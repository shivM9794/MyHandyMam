package com.secondwarranty.app.ResponseModel.GetCartData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("mycartData")
    @Expose
    private List<MycartDatum> mycartData = null;

    public Result(List<MycartDatum> mycartData) {
        this.mycartData = mycartData;
    }

    public List<MycartDatum> getMycartData() {
        return mycartData;
    }

    public void setMycartData(List<MycartDatum> mycartData) {
        this.mycartData = mycartData;
    }
}
