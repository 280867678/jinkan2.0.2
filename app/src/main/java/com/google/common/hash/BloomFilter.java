package com.google.common.hash;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.google.common.hash.BloomFilterStrategies;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import me.tvspark.AbstractC2573rt;
import me.tvspark.C2730vy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class BloomFilter<T> implements AbstractC2573rt<T>, Serializable {
    public final BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww bits;
    public final Funnel<? super T> funnel;
    public final int numHashFunctions;
    public final Strategy strategy;

    /* loaded from: classes3.dex */
    public static class SerialForm<T> implements Serializable {
        public static final long serialVersionUID = 1;
        public final long[] data;
        public final Funnel<? super T> funnel;
        public final int numHashFunctions;
        public final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bloomFilter.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.numHashFunctions = bloomFilter.numHashFunctions;
            this.funnel = bloomFilter.funnel;
            this.strategy = bloomFilter.strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    /* loaded from: classes3.dex */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public BloomFilter(BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, Funnel<? super T> funnel, Strategy strategy) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0, "numHashFunctions (%s) must be > 0", i);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 255 ? false : z, "numHashFunctions (%s) must be <= 255", i);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.bits = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.numHashFunctions = i;
            if (funnel == null) {
                throw null;
            }
            this.funnel = funnel;
            if (strategy == null) {
                throw null;
            }
            this.strategy = strategy;
            return;
        }
        throw null;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i) {
        return create(funnel, i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i, double d) {
        return create(funnel, i, d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j) {
        return create(funnel, j, 0.03d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d) {
        return create(funnel, j, d, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d, Strategy strategy) {
        if (funnel != null) {
            boolean z = true;
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "Expected insertions (%s) must be >= 0", j);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d > RoundRectDrawableWithShadow.COS_45, "False positive probability (%s) must be > 0.0", Double.valueOf(d));
            if (d >= 1.0d) {
                z = false;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "False positive probability (%s) must be < 1.0", Double.valueOf(d));
            if (strategy == null) {
                throw null;
            }
            if (i == 0) {
                j = 1;
            }
            long optimalNumOfBits = optimalNumOfBits(j, d);
            try {
                return new BloomFilter<>(new BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(optimalNumOfBits), optimalNumOfHashFunctions(j, optimalNumOfBits), funnel, strategy);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e);
            }
        }
        throw null;
    }

    public static long optimalNumOfBits(long j, double d) {
        if (d == RoundRectDrawableWithShadow.COS_45) {
            d = Double.MIN_VALUE;
        }
        return (long) ((Math.log(d) * (-j)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    public static int optimalNumOfHashFunctions(long j, long j2) {
        return Math.max(1, (int) Math.round(Math.log(2.0d) * (j2 / j)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i;
        int i2;
        int readInt;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, "InputStream");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(funnel, "Funnel");
        byte b = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i2 = dataInputStream.readByte() & 255;
                try {
                    readInt = dataInputStream.readInt();
                } catch (RuntimeException e) {
                    e = e;
                    b = readByte;
                    i = -1;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
                }
            } catch (RuntimeException e2) {
                e = e2;
                i2 = -1;
            }
            try {
                BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                long[] jArr = new long[readInt];
                for (int i3 = 0; i3 < readInt; i3++) {
                    jArr[i3] = dataInputStream.readLong();
                }
                return new BloomFilter<>(new BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr), i2, funnel, bloomFilterStrategies);
            } catch (RuntimeException e3) {
                e = e3;
                b = readByte;
                i = readInt;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
        } catch (RuntimeException e4) {
            e = e4;
            i = -1;
            i2 = -1;
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // me.tvspark.AbstractC2573rt
    @Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    public long approximateElementCount() {
        double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return C2730vy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((-Math.log1p(-(this.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.sum() / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2))) * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    public long bitSize() {
        return this.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(new BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.sum() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        if (bloomFilter != null) {
            return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
        }
        throw null;
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        long j;
        long j2;
        boolean z;
        if (bloomFilter != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
            boolean z2 = bitSize() == bloomFilter.bitSize();
            long bitSize = bitSize();
            long bitSize2 = bloomFilter.bitSize();
            if (z2) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
                BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.bits;
                BloomFilterStrategies.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bloomFilter.bits;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(), "BitArrays must be of equal length (%s != %s)", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length());
                for (int i = 0; i < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(); i++) {
                    long j3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                    while (true) {
                        j = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                        j2 = j | j3;
                        if (j == j2) {
                            z = false;
                            break;
                        } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(i, j, j2)) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(Long.bitCount(j2) - Long.bitCount(j));
                    }
                }
                return;
            }
            throw new IllegalArgumentException(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("BloomFilters must have the same size underlying bit arrays (%s != %s)", Long.valueOf(bitSize), Long.valueOf(bitSize2)));
        }
        throw null;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        long ordinal = this.strategy.ordinal();
        byte b = (byte) ordinal;
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((long) b) == ordinal, "Out of range: %s", ordinal);
        dataOutputStream.writeByte(b);
        long j = this.numHashFunctions;
        if ((j >> 8) != 0) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "out of range: %s", j);
        dataOutputStream.writeByte((byte) j);
        dataOutputStream.writeInt(this.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length());
        for (int i = 0; i < this.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(); i++) {
            dataOutputStream.writeLong(this.bits.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i));
        }
    }
}
