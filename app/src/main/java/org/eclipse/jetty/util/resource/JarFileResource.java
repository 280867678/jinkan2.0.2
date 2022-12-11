package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import me.tvspark.outline;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class JarFileResource extends JarResource {
    public static final Logger LOG = Log.getLogger(JarFileResource.class);
    public boolean _directory;
    public JarEntry _entry;
    public boolean _exists;
    public File _file;
    public JarFile _jarFile;
    public String _jarUrl;
    public String[] _list;
    public String _path;

    public JarFileResource(URL url) {
        super(url);
    }

    public JarFileResource(URL url, boolean z) {
        super(url, z);
    }

    public static Resource getNonCachingResource(Resource resource) {
        return !(resource instanceof JarFileResource) ? resource : new JarFileResource(((JarFileResource) resource).getURL(), false);
    }

    private List<String> listEntries() {
        checkConnection();
        ArrayList arrayList = new ArrayList(32);
        JarFile jarFile = this._jarFile;
        if (jarFile == null) {
            try {
                JarURLConnection jarURLConnection = (JarURLConnection) new URL(this._jarUrl).openConnection();
                jarURLConnection.setUseCaches(getUseCaches());
                jarFile = jarURLConnection.getJarFile();
            } catch (Exception e) {
                e.printStackTrace();
                LOG.ignore(e);
            }
        }
        Enumeration<JarEntry> entries = jarFile.entries();
        String str = this._urlString;
        String substring = str.substring(str.indexOf("!/") + 2);
        while (entries.hasMoreElements()) {
            String replace = entries.nextElement().getName().replace('\\', '/');
            if (replace.startsWith(substring) && replace.length() != substring.length()) {
                String substring2 = replace.substring(substring.length());
                int indexOf = substring2.indexOf(47);
                if (indexOf >= 0) {
                    if (indexOf != 0 || substring2.length() != 1) {
                        substring2 = indexOf == 0 ? substring2.substring(indexOf + 1, substring2.length()) : substring2.substring(0, indexOf + 1);
                        if (arrayList.contains(substring2)) {
                        }
                    }
                }
                arrayList.add(substring2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.jar.JarEntry, java.util.jar.JarFile, java.lang.String[], java.io.File] */
    @Override // org.eclipse.jetty.util.resource.JarResource, org.eclipse.jetty.util.resource.URLResource
    public boolean checkConnection() {
        try {
            super.checkConnection();
            return this._jarFile != null;
        } finally {
            if (this._jarConnection == null) {
                this._entry = null;
                this._file = null;
                this._jarFile = null;
                this._list = null;
            }
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String encode(String str) {
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c9, code lost:
        r7._directory = true;
     */
    @Override // org.eclipse.jetty.util.resource.JarResource, org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean exists() {
        boolean z = true;
        if (this._exists) {
            return true;
        }
        if (this._urlString.endsWith("!/")) {
            try {
                return Resource.newResource(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this._urlString, -2, 4)).exists();
            } catch (Exception e) {
                LOG.ignore(e);
                return false;
            }
        }
        boolean checkConnection = checkConnection();
        if (this._jarUrl != null && this._path == null) {
            this._directory = checkConnection;
            return true;
        }
        JarFile jarFile = null;
        if (checkConnection) {
            jarFile = this._jarFile;
        } else {
            try {
                JarURLConnection jarURLConnection = (JarURLConnection) new URL(this._jarUrl).openConnection();
                jarURLConnection.setUseCaches(getUseCaches());
                jarFile = jarURLConnection.getJarFile();
            } catch (Exception e2) {
                LOG.ignore(e2);
            }
        }
        if (jarFile != null && this._entry == null && !this._directory) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (true) {
                if (!entries.hasMoreElements()) {
                    break;
                }
                JarEntry nextElement = entries.nextElement();
                String replace = nextElement.getName().replace('\\', '/');
                if (!replace.equals(this._path)) {
                    if (!this._path.endsWith("/")) {
                        if (replace.startsWith(this._path) && replace.length() > this._path.length() && replace.charAt(this._path.length()) == '/') {
                            break;
                        }
                    } else if (replace.startsWith(this._path)) {
                        break;
                    }
                } else {
                    this._entry = nextElement;
                    this._directory = this._path.endsWith("/");
                    break;
                }
            }
            if (this._directory && !this._urlString.endsWith("/")) {
                this._urlString = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this._urlString, "/");
                try {
                    this._url = new URL(this._urlString);
                } catch (MalformedURLException e3) {
                    LOG.warn(e3);
                }
            }
        }
        if (!this._directory && this._entry == null) {
            z = false;
        }
        this._exists = z;
        return z;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean isContainedIn(Resource resource) throws MalformedURLException {
        String str = this._urlString;
        int indexOf = str.indexOf("!/");
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        if (str.startsWith("jar:")) {
            str = str.substring(4);
        }
        return new URL(str).sameFile(resource.getURL());
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return this._urlString.endsWith("/") || (exists() && this._directory);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        JarEntry jarEntry;
        if (!checkConnection() || this._file == null) {
            return -1L;
        }
        return (!exists() || (jarEntry = this._entry) == null) ? this._file.lastModified() : jarEntry.getTime();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public long length() {
        JarEntry jarEntry;
        if (!isDirectory() && (jarEntry = this._entry) != null) {
            return jarEntry.getSize();
        }
        return -1L;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public synchronized String[] list() {
        List<String> listEntries;
        if (isDirectory() && this._list == null) {
            try {
                listEntries = listEntries();
            } catch (Exception e) {
                Logger logger = LOG;
                logger.warn("Retrying list:" + e, new Object[0]);
                LOG.debug(e);
                release();
                listEntries = listEntries();
            }
            if (listEntries != null) {
                String[] strArr = new String[listEntries.size()];
                this._list = strArr;
                listEntries.toArray(strArr);
            }
        }
        return this._list;
    }

    @Override // org.eclipse.jetty.util.resource.JarResource
    public synchronized void newConnection() throws IOException {
        super.newConnection();
        this._entry = null;
        this._file = null;
        this._jarFile = null;
        this._list = null;
        int indexOf = this._urlString.indexOf("!/") + 2;
        this._jarUrl = this._urlString.substring(0, indexOf);
        String substring = this._urlString.substring(indexOf);
        this._path = substring;
        if (substring.length() == 0) {
            this._path = null;
        }
        this._jarFile = this._jarConnection.getJarFile();
        this._file = new File(this._jarFile.getName());
    }

    @Override // org.eclipse.jetty.util.resource.JarResource, org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public synchronized void release() {
        this._list = null;
        this._entry = null;
        this._file = null;
        if (!getUseCaches() && this._jarFile != null) {
            try {
                Logger logger = LOG;
                logger.debug("Closing JarFile " + this._jarFile.getName(), new Object[0]);
                this._jarFile.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
        this._jarFile = null;
        super.release();
    }
}
