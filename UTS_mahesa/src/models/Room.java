package models;
public class Room {
    private String roomNumber;
    private boolean isAvailable;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
