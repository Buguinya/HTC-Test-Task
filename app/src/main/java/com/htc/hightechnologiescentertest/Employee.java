package com.htc.hightechnologiescentertest;

import com.google.gson.annotations.SerializedName;

public class Employee {

    private String name;

    @SerializedName("phone_number")
    private String phoneNumber;

    private String[] skills;

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

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}
