package com.secondwarranty.app.ResponseModel.SearchBox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("searchresultTextData")
    @Expose
    private List<SearchresultTextDatum> searchresultTextData = null;

    public Result(List<SearchresultTextDatum> searchresultTextData) {
        this.searchresultTextData = searchresultTextData;
    }

    public List<SearchresultTextDatum> getSearchresultTextData() {
        return searchresultTextData;
    }

    public void setSearchresultTextData(List<SearchresultTextDatum> searchresultTextData) {
        this.searchresultTextData = searchresultTextData;
    }
}
