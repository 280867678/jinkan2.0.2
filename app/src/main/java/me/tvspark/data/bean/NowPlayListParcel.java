package me.tvspark.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.sk0;

/* loaded from: classes4.dex */
public class NowPlayListParcel implements Serializable, sk0 {
    public List<EpisodeParcel> episodeListPlay = new ArrayList();
    public int channelPlay = 0;

    public void clear() {
        this.episodeListPlay.clear();
    }

    public int getChannelPlay() {
        return this.channelPlay;
    }

    public List<EpisodeParcel> getEpisodeListPlay() {
        return this.episodeListPlay;
    }

    public void setData(List<EpisodeParcel> list, int i) {
        this.channelPlay = i;
        this.episodeListPlay.clear();
        this.episodeListPlay.addAll(list);
    }
}
