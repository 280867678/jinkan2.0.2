package com.arialyy.aria.core.event;

/* loaded from: classes3.dex */
public class PeerIndexEvent {
    public long createTime = System.currentTimeMillis();
    public String key;
    public int peerIndex;

    public PeerIndexEvent(String str, int i) {
        this.peerIndex = i;
        this.key = str;
    }
}
