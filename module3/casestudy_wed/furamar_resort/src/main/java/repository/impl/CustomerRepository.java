package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO customer (customer_type_id, `name` , date_of_birth,gender,id_card,phone_number,email,address) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_NAME = "select * from customer where `name` =?;";
    private static final String SELECT_ALL_USERS = "select * from customer ORDER BY `name` ASC ;";
    private static final String DELETE_USERS_SQL = "delete from customer where id = ?;";
    private static final String UPDATE_USERS_SQL = "update customer set customer_type_id=?, name = ?,date_of_birth= ?," +
            " gender =? ,id_card=? ,phone_number = ?,email=?,address=? where id=?;";


    @Override
    public boolean add(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
            ps.setString(1, customer.getCustomerType());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getDateOfBirth());
            ps.setString(4, String.valueOf(customer.isGender()));
            ps.setString(5, customer.getIdCard());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());

            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    @Override
    public List<Customer> findByName(String str) {

        Connection connection = BaseRepository.getConnectDB();
        List<Customer> userList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_NAME);
            ps.setString(1, str);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String customer_id = resultSet.getString("customer_type_id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, customer_id,name,dateOfBirth,gender,idCard,phoneNumber,email,address );
                userList.add(customer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<Customer> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<Customer> userList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String customerId=resultSet.getString("customer_type_id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, customerId, name, dateOfBirth,gender,idCard,phoneNumber,email,address);
                userList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean remove(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_USERS_SQL);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USERS_SQL);
            ps.setString(1, customer.getCustomerType());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getDateOfBirth());
            ps.setBoolean(4, customer.isGender());
            ps.setString(5, customer.getIdCard());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            ps.setInt(9, customer.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}
