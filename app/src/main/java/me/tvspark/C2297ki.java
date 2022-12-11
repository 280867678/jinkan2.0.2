package me.tvspark;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* renamed from: me.tvspark.ki */
/* loaded from: classes4.dex */
public final class C2297ki {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
    public final StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new StringBuilder();

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, StringBuilder sb) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) {
            return null;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, sb);
        if (!"".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        StringBuilder sb2 = new StringBuilder(1);
        sb2.append((char) c2078el.Wwwwwwwwwwwwwwwwwwwwww());
        return sb2.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (i < i2 && !z) {
            char c = (char) c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z = true;
            } else {
                i++;
                sb.append(c);
            }
        }
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0068 A[LOOP:1: B:3:0x0002->B:41:0x0068, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        boolean z;
        boolean z2;
        while (true) {
            for (boolean z3 = true; c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0 && z3; z3 = false) {
                char c = (char) c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i + 2 <= i2) {
                        int i3 = i + 1;
                        if (bArr[i] == 47) {
                            int i4 = i3 + 1;
                            if (bArr[i3] == 42) {
                                while (true) {
                                    int i5 = i4 + 1;
                                    if (i5 >= i2) {
                                        break;
                                    } else if (((char) bArr[i4]) == '*' && ((char) bArr[i5]) == '/') {
                                        i2 = i5 + 1;
                                        i4 = i2;
                                    } else {
                                        i4 = i5;
                                    }
                                }
                                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 - c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                z2 = true;
                                if (!z2) {
                                    break;
                                }
                            }
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
            return;
        }
    }
}
