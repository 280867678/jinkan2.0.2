package com.arialyy.aria.core.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.arialyy.aria.core.inf.IEntity;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.orm.annotation.Default;
import com.arialyy.aria.orm.annotation.Ignore;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class AbsEntity extends DbEntity implements IEntity, Parcelable, Serializable {
    public long completeTime;
    public String convertFileSize;
    @Ignore
    public String convertSpeed;
    public long currentProgress;
    @Ignore
    public int failNum;
    public long fileSize;
    @Default("false")
    public boolean isComplete;
    public int percent;
    @Ignore
    public long speed;
    @Default(ExifInterface.GPS_MEASUREMENT_3D)
    public int state;
    public long stopTime;
    public String str;
    @Ignore
    public int timeLeft;

    public AbsEntity() {
        this.speed = 0L;
        this.failNum = 0;
        this.timeLeft = Integer.MAX_VALUE;
        this.fileSize = 0L;
        this.state = 3;
        this.currentProgress = 0L;
        this.isComplete = false;
        this.stopTime = 0L;
    }

    public AbsEntity(Parcel parcel) {
        this.speed = 0L;
        boolean z = false;
        this.failNum = 0;
        this.timeLeft = Integer.MAX_VALUE;
        this.fileSize = 0L;
        this.state = 3;
        this.currentProgress = 0L;
        this.isComplete = false;
        this.stopTime = 0L;
        this.speed = parcel.readLong();
        this.convertSpeed = parcel.readString();
        this.failNum = parcel.readInt();
        this.str = parcel.readString();
        this.fileSize = parcel.readLong();
        this.convertFileSize = parcel.readString();
        this.state = parcel.readInt();
        this.currentProgress = parcel.readLong();
        this.completeTime = parcel.readLong();
        this.percent = parcel.readInt();
        this.isComplete = parcel.readByte() != 0 ? true : z;
        this.stopTime = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCompleteTime() {
        return this.completeTime;
    }

    public String getConvertFileSize() {
        return this.convertFileSize;
    }

    public String getConvertSpeed() {
        return this.convertSpeed;
    }

    public long getCurrentProgress() {
        return this.currentProgress;
    }

    public int getFailNum() {
        return this.failNum;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getId() {
        return getRowID();
    }

    public abstract String getKey();

    public int getPercent() {
        return this.percent;
    }

    public long getSpeed() {
        return this.speed;
    }

    public int getState() {
        return this.state;
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public String getStr() {
        return this.str;
    }

    public abstract int getTaskType();

    public int getTimeLeft() {
        return this.timeLeft;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void setComplete(boolean z) {
        this.isComplete = z;
    }

    public void setCompleteTime(long j) {
        this.completeTime = j;
    }

    public void setConvertFileSize(String str) {
        this.convertFileSize = str;
    }

    public void setConvertSpeed(String str) {
        this.convertSpeed = str;
    }

    public void setCurrentProgress(long j) {
        this.currentProgress = j;
    }

    public void setFailNum(int i) {
        this.failNum = i;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setPercent(int i) {
        this.percent = i;
    }

    public void setSpeed(long j) {
        this.speed = j;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setStopTime(long j) {
        this.stopTime = j;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setTimeLeft(int i) {
        this.timeLeft = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.speed);
        parcel.writeString(this.convertSpeed);
        parcel.writeInt(this.failNum);
        parcel.writeString(this.str);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.convertFileSize);
        parcel.writeInt(this.state);
        parcel.writeLong(this.currentProgress);
        parcel.writeLong(this.completeTime);
        parcel.writeInt(this.percent);
        parcel.writeByte(this.isComplete ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.stopTime);
    }
}
