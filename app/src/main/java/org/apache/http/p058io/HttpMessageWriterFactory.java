package org.apache.http.p058io;

import org.apache.http.HttpMessage;

/* renamed from: org.apache.http.io.HttpMessageWriterFactory */
/* loaded from: classes4.dex */
public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}
