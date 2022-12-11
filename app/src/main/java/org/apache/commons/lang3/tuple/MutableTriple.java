package org.apache.commons.lang3.tuple;

/* loaded from: classes4.dex */
public class MutableTriple<L, M, R> extends Triple<L, M, R> {
    public static final long serialVersionUID = 1;
    public L left;
    public M middle;
    public R right;

    public MutableTriple() {
    }

    public MutableTriple(L l, M m, R r) {
        this.left = l;
        this.middle = m;
        this.right = r;
    }

    /* renamed from: of */
    public static <L, M, R> MutableTriple<L, M, R> m40of(L l, M m, R r) {
        return new MutableTriple<>(l, m, r);
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

    public void setLeft(L l) {
        this.left = l;
    }

    public void setMiddle(M m) {
        this.middle = m;
    }

    public void setRight(R r) {
        this.right = r;
    }
}
