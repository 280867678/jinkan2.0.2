package com.google.common.math;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import me.tvspark.AbstractC2804xy;
import me.tvspark.C2456ot;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class PairedStats implements Serializable {
    public static final int BYTES = 88;
    public static final long serialVersionUID = 0;
    public final double sumOfProductsOfDeltas;
    public final Stats xStats;
    public final Stats yStats;

    public PairedStats(Stats stats, Stats stats2, double d) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d;
    }

    public static double ensureInUnitRange(double d) {
        if (d >= 1.0d) {
            return 1.0d;
        }
        if (d > -1.0d) {
            return d;
        }
        return -1.0d;
    }

    public static double ensurePositive(double d) {
        if (d > RoundRectDrawableWithShadow.COS_45) {
            return d;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        if (bArr != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new PairedStats(Stats.readFrom(order), Stats.readFrom(order), order.getDouble());
        }
        throw null;
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(Object obj) {
        if (obj != null && PairedStats.class == obj.getClass()) {
            PairedStats pairedStats = (PairedStats) obj;
            return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas)});
    }

    public AbstractC2804xy leastSquaresFit() {
        boolean z = false;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return AbstractC2804xy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas <= RoundRectDrawableWithShadow.COS_45) {
            if (this.yStats.sumOfSquaresOfDeltas() > RoundRectDrawableWithShadow.COS_45) {
                z = true;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            double mean = this.xStats.mean();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mean));
            return new AbstractC2804xy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mean);
        } else if (this.yStats.sumOfSquaresOfDeltas() > RoundRectDrawableWithShadow.COS_45) {
            double mean2 = this.xStats.mean();
            double mean3 = this.yStats.mean();
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mean2) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mean3)) {
                z = true;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            double d = this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!Double.isNaN(d));
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d) ? new AbstractC2804xy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d, mean3 - (mean2 * d)) : new AbstractC2804xy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mean2);
        } else {
            double mean4 = this.yStats.mean();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mean4));
            return new AbstractC2804xy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RoundRectDrawableWithShadow.COS_45, mean4);
        }
    }

    public double pearsonsCorrelationCoefficient() {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = xStats().sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = yStats().sumOfSquaresOfDeltas();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(sumOfSquaresOfDeltas > RoundRectDrawableWithShadow.COS_45);
        if (sumOfSquaresOfDeltas2 <= RoundRectDrawableWithShadow.COS_45) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(order);
        this.yStats.writeTo(order);
        order.putDouble(this.sumOfProductsOfDeltas);
        return order.array();
    }

    public String toString() {
        int i = (count() > 0L ? 1 : (count() == 0L ? 0 : -1));
        C2456ot Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        Stats stats = this.xStats;
        if (i > 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("xStats", stats);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("yStats", this.yStats);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("populationCovariance", populationCovariance());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("xStats", stats);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("yStats", this.yStats);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
