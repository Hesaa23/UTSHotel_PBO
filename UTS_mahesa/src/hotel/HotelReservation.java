package hotel;
import services.HotelServiceImpl;
import java.util.Scanner;

public class HotelReservation {
    private static Scanner scanner = new Scanner(System.in);
    private static HotelServiceImpl hotelService = new HotelServiceImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Aplikasi Reservasi Hotel ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Customer");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear input

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Hapus Kamar");
            System.out.println("3. Tambah Customer");
            System.out.println("4. Hapus Customer");
            System.out.println("5. Cek Ketersediaan Kamar");
            System.out.println("6. Lihat Daftar Customer & Admin");
            System.out.println("7. Lihat Daftar Kamar");
            System.out.println("8. Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear input

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nomor kamar: ");
                    String roomNumber = scanner.nextLine();
                    hotelService.addRoom(roomNumber);
                    break;
                case 2:
                    System.out.print("Masukkan nomor kamar yang akan dihapus: ");
                    roomNumber = scanner.nextLine();
                    hotelService.removeRoom(roomNumber);
                    break;
                case 3:
                    System.out.print("Masukkan nama customer: ");
                    String customerName = scanner.nextLine();
                    hotelService.addCustomer(customerName);
                    break;
                case 4:
                    System.out.print("Masukkan nama customer yang akan dihapus: ");
                    customerName = scanner.nextLine();
                    hotelService.removeCustomer(customerName);
                    break;
                case 5:
                    hotelService.checkAvailability();
                    break;
                case 6:
                    hotelService.viewAllCustomers();
                    break;
                case 7:
                    hotelService.viewAllRooms();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void customerMenu() {
        System.out.print("Masukkan nama customer: ");
        String customerName = scanner.nextLine();

        while (true) {
            System.out.println("\n=== Menu Customer ===");
            System.out.println("1. Pesan Kamar");
            System.out.println("2. Lihat Detail Pesanan");
            System.out.println("3. Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear input

            switch (choice) {
                case 1:
                    hotelService.bookRoom(customerName);
                    break;
                case 2:
                    hotelService.viewBookingDetails(customerName);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
