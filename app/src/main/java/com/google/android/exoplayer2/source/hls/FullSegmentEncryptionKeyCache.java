package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class FullSegmentEncryptionKeyCache {
    public final LinkedHashMap<Uri, byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public FullSegmentEncryptionKeyCache(final int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LinkedHashMap<Uri, byte[]>(this, i + 1, 1.0f, false) { // from class: com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
                return size() > i;
            }
        };
    }
}
