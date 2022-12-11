package me.tvspark.data.bean;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class DoubanCategoryAPIParcel implements Serializable {
    public List<DataEntity> data = new ArrayList();

    /* loaded from: classes4.dex */
    public static class DataEntity implements Serializable {
        public RatingEntity rating = new RatingEntity();
        public PicEntity pic = new PicEntity();

        /* renamed from: id */
        public String f4516id = "";
        public String title = "";
        public String card_subtitle = "";
        public String url = "";
        public List<ActorsEntity> actors = new ArrayList();
        public List<DirectorsEntity> directors = new ArrayList();

        /* loaded from: classes4.dex */
        public static class ActorsEntity implements Serializable {
            public String name = "";

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }
        }

        /* loaded from: classes4.dex */
        public static class DirectorsEntity implements Serializable {
            public String name = "";

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }
        }

        /* loaded from: classes4.dex */
        public static class PicEntity implements Serializable {
            public String large = "";
            public String normal = "";

            public String getLarge() {
                return this.large;
            }

            public String getNormal() {
                return this.normal;
            }

            public void setLarge(String str) {
                this.large = str;
            }

            public void setNormal(String str) {
                this.normal = str;
            }
        }

        /* loaded from: classes4.dex */
        public static class RatingEntity implements Serializable {
            public double star_count = RoundRectDrawableWithShadow.COS_45;
            public double value = RoundRectDrawableWithShadow.COS_45;
            public int count = 0;

            public int getCount() {
                return this.count;
            }

            public double getStar_count() {
                return this.star_count;
            }

            public double getValue() {
                return this.value;
            }

            public void setCount(int i) {
                this.count = i;
            }

            public void setStar_count(double d) {
                this.star_count = d;
            }

            public void setValue(double d) {
                this.value = d;
            }
        }

        public List<ActorsEntity> getActors() {
            return this.actors;
        }

        public String getCard_subtitle() {
            return this.card_subtitle;
        }

        public List<DirectorsEntity> getDirectors() {
            return this.directors;
        }

        public String getId() {
            return this.f4516id;
        }

        public PicEntity getPic() {
            return this.pic;
        }

        public RatingEntity getRating() {
            return this.rating;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        public void setActors(List<ActorsEntity> list) {
            this.actors = list;
        }

        public void setCard_subtitle(String str) {
            this.card_subtitle = str;
        }

        public void setDirectors(List<DirectorsEntity> list) {
            this.directors = list;
        }

        public void setId(String str) {
            this.f4516id = str;
        }

        public void setPic(PicEntity picEntity) {
            this.pic = picEntity;
        }

        public void setRating(RatingEntity ratingEntity) {
            this.rating = ratingEntity;
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
}
