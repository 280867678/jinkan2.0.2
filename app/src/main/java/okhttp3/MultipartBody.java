package okhttp3;

import androidx.core.app.Person;
import androidx.core.net.MailTo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.uw0;
import me.tvspark.vw0;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class MultipartBody extends RequestBody {
    public static final byte[] DASHDASH;
    public final ByteString boundaryByteString;
    public long contentLength = -1;
    public final MediaType contentType;
    public final List<Part> parts;
    public final MediaType type;
    public static final Companion Companion = new Companion(null);
    public static final MediaType MIXED = MediaType.Companion.get("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.Companion.get("multipart/alternative");
    public static final MediaType DIGEST = MediaType.Companion.get("multipart/digest");
    public static final MediaType PARALLEL = MediaType.Companion.get("multipart/parallel");
    public static final MediaType FORM = MediaType.Companion.get("multipart/form-data");
    public static final byte[] COLONSPACE = {(byte) 58, (byte) 32};
    public static final byte[] CRLF = {(byte) 13, (byte) 10};

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final ByteString boundary;
        public final List<Part> parts;
        public MediaType type;

        public Builder() {
            this(null, 1, null);
        }

        public Builder(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "boundary");
            this.boundary = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Builder(String str, int i, gi0 gi0Var) {
            this(str);
            if ((i & 1) != 0) {
                str = UUID.randomUUID().toString();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, "UUID.randomUUID().toString()");
            }
        }

        public final Builder addFormDataPart(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            addPart(Part.Companion.createFormData(str, str2));
            return this;
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
            addPart(Part.Companion.createFormData(str, str2, requestBody));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
            addPart(Part.Companion.create(headers, requestBody));
            return this;
        }

        public final Builder addPart(Part part) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(part, "part");
            this.parts.add(part);
            return this;
        }

        public final Builder addPart(RequestBody requestBody) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
            addPart(Part.Companion.create(requestBody));
            return this;
        }

        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final Builder setType(MediaType mediaType) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaType, "type");
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) mediaType.type(), (Object) "multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + mediaType).toString());
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

        public final void appendQuotedString$okhttp(StringBuilder sb, String str) {
            String str2;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "$this$appendQuotedString");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Person.KEY_KEY);
            sb.append('\"');
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '\n') {
                    str2 = "%0A";
                } else if (charAt == '\r') {
                    str2 = "%0D";
                } else if (charAt == '\"') {
                    str2 = "%22";
                } else {
                    sb.append(charAt);
                }
                sb.append(str2);
            }
            sb.append('\"');
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Part {
        public static final Companion Companion = new Companion(null);
        public final RequestBody body;
        public final Headers headers;

        @ef0
        /* loaded from: classes4.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(gi0 gi0Var) {
                this();
            }

            public final Part create(Headers headers, RequestBody requestBody) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
                boolean z = true;
                if ((headers != null ? headers.get("Content-Type") : null) == null) {
                    if ((headers != null ? headers.get("Content-Length") : null) != null) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
                    }
                    return new Part(headers, requestBody, null);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            }

            public final Part create(RequestBody requestBody) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
                return create(null, requestBody);
            }

            public final Part createFormData(String str, String str2) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
                return createFormData(str, null, RequestBody.Companion.create$default(RequestBody.Companion, str2, (MediaType) null, 1, (Object) null));
            }

            public final Part createFormData(String str, String str2, RequestBody requestBody) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                MultipartBody.Companion.appendQuotedString$okhttp(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.Companion.appendQuotedString$okhttp(sb, str2);
                }
                String sb2 = sb.toString();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb2, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb2).build(), requestBody);
            }
        }

        public Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, gi0 gi0Var) {
            this(headers, requestBody);
        }

        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }

        /* renamed from: -deprecated_body  reason: not valid java name */
        public final RequestBody m5058deprecated_body() {
            return this.body;
        }

        /* renamed from: -deprecated_headers  reason: not valid java name */
        public final Headers m5059deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    static {
        byte b = (byte) 45;
        DASHDASH = new byte[]{b, b};
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "boundaryByteString");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaType, "type");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "parts");
        this.boundaryByteString = byteString;
        this.type = mediaType;
        this.parts = list;
        MediaType.Companion companion = MediaType.Companion;
        this.contentType = companion.get(this.type + "; boundary=" + boundary());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(vw0 vw0Var, boolean z) throws IOException {
        uw0 uw0Var;
        if (z) {
            vw0Var = new uw0();
            uw0Var = vw0Var;
        } else {
            uw0Var = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = this.parts.get(i);
            Headers headers = part.headers();
            RequestBody body = part.body();
            if (vw0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            vw0Var.mo4961write(DASHDASH);
            vw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.boundaryByteString);
            vw0Var.mo4961write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers.name(i2)).mo4961write(COLONSPACE).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers.value(i2)).mo4961write(CRLF);
                }
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Content-Type: ").mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contentType.toString()).mo4961write(CRLF);
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Content-Length: ").mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(contentLength).mo4961write(CRLF);
            } else if (z) {
                if (uw0Var != 0) {
                    uw0Var.skip(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww);
                    return -1L;
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            vw0Var.mo4961write(CRLF);
            if (z) {
                j += contentLength;
            } else {
                body.writeTo(vw0Var);
            }
            vw0Var.mo4961write(CRLF);
        }
        if (vw0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        vw0Var.mo4961write(DASHDASH);
        vw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.boundaryByteString);
        vw0Var.mo4961write(DASHDASH);
        vw0Var.mo4961write(CRLF);
        if (!z) {
            return j;
        }
        if (uw0Var != 0) {
            long j2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            long j3 = j + j2;
            uw0Var.skip(j2);
            return j3;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    /* renamed from: -deprecated_boundary  reason: not valid java name */
    public final String m5054deprecated_boundary() {
        return boundary();
    }

    /* renamed from: -deprecated_parts  reason: not valid java name */
    public final List<Part> m5055deprecated_parts() {
        return this.parts;
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m5056deprecated_size() {
        return size();
    }

    /* renamed from: -deprecated_type  reason: not valid java name */
    public final MediaType m5057deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j == -1) {
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }
        return j;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int i) {
        return this.parts.get(i);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(vw0 vw0Var) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
        writeOrCountBytes(vw0Var, false);
    }
}
