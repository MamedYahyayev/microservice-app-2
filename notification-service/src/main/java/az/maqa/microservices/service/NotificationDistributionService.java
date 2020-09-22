package az.maqa.microservices.service;

import az.maq.microservices.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationDistributionService {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification) {
        System.out.println("---------------------------------------------------");
        System.out.println("Notification sending to accounts....");
        System.out.println("Notification -> " + ticketNotification.toString());
    }


}
