package me.tvspark.data.sql;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import me.tvspark.co0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.utils.SKUtils;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class WebSourceTitaData extends LitePalSupport implements Serializable, Parcelable, Cloneable {
    public static final Parcelable.Creator<WebSourceTitaData> CREATOR = new Parcelable.Creator<WebSourceTitaData>() { // from class: me.tvspark.data.sql.WebSourceTitaData.1
        @Override // android.os.Parcelable.Creator
        public WebSourceTitaData createFromParcel(Parcel parcel) {
            return new WebSourceTitaData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WebSourceTitaData[] newArray(int i) {
            return new WebSourceTitaData[i];
        }
    };
    public String baseUrl;
    public String htmlCharset;
    public String indexCoverPrefix;
    public String indexLinkPrefix;
    public String name;
    public String reqCharset;
    public boolean reqDetailByWebView;
    public String reqType;
    public String resultCoverPrefix;
    public String resultLinkPrefix;
    public String ruleChannelGroups;
    public String ruleDetailCover;
    public String ruleDetailCoverPrefix;
    public String ruleDetailIntro;
    public String ruleEpLink;
    public String ruleEpLinkPrefix;
    public String ruleEpListM3u8;
    public String ruleEpTitle;
    public String ruleIndex1List;
    public String ruleIndex2List;
    public String ruleIndex3List;
    public String ruleIndex4List;
    public String ruleIndexActor;
    public String ruleIndexCover;
    public String ruleIndexLink;
    public String ruleIndexTitle;
    public String ruleResultArea;
    public String ruleResultCover;
    public String ruleResultLink;
    public String ruleResultList;
    public String ruleResultTitle;
    public String ruleResultType;
    public String searchPostData;
    public String searchUrl;
    public int serialNumber;
    public long sortTime;
    public String userAgent;
    public String webIndexUrl;

    public WebSourceTitaData() {
        this.name = "";
        this.serialNumber = 1;
        this.reqType = "";
        this.reqCharset = "";
        this.htmlCharset = "";
        this.userAgent = "";
        this.baseUrl = "";
        this.searchUrl = "";
        this.searchPostData = "";
        this.ruleResultList = "";
        this.ruleResultLink = "";
        this.resultLinkPrefix = "";
        this.ruleResultCover = "";
        this.resultCoverPrefix = "";
        this.webIndexUrl = "";
        this.ruleIndex1List = "";
        this.ruleIndex2List = "";
        this.ruleIndex3List = "";
        this.ruleIndex4List = "";
        this.ruleIndexLink = "";
        this.indexLinkPrefix = "";
        this.ruleIndexTitle = "";
        this.ruleIndexCover = "";
        this.indexCoverPrefix = "";
        this.ruleIndexActor = "";
        this.ruleResultTitle = "";
        this.ruleResultArea = "";
        this.ruleResultType = "";
        this.reqDetailByWebView = false;
        this.ruleDetailCover = "";
        this.ruleDetailCoverPrefix = "";
        this.ruleDetailIntro = "";
        this.ruleEpListM3u8 = "";
        this.ruleEpTitle = "";
        this.ruleEpLink = "";
        this.ruleEpLinkPrefix = "";
        this.ruleChannelGroups = "";
        this.sortTime = 0L;
    }

    public WebSourceTitaData(Parcel parcel) {
        this.name = "";
        boolean z = true;
        this.serialNumber = 1;
        this.reqType = "";
        this.reqCharset = "";
        this.htmlCharset = "";
        this.userAgent = "";
        this.baseUrl = "";
        this.searchUrl = "";
        this.searchPostData = "";
        this.ruleResultList = "";
        this.ruleResultLink = "";
        this.resultLinkPrefix = "";
        this.ruleResultCover = "";
        this.resultCoverPrefix = "";
        this.webIndexUrl = "";
        this.ruleIndex1List = "";
        this.ruleIndex2List = "";
        this.ruleIndex3List = "";
        this.ruleIndex4List = "";
        this.ruleIndexLink = "";
        this.indexLinkPrefix = "";
        this.ruleIndexTitle = "";
        this.ruleIndexCover = "";
        this.indexCoverPrefix = "";
        this.ruleIndexActor = "";
        this.ruleResultTitle = "";
        this.ruleResultArea = "";
        this.ruleResultType = "";
        this.reqDetailByWebView = false;
        this.ruleDetailCover = "";
        this.ruleDetailCoverPrefix = "";
        this.ruleDetailIntro = "";
        this.ruleEpListM3u8 = "";
        this.ruleEpTitle = "";
        this.ruleEpLink = "";
        this.ruleEpLinkPrefix = "";
        this.ruleChannelGroups = "";
        this.sortTime = 0L;
        this.name = parcel.readString();
        this.serialNumber = parcel.readInt();
        this.reqType = parcel.readString();
        this.reqCharset = parcel.readString();
        this.htmlCharset = parcel.readString();
        this.userAgent = parcel.readString();
        this.baseUrl = parcel.readString();
        this.searchUrl = parcel.readString();
        this.searchPostData = parcel.readString();
        this.ruleResultList = parcel.readString();
        this.ruleResultLink = parcel.readString();
        this.resultLinkPrefix = parcel.readString();
        this.ruleResultCover = parcel.readString();
        this.resultCoverPrefix = parcel.readString();
        this.webIndexUrl = parcel.readString();
        this.ruleIndex1List = parcel.readString();
        this.ruleIndex2List = parcel.readString();
        this.ruleIndex3List = parcel.readString();
        this.ruleIndex4List = parcel.readString();
        this.ruleIndexLink = parcel.readString();
        this.indexLinkPrefix = parcel.readString();
        this.ruleIndexTitle = parcel.readString();
        this.ruleIndexCover = parcel.readString();
        this.indexCoverPrefix = parcel.readString();
        this.ruleIndexActor = parcel.readString();
        this.ruleResultTitle = parcel.readString();
        this.ruleResultArea = parcel.readString();
        this.ruleResultType = parcel.readString();
        this.reqDetailByWebView = parcel.readByte() == 0 ? false : z;
        this.ruleDetailCover = parcel.readString();
        this.ruleDetailCoverPrefix = parcel.readString();
        this.ruleDetailIntro = parcel.readString();
        this.ruleEpListM3u8 = parcel.readString();
        this.ruleEpTitle = parcel.readString();
        this.ruleEpLink = parcel.readString();
        this.ruleEpLinkPrefix = parcel.readString();
        this.ruleChannelGroups = parcel.readString();
        this.sortTime = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getHtmlCharset() {
        return this.htmlCharset;
    }

    public String getIndexCoverPrefix() {
        return this.indexCoverPrefix;
    }

    public String getIndexLinkPrefix() {
        return this.indexLinkPrefix;
    }

    public String getName() {
        return this.name;
    }

    public String getReqCharset() {
        return this.reqCharset;
    }

    public String getReqType() {
        return this.reqType;
    }

    public String getResultCoverPrefix() {
        return this.resultCoverPrefix;
    }

    public String getResultLinkPrefix() {
        return this.resultLinkPrefix;
    }

    public String getRuleChannelGroups() {
        return this.ruleChannelGroups;
    }

    public String getRuleDetailCover() {
        return this.ruleDetailCover;
    }

    public String getRuleDetailCoverPrefix() {
        return this.ruleDetailCoverPrefix;
    }

    public String getRuleDetailIntro() {
        return this.ruleDetailIntro;
    }

    public String getRuleEpLink() {
        return this.ruleEpLink;
    }

    public String getRuleEpLinkPrefix() {
        return this.ruleEpLinkPrefix;
    }

    public String getRuleEpListM3u8() {
        return this.ruleEpListM3u8;
    }

    public String getRuleEpTitle() {
        return this.ruleEpTitle;
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

    public String getRuleIndexActor() {
        return this.ruleIndexActor;
    }

    public String getRuleIndexCover() {
        return this.ruleIndexCover;
    }

    public String getRuleIndexLink() {
        return this.ruleIndexLink;
    }

    public String getRuleIndexTitle() {
        return this.ruleIndexTitle;
    }

    public String getRuleResultArea() {
        return this.ruleResultArea;
    }

    public String getRuleResultCover() {
        return this.ruleResultCover;
    }

    public String getRuleResultLink() {
        return this.ruleResultLink;
    }

    public String getRuleResultList() {
        return this.ruleResultList;
    }

    public String getRuleResultTitle() {
        return this.ruleResultTitle;
    }

    public String getRuleResultType() {
        return this.ruleResultType;
    }

    public String getSearchPostData() {
        return this.searchPostData;
    }

    public String getSearchUrl() {
        return this.searchUrl;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public long getSortTime() {
        return this.sortTime;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getWebIndexUrl() {
        return this.webIndexUrl;
    }

    public boolean isReqDetailByWebView() {
        return this.reqDetailByWebView;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setCustomWebSourceSData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, boolean z, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34) {
        this.name = str;
        this.serialNumber = Integer.valueOf(str2).intValue();
        this.reqType = str3;
        this.reqCharset = str4;
        this.htmlCharset = str5;
        this.userAgent = str6;
        this.baseUrl = str7;
        this.searchUrl = str8;
        this.searchPostData = str9;
        this.ruleResultList = str10;
        this.ruleResultLink = str11;
        this.resultLinkPrefix = str12;
        this.ruleResultCover = str13;
        this.resultCoverPrefix = str14;
        this.webIndexUrl = str15;
        this.ruleIndex1List = str16;
        this.ruleIndex2List = str17;
        this.ruleIndex3List = str18;
        this.ruleIndex4List = str19;
        this.ruleIndexLink = str20;
        this.indexLinkPrefix = str21;
        this.ruleIndexTitle = str22;
        this.ruleIndexCover = str23;
        this.indexCoverPrefix = str24;
        this.ruleIndexActor = str25;
        this.ruleResultTitle = str26;
        this.reqDetailByWebView = z;
        this.ruleDetailCover = str27;
        this.ruleDetailCoverPrefix = str28;
        this.ruleDetailIntro = str29;
        this.ruleChannelGroups = str30;
        this.ruleEpListM3u8 = str31;
        this.ruleEpTitle = str32;
        this.ruleEpLink = str33;
        this.ruleEpLinkPrefix = str34;
    }

    public void setHtmlCharset(String str) {
        this.htmlCharset = str;
    }

    public void setIndexCoverPrefix(String str) {
        this.indexCoverPrefix = str;
    }

    public void setIndexLinkPrefix(String str) {
        this.indexLinkPrefix = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReqCharset(String str) {
        this.reqCharset = str;
    }

    public void setReqDetailByWebView(boolean z) {
        this.reqDetailByWebView = z;
    }

    public void setReqType(String str) {
        this.reqType = str;
    }

    public void setResultCoverPrefix(String str) {
        this.resultCoverPrefix = str;
    }

    public void setResultLinkPrefix(String str) {
        this.resultLinkPrefix = str;
    }

    public void setRuleChannelGroups(String str) {
        this.ruleChannelGroups = str;
    }

    public void setRuleDetailCover(String str) {
        this.ruleDetailCover = str;
    }

    public void setRuleDetailCoverPrefix(String str) {
        this.ruleDetailCoverPrefix = str;
    }

    public void setRuleDetailIntro(String str) {
        this.ruleDetailIntro = str;
    }

    public void setRuleEpLink(String str) {
        this.ruleEpLink = str;
    }

    public void setRuleEpLinkPrefix(String str) {
        this.ruleEpLinkPrefix = str;
    }

    public void setRuleEpListM3u8(String str) {
        this.ruleEpListM3u8 = str;
    }

    public void setRuleEpTitle(String str) {
        this.ruleEpTitle = str;
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

    public void setRuleIndexActor(String str) {
        this.ruleIndexActor = str;
    }

    public void setRuleIndexCover(String str) {
        this.ruleIndexCover = str;
    }

    public void setRuleIndexLink(String str) {
        this.ruleIndexLink = str;
    }

    public void setRuleIndexTitle(String str) {
        this.ruleIndexTitle = str;
    }

    public void setRuleResultArea(String str) {
        this.ruleResultArea = str;
    }

    public void setRuleResultCover(String str) {
        this.ruleResultCover = str;
    }

    public void setRuleResultLink(String str) {
        this.ruleResultLink = str;
    }

    public void setRuleResultList(String str) {
        this.ruleResultList = str;
    }

    public void setRuleResultTitle(String str) {
        this.ruleResultTitle = str;
    }

    public void setRuleResultType(String str) {
        this.ruleResultType = str;
    }

    public void setSearchPostData(String str) {
        this.searchPostData = str;
    }

    public void setSearchUrl(String str) {
        this.searchUrl = str;
    }

    public void setSerialNumber(int i) {
        this.serialNumber = i;
    }

    public void setSortTime(long j) {
        this.sortTime = j;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public void setWebIndexUrl(String str) {
        this.webIndexUrl = str;
    }

    public String toCustomJson() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("{\"name\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.name, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"serialNumber\": \"");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.serialNumber);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\",\"reqType\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.reqType, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"reqCharset\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.reqCharset, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"htmlCharset\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.htmlCharset, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"userAgent\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.userAgent, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"baseUrl\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.baseUrl, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"searchUrl\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.searchUrl, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"searchPostData\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.searchPostData, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleResultList\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleResultList, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleResultLink\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleResultLink, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"resultLinkPrefix\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.resultLinkPrefix, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleResultCover\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleResultCover, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"resultCoverPrefix\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.resultCoverPrefix, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"webIndexUrl\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.webIndexUrl, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleIndex1List\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleIndex1List, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleIndex2List\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleIndex2List, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleIndex3List\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleIndex3List, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleIndex4List\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleIndex4List, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleIndexLink\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleIndexLink, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"indexLinkPrefix\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.indexLinkPrefix, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleIndexTitle\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleIndexTitle, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleIndexCover\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleIndexCover, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"indexCoverPrefix\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.indexCoverPrefix, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleIndexActor\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleIndexActor, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleResultTitle\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleResultTitle, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"reqDetailByWebView\": ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.reqDetailByWebView);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",\"ruleDetailCover\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleDetailCover, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleDetailCoverPrefix\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleDetailCoverPrefix, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleDetailIntro\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleDetailIntro, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleChannelGroups\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleChannelGroups, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleEpListM3u8\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleEpListM3u8, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleEpTitle\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleEpTitle, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleEpLink\": \"");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleEpLink, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "\",\"ruleEpLinkPrefix\": \"");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.ruleEpLinkPrefix));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\"}");
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()));
    }

    public WebSourceIndexData trans2WebSourceIndexData() {
        WebSourceIndexData webSourceIndexData = new WebSourceIndexData();
        webSourceIndexData.setCustomWebSource(true);
        webSourceIndexData.setWebSourceBaseUrl(this.baseUrl);
        webSourceIndexData.setWebSourceSiteName(this.name);
        webSourceIndexData.setHttpUserAgent(this.userAgent);
        webSourceIndexData.setSerialNumber(this.serialNumber);
        webSourceIndexData.setWebIndexUrl(this.webIndexUrl);
        webSourceIndexData.setReqCharset(this.reqCharset);
        webSourceIndexData.setHtmlCharset(this.htmlCharset);
        webSourceIndexData.setRuleIndex1List(this.ruleIndex1List);
        webSourceIndexData.setRuleIndex2List(this.ruleIndex2List);
        webSourceIndexData.setRuleIndex3List(this.ruleIndex3List);
        webSourceIndexData.setRuleIndex4List(this.ruleIndex4List);
        webSourceIndexData.setRuleIndexOtherCover(this.ruleIndexCover);
        webSourceIndexData.setIndexOtherCoverPrefix(this.indexCoverPrefix);
        webSourceIndexData.setRuleIndexOtherLink(this.ruleIndexLink);
        webSourceIndexData.setIndexOtherLinkPrefix(this.indexLinkPrefix);
        webSourceIndexData.setRuleIndexOtherTitle(this.ruleIndexTitle);
        webSourceIndexData.setRuleIndexOtherActor(this.ruleIndexActor);
        webSourceIndexData.setWebSearchUrl(this.searchUrl);
        webSourceIndexData.setRuleSearchList(this.ruleResultList);
        webSourceIndexData.setRuleSearchLink(this.ruleResultLink);
        webSourceIndexData.setSearchLinkPrefix(this.resultLinkPrefix);
        webSourceIndexData.setRuleSearchTitle(this.ruleResultTitle);
        webSourceIndexData.setRuleSearchNumber(this.ruleResultArea);
        webSourceIndexData.setRuleSearchCover(this.ruleResultCover);
        webSourceIndexData.setSearchCoverPrefix(this.resultCoverPrefix);
        webSourceIndexData.setRuleSearchActor(this.ruleResultType);
        webSourceIndexData.setSearchPostData(this.searchPostData);
        return webSourceIndexData;
    }

    public WebSourceSeasonData trans2WebSourceSeasonData() {
        WebSourceSeasonData webSourceSeasonData = new WebSourceSeasonData();
        webSourceSeasonData.setCustomWebSource(true);
        webSourceSeasonData.setWebSourceBaseUrl(this.baseUrl);
        webSourceSeasonData.setWebSourceSiteName(this.name);
        webSourceSeasonData.setHttpUserAgent(this.userAgent);
        webSourceSeasonData.setSerialNumber(this.serialNumber);
        webSourceSeasonData.setUseWebViewReq(this.reqDetailByWebView);
        webSourceSeasonData.setRuleSeasonCover(this.ruleDetailCover);
        webSourceSeasonData.setRuleSeasonCoverPrefix(this.ruleDetailCoverPrefix);
        webSourceSeasonData.setRuleSeasonDesc(this.ruleDetailIntro);
        webSourceSeasonData.setRuleChannelList(this.ruleChannelGroups);
        webSourceSeasonData.setRuleEpisodeList(this.ruleEpListM3u8);
        webSourceSeasonData.setRuleEpisodeLink(this.ruleEpLink);
        webSourceSeasonData.setRuleEpisodeLinkPrefix(this.ruleEpLinkPrefix);
        webSourceSeasonData.setRuleEpisodeName(this.ruleEpTitle);
        return webSourceSeasonData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.serialNumber);
        parcel.writeString(this.reqType);
        parcel.writeString(this.reqCharset);
        parcel.writeString(this.htmlCharset);
        parcel.writeString(this.userAgent);
        parcel.writeString(this.baseUrl);
        parcel.writeString(this.searchUrl);
        parcel.writeString(this.searchPostData);
        parcel.writeString(this.ruleResultList);
        parcel.writeString(this.ruleResultLink);
        parcel.writeString(this.resultLinkPrefix);
        parcel.writeString(this.ruleResultCover);
        parcel.writeString(this.resultCoverPrefix);
        parcel.writeString(this.webIndexUrl);
        parcel.writeString(this.ruleIndex1List);
        parcel.writeString(this.ruleIndex2List);
        parcel.writeString(this.ruleIndex3List);
        parcel.writeString(this.ruleIndex4List);
        parcel.writeString(this.ruleIndexLink);
        parcel.writeString(this.indexLinkPrefix);
        parcel.writeString(this.ruleIndexTitle);
        parcel.writeString(this.ruleIndexCover);
        parcel.writeString(this.indexCoverPrefix);
        parcel.writeString(this.ruleIndexActor);
        parcel.writeString(this.ruleResultTitle);
        parcel.writeString(this.ruleResultArea);
        parcel.writeString(this.ruleResultType);
        parcel.writeByte(this.reqDetailByWebView ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ruleDetailCover);
        parcel.writeString(this.ruleDetailCoverPrefix);
        parcel.writeString(this.ruleDetailIntro);
        parcel.writeString(this.ruleEpListM3u8);
        parcel.writeString(this.ruleEpTitle);
        parcel.writeString(this.ruleEpLink);
        parcel.writeString(this.ruleEpLinkPrefix);
        parcel.writeString(this.ruleChannelGroups);
        parcel.writeLong(this.sortTime);
    }
}
