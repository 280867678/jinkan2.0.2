package org.mozilla.javascript;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.s21;

/* loaded from: classes5.dex */
public class Hashtable implements Serializable, Iterable<Entry> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final HashMap<Object, Entry> map = new HashMap<>();
    public Entry first = null;
    public Entry last = null;

    /* loaded from: classes5.dex */
    public static final class Entry implements Serializable {
        public boolean deleted;
        public final int hashCode;
        public Object key;
        public Entry next;
        public Entry prev;
        public Object value;

        public Entry() {
            this.hashCode = 0;
        }

        public Entry(Object obj, Object obj2) {
            if (!(obj instanceof Number) || (obj instanceof Double)) {
                this.key = obj;
            } else {
                this.key = Double.valueOf(((Number) obj).doubleValue());
            }
            if (this.key != null && !obj.equals(Double.valueOf(ScriptRuntime.negativeZero))) {
                this.hashCode = this.key.hashCode();
            } else {
                this.hashCode = 0;
            }
            this.value = obj2;
        }

        public Object clear() {
            Object obj = this.value;
            Object obj2 = Undefined.instance;
            this.key = obj2;
            this.value = obj2;
            this.deleted = true;
            return obj;
        }

        public boolean equals(Object obj) {
            try {
                return ScriptRuntime.sameZero(this.key, ((Entry) obj).key);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        public int hashCode() {
            return this.hashCode;
        }

        public Object key() {
            return this.key;
        }

        public Object value() {
            return this.value;
        }
    }

    /* loaded from: classes5.dex */
    public final class Iter implements Iterator<Entry> {
        public Entry pos;

        public Iter(Entry entry) {
            Entry makeDummy = Hashtable.this.makeDummy();
            makeDummy.next = entry;
            this.pos = makeDummy;
        }

        private void skipDeleted() {
            while (true) {
                Entry entry = this.pos.next;
                if (entry == null || !entry.deleted) {
                    return;
                }
                this.pos = entry;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            skipDeleted();
            Entry entry = this.pos;
            return (entry == null || entry.next == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Entry next() {
            Entry entry;
            skipDeleted();
            Entry entry2 = this.pos;
            if (entry2 == null || (entry = entry2.next) == null) {
                throw new NoSuchElementException();
            }
            this.pos = entry;
            return entry;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Entry makeDummy() {
        Entry entry = new Entry();
        entry.clear();
        return entry;
    }

    public void clear() {
        iterator().forEachRemaining(s21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.first != null) {
            Entry entry = new Entry();
            entry.clear();
            this.last.next = entry;
            this.last = entry;
            this.first = entry;
        }
        this.map.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r1 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object delete(Object obj) {
        Entry entry;
        Entry entry2;
        Entry remove = this.map.remove(new Entry(obj, null));
        if (remove == null) {
            return null;
        }
        if (remove != this.first) {
            entry = remove.prev;
            entry.next = remove.next;
            remove.prev = null;
            entry2 = remove.next;
            if (entry2 == null) {
                this.last = entry;
            }
            entry2.prev = entry;
        } else if (remove == this.last) {
            remove.clear();
            remove.prev = null;
        } else {
            entry = remove.next;
            this.first = entry;
            entry.prev = null;
            entry2 = entry.next;
        }
        return remove.clear();
    }

    public Object get(Object obj) {
        Entry entry = this.map.get(new Entry(obj, null));
        if (entry == null) {
            return null;
        }
        return entry.value;
    }

    public boolean has(Object obj) {
        return this.map.containsKey(new Entry(obj, null));
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return new Iter(this.first);
    }

    public void put(Object obj, Object obj2) {
        Entry entry = new Entry(obj, obj2);
        Entry putIfAbsent = this.map.putIfAbsent(entry, entry);
        if (putIfAbsent != null) {
            putIfAbsent.value = obj2;
        } else if (this.first == null) {
            this.last = entry;
            this.first = entry;
        } else {
            Entry entry2 = this.last;
            entry2.next = entry;
            entry.prev = entry2;
            this.last = entry;
        }
    }

    public int size() {
        return this.map.size();
    }
}
