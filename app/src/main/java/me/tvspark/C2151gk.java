package me.tvspark;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.fourthline.cling.model.types.BytesRange;

/* renamed from: me.tvspark.gk */
/* loaded from: classes4.dex */
public class C2151gk extends AbstractC2715vj implements HttpDataSource {
    public long Wwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public InputStream Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public HttpURLConnection Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C1949bk Wwwwwwwwwwwwwwwwwwwwwwww;
    public final HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Pattern Wwwwwwwwwwwwwww = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference<byte[]> Wwwwwwwwwwwwww = new AtomicReference<>();

    public C2151gk(String str, int i, int i2, boolean z, @Nullable HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        super(true);
        if (!TextUtils.isEmpty(str)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = new HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static URL Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(URL url, @Nullable String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if ("https".equals(protocol) || "http".equals(protocol)) {
                return url2;
            }
            String valueOf = String.valueOf(protocol);
            throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
        }
        throw new ProtocolException("Null location redirect");
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HttpURLConnection httpURLConnection, long j) {
        int i = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 19 || i == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (!"com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) && !"com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    return;
                }
                Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        if (this.Wwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwww) {
            return;
        }
        byte[] andSet = Wwwwwwwwwwwwww.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j = this.Wwwwwwwwwwwwwwwww;
            long j2 = this.Wwwwwwwwwwwwwwwwwww;
            if (j == j2) {
                Wwwwwwwwwwwwww.set(andSet);
                return;
            }
            int read = this.Wwwwwwwwwwwwwwwwwwwwww.read(andSet, 0, (int) Math.min(j2 - j, andSet.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (read == -1) {
                throw new EOFException();
            }
            this.Wwwwwwwwwwwwwwwww += read;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        HttpURLConnection httpURLConnection = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected error while disconnecting", e);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HttpURLConnection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws IOException {
        C1949bk c1949bk2 = c1949bk;
        URL url = new URL(c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        int i = c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr = c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j = c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j2 = c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = 0;
        boolean z = (c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwww & 1) == 1;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, i, bArr, j, j2, z, true, c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        while (true) {
            int i3 = i2 + 1;
            if (i2 > 20) {
                throw new NoRouteToHostException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(31, "Too many redirects: ", i3));
            }
            long j3 = j2;
            long j4 = j;
            HttpURLConnection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, i, bArr, j, j2, z, false, c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int responseCode = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResponseCode();
            String headerField = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHeaderField("Location");
            if ((i == 1 || i == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.disconnect();
                url = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, headerField);
            } else if (i != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                break;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.disconnect();
                url = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, headerField);
                i = 1;
                bArr = null;
            }
            c1949bk2 = c1949bk;
            i2 = i3;
            j2 = j3;
            j = j4;
        }
    }

    @Override // me.tvspark.AbstractC2715vj, me.tvspark.AbstractC2863zj
    public Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        HttpURLConnection httpURLConnection = this.Wwwwwwwwwwwwwwwwwwwwwww;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    public final HttpURLConnection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(URL url, int i, @Nullable byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        httpURLConnection.setReadTimeout(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        HashMap hashMap = new HashMap();
        HttpDataSource.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            hashMap.putAll(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        hashMap.putAll(this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j != 0 || j2 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append(BytesRange.PREFIX);
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        httpURLConnection.setRequestProperty("Accept-Encoding", z ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(C1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwwww != null) {
                HttpURLConnection httpURLConnection = this.Wwwwwwwwwwwwwwwwwwwwwww;
                long j = this.Wwwwwwwwwwwwwwwwww;
                if (j != -1) {
                    j -= this.Wwwwwwwwwwwwwwww;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpURLConnection, j);
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwww.close();
                } catch (IOException e) {
                    throw new HttpDataSource.HttpDataSourceException(e, this.Wwwwwwwwwwwwwwwwwwwwwwww, 3);
                }
            }
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwww = null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = false;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (i2 == 0) {
                return 0;
            }
            long j = this.Wwwwwwwwwwwwwwwwww;
            if (j != -1) {
                long j2 = j - this.Wwwwwwwwwwwwwwww;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                }
                return -1;
            }
            int read = this.Wwwwwwwwwwwwwwwwwwwwww.read(bArr, i, i2);
            if (read == -1) {
                if (this.Wwwwwwwwwwwwwwwwww != -1) {
                    throw new EOFException();
                }
                return -1;
            }
            this.Wwwwwwwwwwwwwwww += read;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
            return read;
        } catch (IOException e) {
            throw new HttpDataSource.HttpDataSourceException(e, this.Wwwwwwwwwwwwwwwwwwwwwwww, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
        if (r7 != 0) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.Map] */
    @Override // me.tvspark.AbstractC2863zj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws HttpDataSource.HttpDataSourceException {
        long j;
        long parseLong;
        String headerField;
        C1949bk c1949bk2 = c1949bk;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c1949bk2;
        this.Wwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwww = 0L;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        int i = 1;
        try {
            HttpURLConnection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            try {
                this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResponseCode();
                String responseMessage = this.Wwwwwwwwwwwwwwwwwwwwwww.getResponseMessage();
                int i2 = this.Wwwwwwwwwwwwwwwwwwww;
                if (i2 < 200 || i2 > 299) {
                    Map<String, List<String>> headerFields = this.Wwwwwwwwwwwwwwwwwwwwwww.getHeaderFields();
                    InputStream errorStream = this.Wwwwwwwwwwwwwwwwwwwwwww.getErrorStream();
                    try {
                        byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = errorStream != null ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorStream) : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        i = headerFields;
                        c1949bk2 = c1949bk;
                        HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(this.Wwwwwwwwwwwwwwwwwwww, responseMessage, i, c1949bk2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (this.Wwwwwwwwwwwwwwwwwwww == 416) {
                            invalidResponseCodeException.initCause(new DataSourceException(0));
                        }
                        throw invalidResponseCodeException;
                    } catch (IOException e) {
                        throw new HttpDataSource.HttpDataSourceException("Error reading non-2xx response body", e, c1949bk2, i);
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww.getContentType();
                if (this.Wwwwwwwwwwwwwwwwwwww == 200) {
                    j = c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                j = 0;
                this.Wwwwwwwwwwwwwwwwwww = j;
                boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(this.Wwwwwwwwwwwwwwwwwwwwwww.getHeaderField("Content-Encoding"));
                if (!equalsIgnoreCase) {
                    long j2 = c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long j3 = -1;
                    if (j2 != -1) {
                        this.Wwwwwwwwwwwwwwwwww = j2;
                    } else {
                        HttpURLConnection httpURLConnection = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
                        if (!TextUtils.isEmpty(headerField2)) {
                            try {
                                parseLong = Long.parseLong(headerField2);
                            } catch (NumberFormatException unused) {
                                String.valueOf(headerField2).length();
                            }
                            headerField = httpURLConnection.getHeaderField("Content-Range");
                            if (!TextUtils.isEmpty(headerField)) {
                                Matcher matcher = Wwwwwwwwwwwwwww.matcher(headerField);
                                if (matcher.find()) {
                                    try {
                                        long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                        if (parseLong < 0) {
                                            parseLong = parseLong2;
                                        } else if (parseLong != parseLong2) {
                                            String.valueOf(headerField2).length();
                                            String.valueOf(headerField).length();
                                            parseLong = Math.max(parseLong, parseLong2);
                                        }
                                    } catch (NumberFormatException unused2) {
                                        String.valueOf(headerField).length();
                                    }
                                }
                            }
                            if (parseLong != -1) {
                                j3 = parseLong - this.Wwwwwwwwwwwwwwwwwww;
                            }
                            this.Wwwwwwwwwwwwwwwwww = j3;
                        }
                        parseLong = -1;
                        headerField = httpURLConnection.getHeaderField("Content-Range");
                        if (!TextUtils.isEmpty(headerField)) {
                        }
                        if (parseLong != -1) {
                        }
                        this.Wwwwwwwwwwwwwwwwww = j3;
                    }
                } else {
                    this.Wwwwwwwwwwwwwwwwww = c1949bk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.getInputStream();
                    if (equalsIgnoreCase) {
                        this.Wwwwwwwwwwwwwwwwwwwwww = new GZIPInputStream(this.Wwwwwwwwwwwwwwwwwwwwww);
                    }
                    this.Wwwwwwwwwwwwwwwwwwwww = true;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
                    return this.Wwwwwwwwwwwwwwwwww;
                } catch (IOException e2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw new HttpDataSource.HttpDataSourceException(e2, c1949bk2, 1);
                }
            } catch (IOException e3) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect", e3, c1949bk2, 1);
            }
        } catch (IOException e4) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect", e4, c1949bk2, 1);
        }
    }
}
