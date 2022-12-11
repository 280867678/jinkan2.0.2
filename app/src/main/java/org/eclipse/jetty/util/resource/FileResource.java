package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import me.tvspark.outline;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class FileResource extends URLResource {
    public static final Logger LOG = Log.getLogger(FileResource.class);
    public static boolean __checkAliases = true;
    public transient URL _alias = null;
    public transient boolean _aliasChecked = false;
    public File _file;

    public FileResource(URL url) throws IOException, URISyntaxException {
        super(url, null);
        File file;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        try {
            this._file = new File(new URI(url.toString()));
        } catch (URISyntaxException e) {
            throw e;
        } catch (Exception e2) {
            LOG.ignore(e2);
            try {
                URI uri = new URI("file:" + URIUtil.encodePath(url.toString().substring(5)));
                if (uri.getAuthority() == null) {
                    file = new File(uri);
                } else {
                    file = new File("//" + uri.getAuthority() + URIUtil.decodePath(url.getFile()));
                }
                this._file = file;
            } catch (Exception e3) {
                LOG.ignore(e3);
                checkConnection();
                Permission permission = this._connection.getPermission();
                this._file = new File(permission == null ? url.getFile() : permission.getName());
            }
        }
        if (this._file.isDirectory()) {
            if (this._urlString.endsWith("/")) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this._urlString, "/");
        } else if (!this._urlString.endsWith("/")) {
            return;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this._urlString, -1, 0);
        }
        this._urlString = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public FileResource(URL url, URLConnection uRLConnection, File file) {
        super(url, uRLConnection);
        this._file = file;
        if (!file.isDirectory() || this._urlString.endsWith("/")) {
            return;
        }
        this._urlString = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this._urlString, "/");
    }

    public static boolean getCheckAliases() {
        return __checkAliases;
    }

    public static void setCheckAliases(boolean z) {
        __checkAliases = z;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public Resource addPath(String str) throws IOException, MalformedURLException {
        URLResource uRLResource;
        String canonicalPath = URIUtil.canonicalPath(str);
        if ("/".equals(canonicalPath)) {
            return this;
        }
        if (!isDirectory()) {
            uRLResource = (FileResource) super.addPath(canonicalPath);
            String str2 = uRLResource._urlString;
        } else if (canonicalPath == null) {
            throw new MalformedURLException();
        } else {
            uRLResource = (URLResource) Resource.newResource(URIUtil.addPaths(this._urlString, URIUtil.encodePath(canonicalPath.startsWith("/") ? canonicalPath.substring(1) : canonicalPath)));
        }
        String encodePath = URIUtil.encodePath(canonicalPath);
        int length = uRLResource.toString().length() - encodePath.length();
        int lastIndexOf = uRLResource._urlString.lastIndexOf(encodePath, length);
        if (length != lastIndexOf && ((length - 1 != lastIndexOf || canonicalPath.endsWith("/") || !uRLResource.isDirectory()) && (uRLResource instanceof FileResource))) {
            FileResource fileResource = (FileResource) uRLResource;
            fileResource._alias = fileResource._file.getCanonicalFile().toURI().toURL();
            fileResource._aliasChecked = true;
        }
        return uRLResource;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public void copyTo(File file) throws IOException {
        if (isDirectory()) {
            C3009IO.copyDir(getFile(), file);
        } else if (!file.exists()) {
            C3009IO.copy(getFile(), file);
        } else {
            throw new IllegalArgumentException(file + " exists");
        }
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean delete() throws SecurityException {
        return this._file.delete();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String encode(String str) {
        return str;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FileResource)) {
            return false;
        }
        File file = ((FileResource) obj)._file;
        File file2 = this._file;
        if (file == file2) {
            return true;
        }
        return file2 != null && file2.equals(file);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        return this._file.exists();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URL getAlias() {
        if (__checkAliases && !this._aliasChecked) {
            try {
                String absolutePath = this._file.getAbsolutePath();
                String canonicalPath = this._file.getCanonicalPath();
                if (absolutePath.length() != canonicalPath.length() || !absolutePath.equals(canonicalPath)) {
                    this._alias = Resource.toURL(new File(canonicalPath));
                }
                this._aliasChecked = true;
                if (this._alias != null && LOG.isDebugEnabled()) {
                    Logger logger = LOG;
                    logger.debug("ALIAS abs=" + absolutePath, new Object[0]);
                    Logger logger2 = LOG;
                    logger2.debug("ALIAS can=" + canonicalPath, new Object[0]);
                }
            } catch (Exception e) {
                LOG.warn(Log.EXCEPTION, e);
                return getURL();
            }
        }
        return this._alias;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public File getFile() {
        return this._file;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this._file);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public String getName() {
        return this._file.getAbsolutePath();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public OutputStream getOutputStream() throws IOException, SecurityException {
        return new FileOutputStream(this._file);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource
    public int hashCode() {
        File file = this._file;
        return file == null ? super.hashCode() : file.hashCode();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return this._file.isDirectory();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        return this._file.lastModified();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public long length() {
        return this._file.length();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public String[] list() {
        String[] list = this._file.list();
        if (list == null) {
            return null;
        }
        int length = list.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return list;
            }
            if (new File(this._file, list[i]).isDirectory() && !list[i].endsWith("/")) {
                list[i] = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), list[i], "/");
            }
            length = i;
        }
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean renameTo(Resource resource) throws SecurityException {
        if (resource instanceof FileResource) {
            return this._file.renameTo(((FileResource) resource)._file);
        }
        return false;
    }
}
