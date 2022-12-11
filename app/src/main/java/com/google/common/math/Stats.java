package com.google.common.math;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import me.tvspark.C2456ot;
import me.tvspark.C2878zy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class Stats implements Serializable {
    public static final int BYTES = 40;
    public static final long serialVersionUID = 0;
    public final long count;
    public final double max;
    public final double mean;
    public final double min;
    public final double sumOfSquaresOfDeltas;

    public Stats(long j, double d, double d2, double d3, double d4) {
        this.count = j;
        this.mean = d;
        this.sumOfSquaresOfDeltas = d2;
        this.min = d3;
        this.max = d4;
    }

    public static Stats fromByteArray(byte[] bArr) {
        if (bArr != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
            return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
        }
        throw null;
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static double meanOf(Iterator<? extends Number> it) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j++;
            doubleValue = (!Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(doubleValue2) || !Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(doubleValue)) ? C2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(doubleValue, doubleValue2) : ((doubleValue2 - doubleValue) / j) + doubleValue;
        }
        return doubleValue;
    }

    public static double meanOf(double... dArr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d2 = dArr[i];
            d = (!Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d2) || !Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) ? C2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d, d2) : ((d2 - d) / (i + 1)) + d;
        }
        return d;
    }

    public static double meanOf(int... iArr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr.length > 0);
        double d = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d2 = iArr[i];
            d = (!Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d2) || !Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) ? C2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d, d2) : ((d2 - d) / (i + 1)) + d;
        }
        return d;
    }

    public static double meanOf(long... jArr) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr.length > 0);
        double d = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d2 = jArr[i];
            d = (!Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d2) || !Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) ? C2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d, d2) : ((d2 - d) / (i + 1)) + d;
        }
        return d;
    }

    /* renamed from: of */
    public static Stats m3823of(Iterable<? extends Number> iterable) {
        C2878zy c2878zy = new C2878zy();
        for (Number number : iterable) {
            c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(number.doubleValue());
        }
        return c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
            return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
        }
        throw null;
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object obj) {
        if (obj != null && Stats.class == obj.getClass()) {
            Stats stats = (Stats) obj;
            return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)});
    }

    public double max() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.count != 0);
        return this.max;
    }

    public double mean() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.count != 0);
        return this.mean;
    }

    public double min() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        long j = this.count;
        double d = RoundRectDrawableWithShadow.COS_45;
        if (j == 1) {
            return RoundRectDrawableWithShadow.COS_45;
        }
        double d2 = this.sumOfSquaresOfDeltas;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true ^ Double.isNaN(d2));
        if (d2 > RoundRectDrawableWithShadow.COS_45) {
            d = d2;
        }
        return d / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        double d = this.sumOfSquaresOfDeltas;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true ^ Double.isNaN(d));
        if (d <= RoundRectDrawableWithShadow.COS_45) {
            d = 0.0d;
        }
        return d / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        int i = (count() > 0L ? 1 : (count() == 0L ? 0 : -1));
        C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("count", this.count);
        if (i > 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mean", this.mean);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("populationStandardDeviation", populationStandardDeviation());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("min", this.min);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("max", this.max);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
            byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
            return;
        }
        throw null;
    }

    /* renamed from: of */
    public static Stats m3822of(Iterator<? extends Number> it) {
        C2878zy c2878zy = new C2878zy();
        while (it.hasNext()) {
            c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next().doubleValue());
        }
        return c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static Stats m3821of(double... dArr) {
        C2878zy c2878zy = new C2878zy();
        for (double d : dArr) {
            c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d);
        }
        return c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static Stats m3820of(int... iArr) {
        C2878zy c2878zy = new C2878zy();
        for (int i : iArr) {
            c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        return c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: of */
    public static Stats m3819of(long... jArr) {
        C2878zy c2878zy = new C2878zy();
        for (long j : jArr) {
            c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        }
        return c2878zy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
