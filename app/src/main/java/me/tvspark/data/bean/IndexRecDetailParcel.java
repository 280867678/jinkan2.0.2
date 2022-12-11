package me.tvspark.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import me.tvspark.sk0;

/* loaded from: classes4.dex */
public class IndexRecDetailParcel implements Serializable, Parcelable, sk0 {
    public static final Parcelable.Creator<IndexRecDetailParcel> CREATOR = new Parcelable.Creator<IndexRecDetailParcel>() { // from class: me.tvspark.data.bean.IndexRecDetailParcel.1
        @Override // android.os.Parcelable.Creator
        public IndexRecDetailParcel createFromParcel(Parcel parcel) {
            return new IndexRecDetailParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IndexRecDetailParcel[] newArray(int i) {
            return new IndexRecDetailParcel[i];
        }
    };
    public String desc;
    public String starring;
    public String style;
    public String year;
    public String zone;

    public IndexRecDetailParcel() {
        this.year = "";
        this.zone = "";
        this.style = "";
        this.starring = "";
        this.desc = "";
    }

    public IndexRecDetailParcel(Parcel parcel) {
        this.year = "";
        this.zone = "";
        this.style = "";
        this.starring = "";
        this.desc = "";
        this.year = parcel.readString();
        this.zone = parcel.readString();
        this.style = parcel.readString();
        this.starring = parcel.readString();
        this.desc = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getStarring() {
        return this.starring;
    }

    public String getStyle() {
        return this.style;
    }

    public String getYear() {
        return this.year;
    }

    public String getZone() {
        return this.zone;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setStarring(String str) {
        this.starring = str;
    }

    public void setStyle(String str) {
        this.style = str;
    }

    public void setYear(String str) {
        this.year = str;
    }

    public void setZone(String str) {
        this.zone = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.year);
        parcel.writeString(this.zone);
        parcel.writeString(this.style);
        parcel.writeString(this.starring);
        parcel.writeString(this.desc);
    }
}
