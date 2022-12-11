package me.tvspark;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.C1543ak;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import me.tvspark.C2786xg;
import org.apache.commons.lang3.StringUtils;

/* renamed from: me.tvspark.ci */
/* loaded from: classes4.dex */
public final class C1984ci {
    public List<C1984ci> Wwwwwwwwwwwwwwwwwwwwww;
    public final HashMap<String, Integer> Wwwwwwwwwwwwwwwwwwwwwww;
    public final HashMap<String, Integer> Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C1984ci Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1984ci(@Nullable String str, @Nullable String str2, long j, long j2, @Nullable C2075ei c2075ei, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable C1984ci c1984ci) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = str4;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2075ei;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = strArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2 != null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        if (str3 != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = c1984ci;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
            this.Wwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
            return;
        }
        throw null;
    }

    public static C1984ci Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return new C1984ci(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", StringUtils.SPACE).replaceAll("[ \t\\x0B\f\r]+", StringUtils.SPACE), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        List<C1984ci> list = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public C1984ci Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        List<C1984ci> list = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j) && "div".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            list.add(new Pair<>(str, this.Wwwwwwwwwwwwwwwwwwwwwwwwww));
            return;
        }
        for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, str, list);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeSet<Long> treeSet, boolean z) {
        boolean equals = C1543ak.f3013ax.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        boolean equals2 = "div".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (z || equals || (equals2 && this.Wwwwwwwwwwwwwwwwwwwwwwwwww != null)) {
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            this.Wwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(treeSet, z || equals);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1984ci c1984ci) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.add(c1984ci);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L) || (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= j && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L) || ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L && j < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= j && j < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public static SpannableStringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Map<String, C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> map) {
        if (!map.containsKey(str)) {
            C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SpannableStringBuilder();
            map.put(str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        CharSequence charSequence = map.get(str).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
        return (SpannableStringBuilder) charSequence;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, Map<String, C2075ei> map, Map<String, C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> map2) {
        C1984ci c1984ci;
        boolean z;
        int i;
        Object absoluteSizeSpan;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j)) {
            return;
        }
        for (Map.Entry<String, Integer> entry : this.Wwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
            String key = entry.getKey();
            int intValue = this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(key) ? this.Wwwwwwwwwwwwwwwwwwwwwwww.get(key).intValue() : 0;
            int intValue2 = entry.getValue().intValue();
            if (intValue != intValue2) {
                C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = map2.get(key);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, map);
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = spannableStringBuilder;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    C1984ci c1984ci2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    int i2 = -1;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != -1) {
                        spannableStringBuilder.setSpan(new StyleSpan(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()), intValue, intValue2, 33);
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, new ForegroundColorSpan(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), intValue, intValue2, 33);
                        } else {
                            throw new IllegalStateException("Font color has not been defined.");
                        }
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, new BackgroundColorSpan(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), intValue, intValue2, 33);
                        } else {
                            throw new IllegalStateException("Background color has not been defined.");
                        }
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, new TypefaceSpan(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), intValue, intValue2, 33);
                    }
                    int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
                    if (i3 == 2) {
                        while (true) {
                            if (c1984ci2 == null) {
                                c1984ci2 = null;
                                break;
                            }
                            C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1984ci2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1984ci2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, map);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww == 1) {
                                break;
                            }
                            c1984ci2 = c1984ci2.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        if (c1984ci2 != null) {
                            ArrayDeque arrayDeque = new ArrayDeque();
                            arrayDeque.push(c1984ci2);
                            while (true) {
                                if (arrayDeque.isEmpty()) {
                                    c1984ci = null;
                                    break;
                                }
                                c1984ci = (C1984ci) arrayDeque.pop();
                                C2075ei Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, map);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww == 3) {
                                    break;
                                }
                                for (int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1; Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 >= 0; Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4--) {
                                    arrayDeque.push(c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4));
                                }
                            }
                            if (c1984ci != null && c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1) {
                                z = false;
                                if (c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                                    String str = c1984ci.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                                    C2075ei c2075ei = c1984ci2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (c2075ei != null) {
                                        i2 = c2075ei.Wwwwwwwwwwwwwwwwwwwww;
                                    }
                                    spannableStringBuilder.setSpan(new C2635th(str, i2), intValue, intValue2, 33);
                                }
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww == 1) {
                                    z = true;
                                }
                                if (z) {
                                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, new C2598sh(), intValue, intValue2, 33);
                                }
                                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
                                if (i != 1) {
                                    absoluteSizeSpan = new AbsoluteSizeSpan((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, true);
                                } else if (i == 2) {
                                    absoluteSizeSpan = new RelativeSizeSpan(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                                } else {
                                    if (i == 3) {
                                        absoluteSizeSpan = new RelativeSizeSpan(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww / 100.0f);
                                    }
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
                                }
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, absoluteSizeSpan, intValue, intValue2, 33);
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
                            }
                        }
                    } else if (i3 == 3 || i3 == 4) {
                        spannableStringBuilder.setSpan(new C1910ai(), intValue, intValue2, 33);
                    }
                    z = false;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww == 1) {
                    }
                    if (z) {
                    }
                    i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i != 1) {
                    }
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, absoluteSizeSpan, intValue, intValue2, 33);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
                } else {
                    continue;
                }
            }
        }
        for (int i4 = 0; i4 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i4++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, map, map2);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z, String str, Map<String, C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> map) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        if ("metadata".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        if (!"".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && z) {
            SpannableStringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, map);
            String str2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((CharSequence) str2);
        } else if ("br".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, map).append('\n');
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j)) {
            for (Map.Entry<String, C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> entry : map.entrySet()) {
                CharSequence charSequence = entry.getValue().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.put(entry.getKey(), Integer.valueOf(charSequence.length()));
            }
            boolean equals = C1543ak.f3013ax.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, z || equals, str, map);
            }
            if (equals) {
                SpannableStringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, map);
                int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.charAt(length) == ' ');
                if (length >= 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.charAt(length) != '\n') {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('\n');
                }
            }
            for (Map.Entry<String, C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> entry2 : map.entrySet()) {
                CharSequence charSequence2 = entry2.getValue().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence2);
                this.Wwwwwwwwwwwwwwwwwwwwwww.put(entry2.getKey(), Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
