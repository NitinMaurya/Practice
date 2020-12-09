package demo.designPatterns.observer;

public interface Observable {
    boolean add(Observer observer);
    boolean remove(Observer observer);
    void broadcast();
}
