package com.secondwarranty.app.ResponseModel.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("orderdatawithaddress")
    @Expose
    private Orderdatawithaddress orderdatawithaddress;

    public Result(Orderdatawithaddress orderdatawithaddress) {
        this.orderdatawithaddress = orderdatawithaddress;
    }

    public Orderdatawithaddress getOrderdatawithaddress() {
        return orderdatawithaddress;
    }

    public void setOrderdatawithaddress(Orderdatawithaddress orderdatawithaddress) {
        this.orderdatawithaddress = orderdatawithaddress;
    }
}
