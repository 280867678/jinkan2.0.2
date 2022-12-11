package org.antlr.p055v4.runtime.misc;

import java.io.Serializable;
import me.tvspark.r40;

/* renamed from: org.antlr.v4.runtime.misc.Pair */
/* loaded from: classes4.dex */
public class Pair<A, B> implements Serializable {

    /* renamed from: a */
    public final A f4543a;

    /* renamed from: b */
    public final B f4544b;

    public Pair(A a, B b) {
        this.f4543a = a;
        this.f4544b = b;
    }

    public boolean equals(Object obj) {
        boolean equals;
        boolean equals2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        A a = this.f4543a;
        A a2 = pair.f4543a;
        if (a == null) {
            equals = a2 == null;
        } else {
            equals = a.equals(a2);
        }
        if (equals) {
            B b = this.f4544b;
            B b2 = pair.f4544b;
            if (b == null) {
                equals2 = b2 == null;
            } else {
                equals2 = b.equals(b2);
            }
            if (equals2) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.f4543a), this.f4544b), 2);
    }

    public String toString() {
        return String.format("(%s, %s)", this.f4543a, this.f4544b);
    }
}
