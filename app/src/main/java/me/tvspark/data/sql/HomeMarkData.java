package me.tvspark.data.sql;

import android.os.Parcel;
import android.os.Parcelable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class HomeMarkData extends LitePalSupport implements Parcelable {
    public static final Parcelable.Creator<HomeMarkData> CREATOR = new Parcelable.Creator<HomeMarkData>() { // from class: me.tvspark.data.sql.HomeMarkData.1
        @Override // android.os.Parcelable.Creator
        public HomeMarkData createFromParcel(Parcel parcel) {
            return new HomeMarkData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HomeMarkData[] newArray(int i) {
            return new HomeMarkData[i];
        }
    };
    public String iconColor;
    public String iconTxt;
    public String iconUrl;
    public int serialNumber;
    public String title;
    public String url;

    public HomeMarkData() {
        this.url = "";
        this.title = "";
        this.serialNumber = 0;
        this.iconUrl = "";
        this.iconColor = "";
        this.iconTxt = "";
    }

    public HomeMarkData(Parcel parcel) {
        this.url = "";
        this.title = "";
        this.serialNumber = 0;
        this.iconUrl = "";
        this.iconColor = "";
        this.iconTxt = "";
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.serialNumber = parcel.readInt();
        this.iconUrl = parcel.readString();
        this.iconColor = parcel.readString();
        this.iconTxt = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIconColor() {
        return this.iconColor;
    }

    public String getIconTxt() {
        return this.iconTxt;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setIconColor(String str) {
        this.iconColor = str;
    }

    public void setIconTxt(String str) {
        this.iconTxt = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setSerialNumber(int i) {
        this.serialNumber = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeInt(this.serialNumber);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.iconColor);
        parcel.writeString(this.iconTxt);
    }
}
