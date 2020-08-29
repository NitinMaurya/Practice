package demo.designPatterns.observer;

public class SatelliteObserver implements Observer {
    @Override
    public void update(WeatherStation observable) {
        System.out.println("Satellite Got update: Temperature = " + observable.getTemperature());
    }
}
