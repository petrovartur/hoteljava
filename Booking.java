package model;

public class Booking {

    private int id;
    private String roomNumber;
    private String type;
    private int nights;
    private String notes;

    public Booking(int id, String roomNumber,
                   String type, int nights, String notes) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.nights = nights;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public int getNights() {
        return nights;
    }

    public String getNotes() {
        return notes;
    }

    public String toString() {
        return "Booking(" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", nights='" + nights +
                ", notes='" + notes + '\'' +
                '}';
    }

}
