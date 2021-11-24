package com.secondwarranty.app.ResponseModel.ChangeDateAndTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rescheduledatetimes {

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
    private Integer minCharge;
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
    @SerializedName("order_step")
    @Expose
    private Integer orderStep;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("order_placed")
    @Expose
    private String orderPlaced;
    @SerializedName("order_assigned")
    @Expose
    private String orderAssigned;
    @SerializedName("payment_mode")
    @Expose
    private String paymentMode;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("status")
    @Expose
    private String status;
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
    @SerializedName("schedule_date")
    @Expose
    private Integer scheduleDate;
    @SerializedName("schedule_time")
    @Expose
    private String scheduleTime;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("current_location")
    @Expose
    private String currentLocation;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("update_date")
    @Expose
    private Integer updateDate;
    @SerializedName("update_lat")
    @Expose
    private String updateLat;
    @SerializedName("update_long")
    @Expose
    private String updateLong;
    @SerializedName("cancellation_date")
    @Expose
    private Integer cancellationDate;
    @SerializedName("cancellation_reason")
    @Expose
    private String cancellationReason;
    @SerializedName("_id")
    @Expose
    private Id id;

    public Rescheduledatetimes(Long orderId, String sequenceOrderId, Long usersId, String serviceType, Integer minCharge, Long subCategoryId, String subCategoryName, Long categoryId, String categoryName, Integer orderStep, String paymentStatus, String orderPlaced, String orderAssigned, String paymentMode, String orderStatus, String status, String deviceId, Integer creationDate, String creationLat, String creationLong, Integer scheduleDate, String scheduleTime, String address, String currentLocation, String landmark, Integer updateDate, String updateLat, String updateLong, Integer cancellationDate, String cancellationReason, Id id) {
        this.orderId = orderId;
        this.sequenceOrderId = sequenceOrderId;
        this.usersId = usersId;
        this.serviceType = serviceType;
        this.minCharge = minCharge;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.orderStep = orderStep;
        this.paymentStatus = paymentStatus;
        this.orderPlaced = orderPlaced;
        this.orderAssigned = orderAssigned;
        this.paymentMode = paymentMode;
        this.orderStatus = orderStatus;
        this.status = status;
        this.deviceId = deviceId;
        this.creationDate = creationDate;
        this.creationLat = creationLat;
        this.creationLong = creationLong;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.address = address;
        this.currentLocation = currentLocation;
        this.landmark = landmark;
        this.updateDate = updateDate;
        this.updateLat = updateLat;
        this.updateLong = updateLong;
        this.cancellationDate = cancellationDate;
        this.cancellationReason = cancellationReason;
        this.id = id;
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

    public Integer getMinCharge() {
        return minCharge;
    }

    public void setMinCharge(Integer minCharge) {
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

    public Integer getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(Integer orderStep) {
        this.orderStep = orderStep;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public String getOrderAssigned() {
        return orderAssigned;
    }

    public void setOrderAssigned(String orderAssigned) {
        this.orderAssigned = orderAssigned;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Integer scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateLat() {
        return updateLat;
    }

    public void setUpdateLat(String updateLat) {
        this.updateLat = updateLat;
    }

    public String getUpdateLong() {
        return updateLong;
    }

    public void setUpdateLong(String updateLong) {
        this.updateLong = updateLong;
    }

    public Integer getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Integer cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
