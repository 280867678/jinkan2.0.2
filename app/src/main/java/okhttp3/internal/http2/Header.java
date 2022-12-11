package okhttp3.internal.http2;

import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class Header {
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    public static final Companion Companion = new Companion(null);
    public static final ByteString PSEUDO_PREFIX = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(":");
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString RESPONSE_STATUS = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RESPONSE_STATUS_UTF8);
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_METHOD = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TARGET_METHOD_UTF8);
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_PATH = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TARGET_PATH_UTF8);
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public static final ByteString TARGET_SCHEME = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TARGET_SCHEME_UTF8);
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_AUTHORITY = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TARGET_AUTHORITY_UTF8);

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String str, String str2) {
        this(ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str), ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "value");
    }

    public Header(ByteString byteString, ByteString byteString2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString2, "value");
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = this.value.size() + byteString.size() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i, Object obj) {
        if ((i & 1) != 0) {
            byteString = header.name;
        }
        if ((i & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    public final ByteString component1() {
        return this.name;
    }

    public final ByteString component2() {
        return this.value;
    }

    public final Header copy(ByteString byteString, ByteString byteString2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString2, "value");
        return new Header(byteString, byteString2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Header)) {
                return false;
            }
            Header header = (Header) obj;
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.name, header.name) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value, header.value);
        }
        return true;
    }

    public int hashCode() {
        ByteString byteString = this.name;
        int i = 0;
        int hashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.value;
        if (byteString2 != null) {
            i = byteString2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }
}
