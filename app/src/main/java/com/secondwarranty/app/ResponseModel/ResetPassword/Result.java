package com.secondwarranty.app.ResponseModel.ResetPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("usersData")
    @Expose
    private UsersData usersData;

    public Result(UsersData usersData) {
        this.usersData = usersData;
    }

    public UsersData getUsersData() {
        return usersData;
    }

    public void setUsersData(UsersData usersData) {
        this.usersData = usersData;
    }
}
