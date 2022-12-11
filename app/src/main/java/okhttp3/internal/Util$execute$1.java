package okhttp3.internal;

import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class Util$execute$1 implements Runnable {
    public final /* synthetic */ xg0 $block;
    public final /* synthetic */ String $name;

    public Util$execute$1(String str, xg0 xg0Var) {
        this.$name = str;
        this.$block = xg0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.$name;
        Thread currentThread = Thread.currentThread();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            this.$block.mo4969invoke();
        } finally {
            currentThread.setName(name);
        }
    }
}
