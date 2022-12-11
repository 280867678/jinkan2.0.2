package org.eclipse.jetty.servlet;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.C1543ak;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.WriterOutputStream;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.InclusiveByteRange;
import org.eclipse.jetty.server.ResourceCache;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.nio.NIOConnector;
import org.eclipse.jetty.server.ssl.SslConnector;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.MultiPartOutputStream;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.FileResource;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.util.resource.ResourceFactory;

/* loaded from: classes5.dex */
public class DefaultServlet extends HttpServlet implements ResourceFactory {
    public static final Logger LOG = Log.getLogger(DefaultServlet.class);
    public static final long serialVersionUID = 4930458713846881193L;
    public ResourceCache _cache;
    public ByteArrayBuffer _cacheControl;
    public ContextHandler _contextHandler;
    public ServletHolder _defaultHolder;
    public MimeTypes _mimeTypes;
    public String _relativeResourceBase;
    public Resource _resourceBase;
    public ServletContext _servletContext;
    public ServletHandler _servletHandler;
    public Resource _stylesheet;
    public String[] _welcomes;
    public boolean _acceptRanges = true;
    public boolean _dirAllowed = true;
    public boolean _welcomeServlets = false;
    public boolean _welcomeExactServlets = false;
    public boolean _redirectWelcome = false;
    public boolean _gzip = true;
    public boolean _pathInfoOnly = false;
    public boolean _etags = false;
    public boolean _useFileMappedBuffer = false;

    private boolean getInitBoolean(String str, boolean z) {
        String initParameter = getInitParameter(str);
        return (initParameter == null || initParameter.length() == 0) ? z : initParameter.startsWith(C1543ak.f2971aH) || initParameter.startsWith(ExifInterface.GPS_DIRECTION_TRUE) || initParameter.startsWith("y") || initParameter.startsWith("Y") || initParameter.startsWith("1");
    }

    private int getInitInt(String str, int i) {
        String initParameter = getInitParameter(str);
        if (initParameter == null) {
            initParameter = getInitParameter(str);
        }
        return (initParameter == null || initParameter.length() <= 0) ? i : Integer.parseInt(initParameter);
    }

    private String getWelcomeFile(String str) throws MalformedURLException, IOException {
        PathMap.Entry holderEntry;
        String str2 = null;
        if (this._welcomes == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this._welcomes;
            if (i >= strArr.length) {
                return str2;
            }
            String addPaths = URIUtil.addPaths(str, strArr[i]);
            Resource resource = getResource(addPaths);
            if (resource != null && resource.exists()) {
                return this._welcomes[i];
            }
            if ((this._welcomeServlets || this._welcomeExactServlets) && str2 == null && (holderEntry = this._servletHandler.getHolderEntry(addPaths)) != null && holderEntry.getValue() != this._defaultHolder && (this._welcomeServlets || (this._welcomeExactServlets && holderEntry.getKey().equals(addPaths)))) {
                str2 = addPaths;
            }
            i++;
        }
    }

    private boolean hasDefinedRange(Enumeration<String> enumeration) {
        return enumeration != null && enumeration.hasMoreElements();
    }

    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    public void destroy() {
        ResourceCache resourceCache = this._cache;
        if (resourceCache != null) {
            resourceCache.flushCache();
        }
        super.destroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:202:0x0057, code lost:
        if (hasDefinedRange(r7) == false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02c9 A[Catch: all -> 0x02f1, IllegalArgumentException -> 0x02f3, TRY_LEAVE, TryCatch #11 {IllegalArgumentException -> 0x02f3, all -> 0x02f1, blocks: (B:39:0x00f9, B:41:0x0101, B:44:0x0123, B:47:0x0131, B:50:0x0139, B:53:0x0141, B:55:0x0149, B:57:0x014f, B:59:0x015e, B:61:0x0164, B:62:0x0178, B:63:0x0186, B:73:0x018d, B:111:0x01d9, B:113:0x01df, B:116:0x01e9, B:118:0x01ef, B:120:0x01fe, B:122:0x0207, B:124:0x020d, B:125:0x0231, B:126:0x0241, B:128:0x0247, B:130:0x024d, B:131:0x0252, B:132:0x025c, B:145:0x0286, B:146:0x028a, B:163:0x02c2, B:164:0x02c3, B:166:0x02c9, B:167:0x02da, B:168:0x02f0), top: B:38:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02da A[Catch: all -> 0x02f1, IllegalArgumentException -> 0x02f3, TRY_ENTER, TryCatch #11 {IllegalArgumentException -> 0x02f3, all -> 0x02f1, blocks: (B:39:0x00f9, B:41:0x0101, B:44:0x0123, B:47:0x0131, B:50:0x0139, B:53:0x0141, B:55:0x0149, B:57:0x014f, B:59:0x015e, B:61:0x0164, B:62:0x0178, B:63:0x0186, B:73:0x018d, B:111:0x01d9, B:113:0x01df, B:116:0x01e9, B:118:0x01ef, B:120:0x01fe, B:122:0x0207, B:124:0x020d, B:125:0x0231, B:126:0x0241, B:128:0x0247, B:130:0x024d, B:131:0x0252, B:132:0x025c, B:145:0x0286, B:146:0x028a, B:163:0x02c2, B:164:0x02c3, B:166:0x02c9, B:167:0x02da, B:168:0x02f0), top: B:38:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00da A[Catch: all -> 0x00f2, IllegalArgumentException -> 0x00f5, TryCatch #10 {IllegalArgumentException -> 0x00f5, all -> 0x00f2, blocks: (B:173:0x00a6, B:175:0x00ac, B:177:0x00b2, B:179:0x00c1, B:29:0x00da, B:31:0x00de, B:33:0x00e4, B:36:0x00ed, B:75:0x01a5, B:77:0x01ab, B:81:0x01b3, B:83:0x01c2, B:84:0x01c5), top: B:172:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0101 A[Catch: all -> 0x02f1, IllegalArgumentException -> 0x02f3, TryCatch #11 {IllegalArgumentException -> 0x02f3, all -> 0x02f1, blocks: (B:39:0x00f9, B:41:0x0101, B:44:0x0123, B:47:0x0131, B:50:0x0139, B:53:0x0141, B:55:0x0149, B:57:0x014f, B:59:0x015e, B:61:0x0164, B:62:0x0178, B:63:0x0186, B:73:0x018d, B:111:0x01d9, B:113:0x01df, B:116:0x01e9, B:118:0x01ef, B:120:0x01fe, B:122:0x0207, B:124:0x020d, B:125:0x0231, B:126:0x0241, B:128:0x0247, B:130:0x024d, B:131:0x0252, B:132:0x025c, B:145:0x0286, B:146:0x028a, B:163:0x02c2, B:164:0x02c3, B:166:0x02c9, B:167:0x02da, B:168:0x02f0), top: B:38:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0309 A[Catch: all -> 0x031e, TRY_LEAVE, TryCatch #10 {all -> 0x031e, blocks: (B:89:0x02fc, B:91:0x0309), top: B:88:0x02fc }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0318  */
    @Override // javax.servlet.http.HttpServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doGet(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        String servletPath;
        String pathInfo;
        Enumeration<String> headers;
        Resource resource;
        HttpContent.ResourceAsHttpContent resourceAsHttpContent;
        boolean z;
        String encodeRedirectURL;
        Resource resource2;
        Boolean valueOf = Boolean.valueOf(ae0Var.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI) != null);
        HttpContent.ResourceAsHttpContent resourceAsHttpContent2 = null;
        r4 = null;
        Resource resource3 = null;
        Resource resource4 = null;
        if (valueOf == null || !valueOf.booleanValue()) {
            valueOf = Boolean.FALSE;
            servletPath = this._pathInfoOnly ? "/" : ae0Var.getServletPath();
            pathInfo = ae0Var.getPathInfo();
            headers = ae0Var.getHeaders("Range");
        } else {
            servletPath = (String) ae0Var.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH);
            pathInfo = (String) ae0Var.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO);
            if (servletPath == null) {
                servletPath = ae0Var.getServletPath();
                pathInfo = ae0Var.getPathInfo();
            }
        }
        headers = null;
        String addPaths = URIUtil.addPaths(servletPath, pathInfo);
        if (pathInfo == null) {
            pathInfo = ae0Var.getServletPath();
        }
        boolean endsWith = pathInfo.endsWith("/");
        try {
            try {
                if (valueOf.booleanValue() || !this._gzip || headers != null || endsWith) {
                    resource = null;
                    resourceAsHttpContent = null;
                } else {
                    String str = addPaths + ".gz";
                    if (this._cache == null) {
                        resource = getResource(str);
                        resourceAsHttpContent = null;
                    } else {
                        HttpContent lookup = this._cache.lookup(str);
                        if (lookup == null) {
                            resource2 = null;
                        } else {
                            try {
                                resource2 = lookup.getResource();
                            } catch (IllegalArgumentException e) {
                                e = e;
                                resourceAsHttpContent = lookup;
                                try {
                                    LOG.warn(Log.EXCEPTION, e);
                                    if (!ce0Var.isCommitted()) {
                                    }
                                    if (resourceAsHttpContent != null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    resource = resource4;
                                    resourceAsHttpContent2 = resourceAsHttpContent;
                                    if (resourceAsHttpContent2 == null) {
                                        resourceAsHttpContent2.release();
                                    } else if (resource != null) {
                                        resource.release();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                resource = null;
                                resourceAsHttpContent2 = lookup;
                                if (resourceAsHttpContent2 == null) {
                                }
                                throw th;
                            }
                        }
                        Resource resource5 = resource2;
                        resourceAsHttpContent = lookup;
                        resource = resource5;
                    }
                    if (resource != null) {
                        try {
                            if (resource.exists() && !resource.isDirectory()) {
                                ce0Var.addHeader("Vary", "Accept-Encoding");
                                String header = ae0Var.getHeader("Accept-Encoding");
                                if (header != null && header.indexOf("gzip") >= 0) {
                                    z = true;
                                    if (!z) {
                                        if (this._cache == null) {
                                            resource3 = getResource(addPaths);
                                        } else {
                                            resourceAsHttpContent = this._cache.lookup(addPaths);
                                            if (resourceAsHttpContent != null) {
                                                resource3 = resourceAsHttpContent.getResource();
                                            }
                                        }
                                        resource = resource3;
                                    }
                                    resourceAsHttpContent2 = resourceAsHttpContent;
                                    if (LOG.isDebugEnabled()) {
                                        Logger logger = LOG;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("uri=");
                                        sb.append(ae0Var.getRequestURI());
                                        sb.append(" resource=");
                                        sb.append(resource);
                                        sb.append(resourceAsHttpContent2 != null ? " content" : "");
                                        logger.debug(sb.toString(), new Object[0]);
                                    }
                                    if (resource != null && resource.exists()) {
                                        if (!resource.isDirectory()) {
                                            if (endsWith && (addPaths.length() != 1 || ae0Var.getAttribute("org.eclipse.jetty.server.nullPathInfo") == null)) {
                                                String welcomeFile = getWelcomeFile(addPaths);
                                                if (welcomeFile != null) {
                                                    LOG.debug("welcome={}", welcomeFile);
                                                    if (this._redirectWelcome) {
                                                        ce0Var.setContentLength(0);
                                                        String queryString = ae0Var.getQueryString();
                                                        if (queryString == null || queryString.length() == 0) {
                                                            encodeRedirectURL = ce0Var.encodeRedirectURL(URIUtil.addPaths(this._servletContext.getContextPath(), welcomeFile));
                                                        } else {
                                                            encodeRedirectURL = ce0Var.encodeRedirectURL(URIUtil.addPaths(this._servletContext.getContextPath(), welcomeFile) + "?" + queryString);
                                                        }
                                                        ce0Var.sendRedirect(encodeRedirectURL);
                                                    } else {
                                                        RequestDispatcher requestDispatcher = ae0Var.getRequestDispatcher(welcomeFile);
                                                        if (requestDispatcher != null) {
                                                            if (valueOf.booleanValue()) {
                                                                requestDispatcher.include(ae0Var, ce0Var);
                                                            } else {
                                                                ae0Var.setAttribute("org.eclipse.jetty.server.welcome", welcomeFile);
                                                                requestDispatcher.forward(ae0Var, ce0Var);
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    HttpContent.ResourceAsHttpContent resourceAsHttpContent3 = new HttpContent.ResourceAsHttpContent(resource, this._mimeTypes.getMimeByExtension(resource.toString()), this._etags);
                                                    try {
                                                        if (valueOf.booleanValue() || passConditionalHeaders(ae0Var, ce0Var, resource, resourceAsHttpContent3)) {
                                                            sendDirectory(ae0Var, ce0Var, resource, addPaths);
                                                        }
                                                        resourceAsHttpContent2 = resourceAsHttpContent3;
                                                    } catch (IllegalArgumentException e2) {
                                                        e = e2;
                                                        resourceAsHttpContent = resourceAsHttpContent3;
                                                        resource4 = resource;
                                                        LOG.warn(Log.EXCEPTION, e);
                                                        if (!ce0Var.isCommitted()) {
                                                            ce0Var.sendError(500, e.getMessage());
                                                        }
                                                        if (resourceAsHttpContent != null) {
                                                            resourceAsHttpContent.release();
                                                            return;
                                                        } else if (resource4 == null) {
                                                            return;
                                                        } else {
                                                            resource4.release();
                                                            return;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        resourceAsHttpContent2 = resourceAsHttpContent3;
                                                        if (resourceAsHttpContent2 == null) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                if (resourceAsHttpContent2 != null) {
                                                }
                                            }
                                            StringBuffer requestURL = ae0Var.getRequestURL();
                                            synchronized (requestURL) {
                                                int lastIndexOf = requestURL.lastIndexOf(";");
                                                if (lastIndexOf < 0) {
                                                    requestURL.append('/');
                                                } else {
                                                    requestURL.insert(lastIndexOf, '/');
                                                }
                                                String queryString2 = ae0Var.getQueryString();
                                                if (queryString2 != null && queryString2.length() != 0) {
                                                    requestURL.append('?');
                                                    requestURL.append(queryString2);
                                                }
                                                ce0Var.setContentLength(0);
                                                ce0Var.sendRedirect(ce0Var.encodeRedirectURL(requestURL.toString()));
                                            }
                                            if (resourceAsHttpContent2 != null) {
                                            }
                                        } else if (!endsWith || !this._contextHandler.isAliases() || addPaths.length() <= 1) {
                                            resourceAsHttpContent = resourceAsHttpContent2 == null ? new HttpContent.ResourceAsHttpContent(resource, this._mimeTypes.getMimeByExtension(resource.toString()), ce0Var.getBufferSize(), this._etags) : resourceAsHttpContent2;
                                            if (valueOf.booleanValue() || passConditionalHeaders(ae0Var, ce0Var, resource, resourceAsHttpContent)) {
                                                if (z) {
                                                    ce0Var.setHeader("Content-Encoding", "gzip");
                                                    String mimeType = this._servletContext.getMimeType(addPaths);
                                                    if (mimeType != null) {
                                                        ce0Var.setContentType(mimeType);
                                                    }
                                                }
                                                sendData(ae0Var, ce0Var, valueOf.booleanValue(), resource, resourceAsHttpContent, headers);
                                            }
                                            resourceAsHttpContent2 = resourceAsHttpContent;
                                            if (resourceAsHttpContent2 != null) {
                                                resourceAsHttpContent2.release();
                                                return;
                                            } else if (resource == null) {
                                                return;
                                            } else {
                                                resource.release();
                                                return;
                                            }
                                        } else {
                                            String queryString3 = ae0Var.getQueryString();
                                            String substring = addPaths.substring(0, addPaths.length() - 1);
                                            if (queryString3 != null && queryString3.length() != 0) {
                                                substring = substring + "?" + queryString3;
                                            }
                                            encodeRedirectURL = ce0Var.encodeRedirectURL(URIUtil.addPaths(this._servletContext.getContextPath(), substring));
                                            ce0Var.sendRedirect(encodeRedirectURL);
                                            if (resourceAsHttpContent2 != null) {
                                            }
                                        }
                                    }
                                    if (!valueOf.booleanValue()) {
                                        throw new FileNotFoundException("!" + addPaths);
                                    }
                                    ce0Var.sendError(404);
                                    if (resourceAsHttpContent2 != null) {
                                    }
                                }
                            }
                        } catch (IllegalArgumentException e3) {
                            e = e3;
                            resource4 = resource;
                            LOG.warn(Log.EXCEPTION, e);
                            if (!ce0Var.isCommitted()) {
                            }
                            if (resourceAsHttpContent != null) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            resourceAsHttpContent2 = resourceAsHttpContent;
                            if (resourceAsHttpContent2 == null) {
                            }
                            throw th;
                        }
                    }
                }
                if (LOG.isDebugEnabled()) {
                }
                if (resource != null) {
                    if (!resource.isDirectory()) {
                    }
                }
                if (!valueOf.booleanValue()) {
                }
            } catch (IllegalArgumentException e4) {
                e = e4;
                resourceAsHttpContent = resourceAsHttpContent2;
            } catch (Throwable th5) {
                th = th5;
            }
            z = false;
            if (!z) {
            }
            resourceAsHttpContent2 = resourceAsHttpContent;
        } catch (IllegalArgumentException e5) {
            e = e5;
            resourceAsHttpContent = null;
        } catch (Throwable th6) {
            th = th6;
            resource = null;
        }
    }

    @Override // javax.servlet.http.HttpServlet
    public void doOptions(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        ce0Var.setHeader("Allow", "GET,HEAD,POST,OPTIONS");
    }

    @Override // javax.servlet.http.HttpServlet
    public void doPost(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        doGet(ae0Var, ce0Var);
    }

    @Override // javax.servlet.http.HttpServlet
    public void doTrace(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        ce0Var.sendError(405);
    }

    @Override // javax.servlet.GenericServlet, javax.servlet.ServletConfig
    public String getInitParameter(String str) {
        ServletContext servletContext = getServletContext();
        String initParameter = servletContext.getInitParameter("org.eclipse.jetty.servlet.Default." + str);
        return initParameter == null ? super.getInitParameter(str) : initParameter;
    }

    public Resource getResource(String str) {
        Resource resource;
        IOException e;
        String str2 = this._relativeResourceBase;
        if (str2 != null) {
            str = URIUtil.addPaths(str2, str);
        }
        Resource resource2 = null;
        try {
            if (this._resourceBase != null) {
                resource = this._resourceBase.addPath(str);
                try {
                    if (this._contextHandler.checkAlias(str, resource)) {
                        resource2 = resource;
                    }
                } catch (IOException e2) {
                    e = e2;
                    LOG.ignore(e);
                    resource2 = resource;
                    if (resource2 != null) {
                    }
                }
            } else {
                resource2 = this._servletContext instanceof ContextHandler.Context ? this._contextHandler.getResource(str) : this._contextHandler.newResource(this._servletContext.getResource(str));
            }
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                logger.debug("Resource " + str + "=" + resource2, new Object[0]);
            }
        } catch (IOException e3) {
            resource = resource2;
            e = e3;
        }
        return ((resource2 != null || !resource2.exists()) && str.endsWith("/jetty-dir.css")) ? this._stylesheet : resource2;
    }

    @Override // javax.servlet.GenericServlet
    public void init() throws UnavailableException {
        ServletHolder[] servlets;
        ServletContext servletContext = getServletContext();
        this._servletContext = servletContext;
        ContextHandler initContextHandler = initContextHandler(servletContext);
        this._contextHandler = initContextHandler;
        this._mimeTypes = initContextHandler.getMimeTypes();
        String[] welcomeFiles = this._contextHandler.getWelcomeFiles();
        this._welcomes = welcomeFiles;
        if (welcomeFiles == null) {
            this._welcomes = new String[]{"index.html", "index.jsp"};
        }
        this._acceptRanges = getInitBoolean("acceptRanges", this._acceptRanges);
        this._dirAllowed = getInitBoolean("dirAllowed", this._dirAllowed);
        this._redirectWelcome = getInitBoolean("redirectWelcome", this._redirectWelcome);
        this._gzip = getInitBoolean("gzip", this._gzip);
        this._pathInfoOnly = getInitBoolean("pathInfoOnly", this._pathInfoOnly);
        if ("exact".equals(getInitParameter("welcomeServlets"))) {
            this._welcomeExactServlets = true;
            this._welcomeServlets = false;
        } else {
            this._welcomeServlets = getInitBoolean("welcomeServlets", this._welcomeServlets);
        }
        if (getInitParameter("aliases") != null) {
            this._contextHandler.setAliases(getInitBoolean("aliases", false));
        }
        boolean isAliases = this._contextHandler.isAliases();
        if (isAliases || FileResource.getCheckAliases()) {
            if (isAliases) {
                this._servletContext.log("Aliases are enabled! Security constraints may be bypassed!!!");
            }
            this._useFileMappedBuffer = getInitBoolean("useFileMappedBuffer", this._useFileMappedBuffer);
            this._relativeResourceBase = getInitParameter("relativeResourceBase");
            String initParameter = getInitParameter("resourceBase");
            if (initParameter != null) {
                if (this._relativeResourceBase != null) {
                    throw new UnavailableException("resourceBase & relativeResourceBase");
                }
                try {
                    this._resourceBase = this._contextHandler.newResource(initParameter);
                } catch (Exception e) {
                    LOG.warn(Log.EXCEPTION, e);
                    throw new UnavailableException(e.toString());
                }
            }
            String initParameter2 = getInitParameter("stylesheet");
            if (initParameter2 != null) {
                try {
                    Resource newResource = Resource.newResource(initParameter2);
                    this._stylesheet = newResource;
                    if (!newResource.exists()) {
                        LOG.warn("!" + initParameter2, new Object[0]);
                        this._stylesheet = null;
                    }
                } catch (Exception e2) {
                    LOG.warn(e2.toString(), new Object[0]);
                    LOG.debug(e2);
                }
            }
            if (this._stylesheet == null) {
                this._stylesheet = Resource.newResource(getClass().getResource("/jetty-dir.css"));
            }
            String initParameter3 = getInitParameter("cacheControl");
            if (initParameter3 != null) {
                this._cacheControl = new ByteArrayBuffer(initParameter3);
            }
            String initParameter4 = getInitParameter("resourceCache");
            int initInt = getInitInt("maxCacheSize", -2);
            int initInt2 = getInitInt("maxCachedFileSize", -2);
            int initInt3 = getInitInt("maxCachedFiles", -2);
            if (initParameter4 != null) {
                if (initInt != -1 || initInt2 != -2 || initInt3 != -2) {
                    LOG.debug("ignoring resource cache configuration, using resourceCache attribute", new Object[0]);
                }
                if (this._relativeResourceBase != null || this._resourceBase != null) {
                    throw new UnavailableException("resourceCache specified with resource bases");
                }
                ResourceCache resourceCache = (ResourceCache) this._servletContext.getAttribute(initParameter4);
                this._cache = resourceCache;
                LOG.debug("Cache {}={}", initParameter4, resourceCache);
            }
            this._etags = getInitBoolean("etags", this._etags);
            try {
                if (this._cache == null && initInt3 > 0) {
                    ResourceCache resourceCache2 = new ResourceCache(null, this, this._mimeTypes, this._useFileMappedBuffer, this._etags);
                    this._cache = resourceCache2;
                    if (initInt > 0) {
                        resourceCache2.setMaxCacheSize(initInt);
                    }
                    if (initInt2 >= -1) {
                        this._cache.setMaxCachedFileSize(initInt2);
                    }
                    if (initInt3 >= -1) {
                        this._cache.setMaxCachedFiles(initInt3);
                    }
                }
                ServletHandler servletHandler = (ServletHandler) this._contextHandler.getChildHandlerByClass(ServletHandler.class);
                this._servletHandler = servletHandler;
                for (ServletHolder servletHolder : servletHandler.getServlets()) {
                    if (servletHolder.getServletInstance() == this) {
                        this._defaultHolder = servletHolder;
                    }
                }
                if (!LOG.isDebugEnabled()) {
                    return;
                }
                Logger logger = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("resource base = ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._resourceBase);
                logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
                return;
            } catch (Exception e3) {
                LOG.warn(Log.EXCEPTION, e3);
                throw new UnavailableException(e3.toString());
            }
        }
        throw new IllegalStateException("Alias checking disabled");
    }

    public ContextHandler initContextHandler(ServletContext servletContext) {
        ContextHandler.Context currentContext;
        if (ContextHandler.getCurrentContext() != null) {
            currentContext = ContextHandler.getCurrentContext();
        } else if (!(servletContext instanceof ContextHandler.Context)) {
            throw new IllegalArgumentException("The servletContext " + servletContext + StringUtils.SPACE + servletContext.getClass().getName() + " is not " + ContextHandler.Context.class.getName());
        } else {
            currentContext = (ContextHandler.Context) servletContext;
        }
        return currentContext.getContextHandler();
    }

    public boolean passConditionalHeaders(ae0 ae0Var, ce0 ce0Var, Resource resource, HttpContent httpContent) throws IOException {
        Buffer lastModified;
        boolean z;
        try {
            if (!ae0Var.getMethod().equals("HEAD")) {
                if (this._etags) {
                    String header = ae0Var.getHeader("If-Match");
                    if (header != null) {
                        if (httpContent == null || httpContent.getETag() == null) {
                            z = false;
                        } else {
                            QuotedStringTokenizer quotedStringTokenizer = new QuotedStringTokenizer(header, ", ", false, true);
                            z = false;
                            while (!z && quotedStringTokenizer.hasMoreTokens()) {
                                if (httpContent.getETag().toString().equals(quotedStringTokenizer.nextToken())) {
                                    z = true;
                                }
                            }
                        }
                        if (!z) {
                            Response response = Response.getResponse(ce0Var);
                            response.reset(true);
                            response.setStatus(412);
                            return false;
                        }
                    }
                    String header2 = ae0Var.getHeader("If-None-Match");
                    if (header2 != null && httpContent != null && httpContent.getETag() != null) {
                        if (httpContent.getETag().toString().equals(ae0Var.getAttribute("o.e.j.s.GzipFilter.ETag"))) {
                            Response response2 = Response.getResponse(ce0Var);
                            response2.reset(true);
                            response2.setStatus(304);
                            response2.getHttpFields().put(HttpHeaders.ETAG_BUFFER, header2);
                            return false;
                        } else if (httpContent.getETag().toString().equals(header2)) {
                            Response response3 = Response.getResponse(ce0Var);
                            response3.reset(true);
                            response3.setStatus(304);
                            response3.getHttpFields().put(HttpHeaders.ETAG_BUFFER, httpContent.getETag());
                            return false;
                        } else {
                            QuotedStringTokenizer quotedStringTokenizer2 = new QuotedStringTokenizer(header2, ", ", false, true);
                            while (quotedStringTokenizer2.hasMoreTokens()) {
                                if (httpContent.getETag().toString().equals(quotedStringTokenizer2.nextToken())) {
                                    Response response4 = Response.getResponse(ce0Var);
                                    response4.reset(true);
                                    response4.setStatus(304);
                                    response4.getHttpFields().put(HttpHeaders.ETAG_BUFFER, httpContent.getETag());
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                }
                String header3 = ae0Var.getHeader("If-Modified-Since");
                if (header3 != null) {
                    Response response5 = Response.getResponse(ce0Var);
                    if (httpContent != null && (lastModified = httpContent.getLastModified()) != null && header3.equals(lastModified.toString())) {
                        response5.reset(true);
                        response5.setStatus(304);
                        if (this._etags) {
                            response5.getHttpFields().add(HttpHeaders.ETAG_BUFFER, httpContent.getETag());
                        }
                        response5.flushBuffer();
                        return false;
                    }
                    long dateHeader = ae0Var.getDateHeader("If-Modified-Since");
                    if (dateHeader != -1 && resource.lastModified() / 1000 <= dateHeader / 1000) {
                        response5.reset(true);
                        response5.setStatus(304);
                        if (this._etags) {
                            response5.getHttpFields().add(HttpHeaders.ETAG_BUFFER, httpContent.getETag());
                        }
                        response5.flushBuffer();
                        return false;
                    }
                }
                long dateHeader2 = ae0Var.getDateHeader("If-Unmodified-Since");
                if (dateHeader2 != -1 && resource.lastModified() / 1000 > dateHeader2 / 1000) {
                    ce0Var.sendError(412);
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException e) {
            if (!ce0Var.isCommitted()) {
                ce0Var.sendError(400, e.getMessage());
            }
            throw e;
        }
    }

    public void sendData(ae0 ae0Var, ce0 ce0Var, boolean z, Resource resource, HttpContent httpContent, Enumeration enumeration) throws IOException {
        boolean z2;
        long contentLength;
        OutputStream writerOutputStream;
        boolean z3;
        long j;
        long j2;
        if (httpContent == null) {
            contentLength = resource.length();
            z2 = false;
        } else {
            Connector connector = AbstractHttpConnection.getCurrentConnection().getConnector();
            z2 = (connector instanceof NIOConnector) && ((NIOConnector) connector).getUseDirectBuffers() && !(connector instanceof SslConnector);
            contentLength = httpContent.getContentLength();
        }
        try {
            writerOutputStream = ce0Var.getOutputStream();
            z3 = writerOutputStream instanceof HttpOutput ? ((HttpOutput) writerOutputStream).isWritten() : AbstractHttpConnection.getCurrentConnection().getGenerator().isWritten();
        } catch (IllegalStateException unused) {
            writerOutputStream = new WriterOutputStream(ce0Var.getWriter());
            z3 = true;
        }
        long j3 = -1;
        if (enumeration == null || !enumeration.hasMoreElements() || contentLength < 0) {
            if (!z) {
                if (httpContent == null || z3 || !(writerOutputStream instanceof HttpOutput)) {
                    if (!z3) {
                        j3 = contentLength;
                    }
                    writeHeaders(ce0Var, httpContent, j3);
                    Buffer indirectBuffer = httpContent.getIndirectBuffer();
                    if (indirectBuffer != null) {
                        indirectBuffer.writeTo(writerOutputStream);
                        return;
                    }
                } else if (ce0Var instanceof Response) {
                    writeOptionHeaders(((Response) ce0Var).getHttpFields());
                    ((AbstractHttpConnection.Output) writerOutputStream).sendContent(httpContent);
                    return;
                } else {
                    Buffer directBuffer = z2 ? httpContent.getDirectBuffer() : httpContent.getIndirectBuffer();
                    writeHeaders(ce0Var, httpContent, contentLength);
                    if (directBuffer != null) {
                        ((AbstractHttpConnection.Output) writerOutputStream).sendContent(directBuffer);
                        return;
                    }
                }
            }
            resource.writeTo(writerOutputStream, 0L, contentLength);
            return;
        }
        List satisfiableRanges = InclusiveByteRange.satisfiableRanges(enumeration, contentLength);
        if (satisfiableRanges == null || satisfiableRanges.size() == 0) {
            writeHeaders(ce0Var, httpContent, contentLength);
            ce0Var.setStatus(416);
            ce0Var.setHeader("Content-Range", InclusiveByteRange.to416HeaderRangeString(contentLength));
            j = 0;
            j2 = contentLength;
        } else if (satisfiableRanges.size() != 1) {
            writeHeaders(ce0Var, httpContent, -1L);
            String obj = httpContent.getContentType() == null ? null : httpContent.getContentType().toString();
            if (obj == null) {
                Logger logger = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown mimetype for ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ae0Var.getRequestURI());
                logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            }
            MultiPartOutputStream multiPartOutputStream = new MultiPartOutputStream(writerOutputStream);
            ce0Var.setStatus(206);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ae0Var.getHeader(HttpHeaders.REQUEST_RANGE) != null ? "multipart/x-byteranges; boundary=" : "multipart/byteranges; boundary=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(multiPartOutputStream.getBoundary());
            ce0Var.setContentType(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            InputStream inputStream = resource.getInputStream();
            String[] strArr = new String[satisfiableRanges.size()];
            int i = 0;
            int i2 = 0;
            while (i < satisfiableRanges.size()) {
                InclusiveByteRange inclusiveByteRange = (InclusiveByteRange) satisfiableRanges.get(i);
                strArr[i] = inclusiveByteRange.toHeaderRangeString(contentLength);
                i2 = (int) ((inclusiveByteRange.getLast(contentLength) - inclusiveByteRange.getFirst(contentLength)) + strArr[i].length() + multiPartOutputStream.getBoundary().length() + (i > 0 ? 2 : 0) + 2 + 2 + (obj == null ? 0 : obj.length() + 14) + 2 + 13 + 2 + 2 + 2 + 1 + i2);
                i++;
            }
            ce0Var.setContentLength(multiPartOutputStream.getBoundary().length() + 4 + 2 + 2 + i2);
            long j4 = 0;
            for (int i3 = 0; i3 < satisfiableRanges.size(); i3++) {
                InclusiveByteRange inclusiveByteRange2 = (InclusiveByteRange) satisfiableRanges.get(i3);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Content-Range: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(strArr[i3]);
                multiPartOutputStream.startPart(obj, new String[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString()});
                long first = inclusiveByteRange2.getFirst(contentLength);
                long size = inclusiveByteRange2.getSize(contentLength);
                if (inputStream != null) {
                    if (first < j4) {
                        inputStream.close();
                        inputStream = resource.getInputStream();
                        j4 = 0;
                    }
                    if (j4 < first) {
                        inputStream.skip(first - j4);
                    } else {
                        first = j4;
                    }
                    C3009IO.copy(inputStream, multiPartOutputStream, size);
                    j4 = first + size;
                } else {
                    resource.writeTo(multiPartOutputStream, first, size);
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            multiPartOutputStream.close();
            return;
        } else {
            InclusiveByteRange inclusiveByteRange3 = (InclusiveByteRange) satisfiableRanges.get(0);
            j2 = inclusiveByteRange3.getSize(contentLength);
            writeHeaders(ce0Var, httpContent, j2);
            ce0Var.setStatus(206);
            ce0Var.setHeader("Content-Range", inclusiveByteRange3.toHeaderRangeString(contentLength));
            j = inclusiveByteRange3.getFirst(contentLength);
        }
        resource.writeTo(writerOutputStream, j, j2);
    }

    public void sendDirectory(ae0 ae0Var, ce0 ce0Var, Resource resource, String str) throws IOException {
        if (!this._dirAllowed) {
            ce0Var.sendError(403);
            return;
        }
        String addPaths = URIUtil.addPaths(ae0Var.getRequestURI(), "/");
        Resource resource2 = this._resourceBase;
        if (resource2 != null) {
            if (resource2 instanceof ResourceCollection) {
                resource = resource2.addPath(str);
            }
        } else if (this._contextHandler.getBaseResource() instanceof ResourceCollection) {
            resource = this._contextHandler.getBaseResource().addPath(str);
        }
        boolean z = true;
        if (str.length() <= 1) {
            z = false;
        }
        String listHTML = resource.getListHTML(addPaths, z);
        if (listHTML == null) {
            ce0Var.sendError(403, "No directory");
            return;
        }
        byte[] bytes = listHTML.getBytes("UTF-8");
        ce0Var.setContentType(MimeTypes.TEXT_HTML__UTF_8);
        ce0Var.setContentLength(bytes.length);
        ce0Var.getOutputStream().write(bytes);
    }

    public void writeHeaders(ce0 ce0Var, HttpContent httpContent, long j) throws IOException {
        if (httpContent.getContentType() != null && ce0Var.getContentType() == null) {
            ce0Var.setContentType(httpContent.getContentType().toString());
        }
        if (!(ce0Var instanceof Response)) {
            long lastModified = httpContent.getResource().lastModified();
            if (lastModified >= 0) {
                ce0Var.setDateHeader("Last-Modified", lastModified);
            }
            if (j != -1) {
                if (j < 2147483647L) {
                    ce0Var.setContentLength((int) j);
                } else {
                    ce0Var.setHeader("Content-Length", Long.toString(j));
                }
            }
            writeOptionHeaders(ce0Var);
            if (!this._etags) {
                return;
            }
            ce0Var.setHeader("ETag", httpContent.getETag().toString());
            return;
        }
        Response response = (Response) ce0Var;
        HttpFields httpFields = response.getHttpFields();
        if (httpContent.getLastModified() != null) {
            httpFields.put(HttpHeaders.LAST_MODIFIED_BUFFER, httpContent.getLastModified());
        } else if (httpContent.getResource() != null) {
            long lastModified2 = httpContent.getResource().lastModified();
            if (lastModified2 != -1) {
                httpFields.putDateField(HttpHeaders.LAST_MODIFIED_BUFFER, lastModified2);
            }
        }
        if (j != -1) {
            response.setLongContentLength(j);
        }
        writeOptionHeaders(httpFields);
        if (!this._etags) {
            return;
        }
        httpFields.put(HttpHeaders.ETAG_BUFFER, httpContent.getETag());
    }

    public void writeOptionHeaders(ce0 ce0Var) throws IOException {
        if (this._acceptRanges) {
            ce0Var.setHeader("Accept-Ranges", HttpHeaderValues.BYTES);
        }
        ByteArrayBuffer byteArrayBuffer = this._cacheControl;
        if (byteArrayBuffer != null) {
            ce0Var.setHeader("Cache-Control", byteArrayBuffer.toString());
        }
    }

    public void writeOptionHeaders(HttpFields httpFields) throws IOException {
        if (this._acceptRanges) {
            httpFields.put(HttpHeaders.ACCEPT_RANGES_BUFFER, HttpHeaderValues.BYTES_BUFFER);
        }
        ByteArrayBuffer byteArrayBuffer = this._cacheControl;
        if (byteArrayBuffer != null) {
            httpFields.put(HttpHeaders.CACHE_CONTROL_BUFFER, byteArrayBuffer);
        }
    }
}
