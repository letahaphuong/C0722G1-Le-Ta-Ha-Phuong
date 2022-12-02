package com.example.demo.dto;


import com.example.demo.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {

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


    public UserDto() {
    }

    public UserDto(Long id, @NotEmpty(message = "{NotEmpty}") @Size(min = 5, max = 45, message = "{Size}") @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$", message = "{PatternFirstName}") String firstName, @NotEmpty(message = "{NotEmpty}") @Size(min = 5, max = 45, message = "{Size}") @Pattern(regexp = "^[A-Z][a-z]+$", message = "{PatternFirstName}") String lastName, int age, @Pattern(regexp = "^[0][0-9]{9,10}$", message = "{Phone}") String phoneNumber, @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "{Email}") String email) {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto=(UserDto) target;
        int age =userDto.getAge();

        if (age<18){
            errors.rejectValue("age","Age","");
        }
    }
}
