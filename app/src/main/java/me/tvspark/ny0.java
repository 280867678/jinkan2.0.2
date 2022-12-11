package me.tvspark;

import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public class ny0 implements Set<my0> {
    public int Wwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public BitSet Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public final ArrayList<my0> Wwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends s01<my0> {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        @Override // me.tvspark.s01
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var, my0 my0Var2) {
            my0 my0Var3 = my0Var;
            my0 my0Var4 = my0Var2;
            if (my0Var3 == my0Var4) {
                return true;
            }
            return my0Var3 != null && my0Var4 != null && my0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == my0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && my0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == my0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && my0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(my0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.s01
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var) {
            my0 my0Var2 = my0Var;
            return my0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + ((((my0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + TbsListener.ErrorCode.INCR_UPDATE_FAIL) * 31) + my0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends t01<my0> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s01<? super my0> s01Var) {
            super(s01Var, 16, 2);
        }

        @Override // me.tvspark.t01
        public my0[][] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return new my0[i];
        }

        @Override // me.tvspark.t01
        public my0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            if (!(obj instanceof my0)) {
                return null;
            }
            return (my0) obj;
        }

        @Override // me.tvspark.t01
        public my0[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return new my0[i];
        }
    }

    public ny0() {
        this(true);
    }

    public ny0(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList<>(7);
        this.Wwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwww = z;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ry0 ry0Var) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                return;
            }
            Iterator<my0> it = this.Wwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                my0 next = it.next();
                next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ry0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return;
        }
        throw new IllegalStateException("This set is readonly");
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var, null);
        return true;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var, u01<a01, a01, a01> u01Var) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != g01.Wwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwww = true;
            }
            if (my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
                this.Wwwwwwwwwwwwwwwwww = true;
            }
            my0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == my0Var) {
                this.Wwwwwwwwwwwwwwww = -1;
                this.Wwwwwwwwwwwwwwwwwwwwww.add(my0Var);
                return true;
            }
            a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, !this.Wwwwwwwwwwwwwwwww, u01Var);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 1073741824;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            return true;
        }
        throw new IllegalStateException("This set is readonly");
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((my0) obj);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends my0> collection) {
        for (my0 my0Var : collection) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            return;
        }
        throw new IllegalStateException("This set is readonly");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj));
        }
        throw new UnsupportedOperationException("This method is not implemented for readonly sets.");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ny0)) {
            return false;
        }
        ny0 ny0Var = (ny0) obj;
        ArrayList<my0> arrayList = this.Wwwwwwwwwwwwwwwwwwwwww;
        return arrayList != null && arrayList.equals(ny0Var.Wwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwww == ny0Var.Wwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwww == ny0Var.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwww == ny0Var.Wwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwww == ny0Var.Wwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwww == ny0Var.Wwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwww == -1) {
                this.Wwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww.hashCode();
            }
            return this.Wwwwwwwwwwwwwwww;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<my0> iterator() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.Wwwwwwwwwwwwwwwwwwwwwww.toArray(tArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Wwwwwwwwwwwwwwwwwwwwww.toString());
        if (this.Wwwwwwwwwwwwwwwwwww) {
            sb.append(",hasSemanticContext=");
            sb.append(this.Wwwwwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww != 0) {
            sb.append(",uniqueAlt=");
            sb.append(this.Wwwwwwwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            sb.append(",conflictingAlts=");
            sb.append(this.Wwwwwwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwwwwwww) {
            sb.append(",dipsIntoOuterContext");
        }
        return sb.toString();
    }
}
