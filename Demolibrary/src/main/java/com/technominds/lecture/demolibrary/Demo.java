package com.technominds.lecture.demolibrary;

import java.util.ArrayList;
import java.util.LinkedList;


public class Demo {
    public static void main(String[] args) {
        //declration of array list
        LinkedList<String> cars=new LinkedList<String>();

        cars.add("Maruti");
        cars.add("Honda");
        cars.add("BMW");
        cars.add("Nimmo");

        System.out.println(cars);
        cars.removeLast();
        System.out.println(cars);
        System.out.println(cars.size());
    }
}