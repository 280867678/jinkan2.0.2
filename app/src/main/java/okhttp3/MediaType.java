package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;

@ef0
/* loaded from: classes4.dex */
public final class MediaType {
    public static final String QUOTED = "\"([^\"]*)\"";
    public static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    public final String charset;
    public final String mediaType;
    public final String subtype;
    public final String type;
    public static final Companion Companion = new Companion(null);
    public static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final MediaType m5052deprecated_get(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "mediaType");
            return get(str);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final MediaType m5053deprecated_parse(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "mediaType");
            return parse(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final MediaType get(String str) {
            String str2;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toMediaType");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String group = matcher.group(1);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) group, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "Locale.US");
            String lowerCase = group.toLowerCase(locale);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String group2 = matcher.group(2);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) group2, "typeSubtype.group(2)");
            Locale locale2 = Locale.US;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale2, "Locale.US");
            String lowerCase2 = group2.toLowerCase(locale2);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            Matcher matcher2 = MediaType.PARAMETER.matcher(str);
            int end = matcher.end();
            String str3 = null;
            while (end < str.length()) {
                matcher2.region(end, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Parameter is not formatted correctly: \"");
                    String substring = str.substring(end);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(substring);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\" for: \"");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('\"');
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
                }
                String group3 = matcher2.group(1);
                if (group3 == null || !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group3, "charset", true)) {
                    end = matcher2.end();
                } else {
                    String group4 = matcher2.group(2);
                    boolean z = false;
                    if (group4 == null) {
                        group4 = matcher2.group(3);
                        str2 = "parameter.group(3)";
                    } else {
                        if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group4, "'", false, 2) && nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group4, "'", false, 2) && group4.length() > 2) {
                            group4 = group4.substring(1, group4.length() - 1);
                            str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                        }
                        if (str3 != null || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group4, str3, true)) {
                            z = true;
                        }
                        if (z) {
                            throw new IllegalArgumentException(("Multiple charsets defined: \"" + str3 + "\" and: \"" + group4 + "\" for: \"" + str + '\"').toString());
                        }
                        str3 = group4;
                        end = matcher2.end();
                    }
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) group4, str2);
                    if (str3 != null) {
                    }
                    z = true;
                    if (z) {
                    }
                }
            }
            return new MediaType(str, lowerCase, lowerCase2, str3, null);
        }

        public final MediaType parse(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toMediaTypeOrNull");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public MediaType(String str, String str2, String str3, String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String str4, gi0 gi0Var) {
        this(str, str2, str3, str4);
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_subtype  reason: not valid java name */
    public final String m5050deprecated_subtype() {
        return this.subtype;
    }

    /* renamed from: -deprecated_type  reason: not valid java name */
    public final String m5051deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public final Charset charset(Charset charset) {
        try {
            return this.charset != null ? Charset.forName(this.charset) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) ((MediaType) obj).mediaType, (Object) this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }
}
