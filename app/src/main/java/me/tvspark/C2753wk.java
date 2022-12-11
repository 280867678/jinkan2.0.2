package me.tvspark;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: me.tvspark.wk */
/* loaded from: classes4.dex */
public final class C2753wk<E> implements Iterable<E> {
    public final Object Wwwwwwwwwwwwwwwwwwwwwwww = new Object();
    @GuardedBy("lock")
    public final Map<E, Integer> Wwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    @GuardedBy("lock")
    public Set<E> Wwwwwwwwwwwwwwwwwwwwww = Collections.emptySet();
    @GuardedBy("lock")
    public List<E> Wwwwwwwwwwwwwwwwwwwww = Collections.emptyList();

    public void add(E e) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            ArrayList arrayList = new ArrayList(this.Wwwwwwwwwwwwwwwwwwwww);
            arrayList.add(e);
            this.Wwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(arrayList);
            Integer num = this.Wwwwwwwwwwwwwwwwwwwwwww.get(e);
            if (num == null) {
                HashSet hashSet = new HashSet(this.Wwwwwwwwwwwwwwwwwwwwww);
                hashSet.add(e);
                this.Wwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableSet(hashSet);
            }
            Map<E, Integer> map = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            map.put(e, Integer.valueOf(i));
        }
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            set = this.Wwwwwwwwwwwwwwwwwwwwww;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            it = this.Wwwwwwwwwwwwwwwwwwwww.iterator();
        }
        return it;
    }

    public void remove(E e) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            Integer num = this.Wwwwwwwwwwwwwwwwwwwwwww.get(e);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.Wwwwwwwwwwwwwwwwwwwww);
            arrayList.remove(e);
            this.Wwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.remove(e);
                HashSet hashSet = new HashSet(this.Wwwwwwwwwwwwwwwwwwwwww);
                hashSet.remove(e);
                this.Wwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableSet(hashSet);
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwww.put(e, Integer.valueOf(num.intValue() - 1));
            }
        }
    }
}
