package me.tvspark.data.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class CNTVEpisodeParcel implements Serializable {
    public String hls_url;
    public String tag;
    public String title;
    public VideoBean video;

    /* loaded from: classes4.dex */
    public static class VideoBean implements Serializable {
        public List<ChaptersBean> chapters;
        public List<ChaptersBean> chapters2;
        public List<ChaptersBean> chapters3;
        public List<ChaptersBean> chapters4;
        public String totalLength;
        public String url;
        public int validChapterNum;

        /* loaded from: classes4.dex */
        public static class ChaptersBean implements Serializable {
            public String duration;
            public String image;
            public String url;

            public String getDuration() {
                return this.duration;
            }

            public String getImage() {
                return this.image;
            }

            public String getUrl() {
                return this.url;
            }

            public void setDuration(String str) {
                this.duration = str;
            }

            public void setImage(String str) {
                this.image = str;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public List<ChaptersBean> getChapters() {
            return this.chapters;
        }

        public List<ChaptersBean> getChapters2() {
            return this.chapters2;
        }

        public List<ChaptersBean> getChapters3() {
            return this.chapters3;
        }

        public List<ChaptersBean> getChapters4() {
            return this.chapters4;
        }

        public String getTotalLength() {
            return this.totalLength;
        }

        public String getUrl() {
            return this.url;
        }

        public int getValidChapterNum() {
            return this.validChapterNum;
        }

        public void setChapters(List<ChaptersBean> list) {
            this.chapters = list;
        }

        public void setChapters2(List<ChaptersBean> list) {
            this.chapters2 = list;
        }

        public void setChapters3(List<ChaptersBean> list) {
            this.chapters3 = list;
        }

        public void setChapters4(List<ChaptersBean> list) {
            this.chapters4 = list;
        }

        public void setTotalLength(String str) {
            this.totalLength = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setValidChapterNum(int i) {
            this.validChapterNum = i;
        }
    }

    public String getHls_url() {
        if (!TextUtils.isEmpty(this.hls_url)) {
            this.hls_url = this.hls_url.replace("main", "1200");
        }
        return this.hls_url;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }

    public VideoBean getVideo() {
        return this.video;
    }

    public void setHls_url(String str) {
        this.hls_url = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideo(VideoBean videoBean) {
        this.video = videoBean;
    }
}
