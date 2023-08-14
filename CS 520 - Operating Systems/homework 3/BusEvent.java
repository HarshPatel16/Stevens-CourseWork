package com.example.bussimulator;

import java.util.Iterator;
import java.util.LinkedList;

public class BusEvent extends Event{
    Integer busStop;
    Integer busNumber;
    Integer time_Bet_Stops = 5;
    Integer time_To_Board = 2/60;
//    Simulation simulation = new Simulation();

    public BusEvent(Double time, TypeEnum.Type type) {
        super(time, type);
    }

    public BusEvent(Double time, TypeEnum.Type type, Integer busNumber, Integer busStop) {
        super(time, type);
        this.busNumber=busNumber;
        this.busStop=busStop;
    }
//    public LinkedList<Event> busArrivalInitiation

    public LinkedList<Event> busArrival (LinkedList<Event> eventLinkedList, Integer busNumber, Integer busStop, Integer[] passengerQ, Simulation simulation){
        EventGenerator eventGenerator = new EventGenerator();
        if (passengerQ[busStop] == 0){
            System.out.println("The passenger Queue is empty at" + busStop + " at time " + simulation.time + "\n");
            int eBusStop = (busStop < 15) ? busStop+1 : 1;
            simulation.setBusStopForRecord(busStop,busNumber);
            simulation.setTime(simulation.getTime()+time_Bet_Stops);
            eventLinkedList = eventGenerator.insert(eventLinkedList, new BusEvent(time, TypeEnum.Type.ARRIVAL, busNumber, eBusStop));
//            busArrival(eventLinkedList, busNumber, busStop, passengerQ,simulation);
        }
        else {
            // Call the boarder event
//            simulation.setTime(simulation.getTime()+time_Bet_Stops);
            System.out.println("Bus ["+ busNumber + "] arrived at [" + busStop + "] at time " + simulation.getTime() + "");
            simulation.setBusStopForRecord(busStop,busNumber);
            eventLinkedList = eventGenerator.insert(eventLinkedList, new BusEvent(simulation.time, TypeEnum.Type.BOARDER, busNumber, busStop));
//            boarder(eventLinkedList, busNumber, busStop, passengerQ, simulation);
        }
            return eventLinkedList;
    }

    public LinkedList<Event> boarder(LinkedList<Event> eventLinkedList, Integer busNumber, Integer busStop, Integer[] passengerQ, Simulation simulation){
        EventGenerator eventGenerator = new EventGenerator();
        if (passengerQ[busStop] == 0){
            System.out.println("Queue at bus stop "+busStop+" is empty \n");
            int eBusStop = (busStop < 15) ? busStop+1 : 1;
            simulation.setTime(simulation.getTime()+time_Bet_Stops);
            eventLinkedList = eventGenerator.insert(eventLinkedList, new BusEvent(simulation.time, TypeEnum.Type.ARRIVAL, busNumber, eBusStop));
//            busArrival(eventLinkedList, busNumber, busStop, passengerQ,simulation);
        }
        else {
            while (passengerQ[busStop] > 0){
                System.out.println("Boarding started for bus [" +busNumber+"] at stop "+ busStop + " at time"+ simulation.time);
                simulation.setTime(simulation.getTime()+time_To_Board*passengerQ[busStop]);
                passengerQ[busStop] = 0;
                int eBusStop = (busStop < 15) ? busStop+1 : 1;
                eventLinkedList = eventGenerator.insert(eventLinkedList, new BusEvent(simulation.time, TypeEnum.Type.ARRIVAL, busNumber, eBusStop));
//                boarder(eventLinkedList, busNumber, busStop, passengerQ, simulation);
            }
        }
        return  eventLinkedList;
    }
}
