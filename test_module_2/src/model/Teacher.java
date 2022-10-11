package model;

public class Teacher extends Person {
    private String level;
    public Teacher() {
    }
    public Teacher(String level) {
        this.level = level;
    }

    public Teacher(String id, String name, String phoneNumber, String birthDay, String gender, String level) {
        super(id, name, phoneNumber, birthDay, gender);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Teacher{" +super.toString()+
                ", level='" + level + '\'' +
                '}';
    }

    @Override
    public String getInfoPerson() {
        return String.format("%s,%s,%s,%s,%s,%s",getId(),getName(),getPhoneNumber(),
                getBirthDay(),getGender(),getLevel());
    }
}
