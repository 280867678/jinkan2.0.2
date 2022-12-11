package org.mozilla.javascript;

import java.util.Iterator;
import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes5.dex */
public class SlotMapContainer implements SlotMap {
    public static final int LARGE_HASH_SIZE = 2000;
    public SlotMap map;

    public SlotMapContainer(int i) {
        this.map = i > 2000 ? new HashSlotMap() : new EmbeddedSlotMap();
    }

    @Override // org.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        checkMapSize();
        this.map.addSlot(slot);
    }

    public void checkMapSize() {
        SlotMap slotMap = this.map;
        if (!(slotMap instanceof EmbeddedSlotMap) || slotMap.size() < 2000) {
            return;
        }
        HashSlotMap hashSlotMap = new HashSlotMap();
        for (ScriptableObject.Slot slot : this.map) {
            hashSlotMap.addSlot(slot);
        }
        this.map = hashSlotMap;
    }

    public int dirtySize() {
        return this.map.size();
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot get(Object obj, int i, ScriptableObject.SlotAccess slotAccess) {
        if (slotAccess != ScriptableObject.SlotAccess.QUERY) {
            checkMapSize();
        }
        return this.map.get(obj, i, slotAccess);
    }

    @Override // org.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return this.map.iterator();
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i) {
        return this.map.query(obj, i);
    }

    public long readLock() {
        return 0L;
    }

    @Override // org.mozilla.javascript.SlotMap
    public void remove(Object obj, int i) {
        this.map.remove(obj, i);
    }

    @Override // org.mozilla.javascript.SlotMap
    public int size() {
        return this.map.size();
    }

    public void unlockRead(long j) {
    }
}
