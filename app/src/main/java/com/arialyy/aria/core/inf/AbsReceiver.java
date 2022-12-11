package com.arialyy.aria.core.inf;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class AbsReceiver implements IReceiver {
    public static final Map<String, Object> OBJ_MAP = new ConcurrentHashMap();
    public boolean needRmListener = false;
    public String targetName;

    public static String getKey(IReceiver iReceiver) {
        return String.format("%s_%s_%s", iReceiver.getTargetName(), iReceiver.getType(), Integer.valueOf(iReceiver.hashCode()));
    }

    private void removeObj() {
        Iterator<Map.Entry<String, Object>> it = OBJ_MAP.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equals(getKey())) {
                it.remove();
            }
        }
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public void destroy() {
        unRegisterListener();
        removeObj();
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public String getKey() {
        return getKey(this);
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public String getTargetName() {
        return this.targetName;
    }

    public abstract void unRegisterListener();
}
