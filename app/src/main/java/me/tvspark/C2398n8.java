package me.tvspark;

import android.util.Pair;
import android.util.SparseArray;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC2625t7;
import me.tvspark.C2245j3;
import me.tvspark.C2322l6;
import me.tvspark.C2515q8;
import me.tvspark.C2737w4;
import org.apache.commons.lang3.time.StopWatch;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* renamed from: me.tvspark.n8 */
/* loaded from: classes4.dex */
public final class C2398n8 implements AbstractC2472p8 {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2435o8 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[8];
    public final ArrayDeque<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();
    public final C2589s8 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2589s8();

    /* renamed from: me.tvspark.n8$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, int i) throws IOException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        abstractC2212i7.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0538, code lost:
        if (r0 == 0) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0581, code lost:
        r2 = "audio/raw";
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x057d, code lost:
        "audio/x-unknown".length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x057b, code lost:
        if (r0 == 0) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x056e, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwww() == me.tvspark.C2515q8.f4521Kk.getLeastSignificantBits()) goto L288;
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x078e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x07b4  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x098e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x07c1  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x09c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        int i;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str;
        Object obj;
        Object obj2;
        String str2;
        Object obj3;
        String str3;
        Object obj4;
        Object obj5;
        String str4;
        Object obj6;
        Object obj7;
        String str5;
        Object obj8;
        String str6;
        Object obj9;
        String str7;
        Object obj10;
        String str8;
        Object obj11;
        boolean z;
        C2515q8 c2515q8;
        char c;
        String str9;
        List<byte[]> list;
        List<byte[]> singletonList;
        String str10;
        String str11;
        String str12;
        Pair pair;
        int i2;
        String str13;
        ArrayList arrayList;
        int i3;
        String str14;
        ArrayList arrayList2;
        String str15;
        String str16;
        int i4;
        ArrayList arrayList3;
        String str17;
        boolean z2;
        int i5;
        ArrayList arrayList4;
        byte[] bArr;
        int i6;
        int i7;
        int i8;
        C2754wl c2754wl;
        byte[] bArr2;
        int i9;
        List<byte[]> list2;
        C2791xl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        ArrayList arrayList5;
        List<byte[]> list3;
        AbstractC2625t7 wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2864zk c2864zk;
        int i10;
        C2864zk c2864zk2;
        int i11;
        C2398n8 c2398n8 = this;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2398n8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        while (true) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww peek = c2398n8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek();
            if (peek != null && abstractC2212i7.getPosition() >= peek.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                AbstractC2435o8 abstractC2435o8 = c2398n8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i12 = c2398n8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pop().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2515q8 c2515q82 = C2515q8.this;
                if (c2515q82 == null) {
                    throw null;
                }
                if (i12 == 160) {
                    if (c2515q82.Kkkkkkkkkkkkkkkkkkkkkkkkkk != 2) {
                        return true;
                    }
                    int i13 = 0;
                    for (int i14 = 0; i14 < c2515q82.Kkkkkkkkkkkkkkkkkkkkkk; i14++) {
                        i13 += c2515q82.Kkkkkkkkkkkkkkkkkkkkk[i14];
                    }
                    C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2515q82.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c2515q82.Kkkkkkkkkkkkkkkkkkkk);
                    for (int i15 = 0; i15 < c2515q82.Kkkkkkkkkkkkkkkkkkkkkk; i15++) {
                        long j = c2515q82.Kkkkkkkkkkkkkkkkkkkkkkkkk + ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww * i15) / 1000);
                        int i16 = c2515q82.Kkkkkkkkkkkkkkkkkk;
                        if (i15 == 0 && !c2515q82.Kkkkkkkkkkkkkkkk) {
                            i16 |= 1;
                        }
                        int i17 = c2515q82.Kkkkkkkkkkkkkkkkkkkkk[i15];
                        i13 -= i17;
                        c2515q82.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, i16, i17, i13);
                    }
                    c2515q82.Kkkkkkkkkkkkkkkkkkkkkkkkkk = 0;
                    return true;
                } else if (i12 != 174) {
                    if (i12 == 19899) {
                        int i18 = c2515q82.Wwwwwwwwwwww;
                        if (i18 != -1) {
                            long j2 = c2515q82.Wwwwwwwwwww;
                            if (j2 != -1) {
                                if (i18 != 475249515) {
                                    return true;
                                }
                                c2515q82.Wwwwwwwww = j2;
                                return true;
                            }
                        }
                        throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                    } else if (i12 == 25152) {
                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2515q82.Wwwwwwwwwwwwww;
                        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            return true;
                        }
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww = new C2322l6(null, true, new C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, "video/webm", c2515q82.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        return true;
                    } else if (i12 == 28032) {
                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2515q82.Wwwwwwwwwwwwww;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwww && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            throw new ParserException("Combining encryption and compression is not supported");
                        }
                        return true;
                    } else if (i12 == 357149030) {
                        if (c2515q82.Wwwwwwwwwwwwwwwww == -9223372036854775807L) {
                            c2515q82.Wwwwwwwwwwwwwwwww = StopWatch.NANO_2_MILLIS;
                        }
                        long j3 = c2515q82.Wwwwwwwwwwwwwwww;
                        if (j3 == -9223372036854775807L) {
                            return true;
                        }
                        c2515q82.Wwwwwwwwwwwwwww = c2515q82.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3);
                        return true;
                    } else if (i12 == 374648427) {
                        if (c2515q82.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 0) {
                            throw new ParserException("No valid tracks were found");
                        }
                        c2515q82.Kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return true;
                    } else if (i12 != 475249515 || c2515q82.Wwwwwwwwwwwww) {
                        return true;
                    } else {
                        AbstractC2249j7 abstractC2249j7 = c2515q82.Kkkkkk;
                        if (c2515q82.Wwwwwwwwwwwwwwwwww != -1 && c2515q82.Wwwwwwwwwwwwwww != -9223372036854775807L && (c2864zk = c2515q82.Wwwwww) != null && (i10 = c2864zk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != 0 && (c2864zk2 = c2515q82.Wwwww) != null && c2864zk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i10) {
                            int[] iArr = new int[i10];
                            long[] jArr = new long[i10];
                            long[] jArr2 = new long[i10];
                            long[] jArr3 = new long[i10];
                            for (int i19 = 0; i19 < i10; i19++) {
                                jArr3[i19] = c2515q82.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i19);
                                jArr[i19] = c2515q82.Wwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i19) + c2515q82.Wwwwwwwwwwwwwwwwww;
                            }
                            int i20 = 0;
                            while (true) {
                                i11 = i10 - 1;
                                if (i20 >= i11) {
                                    break;
                                }
                                int i21 = i20 + 1;
                                iArr[i20] = (int) (jArr[i21] - jArr[i20]);
                                jArr2[i20] = jArr3[i21] - jArr3[i20];
                                i20 = i21;
                            }
                            iArr[i11] = (int) ((c2515q82.Wwwwwwwwwwwwwwwwww + c2515q82.Wwwwwwwwwwwwwwwwwww) - jArr[i11]);
                            jArr2[i11] = c2515q82.Wwwwwwwwwwwwwww - jArr3[i11];
                            if (jArr2[i11] <= 0) {
                                iArr = Arrays.copyOf(iArr, i11);
                                jArr = Arrays.copyOf(jArr, i11);
                                jArr2 = Arrays.copyOf(jArr2, i11);
                                jArr3 = Arrays.copyOf(jArr3, i11);
                            }
                            c2515q82.Wwwwww = null;
                            c2515q82.Wwwww = null;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C1973c7(iArr, jArr, jArr2, jArr3);
                        } else {
                            c2515q82.Wwwwww = null;
                            c2515q82.Wwwww = null;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2515q82.Wwwwwwwwwwwwwww, 0L);
                        }
                        abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        c2515q82.Wwwwwwwwwwwww = true;
                        return true;
                    }
                } else {
                    String str18 = c2515q82.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    String str19 = "S_VOBSUB";
                    String str20 = "A_TRUEHD";
                    String str21 = "A_MS/ACM";
                    if (!"V_VP8".equals(str18) && !"V_VP9".equals(str18) && !"V_AV1".equals(str18) && !"V_MPEG2".equals(str18) && !"V_MPEG4/ISO/SP".equals(str18) && !"V_MPEG4/ISO/ASP".equals(str18) && !"V_MPEG4/ISO/AP".equals(str18) && !"V_MPEG4/ISO/AVC".equals(str18) && !"V_MPEGH/ISO/HEVC".equals(str18) && !"V_MS/VFW/FOURCC".equals(str18) && !"V_THEORA".equals(str18) && !"A_OPUS".equals(str18) && !"A_VORBIS".equals(str18) && !"A_AAC".equals(str18)) {
                        if (!"A_MPEG/L2".equals(str18)) {
                            obj7 = "V_MPEG4/ISO/AP";
                            if (!"A_MPEG/L3".equals(str18)) {
                                obj2 = "V_MPEG4/ISO/SP";
                                if ("A_AC3".equals(str18) || "A_EAC3".equals(str18)) {
                                    obj5 = "A_VORBIS";
                                } else {
                                    obj5 = "A_VORBIS";
                                    if (!str20.equals(str18)) {
                                        str20 = str20;
                                        str4 = "A_DTS";
                                        if (!str4.equals(str18)) {
                                            obj6 = "A_MPEG/L2";
                                            str = "A_DTS/EXPRESS";
                                            if (!str.equals(str18)) {
                                                obj = "A_MPEG/L3";
                                                if (!"A_DTS/LOSSLESS".equals(str18)) {
                                                    obj8 = "V_MS/VFW/FOURCC";
                                                    str6 = "A_FLAC";
                                                    if (!str6.equals(str18)) {
                                                        obj9 = "V_MPEG4/ISO/ASP";
                                                        if (str21.equals(str18)) {
                                                            str21 = str21;
                                                            str7 = "A_PCM/INT/LIT";
                                                            obj10 = "V_MPEG4/ISO/AVC";
                                                            str8 = "S_TEXT/UTF8";
                                                            obj11 = "A_DTS/LOSSLESS";
                                                            str5 = "S_TEXT/ASS";
                                                            obj3 = "A_AAC";
                                                            str3 = "S_HDMV/PGS";
                                                            obj4 = "A_AC3";
                                                            str2 = "S_DVBSUB";
                                                            z = true;
                                                            if (z) {
                                                            }
                                                            c2515q8.Wwwwwwwwwwwwww = null;
                                                            return true;
                                                        }
                                                        str21 = str21;
                                                        str7 = "A_PCM/INT/LIT";
                                                        if (!str7.equals(str18)) {
                                                            obj10 = "V_MPEG4/ISO/AVC";
                                                            str8 = "S_TEXT/UTF8";
                                                            if (!str8.equals(str18)) {
                                                                obj11 = "A_DTS/LOSSLESS";
                                                                str5 = "S_TEXT/ASS";
                                                                if (!str5.equals(str18)) {
                                                                    obj3 = "A_AAC";
                                                                    if (str19.equals(str18)) {
                                                                        str19 = str19;
                                                                        str3 = "S_HDMV/PGS";
                                                                        obj4 = "A_AC3";
                                                                        str2 = "S_DVBSUB";
                                                                        z = true;
                                                                        if (z) {
                                                                        }
                                                                        c2515q8.Wwwwwwwwwwwwww = null;
                                                                        return true;
                                                                    }
                                                                    str19 = str19;
                                                                    str3 = "S_HDMV/PGS";
                                                                    if (!str3.equals(str18)) {
                                                                        obj4 = "A_AC3";
                                                                        str2 = "S_DVBSUB";
                                                                        if (!str2.equals(str18)) {
                                                                            z = false;
                                                                            if (z) {
                                                                                String str22 = str2;
                                                                                C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2515q82.Wwwwwwwwwwwwww;
                                                                                String str23 = str4;
                                                                                AbstractC2249j7 abstractC2249j72 = c2515q82.Kkkkkk;
                                                                                int i22 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                String str24 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                switch (str24.hashCode()) {
                                                                                    case -2095576542:
                                                                                        if (str24.equals(obj7)) {
                                                                                            c = 6;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -2095575984:
                                                                                        if (str24.equals(obj2)) {
                                                                                            c = 4;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -1985379776:
                                                                                        if (str24.equals(str21)) {
                                                                                            c = 23;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -1784763192:
                                                                                        if (str24.equals(str20)) {
                                                                                            c = 18;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -1730367663:
                                                                                        if (str24.equals(obj5)) {
                                                                                            c = 11;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -1482641358:
                                                                                        if (str24.equals(obj6)) {
                                                                                            c = 14;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -1482641357:
                                                                                        if (str24.equals(obj)) {
                                                                                            c = 15;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -1373388978:
                                                                                        if (str24.equals(obj8)) {
                                                                                            c = '\t';
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -933872740:
                                                                                        if (str24.equals(str22)) {
                                                                                            c = 29;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -538363189:
                                                                                        if (str24.equals(obj9)) {
                                                                                            c = 5;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -538363109:
                                                                                        if (str24.equals(obj10)) {
                                                                                            c = 7;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -425012669:
                                                                                        if (str24.equals(str19)) {
                                                                                            c = 27;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case -356037306:
                                                                                        if (str24.equals(obj11)) {
                                                                                            c = 21;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 62923557:
                                                                                        if (str24.equals(obj3)) {
                                                                                            c = '\r';
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 62923603:
                                                                                        if (str24.equals(obj4)) {
                                                                                            c = 16;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 62927045:
                                                                                        if (str24.equals(str23)) {
                                                                                            c = 19;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 82318131:
                                                                                        if (str24.equals("V_AV1")) {
                                                                                            c = 2;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 82338133:
                                                                                        if (str24.equals("V_VP8")) {
                                                                                            c = 0;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 82338134:
                                                                                        if (str24.equals("V_VP9")) {
                                                                                            c = 1;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 99146302:
                                                                                        if (str24.equals(str3)) {
                                                                                            c = 28;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 444813526:
                                                                                        if (str24.equals("V_THEORA")) {
                                                                                            c = '\n';
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 542569478:
                                                                                        if (str24.equals(str)) {
                                                                                            c = 20;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 725957860:
                                                                                        if (str24.equals(str7)) {
                                                                                            c = 24;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 738597099:
                                                                                        if (str24.equals(str5)) {
                                                                                            c = JSONLexer.EOI;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 855502857:
                                                                                        if (str24.equals("V_MPEGH/ISO/HEVC")) {
                                                                                            c = '\b';
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 1422270023:
                                                                                        if (str24.equals(str8)) {
                                                                                            c = 25;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 1809237540:
                                                                                        if (str24.equals("V_MPEG2")) {
                                                                                            c = 3;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 1950749482:
                                                                                        if (str24.equals("A_EAC3")) {
                                                                                            c = 17;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 1950789798:
                                                                                        if (str24.equals(str6)) {
                                                                                            c = 22;
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    case 1951062397:
                                                                                        if (str24.equals("A_OPUS")) {
                                                                                            c = '\f';
                                                                                            break;
                                                                                        }
                                                                                        c = 65535;
                                                                                        break;
                                                                                    default:
                                                                                        c = 65535;
                                                                                        break;
                                                                                }
                                                                                String str25 = "video/x-unknown";
                                                                                switch (c) {
                                                                                    case 0:
                                                                                        str9 = "video/x-vnd.on2.vp8";
                                                                                        list = null;
                                                                                        str11 = str9;
                                                                                        singletonList = list;
                                                                                        str12 = null;
                                                                                        str16 = str12;
                                                                                        i3 = -1;
                                                                                        i4 = -1;
                                                                                        String str26 = str11;
                                                                                        arrayList3 = singletonList;
                                                                                        str15 = str26;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2791xl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2078el(bArr))) != null) {
                                                                                            str16 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                            str15 = "video/dolby-vision";
                                                                                        }
                                                                                        int i23 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkk;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkk;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwww = i4;
                                                                                            i6 = 1;
                                                                                            list2 = arrayList3;
                                                                                        } else if (C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwww == 0) {
                                                                                                int i24 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwww;
                                                                                                i7 = -1;
                                                                                                if (i24 == -1) {
                                                                                                    i24 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwww;
                                                                                                }
                                                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwww = i24;
                                                                                                int i25 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwww;
                                                                                                if (i25 == -1) {
                                                                                                    i25 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww;
                                                                                                }
                                                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwww = i25;
                                                                                            } else {
                                                                                                i7 = -1;
                                                                                            }
                                                                                            float f = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwww == i7 || (i9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwww) == i7) ? -1.0f : (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww * i8) / (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwww * i9);
                                                                                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwww) {
                                                                                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwww == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwww == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Www == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkkkkkk == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkkkkk == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkkkk == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkkk == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkk == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkk == -1.0f || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkk == -1.0f) {
                                                                                                    bArr2 = null;
                                                                                                } else {
                                                                                                    bArr2 = new byte[25];
                                                                                                    ByteBuffer order = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                                                                                                    order.put((byte) 0);
                                                                                                    order.putShort((short) ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwww * 50000.0f) + 0.5f));
                                                                                                    order.putShort((short) ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwww * 50000.0f) + 0.5f));
                                                                                                    order.putShort((short) ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Www * 50000.0f) + 0.5f));
                                                                                                    order.putShort((short) ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkkkkkk * 50000.0f) + 0.5f));
                                                                                                    order.putShort((short) ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkkkkk * 50000.0f) + 0.5f));
                                                                                                    order.putShort((short) ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkkkk * 50000.0f) + 0.5f));
                                                                                                    order.putShort((short) ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkkk * 50000.0f) + 0.5f));
                                                                                                    order.putShort((short) ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkkk * 50000.0f) + 0.5f));
                                                                                                    order.putShort((short) (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkkk + 0.5f));
                                                                                                    order.putShort((short) (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkkk + 0.5f));
                                                                                                    order.putShort((short) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwww);
                                                                                                    order.putShort((short) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwww);
                                                                                                }
                                                                                                c2754wl = new C2754wl(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwww, bArr2);
                                                                                            } else {
                                                                                                c2754wl = null;
                                                                                            }
                                                                                            if (C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                                i7 = C2515q8.Illllllllllllllllllllllllllll.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).intValue();
                                                                                            }
                                                                                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwww == 0 && Float.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwww, 0.0f) == 0 && Float.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwww, 0.0f) == 0) {
                                                                                                if (Float.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwww, 0.0f) == 0) {
                                                                                                    i7 = 0;
                                                                                                } else if (Float.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwww, 90.0f) == 0) {
                                                                                                    i7 = 90;
                                                                                                } else if (Float.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwww, -180.0f) == 0 || Float.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwww, 180.0f) == 0) {
                                                                                                    i7 = 180;
                                                                                                } else if (Float.compare(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwww, -90.0f) == 0) {
                                                                                                    i7 = 270;
                                                                                                }
                                                                                            }
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwww;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwww = f;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwww = i7;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwww;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwww;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwww = c2754wl;
                                                                                            i6 = 2;
                                                                                            list2 = arrayList3;
                                                                                        } else {
                                                                                            ArrayList arrayList6 = arrayList3;
                                                                                            if (!"application/x-subrip".equals(str15)) {
                                                                                                if ("text/x-ssa".equals(str15)) {
                                                                                                    ArrayList arrayList7 = new ArrayList(2);
                                                                                                    arrayList7.add(C2515q8.Kkkk);
                                                                                                    arrayList7.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                                                                    arrayList6 = arrayList7;
                                                                                                } else {
                                                                                                    arrayList6 = arrayList3;
                                                                                                    if (!"application/vobsub".equals(str15)) {
                                                                                                        arrayList6 = arrayList3;
                                                                                                        if (!"application/pgs".equals(str15)) {
                                                                                                            arrayList6 = arrayList3;
                                                                                                            if (!"application/dvbsubs".equals(str15)) {
                                                                                                                throw new ParserException("Unexpected MIME type.");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            i6 = 3;
                                                                                            list2 = arrayList6;
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                                                                        break;
                                                                                    case 1:
                                                                                        str9 = "video/x-vnd.on2.vp9";
                                                                                        list = null;
                                                                                        str11 = str9;
                                                                                        singletonList = list;
                                                                                        str12 = null;
                                                                                        str16 = str12;
                                                                                        i3 = -1;
                                                                                        i4 = -1;
                                                                                        String str262 = str11;
                                                                                        arrayList3 = singletonList;
                                                                                        str15 = str262;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                            str16 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                            str15 = "video/dolby-vision";
                                                                                            break;
                                                                                        }
                                                                                        int i232 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray2.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52);
                                                                                        break;
                                                                                    case 2:
                                                                                        str9 = "video/av01";
                                                                                        list = null;
                                                                                        str11 = str9;
                                                                                        singletonList = list;
                                                                                        str12 = null;
                                                                                        str16 = str12;
                                                                                        i3 = -1;
                                                                                        i4 = -1;
                                                                                        String str2622 = str11;
                                                                                        arrayList3 = singletonList;
                                                                                        str15 = str2622;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i2322 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2322;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray22 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray22.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522);
                                                                                        break;
                                                                                    case 3:
                                                                                        str9 = "video/mpeg2";
                                                                                        list = null;
                                                                                        str11 = str9;
                                                                                        singletonList = list;
                                                                                        str12 = null;
                                                                                        str16 = str12;
                                                                                        i3 = -1;
                                                                                        i4 = -1;
                                                                                        String str26222 = str11;
                                                                                        arrayList3 = singletonList;
                                                                                        str15 = str26222;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i23222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222);
                                                                                        break;
                                                                                    case 4:
                                                                                    case 5:
                                                                                    case 6:
                                                                                        byte[] bArr3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        singletonList = bArr3 == null ? null : Collections.singletonList(bArr3);
                                                                                        str10 = "video/mp4v-es";
                                                                                        str11 = str10;
                                                                                        str12 = null;
                                                                                        str16 = str12;
                                                                                        i3 = -1;
                                                                                        i4 = -1;
                                                                                        String str262222 = str11;
                                                                                        arrayList3 = singletonList;
                                                                                        str15 = str262222;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i232222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray2222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222);
                                                                                        break;
                                                                                    case 7:
                                                                                        C2717vl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2717vl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2078el(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww));
                                                                                        list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        str9 = "video/avc";
                                                                                        str11 = str9;
                                                                                        singletonList = list;
                                                                                        str12 = null;
                                                                                        str16 = str12;
                                                                                        i3 = -1;
                                                                                        i4 = -1;
                                                                                        String str2622222 = str11;
                                                                                        arrayList3 = singletonList;
                                                                                        str15 = str2622222;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i2322222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2322222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray22222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray22222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222);
                                                                                        break;
                                                                                    case '\b':
                                                                                        C2865zl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = C2865zl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2078el(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww));
                                                                                        list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        str9 = "video/hevc";
                                                                                        str11 = str9;
                                                                                        singletonList = list;
                                                                                        str12 = null;
                                                                                        str16 = str12;
                                                                                        i3 = -1;
                                                                                        i4 = -1;
                                                                                        String str26222222 = str11;
                                                                                        arrayList3 = singletonList;
                                                                                        str15 = str26222222;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i23222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222);
                                                                                        break;
                                                                                    case '\t':
                                                                                        C2078el c2078el = new C2078el(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                                                        try {
                                                                                            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                                                                            long Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 1482049860) {
                                                                                                pair = new Pair(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_DIVX, null);
                                                                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 859189832) {
                                                                                                pair = new Pair(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP, null);
                                                                                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 826496599) {
                                                                                                byte[] bArr4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                                for (int i26 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 20; i26 < bArr4.length - 4; i26++) {
                                                                                                    if (bArr4[i26] == 0 && bArr4[i26 + 1] == 0 && bArr4[i26 + 2] == 1 && bArr4[i26 + 3] == 15) {
                                                                                                        pair = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArr4, i26, bArr4.length)));
                                                                                                    }
                                                                                                }
                                                                                                throw new ParserException("Failed to find FourCC VC1 initialization data");
                                                                                            } else {
                                                                                                pair = new Pair(str25, null);
                                                                                            }
                                                                                            str10 = (String) pair.first;
                                                                                            singletonList = (List) pair.second;
                                                                                            str11 = str10;
                                                                                            str12 = null;
                                                                                            str16 = str12;
                                                                                            i3 = -1;
                                                                                            i4 = -1;
                                                                                            String str262222222 = str11;
                                                                                            arrayList3 = singletonList;
                                                                                            str15 = str262222222;
                                                                                            bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                            if (bArr != null) {
                                                                                            }
                                                                                            int i232222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                            if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                            }
                                                                                            if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                            }
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232222222;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                            AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222;
                                                                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222);
                                                                                            c2515q8 = c2515q82;
                                                                                            SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                            C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                            sparseArray2222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222);
                                                                                            break;
                                                                                        } catch (ArrayIndexOutOfBoundsException unused) {
                                                                                            throw new ParserException("Error parsing FourCC private data");
                                                                                        }
                                                                                        break;
                                                                                    case '\n':
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i2322222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2322222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray22222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray22222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222);
                                                                                        break;
                                                                                    case 11:
                                                                                        byte[] bArr5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        try {
                                                                                            if (bArr5[0] != 2) {
                                                                                                throw new ParserException("Error parsing vorbis codec private");
                                                                                            }
                                                                                            int i27 = 0;
                                                                                            int i28 = 1;
                                                                                            while (bArr5[i28] == -1) {
                                                                                                i27 += 255;
                                                                                                i28++;
                                                                                            }
                                                                                            int i29 = i28 + 1;
                                                                                            int i30 = i27 + bArr5[i28];
                                                                                            int i31 = 0;
                                                                                            while (bArr5[i29] == -1) {
                                                                                                i31 += 255;
                                                                                                i29++;
                                                                                            }
                                                                                            int i32 = i29 + 1;
                                                                                            int i33 = i31 + bArr5[i29];
                                                                                            if (bArr5[i32] != 1) {
                                                                                                throw new ParserException("Error parsing vorbis codec private");
                                                                                            }
                                                                                            byte[] bArr6 = new byte[i30];
                                                                                            System.arraycopy(bArr5, i32, bArr6, 0, i30);
                                                                                            int i34 = i32 + i30;
                                                                                            if (bArr5[i34] != 3) {
                                                                                                throw new ParserException("Error parsing vorbis codec private");
                                                                                            }
                                                                                            int i35 = i34 + i33;
                                                                                            if (bArr5[i35] != 5) {
                                                                                                throw new ParserException("Error parsing vorbis codec private");
                                                                                            }
                                                                                            byte[] bArr7 = new byte[bArr5.length - i35];
                                                                                            System.arraycopy(bArr5, i35, bArr7, 0, bArr5.length - i35);
                                                                                            arrayList = new ArrayList(2);
                                                                                            arrayList.add(bArr6);
                                                                                            arrayList.add(bArr7);
                                                                                            i3 = 8192;
                                                                                            str14 = "audio/vorbis";
                                                                                            String str27 = str14;
                                                                                            arrayList2 = arrayList;
                                                                                            str15 = str27;
                                                                                            i4 = -1;
                                                                                            arrayList5 = arrayList2;
                                                                                            str16 = null;
                                                                                            arrayList3 = arrayList5;
                                                                                            bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                            if (bArr != null) {
                                                                                            }
                                                                                            int i23222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                            if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                            }
                                                                                            if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                            }
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23222222222;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                            C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                            AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222;
                                                                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222);
                                                                                            c2515q8 = c2515q82;
                                                                                            SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                            C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                            sparseArray222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222);
                                                                                            break;
                                                                                        } catch (ArrayIndexOutOfBoundsException unused2) {
                                                                                            throw new ParserException("Error parsing vorbis codec private");
                                                                                        }
                                                                                        break;
                                                                                    case '\f':
                                                                                        arrayList = new ArrayList(3);
                                                                                        arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                                                        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkk).array());
                                                                                        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkk).array());
                                                                                        i3 = 5760;
                                                                                        str14 = "audio/opus";
                                                                                        String str272 = str14;
                                                                                        arrayList2 = arrayList;
                                                                                        str15 = str272;
                                                                                        i4 = -1;
                                                                                        arrayList5 = arrayList2;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i232222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray2222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222);
                                                                                        break;
                                                                                    case '\r':
                                                                                        singletonList = Collections.singletonList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                                                        C2737w4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = C2737w4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        str12 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        str11 = "audio/mp4a-latm";
                                                                                        str16 = str12;
                                                                                        i3 = -1;
                                                                                        i4 = -1;
                                                                                        String str2622222222 = str11;
                                                                                        arrayList3 = singletonList;
                                                                                        str15 = str2622222222;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i2322222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2322222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray22222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray22222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222);
                                                                                        break;
                                                                                    case 14:
                                                                                        str15 = "audio/mpeg-L2";
                                                                                        i3 = 4096;
                                                                                        arrayList2 = null;
                                                                                        i4 = -1;
                                                                                        arrayList5 = arrayList2;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i23222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222);
                                                                                        break;
                                                                                    case 15:
                                                                                        str15 = DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG;
                                                                                        i3 = 4096;
                                                                                        arrayList2 = null;
                                                                                        i4 = -1;
                                                                                        arrayList5 = arrayList2;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i232222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray2222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222);
                                                                                        break;
                                                                                    case 16:
                                                                                        str17 = "audio/ac3";
                                                                                        str25 = str17;
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i2322222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2322222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray22222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray22222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222);
                                                                                        break;
                                                                                    case 17:
                                                                                        str17 = "audio/eac3";
                                                                                        str25 = str17;
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i23222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222);
                                                                                        break;
                                                                                    case 18:
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkk = new C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        str17 = "audio/true-hd";
                                                                                        str25 = str17;
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i232222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray2222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222);
                                                                                        break;
                                                                                    case 19:
                                                                                    case 20:
                                                                                        str17 = "audio/vnd.dts";
                                                                                        str25 = str17;
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i2322222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2322222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray22222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray22222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222);
                                                                                        break;
                                                                                    case 21:
                                                                                        str17 = "audio/vnd.dts.hd";
                                                                                        str25 = str17;
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i23222222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23222222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray222222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray222222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222);
                                                                                        break;
                                                                                    case 22:
                                                                                        str13 = "audio/flac";
                                                                                        list3 = Collections.singletonList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                                                        i5 = -1;
                                                                                        arrayList4 = list3;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i232222222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232222222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2222222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray2222222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222);
                                                                                        break;
                                                                                    case 23:
                                                                                        C2078el c2078el2 = new C2078el(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                                                        try {
                                                                                            int Wwwwwwwwwwwwwwwwwwwwwwwwww = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                                                                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwww == 65534) {
                                                                                                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(24);
                                                                                                    if (c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwww() == C2515q8.f4521Kk.getMostSignificantBits()) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                z2 = false;
                                                                                                if (!z2) {
                                                                                                    i2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkk);
                                                                                                    break;
                                                                                                } else {
                                                                                                    "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown");
                                                                                                    str25 = "audio/x-unknown";
                                                                                                    i2 = -1;
                                                                                                    str13 = str25;
                                                                                                    i5 = i2;
                                                                                                    arrayList4 = null;
                                                                                                    i4 = i5;
                                                                                                    arrayList5 = arrayList4;
                                                                                                    str15 = str13;
                                                                                                    i3 = -1;
                                                                                                    str16 = null;
                                                                                                    arrayList3 = arrayList5;
                                                                                                    bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                                    if (bArr != null) {
                                                                                                    }
                                                                                                    int i2322222222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                                    if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                                    }
                                                                                                    if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                                    }
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2322222222222222222222;
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                                    C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                                    AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222;
                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222222222222);
                                                                                                    c2515q8 = c2515q82;
                                                                                                    SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray22222222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                                    C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                                    sparseArray22222222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222);
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                            }
                                                                                        } catch (ArrayIndexOutOfBoundsException unused3) {
                                                                                            throw new ParserException("Error parsing MS/ACM codec private");
                                                                                        }
                                                                                        break;
                                                                                    case 24:
                                                                                        i2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkk);
                                                                                        break;
                                                                                    case 25:
                                                                                        str25 = "application/x-subrip";
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i23222222222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23222222222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray222222222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray222222222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222);
                                                                                        break;
                                                                                    case 26:
                                                                                        str25 = "text/x-ssa";
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i232222222222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232222222222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2222222222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray2222222222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222);
                                                                                        break;
                                                                                    case 27:
                                                                                        str13 = "application/vobsub";
                                                                                        list3 = Collections.singletonList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww);
                                                                                        i5 = -1;
                                                                                        arrayList4 = list3;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i2322222222222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2322222222222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww422222222222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray22222222222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray22222222222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww522222222222222222222222);
                                                                                        break;
                                                                                    case 28:
                                                                                        str25 = "application/pgs";
                                                                                        i2 = -1;
                                                                                        str13 = str25;
                                                                                        i5 = i2;
                                                                                        arrayList4 = null;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i23222222222222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i23222222222222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4222222222222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray222222222222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray222222222222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5222222222222222222222222);
                                                                                        break;
                                                                                    case 29:
                                                                                        byte[] bArr8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        byte[] bArr9 = {bArr8[0], bArr8[1], bArr8[2], bArr8[3]};
                                                                                        str13 = "application/dvbsubs";
                                                                                        list3 = Collections.singletonList(bArr9);
                                                                                        i5 = -1;
                                                                                        arrayList4 = list3;
                                                                                        i4 = i5;
                                                                                        arrayList5 = arrayList4;
                                                                                        str15 = str13;
                                                                                        i3 = -1;
                                                                                        str16 = null;
                                                                                        arrayList3 = arrayList5;
                                                                                        bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkkkkkkkkk;
                                                                                        if (bArr != null) {
                                                                                        }
                                                                                        int i232222222222222222222222222 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkk ? 1 : 0) | 0 | (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkkkk ? 2 : 0);
                                                                                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str15)) {
                                                                                        }
                                                                                        if (!C2515q8.Illllllllllllllllllllllllllll.containsKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                                                                        }
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwww = str15;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwww = i3;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkkk;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i232222222222222222222222222;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwww = list2;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str16;
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222222222222222 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222222 = abstractC2249j72.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Kkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222222;
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww42222222222222222222222222);
                                                                                        c2515q8 = c2515q82;
                                                                                        SparseArray<C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> sparseArray2222222222222222222222222 = c2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                                                                        C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222222 = c2515q8.Wwwwwwwwwwwwww;
                                                                                        sparseArray2222222222222222222222222.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww52222222222222222222222222);
                                                                                        break;
                                                                                    default:
                                                                                        throw new ParserException("Unrecognized codec identifier.");
                                                                                }
                                                                            } else {
                                                                                c2515q8 = c2515q82;
                                                                            }
                                                                            c2515q8.Wwwwwwwwwwwwww = null;
                                                                            return true;
                                                                        }
                                                                        z = true;
                                                                        if (z) {
                                                                        }
                                                                        c2515q8.Wwwwwwwwwwwwww = null;
                                                                        return true;
                                                                    }
                                                                    obj4 = "A_AC3";
                                                                    str2 = "S_DVBSUB";
                                                                    z = true;
                                                                    if (z) {
                                                                    }
                                                                    c2515q8.Wwwwwwwwwwwwww = null;
                                                                    return true;
                                                                }
                                                                obj3 = "A_AAC";
                                                                str3 = "S_HDMV/PGS";
                                                                obj4 = "A_AC3";
                                                                str2 = "S_DVBSUB";
                                                                z = true;
                                                                if (z) {
                                                                }
                                                                c2515q8.Wwwwwwwwwwwwww = null;
                                                                return true;
                                                            }
                                                            obj11 = "A_DTS/LOSSLESS";
                                                            str5 = "S_TEXT/ASS";
                                                            obj3 = "A_AAC";
                                                            str3 = "S_HDMV/PGS";
                                                            obj4 = "A_AC3";
                                                            str2 = "S_DVBSUB";
                                                            z = true;
                                                            if (z) {
                                                            }
                                                            c2515q8.Wwwwwwwwwwwwww = null;
                                                            return true;
                                                        }
                                                        obj10 = "V_MPEG4/ISO/AVC";
                                                        str8 = "S_TEXT/UTF8";
                                                        obj11 = "A_DTS/LOSSLESS";
                                                        str5 = "S_TEXT/ASS";
                                                        obj3 = "A_AAC";
                                                        str3 = "S_HDMV/PGS";
                                                        obj4 = "A_AC3";
                                                        str2 = "S_DVBSUB";
                                                        z = true;
                                                        if (z) {
                                                        }
                                                        c2515q8.Wwwwwwwwwwwwww = null;
                                                        return true;
                                                    }
                                                } else {
                                                    obj8 = "V_MS/VFW/FOURCC";
                                                    str6 = "A_FLAC";
                                                }
                                                obj9 = "V_MPEG4/ISO/ASP";
                                                str7 = "A_PCM/INT/LIT";
                                                obj10 = "V_MPEG4/ISO/AVC";
                                                str8 = "S_TEXT/UTF8";
                                                obj11 = "A_DTS/LOSSLESS";
                                                str5 = "S_TEXT/ASS";
                                                obj3 = "A_AAC";
                                                str3 = "S_HDMV/PGS";
                                                obj4 = "A_AC3";
                                                str2 = "S_DVBSUB";
                                                z = true;
                                                if (z) {
                                                }
                                                c2515q8.Wwwwwwwwwwwwww = null;
                                                return true;
                                            }
                                            obj = "A_MPEG/L3";
                                            str5 = "S_TEXT/ASS";
                                            obj3 = "A_AAC";
                                            str3 = "S_HDMV/PGS";
                                            obj4 = "A_AC3";
                                        }
                                        obj6 = "A_MPEG/L2";
                                        str = "A_DTS/EXPRESS";
                                        obj = "A_MPEG/L3";
                                        str5 = "S_TEXT/ASS";
                                        obj3 = "A_AAC";
                                        str3 = "S_HDMV/PGS";
                                        obj4 = "A_AC3";
                                    } else {
                                        str20 = str20;
                                    }
                                }
                                str4 = "A_DTS";
                                obj6 = "A_MPEG/L2";
                                str = "A_DTS/EXPRESS";
                                obj = "A_MPEG/L3";
                                str5 = "S_TEXT/ASS";
                                obj3 = "A_AAC";
                                str3 = "S_HDMV/PGS";
                                obj4 = "A_AC3";
                            } else {
                                obj2 = "V_MPEG4/ISO/SP";
                                str2 = "S_DVBSUB";
                                obj6 = "A_MPEG/L2";
                                str = "A_DTS/EXPRESS";
                                obj = "A_MPEG/L3";
                                str5 = "S_TEXT/ASS";
                                obj3 = "A_AAC";
                                str3 = "S_HDMV/PGS";
                                obj4 = "A_AC3";
                                obj5 = "A_VORBIS";
                                str4 = "A_DTS";
                            }
                        } else {
                            obj7 = "V_MPEG4/ISO/AP";
                            str5 = "S_TEXT/ASS";
                            obj3 = "A_AAC";
                            str3 = "S_HDMV/PGS";
                            obj4 = "A_AC3";
                            obj5 = "A_VORBIS";
                            str4 = "A_DTS";
                            obj6 = "A_MPEG/L2";
                            str = "A_DTS/EXPRESS";
                            obj = "A_MPEG/L3";
                            obj2 = "V_MPEG4/ISO/SP";
                        }
                        str2 = "S_DVBSUB";
                        obj8 = "V_MS/VFW/FOURCC";
                        str6 = "A_FLAC";
                        obj9 = "V_MPEG4/ISO/ASP";
                        str7 = "A_PCM/INT/LIT";
                        obj10 = "V_MPEG4/ISO/AVC";
                        str8 = "S_TEXT/UTF8";
                        obj11 = "A_DTS/LOSSLESS";
                        z = true;
                        if (z) {
                        }
                        c2515q8.Wwwwwwwwwwwwww = null;
                        return true;
                    }
                    str = "A_DTS/EXPRESS";
                    obj = "A_MPEG/L3";
                    obj2 = "V_MPEG4/ISO/SP";
                    str2 = "S_DVBSUB";
                    obj3 = "A_AAC";
                    str3 = "S_HDMV/PGS";
                    obj4 = "A_AC3";
                    obj5 = "A_VORBIS";
                    str4 = "A_DTS";
                    obj6 = "A_MPEG/L2";
                    obj7 = "V_MPEG4/ISO/AP";
                    str5 = "S_TEXT/ASS";
                    obj8 = "V_MS/VFW/FOURCC";
                    str6 = "A_FLAC";
                    obj9 = "V_MPEG4/ISO/ASP";
                    str7 = "A_PCM/INT/LIT";
                    obj10 = "V_MPEG4/ISO/AVC";
                    str8 = "S_TEXT/UTF8";
                    obj11 = "A_DTS/LOSSLESS";
                    z = true;
                    if (z) {
                    }
                    c2515q8.Wwwwwwwwwwwwww = null;
                    return true;
                }
            }
            boolean z3 = true;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, true, false, 4);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == -2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 == -1) {
                    return false;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
                z3 = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == z3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, false, z3, 8);
                i = 2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
            } else {
                i = 2;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = ((C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 != 0) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == z3) {
                    long position = abstractC2212i7.getPosition();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.push(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + position, null));
                    ((C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, position, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == i) {
                    long j4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (j4 > 8) {
                        long j5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j5);
                        throw new ParserException(sb.toString());
                    }
                    ((C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, (int) j4));
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == 3) {
                    long j6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (j6 > 2147483647L) {
                        long j7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j7);
                        throw new ParserException(sb2.toString());
                    }
                    ((C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, (int) j6));
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == 4) {
                    ((C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, (int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2212i7);
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 != 5) {
                    throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(32, "Invalid element type ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9));
                } else {
                    long j8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (j8 != 4 && j8 != 8) {
                        long j9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j9);
                        throw new ParserException(sb3.toString());
                    }
                    AbstractC2435o8 abstractC2435o82 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i36 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i37 = (int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    ((C2515q8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) abstractC2435o82).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i36, i37 == 4 ? Float.intBitsToFloat((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : Double.longBitsToDouble(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, i37)));
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                return true;
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            c2398n8 = this;
        }
    }

    @RequiresNonNull({"processor"})
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        while (true) {
            boolean z = false;
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2589s8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0]);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 <= 4) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (int) C2589s8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, false);
                if (C2515q8.this == null) {
                    throw null;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 357149030 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 524531317 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 475249515 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 374648427) {
                    z = true;
                }
                if (z) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, int i) throws IOException {
        abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] & 255);
        }
        return j;
    }
}
