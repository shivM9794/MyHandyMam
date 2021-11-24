package com.secondwarranty.app.ResponseModel.SelectDates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScheduleDates {

    @SerializedName("Date1")
    @Expose
    private String date1;
    @SerializedName("Date2")
    @Expose
    private String date2;
    @SerializedName("Date3")
    @Expose
    private String date3;

    public ScheduleDates(String date1, String date2, String date3) {
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getDate3() {
        return date3;
    }

    public void setDate3(String date3) {
        this.date3 = date3;
    }
}
