
package com.example.BrowseFragmentUsingRetrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class deeplinkResponse {

    @SerializedName("appPackageName")
    @Expose
    private String appPackageName;
    @SerializedName("appDeeplink")
    @Expose
    private String appDeeplink;
    @SerializedName("appClassName")
    @Expose
    private String appClassName;
    @SerializedName("appCategory")
    @Expose
    private String appCategory;
    @SerializedName("appFlags")
    @Expose
    private List<String> appFlags = null;
    @SerializedName("appAction")
    @Expose
    private String appAction;
    @SerializedName("appExtras")
    @Expose
    private List<Object> appExtras = null;
    @SerializedName("marketPackageName")
    @Expose
    private String marketPackageName;
    @SerializedName("marketDeeplink")
    @Expose
    private String marketDeeplink;
    @SerializedName("marketClassName")
    @Expose
    private String marketClassName;
    @SerializedName("marketCategory")
    @Expose
    private String marketCategory;
    @SerializedName("marketFlags")
    @Expose
    private List<Object> marketFlags = null;
    @SerializedName("marketAction")
    @Expose
    private String marketAction;
    @SerializedName("marketExtras")
    @Expose
    private List<Object> marketExtras = null;
    @SerializedName("intentType")
    @Expose
    private String intentType;
    @SerializedName("makeDefaultIntent")
    @Expose
    private Boolean makeDefaultIntent;

    /**
     * No args constructor for use in serialization
     * 
     */
    public deeplinkResponse() {
    }

    /**
     * 
     * @param marketCategory
     * @param marketAction
     * @param appCategory
     * @param marketClassName
     * @param marketExtras
     * @param marketPackageName
     * @param appFlags
     * @param appDeeplink
     * @param intentType
     * @param marketFlags
     * @param appAction
     * @param appPackageName
     * @param appClassName
     * @param makeDefaultIntent
     * @param marketDeeplink
     * @param appExtras
     */
    public deeplinkResponse(String appPackageName, String appDeeplink, String appClassName, String appCategory, List<String> appFlags, String appAction, List<Object> appExtras, String marketPackageName, String marketDeeplink, String marketClassName, String marketCategory, List<Object> marketFlags, String marketAction, List<Object> marketExtras, String intentType, Boolean makeDefaultIntent) {
        super();
        this.appPackageName = appPackageName;
        this.appDeeplink = appDeeplink;
        this.appClassName = appClassName;
        this.appCategory = appCategory;
        this.appFlags = appFlags;
        this.appAction = appAction;
        this.appExtras = appExtras;
        this.marketPackageName = marketPackageName;
        this.marketDeeplink = marketDeeplink;
        this.marketClassName = marketClassName;
        this.marketCategory = marketCategory;
        this.marketFlags = marketFlags;
        this.marketAction = marketAction;
        this.marketExtras = marketExtras;
        this.intentType = intentType;
        this.makeDefaultIntent = makeDefaultIntent;
    }

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    public String getAppDeeplink() {
        return appDeeplink;
    }

    public void setAppDeeplink(String appDeeplink) {
        this.appDeeplink = appDeeplink;
    }

    public String getAppClassName() {
        return appClassName;
    }

    public void setAppClassName(String appClassName) {
        this.appClassName = appClassName;
    }

    public String getAppCategory() {
        return appCategory;
    }

    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }

    public List<String> getAppFlags() {
        return appFlags;
    }

    public void setAppFlags(List<String> appFlags) {
        this.appFlags = appFlags;
    }

    public String getAppAction() {
        return appAction;
    }

    public void setAppAction(String appAction) {
        this.appAction = appAction;
    }

    public List<Object> getAppExtras() {
        return appExtras;
    }

    public void setAppExtras(List<Object> appExtras) {
        this.appExtras = appExtras;
    }

    public String getMarketPackageName() {
        return marketPackageName;
    }

    public void setMarketPackageName(String marketPackageName) {
        this.marketPackageName = marketPackageName;
    }

    public String getMarketDeeplink() {
        return marketDeeplink;
    }

    public void setMarketDeeplink(String marketDeeplink) {
        this.marketDeeplink = marketDeeplink;
    }

    public String getMarketClassName() {
        return marketClassName;
    }

    public void setMarketClassName(String marketClassName) {
        this.marketClassName = marketClassName;
    }

    public String getMarketCategory() {
        return marketCategory;
    }

    public void setMarketCategory(String marketCategory) {
        this.marketCategory = marketCategory;
    }

    public List<Object> getMarketFlags() {
        return marketFlags;
    }

    public void setMarketFlags(List<Object> marketFlags) {
        this.marketFlags = marketFlags;
    }

    public String getMarketAction() {
        return marketAction;
    }

    public void setMarketAction(String marketAction) {
        this.marketAction = marketAction;
    }

    public List<Object> getMarketExtras() {
        return marketExtras;
    }

    public void setMarketExtras(List<Object> marketExtras) {
        this.marketExtras = marketExtras;
    }

    public String getIntentType() {
        return intentType;
    }

    public void setIntentType(String intentType) {
        this.intentType = intentType;
    }

    public Boolean getMakeDefaultIntent() {
        return makeDefaultIntent;
    }

    public void setMakeDefaultIntent(Boolean makeDefaultIntent) {
        this.makeDefaultIntent = makeDefaultIntent;
    }

}
