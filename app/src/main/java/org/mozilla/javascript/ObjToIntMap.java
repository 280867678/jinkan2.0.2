package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ObjToIntMap implements Serializable {

    /* renamed from: A */
    public static final int f4678A = -1640531527;
    public static final Object DELETED = new Object();
    public static final boolean check = false;
    public static final long serialVersionUID = -1542220580748809402L;
    public int keyCount;
    public transient Object[] keys;
    public transient int occupiedCount;
    public int power;
    public transient int[] values;

    /* loaded from: classes5.dex */
    public static class Iterator {
        public int cursor;
        public Object[] keys;
        public ObjToIntMap master;
        public int remaining;
        public int[] values;

        public Iterator(ObjToIntMap objToIntMap) {
            this.master = objToIntMap;
        }

        public boolean done() {
            return this.remaining < 0;
        }

        public Object getKey() {
            Object obj = this.keys[this.cursor];
            if (obj == UniqueTag.NULL_VALUE) {
                return null;
            }
            return obj;
        }

        public int getValue() {
            return this.values[this.cursor];
        }

        public final void init(Object[] objArr, int[] iArr, int i) {
            this.keys = objArr;
            this.values = iArr;
            this.cursor = -1;
            this.remaining = i;
        }

        public void next() {
            if (this.remaining == -1) {
                Kit.codeBug();
            }
            if (this.remaining == 0) {
                this.remaining = -1;
                this.cursor = -1;
                return;
            }
            int i = this.cursor;
            while (true) {
                this.cursor = i + 1;
                Object obj = this.keys[this.cursor];
                if (obj != null && obj != ObjToIntMap.DELETED) {
                    this.remaining--;
                    return;
                }
                i = this.cursor;
            }
        }

        public void setValue(int i) {
            this.values[this.cursor] = i;
        }

        public void start() {
            this.master.initIterator(this);
            next();
        }
    }

    public ObjToIntMap() {
        this(4);
    }

    public ObjToIntMap(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        int i2 = 2;
        while ((1 << i2) < (i * 4) / 3) {
            i2++;
        }
        this.power = i2;
    }

    private int ensureIndex(Object obj) {
        int i;
        int hashCode = obj.hashCode();
        Object[] objArr = this.keys;
        int i2 = -1;
        if (objArr != null) {
            int i3 = (-1640531527) * hashCode;
            int i4 = this.power;
            i = i3 >>> (32 - i4);
            Object obj2 = objArr[i];
            if (obj2 != null) {
                int i5 = 1 << i4;
                if (obj2 != obj && (this.values[i5 + i] != hashCode || !obj2.equals(obj))) {
                    if (obj2 == DELETED) {
                        i2 = i;
                    }
                    int i6 = i5 - 1;
                    int tableLookupStep = tableLookupStep(i3, i6, this.power);
                    while (true) {
                        i = (i + tableLookupStep) & i6;
                        Object obj3 = this.keys[i];
                        if (obj3 != null) {
                            if (obj3 == obj || (this.values[i5 + i] == hashCode && obj3.equals(obj))) {
                                break;
                            } else if (obj3 == DELETED && i2 < 0) {
                                i2 = i;
                            }
                        } else {
                            break;
                        }
                    }
                }
                return i;
            }
        } else {
            i = -1;
        }
        if (i2 < 0) {
            if (this.keys != null) {
                int i7 = this.occupiedCount;
                if (i7 * 4 < (1 << this.power) * 3) {
                    this.occupiedCount = i7 + 1;
                    i2 = i;
                }
            }
            rehashTable();
            return insertNewKey(obj, hashCode);
        }
        this.keys[i2] = obj;
        this.values[(1 << this.power) + i2] = hashCode;
        this.keyCount++;
        return i2;
    }

    private int findIndex(Object obj) {
        if (this.keys != null) {
            int hashCode = obj.hashCode();
            int i = (-1640531527) * hashCode;
            int i2 = this.power;
            int i3 = i >>> (32 - i2);
            Object obj2 = this.keys[i3];
            if (obj2 == null) {
                return -1;
            }
            int i4 = 1 << i2;
            if (obj2 != obj && (this.values[i4 + i3] != hashCode || !obj2.equals(obj))) {
                int i5 = i4 - 1;
                int tableLookupStep = tableLookupStep(i, i5, this.power);
                while (true) {
                    i3 = (i3 + tableLookupStep) & i5;
                    Object obj3 = this.keys[i3];
                    if (obj3 != null) {
                        if (obj3 == obj || (this.values[i4 + i3] == hashCode && obj3.equals(obj))) {
                            break;
                        }
                    } else {
                        return -1;
                    }
                }
            }
            return i3;
        }
        return -1;
    }

    private int insertNewKey(Object obj, int i) {
        int i2 = (-1640531527) * i;
        int i3 = this.power;
        int i4 = i2 >>> (32 - i3);
        int i5 = 1 << i3;
        if (this.keys[i4] == null) {
            this.keys[i4] = obj;
            this.values[i5 + i4] = i;
            this.occupiedCount++;
            this.keyCount++;
            return i4;
        }
        int i6 = i5 - 1;
        int tableLookupStep = tableLookupStep(i2, i6, i3);
        do {
            i4 = (i4 + tableLookupStep) & i6;
        } while (this.keys[i4] != null);
        this.keys[i4] = obj;
        this.values[i5 + i4] = i;
        this.occupiedCount++;
        this.keyCount++;
        return i4;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int i = this.keyCount;
        if (i != 0) {
            this.keyCount = 0;
            int i2 = 1 << this.power;
            this.keys = new Object[i2];
            this.values = new int[i2 * 2];
            for (int i3 = 0; i3 != i; i3++) {
                Object readObject = objectInputStream.readObject();
                this.values[insertNewKey(readObject, readObject.hashCode())] = objectInputStream.readInt();
            }
        }
    }

    private void rehashTable() {
        if (this.keys == null) {
            int i = 1 << this.power;
            this.keys = new Object[i];
            this.values = new int[i * 2];
            return;
        }
        if (this.keyCount * 2 >= this.occupiedCount) {
            this.power++;
        }
        int i2 = 1 << this.power;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int length = objArr.length;
        this.keys = new Object[i2];
        this.values = new int[i2 * 2];
        int i3 = this.keyCount;
        int i4 = 0;
        this.keyCount = 0;
        this.occupiedCount = 0;
        while (i3 != 0) {
            Object obj = objArr[i4];
            if (obj != null && obj != DELETED) {
                this.values[insertNewKey(obj, iArr[length + i4])] = iArr[i4];
                i3--;
            }
            i4++;
        }
    }

    public static int tableLookupStep(int i, int i2, int i3) {
        int i4 = 32 - (i3 * 2);
        if (i4 >= 0) {
            i >>>= i4;
        } else {
            i2 >>>= -i4;
        }
        return (i & i2) | 1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.keyCount;
        int i2 = 0;
        while (i != 0) {
            Object obj = this.keys[i2];
            if (obj != null && obj != DELETED) {
                i--;
                objectOutputStream.writeObject(obj);
                objectOutputStream.writeInt(this.values[i2]);
            }
            i2++;
        }
    }

    public void clear() {
        int length = this.keys.length;
        while (length != 0) {
            length--;
            this.keys[length] = null;
        }
        this.keyCount = 0;
        this.occupiedCount = 0;
    }

    public int get(Object obj, int i) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        return findIndex >= 0 ? this.values[findIndex] : i;
    }

    public int getExisting(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        if (findIndex >= 0) {
            return this.values[findIndex];
        }
        Kit.codeBug();
        return 0;
    }

    public void getKeys(Object[] objArr, int i) {
        int i2 = this.keyCount;
        int i3 = 0;
        while (i2 != 0) {
            Object obj = this.keys[i3];
            if (obj != null && obj != DELETED) {
                if (obj == UniqueTag.NULL_VALUE) {
                    obj = null;
                }
                objArr[i] = obj;
                i++;
                i2--;
            }
            i3++;
        }
    }

    public Object[] getKeys() {
        Object[] objArr = new Object[this.keyCount];
        getKeys(objArr, 0);
        return objArr;
    }

    public boolean has(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        return findIndex(obj) >= 0;
    }

    public final void initIterator(Iterator iterator) {
        iterator.init(this.keys, this.values, this.keyCount);
    }

    public Object intern(Object obj) {
        boolean z;
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
            z = true;
        } else {
            z = false;
        }
        int ensureIndex = ensureIndex(obj);
        this.values[ensureIndex] = 0;
        if (z) {
            return null;
        }
        return this.keys[ensureIndex];
    }

    public boolean isEmpty() {
        return this.keyCount == 0;
    }

    public Iterator newIterator() {
        return new Iterator(this);
    }

    public void put(Object obj, int i) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        this.values[ensureIndex(obj)] = i;
    }

    public void remove(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        if (findIndex >= 0) {
            this.keys[findIndex] = DELETED;
            this.keyCount--;
        }
    }

    public int size() {
        return this.keyCount;
    }
}
