package me.tvspark;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;

/* loaded from: classes4.dex */
public interface ce0 extends ServletResponse {
    void addCookie(Cookie cookie);

    void addDateHeader(String str, long j);

    void addHeader(String str, String str2);

    void addIntHeader(String str, int i);

    boolean containsHeader(String str);

    String encodeRedirectURL(String str);

    String encodeRedirectUrl(String str);

    String encodeURL(String str);

    String encodeUrl(String str);

    String getHeader(String str);

    Collection<String> getHeaderNames();

    Collection<String> getHeaders(String str);

    int getStatus();

    void sendError(int i) throws IOException;

    void sendError(int i, String str) throws IOException;

    void sendRedirect(String str) throws IOException;

    void setDateHeader(String str, long j);

    void setHeader(String str, String str2);

    void setIntHeader(String str, int i);

    void setStatus(int i);

    void setStatus(int i, String str);
}
