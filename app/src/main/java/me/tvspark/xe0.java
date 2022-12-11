package me.tvspark;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

/* loaded from: classes4.dex */
public class xe0 {

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public ze0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ze0();
        public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
            View view = new View(context);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
            view.setTag("xe0");
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public ye0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public ze0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Bitmap bitmap, ze0 ze0Var, boolean z, ye0 ye0Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bitmap;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ze0Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ye0Var;
        }
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
    }
}
