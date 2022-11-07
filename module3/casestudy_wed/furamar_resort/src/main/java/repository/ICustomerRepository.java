package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    boolean add(Customer customer);

    List<Customer> findByName(String str);

    List<Customer> findAll();

    boolean remove(int id);

    boolean update(int id,Customer customer);
}
