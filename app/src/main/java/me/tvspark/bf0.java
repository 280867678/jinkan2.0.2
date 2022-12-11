package me.tvspark;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class bf0 {
    public static ExecutorService Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Executors.newCachedThreadPool();
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ze0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public WeakReference<Context> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public bf0(Context context, Bitmap bitmap, ze0 ze0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context.getResources();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ze0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new WeakReference<>(context);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bitmap;
    }
}
