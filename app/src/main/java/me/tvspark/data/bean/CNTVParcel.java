package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class CNTVParcel implements Serializable {
    public DataBean data = new DataBean();

    /* loaded from: classes4.dex */
    public static class DataBean implements Serializable {
        public List<ListBean> list = new ArrayList();
        public int total;

        /* loaded from: classes4.dex */
        public static class ListBean implements Serializable {
            public long focus_date;

            /* renamed from: sc */
            public String f4515sc = "";
            public String image = "";
            public String url = "";

            /* renamed from: fc */
            public String f4513fc = "";

            /* renamed from: id */
            public String f4514id = "";
            public String vsetid = "";
            public String image2 = "";
            public String title = "";
            public String actors = "";
            public String year = "";
            public String channel = "";
            public String image3 = "";
            public String brief = "";
            public String count = "";
            public String area = "";

            public String getActors() {
                return this.actors;
            }

            public String getArea() {
                return this.area;
            }

            public String getBrief() {
                return this.brief;
            }

            public String getChannel() {
                return this.channel;
            }

            public String getCount() {
                return this.count;
            }

            public String getFc() {
                return this.f4513fc;
            }

            public long getFocus_date() {
                return this.focus_date;
            }

            public String getId() {
                return this.f4514id;
            }

            public String getImage() {
                return this.image;
            }

            public String getImage2() {
                return this.image2;
            }

            public String getImage3() {
                return this.image3;
            }

            public String getSc() {
                return this.f4515sc;
            }

            public String getTitle() {
                return this.title;
            }

            public String getUrl() {
                return this.url;
            }

            public String getVsetid() {
                return this.vsetid;
            }

            public String getYear() {
                return this.year;
            }

            public void setActors(String str) {
                this.actors = str;
            }

            public void setArea(String str) {
                this.area = str;
            }

            public void setBrief(String str) {
                this.brief = str;
            }

            public void setChannel(String str) {
                this.channel = str;
            }

            public void setCount(String str) {
                this.count = str;
            }

            public void setFc(String str) {
                this.f4513fc = str;
            }

            public void setFocus_date(long j) {
                this.focus_date = j;
            }

            public void setId(String str) {
                this.f4514id = str;
            }

            public void setImage(String str) {
                this.image = str;
            }

            public void setImage2(String str) {
                this.image2 = str;
            }

            public void setImage3(String str) {
                this.image3 = str;
            }

            public void setSc(String str) {
                this.f4515sc = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setUrl(String str) {
                this.url = str;
            }

            public void setVsetid(String str) {
                this.vsetid = str;
            }

            public void setYear(String str) {
                this.year = str;
            }
        }

        public List<ListBean> getList() {
            return this.list;
        }

        public int getTotal() {
            return this.total;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
