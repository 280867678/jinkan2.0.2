package me.tvspark;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.jl */
/* loaded from: classes4.dex */
public final class C2263jl {
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2263jl(Handler handler) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handler;
    }

    public Message Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable Object obj) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(i, obj);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.sendEmptyMessage(i);
    }
}
