package org.apache.http.p058io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

/* renamed from: org.apache.http.io.HttpMessageWriter */
/* loaded from: classes4.dex */
public interface HttpMessageWriter<T extends HttpMessage> {
    void write(T t) throws IOException, HttpException;
}
