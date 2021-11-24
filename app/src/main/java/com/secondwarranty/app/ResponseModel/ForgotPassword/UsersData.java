package com.secondwarranty.app.ResponseModel.ForgotPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersData {

    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("users_email")
    @Expose
    private String usersEmail;
    @SerializedName("users_mobile")
    @Expose
    private Long usersMobile;
    @SerializedName("verification_code")
    @Expose
    private Integer verificationCode;

    public UsersData(Long usersId, String usersEmail, Long usersMobile, Integer verificationCode) {
        this.usersId = usersId;
        this.usersEmail = usersEmail;
        this.usersMobile = usersMobile;
        this.verificationCode = verificationCode;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
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

    public Integer getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Integer verificationCode) {
        this.verificationCode = verificationCode;
    }
}
