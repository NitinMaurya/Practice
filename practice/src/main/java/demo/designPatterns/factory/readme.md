Basic Knowledge:

Link: https://medium.com/@kousiknath/design-patterns-different-approaches-to-use-factory-pattern-to-choose-objects-dynamically-at-run-71449bceecef


Another great example of factory method pattern in real life can be:

Notifications to be sent to a customer.

Let's say we have to send different types of notifications to customer based on different kafka events

1. Booking Event 
2. Task Event

What we can do is, create a multiple classes of different notifications to be sent to the customer like 
- your reservation about to start.
- you have been allocated a vehicle.
- your vehicle has been replaced.
- your profile has been approved.

And then we can create a Notification factory which will take these events 
and decide which notification is to be sent by checking the conditions in the event data.

Disadvantage:

Let's say we have hundreds of notifications to be sent but in this case the factory class will have lots of if-else.
So in this case we use strategy pattern.

link: https://dzone.com/articles/design-patterns-the-strategy-and-factory-patterns
