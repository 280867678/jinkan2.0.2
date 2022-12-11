package me.tvspark;

import java.util.Iterator;

/* loaded from: classes4.dex */
public class zi0 implements Iterable<Integer>, pi0 {
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    public zi0(int i, int i2, int i3) {
        if (i3 != 0) {
            if (i3 == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, i3);
            this.Wwwwwwwwwwwwwwwwwwwwww = i3;
            return;
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof zi0) {
            if (!isEmpty() || !((zi0) obj).isEmpty()) {
                zi0 zi0Var = (zi0) obj;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww != zi0Var.Wwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwww != zi0Var.Wwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwww != zi0Var.Wwwwwwwwwwwwwwwwwwwwww) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.Wwwwwwwwwwwwwwwwwwwwwwww * 31) + this.Wwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean isEmpty() {
        if (this.Wwwwwwwwwwwwwwwwwwwwww > 0) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return true;
            }
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new aj0(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.Wwwwwwwwwwwwwwwwwwwwww > 0) {
            sb = new StringBuilder();
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            sb.append("..");
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
            sb.append(" step ");
            i = this.Wwwwwwwwwwwwwwwwwwwwww;
        } else {
            sb = new StringBuilder();
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            sb.append(" downTo ");
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
            sb.append(" step ");
            i = -this.Wwwwwwwwwwwwwwwwwwwwww;
        }
        sb.append(i);
        return sb.toString();
    }
}
