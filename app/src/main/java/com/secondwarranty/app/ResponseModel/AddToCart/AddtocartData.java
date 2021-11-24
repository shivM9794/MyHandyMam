package com.secondwarranty.app.ResponseModel.AddToCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddtocartData {

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

    public AddtocartData(Long orderId, Long usersId, String deviceId, Integer creationDate, String creationLat, String creationLong, Long cartId, String addedToCart) {
        this.orderId = orderId;
        this.usersId = usersId;
        this.deviceId = deviceId;
        this.creationDate = creationDate;
        this.creationLat = creationLat;
        this.creationLong = creationLong;
        this.cartId = cartId;
        this.addedToCart = addedToCart;
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
}
