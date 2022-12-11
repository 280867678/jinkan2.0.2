package com.arialyy.aria.core.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.arialyy.aria.orm.annotation.Default;

/* loaded from: classes3.dex */
public abstract class AbsNormalEntity extends AbsEntity implements Parcelable {
    public String fileName;
    @Default("false")
    public boolean isGroupChild;
    @Default("false")
    public boolean isRedirect;
    public String redirectUrl;
    public int taskType;
    public String url;

    public AbsNormalEntity() {
        this.isGroupChild = false;
        this.isRedirect = false;
    }

    public AbsNormalEntity(Parcel parcel) {
        super(parcel);
        boolean z = false;
        this.isGroupChild = false;
        this.isRedirect = false;
        this.url = parcel.readString();
        this.fileName = parcel.readString();
        this.isGroupChild = parcel.readByte() != 0;
        this.isRedirect = parcel.readByte() != 0 ? true : z;
        this.redirectUrl = parcel.readString();
    }

    @Override // com.arialyy.aria.core.common.AbsEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileName() {
        return this.fileName;
    }

    public abstract String getFilePath();

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isGroupChild() {
        return this.isGroupChild;
    }

    public boolean isRedirect() {
        return this.isRedirect;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setGroupChild(boolean z) {
        this.isGroupChild = z;
    }

    public void setRedirect(boolean z) {
        this.isRedirect = z;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public void setTaskType(int i) {
        this.taskType = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // com.arialyy.aria.core.common.AbsEntity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.url);
        parcel.writeString(this.fileName);
        parcel.writeByte(this.isGroupChild ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRedirect ? (byte) 1 : (byte) 0);
        parcel.writeString(this.redirectUrl);
    }
}
