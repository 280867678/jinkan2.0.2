package org.mozilla.javascript;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import me.tvspark.m21;
import org.mozilla.javascript.debug.DebuggableObject;

/* loaded from: classes5.dex */
public final class EqualObjectGraphs {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ThreadLocal<EqualObjectGraphs> instance = new ThreadLocal<>();
    public final Map<Object, Object> knownEquals = new IdentityHashMap();
    public final Map<Object, Object> currentlyCompared = new IdentityHashMap();

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        if (obj instanceof Integer) {
            if (obj2 instanceof Integer) {
                return ((Integer) obj).compareTo((Integer) obj2);
            }
            if ((obj2 instanceof String) || (obj2 instanceof Symbol)) {
                return -1;
            }
        } else if (obj instanceof String) {
            if (obj2 instanceof String) {
                return ((String) obj).compareTo((String) obj2);
            }
            if (obj2 instanceof Integer) {
                return 1;
            }
            if (obj2 instanceof Symbol) {
                return -1;
            }
        } else if (obj instanceof Symbol) {
            if (obj2 instanceof Symbol) {
                return getSymbolName((Symbol) obj).compareTo(getSymbolName((Symbol) obj2));
            }
            if ((obj2 instanceof Integer) || (obj2 instanceof String)) {
                return 1;
            }
        }
        throw new ClassCastException();
    }

    private boolean equalGraphsNoMemo(Object obj, Object obj2) {
        return obj instanceof Wrapper ? (obj2 instanceof Wrapper) && equalGraphs(((Wrapper) obj).unwrap(), ((Wrapper) obj2).unwrap()) : obj instanceof Scriptable ? (obj2 instanceof Scriptable) && equalScriptables((Scriptable) obj, (Scriptable) obj2) : obj instanceof ConsString ? ((ConsString) obj).toString().equals(obj2) : obj2 instanceof ConsString ? obj.equals(((ConsString) obj2).toString()) : obj instanceof SymbolKey ? (obj2 instanceof SymbolKey) && equalGraphs(((SymbolKey) obj).getName(), ((SymbolKey) obj2).getName()) : obj instanceof Object[] ? (obj2 instanceof Object[]) && equalObjectArrays((Object[]) obj, (Object[]) obj2) : obj.getClass().isArray() ? Objects.deepEquals(obj, obj2) : obj instanceof List ? (obj2 instanceof List) && equalLists((List) obj, (List) obj2) : obj instanceof Map ? (obj2 instanceof Map) && equalMaps((Map) obj, (Map) obj2) : obj instanceof Set ? (obj2 instanceof Set) && equalSets((Set) obj, (Set) obj2) : obj instanceof NativeGlobal ? obj2 instanceof NativeGlobal : obj instanceof JavaAdapter ? obj2 instanceof JavaAdapter : obj instanceof NativeJavaTopPackage ? obj2 instanceof NativeJavaTopPackage : obj.equals(obj2);
    }

    public static boolean equalInterpretedFunctions(InterpretedFunction interpretedFunction, InterpretedFunction interpretedFunction2) {
        return Objects.equals(interpretedFunction.getEncodedSource(), interpretedFunction2.getEncodedSource());
    }

    private boolean equalLists(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator<?> it = list.iterator();
        Iterator<?> it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!equalGraphs(it.next(), it2.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean equalMaps(Map<?, ?> map, Map<?, ?> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        Iterator<Map.Entry> sortedEntries = sortedEntries(map);
        Iterator<Map.Entry> sortedEntries2 = sortedEntries(map2);
        while (sortedEntries.hasNext() && sortedEntries2.hasNext()) {
            Map.Entry next = sortedEntries.next();
            Map.Entry next2 = sortedEntries2.next();
            if (equalGraphs(next.getKey(), next2.getKey()) || !equalGraphs(next.getValue(), next2.getValue())) {
                return false;
            }
            while (sortedEntries.hasNext()) {
                Map.Entry next3 = sortedEntries.next();
                Map.Entry next22 = sortedEntries2.next();
                if (equalGraphs(next3.getKey(), next22.getKey())) {
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean equalObjectArrays(Object[] objArr, Object[] objArr2) {
        if (objArr.length != objArr2.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (!equalGraphs(objArr[i], objArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean equalScriptables(Scriptable scriptable, Scriptable scriptable2) {
        Object[] sortedIds = getSortedIds(scriptable);
        Object[] sortedIds2 = getSortedIds(scriptable2);
        if (!equalObjectArrays(sortedIds, sortedIds2)) {
            return false;
        }
        int length = sortedIds.length;
        for (int i = 0; i < length; i++) {
            if (!equalGraphs(getValue(scriptable, sortedIds[i]), getValue(scriptable2, sortedIds2[i]))) {
                return false;
            }
        }
        if (!equalGraphs(scriptable.getPrototype(), scriptable2.getPrototype()) || !equalGraphs(scriptable.getParentScope(), scriptable2.getParentScope())) {
            return false;
        }
        if (scriptable instanceof NativeContinuation) {
            return (scriptable2 instanceof NativeContinuation) && NativeContinuation.equalImplementations((NativeContinuation) scriptable, (NativeContinuation) scriptable2);
        } else if (scriptable instanceof NativeJavaPackage) {
            return scriptable.equals(scriptable2);
        } else {
            if (scriptable instanceof IdFunctionObject) {
                return (scriptable2 instanceof IdFunctionObject) && IdFunctionObject.equalObjectGraphs((IdFunctionObject) scriptable, (IdFunctionObject) scriptable2, this);
            } else if (scriptable instanceof InterpretedFunction) {
                return (scriptable2 instanceof InterpretedFunction) && equalInterpretedFunctions((InterpretedFunction) scriptable, (InterpretedFunction) scriptable2);
            } else if (scriptable instanceof ArrowFunction) {
                return (scriptable2 instanceof ArrowFunction) && ArrowFunction.equalObjectGraphs((ArrowFunction) scriptable, (ArrowFunction) scriptable2, this);
            } else if (scriptable instanceof BoundFunction) {
                return (scriptable2 instanceof BoundFunction) && BoundFunction.equalObjectGraphs((BoundFunction) scriptable, (BoundFunction) scriptable2, this);
            } else if (!(scriptable instanceof NativeSymbol)) {
                return true;
            } else {
                return (scriptable2 instanceof NativeSymbol) && equalGraphs(((NativeSymbol) scriptable).getKey(), ((NativeSymbol) scriptable2).getKey());
            }
        }
    }

    private boolean equalSets(Set<?> set, Set<?> set2) {
        return equalObjectArrays(sortedSet(set), sortedSet(set2));
    }

    public static Object[] getIds(Scriptable scriptable) {
        return scriptable instanceof ScriptableObject ? ((ScriptableObject) scriptable).getIds(true, true) : scriptable instanceof DebuggableObject ? ((DebuggableObject) scriptable).getAllIds() : scriptable.getIds();
    }

    public static Object[] getSortedIds(Scriptable scriptable) {
        Object[] ids = getIds(scriptable);
        Arrays.sort(ids, m21.Wwwwwwwwwwwwwwwwwwwwwwww);
        return ids;
    }

    public static String getSymbolName(Symbol symbol) {
        SymbolKey key;
        if (symbol instanceof SymbolKey) {
            key = (SymbolKey) symbol;
        } else if (!(symbol instanceof NativeSymbol)) {
            throw new ClassCastException();
        } else {
            key = ((NativeSymbol) symbol).getKey();
        }
        return key.getName();
    }

    public static Object getValue(Scriptable scriptable, Object obj) {
        if (obj instanceof Symbol) {
            return ScriptableObject.getProperty(scriptable, (Symbol) obj);
        }
        if (obj instanceof Integer) {
            return ScriptableObject.getProperty(scriptable, ((Integer) obj).intValue());
        }
        if (!(obj instanceof String)) {
            throw new ClassCastException();
        }
        return ScriptableObject.getProperty(scriptable, (String) obj);
    }

    public static Iterator<Map.Entry> sortedEntries(Map map) {
        if (!(map instanceof SortedMap)) {
            map = new TreeMap(map);
        }
        return map.entrySet().iterator();
    }

    public static Object[] sortedSet(Set<?> set) {
        Object[] array = set.toArray();
        Arrays.sort(array);
        return array;
    }

    public static <T> T withThreadLocal(java.util.function.Function<EqualObjectGraphs, T> function) {
        EqualObjectGraphs equalObjectGraphs = instance.get();
        if (equalObjectGraphs == null) {
            EqualObjectGraphs equalObjectGraphs2 = new EqualObjectGraphs();
            instance.set(equalObjectGraphs2);
            try {
                return function.apply(equalObjectGraphs2);
            } finally {
                instance.set(null);
            }
        }
        return function.apply(equalObjectGraphs);
    }

    public boolean equalGraphs(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        Object obj3 = this.currentlyCompared.get(obj);
        if (obj3 == obj2) {
            return true;
        }
        if (obj3 != null) {
            return false;
        }
        Object obj4 = this.knownEquals.get(obj);
        if (obj4 == obj2) {
            return true;
        }
        if (obj4 != null || this.knownEquals.get(obj2) != null) {
            return false;
        }
        this.currentlyCompared.put(obj, obj2);
        boolean equalGraphsNoMemo = equalGraphsNoMemo(obj, obj2);
        if (equalGraphsNoMemo) {
            this.knownEquals.put(obj, obj2);
            this.knownEquals.put(obj2, obj);
        }
        this.currentlyCompared.remove(obj);
        return equalGraphsNoMemo;
    }
}
