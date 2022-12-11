package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import me.tvspark.C2786xg;

/* renamed from: me.tvspark.fi */
/* loaded from: classes4.dex */
public final class C2112fi implements AbstractC1909ah {
    public final Map<String, String> Wwwwwwwwwwwwwwwwwwww;
    public final Map<String, C2038di> Wwwwwwwwwwwwwwwwwwwww;
    public final Map<String, C2075ei> Wwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final C1984ci Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2112fi(C1984ci c1984ci, Map<String, C2075ei> map, Map<String, C2038di> map2, Map<String, String> map3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c1984ci;
        this.Wwwwwwwwwwwwwwwwwwwww = map2;
        this.Wwwwwwwwwwwwwwwwwwww = map3;
        this.Wwwwwwwwwwwwwwwwwwwwww = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        if (c1984ci != null) {
            TreeSet<Long> treeSet = new TreeSet<>();
            int i = 0;
            c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(treeSet, false);
            long[] jArr = new long[treeSet.size()];
            Iterator<Long> it = treeSet.iterator();
            while (it.hasNext()) {
                jArr[i] = it.next().longValue();
                i++;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = jArr;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC1909ah
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        C1910ai[] c1910aiArr;
        C1984ci c1984ci = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        Map<String, C2075ei> map = this.Wwwwwwwwwwwwwwwwwwwwww;
        Map<String, C2038di> map2 = this.Wwwwwwwwwwwwwwwwwwwww;
        Map<String, String> map3 = this.Wwwwwwwwwwwwwwwwwwww;
        if (c1984ci != null) {
            ArrayList arrayList = new ArrayList();
            c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwww, arrayList);
            TreeMap treeMap = new TreeMap();
            c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, false, c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwww, treeMap);
            c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, map, treeMap);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str = map3.get(pair.second);
                if (str != null) {
                    byte[] decode = Base64.decode(str, 0);
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                    C2038di c2038di = map2.get(pair.first);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2038di);
                    arrayList2.add(new C2786xg(null, null, decodeByteArray, c2038di.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, c2038di.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2038di.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Integer.MIN_VALUE, -3.4028235E38f, c2038di.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2038di.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, false, -16777216, c2038di.Wwwwwwwwwwwwwwwwwwwwwwwww, null));
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                C2038di c2038di2 = map2.get(entry.getKey());
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2038di2);
                C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) entry.getValue();
                CharSequence charSequence = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
                for (C1910ai c1910ai : (C1910ai[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), C1910ai.class)) {
                    spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(c1910ai), spannableStringBuilder.getSpanEnd(c1910ai), (CharSequence) "");
                }
                for (int i = 0; i < spannableStringBuilder.length(); i++) {
                    if (spannableStringBuilder.charAt(i) == ' ') {
                        int i2 = i + 1;
                        int i3 = i2;
                        while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                            i3++;
                        }
                        int i4 = i3 - i2;
                        if (i4 > 0) {
                            spannableStringBuilder.delete(i, i4 + i);
                        }
                    }
                }
                if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                    spannableStringBuilder.delete(0, 1);
                }
                for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
                    if (spannableStringBuilder.charAt(i5) == '\n') {
                        int i6 = i5 + 1;
                        if (spannableStringBuilder.charAt(i6) == ' ') {
                            spannableStringBuilder.delete(i6, i5 + 2);
                        }
                    }
                }
                if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                    spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
                }
                for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
                    if (spannableStringBuilder.charAt(i7) == ' ') {
                        int i8 = i7 + 1;
                        if (spannableStringBuilder.charAt(i8) == '\n') {
                            spannableStringBuilder.delete(i7, i8);
                        }
                    }
                }
                if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                    spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
                }
                float f = c2038di2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i9 = c2038di2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i9;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2038di2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2038di2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = c2038di2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                float f2 = c2038di2.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                int i10 = c2038di2.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww = f2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = i10;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = c2038di2.Wwwwwwwwwwwwwwwwwwwwwwwww;
                arrayList2.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            return arrayList2;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.length;
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, j, false, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww.length) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC1909ah
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwww[i];
    }
}
