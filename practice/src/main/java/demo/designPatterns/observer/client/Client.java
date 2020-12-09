package demo.designPatterns.observer.client;

import demo.designPatterns.observer.MobileObserver;
import demo.designPatterns.observer.SatelliteObserver;
import demo.designPatterns.observer.WeatherStation;

public class Client {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.add(new MobileObserver());
        station.add(new SatelliteObserver());
        station.setTemperature(36.5);
        System.out.println(station.getTemperature());
    }
}
