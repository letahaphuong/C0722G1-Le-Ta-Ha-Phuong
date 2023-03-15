package ss14_sorting_algorithms.excercise.excercise_from_mrHai.model;

public class Student extends Person implements Comparable<Student> {
    private String nameClass;
    private double score;

    public Student(String nameClass, double score) {
        this.nameClass = nameClass;
        this.score = score;
    }

    public Student(String id, String name,
                   String birthday, Boolean sex,
                   String nameClass, double score) {
        super(id, name, birthday, sex);
        this.nameClass = nameClass;
        this.score = score;
    }

    public Student() {
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        if (getSex().equals(true)) {
            return "SINH VIÊN{" +
                    " Mã sinh viên: " +
                    getId() +
                    ", Tên Sinh Viên: " +
                    getName() +
                    ", Ngày tháng năm sinh: " +
                    getBirthday() +
                    ", Giới tính: " +
                    "Nam" +
                    ", Tên Lớp='" + nameClass + '\'' +
                    ", Điểm số=" + score +
                    '}';
        } else if (getSex().equals(false)) {
            return "SINH VIÊN{" +
                    " Mã sinh viên: " +
                    getId() +
                    ", Tên Sinh Viên: " +
                    getName() +
                    ", Ngày tháng năm sinh: " +
                    getBirthday() +
                    ", Giới tính: " +
                    getSex() +
                    ", Tên Lớp='" + nameClass + '\'' +
                    ", Điểm số=" + score +
                    '}';
        } else {
            return "Chưa nhập giới tính";
        }
    }


    @Override
    public int compareTo(Student o) {
        if (this.getName().compareTo(o.getName()) != 0) {
            return getName().compareTo(o.getName());
        } else {
            return getId().compareTo(o.getId());
        }
    }
}

