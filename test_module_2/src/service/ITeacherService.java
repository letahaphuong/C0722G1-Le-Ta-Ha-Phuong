package service;

import java.io.IOException;

public interface ITeacherService {
    void addStudent() throws IOException;

    void removeStudent() throws IOException;

    void displayStudent() throws IOException;
}
