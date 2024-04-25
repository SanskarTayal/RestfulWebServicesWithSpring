package com.twpractice.app.ws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
    @NotNull
    @Size(min = 2, message = "FirstName must be greater than 2 Characters.")
    private String firstName;
    @NotNull
    @Size(min = 2, message = "LastName must be greater than 2 Characters.")
    private String lastName;

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
}
