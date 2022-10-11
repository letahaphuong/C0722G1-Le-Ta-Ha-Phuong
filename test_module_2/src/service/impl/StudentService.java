package service.impl;

import model.Student;
import service.IStudentService;
import util.CheckUtils;
import util.UserException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();

    public Student infoStudent() {
        String id;
        while (true) {
            try {
                System.out.println("Enter ID: ");
                id = scanner.nextLine();
                CheckUtils.checkIdStudent(id);
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
                birthday = date;
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }

        String gender;
        while (true) {
            try {
                System.out.println("Enter Gender(male | female | other): ");
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
                System.out.println("Enter Phone Number(0XXX XXX XXX): ");
                phoneNumber = scanner.nextLine();
                CheckUtils.checkPhone(phoneNumber);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }
        String nameClass;
        while (true) {
            try {
                System.out.println("Enter Class Name (AX): ");
                nameClass = scanner.nextLine();
                CheckUtils.checkNameClass(nameClass);
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        }

        double score;
        while (true) {
            try {
                System.out.println("Enter Score : ");
                score = Double.parseDouble(scanner.nextLine());
                if (score>=0 && score<=10){
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Format Error,Pls Try Again!");
            }

        }
        return new Student(id, name, phoneNumber, birthday, gender, nameClass, score);
    }

    @Override
    public void addStudent() throws IOException {
        studentList = readFile();
        Student student = this.infoStudent();
        studentList.add(student);
        System.out.println("Added!");
        writeFile(studentList);
    }

    @Override
    public void removeStudent() throws IOException {
        studentList = readFile();
        System.out.println("Enter Your ID Want Remove");
        String id = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                System.out.println("Are you sure to remove!" +
                        "\n y to REMOVE" +
                        "\n n to CANCEL");
                String chocie = scanner.nextLine();
                if (chocie.equals("y")) {
                    studentList.remove(i);
                    System.out.println("Deleted!");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Id Not Found");
        }
        writeFile(studentList);
    }

    @Override
    public void displayStudent() throws IOException {
        studentList = readFile();
        for (Student student : studentList) {
            System.out.println(student);
        }

    }

    public List<Student> readFile() throws IOException {
        BufferedReader bufferedReader = null;
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File("src\\data\\student.csv");
            FileReader fileReader = new FileReader(file);
            if (!file.exists()) {
                System.err.println("File Not Found!");
            }
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Student student;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                student = new Student();
                student.setId(info[0]);
                student.setName(info[1]);
                student.setPhoneNumber(info[2]);
                student.setBirthDay(info[3]);
                student.setGender(info[4]);
                student.setClassName(info[5]);
                student.setScore(Double.parseDouble(info[6]));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }

        return studentList;
    }

    public void writeFile(List<Student> studentList) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\data\\student.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : studentList) {
                bufferedWriter.write(student.getInfoPerson());
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
