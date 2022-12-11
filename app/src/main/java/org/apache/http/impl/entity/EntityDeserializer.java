package org.apache.http.impl.entity;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.p057io.ChunkedInputStream;
import org.apache.http.impl.p057io.ContentLengthInputStream;
import org.apache.http.impl.p057io.IdentityInputStream;
import org.apache.http.p058io.SessionInputBuffer;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
@Deprecated
/* loaded from: classes4.dex */
public class EntityDeserializer {
    public final ContentLengthStrategy lenStrategy;

    public EntityDeserializer(ContentLengthStrategy contentLengthStrategy) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(contentLengthStrategy, "Content length strategy");
    }

    public HttpEntity deserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) throws HttpException, IOException {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(httpMessage, "HTTP message");
        return doDeserialize(sessionInputBuffer, httpMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BasicHttpEntity doDeserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) throws HttpException, IOException {
        InputStream identityInputStream;
        Header firstHeader;
        Header firstHeader2;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long determineLength = this.lenStrategy.determineLength(httpMessage);
        if (determineLength == -2) {
            basicHttpEntity.setChunked(true);
            basicHttpEntity.setContentLength(-1L);
            identityInputStream = new ChunkedInputStream(sessionInputBuffer);
        } else {
            int i = (determineLength > (-1L) ? 1 : (determineLength == (-1L) ? 0 : -1));
            basicHttpEntity.setChunked(false);
            if (i != 0) {
                basicHttpEntity.setContentLength(determineLength);
                basicHttpEntity.setContent(new ContentLengthInputStream(sessionInputBuffer, determineLength));
                firstHeader = httpMessage.getFirstHeader("Content-Type");
                if (firstHeader != null) {
                    basicHttpEntity.setContentType(firstHeader);
                }
                firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
                if (firstHeader2 != null) {
                    basicHttpEntity.setContentEncoding(firstHeader2);
                }
                return basicHttpEntity;
            }
            basicHttpEntity.setContentLength(-1L);
            identityInputStream = new IdentityInputStream(sessionInputBuffer);
        }
        basicHttpEntity.setContent(identityInputStream);
        firstHeader = httpMessage.getFirstHeader("Content-Type");
        if (firstHeader != null) {
        }
        firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
        }
        return basicHttpEntity;
    }
}
