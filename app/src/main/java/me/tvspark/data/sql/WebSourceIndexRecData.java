package me.tvspark.data.sql;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class WebSourceIndexRecData extends LitePalSupport implements Cloneable, Parcelable {
    public static final Parcelable.Creator<WebSourceIndexRecData> CREATOR = new Parcelable.Creator<WebSourceIndexRecData>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.9
        @Override // android.os.Parcelable.Creator
        public WebSourceIndexRecData createFromParcel(Parcel parcel) {
            return new WebSourceIndexRecData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WebSourceIndexRecData[] newArray(int i) {
            return new WebSourceIndexRecData[i];
        }
    };
    public String animRankTitle;
    public String animRankUrl;
    public String animTitle;
    public String animTypeJson;
    public String animTypeJsonMore;
    public String animUrlJsonMore;
    public String artRankTitle;
    public String artRankUrl;
    public String artTitle;
    public String artTypeJson;
    public String artTypeJsonMore;
    public String artUrlJsonMore;
    public String baseUrlRank;
    public String baseUrlRec;
    public String htmlRegularDetail;
    public String htmlRegularIndexRec;
    public String htmlRegularMore;
    public String imgRefererRank;
    public String imgRefererRec;
    public String indexUrlRec;
    public String movieRankTitle;
    public String movieRankUrl;
    public String movieTitle;
    public String movieTypeJson;
    public String movieTypeJsonMore;
    public String movieUrlJsonMore;
    public String rankHtmlCharset;
    public String ruleAnimTypeContentJson;
    public String ruleArtTypeContentJson;
    public String ruleDetailDesc;
    public String ruleDetailStarring;
    public String ruleDetailStyle;
    public String ruleDetailYear;
    public String ruleDetailZone;
    public String ruleMovieTypeContentJson;
    public String ruleRankList;
    public String ruleTvTypeContentJson;
    public String ruleVideoActor;
    public String ruleVideoActorMore;
    public String ruleVideoCover;
    public String ruleVideoCoverMore;
    public String ruleVideoCoverPrefix;
    public String ruleVideoCoverPrefixMore;
    public String ruleVideoLink;
    public String ruleVideoLinkMore;
    public String ruleVideoLinkPrefix;
    public String ruleVideoLinkPrefixMore;
    public String ruleVideoListMore;
    public String ruleVideoRankCover;
    public String ruleVideoRankCoverPrefix;
    public String ruleVideoRankDesc1;
    public String ruleVideoRankDesc2;
    public String ruleVideoRankScore;
    public String ruleVideoRankTitle;
    public String ruleVideoTitle;
    public String ruleVideoTitleMore;
    public String tvRankTitle;
    public String tvRankUrl;
    public String tvTitle;
    public String tvTypeJson;
    public String tvTypeJsonMore;
    public String tvUrlJsonMore;
    public String userAgentRank;
    public String userAgentRec;
    public int version;

    public WebSourceIndexRecData() {
        this.rankHtmlCharset = "";
        this.imgRefererRank = "";
        this.baseUrlRank = "";
        this.userAgentRank = "";
        this.tvRankTitle = "";
        this.tvRankUrl = "";
        this.movieRankTitle = "";
        this.movieRankUrl = "";
        this.artRankTitle = "";
        this.artRankUrl = "";
        this.animRankTitle = "";
        this.animRankUrl = "";
        this.ruleRankList = "";
        this.ruleVideoRankTitle = "";
        this.ruleVideoRankCover = "";
        this.ruleVideoRankCoverPrefix = "";
        this.ruleVideoRankScore = "";
        this.ruleVideoRankDesc1 = "";
        this.ruleVideoRankDesc2 = "";
        this.imgRefererRec = "";
        this.baseUrlRec = "";
        this.userAgentRec = "";
        this.indexUrlRec = "";
        this.htmlRegularIndexRec = "";
        this.tvTitle = "";
        this.tvTypeJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleTvTypeContentJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.movieTitle = "";
        this.movieTypeJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleMovieTypeContentJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.artTitle = "";
        this.artTypeJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleArtTypeContentJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.animTitle = "";
        this.animTypeJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleAnimTypeContentJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleVideoTitle = "";
        this.ruleVideoLink = "";
        this.ruleVideoLinkPrefix = "";
        this.ruleVideoCover = "";
        this.ruleVideoCoverPrefix = "";
        this.ruleVideoActor = "";
        this.htmlRegularDetail = "";
        this.ruleDetailYear = "";
        this.ruleDetailZone = "";
        this.ruleDetailStyle = "";
        this.ruleDetailStarring = "";
        this.ruleDetailDesc = "";
        this.htmlRegularMore = "";
        this.tvTypeJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.tvUrlJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.movieTypeJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.movieUrlJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.artTypeJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.artUrlJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.animTypeJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.animUrlJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleVideoListMore = "";
        this.ruleVideoTitleMore = "";
        this.ruleVideoLinkMore = "";
        this.ruleVideoLinkPrefixMore = "";
        this.ruleVideoCoverMore = "";
        this.ruleVideoCoverPrefixMore = "";
        this.ruleVideoActorMore = "";
    }

    public WebSourceIndexRecData(Parcel parcel) {
        this.rankHtmlCharset = "";
        this.imgRefererRank = "";
        this.baseUrlRank = "";
        this.userAgentRank = "";
        this.tvRankTitle = "";
        this.tvRankUrl = "";
        this.movieRankTitle = "";
        this.movieRankUrl = "";
        this.artRankTitle = "";
        this.artRankUrl = "";
        this.animRankTitle = "";
        this.animRankUrl = "";
        this.ruleRankList = "";
        this.ruleVideoRankTitle = "";
        this.ruleVideoRankCover = "";
        this.ruleVideoRankCoverPrefix = "";
        this.ruleVideoRankScore = "";
        this.ruleVideoRankDesc1 = "";
        this.ruleVideoRankDesc2 = "";
        this.imgRefererRec = "";
        this.baseUrlRec = "";
        this.userAgentRec = "";
        this.indexUrlRec = "";
        this.htmlRegularIndexRec = "";
        this.tvTitle = "";
        this.tvTypeJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleTvTypeContentJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.movieTitle = "";
        this.movieTypeJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleMovieTypeContentJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.artTitle = "";
        this.artTypeJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleArtTypeContentJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.animTitle = "";
        this.animTypeJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleAnimTypeContentJson = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleVideoTitle = "";
        this.ruleVideoLink = "";
        this.ruleVideoLinkPrefix = "";
        this.ruleVideoCover = "";
        this.ruleVideoCoverPrefix = "";
        this.ruleVideoActor = "";
        this.htmlRegularDetail = "";
        this.ruleDetailYear = "";
        this.ruleDetailZone = "";
        this.ruleDetailStyle = "";
        this.ruleDetailStarring = "";
        this.ruleDetailDesc = "";
        this.htmlRegularMore = "";
        this.tvTypeJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.tvUrlJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.movieTypeJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.movieUrlJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.artTypeJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.artUrlJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.animTypeJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.animUrlJsonMore = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        this.ruleVideoListMore = "";
        this.ruleVideoTitleMore = "";
        this.ruleVideoLinkMore = "";
        this.ruleVideoLinkPrefixMore = "";
        this.ruleVideoCoverMore = "";
        this.ruleVideoCoverPrefixMore = "";
        this.ruleVideoActorMore = "";
        this.version = parcel.readInt();
        this.rankHtmlCharset = parcel.readString();
        this.imgRefererRank = parcel.readString();
        this.baseUrlRank = parcel.readString();
        this.userAgentRank = parcel.readString();
        this.tvRankTitle = parcel.readString();
        this.tvRankUrl = parcel.readString();
        this.movieRankTitle = parcel.readString();
        this.movieRankUrl = parcel.readString();
        this.artRankTitle = parcel.readString();
        this.artRankUrl = parcel.readString();
        this.animRankTitle = parcel.readString();
        this.animRankUrl = parcel.readString();
        this.ruleRankList = parcel.readString();
        this.ruleVideoRankTitle = parcel.readString();
        this.ruleVideoRankCover = parcel.readString();
        this.ruleVideoRankCoverPrefix = parcel.readString();
        this.ruleVideoRankScore = parcel.readString();
        this.ruleVideoRankDesc1 = parcel.readString();
        this.ruleVideoRankDesc2 = parcel.readString();
        this.imgRefererRec = parcel.readString();
        this.baseUrlRec = parcel.readString();
        this.userAgentRec = parcel.readString();
        this.indexUrlRec = parcel.readString();
        this.htmlRegularIndexRec = parcel.readString();
        this.tvTitle = parcel.readString();
        this.tvTypeJson = parcel.readString();
        this.ruleTvTypeContentJson = parcel.readString();
        this.movieTitle = parcel.readString();
        this.movieTypeJson = parcel.readString();
        this.ruleMovieTypeContentJson = parcel.readString();
        this.artTitle = parcel.readString();
        this.artTypeJson = parcel.readString();
        this.ruleArtTypeContentJson = parcel.readString();
        this.animTitle = parcel.readString();
        this.animTypeJson = parcel.readString();
        this.ruleAnimTypeContentJson = parcel.readString();
        this.ruleVideoTitle = parcel.readString();
        this.ruleVideoLink = parcel.readString();
        this.ruleVideoLinkPrefix = parcel.readString();
        this.ruleVideoCover = parcel.readString();
        this.ruleVideoCoverPrefix = parcel.readString();
        this.ruleVideoActor = parcel.readString();
        this.htmlRegularDetail = parcel.readString();
        this.ruleDetailYear = parcel.readString();
        this.ruleDetailZone = parcel.readString();
        this.ruleDetailStyle = parcel.readString();
        this.ruleDetailStarring = parcel.readString();
        this.ruleDetailDesc = parcel.readString();
        this.htmlRegularMore = parcel.readString();
        this.tvTypeJsonMore = parcel.readString();
        this.tvUrlJsonMore = parcel.readString();
        this.movieTypeJsonMore = parcel.readString();
        this.movieUrlJsonMore = parcel.readString();
        this.artTypeJsonMore = parcel.readString();
        this.artUrlJsonMore = parcel.readString();
        this.animTypeJsonMore = parcel.readString();
        this.animUrlJsonMore = parcel.readString();
        this.ruleVideoListMore = parcel.readString();
        this.ruleVideoTitleMore = parcel.readString();
        this.ruleVideoLinkMore = parcel.readString();
        this.ruleVideoLinkPrefixMore = parcel.readString();
        this.ruleVideoCoverMore = parcel.readString();
        this.ruleVideoCoverPrefixMore = parcel.readString();
        this.ruleVideoActorMore = parcel.readString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAnimRankTitle() {
        return this.animRankTitle;
    }

    public String getAnimRankUrl() {
        return this.animRankUrl;
    }

    public String getAnimTitle() {
        return this.animTitle;
    }

    public String getAnimTypeJson() {
        return this.animTypeJson;
    }

    public String getAnimTypeJsonMore() {
        return this.animTypeJsonMore;
    }

    public List<String> getAnimTypeList() {
        return !TextUtils.isEmpty(this.animTypeJson) ? (List) JSON.parseObject(this.animTypeJson, new TypeReference<List<String>>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.7
        }, new Feature[0]) : new ArrayList();
    }

    public String getAnimUrlJsonMore() {
        return this.animUrlJsonMore;
    }

    public String getArtRankTitle() {
        return this.artRankTitle;
    }

    public String getArtRankUrl() {
        return this.artRankUrl;
    }

    public String getArtTitle() {
        return this.artTitle;
    }

    public String getArtTypeJson() {
        return this.artTypeJson;
    }

    public String getArtTypeJsonMore() {
        return this.artTypeJsonMore;
    }

    public List<String> getArtTypeList() {
        return !TextUtils.isEmpty(this.artTypeJson) ? (List) JSON.parseObject(this.artTypeJson, new TypeReference<List<String>>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.5
        }, new Feature[0]) : new ArrayList();
    }

    public String getArtUrlJsonMore() {
        return this.artUrlJsonMore;
    }

    public String getBaseUrlRank() {
        return this.baseUrlRank;
    }

    public String getBaseUrlRec() {
        return this.baseUrlRec;
    }

    public String getHtmlRegularDetail() {
        return this.htmlRegularDetail;
    }

    public String getHtmlRegularIndexRec() {
        return this.htmlRegularIndexRec;
    }

    public String getHtmlRegularMore() {
        return this.htmlRegularMore;
    }

    public String getImgRefererRank() {
        return this.imgRefererRank;
    }

    public String getImgRefererRec() {
        return this.imgRefererRec;
    }

    public String getIndexUrlRec() {
        return this.indexUrlRec;
    }

    public String getMovieRankTitle() {
        return this.movieRankTitle;
    }

    public String getMovieRankUrl() {
        return this.movieRankUrl;
    }

    public String getMovieTitle() {
        return this.movieTitle;
    }

    public String getMovieTypeJson() {
        return this.movieTypeJson;
    }

    public String getMovieTypeJsonMore() {
        return this.movieTypeJsonMore;
    }

    public List<String> getMovieTypeList() {
        return !TextUtils.isEmpty(this.movieTypeJson) ? (List) JSON.parseObject(this.movieTypeJson, new TypeReference<List<String>>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.3
        }, new Feature[0]) : new ArrayList();
    }

    public String getMovieUrlJsonMore() {
        return this.movieUrlJsonMore;
    }

    public String getRankHtmlCharset() {
        return this.rankHtmlCharset;
    }

    public String getRuleAnimTypeContentJson() {
        return this.ruleAnimTypeContentJson;
    }

    public List<String> getRuleAnimTypeContentList() {
        return !TextUtils.isEmpty(this.ruleAnimTypeContentJson) ? (List) JSON.parseObject(this.ruleAnimTypeContentJson, new TypeReference<List<String>>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.8
        }, new Feature[0]) : new ArrayList();
    }

    public String getRuleArtTypeContentJson() {
        return this.ruleArtTypeContentJson;
    }

    public List<String> getRuleArtTypeContentList() {
        return !TextUtils.isEmpty(this.ruleArtTypeContentJson) ? (List) JSON.parseObject(this.ruleArtTypeContentJson, new TypeReference<List<String>>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.6
        }, new Feature[0]) : new ArrayList();
    }

    public String getRuleDetailDesc() {
        return this.ruleDetailDesc;
    }

    public String getRuleDetailStarring() {
        return this.ruleDetailStarring;
    }

    public String getRuleDetailStyle() {
        return this.ruleDetailStyle;
    }

    public String getRuleDetailYear() {
        return this.ruleDetailYear;
    }

    public String getRuleDetailZone() {
        return this.ruleDetailZone;
    }

    public String getRuleMovieTypeContentJson() {
        return this.ruleMovieTypeContentJson;
    }

    public List<String> getRuleMovieTypeContentList() {
        return !TextUtils.isEmpty(this.ruleMovieTypeContentJson) ? (List) JSON.parseObject(this.ruleMovieTypeContentJson, new TypeReference<List<String>>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.4
        }, new Feature[0]) : new ArrayList();
    }

    public String getRuleRankList() {
        return this.ruleRankList;
    }

    public String getRuleTvTypeContentJson() {
        return this.ruleTvTypeContentJson;
    }

    public List<String> getRuleTvTypeContentList() {
        return !TextUtils.isEmpty(this.ruleTvTypeContentJson) ? (List) JSON.parseObject(this.ruleTvTypeContentJson, new TypeReference<List<String>>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.2
        }, new Feature[0]) : new ArrayList();
    }

    public String getRuleVideoActor() {
        return this.ruleVideoActor;
    }

    public String getRuleVideoActorMore() {
        return this.ruleVideoActorMore;
    }

    public String getRuleVideoCover() {
        return this.ruleVideoCover;
    }

    public String getRuleVideoCoverMore() {
        return this.ruleVideoCoverMore;
    }

    public String getRuleVideoCoverPrefix() {
        return this.ruleVideoCoverPrefix;
    }

    public String getRuleVideoCoverPrefixMore() {
        return this.ruleVideoCoverPrefixMore;
    }

    public String getRuleVideoLink() {
        return this.ruleVideoLink;
    }

    public String getRuleVideoLinkMore() {
        return this.ruleVideoLinkMore;
    }

    public String getRuleVideoLinkPrefix() {
        return this.ruleVideoLinkPrefix;
    }

    public String getRuleVideoLinkPrefixMore() {
        return this.ruleVideoLinkPrefixMore;
    }

    public String getRuleVideoListMore() {
        return this.ruleVideoListMore;
    }

    public String getRuleVideoRankCover() {
        return this.ruleVideoRankCover;
    }

    public String getRuleVideoRankCoverPrefix() {
        return this.ruleVideoRankCoverPrefix;
    }

    public String getRuleVideoRankDesc1() {
        return this.ruleVideoRankDesc1;
    }

    public String getRuleVideoRankDesc2() {
        return this.ruleVideoRankDesc2;
    }

    public String getRuleVideoRankScore() {
        return this.ruleVideoRankScore;
    }

    public String getRuleVideoRankTitle() {
        return this.ruleVideoRankTitle;
    }

    public String getRuleVideoTitle() {
        return this.ruleVideoTitle;
    }

    public String getRuleVideoTitleMore() {
        return this.ruleVideoTitleMore;
    }

    public String getTvRankTitle() {
        return this.tvRankTitle;
    }

    public String getTvRankUrl() {
        return this.tvRankUrl;
    }

    public String getTvTitle() {
        return this.tvTitle;
    }

    public String getTvTypeJson() {
        return this.tvTypeJson;
    }

    public String getTvTypeJsonMore() {
        return this.tvTypeJsonMore;
    }

    public List<String> getTvTypeList() {
        return !TextUtils.isEmpty(this.tvTypeJson) ? (List) JSON.parseObject(this.tvTypeJson, new TypeReference<List<String>>() { // from class: me.tvspark.data.sql.WebSourceIndexRecData.1
        }, new Feature[0]) : new ArrayList();
    }

    public String getTvUrlJsonMore() {
        return this.tvUrlJsonMore;
    }

    public String getUserAgentRank() {
        return this.userAgentRank;
    }

    public String getUserAgentRec() {
        return this.userAgentRec;
    }

    public int getVersion() {
        return this.version;
    }

    public void setAnimRankTitle(String str) {
        this.animRankTitle = str;
    }

    public void setAnimRankUrl(String str) {
        this.animRankUrl = str;
    }

    public void setAnimTitle(String str) {
        this.animTitle = str;
    }

    public void setAnimTypeJson(String str) {
        this.animTypeJson = str;
    }

    public void setAnimTypeJsonMore(String str) {
        this.animTypeJsonMore = str;
    }

    public void setAnimUrlJsonMore(String str) {
        this.animUrlJsonMore = str;
    }

    public void setArtRankTitle(String str) {
        this.artRankTitle = str;
    }

    public void setArtRankUrl(String str) {
        this.artRankUrl = str;
    }

    public void setArtTitle(String str) {
        this.artTitle = str;
    }

    public void setArtTypeJson(String str) {
        this.artTypeJson = str;
    }

    public void setArtTypeJsonMore(String str) {
        this.artTypeJsonMore = str;
    }

    public void setArtUrlJsonMore(String str) {
        this.artUrlJsonMore = str;
    }

    public void setBaseUrlRank(String str) {
        this.baseUrlRank = str;
    }

    public void setBaseUrlRec(String str) {
        this.baseUrlRec = str;
    }

    public void setHtmlRegularDetail(String str) {
        this.htmlRegularDetail = str;
    }

    public void setHtmlRegularIndexRec(String str) {
        this.htmlRegularIndexRec = str;
    }

    public void setHtmlRegularMore(String str) {
        this.htmlRegularMore = str;
    }

    public void setImgRefererRank(String str) {
        this.imgRefererRank = str;
    }

    public void setImgRefererRec(String str) {
        this.imgRefererRec = str;
    }

    public void setIndexUrlRec(String str) {
        this.indexUrlRec = str;
    }

    public void setMovieRankTitle(String str) {
        this.movieRankTitle = str;
    }

    public void setMovieRankUrl(String str) {
        this.movieRankUrl = str;
    }

    public void setMovieTitle(String str) {
        this.movieTitle = str;
    }

    public void setMovieTypeJson(String str) {
        this.movieTypeJson = str;
    }

    public void setMovieTypeJsonMore(String str) {
        this.movieTypeJsonMore = str;
    }

    public void setMovieUrlJsonMore(String str) {
        this.movieUrlJsonMore = str;
    }

    public void setRankHtmlCharset(String str) {
        this.rankHtmlCharset = str;
    }

    public void setRuleAnimTypeContentJson(String str) {
        this.ruleAnimTypeContentJson = str;
    }

    public void setRuleArtTypeContentJson(String str) {
        this.ruleArtTypeContentJson = str;
    }

    public void setRuleDetailDesc(String str) {
        this.ruleDetailDesc = str;
    }

    public void setRuleDetailStarring(String str) {
        this.ruleDetailStarring = str;
    }

    public void setRuleDetailStyle(String str) {
        this.ruleDetailStyle = str;
    }

    public void setRuleDetailYear(String str) {
        this.ruleDetailYear = str;
    }

    public void setRuleDetailZone(String str) {
        this.ruleDetailZone = str;
    }

    public void setRuleMovieTypeContentJson(String str) {
        this.ruleMovieTypeContentJson = str;
    }

    public void setRuleRankList(String str) {
        this.ruleRankList = str;
    }

    public void setRuleTvTypeContentJson(String str) {
        this.ruleTvTypeContentJson = str;
    }

    public void setRuleVideoActor(String str) {
        this.ruleVideoActor = str;
    }

    public void setRuleVideoActorMore(String str) {
        this.ruleVideoActorMore = str;
    }

    public void setRuleVideoCover(String str) {
        this.ruleVideoCover = str;
    }

    public void setRuleVideoCoverMore(String str) {
        this.ruleVideoCoverMore = str;
    }

    public void setRuleVideoCoverPrefix(String str) {
        this.ruleVideoCoverPrefix = str;
    }

    public void setRuleVideoCoverPrefixMore(String str) {
        this.ruleVideoCoverPrefixMore = str;
    }

    public void setRuleVideoLink(String str) {
        this.ruleVideoLink = str;
    }

    public void setRuleVideoLinkMore(String str) {
        this.ruleVideoLinkMore = str;
    }

    public void setRuleVideoLinkPrefix(String str) {
        this.ruleVideoLinkPrefix = str;
    }

    public void setRuleVideoLinkPrefixMore(String str) {
        this.ruleVideoLinkPrefixMore = str;
    }

    public void setRuleVideoListMore(String str) {
        this.ruleVideoListMore = str;
    }

    public void setRuleVideoRankCover(String str) {
        this.ruleVideoRankCover = str;
    }

    public void setRuleVideoRankCoverPrefix(String str) {
        this.ruleVideoRankCoverPrefix = str;
    }

    public void setRuleVideoRankDesc1(String str) {
        this.ruleVideoRankDesc1 = str;
    }

    public void setRuleVideoRankDesc2(String str) {
        this.ruleVideoRankDesc2 = str;
    }

    public void setRuleVideoRankScore(String str) {
        this.ruleVideoRankScore = str;
    }

    public void setRuleVideoRankTitle(String str) {
        this.ruleVideoRankTitle = str;
    }

    public void setRuleVideoTitle(String str) {
        this.ruleVideoTitle = str;
    }

    public void setRuleVideoTitleMore(String str) {
        this.ruleVideoTitleMore = str;
    }

    public void setTvRankTitle(String str) {
        this.tvRankTitle = str;
    }

    public void setTvRankUrl(String str) {
        this.tvRankUrl = str;
    }

    public void setTvTitle(String str) {
        this.tvTitle = str;
    }

    public void setTvTypeJson(String str) {
        this.tvTypeJson = str;
    }

    public void setTvTypeJsonMore(String str) {
        this.tvTypeJsonMore = str;
    }

    public void setTvUrlJsonMore(String str) {
        this.tvUrlJsonMore = str;
    }

    public void setUserAgentRank(String str) {
        this.userAgentRank = str;
    }

    public void setUserAgentRec(String str) {
        this.userAgentRec = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.version);
        parcel.writeString(this.rankHtmlCharset);
        parcel.writeString(this.imgRefererRank);
        parcel.writeString(this.baseUrlRank);
        parcel.writeString(this.userAgentRank);
        parcel.writeString(this.tvRankTitle);
        parcel.writeString(this.tvRankUrl);
        parcel.writeString(this.movieRankTitle);
        parcel.writeString(this.movieRankUrl);
        parcel.writeString(this.artRankTitle);
        parcel.writeString(this.artRankUrl);
        parcel.writeString(this.animRankTitle);
        parcel.writeString(this.animRankUrl);
        parcel.writeString(this.ruleRankList);
        parcel.writeString(this.ruleVideoRankTitle);
        parcel.writeString(this.ruleVideoRankCover);
        parcel.writeString(this.ruleVideoRankCoverPrefix);
        parcel.writeString(this.ruleVideoRankScore);
        parcel.writeString(this.ruleVideoRankDesc1);
        parcel.writeString(this.ruleVideoRankDesc2);
        parcel.writeString(this.imgRefererRec);
        parcel.writeString(this.baseUrlRec);
        parcel.writeString(this.userAgentRec);
        parcel.writeString(this.indexUrlRec);
        parcel.writeString(this.htmlRegularIndexRec);
        parcel.writeString(this.tvTitle);
        parcel.writeString(this.tvTypeJson);
        parcel.writeString(this.ruleTvTypeContentJson);
        parcel.writeString(this.movieTitle);
        parcel.writeString(this.movieTypeJson);
        parcel.writeString(this.ruleMovieTypeContentJson);
        parcel.writeString(this.artTitle);
        parcel.writeString(this.artTypeJson);
        parcel.writeString(this.ruleArtTypeContentJson);
        parcel.writeString(this.animTitle);
        parcel.writeString(this.animTypeJson);
        parcel.writeString(this.ruleAnimTypeContentJson);
        parcel.writeString(this.ruleVideoTitle);
        parcel.writeString(this.ruleVideoLink);
        parcel.writeString(this.ruleVideoLinkPrefix);
        parcel.writeString(this.ruleVideoCover);
        parcel.writeString(this.ruleVideoCoverPrefix);
        parcel.writeString(this.ruleVideoActor);
        parcel.writeString(this.htmlRegularDetail);
        parcel.writeString(this.ruleDetailYear);
        parcel.writeString(this.ruleDetailZone);
        parcel.writeString(this.ruleDetailStyle);
        parcel.writeString(this.ruleDetailStarring);
        parcel.writeString(this.ruleDetailDesc);
        parcel.writeString(this.htmlRegularMore);
        parcel.writeString(this.tvTypeJsonMore);
        parcel.writeString(this.tvUrlJsonMore);
        parcel.writeString(this.movieTypeJsonMore);
        parcel.writeString(this.movieUrlJsonMore);
        parcel.writeString(this.artTypeJsonMore);
        parcel.writeString(this.artUrlJsonMore);
        parcel.writeString(this.animTypeJsonMore);
        parcel.writeString(this.animUrlJsonMore);
        parcel.writeString(this.ruleVideoListMore);
        parcel.writeString(this.ruleVideoTitleMore);
        parcel.writeString(this.ruleVideoLinkMore);
        parcel.writeString(this.ruleVideoLinkPrefixMore);
        parcel.writeString(this.ruleVideoCoverMore);
        parcel.writeString(this.ruleVideoCoverPrefixMore);
        parcel.writeString(this.ruleVideoActorMore);
    }
}
