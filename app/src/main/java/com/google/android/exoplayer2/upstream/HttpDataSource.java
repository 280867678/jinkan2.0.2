package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.AbstractC2410nk;
import me.tvspark.AbstractC2863zj;
import me.tvspark.C1949bk;
import me.tvspark.C2151gk;
import me.tvspark.C2188hk;
import me.tvspark.C2374ml;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public interface HttpDataSource extends AbstractC2863zj {

    /* loaded from: classes3.dex */
    public static class HttpDataSourceException extends IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final C1949bk dataSpec;
        public final int type;

        public HttpDataSourceException(IOException iOException, C1949bk c1949bk, int i) {
            super(iOException);
            this.dataSpec = c1949bk;
            this.type = i;
        }

        public HttpDataSourceException(String str, IOException iOException, C1949bk c1949bk, int i) {
            super(str, iOException);
            this.dataSpec = c1949bk;
            this.type = i;
        }

        public HttpDataSourceException(String str, C1949bk c1949bk, int i) {
            super(str);
            this.dataSpec = c1949bk;
            this.type = i;
        }

        public HttpDataSourceException(C1949bk c1949bk, int i) {
            this.dataSpec = c1949bk;
            this.type = i;
        }
    }

    /* loaded from: classes3.dex */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InvalidContentTypeException(String str, C1949bk c1949bk) {
            super(r0.length() != 0 ? "Invalid content type: ".concat(r0) : new String("Invalid content type: "), c1949bk, 1);
            String valueOf = String.valueOf(str);
            this.contentType = str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        @Nullable
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i, @Nullable String str, Map<String, List<String>> map, C1949bk c1949bk) {
            this(i, str, map, c1949bk, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public InvalidResponseCodeException(int i, @Nullable String str, Map<String, List<String>> map, C1949bk c1949bk, byte[] bArr) {
            super(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(26, "Response code: ", i), c1949bk, 1);
            this.responseCode = i;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }

        @Deprecated
        public InvalidResponseCodeException(int i, Map<String, List<String>> map, C1949bk c1949bk) {
            this(i, null, map, c1949bk, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

        public synchronized Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableMap(new HashMap(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        @Override // me.tvspark.AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public final HttpDataSource mo4450Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            C2188hk c2188hk = (C2188hk) this;
            C2151gk c2151gk = new C2151gk(c2188hk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2188hk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2188hk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2188hk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AbstractC2410nk abstractC2410nk = c2188hk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2410nk != null) {
                c2151gk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            }
            return c2151gk;
        }
    }
}
