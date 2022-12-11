package org.eclipse.jetty.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class StringMap extends AbstractMap implements Externalizable {
    public static final boolean CASE_INSENSTIVE = true;
    public static final int __HASH_WIDTH = 17;
    public HashSet _entrySet;
    public boolean _ignoreCase;
    public NullEntry _nullEntry;
    public Object _nullValue;
    public Node _root;
    public Set _umEntrySet;
    public int _width;

    /* loaded from: classes5.dex */
    public static class Node implements Map.Entry {
        public char[] _char;
        public Node[] _children;
        public String _key;
        public Node _next;
        public char[] _ochar;
        public Object _value;

        public Node() {
        }

        public Node(boolean z, String str, int i) {
            int length = str.length() - i;
            this._char = new char[length];
            this._ochar = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i + i2);
                this._char[i2] = charAt;
                if (z) {
                    if (Character.isUpperCase(charAt)) {
                        charAt = Character.toLowerCase(charAt);
                    } else if (Character.isLowerCase(charAt)) {
                        charAt = Character.toUpperCase(charAt);
                    }
                    this._ochar[i2] = charAt;
                }
            }
        }

        private void toString(StringBuilder sb) {
            sb.append("{[");
            if (this._char != null) {
                int i = 0;
                while (true) {
                    char[] cArr = this._char;
                    if (i >= cArr.length) {
                        break;
                    }
                    sb.append(cArr[i]);
                    i++;
                }
            } else {
                sb.append('-');
            }
            sb.append(':');
            sb.append(this._key);
            sb.append(B64Code.__pad);
            sb.append(this._value);
            sb.append(']');
            if (this._children != null) {
                for (int i2 = 0; i2 < this._children.length; i2++) {
                    sb.append('|');
                    Node[] nodeArr = this._children;
                    if (nodeArr[i2] != null) {
                        nodeArr[i2].toString(sb);
                    } else {
                        sb.append("-");
                    }
                }
            }
            sb.append('}');
            if (this._next != null) {
                sb.append(",\n");
                this._next.toString(sb);
            }
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this._key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this._value;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this._value;
            this._value = obj;
            return obj2;
        }

        public Node split(StringMap stringMap, int i) {
            Node node = new Node();
            char[] cArr = this._char;
            int length = cArr.length - i;
            this._char = new char[i];
            node._char = new char[length];
            System.arraycopy(cArr, 0, this._char, 0, i);
            System.arraycopy(cArr, i, node._char, 0, length);
            char[] cArr2 = this._ochar;
            if (cArr2 != null) {
                this._ochar = new char[i];
                node._ochar = new char[length];
                System.arraycopy(cArr2, 0, this._ochar, 0, i);
                System.arraycopy(cArr2, i, node._ochar, 0, length);
            }
            node._key = this._key;
            node._value = this._value;
            this._key = null;
            this._value = null;
            if (stringMap._entrySet.remove(this)) {
                stringMap._entrySet.add(node);
            }
            node._children = this._children;
            int i2 = stringMap._width;
            Node[] nodeArr = new Node[i2];
            this._children = nodeArr;
            nodeArr[node._char[0] % i2] = node;
            char[] cArr3 = node._ochar;
            if (cArr3 != null && nodeArr[cArr3[0] % i2] != node) {
                nodeArr[cArr3[0] % i2] = node;
            }
            return node;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(sb);
            return sb.toString();
        }
    }

    /* loaded from: classes5.dex */
    public class NullEntry implements Map.Entry {
        public NullEntry() {
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return null;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return StringMap.this._nullValue;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            StringMap stringMap = StringMap.this;
            Object obj2 = stringMap._nullValue;
            stringMap._nullValue = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[:null=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringMap.this._nullValue);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public StringMap() {
        this._width = 17;
        this._root = new Node();
        this._ignoreCase = false;
        this._nullEntry = null;
        this._nullValue = null;
        HashSet hashSet = new HashSet(3);
        this._entrySet = hashSet;
        this._umEntrySet = Collections.unmodifiableSet(hashSet);
    }

    public StringMap(boolean z) {
        this();
        this._ignoreCase = z;
    }

    public StringMap(boolean z, int i) {
        this();
        this._ignoreCase = z;
        this._width = i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._root = new Node();
        this._nullEntry = null;
        this._nullValue = null;
        this._entrySet.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return obj == null ? this._nullEntry != null : getEntry(obj.toString(), 0, obj.toString().length()) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return this._umEntrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (obj == null) {
            return this._nullValue;
        }
        return get(obj instanceof String ? (String) obj : obj.toString());
    }

    public Object get(String str) {
        if (str == null) {
            return this._nullValue;
        }
        Map.Entry entry = getEntry(str, 0, str.length());
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public Map.Entry getBestEntry(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return this._nullEntry;
        }
        Node node = this._root;
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            char c = (char) bArr[i + i4];
            if (i3 == -1) {
                Node[] nodeArr = node._children;
                Node node2 = nodeArr == null ? null : nodeArr[c % this._width];
                if (node2 == null && i4 > 0) {
                    return node;
                }
                node = node2;
                i3 = 0;
            }
            while (node != null) {
                if (node._char[i3] == c || (this._ignoreCase && node._ochar[i3] == c)) {
                    i3++;
                    if (i3 == node._char.length) {
                        i3 = -1;
                    }
                } else if (i3 > 0) {
                    return null;
                } else {
                    node = node._next;
                }
            }
            return null;
        }
        if (i3 > 0) {
            return null;
        }
        if (node != null && node._key == null) {
            return null;
        }
        return node;
    }

    public Map.Entry getEntry(String str, int i, int i2) {
        if (str == null) {
            return this._nullEntry;
        }
        Node node = this._root;
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            char charAt = str.charAt(i + i4);
            if (i3 == -1) {
                Node[] nodeArr = node._children;
                node = nodeArr == null ? null : nodeArr[charAt % this._width];
                i3 = 0;
            }
            while (node != null) {
                if (node._char[i3] == charAt || (this._ignoreCase && node._ochar[i3] == charAt)) {
                    i3++;
                    if (i3 == node._char.length) {
                        i3 = -1;
                    }
                } else if (i3 > 0) {
                    return null;
                } else {
                    node = node._next;
                }
            }
            return null;
        }
        if (i3 > 0) {
            return null;
        }
        if (node != null && node._key == null) {
            return null;
        }
        return node;
    }

    public Map.Entry getEntry(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return this._nullEntry;
        }
        Node node = this._root;
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            char c = cArr[i + i4];
            if (i3 == -1) {
                Node[] nodeArr = node._children;
                node = nodeArr == null ? null : nodeArr[c % this._width];
                i3 = 0;
            }
            while (node != null) {
                if (node._char[i3] == c || (this._ignoreCase && node._ochar[i3] == c)) {
                    i3++;
                    if (i3 == node._char.length) {
                        i3 = -1;
                    }
                } else if (i3 > 0) {
                    return null;
                } else {
                    node = node._next;
                }
            }
            return null;
        }
        if (i3 > 0) {
            return null;
        }
        if (node != null && node._key == null) {
            return null;
        }
        return node;
    }

    public int getWidth() {
        return this._width;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this._entrySet.isEmpty();
    }

    public boolean isIgnoreCase() {
        return this._ignoreCase;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        return put(obj == null ? null : obj.toString(), obj2);
    }

    public Object put(String str, Object obj) {
        if (str == null) {
            Object obj2 = this._nullValue;
            this._nullValue = obj;
            if (this._nullEntry == null) {
                NullEntry nullEntry = new NullEntry();
                this._nullEntry = nullEntry;
                this._entrySet.add(nullEntry);
            }
            return obj2;
        }
        Node node = this._root;
        Node node2 = null;
        Node node3 = null;
        int i = 0;
        int i2 = -1;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            char charAt = str.charAt(i);
            if (i2 == -1) {
                Node[] nodeArr = node._children;
                node2 = null;
                node3 = node;
                node = nodeArr == null ? null : nodeArr[charAt % this._width];
                i2 = 0;
            }
            while (node != null) {
                if (node._char[i2] == charAt || (this._ignoreCase && node._ochar[i2] == charAt)) {
                    i2++;
                    if (i2 == node._char.length) {
                        node2 = null;
                    } else {
                        node2 = null;
                        i++;
                    }
                } else if (i2 == 0) {
                    node2 = node;
                    node = node._next;
                } else {
                    node.split(this, i2);
                    i--;
                }
                i2 = -1;
                i++;
            }
            node = new Node(this._ignoreCase, str, i);
            if (node2 != null) {
                node2._next = node;
            } else if (node3 != null) {
                if (node3._children == null) {
                    node3._children = new Node[this._width];
                }
                Node[] nodeArr2 = node3._children;
                int i3 = this._width;
                nodeArr2[charAt % i3] = node;
                char[] cArr = node._ochar;
                int i4 = cArr[0] % i3;
                if (cArr != null && node._char[0] % i3 != i4) {
                    if (nodeArr2[i4] == null) {
                        nodeArr2[i4] = node;
                    } else {
                        Node node4 = nodeArr2[i4];
                        while (true) {
                            Node node5 = node4._next;
                            if (node5 == null) {
                                break;
                            }
                            node4 = node5;
                        }
                        node4._next = node;
                    }
                }
            } else {
                this._root = node;
            }
        }
        if (node == null) {
            return null;
        }
        if (i2 > 0) {
            node.split(this, i2);
        }
        Object obj3 = node._value;
        node._key = str;
        node._value = obj;
        this._entrySet.add(node);
        return obj3;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        setIgnoreCase(objectInput.readBoolean());
        putAll((HashMap) objectInput.readObject());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        return remove(obj == null ? null : obj.toString());
    }

    public Object remove(String str) {
        if (str == null) {
            Object obj = this._nullValue;
            NullEntry nullEntry = this._nullEntry;
            if (nullEntry != null) {
                this._entrySet.remove(nullEntry);
                this._nullEntry = null;
                this._nullValue = null;
            }
            return obj;
        }
        Node node = this._root;
        int i = -1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (i == -1) {
                Node[] nodeArr = node._children;
                node = nodeArr == null ? null : nodeArr[charAt % this._width];
                i = 0;
            }
            while (node != null) {
                if (node._char[i] == charAt || (this._ignoreCase && node._ochar[i] == charAt)) {
                    i++;
                    if (i == node._char.length) {
                        i = -1;
                    }
                } else if (i > 0) {
                    return null;
                } else {
                    node = node._next;
                }
            }
            return null;
        }
        if (i > 0) {
            return null;
        }
        if (node != null && node._key == null) {
            return null;
        }
        Object obj2 = node._value;
        this._entrySet.remove(node);
        node._value = null;
        node._key = null;
        return obj2;
    }

    public void setIgnoreCase(boolean z) {
        if (this._root._children == null) {
            this._ignoreCase = z;
            return;
        }
        throw new IllegalStateException("Must be set before first put");
    }

    public void setWidth(int i) {
        this._width = i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this._entrySet.size();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        HashMap hashMap = new HashMap(this);
        objectOutput.writeBoolean(this._ignoreCase);
        objectOutput.writeObject(hashMap);
    }
}
