package okhttp3.internal.http2;

import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import okhttp3.internal.Util;
import okio.ByteString;
import org.apache.http.message.TokenParser;

@ef0
/* loaded from: classes4.dex */
public final class Http2 {
    public static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;
    public static final Http2 INSTANCE = new Http2();
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] FLAGS = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) binaryString, "Integer.toBinaryString(it)");
            String format = Util.format("%8s", binaryString);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(format, "$this$replace");
            String replace = format.replace(TokenParser.f4579SP, '0');
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            strArr[i] = replace;
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i2 = 0; i2 < 1; i2++) {
            int i3 = iArr[i2];
            String[] strArr3 = FLAGS;
            strArr3[i3 | 8] = strArr3[i3] + ((Object) "|PADDED");
        }
        String[] strArr4 = FLAGS;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            for (int i6 = 0; i6 < 1; i6++) {
                int i7 = iArr[i6];
                int i8 = i7 | i5;
                FLAGS[i8] = FLAGS[i7] + "|" + FLAGS[i5];
                StringBuilder sb = new StringBuilder();
                sb.append(FLAGS[i7]);
                sb.append("|");
                FLAGS[i8 | 8] = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, FLAGS[i5], "|PADDED");
            }
        }
        int length = FLAGS.length;
        for (int i9 = 0; i9 < length; i9++) {
            String[] strArr5 = FLAGS;
            if (strArr5[i9] == null) {
                strArr5[i9] = BINARY[i9];
            }
        }
    }

    public final String formatFlags(int i, int i2) {
        String str;
        String str2;
        String str3;
        if (i2 == 0) {
            return "";
        }
        if (i != 2 && i != 3) {
            if (i == 4 || i == 6) {
                return i2 == 1 ? "ACK" : BINARY[i2];
            } else if (i != 7 && i != 8) {
                String[] strArr = FLAGS;
                if (i2 < strArr.length) {
                    str = strArr[i2];
                    if (str == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                } else {
                    str = BINARY[i2];
                }
                if (i == 5 && (i2 & 4) != 0) {
                    str2 = "HEADERS";
                    str3 = "PUSH_PROMISE";
                } else if (i != 0 || (i2 & 32) == 0) {
                    return str;
                } else {
                    str2 = "PRIORITY";
                    str3 = "COMPRESSED";
                }
                return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, str3, false, 4);
            }
        }
        return BINARY[i2];
    }

    public final String frameLog(boolean z, int i, int i2, int i3, int i4) {
        String[] strArr = FRAME_NAMES;
        return Util.format("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), i3 < strArr.length ? strArr[i3] : Util.format("0x%02x", Integer.valueOf(i3)), formatFlags(i3, i4));
    }
}
