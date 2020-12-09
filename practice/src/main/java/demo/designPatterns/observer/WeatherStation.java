package demo.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {
    private List<Observer> observers;
    private Double temperature = 0.0;

    @Override
    public boolean add(Observer observer) {
        if(observers == null){
            observers = new ArrayList<>();
        }
        return observers.add(observer);
    }

    @Override
    public boolean remove(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void broadcast() {
        this.observers.forEach((observer) -> observer.update(this));
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
        this.broadcast();
    }
}
