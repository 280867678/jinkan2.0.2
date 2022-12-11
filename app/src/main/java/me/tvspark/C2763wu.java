package me.tvspark;

import com.google.common.base.Predicates$CompositionPredicate;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps$EntryFunction;
import com.google.common.collect.Maps$UnmodifiableNavigableMap;
import com.google.common.collect.UnmodifiableSortedMultiset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import org.eclipse.jetty.util.B64Code;

/* renamed from: me.tvspark.wu */
/* loaded from: classes4.dex */
public final class C2763wu {
    public static <V> V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<?, V> map, Object obj) {
        if (map != null) {
            try {
                return map.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return null;
            }
        }
        throw null;
    }

    public static StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    public static <K> K Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <E> ArrayList<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<? extends E> iterable) {
        if (iterable != null) {
            return iterable instanceof Collection ? new ArrayList<>((Collection) iterable) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable.iterator());
        }
        throw null;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i < 3) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "expectedSize");
            return i + 1;
        } else if (i >= 1073741824) {
            return Integer.MAX_VALUE;
        } else {
            return (int) ((i / 0.75f) + 1.0f);
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<?> iterable) {
        if (iterable instanceof AbstractC2090ex) {
            return ((AbstractC2090ex) iterable).mo4975elementSet().size();
        }
        return 11;
    }

    public static <E> int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex<E> abstractC2090ex, E e, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "count");
        int count = abstractC2090ex.count(e);
        int i2 = i - count;
        if (i2 > 0) {
            abstractC2090ex.add(e, i2);
        } else if (i2 < 0) {
            abstractC2090ex.remove(e, -i2);
        }
        return count;
    }

    public static <E> ImmutableMap<E, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<E> collection) {
        ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ImmutableMap.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection.size());
        int i = 0;
        for (E e : collection) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, Integer.valueOf(i));
            i++;
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4533Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<?, ?> map) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map.size());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('{');
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            }
            z = false;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(entry.getKey());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(B64Code.__pad);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(entry.getValue());
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static <K, V> Iterator<Map.Entry<K, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Set<K> set, AbstractC2271jt<? super K, V> abstractC2271jt) {
        return new C2200hw(set.iterator(), abstractC2271jt);
    }

    public static <E> Iterator<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex<E> abstractC2090ex) {
        return new C2275jx(abstractC2090ex, abstractC2090ex.mo4575entrySet().iterator());
    }

    public static /* synthetic */ Map.Entry Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return new C2237iw(entry);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex<?> abstractC2090ex, Object obj) {
        if (obj == abstractC2090ex) {
            return true;
        }
        if (obj instanceof AbstractC2090ex) {
            AbstractC2090ex abstractC2090ex2 = (AbstractC2090ex) obj;
            if (abstractC2090ex.size() == abstractC2090ex2.size() && abstractC2090ex.mo4575entrySet().size() == abstractC2090ex2.mo4575entrySet().size()) {
                for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : abstractC2090ex2.mo4575entrySet()) {
                    if (abstractC2090ex.count(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement()) != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex<E> abstractC2090ex, E e, int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "oldCount");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, "newCount");
        if (abstractC2090ex.count(e) == i) {
            abstractC2090ex.setCount(e, i2);
            return true;
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map.Entry<? extends K, ? extends V> entry) {
        if (entry != null) {
            return new C2237iw(entry);
        }
        throw null;
    }

    public static <E> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex<E> abstractC2090ex, Collection<? extends E> collection) {
        if (abstractC2090ex != null) {
            if (collection == null) {
                throw null;
            }
            if (collection instanceof AbstractC2090ex) {
                AbstractC2090ex abstractC2090ex2 = (AbstractC2090ex) collection;
                if (abstractC2090ex2 instanceof AbstractMapBasedMultiset) {
                    AbstractMapBasedMultiset abstractMapBasedMultiset = (AbstractMapBasedMultiset) abstractC2090ex2;
                    if (abstractMapBasedMultiset.isEmpty()) {
                        return false;
                    }
                    abstractMapBasedMultiset.addTo(abstractC2090ex);
                } else if (abstractC2090ex2.isEmpty()) {
                    return false;
                } else {
                    for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : abstractC2090ex2.mo4575entrySet()) {
                        abstractC2090ex.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount());
                    }
                }
                return true;
            } else if (collection.isEmpty()) {
                return false;
            } else {
                return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) abstractC2090ex, (Iterator) collection.iterator());
            }
        }
        throw null;
    }

    public static <E> ArrayList<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "arraySize");
        return new ArrayList<>(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i + 5 + (i / 10)));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2090ex<?> abstractC2090ex, Collection<?> collection) {
        if (collection != null) {
            if (collection instanceof AbstractC2090ex) {
                collection = ((AbstractC2090ex) collection).mo4975elementSet();
            }
            return abstractC2090ex.mo4975elementSet().retainAll(collection);
        }
        throw null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<?, ?> map, Object obj) {
        if (map != null) {
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        throw null;
    }

    public static <E> ArrayList<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterator<? extends E> it) {
        ArrayList<E> arrayList = new ArrayList<>();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) arrayList, (Iterator) it);
        return arrayList;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<?> collection, Object obj) {
        if (collection != null) {
            try {
                return collection.contains(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        throw null;
    }

    public static <K, V1, V2> Map<K, V2> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Map<K, V1> map, AbstractC2271jt<? super V1, V2> abstractC2271jt) {
        if (abstractC2271jt != null) {
            return new C2650tw(map, new C2311kw(abstractC2271jt));
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> NavigableMap<K, V> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NavigableMap<K, ? extends V> navigableMap) {
        if (navigableMap != 0) {
            return navigableMap instanceof Maps$UnmodifiableNavigableMap ? navigableMap : new Maps$UnmodifiableNavigableMap(navigableMap);
        }
        throw null;
    }

    public static <E> AbstractC2766wx<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2766wx<E> abstractC2766wx) {
        if (abstractC2766wx != null) {
            return new UnmodifiableSortedMultiset(abstractC2766wx);
        }
        throw null;
    }

    public static <V> AbstractC2573rt<Map.Entry<?, V>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2573rt<? super V> abstractC2573rt) {
        return new Predicates$CompositionPredicate(abstractC2573rt, Maps$EntryFunction.VALUE);
    }
}
