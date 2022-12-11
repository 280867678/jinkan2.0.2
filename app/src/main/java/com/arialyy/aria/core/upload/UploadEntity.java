package com.arialyy.aria.core.upload;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.orm.annotation.Primary;

/* loaded from: classes3.dex */
public class UploadEntity extends AbsNormalEntity implements Parcelable {
    public static final Parcelable.Creator<UploadEntity> CREATOR = new Parcelable.Creator<UploadEntity>() { // from class: com.arialyy.aria.core.upload.UploadEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public UploadEntity mo4439createFromParcel(Parcel parcel) {
            return new UploadEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public UploadEntity[] mo4440newArray(int i) {
            return new UploadEntity[i];
        }
    };
    @Primary
    public String filePath;
    public String responseStr = "";

    public UploadEntity() {
    }

    public UploadEntity(Parcel parcel) {
        super(parcel);
        this.filePath = parcel.readString();
    }

    @Override // com.arialyy.aria.core.common.AbsNormalEntity, com.arialyy.aria.core.common.AbsEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.arialyy.aria.core.common.AbsNormalEntity
    public String getFilePath() {
        return this.filePath;
    }

    @Override // com.arialyy.aria.core.common.AbsEntity
    public String getKey() {
        return this.filePath;
    }

    public String getResponseStr() {
        return this.responseStr;
    }

    @Override // com.arialyy.aria.core.common.AbsEntity
    public int getTaskType() {
        if (TextUtils.isEmpty(getUrl())) {
            return 0;
        }
        return getUrl().startsWith("ftp") ? 6 : 5;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setResponseStr(String str) {
        this.responseStr = str;
    }

    @Override // com.arialyy.aria.core.common.AbsNormalEntity, com.arialyy.aria.core.common.AbsEntity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.filePath);
    }
}
