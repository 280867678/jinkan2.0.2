package me.tvspark.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.arialyy.aria.core.download.DownloadEntity;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.sk0;

/* loaded from: classes4.dex */
public class MyDownData implements Parcelable, sk0 {
    public static final Parcelable.Creator<MyDownData> CREATOR = new Parcelable.Creator<MyDownData>() { // from class: me.tvspark.data.bean.MyDownData.1
        @Override // android.os.Parcelable.Creator
        public MyDownData createFromParcel(Parcel parcel) {
            return new MyDownData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MyDownData[] newArray(int i) {
            return new MyDownData[i];
        }
    };
    public int childFilesCount;
    public long childFilesSize;
    public List<DownloadEntity> childList;
    public String coverUrl;
    public String dirName;
    public String dirPath;

    public MyDownData() {
        this.dirPath = "";
        this.coverUrl = "";
        this.dirName = "";
        this.childFilesSize = 0L;
        this.childFilesCount = 0;
        this.childList = new ArrayList();
    }

    public MyDownData(Parcel parcel) {
        this.dirPath = "";
        this.coverUrl = "";
        this.dirName = "";
        this.childFilesSize = 0L;
        this.childFilesCount = 0;
        this.childList = new ArrayList();
        this.dirPath = parcel.readString();
        this.coverUrl = parcel.readString();
        this.dirName = parcel.readString();
        this.childFilesSize = parcel.readLong();
        this.childFilesCount = parcel.readInt();
        this.childList = parcel.createTypedArrayList(DownloadEntity.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChildFilesCount() {
        return this.childFilesCount;
    }

    public long getChildFilesSize() {
        return this.childFilesSize;
    }

    public List<DownloadEntity> getChildList() {
        return this.childList;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDirName() {
        return this.dirName;
    }

    public String getDirPath() {
        return this.dirPath;
    }

    public void setChildFilesCount(int i) {
        this.childFilesCount = i;
    }

    public void setChildFilesSize(long j) {
        this.childFilesSize = j;
    }

    public void setChildList(List<DownloadEntity> list) {
        this.childList = list;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDirName(String str) {
        this.dirName = str;
    }

    public void setDirPath(String str) {
        this.dirPath = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dirPath);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.dirName);
        parcel.writeLong(this.childFilesSize);
        parcel.writeInt(this.childFilesCount);
        parcel.writeTypedList(this.childList);
    }
}
