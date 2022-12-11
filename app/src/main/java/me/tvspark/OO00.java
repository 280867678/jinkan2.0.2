package me.tvspark;

import java.util.Queue;
import me.tvspark.QQOO;

/* loaded from: classes4.dex */
public abstract class OO00<T extends QQOO> {
    public final Queue<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20);

    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        T poll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.poll();
        return poll == null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : poll;
    }

    public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() < 20) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.offer(t);
        }
    }
}
