package com.twpracticespring.appws.practiceappws.ui.model.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message = "firstName Cannot be null")
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    @NotNull(message = "Email Cannot be null")
    private String email;
    @NotNull(message = "Password Cannot be null")
    @Size(min = 8, max = 16)
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
