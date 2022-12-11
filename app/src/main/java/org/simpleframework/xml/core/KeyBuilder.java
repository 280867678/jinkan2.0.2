package org.simpleframework.xml.core;

import java.util.Arrays;

/* loaded from: classes5.dex */
public class KeyBuilder {
    public final Label label;

    /* loaded from: classes5.dex */
    public static class Key {
        public final KeyType type;
        public final String value;

        public Key(KeyType keyType, String str) throws Exception {
            this.value = str;
            this.type = keyType;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return equals((Key) obj);
            }
            return false;
        }

        public boolean equals(Key key) {
            if (this.type == key.type) {
                return key.value.equals(this.value);
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return this.value;
        }
    }

    /* loaded from: classes5.dex */
    public enum KeyType {
        TEXT,
        ATTRIBUTE,
        ELEMENT
    }

    public KeyBuilder(Label label) {
        this.label = label;
    }

    private Object getKey(KeyType keyType) throws Exception {
        String key = getKey(this.label.getPaths());
        return keyType == null ? key : new Key(keyType, key);
    }

    private String getKey(String[] strArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (strArr.length > 0) {
            Arrays.sort(strArr);
            for (String str : strArr) {
                sb.append(str);
                sb.append('>');
            }
        }
        return sb.toString();
    }

    public Object getKey() throws Exception {
        return getKey(this.label.isAttribute() ? KeyType.ATTRIBUTE : KeyType.ELEMENT);
    }
}
