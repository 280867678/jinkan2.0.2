package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class VersionParcel implements Serializable {
    public boolean bweb;
    public int needUpdateWebsourceApkVersion;
    public int ruleCategoryVersion;
    public int ruleDownloadVersion;
    public int ruleIndexVersion;
    public int ruleLiveVersion;
    public int ruleSeasonVersion;
    public String latestVersionName = "";
    public int latestVersionCode = 0;
    public String downloadUrl = "";
    public boolean forceUpdate = false;
    public String shareUrl = "";
    public String changelog = "";
    public int ad_type = 0;
    public int data_type = 0;
    public String data_url = "";
    public String data_pic = "";
    public String banner_url = "";
    public String banner_pic = "";
    public String hostIndex = "";
    public List<String> bWords = new ArrayList();
    public int nFlag = 0;
    public String nContent = "";
    public String noticeUrl = "";
    public String nType = "wok";
    public boolean isGoWebPlay = false;
    public String ruleIndexRecVersion = "";
    public String mianze = "";
    public String titaUrl = "";

    /* renamed from: dn */
    public String f4518dn = "";
    public String dnu = "";
    public String marqueeTxt = "";
    public String marqueeUrl = "";

    public int getAd_type() {
        return this.ad_type;
    }

    public String getBanner_pic() {
        return this.banner_pic;
    }

    public String getBanner_url() {
        return this.banner_url;
    }

    public String getChangelog() {
        return this.changelog;
    }

    public String getData_pic() {
        return this.data_pic;
    }

    public int getData_type() {
        return this.data_type;
    }

    public String getData_url() {
        return this.data_url;
    }

    public String getDn() {
        return this.f4518dn;
    }

    public String getDnu() {
        return this.dnu;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getHostIndex() {
        return this.hostIndex;
    }

    public int getLatestVersionCode() {
        return this.latestVersionCode;
    }

    public String getLatestVersionName() {
        return this.latestVersionName;
    }

    public String getMarqueeTxt() {
        return this.marqueeTxt;
    }

    public String getMarqueeUrl() {
        return this.marqueeUrl;
    }

    public String getMianze() {
        return this.mianze;
    }

    public int getNeedUpdateWebsourceApkVersion() {
        return this.needUpdateWebsourceApkVersion;
    }

    public String getNoticeUrl() {
        return this.noticeUrl;
    }

    public int getRuleCategoryVersion() {
        return this.ruleCategoryVersion;
    }

    public int getRuleDownloadVersion() {
        return this.ruleDownloadVersion;
    }

    public String getRuleIndexRecVersion() {
        return this.ruleIndexRecVersion;
    }

    public int getRuleIndexVersion() {
        return this.ruleIndexVersion;
    }

    public int getRuleLiveVersion() {
        return this.ruleLiveVersion;
    }

    public int getRuleSeasonVersion() {
        return this.ruleSeasonVersion;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getTitaUrl() {
        return this.titaUrl;
    }

    public List<String> getbWords() {
        return this.bWords;
    }

    public String getnContent() {
        return this.nContent;
    }

    public int getnFlag() {
        return this.nFlag;
    }

    public String getnType() {
        return this.nType;
    }

    public boolean isBweb() {
        return this.bweb;
    }

    public boolean isForceUpdate() {
        return this.forceUpdate;
    }

    public boolean isGoWebPlay() {
        return this.isGoWebPlay;
    }

    public void setAd_type(int i) {
        this.ad_type = i;
    }

    public void setBanner_pic(String str) {
        this.banner_pic = str;
    }

    public void setBanner_url(String str) {
        this.banner_url = str;
    }

    public void setBweb(boolean z) {
        this.bweb = z;
    }

    public void setChangelog(String str) {
        this.changelog = str;
    }

    public void setData_pic(String str) {
        this.data_pic = str;
    }

    public void setData_type(int i) {
        this.data_type = i;
    }

    public void setData_url(String str) {
        this.data_url = str;
    }

    public void setDn(String str) {
        this.f4518dn = str;
    }

    public void setDnu(String str) {
        this.dnu = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setForceUpdate(boolean z) {
        this.forceUpdate = z;
    }

    public void setGoWebPlay(boolean z) {
        this.isGoWebPlay = z;
    }

    public void setHostIndex(String str) {
        this.hostIndex = str;
    }

    public void setLatestVersionCode(int i) {
        this.latestVersionCode = i;
    }

    public void setLatestVersionName(String str) {
        this.latestVersionName = str;
    }

    public void setMarqueeTxt(String str) {
        this.marqueeTxt = str;
    }

    public void setMarqueeUrl(String str) {
        this.marqueeUrl = str;
    }

    public void setMianze(String str) {
        this.mianze = str;
    }

    public void setNeedUpdateWebsourceApkVersion(int i) {
        this.needUpdateWebsourceApkVersion = i;
    }

    public void setNoticeUrl(String str) {
        this.noticeUrl = str;
    }

    public void setRuleCategoryVersion(int i) {
        this.ruleCategoryVersion = i;
    }

    public void setRuleDownloadVersion(int i) {
        this.ruleDownloadVersion = i;
    }

    public void setRuleIndexRecVersion(String str) {
        this.ruleIndexRecVersion = str;
    }

    public void setRuleIndexVersion(int i) {
        this.ruleIndexVersion = i;
    }

    public void setRuleLiveVersion(int i) {
        this.ruleLiveVersion = i;
    }

    public void setRuleSeasonVersion(int i) {
        this.ruleSeasonVersion = i;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setTitaUrl(String str) {
        this.titaUrl = str;
    }

    public void setbWords(List<String> list) {
        this.bWords = list;
    }

    public void setnContent(String str) {
        this.nContent = str;
    }

    public void setnFlag(int i) {
        this.nFlag = i;
    }

    public void setnType(String str) {
        this.nType = str;
    }
}
