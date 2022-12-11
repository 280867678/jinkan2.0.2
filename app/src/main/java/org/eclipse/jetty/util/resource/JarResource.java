package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import me.tvspark.outline;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class JarResource extends URLResource {
    public static final Logger LOG = Log.getLogger(JarResource.class);
    public JarURLConnection _jarConnection;

    public JarResource(URL url) {
        super(url, null);
    }

    public JarResource(URL url, boolean z) {
        super(url, null, z);
    }

    public static Resource newJarResource(Resource resource) throws IOException {
        if (resource instanceof JarResource) {
            return resource;
        }
        return Resource.newResource("jar:" + resource + "!/");
    }

    @Override // org.eclipse.jetty.util.resource.URLResource
    public synchronized boolean checkConnection() {
        super.checkConnection();
        try {
            if (this._jarConnection != this._connection) {
                newConnection();
            }
        } catch (IOException e) {
            LOG.ignore(e);
            this._jarConnection = null;
        }
        return this._jarConnection != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (r7.equals("") == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e5, code lost:
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00e3, code lost:
        if (r7.startsWith(r0) == false) goto L39;
     */
    @Override // org.eclipse.jetty.util.resource.Resource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void copyTo(File file) throws IOException {
        Manifest manifest;
        boolean z;
        if (!exists()) {
            return;
        }
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            logger.debug("Extract " + this + " to " + file, new Object[0]);
        }
        String trim = getURL().toExternalForm().trim();
        int indexOf = trim.indexOf("!/");
        int i = indexOf >= 0 ? 4 : 0;
        if (indexOf < 0) {
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Not a valid jar url: ", trim));
        }
        URL url = new URL(trim.substring(i, indexOf));
        int i2 = indexOf + 2;
        FileOutputStream fileOutputStream = null;
        String substring = i2 < trim.length() ? trim.substring(i2) : null;
        boolean z2 = substring != null && substring.endsWith("/");
        if (LOG.isDebugEnabled()) {
            Logger logger2 = LOG;
            logger2.debug("Extracting entry = " + substring + " from jar " + url, new Object[0]);
        }
        JarInputStream jarInputStream = new JarInputStream(url.openConnection().getInputStream());
        while (true) {
            JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
            if (nextJarEntry == null) {
                break;
            }
            String name = nextJarEntry.getName();
            if (substring == null || !name.startsWith(substring)) {
                if (substring != null) {
                }
                z = true;
            } else {
                if (!z2 && substring.length() + 1 == name.length() && name.endsWith("/")) {
                    z2 = true;
                }
                if (z2) {
                    name = name.substring(substring.length());
                }
                z = true;
            }
            if (!z) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Skipping entry: ", name), new Object[0]);
                }
            } else if (URIUtil.canonicalPath(name.replace('\\', '/')) != null) {
                File file2 = new File(file, name);
                if (!nextJarEntry.isDirectory()) {
                    File file3 = new File(file2.getParent());
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            C3009IO.copy(jarInputStream, fileOutputStream2);
                            C3009IO.close((OutputStream) fileOutputStream2);
                            if (nextJarEntry.getTime() >= 0) {
                                file2.setLastModified(nextJarEntry.getTime());
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            C3009IO.close((OutputStream) fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else if (!file2.exists()) {
                    file2.mkdirs();
                }
            } else if (LOG.isDebugEnabled()) {
                LOG.debug(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid entry: ", name), new Object[0]);
            }
        }
        if ((substring == null || substring.equalsIgnoreCase("META-INF/MANIFEST.MF")) && (manifest = jarInputStream.getManifest()) != null) {
            File file4 = new File(file, "META-INF");
            file4.mkdir();
            FileOutputStream fileOutputStream3 = new FileOutputStream(new File(file4, "MANIFEST.MF"));
            manifest.write(fileOutputStream3);
            fileOutputStream3.close();
        }
        C3009IO.close((InputStream) jarInputStream);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        return this._urlString.endsWith("!/") ? checkConnection() : super.exists();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public File getFile() throws IOException {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public InputStream getInputStream() throws IOException {
        checkConnection();
        return !this._urlString.endsWith("!/") ? new FilterInputStream(super.getInputStream()) { // from class: org.eclipse.jetty.util.resource.JarResource.1
            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                ((FilterInputStream) this).in = C3009IO.getClosedStream();
            }
        } : new URL(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this._urlString, -2, 4)).openStream();
    }

    public void newConnection() throws IOException {
        this._jarConnection = (JarURLConnection) this._connection;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public synchronized void release() {
        this._jarConnection = null;
        super.release();
    }
}
