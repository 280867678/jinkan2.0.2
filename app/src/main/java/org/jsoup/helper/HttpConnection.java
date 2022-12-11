package org.jsoup.helper;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.pro.C1588bm;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.MultiPartWriter;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.UncheckedIOException;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.internal.ConstrainableInputStream;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

/* loaded from: classes5.dex */
public class HttpConnection implements Connection {
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
    public static final String DefaultUploadType = "application/octet-stream";
    public static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
    public static final int HTTP_TEMP_REDIR = 307;
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    public static final String USER_AGENT = "User-Agent";
    public Connection.Request req = new Request();
    public Connection.Response res = new Response();

    /* loaded from: classes5.dex */
    public static abstract class Base<T extends Connection.Base> implements Connection.Base<T> {
        public Map<String, String> cookies;
        public Map<String, List<String>> headers;
        public Connection.Method method;
        public URL url;

        public Base() {
            this.headers = new LinkedHashMap();
            this.cookies = new LinkedHashMap();
        }

        public static String fixHeaderEncoding(String str) {
            try {
                byte[] bytes = str.getBytes("ISO-8859-1");
                return !looksLikeUtf8(bytes) ? str : new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }

        private List<String> getHeadersCaseInsensitive(String str) {
            Validate.notNull(str);
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return Collections.emptyList();
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if ((((r8[1] & 255) == 187) & ((r8[2] & 255) == 191)) != false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static boolean looksLikeUtf8(byte[] bArr) {
            int i;
            int i2 = 3;
            if (bArr.length >= 3 && (bArr[0] & 255) == 239) {
            }
            i2 = 0;
            int length = bArr.length;
            while (i2 < length) {
                byte b = bArr[i2];
                if ((b & 128) != 0) {
                    if ((b & C1588bm.f3196k) == 192) {
                        i = i2 + 1;
                    } else if ((b & 240) == 224) {
                        i = i2 + 2;
                    } else if ((b & 248) != 240) {
                        return false;
                    } else {
                        i = i2 + 3;
                    }
                    if (i >= bArr.length) {
                        return false;
                    }
                    while (i2 < i) {
                        i2++;
                        if ((bArr[i2] & ExifInterface.MARKER_SOF0) != 128) {
                            return false;
                        }
                    }
                    continue;
                }
                i2++;
            }
            return true;
        }

        private Map.Entry<String, List<String>> scanHeaders(String str) {
            String lowerCase = Normalizer.lowerCase(str);
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                if (Normalizer.lowerCase(entry.getKey()).equals(lowerCase)) {
                    return entry;
                }
            }
            return null;
        }

        @Override // org.jsoup.Connection.Base
        public T addHeader(String str, String str2) {
            Validate.notEmpty(str);
            if (str2 == null) {
                str2 = "";
            }
            List<String> headers = headers(str);
            if (headers.isEmpty()) {
                headers = new ArrayList<>();
                this.headers.put(str, headers);
            }
            headers.add(fixHeaderEncoding(str2));
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public String cookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.get(str);
        }

        @Override // org.jsoup.Connection.Base
        public T cookie(String str, String str2) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            Validate.notNull(str2, "Cookie value must not be null");
            this.cookies.put(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, String> cookies() {
            return this.cookies;
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.containsKey(str);
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            return !getHeadersCaseInsensitive(str).isEmpty();
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasHeaderWithValue(String str, String str2) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            for (String str3 : headers(str)) {
                if (str2.equalsIgnoreCase(str3)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.jsoup.Connection.Base
        public String header(String str) {
            Validate.notNull(str, "Header name must not be null");
            List<String> headersCaseInsensitive = getHeadersCaseInsensitive(str);
            if (headersCaseInsensitive.size() > 0) {
                return StringUtil.join(headersCaseInsensitive, ", ");
            }
            return null;
        }

        @Override // org.jsoup.Connection.Base
        public T header(String str, String str2) {
            Validate.notEmpty(str, "Header name must not be empty");
            removeHeader(str);
            addHeader(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public List<String> headers(String str) {
            Validate.notEmpty(str);
            return getHeadersCaseInsensitive(str);
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, String> headers() {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.headers.size());
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value.size() > 0) {
                    linkedHashMap.put(key, value.get(0));
                }
            }
            return linkedHashMap;
        }

        @Override // org.jsoup.Connection.Base
        public T method(Connection.Method method) {
            Validate.notNull(method, "Method must not be null");
            this.method = method;
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Connection.Method method() {
            return this.method;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, List<String>> multiHeaders() {
            return this.headers;
        }

        @Override // org.jsoup.Connection.Base
        public T removeCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            this.cookies.remove(str);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public T removeHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            Map.Entry<String, List<String>> scanHeaders = scanHeaders(str);
            if (scanHeaders != null) {
                this.headers.remove(scanHeaders.getKey());
            }
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public URL url() {
            return this.url;
        }

        @Override // org.jsoup.Connection.Base
        public T url(URL url) {
            Validate.notNull(url, "URL must not be null");
            this.url = url;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static class KeyVal implements Connection.KeyVal {
        public String contentType;
        public String key;
        public InputStream stream;
        public String value;

        public static KeyVal create(String str, String str2) {
            return new KeyVal().mo5232key(str).mo5233value(str2);
        }

        public static KeyVal create(String str, String str2, InputStream inputStream) {
            return new KeyVal().mo5232key(str).mo5233value(str2).mo5231inputStream(inputStream);
        }

        @Override // org.jsoup.Connection.KeyVal
        public String contentType() {
            return this.contentType;
        }

        @Override // org.jsoup.Connection.KeyVal
        public Connection.KeyVal contentType(String str) {
            Validate.notEmpty(str);
            this.contentType = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public boolean hasInputStream() {
            return this.stream != null;
        }

        @Override // org.jsoup.Connection.KeyVal
        public InputStream inputStream() {
            return this.stream;
        }

        @Override // org.jsoup.Connection.KeyVal
        /* renamed from: inputStream  reason: collision with other method in class */
        public KeyVal mo5231inputStream(InputStream inputStream) {
            Validate.notNull(this.value, "Data input stream must not be null");
            this.stream = inputStream;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String key() {
            return this.key;
        }

        @Override // org.jsoup.Connection.KeyVal
        /* renamed from: key  reason: collision with other method in class */
        public KeyVal mo5232key(String str) {
            Validate.notEmpty(str, "Data key must not be empty");
            this.key = str;
            return this;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String value() {
            return this.value;
        }

        @Override // org.jsoup.Connection.KeyVal
        /* renamed from: value  reason: collision with other method in class */
        public KeyVal mo5233value(String str) {
            Validate.notNull(str, "Data value must not be null");
            this.value = str;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static class Request extends Base<Connection.Request> implements Connection.Request {
        public Proxy proxy;
        public SSLSocketFactory sslSocketFactory;
        public String body = null;
        public boolean ignoreHttpErrors = false;
        public boolean ignoreContentType = false;
        public boolean parserDefined = false;
        public String postDataCharset = "UTF-8";
        public int timeoutMilliseconds = BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH;
        public int maxBodySizeBytes = 2097152;
        public boolean followRedirects = true;
        public Collection<Connection.KeyVal> data = new ArrayList();
        public Parser parser = Parser.htmlParser();

        public Request() {
            super();
            this.method = Connection.Method.GET;
            addHeader("Accept-Encoding", "gzip");
            addHeader("User-Agent", HttpConnection.DEFAULT_UA);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Request addHeader(String str, String str2) {
            return super.addHeader(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Request cookie(String str, String str2) {
            return super.cookie(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // org.jsoup.Connection.Request
        public Collection<Connection.KeyVal> data() {
            return this.data;
        }

        @Override // org.jsoup.Connection.Request
        /* renamed from: data  reason: collision with other method in class */
        public Request mo5234data(Connection.KeyVal keyVal) {
            Validate.notNull(keyVal, "Key val must not be null");
            this.data.add(keyVal);
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean followRedirects() {
            return this.followRedirects;
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Request header(String str, String str2) {
            return super.header(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request ignoreContentType(boolean z) {
            this.ignoreContentType = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean ignoreContentType() {
            return this.ignoreContentType;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request ignoreHttpErrors(boolean z) {
            this.ignoreHttpErrors = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean ignoreHttpErrors() {
            return this.ignoreHttpErrors;
        }

        @Override // org.jsoup.Connection.Request
        public int maxBodySize() {
            return this.maxBodySizeBytes;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request maxBodySize(int i) {
            Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
            this.maxBodySizeBytes = i;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Request method(Connection.Method method) {
            return super.method(method);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        @Override // org.jsoup.Connection.Request
        /* renamed from: parser  reason: collision with other method in class */
        public Request mo5235parser(Parser parser) {
            this.parser = parser;
            this.parserDefined = true;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Parser parser() {
            return this.parser;
        }

        @Override // org.jsoup.Connection.Request
        public String postDataCharset() {
            return this.postDataCharset;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request postDataCharset(String str) {
            Validate.notNull(str, "Charset must not be null");
            if (Charset.isSupported(str)) {
                this.postDataCharset = str;
                return this;
            }
            throw new IllegalCharsetNameException(str);
        }

        @Override // org.jsoup.Connection.Request
        public Proxy proxy() {
            return this.proxy;
        }

        @Override // org.jsoup.Connection.Request
        /* renamed from: proxy  reason: collision with other method in class */
        public Request mo5236proxy(String str, int i) {
            this.proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i));
            return this;
        }

        @Override // org.jsoup.Connection.Request
        /* renamed from: proxy  reason: collision with other method in class */
        public Request mo5237proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Request removeCookie(String str) {
            return super.removeCookie(str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Request removeHeader(String str) {
            return super.removeHeader(str);
        }

        @Override // org.jsoup.Connection.Request
        public String requestBody() {
            return this.body;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request requestBody(String str) {
            this.body = str;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public SSLSocketFactory sslSocketFactory() {
            return this.sslSocketFactory;
        }

        @Override // org.jsoup.Connection.Request
        public void sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
        }

        @Override // org.jsoup.Connection.Request
        public int timeout() {
            return this.timeoutMilliseconds;
        }

        @Override // org.jsoup.Connection.Request
        /* renamed from: timeout  reason: collision with other method in class */
        public Request mo5238timeout(int i) {
            Validate.isTrue(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.timeoutMilliseconds = i;
            return this;
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Request url(URL url) {
            return super.url(url);
        }
    }

    /* loaded from: classes5.dex */
    public static class Response extends Base<Connection.Response> implements Connection.Response {
        public static final String LOCATION = "Location";
        public static final int MAX_REDIRECTS = 20;
        public static final Pattern xmlContentTypeRxp = Pattern.compile("(application|text)/\\w*\\+?xml.*");
        public InputStream bodyStream;
        public ByteBuffer byteData;
        public String charset;
        public HttpURLConnection conn;
        public String contentType;
        public boolean executed;
        public boolean inputStreamRead;
        public int numRedirects;
        public Connection.Request req;
        public int statusCode;
        public String statusMessage;

        public Response() {
            super();
            this.executed = false;
            this.inputStreamRead = false;
            this.numRedirects = 0;
        }

        public Response(Response response) throws IOException {
            super();
            this.executed = false;
            this.inputStreamRead = false;
            this.numRedirects = 0;
            if (response != null) {
                int i = response.numRedirects + 1;
                this.numRedirects = i;
                if (i >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", response.url()));
                }
            }
        }

        public static HttpURLConnection createConnection(Connection.Request request) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) (request.proxy() == null ? request.url().openConnection() : request.url().openConnection(request.proxy()));
            httpURLConnection.setRequestMethod(request.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.timeout());
            httpURLConnection.setReadTimeout(request.timeout() / 2);
            if (request.sslSocketFactory() != null && (httpURLConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(request.sslSocketFactory());
            }
            if (request.method().hasBody()) {
                httpURLConnection.setDoOutput(true);
            }
            if (request.cookies().size() > 0) {
                httpURLConnection.addRequestProperty(HttpHeaders.COOKIE, getRequestCookieString(request));
            }
            for (Map.Entry<String, List<String>> entry : request.multiHeaders().entrySet()) {
                for (String str : entry.getValue()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), str);
                }
            }
            return httpURLConnection;
        }

        public static LinkedHashMap<String, List<String>> createHeaderMap(HttpURLConnection httpURLConnection) {
            LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i++;
                if (headerFieldKey != null && headerField != null) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        linkedHashMap.get(headerFieldKey).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        public static Response execute(Connection.Request request) throws IOException {
            return execute(request, null);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(11:8|(1:10)(1:100)|(1:12)|13|(9:(1:(9:99|19|20|21|(1:23)|24|26|27|(2:46|(2:90|91)(6:50|(2:59|60)|69|(1:87)(6:73|(1:75)(1:86)|76|(1:78)(3:83|(1:85)|80)|79|80)|81|82))(9:31|(1:33)|34|(1:38)|39|(2:42|40)|43|44|45)))(1:17)|26|27|(1:29)|46|(1:48)|88|90|91)|18|19|20|21|(0)|24) */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x015e, code lost:
            if (org.jsoup.helper.HttpConnection.Response.xmlContentTypeRxp.matcher(r10).matches() == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
            if ((r9 instanceof org.jsoup.helper.HttpConnection.Request) == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x016b, code lost:
            if (((org.jsoup.helper.HttpConnection.Request) r9).parserDefined != false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x016d, code lost:
            r9.mo5235parser(org.jsoup.parser.Parser.xmlParser());
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x01f8, code lost:
            r9 = e;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0087 A[Catch: IOException -> 0x01f8, TryCatch #0 {IOException -> 0x01f8, blocks: (B:21:0x007e, B:23:0x0087, B:24:0x008e), top: B:20:0x007e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Response execute(Connection.Request request, Response response) throws IOException {
            String outputContentType;
            HttpURLConnection createConnection;
            int responseCode;
            Response response2;
            InputStream inflaterInputStream;
            Validate.notNull(request, "Request must not be null");
            Validate.notNull(request.url(), "URL must be specified to connect");
            String protocol = request.url().getProtocol();
            if (protocol.equals("http") || protocol.equals("https")) {
                boolean hasBody = request.method().hasBody();
                boolean z = request.requestBody() != null;
                if (!hasBody) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot set a request body for HTTP method ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.method());
                    Validate.isFalse(z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                Response response3 = null;
                try {
                    if (request.data().size() > 0 && (!hasBody || z)) {
                        serialiseRequestUrl(request);
                    } else if (hasBody) {
                        outputContentType = setOutputContentType(request);
                        long nanoTime = System.nanoTime();
                        createConnection = createConnection(request);
                        createConnection.connect();
                        if (createConnection.getDoOutput()) {
                            writePost(request, createConnection.getOutputStream(), outputContentType);
                        }
                        responseCode = createConnection.getResponseCode();
                        response2 = new Response(response);
                        response2.setupFromConnection(createConnection, response);
                        response2.req = request;
                        if (!response2.hasHeader("Location") && request.followRedirects()) {
                            if (responseCode != 307) {
                                request.method(Connection.Method.GET);
                                request.data().clear();
                                request.requestBody(null);
                                request.removeHeader("Content-Type");
                            }
                            String header = response2.header("Location");
                            if (header.startsWith("http:/") && header.charAt(6) != '/') {
                                header = header.substring(6);
                            }
                            request.url(HttpConnection.encodeUrl(StringUtil.resolve(request.url(), header)));
                            for (Map.Entry<String, String> entry : response2.cookies.entrySet()) {
                                request.cookie(entry.getKey(), entry.getValue());
                            }
                            return execute(request, response2);
                        } else if ((responseCode >= 200 || responseCode >= 400) && !request.ignoreHttpErrors()) {
                            throw new HttpStatusException("HTTP error fetching URL", responseCode, request.url().toString());
                        } else {
                            String contentType = response2.contentType();
                            if (contentType != null && !request.ignoreContentType() && !contentType.startsWith("text/") && !xmlContentTypeRxp.matcher(contentType).matches()) {
                                throw new UnsupportedMimeTypeException("Unhandled content type. Must be text/*, application/xml, or application/*+xml", contentType, request.url().toString());
                            }
                            response2.charset = DataUtil.getCharsetFromContentType(response2.contentType);
                            if (createConnection.getContentLength() == 0 || request.method() == Connection.Method.HEAD) {
                                response2.byteData = DataUtil.emptyByteBuffer();
                            } else {
                                response2.bodyStream = null;
                                response2.bodyStream = createConnection.getErrorStream() != null ? createConnection.getErrorStream() : createConnection.getInputStream();
                                if (response2.hasHeaderWithValue("Content-Encoding", "gzip")) {
                                    inflaterInputStream = new GZIPInputStream(response2.bodyStream);
                                } else {
                                    if (response2.hasHeaderWithValue("Content-Encoding", "deflate")) {
                                        inflaterInputStream = new InflaterInputStream(response2.bodyStream, new Inflater(true));
                                    }
                                    response2.bodyStream = ConstrainableInputStream.wrap(response2.bodyStream, 32768, request.maxBodySize()).timeout(nanoTime, request.timeout());
                                }
                                response2.bodyStream = inflaterInputStream;
                                response2.bodyStream = ConstrainableInputStream.wrap(response2.bodyStream, 32768, request.maxBodySize()).timeout(nanoTime, request.timeout());
                            }
                            response2.executed = true;
                            return response2;
                        }
                    }
                    response2.setupFromConnection(createConnection, response);
                    response2.req = request;
                    if (!response2.hasHeader("Location")) {
                    }
                    if (responseCode >= 200) {
                    }
                    throw new HttpStatusException("HTTP error fetching URL", responseCode, request.url().toString());
                } catch (IOException e) {
                    e = e;
                    response3 = response2;
                    if (response3 != null) {
                        response3.safeClose();
                    }
                    throw e;
                }
                outputContentType = null;
                long nanoTime2 = System.nanoTime();
                createConnection = createConnection(request);
                createConnection.connect();
                if (createConnection.getDoOutput()) {
                }
                responseCode = createConnection.getResponseCode();
                response2 = new Response(response);
            } else {
                throw new MalformedURLException("Only http & https protocols supported");
            }
        }

        public static String getRequestCookieString(Connection.Request request) {
            StringBuilder borrowBuilder = StringUtil.borrowBuilder();
            boolean z = true;
            for (Map.Entry<String, String> entry : request.cookies().entrySet()) {
                if (!z) {
                    borrowBuilder.append("; ");
                } else {
                    z = false;
                }
                borrowBuilder.append(entry.getKey());
                borrowBuilder.append(B64Code.__pad);
                borrowBuilder.append(entry.getValue());
            }
            return StringUtil.releaseBuilder(borrowBuilder);
        }

        private void prepareByteData() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            if (this.byteData == null) {
                Validate.isFalse(this.inputStreamRead, "Request has already been read (with .parse())");
                try {
                    try {
                        this.byteData = DataUtil.readToByteBuffer(this.bodyStream, this.req.maxBodySize());
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                } finally {
                    this.inputStreamRead = true;
                    safeClose();
                }
            }
        }

        private void safeClose() {
            InputStream inputStream = this.bodyStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.bodyStream = null;
                    throw th;
                }
                this.bodyStream = null;
            }
            HttpURLConnection httpURLConnection = this.conn;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.conn = null;
            }
        }

        public static void serialiseRequestUrl(Connection.Request request) throws IOException {
            boolean z;
            URL url = request.url();
            StringBuilder borrowBuilder = StringUtil.borrowBuilder();
            borrowBuilder.append(url.getProtocol());
            borrowBuilder.append("://");
            borrowBuilder.append(url.getAuthority());
            borrowBuilder.append(url.getPath());
            borrowBuilder.append("?");
            if (url.getQuery() != null) {
                borrowBuilder.append(url.getQuery());
                z = false;
            } else {
                z = true;
            }
            for (Connection.KeyVal keyVal : request.data()) {
                Validate.isFalse(keyVal.hasInputStream(), "InputStream data not supported in URL query string.");
                if (!z) {
                    borrowBuilder.append('&');
                } else {
                    z = false;
                }
                borrowBuilder.append(URLEncoder.encode(keyVal.key(), "UTF-8"));
                borrowBuilder.append(B64Code.__pad);
                borrowBuilder.append(URLEncoder.encode(keyVal.value(), "UTF-8"));
            }
            request.url(new URL(StringUtil.releaseBuilder(borrowBuilder)));
            request.data().clear();
        }

        public static String setOutputContentType(Connection.Request request) {
            String mimeBoundary;
            StringBuilder sb;
            if (request.hasHeader("Content-Type")) {
                if (request.header("Content-Type").contains("multipart/form-data") && !request.header("Content-Type").contains("boundary")) {
                    mimeBoundary = DataUtil.mimeBoundary();
                    sb = new StringBuilder();
                    sb.append("multipart/form-data; boundary=");
                    sb.append(mimeBoundary);
                    request.header("Content-Type", sb.toString());
                    return mimeBoundary;
                }
                return null;
            } else if (!HttpConnection.needsMultipart(request)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("application/x-www-form-urlencoded; charset=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.postDataCharset());
                request.header("Content-Type", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return null;
            } else {
                mimeBoundary = DataUtil.mimeBoundary();
                sb = new StringBuilder();
                sb.append("multipart/form-data; boundary=");
                sb.append(mimeBoundary);
                request.header("Content-Type", sb.toString());
                return mimeBoundary;
            }
        }

        private void setupFromConnection(HttpURLConnection httpURLConnection, Response response) throws IOException {
            this.conn = httpURLConnection;
            this.method = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.url = httpURLConnection.getURL();
            this.statusCode = httpURLConnection.getResponseCode();
            this.statusMessage = httpURLConnection.getResponseMessage();
            this.contentType = httpURLConnection.getContentType();
            processResponseHeaders(createHeaderMap(httpURLConnection));
            if (response != null) {
                for (Map.Entry entry : response.cookies().entrySet()) {
                    if (!hasCookie((String) entry.getKey())) {
                        cookie((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                response.safeClose();
            }
        }

        public static void writePost(Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.KeyVal> data = request.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, request.postDataCharset()));
            if (str != null) {
                for (Connection.KeyVal keyVal : data) {
                    bufferedWriter.write(MultiPartWriter.__DASHDASH);
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.key()));
                    bufferedWriter.write("\"");
                    if (keyVal.hasInputStream()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.value()));
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        bufferedWriter.write(keyVal.contentType() != null ? keyVal.contentType() : "application/octet-stream");
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.crossStreams(keyVal.inputStream(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(keyVal.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write(MultiPartWriter.__DASHDASH);
                bufferedWriter.write(str);
                bufferedWriter.write(MultiPartWriter.__DASHDASH);
            } else if (request.requestBody() != null) {
                bufferedWriter.write(request.requestBody());
            } else {
                boolean z = true;
                for (Connection.KeyVal keyVal2 : data) {
                    if (!z) {
                        bufferedWriter.append('&');
                    } else {
                        z = false;
                    }
                    bufferedWriter.write(URLEncoder.encode(keyVal2.key(), request.postDataCharset()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(keyVal2.value(), request.postDataCharset()));
                }
            }
            bufferedWriter.close();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Response addHeader(String str, String str2) {
            return super.addHeader(str, str2);
        }

        @Override // org.jsoup.Connection.Response
        public String body() {
            prepareByteData();
            String str = this.charset;
            if (str == null) {
                str = "UTF-8";
            }
            String charBuffer = Charset.forName(str).decode(this.byteData).toString();
            this.byteData.rewind();
            return charBuffer;
        }

        @Override // org.jsoup.Connection.Response
        public byte[] bodyAsBytes() {
            prepareByteData();
            return this.byteData.array();
        }

        @Override // org.jsoup.Connection.Response
        public BufferedInputStream bodyStream() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            Validate.isFalse(this.inputStreamRead, "Request has already been read");
            this.inputStreamRead = true;
            return ConstrainableInputStream.wrap(this.bodyStream, 32768, this.req.maxBodySize());
        }

        @Override // org.jsoup.Connection.Response
        public Connection.Response bufferUp() {
            prepareByteData();
            return this;
        }

        @Override // org.jsoup.Connection.Response
        public String charset() {
            return this.charset;
        }

        @Override // org.jsoup.Connection.Response
        /* renamed from: charset  reason: collision with other method in class */
        public Response mo5239charset(String str) {
            this.charset = str;
            return this;
        }

        @Override // org.jsoup.Connection.Response
        public String contentType() {
            return this.contentType;
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Response cookie(String str, String str2) {
            return super.cookie(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Response header(String str, String str2) {
            return super.header(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Response method(Connection.Method method) {
            return super.method(method);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        @Override // org.jsoup.Connection.Response
        public Document parse() throws IOException {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.byteData != null) {
                this.bodyStream = new ByteArrayInputStream(this.byteData.array());
                this.inputStreamRead = false;
            }
            Validate.isFalse(this.inputStreamRead, "Input stream already read and parsed, cannot re-read.");
            Document parseInputStream = DataUtil.parseInputStream(this.bodyStream, this.charset, this.url.toExternalForm(), this.req.parser());
            this.charset = parseInputStream.outputSettings().charset().name();
            this.inputStreamRead = true;
            safeClose();
            return parseInputStream;
        }

        public void processResponseHeaders(Map<String, List<String>> map) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    List<String> value = entry.getValue();
                    if (key.equalsIgnoreCase(HttpHeaders.SET_COOKIE)) {
                        for (String str : value) {
                            if (str != null) {
                                TokenQueue tokenQueue = new TokenQueue(str);
                                String trim = tokenQueue.chompTo("=").trim();
                                String trim2 = tokenQueue.consumeTo(";").trim();
                                if (trim.length() > 0) {
                                    cookie(trim, trim2);
                                }
                            }
                        }
                    }
                    for (String str2 : value) {
                        addHeader(key, str2);
                    }
                }
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Response removeCookie(String str) {
            return super.removeCookie(str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Response removeHeader(String str) {
            return super.removeHeader(str);
        }

        @Override // org.jsoup.Connection.Response
        public int statusCode() {
            return this.statusCode;
        }

        @Override // org.jsoup.Connection.Response
        public String statusMessage() {
            return this.statusMessage;
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Response url(URL url) {
            return super.url(url);
        }
    }

    public static Connection connect(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(str);
        return httpConnection;
    }

    public static Connection connect(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(url);
        return httpConnection;
    }

    public static String encodeMimeName(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\"", "%22");
    }

    public static String encodeUrl(String str) {
        try {
            return encodeUrl(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    public static URL encodeUrl(URL url) {
        try {
            return new URL(new URI(url.toExternalForm().replace(StringUtils.SPACE, "%20")).toASCIIString());
        } catch (MalformedURLException | URISyntaxException unused) {
            return url;
        }
    }

    public static boolean needsMultipart(Connection.Request request) {
        for (Connection.KeyVal keyVal : request.data()) {
            if (keyVal.hasInputStream()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.jsoup.Connection
    public Connection cookie(String str, String str2) {
        this.req.cookie(str, str2);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection cookies(Map<String, String> map) {
        Validate.notNull(map, "Cookie map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.cookie(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.KeyVal data(String str) {
        Validate.notEmpty(str, "Data key must not be empty");
        for (Connection.KeyVal keyVal : request().data()) {
            if (keyVal.key().equals(str)) {
                return keyVal;
            }
        }
        return null;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2) {
        this.req.mo5234data(KeyVal.create(str, str2));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream) {
        this.req.mo5234data(KeyVal.create(str, str2, inputStream));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream, String str3) {
        this.req.mo5234data(KeyVal.create(str, str2, inputStream).contentType(str3));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(Collection<Connection.KeyVal> collection) {
        Validate.notNull(collection, "Data collection must not be null");
        for (Connection.KeyVal keyVal : collection) {
            this.req.mo5234data(keyVal);
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(Map<String, String> map) {
        Validate.notNull(map, "Data map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.mo5234data(KeyVal.create(entry.getKey(), entry.getValue()));
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String... strArr) {
        Validate.notNull(strArr, "Data key value pairs must not be null");
        Validate.isTrue(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            Validate.notEmpty(str, "Data key must not be empty");
            Validate.notNull(str2, "Data value must not be null");
            this.req.mo5234data(KeyVal.create(str, str2));
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.Response execute() throws IOException {
        Response execute = Response.execute(this.req);
        this.res = execute;
        return execute;
    }

    @Override // org.jsoup.Connection
    public Connection followRedirects(boolean z) {
        this.req.followRedirects(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Document get() throws IOException {
        this.req.method(Connection.Method.GET);
        execute();
        return this.res.parse();
    }

    @Override // org.jsoup.Connection
    public Connection header(String str, String str2) {
        this.req.header(str, str2);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection headers(Map<String, String> map) {
        Validate.notNull(map, "Header map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.header(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection ignoreContentType(boolean z) {
        this.req.ignoreContentType(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection ignoreHttpErrors(boolean z) {
        this.req.ignoreHttpErrors(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection maxBodySize(int i) {
        this.req.maxBodySize(i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection method(Connection.Method method) {
        this.req.method(method);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection parser(Parser parser) {
        this.req.mo5235parser(parser);
        return this;
    }

    @Override // org.jsoup.Connection
    public Document post() throws IOException {
        this.req.method(Connection.Method.POST);
        execute();
        return this.res.parse();
    }

    @Override // org.jsoup.Connection
    public Connection postDataCharset(String str) {
        this.req.postDataCharset(str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection proxy(String str, int i) {
        this.req.mo5236proxy(str, i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection proxy(Proxy proxy) {
        this.req.mo5237proxy(proxy);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection referrer(String str) {
        Validate.notNull(str, "Referrer must not be null");
        this.req.header("Referer", str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.Request request() {
        return this.req;
    }

    @Override // org.jsoup.Connection
    public Connection request(Connection.Request request) {
        this.req = request;
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection requestBody(String str) {
        this.req.requestBody(str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.Response response() {
        return this.res;
    }

    @Override // org.jsoup.Connection
    public Connection response(Connection.Response response) {
        this.res = response;
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.req.sslSocketFactory(sSLSocketFactory);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection timeout(int i) {
        this.req.mo5238timeout(i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection url(String str) {
        Validate.notEmpty(str, "Must supply a valid URL");
        try {
            this.req.url(new URL(encodeUrl(str)));
            return this;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Malformed URL: ", str), e);
        }
    }

    @Override // org.jsoup.Connection
    public Connection url(URL url) {
        this.req.url(url);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection userAgent(String str) {
        Validate.notNull(str, "User agent must not be null");
        this.req.header("User-Agent", str);
        return this;
    }
}
