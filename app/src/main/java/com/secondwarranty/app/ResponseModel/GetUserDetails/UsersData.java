package com.secondwarranty.app.ResponseModel.GetUserDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersData {

    @SerializedName("users_token")
    @Expose
    private String usersToken;
    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("users_sequence_id")
    @Expose
    private String usersSequenceId;
    @SerializedName("users_name")
    @Expose
    private String usersName;
    @SerializedName("users_email")
    @Expose
    private String usersEmail;
    @SerializedName("users_email_verified")
    @Expose
    private String usersEmailVerified;
    @SerializedName("users_mobile")
    @Expose
    private String usersMobile;
    @SerializedName("users_mobile_verified")
    @Expose
    private String usersMobileVerified;
    @SerializedName("users_type")
    @Expose
    private String usersType;
    @SerializedName("users_image")
    @Expose
    private String usersImage;
    @SerializedName("account_verified")
    @Expose
    private String accountVerified;
    @SerializedName("alt_mobile")
    @Expose
    private String altMobile;
    @SerializedName("address")
    @Expose
    private String address;

    public UsersData(String usersToken, Long usersId, String usersSequenceId, String usersName, String usersEmail, String usersEmailVerified, String usersMobile, String usersMobileVerified, String usersType, String usersImage, String accountVerified, String altMobile, String address) {
        this.usersToken = usersToken;
        this.usersId = usersId;
        this.usersSequenceId = usersSequenceId;
        this.usersName = usersName;
        this.usersEmail = usersEmail;
        this.usersEmailVerified = usersEmailVerified;
        this.usersMobile = usersMobile;
        this.usersMobileVerified = usersMobileVerified;
        this.usersType = usersType;
        this.usersImage = usersImage;
        this.accountVerified = accountVerified;
        this.altMobile = altMobile;
        this.address = address;
    }

    public String getUsersToken() {
        return usersToken;
    }

    public void setUsersToken(String usersToken) {
        this.usersToken = usersToken;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getUsersSequenceId() {
        return usersSequenceId;
    }

    public void setUsersSequenceId(String usersSequenceId) {
        this.usersSequenceId = usersSequenceId;
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

    public String getUsersEmailVerified() {
        return usersEmailVerified;
    }

    public void setUsersEmailVerified(String usersEmailVerified) {
        this.usersEmailVerified = usersEmailVerified;
    }

    public String getUsersMobile() {
        return usersMobile;
    }

    public void setUsersMobile(String usersMobile) {
        this.usersMobile = usersMobile;
    }

    public String getUsersMobileVerified() {
        return usersMobileVerified;
    }

    public void setUsersMobileVerified(String usersMobileVerified) {
        this.usersMobileVerified = usersMobileVerified;
    }

    public String getUsersType() {
        return usersType;
    }

    public void setUsersType(String usersType) {
        this.usersType = usersType;
    }

    public String getUsersImage() {
        return usersImage;
    }

    public void setUsersImage(String usersImage) {
        this.usersImage = usersImage;
    }

    public String getAccountVerified() {
        return accountVerified;
    }

    public void setAccountVerified(String accountVerified) {
        this.accountVerified = accountVerified;
    }

    public String getAltMobile() {
        return altMobile;
    }

    public void setAltMobile(String altMobile) {
        this.altMobile = altMobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
