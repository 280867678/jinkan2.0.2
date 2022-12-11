package org.eclipse.jetty.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.View;
import org.eclipse.jetty.p059io.nio.DirectNIOBuffer;
import org.eclipse.jetty.p059io.nio.IndirectNIOBuffer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceFactory;

/* loaded from: classes4.dex */
public class ResourceCache {
    public static final Logger LOG = Log.getLogger(ResourceCache.class);
    public final boolean _etags;
    public final ResourceFactory _factory;
    public final MimeTypes _mimeTypes;
    public final ResourceCache _parent;
    public boolean _useFileMappedBuffer;
    public int _maxCachedFileSize = 4194304;
    public int _maxCachedFiles = 2048;
    public int _maxCacheSize = 33554432;
    public final ConcurrentMap<String, Content> _cache = new ConcurrentHashMap();
    public final AtomicInteger _cachedSize = new AtomicInteger();
    public final AtomicInteger _cachedFiles = new AtomicInteger();

    /* loaded from: classes4.dex */
    public class Content implements HttpContent {
        public final Buffer _contentType;
        public final Buffer _etagBuffer;
        public final String _key;
        public volatile long _lastAccessed;
        public final long _lastModified;
        public final Buffer _lastModifiedBytes;
        public final int _length;
        public final Resource _resource;
        public AtomicReference<Buffer> _indirectBuffer = new AtomicReference<>();
        public AtomicReference<Buffer> _directBuffer = new AtomicReference<>();

        public Content(String str, Resource resource) {
            this._key = str;
            this._resource = resource;
            this._contentType = ResourceCache.this._mimeTypes.getMimeByExtension(this._resource.toString());
            boolean exists = resource.exists();
            long lastModified = exists ? resource.lastModified() : -1L;
            this._lastModified = lastModified;
            ByteArrayBuffer byteArrayBuffer = null;
            this._lastModifiedBytes = lastModified < 0 ? null : new ByteArrayBuffer(HttpFields.formatDate(this._lastModified));
            this._length = exists ? (int) resource.length() : 0;
            ResourceCache.this._cachedSize.addAndGet(this._length);
            ResourceCache.this._cachedFiles.incrementAndGet();
            this._lastAccessed = System.currentTimeMillis();
            this._etagBuffer = ResourceCache.this._etags ? new ByteArrayBuffer(resource.getWeakETag()) : byteArrayBuffer;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public long getContentLength() {
            return this._length;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public Buffer getContentType() {
            return this._contentType;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public Buffer getDirectBuffer() {
            Buffer buffer = this._directBuffer.get();
            if (buffer == null) {
                Buffer directBuffer = ResourceCache.this.getDirectBuffer(this._resource);
                if (directBuffer == null) {
                    Logger logger = ResourceCache.LOG;
                    logger.warn("Could not load " + this, new Object[0]);
                } else {
                    buffer = this._directBuffer.compareAndSet(null, directBuffer) ? directBuffer : this._directBuffer.get();
                }
            }
            if (buffer == null) {
                return null;
            }
            return new View(buffer);
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public Buffer getETag() {
            return this._etagBuffer;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public Buffer getIndirectBuffer() {
            Buffer buffer = this._indirectBuffer.get();
            if (buffer == null) {
                Buffer indirectBuffer = ResourceCache.this.getIndirectBuffer(this._resource);
                if (indirectBuffer == null) {
                    Logger logger = ResourceCache.LOG;
                    logger.warn("Could not load " + this, new Object[0]);
                } else {
                    buffer = this._indirectBuffer.compareAndSet(null, indirectBuffer) ? indirectBuffer : this._indirectBuffer.get();
                }
            }
            if (buffer == null) {
                return null;
            }
            return new View(buffer);
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public InputStream getInputStream() throws IOException {
            Buffer indirectBuffer = getIndirectBuffer();
            return (indirectBuffer == null || indirectBuffer.array() == null) ? this._resource.getInputStream() : new ByteArrayInputStream(indirectBuffer.array(), indirectBuffer.getIndex(), indirectBuffer.length());
        }

        public String getKey() {
            return this._key;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public Buffer getLastModified() {
            return this._lastModifiedBytes;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public Resource getResource() {
            return this._resource;
        }

        public void invalidate() {
            ResourceCache.this._cachedSize.addAndGet(-this._length);
            ResourceCache.this._cachedFiles.decrementAndGet();
            this._resource.release();
        }

        public boolean isCached() {
            return this._key != null;
        }

        public boolean isMiss() {
            return false;
        }

        public boolean isValid() {
            if (this._lastModified == this._resource.lastModified() && this._length == this._resource.length()) {
                this._lastAccessed = System.currentTimeMillis();
                return true;
            } else if (this != ResourceCache.this._cache.remove(this._key)) {
                return false;
            } else {
                invalidate();
                return false;
            }
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public void release() {
        }

        public String toString() {
            Resource resource = this._resource;
            return String.format("%s %s %d %s %s", resource, Boolean.valueOf(resource.exists()), Long.valueOf(this._resource.lastModified()), this._contentType, this._lastModifiedBytes);
        }
    }

    public ResourceCache(ResourceCache resourceCache, ResourceFactory resourceFactory, MimeTypes mimeTypes, boolean z, boolean z2) {
        this._useFileMappedBuffer = true;
        this._factory = resourceFactory;
        this._mimeTypes = mimeTypes;
        this._parent = resourceCache;
        this._etags = z2;
        this._useFileMappedBuffer = z;
    }

    private HttpContent load(String str, Resource resource) throws IOException {
        if (resource == null || !resource.exists()) {
            return null;
        }
        if (resource.isDirectory() || !isCacheable(resource)) {
            return new HttpContent.ResourceAsHttpContent(resource, this._mimeTypes.getMimeByExtension(resource.toString()), getMaxCachedFileSize(), this._etags);
        }
        Content content = new Content(str, resource);
        shrinkCache();
        Content putIfAbsent = this._cache.putIfAbsent(str, content);
        if (putIfAbsent == null) {
            return content;
        }
        content.invalidate();
        return putIfAbsent;
    }

    private void shrinkCache() {
        while (this._cache.size() > 0) {
            if (this._cachedFiles.get() <= this._maxCachedFiles && this._cachedSize.get() <= this._maxCacheSize) {
                return;
            }
            TreeSet treeSet = new TreeSet(new Comparator<Content>() { // from class: org.eclipse.jetty.server.ResourceCache.1
                @Override // java.util.Comparator
                public int compare(Content content, Content content2) {
                    if (content._lastAccessed < content2._lastAccessed) {
                        return -1;
                    }
                    if (content._lastAccessed > content2._lastAccessed) {
                        return 1;
                    }
                    if (content._length >= content2._length) {
                        return content._key.compareTo(content2._key);
                    }
                    return -1;
                }
            });
            for (Content content : this._cache.values()) {
                treeSet.add(content);
            }
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                Content content2 = (Content) it.next();
                if (this._cachedFiles.get() > this._maxCachedFiles || this._cachedSize.get() > this._maxCacheSize) {
                    if (content2 == this._cache.remove(content2.getKey())) {
                        content2.invalidate();
                    }
                }
            }
        }
    }

    public void flushCache() {
        if (this._cache == null) {
            return;
        }
        while (this._cache.size() > 0) {
            for (String str : this._cache.keySet()) {
                Content remove = this._cache.remove(str);
                if (remove != null) {
                    remove.invalidate();
                }
            }
        }
    }

    public int getCachedFiles() {
        return this._cachedFiles.get();
    }

    public int getCachedSize() {
        return this._cachedSize.get();
    }

    public Buffer getDirectBuffer(Resource resource) {
        try {
            if (this._useFileMappedBuffer && resource.getFile() != null) {
                return new DirectNIOBuffer(resource.getFile());
            }
            int length = (int) resource.length();
            if (length >= 0) {
                DirectNIOBuffer directNIOBuffer = new DirectNIOBuffer(length);
                InputStream inputStream = resource.getInputStream();
                directNIOBuffer.readFrom(inputStream, length);
                inputStream.close();
                return directNIOBuffer;
            }
            Logger logger = LOG;
            logger.warn("invalid resource: " + String.valueOf(resource) + StringUtils.SPACE + length, new Object[0]);
            return null;
        } catch (IOException e) {
            LOG.warn(e);
            return null;
        }
    }

    public Buffer getIndirectBuffer(Resource resource) {
        try {
            int length = (int) resource.length();
            if (length >= 0) {
                IndirectNIOBuffer indirectNIOBuffer = new IndirectNIOBuffer(length);
                InputStream inputStream = resource.getInputStream();
                indirectNIOBuffer.readFrom(inputStream, length);
                inputStream.close();
                return indirectNIOBuffer;
            }
            Logger logger = LOG;
            logger.warn("invalid resource: " + String.valueOf(resource) + StringUtils.SPACE + length, new Object[0]);
            return null;
        } catch (IOException e) {
            LOG.warn(e);
            return null;
        }
    }

    public int getMaxCacheSize() {
        return this._maxCacheSize;
    }

    public int getMaxCachedFileSize() {
        return this._maxCachedFileSize;
    }

    public int getMaxCachedFiles() {
        return this._maxCachedFiles;
    }

    public boolean isCacheable(Resource resource) {
        long length = resource.length();
        return length > 0 && length < ((long) this._maxCachedFileSize) && length < ((long) this._maxCacheSize);
    }

    public boolean isUseFileMappedBuffer() {
        return this._useFileMappedBuffer;
    }

    public HttpContent lookup(String str) throws IOException {
        HttpContent lookup;
        Content content = this._cache.get(str);
        if (content == null || !content.isValid()) {
            HttpContent load = load(str, this._factory.getResource(str));
            if (load != null) {
                return load;
            }
            ResourceCache resourceCache = this._parent;
            if (resourceCache != null && (lookup = resourceCache.lookup(str)) != null) {
                return lookup;
            }
            return null;
        }
        return content;
    }

    public void setMaxCacheSize(int i) {
        this._maxCacheSize = i;
        shrinkCache();
    }

    public void setMaxCachedFileSize(int i) {
        this._maxCachedFileSize = i;
        shrinkCache();
    }

    public void setMaxCachedFiles(int i) {
        this._maxCachedFiles = i;
        shrinkCache();
    }

    public void setUseFileMappedBuffer(boolean z) {
        this._useFileMappedBuffer = z;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ResourceCache[");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._parent);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._factory);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]@");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(hashCode());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
