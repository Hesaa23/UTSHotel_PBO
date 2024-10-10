package services;
import models.Room;
import models.Customer;
public interface HotelService {
    void addRoom(String roomNumber);
    void removeRoom(String roomNumber);
    void checkAvailability();
    void addCustomer(String name);
    void removeCustomer(String name);
}
