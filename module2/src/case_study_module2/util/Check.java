package case_study_module2.util;

public class Check {
    public static void checkName(String name) throws FormatException {
        boolean check=name.matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$");
        if (!check){
            throw new FormatException("Format error,Enter again!");
        }
    }
    public static void checkMail(String mail) throws FormatException {
        boolean check =mail.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        if (!check){
            throw new FormatException("Format error,Enter again!");
        }
    }
    public static void checkPhone(String phone) throws FormatException {
        boolean check=phone.matches("^0\\d{9,10}$");
        if (!check){
            throw new FormatException("Format error,Enter again!");
        }
    }
    public static void checkIDCard(String idCard) throws FormatException {
        boolean check=idCard.matches("^\\d{9}$");
        if (!check){
            throw new FormatException("Format error,Enter again!");
        }
    }
    
}
