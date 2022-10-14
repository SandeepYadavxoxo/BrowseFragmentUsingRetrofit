
package com.example.BrowseFragmentUsingRetrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RowItem {

    //    @SerializedName("tileType")
//    @Expose
//    private String tileType;
//    @SerializedName("tid")
//    @Expose
//    private String tid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("portrait")
    @Expose
    private String portrait;
    //@SerializedName("background")
    //  @Expose
//    private String background;
//    @SerializedName("rating")
//    @Expose
//    private float rating;
//    @SerializedName("runtime")
//    @Expose
//    private String runtime;
//    @SerializedName("startTime")
//    @Expose
//    private Integer startTime;
//    @SerializedName("startIndex")
//    @Expose
//    private Integer startIndex;
//    @SerializedName("target")
//    @Expose
//    private List<String> target = null;
//    @SerializedName("type")
//    @Expose
//    private String type;
//    @SerializedName("useAlternate")
//    @Expose
//    private Boolean useAlternate;
//    @SerializedName("alternateUrl")
//    @Expose
//    private String alternateUrl;
//    @SerializedName("playstoreUrl")
//    @Expose
//    private String playstoreUrl;
//    @SerializedName("package")
//    @Expose
//    private String _package;
//    @SerializedName("detailPage")
//    @Expose
//    private Boolean detailPage;

    public  RowItem(){

    }
    public RowItem(String title,String poster, String portrait) {
//        this.tileType = tileType;
//        this.tid = tid;
        this.title = title;
        this.poster = poster;
        this.portrait = portrait;
//        this.background = background;
//        this.rating = rating;
//        this.runtime = runtime;
//        this.startTime = startTime;
//        this.startIndex = startIndex;
//        this.target = target;
//        this.type = type;
//        this.useAlternate = useAlternate;
//        this.alternateUrl = alternateUrl;
//        this.playstoreUrl = playstoreUrl;
//        this._package = _package;
//        this.detailPage = detailPage;
//        this.source = source;
//        this.genre = genre;
//        this.year = year;
//        this.director = director;
//        this.cast = cast;
//        this.synopsis = synopsis;
//        this.showTileInfo = showTileInfo;
//        this.tileWidth = tileWidth;
//        this.tileHeight = tileHeight;
    }

//    @SerializedName("source")
//    @Expose
//    private String source;
//    @SerializedName("genre")
//    @Expose
//    private List<String> genre = null;
//    @SerializedName("year")
//    @Expose
//    private String year;
//    @SerializedName("director")
//    @Expose
//    private List<String> director = null;
//    @SerializedName("cast")
//    @Expose
//    private List<String> cast = null;
//    @SerializedName("synopsis")
//    @Expose
//    private String synopsis;
//    @SerializedName("showTileInfo")
//    @Expose
//    private String showTileInfo;
//    @SerializedName("tileWidth")
//    @Expose
//    private String tileWidth;
//    @SerializedName("tileHeight")
//    @Expose
//    private String tileHeight;

//    public String getTileType() {
//        return tileType;
//    }
//
//    public void setTileType(String tileType) {
//        this.tileType = tileType;
//    }
//
//    public String getTid() {
//        return tid;
//    }
//
//    public void setTid(String tid) {
//        this.tid = tid;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }


    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }



//    public String getBackground() {
//        return background;
//    }
//
//    public void setBackground(String background) {
//        this.background = background;
//    }
//
//    public float getRating() {
//        return rating;
//    }
//
//    public void setRating(float rating) {
//        this.rating = rating;
//    }
//
//    public String getRuntime() {
//        return runtime;
//    }
//
//    public void setRuntime(String runtime) {
//        this.runtime = runtime;
//    }
//
//    public Integer getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(Integer startTime) {
//        this.startTime = startTime;
//    }
//
//    public Integer getStartIndex() {
//        return startIndex;
//    }
//
//    public void setStartIndex(Integer startIndex) {
//        this.startIndex = startIndex;
//    }
//
//    public List<String> getTarget() {
//        return target;
//    }
//
//    public void setTarget(List<String> target) {
//        this.target = target;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Boolean getUseAlternate() {
//        return useAlternate;
//    }
//
//    public void setUseAlternate(Boolean useAlternate) {
//        this.useAlternate = useAlternate;
//    }
//
//    public String getAlternateUrl() {
//        return alternateUrl;
//    }
//
//    public void setAlternateUrl(String alternateUrl) {
//        this.alternateUrl = alternateUrl;
//    }
//
//    public String getPlaystoreUrl() {
//        return playstoreUrl;
//    }
//
//    public void setPlaystoreUrl(String playstoreUrl) {
//        this.playstoreUrl = playstoreUrl;
//    }
//
//    public String getPackage() {
//        return _package;
//    }
//
//    public void setPackage(String _package) {
//        this._package = _package;
//    }
//
//    public Boolean getDetailPage() {
//        return detailPage;
//    }
//
//    public void setDetailPage(Boolean detailPage) {
//        this.detailPage = detailPage;
//    }

//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }
//
//    public List<String> getGenre() {
//        return genre;
//    }
//
//    public void setGenre(List<String> genre) {
//        this.genre = genre;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//    public List<String> getDirector() {
//        return director;
//    }
//
//    public void setDirector(List<String> director) {
//        this.director = director;
//    }
//
//    public List<String> getCast() {
//        return cast;
//    }
//
//    public void setCast(List<String> cast) {
//        this.cast = cast;
//    }
//
//    public String getSynopsis() {
//        return synopsis;
//    }
//
//    public void setSynopsis(String synopsis) {
//        this.synopsis = synopsis;
//    }
//
//    public String getShowTileInfo() {
//        return showTileInfo;
//    }
//
//    public void setShowTileInfo(String showTileInfo) {
//        this.showTileInfo = showTileInfo;
//    }
//
//    public String getTileWidth() {
//        return tileWidth;
//    }
//
//    public void setTileWidth(String tileWidth) {
//        this.tileWidth = tileWidth;
//    }
//
//    public String getTileHeight() {
//        return tileHeight;
//    }
//
//    public void setTileHeight(String tileHeight) {
//        this.tileHeight = tileHeight;
//    }

}
