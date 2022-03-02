package com.test.hplusapp.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    private int id;

    // changing the default message with our custom message
    @Size(min = 6, message = "username should be of at-least 6 characters.")
    private String username;

    @Pattern(regexp = "((?=.*[A-Z]).{6,10})",
            message = "Password must have 1 Uppercase character and should be at-least 6 characters long")
    private String password;

    @NotEmpty(message = "First name can't be empty")
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING) // so that in database instead of numbers 0, 1, 2 the string of enum gets stored
    private Gender gender;

    @NotNull(message = "activity should not be null.")
    private String activity;
    private Date dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
