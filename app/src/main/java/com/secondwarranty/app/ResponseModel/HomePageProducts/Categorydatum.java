package com.secondwarranty.app.ResponseModel.HomePageProducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categorydatum {

    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_slug")
    @Expose
    private String categorySlug;
    @SerializedName("category_web_image_alt")
    @Expose
    private String categoryWebImageAlt;
    @SerializedName("category_app_image_alt")
    @Expose
    private String categoryAppImageAlt;
    @SerializedName("category_id")
    @Expose
    private Long categoryId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("category_app_image")
    @Expose
    private String categoryAppImage;
    @SerializedName("category_web_image")
    @Expose
    private String categoryWebImage;
    @SerializedName("_id")
    @Expose
    private Id id;
    @SerializedName("subcategorydata")
    @Expose
    private List<Subcategorydatum> subcategorydata = null;

    public Categorydatum(String categoryName, String categorySlug, String categoryWebImageAlt, String categoryAppImageAlt, Long categoryId, String status, String categoryAppImage, String categoryWebImage, Id id, List<Subcategorydatum> subcategorydata) {
        this.categoryName = categoryName;
        this.categorySlug = categorySlug;
        this.categoryWebImageAlt = categoryWebImageAlt;
        this.categoryAppImageAlt = categoryAppImageAlt;
        this.categoryId = categoryId;
        this.status = status;
        this.categoryAppImage = categoryAppImage;
        this.categoryWebImage = categoryWebImage;
        this.id = id;
        this.subcategorydata = subcategorydata;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public String getCategoryWebImageAlt() {
        return categoryWebImageAlt;
    }

    public void setCategoryWebImageAlt(String categoryWebImageAlt) {
        this.categoryWebImageAlt = categoryWebImageAlt;
    }

    public String getCategoryAppImageAlt() {
        return categoryAppImageAlt;
    }

    public void setCategoryAppImageAlt(String categoryAppImageAlt) {
        this.categoryAppImageAlt = categoryAppImageAlt;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoryAppImage() {
        return categoryAppImage;
    }

    public void setCategoryAppImage(String categoryAppImage) {
        this.categoryAppImage = categoryAppImage;
    }

    public String getCategoryWebImage() {
        return categoryWebImage;
    }

    public void setCategoryWebImage(String categoryWebImage) {
        this.categoryWebImage = categoryWebImage;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public List<Subcategorydatum> getSubcategorydata() {
        return subcategorydata;
    }

    public void setSubcategorydata(List<Subcategorydatum> subcategorydata) {
        this.subcategorydata = subcategorydata;
    }
}
