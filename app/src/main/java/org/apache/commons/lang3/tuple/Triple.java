package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import me.tvspark.outline;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* loaded from: classes4.dex */
public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    public static final long serialVersionUID = 1;

    /* renamed from: of */
    public static <L, M, R> Triple<L, M, R> m38of(L l, M m, R r) {
        return new ImmutableTriple(l, m, r);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Triple) ((Triple) obj));
    }

    public int compareTo(Triple<L, M, R> triple) {
        return new CompareToBuilder().append(getLeft(), triple.getLeft()).append(getMiddle(), triple.getMiddle()).append(getRight(), triple.getRight()).toComparison();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return ObjectUtils.equals(getLeft(), triple.getLeft()) && ObjectUtils.equals(getMiddle(), triple.getMiddle()) && ObjectUtils.equals(getRight(), triple.getRight());
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public int hashCode() {
        int i = 0;
        int hashCode = (getLeft() == null ? 0 : getLeft().hashCode()) ^ (getMiddle() == null ? 0 : getMiddle().hashCode());
        if (getRight() != null) {
            i = getRight().hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('(');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getLeft());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getMiddle());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRight());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String toString(String str) {
        return String.format(str, getLeft(), getMiddle(), getRight());
    }
}
