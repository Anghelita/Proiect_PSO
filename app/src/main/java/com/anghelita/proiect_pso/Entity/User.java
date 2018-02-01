package com.anghelita.proiect_pso.Entity;

/**
 * Created by c1baN on 11/15/2017.
 */

public class User{

    private static String firstName = null;
    private static String lastName = null;
    private static String password = null;
    private static String email = null;
    private static String phone = null;
    private static String Group = null;
    private static String IDDownload = null;

    public static String getIDDownload() {
        return IDDownload;
    }

    public static void setIDDownload(String IDDownload) {
        User.IDDownload = IDDownload;
    }

    public static String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        User.firstName = firstName;
    }

    public static String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public static String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        User.lastName = lastName;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        User.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        User.email = email;
    }

    public static String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        User.phone = phone;
    }


    public void setUser(String firstName, String lastName,String password, String email,String phone, int code){
        User.firstName = firstName;
        User.lastName = lastName;
        User.password = password;
        User.email = email;
        User.phone = phone;
    }

    public void removeUser() {
        firstName = null;
        lastName = null;
        password = null;
        email = null;
        phone = null;
    }
}
