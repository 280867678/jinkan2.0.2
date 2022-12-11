package okhttp3;

import com.just.agentweb.DefaultWebClient;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.hx0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.mi0;
import me.tvspark.mx0;
import me.tvspark.nk0;
import me.tvspark.r40;
import me.tvspark.uw0;
import me.tvspark.vw0;
import me.tvspark.ww0;
import me.tvspark.xw0;
import me.tvspark.yw0;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.p053io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import org.eclipse.jetty.http.HttpHeaderValues;

@ef0
/* loaded from: classes4.dex */
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    public static final int ENTRY_BODY = 1;
    public static final int ENTRY_COUNT = 2;
    public static final int ENTRY_METADATA = 0;
    public static final int VERSION = 201105;
    public final DiskLruCache cache;
    public int hitCount;
    public int networkCount;
    public int requestCount;
    public int writeAbortCount;
    public int writeSuccessCount;

    @ef0
    /* loaded from: classes4.dex */
    public static final class CacheResponseBody extends ResponseBody {
        public final ww0 bodySource;
        public final String contentLength;
        public final String contentType;
        public final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            final mx0 source = snapshot.getSource(1);
            yw0 yw0Var = new yw0(source) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // me.tvspark.yw0, me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    CacheResponseBody.this.getSnapshot$okhttp().close();
                    super.close();
                }
            };
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yw0Var, "$receiver");
            this.bodySource = new hx0(yw0Var);
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return Util.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot$okhttp() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public ww0 source() {
            return this.bodySource;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i = 0; i < size; i++) {
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Vary", headers.name(i), true)) {
                    String value = headers.value(i);
                    if (treeSet == null) {
                        treeSet = new TreeSet(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mi0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    for (String str : nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) value, new char[]{','}, false, 0, 6)) {
                        if (str == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        treeSet.add(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).toString());
                    }
                    continue;
                }
            }
            return treeSet != null ? treeSet : EmptySet.INSTANCE;
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i));
                }
            }
            return builder.build();
        }

        public final boolean hasVaryAll(Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "$this$hasVaryAll");
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl httpUrl) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
            return ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl.toString()).md5().hex();
        }

        public final int readInt$okhttp(ww0 ww0Var) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
            try {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ww0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                String Wwwwwwwwwwwwwwwwwwwwwwwww = ww0Var.Wwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwww <= Integer.MAX_VALUE) {
                    if (!(Wwwwwwwwwwwwwwwwwwwwwwwww.length() > 0)) {
                        return (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
                throw new IOException("expected an int but was \"" + Wwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwww + '\"');
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "$this$varyHeaders");
            Response networkResponse = response.networkResponse();
            if (networkResponse != null) {
                return varyHeaders(networkResponse.request().headers(), response.headers());
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }

        public final boolean varyMatches(Response response, Headers headers, Request request) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "cachedResponse");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, "cachedRequest");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "newRequest");
            Set<String> varyFields = varyFields(response.headers());
            if (!(varyFields instanceof Collection) || !varyFields.isEmpty()) {
                for (String str : varyFields) {
                    if (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers.values(str), request.headers(str))) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Entry {
        public final int code;
        public final Handshake handshake;
        public final String message;
        public final Protocol protocol;
        public final long receivedResponseMillis;
        public final String requestMethod;
        public final Headers responseHeaders;
        public final long sentRequestMillis;
        public final String url;
        public final Headers varyHeaders;
        public static final Companion Companion = new Companion(null);
        public static final String SENT_MILLIS = Platform.Companion.get().getPrefix() + "-Sent-Millis";
        public static final String RECEIVED_MILLIS = Platform.Companion.get().getPrefix() + "-Received-Millis";

        @ef0
        /* loaded from: classes4.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(gi0 gi0Var) {
                this();
            }
        }

        public Entry(mx0 mx0Var) throws IOException {
            Handshake handshake;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "rawSource");
            try {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "$receiver");
                hx0 hx0Var = new hx0(mx0Var);
                this.url = hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwww();
                this.requestMethod = hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwww();
                Headers.Builder builder = new Headers.Builder();
                int readInt$okhttp = Cache.Companion.readInt$okhttp(hx0Var);
                boolean z = false;
                for (int i = 0; i < readInt$okhttp; i++) {
                    builder.addLenient$okhttp(hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwww());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.Companion.parse(hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwww());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt$okhttp2 = Cache.Companion.readInt$okhttp(hx0Var);
                for (int i2 = 0; i2 < readInt$okhttp2; i2++) {
                    builder2.addLenient$okhttp(hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwww());
                }
                String str = builder2.get(SENT_MILLIS);
                String str2 = builder2.get(RECEIVED_MILLIS);
                builder2.removeAll(SENT_MILLIS);
                builder2.removeAll(RECEIVED_MILLIS);
                long j = 0;
                this.sentRequestMillis = str != null ? Long.parseLong(str) : 0L;
                this.receivedResponseMillis = str2 != null ? Long.parseLong(str2) : j;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String Wwwwwwwwwwwwwwwwwwwwwwwww = hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwww.length() > 0 ? true : z) {
                        throw new IOException("expected \"\" but was \"" + Wwwwwwwwwwwwwwwwwwwwwwwww + '\"');
                    }
                    handshake = Handshake.Companion.get(!hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? TlsVersion.Companion.forJavaName(hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwww()) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwww()), readCertificateList(hx0Var), readCertificateList(hx0Var));
                } else {
                    handshake = null;
                }
                this.handshake = handshake;
            } finally {
                mx0Var.close();
            }
        }

        public Entry(Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
            this.url = response.request().url().toString();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        private final boolean isHttps() {
            return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.url, DefaultWebClient.HTTPS_SCHEME, false, 2);
        }

        private final List<Certificate> readCertificateList(ww0 ww0Var) throws IOException {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(ww0Var);
            if (readInt$okhttp == -1) {
                return EmptyList.INSTANCE;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                for (int i = 0; i < readInt$okhttp; i++) {
                    String Wwwwwwwwwwwwwwwwwwwwwwwww = ww0Var.Wwwwwwwwwwwwwwwwwwwwwwwww();
                    uw0 uw0Var = new uw0();
                    ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    uw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    arrayList.add(certificateFactory.generateCertificate(new uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private final void writeCertList(vw0 vw0Var, List<? extends Certificate> list) throws IOException {
            try {
                vw0Var.mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(list.size()).mo4963writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    byte[] encoded = list.get(i).getEncoded();
                    ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion;
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) encoded, HttpHeaderValues.BYTES);
                    vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, encoded, 0, 0, 3).base64()).mo4963writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.url, (Object) request.url().toString()) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.requestMethod, (Object) request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editor, "editor");
            vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editor.newSink(0));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.url).mo4963writeByte(10);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requestMethod).mo4963writeByte(10);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.varyHeaders.size()).mo4963writeByte(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.varyHeaders.name(i)).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(": ").mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.varyHeaders.value(i)).mo4963writeByte(10);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StatusLine(this.protocol, this.code, this.message).toString()).mo4963writeByte(10);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.responseHeaders.size() + 2).mo4963writeByte(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.responseHeaders.name(i2)).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(": ").mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.responseHeaders.value(i2)).mo4963writeByte(10);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SENT_MILLIS).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(": ").mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.sentRequestMillis).mo4963writeByte(10);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RECEIVED_MILLIS).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(": ").mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.receivedResponseMillis).mo4963writeByte(10);
            if (isHttps()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4963writeByte(10);
                Handshake handshake = this.handshake;
                if (handshake == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handshake.cipherSuite().javaName()).mo4963writeByte(10);
                writeCertList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.handshake.peerCertificates());
                writeCertList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.handshake.localCertificates());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.handshake.tlsVersion().javaName()).mo4963writeByte(10);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class RealCacheRequest implements CacheRequest {
        public final kx0 body;
        public final kx0 cacheOut;
        public boolean done;
        public final DiskLruCache.Editor editor;
        public final /* synthetic */ Cache this$0;

        public RealCacheRequest(Cache cache, DiskLruCache.Editor editor) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            kx0 newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new xw0(newSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // me.tvspark.xw0, me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (RealCacheRequest.this.this$0) {
                        if (RealCacheRequest.this.getDone$okhttp()) {
                            return;
                        }
                        RealCacheRequest.this.setDone$okhttp(true);
                        Cache cache2 = RealCacheRequest.this.this$0;
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        RealCacheRequest.this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (this.this$0) {
                if (this.done) {
                    return;
                }
                this.done = true;
                Cache cache = this.this$0;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public kx0 body() {
            return this.body;
        }

        public final boolean getDone$okhttp() {
            return this.done;
        }

        public final void setDone$okhttp(boolean z) {
            this.done = z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "directory");
    }

    public Cache(File file, long j, FileSystem fileSystem) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "directory");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileSystem, "fileSystem");
        this.cache = DiskLruCache.Companion.create(fileSystem, file, VERSION, 2, j);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m4987deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot != null) {
                try {
                    Entry entry = new Entry(snapshot.getSource(0));
                    Response response = entry.response(snapshot);
                    if (entry.matches(request, response)) {
                        return response;
                    }
                    ResponseBody body = response.body();
                    if (body != null) {
                        Util.closeQuietly(body);
                    }
                    return null;
                } catch (IOException unused) {
                    Util.closeQuietly(snapshot);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editor;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        String method = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if ((!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method, (Object) "GET")) || Companion.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = DiskLruCache.edit$default(this.cache, Companion.key(response.request().url()), 0L, 2, null);
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new RealCacheRequest(this, editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
            }
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i) {
        this.writeAbortCount = i;
    }

    public final void setWriteSuccessCount$okhttp(int i) {
        this.writeSuccessCount = i;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(Response response, Response response2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "cached");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response2, "network");
        Entry entry = new Entry(response2);
        ResponseBody body = response.body();
        if (body != null) {
            DiskLruCache.Editor editor = null;
            try {
                editor = ((CacheResponseBody) body).getSnapshot$okhttp().edit();
                if (editor == null) {
                    return;
                }
                entry.writeTo(editor);
                editor.commit();
                return;
            } catch (IOException unused) {
                abortQuietly(editor);
                return;
            }
        }
        throw new TypeCastException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
    }

    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }
}
