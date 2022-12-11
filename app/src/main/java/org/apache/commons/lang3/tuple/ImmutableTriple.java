package org.apache.commons.lang3.tuple;

/* loaded from: classes4.dex */
public final class ImmutableTriple<L, M, R> extends Triple<L, M, R> {
    public static final long serialVersionUID = 1;
    public final L left;
    public final M middle;
    public final R right;

    public ImmutableTriple(L l, M m, R r) {
        this.left = l;
        this.middle = m;
        this.right = r;
    }

    /* renamed from: of */
    public static <L, M, R> ImmutableTriple<L, M, R> m42of(L l, M m, R r) {
        return new ImmutableTriple<>(l, m, r);
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public M getMiddle() {
        return this.middle;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public R getRight() {
        return this.right;
    }
}
