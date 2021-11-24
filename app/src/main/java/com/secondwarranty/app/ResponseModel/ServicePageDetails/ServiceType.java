package com.secondwarranty.app.ResponseModel.ServicePageDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceType {

    @SerializedName("service_type_id")
    @Expose
    private Integer serviceTypeId;
    @SerializedName("heading")
    @Expose
    private String heading;
    @SerializedName("min_charge")
    @Expose
    private Integer minCharge;
    @SerializedName("estimate_range")
    @Expose
    private String estimateRange;
    @SerializedName("disclaimer")
    @Expose
    private String disclaimer;

    public ServiceType(Integer serviceTypeId, String heading, Integer minCharge, String estimateRange, String disclaimer) {
        this.serviceTypeId = serviceTypeId;
        this.heading = heading;
        this.minCharge = minCharge;
        this.estimateRange = estimateRange;
        this.disclaimer = disclaimer;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Integer getMinCharge() {
        return minCharge;
    }

    public void setMinCharge(Integer minCharge) {
        this.minCharge = minCharge;
    }

    public String getEstimateRange() {
        return estimateRange;
    }

    public void setEstimateRange(String estimateRange) {
        this.estimateRange = estimateRange;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }
}
