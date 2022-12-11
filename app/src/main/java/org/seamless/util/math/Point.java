package org.seamless.util.math;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class Point {

    /* renamed from: x */
    public int f5004x;

    /* renamed from: y */
    public int f5005y;

    public Point(int i, int i2) {
        this.f5004x = i;
        this.f5005y = i2;
    }

    public Point divide(double d) {
        int i = this.f5004x;
        int i2 = 0;
        int i3 = i != 0 ? (int) (i / d) : 0;
        int i4 = this.f5005y;
        if (i4 != 0) {
            i2 = (int) (i4 / d);
        }
        return new Point(i3, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Point.class != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return this.f5004x == point.f5004x && this.f5005y == point.f5005y;
    }

    public int getX() {
        return this.f5004x;
    }

    public int getY() {
        return this.f5005y;
    }

    public int hashCode() {
        return (this.f5004x * 31) + this.f5005y;
    }

    public Point multiply(double d) {
        int i = this.f5004x;
        int i2 = 0;
        int i3 = i != 0 ? (int) (i * d) : 0;
        int i4 = this.f5005y;
        if (i4 != 0) {
            i2 = (int) (i4 * d);
        }
        return new Point(i3, i2);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Point(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f5004x);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("/");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.f5005y, ")");
    }
}
