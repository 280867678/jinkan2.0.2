package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import me.tvspark.outline;
import org.eclipse.jetty.util.B64Code;

/* loaded from: classes3.dex */
public final class MailTo {
    public static final String BCC = "bcc";
    public static final String BODY = "body";

    /* renamed from: CC */
    public static final String f52CC = "cc";
    public static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    public static final String SUBJECT = "subject";

    /* renamed from: TO */
    public static final String f53TO = "to";
    public HashMap<String, String> mHeaders = new HashMap<>();

    public static boolean isMailTo(@Nullable Uri uri) {
        return uri != null && MAILTO.equals(uri.getScheme());
    }

    public static boolean isMailTo(@Nullable String str) {
        return str != null && str.startsWith("mailto:");
    }

    @NonNull
    public static MailTo parse(@NonNull Uri uri) throws ParseException {
        return parse(uri.toString());
    }

    @NonNull
    public static MailTo parse(@NonNull String str) throws ParseException {
        String decode;
        String substring;
        Preconditions.checkNotNull(str);
        if (isMailTo(str)) {
            int indexOf = str.indexOf(35);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf(63);
            if (indexOf2 == -1) {
                decode = Uri.decode(str.substring(7));
                substring = null;
            } else {
                decode = Uri.decode(str.substring(7, indexOf2));
                substring = str.substring(indexOf2 + 1);
            }
            MailTo mailTo = new MailTo();
            if (substring != null) {
                for (String str2 : substring.split("&")) {
                    String[] split = str2.split("=", 2);
                    if (split.length != 0) {
                        mailTo.mHeaders.put(Uri.decode(split[0]).toLowerCase(Locale.ROOT), split.length > 1 ? Uri.decode(split[1]) : null);
                    }
                }
            }
            String to = mailTo.getTo();
            if (to != null) {
                decode = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(decode, ", ", to);
            }
            mailTo.mHeaders.put(f53TO, decode);
            return mailTo;
        }
        throw new ParseException("Not a mailto scheme");
    }

    @Nullable
    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    @Nullable
    public String getBody() {
        return this.mHeaders.get(BODY);
    }

    @Nullable
    public String getCc() {
        return this.mHeaders.get(f52CC);
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Nullable
    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    @Nullable
    public String getTo() {
        return this.mHeaders.get(f53TO);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("mailto:");
        sb.append('?');
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append(B64Code.__pad);
            sb.append(Uri.encode(entry.getValue()));
            sb.append('&');
        }
        return sb.toString();
    }
}
