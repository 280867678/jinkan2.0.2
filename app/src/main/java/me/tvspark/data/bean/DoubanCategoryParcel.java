package me.tvspark.data.bean;

import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class DoubanCategoryParcel implements Serializable {
    public List<DataEntity> data = new ArrayList();

    /* loaded from: classes4.dex */
    public static class DataEntity implements Serializable {
        public transient NativeExpressADView nativeExpressADView;
        public String rate = "";
        public String rateCount = "";
        public String star = "";
        public String title = "";
        public String url = "";
        public String cover = "";

        /* renamed from: id */
        public String f4517id = "";
        public String card_subtitle = "";
        public List<String> directors = new ArrayList();
        public List<String> casts = new ArrayList();
        public boolean isADPos = false;

        public String getCard_subtitle() {
            return this.card_subtitle;
        }

        public List<String> getCasts() {
            return this.casts;
        }

        public String getCover() {
            return this.cover;
        }

        public List<String> getDirectors() {
            return this.directors;
        }

        public String getId() {
            return this.f4517id;
        }

        public NativeExpressADView getNativeExpressADView() {
            return this.nativeExpressADView;
        }

        public String getRate() {
            return this.rate;
        }

        public String getRateCount() {
            return this.rateCount;
        }

        public String getStar() {
            return this.star;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        public boolean isADPos() {
            return this.isADPos;
        }

        public void setADPos(boolean z) {
            this.isADPos = z;
        }

        public void setCard_subtitle(String str) {
            this.card_subtitle = str;
        }

        public void setCasts(List<String> list) {
            this.casts = list;
        }

        public void setCover(String str) {
            this.cover = str;
        }

        public void setDirectors(List<String> list) {
            this.directors = list;
        }

        public void setId(String str) {
            this.f4517id = str;
        }

        public void setNativeExpressADView(NativeExpressADView nativeExpressADView) {
            this.nativeExpressADView = nativeExpressADView;
        }

        public void setRate(String str) {
            this.rate = str;
        }

        public void setRateCount(String str) {
            this.rateCount = str;
        }

        public void setStar(String str) {
            this.star = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public List<DataEntity> getData() {
        return this.data;
    }

    public void setData(List<DataEntity> list) {
        this.data = list;
    }

    public void transParcel(DoubanCategoryAPIParcel doubanCategoryAPIParcel) {
        for (int i = 0; i < doubanCategoryAPIParcel.getData().size(); i++) {
            DataEntity dataEntity = new DataEntity();
            for (int i2 = 0; i2 < doubanCategoryAPIParcel.getData().get(i).getActors().size(); i2++) {
                dataEntity.getCasts().add(doubanCategoryAPIParcel.getData().get(i).getActors().get(i2).getName());
            }
            for (int i3 = 0; i3 < doubanCategoryAPIParcel.getData().get(i).getDirectors().size(); i3++) {
                dataEntity.getDirectors().add(doubanCategoryAPIParcel.getData().get(i).getDirectors().get(i3).getName());
            }
            if (doubanCategoryAPIParcel.getData().get(i).getRating() != null) {
                dataEntity.setRate(doubanCategoryAPIParcel.getData().get(i).getRating().getValue() + "");
                dataEntity.setStar((doubanCategoryAPIParcel.getData().get(i).getRating().getStar_count() * 10.0d) + "");
                dataEntity.setRateCount(doubanCategoryAPIParcel.getData().get(i).getRating().getCount() + "");
            }
            dataEntity.setTitle(doubanCategoryAPIParcel.getData().get(i).getTitle());
            dataEntity.setUrl(doubanCategoryAPIParcel.getData().get(i).getUrl());
            if (doubanCategoryAPIParcel.getData().get(i).getPic() != null) {
                dataEntity.setCover(doubanCategoryAPIParcel.getData().get(i).getPic().getNormal());
            }
            dataEntity.setId(doubanCategoryAPIParcel.getData().get(i).getId());
            dataEntity.setCard_subtitle(doubanCategoryAPIParcel.getData().get(i).getCard_subtitle());
            this.data.add(dataEntity);
        }
    }
}
