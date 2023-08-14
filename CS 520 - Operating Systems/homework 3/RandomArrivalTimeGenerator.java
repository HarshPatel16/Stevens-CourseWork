package com.example.bussimulator;

import java.util.Random;

public class RandomArrivalTimeGenerator {

    private Double randomNumberGenerator (Double lambda){
        Random rand = new Random();
        return (-1)*(Math.log(1-rand.nextDouble()))/lambda;
    }
    public Double generateArrivalTime(){
        RandomArrivalTimeGenerator generator = new RandomArrivalTimeGenerator();
        double lambda = 8.2; //Lambda chosen so as to make arrival time for 5 people/min
        double sum = 0;

        for (int i=0 ; i<=10000; i++) {
            sum += generator.randomNumberGenerator(lambda);
        }
        Double mean = sum / 10000;
//        System.out.println("The value of random time is :- " + mean + "\n");

        return mean;

    }
}
