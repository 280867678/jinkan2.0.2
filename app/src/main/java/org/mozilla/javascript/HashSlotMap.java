package org.mozilla.javascript;

import java.util.Iterator;
import java.util.LinkedHashMap;
import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes5.dex */
public class HashSlotMap implements SlotMap {
    public final LinkedHashMap<Object, ScriptableObject.Slot> map = new LinkedHashMap<>();

    /* renamed from: org.mozilla.javascript.HashSlotMap$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C33051 {
        public static final /* synthetic */ int[] $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess;

        static {
            int[] iArr = new int[ScriptableObject.SlotAccess.values().length];
            $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess = iArr;
            try {
                ScriptableObject.SlotAccess slotAccess = ScriptableObject.SlotAccess.QUERY;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess;
                ScriptableObject.SlotAccess slotAccess2 = ScriptableObject.SlotAccess.MODIFY;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess;
                ScriptableObject.SlotAccess slotAccess3 = ScriptableObject.SlotAccess.MODIFY_CONST;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess;
                ScriptableObject.SlotAccess slotAccess4 = ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess;
                ScriptableObject.SlotAccess slotAccess5 = ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private ScriptableObject.Slot createSlot(Object obj, int i, Object obj2, ScriptableObject.SlotAccess slotAccess) {
        ScriptableObject.Slot slot;
        ScriptableObject.Slot slot2 = this.map.get(obj2);
        if (slot2 == null) {
            ScriptableObject.Slot getterSlot = slotAccess == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER ? new ScriptableObject.GetterSlot(obj, i, 0) : new ScriptableObject.Slot(obj, i, 0);
            if (slotAccess == ScriptableObject.SlotAccess.MODIFY_CONST) {
                getterSlot.setAttributes(13);
            }
            addSlot(getterSlot);
            return getterSlot;
        }
        if (slotAccess == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER && !(slot2 instanceof ScriptableObject.GetterSlot)) {
            slot = new ScriptableObject.GetterSlot(obj2, slot2.indexOrHash, slot2.getAttributes());
        } else if (slotAccess != ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA || !(slot2 instanceof ScriptableObject.GetterSlot)) {
            if (slotAccess != ScriptableObject.SlotAccess.MODIFY_CONST) {
                return slot2;
            }
            return null;
        } else {
            slot = new ScriptableObject.Slot(obj2, slot2.indexOrHash, slot2.getAttributes());
        }
        slot.value = slot2.value;
        this.map.put(obj2, slot);
        return slot;
    }

    @Override // org.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        Object obj = slot.name;
        if (obj == null) {
            obj = String.valueOf(slot.indexOrHash);
        }
        this.map.put(obj, slot);
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot get(Object obj, int i, ScriptableObject.SlotAccess slotAccess) {
        Object valueOf = obj == null ? String.valueOf(i) : obj;
        ScriptableObject.Slot slot = this.map.get(valueOf);
        int ordinal = slotAccess.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1 || ordinal == 2) {
                if (slot != null) {
                    return slot;
                }
            } else if (ordinal != 3) {
                if (ordinal == 4 && !(slot instanceof ScriptableObject.GetterSlot)) {
                    return slot;
                }
            } else if (slot instanceof ScriptableObject.GetterSlot) {
                return slot;
            }
            return createSlot(obj, i, valueOf, slotAccess);
        }
        return slot;
    }

    @Override // org.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return this.map.values().iterator();
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i) {
        if (obj == null) {
            obj = String.valueOf(i);
        }
        return this.map.get(obj);
    }

    @Override // org.mozilla.javascript.SlotMap
    public void remove(Object obj, int i) {
        Object valueOf = obj == null ? String.valueOf(i) : obj;
        ScriptableObject.Slot slot = this.map.get(valueOf);
        if (slot != null) {
            if ((slot.getAttributes() & 4) == 0) {
                this.map.remove(valueOf);
            } else if (Context.getContext().isStrictMode()) {
                throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", obj);
            }
        }
    }

    @Override // org.mozilla.javascript.SlotMap
    public int size() {
        return this.map.size();
    }
}
