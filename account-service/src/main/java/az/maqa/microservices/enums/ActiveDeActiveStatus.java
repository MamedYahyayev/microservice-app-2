package az.maqa.microservices.enums;

public enum ActiveDeActiveStatus {

    ACTIVE(true),
    DEACTIVE(false);

    private boolean status;

    ActiveDeActiveStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
