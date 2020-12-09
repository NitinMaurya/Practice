package practice.designPatterns.observer.client;

import practice.designPatterns.observer.MobileObserver;
import practice.designPatterns.observer.SatelliteObserver;
import practice.designPatterns.observer.WeatherStation;

public class Client {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.add(new MobileObserver());
        station.add(new SatelliteObserver());
        station.setTemperature(36.5);
        System.out.println(station.getTemperature());
    }
}
