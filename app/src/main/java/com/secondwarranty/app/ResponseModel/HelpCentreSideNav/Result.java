package com.secondwarranty.app.ResponseModel.HelpCentreSideNav;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("userdetails")
    @Expose
    private Userdetails userdetails;
    @SerializedName("help_center_data")
    @Expose
    private HelpCenterData helpCenterData;

    public Result(Userdetails userdetails, HelpCenterData helpCenterData) {
        this.userdetails = userdetails;
        this.helpCenterData = helpCenterData;
    }

    public Userdetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(Userdetails userdetails) {
        this.userdetails = userdetails;
    }

    public HelpCenterData getHelpCenterData() {
        return helpCenterData;
    }

    public void setHelpCenterData(HelpCenterData helpCenterData) {
        this.helpCenterData = helpCenterData;
    }
}
