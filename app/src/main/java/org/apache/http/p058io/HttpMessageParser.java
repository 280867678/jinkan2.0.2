package org.apache.http.p058io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

/* renamed from: org.apache.http.io.HttpMessageParser */
/* loaded from: classes4.dex */
public interface HttpMessageParser<T extends HttpMessage> {
    T parse() throws IOException, HttpException;
}
