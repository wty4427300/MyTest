package com.design_patterns.observer;

import java.util.Observable;
import java.util.Observer;

class MyObservable extends Observable {

}


public class MyObserver implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        System.out.println("监听");
    }

    public static void main(String[] args) {

    }
}
