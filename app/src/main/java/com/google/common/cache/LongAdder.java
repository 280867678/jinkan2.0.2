package com.google.common.cache;

import com.google.common.cache.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import me.tvspark.AbstractC2087eu;

/* loaded from: classes3.dex */
public final class LongAdder extends Striped64 implements Serializable, AbstractC2087eu {
    public static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // me.tvspark.AbstractC2087eu
    public void add(long j) {
        int length;
        Striped64.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Striped64.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.cells;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr == null) {
            long j2 = this.base;
            if (casBase(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z = true;
        if (iArr != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != null && (length = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) >= 1 && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[(length - 1) & iArr[0]]) != null) {
            long j3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3, j3 + j);
            if (z) {
                return;
            }
        }
        retryUpdate(j, iArr, z);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // com.google.common.cache.Striped64
    /* renamed from: fn */
    public final long mo3929fn(long j, long j2) {
        return j + j2;
    }

    @Override // me.tvspark.AbstractC2087eu
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // me.tvspark.AbstractC2087eu
    public long sum() {
        long j = this.base;
        Striped64.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.cells;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != null) {
            for (Striped64.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    j += wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
        }
        return j;
    }

    public long sumThenReset() {
        long j = this.base;
        Striped64.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.cells;
        this.base = 0L;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != null) {
            for (Striped64.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    j += wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
