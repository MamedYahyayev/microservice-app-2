package az.maq.microservices.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketNotification implements Serializable {
    private String ticketId;
    private String accountId;
    private String ticketDescription;
}
