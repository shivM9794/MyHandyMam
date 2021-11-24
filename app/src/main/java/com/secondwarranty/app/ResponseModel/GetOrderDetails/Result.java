package com.secondwarranty.app.ResponseModel.GetOrderDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("orderdetails")
    @Expose
    private Orderdetails orderdetails;

    public Result(Orderdetails orderdetails) {
        this.orderdetails = orderdetails;
    }

    public Orderdetails getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(Orderdetails orderdetails) {
        this.orderdetails = orderdetails;
    }
}
