package me.tvspark;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Registry;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import me.tvspark.Kkkkkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkk;

/* loaded from: classes4.dex */
public class Kkkkkkkkkkkkkk extends ContextWrapper {
    @VisibleForTesting
    public static final Kkkkkkkkkkk<?, ?> Wwwwwwwwwwwwwwwwwwwwwwww = new Kkkkkkkkkkkkkkkkk();
    @Nullable
    @GuardedBy("this")
    public C2544r0 Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final IIl Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Map<Class<?>, Kkkkkkkkkkk<?, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<AbstractC2507q0<Object>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2807y0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Registry Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Kkkkkkkkkkkkkk(@NonNull Context context, @NonNull OO000 oo000, @NonNull Registry registry, @NonNull C2807y0 c2807y0, @NonNull Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @NonNull Map<Class<?>, Kkkkkkkkkkk<?, ?>> map, @NonNull List<AbstractC2507q0<Object>> list, @NonNull IIl iIl, boolean z, int i) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = registry;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2807y0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = map;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = iIl;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public synchronized C2544r0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (((Kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                C2544r0 c2544r0 = new C2544r0();
                c2544r0.Wwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = c2544r0;
            } else {
                throw null;
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
