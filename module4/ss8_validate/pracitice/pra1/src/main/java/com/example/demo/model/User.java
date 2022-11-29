package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2,max = 30)
    private String name;

    @Min(18)
    private int age;

    public User() {
    }

    public User(Long id, @NotEmpty @Size(min = 2, max = 30) String name, @Min(18) int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user=(User) target;
        String name = user.getName();
        int age=user.getAge();

        if (name == null || "".equals(name)){
            errors.rejectValue("name","errors.name.blank","Tên khách hàng không được để trống");
        }
        if (age<18){
            errors.rejectValue("name","errors.age.wrong","Tuổi không được nhỏ hơn 18");
        }

    }
}
