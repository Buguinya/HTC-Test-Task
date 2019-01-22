package com.htc.hightechnologiescentertest;

import com.google.gson.annotations.SerializedName;

public class JsonResponse {

    @SerializedName("company")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
