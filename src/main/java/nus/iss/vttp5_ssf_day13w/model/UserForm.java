package nus.iss.vttp5_ssf_day13w.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserForm {

    private String ID;

    @NotEmpty(message = "Name is mandatory")
    @Size(min = 2, max = 64, message = "Name must be between 3 to 64 characters long")
    private String name; 

    @NotEmpty(message = "Email is mandatory")
    @Email(message = "Email must be valid email format")
    private String email; 

    @NotEmpty(message = "Phone number is mandatory")
    @Pattern(regexp = "\\d{7,}", message = "Phone number must contain at least 7 digits")
    private String phoneNumber; 

    @NotNull(message = "Date of Birth is mandatory")
    @Past(message = "Date of Birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    // constructors
    public UserForm() {

        // random ID generated 
        this.ID = UUID.randomUUID().toString().substring(0, 8);

    }

    public UserForm(String name, String email, String phoneNumber, LocalDate dateOfBirth) {

        // random ID generated 
        this.ID = UUID.randomUUID().toString().substring(0, 8);

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    // constructor for UserForm that already has ID 
    public UserForm(String ID, String name, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;

    }

    // getters and setters

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }     

    public Boolean validAge() {
        LocalDate now = LocalDate.now();
        Integer age = Period.between(dateOfBirth, now).getYears();

        if (age < 10 || age > 100) { 
            return false;
        } else {
            return true;
        }

    }


}
