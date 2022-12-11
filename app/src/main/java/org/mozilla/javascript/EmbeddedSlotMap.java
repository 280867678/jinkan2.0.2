package org.mozilla.javascript;

import java.util.Iterator;
import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes5.dex */
public class EmbeddedSlotMap implements SlotMap {
    public static final int INITIAL_SLOT_SIZE = 4;
    public int count;
    public ScriptableObject.Slot firstAdded;
    public ScriptableObject.Slot lastAdded;
    public ScriptableObject.Slot[] slots;

    /* renamed from: org.mozilla.javascript.EmbeddedSlotMap$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C33041 {
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

    /* loaded from: classes5.dex */
    public static final class Iter implements Iterator<ScriptableObject.Slot> {
        public ScriptableObject.Slot next;

        public Iter(ScriptableObject.Slot slot) {
            this.next = slot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public ScriptableObject.Slot next() {
            ScriptableObject.Slot slot = this.next;
            this.next = slot.orderedNext;
            return slot;
        }
    }

    private void addKnownAbsentSlot(ScriptableObject.Slot[] slotArr, ScriptableObject.Slot slot) {
        int slotIndex = getSlotIndex(slotArr.length, slot.indexOrHash);
        ScriptableObject.Slot slot2 = slotArr[slotIndex];
        slotArr[slotIndex] = slot;
        slot.next = slot2;
    }

    private void copyTable(ScriptableObject.Slot[] slotArr, ScriptableObject.Slot[] slotArr2) {
        for (ScriptableObject.Slot slot : slotArr) {
            while (slot != null) {
                ScriptableObject.Slot slot2 = slot.next;
                slot.next = null;
                addKnownAbsentSlot(slotArr2, slot);
                slot = slot2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0036, code lost:
        if (r8 != org.mozilla.javascript.ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003a, code lost:
        if ((r0 instanceof org.mozilla.javascript.ScriptableObject.GetterSlot) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003c, code lost:
        r8 = new org.mozilla.javascript.ScriptableObject.GetterSlot(r6, r7, r0.getAttributes());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
        r8.value = r0.value;
        r8.next = r0.next;
        r6 = r5.firstAdded;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        if (r0 != r6) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
        r5.firstAdded = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
        r8.orderedNext = r0.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
        if (r0 != r5.lastAdded) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
        r5.lastAdded = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007c, code lost:
        if (r2 != r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
        r5.slots[r9] = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0085, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
        r2.next = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0066, code lost:
        if (r6 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0068, code lost:
        r7 = r6.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006a, code lost:
        if (r7 == r0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006c, code lost:
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006e, code lost:
        if (r6 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0070, code lost:
        r6.orderedNext = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0048, code lost:
        if (r8 != org.mozilla.javascript.ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x004c, code lost:
        if ((r0 instanceof org.mozilla.javascript.ScriptableObject.GetterSlot) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x004e, code lost:
        r8 = new org.mozilla.javascript.ScriptableObject.Slot(r6, r7, r0.getAttributes());
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0088, code lost:
        if (r8 != org.mozilla.javascript.ScriptableObject.SlotAccess.MODIFY_CONST) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x008a, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ScriptableObject.Slot createSlot(Object obj, int i, ScriptableObject.SlotAccess slotAccess, ScriptableObject.Slot slot) {
        Object obj2;
        if (this.count == 0) {
            this.slots = new ScriptableObject.Slot[4];
        } else if (slot != null) {
            int slotIndex = getSlotIndex(this.slots.length, i);
            ScriptableObject.Slot slot2 = this.slots[slotIndex];
            ScriptableObject.Slot slot3 = slot2;
            while (slot2 != null && (slot2.indexOrHash != i || ((obj2 = slot2.name) != obj && (obj == null || !obj.equals(obj2))))) {
                slot3 = slot2;
                slot2 = slot2.next;
            }
        }
        int i2 = (this.count + 1) * 4;
        ScriptableObject.Slot[] slotArr = this.slots;
        if (i2 > slotArr.length * 3) {
            ScriptableObject.Slot[] slotArr2 = new ScriptableObject.Slot[slotArr.length * 2];
            copyTable(slotArr, slotArr2);
            this.slots = slotArr2;
        }
        ScriptableObject.Slot getterSlot = slotAccess == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER ? new ScriptableObject.GetterSlot(obj, i, 0) : new ScriptableObject.Slot(obj, i, 0);
        if (slotAccess == ScriptableObject.SlotAccess.MODIFY_CONST) {
            getterSlot.setAttributes(13);
        }
        insertNewSlot(getterSlot);
        return getterSlot;
    }

    public static int getSlotIndex(int i, int i2) {
        return (i - 1) & i2;
    }

    private void insertNewSlot(ScriptableObject.Slot slot) {
        this.count++;
        ScriptableObject.Slot slot2 = this.lastAdded;
        if (slot2 != null) {
            slot2.orderedNext = slot;
        }
        if (this.firstAdded == null) {
            this.firstAdded = slot;
        }
        this.lastAdded = slot;
        addKnownAbsentSlot(this.slots, slot);
    }

    @Override // org.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        if (this.slots == null) {
            this.slots = new ScriptableObject.Slot[4];
        }
        insertNewSlot(slot);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0051, code lost:
        if (r1 != null) goto L37;
     */
    @Override // org.mozilla.javascript.SlotMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ScriptableObject.Slot get(Object obj, int i, ScriptableObject.SlotAccess slotAccess) {
        ScriptableObject.Slot slot = null;
        if (this.slots == null && slotAccess == ScriptableObject.SlotAccess.QUERY) {
            return null;
        }
        if (obj != null) {
            i = obj.hashCode();
        }
        ScriptableObject.Slot[] slotArr = this.slots;
        if (slotArr != null) {
            slot = this.slots[getSlotIndex(slotArr.length, i)];
            while (slot != null) {
                Object obj2 = slot.name;
                if (i == slot.indexOrHash && (obj2 == obj || (obj != null && obj.equals(obj2)))) {
                    break;
                }
                slot = slot.next;
            }
            int ordinal = slotAccess.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1 && ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal == 4 && !(slot instanceof ScriptableObject.GetterSlot)) {
                            return slot;
                        }
                    } else if (slot instanceof ScriptableObject.GetterSlot) {
                        return slot;
                    }
                }
            }
            return slot;
        }
        return createSlot(obj, i, slotAccess, slot);
    }

    @Override // org.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return new Iter(this.firstAdded);
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i) {
        if (this.slots == null) {
            return null;
        }
        if (obj != null) {
            i = obj.hashCode();
        }
        for (ScriptableObject.Slot slot = this.slots[getSlotIndex(this.slots.length, i)]; slot != null; slot = slot.next) {
            Object obj2 = slot.name;
            if (i == slot.indexOrHash && (obj2 == obj || (obj != null && obj.equals(obj2)))) {
                return slot;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if ((r1.getAttributes() & 4) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (org.mozilla.javascript.Context.getContext().isStrictMode() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
        throw org.mozilla.javascript.ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
        r5.count--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
        if (r2 != r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        r5.slots[r0] = r1.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
        r6 = r5.firstAdded;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
        if (r1 != r6) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
        r6 = null;
        r5.firstAdded = r1.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r1 != r5.lastAdded) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        r5.lastAdded = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        r7 = r6.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
        if (r7 == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006e, code lost:
        r6.orderedNext = r1.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005a, code lost:
        r2.next = r1.next;
     */
    @Override // org.mozilla.javascript.SlotMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void remove(Object obj, int i) {
        Object obj2;
        if (obj != null) {
            i = obj.hashCode();
        }
        if (this.count != 0) {
            int slotIndex = getSlotIndex(this.slots.length, i);
            ScriptableObject.Slot slot = this.slots[slotIndex];
            ScriptableObject.Slot slot2 = slot;
            while (slot != null && (slot.indexOrHash != i || ((obj2 = slot.name) != obj && (obj == null || !obj.equals(obj2))))) {
                slot2 = slot;
                slot = slot.next;
            }
        }
    }

    @Override // org.mozilla.javascript.SlotMap
    public int size() {
        return this.count;
    }
}
