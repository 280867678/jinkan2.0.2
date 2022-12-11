package org.mozilla.javascript.commonjs.module.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jetty.http.HttpHeaderValues;

/* loaded from: classes5.dex */
public class UrlModuleSourceProvider extends ModuleSourceProviderBase {
    public static final long serialVersionUID = 1;
    public final Iterable<URI> fallbackUris;
    public final Iterable<URI> privilegedUris;
    public final UrlConnectionExpiryCalculator urlConnectionExpiryCalculator;
    public final UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider;

    /* loaded from: classes5.dex */
    public static class URLValidator implements Serializable {
        public static final long serialVersionUID = 1;
        public final String entityTags;
        public long expiry;
        public final long lastModified;
        public final URI uri;

        public URLValidator(URI uri, URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) {
            this.uri = uri;
            this.lastModified = uRLConnection.getLastModified();
            this.entityTags = getEntityTags(uRLConnection);
            this.expiry = calculateExpiry(uRLConnection, j, urlConnectionExpiryCalculator);
        }

        private long calculateExpiry(URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) {
            if (HttpHeaderValues.NO_CACHE.equals(uRLConnection.getHeaderField("Pragma"))) {
                return 0L;
            }
            String headerField = uRLConnection.getHeaderField("Cache-Control");
            if (headerField != null) {
                if (headerField.indexOf(HttpHeaderValues.NO_CACHE) != -1) {
                    return 0L;
                }
                int maxAge = getMaxAge(headerField);
                if (-1 != maxAge) {
                    long currentTimeMillis = System.currentTimeMillis();
                    return (maxAge * 1000) + (currentTimeMillis - ((currentTimeMillis - j) + Math.max(Math.max(0L, currentTimeMillis - uRLConnection.getDate()), uRLConnection.getHeaderFieldInt("Age", 0) * 1000)));
                }
            }
            long headerFieldDate = uRLConnection.getHeaderFieldDate("Expires", -1L);
            if (headerFieldDate != -1) {
                return headerFieldDate;
            }
            if (urlConnectionExpiryCalculator != null) {
                return urlConnectionExpiryCalculator.calculateExpiry(uRLConnection);
            }
            return 0L;
        }

        private String getEntityTags(URLConnection uRLConnection) {
            List<String> list = uRLConnection.getHeaderFields().get("ETag");
            if (list == null || list.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (true) {
                sb.append(it.next());
                if (!it.hasNext()) {
                    return sb.toString();
                }
                sb.append(", ");
            }
        }

        private int getMaxAge(String str) {
            int indexOf;
            int indexOf2 = str.indexOf("max-age");
            if (indexOf2 == -1 || (indexOf = str.indexOf(61, indexOf2 + 7)) == -1) {
                return -1;
            }
            int i = indexOf + 1;
            int indexOf3 = str.indexOf(44, i);
            try {
                return Integer.parseInt(indexOf3 == -1 ? str.substring(i) : str.substring(i, indexOf3));
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        private boolean isResourceChanged(URLConnection uRLConnection) throws IOException {
            return uRLConnection instanceof HttpURLConnection ? ((HttpURLConnection) uRLConnection).getResponseCode() == 304 : this.lastModified != uRLConnection.getLastModified();
        }

        public boolean appliesTo(URI uri) {
            return this.uri.equals(uri);
        }

        public void applyConditionals(URLConnection uRLConnection) {
            long j = this.lastModified;
            if (j != 0) {
                uRLConnection.setIfModifiedSince(j);
            }
            String str = this.entityTags;
            if (str == null || str.length() <= 0) {
                return;
            }
            uRLConnection.addRequestProperty("If-None-Match", this.entityTags);
        }

        public boolean entityNeedsRevalidation() {
            return System.currentTimeMillis() > this.expiry;
        }

        public boolean updateValidator(URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) throws IOException {
            boolean isResourceChanged = isResourceChanged(uRLConnection);
            if (!isResourceChanged) {
                this.expiry = calculateExpiry(uRLConnection, j, urlConnectionExpiryCalculator);
            }
            return isResourceChanged;
        }
    }

    public UrlModuleSourceProvider(Iterable<URI> iterable, Iterable<URI> iterable2) {
        this(iterable, iterable2, new DefaultUrlConnectionExpiryCalculator(), null);
    }

    public UrlModuleSourceProvider(Iterable<URI> iterable, Iterable<URI> iterable2, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator, UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider) {
        this.privilegedUris = iterable;
        this.fallbackUris = iterable2;
        this.urlConnectionExpiryCalculator = urlConnectionExpiryCalculator;
        this.urlConnectionSecurityDomainProvider = urlConnectionSecurityDomainProvider;
    }

    private void close(URLConnection uRLConnection) {
        try {
            uRLConnection.getInputStream().close();
        } catch (IOException e) {
            onFailedClosingUrlConnection(uRLConnection, e);
        }
    }

    public static String getCharacterEncoding(URLConnection uRLConnection) {
        ParsedContentType parsedContentType = new ParsedContentType(uRLConnection.getContentType());
        String encoding = parsedContentType.getEncoding();
        if (encoding != null) {
            return encoding;
        }
        String contentType = parsedContentType.getContentType();
        return (contentType == null || !contentType.startsWith("text/")) ? "utf-8" : "8859_1";
    }

    public static Reader getReader(URLConnection uRLConnection) throws IOException {
        return new InputStreamReader(uRLConnection.getInputStream(), getCharacterEncoding(uRLConnection));
    }

    private Object getSecurityDomain(URLConnection uRLConnection) {
        UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider = this.urlConnectionSecurityDomainProvider;
        if (urlConnectionSecurityDomainProvider == null) {
            return null;
        }
        return urlConnectionSecurityDomainProvider.getSecurityDomain(uRLConnection);
    }

    private ModuleSource loadFromPathList(String str, Object obj, Iterable<URI> iterable) throws IOException, URISyntaxException {
        if (iterable == null) {
            return null;
        }
        for (URI uri : iterable) {
            ModuleSource loadFromUri = loadFromUri(uri.resolve(str), uri, obj);
            if (loadFromUri != null) {
                return loadFromUri;
            }
        }
        return null;
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    public boolean entityNeedsRevalidation(Object obj) {
        return !(obj instanceof URLValidator) || ((URLValidator) obj).entityNeedsRevalidation();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r15.appliesTo(r13) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ModuleSource loadFromActualUri(URI uri, URI uri2, Object obj) throws IOException {
        URLValidator uRLValidator;
        URL url = new URL(uri2 == null ? null : uri2.toURL(), uri.toString());
        long currentTimeMillis = System.currentTimeMillis();
        URLConnection openUrlConnection = openUrlConnection(url);
        if (obj instanceof URLValidator) {
            uRLValidator = (URLValidator) obj;
        }
        uRLValidator = null;
        if (uRLValidator != null) {
            uRLValidator.applyConditionals(openUrlConnection);
        }
        try {
            openUrlConnection.connect();
            if (uRLValidator == null || uRLValidator.updateValidator(openUrlConnection, currentTimeMillis, this.urlConnectionExpiryCalculator)) {
                return new ModuleSource(getReader(openUrlConnection), getSecurityDomain(openUrlConnection), uri, uri2, new URLValidator(uri, openUrlConnection, currentTimeMillis, this.urlConnectionExpiryCalculator));
            }
            close(openUrlConnection);
            return ModuleSourceProvider.NOT_MODIFIED;
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException e) {
            close(openUrlConnection);
            throw e;
        } catch (RuntimeException e2) {
            close(openUrlConnection);
            throw e2;
        }
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    public ModuleSource loadFromFallbackLocations(String str, Object obj) throws IOException, URISyntaxException {
        return loadFromPathList(str, obj, this.fallbackUris);
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    public ModuleSource loadFromPrivilegedLocations(String str, Object obj) throws IOException, URISyntaxException {
        return loadFromPathList(str, obj, this.privilegedUris);
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    public ModuleSource loadFromUri(URI uri, URI uri2, Object obj) throws IOException, URISyntaxException {
        ModuleSource loadFromActualUri = loadFromActualUri(new URI(uri + ".js"), uri2, obj);
        return loadFromActualUri != null ? loadFromActualUri : loadFromActualUri(uri, uri2, obj);
    }

    public void onFailedClosingUrlConnection(URLConnection uRLConnection, IOException iOException) {
    }

    public URLConnection openUrlConnection(URL url) throws IOException {
        return url.openConnection();
    }
}
