
package com.example.BrowseFragmentUsingRetrofit.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cvte {

    @SerializedName("rowCount")
    @Expose
    private Integer rowCount;
    @SerializedName("rows")
    @Expose
    private List<Row> rows = null;

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

}
