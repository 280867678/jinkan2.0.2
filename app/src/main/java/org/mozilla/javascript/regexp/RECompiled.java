package org.mozilla.javascript.regexp;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class RECompiled implements Serializable {
    public static final long serialVersionUID = -6144956577595844213L;
    public int anchorCh = -1;
    public int classCount;
    public RECharSet[] classList;
    public int flags;
    public int parenCount;
    public byte[] program;
    public final char[] source;

    public RECompiled(String str) {
        this.source = str.toCharArray();
    }
}
