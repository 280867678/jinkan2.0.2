package com.google.common.collect;

/* loaded from: classes3.dex */
public class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
    public static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
    public static final long serialVersionUID = 0;

    public EmptyImmutableListMultimap() {
        super(ImmutableMap.m3900of(), 0);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
