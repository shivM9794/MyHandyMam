package com.secondwarranty.app.ResponseModel.HomePageProducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerDatum {

    @SerializedName("slider_id")
    @Expose
    private Long sliderId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id__2 id;

    public BannerDatum(Long sliderId, String image, String alt, Integer creationDate, String status, Id__2 id) {
        this.sliderId = sliderId;
        this.image = image;
        this.alt = alt;
        this.creationDate = creationDate;
        this.status = status;
        this.id = id;
    }

    public Long getSliderId() {
        return sliderId;
    }

    public void setSliderId(Long sliderId) {
        this.sliderId = sliderId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Id__2 getId() {
        return id;
    }

    public void setId(Id__2 id) {
        this.id = id;
    }
}
