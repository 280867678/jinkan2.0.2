package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public abstract class IdScriptableObject extends ScriptableObject implements IdFunctionCall {
    public transient PrototypeValues prototypeValues;

    /* loaded from: classes5.dex */
    public static final class PrototypeValues implements Serializable {
        public static final int NAME_SLOT = 1;
        public static final int SLOT_SPAN = 2;
        public static final long serialVersionUID = 3038645279153854371L;
        public short[] attributeArray;
        public IdFunctionObject constructor;
        public short constructorAttrs;
        public int constructorId;
        public int maxId;
        public IdScriptableObject obj;
        public Object[] valueArray;

        public PrototypeValues(IdScriptableObject idScriptableObject, int i) {
            if (idScriptableObject != null) {
                if (i < 1) {
                    throw new IllegalArgumentException();
                }
                this.obj = idScriptableObject;
                this.maxId = i;
                return;
            }
            throw new IllegalArgumentException();
        }

        private Object ensureId(int i) {
            Object[] objArr = this.valueArray;
            if (objArr == null) {
                synchronized (this) {
                    objArr = this.valueArray;
                    if (objArr == null) {
                        objArr = new Object[this.maxId * 2];
                        this.valueArray = objArr;
                        this.attributeArray = new short[this.maxId];
                    }
                }
            }
            int i2 = (i - 1) * 2;
            Object obj = objArr[i2];
            if (obj == null) {
                int i3 = this.constructorId;
                if (i == i3) {
                    initSlot(i3, "constructor", this.constructor, this.constructorAttrs);
                    this.constructor = null;
                } else {
                    this.obj.initPrototypeId(i);
                }
                obj = objArr[i2];
                if (obj == null) {
                    throw new IllegalStateException(this.obj.getClass().getName() + ".initPrototypeId(int id) did not initialize id=" + i);
                }
            }
            return obj;
        }

        private void initSlot(int i, Object obj, Object obj2, int i2) {
            Object[] objArr = this.valueArray;
            if (objArr != null) {
                if (obj2 == null) {
                    obj2 = UniqueTag.NULL_VALUE;
                }
                int i3 = i - 1;
                int i4 = i3 * 2;
                synchronized (this) {
                    if (objArr[i4] == null) {
                        objArr[i4] = obj2;
                        objArr[i4 + 1] = obj;
                        this.attributeArray[i3] = (short) i2;
                    } else if (!obj.equals(objArr[i4 + 1])) {
                        throw new IllegalStateException();
                    }
                }
                return;
            }
            throw new IllegalStateException();
        }

        public final IdFunctionObject createPrecachedConstructor() {
            if (this.constructorId == 0) {
                int findPrototypeId = this.obj.findPrototypeId("constructor");
                this.constructorId = findPrototypeId;
                if (findPrototypeId == 0) {
                    throw new IllegalStateException("No id for constructor property");
                }
                this.obj.initPrototypeId(findPrototypeId);
                IdFunctionObject idFunctionObject = this.constructor;
                if (idFunctionObject != null) {
                    idFunctionObject.initFunction(this.obj.getClassName(), ScriptableObject.getTopLevelScope(this.obj));
                    this.constructor.markAsConstructor(this.obj);
                    return this.constructor;
                }
                throw new IllegalStateException(this.obj.getClass().getName() + ".initPrototypeId() did not initialize id=" + this.constructorId);
            }
            throw new IllegalStateException();
        }

        public final void delete(int i) {
            ensureId(i);
            int i2 = i - 1;
            if ((this.attributeArray[i2] & 4) != 0) {
                if (!Context.getContext().isStrictMode()) {
                    return;
                }
                throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", (String) this.valueArray[(i2 * 2) + 1]);
            }
            int i3 = i2 * 2;
            synchronized (this) {
                this.valueArray[i3] = Scriptable.NOT_FOUND;
                this.attributeArray[i2] = 0;
            }
        }

        public final int findId(String str) {
            return this.obj.findPrototypeId(str);
        }

        public final int findId(Symbol symbol) {
            return this.obj.findPrototypeId(symbol);
        }

        public final Object get(int i) {
            Object ensureId = ensureId(i);
            if (ensureId == UniqueTag.NULL_VALUE) {
                return null;
            }
            return ensureId;
        }

        public final int getAttributes(int i) {
            ensureId(i);
            return this.attributeArray[i - 1];
        }

        public final int getMaxId() {
            return this.maxId;
        }

        public final Object[] getNames(boolean z, boolean z2, Object[] objArr) {
            int i;
            Object[] objArr2 = null;
            int i2 = 0;
            for (int i3 = 1; i3 <= this.maxId; i3++) {
                Object ensureId = ensureId(i3);
                if ((z || (this.attributeArray[i3 - 1] & 2) == 0) && ensureId != Scriptable.NOT_FOUND) {
                    Object obj = this.valueArray[outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, -1, 2, 1)];
                    if (obj instanceof String) {
                        if (objArr2 == null) {
                            objArr2 = new Object[this.maxId];
                        }
                        i = i2 + 1;
                        objArr2[i2] = obj;
                    } else if (z2 && (obj instanceof Symbol)) {
                        if (objArr2 == null) {
                            objArr2 = new Object[this.maxId];
                        }
                        i = i2 + 1;
                        objArr2[i2] = obj.toString();
                    }
                    i2 = i;
                }
            }
            if (i2 == 0) {
                return objArr;
            }
            if (objArr == null || objArr.length == 0) {
                if (i2 == objArr2.length) {
                    return objArr2;
                }
                Object[] objArr3 = new Object[i2];
                System.arraycopy(objArr2, 0, objArr3, 0, i2);
                return objArr3;
            }
            int length = objArr.length;
            Object[] objArr4 = new Object[length + i2];
            System.arraycopy(objArr, 0, objArr4, 0, length);
            System.arraycopy(objArr2, 0, objArr4, length, i2);
            return objArr4;
        }

        public final boolean has(int i) {
            Object obj;
            Object[] objArr = this.valueArray;
            return objArr == null || (obj = objArr[(i - 1) * 2]) == null || obj != Scriptable.NOT_FOUND;
        }

        public final void initValue(int i, String str, Object obj, int i2) {
            if (1 > i || i > this.maxId) {
                throw new IllegalArgumentException();
            }
            if (str == null) {
                throw new IllegalArgumentException();
            }
            if (obj == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            ScriptableObject.checkValidAttributes(i2);
            if (this.obj.findPrototypeId(str) != i) {
                throw new IllegalArgumentException(str);
            }
            if (i != this.constructorId) {
                initSlot(i, str, obj, i2);
            } else if (!(obj instanceof IdFunctionObject)) {
                throw new IllegalArgumentException("consructor should be initialized with IdFunctionObject");
            } else {
                this.constructor = (IdFunctionObject) obj;
                this.constructorAttrs = (short) i2;
            }
        }

        public final void initValue(int i, Symbol symbol, Object obj, int i2) {
            if (1 > i || i > this.maxId) {
                throw new IllegalArgumentException();
            }
            if (symbol == null) {
                throw new IllegalArgumentException();
            }
            if (obj == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            ScriptableObject.checkValidAttributes(i2);
            if (this.obj.findPrototypeId(symbol) != i) {
                throw new IllegalArgumentException(symbol.toString());
            }
            if (i != this.constructorId) {
                initSlot(i, symbol, obj, i2);
            } else if (!(obj instanceof IdFunctionObject)) {
                throw new IllegalArgumentException("consructor should be initialized with IdFunctionObject");
            } else {
                this.constructor = (IdFunctionObject) obj;
                this.constructorAttrs = (short) i2;
            }
        }

        public final void set(int i, Scriptable scriptable, Object obj) {
            if (obj != Scriptable.NOT_FOUND) {
                ensureId(i);
                int i2 = i - 1;
                if ((this.attributeArray[i2] & 1) != 0) {
                    return;
                }
                if (scriptable == this.obj) {
                    if (obj == null) {
                        obj = UniqueTag.NULL_VALUE;
                    }
                    int i3 = i2 * 2;
                    synchronized (this) {
                        this.valueArray[i3] = obj;
                    }
                    return;
                }
                Object obj2 = this.valueArray[(i2 * 2) + 1];
                if (!(obj2 instanceof Symbol)) {
                    scriptable.put((String) obj2, scriptable, obj);
                    return;
                } else if (!(scriptable instanceof SymbolScriptable)) {
                    return;
                } else {
                    ((SymbolScriptable) scriptable).put((Symbol) obj2, scriptable, obj);
                    return;
                }
            }
            throw new IllegalArgumentException();
        }

        public final void setAttributes(int i, int i2) {
            ScriptableObject.checkValidAttributes(i2);
            ensureId(i);
            synchronized (this) {
                this.attributeArray[i - 1] = (short) i2;
            }
        }
    }

    public IdScriptableObject() {
    }

    public IdScriptableObject(Scriptable scriptable, Scriptable scriptable2) {
        super(scriptable, scriptable2);
    }

    private ScriptableObject getBuiltInDescriptor(String str) {
        int findId;
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            return ScriptableObject.buildDataDescriptor(parentScope, getInstanceIdValue(65535 & findInstanceIdInfo), findInstanceIdInfo >>> 16);
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (findId = prototypeValues.findId(str)) != 0) {
            return ScriptableObject.buildDataDescriptor(parentScope, this.prototypeValues.get(findId), this.prototypeValues.getAttributes(findId));
        }
        return null;
    }

    private ScriptableObject getBuiltInDescriptor(Symbol symbol) {
        int findId;
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (findId = prototypeValues.findId(symbol)) == 0) {
            return null;
        }
        return ScriptableObject.buildDataDescriptor(parentScope, this.prototypeValues.get(findId), this.prototypeValues.getAttributes(findId));
    }

    public static EcmaError incompatibleCallError(IdFunctionObject idFunctionObject) {
        throw ScriptRuntime.typeError1("msg.incompat.call", idFunctionObject.getFunctionName());
    }

    public static int instanceIdInfo(int i, int i2) {
        return (i << 16) | i2;
    }

    private IdFunctionObject newIdFunction(Object obj, int i, String str, int i2, Scriptable scriptable) {
        IdFunctionObject idFunctionObject = Context.getContext().getLanguageVersion() < 200 ? new IdFunctionObject(this, obj, i, str, i2, scriptable) : new IdFunctionObjectES6(this, obj, i, str, i2, scriptable);
        if (isSealed()) {
            idFunctionObject.sealObject();
        }
        return idFunctionObject;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt != 0) {
            activatePrototypeMap(readInt);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        PrototypeValues prototypeValues = this.prototypeValues;
        objectOutputStream.writeInt(prototypeValues != null ? prototypeValues.getMaxId() : 0);
    }

    public final void activatePrototypeMap(int i) {
        PrototypeValues prototypeValues = new PrototypeValues(this, i);
        synchronized (this) {
            if (this.prototypeValues != null) {
                throw new IllegalStateException();
            }
            this.prototypeValues = prototypeValues;
        }
    }

    public void addIdFunctionProperty(Scriptable scriptable, Object obj, int i, String str, int i2) {
        newIdFunction(obj, i, str, i2, ScriptableObject.getTopLevelScope(scriptable)).addAsProperty(scriptable);
    }

    public final Object defaultGet(String str) {
        return super.get(str, this);
    }

    public final boolean defaultHas(String str) {
        return super.has(str, this);
    }

    public final void defaultPut(String str, Object obj) {
        super.put(str, this, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject) {
        int findId;
        if (obj instanceof String) {
            String str = (String) obj;
            int findInstanceIdInfo = findInstanceIdInfo(str);
            if (findInstanceIdInfo != 0) {
                int i = 65535 & findInstanceIdInfo;
                if (!isAccessorDescriptor(scriptableObject)) {
                    checkPropertyDefinition(scriptableObject);
                    checkPropertyChange(str, getOwnPropertyDescriptor(context, obj), scriptableObject);
                    int i2 = findInstanceIdInfo >>> 16;
                    Object property = ScriptableObject.getProperty(scriptableObject, "value");
                    if (property != Scriptable.NOT_FOUND && (i2 & 1) == 0 && !sameValue(property, getInstanceIdValue(i))) {
                        setInstanceIdValue(i, property);
                    }
                    setAttributes(str, applyDescriptorToAttributeBitset(i2, scriptableObject));
                    return;
                }
                delete(i);
            }
            PrototypeValues prototypeValues = this.prototypeValues;
            if (prototypeValues != null && (findId = prototypeValues.findId(str)) != 0) {
                if (!isAccessorDescriptor(scriptableObject)) {
                    checkPropertyDefinition(scriptableObject);
                    checkPropertyChange(str, getOwnPropertyDescriptor(context, obj), scriptableObject);
                    int attributes = this.prototypeValues.getAttributes(findId);
                    Object property2 = ScriptableObject.getProperty(scriptableObject, "value");
                    if (property2 != Scriptable.NOT_FOUND && (attributes & 1) == 0 && !sameValue(property2, this.prototypeValues.get(findId))) {
                        this.prototypeValues.set(findId, this, property2);
                    }
                    this.prototypeValues.setAttributes(findId, applyDescriptorToAttributeBitset(attributes, scriptableObject));
                    if (!super.has(str, this)) {
                        return;
                    }
                    super.delete(str);
                    return;
                }
                this.prototypeValues.delete(findId);
            }
        }
        super.defineOwnProperty(context, obj, scriptableObject);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(String str) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0 && !isSealed()) {
            if (((findInstanceIdInfo >>> 16) & 4) == 0) {
                setInstanceIdValue(65535 & findInstanceIdInfo, Scriptable.NOT_FOUND);
                return;
            } else if (Context.getContext().isStrictMode()) {
                throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", str);
            } else {
                return;
            }
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (findId = prototypeValues.findId(str)) == 0) {
            super.delete(str);
        } else if (isSealed()) {
        } else {
            this.prototypeValues.delete(findId);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public void delete(Symbol symbol) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(symbol);
        if (findInstanceIdInfo != 0 && !isSealed()) {
            if (((findInstanceIdInfo >>> 16) & 4) == 0) {
                setInstanceIdValue(65535 & findInstanceIdInfo, Scriptable.NOT_FOUND);
                return;
            } else if (Context.getContext().isStrictMode()) {
                throw ScriptRuntime.typeError0("msg.delete.property.with.configurable.false");
            } else {
                return;
            }
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (findId = prototypeValues.findId(symbol)) == 0) {
            super.delete(symbol);
        } else if (isSealed()) {
        } else {
            this.prototypeValues.delete(findId);
        }
    }

    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        throw idFunctionObject.unknown();
    }

    public final IdFunctionObject exportAsJSClass(int i, Scriptable scriptable, boolean z) {
        if (scriptable != this && scriptable != null) {
            setParentScope(scriptable);
            setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        }
        activatePrototypeMap(i);
        IdFunctionObject createPrecachedConstructor = this.prototypeValues.createPrecachedConstructor();
        if (z) {
            sealObject();
        }
        fillConstructorProperties(createPrecachedConstructor);
        if (z) {
            createPrecachedConstructor.sealObject();
        }
        createPrecachedConstructor.exportAsScopeProperty();
        return createPrecachedConstructor;
    }

    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
    }

    public int findInstanceIdInfo(String str) {
        return 0;
    }

    public int findInstanceIdInfo(Symbol symbol) {
        return 0;
    }

    public int findPrototypeId(String str) {
        throw new IllegalStateException(str);
    }

    public int findPrototypeId(Symbol symbol) {
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        int findId;
        Object obj;
        Object instanceIdValue;
        Object obj2 = super.get(str, scriptable);
        if (obj2 != Scriptable.NOT_FOUND) {
            return obj2;
        }
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0 && (instanceIdValue = getInstanceIdValue(findInstanceIdInfo & 65535)) != Scriptable.NOT_FOUND) {
            return instanceIdValue;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        return (prototypeValues == null || (findId = prototypeValues.findId(str)) == 0 || (obj = this.prototypeValues.get(findId)) == Scriptable.NOT_FOUND) ? Scriptable.NOT_FOUND : obj;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        int findId;
        Object obj;
        Object instanceIdValue;
        Object obj2 = super.get(symbol, scriptable);
        if (obj2 != Scriptable.NOT_FOUND) {
            return obj2;
        }
        int findInstanceIdInfo = findInstanceIdInfo(symbol);
        if (findInstanceIdInfo != 0 && (instanceIdValue = getInstanceIdValue(findInstanceIdInfo & 65535)) != Scriptable.NOT_FOUND) {
            return instanceIdValue;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        return (prototypeValues == null || (findId = prototypeValues.findId(symbol)) == 0 || (obj = this.prototypeValues.get(findId)) == Scriptable.NOT_FOUND) ? Scriptable.NOT_FOUND : obj;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(String str) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            return findInstanceIdInfo >>> 16;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        return (prototypeValues == null || (findId = prototypeValues.findId(str)) == 0) ? super.getAttributes(str) : this.prototypeValues.getAttributes(findId);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(Symbol symbol) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(symbol);
        if (findInstanceIdInfo != 0) {
            return findInstanceIdInfo >>> 16;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        return (prototypeValues == null || (findId = prototypeValues.findId(symbol)) == 0) ? super.getAttributes(symbol) : this.prototypeValues.getAttributes(findId);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Object[] ids = super.getIds(z, z2);
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null) {
            ids = prototypeValues.getNames(z, z2, ids);
        }
        int maxInstanceId = getMaxInstanceId();
        if (maxInstanceId != 0) {
            Object[] objArr = null;
            int i = 0;
            while (maxInstanceId != 0) {
                String instanceIdName = getInstanceIdName(maxInstanceId);
                int findInstanceIdInfo = findInstanceIdInfo(instanceIdName);
                if (findInstanceIdInfo != 0) {
                    int i2 = findInstanceIdInfo >>> 16;
                    if (((i2 & 4) != 0 || Scriptable.NOT_FOUND != getInstanceIdValue(maxInstanceId)) && (z || (i2 & 2) == 0)) {
                        if (i == 0) {
                            objArr = new Object[maxInstanceId];
                        }
                        objArr[i] = instanceIdName;
                        i++;
                    }
                }
                maxInstanceId--;
            }
            if (i == 0) {
                return ids;
            }
            if (ids.length == 0 && objArr.length == i) {
                return objArr;
            }
            Object[] objArr2 = new Object[ids.length + i];
            System.arraycopy(ids, 0, objArr2, 0, ids.length);
            System.arraycopy(objArr, 0, objArr2, ids.length, i);
            return objArr2;
        }
        return ids;
    }

    public String getInstanceIdName(int i) {
        throw new IllegalArgumentException(String.valueOf(i));
    }

    public Object getInstanceIdValue(int i) {
        throw new IllegalStateException(String.valueOf(i));
    }

    public int getMaxInstanceId() {
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        ScriptableObject ownPropertyDescriptor = super.getOwnPropertyDescriptor(context, obj);
        return ownPropertyDescriptor == null ? obj instanceof String ? getBuiltInDescriptor((String) obj) : ScriptRuntime.isSymbol(obj) ? getBuiltInDescriptor(((NativeSymbol) obj).getKey()) : ownPropertyDescriptor : ownPropertyDescriptor;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo == 0) {
            PrototypeValues prototypeValues = this.prototypeValues;
            return (prototypeValues == null || (findId = prototypeValues.findId(str)) == 0) ? super.has(str, scriptable) : this.prototypeValues.has(findId);
        } else if (((findInstanceIdInfo >>> 16) & 4) != 0) {
            return true;
        } else {
            return Scriptable.NOT_FOUND != getInstanceIdValue(65535 & findInstanceIdInfo);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(symbol);
        if (findInstanceIdInfo == 0) {
            PrototypeValues prototypeValues = this.prototypeValues;
            return (prototypeValues == null || (findId = prototypeValues.findId(symbol)) == 0) ? super.has(symbol, scriptable) : this.prototypeValues.has(findId);
        } else if (((findInstanceIdInfo >>> 16) & 4) != 0) {
            return true;
        } else {
            return Scriptable.NOT_FOUND != getInstanceIdValue(65535 & findInstanceIdInfo);
        }
    }

    public final boolean hasPrototypeMap() {
        return this.prototypeValues != null;
    }

    public final void initPrototypeConstructor(IdFunctionObject idFunctionObject) {
        int i = this.prototypeValues.constructorId;
        if (i != 0) {
            if (idFunctionObject.methodId() != i) {
                throw new IllegalArgumentException();
            }
            if (isSealed()) {
                idFunctionObject.sealObject();
            }
            this.prototypeValues.initValue(i, "constructor", idFunctionObject, 2);
            return;
        }
        throw new IllegalStateException();
    }

    public void initPrototypeId(int i) {
        throw new IllegalStateException(String.valueOf(i));
    }

    public final IdFunctionObject initPrototypeMethod(Object obj, int i, String str, int i2) {
        return initPrototypeMethod(obj, i, str, str, i2);
    }

    public final IdFunctionObject initPrototypeMethod(Object obj, int i, String str, String str2, int i2) {
        IdFunctionObject newIdFunction = newIdFunction(obj, i, str2 != null ? str2 : str, i2, ScriptableObject.getTopLevelScope(this));
        this.prototypeValues.initValue(i, str, newIdFunction, 2);
        return newIdFunction;
    }

    public final IdFunctionObject initPrototypeMethod(Object obj, int i, Symbol symbol, String str, int i2) {
        IdFunctionObject newIdFunction = newIdFunction(obj, i, str, i2, ScriptableObject.getTopLevelScope(this));
        this.prototypeValues.initValue(i, symbol, newIdFunction, 2);
        return newIdFunction;
    }

    public final void initPrototypeValue(int i, String str, Object obj, int i2) {
        this.prototypeValues.initValue(i, str, obj, i2);
    }

    public final void initPrototypeValue(int i, Symbol symbol, Object obj, int i2) {
        this.prototypeValues.initValue(i, symbol, obj, i2);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            if (scriptable == this && isSealed()) {
                throw Context.reportRuntimeError1("msg.modify.sealed", str);
            }
            if (((findInstanceIdInfo >>> 16) & 1) != 0) {
                return;
            }
            if (scriptable == this) {
                setInstanceIdValue(65535 & findInstanceIdInfo, obj);
                return;
            } else {
                scriptable.put(str, scriptable, obj);
                return;
            }
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (findId = prototypeValues.findId(str)) == 0) {
            super.put(str, scriptable, obj);
        } else if (scriptable == this && isSealed()) {
            throw Context.reportRuntimeError1("msg.modify.sealed", str);
        } else {
            this.prototypeValues.set(findId, scriptable, obj);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        int findId;
        int findInstanceIdInfo = findInstanceIdInfo(symbol);
        if (findInstanceIdInfo != 0) {
            if (scriptable == this && isSealed()) {
                throw Context.reportRuntimeError0("msg.modify.sealed");
            }
            if (((findInstanceIdInfo >>> 16) & 1) != 0) {
                return;
            }
            if (scriptable == this) {
                setInstanceIdValue(65535 & findInstanceIdInfo, obj);
                return;
            } else {
                ScriptableObject.ensureSymbolScriptable(scriptable).put(symbol, scriptable, obj);
                return;
            }
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (findId = prototypeValues.findId(symbol)) == 0) {
            super.put(symbol, scriptable, obj);
        } else if (scriptable == this && isSealed()) {
            throw Context.reportRuntimeError0("msg.modify.sealed");
        } else {
            this.prototypeValues.set(findId, scriptable, obj);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void setAttributes(String str, int i) {
        int findId;
        ScriptableObject.checkValidAttributes(i);
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            int i2 = 65535 & findInstanceIdInfo;
            if (i == (findInstanceIdInfo >>> 16)) {
                return;
            }
            setInstanceIdAttributes(i2, i);
            return;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (findId = prototypeValues.findId(str)) == 0) {
            super.setAttributes(str, i);
        } else {
            this.prototypeValues.setAttributes(findId, i);
        }
    }

    public void setInstanceIdAttributes(int i, int i2) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Changing attributes not supported for ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClassName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInstanceIdName(i));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" property");
        throw ScriptRuntime.constructError("InternalError", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void setInstanceIdValue(int i, Object obj) {
        throw new IllegalStateException(String.valueOf(i));
    }
}
