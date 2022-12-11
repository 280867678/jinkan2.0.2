package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.proguard.l */
/* loaded from: classes3.dex */
public class C1226l {

    /* renamed from: a */
    public ByteBuffer f1530a;

    /* renamed from: b */
    public String f1531b;

    public C1226l() {
        this(128);
    }

    public C1226l(int i) {
        this.f1531b = "GBK";
        this.f1530a = ByteBuffer.allocate(i);
    }

    /* renamed from: a */
    private void m2892a(Object[] objArr, int i) {
        m2908a(8);
        m2888b((byte) 9, i);
        m2907a(objArr.length, 0);
        for (Object obj : objArr) {
            m2904a(obj, 0);
        }
    }

    /* renamed from: a */
    public int m2903a(String str) {
        this.f1531b = str;
        return 0;
    }

    /* renamed from: a */
    public ByteBuffer m2912a() {
        return this.f1530a;
    }

    /* renamed from: a */
    public void m2911a(byte b, int i) {
        m2908a(3);
        if (b == 0) {
            m2888b((byte) 12, i);
            return;
        }
        m2888b((byte) 0, i);
        this.f1530a.put(b);
    }

    /* renamed from: a */
    public void m2910a(double d, int i) {
        m2908a(10);
        m2888b((byte) 5, i);
        this.f1530a.putDouble(d);
    }

    /* renamed from: a */
    public void m2909a(float f, int i) {
        m2908a(6);
        m2888b((byte) 4, i);
        this.f1530a.putFloat(f);
    }

    /* renamed from: a */
    public void m2908a(int i) {
        if (this.f1530a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f1530a.capacity() + i) * 2);
            allocate.put(this.f1530a.array(), 0, this.f1530a.position());
            this.f1530a = allocate;
        }
    }

    /* renamed from: a */
    public void m2907a(int i, int i2) {
        m2908a(6);
        if (i >= -32768 && i <= 32767) {
            m2899a((short) i, i2);
            return;
        }
        m2888b((byte) 2, i2);
        this.f1530a.putInt(i);
    }

    /* renamed from: a */
    public void m2906a(long j, int i) {
        m2908a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            m2907a((int) j, i);
            return;
        }
        m2888b((byte) 3, i);
        this.f1530a.putLong(j);
    }

    /* renamed from: a */
    public void m2905a(AbstractC1228m abstractC1228m, int i) {
        m2908a(2);
        m2888b((byte) 10, i);
        abstractC1228m.mo2856a(this);
        m2908a(2);
        m2888b((byte) 11, 0);
    }

    /* renamed from: a */
    public void m2904a(Object obj, int i) {
        Object obj2;
        if (obj instanceof Byte) {
            m2911a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            m2898a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            m2899a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            m2907a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            m2906a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            m2909a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            m2910a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            m2902a((String) obj, i);
        } else if (obj instanceof Map) {
            m2900a((Map) obj, i);
        } else {
            if (obj instanceof List) {
                obj2 = (List) obj;
            } else if (obj instanceof AbstractC1228m) {
                m2905a((AbstractC1228m) obj, i);
                return;
            } else if (obj instanceof byte[]) {
                m2897a((byte[]) obj, i);
                return;
            } else if (obj instanceof boolean[]) {
                m2890a((boolean[]) obj, i);
                return;
            } else if (obj instanceof short[]) {
                m2891a((short[]) obj, i);
                return;
            } else if (obj instanceof int[]) {
                m2894a((int[]) obj, i);
                return;
            } else if (obj instanceof long[]) {
                m2893a((long[]) obj, i);
                return;
            } else if (obj instanceof float[]) {
                m2895a((float[]) obj, i);
                return;
            } else if (obj instanceof double[]) {
                m2896a((double[]) obj, i);
                return;
            } else if (obj.getClass().isArray()) {
                m2892a((Object[]) obj, i);
                return;
            } else if (!(obj instanceof Collection)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("write object error: unsupport type. ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
                throw new C1221j(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                obj2 = (Collection) obj;
            }
            m2901a((Collection) obj2, i);
        }
    }

    /* renamed from: a */
    public void m2902a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f1531b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        m2908a(bytes.length + 10);
        if (bytes.length > 255) {
            m2888b((byte) 7, i);
            this.f1530a.putInt(bytes.length);
        } else {
            m2888b((byte) 6, i);
            this.f1530a.put((byte) bytes.length);
        }
        this.f1530a.put(bytes);
    }

    /* renamed from: a */
    public <T> void m2901a(Collection<T> collection, int i) {
        m2908a(8);
        m2888b((byte) 9, i);
        m2907a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t : collection) {
                m2904a(t, 0);
            }
        }
    }

    /* renamed from: a */
    public <K, V> void m2900a(Map<K, V> map, int i) {
        m2908a(8);
        m2888b((byte) 8, i);
        m2907a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                m2904a(entry.getKey(), 0);
                m2904a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    public void m2899a(short s, int i) {
        m2908a(4);
        if (s >= -128 && s <= 127) {
            m2911a((byte) s, i);
            return;
        }
        m2888b((byte) 1, i);
        this.f1530a.putShort(s);
    }

    /* renamed from: a */
    public void m2898a(boolean z, int i) {
        m2911a(z ? (byte) 1 : (byte) 0, i);
    }

    /* renamed from: a */
    public void m2897a(byte[] bArr, int i) {
        m2908a(bArr.length + 8);
        m2888b((byte) 13, i);
        m2888b((byte) 0, 0);
        m2907a(bArr.length, 0);
        this.f1530a.put(bArr);
    }

    /* renamed from: a */
    public void m2896a(double[] dArr, int i) {
        m2908a(8);
        m2888b((byte) 9, i);
        m2907a(dArr.length, 0);
        for (double d : dArr) {
            m2910a(d, 0);
        }
    }

    /* renamed from: a */
    public void m2895a(float[] fArr, int i) {
        m2908a(8);
        m2888b((byte) 9, i);
        m2907a(fArr.length, 0);
        for (float f : fArr) {
            m2909a(f, 0);
        }
    }

    /* renamed from: a */
    public void m2894a(int[] iArr, int i) {
        m2908a(8);
        m2888b((byte) 9, i);
        m2907a(iArr.length, 0);
        for (int i2 : iArr) {
            m2907a(i2, 0);
        }
    }

    /* renamed from: a */
    public void m2893a(long[] jArr, int i) {
        m2908a(8);
        m2888b((byte) 9, i);
        m2907a(jArr.length, 0);
        for (long j : jArr) {
            m2906a(j, 0);
        }
    }

    /* renamed from: a */
    public void m2891a(short[] sArr, int i) {
        m2908a(8);
        m2888b((byte) 9, i);
        m2907a(sArr.length, 0);
        for (short s : sArr) {
            m2899a(s, 0);
        }
    }

    /* renamed from: a */
    public void m2890a(boolean[] zArr, int i) {
        m2908a(8);
        m2888b((byte) 9, i);
        m2907a(zArr.length, 0);
        for (boolean z : zArr) {
            m2898a(z, 0);
        }
    }

    /* renamed from: b */
    public void m2888b(byte b, int i) {
        if (i < 15) {
            this.f1530a.put((byte) (b | (i << 4)));
        } else if (i >= 256) {
            throw new C1221j(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tag is too large: ", i));
        } else {
            this.f1530a.put((byte) (b | 240));
            this.f1530a.put((byte) i);
        }
    }

    /* renamed from: b */
    public byte[] m2889b() {
        byte[] bArr = new byte[this.f1530a.position()];
        System.arraycopy(this.f1530a.array(), 0, bArr, 0, this.f1530a.position());
        return bArr;
    }
}
