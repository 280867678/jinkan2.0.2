package androidx.constraintlayout.solver.widgets;

/* loaded from: classes3.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x */
    public int f40x;

    /* renamed from: y */
    public int f41y;

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.f40x;
        return i >= i4 && i < i4 + this.width && i2 >= (i3 = this.f41y) && i2 < i3 + this.height;
    }

    public int getCenterX() {
        return (this.f40x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f41y + this.height) / 2;
    }

    public void grow(int i, int i2) {
        this.f40x -= i;
        this.f41y -= i2;
        this.width = (i * 2) + this.width;
        this.height = (i2 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i;
        int i2;
        int i3 = this.f40x;
        int i4 = rectangle.f40x;
        return i3 >= i4 && i3 < i4 + rectangle.width && (i = this.f41y) >= (i2 = rectangle.f41y) && i < i2 + rectangle.height;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f40x = i;
        this.f41y = i2;
        this.width = i3;
        this.height = i4;
    }
}
