package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;

@ef0
/* loaded from: classes4.dex */
public final class Challenge {
    public final Map<String, String> authParams;
    public final String scheme;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Challenge(String str, String str2) {
        this(str, r3);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "scheme");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "realm");
        Map singletonMap = Collections.singletonMap("realm", str2);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) singletonMap, "singletonMap(\"realm\", realm)");
    }

    public Challenge(String str, Map<String, String> map) {
        String str2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "scheme");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, "authParams");
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "US");
                str2 = key.toLowerCase(locale);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str2, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            linkedHashMap.put(str2, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }

    /* renamed from: -deprecated_authParams  reason: not valid java name */
    public final Map<String, String> m4998deprecated_authParams() {
        return this.authParams;
    }

    /* renamed from: -deprecated_charset  reason: not valid java name */
    public final Charset m4999deprecated_charset() {
        return charset();
    }

    /* renamed from: -deprecated_realm  reason: not valid java name */
    public final String m5000deprecated_realm() {
        return realm();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m5001deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) charset, "ISO_8859_1");
        return charset;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) challenge.scheme, (Object) this.scheme) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.authParams.hashCode() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.scheme, 899, 31);
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
        Map<String, String> map = this.authParams;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, "$this$toMutableMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        String name = charset.name();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, "charset.name()");
        linkedHashMap.put("charset", name);
        return new Challenge(this.scheme, linkedHashMap);
    }
}
