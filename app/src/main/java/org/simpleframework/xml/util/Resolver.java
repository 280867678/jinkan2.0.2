package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.util.Match;

/* loaded from: classes5.dex */
public class Resolver<M extends Match> extends AbstractSet<M> {
    public final Resolver<M>.Stack stack = new Stack();
    public final Resolver<M>.Cache cache = new Cache();

    /* loaded from: classes5.dex */
    public class Cache extends LimitedCache<List<M>> {
        public Cache() {
            super(1024);
        }
    }

    /* loaded from: classes5.dex */
    public class Stack extends LinkedList<M> {

        /* loaded from: classes5.dex */
        public class Sequence implements Iterator<M> {
            public int cursor;

            public Sequence() {
                this.cursor = Stack.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.cursor > 0;
            }

            @Override // java.util.Iterator
            public M next() {
                if (hasNext()) {
                    Stack stack = Stack.this;
                    int i = this.cursor - 1;
                    this.cursor = i;
                    return (M) stack.get(i);
                }
                return null;
            }

            @Override // java.util.Iterator
            public void remove() {
                Stack.this.purge(this.cursor);
            }
        }

        public Stack() {
        }

        public void purge(int i) {
            Resolver.this.cache.clear();
            remove(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.LinkedList, java.util.Deque
        public /* bridge */ /* synthetic */ void push(Object obj) {
            push((Stack) ((Match) obj));
        }

        public void push(M m) {
            Resolver.this.cache.clear();
            addFirst(m);
        }

        public Iterator<M> sequence() {
            return new Sequence();
        }
    }

    private boolean match(char[] cArr, int i, char[] cArr2, int i2) {
        while (i2 < cArr2.length && i < cArr.length) {
            if (cArr2[i2] == '*') {
                while (cArr2[i2] == '*') {
                    i2++;
                    if (i2 >= cArr2.length) {
                        return true;
                    }
                }
                if (cArr2[i2] == '?' && (i2 = i2 + 1) >= cArr2.length) {
                    return true;
                }
                while (i < cArr.length) {
                    if (cArr[i] == cArr2[i2] || cArr2[i2] == '?') {
                        if (cArr2[i2 - 1] == '?') {
                            break;
                        } else if (match(cArr, i, cArr2, i2)) {
                            return true;
                        }
                    }
                    i++;
                }
                if (cArr.length == i) {
                    return false;
                }
            }
            int i3 = i + 1;
            int i4 = i2 + 1;
            if (cArr[i] != cArr2[i2] && cArr2[i4 - 1] != '?') {
                return false;
            }
            i = i3;
            i2 = i4;
        }
        if (cArr2.length == i2) {
            return cArr.length == i;
        }
        while (cArr2[i2] == '*') {
            i2++;
            if (i2 >= cArr2.length) {
                return true;
            }
        }
        return false;
    }

    private boolean match(char[] cArr, char[] cArr2) {
        return match(cArr, 0, cArr2, 0);
    }

    private List<M> resolveAll(String str, char[] cArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<M> it = this.stack.iterator();
        while (it.hasNext()) {
            Match match = (Match) it.next();
            if (match(cArr, match.getPattern().toCharArray())) {
                this.cache.put(str, arrayList);
                arrayList.add(match);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((Resolver<M>) ((Match) obj));
    }

    public boolean add(M m) {
        this.stack.push((Resolver<M>.Stack) m);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.cache.clear();
        this.stack.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<M> iterator() {
        return (Iterator<M>) this.stack.sequence();
    }

    public boolean remove(M m) {
        this.cache.clear();
        return this.stack.remove(m);
    }

    public M resolve(String str) {
        List<M> list = (List) this.cache.get(str);
        if (list == null) {
            list = resolveAll(str);
        }
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<M> resolveAll(String str) {
        List<M> list = (List) this.cache.get(str);
        if (list != null) {
            return list;
        }
        char[] charArray = str.toCharArray();
        if (charArray != null) {
            return resolveAll(str, charArray);
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.stack.size();
    }
}
