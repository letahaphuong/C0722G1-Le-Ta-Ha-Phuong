package case_study_module2.service.impl;

import case_study_module2.model.booking.Booking;
import case_study_module2.service.IBookingService;

import java.awt.print.Book;
import java.io.File;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BookingService implements IBookingService {
    private static Scanner scanner = new Scanner(System.in);
    private static IBookingService iBookingService = new BookingService();
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Map<Booking, Integer> listBooking = new TreeMap<>();

    public Booking infoBooking() {
        String idBooking;
        while (true) {
            System.out.println("Enter Booking ID: ");
            idBooking = scanner.nextLine();
            break;
        }
        LocalDate beginDay;
        while (true) {
            System.out.println("Enter Begin Day: ");
            beginDay = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
            break;
        }
        LocalDate endDay;
        while (true) {
            System.out.println("Enter End Day: ");
            endDay = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
            break;
        }
        String serviceType;
        while (true) {
            System.out.println("Enter Service Type( 3 Stars | 4 Stars | 5 Stars)");
            serviceType = scanner.nextLine();
            break;
        }
        return new Booking(idBooking, beginDay, endDay, serviceType);
    }

    @Override
    public void display() {

    }

    @Override
    public void add() {

    }

//    private Map<Book, Integer> readFile() {
//        File file = new File("");
//    }
}
