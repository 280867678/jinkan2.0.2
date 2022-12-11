package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.lifecycle.SavedStateHandle;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import me.tvspark.outline;
import org.mozilla.javascript.NativeArrayIterator;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.regexp.NativeRegExp;
import org.simpleframework.xml.core.AnnotationHandler;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public class NativeArray extends IdScriptableObject implements List {
    public static final int ConstructorId_concat = -13;
    public static final int ConstructorId_every = -17;
    public static final int ConstructorId_filter = -18;
    public static final int ConstructorId_find = -22;
    public static final int ConstructorId_findIndex = -23;
    public static final int ConstructorId_forEach = -19;
    public static final int ConstructorId_from = -28;
    public static final int ConstructorId_indexOf = -15;
    public static final int ConstructorId_isArray = -26;
    public static final int ConstructorId_join = -5;
    public static final int ConstructorId_lastIndexOf = -16;
    public static final int ConstructorId_map = -20;
    public static final int ConstructorId_of = -27;
    public static final int ConstructorId_pop = -9;
    public static final int ConstructorId_push = -8;
    public static final int ConstructorId_reduce = -24;
    public static final int ConstructorId_reduceRight = -25;
    public static final int ConstructorId_reverse = -6;
    public static final int ConstructorId_shift = -10;
    public static final int ConstructorId_slice = -14;
    public static final int ConstructorId_some = -21;
    public static final int ConstructorId_sort = -7;
    public static final int ConstructorId_splice = -12;
    public static final int ConstructorId_unshift = -11;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;
    public static final double GROW_FACTOR = 1.5d;
    public static final int Id_concat = 13;
    public static final int Id_constructor = 1;
    public static final int Id_copyWithin = 31;
    public static final int Id_entries = 29;
    public static final int Id_every = 17;
    public static final int Id_fill = 26;
    public static final int Id_filter = 18;
    public static final int Id_find = 22;
    public static final int Id_findIndex = 23;
    public static final int Id_forEach = 19;
    public static final int Id_includes = 30;
    public static final int Id_indexOf = 15;
    public static final int Id_join = 5;
    public static final int Id_keys = 27;
    public static final int Id_lastIndexOf = 16;
    public static final int Id_length = 1;
    public static final int Id_map = 20;
    public static final int Id_pop = 9;
    public static final int Id_push = 8;
    public static final int Id_reduce = 24;
    public static final int Id_reduceRight = 25;
    public static final int Id_reverse = 6;
    public static final int Id_shift = 10;
    public static final int Id_slice = 14;
    public static final int Id_some = 21;
    public static final int Id_sort = 7;
    public static final int Id_splice = 12;
    public static final int Id_toLocaleString = 3;
    public static final int Id_toSource = 4;
    public static final int Id_toString = 2;
    public static final int Id_unshift = 11;
    public static final int Id_values = 28;
    public static final int MAX_INSTANCE_ID = 1;
    public static final int MAX_PRE_GROW_SIZE = 1431655764;
    public static final int MAX_PROTOTYPE_ID = 32;
    public static final int SymbolId_iterator = 32;
    public static final long serialVersionUID = 7331366857676127338L;
    public Object[] dense;
    public boolean denseOnly;
    public long length;
    public int lengthAttr;
    public static final Object ARRAY_TAG = "Array";
    public static final Long NEGATIVE_ONE = -1L;
    public static final Comparator<Object> STRING_COMPARATOR = new StringLikeComparator();
    public static final Comparator<Object> DEFAULT_COMPARATOR = new ElementComparator();
    public static int maximumInitialCapacity = 10000;

    /* loaded from: classes5.dex */
    public static final class ElementComparator implements Comparator<Object> {
        public final Comparator<Object> child;

        public ElementComparator() {
            this.child = NativeArray.STRING_COMPARATOR;
        }

        public ElementComparator(Comparator<Object> comparator) {
            this.child = comparator;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Object obj3 = Undefined.instance;
            if (obj == obj3) {
                if (obj2 == obj3) {
                    return 0;
                }
                return obj2 == Scriptable.NOT_FOUND ? -1 : 1;
            }
            Object obj4 = Scriptable.NOT_FOUND;
            if (obj == obj4) {
                return obj2 == obj4 ? 0 : 1;
            } else if (obj2 != obj4 && obj2 != Undefined.instance) {
                return this.child.compare(obj, obj2);
            } else {
                return -1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class StringLikeComparator implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ScriptRuntime.toString(obj).compareTo(ScriptRuntime.toString(obj2));
        }
    }

    public NativeArray(long j) {
        this.lengthAttr = 6;
        boolean z = j <= ((long) maximumInitialCapacity);
        this.denseOnly = z;
        if (z) {
            int i = (int) j;
            Object[] objArr = new Object[i < 10 ? 10 : i];
            this.dense = objArr;
            Arrays.fill(objArr, Scriptable.NOT_FOUND);
        }
        this.length = j;
    }

    public NativeArray(Object[] objArr) {
        this.lengthAttr = 6;
        this.denseOnly = true;
        this.dense = objArr;
        this.length = objArr.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Scriptable callConstructorOrCreateArray(Context context, Scriptable scriptable, Scriptable scriptable2, long j, boolean z) {
        Scriptable construct;
        int i = 0;
        if (scriptable2 instanceof Function) {
            try {
                construct = ((Function) scriptable2).construct(context, scriptable, (z || j > 0) ? new Object[]{Long.valueOf(j)} : ScriptRuntime.emptyArgs);
            } catch (EcmaError e) {
                if (!"TypeError".equals(e.getName())) {
                    throw e;
                }
            }
            if (construct == null) {
                return construct;
            }
            if (j <= 2147483647L) {
                i = (int) j;
            }
            return context.newArray(scriptable, i);
        }
        construct = null;
        if (construct == null) {
        }
    }

    public static long concatSpreadArg(Context context, Scriptable scriptable, Scriptable scriptable2, long j) {
        long lengthProperty = getLengthProperty(context, scriptable2, false);
        long j2 = lengthProperty + j;
        if (j2 <= 2147483647L && (scriptable instanceof NativeArray)) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && (scriptable2 instanceof NativeArray)) {
                NativeArray nativeArray2 = (NativeArray) scriptable2;
                if (nativeArray2.denseOnly) {
                    nativeArray.ensureCapacity((int) j2);
                    System.arraycopy(nativeArray2.dense, 0, nativeArray.dense, (int) j, (int) lengthProperty);
                    return j2;
                }
            }
        }
        long j3 = 0;
        while (j3 < lengthProperty) {
            Object rawElem = getRawElem(scriptable2, j3);
            if (rawElem != Scriptable.NOT_FOUND) {
                defineElem(context, scriptable, j, rawElem);
            }
            j3++;
            j++;
        }
        return j2;
    }

    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, parentScope, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        nativeObject.defineProperty("writable", (Object) true, 0);
        nativeObject.defineProperty("enumerable", (Object) true, 0);
        nativeObject.defineProperty("configurable", (Object) true, 0);
        return nativeObject;
    }

    public static void defineElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > 2147483647L) {
            scriptable.put(Long.toString(j), scriptable, obj);
        } else {
            scriptable.put((int) j, scriptable, obj);
        }
    }

    public static void deleteElem(Scriptable scriptable, long j) {
        int i = (int) j;
        if (i == j) {
            scriptable.delete(i);
        } else {
            scriptable.delete(Long.toString(j));
        }
    }

    public static long doConcat(Context context, Scriptable scriptable, Scriptable scriptable2, Object obj, long j) {
        if (isConcatSpreadable(context, scriptable, obj)) {
            return concatSpreadArg(context, scriptable2, (Scriptable) obj, j);
        }
        defineElem(context, scriptable2, j, obj);
        return j + 1;
    }

    private boolean ensureCapacity(int i) {
        Object[] objArr = this.dense;
        if (i > objArr.length) {
            if (i > 1431655764) {
                this.denseOnly = false;
                return false;
            }
            int max = Math.max(i, (int) (objArr.length * 1.5d));
            Object[] objArr2 = new Object[max];
            Object[] objArr3 = this.dense;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            Arrays.fill(objArr2, this.dense.length, max, Scriptable.NOT_FOUND);
            this.dense = objArr2;
            return true;
        }
        return true;
    }

    public static Object getElem(Context context, Scriptable scriptable, long j) {
        Object rawElem = getRawElem(scriptable, j);
        return rawElem != Scriptable.NOT_FOUND ? rawElem : Undefined.instance;
    }

    public static long getLengthProperty(Context context, Scriptable scriptable, boolean z) {
        if (scriptable instanceof NativeString) {
            return ((NativeString) scriptable).getLength();
        }
        if (scriptable instanceof NativeArray) {
            return ((NativeArray) scriptable).getLength();
        }
        Object property = ScriptableObject.getProperty(scriptable, Name.LENGTH);
        if (property == Scriptable.NOT_FOUND) {
            return 0L;
        }
        double number = ScriptRuntime.toNumber(property);
        if (number > 9.007199254740991E15d) {
            if (z) {
                throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
            }
            return 2147483647L;
        } else if (number >= RoundRectDrawableWithShadow.COS_45) {
            return ScriptRuntime.toUint32(property);
        } else {
            return 0L;
        }
    }

    public static int getMaximumInitialCapacity() {
        return maximumInitialCapacity;
    }

    public static Object getRawElem(Scriptable scriptable, long j) {
        return j > 2147483647L ? ScriptableObject.getProperty(scriptable, Long.toString(j)) : ScriptableObject.getProperty(scriptable, (int) j);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeArray(0L).exportAsJSClass(32, scriptable, z);
    }

    public static boolean isConcatSpreadable(Context context, Scriptable scriptable, Object obj) {
        Object property;
        if (!(obj instanceof Scriptable) || (property = ScriptableObject.getProperty((Scriptable) obj, SymbolKey.IS_CONCAT_SPREADABLE)) == Scriptable.NOT_FOUND || Undefined.isUndefined(property)) {
            if (context.getLanguageVersion() < 200 && ScriptRuntime.instanceOf(obj, ScriptRuntime.getExistingCtor(context, scriptable, "Array"), context)) {
                return true;
            }
            return js_isArray(obj);
        }
        return ScriptRuntime.toBoolean(property);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Object iterativeMethod(Context context, IdFunctionObject idFunctionObject, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double d;
        long j;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int abs = Math.abs(idFunctionObject.methodId());
        int i = 23;
        int i2 = 22;
        if (22 == abs || 23 == abs) {
            object = ScriptRuntimeES6.requireObjectCoercible(context, object, idFunctionObject);
        }
        long lengthProperty = getLengthProperty(context, object, abs == 20);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        if (context.getLanguageVersion() >= 200 && (obj instanceof NativeRegExp)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        Scriptable object2 = (objArr.length < 2 || objArr[1] == null || objArr[1] == Undefined.instance) ? topLevelScope : ScriptRuntime.toObject(context, scriptable, objArr[1]);
        Scriptable scriptable3 = null;
        if (abs == 18 || abs == 20) {
            scriptable3 = context.newArray(scriptable, abs == 20 ? (int) lengthProperty : 0);
        }
        long j2 = 0;
        long j3 = 0;
        while (true) {
            if (j2 >= lengthProperty) {
                switch (abs) {
                    case 17:
                        return Boolean.TRUE;
                    case 18:
                    case 20:
                        return scriptable3;
                    case 19:
                    case 22:
                    default:
                        return Undefined.instance;
                    case 21:
                        return Boolean.FALSE;
                    case 23:
                        d = -1.0d;
                        break;
                }
            } else {
                Object[] objArr2 = new Object[3];
                Object rawElem = getRawElem(object, j2);
                if (rawElem == Scriptable.NOT_FOUND) {
                    if (abs == i2 || abs == i) {
                        rawElem = Undefined.instance;
                    } else {
                        j = j3;
                        j3 = j;
                        j2++;
                        i = 23;
                        i2 = 22;
                    }
                }
                objArr2[0] = rawElem;
                objArr2[1] = Long.valueOf(j2);
                objArr2[2] = object;
                Object call = function.call(context, topLevelScope, object2, objArr2);
                switch (abs) {
                    case 17:
                        j = j3;
                        if (!ScriptRuntime.toBoolean(call)) {
                            return Boolean.FALSE;
                        }
                        break;
                    case 18:
                        if (ScriptRuntime.toBoolean(call)) {
                            long j4 = j3;
                            j3 = j4 + 1;
                            defineElem(context, scriptable3, j4, objArr2[0]);
                            continue;
                            j2++;
                            i = 23;
                            i2 = 22;
                        }
                        j = j3;
                        break;
                    case 19:
                    default:
                        j = j3;
                        break;
                    case 20:
                        defineElem(context, scriptable3, j2, call);
                        j = j3;
                        break;
                    case 21:
                        if (ScriptRuntime.toBoolean(call)) {
                            return Boolean.TRUE;
                        }
                        j = j3;
                        break;
                    case 22:
                        if (ScriptRuntime.toBoolean(call)) {
                            return rawElem;
                        }
                        j = j3;
                        break;
                    case 23:
                        if (ScriptRuntime.toBoolean(call)) {
                            d = j2;
                            break;
                        }
                        j = j3;
                        break;
                }
                j3 = j;
                j2++;
                i = 23;
                i2 = 22;
            }
        }
        return ScriptRuntime.wrapNumber(d);
    }

    public static Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length == 0) {
            return new NativeArray(0L);
        }
        if (context.getLanguageVersion() == 120) {
            return new NativeArray(objArr);
        }
        Object obj = objArr[0];
        if (objArr.length > 1 || !(obj instanceof Number)) {
            return new NativeArray(objArr);
        }
        long uint32 = ScriptRuntime.toUint32(obj);
        if (uint32 != ((Number) obj).doubleValue()) {
            throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        return new NativeArray(uint32);
    }

    public static Scriptable js_concat(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Scriptable newArray = context.newArray(topLevelScope, 0);
        long doConcat = doConcat(context, topLevelScope, newArray, scriptable2, 0L);
        for (Object obj : objArr) {
            doConcat = doConcat(context, topLevelScope, newArray, obj, doConcat);
        }
        setLengthProperty(context, newArray, doConcat);
        return newArray;
    }

    public static Object js_copyWithin(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        int i = 1;
        long integer = (long) ScriptRuntime.toInteger(objArr.length >= 1 ? objArr[0] : Undefined.instance);
        long max = integer < 0 ? Math.max(integer + lengthProperty, 0L) : Math.min(integer, lengthProperty);
        long integer2 = (long) ScriptRuntime.toInteger(objArr.length >= 2 ? objArr[1] : Undefined.instance);
        long max2 = integer2 < 0 ? Math.max(integer2 + lengthProperty, 0L) : Math.min(integer2, lengthProperty);
        long integer3 = (objArr.length < 3 || Undefined.isUndefined(objArr[2])) ? lengthProperty : (long) ScriptRuntime.toInteger(objArr[2]);
        long min = Math.min((integer3 < 0 ? Math.max(integer3 + lengthProperty, 0L) : Math.min(integer3, lengthProperty)) - max2, lengthProperty - max);
        if (max2 < max) {
            long j = max2 + min;
            if (max < j) {
                i = -1;
                max2 = j - 1;
                max = (max + min) - 1;
            }
        }
        if ((object instanceof NativeArray) && min <= 2147483647L) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                while (min > 0) {
                    Object[] objArr2 = nativeArray.dense;
                    objArr2[(int) max] = objArr2[(int) max2];
                    long j2 = i;
                    max2 += j2;
                    max += j2;
                    min--;
                }
                return scriptable2;
            }
        }
        while (min > 0) {
            Object rawElem = getRawElem(object, max2);
            if (rawElem == Scriptable.NOT_FOUND || Undefined.isUndefined(rawElem)) {
                deleteElem(object, max);
            } else {
                setElem(context, object, max, rawElem);
            }
            long j3 = i;
            max2 += j3;
            max += j3;
            min--;
        }
        return scriptable2;
    }

    public static Object js_fill(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long lengthProperty = getLengthProperty(context, ScriptRuntime.toObject(context, scriptable, scriptable2), false);
        long integer = objArr.length >= 2 ? (long) ScriptRuntime.toInteger(objArr[1]) : 0L;
        long integer2 = (objArr.length < 3 || Undefined.isUndefined(objArr[2])) ? lengthProperty : (long) ScriptRuntime.toInteger(objArr[2]);
        long max = integer2 < 0 ? Math.max(lengthProperty + integer2, 0L) : Math.min(integer2, lengthProperty);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        for (long max2 = integer < 0 ? Math.max(integer + lengthProperty, 0L) : Math.min(integer, lengthProperty); max2 < max; max2++) {
            setRawElem(context, scriptable2, max2, obj);
        }
        return scriptable2;
    }

    public static Object js_from(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(scriptable, objArr.length >= 1 ? objArr[0] : Undefined.instance);
        Object obj = objArr.length >= 2 ? objArr[1] : Undefined.instance;
        Scriptable scriptable3 = Undefined.SCRIPTABLE_UNDEFINED;
        boolean z = !Undefined.isUndefined(obj);
        Function function = null;
        if (z) {
            if (!(obj instanceof Function)) {
                throw ScriptRuntime.typeError0("msg.map.function.not");
            }
            function = (Function) obj;
            if (objArr.length >= 3) {
                scriptable3 = ScriptableObject.ensureScriptable(objArr[2]);
            }
        }
        Scriptable scriptable4 = scriptable3;
        Function function2 = function;
        Object property = ScriptableObject.getProperty(object, SymbolKey.ITERATOR);
        if (!(object instanceof NativeArray) && property != Scriptable.NOT_FOUND && !Undefined.isUndefined(property)) {
            Object callIterator = ScriptRuntime.callIterator(object, context, scriptable);
            if (!Undefined.isUndefined(callIterator)) {
                Scriptable callConstructorOrCreateArray = callConstructorOrCreateArray(context, scriptable, scriptable2, 0L, false);
                IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, callIterator);
                try {
                    Iterator<Object> it = iteratorLikeIterable.iterator();
                    long j = 0;
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (z) {
                            next = function2.call(context, scriptable, scriptable4, new Object[]{next, Long.valueOf(j)});
                        }
                        defineElem(context, callConstructorOrCreateArray, j, next);
                        j++;
                    }
                    iteratorLikeIterable.close();
                    setLengthProperty(context, callConstructorOrCreateArray, j);
                    return callConstructorOrCreateArray;
                } finally {
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        Scriptable callConstructorOrCreateArray2 = callConstructorOrCreateArray(context, scriptable, scriptable2, lengthProperty, true);
        for (long j2 = 0; j2 < lengthProperty; j2++) {
            Object rawElem = getRawElem(object, j2);
            if (rawElem != Scriptable.NOT_FOUND) {
                if (z) {
                    rawElem = function2.call(context, scriptable, scriptable4, new Object[]{rawElem, Long.valueOf(j2)});
                }
                defineElem(context, callConstructorOrCreateArray2, j2, rawElem);
            }
        }
        setLengthProperty(context, callConstructorOrCreateArray2, lengthProperty);
        return callConstructorOrCreateArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r9 < 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object js_indexOf(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        long j = 0;
        if (objArr.length >= 2) {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer < 0) {
                integer += lengthProperty;
            }
            j = integer;
            if (j > lengthProperty - 1) {
                return NEGATIVE_ONE;
            }
        }
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                int i = (int) j;
                while (true) {
                    long j2 = i;
                    if (j2 >= lengthProperty) {
                        return NEGATIVE_ONE;
                    }
                    Object obj2 = nativeArray.dense[i];
                    if (obj2 == Scriptable.NOT_FOUND && prototype != null) {
                        obj2 = ScriptableObject.getProperty(prototype, i);
                    }
                    if (obj2 != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(obj2, obj)) {
                        return Long.valueOf(j2);
                    }
                    i++;
                }
            }
        }
        while (j < lengthProperty) {
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                return Long.valueOf(j);
            }
            j++;
        }
        return NEGATIVE_ONE;
    }

    public static boolean js_isArray(Object obj) {
        if (!(obj instanceof Scriptable)) {
            return false;
        }
        return "Array".equals(((Scriptable) obj).getClassName());
    }

    public static String js_join(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        int i = 0;
        long lengthProperty = getLengthProperty(context, scriptable, false);
        int i2 = (int) lengthProperty;
        if (lengthProperty == i2) {
            String scriptRuntime = (objArr.length < 1 || objArr[0] == Undefined.instance) ? "," : ScriptRuntime.toString(objArr[0]);
            if (scriptable instanceof NativeArray) {
                NativeArray nativeArray = (NativeArray) scriptable;
                if (nativeArray.denseOnly) {
                    StringBuilder sb = new StringBuilder();
                    while (i < i2) {
                        if (i != 0) {
                            sb.append(scriptRuntime);
                        }
                        Object[] objArr2 = nativeArray.dense;
                        if (i < objArr2.length && (obj = objArr2[i]) != null && obj != Undefined.instance && obj != Scriptable.NOT_FOUND) {
                            sb.append(ScriptRuntime.toString(obj));
                        }
                        i++;
                    }
                    return sb.toString();
                }
            }
            if (i2 == 0) {
                return "";
            }
            String[] strArr = new String[i2];
            int i3 = 0;
            for (int i4 = 0; i4 != i2; i4++) {
                Object elem = getElem(context, scriptable, i4);
                if (elem != null && elem != Undefined.instance) {
                    String scriptRuntime2 = ScriptRuntime.toString(elem);
                    i3 += scriptRuntime2.length();
                    strArr[i4] = scriptRuntime2;
                }
            }
            StringBuilder sb2 = new StringBuilder((scriptRuntime.length() * (i2 - 1)) + i3);
            while (i != i2) {
                if (i != 0) {
                    sb2.append(scriptRuntime);
                }
                String str = strArr[i];
                if (str != null) {
                    sb2.append(str);
                }
                i++;
            }
            return sb2.toString();
        }
        throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
    }

    public static Object js_lastIndexOf(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long j;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        if (objArr.length < 2) {
            j = lengthProperty - 1;
        } else {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer >= lengthProperty) {
                j = lengthProperty - 1;
            } else {
                if (integer < 0) {
                    integer += lengthProperty;
                }
                j = integer;
            }
            if (j < 0) {
                return NEGATIVE_ONE;
            }
        }
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                for (int i = (int) j; i >= 0; i--) {
                    Object obj2 = nativeArray.dense[i];
                    if (obj2 == Scriptable.NOT_FOUND && prototype != null) {
                        obj2 = ScriptableObject.getProperty(prototype, i);
                    }
                    if (obj2 != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(obj2, obj)) {
                        return Long.valueOf(i);
                    }
                }
                return NEGATIVE_ONE;
            }
        }
        while (j >= 0) {
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                return Long.valueOf(j);
            }
            j--;
        }
        return NEGATIVE_ONE;
    }

    public static Object js_of(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable callConstructorOrCreateArray = callConstructorOrCreateArray(context, scriptable, scriptable2, objArr.length, true);
        for (int i = 0; i < objArr.length; i++) {
            defineElem(context, callConstructorOrCreateArray, i, objArr[i]);
        }
        setLengthProperty(context, callConstructorOrCreateArray, objArr.length);
        return callConstructorOrCreateArray;
    }

    public static Object js_pop(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj2 = objArr2[(int) j2];
                    objArr2[(int) j2] = Scriptable.NOT_FOUND;
                    return obj2;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable, false);
        if (lengthProperty > 0) {
            lengthProperty--;
            obj = getElem(context, scriptable, lengthProperty);
            deleteElem(scriptable, lengthProperty);
        } else {
            obj = Undefined.instance;
        }
        setLengthProperty(context, scriptable, lengthProperty);
        return obj;
    }

    public static Object js_push(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                while (i < objArr.length) {
                    Object[] objArr2 = nativeArray.dense;
                    long j = nativeArray.length;
                    nativeArray.length = 1 + j;
                    objArr2[(int) j] = objArr[i];
                    i++;
                }
                return ScriptRuntime.wrapNumber(nativeArray.length);
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable, false);
        while (i < objArr.length) {
            setElem(context, scriptable, i + lengthProperty, objArr[i]);
            i++;
        }
        return context.getLanguageVersion() == 120 ? objArr.length == 0 ? Undefined.instance : objArr[objArr.length - 1] : setLengthProperty(context, scriptable, lengthProperty + objArr.length);
    }

    public static Scriptable js_reverse(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                for (int i2 = ((int) nativeArray.length) - 1; i < i2; i2--) {
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[i];
                    objArr2[i] = objArr2[i2];
                    objArr2[i2] = obj;
                    i++;
                }
                return scriptable;
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable, false);
        long j = lengthProperty / 2;
        for (long j2 = 0; j2 < j; j2++) {
            long j3 = (lengthProperty - j2) - 1;
            Object rawElem = getRawElem(scriptable, j2);
            setRawElem(context, scriptable, j2, getRawElem(scriptable, j3));
            setRawElem(context, scriptable, j3, rawElem);
        }
        return scriptable;
    }

    public static Object js_shift(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj2 = objArr2[0];
                    System.arraycopy(objArr2, 1, objArr2, 0, (int) j2);
                    Object[] objArr3 = nativeArray.dense;
                    int i = (int) nativeArray.length;
                    Object obj3 = Scriptable.NOT_FOUND;
                    objArr3[i] = obj3;
                    return obj2 == obj3 ? Undefined.instance : obj2;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable, false);
        if (lengthProperty > 0) {
            lengthProperty--;
            obj = getElem(context, scriptable, 0L);
            if (lengthProperty > 0) {
                for (long j3 = 1; j3 <= lengthProperty; j3++) {
                    setRawElem(context, scriptable, j3 - 1, getRawElem(scriptable, j3));
                }
            }
            deleteElem(scriptable, lengthProperty);
        } else {
            obj = Undefined.instance;
        }
        setLengthProperty(context, scriptable, lengthProperty);
        return obj;
    }

    private Scriptable js_slice(Context context, Scriptable scriptable, Object[] objArr) {
        long sliceIndex;
        Scriptable newArray = context.newArray(ScriptableObject.getTopLevelScope(this), 0);
        long lengthProperty = getLengthProperty(context, scriptable, false);
        if (objArr.length == 0) {
            sliceIndex = 0;
        } else {
            sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
            if (objArr.length != 1 && objArr[1] != Undefined.instance) {
                lengthProperty = toSliceIndex(ScriptRuntime.toInteger(objArr[1]), lengthProperty);
            }
        }
        for (long j = sliceIndex; j < lengthProperty; j++) {
            Object rawElem = getRawElem(scriptable, j);
            if (rawElem != Scriptable.NOT_FOUND) {
                defineElem(context, newArray, j - sliceIndex, rawElem);
            }
        }
        setLengthProperty(context, newArray, Math.max(0L, lengthProperty - sliceIndex));
        return newArray;
    }

    public static Scriptable js_sort(final Context context, final Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Comparator<Object> comparator;
        if (objArr.length <= 0 || Undefined.instance == objArr[0]) {
            comparator = DEFAULT_COMPARATOR;
        } else {
            final Callable valueFunctionAndThis = ScriptRuntime.getValueFunctionAndThis(objArr[0], context);
            final Scriptable lastStoredScriptable = ScriptRuntime.lastStoredScriptable(context);
            final Object[] objArr2 = new Object[2];
            comparator = new ElementComparator(new Comparator<Object>() { // from class: org.mozilla.javascript.NativeArray.1
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    Object[] objArr3 = objArr2;
                    objArr3[0] = obj;
                    objArr3[1] = obj2;
                    double number = ScriptRuntime.toNumber(valueFunctionAndThis.call(context, scriptable, lastStoredScriptable, objArr3));
                    if (number < RoundRectDrawableWithShadow.COS_45) {
                        return -1;
                    }
                    return number > RoundRectDrawableWithShadow.COS_45 ? 1 : 0;
                }
            });
        }
        long lengthProperty = getLengthProperty(context, scriptable2, false);
        int i = (int) lengthProperty;
        if (lengthProperty == i) {
            Object[] objArr3 = new Object[i];
            for (int i2 = 0; i2 != i; i2++) {
                objArr3[i2] = getRawElem(scriptable2, i2);
            }
            Sorting.get().hybridSort(objArr3, comparator);
            for (int i3 = 0; i3 < i; i3++) {
                setRawElem(context, scriptable2, i3, objArr3[i3]);
            }
            return scriptable2;
        }
        throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014b A[LOOP:1: B:42:0x0149->B:43:0x014b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object js_splice(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        NativeArray nativeArray;
        boolean z;
        boolean z2;
        long j;
        NativeArray nativeArray2;
        long j2;
        Object obj;
        int i;
        int i2;
        Object obj2;
        if (scriptable2 instanceof NativeArray) {
            nativeArray = (NativeArray) scriptable2;
            z = nativeArray.denseOnly;
        } else {
            nativeArray = null;
            z = false;
        }
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        int length = objArr.length;
        if (length == 0) {
            return context.newArray(topLevelScope, 0);
        }
        long lengthProperty = getLengthProperty(context, scriptable2, false);
        long sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
        int i3 = length - 1;
        if (objArr.length == 1) {
            j = lengthProperty - sliceIndex;
            z2 = z;
        } else {
            double integer = ScriptRuntime.toInteger(objArr[1]);
            z2 = z;
            if (integer < RoundRectDrawableWithShadow.COS_45) {
                j = 0;
            } else {
                long j3 = lengthProperty - sliceIndex;
                if (integer <= j3) {
                    j3 = (long) integer;
                }
                j = j3;
            }
            i3--;
        }
        long j4 = sliceIndex + j;
        if (j == 0) {
            nativeArray2 = nativeArray;
            j2 = lengthProperty;
            if (context.getLanguageVersion() != 120) {
                obj = context.newArray(topLevelScope, 0);
                long j5 = i3;
                long j6 = j5 - j;
                if (z2) {
                    long j7 = j2 + j6;
                    if (j7 < 2147483647L) {
                        int i4 = (int) j7;
                        NativeArray nativeArray3 = nativeArray2;
                        if (nativeArray3.ensureCapacity(i4)) {
                            Object[] objArr2 = nativeArray3.dense;
                            System.arraycopy(objArr2, (int) j4, objArr2, (int) (j5 + sliceIndex), (int) (j2 - j4));
                            if (i3 > 0) {
                                System.arraycopy(objArr, 2, nativeArray3.dense, (int) sliceIndex, i3);
                            }
                            if (j6 < 0) {
                                Arrays.fill(nativeArray3.dense, i4, (int) j2, Scriptable.NOT_FOUND);
                            }
                            nativeArray3.length = j7;
                            return obj;
                        }
                    }
                }
                long j8 = j2;
                i = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
                if (i <= 0) {
                    long j9 = j8 - 1;
                    while (j9 >= j4) {
                        setRawElem(context, scriptable2, j9 + j6, getRawElem(scriptable2, j9));
                        j9--;
                        j4 = j4;
                    }
                } else if (i < 0) {
                    for (long j10 = j4; j10 < j8; j10++) {
                        setRawElem(context, scriptable2, j10 + j6, getRawElem(scriptable2, j10));
                    }
                    for (long j11 = j8 - 1; j11 >= j8 + j6; j11--) {
                        deleteElem(scriptable2, j11);
                    }
                }
                int length2 = objArr.length - i3;
                for (i2 = 0; i2 < i3; i2++) {
                    setElem(context, scriptable2, i2 + sliceIndex, objArr[i2 + length2]);
                }
                setLengthProperty(context, scriptable2, j8 + j6);
                return obj;
            }
            obj2 = Undefined.instance;
        } else if (j == 1 && context.getLanguageVersion() == 120) {
            nativeArray2 = nativeArray;
            j2 = lengthProperty;
            obj2 = getElem(context, scriptable2, sliceIndex);
        } else if (z2) {
            int i5 = (int) (j4 - sliceIndex);
            Object[] objArr3 = new Object[i5];
            nativeArray2 = nativeArray;
            j2 = lengthProperty;
            System.arraycopy(nativeArray.dense, (int) sliceIndex, objArr3, 0, i5);
            obj2 = context.newArray(topLevelScope, objArr3);
        } else {
            nativeArray2 = nativeArray;
            j2 = lengthProperty;
            Scriptable newArray = context.newArray(topLevelScope, 0);
            for (long j12 = sliceIndex; j12 != j4; j12++) {
                Object rawElem = getRawElem(scriptable2, j12);
                if (rawElem != Scriptable.NOT_FOUND) {
                    setElem(context, newArray, j12 - sliceIndex, rawElem);
                }
            }
            setLengthProperty(context, newArray, j4 - sliceIndex);
            obj2 = newArray;
        }
        obj = obj2;
        long j52 = i3;
        long j62 = j52 - j;
        if (z2) {
        }
        long j82 = j2;
        i = (j62 > 0L ? 1 : (j62 == 0L ? 0 : -1));
        if (i <= 0) {
        }
        int length22 = objArr.length - i3;
        while (i2 < i3) {
        }
        setLengthProperty(context, scriptable2, j82 + j62);
        return obj;
    }

    public static Object js_unshift(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                Object[] objArr2 = nativeArray.dense;
                System.arraycopy(objArr2, 0, objArr2, objArr.length, (int) nativeArray.length);
                while (i < objArr.length) {
                    nativeArray.dense[i] = objArr[i];
                    i++;
                }
                long length = nativeArray.length + objArr.length;
                nativeArray.length = length;
                return ScriptRuntime.wrapNumber(length);
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable, false);
        int length2 = objArr.length;
        if (objArr.length > 0) {
            if (lengthProperty > 0) {
                for (long j = lengthProperty - 1; j >= 0; j--) {
                    setRawElem(context, scriptable, length2 + j, getRawElem(scriptable, j));
                }
            }
            while (i < objArr.length) {
                setElem(context, scriptable, i, objArr[i]);
                i++;
            }
        }
        return setLengthProperty(context, scriptable, lengthProperty + objArr.length);
    }

    public static Object reduceMethod(Context context, int i, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        boolean z = i == 24;
        Object obj2 = objArr.length > 1 ? objArr[1] : Scriptable.NOT_FOUND;
        for (long j = 0; j < lengthProperty; j++) {
            long j2 = z ? j : (lengthProperty - 1) - j;
            Object rawElem = getRawElem(object, j2);
            Object obj3 = Scriptable.NOT_FOUND;
            if (rawElem != obj3) {
                obj2 = obj2 == obj3 ? rawElem : function.call(context, topLevelScope, topLevelScope, new Object[]{obj2, rawElem, Long.valueOf(j2), object});
            }
        }
        if (obj2 == Scriptable.NOT_FOUND) {
            throw ScriptRuntime.typeError0("msg.empty.array.reduce");
        }
        return obj2;
    }

    public static void setElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > 2147483647L) {
            ScriptableObject.putProperty(scriptable, Long.toString(j), obj);
        } else {
            ScriptableObject.putProperty(scriptable, (int) j, obj);
        }
    }

    private void setLength(Object obj) {
        Object[] ids;
        if ((this.lengthAttr & 1) != 0) {
            return;
        }
        double number = ScriptRuntime.toNumber(obj);
        long uint32 = ScriptRuntime.toUint32(number);
        double d = uint32;
        if (d != number) {
            throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        if (this.denseOnly) {
            long j = this.length;
            if (uint32 < j) {
                Object[] objArr = this.dense;
                Arrays.fill(objArr, (int) uint32, objArr.length, Scriptable.NOT_FOUND);
                this.length = uint32;
                return;
            } else if (uint32 < 1431655764 && d < j * 1.5d && ensureCapacity((int) uint32)) {
                this.length = uint32;
                return;
            } else {
                this.denseOnly = false;
            }
        }
        long j2 = this.length;
        if (uint32 < j2) {
            if (j2 - uint32 > 4096) {
                for (Object obj2 : getIds()) {
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (toArrayIndex(str) >= uint32) {
                            delete(str);
                        }
                    } else {
                        int intValue = ((Integer) obj2).intValue();
                        if (intValue >= uint32) {
                            delete(intValue);
                        }
                    }
                }
            } else {
                for (long j3 = uint32; j3 < this.length; j3++) {
                    deleteElem(this, j3);
                }
            }
        }
        this.length = uint32;
    }

    public static Object setLengthProperty(Context context, Scriptable scriptable, long j) {
        Number wrapNumber = ScriptRuntime.wrapNumber(j);
        ScriptableObject.putProperty(scriptable, Name.LENGTH, wrapNumber);
        return wrapNumber;
    }

    public static void setMaximumInitialCapacity(int i) {
        maximumInitialCapacity = i;
    }

    public static void setRawElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (obj == Scriptable.NOT_FOUND) {
            deleteElem(scriptable, j);
        } else {
            setElem(context, scriptable, j, obj);
        }
    }

    public static long toArrayIndex(double d) {
        if (d == d) {
            long uint32 = ScriptRuntime.toUint32(d);
            if (uint32 == d && uint32 != 4294967295L) {
                return uint32;
            }
            return -1L;
        }
        return -1L;
    }

    public static long toArrayIndex(Object obj) {
        if (obj instanceof String) {
            return toArrayIndex((String) obj);
        }
        if (!(obj instanceof Number)) {
            return -1L;
        }
        return toArrayIndex(((Number) obj).doubleValue());
    }

    public static long toArrayIndex(String str) {
        long arrayIndex = toArrayIndex(ScriptRuntime.toNumber(str));
        if (Long.toString(arrayIndex).equals(str)) {
            return arrayIndex;
        }
        return -1L;
    }

    public static int toDenseIndex(Object obj) {
        long arrayIndex = toArrayIndex(obj);
        if (0 > arrayIndex || arrayIndex >= 2147483647L) {
            return -1;
        }
        return (int) arrayIndex;
    }

    public static long toSliceIndex(double d, long j) {
        if (d < RoundRectDrawableWithShadow.COS_45) {
            d += j;
            if (d < RoundRectDrawableWithShadow.COS_45) {
                return 0L;
            }
        } else if (d > j) {
            return j;
        }
        return (long) d;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String toStringHelper(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z, boolean z2) {
        String str;
        boolean has;
        boolean z3;
        boolean z4;
        long j;
        boolean z5;
        String scriptRuntime;
        long lengthProperty = getLengthProperty(context, scriptable2, false);
        StringBuilder sb = new StringBuilder(256);
        if (z) {
            sb.append('[');
            str = ", ";
        } else {
            str = ",";
        }
        ObjToIntMap objToIntMap = context.iterating;
        if (objToIntMap == null) {
            context.iterating = new ObjToIntMap(31);
            has = false;
            z3 = true;
        } else {
            has = objToIntMap.has(scriptable2);
            z3 = false;
        }
        long j2 = 0;
        if (!has) {
            try {
                context.iterating.put(scriptable2, 0);
                if (z && context.getLanguageVersion() >= 150) {
                    z4 = false;
                    j = 0;
                    boolean z6 = false;
                    while (j < lengthProperty) {
                        if (j > j2) {
                            sb.append(str);
                        }
                        Object rawElem = getRawElem(scriptable2, j);
                        if (rawElem != Scriptable.NOT_FOUND && (!z4 || (rawElem != null && rawElem != Undefined.instance))) {
                            if (z) {
                                scriptRuntime = ScriptRuntime.uneval(context, scriptable, rawElem);
                            } else if (rawElem instanceof String) {
                                scriptRuntime = (String) rawElem;
                                if (z) {
                                    sb.append('\"');
                                    sb.append(ScriptRuntime.escapeString(scriptRuntime));
                                    sb.append('\"');
                                    z6 = true;
                                    j++;
                                    j2 = 0;
                                }
                            } else {
                                if (z2) {
                                    rawElem = ScriptRuntime.getPropFunctionAndThis(rawElem, "toLocaleString", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs);
                                }
                                scriptRuntime = ScriptRuntime.toString(rawElem);
                            }
                            sb.append(scriptRuntime);
                            z6 = true;
                            j++;
                            j2 = 0;
                        }
                        z6 = false;
                        j++;
                        j2 = 0;
                    }
                    z5 = z6;
                }
                z4 = true;
                j = 0;
                boolean z62 = false;
                while (j < lengthProperty) {
                }
                z5 = z62;
            } finally {
                if (z3) {
                    context.iterating = null;
                }
            }
        } else {
            z5 = false;
            j = 0;
        }
        if (z) {
            if (z5 || j <= 0) {
                sb.append(']');
            } else {
                sb.append(", ]");
            }
        }
        return sb.toString();
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        Object[] objArr = this.dense;
        if (objArr != null) {
            this.dense = null;
            this.denseOnly = false;
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] != Scriptable.NOT_FOUND) {
                    put(i, this, objArr[i]);
                }
            }
        }
        long arrayIndex = toArrayIndex(obj);
        if (arrayIndex >= this.length) {
            this.length = arrayIndex + 1;
        }
        super.defineOwnProperty(context, obj, scriptableObject, z);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || isSealed() || (!this.denseOnly && isGetterOrSetter(null, i, true))) {
            super.delete(i);
        } else {
            this.dense[i] = Scriptable.NOT_FOUND;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ARRAY_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        while (true) {
            boolean z = true;
            int i = 0;
            switch (methodId) {
                case -28:
                    return js_from(context, scriptable, scriptable2, objArr);
                case -27:
                    return js_of(context, scriptable, scriptable2, objArr);
                case -26:
                    if (objArr.length <= 0 || !js_isArray(objArr[0])) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case -25:
                case -24:
                case -23:
                case -22:
                case -21:
                case -20:
                case -19:
                case -18:
                case -17:
                case -16:
                case -15:
                case -14:
                case -13:
                case -12:
                case -11:
                case -10:
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                    if (objArr.length > 0) {
                        scriptable2 = ScriptRuntime.toObject(context, scriptable, objArr[0]);
                        int length = objArr.length - 1;
                        Object[] objArr2 = new Object[length];
                        while (i < length) {
                            int i2 = i + 1;
                            objArr2[i] = objArr[i2];
                            i = i2;
                        }
                        objArr = objArr2;
                    }
                    methodId = -methodId;
                default:
                    switch (methodId) {
                        case 1:
                            if (scriptable2 != null) {
                                z = false;
                            }
                            return !z ? idFunctionObject.construct(context, scriptable, objArr) : jsConstructor(context, scriptable, objArr);
                        case 2:
                            return toStringHelper(context, scriptable, scriptable2, context.hasFeature(4), false);
                        case 3:
                            return toStringHelper(context, scriptable, scriptable2, false, true);
                        case 4:
                            return toStringHelper(context, scriptable, scriptable2, true, false);
                        case 5:
                            return js_join(context, scriptable2, objArr);
                        case 6:
                            return js_reverse(context, scriptable2, objArr);
                        case 7:
                            return js_sort(context, scriptable, scriptable2, objArr);
                        case 8:
                            return js_push(context, scriptable2, objArr);
                        case 9:
                            return js_pop(context, scriptable2, objArr);
                        case 10:
                            return js_shift(context, scriptable2, objArr);
                        case 11:
                            return js_unshift(context, scriptable2, objArr);
                        case 12:
                            return js_splice(context, scriptable, scriptable2, objArr);
                        case 13:
                            return js_concat(context, scriptable, scriptable2, objArr);
                        case 14:
                            return js_slice(context, scriptable2, objArr);
                        case 15:
                            return js_indexOf(context, scriptable, scriptable2, objArr);
                        case 16:
                            return js_lastIndexOf(context, scriptable, scriptable2, objArr);
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            return iterativeMethod(context, idFunctionObject, scriptable, scriptable2, objArr);
                        case 24:
                        case 25:
                            return reduceMethod(context, methodId, scriptable, scriptable2, objArr);
                        case 26:
                            return js_fill(context, scriptable, scriptable2, objArr);
                        case 27:
                            return new NativeArrayIterator(scriptable, ScriptRuntime.toObject(context, scriptable, scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.KEYS);
                        case 28:
                        case 32:
                            return new NativeArrayIterator(scriptable, ScriptRuntime.toObject(context, scriptable, scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
                        case 29:
                            return new NativeArrayIterator(scriptable, ScriptRuntime.toObject(context, scriptable, scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.ENTRIES);
                        case 30:
                            if (((Long) js_indexOf(context, scriptable, scriptable2, objArr)).longValue() <= -1) {
                                z = false;
                            }
                            return ScriptRuntime.toObject(context, scriptable, Boolean.valueOf(z));
                        case 31:
                            return js_copyWithin(context, scriptable, scriptable2, objArr);
                        default:
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array.prototype has no method: ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(idFunctionObject.getFunctionName());
                            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
            }
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -5, "join", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -6, "reverse", 0);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -7, "sort", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -8, "push", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -9, "pop", 0);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -10, "shift", 0);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -11, "unshift", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -12, "splice", 2);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -13, "concat", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -14, "slice", 2);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -15, "indexOf", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -16, "lastIndexOf", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -17, "every", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -18, "filter", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -19, "forEach", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -20, "map", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -21, "some", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -22, "find", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -23, "findIndex", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -24, "reduce", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -25, "reduceRight", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -26, "isArray", 1);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -27, "of", 0);
        addIdFunctionProperty(idFunctionObject, ARRAY_TAG, -28, "from", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        return str.equals(Name.LENGTH) ? IdScriptableObject.instanceIdInfo(this.lengthAttr, 1) : super.findInstanceIdInfo(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0140  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length != 14) {
            switch (length) {
                case 3:
                    char charAt = str.charAt(0);
                    if (charAt == 'm') {
                        if (str.charAt(2) == 'p' && str.charAt(1) == 'a') {
                            return 20;
                        }
                    } else if (charAt == 'p' && str.charAt(2) == 'p' && str.charAt(1) == 'o') {
                        return 9;
                    }
                    str2 = null;
                    i = 0;
                    break;
                case 4:
                    char charAt2 = str.charAt(2);
                    if (charAt2 == 'i') {
                        i = 5;
                        str2 = "join";
                        break;
                    } else if (charAt2 == 'y') {
                        i = 27;
                        str2 = SavedStateHandle.KEYS;
                        break;
                    } else if (charAt2 == 'r') {
                        i = 7;
                        str2 = "sort";
                        break;
                    } else if (charAt2 == 's') {
                        i = 8;
                        str2 = "push";
                        break;
                    } else {
                        switch (charAt2) {
                            case 'l':
                                i = 26;
                                str2 = "fill";
                                break;
                            case 'm':
                                i = 21;
                                str2 = "some";
                                break;
                            case 'n':
                                i = 22;
                                str2 = "find";
                                break;
                            default:
                                str2 = null;
                                i = 0;
                                break;
                        }
                    }
                case 5:
                    char charAt3 = str.charAt(1);
                    if (charAt3 != 'h') {
                        if (charAt3 != 'l') {
                            if (charAt3 == 'v') {
                                i = 17;
                                str2 = "every";
                                break;
                            }
                            str2 = null;
                            i = 0;
                            break;
                        } else {
                            str2 = "slice";
                            i = 14;
                            break;
                        }
                    } else {
                        i = 10;
                        str2 = "shift";
                        break;
                    }
                case 6:
                    char charAt4 = str.charAt(0);
                    if (charAt4 == 'c') {
                        i = 13;
                        str2 = "concat";
                        break;
                    } else if (charAt4 == 'f') {
                        i = 18;
                        str2 = "filter";
                        break;
                    } else if (charAt4 == 'v') {
                        i = 28;
                        str2 = SavedStateHandle.VALUES;
                        break;
                    } else if (charAt4 == 'r') {
                        i = 24;
                        str2 = "reduce";
                        break;
                    } else {
                        if (charAt4 == 's') {
                            i = 12;
                            str2 = "splice";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    }
                case 7:
                    char charAt5 = str.charAt(0);
                    if (charAt5 == 'e') {
                        i = 29;
                        str2 = "entries";
                        break;
                    } else if (charAt5 == 'f') {
                        i = 19;
                        str2 = "forEach";
                        break;
                    } else if (charAt5 == 'i') {
                        i = 15;
                        str2 = "indexOf";
                        break;
                    } else if (charAt5 == 'r') {
                        i = 6;
                        str2 = "reverse";
                        break;
                    } else {
                        if (charAt5 == 'u') {
                            i = 11;
                            str2 = "unshift";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    }
                case 8:
                    char charAt6 = str.charAt(3);
                    if (charAt6 != 'l') {
                        if (charAt6 != 'o') {
                            if (charAt6 == 't') {
                                str2 = AnnotationHandler.STRING;
                                i = 2;
                                break;
                            }
                            str2 = null;
                            i = 0;
                            break;
                        } else {
                            i = 4;
                            str2 = "toSource";
                            break;
                        }
                    } else {
                        i = 30;
                        str2 = "includes";
                        break;
                    }
                case 9:
                    i = 23;
                    str2 = "findIndex";
                    break;
                case 10:
                    i = 31;
                    str2 = "copyWithin";
                    break;
                case 11:
                    char charAt7 = str.charAt(0);
                    if (charAt7 != 'c') {
                        if (charAt7 != 'l') {
                            if (charAt7 == 'r') {
                                i = 25;
                                str2 = "reduceRight";
                                break;
                            }
                            str2 = null;
                            i = 0;
                            break;
                        } else {
                            i = 16;
                            str2 = "lastIndexOf";
                            break;
                        }
                    } else {
                        str2 = "constructor";
                        i = 1;
                        break;
                    }
            }
        } else {
            str2 = "toLocaleString";
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 32 : 0;
    }

    @Override // java.util.List
    public Object get(int i) {
        return get(i);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (this.denseOnly || !isGetterOrSetter(null, i, false)) {
            Object[] objArr = this.dense;
            return (objArr == null || i < 0 || i >= objArr.length) ? super.get(i, scriptable) : objArr[i];
        }
        return super.get(i, scriptable);
    }

    public Object get(long j) {
        if (j < 0 || j >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object rawElem = getRawElem(this, j);
        if (rawElem == Scriptable.NOT_FOUND || rawElem == Undefined.instance) {
            return null;
        }
        return rawElem instanceof Wrapper ? ((Wrapper) rawElem).unwrap() : rawElem;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || objArr[i] == Scriptable.NOT_FOUND) {
            return super.getAttributes(i);
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Array";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return (cls == ScriptRuntime.NumberClass && Context.getContext().getLanguageVersion() == 120) ? Long.valueOf(this.length) : super.getDefaultValue(cls);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = this.dense;
        if (objArr == null) {
            return ids;
        }
        int length = objArr.length;
        long j = this.length;
        if (length > j) {
            length = (int) j;
        }
        if (length == 0) {
            return ids;
        }
        int length2 = ids.length;
        Object[] objArr2 = new Object[length + length2];
        int i = 0;
        for (int i2 = 0; i2 != length; i2++) {
            if (this.dense[i2] != Scriptable.NOT_FOUND) {
                objArr2[i] = Integer.valueOf(i2);
                i++;
            }
        }
        if (i != length) {
            Object[] objArr3 = new Object[i + length2];
            System.arraycopy(objArr2, 0, objArr3, 0, i);
            objArr2 = objArr3;
        }
        System.arraycopy(ids, 0, objArr2, i, length2);
        return objArr2;
    }

    public List<Integer> getIndexIds() {
        Object[] ids = getIds();
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            int int32 = ScriptRuntime.toInt32(obj);
            if (int32 >= 0 && ScriptRuntime.toString(int32).equals(ScriptRuntime.toString(obj))) {
                arrayList.add(Integer.valueOf(int32));
            }
        }
        return arrayList;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i == 1 ? Name.LENGTH : super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        return i == 1 ? ScriptRuntime.wrapNumber(this.length) : super.getInstanceIdValue(i);
    }

    public long getLength() {
        return this.length;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 1;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int denseIndex;
        if (this.dense != null && (denseIndex = toDenseIndex(obj)) >= 0) {
            Object[] objArr = this.dense;
            if (denseIndex < objArr.length && objArr[denseIndex] != Scriptable.NOT_FOUND) {
                return defaultIndexPropertyDescriptor(objArr[denseIndex]);
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (this.denseOnly || !isGetterOrSetter(null, i, false)) {
            Object[] objArr = this.dense;
            return (objArr == null || i < 0 || i >= objArr.length) ? super.has(i, scriptable) : objArr[i] != Scriptable.NOT_FOUND;
        }
        return super.has(i, scriptable);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i = (int) j;
            int i2 = 0;
            if (obj == null) {
                while (i2 < i) {
                    if (get(i2) == null) {
                        return i2;
                    }
                    i2++;
                }
                return -1;
            }
            while (i2 < i) {
                if (obj.equals(get(i2))) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        throw new IllegalStateException();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        if (i == 32) {
            initPrototypeMethod(ARRAY_TAG, i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        switch (i) {
            case 1:
                str = "constructor";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 2:
                str2 = AnnotationHandler.STRING;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 3:
                str2 = "toLocaleString";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 4:
                str2 = "toSource";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 5:
                str = "join";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 6:
                str2 = "reverse";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 7:
                str = "sort";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 8:
                str = "push";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 9:
                str2 = "pop";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 10:
                str2 = "shift";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 11:
                str = "unshift";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 12:
                str3 = "splice";
                str4 = str3;
                i2 = 2;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 13:
                str = "concat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 14:
                str3 = "slice";
                str4 = str3;
                i2 = 2;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 15:
                str = "indexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 16:
                str = "lastIndexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 17:
                str = "every";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 18:
                str = "filter";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 19:
                str = "forEach";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 20:
                str = "map";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 21:
                str = "some";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 22:
                str = "find";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 23:
                str = "findIndex";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 24:
                str = "reduce";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 25:
                str = "reduceRight";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 26:
                str = "fill";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 27:
                str2 = SavedStateHandle.KEYS;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 28:
                str2 = SavedStateHandle.VALUES;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 29:
                str2 = "entries";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 30:
                str = "includes";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 31:
                str3 = "copyWithin";
                str4 = str3;
                i2 = 2;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Deprecated
    public long jsGet_length() {
        return getLength();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i = ((int) j) - 1;
            if (obj == null) {
                while (i >= 0) {
                    if (get(i) == null) {
                        return i;
                    }
                    i--;
                }
                return -1;
            }
            while (i >= 0) {
                if (obj.equals(get(i))) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(final int i) {
        long j = this.length;
        if (j <= 2147483647L) {
            final int i2 = (int) j;
            if (i >= 0 && i <= i2) {
                return new ListIterator() { // from class: org.mozilla.javascript.NativeArray.2
                    public int cursor;

                    {
                        this.cursor = i;
                    }

                    @Override // java.util.ListIterator
                    public void add(Object obj) {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.ListIterator, java.util.Iterator
                    public boolean hasNext() {
                        return this.cursor < i2;
                    }

                    @Override // java.util.ListIterator
                    public boolean hasPrevious() {
                        return this.cursor > 0;
                    }

                    @Override // java.util.ListIterator, java.util.Iterator
                    public Object next() {
                        int i3 = this.cursor;
                        if (i3 != i2) {
                            NativeArray nativeArray = NativeArray.this;
                            this.cursor = i3 + 1;
                            return nativeArray.get(i3);
                        }
                        throw new NoSuchElementException();
                    }

                    @Override // java.util.ListIterator
                    public int nextIndex() {
                        return this.cursor;
                    }

                    @Override // java.util.ListIterator
                    public Object previous() {
                        int i3 = this.cursor;
                        if (i3 != 0) {
                            NativeArray nativeArray = NativeArray.this;
                            int i4 = i3 - 1;
                            this.cursor = i4;
                            return nativeArray.get(i4);
                        }
                        throw new NoSuchElementException();
                    }

                    @Override // java.util.ListIterator
                    public int previousIndex() {
                        return this.cursor - 1;
                    }

                    @Override // java.util.ListIterator, java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.ListIterator
                    public void set(Object obj) {
                        throw new UnsupportedOperationException();
                    }
                };
            }
            throw new IndexOutOfBoundsException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Index: ", i));
        }
        throw new IllegalStateException();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (scriptable == this && !isSealed() && this.dense != null && i >= 0 && (this.denseOnly || !isGetterOrSetter(null, i, true))) {
            if (!isExtensible() && this.length <= i) {
                return;
            }
            Object[] objArr = this.dense;
            if (i < objArr.length) {
                objArr[i] = obj;
                long j = i;
                if (this.length > j) {
                    return;
                }
                this.length = j + 1;
                return;
            } else if (this.denseOnly && i < objArr.length * 1.5d && ensureCapacity(i + 1)) {
                this.dense[i] = obj;
                this.length = i + 1;
                return;
            } else {
                this.denseOnly = false;
            }
        }
        super.put(i, scriptable, obj);
        if (scriptable == this && (this.lengthAttr & 1) == 0) {
            long j2 = i;
            if (this.length > j2) {
                return;
            }
            this.length = j2 + 1;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
        if (scriptable == this) {
            long arrayIndex = toArrayIndex(str);
            if (arrayIndex < this.length) {
                return;
            }
            this.length = arrayIndex + 1;
            this.denseOnly = false;
        }
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public void setDenseOnly(boolean z) {
        if (!z || this.denseOnly) {
            this.denseOnly = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.lengthAttr = i2;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            setLength(obj);
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        long j = this.length;
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(ScriptRuntime.emptyArgs);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (objArr.length < i) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = get(i2);
            }
            return objArr;
        }
        throw new IllegalStateException();
    }
}
