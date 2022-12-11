package me.tvspark;

import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.util.TimeUtils;
import androidx.exifinterface.media.ExifInterface;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.google.android.exoplayer2.ParserException;
import com.just.agentweb.WebIndicator;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import me.tvspark.AbstractC2625t7;
import me.tvspark.AbstractC2740w7;
import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.jetty.http.HttpTokens;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.regexp.NativeRegExp;

/* renamed from: me.tvspark.q8 */
/* loaded from: classes4.dex */
public class C2515q8 implements AbstractC2175h7 {
    public static final Map<String, Integer> Illllllllllllllllllllllllllll;
    public AbstractC2249j7 Kkkkkk;
    public boolean Kkkkkkk;
    public byte Kkkkkkkk;
    public int Kkkkkkkkk;
    public boolean Kkkkkkkkkk;
    public boolean Kkkkkkkkkkk;
    public boolean Kkkkkkkkkkkk;
    public int Kkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkk;
    public int[] Kkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkk;
    public long Kkkkkkkkkkkkkkkkkkkkkkkk;
    public long Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Www;
    public boolean Wwww;
    @Nullable
    public C2864zk Wwwww;
    @Nullable
    public C2864zk Wwwwww;
    public boolean Wwwwwwwwww;
    public long Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public boolean Wwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwww;
    public ByteBuffer Wwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final SparseArray<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2589s8 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2472p8 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final byte[] Kkkkk = {NativeRegExp.REOP_ENDCHILD, 10, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ASSERTNOTTEST, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, 32, 45, 45, 62, 32, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ASSERTNOTTEST, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, 10};
    public static final byte[] Kkkk = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    public static final byte[] Kkk = {68, 105, 97, 108, 111, 103, 117, 101, HttpTokens.COLON, 32, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ASSERTNOTTEST, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, HttpTokens.COLON, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ASSERTNOTTEST};

    /* renamed from: Kk */
    public static final UUID f4521Kk = new UUID(72057594037932032L, -9223371306706625679L);
    public long Wwwwwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwwwwww = -9223372036854775807L;
    public long Wwwwwwwwwwwwwwww = -9223372036854775807L;
    public long Wwwwwwwwwwwwwww = -9223372036854775807L;
    public long Wwwwwwwww = -1;
    public long Wwwwwwww = -1;
    public long Wwwwwww = -9223372036854775807L;

    /* renamed from: me.tvspark.q8$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[10];

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            }
        }
    }

    /* renamed from: me.tvspark.q8$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Kkkkkkkk;
        public AbstractC2740w7 Kkkkkkkkk;
        public boolean Kkkkkkkkkkkk;
        @Nullable
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkk;
        @Nullable
        public byte[] Kkkkkkkkkkkkkkkkkkk;
        public C2322l6 Wwwwwwwwwwwwwwwwwwwwwww;
        public byte[] Wwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww;
        public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwww = -1;
        public float Wwwwwwwwwwwwwwww = 0.0f;
        public float Wwwwwwwwwwwwwww = 0.0f;
        public float Wwwwwwwwwwwwww = 0.0f;
        public byte[] Wwwwwwwwwwwww = null;
        public int Wwwwwwwwwwww = -1;
        public boolean Wwwwwwwwwww = false;
        public int Wwwwwwwwww = -1;
        public int Wwwwwwwww = -1;
        public int Wwwwwwww = -1;
        public int Wwwwwww = 1000;
        public int Wwwwww = 200;
        public float Wwwww = -1.0f;
        public float Wwww = -1.0f;
        public float Www = -1.0f;
        public float Kkkkkkkkkkkkkkkkkkkkkkkkkk = -1.0f;
        public float Kkkkkkkkkkkkkkkkkkkkkkkkk = -1.0f;
        public float Kkkkkkkkkkkkkkkkkkkkkkkk = -1.0f;
        public float Kkkkkkkkkkkkkkkkkkkkkkk = -1.0f;
        public float Kkkkkkkkkkkkkkkkkkkkkk = -1.0f;
        public float Kkkkkkkkkkkkkkkkkkkkk = -1.0f;
        public float Kkkkkkkkkkkkkkkkkkkk = -1.0f;
        public int Kkkkkkkkkkkkkkkkkk = 1;
        public int Kkkkkkkkkkkkkkkkk = -1;
        public int Kkkkkkkkkkkkkkkk = WebIndicator.MAX_UNIFORM_SPEED_DURATION;
        public long Kkkkkkkkkkkkkkk = 0;
        public long Kkkkkkkkkkkkkk = 0;
        public boolean Kkkkkkkkkkk = true;
        public String Kkkkkkkkkk = "eng";

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    static {
        C2361m8 c2361m8 = C2361m8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        Illllllllllllllllllllllllllll = Collections.unmodifiableMap(hashMap);
    }

    public C2515q8(int i) {
        C2398n8 c2398n8 = new C2398n8();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2398n8;
        c2398n8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i & 1) == 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2589s8();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseArray<>();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(ByteBuffer.allocate(4).putInt(-1).array());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
        this.Wwwwwwwwwwwwwwwwwwwwwww = new C2078el(8);
        this.Wwwwwwwwwwwwwwwwwwwwww = new C2078el();
        this.Wwwwwwwwwwwwwwwwwwwww = new C2078el();
        this.Kkkkkkkkkkkkkkkkkkkkk = new int[1];
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2515q8(0)};
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, String str, long j2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - ((i * TimeUtils.SECONDS_PER_HOUR) * StopWatch.NANO_2_MILLIS);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - ((i2 * 60) * StopWatch.NANO_2_MILLIS);
        int i3 = (int) (j4 / StopWatch.NANO_2_MILLIS);
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * StopWatch.NANO_2_MILLIS)) / j2))));
    }

    public static int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, AbstractC2740w7 abstractC2740w7, int i) throws IOException {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > 0) {
            int min = Math.min(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww, min);
            return min;
        }
        return abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2752wj) abstractC2212i7, i, false);
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws ParserException {
        long j2 = this.Wwwwwwwwwwwwwwwww;
        if (j2 != -9223372036854775807L) {
            return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2, 1000L);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Kkkkkkkkkkkkkkk = 0;
        this.Kkkkkkkkkkkkkk = 0;
        this.Kkkkkkkkkkkkk = 0;
        this.Kkkkkkkkkkkk = false;
        this.Kkkkkkkkkkk = false;
        this.Kkkkkkkkkk = false;
        this.Kkkkkkkkk = 0;
        this.Kkkkkkkk = (byte) 0;
        this.Kkkkkkk = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    }

    @Override // me.tvspark.AbstractC2175h7
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Kkkkkk = abstractC2249j7;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, int i, int i2, int i3) {
        char c;
        byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i4;
        int i5;
        int i6 = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkk;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int i7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7 + 1;
                if (i7 == 0) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 16) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        } else {
            if (("S_TEXT/UTF8".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "S_TEXT/ASS".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) && this.Kkkkkkkkkkkkkkkkkkkkkk <= 1) {
                long j2 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
                if (j2 != -9223372036854775807L) {
                    String str = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int hashCode = str.hashCode();
                    if (hashCode != 738597099) {
                        if (hashCode == 1422270023 && str.equals("S_TEXT/UTF8")) {
                            c = 0;
                            if (c != 0) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, "%02d:%02d:%02d,%03d", 1000L);
                                i4 = 19;
                            } else if (c != 1) {
                                throw new IllegalArgumentException();
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, "%01d:%02d:%02d:%02d", 10000L);
                                i4 = 21;
                            }
                            System.arraycopy(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, bArr, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length);
                            AbstractC2740w7 abstractC2740w7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk;
                            C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                            abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            i5 = i2 + this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if ((268435456 & i6) != 0) {
                                if (this.Kkkkkkkkkkkkkkkkkkkkkk > 1) {
                                    i6 &= -268435457;
                                } else {
                                    C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwww;
                                    int i8 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2, i8, 2);
                                    i5 += i8;
                                }
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i6, i5, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        System.arraycopy(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, bArr, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length);
                        AbstractC2740w7 abstractC2740w72 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk;
                        C2078el c2078el3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        abstractC2740w72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3, c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i5 = i2 + this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if ((268435456 & i6) != 0) {
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i6, i5, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        if (str.equals("S_TEXT/ASS")) {
                            c = 1;
                            if (c != 0) {
                            }
                            System.arraycopy(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, bArr, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length);
                            AbstractC2740w7 abstractC2740w722 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk;
                            C2078el c2078el32 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                            abstractC2740w722.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el32, c2078el32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            i5 = i2 + this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if ((268435456 & i6) != 0) {
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i6, i5, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        System.arraycopy(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, bArr, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length);
                        AbstractC2740w7 abstractC2740w7222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk;
                        C2078el c2078el322 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        abstractC2740w7222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el322, c2078el322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i5 = i2 + this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if ((268435456 & i6) != 0) {
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i6, i5, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
            }
            i5 = i2;
            if ((268435456 & i6) != 0) {
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i6, i5, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww);
        }
        this.Www = true;
    }

    @Override // me.tvspark.AbstractC2175h7
    public final void release() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0005 A[SYNTHETIC] */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        boolean z;
        this.Www = false;
        boolean z2 = true;
        while (z2 && !this.Www) {
            z2 = ((C2398n8) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
            if (z2) {
                long position = abstractC2212i7.getPosition();
                if (this.Wwwwwwwwww) {
                    this.Wwwwwwww = position;
                    c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwww;
                    this.Wwwwwwwwww = false;
                } else {
                    if (this.Wwwwwwwwwwwww) {
                        long j = this.Wwwwwwww;
                        if (j != -1) {
                            c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                            this.Wwwwwwww = -1L;
                        }
                    }
                    z = false;
                    if (!z) {
                        return 1;
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
        if (!z2) {
            for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww valueAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.valueAt(i);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueAt.Kkkkkkkkkkkkk;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueAt);
                }
            }
            return -1;
        }
        return 0;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, int i) throws IOException {
        C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= i) {
            return;
        }
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr.length < i) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i)), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr2 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        abstractC2212i7.readFully(bArr2, i2, i - i2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // me.tvspark.AbstractC2175h7
    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        this.Wwwwwww = -9223372036854775807L;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = 0;
        C2398n8 c2398n8 = (C2398n8) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2398n8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        c2398n8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        C2589s8 c2589s8 = c2398n8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2589s8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        c2589s8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        C2589s8 c2589s82 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2589s82.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        c2589s82.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.valueAt(i).Kkkkkkkkkkkkk;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            }
        }
    }

    @Override // me.tvspark.AbstractC2175h7
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i;
        C2552r8 c2552r8 = new C2552r8();
        long length = abstractC2212i7.getLength();
        long j = 1024;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i2 != 0 && length <= 1024) {
            j = length;
        }
        int i3 = (int) j;
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4);
        c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
        for (long Wwwwwwwwwwwwwwwwwwwww = c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww(); Wwwwwwwwwwwwwwwwwwwww != 440786851; Wwwwwwwwwwwwwwwwwwwww = ((Wwwwwwwwwwwwwwwwwwwww << 8) & (-256)) | (c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] & 255)) {
            int i4 = c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            if (i4 == i3) {
                return false;
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 1);
        }
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
        long j2 = c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != Long.MIN_VALUE) {
            if (i2 != 0 && j2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 >= length) {
                return false;
            }
            while (true) {
                int i5 = (c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > (j2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) ? 1 : (c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == (j2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) ? 0 : -1));
                if (i5 >= 0) {
                    return i5 == 0;
                } else if (c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7) == Long.MIN_VALUE || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7)) < 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > 2147483647L) {
                    return false;
                } else {
                    if (i != 0) {
                        int i6 = (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                        c2552r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i6;
                    }
                }
            }
        } else {
            return false;
        }
    }

    /* renamed from: me.tvspark.q8$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2435o8 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:121:0x023f, code lost:
            throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, AbstractC2212i7 abstractC2212i7) throws IOException {
            long j;
            int i3;
            int i4;
            int[] iArr;
            C2515q8 c2515q8 = C2515q8.this;
            if (c2515q8 != null) {
                int i5 = 4;
                int i6 = 0;
                int i7 = 1;
                if (i != 161 && i != 163) {
                    if (i == 165) {
                        if (c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkkk != 2) {
                            return;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c2515q8.Kkkkkkkkkkkkkkkkkkkk);
                        if (c2515q8.Kkkkkkkkkkkkkkkkk != 4 || !"V_VP9".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                            return;
                        }
                        C2078el c2078el = c2515q8.Wwwwwwwwwwwwwwwwwwwww;
                        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (bArr.length < i2) {
                            bArr = new byte[i2];
                        }
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                        abstractC2212i7.readFully(c2515q8.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i2);
                        return;
                    } else if (i == 16877) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2515q8.Wwwwwwwwwwwwww;
                        int i8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (i8 != 1685485123 && i8 != 1685480259) {
                            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                            return;
                        }
                        byte[] bArr2 = new byte[i2];
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkkkk = bArr2;
                        abstractC2212i7.readFully(bArr2, 0, i2);
                        return;
                    } else if (i == 16981) {
                        byte[] bArr3 = new byte[i2];
                        c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = bArr3;
                        abstractC2212i7.readFully(bArr3, 0, i2);
                        return;
                    } else if (i == 18402) {
                        byte[] bArr4 = new byte[i2];
                        abstractC2212i7.readFully(bArr4, 0, i2);
                        c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, bArr4, 0, 0);
                        return;
                    } else if (i == 21419) {
                        Arrays.fill(c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (byte) 0);
                        abstractC2212i7.readFully(c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4 - i2, i2);
                        c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                        c2515q8.Wwwwwwwwwwww = (int) c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww();
                        return;
                    } else if (i == 25506) {
                        byte[] bArr5 = new byte[i2];
                        c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = bArr5;
                        abstractC2212i7.readFully(bArr5, 0, i2);
                        return;
                    } else if (i != 30322) {
                        throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(26, "Unexpected id: ", i));
                    } else {
                        byte[] bArr6 = new byte[i2];
                        c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwww = bArr6;
                        abstractC2212i7.readFully(bArr6, 0, i2);
                        return;
                    }
                }
                if (c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkkk == 0) {
                    c2515q8.Kkkkkkkkkkkkkkkkkkkk = (int) c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, false, true, 8);
                    c2515q8.Kkkkkkkkkkkkkkkkkkk = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkk = -9223372036854775807L;
                    c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkkk = 1;
                    c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c2515q8.Kkkkkkkkkkkkkkkkkkkk);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 - c2515q8.Kkkkkkkkkkkkkkkkkkk);
                    c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkkk = 0;
                    return;
                }
                if (c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkkk == 1) {
                    c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, 3);
                    int i9 = (c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] & 6) >> 1;
                    byte b = 255;
                    if (i9 == 0) {
                        c2515q8.Kkkkkkkkkkkkkkkkkkkkkk = 1;
                        int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2515q8.Kkkkkkkkkkkkkkkkkkkkk, 1);
                        c2515q8.Kkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] = (i2 - c2515q8.Kkkkkkkkkkkkkkkkkkk) - 3;
                    } else {
                        c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, 4);
                        int i10 = (c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[3] & 255) + 1;
                        c2515q8.Kkkkkkkkkkkkkkkkkkkkkk = i10;
                        int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2515q8.Kkkkkkkkkkkkkkkkkkkkk, i10);
                        c2515q8.Kkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        if (i9 == 2) {
                            int i11 = c2515q8.Kkkkkkkkkkkkkkkkkkkkkk;
                            Arrays.fill(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, i11, ((i2 - c2515q8.Kkkkkkkkkkkkkkkkkkk) - 4) / i11);
                        } else if (i9 == 1) {
                            int i12 = 0;
                            int i13 = 0;
                            while (true) {
                                i3 = c2515q8.Kkkkkkkkkkkkkkkkkkkkkk;
                                if (i12 >= i3 - 1) {
                                    break;
                                }
                                c2515q8.Kkkkkkkkkkkkkkkkkkkkk[i12] = 0;
                                do {
                                    i5++;
                                    c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, i5);
                                    i4 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5 - 1] & 255;
                                    iArr = c2515q8.Kkkkkkkkkkkkkkkkkkkkk;
                                    iArr[i12] = iArr[i12] + i4;
                                } while (i4 == 255);
                                i13 += iArr[i12];
                                i12++;
                            }
                            c2515q8.Kkkkkkkkkkkkkkkkkkkkk[i3 - 1] = ((i2 - c2515q8.Kkkkkkkkkkkkkkkkkkk) - i5) - i13;
                        } else if (i9 != 3) {
                            throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(36, "Unexpected lacing value: ", i9));
                        } else {
                            int i14 = 0;
                            int i15 = 0;
                            while (true) {
                                int i16 = c2515q8.Kkkkkkkkkkkkkkkkkkkkkk;
                                if (i14 >= i16 - 1) {
                                    c2515q8.Kkkkkkkkkkkkkkkkkkkkk[i16 - 1] = ((i2 - c2515q8.Kkkkkkkkkkkkkkkkkkk) - i5) - i15;
                                    break;
                                }
                                c2515q8.Kkkkkkkkkkkkkkkkkkkkk[i14] = i6;
                                i5++;
                                c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, i5);
                                int i17 = i5 - 1;
                                if (c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i17] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                int i18 = 0;
                                while (true) {
                                    if (i18 >= 8) {
                                        j = 0;
                                        break;
                                    }
                                    int i19 = i7 << (7 - i18);
                                    if ((c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i17] & i19) != 0) {
                                        i5 += i18;
                                        c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, i5);
                                        long j2 = (~i19) & c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i17] & b;
                                        j = j2;
                                        for (int i20 = i17 + 1; i20 < i5; i20++) {
                                            j = (j << 8) | (c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i20] & b);
                                            b = 255;
                                        }
                                        if (i14 > 0) {
                                            j -= (1 << ((i18 * 7) + 6)) - 1;
                                        }
                                    } else {
                                        i18++;
                                        b = 255;
                                        i7 = 1;
                                    }
                                }
                                if (j < -2147483648L || j > 2147483647L) {
                                    break;
                                }
                                int i21 = (int) j;
                                int[] iArr2 = c2515q8.Kkkkkkkkkkkkkkkkkkkkk;
                                if (i14 != 0) {
                                    i21 += iArr2[i14 - 1];
                                }
                                iArr2[i14] = i21;
                                i15 += c2515q8.Kkkkkkkkkkkkkkkkkkkkk[i14];
                                i14++;
                                b = 255;
                                i6 = 0;
                                i7 = 1;
                            }
                        }
                    }
                    byte[] bArr7 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkk = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((bArr7[1] & 255) | (bArr7[0] << 8)) + c2515q8.Wwwwwww;
                    c2515q8.Kkkkkkkkkkkkkkkkkk = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 || (i == 163 && (c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] & 128) == 128)) ? 1 : 0;
                    c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkkk = 2;
                    c2515q8.Kkkkkkkkkkkkkkkkkkkkkkk = 0;
                }
                if (i == 163) {
                    while (true) {
                        int i22 = c2515q8.Kkkkkkkkkkkkkkkkkkkkkkk;
                        if (i22 >= c2515q8.Kkkkkkkkkkkkkkkkkkkkkk) {
                            c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkkk = 0;
                            return;
                        } else {
                            c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, ((c2515q8.Kkkkkkkkkkkkkkkkkkkkkkk * wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / 1000) + c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkkk, c2515q8.Kkkkkkkkkkkkkkkkkk, c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, c2515q8.Kkkkkkkkkkkkkkkkkkkkk[i22]), 0);
                            c2515q8.Kkkkkkkkkkkkkkkkkkkkkkk++;
                        }
                    }
                } else {
                    while (true) {
                        int i23 = c2515q8.Kkkkkkkkkkkkkkkkkkkkkkk;
                        if (i23 >= c2515q8.Kkkkkkkkkkkkkkkkkkkkkk) {
                            return;
                        }
                        int[] iArr3 = c2515q8.Kkkkkkkkkkkkkkkkkkkkk;
                        iArr3[i23] = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, iArr3[i23]);
                        c2515q8.Kkkkkkkkkkkkkkkkkkkkkkk++;
                    }
                }
            } else {
                throw null;
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, double d) throws ParserException {
            C2515q8 c2515q8 = C2515q8.this;
            if (c2515q8 != null) {
                if (i == 181) {
                    c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkk = (int) d;
                    return;
                } else if (i == 17545) {
                    c2515q8.Wwwwwwwwwwwwwwww = (long) d;
                    return;
                } else {
                    switch (i) {
                        case 21969:
                            c2515q8.Wwwwwwwwwwwwww.Wwwww = (float) d;
                            return;
                        case 21970:
                            c2515q8.Wwwwwwwwwwwwww.Wwww = (float) d;
                            return;
                        case 21971:
                            c2515q8.Wwwwwwwwwwwwww.Www = (float) d;
                            return;
                        case 21972:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkkk = (float) d;
                            return;
                        case 21973:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkk = (float) d;
                            return;
                        case 21974:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkk = (float) d;
                            return;
                        case 21975:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkk = (float) d;
                            return;
                        case 21976:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkk = (float) d;
                            return;
                        case 21977:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkk = (float) d;
                            return;
                        case 21978:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkk = (float) d;
                            return;
                        default:
                            switch (i) {
                                case 30323:
                                    c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = (float) d;
                                    return;
                                case 30324:
                                    c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwww = (float) d;
                                    return;
                                case 30325:
                                    c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwww = (float) d;
                                    return;
                                default:
                                    return;
                            }
                    }
                }
            }
            throw null;
        }

        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            if (C2515q8.this != null) {
                switch (i) {
                    case Token.LABEL /* 131 */:
                    case Token.JSR /* 136 */:
                    case 155:
                    case Token.LETEXPR /* 159 */:
                    case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
                    case 179:
                    case NormalCmdFactory.TASK_RESTART /* 186 */:
                    case TbsListener.ErrorCode.COPY_EXCEPTION /* 215 */:
                    case TbsListener.ErrorCode.RENAME_FAIL /* 231 */:
                    case TbsListener.ErrorCode.TPATCH_FAIL /* 238 */:
                    case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /* 241 */:
                    case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
                    case 16871:
                    case 16980:
                    case 17029:
                    case 17143:
                    case 18401:
                    case 18408:
                    case 20529:
                    case 20530:
                    case 21420:
                    case 21432:
                    case 21680:
                    case 21682:
                    case 21690:
                    case 21930:
                    case 21945:
                    case 21946:
                    case 21947:
                    case 21948:
                    case 21949:
                    case 21998:
                    case 22186:
                    case 22203:
                    case 25188:
                    case 30321:
                    case 2352003:
                    case 2807729:
                        return 2;
                    case Token.EXPR_VOID /* 134 */:
                    case 17026:
                    case 21358:
                    case 2274716:
                        return 3;
                    case 160:
                    case 166:
                    case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
                    case 183:
                    case 187:
                    case TbsListener.ErrorCode.EXCEED_INCR_UPDATE /* 224 */:
                    case TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR /* 225 */:
                    case 16868:
                    case 18407:
                    case 19899:
                    case 20532:
                    case 20533:
                    case 21936:
                    case 21968:
                    case 25152:
                    case 28032:
                    case 30113:
                    case 30320:
                    case 290298740:
                    case 357149030:
                    case 374648427:
                    case 408125543:
                    case 440786851:
                    case 475249515:
                    case 524531317:
                        return 1;
                    case 161:
                    case 163:
                    case 165:
                    case 16877:
                    case 16981:
                    case 18402:
                    case 21419:
                    case 25506:
                    case 30322:
                        return 4;
                    case 181:
                    case 17545:
                    case 21969:
                    case 21970:
                    case 21971:
                    case 21972:
                    case 21973:
                    case 21974:
                    case 21975:
                    case 21976:
                    case 21977:
                    case 21978:
                    case 30323:
                    case 30324:
                    case 30325:
                        return 5;
                    default:
                        return 0;
                }
            }
            throw null;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) throws ParserException {
            C2515q8 c2515q8 = C2515q8.this;
            if (c2515q8 != null) {
                if (i == 20529) {
                    if (j == 0) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder(55);
                    sb.append("ContentEncodingOrder ");
                    sb.append(j);
                    sb.append(" not supported");
                    throw new ParserException(sb.toString());
                } else if (i == 20530) {
                    if (j == 1) {
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder(55);
                    sb2.append("ContentEncodingScope ");
                    sb2.append(j);
                    sb2.append(" not supported");
                    throw new ParserException(sb2.toString());
                } else {
                    boolean z = false;
                    switch (i) {
                        case Token.LABEL /* 131 */:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case Token.JSR /* 136 */:
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2515q8.Wwwwwwwwwwwwww;
                            if (j == 1) {
                                z = true;
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkk = z;
                            return;
                        case 155:
                            c2515q8.Kkkkkkkkkkkkkkkkkkkkkkkk = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                            return;
                        case Token.LETEXPR /* 159 */:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkk = (int) j;
                            return;
                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case 179:
                            c2515q8.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j));
                            return;
                        case NormalCmdFactory.TASK_RESTART /* 186 */:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case TbsListener.ErrorCode.COPY_EXCEPTION /* 215 */:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case TbsListener.ErrorCode.RENAME_FAIL /* 231 */:
                            c2515q8.Wwwwwww = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                            return;
                        case TbsListener.ErrorCode.TPATCH_FAIL /* 238 */:
                            c2515q8.Kkkkkkkkkkkkkkkkk = (int) j;
                            return;
                        case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /* 241 */:
                            if (c2515q8.Wwww) {
                                return;
                            }
                            c2515q8.Wwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                            c2515q8.Wwww = true;
                            return;
                        case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
                            c2515q8.Kkkkkkkkkkkkkkkk = true;
                            return;
                        case 16871:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case 16980:
                            if (j == 3) {
                                return;
                            }
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("ContentCompAlgo ");
                            sb3.append(j);
                            sb3.append(" not supported");
                            throw new ParserException(sb3.toString());
                        case 17029:
                            if (j >= 1 && j <= 2) {
                                return;
                            }
                            StringBuilder sb4 = new StringBuilder(53);
                            sb4.append("DocTypeReadVersion ");
                            sb4.append(j);
                            sb4.append(" not supported");
                            throw new ParserException(sb4.toString());
                        case 17143:
                            if (j == 1) {
                                return;
                            }
                            StringBuilder sb5 = new StringBuilder(50);
                            sb5.append("EBMLReadVersion ");
                            sb5.append(j);
                            sb5.append(" not supported");
                            throw new ParserException(sb5.toString());
                        case 18401:
                            if (j == 5) {
                                return;
                            }
                            StringBuilder sb6 = new StringBuilder(49);
                            sb6.append("ContentEncAlgo ");
                            sb6.append(j);
                            sb6.append(" not supported");
                            throw new ParserException(sb6.toString());
                        case 18408:
                            if (j == 1) {
                                return;
                            }
                            StringBuilder sb7 = new StringBuilder(56);
                            sb7.append("AESSettingsCipherMode ");
                            sb7.append(j);
                            sb7.append(" not supported");
                            throw new ParserException(sb7.toString());
                        case 21420:
                            c2515q8.Wwwwwwwwwww = j + c2515q8.Wwwwwwwwwwwwwwwwww;
                            return;
                        case 21432:
                            int i2 = (int) j;
                            if (i2 == 0) {
                                c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwww = 0;
                                return;
                            } else if (i2 == 1) {
                                c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwww = 2;
                                return;
                            } else if (i2 == 3) {
                                c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwww = 1;
                                return;
                            } else if (i2 != 15) {
                                return;
                            } else {
                                c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwww = 3;
                                return;
                            }
                        case 21680:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case 21682:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case 21690:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case 21930:
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2515q8.Wwwwwwwwwwwwww;
                            if (j == 1) {
                                z = true;
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkk = z;
                            return;
                        case 21998:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case 22186:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkk = j;
                            return;
                        case 22203:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkk = j;
                            return;
                        case 25188:
                            c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkk = (int) j;
                            return;
                        case 30321:
                            int i3 = (int) j;
                            if (i3 == 0) {
                                c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = 0;
                                return;
                            } else if (i3 == 1) {
                                c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = 1;
                                return;
                            } else if (i3 == 2) {
                                c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = 2;
                                return;
                            } else if (i3 != 3) {
                                return;
                            } else {
                                c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww = 3;
                                return;
                            }
                        case 2352003:
                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) j;
                            return;
                        case 2807729:
                            c2515q8.Wwwwwwwwwwwwwwwww = j;
                            return;
                        default:
                            switch (i) {
                                case 21945:
                                    int i4 = (int) j;
                                    if (i4 == 1) {
                                        c2515q8.Wwwwwwwwwwwwww.Wwwwwwww = 2;
                                        return;
                                    } else if (i4 != 2) {
                                        return;
                                    } else {
                                        c2515q8.Wwwwwwwwwwwwww.Wwwwwwww = 1;
                                        return;
                                    }
                                case 21946:
                                    int i5 = (int) j;
                                    if (i5 != 1) {
                                        if (i5 == 16) {
                                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwww = 6;
                                            return;
                                        } else if (i5 == 18) {
                                            c2515q8.Wwwwwwwwwwwwww.Wwwwwwwww = 7;
                                            return;
                                        } else if (i5 != 6 && i5 != 7) {
                                            return;
                                        }
                                    }
                                    c2515q8.Wwwwwwwwwwwwww.Wwwwwwwww = 3;
                                    return;
                                case 21947:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2515q8.Wwwwwwwwwwwwww;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwww = true;
                                    int i6 = (int) j;
                                    if (i6 == 1) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwww = 1;
                                        return;
                                    } else if (i6 == 9) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwww = 6;
                                        return;
                                    } else if (i6 != 4 && i6 != 5 && i6 != 6 && i6 != 7) {
                                        return;
                                    } else {
                                        c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwww = 2;
                                        return;
                                    }
                                case 21948:
                                    c2515q8.Wwwwwwwwwwwwww.Wwwwwww = (int) j;
                                    return;
                                case 21949:
                                    c2515q8.Wwwwwwwwwwwwww.Wwwwww = (int) j;
                                    return;
                                default:
                                    return;
                            }
                    }
                }
            }
            throw null;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) throws ParserException {
            C2515q8 c2515q8 = C2515q8.this;
            if (c2515q8 != null) {
                if (i == 160) {
                    c2515q8.Kkkkkkkkkkkkkkkk = false;
                    return;
                } else if (i == 174) {
                    c2515q8.Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
                    return;
                } else if (i == 187) {
                    c2515q8.Wwww = false;
                    return;
                } else if (i == 19899) {
                    c2515q8.Wwwwwwwwwwww = -1;
                    c2515q8.Wwwwwwwwwww = -1L;
                    return;
                } else if (i == 20533) {
                    c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    return;
                } else if (i == 21968) {
                    c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwww = true;
                    return;
                } else if (i == 408125543) {
                    long j3 = c2515q8.Wwwwwwwwwwwwwwwwww;
                    if (j3 != -1 && j3 != j) {
                        throw new ParserException("Multiple Segment elements not supported");
                    }
                    c2515q8.Wwwwwwwwwwwwwwwwww = j;
                    c2515q8.Wwwwwwwwwwwwwwwwwww = j2;
                    return;
                } else if (i == 475249515) {
                    c2515q8.Wwwwww = new C2864zk();
                    c2515q8.Wwwww = new C2864zk();
                    return;
                } else if (i != 524531317 || c2515q8.Wwwwwwwwwwwww) {
                    return;
                } else {
                    if (c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2515q8.Wwwwwwwww != -1) {
                        c2515q8.Wwwwwwwwww = true;
                        return;
                    }
                    c2515q8.Kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2515q8.Wwwwwwwwwwwwwww, 0L));
                    c2515q8.Wwwwwwwwwwwww = true;
                    return;
                }
            }
            throw null;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) throws ParserException {
            C2515q8 c2515q8 = C2515q8.this;
            if (c2515q8 != null) {
                if (i == 134) {
                    c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                    return;
                } else if (i != 17026) {
                    if (i == 21358) {
                        c2515q8.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                        return;
                    } else if (i != 2274716) {
                        return;
                    } else {
                        c2515q8.Wwwwwwwwwwwwww.Kkkkkkkkkk = str;
                        return;
                    }
                } else if ("webm".equals(str) || "matroska".equals(str)) {
                    return;
                } else {
                    StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 22));
                    sb.append("DocType ");
                    sb.append(str);
                    sb.append(" not supported");
                    throw new ParserException(sb.toString());
                }
            }
            throw null;
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i) throws IOException {
        int i2;
        int i3;
        if ("S_TEXT/UTF8".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, Kkkkk, i);
            int i4 = this.Kkkkkkkkkkkkkk;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return i4;
        } else if ("S_TEXT/ASS".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, Kkk, i);
            int i5 = this.Kkkkkkkkkkkkkk;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return i5;
        } else {
            AbstractC2740w7 abstractC2740w7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkk;
            char c = '\b';
            if (!this.Kkkkkkkkkkkk) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Kkkkkkkkkkkkkkkkkk &= -1073741825;
                    int i6 = 128;
                    if (!this.Kkkkkkkkkkk) {
                        abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 1);
                        this.Kkkkkkkkkkkkkkk++;
                        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if ((bArr[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.Kkkkkkkk = bArr[0];
                        this.Kkkkkkkkkkk = true;
                    }
                    if ((this.Kkkkkkkk & 1) == 1) {
                        boolean z = (this.Kkkkkkkk & 2) == 2;
                        this.Kkkkkkkkkkkkkkkkkk |= 1073741824;
                        if (!this.Kkkkkkk) {
                            abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 8);
                            this.Kkkkkkkkkkkkkkk += 8;
                            this.Kkkkkkk = true;
                            byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (!z) {
                                i6 = 0;
                            }
                            bArr2[0] = (byte) (i6 | 8);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                            abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, 1);
                            this.Kkkkkkkkkkkkkk++;
                            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                            abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, 8, 1);
                            this.Kkkkkkkkkkkkkk += 8;
                        }
                        if (z) {
                            if (!this.Kkkkkkkkkk) {
                                abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 1);
                                this.Kkkkkkkkkkkkkkk++;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                                this.Kkkkkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
                                this.Kkkkkkkkkk = true;
                            }
                            int i7 = this.Kkkkkkkkk * 4;
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7);
                            abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i7);
                            this.Kkkkkkkkkkkkkkk += i7;
                            short s = (short) ((this.Kkkkkkkkk / 2) + 1);
                            int i8 = (s * 6) + 2;
                            ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwww;
                            if (byteBuffer == null || byteBuffer.capacity() < i8) {
                                this.Wwwwwwwwwwwwwwwwwwww = ByteBuffer.allocate(i8);
                            }
                            this.Wwwwwwwwwwwwwwwwwwww.position(0);
                            this.Wwwwwwwwwwwwwwwwwwww.putShort(s);
                            int i9 = 0;
                            int i10 = 0;
                            while (true) {
                                i3 = this.Kkkkkkkkk;
                                if (i9 >= i3) {
                                    break;
                                }
                                int Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
                                if (i9 % 2 == 0) {
                                    this.Wwwwwwwwwwwwwwwwwwww.putShort((short) (Wwwwwwwwwwwwwwwwwww - i10));
                                } else {
                                    this.Wwwwwwwwwwwwwwwwwwww.putInt(Wwwwwwwwwwwwwwwwwww - i10);
                                }
                                i9++;
                                i10 = Wwwwwwwwwwwwwwwwwww;
                            }
                            int i11 = (i - this.Kkkkkkkkkkkkkkk) - i10;
                            int i12 = i3 % 2;
                            ByteBuffer byteBuffer2 = this.Wwwwwwwwwwwwwwwwwwww;
                            if (i12 == 1) {
                                byteBuffer2.putInt(i11);
                            } else {
                                byteBuffer2.putShort((short) i11);
                                this.Wwwwwwwwwwwwwwwwwwww.putInt(0);
                            }
                            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww.array(), i8);
                            abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, i8, 1);
                            this.Kkkkkkkkkkkkkk += i8;
                        }
                    }
                } else {
                    byte[] bArr3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (bArr3 != null) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr3, bArr3.length);
                    }
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                    this.Kkkkkkkkkkkkkkkkkk |= 268435456;
                    this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    byte[] bArr4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    bArr4[0] = (byte) ((i >> 24) & 255);
                    bArr4[1] = (byte) ((i >> 16) & 255);
                    bArr4[2] = (byte) ((i >> 8) & 255);
                    bArr4[3] = (byte) (i & 255);
                    abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, 4, 2);
                    this.Kkkkkkkkkkkkkk += 4;
                }
                this.Kkkkkkkkkkkk = true;
            }
            int i13 = i + this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!"V_MPEG4/ISO/AVC".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"V_MPEGH/ISO/HEVC".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkk != null) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkk;
                    if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        byte[] bArr5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (bArr5[4] == -8 && bArr5[5] == 114 && bArr5[6] == 111 && (bArr5[7] & ExifInterface.MARKER_COM) == 186) {
                            if ((bArr5[7] & 255) == 187) {
                                c = '\t';
                            }
                            i2 = 40 << ((bArr5[c] >> 4) & 7);
                        } else {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        }
                    }
                }
                while (true) {
                    int i14 = this.Kkkkkkkkkkkkkkk;
                    if (i14 >= i13) {
                        break;
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, abstractC2740w7, i13 - i14);
                    this.Kkkkkkkkkkkkkkk += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    this.Kkkkkkkkkkkkkk += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            } else {
                byte[] bArr6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                bArr6[0] = 0;
                bArr6[1] = 0;
                bArr6[2] = 0;
                int i15 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkk;
                int i16 = 4 - i15;
                while (this.Kkkkkkkkkkkkkkk < i13) {
                    int i17 = this.Kkkkkkkkkkkkk;
                    if (i17 == 0) {
                        int min = Math.min(i15, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        abstractC2212i7.readFully(bArr6, i16 + min, i15 - min);
                        if (min > 0) {
                            C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                            System.arraycopy(c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr6, i16, min);
                            c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += min;
                        }
                        this.Kkkkkkkkkkkkkkk += i15;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                        this.Kkkkkkkkkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                        abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4);
                        this.Kkkkkkkkkkkkkk += 4;
                    } else {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, abstractC2740w7, i17);
                        this.Kkkkkkkkkkkkkkk += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        this.Kkkkkkkkkkkkkk += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        this.Kkkkkkkkkkkkk -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    }
                }
            }
            if ("A_VORBIS".equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 4);
                this.Kkkkkkkkkkkkkk += 4;
            }
            int i18 = this.Kkkkkkkkkkkkkk;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return i18;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr2.length < length) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr.length, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length);
    }
}
