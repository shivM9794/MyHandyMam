package com.secondwarranty.app.ResponseModel.HomePageProducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileImg {

    @SerializedName("users_image")
    @Expose
    private String usersImage;
    @SerializedName("_id")
    @Expose
    private Id__3 id;

    public ProfileImg(String usersImage, Id__3 id) {
        this.usersImage = usersImage;
        this.id = id;
    }

    public String getUsersImage() {
        return usersImage;
    }

    public void setUsersImage(String usersImage) {
        this.usersImage = usersImage;
    }

    public Id__3 getId() {
        return id;
    }

    public void setId(Id__3 id) {
        this.id = id;
    }
}
