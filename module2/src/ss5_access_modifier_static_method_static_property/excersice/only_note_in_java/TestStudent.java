package ss5_access_modifier_static_method_static_property.excersice.only_note_in_java;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Quyên");
        student.setClasses("A7");
        System.out.println(student.getName() + student.getClasses());
    }
}
