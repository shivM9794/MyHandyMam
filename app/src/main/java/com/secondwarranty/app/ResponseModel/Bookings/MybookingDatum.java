package com.secondwarranty.app.ResponseModel.Bookings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MybookingDatum {

    @SerializedName("service_type")
    @Expose
    private String serviceType;
    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("schedule_date")
    @Expose
    private String scheduleDate;
    @SerializedName("schedule_time")
    @Expose
    private String scheduleTime;
    @SerializedName("_id")
    @Expose
    private Id id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;

    public MybookingDatum(String serviceType, String subCategoryName, String scheduleDate, String scheduleTime, Id id, String date, String time) {
        this.serviceType = serviceType;
        this.subCategoryName = subCategoryName;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
