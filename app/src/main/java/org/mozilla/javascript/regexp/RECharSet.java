package org.mozilla.javascript.regexp;

import java.io.Serializable;

/* loaded from: classes5.dex */
public final class RECharSet implements Serializable {
    public static final long serialVersionUID = 7931787979395898394L;
    public volatile transient byte[] bits;
    public volatile transient boolean converted;
    public final int length;
    public final boolean sense;
    public final int startIndex;
    public final int strlength;

    public RECharSet(int i, int i2, int i3, boolean z) {
        this.length = i;
        this.startIndex = i2;
        this.strlength = i3;
        this.sense = z;
    }
}
