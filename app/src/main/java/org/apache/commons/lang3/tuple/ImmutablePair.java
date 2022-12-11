package org.apache.commons.lang3.tuple;

/* loaded from: classes4.dex */
public final class ImmutablePair<L, R> extends Pair<L, R> {
    public static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public ImmutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    /* renamed from: of */
    public static <L, R> ImmutablePair<L, R> m43of(L l, R r) {
        return new ImmutablePair<>(l, r);
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

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }
}
