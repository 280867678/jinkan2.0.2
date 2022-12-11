package com.arialyy.aria.core.download;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.orm.annotation.Default;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.DbDataHelper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class M3U8Entity extends DbEntity implements Parcelable {
    public static final Parcelable.Creator<M3U8Entity> CREATOR = new Parcelable.Creator<M3U8Entity>() { // from class: com.arialyy.aria.core.download.M3U8Entity.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public M3U8Entity mo4419createFromParcel(Parcel parcel) {
            return new M3U8Entity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public M3U8Entity[] mo4420newArray(int i) {
            return new M3U8Entity[i];
        }
    };
    public String cacheDir;
    public String filePath;
    public boolean isLive;

    /* renamed from: iv */
    public String f163iv;
    public String keyFormat;
    public String keyPath;
    public String keyUrl;
    public String method;
    public int peerIndex;
    public int peerNum;
    @Default("1")
    public String keyFormatVersion = "1";
    public String localM3u8Path = "";

    /* loaded from: classes3.dex */
    public static class PeerInfo {
        public int peerId;
        public String peerPath;

        public PeerInfo(int i, String str) {
            this.peerId = i;
            this.peerPath = str;
        }
    }

    public M3U8Entity() {
    }

    public M3U8Entity(Parcel parcel) {
        this.filePath = parcel.readString();
        this.peerIndex = parcel.readInt();
        this.peerNum = parcel.readInt();
        this.isLive = parcel.readByte() != 0;
        this.cacheDir = parcel.readString();
        this.keyPath = parcel.readString();
        this.keyUrl = parcel.readString();
        this.method = parcel.readString();
        this.f163iv = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCacheDir() {
        return this.cacheDir;
    }

    public List<PeerInfo> getCompletedPeer() {
        List<ThreadRecord> list;
        List<ThreadRecord> list2;
        if (TextUtils.isEmpty(getCacheDir())) {
            ALog.m4185w("M3U8Entity", "任务未下载，获取切片失败");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        TaskRecord taskRecord = DbDataHelper.getTaskRecord(this.filePath, this.isLive ? 8 : 7);
        File file = new File(getCacheDir());
        if ((taskRecord == null || (list2 = taskRecord.threadRecords) == null || list2.isEmpty()) && !file.exists()) {
            return null;
        }
        if (taskRecord == null || (list = taskRecord.threadRecords) == null || (list.isEmpty() && file.exists())) {
            String[] list3 = file.list(new FilenameFilter() { // from class: com.arialyy.aria.core.download.M3U8Entity.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return str.endsWith(".ts");
                }
            });
            for (String str : list3) {
                arrayList.add(new PeerInfo(Integer.parseInt(str.substring(0, str.lastIndexOf(".ts"))), getCacheDir().concat("/").concat(str)));
            }
            return arrayList;
        }
        List<ThreadRecord> list4 = taskRecord.threadRecords;
        if (list4 == null || list4.isEmpty() || !file.exists()) {
            return null;
        }
        for (ThreadRecord threadRecord : taskRecord.threadRecords) {
            if (threadRecord.isComplete) {
                String format = String.format("%s/%s.ts", file, Integer.valueOf(threadRecord.threadId));
                if (new File(format).exists()) {
                    arrayList.add(new PeerInfo(threadRecord.threadId, format));
                }
            }
        }
        return arrayList;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getIv() {
        return this.f163iv;
    }

    public String getKeyFormat() {
        return this.keyFormat;
    }

    public String getKeyFormatVersion() {
        return this.keyFormatVersion;
    }

    public String getKeyPath() {
        return this.keyPath;
    }

    public String getKeyUrl() {
        return this.keyUrl;
    }

    public String getLocalM3u8Path() {
        return this.localM3u8Path;
    }

    public String getMethod() {
        return this.method;
    }

    public int getPeerIndex() {
        return this.peerIndex;
    }

    public int getPeerNum() {
        return this.peerNum;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void setCacheDir(String str) {
        this.cacheDir = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setIv(String str) {
        this.f163iv = str;
    }

    public void setKeyFormat(String str) {
        this.keyFormat = str;
    }

    public void setKeyFormatVersion(String str) {
        this.keyFormatVersion = str;
    }

    public void setKeyPath(String str) {
        this.keyPath = str;
    }

    public void setKeyUrl(String str) {
        this.keyUrl = str;
    }

    public void setLive(boolean z) {
        this.isLive = z;
    }

    public void setLocalM3u8Path(String str) {
        this.localM3u8Path = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setPeerIndex(int i) {
        this.peerIndex = i;
    }

    public void setPeerNum(int i) {
        this.peerNum = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.filePath);
        parcel.writeInt(this.peerIndex);
        parcel.writeInt(this.peerNum);
        parcel.writeByte(this.isLive ? (byte) 1 : (byte) 0);
        parcel.writeString(this.cacheDir);
        parcel.writeString(this.keyPath);
        parcel.writeString(this.keyUrl);
        parcel.writeString(this.method);
        parcel.writeString(this.f163iv);
    }
}
