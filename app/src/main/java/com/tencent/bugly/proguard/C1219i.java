package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.i */
/* loaded from: classes3.dex */
public final class C1219i {

    /* renamed from: a */
    public StringBuilder f1519a;

    /* renamed from: b */
    public int f1520b;

    public C1219i(StringBuilder sb, int i) {
        this.f1520b = 0;
        this.f1519a = sb;
        this.f1520b = i;
    }

    /* renamed from: a */
    private void m2959a(String str) {
        for (int i = 0; i < this.f1520b; i++) {
            this.f1519a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f1519a;
            sb.append(str);
            sb.append(": ");
        }
    }

    /* renamed from: a */
    public C1219i m2967a(byte b, String str) {
        m2959a(str);
        StringBuilder sb = this.f1519a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C1219i m2966a(char c, String str) {
        m2959a(str);
        StringBuilder sb = this.f1519a;
        sb.append(c);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C1219i m2965a(double d, String str) {
        m2959a(str);
        StringBuilder sb = this.f1519a;
        sb.append(d);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C1219i m2964a(float f, String str) {
        m2959a(str);
        StringBuilder sb = this.f1519a;
        sb.append(f);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C1219i m2963a(int i, String str) {
        m2959a(str);
        StringBuilder sb = this.f1519a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C1219i m2962a(long j, String str) {
        m2959a(str);
        StringBuilder sb = this.f1519a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C1219i m2961a(AbstractC1228m abstractC1228m, String str) {
        m2966a('{', str);
        if (abstractC1228m == null) {
            StringBuilder sb = this.f1519a;
            sb.append('\t');
            sb.append("null");
        } else {
            abstractC1228m.mo2855a(this.f1519a, this.f1520b + 1);
        }
        m2966a('}', (String) null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> C1219i m2960a(T t, String str) {
        if (t == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
        } else if (t instanceof Byte) {
            m2967a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            m2954a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            m2955a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            m2963a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            m2962a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            m2964a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            m2965a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            m2958a((String) t, str);
        } else if (t instanceof Map) {
            m2956a((Map) t, str);
        } else if (t instanceof List) {
            m2957a((Collection) ((List) t), str);
        } else if (t instanceof AbstractC1228m) {
            m2961a((AbstractC1228m) t, str);
        } else if (t instanceof byte[]) {
            m2953a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            m2960a((C1219i) ((boolean[]) t), str);
        } else if (t instanceof short[]) {
            m2947a((short[]) t, str);
        } else if (t instanceof int[]) {
            m2950a((int[]) t, str);
        } else if (t instanceof long[]) {
            m2949a((long[]) t, str);
        } else if (t instanceof float[]) {
            m2951a((float[]) t, str);
        } else if (t instanceof double[]) {
            m2952a((double[]) t, str);
        } else if (!t.getClass().isArray()) {
            throw new C1221j("write object error: unsupport type.");
        } else {
            m2948a((Object[]) t, str);
        }
        return this;
    }

    /* renamed from: a */
    public C1219i m2958a(String str, String str2) {
        m2959a(str2);
        if (str == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
        } else {
            StringBuilder sb2 = this.f1519a;
            sb2.append(str);
            sb2.append('\n');
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> C1219i m2957a(Collection<T> collection, String str) {
        if (collection == null) {
            m2959a(str);
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\t');
            return this;
        }
        return m2948a(collection.toArray(), str);
    }

    /* renamed from: a */
    public <K, V> C1219i m2956a(Map<K, V> map, String str) {
        m2959a(str);
        if (map == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb2 = this.f1519a;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f1519a;
            sb3.append(map.size());
            sb3.append(", {");
            sb3.append('\n');
            C1219i c1219i = new C1219i(this.f1519a, this.f1520b + 1);
            C1219i c1219i2 = new C1219i(this.f1519a, this.f1520b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                c1219i.m2966a('(', (String) null);
                c1219i2.m2960a((C1219i) entry.getKey(), (String) null);
                c1219i2.m2960a((C1219i) entry.getValue(), (String) null);
                c1219i.m2966a(')', (String) null);
            }
            m2966a('}', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C1219i m2955a(short s, String str) {
        m2959a(str);
        StringBuilder sb = this.f1519a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C1219i m2954a(boolean z, String str) {
        m2959a(str);
        StringBuilder sb = this.f1519a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C1219i m2953a(byte[] bArr, String str) {
        m2959a(str);
        if (bArr == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb2 = this.f1519a;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f1519a;
            sb3.append(bArr.length);
            sb3.append(", [");
            sb3.append('\n');
            C1219i c1219i = new C1219i(this.f1519a, this.f1520b + 1);
            for (byte b : bArr) {
                c1219i.m2967a(b, (String) null);
            }
            m2966a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C1219i m2952a(double[] dArr, String str) {
        m2959a(str);
        if (dArr == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb2 = this.f1519a;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f1519a;
            sb3.append(dArr.length);
            sb3.append(", [");
            sb3.append('\n');
            C1219i c1219i = new C1219i(this.f1519a, this.f1520b + 1);
            for (double d : dArr) {
                c1219i.m2965a(d, (String) null);
            }
            m2966a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C1219i m2951a(float[] fArr, String str) {
        m2959a(str);
        if (fArr == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb2 = this.f1519a;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f1519a;
            sb3.append(fArr.length);
            sb3.append(", [");
            sb3.append('\n');
            C1219i c1219i = new C1219i(this.f1519a, this.f1520b + 1);
            for (float f : fArr) {
                c1219i.m2964a(f, (String) null);
            }
            m2966a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C1219i m2950a(int[] iArr, String str) {
        m2959a(str);
        if (iArr == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb2 = this.f1519a;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f1519a;
            sb3.append(iArr.length);
            sb3.append(", [");
            sb3.append('\n');
            C1219i c1219i = new C1219i(this.f1519a, this.f1520b + 1);
            for (int i : iArr) {
                c1219i.m2963a(i, (String) null);
            }
            m2966a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C1219i m2949a(long[] jArr, String str) {
        m2959a(str);
        if (jArr == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb2 = this.f1519a;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f1519a;
            sb3.append(jArr.length);
            sb3.append(", [");
            sb3.append('\n');
            C1219i c1219i = new C1219i(this.f1519a, this.f1520b + 1);
            for (long j : jArr) {
                c1219i.m2962a(j, (String) null);
            }
            m2966a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public <T> C1219i m2948a(T[] tArr, String str) {
        m2959a(str);
        if (tArr == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb2 = this.f1519a;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f1519a;
            sb3.append(tArr.length);
            sb3.append(", [");
            sb3.append('\n');
            C1219i c1219i = new C1219i(this.f1519a, this.f1520b + 1);
            for (T t : tArr) {
                c1219i.m2960a((C1219i) t, (String) null);
            }
            m2966a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public C1219i m2947a(short[] sArr, String str) {
        m2959a(str);
        if (sArr == null) {
            StringBuilder sb = this.f1519a;
            sb.append("null");
            sb.append('\n');
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb2 = this.f1519a;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        } else {
            StringBuilder sb3 = this.f1519a;
            sb3.append(sArr.length);
            sb3.append(", [");
            sb3.append('\n');
            C1219i c1219i = new C1219i(this.f1519a, this.f1520b + 1);
            for (short s : sArr) {
                c1219i.m2955a(s, (String) null);
            }
            m2966a(']', (String) null);
            return this;
        }
    }
}
