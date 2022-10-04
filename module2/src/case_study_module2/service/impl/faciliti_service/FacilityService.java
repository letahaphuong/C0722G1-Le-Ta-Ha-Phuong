package case_study_module2.service.impl.faciliti_service;

import case_study_module2.model.facility.Facility;
import case_study_module2.service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedHashMap<Facility, Integer> linkedHashMap = new LinkedHashMap<>();
//
//    private static Facility infoHouse() {
//        String id;
//        System.out.println("Enter ID House");
//        id =scanner.nextLine();
//        String serviceName;
//        System.out.println("Enter Service Name: ");
//        serviceName = scanner.nextLine();
//        double usableArea;
//        System.out.println("Enter Usable Area: ");
//        usableArea = Double.parseDouble(scanner.nextLine());
//        double rentalCost;
//        System.out.println("Enter Rental Cost: ");
//        rentalCost = Double.parseDouble(scanner.nextLine());
//        int maxPerson;
//        System.out.println("Enter Max Person Number: ");
//        maxPerson = Integer.parseInt(scanner.nextLine());
//        int rentalType;
//        System.out.println("Enter Rental Type: ");
//        rentalType = Integer.parseInt(scanner.nextLine());
//        String roomStandard;
//        System.out.println("Enter Room Standard");
//        roomStandard = scanner.nextLine();
//        int numberFloors;
//        System.out.println("Enter Room Floors");
//        numberFloors = Integer.parseInt(scanner.nextLine());
//
//        return new House(id,serviceName, usableArea, rentalCost, maxPerson, rentalType, roomStandard, numberFloors);
//    }
//    private static Facility infoVilla() {
//        String id;
//        System.out.println("Enter ID Villa: ");
//        id= scanner.nextLine();
//        String serviceName;
//        System.out.println("Enter Service Name: ");
//        serviceName = scanner.nextLine();
//        double usableArea;
//        System.out.println("Enter Usable Area: ");
//        usableArea = Double.parseDouble(scanner.nextLine());
//        double rentalCost;
//        System.out.println("Enter Rental Cost: ");
//        rentalCost = Double.parseDouble(scanner.nextLine());
//        int maxPerson;
//        System.out.println("Enter Max Person Number: ");
//        maxPerson = Integer.parseInt(scanner.nextLine());
//        int rentalType;
//        System.out.println("Enter Rental Type: ");
//        rentalType = Integer.parseInt(scanner.nextLine());
//        String roomStandard;
//        System.out.println("Enter Swimming Pool Area: ");
//        roomStandard = scanner.nextLine();
//        double swimmingPoolArea;
//        System.out.println("Enter Swimming Pool Area: ");
//        swimmingPoolArea = Double.parseDouble(scanner.nextLine());
//        int numberFloors;
//        System.out.println("Enter Number Floor: ");
//        numberFloors = Integer.parseInt(scanner.nextLine());
//        return new Villa(id,serviceName, usableArea, rentalCost,
//                maxPerson, rentalType, roomStandard, swimmingPoolArea,
//                numberFloors);
//    }
//
//
//    private static Facility infoRoom(){
//        String id;
//        System.out.println("Enter ID Room: ");
//        id=scanner.nextLine();
//        String serviceName;
//        System.out.println("Enter Service Name: ");
//        serviceName = scanner.nextLine();
//        double usableArea;
//        System.out.println("Enter Usable Area: ");
//        usableArea = Double.parseDouble(scanner.nextLine());
//        double rentalCost;
//        System.out.println("Enter Rental Cost: ");
//        rentalCost = Double.parseDouble(scanner.nextLine());
//        int maxPerson;
//        System.out.println("Enter Max Person Number: ");
//        maxPerson = Integer.parseInt(scanner.nextLine());
//        int rentalType;
//        System.out.println("Enter Rental Type: ");
//        rentalType = Integer.parseInt(scanner.nextLine());
//        String freeService;
//        System.out.println("Enter Free Service: ");
//        freeService=scanner.nextLine();
//        return new Room(id,serviceName,usableArea,rentalCost,maxPerson,rentalType,freeService);
//    }

    @Override
    public void display() {

    }

    @Override
    public void add() {

    }

    @Override
    public void displayListMaintain() {

    }


}
