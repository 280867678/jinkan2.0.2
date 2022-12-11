package me.tvspark;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;

/* renamed from: me.tvspark.Ss */
/* loaded from: classes4.dex */
public final class C1887Ss {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.Ss$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* renamed from: me.tvspark.Ss$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final DisplayMetrics Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DisplayMetrics displayMetrics) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = displayMetrics;
        }
    }

    /* renamed from: me.tvspark.Ss$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final int Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public ActivityManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2.0f;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.4f;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.33f;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwww = 4194304;

        static {
            Wwwwwwwwwwwwwwwwwwwwwwwwww = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isLowRamDevice()) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.0f;
        }
    }

    public C1887Ss(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isLowRamDevice() ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww / 2 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        ActivityManager activityManager = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float f = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int round = Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (activityManager.isLowRamDevice() ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww : f));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float f2 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.widthPixels * ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.heightPixels * 4;
        int round2 = Math.round(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww * f2);
        int round3 = Math.round(f2 * wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i = round - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (round3 + round2 <= i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = round3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = round2;
        } else {
            float f3 = i;
            float f4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f6 = f3 / (f4 + f5);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.round(f5 * f6);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.round(f6 * wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(round);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getMemoryClass();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isLowRamDevice();
        }
    }

    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Formatter.formatFileSize(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
    }
}
