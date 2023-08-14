package com.example.bussimulator;

import org.w3c.dom.Node;

import java.lang.constant.Constable;
import java.util.Iterator;
import java.util.LinkedList;

public class EventGenerator {
    public LinkedList<Event> insert(LinkedList<Event> eventLinkedList, Event event){
        Integer position = 0;
        Iterator<Event> iterator= eventLinkedList.stream().iterator();
        while (iterator.hasNext()) {
            if (event.time >= iterator.next().time) {
                position=position+1;
            }
        }
        eventLinkedList.add(position, event);
        return eventLinkedList;
    }
}

