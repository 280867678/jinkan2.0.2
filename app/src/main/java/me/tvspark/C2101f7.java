package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.f7 */
/* loaded from: classes4.dex */
public final class C2101f7 implements AbstractC2323l7 {
    @Nullable
    public static final Constructor<? extends AbstractC2175h7> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7};
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 112800;

    static {
        Constructor<? extends AbstractC2175h7> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(AbstractC2175h7.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating FLAC extension", e);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = constructor;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, List<AbstractC2175h7> list) {
        AbstractC2175h7 c2215ia;
        switch (i) {
            case 0:
                c2215ia = new C2215ia();
                break;
            case 1:
                c2215ia = new C2289ka();
                break;
            case 2:
                c2215ia = new C2363ma(0);
                break;
            case 3:
                c2215ia = new C1974c8(0);
                break;
            case 4:
                Constructor<? extends AbstractC2175h7> constructor = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (constructor == null) {
                    c2215ia = new C2139g8(0);
                    break;
                } else {
                    try {
                        list.add(constructor.newInstance(0));
                        return;
                    } catch (Exception e) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                    }
                }
            case 5:
                c2215ia = new C2250j8();
                break;
            case 6:
                c2215ia = new C2515q8(0);
                break;
            case 7:
                c2215ia = new C2815y8(0, -9223372036854775807L);
                break;
            case 8:
                list.add(new C2251j9(0, null, null, Collections.emptyList()));
                c2215ia = new C2362m9(0);
                break;
            case 9:
                c2215ia = new C2742w9();
                break;
            case 10:
                c2215ia = new C2068eb();
                break;
            case 11:
                c2215ia = new C2290kb(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new C2337ll(0L), new C2437oa(0), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                break;
            case 12:
                c2215ia = new C2438ob();
                break;
            default:
                return;
        }
        list.add(c2215ia);
    }

    @Override // me.tvspark.AbstractC2323l7
    public synchronized AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.EMPTY, new HashMap());
    }

    @Override // me.tvspark.AbstractC2323l7
    public synchronized AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        int[] iArr;
        arrayList = new ArrayList(14);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, arrayList);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, arrayList);
        }
        for (int i : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (i != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && i != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, arrayList);
            }
        }
        return (AbstractC2175h7[]) arrayList.toArray(new AbstractC2175h7[arrayList.size()]);
    }
}
