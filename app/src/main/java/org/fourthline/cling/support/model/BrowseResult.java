package org.fourthline.cling.support.model;

import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;

/* loaded from: classes5.dex */
public class BrowseResult {
    public UnsignedIntegerFourBytes containerUpdateID;
    public UnsignedIntegerFourBytes count;
    public String result;
    public UnsignedIntegerFourBytes totalMatches;

    public BrowseResult(String str, long j, long j2) {
        this(str, j, j2, 0L);
    }

    public BrowseResult(String str, long j, long j2, long j3) {
        this(str, new UnsignedIntegerFourBytes(j), new UnsignedIntegerFourBytes(j2), new UnsignedIntegerFourBytes(j3));
    }

    public BrowseResult(String str, UnsignedIntegerFourBytes unsignedIntegerFourBytes, UnsignedIntegerFourBytes unsignedIntegerFourBytes2, UnsignedIntegerFourBytes unsignedIntegerFourBytes3) {
        this.result = str;
        this.count = unsignedIntegerFourBytes;
        this.totalMatches = unsignedIntegerFourBytes2;
        this.containerUpdateID = unsignedIntegerFourBytes3;
    }

    public UnsignedIntegerFourBytes getContainerUpdateID() {
        return this.containerUpdateID;
    }

    public long getContainerUpdateIDLong() {
        return this.containerUpdateID.getValue().longValue();
    }

    public UnsignedIntegerFourBytes getCount() {
        return this.count;
    }

    public long getCountLong() {
        return this.count.getValue().longValue();
    }

    public String getResult() {
        return this.result;
    }

    public UnsignedIntegerFourBytes getTotalMatches() {
        return this.totalMatches;
    }

    public long getTotalMatchesLong() {
        return this.totalMatches.getValue().longValue();
    }
}
