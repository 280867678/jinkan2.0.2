package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.AbstractC2625t7;
import me.tvspark.C2245j3;
import org.apache.commons.lang3.time.StopWatch;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: me.tvspark.lg */
/* loaded from: classes4.dex */
public final class C2332lg implements AbstractC2175h7 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2337ll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("MPEGTS:(-?\\d+)");
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[1024];

    public C2332lg(@Nullable String str, C2337ll c2337ll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2337ll;
    }

    @RequiresNonNull({"output"})
    public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 3);
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "text/vtt";
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = j;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 6, false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6);
        if (C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return true;
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6, 3, false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 9);
        return C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
        abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L, 0L));
    }

    @Override // me.tvspark.AbstractC2175h7
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        Matcher matcher;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int length = (int) abstractC2212i7.getLength();
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == bArr.length) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int read = abstractC2212i7.read(bArr2, i2, bArr2.length - i2);
        if (read != -1) {
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + read;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            if (length == -1 || i3 != length) {
                return 0;
            }
        }
        C2078el c2078el = new C2078el(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
        long j = 0;
        long j2 = 0;
        for (String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); !TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2); Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                if (!matcher2.find()) {
                    throw new ParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : new String("X-TIMESTAMP-MAP doesn't contain local timestamp: "));
                }
                Matcher matcher3 = Wwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                if (!matcher3.find()) {
                    throw new ParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : new String("X-TIMESTAMP-MAP doesn't contain media timestamp: "));
                }
                String group = matcher2.group(1);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                j2 = C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
                String group2 = matcher3.group(1);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
                j = (Long.parseLong(group2) * StopWatch.NANO_2_MILLIS) / 90000;
            }
        }
        while (true) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                if (!C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3).matches()) {
                    matcher = C2482pi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    if (matcher.matches()) {
                        break;
                    }
                } else {
                    do {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        }
                    } while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty());
                }
            } else {
                matcher = null;
                break;
            }
        }
        if (matcher == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L);
        } else {
            String group3 = matcher.group(1);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group3);
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2562ri.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group3);
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((((j + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - j2) * 90000) / StopWatch.NANO_2_MILLIS) % 8589934592L);
            AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, null);
        }
        return -1;
    }
}
