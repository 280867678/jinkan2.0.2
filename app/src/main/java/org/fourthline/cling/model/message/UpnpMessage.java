package org.fourthline.cling.model.message;

import java.io.UnsupportedEncodingException;
import me.tvspark.outline;
import org.fourthline.cling.model.message.UpnpOperation;
import org.fourthline.cling.model.message.header.ContentTypeHeader;
import org.fourthline.cling.model.message.header.UpnpHeader;

/* loaded from: classes5.dex */
public abstract class UpnpMessage<O extends UpnpOperation> {
    public Object body;
    public BodyType bodyType;
    public UpnpHeaders headers;
    public O operation;
    public int udaMajorVersion;
    public int udaMinorVersion;

    /* loaded from: classes5.dex */
    public enum BodyType {
        STRING,
        BYTES
    }

    public UpnpMessage(UpnpMessage<O> upnpMessage) {
        this.udaMajorVersion = 1;
        this.udaMinorVersion = 0;
        this.headers = new UpnpHeaders();
        this.bodyType = BodyType.STRING;
        this.operation = upnpMessage.getOperation();
        this.headers = upnpMessage.getHeaders();
        this.body = upnpMessage.getBody();
        this.bodyType = upnpMessage.getBodyType();
        this.udaMajorVersion = upnpMessage.getUdaMajorVersion();
        this.udaMinorVersion = upnpMessage.getUdaMinorVersion();
    }

    public UpnpMessage(O o) {
        this.udaMajorVersion = 1;
        this.udaMinorVersion = 0;
        this.headers = new UpnpHeaders();
        this.bodyType = BodyType.STRING;
        this.operation = o;
    }

    public UpnpMessage(O o, BodyType bodyType, Object obj) {
        this.udaMajorVersion = 1;
        this.udaMinorVersion = 0;
        this.headers = new UpnpHeaders();
        this.bodyType = BodyType.STRING;
        this.operation = o;
        this.bodyType = bodyType;
        this.body = obj;
    }

    public Object getBody() {
        return this.body;
    }

    public byte[] getBodyBytes() {
        try {
            if (!hasBody()) {
                return null;
            }
            return getBodyType().equals(BodyType.STRING) ? getBodyString().getBytes() : (byte[]) getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getBodyString() {
        try {
            if (!hasBody()) {
                return null;
            }
            if (!getBodyType().equals(BodyType.STRING)) {
                return new String((byte[]) getBody(), "UTF-8");
            }
            String str = (String) getBody();
            return str.charAt(0) == 65279 ? str.substring(1) : str;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BodyType getBodyType() {
        return this.bodyType;
    }

    public String getContentTypeCharset() {
        ContentTypeHeader contentTypeHeader = getContentTypeHeader();
        if (contentTypeHeader != null) {
            return contentTypeHeader.getValue().getParameters().get("charset");
        }
        return null;
    }

    public ContentTypeHeader getContentTypeHeader() {
        return (ContentTypeHeader) getHeaders().getFirstHeader(UpnpHeader.Type.CONTENT_TYPE, ContentTypeHeader.class);
    }

    public UpnpHeaders getHeaders() {
        return this.headers;
    }

    public O getOperation() {
        return this.operation;
    }

    public int getUdaMajorVersion() {
        return this.udaMajorVersion;
    }

    public int getUdaMinorVersion() {
        return this.udaMinorVersion;
    }

    public boolean hasBody() {
        return getBody() != null;
    }

    public boolean hasHostHeader() {
        return getHeaders().getFirstHeader(UpnpHeader.Type.HOST) != null;
    }

    public boolean isBodyNonEmptyString() {
        return hasBody() && getBodyType().equals(BodyType.STRING) && getBodyString().length() > 0;
    }

    public boolean isContentTypeMissingOrText() {
        ContentTypeHeader contentTypeHeader = getContentTypeHeader();
        return contentTypeHeader == null || contentTypeHeader.isText();
    }

    public boolean isContentTypeText() {
        ContentTypeHeader contentTypeHeader = getContentTypeHeader();
        return contentTypeHeader != null && contentTypeHeader.isText();
    }

    public boolean isContentTypeTextUDA() {
        ContentTypeHeader contentTypeHeader = getContentTypeHeader();
        return contentTypeHeader != null && contentTypeHeader.isUDACompliantXML();
    }

    public void setBody(String str) {
        this.bodyType = BodyType.STRING;
        this.body = str;
    }

    public void setBody(BodyType bodyType, Object obj) {
        this.bodyType = bodyType;
        this.body = obj;
    }

    public void setBodyCharacters(byte[] bArr) throws UnsupportedEncodingException {
        setBody(BodyType.STRING, new String(bArr, getContentTypeCharset() != null ? getContentTypeCharset() : "UTF-8"));
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public void setHeaders(UpnpHeaders upnpHeaders) {
        this.headers = upnpHeaders;
    }

    public void setUdaMajorVersion(int i) {
        this.udaMajorVersion = i;
    }

    public void setUdaMinorVersion(int i) {
        this.udaMinorVersion = i;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getOperation().toString());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
