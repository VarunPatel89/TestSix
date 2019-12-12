package com.app.myapplication.network.requestmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClsGetListRequest
{
    @SerializedName("SearchText")
    @Expose
    private String searchText;

    public String getSearchText()
    {
        return searchText;
    }

    public void setSearchText(String searchText)
    {
        this.searchText = searchText;
    }

}