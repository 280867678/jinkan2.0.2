package me.tvspark.data.sql;

import com.efs.sdk.base.Constants;
import java.io.Serializable;
import me.tvspark.outline;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class WebSourceSeasonData extends LitePalSupport implements Serializable, Cloneable, sk0 {
    public static String cntvEpLinkPre = "https://vdn.apps.cntv.cn/api/getHttpVideoInfo.do?pid=";
    public boolean customWebSource;
    public boolean episoeListReverse;
    public int serialNumber;
    public boolean useWebViewReq;
    public int version;
    public String webSourceBaseUrl = "";
    public String webSourceSiteName = "";
    public String httpUserAgent = "";
    public String imgReferer = Constants.CP_NONE;
    public String ruleSeasonCover = "";
    public String ruleSeasonCoverPrefix = "";
    public String ruleSeasonTitle = "";
    public String ruleSeasonInfoList = "";
    public String ruleSeasonDesc = "";
    public String ruleChannelList = "";
    public String ruleEpisodeList = "";
    public String ruleEpisodeLink = "";
    public String ruleEpisodeLinkPrefix = "";
    public String ruleEpisodeName = "";
    public String ruleDownloadList = "";
    public String ruleDownloadLink = "";
    public String ruleDownloadLinkPrefix = "";
    public String ruleDownloadName = "";

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public WebSourceSeasonData getCNTVWebSource() {
        this.webSourceSiteName = "高清专区";
        this.httpUserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36";
        this.webSourceBaseUrl = "https://api.cntv.cn/";
        this.ruleEpisodeList = "$.data.list.*";
        this.ruleEpisodeName = "$.title";
        this.ruleEpisodeLink = "$.guid";
        this.ruleEpisodeLinkPrefix = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), cntvEpLinkPre, "{id}");
        return this;
    }

    public String getHttpUserAgent() {
        return this.httpUserAgent;
    }

    public String getImgReferer() {
        return this.imgReferer;
    }

    public String getRuleChannelList() {
        return this.ruleChannelList;
    }

    public String getRuleDownloadLink() {
        return this.ruleDownloadLink;
    }

    public String getRuleDownloadLinkPrefix() {
        return this.ruleDownloadLinkPrefix;
    }

    public String getRuleDownloadList() {
        return this.ruleDownloadList;
    }

    public String getRuleDownloadName() {
        return this.ruleDownloadName;
    }

    public String getRuleEpisodeLink() {
        return this.ruleEpisodeLink;
    }

    public String getRuleEpisodeLinkPrefix() {
        return this.ruleEpisodeLinkPrefix;
    }

    public String getRuleEpisodeList() {
        return this.ruleEpisodeList;
    }

    public String getRuleEpisodeName() {
        return this.ruleEpisodeName;
    }

    public String getRuleSeasonCover() {
        return this.ruleSeasonCover;
    }

    public String getRuleSeasonCoverPrefix() {
        return this.ruleSeasonCoverPrefix;
    }

    public String getRuleSeasonDesc() {
        return this.ruleSeasonDesc;
    }

    public String getRuleSeasonInfoList() {
        return this.ruleSeasonInfoList;
    }

    public String getRuleSeasonTitle() {
        return this.ruleSeasonTitle;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public int getVersion() {
        return this.version;
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

    public boolean isEpisoeListReverse() {
        return this.episoeListReverse;
    }

    public boolean isUseWebViewReq() {
        return this.useWebViewReq;
    }

    public void setCustomWebSource(boolean z) {
        this.customWebSource = z;
    }

    public void setEpisoeListReverse(boolean z) {
        this.episoeListReverse = z;
    }

    public void setHttpUserAgent(String str) {
        this.httpUserAgent = str;
    }

    public void setImgReferer(String str) {
        this.imgReferer = str;
    }

    public void setRuleChannelList(String str) {
        this.ruleChannelList = str;
    }

    public void setRuleDownloadLink(String str) {
        this.ruleDownloadLink = str;
    }

    public void setRuleDownloadLinkPrefix(String str) {
        this.ruleDownloadLinkPrefix = str;
    }

    public void setRuleDownloadList(String str) {
        this.ruleDownloadList = str;
    }

    public void setRuleDownloadName(String str) {
        this.ruleDownloadName = str;
    }

    public void setRuleEpisodeLink(String str) {
        this.ruleEpisodeLink = str;
    }

    public void setRuleEpisodeLinkPrefix(String str) {
        this.ruleEpisodeLinkPrefix = str;
    }

    public void setRuleEpisodeList(String str) {
        this.ruleEpisodeList = str;
    }

    public void setRuleEpisodeName(String str) {
        this.ruleEpisodeName = str;
    }

    public void setRuleSeasonCover(String str) {
        this.ruleSeasonCover = str;
    }

    public void setRuleSeasonCoverPrefix(String str) {
        this.ruleSeasonCoverPrefix = str;
    }

    public void setRuleSeasonDesc(String str) {
        this.ruleSeasonDesc = str;
    }

    public void setRuleSeasonInfoList(String str) {
        this.ruleSeasonInfoList = str;
    }

    public void setRuleSeasonTitle(String str) {
        this.ruleSeasonTitle = str;
    }

    public void setSerialNumber(int i) {
        this.serialNumber = i;
    }

    public void setUseWebViewReq(boolean z) {
        this.useWebViewReq = z;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setWebSourceBaseUrl(String str) {
        this.webSourceBaseUrl = str;
    }

    public void setWebSourceSiteName(String str) {
        this.webSourceSiteName = str;
    }
}
