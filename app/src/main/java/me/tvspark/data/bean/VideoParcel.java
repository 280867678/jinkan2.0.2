package me.tvspark.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;
import me.tvspark.sk0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class VideoParcel extends LitePalSupport implements Serializable, Parcelable, sk0 {
    public static final Parcelable.Creator<VideoParcel> CREATOR = new Parcelable.Creator<VideoParcel>() { // from class: me.tvspark.data.bean.VideoParcel.1
        @Override // android.os.Parcelable.Creator
        public VideoParcel createFromParcel(Parcel parcel) {
            return new VideoParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public VideoParcel[] newArray(int i) {
            return new VideoParcel[i];
        }
    };
    public String actor;
    public List<GenreParcel> areaList;
    public int[] categotyListId;
    public String[] categotyListName;
    public String coverUrl;
    public String desc;
    public boolean isADPos;
    public boolean isCategory;
    public String link;
    public transient NativeExpressADView nativeExpressADView;
    public String number;
    public String score;
    public String title;
    public List<GenreParcel> typeList;
    public List<GenreParcel> yearList;

    public VideoParcel() {
        this.title = "";
        this.coverUrl = "";
        this.number = "";
        this.link = "";
        this.actor = "";
        this.desc = "";
        this.score = "";
        this.isADPos = false;
        this.isCategory = false;
        this.categotyListId = new int[0];
        this.categotyListName = new String[0];
        this.typeList = new ArrayList();
        this.areaList = new ArrayList();
        this.yearList = new ArrayList();
    }

    public VideoParcel(Parcel parcel) {
        this.title = "";
        this.coverUrl = "";
        this.number = "";
        this.link = "";
        this.actor = "";
        this.desc = "";
        this.score = "";
        boolean z = false;
        this.isADPos = false;
        this.isCategory = false;
        this.categotyListId = new int[0];
        this.categotyListName = new String[0];
        this.typeList = new ArrayList();
        this.areaList = new ArrayList();
        this.yearList = new ArrayList();
        this.title = parcel.readString();
        this.coverUrl = parcel.readString();
        this.number = parcel.readString();
        this.link = parcel.readString();
        this.actor = parcel.readString();
        this.desc = parcel.readString();
        this.score = parcel.readString();
        this.isADPos = parcel.readByte() != 0;
        this.isCategory = parcel.readByte() != 0 ? true : z;
        this.categotyListId = parcel.createIntArray();
        this.categotyListName = parcel.createStringArray();
        ArrayList arrayList = new ArrayList();
        this.typeList = arrayList;
        parcel.readList(arrayList, GenreParcel.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.areaList = arrayList2;
        parcel.readList(arrayList2, GenreParcel.class.getClassLoader());
        ArrayList arrayList3 = new ArrayList();
        this.yearList = arrayList3;
        parcel.readList(arrayList3, GenreParcel.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoParcel)) {
            return false;
        }
        VideoParcel videoParcel = (VideoParcel) obj;
        if (this.isADPos != videoParcel.isADPos || this.isCategory != videoParcel.isCategory || !this.title.equals(videoParcel.title) || !this.coverUrl.equals(videoParcel.coverUrl) || !this.number.equals(videoParcel.number) || !this.link.equals(videoParcel.link)) {
            return false;
        }
        return this.actor.equals(videoParcel.actor);
    }

    public String getActor() {
        return this.actor;
    }

    public List<GenreParcel> getAreaList() {
        return this.areaList;
    }

    public int[] getCategotyListId() {
        return this.categotyListId;
    }

    public String[] getCategotyListName() {
        return this.categotyListName;
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

    public String getTitle() {
        return this.title;
    }

    public List<GenreParcel> getTypeList() {
        return this.typeList;
    }

    public List<GenreParcel> getYearList() {
        return this.yearList;
    }

    public int hashCode() {
        return ((outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actor, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.link, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.number, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.coverUrl, this.title.hashCode() * 31, 31), 31), 31), 31) + (this.isADPos ? 1 : 0)) * 31) + (this.isCategory ? 1 : 0);
    }

    public boolean isADPos() {
        return this.isADPos;
    }

    public boolean isCategory() {
        return this.isCategory;
    }

    public void setADPos(boolean z) {
        this.isADPos = z;
    }

    public void setActor(String str) {
        this.actor = str;
    }

    public void setAreaList(List<GenreParcel> list) {
        this.areaList = list;
    }

    public void setCategory(boolean z) {
        this.isCategory = z;
    }

    public void setCategotyListId(int[] iArr) {
        this.categotyListId = iArr;
    }

    public void setCategotyListName(String[] strArr) {
        this.categotyListName = strArr;
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

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTypeList(List<GenreParcel> list) {
        this.typeList = list;
    }

    public void setYearList(List<GenreParcel> list) {
        this.yearList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.number);
        parcel.writeString(this.link);
        parcel.writeString(this.actor);
        parcel.writeString(this.desc);
        parcel.writeString(this.score);
        parcel.writeByte(this.isADPos ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCategory ? (byte) 1 : (byte) 0);
        parcel.writeIntArray(this.categotyListId);
        parcel.writeStringArray(this.categotyListName);
        parcel.writeList(this.typeList);
        parcel.writeList(this.areaList);
        parcel.writeList(this.yearList);
    }
}
