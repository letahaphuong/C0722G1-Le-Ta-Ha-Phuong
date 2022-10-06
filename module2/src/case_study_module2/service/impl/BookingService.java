package case_study_module2.service.impl;

import case_study_module2.model.booking.Booking;
import case_study_module2.service.IBookingService;
import case_study_module2.service.ICustomerService;
import case_study_module2.util.CheckUtils;
import case_study_module2.util.FormatException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingService implements IBookingService {
    private static Scanner scanner = new Scanner(System.in);
    private static IBookingService iBookingService = new BookingService();
    private static ICustomerService iCustomerService = new CustomerService();
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Map<Booking, Integer> listBooking = new TreeMap<>();
    static {
        Scanner scanner = new Scanner(System.in);
    }

    public Booking infoBooking() throws IOException {
        String idBooking;
        while (true) {
            try {
                System.out.println("Enter Booking ID(BK-xxxx): ");
                idBooking = scanner.nextLine();
                CheckUtils.checkIdBooking(idBooking);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }
        String idCustomer;
        while (true) {
            try {
                iCustomerService.display();
                System.out.println("Enter Id Customer(CT-xxxx): ");
                idCustomer = scanner.nextLine();
                CheckUtils.checkIdCustomer(idCustomer);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }

        LocalDate beginDay;
        while (true) {
            try {
                System.out.println("Enter Begin Day: ");
                beginDay = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
                break;
            }catch (NumberFormatException e){
                System.out.println("Format Error,Enter Again!");
            }

        }
        LocalDate endDay;
        while (true) {
            try {
                System.out.println("Enter End Day: ");
                endDay = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
                break;
            }catch (NumberFormatException e){
                System.out.println("Format Error,Enter Again!");
            }

        }
        String serviceType;
        while (true) {
            try {
                System.out.println("Enter Service Type( 3 Stars | 4 Stars | 5 Stars)");
                serviceType = scanner.nextLine();
                CheckUtils.checkServiceType(serviceType);
                break;
            }catch (FormatException e){
                System.out.println(e.getMessage());
            }

        }
        String serviceName;
        while (true) {
            try {
                System.out.println("Enter Service Name: ");
                serviceName = scanner.nextLine();
                CheckUtils.checkName(serviceName);
                break;
            }catch (FormatException e){
                System.out.println(e.getMessage());
            }

        }
        return new Booking(idBooking, idCustomer, beginDay, endDay, serviceType, serviceName);
    }

    @Override
    public void display() {
        listBooking=readFile();
        Set<Booking> bookings;
        bookings = listBooking.keySet();
        for (Booking booking : bookings) {
            System.out.println(booking);
        }

    }

    @Override
    public void add() throws IOException {
        listBooking=readFile();
        Booking booking = this.infoBooking();
        listBooking.put(booking, 0);
        System.out.println("Successfully added new!");
        writeFile(listBooking);
    }

    private Map<Booking, Integer> readFile() {
        Map<Booking, Integer> listBook = new LinkedHashMap<>();
        BufferedReader bufferedReader = null;
        try {
            File file = new File("src\\case_study_module2\\data\\booking\\booking.csv");
            FileReader fileReader = new FileReader(file);
            if (file.exists()) {
                System.out.println("File Not Found!");
            }
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Booking booking;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                booking = new Booking();
                booking.setIdBooking(info[0]);
                booking.setIdCustomer(info[1]);
                booking.setBeginDay(LocalDate.parse(info[2], dateTimeFormatter));
                booking.setEndDay(LocalDate.parse(info[3], dateTimeFormatter));
                booking.setServiceType(info[4]);
                booking.setServiceName(info[5]);
                Integer value = Integer.parseInt(info[6]);
                listBook.put(booking, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listBook;
    }

    private void writeFile(Map<Booking, Integer> bookingList) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\case_study_module2\\data\\booking\\booking.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Booking> bookings;
            bookings = bookingList.keySet();
            for (Booking booking : bookings) {
                bufferedWriter.write(booking.getInfoBooking(booking));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
