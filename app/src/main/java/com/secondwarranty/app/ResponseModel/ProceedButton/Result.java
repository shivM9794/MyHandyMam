package com.secondwarranty.app.ResponseModel.ProceedButton;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("orderplaceData")
    @Expose
    private OrderplaceData orderplaceData;

    public Result(OrderplaceData orderplaceData) {
        this.orderplaceData = orderplaceData;
    }

    public OrderplaceData getOrderplaceData() {
        return orderplaceData;
    }

    public void setOrderplaceData(OrderplaceData orderplaceData) {
        this.orderplaceData = orderplaceData;
    }
}
