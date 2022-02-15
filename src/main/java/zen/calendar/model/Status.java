package zen.calendar.model;

public enum Status {
    ACTIVE("ACTIVE"),
    DELETED("DELETED");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
