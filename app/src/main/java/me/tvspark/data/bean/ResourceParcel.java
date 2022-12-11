package me.tvspark.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import java.io.Serializable;
import me.tvspark.outline;
import me.tvspark.sk0;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class ResourceParcel extends LitePalSupport implements Serializable, Parcelable, sk0 {
    public static final Parcelable.Creator<ResourceParcel> CREATOR = new Parcelable.Creator<ResourceParcel>() { // from class: me.tvspark.data.bean.ResourceParcel.1
        @Override // android.os.Parcelable.Creator
        public ResourceParcel createFromParcel(Parcel parcel) {
            return new ResourceParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ResourceParcel[] newArray(int i) {
            return new ResourceParcel[i];
        }
    };
    public String coverUrl;
    public String desc;
    public boolean isADPos;
    public String link;
    public transient NativeExpressADView nativeExpressADView;
    public String number;
    public String score;
    public String tag;
    public String title;

    public ResourceParcel() {
        this.title = "";
        this.coverUrl = "";
        this.number = "";
        this.link = "";
        this.tag = "";
        this.score = "";
        this.desc = "";
        this.isADPos = false;
    }

    public ResourceParcel(Parcel parcel) {
        this.title = "";
        this.coverUrl = "";
        this.number = "";
        this.link = "";
        this.tag = "";
        this.score = "";
        this.desc = "";
        boolean z = false;
        this.isADPos = false;
        this.title = parcel.readString();
        this.coverUrl = parcel.readString();
        this.number = parcel.readString();
        this.link = parcel.readString();
        this.tag = parcel.readString();
        this.score = parcel.readString();
        this.isADPos = parcel.readByte() != 0 ? true : z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getLink() {
        return this.link;
    }

    public NativeExpressADView getNativeExpressADView() {
        return this.nativeExpressADView;
    }

    public String getNumber() {
        return this.number;
    }

    public String getScore() {
        return this.score;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isADPos() {
        return this.isADPos;
    }

    public void setADPos(boolean z) {
        this.isADPos = z;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setNativeExpressADView(NativeExpressADView nativeExpressADView) {
        this.nativeExpressADView = nativeExpressADView;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setScore(String str) {
        this.score = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ResourceParcel{title='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.title);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", coverUrl='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.coverUrl);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", number='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.number);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", link='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.link);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", tag='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.tag);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", score='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.score);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", desc='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.desc);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.number);
        parcel.writeString(this.link);
        parcel.writeString(this.tag);
        parcel.writeString(this.score);
        parcel.writeByte(this.isADPos ? (byte) 1 : (byte) 0);
    }
}
