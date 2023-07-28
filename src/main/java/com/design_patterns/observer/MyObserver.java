package com.design_patterns.observer;

import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

class MyObservable extends Observable{

}


public class MyObserver implements Observer {
    @Override
    public void update(Observable observable, Object o) {

    }
}
