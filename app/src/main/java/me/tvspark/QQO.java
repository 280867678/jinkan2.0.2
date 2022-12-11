package me.tvspark;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
/* loaded from: classes4.dex */
public class QQO implements QQOOO {
    public static final Bitmap.Config[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Bitmap.Config[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Bitmap.Config[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Bitmap.Config[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Bitmap.Config[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final QQOOOOOOO<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new QQOOOOOOO<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends OO00<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        @Override // me.tvspark.OO00
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Bitmap.Config config) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = config;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements QQOO {
        public Bitmap.Config Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return false;
        }

        public int hashCode() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 31;
            Bitmap.Config config = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return i + (config != null ? config.hashCode() : 0);
        }

        @Override // me.tvspark.QQOO
        public void offer() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        public String toString() {
            return QQO.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = configArr;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = configArr;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    @Override // me.tvspark.QQOOO
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap), bitmap.getConfig());
    }

    @Override // me.tvspark.QQOOO
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
        return C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
    }

    @Override // me.tvspark.QQOOO
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, Bitmap.Config config) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, config), config);
    }

    @Override // me.tvspark.QQOOO
    @Nullable
    public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, config);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = config;
        int i3 = 0;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[config.ordinal()];
            configArr = i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? new Bitmap.Config[]{config} : Wwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            configArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        int length = configArr.length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i3];
            Integer ceilingKey = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(config2).ceilingKey(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
            if (ceilingKey == null || ceilingKey.intValue() > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 * 8) {
                i3++;
            } else if (ceilingKey.intValue() != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 || (config2 != null ? !config2.equals(config) : config != null)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ceilingKey.intValue(), config2);
            }
        }
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.reconfigure(i, i2, config);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
    }

    public final NavigableMap<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // me.tvspark.QQOOO
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap), bitmap.getConfig());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, bitmap);
        NavigableMap<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap.getConfig());
        Integer num = (Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.get(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        Integer valueOf = Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.put(valueOf, Integer.valueOf(i));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap.getConfig());
        Integer num2 = (Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.remove(num);
                return;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap) + ", this: " + this);
    }

    @Override // me.tvspark.QQOOO
    @Nullable
    public Bitmap removeLast() {
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf(C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SizeConfigStrategy{groupedMap=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(entry.getKey());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('[');
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(entry.getValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("], ");
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.replace(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length() - 2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length(), "");
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(")}");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}
