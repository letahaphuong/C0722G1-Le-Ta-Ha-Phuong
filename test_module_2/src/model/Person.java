package model;


public abstract class Person {
    private String id;
    private String name;
    private String phoneNumber;
    private String birthDay;
    private String gender;

    public Person() {
    }

    public Person(String id, String name, String phoneNumber, String birthDay, String gender) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", birthDay=" + birthDay +
                        ", gender='" + gender;
    }

    public abstract String getInfoPerson();
}