package me.tvspark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class a11 implements w01 {
    public static final a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<z01> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 1114111);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        a11 a11Var = new a11(new int[0]);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a11Var;
        a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
    }

    public a11(int... iArr) {
        if (iArr == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList(2);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList(iArr.length);
        for (int i : iArr) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    public static a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        a11 a11Var = new a11(new int[0]);
        a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        return a11Var;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        if (size == 1) {
            z01 z01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0);
            return (z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + 1;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            z01 z01Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
            i += (z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + 1;
        }
        return i;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            for (int i2 = 0; i2 < size; i2++) {
                z01 z01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                int i3 = z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i < i3) {
                    return;
                }
                if (i == i3 && i == i4) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(i2);
                    return;
                } else if (i == i3) {
                    z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    return;
                } else if (i == i4) {
                    z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
                    return;
                } else {
                    if (i > i3 && i < i4) {
                        int i5 = z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i - 1;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i + 1, i5);
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        List<z01> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return list == null || list.isEmpty();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            z01 z01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
            int i4 = z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < i) {
                i2 = i3 + 1;
            } else if (i4 <= i) {
                return true;
            } else {
                size = i3 - 1;
            }
        }
        return false;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new RuntimeException("set is empty");
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iy0 iy0Var) {
        StringBuilder sb = new StringBuilder();
        List<z01> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null || list.isEmpty()) {
            return MessageFormatter.DELIM_STR;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 1) {
            sb.append("{");
        }
        Iterator<z01> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            z01 next = it.next();
            int i = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == i2) {
                sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iy0Var, i));
            } else {
                for (int i3 = i; i3 <= i2; i3++) {
                    if (i3 > i) {
                        sb.append(", ");
                    }
                    sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iy0Var, i3));
                }
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 1) {
            sb.append("}");
        }
        return sb.toString();
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iy0 iy0Var, int i) {
        return i == -1 ? "<EOF>" : i == -2 ? "<EPSILON>" : ((jy0) iy0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i);
            return;
        }
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        boolean z;
        z01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            ListIterator<z01> listIterator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.listIterator();
            while (listIterator.hasNext()) {
                z01 next = listIterator.next();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(next)) {
                    return;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next) || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next)) {
                    z01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next);
                    listIterator.set(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    while (listIterator.hasNext()) {
                        z01 next2 = listIterator.next();
                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next2) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next2)) {
                            return;
                        }
                        listIterator.remove();
                        listIterator.previous();
                        listIterator.set(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next2));
                        listIterator.next();
                    }
                    return;
                }
                int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i3 >= i4 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= i4) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    listIterator.previous();
                    listIterator.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    return;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            return;
        }
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a11)) {
            return false;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((a11) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int i = 0;
        for (z01 z01Var : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            i = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() * 2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<z01> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null || list.isEmpty()) {
            return MessageFormatter.DELIM_STR;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 1) {
            sb.append("{");
        }
        Iterator<z01> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            z01 next = it.next();
            int i = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i != i2) {
                sb.append(i);
                sb.append("..");
                sb.append(i2);
            } else if (i == -1) {
                sb.append("<EOF>");
            } else {
                sb.append(i);
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 1) {
            sb.append("}");
        }
        return sb.toString();
    }

    public a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(w01 w01Var) {
        if (w01Var == null) {
            return this;
        }
        boolean z = w01Var instanceof a11;
        int i = 0;
        a11 a11Var = (a11) w01Var;
        if (z) {
            int size = a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            while (i < size) {
                z01 z01Var = a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                i++;
            }
        } else {
            ArrayList arrayList = new ArrayList();
            int size2 = a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            while (i < size2) {
                z01 z01Var2 = a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                int i2 = z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                for (int i3 = z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i3 <= i2; i3++) {
                    arrayList.add(Integer.valueOf(i3));
                }
                i++;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) it.next()).intValue());
            }
        }
        return this;
    }

    public static a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a11 a11Var, a11 a11Var2) {
        int i = 0;
        if (a11Var == null || a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return new a11(new int[0]);
        }
        a11 a11Var3 = new a11(new int[0]);
        a11Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a11Var);
        if (a11Var2 != null && !a11Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            int i2 = 0;
            while (i < a11Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() && i2 < a11Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                z01 z01Var = a11Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                z01 z01Var2 = a11Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                int i3 = z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i3 >= i4) {
                    int i5 = z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i5 <= z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        z01 z01Var3 = null;
                        z01 z01Var4 = i5 > i4 ? new z01(z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1) : null;
                        if (z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            z01Var3 = new z01(z01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1, z01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        List<z01> list = a11Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (z01Var4 != null) {
                            list.set(i, z01Var4);
                            if (z01Var3 != null) {
                                i++;
                                a11Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(i, z01Var3);
                            }
                        } else if (z01Var3 != null) {
                            list.set(i, z01Var3);
                        } else {
                            list.remove(i);
                        }
                    }
                    i++;
                }
                i2++;
            }
        }
        return a11Var3;
    }
}
