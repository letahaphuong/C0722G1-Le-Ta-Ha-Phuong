package case_study_module2.model.person;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birth;
//    private String birth;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person( String name, LocalDate birth, String gender, String idCard, String phoneNumber, String email) {

        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getBirth() {
//        return birth;
//    }
//
//    public void setBirth(String birth) {
//        this.birth = birth;
//    }
    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", gender='" + gender + '\'' +
                ", idCard=" + idCard +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
