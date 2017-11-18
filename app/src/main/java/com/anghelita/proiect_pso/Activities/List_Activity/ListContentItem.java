package com.anghelita.proiect_pso.Activities.List_Activity;

/**
 * Created by c1baN on 11/15/2017.
 */

public class ListContentItem {
    String name;
    String phoneNumber;

    public ListContentItem(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
