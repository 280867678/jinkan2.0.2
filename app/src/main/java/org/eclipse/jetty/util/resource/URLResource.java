package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class URLResource extends Resource {
    public static final Logger LOG = Log.getLogger(URLResource.class);
    public URLConnection _connection;
    public InputStream _in;
    public URL _url;
    public String _urlString;
    public transient boolean _useCaches;

    public URLResource(URL url, URLConnection uRLConnection) {
        this._in = null;
        this._useCaches = Resource.__defaultUseCaches;
        this._url = url;
        this._urlString = url.toString();
        this._connection = uRLConnection;
    }

    public URLResource(URL url, URLConnection uRLConnection, boolean z) {
        this(url, uRLConnection);
        this._useCaches = z;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public Resource addPath(String str) throws IOException, MalformedURLException {
        if (str == null) {
            return null;
        }
        return Resource.newResource(URIUtil.addPaths(this._url.toExternalForm(), URIUtil.canonicalPath(str)));
    }

    public synchronized boolean checkConnection() {
        if (this._connection == null) {
            try {
                URLConnection openConnection = this._url.openConnection();
                this._connection = openConnection;
                openConnection.setUseCaches(this._useCaches);
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
        return this._connection != null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean delete() throws SecurityException {
        throw new SecurityException("Delete not supported");
    }

    public boolean equals(Object obj) {
        return (obj instanceof URLResource) && this._urlString.equals(((URLResource) obj)._urlString);
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        try {
            synchronized (this) {
                if (checkConnection() && this._in == null) {
                    this._in = this._connection.getInputStream();
                }
            }
        } catch (IOException e) {
            LOG.ignore(e);
        }
        return this._in != null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public File getFile() throws IOException {
        if (checkConnection()) {
            Permission permission = this._connection.getPermission();
            if (permission instanceof FilePermission) {
                return new File(permission.getName());
            }
        }
        try {
            return new File(this._url.getFile());
        } catch (Exception e) {
            LOG.ignore(e);
            return null;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public synchronized InputStream getInputStream() throws IOException {
        if (checkConnection()) {
            if (this._in == null) {
                InputStream inputStream = this._connection.getInputStream();
                this._connection = null;
                return inputStream;
            }
            InputStream inputStream2 = this._in;
            this._in = null;
            this._connection = null;
            return inputStream2;
        }
        throw new IOException("Invalid resource");
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String getName() {
        return this._url.toExternalForm();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public OutputStream getOutputStream() throws IOException, SecurityException {
        throw new IOException("Output not supported");
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URL getURL() {
        return this._url;
    }

    public boolean getUseCaches() {
        return this._useCaches;
    }

    public int hashCode() {
        return this._urlString.hashCode();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isContainedIn(Resource resource) throws MalformedURLException {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return exists() && this._url.toString().endsWith("/");
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        if (checkConnection()) {
            return this._connection.getLastModified();
        }
        return -1L;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long length() {
        if (checkConnection()) {
            return this._connection.getContentLength();
        }
        return -1L;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String[] list() {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public synchronized void release() {
        if (this._in != null) {
            try {
                this._in.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
            this._in = null;
        }
        if (this._connection != null) {
            this._connection = null;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean renameTo(Resource resource) throws SecurityException {
        throw new SecurityException("RenameTo not supported");
    }

    public String toString() {
        return this._urlString;
    }
}
