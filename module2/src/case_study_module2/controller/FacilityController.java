package case_study_module2.controller;

import case_study_module2.service.IFacilityService;
import case_study_module2.service.i_faciliti_service.IHouseService;
import case_study_module2.service.i_faciliti_service.IRoomService;
import case_study_module2.service.i_faciliti_service.IVillaService;
import case_study_module2.service.impl.faciliti_service.FacilityService;
import case_study_module2.service.impl.faciliti_service.HouseService;
import case_study_module2.service.impl.faciliti_service.RoomService;
import case_study_module2.service.impl.faciliti_service.VillaService;
import case_study_module2.util.NumberException;

import java.io.IOException;
import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static IFacilityService iFacilityService = new FacilityService();
    private static IHouseService iHouseService= new HouseService();
    private static IVillaService iVillaService=new VillaService();
    private static IRoomService iRoomService=new RoomService();


    public static void menuFacility() throws IOException, NumberException {
        while (true) {
            System.out.println("Welcome to Facility Management");
            System.out.println("Please select option: ");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println("5. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iFacilityService.display();
                    break;
                case 2:
                    facilityOption();
                    break;
                case 3:
                    iFacilityService.displayListMaintain();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void facilityOption() throws NumberException {
        System.out.println("Select Option Facility!");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Return menu");
        System.out.println("0. Exit");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                iVillaService.add();
                break;
            case 2:
                iHouseService.add();
                break;
            case 3:
                iRoomService.add();
                break;
            case 4:
                return;
            case 0:
                System.exit(0);

        }
    }

}
