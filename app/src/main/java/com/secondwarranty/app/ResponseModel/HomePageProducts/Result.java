package com.secondwarranty.app.ResponseModel.HomePageProducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("categorydata")
    @Expose
    private List<Categorydatum> categorydata = null;
    @SerializedName("bannerData")
    @Expose
    private List<BannerDatum> bannerData = null;
    @SerializedName("profileImg")
    @Expose
    private ProfileImg profileImg;

    public Result(List<Categorydatum> categorydata, List<BannerDatum> bannerData, ProfileImg profileImg) {
        this.categorydata = categorydata;
        this.bannerData = bannerData;
        this.profileImg = profileImg;
    }

    public List<Categorydatum> getCategorydata() {
        return categorydata;
    }

    public void setCategorydata(List<Categorydatum> categorydata) {
        this.categorydata = categorydata;
    }

    public List<BannerDatum> getBannerData() {
        return bannerData;
    }

    public void setBannerData(List<BannerDatum> bannerData) {
        this.bannerData = bannerData;
    }

    public ProfileImg getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(ProfileImg profileImg) {
        this.profileImg = profileImg;
    }
}
