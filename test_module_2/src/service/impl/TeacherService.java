package service.impl;
import model.Teacher;
import service.ITeacherService;
import util.CheckUtils;
import util.UserException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    public Teacher infoTeacher() {
        String id;
        while (true) {
            try {
                System.out.println("Enter ID(TC-XXXX): ");
                id = scanner.nextLine();
                CheckUtils.checkIdTeacher(id);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }

        String name;
        while (true) {
            try {
                System.out.println("Enter name: ");
                name = scanner.nextLine();
                CheckUtils.checkName(name);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }

        String birthday;
        while (true) {
            try {
                System.out.println("Enter Birth: ");
                String date = scanner.nextLine();
                CheckUtils.checkDate(date);
                CheckUtils.checkBirthDay(date);
                birthday=date;
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }

        String gender;
        while (true) {
            try {
                System.out.println("Enter Gender: ");
                gender = scanner.nextLine();
                CheckUtils.checkGender(gender);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }


        }

        String phoneNumber;
        while (true) {
            try {
                System.out.println("Enter Phone Number: ");
                phoneNumber = scanner.nextLine();
                CheckUtils.checkPhone(phoneNumber);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }
        String level;
        while (true) {
            try {
                System.out.println("Enter Level: ");
                level = scanner.nextLine();
                CheckUtils.checkLevel(level);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }


        return new Teacher(id, name, phoneNumber, birthday, gender, level);
    }

    @Override
    public void addStudent() throws IOException {
        teacherList = readFile();
        Teacher teacher = this.infoTeacher();
        teacherList.add(teacher);
        System.out.println("Added!");
        writeFile(teacherList);
    }

    @Override
    public void removeStudent() throws IOException {
        teacherList = readFile();
        System.out.println("Enter Your ID Want Remove");
        String id = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId().equals(id)) {
                System.out.println("Are you sure to remove!" +
                        "\n y to REMOVE" +
                        "\n n to CANCEL");
                String chocie = scanner.nextLine();
                if (chocie.equals("y")) {
                    teacherList.remove(i);
                    System.out.println("Deleted!");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Id Not Found");
        }
        writeFile(teacherList);
    }

    @Override
    public void displayStudent() throws IOException {
    teacherList=readFile();
    for (Teacher teacher:teacherList){
        System.out.println(teacher);
    }
    }

    public List<Teacher> readFile() throws IOException {
        BufferedReader bufferedReader = null;
        List<Teacher> teacherList = new ArrayList<>();
        try {
            File file = new File("src\\data\\teacher.csv");
            FileReader fileReader = new FileReader(file);
            if (!file.exists()) {
                System.err.println("File Not Found!");
            }
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Teacher teacher;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                teacher = new Teacher();
                teacher.setId(info[0]);
                teacher.setName(info[1]);
                teacher.setPhoneNumber(info[2]);
                teacher.setBirthDay(info[3]);
                teacher.setGender(info[4]);
                teacher.setLevel(info[5]);
                teacherList.add(teacher);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }

        return teacherList;
    }

    public void writeFile(List<Teacher> teacherList) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\data\\teacher.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Teacher teacher : teacherList) {
                bufferedWriter.write(teacher.getInfoPerson());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }
}
