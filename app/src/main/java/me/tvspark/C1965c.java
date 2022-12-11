package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.c */
/* loaded from: classes4.dex */
public class C1965c {
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public Bitmap Wwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww;
    public Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final OO0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Kkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Kkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.c$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Handler.Callback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                C1965c.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj);
                return true;
            } else if (i != 2) {
                return false;
            } else {
                C1965c.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj);
                return false;
            }
        }
    }

    /* renamed from: me.tvspark.c$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @VisibleForTesting
    /* renamed from: me.tvspark.c$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2693v0<Bitmap> {
        public Bitmap Wwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwww;
        public final Handler Wwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Handler handler, int i, long j) {
            this.Wwwwwwwwwwwwwwwwwwwww = handler;
            this.Wwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwww = j;
        }

        @Override // me.tvspark.AbstractC1930b1
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
            this.Wwwwwwwwwwwwwwwwww = null;
        }

        @Override // me.tvspark.AbstractC1930b1
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj, @Nullable AbstractC2058e1 abstractC2058e1) {
            this.Wwwwwwwwwwwwwwwwww = (Bitmap) obj;
            this.Wwwwwwwwwwwwwwwwwwwww.sendMessageAtTime(this.Wwwwwwwwwwwwwwwwwwwww.obtainMessage(1, this), this.Wwwwwwwwwwwwwwwwwww);
        }
    }

    public C1965c(Kkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkk, Kkkkkkk kkkkkkk, int i, int i2, Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll, Bitmap bitmap) {
        OO0 oo0 = kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
        Kkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww.getBaseContext());
        Kkkkkkkkkkkkk<Bitmap> mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww.getBaseContext()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IIll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Handler handler = new Handler(Looper.getMainLooper(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handler;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = kkkkkkk;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, bitmap);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww == null, "Pending target must be null when starting from the first frame");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwww = null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(), uptimeMillis);
        Kkkkkkkkkkkkk<Bitmap> mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww.mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2243j1(Double.valueOf(Math.random()))));
        mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, null, mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2391n1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @VisibleForTesting
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).sendToTarget();
        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww != null) {
                Bitmap bitmap = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (bitmap != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
                    this.Wwwwwwwwwwwwwwwwwwwwww = null;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(size).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).sendToTarget();
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll, Bitmap bitmap) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, "Argument must not be null");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwww = bitmap;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww.mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, true));
        this.Wwwwwwwwwwwwwwwwwwww = C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
        this.Wwwwwwwwwwwwwwwwwww = bitmap.getWidth();
        this.Wwwwwwwwwwwwwwwwww = bitmap.getHeight();
    }
}
