package az.maqa.microservices.entity;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Tecili"),
    LOW("Vacib Deyil"),
    HIGH("Vacib");

    private String label;

    PriorityType(String label) {
        this.label = label;
    }


}
