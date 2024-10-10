package services;
import models.Room;
import models.Customer;
import java.util.Scanner;
import java.util.ArrayList;

public class HotelServiceImpl implements HotelService {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<String> admins = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Konstruktor
    public HotelServiceImpl() {
        // Menambahkan akun admin secara default
        admins.add("admin1");
        admins.add("admin2");

        // Menambahkan data kamar secara default
        rooms.add(new Room("101"));
        rooms.add(new Room("102"));

        // Menambahkan satu customer secara default
        customers.add(new Customer("John Doe"));
    }

    @Override
    public void addRoom(String roomNumber) {
        rooms.add(new Room(roomNumber));
        System.out.println("Kamar " + roomNumber + " berhasil ditambahkan.");
    }

    @Override
    public void removeRoom(String roomNumber) {
        rooms.removeIf(room -> room.getRoomNumber().equals(roomNumber));
        System.out.println("Kamar " + roomNumber + " berhasil dihapus.");
    }

    @Override
    public void checkAvailability() {
        System.out.println("Ketersediaan Kamar:");
        for (Room room : rooms) {
            System.out.println("Kamar " + room.getRoomNumber() + " - " + (room.isAvailable() ? "Tersedia" : "Dipesan"));
        }
    }

    @Override
    public void addCustomer(String name) {
        customers.add(new Customer(name));
        System.out.println("Customer " + name + " berhasil ditambahkan.");
    }

    @Override
    public void removeCustomer(String name) {
        customers.removeIf(customer -> customer.getName().equals(name));
        System.out.println("Customer " + name + " berhasil dihapus.");
    }

    public void bookRoom(String customerName) {
        Customer customer = findCustomerByName(customerName);
        if (customer != null) {
            checkAvailability();
            System.out.print("Pilih nomor kamar yang ingin dipesan: ");
            String roomNumber = scanner.nextLine();

            Room room = findRoomByNumber(roomNumber);
            if (room != null && room.isAvailable()) {
                room.setAvailable(false);
                customer.setBookedRoom(roomNumber);
                System.out.println("Kamar " + roomNumber + " berhasil dipesan oleh " + customerName);
            } else {
                System.out.println("Kamar tidak tersedia.");
            }
        } else {
            System.out.println("Customer tidak ditemukan.");
        }
    }

    public void viewBookingDetails(String customerName) {
        Customer customer = findCustomerByName(customerName);
        if (customer != null) {
            String bookedRoom = customer.getBookedRoom();
            if (bookedRoom != null) {
                System.out.println(customerName + " telah memesan kamar " + bookedRoom);
            } else {
                System.out.println(customerName + " belum memesan kamar.");
            }
        } else {
            System.out.println("Customer tidak ditemukan.");
        }
    }

    public void viewAllCustomers() {
        System.out.println("\nDaftar Customer:");
        for (Customer customer : customers) {
            System.out.println("- " + customer.getName());
        }

        System.out.println("\nDaftar Admin:");
        for (String admin : admins) {
            System.out.println("- " + admin);
        }
    }

    public void viewAllRooms() {
        System.out.println("\nDaftar Kamar:");
        for (Room room : rooms) {
            System.out.println("- Kamar " + room.getRoomNumber() + " - " + (room.isAvailable() ? "Tersedia" : "Dipesan"));
        }
    }

    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    private Room findRoomByNumber(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }
}
