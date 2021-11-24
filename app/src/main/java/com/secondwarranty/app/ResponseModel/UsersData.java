package com.secondwarranty.app.ResponseModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersData {

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
    @SerializedName("users_mobile")
    @Expose
    private Long usersMobile;
    @SerializedName("email_verification_code")
    @Expose
    private Integer emailVerificationCode;
    @SerializedName("mobile_verification_code")
    @Expose
    private String mobileVerificationCode;
    @SerializedName("users_type")
    @Expose
    private String usersType;
    @SerializedName("users_image")
    @Expose
    private String usersImage;
    @SerializedName("account_verified")
    @Expose
    private String accountVerified;

    public UsersData(Long usersId, Object usersSequenceId, String usersName, String usersEmail, Long usersMobile, Integer emailVerificationCode, String mobileVerificationCode, String usersType, String usersImage, String accountVerified) {
        this.usersId = usersId;
        this.usersSequenceId = usersSequenceId;
        this.usersName = usersName;
        this.usersEmail = usersEmail;
        this.usersMobile = usersMobile;
        this.emailVerificationCode = emailVerificationCode;
        this.mobileVerificationCode = mobileVerificationCode;
        this.usersType = usersType;
        this.usersImage = usersImage;
        this.accountVerified = accountVerified;
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

    public Long getUsersMobile() {
        return usersMobile;
    }

    public void setUsersMobile(Long usersMobile) {
        this.usersMobile = usersMobile;
    }

    public Integer getEmailVerificationCode() {
        return emailVerificationCode;
    }

    public void setEmailVerificationCode(Integer emailVerificationCode) {
        this.emailVerificationCode = emailVerificationCode;
    }

    public String getMobileVerificationCode() {
        return mobileVerificationCode;
    }

    public void setMobileVerificationCode(String mobileVerificationCode) {
        this.mobileVerificationCode = mobileVerificationCode;
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
