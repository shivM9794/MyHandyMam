package com.secondwarranty.app.ResponseModel.Cancellation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("cancelledorderdata")
    @Expose
    private Cancelledorderdata cancelledorderdata;

    public Result(Cancelledorderdata cancelledorderdata) {
        this.cancelledorderdata = cancelledorderdata;
    }

    public Cancelledorderdata getCancelledorderdata() {
        return cancelledorderdata;
    }

    public void setCancelledorderdata(Cancelledorderdata cancelledorderdata) {
        this.cancelledorderdata = cancelledorderdata;
    }
}
