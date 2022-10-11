package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CheckUtils {
    public static void checkName(String name) throws UserException {
        boolean check = name.matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkMail(String mail) throws UserException {
        boolean check = mail.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkPhone(String phone) throws UserException {
        boolean check = phone.matches("^0\\d{9,10}$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkIDCard(String idCard) throws UserException {
        boolean check = idCard.matches("^\\d{9}$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkIdStudent(String idStudent) throws UserException {
        boolean check = idStudent.matches("^ST-\\d{4}$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkIdTeacher(String idTeacher) throws UserException {
        boolean check = idTeacher.matches("^TC-\\d{4}$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkGender(String gender) throws UserException {
        boolean check = gender.matches("^male|female|other$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkLevel(String level) throws UserException {
        boolean check = level.matches("^University|College|Intermediate$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkPosition(String position) throws UserException {
        boolean check = position.matches("^Receptionist|Waiter|Specialist|Supervisor|Manager|Director$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkAddress(String address) throws UserException {
        boolean check = address.matches("^([\\w/]+[ ]?)*([A-Z][a-z]+\\s)+([A-z][a-z]+)$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkTypeGuest(String typeGuest) throws UserException {
        boolean check = typeGuest.matches("^Diamond|Platinium|Gold|Silver|Member$");
        if (!check) {
            throw new UserException("Format error,Enter again!");
        }
    }

    public static void checkStandard(String standard) throws UserException {
        boolean check = standard.matches("^Standard|Superior|Deluxe|Suite$");
        if (!check) {
            throw new UserException("Format Error,Enter Again!");
        }
    }

    public static void checkIdFacility(String faciliti) throws UserException {
        boolean check = faciliti.matches("^((SVVL)|(SVHO)|(SVRO))-[0-9]{4}$");
        if (!check) {
            throw new UserException("Format Error,Enter Again!");
        }
    }

    public static void checkFreeService(String freeService) throws UserException {
        boolean check = freeService.matches("^Beer|Whisky|Drink|Juice|Water|Coffee$");
        if (!check) {
            throw new UserException("Format Error,Enter Again!");
        }
    }

    public static void checkIdBooking(String idBooking) throws UserException {
        boolean check = idBooking.matches("^BK-\\d{4}$");
        if (!check) {
            throw new UserException("Format Error,Enter Again!");
        }
    }

    public static void checkServiceType(String serviceType) throws UserException {
        boolean check = serviceType.matches("^3[ ]Stars|4[ ]Stars|5[ ]Stars");
        if (!check) {
            throw new UserException("Format Error,Enter Again!");
        }
    }

    public static void checkDate(String date) throws UserException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(date);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateOfBirth = LocalDate.parse(date, dateTimeFormatter);
        } catch (ParseException | DateTimeParseException e) {
            throw new UserException("Date Format Exception");
        }
    }

    public static void checkBirthDay(String date) throws UserException {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(date, dateTimeFormatter);
        LocalDate nowSub18 = LocalDate.now().minusYears(18);
        LocalDate nowSub100 = LocalDate.now().minusYears(100);
        boolean isGreatThan18 = (dateOfBirth.compareTo(nowSub18) < 0);
        boolean isLessThan100 = (dateOfBirth.compareTo(nowSub100) > 0);
        if (!isGreatThan18 | !isLessThan100) {
            throw new UserException("Format Error,Pls Try Again!");
        }
    }
    public static void checkNameClass(String nameClass) throws UserException {
        boolean check=nameClass.matches("^A\\d$");
        if (!check){
            throw new UserException("Format Error,Pls Try Again!");
        }
    }

}
