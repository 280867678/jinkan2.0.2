package me.tvspark;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;

/* renamed from: me.tvspark.jz */
/* loaded from: classes4.dex */
public class C2277jz extends TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K> {
    public C2277jz(TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww, TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
        super(wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public ImmutableList<K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends K> iterable) {
        ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww builder = ImmutableList.builder();
        for (Object obj : iterable) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj).isInterface()) {
                builder.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ImmutableList.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj);
            }
        }
        return super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // com.google.common.reflect.TypeToken.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public Iterable<? extends K> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k) {
        return ImmutableSet.m3877of();
    }
}
