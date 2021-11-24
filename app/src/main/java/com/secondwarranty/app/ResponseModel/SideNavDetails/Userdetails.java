package com.secondwarranty.app.ResponseModel.SideNavDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Userdetails {

    @SerializedName("users_name")
    @Expose
    private String usersName;
    @SerializedName("users_mobile")
    @Expose
    private Long usersMobile;
    @SerializedName("_id")
    @Expose
    private Id id;

    public Userdetails(String usersName, Long usersMobile, Id id) {
        this.usersName = usersName;
        this.usersMobile = usersMobile;
        this.id = id;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public Long getUsersMobile() {
        return usersMobile;
    }

    public void setUsersMobile(Long usersMobile) {
        this.usersMobile = usersMobile;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
