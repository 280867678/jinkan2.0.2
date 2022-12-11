package org.apache.commons.lang3.tuple;

/* loaded from: classes4.dex */
public class MutablePair<L, R> extends Pair<L, R> {
    public static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    public MutablePair() {
    }

    public MutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    /* renamed from: of */
    public static <L, R> MutablePair<L, R> m41of(L l, R r) {
        return new MutablePair<>(l, r);
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    /* renamed from: getLeft */
    public L mo5161getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    /* renamed from: getRight */
    public R mo5162getRight() {
        return this.right;
    }

    public void setLeft(L l) {
        this.left = l;
    }

    public void setRight(R r) {
        this.right = r;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        R mo5162getRight = mo5162getRight();
        setRight(r);
        return mo5162getRight;
    }
}
