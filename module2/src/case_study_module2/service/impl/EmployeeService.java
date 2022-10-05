package case_study_module2.service.impl;

import case_study_module2.model.employee.Employee;
import case_study_module2.service.IEmployeeService;
import case_study_module2.util.CheckUtils;
import case_study_module2.util.FormatException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Employee infoEmploy() {
        String id;
        while (true) {
            try {
                System.out.println("Please Enter ID Employ: ");
                id = scanner.nextLine();
                CheckUtils.checkIdPerson(id);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.println("Please Enter Name: ");
                name = scanner.nextLine();
                CheckUtils.checkName(name);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }
        LocalDate birth;
        while (true) {
            try {
                System.out.println("Please Enter Birthday (dd/MM/yyyy): ");
                birth = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
                CheckUtils.checkBirth(birth);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }

        String gender;
        while (true) {
            try {
                System.out.println("Please Enter Gender(male/female/other): ");
                gender = scanner.nextLine();
                CheckUtils.checkGender(gender);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        String idCard;
        while (true) {
            try {
                System.out.println("Please Enter ID Card: ");
                idCard = scanner.nextLine();
                CheckUtils.checkIDCard(idCard);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }
        String phoneNumber;
        while (true) {
            try {
                System.out.println("Please Enter Phone Number: ");
                phoneNumber = scanner.nextLine();
                CheckUtils.checkPhone(phoneNumber);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());

            }

        }
        String email;
        while (true) {
            try {
                System.out.println("Please Enter Email: ");
                email = scanner.nextLine();
                CheckUtils.checkMail(email);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }
        String level;
        while (true) {
            try {
                System.out.println("Please Enter Level(University / College / Intermediate): ");
                level = scanner.nextLine();
                CheckUtils.checkLevel(level);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }
        String position;
        while (true) {
            try {
                System.out.println("Please Enter Position\n" +
                        "(Receptionist, Waiter, Specialist, Supervisor, Manager, Director)" +
                        ": ");
                position = scanner.nextLine();
                CheckUtils.checkPosition(position);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }
        int salary;
        while (true) {
            try {
                System.out.println("Please Enter Salary: ");
                salary = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                e.getStackTrace();
                System.out.println("Format error,Enter again!");
            }

        }
        return new Employee(id, name, birth, gender, idCard, phoneNumber, email, level, position, salary);

    }

    @Override
    public void display() throws IOException {
        employeeList = readFile();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void add() throws IOException {
        employeeList = readFile();
        Employee employee = this.infoEmploy();
        employeeList.add(employee);
        System.out.println("Successfully added new");
        writeFile(employeeList);
    }


    @Override
    public void editByID() throws IOException {
        System.out.println("Enter ID To Edit: ");
        String id = scanner.nextLine();
        employeeList = readFile();
        for (int i = 0; i < employeeList.size(); i++) {
            if (id.equals(employeeList.get(i).getIdEmployee())) {
                System.out.println("Enter new Name : ");
                try {
                    String nameEdit = scanner.nextLine();
                    employeeList.get(i).setName(nameEdit);
                    CheckUtils.checkName(nameEdit);
                } catch (FormatException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Enter new Birthday :");
                try {
                    LocalDate birthEdit = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
                    employeeList.get(i).setBirth(birthEdit);
                } catch (Exception e) {
                    e.getStackTrace();
                    System.out.println("Format error,Enter again!");
                }

                System.out.println("Enter new new Gender : ");
                try {
                    String genderEdit = scanner.nextLine();
                    employeeList.get(i).setGender(genderEdit);
                    CheckUtils.checkGender(genderEdit);
                } catch (Exception e) {
                    e.getStackTrace();
                    System.out.println("Format error,Enter again!");
                }

                System.out.println("Enter new Id Card : ");
                try {
                    String idCardEdit = scanner.nextLine();
                    employeeList.get(i).setIdCard(idCardEdit);
                    CheckUtils.checkIDCard(idCardEdit);
                } catch (FormatException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Enter new Phone Number : ");
                try {
                    String phoneNumberEdit = scanner.nextLine();
                    employeeList.get(i).setPhoneNumber(phoneNumberEdit);
                    CheckUtils.checkPhone(phoneNumberEdit);
                } catch (FormatException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Enter new Email : ");
                try {
                    String emailEdit = scanner.nextLine();
                    employeeList.get(i).setEmail(emailEdit);
                    CheckUtils.checkMail(emailEdit);
                } catch (FormatException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Enter new Level : ");
                try {
                    String levelEdit = scanner.nextLine();
                    employeeList.get(i).setLevel(levelEdit);
                    CheckUtils.checkLevel(levelEdit);
                } catch (Exception e) {
                    e.getStackTrace();
                    System.out.println("Format error,Enter again!");
                }

                System.out.println("Enter new Position : ");
                try {
                    String positionEdit = scanner.nextLine();
                    employeeList.get(i).setPosition(positionEdit);
                    CheckUtils.checkPosition(positionEdit);
                } catch (Exception e) {
                    e.getStackTrace();
                    System.out.println("Format error,Enter again!");
                }

                System.out.println("Enter new Salary : ");
                try {
                    int salaryEdit = Integer.parseInt(scanner.nextLine());
                    employeeList.get(i).setSalary(salaryEdit);
                } catch (Exception e) {
                    e.getStackTrace();
                    System.out.println("Format error,Enter again!");
                }

                System.out.println("Edit successfully!");
                writeFile(employeeList);
                break;
            }
        }
    }


    BufferedReader bufferedReader;

    public List<Employee> readFile() throws IOException {
        List<Employee> employeeList1 = new ArrayList<>();
        try {
            File file = new File("src\\case_study_module2\\data\\employee\\listEmploy.csv");
            FileReader fileReader = new FileReader(file);
            if (!file.exists()) {
                System.out.println("File not found!");
            }
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Employee employee;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                employee = new Employee();
                employee.setIdEmployee(info[0]);
                employee.setName(info[1]);
                employee.setBirth(LocalDate.parse(info[2], dateTimeFormatter));
                employee.setGender(info[3]);
                employee.setIdCard(info[4]);
                employee.setPhoneNumber(info[5]);
                employee.setEmail(info[6]);
                employee.setLevel(info[7]);
                employee.setPosition(info[8]);
                employee.setSalary(Integer.parseInt(info[9]));
                employeeList1.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedReader.close();
        return employeeList1;
    }

    public void writeFile(List<Employee> employeeList2) throws IOException {
        File file = new File("src\\case_study_module2\\data\\employee\\listEmploy.csv");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Employee employee : employeeList2) {
            bufferedWriter.write(employee.getInfoEmployee());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}


