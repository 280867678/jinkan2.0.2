package org.simpleframework.xml.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* loaded from: classes5.dex */
public class LabelMap extends LinkedHashMap<String, Label> implements Iterable<Label> {
    public final Policy policy;

    public LabelMap() {
        this(null);
    }

    public LabelMap(Policy policy) {
        this.policy = policy;
    }

    private String[] getArray(Set<String> set) {
        return (String[]) set.toArray(new String[0]);
    }

    public String[] getKeys() throws Exception {
        HashSet hashSet = new HashSet();
        Iterator<Label> it = iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next != null) {
                String path = next.getPath();
                String name = next.getName();
                hashSet.add(path);
                hashSet.add(name);
            }
        }
        return getArray(hashSet);
    }

    public Label getLabel(String str) {
        return remove(str);
    }

    public LabelMap getLabels() throws Exception {
        LabelMap labelMap = new LabelMap(this.policy);
        Iterator<Label> it = iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next != null) {
                labelMap.put(next.getPath(), next);
            }
        }
        return labelMap;
    }

    public String[] getPaths() throws Exception {
        HashSet hashSet = new HashSet();
        Iterator<Label> it = iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next != null) {
                hashSet.add(next.getPath());
            }
        }
        return getArray(hashSet);
    }

    public boolean isStrict(Context context) {
        Policy policy = this.policy;
        boolean isStrict = context.isStrict();
        return policy == null ? isStrict : isStrict && this.policy.isStrict();
    }

    @Override // java.lang.Iterable
    public Iterator<Label> iterator() {
        return values().iterator();
    }
}
