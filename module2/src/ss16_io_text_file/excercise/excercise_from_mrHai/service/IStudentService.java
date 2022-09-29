package ss16_io_text_file.excercise.excercise_from_mrHai.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IStudentService {
    void addStudent() throws IOException;
    void displayAllStudent();
    void removeStudent();
//    void findStudentNameOrID();

    void findStudentName();

    void findStudentID();

    void sortName();
}
