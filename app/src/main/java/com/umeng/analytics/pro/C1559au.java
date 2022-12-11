package com.umeng.analytics.pro;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.umeng.analytics.pro.au */
/* loaded from: classes4.dex */
public final class C1559au {

    /* renamed from: a */
    public static final Comparator f3140a = new C1561a();

    /* renamed from: com.umeng.analytics.pro.au$a */
    /* loaded from: classes4.dex */
    public static class C1561a implements Comparator {
        public C1561a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? C1559au.m1249a((List) obj, (List) obj2) : obj instanceof Set ? C1559au.m1247a((Set) obj, (Set) obj2) : obj instanceof Map ? C1559au.m1248a((Map) obj, (Map) obj2) : obj instanceof byte[] ? C1559au.m1243a((byte[]) obj, (byte[]) obj2) : C1559au.m1255a((Comparable) obj, (Comparable) obj2);
        }
    }

    /* renamed from: a */
    public static int m1259a(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b2 < b ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1258a(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        return d2 < d ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1257a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1256a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1255a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* renamed from: a */
    public static int m1254a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return m1255a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return m1249a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return m1247a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return m1248a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return m1243a((byte[]) obj, (byte[]) obj2);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot compare objects of type ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    /* renamed from: a */
    public static int m1253a(String str, String str2) {
        return str.compareTo(str2);
    }

    /* renamed from: a */
    public static int m1250a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), bArr, i, remaining);
        return remaining;
    }

    /* renamed from: a */
    public static int m1249a(List list, List list2) {
        int m1257a = m1257a(list.size(), list2.size());
        if (m1257a != 0) {
            return m1257a;
        }
        for (int i = 0; i < list.size(); i++) {
            int compare = f3140a.compare(list.get(i), list2.get(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1248a(Map map, Map map2) {
        int m1257a = m1257a(map.size(), map2.size());
        if (m1257a != 0) {
            return m1257a;
        }
        TreeMap treeMap = new TreeMap(f3140a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f3140a);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compare = f3140a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = f3140a.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1247a(Set set, Set set2) {
        int m1257a = m1257a(set.size(), set2.size());
        if (m1257a != 0) {
            return m1257a;
        }
        TreeSet treeSet = new TreeSet(f3140a);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f3140a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f3140a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1246a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    /* renamed from: a */
    public static int m1245a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public static int m1243a(byte[] bArr, byte[] bArr2) {
        int m1257a = m1257a(bArr.length, bArr2.length);
        if (m1257a != 0) {
            return m1257a;
        }
        for (int i = 0; i < bArr.length; i++) {
            int m1259a = m1259a(bArr[i], bArr2[i]);
            if (m1259a != 0) {
                return m1259a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static String m1260a(byte b) {
        return Integer.toHexString((b | 256) & 511).toUpperCase().substring(1);
    }

    /* renamed from: a */
    public static void m1251a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = byteBuffer.position() + arrayOffset;
        int limit = byteBuffer.limit() + arrayOffset;
        int i = limit - position > 128 ? position + 128 : limit;
        for (int i2 = position; i2 < i; i2++) {
            if (i2 > position) {
                sb.append(StringUtils.SPACE);
            }
            sb.append(m1260a(array[i2]));
        }
        if (limit != i) {
            sb.append("...");
        }
    }

    /* renamed from: a */
    public static byte[] m1252a(ByteBuffer byteBuffer) {
        if (m1242b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        m1250a(byteBuffer, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m1244a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* renamed from: b */
    public static boolean m1242b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: c */
    public static ByteBuffer m1241c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        return m1242b(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m1252a(byteBuffer));
    }

    /* renamed from: d */
    public static ByteBuffer m1240d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(new byte[byteBuffer.remaining()]);
        if (byteBuffer.hasArray()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), wrap.array(), 0, byteBuffer.remaining());
        } else {
            byteBuffer.slice().get(wrap.array());
        }
        return wrap;
    }
}
