package org.seamless.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class MimeType {
    public static final String WILDCARD = "*";
    public Map<String, String> parameters;
    public String subtype;
    public String type;

    public MimeType() {
        this("*", "*");
    }

    public MimeType(String str, String str2) {
        this(str, str2, Collections.EMPTY_MAP);
    }

    public MimeType(String str, String str2, Map<String, String> map) {
        Map<String, String> unmodifiableMap;
        this.type = str == null ? "*" : str;
        this.subtype = str2 == null ? "*" : str2;
        if (map == null) {
            unmodifiableMap = Collections.EMPTY_MAP;
        } else {
            TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: org.seamless.util.MimeType.1
                @Override // java.util.Comparator
                public int compare(String str3, String str4) {
                    return str3.compareToIgnoreCase(str4);
                }
            });
            for (Map.Entry<String, String> entry : map.entrySet()) {
                treeMap.put(entry.getKey(), entry.getValue());
            }
            unmodifiableMap = Collections.unmodifiableMap(treeMap);
        }
        this.parameters = unmodifiableMap;
    }

    public static int getEnd(String str, int i) {
        int indexOf = str.indexOf(61, i);
        int indexOf2 = str.indexOf(59, i);
        return (indexOf == -1 && indexOf2 == -1) ? str.length() : indexOf == -1 ? indexOf2 : (indexOf2 != -1 && indexOf >= indexOf2) ? indexOf2 : indexOf;
    }

    public static int readParamsIntoMap(Map<String, String> map, String str, int i) {
        int end = getEnd(str, i);
        String trim = str.substring(i, end).trim();
        if (end < str.length() && str.charAt(end) == '=') {
            end++;
        }
        StringBuilder sb = new StringBuilder(str.length() - end);
        boolean z = false;
        boolean z2 = false;
        while (end < str.length()) {
            char charAt = str.charAt(end);
            if (charAt != '\"') {
                if (charAt != ';') {
                    if (charAt == '\\') {
                        if (!z) {
                            z = true;
                        }
                        sb.append(charAt);
                        z = false;
                    }
                } else if (!z2) {
                    map.put(trim, sb.toString().trim());
                    return end + 1;
                }
                sb.append(charAt);
            } else {
                if (!z) {
                    z2 = !z2;
                }
                sb.append(charAt);
                z = false;
            }
            end++;
        }
        map.put(trim, sb.toString().trim());
        return end;
    }

    public static MimeType valueOf(String str) throws IllegalArgumentException {
        String str2;
        String str3;
        if (str != null) {
            int indexOf = str.indexOf(";");
            String str4 = null;
            if (indexOf > -1) {
                str2 = str.substring(indexOf + 1).trim();
                str = str.substring(0, indexOf);
            } else {
                str2 = null;
            }
            String[] split = str.split("/");
            if (split.length < 2 && str.equals("*")) {
                str3 = "*";
                str4 = str3;
            } else if (split.length == 2) {
                str4 = split[0].trim();
                str3 = split[1].trim();
            } else if (split.length != 2) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error parsing string: ", str));
            } else {
                str3 = null;
            }
            if (str2 == null || str2.length() <= 0) {
                return new MimeType(str4, str3);
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < str2.length(); i = readParamsIntoMap(hashMap, str2, i)) {
            }
            return new MimeType(str4, str3, hashMap);
        }
        throw new IllegalArgumentException("String value is null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MimeType.class != obj.getClass()) {
            return false;
        }
        MimeType mimeType = (MimeType) obj;
        Map<String, String> map = this.parameters;
        if (map == null ? mimeType.parameters != null : !map.equals(mimeType.parameters)) {
            return false;
        }
        return this.subtype.equalsIgnoreCase(mimeType.subtype) && this.type.equalsIgnoreCase(mimeType.type);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = (this.subtype.toLowerCase().hashCode() + (this.type.toLowerCase().hashCode() * 31)) * 31;
        Map<String, String> map = this.parameters;
        return hashCode + (map != null ? map.hashCode() : 0);
    }

    public boolean isCompatible(MimeType mimeType) {
        if (mimeType == null) {
            return false;
        }
        if (this.type.equals("*") || mimeType.type.equals("*")) {
            return true;
        }
        if (this.type.equalsIgnoreCase(mimeType.type) && (this.subtype.equals("*") || mimeType.subtype.equals("*"))) {
            return true;
        }
        return this.type.equalsIgnoreCase(mimeType.type) && this.subtype.equalsIgnoreCase(mimeType.subtype);
    }

    public boolean isWildcardSubtype() {
        return getSubtype().equals("*");
    }

    public boolean isWildcardType() {
        return getType().equals("*");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toStringNoParameters());
        if (getParameters() != null || getParameters().size() > 0) {
            for (String str : getParameters().keySet()) {
                sb.append(";");
                sb.append(str);
                sb.append("=\"");
                sb.append(getParameters().get(str));
                sb.append("\"");
            }
        }
        return sb.toString();
    }

    public String toStringNoParameters() {
        return getType() + "/" + getSubtype();
    }
}
