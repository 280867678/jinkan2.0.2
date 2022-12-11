package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.uw0;
import me.tvspark.vw0;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

@ef0
/* loaded from: classes4.dex */
public final class FormBody extends RequestBody {
    public final List<String> encodedNames;
    public final List<String> encodedValues;
    public static final Companion Companion = new Companion(null);
    public static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final Charset charset;
        public final List<String> names;
        public final List<String> values;

        public Builder() {
            this(null, 1, null);
        }

        public Builder(Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i, gi0 gi0Var) {
            this((i & 1) != 0 ? null : charset);
        }

        public final Builder add(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            this.names.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            return this;
        }

        public final Builder addEncoded(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            this.names.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
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
    }

    public FormBody(List<String> list, List<String> list2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "encodedNames");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2, "encodedValues");
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    private final long writeOrCountBytes(vw0 vw0Var, boolean z) {
        uw0 buffer;
        if (z) {
            buffer = new uw0();
        } else if (vw0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } else {
            buffer = vw0Var.getBuffer();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.mo4963writeByte(38);
            }
            buffer.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.encodedNames.get(i));
            buffer.mo4963writeByte(61);
            buffer.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.encodedValues.get(i));
        }
        if (z) {
            long j = buffer.Wwwwwwwwwwwwwwwwwwwwwww;
            buffer.skip(j);
            return j;
        }
        return 0L;
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m5016deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    public final String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    public final String name(int i) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i), 0, 0, true, 3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int i) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(vw0 vw0Var) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
        writeOrCountBytes(vw0Var, false);
    }
}
