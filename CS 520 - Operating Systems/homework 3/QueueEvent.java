package com.example.bussimulator;

import java.util.LinkedList;

public class QueueEvent extends Event{
    int busStop;

    Simulation simulation = new Simulation();

    public QueueEvent(Double time, TypeEnum.Type type, int busStop) {
        super(time, type);
        this.busStop = busStop;
    }

    public LinkedList<Event> createPerson (LinkedList<Event> eventLinkedList, TypeEnum.Type type, Integer busStop, Integer[] passengerQ){
        EventGenerator eventGenerator = new EventGenerator();
        RandomArrivalTimeGenerator randomArrivalTimeGenerator = new RandomArrivalTimeGenerator();
        simulation.setTime(simulation.time + randomArrivalTimeGenerator.generateArrivalTime());
        System.out.println("Person arrived at ["+busStop+"] at time " + simulation.time);
        passengerQ[busStop] += 1;
        eventLinkedList = eventGenerator.insert(eventLinkedList, new QueueEvent(simulation.time, type, busStop));
    return eventLinkedList;
    }

    public LinkedList<Event> createPersonAtInitialization (LinkedList<Event> eventLinkedList, TypeEnum.Type type, Integer busStop, Integer[] passengerQ){
        EventGenerator eventGenerator = new EventGenerator();
//        RandomArrivalTimeGenerator randomArrivalTimeGenerator = new RandomArrivalTimeGenerator();
        simulation.setTime(0.0);
        System.out.println("Person arrived at ["+busStop+"] at time " + 0);
        passengerQ[busStop] += 1;
//        simulation.setTime(simulation.getTime() + randomArrivalTimeGenerator.generateArrivalTime());
        eventLinkedList = eventGenerator.insert(eventLinkedList, new QueueEvent(0.0, type, busStop));
        return eventLinkedList;
    }

    public Integer[] initializePassengerQueue(Integer[] passQ){
        for (int i=0; i<passQ.length;i++){
            passQ[i] = 0;
        }
        return passQ;
    }
}
