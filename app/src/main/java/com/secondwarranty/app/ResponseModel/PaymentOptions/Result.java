package com.secondwarranty.app.ResponseModel.PaymentOptions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("finalorderplaced")
    @Expose
    private Finalorderplaced finalorderplaced;

    public Result(Finalorderplaced finalorderplaced) {
        this.finalorderplaced = finalorderplaced;
    }

    public Finalorderplaced getFinalorderplaced() {
        return finalorderplaced;
    }

    public void setFinalorderplaced(Finalorderplaced finalorderplaced) {
        this.finalorderplaced = finalorderplaced;
    }
}
