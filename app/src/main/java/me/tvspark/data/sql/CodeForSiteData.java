package me.tvspark.data.sql;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class CodeForSiteData extends LitePalSupport implements Serializable, Parcelable, Cloneable {
    public static final Parcelable.Creator<CodeForSiteData> CREATOR = new Parcelable.Creator<CodeForSiteData>() { // from class: me.tvspark.data.sql.CodeForSiteData.1
        @Override // android.os.Parcelable.Creator
        public CodeForSiteData createFromParcel(Parcel parcel) {
            return new CodeForSiteData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CodeForSiteData[] newArray(int i) {
            return new CodeForSiteData[i];
        }
    };
    public String name;
    public String webSourceBaseUrl;

    public CodeForSiteData(Parcel parcel) {
        this.webSourceBaseUrl = "";
        this.name = "";
        this.webSourceBaseUrl = parcel.readString();
        this.name = parcel.readString();
    }

    public CodeForSiteData(String str, String str2) {
        this.webSourceBaseUrl = "";
        this.name = "";
        this.webSourceBaseUrl = str;
        this.name = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public String getWebSourceBaseUrl() {
        return this.webSourceBaseUrl;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setWebSourceBaseUrl(String str) {
        this.webSourceBaseUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.webSourceBaseUrl);
        parcel.writeString(this.name);
    }
}
