package com.example.bussimulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Simulation {
    Integer[] passQ = new Integer[16];
    Double time=0.0;
    Integer[] busStopForRecord = new Integer[6];

    public void setBusStopForRecord(int eBusStop, int eBusNumber) {
        this.busStopForRecord[eBusNumber] = eBusStop;
    }

    public Integer[] initializebusStopForRecord(Integer[] busStopForRecord){
        for (int i=0; i<busStopForRecord.length;i++){
            busStopForRecord[i] = 0;
        }
        return busStopForRecord;
    }

    public void generatePeriodicTime(Double time, Simulation eSimulation){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                saveToTxtFile(time,"", eSimulation);
            }
        }, 0, 30*1000);

    }

    public void saveToTxtFile(Double time, String consoleOutputString, Simulation eSimulation){
        File file = new File("save4.txt");   // load the file
        // if file doesn't exists, then create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // write something to the file
        try {
            FileWriter out = new FileWriter(file, true);    // append to it

            out.write('\n');
            out.write(Double.toString(time));  // for test

            out.write('\n');
            for (int i = 1; i < passQ.length; i++) {
                out.write(passQ[i] + " "); // save waiting queue at each bus stops
            }

            out.write('\n');
            out.write(consoleOutputString);

            for (int i = 1; i < eSimulation.busStopForRecord.length; i++) {
                out.write(eSimulation.busStopForRecord[i] + " ");  // save bus locations
            }
            out.write('\n');
            out.close();    // close the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Double getTime()
    {
        return this.time;
    }

    public void setTime(Double time){
        this.time = time;
    }

    private void initializationPeople(LinkedList<Event> eventLinkedList, Integer noOfBusStops,QueueEvent queueEvent){

        for (int i = 1; i <= noOfBusStops; i++){
//            passQ[i] += 1;
            queueEvent.createPersonAtInitialization(eventLinkedList, TypeEnum.Type.PERSON, i, passQ);
        }
    }

    private void initializeBusStop(LinkedList<Event> eventLinkedList, Integer noOfBuses, BusEvent busEvent, Simulation simulation){

        int j=0;
        for(int i=1; i<=noOfBuses; i++){
            j =  j+3;
            busEvent.busArrival(eventLinkedList,i,j,passQ, simulation);
        }
    }

    public static void main(String[] args)
    {
        Simulation sim = new Simulation();
        LinkedList<Event> eventLinkedList = new LinkedList<>();
        Integer noOfBuses = 5;
        Integer noOfBusStops = 15;
        Double stop_time = 8 * 60.0;
        Double recordingTime = 0.0;
        BusEvent busEvent = new BusEvent(null, null);
        QueueEvent passengerQEvent = new QueueEvent(0.0, null, 0);


        passengerQEvent.initializePassengerQueue(sim.passQ);
        sim.initializebusStopForRecord(passengerQEvent.simulation.busStopForRecord);
        sim.initializationPeople(eventLinkedList, noOfBusStops, passengerQEvent); // Initialization of Bus stop before time 0
        sim.initializeBusStop(eventLinkedList, noOfBuses, busEvent, passengerQEvent.simulation);

        while (sim.getTime() <= stop_time) {
//            sim.time++;
            Event next_event = eventLinkedList.peekFirst();

            if (Math.floor(passengerQEvent.simulation.time) == (recordingTime)) {
                recordingTime += 30.0;
                sim.generatePeriodicTime(passengerQEvent.simulation.time, passengerQEvent.simulation);
            }

            switch (Objects.requireNonNull(next_event).type) {
                case PERSON -> {
                    QueueEvent passEvent = (QueueEvent) next_event;
                    passengerQEvent.createPerson(eventLinkedList, TypeEnum.Type.PERSON, passEvent.busStop, sim.passQ);
                    eventLinkedList.removeFirst();
                    break;
                }
                case ARRIVAL -> {
                    BusEvent eBusEvent = (BusEvent) next_event;
                    busEvent.busArrival(eventLinkedList, eBusEvent.busNumber, eBusEvent.busStop, sim.passQ, passengerQEvent.simulation);
                    eventLinkedList.removeFirst();
                    break;
                }
                case BOARDER -> {
                    BusEvent eBusEvent = (BusEvent) next_event;
                    busEvent.boarder(eventLinkedList, eBusEvent.busNumber, eBusEvent.busStop, sim.passQ, passengerQEvent.simulation);
                    eventLinkedList.removeFirst();
                    break;
                }
            }
            sim.time = next_event.time;
        }
//        while (sim.time <= stop_time);
    }
}
