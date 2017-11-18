package com.anghelita.proiect_pso.Entity;

/**
 * Created by c1baN on 11/15/2017.
 */

public class User{

    private static String firstName;
    private static String lastName;
    private static String password;
    private static String email;
    private static String phone;
    private static int code;

    public static String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setUser(String firstName, String lastName,String password, String email,String phone, int code){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.code = code;
    }
}
