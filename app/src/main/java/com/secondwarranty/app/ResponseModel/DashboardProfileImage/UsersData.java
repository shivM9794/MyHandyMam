package com.secondwarranty.app.ResponseModel.DashboardProfileImage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersData {

    @SerializedName("users_token")
    @Expose
    private String usersToken;
    @SerializedName("Imagelink")
    @Expose
    private String imagelink;
    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("users_sequence_id")
    @Expose
    private Object usersSequenceId;
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
    private Long usersMobile;
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

    public UsersData(String usersToken, String imagelink, Long usersId, Object usersSequenceId, String usersName, String usersEmail, String usersEmailVerified, Long usersMobile, String usersMobileVerified, String usersType, String usersImage, String accountVerified) {
        this.usersToken = usersToken;
        this.imagelink = imagelink;
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
    }

    public String getUsersToken() {
        return usersToken;
    }

    public void setUsersToken(String usersToken) {
        this.usersToken = usersToken;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Object getUsersSequenceId() {
        return usersSequenceId;
    }

    public void setUsersSequenceId(Object usersSequenceId) {
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

    public Long getUsersMobile() {
        return usersMobile;
    }

    public void setUsersMobile(Long usersMobile) {
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
}
