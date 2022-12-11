package org.antlr.p055v4.runtime.atn;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import me.tvspark.a11;
import me.tvspark.az0;
import me.tvspark.bz0;
import me.tvspark.c01;
import me.tvspark.d01;
import me.tvspark.dz0;
import me.tvspark.e01;
import me.tvspark.f01;
import me.tvspark.h01;
import me.tvspark.hz0;
import me.tvspark.j01;
import me.tvspark.jz0;
import me.tvspark.k01;
import me.tvspark.kz0;
import me.tvspark.l01;
import me.tvspark.ly0;
import me.tvspark.m01;
import me.tvspark.mz0;
import me.tvspark.n01;
import me.tvspark.nz0;
import me.tvspark.oy0;
import me.tvspark.oz0;
import me.tvspark.py0;
import me.tvspark.pz0;
import me.tvspark.qy0;
import me.tvspark.qz0;
import me.tvspark.rz0;
import me.tvspark.sy0;
import me.tvspark.sz0;
import me.tvspark.tz0;
import me.tvspark.uy0;
import me.tvspark.wy0;
import me.tvspark.wz0;
import me.tvspark.xy0;
import me.tvspark.xz0;
import me.tvspark.yy0;
import me.tvspark.yz0;
import me.tvspark.zy0;
import me.tvspark.zz0;
import org.antlr.p055v4.runtime.misc.Pair;

/* renamed from: org.antlr.v4.runtime.atn.ATNDeserializer */
/* loaded from: classes4.dex */
public class ATNDeserializer {
    public static final List<UUID> Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
    public final oy0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final UUID Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = UUID.fromString("33761B2D-78BB-4A43-8B0B-4F5BEE8AACF3");
    public static final UUID Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = UUID.fromString("1DA0C57D-6C06-438A-9B27-10BCB3CE0F61");
    public static final UUID Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = UUID.fromString("AADB8D7E-AEEF-4415-AD2B-8204D6CF042E");
    public static final UUID Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = UUID.fromString("59627784-3BE5-417A-B9EB-8131A7286089");
    public static final UUID Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: org.antlr.v4.runtime.atn.ATNDeserializer$UnicodeDeserializingMode */
    /* loaded from: classes4.dex */
    public enum UnicodeDeserializingMode {
        UNICODE_BMP,
        UNICODE_SMP
    }

    /* renamed from: org.antlr.v4.runtime.atn.ATNDeserializer$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char[] cArr, int i);

        int size();
    }

    static {
        ArrayList arrayList = new ArrayList();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList;
        arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public ATNDeserializer() {
        oy0 oy0Var = oy0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oy0Var == null ? oy0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : oy0Var;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid, UUID uuid2) {
        int indexOf = Wwwwwwwwwwwwwwwwwwwwwwwwwwww.indexOf(uuid);
        return indexOf >= 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwww.indexOf(uuid2) >= indexOf;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char[] cArr, int i, List<a11> list, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int i2 = i + 1;
        char c = cArr[i];
        for (int i3 = 0; i3 < c; i3++) {
            char c2 = cArr[i2];
            int i4 = i2 + 1;
            a11 a11Var = new a11(new int[0]);
            list.add(a11Var);
            int i5 = i4 + 1;
            if (cArr[i4] != 0) {
                a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
            }
            i2 = i5;
            int i6 = 0;
            while (i6 < c2) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, i2);
                int size = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() + i2;
                a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr, size));
                i6++;
                i2 = size + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            }
        }
        return i2;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalStateException((String) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10, types: [me.tvspark.e01] */
    /* JADX WARN: Type inference failed for: r14v11, types: [me.tvspark.zy0] */
    /* JADX WARN: Type inference failed for: r14v12, types: [me.tvspark.l01] */
    /* JADX WARN: Type inference failed for: r14v13, types: [me.tvspark.k01] */
    /* JADX WARN: Type inference failed for: r14v14, types: [me.tvspark.xz0] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19, types: [me.tvspark.sz0] */
    /* JADX WARN: Type inference failed for: r14v4, types: [me.tvspark.yy0] */
    /* JADX WARN: Type inference failed for: r14v5, types: [me.tvspark.d01] */
    /* JADX WARN: Type inference failed for: r14v6, types: [me.tvspark.xy0] */
    /* JADX WARN: Type inference failed for: r14v7, types: [me.tvspark.wz0] */
    /* JADX WARN: Type inference failed for: r14v8, types: [me.tvspark.j01] */
    /* JADX WARN: Type inference failed for: r14v9, types: [me.tvspark.m01] */
    /* JADX WARN: Type inference failed for: r18v0, types: [org.antlr.v4.runtime.atn.ATNDeserializer] */
    public ly0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char[] cArr) {
        sy0 sy0Var;
        Transition transition;
        int i;
        hz0 jz0Var;
        Transition dz0Var;
        Transition c01Var;
        az0 az0Var;
        ?? yy0Var;
        int i2;
        char[] cArr2 = (char[]) cArr.clone();
        for (int i3 = 1; i3 < cArr2.length; i3++) {
            cArr2[i3] = (char) (cArr2[i3] - 2);
        }
        char c = cArr2[0];
        if (c == 3) {
            UUID uuid = new UUID(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr2, 5), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr2, 1));
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(uuid)) {
                throw new UnsupportedOperationException(new InvalidClassException(ly0.class.getName(), String.format(Locale.getDefault(), "Could not deserialize ATN with UUID %s (expected %s or a legacy UUID).", uuid, Wwwwwwwwwwwwwwwwwwwwwwwwwww)));
            }
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uuid);
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uuid);
            ly0 ly0Var = new ly0(ATNType.values()[cArr2[9]], cArr2[10]);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            char c2 = cArr2[11];
            char c3 = '\f';
            int i4 = 0;
            int i5 = 12;
            while (true) {
                char c4 = 65535;
                if (i4 >= c2) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        ((sz0) pair.f4543a).Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(((Integer) pair.f4544b).intValue());
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        Pair pair2 = (Pair) it2.next();
                        ((az0) pair2.f4543a).Wwwwwwwwwwwwwwwwwwwwwwwwww = (zy0) ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(((Integer) pair2.f4544b).intValue());
                    }
                    char c5 = cArr2[i5];
                    int i6 = i5 + 1;
                    int i7 = 0;
                    while (i7 < c5) {
                        ((bz0) ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cArr2[i6])).Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        i7++;
                        i6++;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        char c6 = cArr2[i6];
                        i6++;
                        int i8 = 0;
                        while (i8 < c6) {
                            ((d01) ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cArr2[i6])).Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                            i8++;
                            i6++;
                        }
                    }
                    int i9 = i6 + 1;
                    char c7 = cArr2[i6];
                    if (ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ATNType.LEXER) {
                        ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[c7];
                    }
                    ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new d01[c7];
                    int i10 = i9;
                    for (int i11 = 0; i11 < c7; i11++) {
                        int i12 = i10 + 1;
                        ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i11] = (d01) ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cArr2[i10]);
                        if (ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ATNType.LEXER) {
                            i10 = i12 + 1;
                            char c8 = cArr2[i12];
                            if (c8 == 65535) {
                                c8 = 65535;
                            }
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i11] = c8;
                            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, uuid)) {
                                i12 = i10 + 1;
                                char c9 = cArr2[i10];
                            }
                        }
                        i10 = i12;
                    }
                    ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new e01[c7];
                    for (sy0 sy0Var2 : ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (sy0Var2 instanceof e01) {
                            e01 e01Var = (e01) sy0Var2;
                            e01[] e01VarArr = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i13 = sy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            e01VarArr[i13] = e01Var;
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i13].Wwwwwwwwwwwwwwwwwwwwwwwwwwww = e01Var;
                        }
                    }
                    char c10 = cArr2[i10];
                    int i14 = i10 + 1;
                    int i15 = 0;
                    while (i15 < c10) {
                        ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwww.add((m01) ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cArr2[i14]));
                        i15++;
                        i14++;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    UnicodeDeserializingMode unicodeDeserializingMode = UnicodeDeserializingMode.UNICODE_BMP;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr2, i14, arrayList3, unicodeDeserializingMode == unicodeDeserializingMode ? new py0() : new qy0());
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, uuid)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cArr2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, arrayList3, UnicodeDeserializingMode.UNICODE_SMP == UnicodeDeserializingMode.UNICODE_BMP ? new py0() : new qy0());
                    }
                    int i16 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 + 1;
                    char c11 = cArr2[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4];
                    int i17 = i16;
                    for (int i18 = 0; i18 < c11; i18++) {
                        char c12 = cArr2[i17];
                        char c13 = cArr2[i17 + 1];
                        char c14 = cArr2[i17 + 2];
                        char c15 = cArr2[i17 + 3];
                        char c16 = cArr2[i17 + 4];
                        char c17 = cArr2[i17 + 5];
                        sy0 sy0Var3 = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c13);
                        switch (c14) {
                            case 1:
                                dz0Var = new dz0(sy0Var3);
                                continue;
                                ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c12).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dz0Var);
                                i17 += 6;
                            case 2:
                                if (c17 != 0) {
                                    c01Var = new c01(sy0Var3, -1, c16);
                                    break;
                                } else {
                                    c01Var = new c01(sy0Var3, c15, c16);
                                    break;
                                }
                            case 3:
                                c01Var = new f01((d01) ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c15), c16, c17, sy0Var3);
                                break;
                            case 4:
                                c01Var = new zz0(sy0Var3, c15, c16, c17 != 0);
                                break;
                            case 5:
                                if (c17 != 0) {
                                    c01Var = new wy0(sy0Var3, -1);
                                    break;
                                } else {
                                    c01Var = new wy0(sy0Var3, c15);
                                    break;
                                }
                            case 6:
                                c01Var = new uy0(sy0Var3, c15, c16, c17 != 0);
                                break;
                            case 7:
                                dz0Var = new h01(sy0Var3, (a11) arrayList3.get(c15));
                                continue;
                                ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c12).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dz0Var);
                                i17 += 6;
                            case '\b':
                                dz0Var = new tz0(sy0Var3, (a11) arrayList3.get(c15));
                                continue;
                                ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c12).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dz0Var);
                                i17 += 6;
                            case '\t':
                                dz0Var = new n01(sy0Var3);
                                continue;
                                ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c12).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dz0Var);
                                i17 += 6;
                            case '\n':
                                dz0Var = new yz0(sy0Var3, c15);
                                continue;
                                ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c12).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dz0Var);
                                i17 += 6;
                            default:
                                throw new IllegalArgumentException("The specified transition type is not valid.");
                        }
                        dz0Var = c01Var;
                        ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(c12).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dz0Var);
                        i17 += 6;
                    }
                    for (sy0 sy0Var4 : ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        for (int i19 = 0; i19 < sy0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i19++) {
                            Transition Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = sy0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i19);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 instanceof f01) {
                                f01 f01Var = (f01) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                                d01[] d01VarArr = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i20 = f01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (!d01VarArr[i20].Wwwwwwwwwwwwwwwwwwwwwwwwwww || f01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                                    i20 = -1;
                                }
                                ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[f01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new dz0(f01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i20));
                            }
                        }
                    }
                    for (sy0 sy0Var5 : ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (sy0Var5 instanceof az0) {
                            az0 az0Var2 = (az0) sy0Var5;
                            zy0 zy0Var = az0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (zy0Var == null) {
                                throw new IllegalStateException();
                            }
                            if (zy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                                throw new IllegalStateException();
                            }
                            zy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = az0Var2;
                        }
                        if (sy0Var5 instanceof xz0) {
                            xz0 xz0Var = (xz0) sy0Var5;
                            for (int i21 = 0; i21 < xz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i21++) {
                                sy0 sy0Var6 = xz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i21).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (sy0Var6 instanceof wz0) {
                                    ((wz0) sy0Var6).Wwwwwwwwwwwwwwwwwwwwwwwww = xz0Var;
                                }
                            }
                        } else if (sy0Var5 instanceof l01) {
                            l01 l01Var = (l01) sy0Var5;
                            for (int i22 = 0; i22 < l01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i22++) {
                                sy0 sy0Var7 = l01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i22).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (sy0Var7 instanceof k01) {
                                    ((k01) sy0Var7).Wwwwwwwwwwwwwwwwwwwwwwwwww = l01Var;
                                }
                            }
                        }
                    }
                    int i23 = i17 + 1;
                    char c18 = cArr2[i17];
                    int i24 = 1;
                    while (i24 <= c18) {
                        int i25 = i23 + 1;
                        bz0 bz0Var = (bz0) ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cArr2[i23]);
                        ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(bz0Var);
                        bz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i24 - 1;
                        i24++;
                        i23 = i25;
                    }
                    if (ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ATNType.LEXER) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                            int i26 = i23 + 1;
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new hz0[cArr2[i23]];
                            int i27 = 0;
                            while (i27 < ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                                int i28 = i26 + 1;
                                LexerActionType lexerActionType = LexerActionType.values()[cArr2[i26]];
                                int i29 = i28 + 1;
                                char c19 = cArr2[i28];
                                if (c19 == 65535) {
                                    c19 = 65535;
                                }
                                int i30 = i29 + 1;
                                char c20 = cArr2[i29];
                                if (c20 == 65535) {
                                    c20 = 65535;
                                }
                                switch (lexerActionType.ordinal()) {
                                    case 0:
                                        jz0Var = new jz0(c19);
                                        break;
                                    case 1:
                                        jz0Var = new kz0(c19, c20);
                                        break;
                                    case 2:
                                        jz0Var = new mz0(c19);
                                        break;
                                    case 3:
                                        jz0Var = nz0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        break;
                                    case 4:
                                        jz0Var = oz0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        break;
                                    case 5:
                                        jz0Var = new pz0(c19);
                                        break;
                                    case 6:
                                        jz0Var = qz0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        break;
                                    case 7:
                                        jz0Var = new rz0(c19);
                                        break;
                                    default:
                                        throw new IllegalArgumentException(String.format(Locale.getDefault(), "The specified lexer action type %d is not valid.", lexerActionType));
                                }
                                ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i27] = jz0Var;
                                i27++;
                                i26 = i30;
                            }
                        } else {
                            ArrayList arrayList4 = new ArrayList();
                            for (sy0 sy0Var8 : ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                for (int i31 = 0; i31 < sy0Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i31++) {
                                    Transition Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = sy0Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i31);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 instanceof uy0) {
                                        uy0 uy0Var = (uy0) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                                        int i32 = uy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        kz0 kz0Var = new kz0(i32, uy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        sy0Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(i31, new uy0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i32, arrayList4.size(), false));
                                        arrayList4.add(kz0Var);
                                    }
                                }
                            }
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (hz0[]) arrayList4.toArray(new hz0[arrayList4.size()]);
                        }
                    }
                    for (sy0 sy0Var9 : ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if ((sy0Var9 instanceof k01) && ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[sy0Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            sy0 sy0Var10 = sy0Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if ((sy0Var10 instanceof sz0) && sy0Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (sy0Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01)) {
                                ((k01) sy0Var9).Wwwwwwwwwwwwwwwwwwwwwwwww = true;
                            }
                        }
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ly0Var);
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ATNType.PARSER) {
                        ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length];
                        for (int i33 = 0; i33 < ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; i33++) {
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i33] = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + i33 + 1;
                        }
                        for (int i34 = 0; i34 < ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; i34++) {
                            xy0 xy0Var = new xy0();
                            xy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i34;
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xy0Var);
                            zy0 zy0Var2 = new zy0();
                            zy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i34;
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zy0Var2);
                            xy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwww = zy0Var2;
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(xy0Var);
                            xy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() - 1;
                            zy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = xy0Var;
                            if (ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i34].Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                Iterator<sy0> it3 = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        sy0Var = it3.next();
                                        if (sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i34 && (sy0Var instanceof k01)) {
                                            sy0 sy0Var11 = sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            if ((sy0Var11 instanceof sz0) && sy0Var11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                                i = 0;
                                                if (sy0Var11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01) {
                                                }
                                            }
                                        }
                                    } else {
                                        i = 0;
                                        sy0Var = null;
                                    }
                                }
                                if (sy0Var == null) {
                                    throw new UnsupportedOperationException("Couldn't identify final state of the precedence rule prefix section.");
                                }
                                transition = ((k01) sy0Var).Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                            } else {
                                sy0Var = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i34];
                                transition = null;
                            }
                            for (sy0 sy0Var12 : ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                for (Transition transition2 : sy0Var12.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    if (transition2 != transition && transition2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == sy0Var) {
                                        transition2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zy0Var2;
                                    }
                                }
                            }
                            while (ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i34].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
                                d01[] d01VarArr2 = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                xy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d01VarArr2[i34].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(d01VarArr2[i34].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1));
                            }
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i34].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new dz0(xy0Var));
                            zy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new dz0(sy0Var));
                            yy0 yy0Var2 = new yy0();
                            ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yy0Var2);
                            yy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new wy0(zy0Var2, ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i34]));
                            xy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new dz0(yy0Var2));
                        }
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ly0Var);
                        }
                    }
                    return ly0Var;
                }
                int i35 = i5 + 1;
                char c21 = cArr2[i5];
                if (c21 == 0) {
                    ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((sy0) null);
                    i5 = i35;
                } else {
                    int i36 = i35 + 1;
                    char c22 = cArr2[i35];
                    if (c22 != 65535) {
                        c4 = c22;
                    }
                    switch (c21) {
                        case 0:
                            az0Var = null;
                            break;
                        case 1:
                            yy0Var = new yy0();
                            az0 az0Var3 = yy0Var;
                            az0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var3;
                            break;
                        case 2:
                            yy0Var = new d01();
                            az0 az0Var32 = yy0Var;
                            az0Var32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var32;
                            break;
                        case 3:
                            yy0Var = new xy0();
                            az0 az0Var322 = yy0Var;
                            az0Var322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var322;
                            break;
                        case 4:
                            yy0Var = new wz0();
                            az0 az0Var3222 = yy0Var;
                            az0Var3222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var3222;
                            break;
                        case 5:
                            yy0Var = new j01();
                            az0 az0Var32222 = yy0Var;
                            az0Var32222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var32222;
                            break;
                        case 6:
                            yy0Var = new m01();
                            az0 az0Var322222 = yy0Var;
                            az0Var322222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var322222;
                            break;
                        case 7:
                            yy0Var = new e01();
                            az0 az0Var3222222 = yy0Var;
                            az0Var3222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var3222222;
                            break;
                        case '\b':
                            yy0Var = new zy0();
                            az0 az0Var32222222 = yy0Var;
                            az0Var32222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var32222222;
                            break;
                        case '\t':
                            yy0Var = new l01();
                            az0 az0Var322222222 = yy0Var;
                            az0Var322222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var322222222;
                            break;
                        case '\n':
                            yy0Var = new k01();
                            az0 az0Var3222222222 = yy0Var;
                            az0Var3222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var3222222222;
                            break;
                        case 11:
                            yy0Var = new xz0();
                            az0 az0Var32222222222 = yy0Var;
                            az0Var32222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var32222222222;
                            break;
                        case '\f':
                            yy0Var = new sz0();
                            az0 az0Var322222222222 = yy0Var;
                            az0Var322222222222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c4;
                            az0Var = az0Var322222222222;
                            break;
                        default:
                            throw new IllegalArgumentException(String.format(Locale.getDefault(), "The specified state type %d is not valid.", Integer.valueOf(c21)));
                    }
                    if (c21 == c3) {
                        i2 = i36 + 1;
                        arrayList.add(new Pair((sz0) az0Var, Integer.valueOf(cArr2[i36])));
                    } else {
                        if (az0Var instanceof az0) {
                            i2 = i36 + 1;
                            arrayList2.add(new Pair(az0Var, Integer.valueOf(cArr2[i36])));
                        }
                        ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(az0Var);
                        i5 = i36;
                    }
                    i36 = i2;
                    ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(az0Var);
                    i5 = i36;
                }
                i4++;
                c3 = '\f';
            }
        } else {
            throw new UnsupportedOperationException(new InvalidClassException(ly0.class.getName(), String.format(Locale.getDefault(), "Could not deserialize ATN with version %d (expected %d).", Integer.valueOf(c), 3)));
        }
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char[] cArr, int i) {
        int i2 = i + 2;
        return (((cArr[i2 + 1] << 16) | cArr[i2]) << 32) | ((cArr[i] | (cArr[i + 1] << 16)) & 4294967295L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x00fe, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww < 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0109, code lost:
        if ((r0 instanceof me.tvspark.e01) == false) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ly0 ly0Var) {
        boolean z;
        Iterator<sy0> it = ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            sy0 next = it.next();
            if (next != null) {
                boolean z2 = false;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() <= 1);
                if (next instanceof wz0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((wz0) next).Wwwwwwwwwwwwwwwwwwwwwwwww != null);
                }
                if (next instanceof k01) {
                    k01 k01Var = (k01) next;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k01Var.Wwwwwwwwwwwwwwwwwwwwwwwwww != null);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 2);
                    if (k01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof j01) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof sz0);
                        z = !k01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else if (!(k01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof sz0)) {
                        throw new IllegalStateException();
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof j01);
                        z = k01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                }
                if (next instanceof l01) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof k01);
                }
                if (next instanceof sz0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((sz0) next).Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null);
                }
                if (next instanceof d01) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((d01) next).Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null);
                }
                if (next instanceof az0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((az0) next).Wwwwwwwwwwwwwwwwwwwwwwwwww != null);
                }
                if (next instanceof zy0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((zy0) next).Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null);
                }
                if (next instanceof bz0) {
                    bz0 bz0Var = (bz0) next;
                    if (bz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 1) {
                    }
                    z2 = true;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2);
                } else {
                    if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 1) {
                    }
                    z2 = true;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2);
                }
            }
        }
    }
}
