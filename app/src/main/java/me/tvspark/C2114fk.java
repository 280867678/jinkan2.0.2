package me.tvspark;

import android.content.Context;
import androidx.annotation.Nullable;
import com.just.agentweb.WebIndicator;
import com.stub.StubApp;
import me.tvspark.AbstractC2863zj;

/* renamed from: me.tvspark.fk */
/* loaded from: classes4.dex */
public final class C2114fk implements AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final AbstractC2410nk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2114fk(Context context) {
        C2188hk c2188hk = new C2188hk(C2208i3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, WebIndicator.MAX_UNIFORM_SPEED_DURATION, WebIndicator.MAX_UNIFORM_SPEED_DURATION, false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2188hk;
    }

    public C2114fk(Context context, @Nullable AbstractC2410nk abstractC2410nk, AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2410nk;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public AbstractC2863zj mo4450Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2077ek c2077ek = new C2077ek(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4450Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        AbstractC2410nk abstractC2410nk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2410nk != null) {
            c2077ek.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
        }
        return c2077ek;
    }
}
