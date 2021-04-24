package practice.designPatterns.abstractFactory;

public class BookingStartNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Your booking {" + message + "} about to start at 12 pm");
    }
}
