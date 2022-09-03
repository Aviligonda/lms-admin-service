package com.bridgelabz.lmsadminservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
/*
 * Purpose : AdminDTO fields are Used to Create and Update Admins
 * Version : 1.0
 * @author : Aviligonda Sreenivasulu
 * */


@Data
public class AdminDTO {
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid firstName")
    private String firstName;
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid lastName")
    private String lastName;
    @Pattern(regexp = "[6789][0-9]{9}", message = "Invalid mobile number")
    private String mobile;
    @Pattern(regexp = "(\\w+[.+-]?)*@\\w+(\\.+[a-zA-Z]{2,4})*", message = "Invalid Email, Enter correct Email")
    private String emailId;
    @Pattern(regexp = "(?=.*?[A-Z])(?=.*?\\d)(?=.*?[!@#$%^&*_()+-])[A-Za-z\\d!@#$%^&()*+_-]{8,}"
            , message = "Password should have AtLeast one (capital ,small,special character,numeric) minimum 8 characters")
    private String password;
    @NotNull(message = " Status can't be Empty")
    private String status;

}

