package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import me.tvspark.AbstractC2746wd;
import me.tvspark.C2336lk;

/* renamed from: me.tvspark.xd */
/* loaded from: classes4.dex */
public final class C2783xd<T extends AbstractC2746wd<T>> implements C2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
    @Nullable
    public final List<C2820yd> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2783xd(C2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @Nullable List<C2820yd> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
    }

    @Override // me.tvspark.C2336lk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, InputStream inputStream) throws IOException {
        T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, inputStream);
        List<C2820yd> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return (list == null || list.isEmpty()) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : (AbstractC2746wd) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
