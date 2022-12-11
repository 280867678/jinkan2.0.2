package me.tvspark;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.ParserException;
import com.google.common.collect.ImmutableList;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.tvspark.AbstractC2140g9;
import me.tvspark.C2245j3;
import me.tvspark.C2254jc;
import me.tvspark.C2737w4;
import org.apache.commons.lang3.time.StopWatch;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* renamed from: me.tvspark.h9 */
/* loaded from: classes4.dex */
public final class C2177h9 {
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OpusHead");

    /* renamed from: me.tvspark.h9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            C2078el c2078el = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el;
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww() & 255;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 8) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            }
            if (i == 16) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww();
            }
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
            if (i2 % 2 != 0) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 15;
            }
            int Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww;
            return (Wwwwwwwwwwwwwwwwwwwwww & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >> 4;
        }

        @Override // me.tvspark.C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return -1;
        }
    }

    /* renamed from: me.tvspark.h9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            C2078el c2078el = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el;
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
            int Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwww == 0 ? -1 : Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return i == -1 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww() : i;
        }

        @Override // me.tvspark.C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.C2177h9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* renamed from: me.tvspark.h9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: me.tvspark.h9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, C2078el c2078el2, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el2.Wwwwwwwwwwwwwwwwwww();
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 1 ? false : true, "first_chunk must be 1");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            if (i == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww() : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i2 > 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww() - 1 : -1;
            }
            return true;
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        int i = Wwwwwwwwwwwwwwwwwwwwww & 127;
        while ((Wwwwwwwwwwwwwwwwwwwwww & 128) == 128) {
            Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            i = (i << 7) | (Wwwwwwwwwwwwwwwwwwwwww & 127);
        }
        return i;
    }

    public static Pair<String, byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i + 8 + 4);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        if ((Wwwwwwwwwwwwwwwwwwwwww & 128) != 0) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
        if ((Wwwwwwwwwwwwwwwwwwwwww & 64) != 0) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwww());
        }
        if ((Wwwwwwwwwwwwwwwwwwwwww & 32) != 0) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwww());
        if (DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) || "audio/vnd.dts".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) || "audio/vnd.dts.hd".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
            return Pair.create(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, null);
        }
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
        byte[] bArr = new byte[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        return Pair.create(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, bArr);
    }

    @Nullable
    public static C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        C2288k9 c2288k9;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1751411826);
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1801812339);
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1768715124);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == null) {
            return null;
        }
        C2078el c2078el = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 1835299937) {
            return null;
        }
        C2078el c2078el2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        String[] strArr = new String[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5];
        for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5; i++) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            strArr[i] = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 - 8);
        }
        C2078el c2078el3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
        ArrayList arrayList = new ArrayList();
        while (c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 8) {
            int i2 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 >= 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
                String str = strArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8];
                int i3 = i2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
                while (true) {
                    int i4 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i4 >= i3) {
                        c2288k9 = null;
                        break;
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1684108385) {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 - 16;
                        byte[] bArr = new byte[i5];
                        System.arraycopy(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i5);
                        c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i5;
                        c2288k9 = new C2288k9(str, bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10);
                        break;
                    }
                    c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                }
                if (c2288k9 != null) {
                    arrayList.add(c2288k9);
                }
            }
            c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
        }
        if (!arrayList.isEmpty()) {
            return new C2254jc(arrayList);
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, C2516q9> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2) {
        Integer num;
        C2516q9 c2516q9;
        Pair<Integer, C2516q9> create;
        int i3;
        int i4;
        byte[] bArr;
        int i5 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (i5 - i < i2) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > 0, "childAtomSize should be positive");
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1936289382) {
                int i6 = i5 + 8;
                int i7 = -1;
                int i8 = 0;
                String str = null;
                Integer num2 = null;
                while (i6 - i5 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1718775137) {
                        num2 = Integer.valueOf(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1935894637) {
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                        str = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1935894633) {
                        i7 = i6;
                        i8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    }
                    i6 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(num2, "frma atom is mandatory");
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7 != -1, "schi atom is mandatory");
                    int i9 = i7 + 8;
                    while (true) {
                        if (i9 - i7 >= i8) {
                            num = num2;
                            c2516q9 = null;
                            break;
                        }
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1952804451) {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >> 24) & 255;
                            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == 0) {
                                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                                i3 = Wwwwwwwwwwwwwwwwwwwwww & 15;
                                i4 = (Wwwwwwwwwwwwwwwwwwwwww & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >> 4;
                            }
                            boolean z = c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 1;
                            int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                            byte[] bArr2 = new byte[16];
                            System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr2, 0, 16);
                            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 16;
                            if (!z || Wwwwwwwwwwwwwwwwwwwwww2 != 0) {
                                bArr = null;
                            } else {
                                int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                                byte[] bArr3 = new byte[Wwwwwwwwwwwwwwwwwwwwww3];
                                System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr3, 0, Wwwwwwwwwwwwwwwwwwwwww3);
                                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwww3;
                                bArr = bArr3;
                            }
                            num = num2;
                            c2516q9 = new C2516q9(z, str, Wwwwwwwwwwwwwwwwwwwwww2, bArr2, i4, i3, bArr);
                        } else {
                            i9 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                        }
                    }
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2516q9, "tenc atom is mandatory");
                    create = Pair.create(num, c2516q9);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            i5 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2590s9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2473p9 c2473p9, AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2471p7 c2471p7) throws ParserException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z;
        int i;
        int i2;
        int i3;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i4;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        long j;
        int i7;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i8;
        int i9;
        long[] jArr3;
        int i10;
        int[] iArr3;
        long[] jArr4;
        int[] iArr4;
        int[] iArr5;
        boolean z4;
        int i11;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937011578);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        } else {
            AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937013298);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
            return new C2590s9(c2473p9, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937007471);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1668232756);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            z = true;
        } else {
            z = false;
        }
        C2078el c2078el = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937011555);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
        C2078el c2078el2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937011827);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
        C2078el c2078el3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937011571);
        C2078el c2078el4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1668576371);
        C2078el c2078el5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2, c2078el, z);
        c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
        int Wwwwwwwwwwwwwwwwwww = c2078el3.Wwwwwwwwwwwwwwwwwww() - 1;
        int Wwwwwwwwwwwwwwwwwww2 = c2078el3.Wwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwww3 = c2078el3.Wwwwwwwwwwwwwwwwwww();
        if (c2078el5 != null) {
            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
            i = c2078el5.Wwwwwwwwwwwwwwwwwww();
        } else {
            i = 0;
        }
        if (c2078el4 != null) {
            c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
            i2 = c2078el4.Wwwwwwwwwwwwwwwwwww();
            if (i2 > 0) {
                i3 = c2078el4.Wwwwwwwwwwwwwwwwwww() - 1;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                String str = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1 && (("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && Wwwwwwwwwwwwwwwwwww == 0 && i == 0 && i2 == 0)) {
                    i4 = Wwwwwwwwwwwwwwwwwww;
                    i5 = Wwwwwwwwwwwwwwwwwww2;
                    z2 = true;
                } else {
                    i4 = Wwwwwwwwwwwwwwwwwww;
                    i5 = Wwwwwwwwwwwwwwwwwww2;
                    z2 = false;
                }
                if (!z2) {
                    int i12 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long[] jArr5 = new long[i12];
                    int[] iArr6 = new int[i12];
                    while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        int i13 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        jArr5[i13] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        iArr6[i13] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    long j2 = Wwwwwwwwwwwwwwwwwww3;
                    int i14 = 8192 / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    int i15 = 0;
                    for (int i16 = 0; i16 < i12; i16++) {
                        i15 += C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr6[i16], i14);
                    }
                    long[] jArr6 = new long[i15];
                    int[] iArr7 = new int[i15];
                    long[] jArr7 = new long[i15];
                    int[] iArr8 = new int[i15];
                    int i17 = 0;
                    int i18 = 0;
                    int i19 = 0;
                    int i20 = 0;
                    while (i17 < i12) {
                        int i21 = iArr6[i17];
                        long j3 = jArr5[i17];
                        int i22 = i20;
                        int i23 = i12;
                        int i24 = i19;
                        int i25 = i22;
                        long[] jArr8 = jArr5;
                        int i26 = i21;
                        while (i26 > 0) {
                            int min = Math.min(i14, i26);
                            jArr6[i25] = j3;
                            iArr7[i25] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 * min;
                            i24 = Math.max(i24, iArr7[i25]);
                            jArr7[i25] = i18 * j2;
                            iArr8[i25] = 1;
                            j3 += iArr7[i25];
                            i18 += min;
                            i26 -= min;
                            i25++;
                            iArr6 = iArr6;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        }
                        i17++;
                        jArr5 = jArr8;
                        int i27 = i25;
                        i19 = i24;
                        i12 = i23;
                        i20 = i27;
                    }
                    i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    jArr = jArr6;
                    iArr2 = iArr8;
                    iArr = iArr7;
                    jArr2 = jArr7;
                    i8 = i19;
                    j = j2 * i18;
                } else {
                    long[] jArr9 = new long[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
                    int[] iArr9 = new int[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
                    long[] jArr10 = new long[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
                    int[] iArr10 = new int[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
                    int i28 = i3;
                    int i29 = 0;
                    int i30 = 0;
                    int i31 = 0;
                    int i32 = 0;
                    long j4 = 0;
                    int i33 = 0;
                    long j5 = 0;
                    int i34 = i;
                    int i35 = Wwwwwwwwwwwwwwwwwww3;
                    int i36 = i5;
                    int i37 = i4;
                    while (true) {
                        if (i29 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                            i6 = i36;
                            break;
                        }
                        int i38 = i31;
                        boolean z5 = true;
                        while (i38 == 0) {
                            z5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            if (!z5) {
                                break;
                            }
                            int i39 = i36;
                            long j6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            i38 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            j5 = j6;
                            i35 = i35;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            i36 = i39;
                        }
                        int i40 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        i6 = i36;
                        int i41 = i35;
                        if (!z5) {
                            jArr9 = Arrays.copyOf(jArr9, i29);
                            iArr9 = Arrays.copyOf(iArr9, i29);
                            jArr10 = Arrays.copyOf(jArr10, i29);
                            iArr10 = Arrays.copyOf(iArr10, i29);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = i29;
                            i31 = i38;
                            break;
                        }
                        if (c2078el5 != null) {
                            while (i32 == 0 && i34 > 0) {
                                i32 = c2078el5.Wwwwwwwwwwwwwwwwwww();
                                i33 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                i34--;
                            }
                            i32--;
                        }
                        int i42 = i33;
                        jArr9[i29] = j5;
                        iArr9[i29] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (iArr9[i29] > i30) {
                            i30 = iArr9[i29];
                        }
                        jArr10[i29] = j4 + i42;
                        iArr10[i29] = c2078el4 == null ? 1 : 0;
                        if (i29 == i28) {
                            iArr10[i29] = 1;
                            i2--;
                            if (i2 > 0) {
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el4);
                                i28 = c2078el4.Wwwwwwwwwwwwwwwwwww() - 1;
                            }
                        }
                        int i43 = i28;
                        j4 += i41;
                        int i44 = i6 - 1;
                        if (i44 != 0 || i37 <= 0) {
                            i9 = i41;
                        } else {
                            i44 = c2078el3.Wwwwwwwwwwwwwwwwwww();
                            i9 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            i37--;
                        }
                        i36 = i44;
                        int i45 = i9;
                        j5 += iArr9[i29];
                        i29++;
                        i33 = i42;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = i40;
                        i35 = i45;
                        i31 = i38 - 1;
                        i28 = i43;
                    }
                    long j7 = j4 + i33;
                    if (c2078el5 != null) {
                        while (i34 > 0) {
                            if (c2078el5.Wwwwwwwwwwwwwwwwwww() != 0) {
                                z3 = false;
                                break;
                            }
                            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            i34--;
                        }
                    }
                    z3 = true;
                    if (i2 != 0 || i6 != 0 || i31 != 0 || i37 != 0 || i32 != 0 || !z3) {
                        (!z3 ? ", ctts invalid" : "").length();
                    }
                    j = j7;
                    i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    jArr = jArr9;
                    iArr = iArr9;
                    jArr2 = jArr10;
                    iArr2 = iArr10;
                    i8 = i30;
                }
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                jArr3 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (jArr3 != null) {
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr2, (long) StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    return new C2590s9(c2473p9, jArr, iArr, i8, jArr2, iArr2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                }
                if (jArr3.length == 1 && c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 && jArr2.length >= 2) {
                    long[] jArr11 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr11);
                    long j8 = jArr11[0];
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww[0], c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j8;
                    int length = jArr2.length - 1;
                    i10 = i7;
                    if (jArr2[0] <= j8 && j8 < jArr2[C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, 0, length)] && jArr2[C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr2.length - 4, 0, length)] < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 <= j) {
                        long j9 = j - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10;
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j8 - jArr2[0], c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkk, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j9, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkk, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 != 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 != 0) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 <= 2147483647L && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 <= 2147483647L) {
                            c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11;
                            c2471p7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12;
                            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr2, (long) StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            return new C2590s9(c2473p9, jArr, iArr, i8, jArr2, iArr2, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww[0], StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                    }
                } else {
                    i10 = i7;
                }
                long[] jArr12 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (jArr12.length == 1 && jArr12[0] == 0) {
                    long[] jArr13 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr13);
                    long j10 = jArr13[0];
                    for (int i46 = 0; i46 < jArr2.length; i46++) {
                        jArr2[i46] = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr2[i46] - j10, StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    return new C2590s9(c2473p9, jArr, iArr, i8, jArr2, iArr2, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - j10, StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                }
                boolean z6 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1;
                long[] jArr14 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                int[] iArr11 = new int[jArr14.length];
                int[] iArr12 = new int[jArr14.length];
                long[] jArr15 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr15);
                int i47 = 0;
                boolean z7 = false;
                int i48 = 0;
                int i49 = 0;
                while (true) {
                    long[] jArr16 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    iArr3 = iArr;
                    if (i47 >= jArr16.length) {
                        break;
                    }
                    int i50 = i8;
                    long j11 = jArr15[i47];
                    if (j11 != -1) {
                        i11 = i50;
                        boolean z8 = z7;
                        int i51 = i48;
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr16[i47], c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        iArr11[i47] = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr2, j11, true, true);
                        iArr12[i47] = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr2, j11 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13, z6, false);
                        while (iArr11[i47] < iArr12[i47] && (iArr2[iArr11[i47]] & 1) == 0) {
                            iArr11[i47] = iArr11[i47] + 1;
                        }
                        int i52 = (iArr12[i47] - iArr11[i47]) + i51;
                        z4 = z8 | (i49 != iArr11[i47]);
                        i49 = iArr12[i47];
                        i48 = i52;
                    } else {
                        z4 = z7;
                        i11 = i50;
                    }
                    i47++;
                    iArr = iArr3;
                    i8 = i11;
                    z7 = z4;
                }
                int i53 = i8;
                boolean z9 = z7;
                int i54 = 0;
                boolean z10 = true;
                if (i48 == i10) {
                    z10 = false;
                }
                boolean z11 = z9 | z10;
                long[] jArr17 = z11 ? new long[i48] : jArr;
                int[] iArr13 = z11 ? new int[i48] : iArr3;
                int i55 = z11 ? 0 : i53;
                int[] iArr14 = z11 ? new int[i48] : iArr2;
                long[] jArr18 = new long[i48];
                int i56 = i55;
                int i57 = 0;
                long j12 = 0;
                while (i54 < c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                    long j13 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwww[i54];
                    int i58 = iArr11[i54];
                    int[] iArr15 = iArr11;
                    int i59 = iArr12[i54];
                    if (z11) {
                        iArr4 = iArr12;
                        int i60 = i59 - i58;
                        System.arraycopy(jArr, i58, jArr17, i57, i60);
                        jArr4 = jArr;
                        iArr5 = iArr3;
                        System.arraycopy(iArr5, i58, iArr13, i57, i60);
                        System.arraycopy(iArr2, i58, iArr14, i57, i60);
                    } else {
                        jArr4 = jArr;
                        iArr4 = iArr12;
                        iArr5 = iArr3;
                    }
                    int i61 = i56;
                    while (i58 < i59) {
                        int[] iArr16 = iArr14;
                        int i62 = i54;
                        long[] jArr19 = jArr2;
                        int[] iArr17 = iArr2;
                        long j14 = j12;
                        jArr18[i57] = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j12, StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.max(0L, jArr2[i58] - j13), StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (z11 && iArr13[i57] > i61) {
                            i61 = iArr5[i58];
                        }
                        i57++;
                        i58++;
                        iArr2 = iArr17;
                        j12 = j14;
                        jArr2 = jArr19;
                        iArr14 = iArr16;
                        i54 = i62;
                    }
                    int i63 = i54;
                    i54 = i63 + 1;
                    j12 += c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i63];
                    i56 = i61;
                    iArr11 = iArr15;
                    jArr2 = jArr2;
                    iArr12 = iArr4;
                    iArr2 = iArr2;
                    iArr3 = iArr5;
                    jArr = jArr4;
                }
                return new C2590s9(c2473p9, jArr17, iArr13, i56, jArr18, iArr14, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j12, StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            c2078el4 = null;
        } else {
            i2 = 0;
        }
        i3 = -1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        String str2 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
        }
        i4 = Wwwwwwwwwwwwwwwwwww;
        i5 = Wwwwwwwwwwwwwwwwwww2;
        z2 = false;
        if (!z2) {
        }
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww92 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, StopWatch.NANO_2_MILLIS, c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        jArr3 = c2473p9.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (jArr3 != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:529:0x00ea, code lost:
        if (r11 == 0) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0aa8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0aad  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0a82  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<C2590s9> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2471p7 c2471p7, long j, @Nullable C2322l6 c2322l6, boolean z, boolean z2, AbstractC2271jt<C2473p9, C2473p9> abstractC2271jt) throws ParserException {
        boolean z3;
        long Wwwwwwwwwwwwwwwwwwwww;
        int i;
        ArrayList arrayList;
        long[] jArr;
        long[] jArr2;
        C2473p9 c2473p9;
        Pair create;
        ArrayList arrayList2;
        int i2;
        boolean z4;
        Pair pair;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        C2516q9[] c2516q9Arr;
        int i3;
        int i4;
        int i5;
        int i6;
        C2322l6 c2322l62;
        String str;
        int i7;
        byte[] bArr;
        int i8;
        int i9;
        boolean z5;
        List<byte[]> list;
        int i10;
        String str2;
        List<byte[]> list2;
        int i11;
        int i12;
        int i13;
        C2322l6 c2322l63;
        String str3;
        int i14;
        int i15;
        ImmutableList immutableList;
        String str4;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        String str5;
        int i22;
        boolean z6;
        String str6;
        int i23;
        String str7;
        int i24;
        int i25;
        List<byte[]> m3918of;
        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str8;
        ImmutableList immutableList2;
        long j2;
        C2473p9 mo4462apply;
        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2322l6 c2322l64 = c2322l6;
        ArrayList arrayList3 = new ArrayList();
        int i26 = 0;
        while (i26 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
            AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i26);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1953653099) {
                i = i26;
            } else {
                AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1836476516);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1835297121);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1751411826);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                C2078el c2078el = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                int i27 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1936684398 ? 1 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1986618469 ? 2 : (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1952807028 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1935832172 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1937072756 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1668047728) ? 3 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 1835365473 ? 4 : -1;
                if (i27 == -1) {
                    arrayList = arrayList3;
                    i = i26;
                } else {
                    AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1953196132);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                    C2078el c2078el2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i28 = 8;
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = (c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >> 24) & 255;
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == 0 ? 8 : 16);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    int i29 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == 0) {
                        i28 = 4;
                    }
                    int i30 = 0;
                    while (true) {
                        if (i30 >= i28) {
                            z3 = true;
                            break;
                        } else if (c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i29 + i30] != -1) {
                            z3 = false;
                            break;
                        } else {
                            i30++;
                        }
                    }
                    if (z3) {
                        c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i28);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 == 0 ? c2078el2.Wwwwwwwwwwwwwwwwwwwww() : c2078el2.Wwwwwwwwwwwwwwwwww();
                    }
                    Wwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int i31 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == 65536 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 == -65536 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 == 0) ? 90 : (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == -65536 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 == 65536 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 == 0) ? 270 : (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == -65536 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 == 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 == -65536) ? 180 : 0;
                    long j3 = j == -9223372036854775807L ? Wwwwwwwwwwwwwwwwwwwww : j;
                    C2078el c2078el3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                    c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(((c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >> 24) & 255) == 0 ? 8 : 16);
                    long Wwwwwwwwwwwwwwwwwwwww2 = c2078el3.Wwwwwwwwwwwwwwwwwwwww();
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = j3 == -9223372036854775807L ? -9223372036854775807L : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3, StopWatch.NANO_2_MILLIS, Wwwwwwwwwwwwwwwwwwwww2);
                    AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1835626086);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937007212);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                    AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1835296868);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13);
                    C2078el c2078el4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = (c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >> 24) & 255;
                    c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 == 0 ? 8 : 16);
                    long Wwwwwwwwwwwwwwwwwwwww3 = c2078el4.Wwwwwwwwwwwwwwwwwwwww();
                    c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 == 0 ? 4 : 8);
                    int Wwwwwwwwwwwwwwwww = c2078el4.Wwwwwwwwwwwwwwwww();
                    i = i26;
                    StringBuilder sb = new StringBuilder(3);
                    sb.append((char) (((Wwwwwwwwwwwwwwwww >> 10) & 31) + 96));
                    sb.append((char) (((Wwwwwwwwwwwwwwwww >> 5) & 31) + 96));
                    sb.append((char) ((Wwwwwwwwwwwwwwwww & 31) + 96));
                    Pair create2 = Pair.create(Long.valueOf(Wwwwwwwwwwwwwwwwwwwww3), sb.toString());
                    AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937011556);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15);
                    C2078el c2078el5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    String str9 = (String) create2.second;
                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    C2516q9[] c2516q9Arr2 = new C2516q9[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16];
                    int i32 = 0;
                    C2245j3 c2245j3 = null;
                    int i33 = 0;
                    int i34 = 0;
                    while (i32 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16) {
                        int i35 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 > 0) {
                            arrayList2 = arrayList3;
                            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16;
                            z4 = true;
                        } else {
                            arrayList2 = arrayList3;
                            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16;
                            z4 = false;
                        }
                        String str10 = "childAtomSize should be positive";
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z4, str10);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        long j4 = Wwwwwwwwwwwwwwwwwwwww2;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1635148593 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1635148595 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1701733238 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1836070006 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1752589105 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1751479857 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1932670515 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1987063864 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1987063865 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1635135537 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685479798 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685479729 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685481573 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685481521) {
                            int i36 = i31;
                            pair = create2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                            c2516q9Arr = c2516q9Arr2;
                            i3 = i27;
                            i4 = i32;
                            int i37 = -1;
                            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i35 + 8 + 8);
                            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                            int Wwwwwwwwwwwwwwwww2 = c2078el5.Wwwwwwwwwwwwwwwww();
                            int Wwwwwwwwwwwwwwwww3 = c2078el5.Wwwwwwwwwwwwwwwww();
                            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(50);
                            int i38 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1701733238) {
                                i5 = i35;
                                i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17;
                                Pair<Integer, C2516q9> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el5, i5, i6);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.first).intValue();
                                    c2322l62 = c2322l6 == null ? null : c2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((C2516q9) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.second).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                    c2516q9Arr[i4] = (C2516q9) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.second;
                                } else {
                                    c2322l62 = c2322l6;
                                }
                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i38);
                            } else {
                                i5 = i35;
                                i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17;
                                c2322l62 = c2322l6;
                            }
                            float f = 1.0f;
                            boolean z7 = false;
                            str = str9;
                            C2322l6 c2322l65 = c2322l62;
                            String str11 = null;
                            byte[] bArr2 = null;
                            String str12 = null;
                            List<byte[]> list3 = null;
                            while (true) {
                                if (i38 - i5 >= i6) {
                                    i7 = i37;
                                    bArr = bArr2;
                                    break;
                                }
                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i38);
                                int i39 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                i7 = i37;
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                bArr = bArr2;
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19 == 0 && c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i5 == i6) {
                                    break;
                                }
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19 > 0, str10);
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                String str13 = str10;
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1635148611) {
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str12 == null);
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i39 + 8);
                                    C2717vl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2717vl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el5);
                                    list2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i40 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (!z7) {
                                        f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    }
                                    str12 = "video/avc";
                                    i34 = i40;
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1752589123) {
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str12 == null);
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i39 + 8);
                                    C2865zl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2865zl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el5);
                                    list2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i34 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    str12 = "video/hevc";
                                } else {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1685480259 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1685485123) {
                                        i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                        z5 = z7;
                                        C2791xl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2791xl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el5);
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null) {
                                            str12 = "video/dolby-vision";
                                            list = list3;
                                            bArr2 = bArr;
                                            str11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            list3 = list;
                                            i10 = i7;
                                        }
                                        list = list3;
                                        bArr2 = bArr;
                                        list3 = list;
                                        i10 = i7;
                                    } else {
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1987076931) {
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str12 == null);
                                            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1635135811) {
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str12 == null);
                                            str2 = "video/av01";
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1681012275) {
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str12 == null);
                                            str2 = DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1702061171) {
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str12 == null);
                                            Pair<String, byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el5, i39);
                                            str12 = (String) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.first;
                                            byte[] bArr3 = (byte[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.second;
                                            if (bArr3 != null) {
                                                list = ImmutableList.m3918of(bArr3);
                                                i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                                z5 = z7;
                                                bArr2 = bArr;
                                                list3 = list;
                                                i10 = i7;
                                            }
                                            i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                            z5 = z7;
                                            list = list3;
                                            bArr2 = bArr;
                                            list3 = list;
                                            i10 = i7;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1885434736) {
                                            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i39 + 8);
                                            f = c2078el5.Wwwwwwwwwwwwwwwwwww() / c2078el5.Wwwwwwwwwwwwwwwwwww();
                                            i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                            i10 = i7;
                                            bArr2 = bArr;
                                            z7 = true;
                                            i38 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19;
                                            i37 = i10;
                                            str10 = str13;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = i9;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1937126244) {
                                            int i41 = i39 + 8;
                                            while (true) {
                                                if (i41 - i39 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19) {
                                                    i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                                    z5 = z7;
                                                    list = list3;
                                                    bArr2 = null;
                                                    break;
                                                }
                                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i41);
                                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                                z5 = z7;
                                                if (c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1886547818) {
                                                    bArr2 = Arrays.copyOfRange(c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i41, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21 + i41);
                                                    list = list3;
                                                    break;
                                                }
                                                i41 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21;
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = i9;
                                                z7 = z5;
                                            }
                                            list3 = list;
                                            i10 = i7;
                                        } else {
                                            i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                            z5 = z7;
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 == 1936995172) {
                                                int Wwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwwwwwwww();
                                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                                if (Wwwwwwwwwwwwwwwwwwwwww == 0) {
                                                    int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el5.Wwwwwwwwwwwwwwwwwwwwww();
                                                    if (Wwwwwwwwwwwwwwwwwwwwww2 == 0) {
                                                        i10 = 0;
                                                    } else if (Wwwwwwwwwwwwwwwwwwwwww2 == 1) {
                                                        i10 = 1;
                                                    } else if (Wwwwwwwwwwwwwwwwwwwwww2 == 2) {
                                                        i10 = 2;
                                                    } else if (Wwwwwwwwwwwwwwwwwwwwww2 == 3) {
                                                        i10 = 3;
                                                    }
                                                    bArr2 = bArr;
                                                }
                                            }
                                            list = list3;
                                            bArr2 = bArr;
                                            list3 = list;
                                            i10 = i7;
                                        }
                                        str12 = str2;
                                        i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                        z5 = z7;
                                        list = list3;
                                        bArr2 = bArr;
                                        list3 = list;
                                        i10 = i7;
                                    }
                                    z7 = z5;
                                    i38 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19;
                                    i37 = i10;
                                    str10 = str13;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = i9;
                                }
                                list = list2;
                                i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18;
                                z5 = z7;
                                bArr2 = bArr;
                                list3 = list;
                                i10 = i7;
                                z7 = z5;
                                i38 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19;
                                i37 = i10;
                                str10 = str13;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = i9;
                            }
                            if (str12 == null) {
                                i8 = i36;
                            } else {
                                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwww = str12;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str11;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwww2;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwww3;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwww = f;
                                i8 = i36;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwww = i8;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwww = bArr;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwww = i7;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwww = list3;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwww = c2322l65;
                                c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                        } else {
                            i3 = i27;
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1836069985 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1701733217 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1633889587 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1700998451 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1633889588 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685353315 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685353317 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685353320 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685353324 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1935764850 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1935767394 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1819304813 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1936684916 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1953984371 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 778924082 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 778924083 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1634492771 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1634492791 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1970037111 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1332770163 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1716281667) {
                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i35 + 8 + 8);
                                if (z2) {
                                    i11 = c2078el5.Wwwwwwwwwwwwwwwww();
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                                } else {
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    i11 = 0;
                                }
                                if (i11 == 0 || i11 == 1) {
                                    int Wwwwwwwwwwwwwwwww4 = c2078el5.Wwwwwwwwwwwwwwwww();
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                                    byte[] bArr4 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i42 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    pair = create2;
                                    int i43 = i42 + 1;
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i43;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                    int i44 = i43 + 1;
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i44;
                                    int i45 = (bArr4[i43] & 255) | ((bArr4[i42] & 255) << 8);
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i44 + 2;
                                    if (i11 == 1) {
                                        c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                    }
                                    i12 = i45;
                                    i13 = Wwwwwwwwwwwwwwwww4;
                                } else if (i11 == 2) {
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                    i12 = (int) Math.round(Double.longBitsToDouble(c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwww()));
                                    i13 = c2078el5.Wwwwwwwwwwwwwwwwwww();
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(20);
                                    pair = create2;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                }
                                int i46 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1701733217) {
                                    Pair<Integer, C2516q9> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el5, i35, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 != null) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.first).intValue();
                                        c2322l63 = c2322l64 == null ? null : c2322l64.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((C2516q9) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.second).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        c2516q9Arr2[i32] = (C2516q9) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.second;
                                    } else {
                                        c2322l63 = c2322l64;
                                    }
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i46);
                                } else {
                                    c2322l63 = c2322l64;
                                }
                                String str14 = "audio/ac3";
                                int i47 = i13;
                                String str15 = "audio/raw";
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1633889587) {
                                    str15 = str14;
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1700998451) {
                                    str15 = "audio/eac3";
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1633889588) {
                                    str15 = "audio/ac4";
                                } else {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685353315) {
                                        str3 = "audio/vnd.dts";
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685353320 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685353324) {
                                        str3 = "audio/vnd.dts.hd";
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1685353317) {
                                        str3 = "audio/vnd.dts.hd;profile=lbr";
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1935764850) {
                                        str3 = DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP;
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1935767394) {
                                        str3 = "audio/amr-wb";
                                    } else {
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1819304813 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1936684916) {
                                            i14 = 2;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1953984371) {
                                            i14 = 268435456;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 778924082 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 778924083) {
                                            str3 = DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1634492771) {
                                            str3 = "audio/alac";
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1634492791) {
                                            str3 = "audio/g711-alaw";
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1970037111) {
                                            str3 = "audio/g711-mlaw";
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1332770163) {
                                            str3 = "audio/opus";
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1716281667) {
                                            str3 = "audio/flac";
                                        } else {
                                            str15 = null;
                                        }
                                        i15 = i47;
                                        immutableList = null;
                                        c2516q9Arr = c2516q9Arr2;
                                        str4 = str15;
                                        i4 = i32;
                                        String str16 = null;
                                        i16 = i31;
                                        i17 = i12;
                                        i18 = i46;
                                        while (i18 - i35 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17) {
                                            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18);
                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 > 0) {
                                                i22 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17;
                                                z6 = true;
                                            } else {
                                                i22 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17;
                                                z6 = false;
                                            }
                                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z6, str10);
                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            int i48 = i35;
                                            int i49 = 1702061171;
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 != 1702061171) {
                                                if (!z2 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 != 2002876005) {
                                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 == 1684103987) {
                                                        c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18 + 8);
                                                        String num = Integer.toString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                                        int i50 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(c2078el5.Wwwwwwwwwwwwwwwwwwwwww() & 192) >> 6];
                                                        int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el5.Wwwwwwwwwwwwwwwwwwwwww();
                                                        int i51 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(Wwwwwwwwwwwwwwwwwwwwww3 & 56) >> 3];
                                                        if ((Wwwwwwwwwwwwwwwwwwwwww3 & 4) != 0) {
                                                            i51++;
                                                        }
                                                        i23 = i14;
                                                        int i52 = i51;
                                                        str7 = str16;
                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = num;
                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = str14;
                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwww = i52;
                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwww = i50;
                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = c2322l63;
                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                                        str6 = str14;
                                                        c2245j3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                    } else {
                                                        i23 = i14;
                                                        str7 = str16;
                                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 == 1684366131) {
                                                            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18 + 8);
                                                            String num2 = Integer.toString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                                            c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                                            int i53 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(c2078el5.Wwwwwwwwwwwwwwwwwwwwww() & 192) >> 6];
                                                            int Wwwwwwwwwwwwwwwwwwwwww4 = c2078el5.Wwwwwwwwwwwwwwwwwwwwww();
                                                            int i54 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(Wwwwwwwwwwwwwwwwwwwwww4 & 14) >> 1];
                                                            if ((Wwwwwwwwwwwwwwwwwwwwww4 & 1) != 0) {
                                                                i54++;
                                                            }
                                                            if (((c2078el5.Wwwwwwwwwwwwwwwwwwwwww() & 30) >> 1) > 0 && (c2078el5.Wwwwwwwwwwwwwwwwwwwwww() & 2) != 0) {
                                                                i54 += 2;
                                                            }
                                                            if (c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() <= 0 || (c2078el5.Wwwwwwwwwwwwwwwwwwwwww() & 1) == 0) {
                                                                str6 = str14;
                                                                str8 = "audio/eac3";
                                                            } else {
                                                                str8 = "audio/eac3-joc";
                                                                str6 = str14;
                                                            }
                                                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = num2;
                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwww = str8;
                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwww = i54;
                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwww = i53;
                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwww = c2322l63;
                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                        } else {
                                                            str6 = str14;
                                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 == 1684103988) {
                                                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18 + 8);
                                                                String num3 = Integer.toString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                                                int i55 = ((c2078el5.Wwwwwwwwwwwwwwwwwwwwww() & 32) >> 5) == 1 ? 48000 : 44100;
                                                                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = num3;
                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/ac4";
                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwww = 2;
                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwww = i55;
                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww = c2322l63;
                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 == 1684305011) {
                                                                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwww = str4;
                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwww = i15;
                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwww = i17;
                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwww = c2322l63;
                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                            } else {
                                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 == 1682927731) {
                                                                    int i56 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 - 8;
                                                                    byte[] bArr5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                    byte[] copyOf = Arrays.copyOf(bArr5, bArr5.length + i56);
                                                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18 + 8);
                                                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(copyOf, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length, i56);
                                                                    m3918of = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(copyOf);
                                                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 == 1684425825) {
                                                                    int i57 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 - 12;
                                                                    byte[] bArr6 = new byte[i57 + 4];
                                                                    bArr6[0] = 102;
                                                                    bArr6[1] = 76;
                                                                    bArr6[2] = 97;
                                                                    bArr6[3] = 67;
                                                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18 + 12);
                                                                    System.arraycopy(c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr6, 4, i57);
                                                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i57;
                                                                    m3918of = ImmutableList.m3918of(bArr6);
                                                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 == 1634492771) {
                                                                    int i58 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 - 12;
                                                                    byte[] bArr7 = new byte[i58];
                                                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i18 + 12);
                                                                    System.arraycopy(c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr7, 0, i58);
                                                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i58;
                                                                    C2078el c2078el6 = new C2078el(bArr7);
                                                                    c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9);
                                                                    int Wwwwwwwwwwwwwwwwwwwwww5 = c2078el6.Wwwwwwwwwwwwwwwwwwwwww();
                                                                    c2078el6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20);
                                                                    Pair create3 = Pair.create(Integer.valueOf(c2078el6.Wwwwwwwwwwwwwwwwwww()), Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwww5));
                                                                    int intValue = ((Integer) create3.first).intValue();
                                                                    i15 = ((Integer) create3.second).intValue();
                                                                    immutableList = ImmutableList.m3918of(bArr7);
                                                                    i17 = intValue;
                                                                }
                                                                immutableList = m3918of;
                                                            }
                                                        }
                                                        c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                                    }
                                                    str16 = str7;
                                                    i18 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22;
                                                    i35 = i48;
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = i22;
                                                    i14 = i23;
                                                    str14 = str6;
                                                } else {
                                                    i49 = 1702061171;
                                                }
                                            }
                                            str6 = str14;
                                            i23 = i14;
                                            str7 = str16;
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 == i49) {
                                                i24 = i18;
                                            } else {
                                                i24 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                while (i24 - i18 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22) {
                                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i24);
                                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww24 = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww24 > 0, str10);
                                                    if (c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 1702061171) {
                                                        i24 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww24;
                                                    }
                                                }
                                                i25 = -1;
                                                i24 = -1;
                                                if (i24 != i25) {
                                                    Pair<String, byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el5, i24);
                                                    String str17 = (String) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.first;
                                                    byte[] bArr8 = (byte[]) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.second;
                                                    if (bArr8 != null) {
                                                        if ("audio/mp4a-latm".equals(str17)) {
                                                            C2737w4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = C2737w4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr8);
                                                            int i59 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                            int i60 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                            str16 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                            i17 = i59;
                                                            i15 = i60;
                                                        } else {
                                                            str16 = str7;
                                                        }
                                                        immutableList = ImmutableList.m3918of(bArr8);
                                                    } else {
                                                        str16 = str7;
                                                    }
                                                    str4 = str17;
                                                    i18 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22;
                                                    i35 = i48;
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = i22;
                                                    i14 = i23;
                                                    str14 = str6;
                                                }
                                                str16 = str7;
                                                i18 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22;
                                                i35 = i48;
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = i22;
                                                i14 = i23;
                                                str14 = str6;
                                            }
                                            i25 = -1;
                                            if (i24 != i25) {
                                            }
                                            str16 = str7;
                                            i18 += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22;
                                            i35 = i48;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = i22;
                                            i14 = i23;
                                            str14 = str6;
                                        }
                                        i19 = i14;
                                        i20 = i35;
                                        i21 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17;
                                        str5 = str16;
                                        if (c2245j3 == null && str4 != null) {
                                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwwwwwwwwwwwwwwww = str4;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str5;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwww = i15;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwww = i17;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwww = i19;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwwwwwwwwwwwwww = immutableList;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwwwwwwwwwwwww = c2322l63;
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                            c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        }
                                        str = str9;
                                        i8 = i16;
                                        i5 = i20;
                                        i6 = i21;
                                    }
                                    str15 = str3;
                                }
                                i14 = -1;
                                i15 = i47;
                                immutableList = null;
                                c2516q9Arr = c2516q9Arr2;
                                str4 = str15;
                                i4 = i32;
                                String str162 = null;
                                i16 = i31;
                                i17 = i12;
                                i18 = i46;
                                while (i18 - i35 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17) {
                                }
                                i19 = i14;
                                i20 = i35;
                                i21 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17;
                                str5 = str162;
                                if (c2245j3 == null) {
                                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwwwwwwwwwwwwwwwwww = str4;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str5;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwwwww = i15;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwwww = i17;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwww = i19;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwwwwwwwwwwwwwwww = immutableList;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwwwwwwwwwwwwwww = c2322l63;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                    c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww122.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                }
                                str = str9;
                                i8 = i16;
                                i5 = i20;
                                i6 = i21;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1414810956 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1954034535 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 2004251764 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1937010800 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1664495672) {
                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i35 + 8 + 8);
                                String str18 = "application/ttml+xml";
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 != 1414810956) {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1954034535) {
                                        int i61 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 - 8) - 8;
                                        byte[] bArr9 = new byte[i61];
                                        System.arraycopy(c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr9, 0, i61);
                                        c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i61;
                                        immutableList2 = ImmutableList.m3918of(bArr9);
                                        str18 = "application/x-quicktime-tx3g";
                                        j2 = Long.MAX_VALUE;
                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.Wwwwwwwwwwwwwwwwwwwwwwww = str18;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.Wwwwwwwwwwwwwwwwwwww = j2;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.Wwwwwwwwwwwwwwwwwwwwww = immutableList2;
                                        c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 2004251764) {
                                        str18 = "application/x-mp4-vtt";
                                    } else {
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1937010800) {
                                            j2 = 0;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 != 1664495672) {
                                            throw new IllegalStateException();
                                        } else {
                                            j2 = Long.MAX_VALUE;
                                            str18 = "application/x-mp4-cea-608";
                                            i33 = 1;
                                        }
                                        immutableList2 = null;
                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww132 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww132.Wwwwwwwwwwwwwwwwwwwwwwww = str18;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww132.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww132.Wwwwwwwwwwwwwwwwwwww = j2;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww132.Wwwwwwwwwwwwwwwwwwwwww = immutableList2;
                                        c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww132.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    }
                                }
                                immutableList2 = null;
                                j2 = Long.MAX_VALUE;
                                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1322 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1322.Wwwwwwwwwwwwwwwwwwwwwwww = str18;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str9;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1322.Wwwwwwwwwwwwwwwwwwww = j2;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1322.Wwwwwwwwwwwwwwwwwwwwww = immutableList2;
                                c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1835365492) {
                                c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i35 + 8 + 8);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1835365492) {
                                    c2078el5.Wwwwwwwwwwwwwwwwwwwwwwww();
                                    String Wwwwwwwwwwwwwwwwwwwwwwww = c2078el5.Wwwwwwwwwwwwwwwwwwwwwwww();
                                    if (Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwww;
                                        c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    }
                                }
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 == 1667329389) {
                                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15.Wwwwwwwwwwwwwwwwwwwwwwww = "application/x-camera-motion";
                                c2245j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                            i16 = i31;
                            pair = create2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                            c2516q9Arr = c2516q9Arr2;
                            i20 = i35;
                            i21 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17;
                            i4 = i32;
                            str = str9;
                            i8 = i16;
                            i5 = i20;
                            i6 = i21;
                        }
                        c2078el5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 + i6);
                        i32 = i4 + 1;
                        i31 = i8;
                        i27 = i3;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = i2;
                        Wwwwwwwwwwwwwwwwwwwww2 = j4;
                        arrayList3 = arrayList2;
                        str9 = str;
                        create2 = pair;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        c2516q9Arr2 = c2516q9Arr;
                        c2322l64 = c2322l6;
                    }
                    arrayList = arrayList3;
                    Pair pair2 = create2;
                    AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                    long j5 = Wwwwwwwwwwwwwwwwwwwww2;
                    C2516q9[] c2516q9Arr3 = c2516q9Arr2;
                    int i62 = i27;
                    if (!z) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1701082227);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null) {
                            AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww25 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1701606260);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww25 == null) {
                                create = null;
                            } else {
                                C2078el c2078el7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww25.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww26 = (c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >> 24) & 255;
                                int Wwwwwwwwwwwwwwwwwww = c2078el7.Wwwwwwwwwwwwwwwwwww();
                                long[] jArr3 = new long[Wwwwwwwwwwwwwwwwwww];
                                long[] jArr4 = new long[Wwwwwwwwwwwwwwwwwww];
                                for (int i63 = 0; i63 < Wwwwwwwwwwwwwwwwwww; i63++) {
                                    jArr3[i63] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww26 == 1 ? c2078el7.Wwwwwwwwwwwwwwwwww() : c2078el7.Wwwwwwwwwwwwwwwwwwwww();
                                    jArr4[i63] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww26 == 1 ? c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwww() : c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    byte[] bArr10 = c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i64 = c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i65 = i64 + 1;
                                    c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i65;
                                    c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i65 + 1;
                                    if (((short) ((bArr10[i65] & 255) | ((bArr10[i64] & 255) << 8))) != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    c2078el7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                }
                                create = Pair.create(jArr3, jArr4);
                            }
                            if (create != null) {
                                jArr2 = (long[]) create.first;
                                jArr = (long[]) create.second;
                                if (c2245j3 != null) {
                                    c2473p9 = new C2473p9(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, i62, ((Long) pair2.first).longValue(), j5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12, c2245j3, i33, c2516q9Arr3, i34, jArr2, jArr);
                                    mo4462apply = abstractC2271jt.mo4462apply(c2473p9);
                                    if (mo4462apply != null) {
                                        arrayList3 = arrayList;
                                    } else {
                                        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1835297121);
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1835626086);
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8);
                                        AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1937007212);
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                                        C2590s9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4462apply, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9, c2471p7);
                                        arrayList3 = arrayList;
                                        arrayList3.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16);
                                    }
                                }
                            }
                        }
                    } else {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                    }
                    jArr = null;
                    jArr2 = null;
                    if (c2245j3 != null) {
                    }
                }
                c2473p9 = null;
                mo4462apply = abstractC2271jt.mo4462apply(c2473p9);
                if (mo4462apply != null) {
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i26 = i + 1;
            c2322l64 = c2322l6;
        }
        return arrayList3;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x025d A[Catch: all -> 0x01f9, TryCatch #0 {all -> 0x01f9, blocks: (B:124:0x0070, B:126:0x0076, B:128:0x007b, B:130:0x0083, B:31:0x0099, B:44:0x00a6, B:47:0x00b3, B:50:0x00c1, B:52:0x00cb, B:57:0x00e3, B:66:0x0270, B:84:0x013a, B:87:0x0147, B:97:0x016b, B:99:0x016f, B:101:0x017f, B:106:0x018b, B:110:0x0196, B:117:0x01a4, B:118:0x024d, B:120:0x025d, B:122:0x0261, B:137:0x01ba, B:139:0x01c1, B:141:0x01cb, B:142:0x01dd, B:144:0x01ed, B:145:0x01f1, B:173:0x0240), top: B:123:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0261 A[Catch: all -> 0x01f9, TRY_LEAVE, TryCatch #0 {all -> 0x01f9, blocks: (B:124:0x0070, B:126:0x0076, B:128:0x007b, B:130:0x0083, B:31:0x0099, B:44:0x00a6, B:47:0x00b3, B:50:0x00c1, B:52:0x00cb, B:57:0x00e3, B:66:0x0270, B:84:0x013a, B:87:0x0147, B:97:0x016b, B:99:0x016f, B:101:0x017f, B:106:0x018b, B:110:0x0196, B:117:0x01a4, B:118:0x024d, B:120:0x025d, B:122:0x0261, B:137:0x01ba, B:139:0x01c1, B:141:0x01cb, B:142:0x01dd, B:144:0x01ed, B:145:0x01f1, B:173:0x0240), top: B:123:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0083 A[Catch: all -> 0x01f9, TryCatch #0 {all -> 0x01f9, blocks: (B:124:0x0070, B:126:0x0076, B:128:0x007b, B:130:0x0083, B:31:0x0099, B:44:0x00a6, B:47:0x00b3, B:50:0x00c1, B:52:0x00cb, B:57:0x00e3, B:66:0x0270, B:84:0x013a, B:87:0x0147, B:97:0x016b, B:99:0x016f, B:101:0x017f, B:106:0x018b, B:110:0x0196, B:117:0x01a4, B:118:0x024d, B:120:0x025d, B:122:0x0261, B:137:0x01ba, B:139:0x01c1, B:141:0x01cb, B:142:0x01dd, B:144:0x01ed, B:145:0x01f1, B:173:0x0240), top: B:123:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0279 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0048 A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        String str;
        C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String valueOf;
        String str2;
        String str3;
        if (z) {
            return null;
        }
        C2078el c2078el = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 8) {
            int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1835365473) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                int i2 = i + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
                while (true) {
                    int i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i3 >= i2) {
                        return null;
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1768715124) {
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                        int i4 = i3 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                        ArrayList arrayList = new ArrayList();
                        while (true) {
                            int i5 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (i5 >= i4) {
                                break;
                            }
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + i5;
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            int i6 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 >> 24) & 255;
                            if (i6 == 169 || i6 == 253) {
                                int i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 & ViewCompat.MEASURED_SIZE_MASK;
                                if (i7 == 6516084) {
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1684108385) {
                                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 - 16);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2144gd("und", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                    } else {
                                        String valueOf2 = String.valueOf(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5));
                                        if (valueOf2.length() != 0) {
                                            "Failed to parse comment attribute: ".concat(valueOf2);
                                        } else {
                                            new String("Failed to parse comment attribute: ");
                                        }
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                    }
                                } else {
                                    if (i7 != 7233901 && i7 != 7631467) {
                                        if (i7 != 6516589 && i7 != 7828084) {
                                            if (i7 == 6578553) {
                                                str = "TDRC";
                                            } else if (i7 == 4280916) {
                                                str = "TPE1";
                                            } else if (i7 == 7630703) {
                                                str = "TSSE";
                                            } else if (i7 == 6384738) {
                                                str = "TALB";
                                            } else if (i7 == 7108978) {
                                                str = "USLT";
                                            } else if (i7 == 6776174) {
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, "TCON", c2078el);
                                            } else {
                                                if (i7 == 6779504) {
                                                    str = "TIT1";
                                                }
                                                valueOf = String.valueOf(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5));
                                                if (valueOf.length() == 0) {
                                                    "Skipped unknown metadata entry: ".concat(valueOf);
                                                } else {
                                                    new String("Skipped unknown metadata entry: ");
                                                }
                                                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                                }
                                            }
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, str, c2078el);
                                        }
                                        str = "TCOM";
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, str, c2078el);
                                    }
                                    str = "TIT2";
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, str, c2078el);
                                }
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                }
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1735291493) {
                                try {
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 > 0) {
                                        String[] strArr = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 <= strArr.length) {
                                            str2 = strArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 - 1];
                                            if (str2 != null) {
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2403nd("TCON", null, str2);
                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                                }
                                            }
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                            }
                                        }
                                    }
                                    str2 = null;
                                    if (str2 != null) {
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                    }
                                } finally {
                                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                }
                            } else {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1684632427) {
                                    str3 = "TPOS";
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1953655662) {
                                    str3 = "TRCK";
                                } else {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1953329263) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, "TBPM", c2078el, true, false);
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1668311404) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, "TCMP", c2078el, true, true);
                                    } else {
                                        int i8 = 4;
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1668249202) {
                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1684108385) {
                                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & ViewCompat.MEASURED_SIZE_MASK;
                                                String str4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == 13 ? DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == 14 ? DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG : null;
                                                if (str4 != null) {
                                                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                                    int i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 - 16;
                                                    byte[] bArr = new byte[i9];
                                                    System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i9);
                                                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i9;
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C1979cd(str4, null, 3, bArr);
                                                }
                                            }
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                        } else {
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1631670868) {
                                                str = "TPE2";
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1936682605) {
                                                str = "TSOT";
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1936679276) {
                                                str = "TSO2";
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1936679282) {
                                                str = "TSOA";
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1936679265) {
                                                str = "TSOP";
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1936679791) {
                                                str = "TSOC";
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1920233063) {
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, "ITUNESADVISORY", c2078el, false, false);
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1885823344) {
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, "ITUNESGAPLESS", c2078el, false, true);
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1936683886) {
                                                str = "TVSHOWSORT";
                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1953919848) {
                                                str = "TVSHOW";
                                            } else {
                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 757935405) {
                                                    String str5 = null;
                                                    String str6 = null;
                                                    int i10 = -1;
                                                    int i11 = -1;
                                                    while (true) {
                                                        int i12 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                        if (i12 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) {
                                                            break;
                                                        }
                                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 == 1835360622) {
                                                            str5 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 - 12);
                                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 == 1851878757) {
                                                            str6 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 - 12);
                                                        } else {
                                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 == 1684108385) {
                                                                i10 = i12;
                                                                i11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                                                            }
                                                            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 - 12);
                                                        }
                                                        i8 = 4;
                                                    }
                                                    if (str5 != null && str6 != null && i10 != -1) {
                                                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10);
                                                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2292kd(str5, str6, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11 - 16));
                                                    }
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                                }
                                                valueOf = String.valueOf(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5));
                                                if (valueOf.length() == 0) {
                                                }
                                                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                                }
                                            }
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, str, c2078el);
                                        }
                                    }
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                    }
                                }
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2325l9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, str3, c2078el);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new C2254jc(arrayList);
                        }
                        return null;
                    }
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                }
            } else {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
        }
        return null;
    }
}
