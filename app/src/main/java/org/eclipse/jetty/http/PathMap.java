package org.eclipse.jetty.http;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import me.tvspark.outline;
import okhttp3.CertificatePinner;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.StringMap;

/* loaded from: classes4.dex */
public class PathMap extends HashMap implements Externalizable {
    public static String __pathSpecSeparators = ":,";
    public Entry _default;
    public List _defaultSingletonList;
    public final Set _entrySet;
    public final StringMap _exactMap;
    public boolean _nodefault;
    public Entry _prefixDefault;
    public final StringMap _prefixMap;
    public final StringMap _suffixMap;

    /* loaded from: classes4.dex */
    public static class Entry implements Map.Entry {
        public final Object key;
        public String mapped;
        public transient String string;
        public final Object value;

        public Entry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.key;
        }

        public String getMapped() {
            return this.mapped;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        public void setMapped(String str) {
            this.mapped = str;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            if (this.string == null) {
                this.string = this.key + "=" + this.value;
            }
            return this.string;
        }
    }

    public PathMap() {
        super(11);
        this._prefixMap = new StringMap();
        this._suffixMap = new StringMap();
        this._exactMap = new StringMap();
        this._defaultSingletonList = null;
        this._prefixDefault = null;
        this._default = null;
        this._nodefault = false;
        this._entrySet = entrySet();
    }

    public PathMap(int i) {
        super(i);
        this._prefixMap = new StringMap();
        this._suffixMap = new StringMap();
        this._exactMap = new StringMap();
        this._defaultSingletonList = null;
        this._prefixDefault = null;
        this._default = null;
        this._nodefault = false;
        this._entrySet = entrySet();
    }

    public PathMap(Map map) {
        this._prefixMap = new StringMap();
        this._suffixMap = new StringMap();
        this._exactMap = new StringMap();
        this._defaultSingletonList = null;
        this._prefixDefault = null;
        this._default = null;
        this._nodefault = false;
        putAll(map);
        this._entrySet = entrySet();
    }

    public PathMap(boolean z) {
        super(11);
        this._prefixMap = new StringMap();
        this._suffixMap = new StringMap();
        this._exactMap = new StringMap();
        this._defaultSingletonList = null;
        this._prefixDefault = null;
        this._default = null;
        this._nodefault = false;
        this._entrySet = entrySet();
        this._nodefault = z;
    }

    public static boolean isPathWildcardMatch(String str, String str2) {
        int length = str.length() - 2;
        return str.endsWith("/*") && str2.regionMatches(0, str, 0, length) && (str2.length() == length || '/' == str2.charAt(length));
    }

    public static boolean match(String str, String str2) throws IllegalArgumentException {
        return match(str, str2, false);
    }

    public static boolean match(String str, String str2, boolean z) throws IllegalArgumentException {
        if (str.length() == 0) {
            return "/".equals(str2);
        }
        char charAt = str.charAt(0);
        if (charAt == '/') {
            if ((!z && str.length() == 1) || str.equals(str2) || isPathWildcardMatch(str, str2)) {
                return true;
            }
        } else if (charAt == '*') {
            return str2.regionMatches((str2.length() - str.length()) + 1, str, 1, str.length() - 1);
        }
        return false;
    }

    public static String pathInfo(String str, String str2) {
        if ("".equals(str)) {
            return str2;
        }
        if (str.charAt(0) != '/' || str.length() == 1) {
            return null;
        }
        boolean isPathWildcardMatch = isPathWildcardMatch(str, str2);
        if ((str.equals(str2) && !isPathWildcardMatch) || !isPathWildcardMatch || str2.length() == str.length() - 2) {
            return null;
        }
        return str2.substring(str.length() - 2);
    }

    public static String pathMatch(String str, String str2) {
        char charAt = str.charAt(0);
        if (charAt != '/') {
            if (charAt == '*' && str2.regionMatches(str2.length() - (str.length() - 1), str, 1, str.length() - 1)) {
                return str2;
            }
            return null;
        } else if (str.length() == 1 || str.equals(str2)) {
            return str2;
        } else {
            if (!isPathWildcardMatch(str, str2)) {
                return null;
            }
            return str2.substring(0, str.length() - 2);
        }
    }

    public static String relativePath(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        String pathInfo = pathInfo(str2, str3);
        if (pathInfo != null) {
            str3 = pathInfo;
        }
        if (str3.startsWith("./")) {
            str3 = str3.substring(2);
        }
        if (str.endsWith("/")) {
            if (str3.startsWith("/")) {
                sb2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                sb2.append(str3.substring(1));
                return sb2.toString();
            }
            sb = new StringBuilder();
        } else if (!str3.startsWith("/")) {
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "/", str3);
        } else {
            sb = new StringBuilder();
        }
        sb.append(str);
        sb.append(str3);
        sb2 = sb;
        return sb2.toString();
    }

    public static void setPathSpecSeparators(String str) {
        __pathSpecSeparators = str;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        this._exactMap.clear();
        this._prefixMap.clear();
        this._suffixMap.clear();
        this._default = null;
        this._defaultSingletonList = null;
        super.clear();
    }

    public boolean containsMatch(String str) {
        Entry match = getMatch(str);
        return match != null && !match.equals(this._default);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r2 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        r0 = org.eclipse.jetty.util.LazyList.add(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        r3 = r7.indexOf(46, r3 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (r3 <= 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        r2 = r6._suffixMap.getEntry(r7, r3 + 1, (r1 - r3) - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        r2 = r2.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
        r7 = r6._default;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r7 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
        if (r0 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        return r6._defaultSingletonList;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
        return org.eclipse.jetty.util.LazyList.add(r0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return r0;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x005b -> B:17:0x003f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getLazyMatches(String str) {
        Object obj = null;
        if (str == null) {
            return LazyList.getList(null);
        }
        int length = str.length();
        int i = 0;
        Map.Entry entry = this._exactMap.getEntry(str, 0, length);
        if (entry != null) {
            obj = LazyList.add(null, entry.getValue());
        }
        int i2 = length - 1;
        while (true) {
            i2 = str.lastIndexOf(47, i2 - 1);
            if (i2 < 0) {
                break;
            }
            Map.Entry entry2 = this._prefixMap.getEntry(str, 0, i2);
            if (entry2 != null) {
                obj = LazyList.add(obj, entry2.getValue());
            }
        }
        Object obj2 = this._prefixDefault;
    }

    public Entry getMatch(String str) {
        Map.Entry entry;
        Object value;
        Map.Entry entry2;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i = 0;
        if (length == 1 && str.charAt(0) == '/' && (entry2 = (Map.Entry) this._exactMap.get("")) != null) {
            return (Entry) entry2;
        }
        Map.Entry entry3 = this._exactMap.getEntry(str, 0, length);
        if (entry3 != null) {
            value = entry3.getValue();
        } else {
            int i2 = length;
            while (true) {
                i2 = str.lastIndexOf(47, i2 - 1);
                if (i2 >= 0) {
                    Map.Entry entry4 = this._prefixMap.getEntry(str, 0, i2);
                    if (entry4 != null) {
                        value = entry4.getValue();
                        break;
                    }
                } else {
                    Entry entry5 = this._prefixDefault;
                    if (entry5 != null) {
                        return entry5;
                    }
                    do {
                        i = str.indexOf(46, i + 1);
                        if (i <= 0) {
                            return this._default;
                        }
                        entry = this._suffixMap.getEntry(str, i + 1, (length - i) - 1);
                    } while (entry == null);
                    value = entry.getValue();
                }
            }
        }
        return (Entry) value;
    }

    public List getMatches(String str) {
        return LazyList.getList(getLazyMatches(str));
    }

    public Object match(String str) {
        Entry match = getMatch(str);
        if (match != null) {
            return match.getValue();
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        StringMap stringMap;
        String obj3 = obj.toString();
        if ("".equals(obj3.trim())) {
            Entry entry = new Entry("", obj2);
            entry.setMapped("");
            this._exactMap.put("", (Object) entry);
            return super.put("", obj2);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(obj3, __pathSpecSeparators);
        Object obj4 = null;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!nextToken.startsWith("/") && !nextToken.startsWith(CertificatePinner.WILDCARD)) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PathSpec ", nextToken, ". must start with '/' or '*.'"));
            }
            Object put = super.put(nextToken, obj2);
            Entry entry2 = new Entry(nextToken, obj2);
            if (entry2.getKey().equals(nextToken)) {
                if (nextToken.equals("/*")) {
                    this._prefixDefault = entry2;
                } else {
                    if (nextToken.endsWith("/*")) {
                        String substring = nextToken.substring(0, nextToken.length() - 2);
                        entry2.setMapped(substring);
                        this._prefixMap.put(substring, (Object) entry2);
                        this._exactMap.put(substring, (Object) entry2);
                        stringMap = this._exactMap;
                        nextToken = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken, -1, 0);
                    } else if (nextToken.startsWith(CertificatePinner.WILDCARD)) {
                        stringMap = this._suffixMap;
                        nextToken = nextToken.substring(2);
                    } else {
                        if (!nextToken.equals("/")) {
                            entry2.setMapped(nextToken);
                        } else if (!this._nodefault) {
                            this._default = entry2;
                            this._defaultSingletonList = Collections.singletonList(entry2);
                        }
                        stringMap = this._exactMap;
                    }
                    stringMap.put(nextToken, (Object) entry2);
                }
            }
            obj4 = put;
        }
        return obj4;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        putAll((HashMap) objectInput.readObject());
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        StringMap stringMap;
        if (obj != null) {
            String str = (String) obj;
            if (str.equals("/*")) {
                this._prefixDefault = null;
            } else {
                if (str.endsWith("/*")) {
                    this._prefixMap.remove(str.substring(0, str.length() - 2));
                    this._exactMap.remove(str.substring(0, str.length() - 1));
                    stringMap = this._exactMap;
                    str = str.substring(0, str.length() - 2);
                } else if (str.startsWith(CertificatePinner.WILDCARD)) {
                    stringMap = this._suffixMap;
                    str = str.substring(2);
                } else if (str.equals("/")) {
                    this._default = null;
                    this._defaultSingletonList = null;
                } else {
                    stringMap = this._exactMap;
                }
                stringMap.remove(str);
            }
        }
        return super.remove(obj);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(new HashMap(this));
    }
}
