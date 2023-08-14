package com.example.bussimulator;

public class Event {
  Double time;
  TypeEnum.Type type;
    public Event(Double time, TypeEnum.Type type){
      this.time = time;
      this.type = type;
  }
}
