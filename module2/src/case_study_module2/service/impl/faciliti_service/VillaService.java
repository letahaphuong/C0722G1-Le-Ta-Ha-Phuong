package case_study_module2.service.impl.faciliti_service;

import case_study_module2.model.facility.Facility;
import case_study_module2.model.facility.House;
import case_study_module2.model.facility.Villa;
import case_study_module2.service.i_faciliti_service.IVillaService;
import case_study_module2.util.CheckUtils;
import case_study_module2.util.FormatException;

import java.io.*;
import java.util.*;

public class VillaService implements IVillaService {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Villa, Integer> listVilla = new LinkedHashMap<>();

    public Villa infoVilla() {
        String id;
        while (true) {
            try {
                System.out.println("Enter ID Villa: ");
                id = scanner.nextLine();
                CheckUtils.checkIdVillaFacility(id);
                break;
            } catch (FormatException e) {
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
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        double usableArea;
        while (true) {
            try {
                System.out.println("Enter Usable Area: ");
                usableArea = Double.parseDouble(scanner.nextLine());
                if (usableArea > 30) {
                    break;
                }
            } catch (NumberFormatException e) {
                e.getStackTrace();
                System.out.println("Format Error,Try Again!");
            }
        }

        double rentalCost;
        while (true) {
            try {
                System.out.println("Enter Rental Cost: ");
                rentalCost = Double.parseDouble(scanner.nextLine());
                if (rentalCost > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                e.getStackTrace();
                System.out.println("Format Error,Try Again!");
            }
        }

        int maxPerson;
        while (true) {
            try {
                System.out.println("Enter Max Person Number: ");
                maxPerson = Integer.parseInt(scanner.nextLine());
                if (maxPerson >= 0 && maxPerson < 20) {
                    break;
                }
            } catch (NumberFormatException e) {
                e.getStackTrace();
                System.out.println("Format Error,Try Again!");
            }
        }

        String rentalType;
        while (true) {
            try {
                System.out.println("Enter Rental Type: ");
                rentalType = scanner.nextLine();
                CheckUtils.checkName(rentalType);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        String roomStandard;
        while (true) {
            try {
                System.out.println("Enter Room Standard: ");
                roomStandard = scanner.nextLine();
                CheckUtils.checkStandard(roomStandard);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        double swimmingPoolArea;
        while (true) {
            try {
                System.out.println("Enter Swimming Pool Area: ");
                swimmingPoolArea = Double.parseDouble(scanner.nextLine());
                if (swimmingPoolArea > 30) {
                    break;
                }
            } catch (NumberFormatException e) {
                e.getStackTrace();
                System.out.println("Format Error,Try Again");
            }
        }

        int numberFloors;
        while (true) {
            try {
                System.out.println("Enter Number Floor: ");
                numberFloors = Integer.parseInt(scanner.nextLine());
                if (numberFloors > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                e.getStackTrace();
                System.out.println("Format Error,Try Again!");
            }
        }

        return new Villa(id, serviceName, usableArea, rentalCost,
                maxPerson, rentalType, roomStandard, swimmingPoolArea,
                numberFloors);
    }

    @Override
    public void add() {
        listVilla = readFile();
        Villa villa = this.infoVilla();
        listVilla.put(villa, 0);
        System.out.println("Successfully added new!");
        writeFile(listVilla);
    }

    private Map<Villa, Integer> readFile() {
        Map<Villa, Integer> houseList = new LinkedHashMap<>();
        File file = new File("src\\case_study_module2\\data\\villa\\villa.csv");
        try {
            FileReader fileReader = new FileReader(file);
            if (!file.exists()) {
                System.out.println("File Not Found!");
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Villa villa;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                villa = new Villa();
                villa.setId(info[0]);
                villa.setServiceName(info[1]);
                villa.setUsableArea(Double.parseDouble(info[2]));
                villa.setRentalCost(Double.parseDouble(info[3]));
                villa.setMaxPerson(Integer.parseInt(info[4]));
                villa.setRentalType(info[5]);
                villa.setRoomStandard(info[6]);
                villa.setSwimmingPoolArea(Double.parseDouble(info[7]));
                villa.setNumberFloors(Integer.parseInt(info[8]));
                Integer value = Integer.parseInt(info[9]);
                houseList.put(villa, 0);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }

    private void writeFile(Map<Villa, Integer> roomsList) {
        File file = new File("src\\case_study_module2\\data\\villa\\villa.csv");
        if (!file.exists()) {
            System.out.println("File is not exist");
        }

        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Villa> villas = new LinkedHashSet<>();
            villas = roomsList.keySet();
            for (Villa villa : villas) {
                bufferedWriter.write(villa.getInfo(villa) + "," + roomsList.get(villa));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
