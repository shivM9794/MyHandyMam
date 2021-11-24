package com.secondwarranty.app.ResponseModel.ServicePageDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Servicepagedetails {

    @SerializedName("category_id")
    @Expose
    private Long categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_slug")
    @Expose
    private String categorySlug;
    @SerializedName("sub_category_id")
    @Expose
    private Long subCategoryId;
    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("sub_category_slug")
    @Expose
    private String subCategorySlug;
    @SerializedName("service_image")
    @Expose
    private String serviceImage;
    @SerializedName("service_image_alt")
    @Expose
    private String serviceImageAlt;
    @SerializedName("serviceType")
    @Expose
    private List<ServiceType> serviceType = null;
    @SerializedName("service_id")
    @Expose
    private Long serviceId;
    @SerializedName("creation_ip")
    @Expose
    private String creationIp;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("created_by")
    @Expose
    private Long createdBy;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("update_date")
    @Expose
    private Integer updateDate;
    @SerializedName("update_ip")
    @Expose
    private String updateIp;
    @SerializedName("updated_by")
    @Expose
    private Long updatedBy;
    @SerializedName("_id")
    @Expose
    private Id id;

    public Servicepagedetails(Long categoryId, String categoryName, String categorySlug, Long subCategoryId, String subCategoryName, String subCategorySlug, String serviceImage, String serviceImageAlt, List<ServiceType> serviceType, Long serviceId, String creationIp, Integer creationDate, Long createdBy, String status, Integer updateDate, String updateIp, Long updatedBy, Id id) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categorySlug = categorySlug;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.subCategorySlug = subCategorySlug;
        this.serviceImage = serviceImage;
        this.serviceImageAlt = serviceImageAlt;
        this.serviceType = serviceType;
        this.serviceId = serviceId;
        this.creationIp = creationIp;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.status = status;
        this.updateDate = updateDate;
        this.updateIp = updateIp;
        this.updatedBy = updatedBy;
        this.id = id;
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

    public String getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
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

    public String getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(String serviceImage) {
        this.serviceImage = serviceImage;
    }

    public String getServiceImageAlt() {
        return serviceImageAlt;
    }

    public void setServiceImageAlt(String serviceImageAlt) {
        this.serviceImageAlt = serviceImageAlt;
    }

    public List<ServiceType> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<ServiceType> serviceType) {
        this.serviceType = serviceType;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getCreationIp() {
        return creationIp;
    }

    public void setCreationIp(String creationIp) {
        this.creationIp = creationIp;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateIp() {
        return updateIp;
    }

    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
