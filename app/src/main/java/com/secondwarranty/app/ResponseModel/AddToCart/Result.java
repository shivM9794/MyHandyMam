package com.secondwarranty.app.ResponseModel.AddToCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("addtocartData")
    @Expose
    private AddtocartData addtocartData;

    public Result(AddtocartData addtocartData) {
        this.addtocartData = addtocartData;
    }

    public AddtocartData getAddtocartData() {
        return addtocartData;
    }

    public void setAddtocartData(AddtocartData addtocartData) {
        this.addtocartData = addtocartData;
    }
}
