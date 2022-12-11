package me.tvspark;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import com.p046uc.crashsdk.export.LogType;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC2116fm;
import me.tvspark.C1988cm;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.server.AsyncContinuation;
import org.eclipse.jetty.util.B64Code;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;
import org.mozilla.javascript.Token;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* renamed from: me.tvspark.am */
/* loaded from: classes4.dex */
public class C1914am extends MediaCodecRenderer {
    public static boolean Ooooooooo;
    public static boolean Oooooooooo;
    @Nullable
    public static final Method Ooooooooooo;

    /* renamed from: Ss */
    public static final int[] f4511Ss = {1920, 1600, 1440, LogType.UNEXP_ANR, 960, 854, 640, 540, 480};
    public final C1988cm IIl;
    public final Context IIll;

    /* renamed from: O0 */
    public Surface f4512O0;
    public float O00;
    public Surface O000;
    public boolean O0000;
    public boolean O00000;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww O000000;
    public final int O00000000;
    public final long O000000000;
    public final AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww O0000000000;
    public int OO0;
    public long OO00;
    public long OO0000;
    public boolean OO00000;
    public boolean OO000000;
    public boolean OO0000000;
    public boolean OO000000000;
    public int QQOO;
    public int QQOOOOO;
    public long QQOOOOOO;
    public long QQOOOOOOO;
    public int QQOOOOOOOO;
    public int QQOOOOOOOOO;
    @Nullable
    public AbstractC1951bm Sss;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Ssss;
    public int Sssss;
    public boolean Ssssss;
    public float Sssssss;
    public int Ssssssss;
    public int Sssssssss;
    public int Ssssssssss;
    public float Sssssssssss;
    public final boolean O0000000 = "NVIDIA".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    public long OO000 = -9223372036854775807L;
    public int QQOOOO = -1;
    public int QQOOO = -1;
    public float QQO = -1.0f;
    public int OO00000000 = 1;

    @RequiresApi(23)
    /* renamed from: me.tvspark.am$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements MediaCodec.OnFrameRenderedListener, Handler.Callback {
        public final Handler Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec mediaCodec) {
            Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Handler.Callback) this);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            mediaCodec.setOnFrameRenderedListener(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            C1914am c1914am = C1914am.this;
            if (this != c1914am.Ssss) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                c1914am.f555Il = true;
                return;
            }
            try {
                c1914am.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            } catch (ExoPlaybackException e) {
                C1914am.this.IIllllllll = e;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1) << 32) | C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg2));
            return true;
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 30) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.sendMessageAtFrontOfQueue(Message.obtain(this.Wwwwwwwwwwwwwwwwwwwwwwww, 0, (int) (j >> 32), (int) j));
        }
    }

    /* renamed from: me.tvspark.am$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        }
    }

    static {
        Method method;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 30) {
            try {
                method = Surface.class.getMethod("setFrameRate", Float.TYPE, Integer.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            Ooooooooooo = method;
        }
        method = null;
        Ooooooooooo = method;
    }

    public C1914am(Context context, AbstractC2143gc abstractC2143gc, long j, boolean z, @Nullable Handler handler, @Nullable AbstractC2116fm abstractC2116fm, int i) {
        super(2, abstractC2143gc, z, 30.0f);
        this.O000000000 = j;
        this.O00000000 = i;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.IIll = origApplicationContext;
        this.IIl = new C1988cm(origApplicationContext);
        this.O0000000000 = new AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler, abstractC2116fm);
        Kkkkkkkkkkkkkkkkkkkkk();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x042b, code lost:
        if (r0.equals("deb") != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Kkkkkkkkkkkkkk() {
        char c;
        char c2 = 28;
        char c3 = 65535;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 28) {
            String str = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            switch (str.hashCode()) {
                case -1339091551:
                    if (str.equals("dangal")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1220081023:
                    if (str.equals("dangalFHD")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1220066608:
                    if (str.equals("dangalUHD")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -64886864:
                    if (str.equals("magnolia")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 825323514:
                    if (str.equals("machuca")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0 || c == 1 || c == 2 || c == 3 || c == 4) {
                return true;
            }
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 27 || !"HWEML".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 26) {
                String str2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                switch (str2.hashCode()) {
                    case -2144781245:
                        if (str2.equals("GIONEE_SWW1609")) {
                            c2 = '6';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2144781185:
                        if (str2.equals("GIONEE_SWW1627")) {
                            c2 = '7';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2144781160:
                        if (str2.equals("GIONEE_SWW1631")) {
                            c2 = '8';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2097309513:
                        if (str2.equals("K50a40")) {
                            c2 = 'J';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2022874474:
                        if (str2.equals("CP8676_I02")) {
                            c2 = 22;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1978993182:
                        if (str2.equals("NX541J")) {
                            c2 = 'Y';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1978990237:
                        if (str2.equals("NX573J")) {
                            c2 = 'Z';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1936688988:
                        if (str2.equals("PGN528")) {
                            c2 = 'e';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1936688066:
                        if (str2.equals("PGN610")) {
                            c2 = 'f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1936688065:
                        if (str2.equals("PGN611")) {
                            c2 = 'g';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1931988508:
                        if (str2.equals("AquaPowerM")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1885099851:
                        if (str2.equals("RAIJIN")) {
                            c2 = 't';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1696512866:
                        if (str2.equals("XT1663")) {
                            c2 = 137;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1680025915:
                        if (str2.equals("ComioS1")) {
                            c2 = 21;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1615810839:
                        if (str2.equals("Phantom6")) {
                            c2 = 'h';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1600724499:
                        if (str2.equals("pacificrim")) {
                            c2 = '_';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1554255044:
                        if (str2.equals("vernee_M5")) {
                            c2 = 130;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1481772737:
                        if (str2.equals("panell_dl")) {
                            c2 = 'a';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1481772730:
                        if (str2.equals("panell_ds")) {
                            c2 = 'b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1481772729:
                        if (str2.equals("panell_dt")) {
                            c2 = 'c';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1320080169:
                        if (str2.equals("GiONEE_GBL7319")) {
                            c2 = '4';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1217592143:
                        if (str2.equals("BRAVIA_ATV2")) {
                            c2 = 18;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1180384755:
                        if (str2.equals("iris60")) {
                            c2 = 'F';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1139198265:
                        if (str2.equals("Slate_Pro")) {
                            c2 = 'v';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1052835013:
                        if (str2.equals("namath")) {
                            c2 = 'W';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -993250464:
                        if (str2.equals("A10-70F")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -993250458:
                        if (str2.equals("A10-70L")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -965403638:
                        if (str2.equals("s905x018")) {
                            c2 = 'x';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -958336948:
                        if (str2.equals("ELUGA_Ray_X")) {
                            c2 = '\"';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -879245230:
                        if (str2.equals("tcl_eu")) {
                            c2 = '~';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -842500323:
                        if (str2.equals("nicklaus_f")) {
                            c2 = 'X';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -821392978:
                        if (str2.equals("A7000-a")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -797483286:
                        if (str2.equals("SVP-DTV15")) {
                            c2 = 'w';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -794946968:
                        if (str2.equals("watson")) {
                            c2 = 131;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -788334647:
                        if (str2.equals("whyred")) {
                            c2 = 132;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -782144577:
                        if (str2.equals("OnePlus5T")) {
                            c2 = '[';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -575125681:
                        if (str2.equals("GiONEE_CBL7513")) {
                            c2 = '3';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -521118391:
                        if (str2.equals("GIONEE_GBL7360")) {
                            c2 = '5';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -430914369:
                        if (str2.equals("Pixi4-7_3G")) {
                            c2 = 'i';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -290434366:
                        if (str2.equals("taido_row")) {
                            c2 = 'y';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -282781963:
                        if (str2.equals("BLACK-1X")) {
                            c2 = 17;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -277133239:
                        if (str2.equals("Z12_PRO")) {
                            c2 = 138;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -173639913:
                        if (str2.equals("ELUGA_A3_Pro")) {
                            c2 = 31;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -56598463:
                        if (str2.equals("woods_fn")) {
                            c2 = 134;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2126:
                        if (str2.equals("C1")) {
                            c2 = 20;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2564:
                        if (str2.equals("Q5")) {
                            c2 = 'q';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2715:
                        if (str2.equals("V1")) {
                            c2 = 127;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2719:
                        if (str2.equals("V5")) {
                            c2 = 129;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3091:
                        if (str2.equals("b5")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3483:
                        if (str2.equals("mh")) {
                            c2 = 'T';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 73405:
                        if (str2.equals("JGZ")) {
                            c2 = 'I';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 75537:
                        if (str2.equals("M04")) {
                            c2 = 'O';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 75739:
                        if (str2.equals("M5c")) {
                            c2 = 'P';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 76779:
                        if (str2.equals("MX6")) {
                            c2 = 'V';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 78669:
                        if (str2.equals("P85")) {
                            c2 = '^';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 79305:
                        if (str2.equals("PLE")) {
                            c2 = 'k';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 80618:
                        if (str2.equals("QX1")) {
                            c2 = 's';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 88274:
                        if (str2.equals("Z80")) {
                            c2 = 139;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 98846:
                        if (str2.equals("cv1")) {
                            c2 = JSONLexer.EOI;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 98848:
                        if (str2.equals("cv3")) {
                            c2 = 27;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 99329:
                        break;
                    case 101481:
                        if (str2.equals("flo")) {
                            c2 = '1';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1513190:
                        if (str2.equals("1601")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1514184:
                        if (str2.equals("1713")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1514185:
                        if (str2.equals("1714")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2133089:
                        if (str2.equals("F01H")) {
                            c2 = '$';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2133091:
                        if (str2.equals("F01J")) {
                            c2 = '%';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2133120:
                        if (str2.equals("F02H")) {
                            c2 = '&';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2133151:
                        if (str2.equals("F03H")) {
                            c2 = ExtendedMessageFormat.QUOTE;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2133182:
                        if (str2.equals("F04H")) {
                            c2 = '(';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2133184:
                        if (str2.equals("F04J")) {
                            c2 = ')';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2436959:
                        if (str2.equals("P681")) {
                            c2 = ']';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2463773:
                        if (str2.equals("Q350")) {
                            c2 = 'm';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2464648:
                        if (str2.equals("Q427")) {
                            c2 = 'o';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2689555:
                        if (str2.equals("XE2X")) {
                            c2 = 136;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3154429:
                        if (str2.equals("fugu")) {
                            c2 = '2';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3284551:
                        if (str2.equals("kate")) {
                            c2 = 'K';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3351335:
                        if (str2.equals("mido")) {
                            c2 = 'U';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3386211:
                        if (str2.equals("p212")) {
                            c2 = '\\';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 41325051:
                        if (str2.equals("MEIZU_M5")) {
                            c2 = 'S';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 51349633:
                        if (str2.equals("601LV")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 51350594:
                        if (str2.equals("602LV")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 55178625:
                        if (str2.equals("Aura_Note_2")) {
                            c2 = 15;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 61542055:
                        if (str2.equals("A1601")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 65355429:
                        if (str2.equals("E5643")) {
                            c2 = 30;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66214468:
                        if (str2.equals("F3111")) {
                            c2 = '*';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66214470:
                        if (str2.equals("F3113")) {
                            c2 = '+';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66214473:
                        if (str2.equals("F3116")) {
                            c2 = ',';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66215429:
                        if (str2.equals("F3211")) {
                            c2 = '-';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66215431:
                        if (str2.equals("F3213")) {
                            c2 = '.';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66215433:
                        if (str2.equals("F3215")) {
                            c2 = '/';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66216390:
                        if (str2.equals("F3311")) {
                            c2 = '0';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 76402249:
                        if (str2.equals("PRO7S")) {
                            c2 = 'l';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 76404105:
                        if (str2.equals("Q4260")) {
                            c2 = 'n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 76404911:
                        if (str2.equals("Q4310")) {
                            c2 = 'p';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 80963634:
                        if (str2.equals("V23GB")) {
                            c2 = 128;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 82882791:
                        if (str2.equals("X3_HK")) {
                            c2 = 135;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 98715550:
                        if (str2.equals("i9031")) {
                            c2 = 'C';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 101370885:
                        if (str2.equals("l5460")) {
                            c2 = 'L';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 102844228:
                        if (str2.equals("le_x6")) {
                            c2 = 'M';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 165221241:
                        if (str2.equals("A2016a40")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 182191441:
                        if (str2.equals("CPY83_I00")) {
                            c2 = 25;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 245388979:
                        if (str2.equals("marino_f")) {
                            c2 = 'R';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 287431619:
                        if (str2.equals("griffin")) {
                            c2 = '<';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 307593612:
                        if (str2.equals("A7010a48")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 308517133:
                        if (str2.equals("A7020a48")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 316215098:
                        if (str2.equals("TB3-730F")) {
                            c2 = 'z';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 316215116:
                        if (str2.equals("TB3-730X")) {
                            c2 = '{';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 316246811:
                        if (str2.equals("TB3-850F")) {
                            c2 = '|';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 316246818:
                        if (str2.equals("TB3-850M")) {
                            c2 = '}';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 407160593:
                        if (str2.equals("Pixi5-10_4G")) {
                            c2 = 'j';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 507412548:
                        if (str2.equals("QM16XE_U")) {
                            c2 = 'r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 793982701:
                        if (str2.equals("GIONEE_WBL5708")) {
                            c2 = '9';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 794038622:
                        if (str2.equals("GIONEE_WBL7365")) {
                            c2 = ':';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 794040393:
                        if (str2.equals("GIONEE_WBL7519")) {
                            c2 = BasicHeaderValueParser.PARAM_DELIMITER;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 835649806:
                        if (str2.equals("manning")) {
                            c2 = 'Q';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 917340916:
                        if (str2.equals("A7000plus")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 958008161:
                        if (str2.equals("j2xlteins")) {
                            c2 = 'H';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1060579533:
                        if (str2.equals("panell_d")) {
                            c2 = '`';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1150207623:
                        if (str2.equals("LS-5017")) {
                            c2 = 'N';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1176899427:
                        if (str2.equals("itel_S41")) {
                            c2 = 'G';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1280332038:
                        if (str2.equals("hwALE-H")) {
                            c2 = '>';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1306947716:
                        if (str2.equals("EverStar_S")) {
                            c2 = '#';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1349174697:
                        if (str2.equals("htc_e56ml_dtul")) {
                            c2 = B64Code.__pad;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1522194893:
                        if (str2.equals("woods_f")) {
                            c2 = 133;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1691543273:
                        if (str2.equals("CPH1609")) {
                            c2 = 23;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1691544261:
                        if (str2.equals("CPH1715")) {
                            c2 = 24;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1709443163:
                        if (str2.equals("iball8735_9806")) {
                            c2 = 'D';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1865889110:
                        if (str2.equals("santoni")) {
                            c2 = 'u';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1906253259:
                        if (str2.equals("PB2-670M")) {
                            c2 = 'd';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1977196784:
                        if (str2.equals("Infinix-X572")) {
                            c2 = 'E';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2006372676:
                        if (str2.equals("BRAVIA_ATV3_4K")) {
                            c2 = 19;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2019281702:
                        if (str2.equals("DM-01K")) {
                            c2 = 29;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2029784656:
                        if (str2.equals("HWBLN-H")) {
                            c2 = '?';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2030379515:
                        if (str2.equals("HWCAM-H")) {
                            c2 = '@';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2033393791:
                        if (str2.equals("ASUS_X00AD_2")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2047190025:
                        if (str2.equals("ELUGA_Note")) {
                            c2 = TokenParser.f4579SP;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2047252157:
                        if (str2.equals("ELUGA_Prim")) {
                            c2 = PublicSuffixDatabase.EXCEPTION_MARKER;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2048319463:
                        if (str2.equals("HWVNS-H")) {
                            c2 = 'A';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2048855701:
                        if (str2.equals("HWWAS-H")) {
                            c2 = 'B';
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case ' ':
                    case '!':
                    case '\"':
                    case '#':
                    case '$':
                    case '%':
                    case '&':
                    case '\'':
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '/':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'I':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'O':
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                    case 'T':
                    case 'U':
                    case 'V':
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                    case '[':
                    case '\\':
                    case ']':
                    case '^':
                    case '_':
                    case '`':
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                    case '{':
                    case '|':
                    case '}':
                    case '~':
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case Token.LABEL /* 131 */:
                    case Token.TARGET /* 132 */:
                    case Token.LOOP /* 133 */:
                    case Token.EXPR_VOID /* 134 */:
                    case Token.EXPR_RESULT /* 135 */:
                    case Token.JSR /* 136 */:
                    case Token.SCRIPT /* 137 */:
                    case Token.TYPEOFNAME /* 138 */:
                    case Token.USE_STACK /* 139 */:
                        return true;
                    default:
                        String str3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int hashCode = str3.hashCode();
                        if (hashCode != -594534941) {
                            if (hashCode != 2006354) {
                                if (hashCode == 2006367 && str3.equals("AFTN")) {
                                    c3 = 1;
                                }
                            } else if (str3.equals("AFTA")) {
                                c3 = 0;
                            }
                        } else if (str3.equals("JSN-L21")) {
                            c3 = 2;
                        }
                        if (c3 == 0 || c3 == 1 || c3 == 2) {
                            return true;
                        }
                        break;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return j < -30000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec, String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0 && c != 1) {
            if (c == 2) {
                if ("BRAVIA 4K 2015".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || ("Amazon".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && ("KFSOWI".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || ("AFTS".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)))) {
                    return -1;
                }
                i3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 16) * C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 16) * 16 * 16;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            } else if (c != 3) {
                if (c != 4 && c != 5) {
                    return -1;
                }
                i3 = i * i2;
                return (i3 * 3) / (i4 * 2);
            }
        }
        i3 = i * i2;
        i4 = 2;
        return (i3 * 3) / (i4 * 2);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec, C2245j3 c2245j3) {
        if (c2245j3.Wwwwwwwwwwww != -1) {
            int size = c2245j3.Wwwwwwwwwww.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += c2245j3.Wwwwwwwwwww.get(i2).length;
            }
            return c2245j3.Wwwwwwwwwwww + i;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j3.Wwwwwwwwwwwww, c2245j3.Wwwwwwww, c2245j3.Wwwwwww);
    }

    public static List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2143gc abstractC2143gc, C2245j3 c2245j3, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str;
        String str2 = c2245j3.Wwwwwwwwwwwww;
        if (str2 == null) {
            return Collections.emptyList();
        }
        List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2143gc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, z, z2), c2245j3);
        if ("video/dolby-vision".equals(str2) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3)) != null) {
            int intValue = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first).intValue();
            if (intValue == 16 || intValue == 256) {
                str = "video/hevc";
            } else if (intValue == 512) {
                str = "video/avc";
            }
            ((ArrayList) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3).addAll(abstractC2143gc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, z, z2));
        }
        return Collections.unmodifiableList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
    }

    public final void Kkkkkkkkkkkkkkk() {
        this.OO000 = this.O000000000 > 0 ? SystemClock.elapsedRealtime() + this.O000000000 : -9223372036854775807L;
    }

    public final void Kkkkkkkkkkkkkkkk() {
        if (this.Ssssssssss == -1 && this.Sssssssss == -1) {
            return;
        }
        this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Ssssssssss, this.Sssssssss, this.Ssssssss, this.Sssssss);
    }

    public final void Kkkkkkkkkkkkkkkkk() {
        if (this.QQOOOO == -1 && this.QQOOO == -1) {
            return;
        }
        if (this.Ssssssssss == this.QQOOOO && this.Sssssssss == this.QQOOO && this.Ssssssss == this.QQOO && this.Sssssss == this.QQO) {
            return;
        }
        this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.QQOOOO, this.QQOOO, this.QQOO, this.QQO);
        this.Ssssssssss = this.QQOOOO;
        this.Sssssssss = this.QQOOO;
        this.Ssssssss = this.QQOO;
        this.Sssssss = this.QQO;
    }

    public void Kkkkkkkkkkkkkkkkkk() {
        this.OO00000 = true;
        if (!this.OO0000000) {
            this.OO0000000 = true;
            AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.O0000000000;
            Surface surface = this.O000;
            Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (handler != null) {
                handler.post(new RunnableC2602sl(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, surface));
            }
            this.OO000000000 = true;
        }
    }

    public final void Kkkkkkkkkkkkkkkkkkk() {
        if (this.OO0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final long j = elapsedRealtime - this.OO00;
            final AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.O0000000000;
            final int i = this.OO0;
            Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (handler != null) {
                handler.post(new Runnable() { // from class: me.tvspark.ul
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j);
                    }
                });
            }
            this.OO0 = 0;
            this.OO00 = elapsedRealtime;
        }
    }

    public final void Kkkkkkkkkkkkkkkkkkkk() {
        Surface surface;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 30 || (surface = this.O000) == null || surface == this.f4512O0 || this.O00 == 0.0f) {
            return;
        }
        this.O00 = 0.0f;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(surface, 0.0f);
    }

    public final void Kkkkkkkkkkkkkkkkkkkkk() {
        this.Ssssssssss = -1;
        this.Sssssssss = -1;
        this.Sssssss = -1.0f;
        this.Ssssssss = -1;
    }

    public final void Kkkkkkkkkkkkkkkkkkkkkk() {
        MediaCodec mediaCodec;
        this.OO0000000 = false;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23 || !this.Ssssss || (mediaCodec = this.Kkkkkkkkkkkkkkkkk) == null) {
            return;
        }
        this.Ssss = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodec);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void Www() {
        super.Www();
        this.QQOOOOOOOO = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwww() {
        Kkkkkkkkkkkkkkkkkkkkkk();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean Wwwwwwwww() {
        return this.Ssssss && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23;
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwww() {
        this.OO000 = -9223372036854775807L;
        Kkkkkkkkkkkkkkkkkkk();
        final int i = this.QQOOOOO;
        if (i != 0) {
            final AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.O0000000000;
            final long j = this.QQOOOOOO;
            Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (handler != null) {
                handler.post(new Runnable() { // from class: me.tvspark.pl
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i);
                    }
                });
            }
            this.QQOOOOOO = 0L;
            this.QQOOOOO = 0;
        }
        Kkkkkkkkkkkkkkkkkkkk();
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwww() {
        this.OO0 = 0;
        this.OO00 = SystemClock.elapsedRealtime();
        this.QQOOOOOOO = SystemClock.elapsedRealtime() * 1000;
        this.QQOOOOOO = 0L;
        this.QQOOOOO = 0;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwww() {
        try {
            super.Wwwwwwwwwwwwwwwwww();
        } finally {
            Surface surface = this.f4512O0;
            if (surface != null) {
                if (this.O000 == surface) {
                    this.O000 = null;
                }
                this.f4512O0.release();
                this.f4512O0 = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwww() {
        Kkkkkkkkkkkkkkkkkkkkk();
        Kkkkkkkkkkkkkkkkkkkkkk();
        this.OO000000000 = false;
        C1988cm c1988cm = this.IIl;
        if (c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            C1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unregisterDisplayListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.sendEmptyMessage(2);
        }
        this.Ssss = null;
        try {
            super.Wwwwwwwwwwwwwwwwwww();
            final AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.O0000000000;
            final C2698v5 c2698v5 = this.IIlllllll;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                throw null;
            }
            c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (handler == null) {
                return;
            }
            handler.post(new Runnable() { // from class: me.tvspark.ol
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
                }
            });
        } catch (Throwable th) {
            final AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.O0000000000;
            final C2698v5 c2698v52 = this.IIlllllll;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                c2698v52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Handler handler2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: me.tvspark.ol
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v52);
                        }
                    });
                }
                throw th;
            }
            throw null;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        C2698v5 c2698v5 = this.IIlllllll;
        c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwww += j;
        c2698v5.Wwwwwwwwwwwwwwwwwwwwwwww++;
        this.QQOOOOOO += j;
        this.QQOOOOO++;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws ExoPlaybackException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        Kkkkkkkkkkkkkkkkk();
        this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        Kkkkkkkkkkkkkkkkkk();
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        if (!this.Ssssss) {
            this.QQOOOOOOOO--;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2698v5 c2698v5 = this.IIlllllll;
        c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        this.OO0 += i;
        int i2 = this.QQOOOOOOOOO + i;
        this.QQOOOOOOOOO = i2;
        c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(i2, c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i3 = this.O00000000;
        if (i3 <= 0 || this.OO0 < i3) {
            return;
        }
        Kkkkkkkkkkkkkkkkkkk();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        if (!this.Ssssss) {
            this.QQOOOOOOOO--;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec mediaCodec, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2738w5 c2738w5) throws ExoPlaybackException {
        if (!this.Ssssss) {
            this.QQOOOOOOOO++;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23 || !this.Ssssss) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2738w5.Wwwwwwwwwwwwwwwwwwwww);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Surface surface;
        if (super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && (this.OO0000000 || (((surface = this.f4512O0) != null && this.O000 == surface) || this.Kkkkkkkkkkkkkkkkk == null || this.Ssssss))) {
            this.OO000 = -9223372036854775807L;
            return true;
        } else if (this.OO000 == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.OO000) {
                return true;
            }
            this.OO000 = -9223372036854775807L;
            return false;
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec) {
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23 && !this.Ssssss && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && (!c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww || C2828yl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.IIll));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, C2245j3 c2245j3, C2245j3[] c2245j3Arr) {
        float f2 = -1.0f;
        for (C2245j3 c2245j32 : c2245j3Arr) {
            float f3 = c2245j32.Wwwwww;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec mediaCodec, C2069ec c2069ec, C2245j3 c2245j3, C2245j3 c2245j32) {
        if (c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, c2245j32, true)) {
            int i = c2245j32.Wwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.O000000;
            if (i > wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || c2245j32.Wwwwwww > wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j32) > this.O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return 0;
            }
            return c2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j32) ? 3 : 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2143gc abstractC2143gc, C2245j3 c2245j3) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwww)) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
        boolean z = c2245j3.Wwwwwwwwww != null;
        List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2143gc, c2245j3, z, false);
        if (z && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2143gc, c2245j3, false, false);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isEmpty()) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        if (!MediaCodecRenderer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3)) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
        C2069ec c2069ec = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(0);
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        int i2 = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3) ? 16 : 8;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
            List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2143gc, c2245j3, z, true);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.isEmpty()) {
                C2069ec c2069ec2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.get(0);
                if (c2069ec2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3) && c2069ec2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3)) {
                    i = 32;
                }
            }
        }
        return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? 4 : 3, i2, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, @Nullable C2069ec c2069ec) {
        return new MediaCodecVideoDecoderException(th, c2069ec, this.O000);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2143gc abstractC2143gc, C2245j3 c2245j3, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2143gc, c2245j3, z, this.Ssssss);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) throws ExoPlaybackException {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, z);
        Kkkkkkkkkkkkkkkkkkkkkk();
        this.OO0000 = -9223372036854775807L;
        this.QQOOOOOOOOO = 0;
        if (z) {
            Kkkkkkkkkkkkkkk();
        } else {
            this.OO000 = -9223372036854775807L;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec mediaCodec, int i) {
        Kkkkkkkkkkkkkkkkk();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.QQOOOOOOO = SystemClock.elapsedRealtime() * 1000;
        this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        this.QQOOOOOOOOO = 0;
        Kkkkkkkkkkkkkkkkkk();
    }

    @RequiresApi(21)
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec mediaCodec, int i, long j) {
        Kkkkkkkkkkkkkkkkk();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.QQOOOOOOO = SystemClock.elapsedRealtime() * 1000;
        this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        this.QQOOOOOOOOO = 0;
        Kkkkkkkkkkkkkkkkkk();
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x00ed, code lost:
        if (r5 == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00ef, code lost:
        r12 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00f2, code lost:
        if (r5 == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00f6, code lost:
        r9 = new android.graphics.Point(r12, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00f5, code lost:
        r10 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00f1, code lost:
        r12 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0108  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec, AbstractC1978cc abstractC1978cc, C2245j3 c2245j3, @Nullable MediaCrypto mediaCrypto, float f) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Point point;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        boolean z;
        int i;
        MediaFormat mediaFormat;
        float f2;
        C2754wl c2754wl;
        boolean z2;
        Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        String str = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2245j3[] Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwww();
        int i2 = c2245j3.Wwwwwwww;
        int i3 = c2245j3.Wwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j3);
        if (Wwwwwwwwwwwwwwwwwwww.length == 1) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != -1 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j3.Wwwwwwwwwwwww, c2245j3.Wwwwwwww, c2245j3.Wwwwwww)) != -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Math.min((int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 * 1.5f), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
        } else {
            boolean z3 = false;
            for (C2245j3 c2245j32 : Wwwwwwwwwwwwwwwwwwww) {
                if (c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, c2245j32, false)) {
                    z3 |= c2245j32.Wwwwwwww == -1 || c2245j32.Wwwwwww == -1;
                    i2 = Math.max(i2, c2245j32.Wwwwwwww);
                    i3 = Math.max(i3, c2245j32.Wwwwwww);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Math.max(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j32));
                }
            }
            if (z3) {
                boolean z4 = c2245j3.Wwwwwww > c2245j3.Wwwwwwww;
                int i4 = z4 ? c2245j3.Wwwwwww : c2245j3.Wwwwwwww;
                int i5 = z4 ? c2245j3.Wwwwwwww : c2245j3.Wwwwwww;
                float f3 = i5 / i4;
                int[] iArr = f4511Ss;
                int length = iArr.length;
                int i6 = 0;
                while (true) {
                    Point point2 = null;
                    if (i6 >= length) {
                        break;
                    }
                    int i7 = iArr[i6];
                    int[] iArr2 = iArr;
                    int i8 = (int) (i7 * f3);
                    if (i7 <= i4 || i8 <= i5) {
                        break;
                    }
                    int i9 = i4;
                    int i10 = i5;
                    if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
                        int i11 = z4 ? i8 : i7;
                        if (!z4) {
                            i7 = i8;
                        }
                        MediaCodecInfo.CodecCapabilities codecCapabilities = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
                            point2 = C2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoCapabilities, i11, i7);
                        }
                        Point point3 = point2;
                        point2 = point3;
                        if (c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(point3.x, point3.y, c2245j3.Wwwwww)) {
                            break;
                        }
                    } else {
                        try {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7, 16) * 16;
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8, 16) * 16;
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 <= MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                break;
                            }
                        } catch (MediaCodecUtil.DecoderQueryException unused) {
                            point = point2;
                            if (point != null) {
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                            this.O000000 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            z = this.O0000000;
                            i = this.Sssss;
                            mediaFormat = new MediaFormat();
                            mediaFormat.setString(IMediaFormat.KEY_MIME, str);
                            mediaFormat.setInteger("width", c2245j3.Wwwwwwww);
                            mediaFormat.setInteger("height", c2245j3.Wwwwwww);
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, c2245j3.Wwwwwwwwwww);
                            f2 = c2245j3.Wwwwww;
                            if (f2 != -1.0f) {
                            }
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "rotation-degrees", c2245j3.Wwwww);
                            c2754wl = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkkk;
                            if (c2754wl != null) {
                            }
                            if ("video/dolby-vision".equals(c2245j3.Wwwwwwwwwwwww)) {
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "profile", ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first).intValue());
                            }
                            mediaFormat.setInteger("max-width", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            mediaFormat.setInteger("max-height", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "max-input-size", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23) {
                            }
                            if (!z) {
                            }
                            if (i != 0) {
                            }
                            if (this.O000 == null) {
                            }
                            abstractC1978cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, this.O000, mediaCrypto, 0);
                            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23) {
                                return;
                            }
                            return;
                        }
                    }
                    i6++;
                    iArr = iArr2;
                    i4 = i9;
                    i5 = i10;
                }
                if (point != null) {
                    i2 = Math.max(i2, point.x);
                    i3 = Math.max(i3, point.y);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Math.max(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j3.Wwwwwwwwwwwww, i2, i3));
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
        }
        this.O000000 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        z = this.O0000000;
        i = this.Sssss;
        mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("width", c2245j3.Wwwwwwww);
        mediaFormat.setInteger("height", c2245j3.Wwwwwww);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, c2245j3.Wwwwwwwwwww);
        f2 = c2245j3.Wwwwww;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "rotation-degrees", c2245j3.Wwwww);
        c2754wl = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        if (c2754wl != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "color-transfer", c2754wl.Wwwwwwwwwwwwwwwwwwwwww);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "color-standard", c2754wl.Wwwwwwwwwwwwwwwwwwwwwwww);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "color-range", c2754wl.Wwwwwwwwwwwwwwwwwwwwwww);
            byte[] bArr = c2754wl.Wwwwwwwwwwwwwwwwwwwww;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(c2245j3.Wwwwwwwwwwwww) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3)) != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "profile", ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first).intValue());
        }
        mediaFormat.setInteger("max-width", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        mediaFormat.setInteger("max-height", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "max-input-size", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (!z) {
            z2 = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z2 = true;
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z2);
            mediaFormat.setInteger("audio-session-id", i);
        }
        if (this.O000 == null) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec)) {
                throw new IllegalStateException();
            }
            if (this.f4512O0 == null) {
                this.f4512O0 = C2828yl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.IIll, c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.O000 = this.f4512O0;
        }
        abstractC1978cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, this.O000, mediaCrypto, 0);
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23 || !this.Ssssss) {
            return;
        }
        this.Ssss = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1978cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (C1914am.class) {
            if (!Oooooooooo) {
                Ooooooooo = Kkkkkkkkkkkkkk();
                Oooooooooo = true;
            }
        }
        return Ooooooooo;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec) {
        return this.O000 != null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec);
    }

    @Override // me.tvspark.AbstractC1896a4, me.tvspark.AbstractC1970c4
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Surface surface;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 30 || (surface = this.O000) == null || surface == this.f4512O0) {
            return;
        }
        float f = this.Wwwwwwwwwwwwwwwwwwww == 2 && (this.Sssssssssss > (-1.0f) ? 1 : (this.Sssssssssss == (-1.0f) ? 0 : -1)) != 0 ? this.Sssssssssss * this.Kkkkkkkkkkkkkkkkkk : 0.0f;
        if (this.O00 == f && !z) {
            return;
        }
        this.O00 = f;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.O000, f);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2738w5 c2738w5) throws ExoPlaybackException {
        if (!this.O0000) {
            return;
        }
        ByteBuffer byteBuffer = c2738w5.Wwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
        ByteBuffer byteBuffer2 = byteBuffer;
        if (byteBuffer2.remaining() < 7) {
            return;
        }
        byte b = byteBuffer2.get();
        short s = byteBuffer2.getShort();
        short s2 = byteBuffer2.getShort();
        byte b2 = byteBuffer2.get();
        byte b3 = byteBuffer2.get();
        byteBuffer2.position(0);
        if (b != -75 || s != 60 || s2 != 1 || b2 != 4 || b3 != 0) {
            return;
        }
        byte[] bArr = new byte[byteBuffer2.remaining()];
        byteBuffer2.get(bArr);
        byteBuffer2.position(0);
        MediaCodec mediaCodec = this.Kkkkkkkkkkkkkkkkk;
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodec.setParameters(bundle);
    }

    @Override // me.tvspark.AbstractC2846z2, me.tvspark.C2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i != 1) {
            if (i != 4) {
                if (i != 6) {
                    return;
                }
                this.Sss = (AbstractC1951bm) obj;
                return;
            }
            int intValue = ((Integer) obj).intValue();
            this.OO00000000 = intValue;
            MediaCodec mediaCodec = this.Kkkkkkkkkkkkkkkkk;
            if (mediaCodec == null) {
                return;
            }
            mediaCodec.setVideoScalingMode(intValue);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.f4512O0;
            if (surface2 != null) {
                surface = surface2;
            } else {
                C2069ec c2069ec = this.Kkkkkkkkk;
                if (c2069ec != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec)) {
                    surface = C2828yl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.IIll, c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.f4512O0 = surface;
                }
            }
        }
        if (this.O000 == surface) {
            if (surface == null || surface == this.f4512O0) {
                return;
            }
            Kkkkkkkkkkkkkkkk();
            if (!this.OO000000000) {
                return;
            }
            AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.O0000000000;
            Surface surface3 = this.O000;
            Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (handler == null) {
                return;
            }
            handler.post(new RunnableC2602sl(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, surface3));
            return;
        }
        Kkkkkkkkkkkkkkkkkkkk();
        this.O000 = surface;
        this.OO000000000 = false;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        int i2 = this.Wwwwwwwwwwwwwwwwwwww;
        MediaCodec mediaCodec2 = this.Kkkkkkkkkkkkkkkkk;
        if (mediaCodec2 != null) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23 && surface != null && !this.O00000) {
                mediaCodec2.setOutputSurface(surface);
            } else {
                Wwwww();
                Wwwwwwww();
            }
        }
        if (surface == null || surface == this.f4512O0) {
            Kkkkkkkkkkkkkkkkkkkkk();
            Kkkkkkkkkkkkkkkkkkkkkk();
            return;
        }
        Kkkkkkkkkkkkkkkk();
        Kkkkkkkkkkkkkkkkkkkkkk();
        if (i2 != 2) {
            return;
        }
        Kkkkkkkkkkkkkkk();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, C2245j3 c2245j3) {
        AbstractC1951bm abstractC1951bm = this.Sss;
        if (abstractC1951bm != null) {
            abstractC1951bm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2, c2245j3, this.Kkkkkkkkkkkkkk);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final String str, final long j, final long j2) {
        final AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.O0000000000;
        Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (handler != null) {
            handler.post(new Runnable() { // from class: me.tvspark.ql
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, j, j2);
                }
            });
        }
        this.O00000 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        C2069ec c2069ec = this.Kkkkkkkkk;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec);
        C2069ec c2069ec2 = c2069ec;
        if (c2069ec2 != null) {
            boolean z = false;
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29 && "video/x-vnd.on2.vp9".equals(c2069ec2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                MediaCodecInfo.CodecProfileLevel[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2069ec2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[i].profile == 16384) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.O0000 = z;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) throws ExoPlaybackException {
        this.IIlllllll = new C2698v5();
        int i = this.Sssss;
        C2007d4 c2007d4 = this.Wwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2007d4);
        int i2 = c2007d4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Sssss = i2;
        this.Ssssss = i2 != 0;
        if (this.Sssss != i) {
            Wwwww();
        }
        final AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.O0000000000;
        final C2698v5 c2698v5 = this.IIlllllll;
        Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (handler != null) {
            handler.post(new Runnable() { // from class: me.tvspark.rl
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
                }
            });
        }
        C1988cm c1988cm = this.IIl;
        c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
        if (c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.sendEmptyMessage(1);
            C1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.registerDisplayListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, null);
            }
            c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.OO000000 = z2;
        this.OO00000 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2282k3 c2282k3) throws ExoPlaybackException {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2282k3);
        final AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.O0000000000;
        final C2245j3 c2245j3 = c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (handler != null) {
            handler.post(new Runnable() { // from class: me.tvspark.nl
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2116fm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, @Nullable MediaFormat mediaFormat) {
        MediaCodec mediaCodec = this.Kkkkkkkkkkkkkkkkk;
        if (mediaCodec != null) {
            mediaCodec.setVideoScalingMode(this.OO00000000);
        }
        if (this.Ssssss) {
            this.QQOOOO = c2245j3.Wwwwwwww;
            this.QQOOO = c2245j3.Wwwwwww;
        } else if (mediaFormat == null) {
            throw null;
        } else {
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.QQOOOO = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.QQOOO = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        this.QQO = c2245j3.Wwww;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
            int i = c2245j3.Wwwww;
            if (i == 90 || i == 270) {
                int i2 = this.QQOOOO;
                this.QQOOOO = this.QQOOO;
                this.QQOOO = i2;
                this.QQO = 1.0f / this.QQO;
            }
        } else {
            this.QQOO = c2245j3.Wwwww;
        }
        this.Sssssssssss = c2245j3.Wwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x0113, code lost:
        if (r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r11, r14) != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwww(r14) && r13 > 100000) != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0188  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, @Nullable MediaCodec mediaCodec, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, C2245j3 c2245j3) throws ExoPlaybackException {
        long j4;
        boolean z3;
        boolean z4;
        long j5;
        long j6;
        C1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j7;
        boolean z5;
        boolean z6;
        long j8;
        long j9;
        if (mediaCodec != null) {
            if (this.OO0000 == -9223372036854775807L) {
                this.OO0000 = j;
            }
            long j10 = this.IIlllll;
            long j11 = j3 - j10;
            if (z && !z2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodec, i);
                return true;
            }
            long j12 = j3 - j;
            if (this.O000 == this.f4512O0) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwww(j12)) {
                    return false;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodec, i);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(j12);
                return true;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            long j13 = elapsedRealtime - this.QQOOOOOOO;
            boolean z7 = this.Wwwwwwwwwwwwwwwwwwww == 2;
            if (this.OO00000 ? this.OO0000000 : !z7 && !this.OO000000) {
                j4 = elapsedRealtime;
                z3 = false;
            } else {
                j4 = elapsedRealtime;
                z3 = true;
            }
            if (this.OO000 == -9223372036854775807L && j >= j10) {
                if (!z3) {
                    if (z7) {
                    }
                }
                z4 = true;
                if (!z4) {
                    long nanoTime = System.nanoTime();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j11, nanoTime, c2245j3);
                    if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodec, i, nanoTime);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodec, i);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(j12);
                    return true;
                } else if (!z7 || j == this.OO0000) {
                    return false;
                } else {
                    long nanoTime2 = System.nanoTime();
                    long j14 = ((j12 - (j4 - j2)) * 1000) + nanoTime2;
                    C1988cm c1988cm = this.IIl;
                    long j15 = j3 * 1000;
                    if (c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (j3 != c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            c1988cm.Wwwwwwwwwwwwwwwwwwwwwww++;
                            c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        long j16 = c1988cm.Wwwwwwwwwwwwwwwwwwwwwww;
                        if (j16 >= 6) {
                            long j17 = c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + ((j15 - c1988cm.Wwwwwwwwwwwwwwwwwwwwwwww) / j16);
                            if (!c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j17, j14)) {
                                j6 = (c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwww + j17) - c1988cm.Wwwwwwwwwwwwwwwwwwwwwwww;
                                j5 = j17;
                                if (!c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    c1988cm.Wwwwwwwwwwwwwwwwwwwwwwww = j15;
                                    c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwww = j14;
                                    c1988cm.Wwwwwwwwwwwwwwwwwwwwwww = 0L;
                                    c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                }
                                c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
                                c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j5;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
                                    j8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                                    if (j8 != -9223372036854775807L) {
                                        long j18 = c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        long j19 = (((j6 - j8) / j18) * j18) + j8;
                                        if (j6 <= j19) {
                                            j9 = j19 - j18;
                                        } else {
                                            j9 = j19;
                                            j19 = j18 + j19;
                                        }
                                        if (j19 - j6 >= j6 - j9) {
                                            j19 = j9;
                                        }
                                        j6 = j19 - c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    }
                                }
                                j7 = (j6 - nanoTime2) / 1000;
                                boolean z8 = this.OO000 == -9223372036854775807L;
                                if (!((j7 > (-500000L) ? 1 : (j7 == (-500000L) ? 0 : -1)) >= 0) && !z2) {
                                    AbstractC2183hf abstractC2183hf = this.Wwwwwwwwwwwwwwwwwww;
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2183hf);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2183hf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - this.Wwwwwwwwwwwwwwwww);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
                                        z6 = false;
                                    } else {
                                        C2698v5 c2698v5 = this.IIlllllll;
                                        c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwww++;
                                        int i4 = this.QQOOOOOOOO + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                        if (z8) {
                                            c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += i4;
                                        } else {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                                        }
                                        Wwwwwwwwwww();
                                        z6 = true;
                                    }
                                    if (z6) {
                                        return false;
                                    }
                                }
                                if (!(!Wwwwwwwwwwwwwwwwwwwwwwwwwwww(j7) && !z2)) {
                                    if (z8) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodec, i);
                                        z5 = true;
                                    } else {
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("dropVideoBuffer");
                                        mediaCodec.releaseOutputBuffer(i, false);
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        z5 = true;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(j7);
                                    return z5;
                                } else if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
                                    if (j7 >= 50000) {
                                        return false;
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j11, j6, c2245j3);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodec, i, j6);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(j7);
                                    return true;
                                } else if (j7 >= AsyncContinuation.DEFAULT_TIMEOUT) {
                                    return false;
                                } else {
                                    if (j7 > 11000) {
                                        try {
                                            Thread.sleep((j7 - 10000) / 1000);
                                        } catch (InterruptedException unused) {
                                            Thread.currentThread().interrupt();
                                            return false;
                                        }
                                    }
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j11, j6, c2245j3);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodec, i);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(j7);
                                    return true;
                                }
                            }
                        }
                        c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    }
                    j5 = j15;
                    j6 = j14;
                    if (!c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                    }
                    c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
                    c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j5;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1988cm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        j8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                        if (j8 != -9223372036854775807L) {
                        }
                    }
                    j7 = (j6 - nanoTime2) / 1000;
                    if (this.OO000 == -9223372036854775807L) {
                    }
                    if (!((j7 > (-500000L) ? 1 : (j7 == (-500000L) ? 0 : -1)) >= 0) && !z2) {
                    }
                    if (!(!Wwwwwwwwwwwwwwwwwwwwwwwwwwww(j7) && !z2)) {
                    }
                }
            }
            z4 = false;
            if (!z4) {
            }
        } else {
            throw null;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC2846z2, me.tvspark.AbstractC1896a4
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) throws ExoPlaybackException {
        this.Kkkkkkkkkkkkkkkkkk = f;
        if (this.Kkkkkkkkkkkkkkkkk != null && this.Illllllllll != 3 && this.Wwwwwwwwwwwwwwwwwwww != 0) {
            Kkkkkkkkkkkkkkkkkkkkkkkk();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    @RequiresApi(30)
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Surface surface, float f) {
        Method method = Ooooooooooo;
        try {
            Ooooooooooo.invoke(surface, Float.valueOf(f), Integer.valueOf(f == 0.0f ? 0 : 1));
        } catch (Exception e) {
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to call Surface.setFrameRate", e);
        }
    }
}
