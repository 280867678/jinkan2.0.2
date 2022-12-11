package org.eclipse.jetty.util;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class IPAddressMap<TYPE> extends HashMap<String, TYPE> {
    public final HashMap<String, IPAddrPattern> _patterns = new HashMap<>();

    /* loaded from: classes5.dex */
    public static class IPAddrPattern {
        public final OctetPattern[] _octets = new OctetPattern[4];

        public IPAddrPattern(String str) throws IllegalArgumentException {
            if (str == null || str.trim().length() == 0) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid IP address pattern: ", str));
            }
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
                for (int i = 0; i < 4; i++) {
                    String str2 = "0-255";
                    String trim = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken().trim() : str2;
                    int length = trim.length();
                    if (length == 0 && stringTokenizer.hasMoreTokens()) {
                        throw new IllegalArgumentException("Invalid IP address pattern: " + str);
                    }
                    OctetPattern[] octetPatternArr = this._octets;
                    if (length != 0) {
                        str2 = trim;
                    }
                    octetPatternArr[i] = new OctetPattern(str2);
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid IP address pattern: ", str), e);
            }
        }

        public boolean match(String str) throws IllegalArgumentException {
            if (str == null || str.trim().length() == 0) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid IP address: ", str));
            }
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
                boolean z = true;
                for (int i = 0; i < 4; i++) {
                    if (!stringTokenizer.hasMoreTokens()) {
                        throw new IllegalArgumentException("Invalid IP address: " + str);
                    }
                    z &= this._octets[i].match(stringTokenizer.nextToken());
                    if (!z) {
                        break;
                    }
                }
                return z;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid IP address: ", str), e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class OctetPattern extends BitSet {
        public final BitSet _mask = new BitSet(256);

        public OctetPattern(String str) throws IllegalArgumentException {
            if (str != null) {
                try {
                    String trim = str.trim();
                    if (trim.length() == 0) {
                        this._mask.set(0, 255);
                        return;
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(trim, ",");
                    while (stringTokenizer.hasMoreTokens()) {
                        String trim2 = stringTokenizer.nextToken().trim();
                        if (trim2.length() > 0) {
                            if (trim2.indexOf(45) < 0) {
                                this._mask.set(Integer.valueOf(trim2).intValue());
                            } else {
                                String[] split = trim2.split("-", -2);
                                if (split.length != 2) {
                                    throw new IllegalArgumentException("Invalid octet spec: " + str);
                                }
                                int parseInt = split[0].length() > 0 ? Integer.parseInt(split[0]) : 0;
                                int parseInt2 = split[1].length() > 0 ? Integer.parseInt(split[1]) : 255;
                                if (parseInt > parseInt2) {
                                    throw new IllegalArgumentException("Invalid octet spec: " + str);
                                }
                                this._mask.set(parseInt, parseInt2 + 1);
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid octet spec: ", str), e);
                }
            }
        }

        public boolean match(int i) throws IllegalArgumentException {
            if (i < 0 || i > 255) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid octet: ", i));
            }
            return this._mask.get(i);
        }

        public boolean match(String str) throws IllegalArgumentException {
            if (str == null || str.trim().length() == 0) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid octet: ", str));
            }
            try {
                return match(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid octet: ", str));
            }
        }
    }

    public IPAddressMap() {
        super(11);
    }

    public IPAddressMap(int i) {
        super(i);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public TYPE get(Object obj) {
        return (TYPE) super.get(obj);
    }

    public Object getLazyMatches(String str) {
        if (str == null) {
            return LazyList.getList(super.entrySet());
        }
        Object obj = null;
        for (Map.Entry entry : super.entrySet()) {
            if (this._patterns.get(entry.getKey()).match(str)) {
                obj = LazyList.add(obj, entry);
            }
        }
        return obj;
    }

    public Map.Entry<String, TYPE> getMatch(String str) {
        if (str != null) {
            for (Map.Entry<String, TYPE> entry : super.entrySet()) {
                if (this._patterns.get(entry.getKey()).match(str)) {
                    return entry;
                }
            }
            return null;
        }
        return null;
    }

    public TYPE match(String str) {
        Map.Entry<String, TYPE> match = getMatch(str);
        if (match == null) {
            return null;
        }
        return match.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((String) obj, (String) obj2);
    }

    public TYPE put(String str, TYPE type) throws IllegalArgumentException {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid IP address pattern: ", str));
        }
        String trim = str.trim();
        if (this._patterns.get(trim) == null) {
            this._patterns.put(trim, new IPAddrPattern(trim));
        }
        return (TYPE) super.put((IPAddressMap<TYPE>) trim, (String) type);
    }
}
