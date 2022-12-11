package me.tvspark;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import me.tvspark.bf0;

/* loaded from: classes4.dex */
public class af0 implements Runnable {
    public final /* synthetic */ bf0 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ BitmapDrawable Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BitmapDrawable bitmapDrawable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = bitmapDrawable;
        }

        @Override // java.lang.Runnable
        public void run() {
            bf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = af0.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            BitmapDrawable bitmapDrawable = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            we0 we0Var = (we0) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ye0 ye0Var = we0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (ye0Var == null) {
                we0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setImageDrawable(bitmapDrawable);
            } else {
                ye0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmapDrawable);
            }
        }
    }

    public af0(bf0 bf0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = bf0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        bf0 bf0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bf0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(), bf0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bf0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            new Handler(Looper.getMainLooper()).post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmapDrawable));
        }
    }
}
