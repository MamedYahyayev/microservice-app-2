package az.maqa.microservices.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity {

    @Getter
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Getter
    @Setter
    @Column(length = 600)
    private String description;

    @Getter
    @Setter
    @Column(length = 4000)
    private String notes;

    @Getter
    @Setter
    @Column(length = 50)
    private String assignee;

    @Getter
    @Setter
    private Date ticketDate;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    private PriorityType priorityType;

    @Getter
    @Setter
    @Enumerated
    private TicketStatus ticketStatus;
}