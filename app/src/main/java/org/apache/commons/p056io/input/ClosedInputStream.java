package org.apache.commons.p056io.input;

import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.ClosedInputStream */
/* loaded from: classes4.dex */
public class ClosedInputStream extends InputStream {
    public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }
}
