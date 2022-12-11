package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import me.tvspark.outline;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public abstract class Resource implements ResourceFactory {
    public static final Logger LOG = Log.getLogger(Resource.class);
    public static boolean __defaultUseCaches = true;
    public volatile Object _associate;

    public static String deTag(String str) {
        return StringUtil.replace(StringUtil.replace(str, "<", "&lt;"), ">", "&gt;");
    }

    public static boolean getDefaultUseCaches() {
        return __defaultUseCaches;
    }

    public static String hrefEncodeURI(String str) {
        StringBuffer stringBuffer;
        String str2;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == '\'' || charAt == '<' || charAt == '>') {
                stringBuffer = new StringBuffer(str.length() << 1);
                break;
            }
        }
        stringBuffer = null;
        if (stringBuffer == null) {
            return str;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt2 = str.charAt(i2);
            if (charAt2 == '\"') {
                str2 = "%22";
            } else if (charAt2 == '\'') {
                str2 = "%27";
            } else if (charAt2 == '<') {
                str2 = "%3C";
            } else if (charAt2 != '>') {
                stringBuffer.append(charAt2);
            } else {
                str2 = "%3E";
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public static boolean isContainedIn(Resource resource, Resource resource2) throws MalformedURLException {
        return resource.isContainedIn(resource2);
    }

    public static Resource newClassPathResource(String str) {
        return newClassPathResource(str, true, false);
    }

    public static Resource newClassPathResource(String str, boolean z, boolean z2) {
        URL resource = Resource.class.getResource(str);
        if (resource == null) {
            resource = Loader.getResource(Resource.class, str, z2);
        }
        if (resource == null) {
            return null;
        }
        return newResource(resource, z);
    }

    public static Resource newResource(File file) throws MalformedURLException, IOException {
        File canonicalFile = file.getCanonicalFile();
        URL url = toURL(canonicalFile);
        return new FileResource(url, url.openConnection(), canonicalFile);
    }

    public static Resource newResource(String str) throws MalformedURLException, IOException {
        return newResource(str, __defaultUseCaches);
    }

    public static Resource newResource(String str, boolean z) throws MalformedURLException, IOException {
        try {
            return newResource(new URL(str));
        } catch (MalformedURLException e) {
            if (str.startsWith("ftp:") || str.startsWith("file:") || str.startsWith("jar:")) {
                LOG.warn(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bad Resource: ", str), new Object[0]);
                throw e;
            }
            try {
                if (str.startsWith("./")) {
                    str = str.substring(2);
                }
                File canonicalFile = new File(str).getCanonicalFile();
                URL url = toURL(canonicalFile);
                URLConnection openConnection = url.openConnection();
                openConnection.setUseCaches(z);
                return new FileResource(url, openConnection, canonicalFile);
            } catch (Exception e2) {
                LOG.debug(Log.EXCEPTION, e2);
                throw e;
            }
        }
    }

    public static Resource newResource(URI uri) throws IOException {
        return newResource(uri.toURL());
    }

    public static Resource newResource(URL url) throws IOException {
        return newResource(url, __defaultUseCaches);
    }

    public static Resource newResource(URL url, boolean z) {
        if (url == null) {
            return null;
        }
        String externalForm = url.toExternalForm();
        if (!externalForm.startsWith("file:")) {
            return externalForm.startsWith("jar:file:") ? new JarFileResource(url, z) : externalForm.startsWith("jar:") ? new JarResource(url, z) : new URLResource(url, null, z);
        }
        try {
            return new FileResource(url);
        } catch (Exception e) {
            LOG.debug(Log.EXCEPTION, e);
            return new BadResource(url, e.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Resource newSystemResource(String str) throws IOException {
        URL resource;
        ClassLoader classLoader;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                resource = contextClassLoader.getResource(str);
                if (resource == null && str.startsWith("/")) {
                    resource = contextClassLoader.getResource(str.substring(1));
                }
            } catch (IllegalArgumentException unused) {
            }
            if (resource == null && (classLoader = Resource.class.getClassLoader()) != null && (resource = classLoader.getResource(str)) == null && str.startsWith("/")) {
                resource = classLoader.getResource(str.substring(1));
            }
            if (resource == null && (resource = ClassLoader.getSystemResource(str)) == null && str.startsWith("/")) {
                resource = ClassLoader.getSystemResource(str.substring(1));
            }
            if (resource == null) {
                return newResource(resource);
            }
            return null;
        }
        resource = null;
        if (resource == null) {
            resource = classLoader.getResource(str.substring(1));
        }
        if (resource == null) {
            resource = ClassLoader.getSystemResource(str.substring(1));
        }
        if (resource == null) {
        }
    }

    public static void setDefaultUseCaches(boolean z) {
        __defaultUseCaches = z;
    }

    public static URL toURL(File file) throws MalformedURLException {
        return file.toURI().toURL();
    }

    public abstract Resource addPath(String str) throws IOException, MalformedURLException;

    public void copyTo(File file) throws IOException {
        if (!file.exists()) {
            writeTo(new FileOutputStream(file), 0L, -1L);
            return;
        }
        throw new IllegalArgumentException(file + " exists");
    }

    public abstract boolean delete() throws SecurityException;

    public String encode(String str) {
        return URIUtil.encodePath(str);
    }

    public abstract boolean exists();

    public void finalize() {
        release();
    }

    public URL getAlias() {
        return null;
    }

    public Object getAssociate() {
        return this._associate;
    }

    public abstract File getFile() throws IOException;

    public abstract InputStream getInputStream() throws IOException;

    public String getListHTML(String str, boolean z) throws IOException {
        String[] list;
        String canonicalPath = URIUtil.canonicalPath(str);
        if (canonicalPath == null || !isDirectory() || (list = list()) == null) {
            return null;
        }
        Arrays.sort(list);
        String decodePath = URIUtil.decodePath(canonicalPath);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Directory: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(deTag(decodePath));
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        StringBuilder sb2 = new StringBuilder(4096);
        sb2.append("<HTML><HEAD>");
        sb2.append("<LINK HREF=\"");
        sb2.append("jetty-dir.css");
        sb2.append("\" REL=\"stylesheet\" TYPE=\"text/css\"/><TITLE>");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, sb, "</TITLE></HEAD><BODY>\n<H1>", sb, "</H1>\n<TABLE BORDER=0>\n");
        if (z) {
            sb2.append("<TR><TD><A HREF=\"");
            sb2.append(URIUtil.addPaths(canonicalPath, "../"));
            sb2.append("\">Parent Directory</A></TD><TD></TD><TD></TD></TR>\n");
        }
        String hrefEncodeURI = hrefEncodeURI(canonicalPath);
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        for (int i = 0; i < list.length; i++) {
            Resource addPath = addPath(list[i]);
            sb2.append("\n<TR><TD><A HREF=\"");
            String addPaths = URIUtil.addPaths(hrefEncodeURI, URIUtil.encodePath(list[i]));
            sb2.append(addPaths);
            if (addPath.isDirectory() && !addPaths.endsWith("/")) {
                sb2.append("/");
            }
            sb2.append("\">");
            sb2.append(deTag(list[i]));
            sb2.append("&nbsp;");
            sb2.append("</A></TD><TD ALIGN=right>");
            sb2.append(addPath.length());
            sb2.append(" bytes&nbsp;</TD><TD>");
            sb2.append(dateTimeInstance.format(new Date(addPath.lastModified())));
            sb2.append("</TD></TR>");
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "</TABLE>\n", "</BODY></HTML>\n");
    }

    public abstract String getName();

    public abstract OutputStream getOutputStream() throws IOException, SecurityException;

    @Override // org.eclipse.jetty.util.resource.ResourceFactory
    public Resource getResource(String str) {
        try {
            return addPath(str);
        } catch (Exception e) {
            LOG.debug(e);
            return null;
        }
    }

    public URI getURI() {
        try {
            return getURL().toURI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract URL getURL();

    public String getWeakETag() {
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append("W/\"");
            String name = getName();
            int length = name.length();
            long j = 0;
            for (int i = 0; i < length; i++) {
                j = (j * 31) + name.charAt(i);
            }
            B64Code.encode(lastModified() ^ j, sb);
            B64Code.encode(length() ^ j, sb);
            sb.append('\"');
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract boolean isContainedIn(Resource resource) throws MalformedURLException;

    public abstract boolean isDirectory();

    public abstract long lastModified();

    public abstract long length();

    public abstract String[] list();

    public abstract void release();

    public abstract boolean renameTo(Resource resource) throws SecurityException;

    public void setAssociate(Object obj) {
        this._associate = obj;
    }

    public void writeTo(OutputStream outputStream, long j, long j2) throws IOException {
        InputStream inputStream = getInputStream();
        try {
            inputStream.skip(j);
            if (j2 < 0) {
                C3009IO.copy(inputStream, outputStream);
            } else {
                C3009IO.copy(inputStream, outputStream, j2);
            }
        } finally {
            inputStream.close();
        }
    }
}
