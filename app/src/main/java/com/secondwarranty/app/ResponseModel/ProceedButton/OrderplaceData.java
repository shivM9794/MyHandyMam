package com.secondwarranty.app.ResponseModel.ProceedButton;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderplaceData {

    @SerializedName("order_id")
    @Expose
    private Long orderId;
    @SerializedName("sequence_order_id")
    @Expose
    private String sequenceOrderId;
    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("service_type")
    @Expose
    private String serviceType;
    @SerializedName("min_charge")
    @Expose
    private String minCharge;
    @SerializedName("sub_category_id")
    @Expose
    private Long subCategoryId;
    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("category_id")
    @Expose
    private Long categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("creation_lat")
    @Expose
    private String creationLat;
    @SerializedName("creation_long")
    @Expose
    private String creationLong;

    public OrderplaceData(Long orderId, String sequenceOrderId, Long usersId, String serviceType, String minCharge, Long subCategoryId, String subCategoryName, Long categoryId, String categoryName, String paymentStatus, String deviceId, Integer creationDate, String creationLat, String creationLong) {
        this.orderId = orderId;
        this.sequenceOrderId = sequenceOrderId;
        this.usersId = usersId;
        this.serviceType = serviceType;
        this.minCharge = minCharge;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.paymentStatus = paymentStatus;
        this.deviceId = deviceId;
        this.creationDate = creationDate;
        this.creationLat = creationLat;
        this.creationLong = creationLong;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSequenceOrderId() {
        return sequenceOrderId;
    }

    public void setSequenceOrderId(String sequenceOrderId) {
        this.sequenceOrderId = sequenceOrderId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMinCharge() {
        return minCharge;
    }

    public void setMinCharge(String minCharge) {
        this.minCharge = minCharge;
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

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationLat() {
        return creationLat;
    }

    public void setCreationLat(String creationLat) {
        this.creationLat = creationLat;
    }

    public String getCreationLong() {
        return creationLong;
    }

    public void setCreationLong(String creationLong) {
        this.creationLong = creationLong;
    }
}
