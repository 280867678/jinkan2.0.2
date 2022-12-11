package org.seamless.xml;

import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.logging.Logger;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

/* loaded from: classes5.dex */
public class CatalogResourceResolver implements LSResourceResolver {
    public static Logger log = Logger.getLogger(CatalogResourceResolver.class.getName());
    public final Map<URI, URL> catalog;

    /* loaded from: classes5.dex */
    public static final class Input implements LSInput {

        /* renamed from: in */
        public InputStream f5024in;

        public Input(InputStream inputStream) {
            this.f5024in = inputStream;
        }

        @Override // org.w3c.dom.ls.LSInput
        public String getBaseURI() {
            return null;
        }

        @Override // org.w3c.dom.ls.LSInput
        public InputStream getByteStream() {
            return this.f5024in;
        }

        @Override // org.w3c.dom.ls.LSInput
        public boolean getCertifiedText() {
            return false;
        }

        @Override // org.w3c.dom.ls.LSInput
        public Reader getCharacterStream() {
            return null;
        }

        @Override // org.w3c.dom.ls.LSInput
        public String getEncoding() {
            return null;
        }

        @Override // org.w3c.dom.ls.LSInput
        public String getPublicId() {
            return null;
        }

        @Override // org.w3c.dom.ls.LSInput
        public String getStringData() {
            return null;
        }

        @Override // org.w3c.dom.ls.LSInput
        public String getSystemId() {
            return null;
        }

        @Override // org.w3c.dom.ls.LSInput
        public void setBaseURI(String str) {
        }

        @Override // org.w3c.dom.ls.LSInput
        public void setByteStream(InputStream inputStream) {
        }

        @Override // org.w3c.dom.ls.LSInput
        public void setCertifiedText(boolean z) {
        }

        @Override // org.w3c.dom.ls.LSInput
        public void setCharacterStream(Reader reader) {
        }

        @Override // org.w3c.dom.ls.LSInput
        public void setEncoding(String str) {
        }

        @Override // org.w3c.dom.ls.LSInput
        public void setPublicId(String str) {
        }

        @Override // org.w3c.dom.ls.LSInput
        public void setStringData(String str) {
        }

        @Override // org.w3c.dom.ls.LSInput
        public void setSystemId(String str) {
        }
    }

    public CatalogResourceResolver(Map<URI, URL> map) {
        this.catalog = map;
    }

    @Override // org.w3c.dom.ls.LSResourceResolver
    public LSInput resolveResource(String str, String str2, String str3, String str4, String str5) {
        Logger logger = log;
        logger.finest("Trying to resolve system identifier URI in catalog: " + str4);
        URL url = this.catalog.get(URI.create(str4));
        if (url == null) {
            Logger logger2 = log;
            logger2.info("System identifier not found in catalog, continuing with default resolution (this most likely means remote HTTP request!): " + str4);
            return null;
        }
        Logger logger3 = log;
        logger3.finest("Loading catalog resource: " + url);
        try {
            Input input = new Input(url.openStream());
            input.setBaseURI(str5);
            input.setSystemId(str4);
            input.setPublicId(str3);
            return input;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
