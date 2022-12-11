package org.seamless.util.math;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class Rectangle {
    public int height;
    public Point position;
    public int width;

    public Rectangle() {
    }

    public Rectangle(Point point, int i, int i2) {
        this.position = point;
        this.width = i;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public Point getPosition() {
        return this.position;
    }

    public int getWidth() {
        return this.width;
    }

    public Rectangle intersection(Rectangle rectangle) {
        int x = this.position.getX();
        int y = this.position.getY();
        int x2 = rectangle.position.getX();
        int y2 = rectangle.position.getY();
        long j = x + this.width;
        long j2 = y + this.height;
        long j3 = x2 + rectangle.width;
        long j4 = y2 + rectangle.height;
        if (x < x2) {
            x = x2;
        }
        if (y < y2) {
            y = y2;
        }
        if (j > j3) {
            j = j3;
        }
        if (j2 > j4) {
            j2 = j4;
        }
        long j5 = j - x;
        long j6 = j2 - y;
        if (j5 < -2147483648L) {
            j5 = -2147483648L;
        }
        if (j6 < -2147483648L) {
            j6 = -2147483648L;
        }
        return new Rectangle(new Point(x, y), (int) j5, (int) j6);
    }

    public boolean isOverlapping(Rectangle rectangle) {
        Rectangle intersection = intersection(rectangle);
        return intersection.getWidth() > 0 && intersection.getHeight() > 0;
    }

    public void reset() {
        this.position = new Point(0, 0);
        this.width = 0;
        this.height = 0;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setPosition(Point point) {
        this.position = point;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Rectangle(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.position);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" - ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.width);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("x");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.height, ")");
    }
}
