package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.WriterOutputStream;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.FileResource;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes4.dex */
public class ResourceHandler extends HandlerWrapper {
    public static final Logger LOG = Log.getLogger(ResourceHandler.class);
    public boolean _aliases;
    public Resource _baseResource;
    public ByteArrayBuffer _cacheControl;
    public ContextHandler _context;
    public Resource _defaultStylesheet;
    public boolean _directory;
    public boolean _etags;
    public Resource _stylesheet;
    public String[] _welcomeFiles = {"index.html"};
    public MimeTypes _mimeTypes = new MimeTypes();

    public void doDirectory(ae0 ae0Var, ce0 ce0Var, Resource resource) throws IOException {
        if (!this._directory) {
            ce0Var.sendError(403);
            return;
        }
        String listHTML = resource.getListHTML(ae0Var.getRequestURI(), ae0Var.getPathInfo().lastIndexOf("/") > 0);
        ce0Var.setContentType(MimeTypes.TEXT_HTML__UTF_8);
        ce0Var.getWriter().println(listHTML);
    }

    public void doResponseHeaders(ce0 ce0Var, Resource resource, String str) {
        if (str != null) {
            ce0Var.setContentType(str);
        }
        long length = resource.length();
        if (!(ce0Var instanceof Response)) {
            if (length > 0) {
                ce0Var.setHeader("Content-Length", Long.toString(length));
            }
            ByteArrayBuffer byteArrayBuffer = this._cacheControl;
            if (byteArrayBuffer == null) {
                return;
            }
            ce0Var.setHeader("Cache-Control", byteArrayBuffer.toString());
            return;
        }
        HttpFields httpFields = ((Response) ce0Var).getHttpFields();
        if (length > 0) {
            httpFields.putLongField(HttpHeaders.CONTENT_LENGTH_BUFFER, length);
        }
        ByteArrayBuffer byteArrayBuffer2 = this._cacheControl;
        if (byteArrayBuffer2 == null) {
            return;
        }
        httpFields.put(HttpHeaders.CACHE_CONTROL_BUFFER, byteArrayBuffer2);
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        ContextHandler.Context currentContext = ContextHandler.getCurrentContext();
        ContextHandler contextHandler = currentContext == null ? null : currentContext.getContextHandler();
        this._context = contextHandler;
        if (contextHandler != null) {
            this._aliases = contextHandler.isAliases();
        }
        if (this._aliases || FileResource.getCheckAliases()) {
            super.doStart();
            return;
        }
        throw new IllegalStateException("Alias checking disabled");
    }

    public Resource getBaseResource() {
        Resource resource = this._baseResource;
        if (resource == null) {
            return null;
        }
        return resource;
    }

    public String getCacheControl() {
        return this._cacheControl.toString();
    }

    public MimeTypes getMimeTypes() {
        return this._mimeTypes;
    }

    public Resource getResource(String str) throws MalformedURLException {
        ContextHandler contextHandler;
        if (str == null || !str.startsWith("/")) {
            throw new MalformedURLException(str);
        }
        Resource resource = this._baseResource;
        if (resource == null && ((contextHandler = this._context) == null || (resource = contextHandler.getBaseResource()) == null)) {
            return null;
        }
        try {
            return resource.addPath(URIUtil.canonicalPath(str));
        } catch (Exception e) {
            LOG.ignore(e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (r1 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Resource getResource(ae0 ae0Var) throws MalformedURLException {
        String servletPath;
        String pathInfo;
        Boolean valueOf = Boolean.valueOf(ae0Var.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI) != null);
        if (valueOf != null && valueOf.booleanValue()) {
            servletPath = (String) ae0Var.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH);
            pathInfo = (String) ae0Var.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO);
            if (servletPath == null) {
            }
            return getResource(URIUtil.addPaths(servletPath, pathInfo));
        }
        servletPath = ae0Var.getServletPath();
        pathInfo = ae0Var.getPathInfo();
        return getResource(URIUtil.addPaths(servletPath, pathInfo));
    }

    public String getResourceBase() {
        Resource resource = this._baseResource;
        if (resource == null) {
            return null;
        }
        return resource.toString();
    }

    public Resource getStylesheet() {
        Resource resource = this._stylesheet;
        if (resource != null) {
            return resource;
        }
        if (this._defaultStylesheet == null) {
            try {
                this._defaultStylesheet = Resource.newResource(getClass().getResource("/jetty-dir.css"));
            } catch (IOException e) {
                LOG.warn(e.toString(), new Object[0]);
                LOG.debug(e);
            }
        }
        return this._defaultStylesheet;
    }

    public Resource getWelcome(Resource resource) throws MalformedURLException, IOException {
        int i = 0;
        while (true) {
            String[] strArr = this._welcomeFiles;
            if (i < strArr.length) {
                Resource addPath = resource.addPath(strArr[i]);
                if (addPath.exists() && !addPath.isDirectory()) {
                    return addPath;
                }
                i++;
            } else {
                return null;
            }
        }
    }

    public String[] getWelcomeFiles() {
        return this._welcomeFiles;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        boolean z;
        Resource resource;
        String str2;
        OutputStream writerOutputStream;
        if (request.isHandled()) {
            return;
        }
        if ("GET".equals(ae0Var.getMethod())) {
            z = false;
        } else if (!"HEAD".equals(ae0Var.getMethod())) {
            super.handle(str, request, ae0Var, ce0Var);
            return;
        } else {
            z = true;
        }
        Resource resource2 = getResource(ae0Var);
        if (resource2 == null || !resource2.exists()) {
            if (!str.endsWith("/jetty-dir.css")) {
                super.handle(str, request, ae0Var, ce0Var);
                return;
            }
            resource2 = getStylesheet();
            if (resource2 == null) {
                return;
            }
            ce0Var.setContentType("text/css");
        }
        if (!this._aliases && resource2.getAlias() != null) {
            LOG.info(resource2 + " aliased to " + resource2.getAlias(), new Object[0]);
            return;
        }
        request.setHandled(true);
        if (!resource2.isDirectory()) {
            resource = resource2;
        } else if (!ae0Var.getPathInfo().endsWith("/")) {
            ce0Var.sendRedirect(ce0Var.encodeRedirectURL(URIUtil.addPaths(ae0Var.getRequestURI(), "/")));
            return;
        } else {
            Resource welcome = getWelcome(resource2);
            if (welcome == null || !welcome.exists()) {
                doDirectory(ae0Var, ce0Var, resource2);
                request.setHandled(true);
                return;
            }
            resource = welcome;
        }
        long lastModified = resource.lastModified();
        String str3 = null;
        if (this._etags) {
            String header = ae0Var.getHeader("If-None-Match");
            str2 = resource.getWeakETag();
            if (header != null && header.equals(str2)) {
                ce0Var.setStatus(304);
                request.getResponse().getHttpFields().put(HttpHeaders.ETAG_BUFFER, str2);
                return;
            }
        } else {
            str2 = null;
        }
        if (lastModified > 0) {
            long dateHeader = ae0Var.getDateHeader("If-Modified-Since");
            if (dateHeader > 0 && lastModified / 1000 <= dateHeader / 1000) {
                ce0Var.setStatus(304);
                return;
            }
        }
        Buffer mimeByExtension = this._mimeTypes.getMimeByExtension(resource.toString());
        if (mimeByExtension == null) {
            mimeByExtension = this._mimeTypes.getMimeByExtension(ae0Var.getPathInfo());
        }
        if (mimeByExtension != null) {
            str3 = mimeByExtension.toString();
        }
        doResponseHeaders(ce0Var, resource, str3);
        ce0Var.setDateHeader("Last-Modified", lastModified);
        if (this._etags) {
            request.getResponse().getHttpFields().put(HttpHeaders.ETAG_BUFFER, str2);
        }
        if (z) {
            return;
        }
        try {
            writerOutputStream = ce0Var.getOutputStream();
        } catch (IllegalStateException unused) {
            writerOutputStream = new WriterOutputStream(ce0Var.getWriter());
        }
        OutputStream outputStream = writerOutputStream;
        if (outputStream instanceof AbstractHttpConnection.Output) {
            ((AbstractHttpConnection.Output) outputStream).sendContent(resource.getInputStream());
        } else {
            resource.writeTo(outputStream, 0L, resource.length());
        }
    }

    public boolean isAliases() {
        return this._aliases;
    }

    public boolean isDirectoriesListed() {
        return this._directory;
    }

    public boolean isEtags() {
        return this._etags;
    }

    public void setAliases(boolean z) {
        this._aliases = z;
    }

    public void setBaseResource(Resource resource) {
        this._baseResource = resource;
    }

    public void setCacheControl(String str) {
        this._cacheControl = str == null ? null : new ByteArrayBuffer(str);
    }

    public void setDirectoriesListed(boolean z) {
        this._directory = z;
    }

    public void setEtags(boolean z) {
        this._etags = z;
    }

    public void setMimeTypes(MimeTypes mimeTypes) {
        this._mimeTypes = mimeTypes;
    }

    public void setResourceBase(String str) {
        try {
            setBaseResource(Resource.newResource(str));
        } catch (Exception e) {
            LOG.warn(e.toString(), new Object[0]);
            LOG.debug(e);
            throw new IllegalArgumentException(str);
        }
    }

    public void setStylesheet(String str) {
        try {
            Resource newResource = Resource.newResource(str);
            this._stylesheet = newResource;
            if (newResource.exists()) {
                return;
            }
            Logger logger = LOG;
            logger.warn("unable to find custom stylesheet: " + str, new Object[0]);
            this._stylesheet = null;
        } catch (Exception e) {
            LOG.warn(e.toString(), new Object[0]);
            LOG.debug(e);
            throw new IllegalArgumentException(str.toString());
        }
    }

    public void setWelcomeFiles(String[] strArr) {
        this._welcomeFiles = strArr;
    }
}
