package org.apache.commons.p056io.input;

import java.io.IOException;

/* renamed from: org.apache.commons.io.input.XmlStreamReaderException */
/* loaded from: classes4.dex */
public class XmlStreamReaderException extends IOException {
    public static final long serialVersionUID = 1;
    public final String bomEncoding;
    public final String contentTypeEncoding;
    public final String contentTypeMime;
    public final String xmlEncoding;
    public final String xmlGuessEncoding;

    public XmlStreamReaderException(String str, String str2, String str3, String str4) {
        this(str, null, null, str2, str3, str4);
    }

    public XmlStreamReaderException(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str);
        this.contentTypeMime = str2;
        this.contentTypeEncoding = str3;
        this.bomEncoding = str4;
        this.xmlGuessEncoding = str5;
        this.xmlEncoding = str6;
    }

    public String getBomEncoding() {
        return this.bomEncoding;
    }

    public String getContentTypeEncoding() {
        return this.contentTypeEncoding;
    }

    public String getContentTypeMime() {
        return this.contentTypeMime;
    }

    public String getXmlEncoding() {
        return this.xmlEncoding;
    }

    public String getXmlGuessEncoding() {
        return this.xmlGuessEncoding;
    }
}
