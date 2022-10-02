package case_study_module2.service;

import java.io.IOException;

public interface IEmployeeService extends IService{
    void displayAllEmployee() throws IOException;
    void addEmployee() throws IOException;
    void editByID() throws IOException;
}
