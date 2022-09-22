package ss13_thuat_toan_tim_kiem.excercise.tempalte.view;

import ss13_thuat_toan_tim_kiem.excercise.tempalte.controller.PersonController;
import ss13_thuat_toan_tim_kiem.excercise.tempalte.controller.StudentController;
import ss13_thuat_toan_tim_kiem.excercise.tempalte.controller.TeacherController;

public class main {
    public static void main(String[] args) {
        PersonController.menuPerson();
        StudentController.menuStudent();
        TeacherController.menuTeacher();
    }
}
