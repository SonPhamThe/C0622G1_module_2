package case_study.service;

import java.io.IOException;

public interface ICustomer {
    void addCustomer() throws IOException;

    void displayCustomer();

    void editCustomer() throws IOException;
}
