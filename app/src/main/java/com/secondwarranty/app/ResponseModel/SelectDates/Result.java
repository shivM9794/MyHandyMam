package com.secondwarranty.app.ResponseModel.SelectDates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("scheduleDates")
    @Expose
    private ScheduleDates scheduleDates;

    public Result(ScheduleDates scheduleDates) {
        this.scheduleDates = scheduleDates;
    }

    public ScheduleDates getScheduleDates() {
        return scheduleDates;
    }

    public void setScheduleDates(ScheduleDates scheduleDates) {
        this.scheduleDates = scheduleDates;
    }
}
