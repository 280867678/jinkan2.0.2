package org.seamless.http;

import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class Representation<E> implements Serializable {
    public CacheControl cacheControl;
    public Integer contentLength;
    public String contentType;
    public E entity;
    public String entityTag;
    public Long lastModified;
    public URL url;

    public Representation(URL url, CacheControl cacheControl, Integer num, String str, Long l, String str2, E e) {
        this.url = url;
        this.cacheControl = cacheControl;
        this.contentLength = num;
        this.contentType = str;
        this.lastModified = l;
        this.entityTag = str2;
        this.entity = e;
    }

    public Representation(URLConnection uRLConnection, E e) {
        this(uRLConnection.getURL(), CacheControl.valueOf(uRLConnection.getHeaderField("Cache-Control")), Integer.valueOf(uRLConnection.getContentLength()), uRLConnection.getContentType(), Long.valueOf(uRLConnection.getLastModified()), uRLConnection.getHeaderField("Etag"), e);
    }

    public Representation(CacheControl cacheControl, Integer num, String str, Long l, String str2, E e) {
        this(null, cacheControl, num, str, l, str2, e);
    }

    public CacheControl getCacheControl() {
        return this.cacheControl;
    }

    public Integer getContentLength() {
        Integer num = this.contentLength;
        if (num == null || num.intValue() == -1) {
            return null;
        }
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public E getEntity() {
        return this.entity;
    }

    public String getEntityTag() {
        return this.entityTag;
    }

    public Long getLastModified() {
        if (this.lastModified.longValue() == 0) {
            return null;
        }
        return this.lastModified;
    }

    public Long getMaxAgeOrNull() {
        if (getCacheControl() == null || getCacheControl().getMaxAge() == -1 || getCacheControl().getMaxAge() == 0) {
            return null;
        }
        return Long.valueOf(getCacheControl().getMaxAge());
    }

    public URL getUrl() {
        return this.url;
    }

    public boolean hasBeenModified(long j) {
        return getLastModified() == null || getLastModified().longValue() < j;
    }

    public boolean hasEntityTagChanged(String str) {
        return getEntityTag() != null && !getEntityTag().equals(str);
    }

    public boolean isExpired(long j) {
        return getMaxAgeOrNull() == null || isExpired(j, getMaxAgeOrNull().longValue());
    }

    public boolean isExpired(long j, long j2) {
        return (j2 * 1000) + j < new Date().getTime();
    }

    public boolean isNoCache() {
        return getCacheControl() != null && getCacheControl().isNoCache();
    }

    public boolean isNoStore() {
        return getCacheControl() != null && getCacheControl().isNoStore();
    }

    public boolean mustRevalidate() {
        return getCacheControl() != null && getCacheControl().isProxyRevalidate();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Representation.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") CT: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getContentType());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
