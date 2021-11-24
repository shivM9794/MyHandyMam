package com.secondwarranty.app.ResponseModel.SideNavDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("userdetails")
    @Expose
    private Userdetails userdetails;

    public Result(Userdetails userdetails) {
        this.userdetails = userdetails;
    }

    public Userdetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(Userdetails userdetails) {
        this.userdetails = userdetails;
    }
}
