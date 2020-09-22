package az.maqa.microservices.service;

import az.maqa.microservices.entity.Ticket;

public interface TicketNotificationService {
    void sendToQueue(Ticket ticket);
}
