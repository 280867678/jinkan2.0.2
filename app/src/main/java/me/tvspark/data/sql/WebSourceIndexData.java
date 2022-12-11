package me.tvspark.data.sql;

import android.os.Parcel;
import android.os.Parcelable;
import com.efs.sdk.base.Constants;
import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class WebSourceIndexData extends LitePalSupport implements Serializable, Parcelable, Cloneable {
    public static final Parcelable.Creator<WebSourceIndexData> CREATOR = new Parcelable.Creator<WebSourceIndexData>() { // from class: me.tvspark.data.sql.WebSourceIndexData.1
        @Override // android.os.Parcelable.Creator
        public WebSourceIndexData createFromParcel(Parcel parcel) {
            return new WebSourceIndexData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WebSourceIndexData[] newArray(int i) {
            return new WebSourceIndexData[i];
        }
    };
    public int appVer;
    public boolean customWebSource;
    public String htmlCharset;
    public String httpUserAgent;
    public String imgReferer;
    public String indexOtherCoverPrefix;
    public String indexOtherLinkPrefix;
    public String reqCharset;
    public String ruleIndex1List;
    public String ruleIndex2List;
    public String ruleIndex3List;
    public String ruleIndex4List;
    public String ruleIndexOtherActor;
    public String ruleIndexOtherCover;
    public String ruleIndexOtherLink;
    public String ruleIndexOtherNumber;
    public String ruleIndexOtherTitle;
    public String ruleSearchActor;
    public String ruleSearchCover;
    public String ruleSearchLink;
    public String ruleSearchList;
    public String ruleSearchNumber;
    public String ruleSearchTitle;
    public String searchCoverPrefix;
    public String searchLinkPrefix;
    public String searchPostData;
    public int serialNumber;
    public int version;
    public String webIndexUrl;
    public String webSearchUrl;
    public String webSourceBaseUrl;
    public String webSourceSiteName;

    public WebSourceIndexData() {
        this.webSourceBaseUrl = "";
        this.webSourceSiteName = "";
        this.httpUserAgent = "";
        this.webIndexUrl = "";
        this.imgReferer = Constants.CP_NONE;
        this.reqCharset = "";
        this.htmlCharset = "";
        this.ruleIndex1List = "";
        this.ruleIndex2List = "";
        this.ruleIndex3List = "";
        this.ruleIndex4List = "";
        this.ruleIndexOtherLink = "";
        this.indexOtherLinkPrefix = "";
        this.ruleIndexOtherTitle = "";
        this.ruleIndexOtherNumber = "";
        this.ruleIndexOtherCover = "";
        this.indexOtherCoverPrefix = "";
        this.ruleIndexOtherActor = "";
        this.webSearchUrl = "";
        this.ruleSearchList = "";
        this.ruleSearchLink = "";
        this.searchLinkPrefix = "";
        this.ruleSearchTitle = "";
        this.ruleSearchNumber = "";
        this.ruleSearchCover = "";
        this.searchCoverPrefix = "";
        this.ruleSearchActor = "";
        this.searchPostData = "";
    }

    public WebSourceIndexData(Parcel parcel) {
        this.webSourceBaseUrl = "";
        this.webSourceSiteName = "";
        this.httpUserAgent = "";
        this.webIndexUrl = "";
        this.imgReferer = Constants.CP_NONE;
        this.reqCharset = "";
        this.htmlCharset = "";
        this.ruleIndex1List = "";
        this.ruleIndex2List = "";
        this.ruleIndex3List = "";
        this.ruleIndex4List = "";
        this.ruleIndexOtherLink = "";
        this.indexOtherLinkPrefix = "";
        this.ruleIndexOtherTitle = "";
        this.ruleIndexOtherNumber = "";
        this.ruleIndexOtherCover = "";
        this.indexOtherCoverPrefix = "";
        this.ruleIndexOtherActor = "";
        this.webSearchUrl = "";
        this.ruleSearchList = "";
        this.ruleSearchLink = "";
        this.searchLinkPrefix = "";
        this.ruleSearchTitle = "";
        this.ruleSearchNumber = "";
        this.ruleSearchCover = "";
        this.searchCoverPrefix = "";
        this.ruleSearchActor = "";
        this.searchPostData = "";
        this.webSourceBaseUrl = parcel.readString();
        this.webSourceSiteName = parcel.readString();
        this.httpUserAgent = parcel.readString();
        this.serialNumber = parcel.readInt();
        this.version = parcel.readInt();
        this.appVer = parcel.readInt();
        this.webIndexUrl = parcel.readString();
        this.imgReferer = parcel.readString();
        this.reqCharset = parcel.readString();
        this.htmlCharset = parcel.readString();
        this.ruleIndex1List = parcel.readString();
        this.ruleIndex2List = parcel.readString();
        this.ruleIndex3List = parcel.readString();
        this.ruleIndex4List = parcel.readString();
        this.ruleIndexOtherLink = parcel.readString();
        this.indexOtherLinkPrefix = parcel.readString();
        this.ruleIndexOtherTitle = parcel.readString();
        this.ruleIndexOtherNumber = parcel.readString();
        this.ruleIndexOtherCover = parcel.readString();
        this.indexOtherCoverPrefix = parcel.readString();
        this.ruleIndexOtherActor = parcel.readString();
        this.webSearchUrl = parcel.readString();
        this.ruleSearchList = parcel.readString();
        this.ruleSearchLink = parcel.readString();
        this.searchLinkPrefix = parcel.readString();
        this.ruleSearchTitle = parcel.readString();
        this.ruleSearchNumber = parcel.readString();
        this.ruleSearchCover = parcel.readString();
        this.searchCoverPrefix = parcel.readString();
        this.ruleSearchActor = parcel.readString();
        this.searchPostData = parcel.readString();
        this.customWebSource = parcel.readByte() != 0;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAppVer() {
        return this.appVer;
    }

    public String getHtmlCharset() {
        return this.htmlCharset;
    }

    public String getHttpUserAgent() {
        return this.httpUserAgent;
    }

    public String getImgReferer() {
        return this.imgReferer;
    }

    public String getIndexOtherCoverPrefix() {
        return this.indexOtherCoverPrefix;
    }

    public String getIndexOtherLinkPrefix() {
        return this.indexOtherLinkPrefix;
    }

    public String getReqCharset() {
        return this.reqCharset;
    }

    public String getRuleIndex1List() {
        return this.ruleIndex1List;
    }

    public String getRuleIndex2List() {
        return this.ruleIndex2List;
    }

    public String getRuleIndex3List() {
        return this.ruleIndex3List;
    }

    public String getRuleIndex4List() {
        return this.ruleIndex4List;
    }

    public String getRuleIndexOtherActor() {
        return this.ruleIndexOtherActor;
    }

    public String getRuleIndexOtherCover() {
        return this.ruleIndexOtherCover;
    }

    public String getRuleIndexOtherLink() {
        return this.ruleIndexOtherLink;
    }

    public String getRuleIndexOtherNumber() {
        return this.ruleIndexOtherNumber;
    }

    public String getRuleIndexOtherTitle() {
        return this.ruleIndexOtherTitle;
    }

    public String getRuleSearchActor() {
        return this.ruleSearchActor;
    }

    public String getRuleSearchCover() {
        return this.ruleSearchCover;
    }

    public String getRuleSearchLink() {
        return this.ruleSearchLink;
    }

    public String getRuleSearchList() {
        return this.ruleSearchList;
    }

    public String getRuleSearchNumber() {
        return this.ruleSearchNumber;
    }

    public String getRuleSearchTitle() {
        return this.ruleSearchTitle;
    }

    public String getSearchCoverPrefix() {
        return this.searchCoverPrefix;
    }

    public String getSearchLinkPrefix() {
        return this.searchLinkPrefix;
    }

    public String getSearchPostData() {
        return this.searchPostData;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public int getVersion() {
        return this.version;
    }

    public String getWebIndexUrl() {
        return this.webIndexUrl;
    }

    public String getWebSearchUrl() {
        return this.webSearchUrl;
    }

    public String getWebSourceBaseUrl() {
        return this.webSourceBaseUrl;
    }

    public String getWebSourceSiteName() {
        return this.webSourceSiteName;
    }

    public boolean isCustomWebSource() {
        return this.customWebSource;
    }

    public void setAppVer(int i) {
        this.appVer = i;
    }

    public void setCustomWebSource(boolean z) {
        this.customWebSource = z;
    }

    public void setHtmlCharset(String str) {
        this.htmlCharset = str;
    }

    public void setHttpUserAgent(String str) {
        this.httpUserAgent = str;
    }

    public void setImgReferer(String str) {
        this.imgReferer = str;
    }

    public void setIndexOtherCoverPrefix(String str) {
        this.indexOtherCoverPrefix = str;
    }

    public void setIndexOtherLinkPrefix(String str) {
        this.indexOtherLinkPrefix = str;
    }

    public void setReqCharset(String str) {
        this.reqCharset = str;
    }

    public void setRuleIndex1List(String str) {
        this.ruleIndex1List = str;
    }

    public void setRuleIndex2List(String str) {
        this.ruleIndex2List = str;
    }

    public void setRuleIndex3List(String str) {
        this.ruleIndex3List = str;
    }

    public void setRuleIndex4List(String str) {
        this.ruleIndex4List = str;
    }

    public void setRuleIndexOtherActor(String str) {
        this.ruleIndexOtherActor = str;
    }

    public void setRuleIndexOtherCover(String str) {
        this.ruleIndexOtherCover = str;
    }

    public void setRuleIndexOtherLink(String str) {
        this.ruleIndexOtherLink = str;
    }

    public void setRuleIndexOtherNumber(String str) {
        this.ruleIndexOtherNumber = str;
    }

    public void setRuleIndexOtherTitle(String str) {
        this.ruleIndexOtherTitle = str;
    }

    public void setRuleSearchActor(String str) {
        this.ruleSearchActor = str;
    }

    public void setRuleSearchCover(String str) {
        this.ruleSearchCover = str;
    }

    public void setRuleSearchLink(String str) {
        this.ruleSearchLink = str;
    }

    public void setRuleSearchList(String str) {
        this.ruleSearchList = str;
    }

    public void setRuleSearchNumber(String str) {
        this.ruleSearchNumber = str;
    }

    public void setRuleSearchTitle(String str) {
        this.ruleSearchTitle = str;
    }

    public void setSearchCoverPrefix(String str) {
        this.searchCoverPrefix = str;
    }

    public void setSearchLinkPrefix(String str) {
        this.searchLinkPrefix = str;
    }

    public void setSearchPostData(String str) {
        this.searchPostData = str;
    }

    public void setSerialNumber(int i) {
        this.serialNumber = i;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setWebIndexUrl(String str) {
        this.webIndexUrl = str;
    }

    public void setWebSearchUrl(String str) {
        this.webSearchUrl = str;
    }

    public void setWebSourceBaseUrl(String str) {
        this.webSourceBaseUrl = str;
    }

    public void setWebSourceSiteName(String str) {
        this.webSourceSiteName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.webSourceBaseUrl);
        parcel.writeString(this.webSourceSiteName);
        parcel.writeString(this.httpUserAgent);
        parcel.writeInt(this.serialNumber);
        parcel.writeInt(this.version);
        parcel.writeInt(this.appVer);
        parcel.writeString(this.webIndexUrl);
        parcel.writeString(this.imgReferer);
        parcel.writeString(this.reqCharset);
        parcel.writeString(this.htmlCharset);
        parcel.writeString(this.ruleIndex1List);
        parcel.writeString(this.ruleIndex2List);
        parcel.writeString(this.ruleIndex3List);
        parcel.writeString(this.ruleIndex4List);
        parcel.writeString(this.ruleIndexOtherLink);
        parcel.writeString(this.indexOtherLinkPrefix);
        parcel.writeString(this.ruleIndexOtherTitle);
        parcel.writeString(this.ruleIndexOtherNumber);
        parcel.writeString(this.ruleIndexOtherCover);
        parcel.writeString(this.indexOtherCoverPrefix);
        parcel.writeString(this.ruleIndexOtherActor);
        parcel.writeString(this.webSearchUrl);
        parcel.writeString(this.ruleSearchList);
        parcel.writeString(this.ruleSearchLink);
        parcel.writeString(this.searchLinkPrefix);
        parcel.writeString(this.ruleSearchTitle);
        parcel.writeString(this.ruleSearchNumber);
        parcel.writeString(this.ruleSearchCover);
        parcel.writeString(this.searchCoverPrefix);
        parcel.writeString(this.ruleSearchActor);
        parcel.writeString(this.searchPostData);
        parcel.writeByte(this.customWebSource ? (byte) 1 : (byte) 0);
    }
}
