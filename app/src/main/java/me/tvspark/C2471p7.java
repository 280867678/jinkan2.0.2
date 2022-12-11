package me.tvspark;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.p7 */
/* loaded from: classes4.dex */
public final class C2471p7 {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                int parseInt = Integer.parseInt(group, 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt <= 0 && parseInt2 <= 0) {
                    return false;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parseInt;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parseInt2;
                return true;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2254jc c2254jc) {
        int i = 0;
        while (true) {
            C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i];
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2144gd) {
                    C2144gd c2144gd = (C2144gd) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if ("iTunSMPB".equals(c2144gd.Wwwwwwwwwwwwwwwwwwwwww) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2144gd.Wwwwwwwwwwwwwwwwwwwww)) {
                        return true;
                    }
                } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2292kd) {
                    C2292kd c2292kd = (C2292kd) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if ("com.apple.iTunes".equals(c2292kd.Wwwwwwwwwwwwwwwwwwwwwww) && "iTunSMPB".equals(c2292kd.Wwwwwwwwwwwwwwwwwwwwww) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2292kd.Wwwwwwwwwwwwwwwwwwwww)) {
                        return true;
                    }
                } else {
                    continue;
                }
                i++;
            } else {
                return false;
            }
        }
    }
}
