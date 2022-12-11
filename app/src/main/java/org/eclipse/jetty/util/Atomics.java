package org.eclipse.jetty.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class Atomics {
    public static void updateMax(AtomicInteger atomicInteger, int i) {
        int i2;
        do {
            i2 = atomicInteger.get();
            if (i <= i2) {
                return;
            }
        } while (!atomicInteger.compareAndSet(i2, i));
    }

    public static void updateMax(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j <= j2) {
                return;
            }
        } while (!atomicLong.compareAndSet(j2, j));
    }

    public static void updateMin(AtomicInteger atomicInteger, int i) {
        int i2;
        do {
            i2 = atomicInteger.get();
            if (i >= i2) {
                return;
            }
        } while (!atomicInteger.compareAndSet(i2, i));
    }

    public static void updateMin(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j >= j2) {
                return;
            }
        } while (!atomicLong.compareAndSet(j2, j));
    }
}
