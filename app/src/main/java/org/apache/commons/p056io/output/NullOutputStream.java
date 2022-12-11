package org.apache.commons.p056io.output;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.NullOutputStream */
/* loaded from: classes4.dex */
public class NullOutputStream extends OutputStream {
    public static final NullOutputStream NULL_OUTPUT_STREAM = new NullOutputStream();

    @Override // java.io.OutputStream
    public void write(int i) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
    }
}
