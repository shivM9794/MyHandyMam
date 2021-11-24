package com.secondwarranty.app.ResponseModel.ResetPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersData {

    @SerializedName("users_id")
    @Expose
    private Long usersId;

    public UsersData(Long usersId) {
        this.usersId = usersId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }
}
