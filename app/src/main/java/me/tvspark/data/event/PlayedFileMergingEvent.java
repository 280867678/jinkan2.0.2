package me.tvspark.data.event;

/* loaded from: classes4.dex */
public class PlayedFileMergingEvent extends BaseEvent {
    public long currentPlayPos;
    public String mergedFilePath;
    public String videoTitle;

    public PlayedFileMergingEvent(String str, String str2, long j) {
        this.videoTitle = str;
        this.mergedFilePath = str2;
        this.currentPlayPos = j;
    }

    public long getCurrentPlayPos() {
        return this.currentPlayPos;
    }

    public String getMergedFilePath() {
        return this.mergedFilePath;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public void setCurrentPlayPos(long j) {
        this.currentPlayPos = j;
    }

    public void setMergedFilePath(String str) {
        this.mergedFilePath = str;
    }

    public void setVideoTitle(String str) {
        this.videoTitle = str;
    }
}
