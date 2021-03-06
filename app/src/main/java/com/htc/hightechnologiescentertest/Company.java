package com.htc.hightechnologiescentertest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Company {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("competences")
    @Expose
    private List<String> competences;

    @SerializedName("employees")
    @Expose
    private List<Employee> employees;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<String> getCompetences() {

        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public void setName(String name) {
        this.name = name;

    }
}
