package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 5,max = 45,message = "{Size}")
    @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$",message = "{PatternFirstName}")
    private String firstName;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 5,max = 45,message = "{Size}")
    @Pattern(regexp = "^[A-Z][a-z]+$",message = "{PatternFirstName}")
    private String lastName;

    private int age;

    @Pattern(regexp = "^[0][0-9]{9,10}$",message = "{Phone}")
    private String phoneNumber;

    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "{Email}")
    private String email;


    public User() {
    }

    public User(Long id, @Size(min = 5, max = 45) String firstName, @Size(min = 5, max = 45) String lastName, int age, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user=(User) target;
        int age =user.getAge();

        if (age<18){
            errors.rejectValue("age","Age","");
        }

    }
}
