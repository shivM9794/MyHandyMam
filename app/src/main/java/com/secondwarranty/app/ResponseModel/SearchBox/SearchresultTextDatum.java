package com.secondwarranty.app.ResponseModel.SearchBox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchresultTextDatum {

    @SerializedName("category_id")
    @Expose
    private Long categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("sub_category_slug")
    @Expose
    private String subCategorySlug;
    @SerializedName("sub_category_id")
    @Expose
    private Long subCategoryId;
    @SerializedName("sub_category_app_image")
    @Expose
    private String subCategoryAppImage;
    @SerializedName("sub_category_web_image")
    @Expose
    private String subCategoryWebImage;

    public SearchresultTextDatum(Long categoryId, String categoryName, String subCategoryName, String subCategorySlug, Long subCategoryId, String subCategoryAppImage, String subCategoryWebImage) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.subCategoryName = subCategoryName;
        this.subCategorySlug = subCategorySlug;
        this.subCategoryId = subCategoryId;
        this.subCategoryAppImage = subCategoryAppImage;
        this.subCategoryWebImage = subCategoryWebImage;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategorySlug() {
        return subCategorySlug;
    }

    public void setSubCategorySlug(String subCategorySlug) {
        this.subCategorySlug = subCategorySlug;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryAppImage() {
        return subCategoryAppImage;
    }

    public void setSubCategoryAppImage(String subCategoryAppImage) {
        this.subCategoryAppImage = subCategoryAppImage;
    }

    public String getSubCategoryWebImage() {
        return subCategoryWebImage;
    }

    public void setSubCategoryWebImage(String subCategoryWebImage) {
        this.subCategoryWebImage = subCategoryWebImage;
    }
}
