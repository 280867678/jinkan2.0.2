package org.seamless.http;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.message.TokenParser;

/* loaded from: classes5.dex */
public class Headers implements Map<String, List<String>> {

    /* renamed from: CR */
    public static final byte f4757CR = 13;

    /* renamed from: LF */
    public static final byte f4758LF = 10;
    public final Map<String, List<String>> map;
    public boolean normalizeHeaders;

    public Headers() {
        this.map = new HashMap(32);
        this.normalizeHeaders = true;
    }

    public Headers(ByteArrayInputStream byteArrayInputStream) {
        this.map = new HashMap(32);
        this.normalizeHeaders = true;
        StringBuilder sb = new StringBuilder(256);
        Headers headers = new Headers();
        String readLine = readLine(sb, byteArrayInputStream);
        if (readLine.length() == 0) {
            putAll(headers);
        }
        String str = null;
        do {
            char charAt = readLine.charAt(0);
            if (str == null || !(charAt == ' ' || charAt == '\t')) {
                String[] splitHeader = splitHeader(readLine);
                headers.add(splitHeader[0], splitHeader[1]);
                str = splitHeader[0];
            } else {
                List<String> list = headers.get((Object) str);
                int size = list.size() - 1;
                list.set(size, list.get(size) + readLine.trim());
            }
            sb.delete(0, sb.length());
            readLine = readLine(sb, byteArrayInputStream);
        } while (readLine.length() != 0);
        putAll(headers);
    }

    public Headers(Map<String, List<String>> map) {
        this.map = new HashMap(32);
        this.normalizeHeaders = true;
        putAll(map);
    }

    public Headers(boolean z) {
        this.map = new HashMap(32);
        this.normalizeHeaders = true;
        this.normalizeHeaders = z;
    }

    private String normalize(String str) {
        if (this.normalizeHeaders) {
            if (str == null) {
                return null;
            }
            if (str.length() == 0) {
                return str;
            }
            char[] charArray = str.toCharArray();
            if (charArray[0] >= 'a' && charArray[0] <= 'z') {
                charArray[0] = (char) (charArray[0] - ' ');
            }
            int length = str.length();
            for (int i = 1; i < length; i++) {
                if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                    charArray[i] = (char) (charArray[i] + TokenParser.f4579SP);
                }
            }
            return new String(charArray);
        }
        return str;
    }

    public static String readLine(ByteArrayInputStream byteArrayInputStream) {
        return readLine(new StringBuilder(256), byteArrayInputStream);
    }

    public static String readLine(StringBuilder sb, ByteArrayInputStream byteArrayInputStream) {
        while (true) {
            int read = byteArrayInputStream.read();
            if (read == -1) {
                break;
            }
            char c = (char) read;
            if (c == '\r') {
                if (((char) byteArrayInputStream.read()) == '\n') {
                    break;
                }
                sb.append(c);
            } else if (c == '\n') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void add(String str, String str2) {
        String normalize = normalize(str);
        List<String> list = this.map.get(normalize);
        if (list == null) {
            list = new LinkedList<>();
            this.map.put(normalize, list);
        }
        list.add(str2);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return obj != null && (obj instanceof String) && this.map.containsKey(normalize((String) obj));
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, List<String>>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    public int findNonWhitespace(String str, int i) {
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    @Override // java.util.Map
    public List<String> get(Object obj) {
        return this.map.get(normalize((String) obj));
    }

    public String getFirstHeader(String str) {
        List<String> list = this.map.get(normalize(str));
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.map.keySet();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public List<String> put(String str, List<String> list) {
        return this.map.put(normalize(str), list);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends List<String>> map) {
        for (Map.Entry<? extends String, ? extends List<String>> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public List<String> remove(Object obj) {
        return this.map.remove(normalize((String) obj));
    }

    public void set(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str2);
        put(str, (List<String>) linkedList);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    public String[] splitHeader(String str) {
        char charAt;
        int findNonWhitespace = findNonWhitespace(str, 0);
        int i = findNonWhitespace;
        while (i < str.length() && (charAt = str.charAt(i)) != ':' && !Character.isWhitespace(charAt)) {
            i++;
        }
        int i2 = i;
        while (i2 < str.length()) {
            char charAt2 = str.charAt(i2);
            i2++;
            if (charAt2 == ':') {
                break;
            }
        }
        int findNonWhitespace2 = findNonWhitespace(str, i2);
        int findEndOfString = findEndOfString(str);
        String[] strArr = new String[2];
        strArr[0] = str.substring(findNonWhitespace, i);
        strArr[1] = (str.length() < findNonWhitespace2 || str.length() < findEndOfString || findNonWhitespace2 >= findEndOfString) ? null : str.substring(findNonWhitespace2, findEndOfString);
        return strArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(512);
        for (Map.Entry<String, List<String>> entry : entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            for (String str : entry.getValue()) {
                sb.append(str);
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    @Override // java.util.Map
    public Collection<List<String>> values() {
        return this.map.values();
    }
}
