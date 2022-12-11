package me.tvspark;

import android.widget.Toast;
import androidx.annotation.NonNull;
import me.tvspark.cl0;

/* loaded from: classes4.dex */
public abstract class zk0<T extends cl0> implements bl0, sk0 {
    public T Wwwwwwwwwwwwwwwwwwwwwwww;

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4928getContext());
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4928getContext(), "请关闭网络代理后重试", 1).show();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull cl0 cl0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cl0Var;
    }
}
