package com.secondwarranty.app.ResponseModel.HelpCentreSideNav;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HelpCenterData {

    @SerializedName("help_center_id")
    @Expose
    private Long helpCenterId;
    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("message")
    @Expose
    private String message;
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

    public HelpCenterData(Long helpCenterId, Long usersId, String message, String deviceId, Integer creationDate, String creationLat, String creationLong) {
        this.helpCenterId = helpCenterId;
        this.usersId = usersId;
        this.message = message;
        this.deviceId = deviceId;
        this.creationDate = creationDate;
        this.creationLat = creationLat;
        this.creationLong = creationLong;
    }

    public Long getHelpCenterId() {
        return helpCenterId;
    }

    public void setHelpCenterId(Long helpCenterId) {
        this.helpCenterId = helpCenterId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
