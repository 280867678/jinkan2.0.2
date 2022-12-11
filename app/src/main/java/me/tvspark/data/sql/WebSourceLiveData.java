package me.tvspark.data.sql;

import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class WebSourceLiveData extends LitePalSupport implements Serializable, Cloneable {
    public int serialNumber;
    public int version;
    public String webSourceBaseUrl = "";
    public String webSourceSiteName = "";
    public String httpUserAgent = "";
    public boolean allGeted = false;
    public String chartsetName = "";
    public String ruleChannelList = "";
    public String ruleChildList = "";
    public String channelUrlPrefix = "";
    public String ruleChannelUrl = "";
    public String ruleChannelName = "";
    public String ruleChildUrlPrefix = "";
    public String ruleChildUrl = "";
    public String ruleChildName = "";

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getChannelUrlPrefix() {
        return this.channelUrlPrefix;
    }

    public String getChartsetName() {
        return this.chartsetName;
    }

    public String getHttpUserAgent() {
        return this.httpUserAgent;
    }

    public String getRuleChannelList() {
        return this.ruleChannelList;
    }

    public String getRuleChannelName() {
        return this.ruleChannelName;
    }

    public String getRuleChannelUrl() {
        return this.ruleChannelUrl;
    }

    public String getRuleChildList() {
        return this.ruleChildList;
    }

    public String getRuleChildName() {
        return this.ruleChildName;
    }

    public String getRuleChildUrl() {
        return this.ruleChildUrl;
    }

    public String getRuleChildUrlPrefix() {
        return this.ruleChildUrlPrefix;
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

    public boolean isAllGeted() {
        return this.allGeted;
    }

    public void setAllGeted(boolean z) {
        this.allGeted = z;
    }

    public void setChannelUrlPrefix(String str) {
        this.channelUrlPrefix = str;
    }

    public void setChartsetName(String str) {
        this.chartsetName = str;
    }

    public void setHttpUserAgent(String str) {
        this.httpUserAgent = str;
    }

    public void setRuleChannelList(String str) {
        this.ruleChannelList = str;
    }

    public void setRuleChannelName(String str) {
        this.ruleChannelName = str;
    }

    public void setRuleChannelUrl(String str) {
        this.ruleChannelUrl = str;
    }

    public void setRuleChildList(String str) {
        this.ruleChildList = str;
    }

    public void setRuleChildName(String str) {
        this.ruleChildName = str;
    }

    public void setRuleChildUrl(String str) {
        this.ruleChildUrl = str;
    }

    public void setRuleChildUrlPrefix(String str) {
        this.ruleChildUrlPrefix = str;
    }

    public void setSerialNumber(int i) {
        this.serialNumber = i;
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
