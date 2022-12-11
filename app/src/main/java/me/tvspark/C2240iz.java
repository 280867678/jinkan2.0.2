package me.tvspark;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.C2166gz;

/* renamed from: me.tvspark.iz */
/* loaded from: classes4.dex */
public class C2240iz extends C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ TypeVariable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2240iz(C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AtomicInteger atomicInteger, TypeVariable typeVariable) {
        super(atomicInteger, null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = typeVariable;
    }

    @Override // me.tvspark.C2166gz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public TypeVariable<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type[] typeArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
        linkedHashSet.addAll(Arrays.asList(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBounds()));
        if (linkedHashSet.size() > 1) {
            linkedHashSet.remove(Object.class);
        }
        return super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Type[]) linkedHashSet.toArray(new Type[0]));
    }
}
