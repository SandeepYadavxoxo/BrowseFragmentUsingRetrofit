
package com.example.BrowseFragmentUsingRetrofit.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

    @SerializedName("rowIndex")
    @Expose
    private Integer rowIndex;
    @SerializedName("rowHeader")
    @Expose
    private String rowHeader;
    @SerializedName("rowLayout")
    @Expose
    private String rowLayout;
    @SerializedName("rowItems")
    @Expose
    private List<RowItem> rowItems = null;

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getRowHeader() {
        return rowHeader;
    }

    public void setRowHeader(String rowHeader) {
        this.rowHeader = rowHeader;
    }

    public String getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(String rowLayout) {
        this.rowLayout = rowLayout;
    }

    public List<RowItem> getRowItems() {
        return rowItems;
    }

    public void setRowItems(List<RowItem> rowItems) {
        this.rowItems = rowItems;
    }

}
