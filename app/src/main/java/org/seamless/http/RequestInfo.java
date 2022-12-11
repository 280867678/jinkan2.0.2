package org.seamless.http;

import java.util.Enumeration;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import me.tvspark.ae0;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;

/* loaded from: classes5.dex */
public class RequestInfo {
    public static final Logger log = Logger.getLogger(RequestInfo.class.getName());

    public static void dumpRequestHeaders(long j, String str, ae0 ae0Var) {
        log.info(str);
        dumpRequestString(j, ae0Var);
        Enumeration<String> headerNames = ae0Var.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String nextElement = headerNames.nextElement();
                log.info(String.format("%s: %s", nextElement, ae0Var.getHeader(nextElement)));
            }
        }
        log.info("----------------------------------------");
    }

    public static void dumpRequestHeaders(long j, ae0 ae0Var) {
        dumpRequestHeaders(j, "REQUEST HEADERS", ae0Var);
    }

    public static void dumpRequestString(long j, ae0 ae0Var) {
        log.info(getRequestInfoString(j, ae0Var));
    }

    public static String getRequestFullURL(ae0 ae0Var) {
        String scheme = ae0Var.getScheme();
        String serverName = ae0Var.getServerName();
        int serverPort = ae0Var.getServerPort();
        String contextPath = ae0Var.getContextPath();
        String servletPath = ae0Var.getServletPath();
        String pathInfo = ae0Var.getPathInfo();
        String queryString = ae0Var.getQueryString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(scheme);
        stringBuffer.append("://");
        stringBuffer.append(serverName);
        if (serverPort != 80 && serverPort != 443) {
            stringBuffer.append(":");
            stringBuffer.append(serverPort);
        }
        stringBuffer.append(contextPath);
        stringBuffer.append(servletPath);
        if (pathInfo != null) {
            stringBuffer.append(pathInfo);
        }
        if (queryString != null) {
            stringBuffer.append("?");
            stringBuffer.append(queryString);
        }
        return stringBuffer.toString();
    }

    public static String getRequestInfoString(long j, ae0 ae0Var) {
        return String.format("%s %s %s %s %s %d", ae0Var.getMethod(), ae0Var.getRequestURI(), ae0Var.getProtocol(), ae0Var.getParameterMap(), ae0Var.getRemoteAddr(), Long.valueOf(j));
    }

    public static boolean isAndroidBubbleUPnPRequest(String str) {
        return str != null && str.contains("BubbleUPnP");
    }

    public static boolean isJRiverRequest(String str) {
        return str != null && (str.contains("J-River") || str.contains("J. River"));
    }

    public static boolean isJRiverRequest(ae0 ae0Var) {
        return isJRiverRequest(ae0Var.getHeader("User-Agent"));
    }

    public static boolean isPS3Request(String str, String str2) {
        return (str != null && str.contains("PLAYSTATION 3")) || (str2 != null && str2.contains("PLAYSTATION 3"));
    }

    public static boolean isPS3Request(ae0 ae0Var) {
        return isPS3Request(ae0Var.getHeader("User-Agent"), ae0Var.getHeader("X-AV-Client-Info"));
    }

    public static boolean isWMPRequest(String str) {
        return str != null && str.contains("Windows-Media-Player") && !isJRiverRequest(str);
    }

    public static boolean isXbox360AlbumArtRequest(ae0 ae0Var) {
        return "true".equals(ae0Var.getParameter("albumArt")) && isXbox360Request(ae0Var);
    }

    public static boolean isXbox360Request(String str, String str2) {
        return (str != null && (str.contains("Xbox") || str.contains("Xenon"))) || (str2 != null && str2.contains("Xbox"));
    }

    public static boolean isXbox360Request(ae0 ae0Var) {
        return isXbox360Request(ae0Var.getHeader("User-Agent"), ae0Var.getHeader("Server"));
    }

    public static void reportClient(StringBuilder sb, ae0 ae0Var) {
        sb.append("Remote Address: ");
        sb.append(ae0Var.getRemoteAddr());
        sb.append("\n");
        if (!ae0Var.getRemoteAddr().equals(ae0Var.getRemoteHost())) {
            sb.append("Remote Host: ");
            sb.append(ae0Var.getRemoteHost());
            sb.append("\n");
        }
        sb.append("Remote Port: ");
        sb.append(ae0Var.getRemotePort());
        sb.append("\n");
        if (ae0Var.getRemoteUser() != null) {
            sb.append("Remote User: ");
            sb.append(ae0Var.getRemoteUser());
            sb.append("\n");
        }
    }

    public static void reportCookies(StringBuilder sb, ae0 ae0Var) {
        Cookie[] cookies = ae0Var.getCookies();
        if (cookies != null && (r0 = cookies.length) > 0) {
            sb.append("Cookies:\n");
            for (Cookie cookie : cookies) {
                sb.append("    ");
                sb.append(cookie.getName());
                sb.append(" = ");
                sb.append(cookie.getValue());
                sb.append('\n');
            }
        }
    }

    public static void reportHeaders(StringBuilder sb, ae0 ae0Var) {
        Enumeration<String> headerNames = ae0Var.getHeaderNames();
        if (headerNames != null && headerNames.hasMoreElements()) {
            sb.append("Headers:\n");
            while (headerNames.hasMoreElements()) {
                String nextElement = headerNames.nextElement();
                String header = ae0Var.getHeader(nextElement);
                sb.append("    ");
                sb.append(nextElement);
                sb.append(": ");
                sb.append(header);
                sb.append('\n');
            }
        }
    }

    public static void reportParameters(StringBuilder sb, ae0 ae0Var) {
        Enumeration<String> parameterNames = ae0Var.getParameterNames();
        if (parameterNames != null && parameterNames.hasMoreElements()) {
            sb.append("Parameters:\n");
            while (parameterNames.hasMoreElements()) {
                String nextElement = parameterNames.nextElement();
                String[] parameterValues = ae0Var.getParameterValues(nextElement);
                if (parameterValues != null) {
                    for (String str : parameterValues) {
                        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "    ", nextElement, " = ", str);
                        sb.append('\n');
                    }
                }
            }
        }
    }

    public static void reportRequest(StringBuilder sb, ae0 ae0Var) {
        String str;
        sb.append("Request: ");
        sb.append(ae0Var.getMethod());
        sb.append(TokenParser.f4579SP);
        sb.append(ae0Var.getRequestURL());
        String queryString = ae0Var.getQueryString();
        if (queryString != null) {
            sb.append('?');
            sb.append(queryString);
        }
        sb.append(" - ");
        String requestedSessionId = ae0Var.getRequestedSessionId();
        if (requestedSessionId != null) {
            sb.append("\nSession ID: ");
        }
        if (requestedSessionId == null) {
            str = "No Session";
        } else if (ae0Var.isRequestedSessionIdValid()) {
            sb.append(requestedSessionId);
            sb.append(" (from ");
            str = ae0Var.isRequestedSessionIdFromCookie() ? "cookie)\n" : ae0Var.isRequestedSessionIdFromURL() ? "url)\n" : "unknown)\n";
        } else {
            str = "Invalid Session ID\n";
        }
        sb.append(str);
    }
}
