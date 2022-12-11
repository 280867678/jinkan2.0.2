package org.apache.commons.p056io.input;

/* renamed from: org.apache.commons.io.input.TailerListener */
/* loaded from: classes4.dex */
public interface TailerListener {
    void fileNotFound();

    void fileRotated();

    void handle(Exception exc);

    void handle(String str);

    void init(Tailer tailer);
}
