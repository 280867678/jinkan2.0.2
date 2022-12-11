package org.apache.commons.p056io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.Appendable;

/* renamed from: org.apache.commons.io.output.AppendableOutputStream */
/* loaded from: classes4.dex */
public class AppendableOutputStream<T extends Appendable> extends OutputStream {
    public final T appendable;

    public AppendableOutputStream(T t) {
        this.appendable = t;
    }

    public T getAppendable() {
        return this.appendable;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.appendable.append((char) i);
    }
}
