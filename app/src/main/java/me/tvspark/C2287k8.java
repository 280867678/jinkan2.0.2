package me.tvspark;

import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.k8 */
/* loaded from: classes4.dex */
public final class C2287k8 extends TagPayloadReader {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
    public long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[0];
    public long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[0];

    public C2287k8() {
        super(new C2138g7());
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
        int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww);
        return new String(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, Wwwwwwwwwwwwwwwww);
    }

    @Nullable
    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        if (i != 0) {
            boolean z = false;
            if (i == 1) {
                if (c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 8) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
                    }
                    if (i != 10) {
                        if (i != 11) {
                            return null;
                        }
                        Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwww())).doubleValue());
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        return date;
                    }
                    int Wwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwww();
                    ArrayList arrayList = new ArrayList(Wwwwwwwwwwwwwwwwwww);
                    for (int i2 = 0; i2 < Wwwwwwwwwwwwwwwwwww; i2++) {
                        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, c2078el.Wwwwwwwwwwwwwwwwwwwwww());
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                    }
                    return arrayList;
                }
                HashMap hashMap = new HashMap();
                while (true) {
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
                    int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwww == 9) {
                        return hashMap;
                    }
                    Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        hashMap.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                }
            } else {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
            }
        } else {
            return Double.valueOf(Double.longBitsToDouble(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwww()));
        }
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j) {
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 2 && "onMetaData".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el)) && c2078el.Wwwwwwwwwwwwwwwwwwwwww() == 8) {
            HashMap<String, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
            Object obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get("duration");
            if (obj instanceof Double) {
                double doubleValue = ((Double) obj).doubleValue();
                if (doubleValue > RoundRectDrawableWithShadow.COS_45) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (long) (doubleValue * 1000000.0d);
                }
            }
            Object obj2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[size];
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[size];
                    for (int i = 0; i < size; i++) {
                        Object obj5 = list.get(i);
                        Object obj6 = list2.get(i);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[0];
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[0];
                            break;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = ((Double) obj5).longValue();
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        return true;
    }

    public static HashMap<String, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int Wwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwww();
        HashMap<String, Object> hashMap = new HashMap<>(Wwwwwwwwwwwwwwwwwww);
        for (int i = 0; i < Wwwwwwwwwwwwwwwwwww; i++) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, c2078el.Wwwwwwwwwwwwwwwwwwwwww());
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                hashMap.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return hashMap;
    }
}
