package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ObjArray implements Serializable {
    public static final int FIELDS_STORE_SIZE = 5;
    public static final long serialVersionUID = 4174889037736658296L;
    public transient Object[] data;

    /* renamed from: f0 */
    public transient Object f4673f0;

    /* renamed from: f1 */
    public transient Object f4674f1;

    /* renamed from: f2 */
    public transient Object f4675f2;

    /* renamed from: f3 */
    public transient Object f4676f3;

    /* renamed from: f4 */
    public transient Object f4677f4;
    public boolean sealed;
    public int size;

    private void ensureCapacity(int i) {
        int i2 = i - 5;
        if (i2 > 0) {
            Object[] objArr = this.data;
            int i3 = 10;
            if (objArr == null) {
                if (10 >= i2) {
                    i2 = 10;
                }
                this.data = new Object[i2];
                return;
            }
            int length = objArr.length;
            if (length >= i2) {
                return;
            }
            if (length > 5) {
                i3 = length * 2;
            }
            if (i3 >= i2) {
                i2 = i3;
            }
            Object[] objArr2 = new Object[i2];
            int i4 = this.size;
            if (i4 > 5) {
                System.arraycopy(this.data, 0, objArr2, 0, i4 - 5);
            }
            this.data = objArr2;
            return;
        }
        throw new IllegalArgumentException();
    }

    private Object getImpl(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? this.data[i - 5] : this.f4677f4 : this.f4676f3 : this.f4675f2 : this.f4674f1 : this.f4673f0;
    }

    public static RuntimeException onEmptyStackTopRead() {
        throw new RuntimeException("Empty stack");
    }

    public static RuntimeException onInvalidIndex(int i, int i2) {
        throw new IndexOutOfBoundsException(i + " ∉ [0, " + i2 + ')');
    }

    public static RuntimeException onSeledMutation() {
        throw new IllegalStateException("Attempt to modify sealed array");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int i = this.size;
        if (i > 5) {
            this.data = new Object[i - 5];
        }
        for (int i2 = 0; i2 != i; i2++) {
            setImpl(i2, objectInputStream.readObject());
        }
    }

    private void setImpl(int i, Object obj) {
        if (i == 0) {
            this.f4673f0 = obj;
        } else if (i == 1) {
            this.f4674f1 = obj;
        } else if (i == 2) {
            this.f4675f2 = obj;
        } else if (i == 3) {
            this.f4676f3 = obj;
        } else if (i != 4) {
            this.data[i - 5] = obj;
        } else {
            this.f4677f4 = obj;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.size;
        for (int i2 = 0; i2 != i; i2++) {
            objectOutputStream.writeObject(getImpl(i2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r8 != 4) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void add(int i, Object obj) {
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw onInvalidIndex(i, i2 + 1);
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                    }
                    if (i2 != 3) {
                        this.f4676f3 = obj;
                        this.size = i2 + 1;
                        return;
                    }
                    Object obj2 = this.f4676f3;
                    this.f4676f3 = obj;
                    obj = obj2;
                    if (i2 == 4) {
                        this.f4677f4 = obj;
                        this.size = i2 + 1;
                        return;
                    }
                    Object obj3 = this.f4677f4;
                    this.f4677f4 = obj;
                    obj = obj3;
                    i = 5;
                    ensureCapacity(i2 + 1);
                    if (i != i2) {
                        Object[] objArr = this.data;
                        int i3 = i - 5;
                        System.arraycopy(objArr, i3, objArr, i3 + 1, i2 - i);
                    }
                    this.data[i - 5] = obj;
                    this.size = i2 + 1;
                    return;
                }
                if (i2 != 2) {
                    this.f4675f2 = obj;
                    this.size = i2 + 1;
                    return;
                }
                Object obj4 = this.f4675f2;
                this.f4675f2 = obj;
                obj = obj4;
                if (i2 != 3) {
                }
            }
        } else if (i2 == 0) {
            this.f4673f0 = obj;
            this.size = i2 + 1;
            return;
        } else {
            Object obj5 = this.f4673f0;
            this.f4673f0 = obj;
            obj = obj5;
        }
        if (i2 == 1) {
            this.f4674f1 = obj;
            this.size = i2 + 1;
            return;
        }
        Object obj6 = this.f4674f1;
        this.f4674f1 = obj;
        obj = obj6;
        if (i2 != 2) {
        }
    }

    public final void add(Object obj) {
        if (!this.sealed) {
            int i = this.size;
            if (i >= 5) {
                ensureCapacity(i + 1);
            }
            this.size = i + 1;
            setImpl(i, obj);
            return;
        }
        throw onSeledMutation();
    }

    public final void clear() {
        if (!this.sealed) {
            int i = this.size;
            for (int i2 = 0; i2 != i; i2++) {
                setImpl(i2, null);
            }
            this.size = 0;
            return;
        }
        throw onSeledMutation();
    }

    public final Object get(int i) {
        if (i < 0 || i >= this.size) {
            throw onInvalidIndex(i, this.size);
        }
        return getImpl(i);
    }

    public int indexOf(Object obj) {
        int i = this.size;
        for (int i2 = 0; i2 != i; i2++) {
            Object impl = getImpl(i2);
            if (impl == obj || (impl != null && impl.equals(obj))) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public int lastIndexOf(Object obj) {
        int i = this.size;
        while (i != 0) {
            i--;
            Object impl = getImpl(i);
            if (impl == obj || (impl != null && impl.equals(obj))) {
                return i;
            }
        }
        return -1;
    }

    public final Object peek() {
        int i = this.size;
        if (i != 0) {
            return getImpl(i - 1);
        }
        throw onEmptyStackTopRead();
    }

    public final Object pop() {
        Object obj;
        if (!this.sealed) {
            int i = this.size - 1;
            if (i == -1) {
                throw onEmptyStackTopRead();
            }
            if (i == 0) {
                obj = this.f4673f0;
                this.f4673f0 = null;
            } else if (i == 1) {
                obj = this.f4674f1;
                this.f4674f1 = null;
            } else if (i == 2) {
                obj = this.f4675f2;
                this.f4675f2 = null;
            } else if (i == 3) {
                obj = this.f4676f3;
                this.f4676f3 = null;
            } else if (i != 4) {
                Object[] objArr = this.data;
                int i2 = i - 5;
                obj = objArr[i2];
                objArr[i2] = null;
            } else {
                obj = this.f4677f4;
                this.f4677f4 = null;
            }
            this.size = i;
            return obj;
        }
        throw onSeledMutation();
    }

    public final void push(Object obj) {
        add(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r7 != 4) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void remove(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw onInvalidIndex(i, i2);
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i3 = i2 - 1;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                    }
                    if (i3 != 3) {
                        this.f4676f3 = null;
                        this.size = i3;
                        return;
                    }
                    this.f4676f3 = this.f4677f4;
                    if (i3 == 4) {
                        this.f4677f4 = null;
                        this.size = i3;
                        return;
                    }
                    this.f4677f4 = this.data[0];
                    i = 5;
                    if (i != i3) {
                        Object[] objArr = this.data;
                        int i4 = i - 5;
                        System.arraycopy(objArr, i4 + 1, objArr, i4, i3 - i);
                    }
                    this.data[i3 - 5] = null;
                    this.size = i3;
                    return;
                }
                if (i3 != 2) {
                    this.f4675f2 = null;
                    this.size = i3;
                    return;
                }
                this.f4675f2 = this.f4676f3;
                if (i3 != 3) {
                }
            }
        } else if (i3 == 0) {
            this.f4673f0 = null;
            this.size = i3;
            return;
        } else {
            this.f4673f0 = this.f4674f1;
        }
        if (i3 == 1) {
            this.f4674f1 = null;
            this.size = i3;
            return;
        }
        this.f4674f1 = this.f4675f2;
        if (i3 != 2) {
        }
    }

    public final void seal() {
        this.sealed = true;
    }

    public final void set(int i, Object obj) {
        if (i < 0 || i >= this.size) {
            throw onInvalidIndex(i, this.size);
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        setImpl(i, obj);
    }

    public final void setSize(int i) {
        if (i >= 0) {
            if (this.sealed) {
                throw onSeledMutation();
            }
            int i2 = this.size;
            if (i < i2) {
                for (int i3 = i; i3 != i2; i3++) {
                    setImpl(i3, null);
                }
            } else if (i > i2 && i > 5) {
                ensureCapacity(i);
            }
            this.size = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final int size() {
        return this.size;
    }

    public final void toArray(Object[] objArr) {
        toArray(objArr, 0);
    }

    public final void toArray(Object[] objArr, int i) {
        int i2 = this.size;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                System.arraycopy(this.data, 0, objArr, i + 5, i2 - 5);
                            }
                            objArr[i + 4] = this.f4677f4;
                        }
                        objArr[i + 3] = this.f4676f3;
                    }
                    objArr[i + 2] = this.f4675f2;
                }
                objArr[i + 1] = this.f4674f1;
            }
            objArr[i + 0] = this.f4673f0;
        }
    }

    public final Object[] toArray() {
        Object[] objArr = new Object[this.size];
        toArray(objArr, 0);
        return objArr;
    }
}
