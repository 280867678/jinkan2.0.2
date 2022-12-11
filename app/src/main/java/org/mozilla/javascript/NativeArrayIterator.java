package org.mozilla.javascript;

/* loaded from: classes5.dex */
public final class NativeArrayIterator extends ES6Iterator {
    public static final String ITERATOR_TAG = "ArrayIterator";
    public static final long serialVersionUID = 1;
    public Scriptable arrayLike;
    public int index;
    public ARRAY_ITERATOR_TYPE type;

    /* loaded from: classes5.dex */
    public enum ARRAY_ITERATOR_TYPE {
        ENTRIES,
        KEYS,
        VALUES
    }

    public NativeArrayIterator() {
    }

    public NativeArrayIterator(Scriptable scriptable, Scriptable scriptable2, ARRAY_ITERATOR_TYPE array_iterator_type) {
        super(scriptable, ITERATOR_TAG);
        this.index = 0;
        this.arrayLike = scriptable2;
        this.type = array_iterator_type;
    }

    public static void init(ScriptableObject scriptableObject, boolean z) {
        ES6Iterator.init(scriptableObject, z, new NativeArrayIterator(), ITERATOR_TAG);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Array Iterator";
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public String getTag() {
        return ITERATOR_TAG;
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public boolean isDone(Context context, Scriptable scriptable) {
        return ((long) this.index) >= NativeArray.getLengthProperty(context, this.arrayLike, false);
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public Object nextValue(Context context, Scriptable scriptable) {
        if (this.type == ARRAY_ITERATOR_TYPE.KEYS) {
            int i = this.index;
            this.index = i + 1;
            return Integer.valueOf(i);
        }
        Scriptable scriptable2 = this.arrayLike;
        Object obj = scriptable2.get(this.index, scriptable2);
        if (obj == Scriptable.NOT_FOUND) {
            obj = Undefined.instance;
        }
        if (this.type == ARRAY_ITERATOR_TYPE.ENTRIES) {
            obj = context.newArray(scriptable, new Object[]{Integer.valueOf(this.index), obj});
        }
        this.index++;
        return obj;
    }
}
