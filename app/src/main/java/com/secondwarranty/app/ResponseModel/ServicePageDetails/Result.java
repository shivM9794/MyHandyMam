package com.secondwarranty.app.ResponseModel.ServicePageDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("servicepagedetails")
    @Expose
    private Servicepagedetails servicepagedetails;

    public Result(Servicepagedetails servicepagedetails) {
        this.servicepagedetails = servicepagedetails;
    }

    public Servicepagedetails getServicepagedetails() {
        return servicepagedetails;
    }

    public void setServicepagedetails(Servicepagedetails servicepagedetails) {
        this.servicepagedetails = servicepagedetails;
    }
}
