package com.arialyy.aria.core.download;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.orm.annotation.Ignore;
import com.arialyy.aria.orm.annotation.Unique;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes3.dex */
public class DownloadEntity extends AbsNormalEntity implements Parcelable {
    public static final Parcelable.Creator<DownloadEntity> CREATOR = new Parcelable.Creator<DownloadEntity>() { // from class: com.arialyy.aria.core.download.DownloadEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public DownloadEntity mo4415createFromParcel(Parcel parcel) {
            return new DownloadEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public DownloadEntity[] mo4416newArray(int i) {
            return new DownloadEntity[i];
        }
    };
    public String disposition;
    @Unique
    public String downloadPath;
    public String groupHash;
    @Ignore
    public M3U8Entity m3U8Entity;
    public String md5Code;
    public String serverFileName;

    public DownloadEntity() {
    }

    public DownloadEntity(Parcel parcel) {
        super(parcel);
        this.downloadPath = parcel.readString();
        this.groupHash = parcel.readString();
        this.md5Code = parcel.readString();
        this.disposition = parcel.readString();
        this.serverFileName = parcel.readString();
        this.m3U8Entity = (M3U8Entity) parcel.readParcelable(M3U8Entity.class.getClassLoader());
    }

    /* renamed from: clone */
    public DownloadEntity m4414clone() throws CloneNotSupportedException {
        return (DownloadEntity) super.clone();
    }

    @Override // com.arialyy.aria.core.common.AbsNormalEntity, com.arialyy.aria.core.common.AbsEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDisposition() {
        return TextUtils.isEmpty(this.disposition) ? "" : CommonUtil.decryptBASE64(this.disposition);
    }

    @Override // com.arialyy.aria.core.common.AbsNormalEntity
    public String getFilePath() {
        return this.downloadPath;
    }

    public String getGroupHash() {
        return this.groupHash;
    }

    @Override // com.arialyy.aria.core.common.AbsEntity
    public String getKey() {
        return getUrl();
    }

    public M3U8Entity getM3U8Entity() {
        if (TextUtils.isEmpty(this.downloadPath)) {
            ALog.m4191e("DownloadEntity", "文件保存路径为空，获取m3u8实体之前需要设置文件保存路径");
            return null;
        }
        if (this.m3U8Entity == null) {
            this.m3U8Entity = (M3U8Entity) DbEntity.findFirst(M3U8Entity.class, "filePath=?", this.downloadPath);
        }
        return this.m3U8Entity;
    }

    public String getMd5Code() {
        return this.md5Code;
    }

    public String getRealUrl() {
        return isRedirect() ? getRedirectUrl() : getUrl();
    }

    public String getServerFileName() {
        return this.serverFileName;
    }

    @Override // com.arialyy.aria.core.common.AbsEntity
    public int getTaskType() {
        if (getUrl() == null) {
            return 0;
        }
        if (!getUrl().startsWith("http")) {
            if (getUrl().startsWith("ftp")) {
                return 3;
            }
            return getUrl().startsWith("sftp") ? 12 : 0;
        }
        M3U8Entity m3U8Entity = getM3U8Entity();
        if (m3U8Entity == null) {
            return 1;
        }
        return m3U8Entity.isLive() ? 8 : 7;
    }

    public void setDisposition(String str) {
        this.disposition = str;
    }

    public DownloadEntity setFilePath(String str) {
        this.downloadPath = str;
        return this;
    }

    public void setGroupHash(String str) {
        this.groupHash = str;
    }

    public void setMd5Code(String str) {
        this.md5Code = str;
    }

    public void setServerFileName(String str) {
        this.serverFileName = str;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("DownloadEntity{downloadPath='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.downloadPath);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", groupHash='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.groupHash);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", fileName='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getFileName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", md5Code='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.md5Code);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", disposition='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.disposition);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", serverFileName='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.serverFileName);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // com.arialyy.aria.core.common.AbsNormalEntity, com.arialyy.aria.core.common.AbsEntity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.downloadPath);
        parcel.writeString(this.groupHash);
        parcel.writeString(this.md5Code);
        parcel.writeString(this.disposition);
        parcel.writeString(this.serverFileName);
        parcel.writeParcelable(this.m3U8Entity, i);
    }
}
