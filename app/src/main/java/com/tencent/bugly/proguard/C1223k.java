package com.tencent.bugly.proguard;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.proguard.k */
/* loaded from: classes3.dex */
public final class C1223k {

    /* renamed from: a */
    public ByteBuffer f1521a;

    /* renamed from: b */
    public String f1522b = "GBK";

    /* renamed from: com.tencent.bugly.proguard.k$a */
    /* loaded from: classes3.dex */
    public static class C1224a {

        /* renamed from: a */
        public byte f1523a;

        /* renamed from: b */
        public int f1524b;
    }

    public C1223k() {
    }

    public C1223k(byte[] bArr) {
        this.f1521a = ByteBuffer.wrap(bArr);
    }

    public C1223k(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f1521a = wrap;
        wrap.position(i);
    }

    /* renamed from: a */
    public static int m2934a(C1224a c1224a, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c1224a.f1523a = (byte) (b & 15);
        int i = (b & 240) >> 4;
        c1224a.f1524b = i;
        if (i == 15) {
            c1224a.f1524b = byteBuffer.get();
            return 2;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <K, V> Map<K, V> m2928a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (m2939a(i)) {
            if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 8) {
                throw new C1217h("type mismatch.");
            }
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            for (int i2 = 0; i2 < m2938a; i2++) {
                map.put(m2932a((C1223k) key, 0, true), m2932a((C1223k) value, 1, true));
            }
        } else if (z) {
            throw new C1217h("require field not exist.");
        }
        return map;
    }

    /* renamed from: a */
    private void m2943a(byte b) {
        int i;
        int i2 = 0;
        switch (b) {
            case 0:
                m2915b(1);
                return;
            case 1:
                m2915b(2);
                return;
            case 2:
            case 4:
                m2915b(4);
                return;
            case 3:
            case 5:
                m2915b(8);
                return;
            case 6:
                i = this.f1521a.get();
                if (i < 0) {
                    i += 256;
                    break;
                }
                break;
            case 7:
                i = this.f1521a.getInt();
                break;
            case 8:
                int m2938a = m2938a(0, 0, true);
                while (i2 < m2938a * 2) {
                    m2916b();
                    i2++;
                }
                return;
            case 9:
                int m2938a2 = m2938a(0, 0, true);
                while (i2 < m2938a2) {
                    m2916b();
                    i2++;
                }
                return;
            case 10:
                m2944a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                C1224a Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.f1523a != 0) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skipField with invalid type, type value: ", b, ", ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.f1523a);
                    throw new C1217h(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                i = m2938a(0, 0, true);
                break;
            default:
                throw new C1217h("invalid type.");
        }
        m2915b(i);
    }

    /* renamed from: b */
    private int m2914b(C1224a c1224a) {
        return m2934a(c1224a, this.f1521a.duplicate());
    }

    /* renamed from: b */
    private void m2916b() {
        m2943a(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a);
    }

    /* renamed from: b */
    private void m2915b(int i) {
        ByteBuffer byteBuffer = this.f1521a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private <T> T[] m2913b(T t, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        } else if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 9) {
            throw new C1217h("type mismatch.");
        } else {
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), m2938a));
            for (int i2 = 0; i2 < m2938a; i2++) {
                tArr[i2] = m2932a((C1223k) t, 0, true);
            }
            return tArr;
        }
    }

    /* renamed from: a */
    public byte m2942a(byte b, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return b;
        }
        byte b2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a;
        if (b2 == 0) {
            return this.f1521a.get();
        }
        if (b2 != 12) {
            throw new C1217h("type mismatch.");
        }
        return (byte) 0;
    }

    /* renamed from: a */
    public double m2941a(double d, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return d;
        }
        byte b = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a;
        if (b == 4) {
            return this.f1521a.getFloat();
        }
        if (b == 5) {
            return this.f1521a.getDouble();
        }
        if (b != 12) {
            throw new C1217h("type mismatch.");
        }
        return RoundRectDrawableWithShadow.COS_45;
    }

    /* renamed from: a */
    public float m2940a(float f, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return f;
        }
        byte b = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a;
        if (b == 4) {
            return this.f1521a.getFloat();
        }
        if (b != 12) {
            throw new C1217h("type mismatch.");
        }
        return 0.0f;
    }

    /* renamed from: a */
    public int m2938a(int i, int i2, boolean z) {
        if (!m2939a(i2)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return i;
        }
        byte b = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a;
        if (b == 0) {
            return this.f1521a.get();
        }
        if (b == 1) {
            return this.f1521a.getShort();
        }
        if (b == 2) {
            return this.f1521a.getInt();
        }
        if (b != 12) {
            throw new C1217h("type mismatch.");
        }
        return 0;
    }

    /* renamed from: a */
    public int m2931a(String str) {
        this.f1522b = str;
        return 0;
    }

    /* renamed from: a */
    public long m2936a(long j, int i, boolean z) {
        int i2;
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return j;
        }
        byte b = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a;
        if (b == 12) {
            return 0L;
        }
        if (b == 0) {
            i2 = this.f1521a.get();
        } else if (b == 1) {
            i2 = this.f1521a.getShort();
        } else if (b != 2) {
            if (b != 3) {
                throw new C1217h("type mismatch.");
            }
            return this.f1521a.getLong();
        } else {
            i2 = this.f1521a.getInt();
        }
        return i2;
    }

    /* renamed from: a */
    public AbstractC1228m m2933a(AbstractC1228m abstractC1228m, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC1228m abstractC1228m2 = (AbstractC1228m) abstractC1228m.getClass().newInstance();
            if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 10) {
                throw new C1217h("type mismatch.");
            }
            abstractC1228m2.mo2857a(this);
            m2944a();
            return abstractC1228m2;
        } catch (Exception e) {
            throw new C1217h(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> Object m2932a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(m2942a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(m2926a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(m2927a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(m2938a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(m2936a(0L, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(m2940a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(m2941a((double) RoundRectDrawableWithShadow.COS_45, i, z));
        }
        if (t instanceof String) {
            return String.valueOf(m2937a(i, z));
        }
        if (t instanceof Map) {
            return m2929a((Map) t, i, z);
        }
        if (t instanceof List) {
            return m2930a((List) t, i, z);
        }
        if (t instanceof AbstractC1228m) {
            return m2933a((AbstractC1228m) t, i, z);
        }
        if (!t.getClass().isArray()) {
            throw new C1217h("read object error: unsupport type.");
        }
        return ((t instanceof byte[]) || (t instanceof Byte[])) ? m2924a((byte[]) null, i, z) : t instanceof boolean[] ? m2917a((boolean[]) null, i, z) : t instanceof short[] ? m2918a((short[]) null, i, z) : t instanceof int[] ? m2921a((int[]) null, i, z) : t instanceof long[] ? m2920a((long[]) null, i, z) : t instanceof float[] ? m2922a((float[]) null, i, z) : t instanceof double[] ? m2923a((double[]) null, i, z) : m2919a((Object[]) t, i, z);
    }

    /* renamed from: a */
    public String m2937a(int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        }
        byte b = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a;
        if (b == 6) {
            int i2 = this.f1521a.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.f1521a.get(bArr);
            try {
                return new String(bArr, this.f1522b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        } else if (b != 7) {
            throw new C1217h("type mismatch.");
        } else {
            int i3 = this.f1521a.getInt();
            if (i3 > 104857600 || i3 < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("String too long: ", i3));
            }
            byte[] bArr2 = new byte[i3];
            this.f1521a.get(bArr2);
            try {
                return new String(bArr2, this.f1522b);
            } catch (UnsupportedEncodingException unused2) {
                return new String(bArr2);
            }
        }
    }

    /* renamed from: a */
    public <K, V> HashMap<K, V> m2929a(Map<K, V> map, int i, boolean z) {
        return (HashMap) m2928a(new HashMap(), map, i, z);
    }

    /* renamed from: a */
    public <T> List<T> m2930a(List<T> list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] m2913b = m2913b(list.get(0), i, z);
        if (m2913b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : m2913b) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* renamed from: a */
    public short m2927a(short s, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return s;
        }
        byte b = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a;
        if (b == 0) {
            return this.f1521a.get();
        }
        if (b == 1) {
            return this.f1521a.getShort();
        }
        if (b != 12) {
            throw new C1217h("type mismatch.");
        }
        return (short) 0;
    }

    /* renamed from: a */
    public void m2944a() {
        C1224a c1224a = new C1224a();
        do {
            m2935a(c1224a);
            m2943a(c1224a.f1523a);
        } while (c1224a.f1523a != 11);
    }

    /* renamed from: a */
    public void m2935a(C1224a c1224a) {
        m2934a(c1224a, this.f1521a);
    }

    /* renamed from: a */
    public void m2925a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f1521a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f1521a = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    public boolean m2939a(int i) {
        try {
            C1224a c1224a = new C1224a();
            while (true) {
                int m2914b = m2914b(c1224a);
                if (i <= c1224a.f1524b || c1224a.f1523a == 11) {
                    break;
                }
                m2915b(m2914b);
                m2943a(c1224a.f1523a);
            }
            return i == c1224a.f1524b;
        } catch (C1217h | BufferUnderflowException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m2926a(boolean z, int i, boolean z2) {
        return m2942a((byte) 0, i, z2) != 0;
    }

    /* renamed from: a */
    public byte[] m2924a(byte[] bArr, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        }
        C1224a Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        byte b = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.f1523a;
        if (b == 9) {
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            byte[] bArr2 = new byte[m2938a];
            for (int i2 = 0; i2 < m2938a; i2++) {
                bArr2[i2] = m2942a(bArr2[0], 0, true);
            }
            return bArr2;
        } else if (b != 13) {
            throw new C1217h("type mismatch.");
        } else {
            C1224a Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.f1523a != 0) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("type mismatch, tag: ", i, ", type: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.f1523a);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.f1523a);
                throw new C1217h(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            int m2938a2 = m2938a(0, 0, true);
            if (m2938a2 >= 0) {
                byte[] bArr3 = new byte[m2938a2];
                this.f1521a.get(bArr3);
                return bArr3;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("invalid size, tag: ", i, ", type: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.f1523a);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.f1523a);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", size: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(m2938a2);
            throw new C1217h(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }

    /* renamed from: a */
    public double[] m2923a(double[] dArr, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        } else if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 9) {
            throw new C1217h("type mismatch.");
        } else {
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            double[] dArr2 = new double[m2938a];
            for (int i2 = 0; i2 < m2938a; i2++) {
                dArr2[i2] = m2941a(dArr2[0], 0, true);
            }
            return dArr2;
        }
    }

    /* renamed from: a */
    public float[] m2922a(float[] fArr, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        } else if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 9) {
            throw new C1217h("type mismatch.");
        } else {
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            float[] fArr2 = new float[m2938a];
            for (int i2 = 0; i2 < m2938a; i2++) {
                fArr2[i2] = m2940a(fArr2[0], 0, true);
            }
            return fArr2;
        }
    }

    /* renamed from: a */
    public int[] m2921a(int[] iArr, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        } else if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 9) {
            throw new C1217h("type mismatch.");
        } else {
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            int[] iArr2 = new int[m2938a];
            for (int i2 = 0; i2 < m2938a; i2++) {
                iArr2[i2] = m2938a(iArr2[0], 0, true);
            }
            return iArr2;
        }
    }

    /* renamed from: a */
    public long[] m2920a(long[] jArr, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        } else if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 9) {
            throw new C1217h("type mismatch.");
        } else {
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            long[] jArr2 = new long[m2938a];
            for (int i2 = 0; i2 < m2938a; i2++) {
                jArr2[i2] = m2936a(jArr2[0], 0, true);
            }
            return jArr2;
        }
    }

    /* renamed from: a */
    public <T> T[] m2919a(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new C1217h("unable to get type of key and value.");
        }
        return (T[]) m2913b(tArr[0], i, z);
    }

    /* renamed from: a */
    public short[] m2918a(short[] sArr, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        } else if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 9) {
            throw new C1217h("type mismatch.");
        } else {
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            short[] sArr2 = new short[m2938a];
            for (int i2 = 0; i2 < m2938a; i2++) {
                sArr2[i2] = m2927a(sArr2[0], 0, true);
            }
            return sArr2;
        }
    }

    /* renamed from: a */
    public boolean[] m2917a(boolean[] zArr, int i, boolean z) {
        if (!m2939a(i)) {
            if (z) {
                throw new C1217h("require field not exist.");
            }
            return null;
        } else if (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this).f1523a != 9) {
            throw new C1217h("type mismatch.");
        } else {
            int m2938a = m2938a(0, 0, true);
            if (m2938a < 0) {
                throw new C1217h(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size invalid: ", m2938a));
            }
            boolean[] zArr2 = new boolean[m2938a];
            for (int i2 = 0; i2 < m2938a; i2++) {
                zArr2[i2] = m2926a(zArr2[0], 0, true);
            }
            return zArr2;
        }
    }
}
