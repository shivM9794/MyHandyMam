package com.secondwarranty.app.ResponseModel.Bookings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("mybookingData")
    @Expose
    private List<MybookingDatum> mybookingData = null;

    public Result(List<MybookingDatum> mybookingData) {
        this.mybookingData = mybookingData;
    }

    public List<MybookingDatum> getMybookingData() {
        return mybookingData;
    }

    public void setMybookingData(List<MybookingDatum> mybookingData) {
        this.mybookingData = mybookingData;
    }
}
