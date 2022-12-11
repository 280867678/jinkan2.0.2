package me.tvspark;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;

/* renamed from: me.tvspark.oy */
/* loaded from: classes4.dex */
public interface AbstractC2461oy {
    <T> HashCode hashObject(T t, Funnel<? super T> funnel);

    AbstractC2504py newHasher();
}
