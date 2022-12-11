package me.tvspark;

import java.util.Random;

@ef0
/* loaded from: classes4.dex */
public final class si0 extends ri0 {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // me.tvspark.ri0
    public Random Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Random random = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(random, "implStorage.get()");
        return random;
    }
}
