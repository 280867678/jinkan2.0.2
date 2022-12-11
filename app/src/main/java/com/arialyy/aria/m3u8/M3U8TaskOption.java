package com.arialyy.aria.m3u8;

import com.arialyy.aria.core.inf.ITaskOption;
import com.arialyy.aria.core.processor.IBandWidthUrlConverter;
import com.arialyy.aria.core.processor.IKeyUrlConverter;
import com.arialyy.aria.core.processor.ILiveTsUrlConverter;
import com.arialyy.aria.core.processor.ITsMergeHandler;
import com.arialyy.aria.core.processor.IVodTsUrlConverter;
import java.lang.ref.SoftReference;
import java.util.List;

/* loaded from: classes3.dex */
public final class M3U8TaskOption implements ITaskOption {
    public String bandWidthUrl;
    public SoftReference<IBandWidthUrlConverter> bandWidthUrlConverter;
    public String cacheDir;
    public long duration;
    public int jumpIndex;
    public String keyPath;
    public SoftReference<IKeyUrlConverter> keyUrlConverter;
    public SoftReference<ILiveTsUrlConverter> liveTsUrlConverter;
    public SoftReference<ITsMergeHandler> mergeHandler;
    public List<String> urls;
    public SoftReference<IVodTsUrlConverter> vodUrlConverter;
    public boolean mergeFile = true;
    public int completeNum = 0;
    public int bandWidth = 0;
    public long liveUpdateInterval = 10000;
    public int maxTsQueueNum = 4;
    public boolean generateIndexFile = false;
    public boolean ignoreFailureTs = false;

    public int getBandWidth() {
        return this.bandWidth;
    }

    public String getBandWidthUrl() {
        return this.bandWidthUrl;
    }

    public IBandWidthUrlConverter getBandWidthUrlConverter() {
        SoftReference<IBandWidthUrlConverter> softReference = this.bandWidthUrlConverter;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public String getCacheDir() {
        return this.cacheDir;
    }

    public int getCompleteNum() {
        return this.completeNum;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getJumpIndex() {
        return this.jumpIndex;
    }

    public String getKeyPath() {
        return this.keyPath;
    }

    public IKeyUrlConverter getKeyUrlConverter() {
        SoftReference<IKeyUrlConverter> softReference = this.keyUrlConverter;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public ILiveTsUrlConverter getLiveTsUrlConverter() {
        SoftReference<ILiveTsUrlConverter> softReference = this.liveTsUrlConverter;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public long getLiveUpdateInterval() {
        long j = this.liveUpdateInterval;
        if (j == 0) {
            return 10000L;
        }
        return j;
    }

    public int getMaxTsQueueNum() {
        int i = this.maxTsQueueNum;
        if (i == 0) {
            return 4;
        }
        return i;
    }

    public ITsMergeHandler getMergeHandler() {
        SoftReference<ITsMergeHandler> softReference = this.mergeHandler;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public IVodTsUrlConverter getVodUrlConverter() {
        SoftReference<IVodTsUrlConverter> softReference = this.vodUrlConverter;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public boolean isGenerateIndexFile() {
        return this.generateIndexFile;
    }

    public boolean isIgnoreFailureTs() {
        return this.ignoreFailureTs;
    }

    public boolean isMergeFile() {
        return this.mergeFile;
    }

    public void setBandWidth(int i) {
        this.bandWidth = i;
    }

    public void setBandWidthUrl(String str) {
        this.bandWidthUrl = str;
    }

    public void setBandWidthUrlConverter(IBandWidthUrlConverter iBandWidthUrlConverter) {
        this.bandWidthUrlConverter = new SoftReference<>(iBandWidthUrlConverter);
    }

    public void setCacheDir(String str) {
        this.cacheDir = str;
    }

    public void setCompleteNum(int i) {
        this.completeNum = i;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setGenerateIndexFile(boolean z) {
        this.generateIndexFile = z;
    }

    public void setIgnoreFailureTs(boolean z) {
        this.ignoreFailureTs = z;
    }

    public void setJumpIndex(int i) {
        this.jumpIndex = i;
    }

    public void setKeyUrlConverter(IKeyUrlConverter iKeyUrlConverter) {
        this.keyUrlConverter = new SoftReference<>(iKeyUrlConverter);
    }

    public void setLiveTsUrlConverter(ILiveTsUrlConverter iLiveTsUrlConverter) {
        this.liveTsUrlConverter = new SoftReference<>(iLiveTsUrlConverter);
    }

    public void setLiveUpdateInterval(long j) {
        this.liveUpdateInterval = j;
    }

    public void setMaxTsQueueNum(int i) {
        this.maxTsQueueNum = i;
    }

    public void setMergeFile(boolean z) {
        this.mergeFile = z;
    }

    public void setMergeHandler(ITsMergeHandler iTsMergeHandler) {
        this.mergeHandler = new SoftReference<>(iTsMergeHandler);
    }

    public void setUrls(List<String> list) {
        this.urls = list;
    }

    public void setVodUrlConverter(IVodTsUrlConverter iVodTsUrlConverter) {
        this.vodUrlConverter = new SoftReference<>(iVodTsUrlConverter);
    }
}
