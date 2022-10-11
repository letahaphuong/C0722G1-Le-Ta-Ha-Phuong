package model;

public class Student extends Person {
    private String className;
    private double score;

    public Student() {
    }

    public Student(String className, double score) {
        this.className = className;
        this.score = score;
    }

    public Student(String id, String name, String phoneNumber, String birthDay,
                   String gender, String className, double score) {
        super(id, name, phoneNumber, birthDay, gender);
        this.className = className;
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", className='" + className + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    @Override
    public String getInfoPerson() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", getId(), getName(),
                getPhoneNumber(), getBirthDay(), getGender(), getClassName(), getScore());
    }

}
