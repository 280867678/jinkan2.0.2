package org.eclipse.jetty.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class MultiMap<K> implements ConcurrentMap<K, Object>, Serializable {
    public static final long serialVersionUID = -6878723138353851005L;
    public ConcurrentMap<K, Object> _cmap;
    public Map<K, Object> _map;

    public MultiMap() {
        this._map = new HashMap();
    }

    public MultiMap(int i) {
        this._map = new HashMap(i);
    }

    public MultiMap(Map<K, Object> map) {
        ConcurrentMap<K, Object> concurrentMap;
        if (map instanceof ConcurrentMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(map);
            this._cmap = concurrentHashMap;
            concurrentMap = concurrentHashMap;
        } else {
            concurrentMap = new HashMap((Map<? extends K, ? extends Object>) map);
        }
        this._map = concurrentMap;
    }

    public MultiMap(MultiMap<K> multiMap) {
        ConcurrentMap<K, Object> concurrentMap;
        if (multiMap._cmap != null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(multiMap._cmap);
            this._cmap = concurrentHashMap;
            concurrentMap = concurrentHashMap;
        } else {
            concurrentMap = new HashMap((Map<? extends K, ? extends Object>) multiMap._map);
        }
        this._map = concurrentMap;
    }

    public MultiMap(boolean z) {
        ConcurrentMap<K, Object> concurrentMap;
        if (z) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            this._cmap = concurrentHashMap;
            concurrentMap = concurrentHashMap;
        } else {
            concurrentMap = new HashMap();
        }
        this._map = concurrentMap;
    }

    public void add(K k, Object obj) {
        Object obj2 = this._map.get(k);
        Object add = LazyList.add(obj2, obj);
        if (obj2 != add) {
            this._map.put(k, add);
        }
    }

    public void addValues(K k, List<? extends Object> list) {
        Object obj = this._map.get(k);
        Object addCollection = LazyList.addCollection(obj, list);
        if (obj != addCollection) {
            this._map.put(k, addCollection);
        }
    }

    public void addValues(K k, String[] strArr) {
        Object obj = this._map.get(k);
        Object addCollection = LazyList.addCollection(obj, Arrays.asList(strArr));
        if (obj != addCollection) {
            this._map.put(k, addCollection);
        }
    }

    @Override // java.util.Map
    public void clear() {
        this._map.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this._map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this._map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, Object>> entrySet() {
        return this._map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this._map.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        Object obj2 = this._map.get(obj);
        int size = LazyList.size(obj2);
        if (size != 0) {
            return size != 1 ? LazyList.getList(obj2, true) : LazyList.get(obj2, 0);
        }
        return null;
    }

    public String getString(Object obj) {
        Object obj2 = this._map.get(obj);
        int size = LazyList.size(obj2);
        if (size != 0) {
            if (size == 1) {
                Object obj3 = LazyList.get(obj2, 0);
                if (obj3 != null) {
                    return obj3.toString();
                }
                return null;
            }
            StringBuilder sb = new StringBuilder(128);
            for (int i = 0; i < LazyList.size(obj2); i++) {
                Object obj4 = LazyList.get(obj2, i);
                if (obj4 != null) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append(obj4.toString());
                }
            }
            return sb.toString();
        }
        return null;
    }

    public Object getValue(Object obj, int i) {
        Object obj2 = this._map.get(obj);
        if (i == 0 && LazyList.size(obj2) == 0) {
            return null;
        }
        return LazyList.get(obj2, i);
    }

    public List getValues(Object obj) {
        return LazyList.getList(this._map.get(obj), true);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this._map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this._map.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this._map.keySet();
    }

    @Override // java.util.Map
    public Object put(K k, Object obj) {
        return this._map.put(k, LazyList.add(null, obj));
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Object> map) {
        if (!(map instanceof MultiMap)) {
            this._map.putAll(map);
            return;
        }
        for (Map.Entry<? extends K, ? extends Object> entry : map.entrySet()) {
            this._map.put(entry.getKey(), LazyList.clone(entry.getValue()));
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public Object putIfAbsent(K k, Object obj) {
        ConcurrentMap<K, Object> concurrentMap = this._cmap;
        if (concurrentMap != null) {
            return concurrentMap.putIfAbsent(k, obj);
        }
        throw new UnsupportedOperationException();
    }

    public Object putValues(K k, List<? extends Object> list) {
        return this._map.put(k, list);
    }

    public Object putValues(K k, String... strArr) {
        Object obj = null;
        for (String str : strArr) {
            obj = LazyList.add(obj, str);
        }
        return this._map.put(k, obj);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this._map.remove(obj);
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean remove(Object obj, Object obj2) {
        ConcurrentMap<K, Object> concurrentMap = this._cmap;
        if (concurrentMap != null) {
            return concurrentMap.remove(obj, obj2);
        }
        throw new UnsupportedOperationException();
    }

    public boolean removeValue(K k, Object obj) {
        Object obj2 = this._map.get(k);
        int size = LazyList.size(obj2);
        if (size > 0) {
            obj2 = LazyList.remove(obj2, obj);
            Map<K, Object> map = this._map;
            if (obj2 == null) {
                map.remove(k);
            } else {
                map.put(k, obj2);
            }
        }
        return LazyList.size(obj2) != size;
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public Object replace(K k, Object obj) {
        ConcurrentMap<K, Object> concurrentMap = this._cmap;
        if (concurrentMap != null) {
            return concurrentMap.replace(k, obj);
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean replace(K k, Object obj, Object obj2) {
        ConcurrentMap<K, Object> concurrentMap = this._cmap;
        if (concurrentMap != null) {
            return concurrentMap.replace(k, obj, obj2);
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this._map.size();
    }

    public String toString() {
        Object obj = this._cmap;
        if (obj == null) {
            obj = this._map;
        }
        return obj.toString();
    }

    public Map<K, String[]> toStringArrayMap() {
        HashMap<K, String[]> hashMap = new HashMap<K, String[]>((this._map.size() * 3) / 2) { // from class: org.eclipse.jetty.util.MultiMap.1
            @Override // java.util.AbstractMap
            public String toString() {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('{');
                for (K k : keySet()) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() > 1) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(',');
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(k);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(B64Code.__pad);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Arrays.asList(get(k)));
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
        };
        for (Map.Entry<K, Object> entry : this._map.entrySet()) {
            hashMap.put(entry.getKey(), LazyList.toStringArray(entry.getValue()));
        }
        return hashMap;
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this._map.values();
    }
}
