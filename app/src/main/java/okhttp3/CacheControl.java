package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import okhttp3.internal.Util;
import org.eclipse.jetty.http.HttpHeaderValues;

@ef0
/* loaded from: classes4.dex */
public final class CacheControl {
    public String headerValue;
    public final boolean immutable;
    public final boolean isPrivate;
    public final boolean isPublic;
    public final int maxAgeSeconds;
    public final int maxStaleSeconds;
    public final int minFreshSeconds;
    public final boolean mustRevalidate;
    public final boolean noCache;
    public final boolean noStore;
    public final boolean noTransform;
    public final boolean onlyIfCached;
    public final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public boolean immutable;
        public int maxAgeSeconds = -1;
        public int maxStaleSeconds = -1;
        public int minFreshSeconds = -1;
        public boolean noCache;
        public boolean noStore;
        public boolean noTransform;
        public boolean onlyIfCached;

        private final int clampToInt(long j) {
            if (j > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit");
            if (i >= 0) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("maxAge < 0: ", i).toString());
        }

        public final Builder maxStale(int i, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit");
            if (i >= 0) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("maxStale < 0: ", i).toString());
        }

        public final Builder minFresh(int i, TimeUnit timeUnit) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit");
            if (i >= 0) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("minFresh < 0: ", i).toString());
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
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

        private final int indexOfElement(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str2, str.charAt(i), false, 2)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.indexOfElement(str, str2, i);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00d1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CacheControl parse(Headers headers) {
            int i;
            int i2;
            int i3;
            String str;
            int i4;
            String str2;
            Headers headers2 = headers;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers2, IOptionConstant.headers);
            int size = headers.size();
            boolean z = true;
            int i5 = 0;
            boolean z2 = true;
            String str3 = null;
            boolean z3 = false;
            boolean z4 = false;
            int i6 = -1;
            int i7 = -1;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            int i8 = -1;
            int i9 = -1;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            while (i5 < size) {
                String name = headers2.name(i5);
                String value = headers2.value(i5);
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "Cache-Control", z)) {
                    if (str3 == null) {
                        str3 = value;
                        i2 = 0;
                        while (i2 < value.length()) {
                            int indexOfElement = indexOfElement(value, "=,;", i2);
                            String substring = value.substring(i2, indexOfElement);
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            String obj = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring).toString();
                            if (indexOfElement != value.length()) {
                                i3 = size;
                                if (value.charAt(indexOfElement) != ',' && value.charAt(indexOfElement) != ';') {
                                    int indexOfNonWhitespace = Util.indexOfNonWhitespace(value, indexOfElement + 1);
                                    if (indexOfNonWhitespace >= value.length() || value.charAt(indexOfNonWhitespace) != '\"') {
                                        str = str3;
                                        i4 = indexOfElement(value, ",;", indexOfNonWhitespace);
                                        String substring2 = value.substring(indexOfNonWhitespace, i4);
                                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        str2 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring2).toString();
                                    } else {
                                        int i10 = indexOfNonWhitespace + 1;
                                        str = str3;
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) value, '\"', i10, false, 4);
                                        str2 = value.substring(i10, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                                    }
                                    z = true;
                                    if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HttpHeaderValues.NO_CACHE, obj, true)) {
                                        z3 = true;
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no-store", obj, true)) {
                                        z4 = true;
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("max-age", obj, true)) {
                                        i6 = Util.toNonNegativeInt(str2, -1);
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("s-maxage", obj, true)) {
                                        i7 = Util.toNonNegativeInt(str2, -1);
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("private", obj, true)) {
                                        z5 = true;
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("public", obj, true)) {
                                        z6 = true;
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("must-revalidate", obj, true)) {
                                        z7 = true;
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("max-stale", obj, true)) {
                                        i8 = Util.toNonNegativeInt(str2, Integer.MAX_VALUE);
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("min-fresh", obj, true)) {
                                        i9 = Util.toNonNegativeInt(str2, -1);
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("only-if-cached", obj, true)) {
                                        z8 = true;
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no-transform", obj, true)) {
                                        z9 = true;
                                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("immutable", obj, true)) {
                                        z10 = true;
                                    }
                                    i2 = i4;
                                    size = i3;
                                    str3 = str;
                                }
                            } else {
                                i3 = size;
                            }
                            str = str3;
                            i4 = indexOfElement + 1;
                            str2 = null;
                            z = true;
                            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HttpHeaderValues.NO_CACHE, obj, true)) {
                            }
                            i2 = i4;
                            size = i3;
                            str3 = str;
                        }
                        i = size;
                        i5++;
                        headers2 = headers;
                        size = i;
                    }
                } else if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "Pragma", z)) {
                    i = size;
                    i5++;
                    headers2 = headers;
                    size = i;
                }
                z2 = false;
                i2 = 0;
                while (i2 < value.length()) {
                }
                i = size;
                i5++;
                headers2 = headers;
                size = i;
            }
            return new CacheControl(z3, z4, i6, i7, z5, z6, z7, i8, i9, z8, z9, z10, !z2 ? null : str3, null);
        }
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    public /* synthetic */ CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, gi0 gi0Var) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    /* renamed from: -deprecated_immutable  reason: not valid java name */
    public final boolean m4988deprecated_immutable() {
        return this.immutable;
    }

    /* renamed from: -deprecated_maxAgeSeconds  reason: not valid java name */
    public final int m4989deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* renamed from: -deprecated_maxStaleSeconds  reason: not valid java name */
    public final int m4990deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* renamed from: -deprecated_minFreshSeconds  reason: not valid java name */
    public final int m4991deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* renamed from: -deprecated_mustRevalidate  reason: not valid java name */
    public final boolean m4992deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    /* renamed from: -deprecated_noCache  reason: not valid java name */
    public final boolean m4993deprecated_noCache() {
        return this.noCache;
    }

    /* renamed from: -deprecated_noStore  reason: not valid java name */
    public final boolean m4994deprecated_noStore() {
        return this.noStore;
    }

    /* renamed from: -deprecated_noTransform  reason: not valid java name */
    public final boolean m4995deprecated_noTransform() {
        return this.noTransform;
    }

    /* renamed from: -deprecated_onlyIfCached  reason: not valid java name */
    public final boolean m4996deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    /* renamed from: -deprecated_sMaxAgeSeconds  reason: not valid java name */
    public final int m4997deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.noCache) {
                sb.append("no-cache, ");
            }
            if (this.noStore) {
                sb.append("no-store, ");
            }
            if (this.maxAgeSeconds != -1) {
                sb.append("max-age=");
                sb.append(this.maxAgeSeconds);
                sb.append(", ");
            }
            if (this.sMaxAgeSeconds != -1) {
                sb.append("s-maxage=");
                sb.append(this.sMaxAgeSeconds);
                sb.append(", ");
            }
            if (this.isPrivate) {
                sb.append("private, ");
            }
            if (this.isPublic) {
                sb.append("public, ");
            }
            if (this.mustRevalidate) {
                sb.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != -1) {
                sb.append("max-stale=");
                sb.append(this.maxStaleSeconds);
                sb.append(", ");
            }
            if (this.minFreshSeconds != -1) {
                sb.append("min-fresh=");
                sb.append(this.minFreshSeconds);
                sb.append(", ");
            }
            if (this.onlyIfCached) {
                sb.append("only-if-cached, ");
            }
            if (this.noTransform) {
                sb.append("no-transform, ");
            }
            if (this.immutable) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            String sb2 = sb.toString();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb2, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = sb2;
            return sb2;
        }
        return str;
    }
}
