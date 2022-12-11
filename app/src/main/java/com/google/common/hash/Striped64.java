package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public abstract class Striped64 extends Number {
    public static final Unsafe UNSAFE;
    public static final long baseOffset;
    public static final long busyOffset;
    public volatile transient long base;
    public volatile transient int busy;
    public volatile transient Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] cells;
    public static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    public static final Random rng = new Random();
    public static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final Unsafe Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unsafe;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unsafe.objectFieldOffset(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getDeclaredField("Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSwapLong(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2);
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    public final boolean casBase(long j, long j2) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j, j2);
    }

    public final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    /* renamed from: fn */
    public abstract long mo3824fn(long j, long j2);

    public final void internalReset(long j) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.cells;
        this.base = j;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != null) {
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void retryUpdate(long j, int[] iArr, boolean z) {
        int i;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i = rng.nextInt();
            if (i == 0) {
                i = 1;
            }
            iArr2[0] = i;
        } else {
            i = iArr[0];
            iArr2 = iArr;
        }
        int i2 = i;
        boolean z4 = false;
        boolean z5 = z;
        while (true) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.cells;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != null && (length = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) > 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[(length - 1) & i2];
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    if (this.busy == 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = this.cells;
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 != null && (length2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2.length) > 0) {
                                    int i3 = (length2 - 1) & i2;
                                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[i3] == null) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[i3] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                        z3 = true;
                                        if (!z3) {
                                            return;
                                        }
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                }
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                } else if (!z5) {
                    z5 = true;
                } else {
                    long j2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, mo3824fn(j2, j))) {
                        return;
                    }
                    if (length < NCPU && this.cells == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
                        if (!z4) {
                            z4 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr3 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[length << 1];
                                    for (int i4 = 0; i4 < length; i4++) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr3[i4] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i4];
                                    }
                                    this.cells = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr3;
                                }
                                this.busy = 0;
                                z4 = false;
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                }
                int i5 = i2 ^ (i2 << 13);
                int i6 = i5 ^ (i5 >>> 17);
                i2 = i6 ^ (i6 << 5);
                iArr2[0] = i2;
            } else if (this.busy == 0 && this.cells == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr && casBusy()) {
                try {
                    if (this.cells == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr4 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2];
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr4[i2 & 1] = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                        this.cells = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr4;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                } finally {
                }
            } else {
                long j3 = this.base;
                if (casBase(j3, mo3824fn(j3, j))) {
                    return;
                }
            }
        }
    }
}
