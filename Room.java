package model;

public class Room {
    private String roomNumber;
    private int guestId;
    private String type;
    private double pricePerNight;
    private boolean occupied;

    public Room (String RoomNumber, String type, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.occupied = false;
        this.guestId = 0;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getType() {
        return type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", guestId=" + guestId +
                ", type='" + type + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", occupied=" + occupied +
                '}';
    }
}
