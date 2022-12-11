package org.mozilla.javascript;

/* loaded from: classes5.dex */
public final class NativeStringIterator extends ES6Iterator {
    public static final String ITERATOR_TAG = "StringIterator";
    public static final long serialVersionUID = 1;
    public int index;
    public String string;

    public NativeStringIterator() {
    }

    public NativeStringIterator(Scriptable scriptable, Scriptable scriptable2) {
        super(scriptable, ITERATOR_TAG);
        this.index = 0;
        this.string = ScriptRuntime.toString(scriptable2);
    }

    public static void init(ScriptableObject scriptableObject, boolean z) {
        ES6Iterator.init(scriptableObject, z, new NativeStringIterator(), ITERATOR_TAG);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "String Iterator";
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public String getTag() {
        return ITERATOR_TAG;
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public boolean isDone(Context context, Scriptable scriptable) {
        return this.index >= this.string.length();
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public Object nextValue(Context context, Scriptable scriptable) {
        int offsetByCodePoints = this.string.offsetByCodePoints(this.index, 1);
        String substring = this.string.substring(this.index, offsetByCodePoints);
        this.index = offsetByCodePoints;
        return substring;
    }
}
