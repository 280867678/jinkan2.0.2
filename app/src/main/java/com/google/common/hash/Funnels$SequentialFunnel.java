package com.google.common.hash;

import java.io.Serializable;
import me.tvspark.AbstractC2652ty;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Funnels$SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
    public final Funnel<E> elementFunnel;

    public Funnels$SequentialFunnel(Funnel<E> funnel) {
        if (funnel != null) {
            this.elementFunnel = funnel;
            return;
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Funnels$SequentialFunnel) {
            return this.elementFunnel.equals(((Funnels$SequentialFunnel) obj).elementFunnel);
        }
        return false;
    }

    public void funnel(Iterable<? extends E> iterable, AbstractC2652ty abstractC2652ty) {
        for (E e : iterable) {
            this.elementFunnel.funnel(e, abstractC2652ty);
        }
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(Object obj, AbstractC2652ty abstractC2652ty) {
        funnel((Iterable) ((Iterable) obj), abstractC2652ty);
    }

    public int hashCode() {
        return Funnels$SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Funnels.sequentialFunnel(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.elementFunnel);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
