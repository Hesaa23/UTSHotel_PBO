package models;
public class Customer {
    private String name;
    private String bookedRoom;

    public Customer(String name) {
        this.name = name;
        this.bookedRoom = null;
    }

    public String getName() {
        return name;
    }

    public String getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(String bookedRoom) {
        this.bookedRoom = bookedRoom;
    }
}
