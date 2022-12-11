package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2346lu;
import me.tvspark.C1923av;
import me.tvspark.C2275jx;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class EnumMultiset<E extends Enum<E>> extends AbstractC2346lu<E> implements Serializable {
    public static final long serialVersionUID = 0;
    public transient int[] counts;
    public transient int distinctElements;
    public transient E[] enumConstants;
    public transient long size;
    public transient Class<E> type;

    /* loaded from: classes3.dex */
    public abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Iterator<T> {
        public int Wwwwwwwwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwwwwwwwww = -1;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.Wwwwwwwwwwwwwwwwwwwwwwww < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (iArr[i] > 0) {
                    return true;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww >= 0, "no calls to next() since the last call to remove()");
            if (EnumMultiset.this.counts[this.Wwwwwwwwwwwwwwwwwwwwwww] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset.this.size -= EnumMultiset.this.counts[this.Wwwwwwwwwwwwwwwwwwwwwww];
                EnumMultiset.this.counts[this.Wwwwwwwwwwwwwwwwwwwwwww] = 0;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends EnumMultiset<E>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return new C1923av(this, i);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends EnumMultiset<E>.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return EnumMultiset.this.enumConstants[i];
        }
    }

    public EnumMultiset(Class<E> cls) {
        this.type = cls;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i - 1;
        return i;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) enumMultiset, (Iterable) iterable);
        return enumMultiset;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) create, (Iterable) iterable);
        return create;
    }

    private boolean isActuallyE(Object obj) {
        if (obj instanceof Enum) {
            Enum r5 = (Enum) obj;
            int ordinal = r5.ordinal();
            E[] eArr = this.enumConstants;
            return ordinal < eArr.length && eArr[ordinal] == r5;
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex) this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex) this, objectOutputStream);
    }

    public int add(E e, int i) {
        checkIsE(e);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        int ordinal = e.ordinal();
        int i2 = this.counts[ordinal];
        long j = i;
        long j2 = i2 + j;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.counts[ordinal] = (int) j2;
        if (i2 == 0) {
            this.distinctElements++;
        }
        this.size += j;
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public /* bridge */ /* synthetic */ int add(Object obj, int i) {
        return add((EnumMultiset<E>) ((Enum) obj), i);
    }

    public void checkIsE(Object obj) {
        if (obj != null) {
            if (isActuallyE(obj)) {
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected an ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.type);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" but got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(obj);
            throw new ClassCastException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    @Override // me.tvspark.AbstractC2346lu
    public int distinctElements() {
        return this.distinctElements;
    }

    @Override // me.tvspark.AbstractC2346lu
    public Iterator<E> elementIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public /* bridge */ /* synthetic */ Set mo4975elementSet() {
        return super.mo4975elementSet();
    }

    @Override // me.tvspark.AbstractC2346lu
    public Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entryIterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    public /* bridge */ /* synthetic */ Set mo4575entrySet() {
        return super.mo4575entrySet();
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, me.tvspark.AbstractC2090ex
    public Iterator<E> iterator() {
        return new C2275jx(this, mo4575entrySet().iterator());
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public int remove(Object obj, int i) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum r1 = (Enum) obj;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        int ordinal = r1.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        if (i2 == 0) {
            return 0;
        }
        if (i2 <= i) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= i2;
        } else {
            iArr[ordinal] = i2 - i;
            this.size -= i;
        }
        return i2;
    }

    public int setCount(E e, int i) {
        int i2;
        checkIsE(e);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
        int ordinal = e.ordinal();
        int[] iArr = this.counts;
        int i3 = iArr[ordinal];
        iArr[ordinal] = i;
        this.size += i - i3;
        if (i3 != 0 || i <= 0) {
            if (i3 > 0 && i == 0) {
                i2 = this.distinctElements - 1;
            }
            return i3;
        }
        i2 = this.distinctElements + 1;
        this.distinctElements = i2;
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i) {
        return setCount((EnumMultiset<E>) ((Enum) obj), i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public int size() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.size);
    }
}
