package com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("scheduledatetime")
    @Expose
    private Scheduledatetime scheduledatetime;

    public Result(Scheduledatetime scheduledatetime) {
        this.scheduledatetime = scheduledatetime;
    }

    public Scheduledatetime getScheduledatetime() {
        return scheduledatetime;
    }

    public void setScheduledatetime(Scheduledatetime scheduledatetime) {
        this.scheduledatetime = scheduledatetime;
    }
}
