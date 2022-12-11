package okhttp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import me.tvspark.cx0;
import me.tvspark.ef0;
import me.tvspark.ek0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nx0;
import me.tvspark.vw0;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return companion.create(mediaType, bArr, i, i2);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.create(bArr, mediaType, i, i2);
        }

        public final RequestBody create(final File file, final MediaType mediaType) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "$this$asRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(vw0 vw0Var) {
                    cx0 cx0Var;
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
                    File file2 = file;
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2, "$receiver");
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileInputStream, "$receiver");
                    try {
                        vw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new cx0(fileInputStream, new nx0()));
                        th = null;
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(String str, MediaType mediaType) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toRequestBody");
            Charset charset = ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (mediaType != null && (charset = MediaType.charset$default(mediaType, null, 1, null)) == null) {
                charset = ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                MediaType.Companion companion = MediaType.Companion;
                mediaType = companion.parse(mediaType + "; charset=utf-8");
            }
            byte[] bytes = str.getBytes(charset);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            return create(file, mediaType);
        }

        public final RequestBody create(MediaType mediaType, String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "content");
            return create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, ByteString byteString) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "content");
            return create(byteString, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i) {
            return create$default(this, mediaType, bArr, i, 0, 8, (Object) null);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "content");
            return create(bArr, mediaType, i, i2);
        }

        public final RequestBody create(final ByteString byteString, final MediaType mediaType) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "$this$toRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return ByteString.this.size();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(vw0 vw0Var) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
                    vw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString.this);
                }
            };
        }

        public final RequestBody create(byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i) {
            return create$default(this, bArr, mediaType, i, 0, 4, (Object) null);
        }

        public final RequestBody create(final byte[] bArr, final MediaType mediaType, final int i, final int i2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "$this$toRequestBody");
            Util.checkOffsetAndCount(bArr.length, i, i2);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i2;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(vw0 vw0Var) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
                    vw0Var.mo4962write(bArr, i, i2);
                }
            };
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create$default(Companion, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i) {
        return Companion.create$default(Companion, mediaType, bArr, i, 0, 8, (Object) null);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        return Companion.create(mediaType, bArr, i, i2);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create$default(Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create$default(Companion, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i) {
        return Companion.create$default(Companion, bArr, mediaType, i, 0, 4, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i, int i2) {
        return Companion.create(bArr, mediaType, i, i2);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(vw0 vw0Var) throws IOException;
}
