package service;

import java.io.IOException;

public interface IAccountsSaveBankService {

    void addSave() throws IOException;

    void removeSave() throws IOException;

    void displaySave() throws IOException;

    void findSave() throws IOException;
}
