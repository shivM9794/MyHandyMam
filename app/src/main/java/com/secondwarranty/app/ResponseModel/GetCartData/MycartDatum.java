package com.secondwarranty.app.ResponseModel.GetCartData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MycartDatum {

    @SerializedName("order_id")
    @Expose
    private Long orderId;
    @SerializedName("users_id")
    @Expose
    private Long usersId;
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
    @SerializedName("cart_id")
    @Expose
    private Long cartId;
    @SerializedName("addedTo_cart")
    @Expose
    private String addedToCart;
    @SerializedName("sequence_order_id")
    @Expose
    private String sequenceOrderId;
    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("service_type")
    @Expose
    private String serviceType;
    @SerializedName("current_location")
    @Expose
    private String currentLocation;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("schedule_date")
    @Expose
    private Integer scheduleDate;
    @SerializedName("schedule_time")
    @Expose
    private Boolean scheduleTime;
    @SerializedName("users_name")
    @Expose
    private String usersName;
    @SerializedName("users_email")
    @Expose
    private String usersEmail;
    @SerializedName("users_mobile")
    @Expose
    private Long usersMobile;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;

    public MycartDatum(Long orderId, Long usersId, String deviceId, Integer creationDate, String creationLat, String creationLong, Long cartId, String addedToCart, String sequenceOrderId, String subCategoryName, String serviceType, String currentLocation, String address, String landmark, Integer scheduleDate, Boolean scheduleTime, String usersName, String usersEmail, Long usersMobile, String date, String time) {
        this.orderId = orderId;
        this.usersId = usersId;
        this.deviceId = deviceId;
        this.creationDate = creationDate;
        this.creationLat = creationLat;
        this.creationLong = creationLong;
        this.cartId = cartId;
        this.addedToCart = addedToCart;
        this.sequenceOrderId = sequenceOrderId;
        this.subCategoryName = subCategoryName;
        this.serviceType = serviceType;
        this.currentLocation = currentLocation;
        this.address = address;
        this.landmark = landmark;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.usersName = usersName;
        this.usersEmail = usersEmail;
        this.usersMobile = usersMobile;
        this.date = date;
        this.time = time;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
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

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getAddedToCart() {
        return addedToCart;
    }

    public void setAddedToCart(String addedToCart) {
        this.addedToCart = addedToCart;
    }

    public String getSequenceOrderId() {
        return sequenceOrderId;
    }

    public void setSequenceOrderId(String sequenceOrderId) {
        this.sequenceOrderId = sequenceOrderId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Integer getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Integer scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Boolean getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Boolean scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public Long getUsersMobile() {
        return usersMobile;
    }

    public void setUsersMobile(Long usersMobile) {
        this.usersMobile = usersMobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
