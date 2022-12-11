package com.arialyy.aria.http;

import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.common.RequestEnum;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.SSLContextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import me.tvspark.outline;
import org.eclipse.jetty.http.HttpHeaders;

/* loaded from: classes3.dex */
public final class ConnectionHelp {
    public static final String TAG = "ConnectionHelp";

    public static InputStream convertInputStream(HttpURLConnection httpURLConnection) throws IOException {
        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
        return TextUtils.isEmpty(headerField) ? httpURLConnection.getInputStream() : headerField.contains("gzip") ? new GZIPInputStream(httpURLConnection.getInputStream()) : headerField.contains("deflate") ? new InflaterInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream();
    }

    public static HttpURLConnection handleConnection(URL url, HttpTaskOption httpTaskOption) throws IOException {
        URLConnection openConnection = httpTaskOption.getProxy() != null ? url.openConnection(httpTaskOption.getProxy()) : url.openConnection();
        if (openConnection instanceof HttpsURLConnection) {
            AriaConfig ariaConfig = AriaConfig.getInstance();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            SSLContext sSLContextFromAssets = SSLContextUtil.getSSLContextFromAssets(ariaConfig.getDConfig().getCaName(), ariaConfig.getDConfig().getCaPath(), "TLS");
            if (sSLContextFromAssets == null) {
                sSLContextFromAssets = SSLContextUtil.getDefaultSLLContext("TLS");
            }
            httpsURLConnection.setSSLSocketFactory(sSLContextFromAssets.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(SSLContextUtil.HOSTNAME_VERIFIER);
            return httpsURLConnection;
        }
        return (HttpURLConnection) openConnection;
    }

    public static URL handleUrl(String str, HttpTaskOption httpTaskOption) throws MalformedURLException {
        Map<String, String> params = httpTaskOption.getParams();
        if (params == null || httpTaskOption.getRequestEnum() != RequestEnum.GET) {
            return new URL(CommonUtil.convertUrl(str));
        }
        if (str.contains("?")) {
            ALog.m4191e(TAG, String.format("设置参数失败，url中已经有?，url: %s", str));
            return new URL(CommonUtil.convertUrl(str));
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "?");
        for (String str2 : params.keySet()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(URLEncoder.encode(params.get(str2)));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("&");
        }
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        return new URL(CommonUtil.convertUrl(sb.substring(0, sb.length() - 1)));
    }

    public static HttpURLConnection setConnectParam(HttpTaskOption httpTaskOption, HttpURLConnection httpURLConnection) {
        CookieStore cookieStore;
        if (httpTaskOption.getRequestEnum() == RequestEnum.POST) {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
        }
        if (httpTaskOption.getHeaders() != null && httpTaskOption.getHeaders().size() > 0) {
            for (String str : httpTaskOption.getHeaders().keySet()) {
                httpURLConnection.setRequestProperty(str, httpTaskOption.getHeaders().get(str));
            }
        }
        if (httpURLConnection.getRequestProperty("Accept-Language") == null) {
            httpURLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7");
        }
        if (httpURLConnection.getRequestProperty("Accept-Encoding") == null) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        if (httpURLConnection.getRequestProperty("Accept-Charset") == null) {
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
        }
        if (httpURLConnection.getRequestProperty("Connection") == null) {
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        }
        if (httpURLConnection.getRequestProperty("Charset") == null) {
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
        }
        if (httpURLConnection.getRequestProperty("User-Agent") == null) {
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        }
        if (httpURLConnection.getRequestProperty("Accept") == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("image/gif, ");
            sb.append("image/jpeg, ");
            sb.append("image/pjpeg, ");
            sb.append("image/webp, ");
            sb.append("image/apng, ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "application/xml, ", "application/xaml+xml, ", "application/xhtml+xml, ", "application/x-shockwave-flash, ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "application/x-ms-xbap, ", "application/x-ms-application, ", "application/msword, ", "application/vnd.ms-excel, ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "application/vnd.ms-xpsdocument, ", "application/vnd.ms-powerpoint, ", "application/signed-exchange, ", "text/plain, ");
            sb.append("text/html, ");
            sb.append("*/*");
            httpURLConnection.setRequestProperty("Accept", sb.toString());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        CookieManager cookieManager = httpTaskOption.getCookieManager();
        if (cookieManager != null && (cookieStore = cookieManager.getCookieStore()) != null && cookieStore.getCookies().size() > 0) {
            httpURLConnection.setRequestProperty(HttpHeaders.COOKIE, TextUtils.join(";", cookieStore.getCookies()));
        }
        return httpURLConnection;
    }
}
