package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Map;
import me.tvspark.outline;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* loaded from: classes4.dex */
public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    public static final long serialVersionUID = 4954918890077093841L;

    /* renamed from: of */
    public static <L, R> Pair<L, R> m39of(L l, R r) {
        return new ImmutablePair(l, r);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Pair) ((Pair) obj));
    }

    public int compareTo(Pair<L, R> pair) {
        return new CompareToBuilder().append(mo5161getLeft(), pair.mo5161getLeft()).append(mo5162getRight(), pair.mo5162getRight()).toComparison();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return ObjectUtils.equals(getKey(), entry.getKey()) && ObjectUtils.equals(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return mo5161getLeft();
    }

    /* renamed from: getLeft */
    public abstract L mo5161getLeft();

    /* renamed from: getRight */
    public abstract R mo5162getRight();

    @Override // java.util.Map.Entry
    public R getValue() {
        return mo5162getRight();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        int i = 0;
        int hashCode = getKey() == null ? 0 : getKey().hashCode();
        if (getValue() != null) {
            i = getValue().hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('(');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(mo5161getLeft());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(mo5162getRight());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String toString(String str) {
        return String.format(str, mo5161getLeft(), mo5162getRight());
    }
}
