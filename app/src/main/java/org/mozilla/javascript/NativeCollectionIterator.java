package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Iterator;
import org.mozilla.javascript.Hashtable;

/* loaded from: classes5.dex */
public class NativeCollectionIterator extends ES6Iterator {
    public String className;
    public transient Iterator<Hashtable.Entry> iterator;
    public Type type;

    /* renamed from: org.mozilla.javascript.NativeCollectionIterator$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C33091 {
        public static final /* synthetic */ int[] $SwitchMap$org$mozilla$javascript$NativeCollectionIterator$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$mozilla$javascript$NativeCollectionIterator$Type = iArr;
            try {
                Type type = Type.KEYS;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$org$mozilla$javascript$NativeCollectionIterator$Type;
                Type type2 = Type.VALUES;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$org$mozilla$javascript$NativeCollectionIterator$Type;
                Type type3 = Type.BOTH;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Type {
        KEYS,
        VALUES,
        BOTH
    }

    public NativeCollectionIterator(String str) {
        this.iterator = Collections.emptyIterator();
        this.className = str;
        this.iterator = Collections.emptyIterator();
        this.type = Type.BOTH;
    }

    public NativeCollectionIterator(Scriptable scriptable, String str, Type type, Iterator<Hashtable.Entry> it) {
        super(scriptable, str);
        this.iterator = Collections.emptyIterator();
        this.className = str;
        this.iterator = it;
        this.type = type;
    }

    public static void init(ScriptableObject scriptableObject, String str, boolean z) {
        ES6Iterator.init(scriptableObject, z, new NativeCollectionIterator(str), str);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.className = (String) objectInputStream.readObject();
        this.type = (Type) objectInputStream.readObject();
        this.iterator = Collections.emptyIterator();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.className);
        objectOutputStream.writeObject(this.type);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return this.className;
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public boolean isDone(Context context, Scriptable scriptable) {
        return !this.iterator.hasNext();
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public Object nextValue(Context context, Scriptable scriptable) {
        Hashtable.Entry next = this.iterator.next();
        int ordinal = this.type.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return next.value;
            }
            if (ordinal != 2) {
                throw new AssertionError();
            }
            return context.newArray(scriptable, new Object[]{next.key, next.value});
        }
        return next.key;
    }
}
