package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import me.tvspark.ef0;
import me.tvspark.ek0;
import me.tvspark.gi0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.uw0;
import me.tvspark.ww0;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.ByteString;
import org.mozilla.javascript.tools.idswitch.Main;

@ef0
/* loaded from: classes4.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    public Reader reader;

    @ef0
    /* loaded from: classes4.dex */
    public static final class BomAwareReader extends Reader {
        public final Charset charset;
        public boolean closed;
        public Reader delegate;
        public final ww0 source;

        public BomAwareReader(ww0 ww0Var, Charset charset) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
            this.source = ww0Var;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, "cbuf");
            if (!this.closed) {
                Reader reader = this.delegate;
                if (reader == null) {
                    reader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                    this.delegate = reader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
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

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ww0 ww0Var, MediaType mediaType, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            if ((i & 2) != 0) {
                j = -1;
            }
            return companion.create(ww0Var, mediaType, j);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toResponseBody");
            Charset charset = ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (mediaType != null && (charset = MediaType.charset$default(mediaType, null, 1, null)) == null) {
                charset = ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                MediaType.Companion companion = MediaType.Companion;
                mediaType = companion.parse(mediaType + "; charset=utf-8");
            }
            uw0 uw0Var = new uw0();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Main.STRING_TAG_STR);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
            uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 0, str.length(), charset);
            return create(uw0Var, mediaType, uw0Var.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        public final ResponseBody create(final ww0 ww0Var, final MediaType mediaType, final long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "$this$asResponseBody");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public ww0 source() {
                    return ww0.this;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, long j, ww0 ww0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "content");
            return create(ww0Var, mediaType, j);
        }

        public final ResponseBody create(MediaType mediaType, String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "content");
            return create(str, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, ByteString byteString) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "content");
            return create(byteString, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] bArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "content");
            return create(bArr, mediaType);
        }

        public final ResponseBody create(ByteString byteString, MediaType mediaType) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$this$toResponseBody");
            uw0 uw0Var = new uw0();
            uw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString);
            return create(uw0Var, mediaType, byteString.size());
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "$this$toResponseBody");
            uw0 uw0Var = new uw0();
            uw0Var.mo4961write(bArr);
            return create(uw0Var, mediaType, bArr.length);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType contentType = contentType();
        return (contentType == null || (charset = contentType.charset(ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) == null) ? ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : charset;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(ih0<? super ww0, ? extends T> ih0Var, ih0<? super T, Integer> ih0Var2) {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            ww0 source = source();
            try {
                T mo4916invoke = ih0Var.mo4916invoke(source);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(source, (Throwable) null);
                int intValue = ih0Var2.mo4916invoke(mo4916invoke).intValue();
                if (contentLength == -1 || contentLength == intValue) {
                    return mo4916invoke;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
            } finally {
            }
        } else {
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot buffer entire body for content length: ", contentLength));
        }
    }

    public static final ResponseBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final ResponseBody create(ww0 ww0Var, MediaType mediaType, long j) {
        return Companion.create(ww0Var, mediaType, j);
    }

    public static final ResponseBody create(MediaType mediaType, long j, ww0 ww0Var) {
        return Companion.create(mediaType, j, ww0Var);
    }

    public static final ResponseBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final ResponseBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final ResponseBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final ByteString byteString() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            ww0 source = source();
            try {
                ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwww = source.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(source, (Throwable) null);
                int size = Wwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                if (contentLength == -1 || contentLength == size) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
            } finally {
            }
        } else {
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot buffer entire body for content length: ", contentLength));
        }
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            ww0 source = source();
            try {
                byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(source, (Throwable) null);
                int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
                if (contentLength == -1 || contentLength == length) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
            } finally {
            }
        } else {
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot buffer entire body for content length: ", contentLength));
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract ww0 source();

    public final String string() throws IOException {
        ww0 source = source();
        try {
            th = null;
            return source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Util.readBomAsCharset(source, charset()));
        } finally {
        }
    }
}
