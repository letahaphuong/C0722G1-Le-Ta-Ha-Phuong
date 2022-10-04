package case_study_module2.service.impl.faciliti_service;

import case_study_module2.model.facility.Facility;
import case_study_module2.model.facility.House;
import case_study_module2.model.facility.Room;
import case_study_module2.service.i_faciliti_service.IRoomService;
import case_study_module2.util.CheckUtils;
import case_study_module2.util.FormatException;

import java.io.*;
import java.util.*;

public class RoomService implements IRoomService {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Room, Integer> listRoom = new LinkedHashMap<>();

    public static Room infoRoom() {
        String id;
        while (true) {
            try {
                System.out.println("Enter ID Room: ");
                id = scanner.nextLine();
                CheckUtils.checkIdRoomFacility(id);
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
                System.out.println("Format Error,Enter Again!");
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
                System.out.println("Enter Rental Cost: ");
            }

        }

        int maxPerson;
        while (true) {
            System.out.println("Enter Max Person Number: ");
            maxPerson = Integer.parseInt(scanner.nextLine());
            if (maxPerson > 0 && maxPerson < 20) {
                break;
            }
        }

        String rentalType;
        while (true) {
            try {
                System.out.println("Enter Rental Type: ");
                rentalType = scanner.nextLine();
                CheckUtils.checkStandard(rentalType);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        String freeService;
        while (true) {
            try {
                System.out.println("Enter Free Service: ");
                freeService = scanner.nextLine();
                CheckUtils.checkName(freeService);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        return new Room(id, serviceName, usableArea, rentalCost, maxPerson, rentalType, freeService);

    }

    @Override
    public void add() {
        listRoom = readFile();
        Room room = this.infoRoom();
        listRoom.put(room, 0);
        System.out.println("Successfully added new!");
        writeFile(listRoom);
    }

    private Map<Room, Integer> readFile() {
        Map<Room, Integer> houseList = new LinkedHashMap<>();
        File file = new File("src\\case_study_module2\\data\\room\\room.csv");
        try {
            FileReader fileReader = new FileReader(file);
            if (!file.exists()) {
                System.out.println("File Not Found!");
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Room room;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                room = new Room();
                room.setId(info[0]);
                room.setServiceName(info[1]);
                room.setUsableArea(Double.parseDouble(info[2]));
                room.setRentalCost(Double.parseDouble(info[3]));
                room.setMaxPerson(Integer.parseInt(info[4]));
                room.setRentalType(info[5]);
                room.setFreeService(info[6]);
                Integer value = Integer.parseInt(info[7]);
                houseList.put(room, 0);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }

    private void writeFile(Map<Room, Integer> roomsList) {
        File file = new File("src\\case_study_module2\\data\\room\\room.csv");
        if (!file.exists()) {
            System.out.println("File is not exist");
        }

        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Room> rooms = new LinkedHashSet<>();
            rooms = roomsList.keySet();
            for (Room room : rooms) {
                bufferedWriter.write(room.getInfoRoom(room) + "," + roomsList.get(room));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
