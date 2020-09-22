package az.maqa.microservices.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Aciq"),
    RESOLVED("Hell Olunmus"),
    IN_PROGRESS("Inkisafda"),
    CLOSE("Bagli");

    private String label;

    TicketStatus(String label) {
        this.label = label;
    }

}
