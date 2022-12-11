package me.tvspark;

import androidx.annotation.Nullable;
import com.just.agentweb.WebIndicator;
import com.p046uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.C2245j3;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.o7 */
/* loaded from: classes4.dex */
public final class C2434o7 {
    @Nullable
    public final C2254jc Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.o7$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long[] jArr, long[] jArr2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr2;
        }
    }

    public C2434o7(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, @Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @Nullable C2254jc c2254jc) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7);
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2254jc;
    }

    public C2434o7(byte[] bArr, int i) {
        C2041dl c2041dl = new C2041dl(bArr);
        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i * 8);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3) + 1;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5) + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4)) << 32) | C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(32));
        this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        switch (i) {
            case WebIndicator.MAX_UNIFORM_SPEED_DURATION /* 8000 */:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case LogType.UNEXP_KNOWN_REASON /* 32000 */:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 8) {
            if (i == 12) {
                return 2;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 20) {
                return 5;
            }
            return i != 24 ? -1 : 6;
        }
        return 1;
    }

    @Nullable
    public static C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, List<C2745wc> list2) {
        if (!list.isEmpty() || !list2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "=");
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length != 2) {
                    String valueOf = String.valueOf(str);
                    if (valueOf.length() != 0) {
                        "Failed to parse Vorbis comment: ".concat(valueOf);
                    } else {
                        new String("Failed to parse Vorbis comment: ");
                    }
                } else {
                    arrayList.add(new C2782xc(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0], Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1]));
                }
            }
            arrayList.addAll(list2);
            if (!arrayList.isEmpty()) {
                return new C2254jc(arrayList);
            }
            return null;
        }
        return null;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * StopWatch.NANO_2_MILLIS) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((j * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / StopWatch.NANO_2_MILLIS, 0L, this.Wwwwwwwwwwwwwwwwwwwwwwwww - 1);
    }

    public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, @Nullable C2254jc c2254jc) {
        bArr[4] = Byte.MIN_VALUE;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i <= 0) {
            i = -1;
        }
        C2254jc c2254jc2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (c2254jc2 != null) {
            c2254jc = c2254jc2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2254jc);
        }
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/flac";
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = i;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = Collections.singletonList(bArr);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2254jc;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Nullable
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2254jc c2254jc) {
        C2254jc c2254jc2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        return c2254jc2 == null ? c2254jc : c2254jc2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2254jc);
    }

    public C2434o7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return new C2434o7(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}
