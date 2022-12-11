package org.mozilla.javascript;

import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes5.dex */
public interface SlotMap extends Iterable<ScriptableObject.Slot> {
    void addSlot(ScriptableObject.Slot slot);

    ScriptableObject.Slot get(Object obj, int i, ScriptableObject.SlotAccess slotAccess);

    boolean isEmpty();

    ScriptableObject.Slot query(Object obj, int i);

    void remove(Object obj, int i);

    int size();
}
