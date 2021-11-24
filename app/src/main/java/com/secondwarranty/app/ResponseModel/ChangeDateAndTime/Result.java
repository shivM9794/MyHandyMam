package com.secondwarranty.app.ResponseModel.ChangeDateAndTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("rescheduledatetimes")
    @Expose
    private Rescheduledatetimes rescheduledatetimes;

    public Result(Rescheduledatetimes rescheduledatetimes) {
        this.rescheduledatetimes = rescheduledatetimes;
    }

    public Rescheduledatetimes getRescheduledatetimes() {
        return rescheduledatetimes;
    }

    public void setRescheduledatetimes(Rescheduledatetimes rescheduledatetimes) {
        this.rescheduledatetimes = rescheduledatetimes;
    }
}
