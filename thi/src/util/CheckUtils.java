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
            throw new UserException("Lỗi định dạng , Nhập lại!");
        }
    }



    public static void checkCodeAcc(String idCard) throws UserException {
        boolean check = idCard.matches("^00\\d{7}$");
        if (!check) {
            throw new UserException("Lỗi định dạng , Nhập lại!");
        }
    }
    public static void checkNumberCard(String numberCard) throws UserException {
        boolean check= numberCard.matches("^\\d{16}$");
        if (!check){
            throw new UserException("Lỗi định dạng , Nhập lại!");
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
            throw new UserException("Lỗi định dạng , Nhập lại!");
        }
    }
    public static void checkrate(String rate) throws UserException {
        try{
            double number=Double.parseDouble(rate);
            if (number<0){
                throw new UserException("Lỗi định dang,Nhập lại");
            }
        }catch (NumberFormatException e){
            throw new UserException("Lỗi định dang,Nhập lại");
        }
    }


}
