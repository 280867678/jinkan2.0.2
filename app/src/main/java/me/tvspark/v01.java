package me.tvspark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class v01<K, V> implements Map<K, V> {
    public LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>>[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final s01<? super K> Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwww = 12;
    public int Wwwwwwwwwwwwwwwwwwww = 1;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> {
        public V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, V v) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v;
        }

        public String toString() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString() + ":" + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public v01(s01<? super K> s01Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = s01Var == null ? b11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : s01Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = new LinkedList[8];
    }

    @Override // java.util.Map
    public void clear() {
        this.Wwwwwwwwwwwwwwwwwwwwwww = new LinkedList[16];
        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>>[] linkedListArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
        LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> linkedList = linkedListArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 & (linkedListArr.length - 1)];
        if (linkedList == null) {
            return null;
        }
        Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> it = linkedList.iterator();
        while (it.hasNext()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> next = it.next();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((K) next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj)) {
                return next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>>[] linkedListArr;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> next;
        int i = 0;
        for (LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> linkedList : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (linkedList != null) {
                Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> it = linkedList.iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    i = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((K) next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                }
            }
        }
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwww == 0;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> next;
        if (k == null) {
            return null;
        }
        int i = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (i > this.Wwwwwwwwwwwwwwwwwwwww) {
            LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>>[] linkedListArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww += 4;
            int length = linkedListArr.length * 2;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new LinkedList[length];
            this.Wwwwwwwwwwwwwwwwwwwww = (int) (length * 0.75d);
            for (LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> linkedList : linkedListArr) {
                if (linkedList != null) {
                    Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> it = linkedList.iterator();
                    while (it.hasNext() && (next = it.next()) != null) {
                        put(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k);
        LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>>[] linkedListArr2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int length2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 & (linkedListArr2.length - 1);
        LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> linkedList2 = linkedListArr2[length2];
        if (linkedList2 == null) {
            linkedList2 = new LinkedList<>();
            linkedListArr2[length2] = linkedList2;
        }
        Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> next2 = it2.next();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((K) next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, k)) {
                V v2 = next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = v;
                this.Wwwwwwwwwwwwwwwwwwwwww++;
                return v2;
            }
        }
        linkedList2.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(k, v));
        this.Wwwwwwwwwwwwwwwwwwwwww++;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>>[] linkedListArr;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> next;
        if (this.Wwwwwwwwwwwwwwwwwwwwww == 0) {
            return MessageFormatter.DELIM_STR;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('{');
        boolean z = true;
        for (LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> linkedList : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (linkedList != null) {
                Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> it = linkedList.iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    if (z) {
                        z = false;
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ");
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(next.toString());
                }
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>>[] linkedListArr;
        ArrayList arrayList = new ArrayList(this.Wwwwwwwwwwwwwwwwwwwwww);
        for (LinkedList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> linkedList : this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (linkedList != null) {
                Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }
        return arrayList;
    }
}
