package com.tencent.smtt.utils;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;
import me.tvspark.outline;
import org.apache.commons.p056io.input.Tailer;

/* renamed from: com.tencent.smtt.utils.e */
/* loaded from: classes4.dex */
public class C1443e implements Closeable {

    /* renamed from: a */
    public static final char[] f2426a = {127, 'E', 'L', 'F', 0};

    /* renamed from: b */
    public final char[] f2427b = new char[16];

    /* renamed from: c */
    public boolean f2428c;

    /* renamed from: d */
    public AbstractC1453j[] f2429d;

    /* renamed from: e */
    public AbstractC1455l[] f2430e;

    /* renamed from: f */
    public byte[] f2431f;

    /* renamed from: g */
    public final C1435c f2432g;

    /* renamed from: h */
    public final AbstractC1444a f2433h;

    /* renamed from: i */
    public final AbstractC1454k[] f2434i;

    /* renamed from: j */
    public byte[] f2435j;

    /* renamed from: com.tencent.smtt.utils.e$a */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1444a {

        /* renamed from: a */
        public short f2436a;

        /* renamed from: b */
        public short f2437b;

        /* renamed from: c */
        public int f2438c;

        /* renamed from: d */
        public int f2439d;

        /* renamed from: e */
        public short f2440e;

        /* renamed from: f */
        public short f2441f;

        /* renamed from: g */
        public short f2442g;

        /* renamed from: h */
        public short f2443h;

        /* renamed from: i */
        public short f2444i;

        /* renamed from: j */
        public short f2445j;

        /* renamed from: a */
        public abstract long mo2079a();

        /* renamed from: b */
        public abstract long mo2078b();
    }

    /* renamed from: com.tencent.smtt.utils.e$b */
    /* loaded from: classes4.dex */
    public static class C1445b extends AbstractC1444a {

        /* renamed from: k */
        public int f2446k;

        /* renamed from: l */
        public int f2447l;

        /* renamed from: m */
        public int f2448m;

        @Override // com.tencent.smtt.utils.C1443e.AbstractC1444a
        /* renamed from: a */
        public long mo2079a() {
            return this.f2448m;
        }

        @Override // com.tencent.smtt.utils.C1443e.AbstractC1444a
        /* renamed from: b */
        public long mo2078b() {
            return this.f2447l;
        }
    }

    /* renamed from: com.tencent.smtt.utils.e$c */
    /* loaded from: classes4.dex */
    public static class C1446c extends AbstractC1453j {

        /* renamed from: a */
        public int f2449a;

        /* renamed from: b */
        public int f2450b;

        /* renamed from: c */
        public int f2451c;

        /* renamed from: d */
        public int f2452d;

        /* renamed from: e */
        public int f2453e;

        /* renamed from: f */
        public int f2454f;
    }

    /* renamed from: com.tencent.smtt.utils.e$d */
    /* loaded from: classes4.dex */
    public static class C1447d extends AbstractC1454k {

        /* renamed from: a */
        public int f2455a;

        /* renamed from: b */
        public int f2456b;

        /* renamed from: c */
        public int f2457c;

        /* renamed from: d */
        public int f2458d;

        /* renamed from: e */
        public int f2459e;

        /* renamed from: f */
        public int f2460f;

        @Override // com.tencent.smtt.utils.C1443e.AbstractC1454k
        /* renamed from: a */
        public int mo2077a() {
            return this.f2458d;
        }

        @Override // com.tencent.smtt.utils.C1443e.AbstractC1454k
        /* renamed from: b */
        public long mo2076b() {
            return this.f2457c;
        }
    }

    /* renamed from: com.tencent.smtt.utils.e$e */
    /* loaded from: classes4.dex */
    public static class C1448e extends AbstractC1455l {

        /* renamed from: a */
        public int f2461a;

        /* renamed from: b */
        public int f2462b;
    }

    /* renamed from: com.tencent.smtt.utils.e$f */
    /* loaded from: classes4.dex */
    public static class C1449f extends AbstractC1444a {

        /* renamed from: k */
        public long f2463k;

        /* renamed from: l */
        public long f2464l;

        /* renamed from: m */
        public long f2465m;

        @Override // com.tencent.smtt.utils.C1443e.AbstractC1444a
        /* renamed from: a */
        public long mo2079a() {
            return this.f2465m;
        }

        @Override // com.tencent.smtt.utils.C1443e.AbstractC1444a
        /* renamed from: b */
        public long mo2078b() {
            return this.f2464l;
        }
    }

    /* renamed from: com.tencent.smtt.utils.e$g */
    /* loaded from: classes4.dex */
    public static class C1450g extends AbstractC1453j {

        /* renamed from: a */
        public long f2466a;

        /* renamed from: b */
        public long f2467b;

        /* renamed from: c */
        public long f2468c;

        /* renamed from: d */
        public long f2469d;

        /* renamed from: e */
        public long f2470e;

        /* renamed from: f */
        public long f2471f;
    }

    /* renamed from: com.tencent.smtt.utils.e$h */
    /* loaded from: classes4.dex */
    public static class C1451h extends AbstractC1454k {

        /* renamed from: a */
        public long f2472a;

        /* renamed from: b */
        public long f2473b;

        /* renamed from: c */
        public long f2474c;

        /* renamed from: d */
        public long f2475d;

        /* renamed from: e */
        public long f2476e;

        /* renamed from: f */
        public long f2477f;

        @Override // com.tencent.smtt.utils.C1443e.AbstractC1454k
        /* renamed from: a */
        public int mo2077a() {
            return (int) this.f2475d;
        }

        @Override // com.tencent.smtt.utils.C1443e.AbstractC1454k
        /* renamed from: b */
        public long mo2076b() {
            return this.f2474c;
        }
    }

    /* renamed from: com.tencent.smtt.utils.e$i */
    /* loaded from: classes4.dex */
    public static class C1452i extends AbstractC1455l {

        /* renamed from: a */
        public long f2478a;

        /* renamed from: b */
        public long f2479b;
    }

    /* renamed from: com.tencent.smtt.utils.e$j */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1453j {

        /* renamed from: g */
        public int f2480g;

        /* renamed from: h */
        public int f2481h;
    }

    /* renamed from: com.tencent.smtt.utils.e$k */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1454k {

        /* renamed from: g */
        public int f2482g;

        /* renamed from: h */
        public int f2483h;

        /* renamed from: i */
        public int f2484i;

        /* renamed from: j */
        public int f2485j;

        /* renamed from: a */
        public abstract int mo2077a();

        /* renamed from: b */
        public abstract long mo2076b();
    }

    /* renamed from: com.tencent.smtt.utils.e$l */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1455l {

        /* renamed from: c */
        public int f2486c;

        /* renamed from: d */
        public char f2487d;

        /* renamed from: e */
        public char f2488e;

        /* renamed from: f */
        public short f2489f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1443e(File file) throws IOException, UnknownFormatConversionException {
        C1445b c1445b;
        C1435c c1435c = new C1435c(file);
        this.f2432g = c1435c;
        c1435c.m2101a(this.f2427b);
        if (m2090a()) {
            c1435c.m2103a(m2082e());
            boolean m2083d = m2083d();
            if (m2083d) {
                C1449f c1449f = new C1449f();
                c1449f.f2436a = c1435c.m2105a();
                c1449f.f2437b = c1435c.m2105a();
                c1449f.f2438c = c1435c.m2100b();
                c1449f.f2463k = c1435c.m2099c();
                c1449f.f2464l = c1435c.m2099c();
                c1449f.f2465m = c1435c.m2099c();
                c1445b = c1449f;
            } else {
                C1445b c1445b2 = new C1445b();
                c1445b2.f2436a = c1435c.m2105a();
                c1445b2.f2437b = c1435c.m2105a();
                c1445b2.f2438c = c1435c.m2100b();
                c1445b2.f2446k = c1435c.m2100b();
                c1445b2.f2447l = c1435c.m2100b();
                c1445b2.f2448m = c1435c.m2100b();
                c1445b = c1445b2;
            }
            this.f2433h = c1445b;
            AbstractC1444a abstractC1444a = this.f2433h;
            abstractC1444a.f2439d = c1435c.m2100b();
            abstractC1444a.f2440e = c1435c.m2105a();
            abstractC1444a.f2441f = c1435c.m2105a();
            abstractC1444a.f2442g = c1435c.m2105a();
            abstractC1444a.f2443h = c1435c.m2105a();
            abstractC1444a.f2444i = c1435c.m2105a();
            abstractC1444a.f2445j = c1435c.m2105a();
            this.f2434i = new AbstractC1454k[abstractC1444a.f2444i];
            for (int i = 0; i < abstractC1444a.f2444i; i++) {
                c1435c.m2104a(abstractC1444a.mo2079a() + (abstractC1444a.f2443h * i));
                if (m2083d) {
                    C1451h c1451h = new C1451h();
                    c1451h.f2482g = c1435c.m2100b();
                    c1451h.f2483h = c1435c.m2100b();
                    c1451h.f2472a = c1435c.m2099c();
                    c1451h.f2473b = c1435c.m2099c();
                    c1451h.f2474c = c1435c.m2099c();
                    c1451h.f2475d = c1435c.m2099c();
                    c1451h.f2484i = c1435c.m2100b();
                    c1451h.f2485j = c1435c.m2100b();
                    c1451h.f2476e = c1435c.m2099c();
                    c1451h.f2477f = c1435c.m2099c();
                    this.f2434i[i] = c1451h;
                } else {
                    C1447d c1447d = new C1447d();
                    c1447d.f2482g = c1435c.m2100b();
                    c1447d.f2483h = c1435c.m2100b();
                    c1447d.f2455a = c1435c.m2100b();
                    c1447d.f2456b = c1435c.m2100b();
                    c1447d.f2457c = c1435c.m2100b();
                    c1447d.f2458d = c1435c.m2100b();
                    c1447d.f2484i = c1435c.m2100b();
                    c1447d.f2485j = c1435c.m2100b();
                    c1447d.f2459e = c1435c.m2100b();
                    c1447d.f2460f = c1435c.m2100b();
                    this.f2434i[i] = c1447d;
                }
            }
            short s = abstractC1444a.f2445j;
            if (s > -1) {
                AbstractC1454k[] abstractC1454kArr = this.f2434i;
                if (s < abstractC1454kArr.length) {
                    AbstractC1454k abstractC1454k = abstractC1454kArr[s];
                    if (abstractC1454k.f2483h != 3) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Wrong string section e_shstrndx=");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((int) abstractC1444a.f2445j);
                        throw new UnknownFormatConversionException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                    this.f2435j = new byte[abstractC1454k.mo2077a()];
                    c1435c.m2104a(abstractC1454k.mo2076b());
                    c1435c.m2102a(this.f2435j);
                    if (!this.f2428c) {
                        return;
                    }
                    m2081f();
                    return;
                }
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid e_shstrndx=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((int) abstractC1444a.f2445j);
            throw new UnknownFormatConversionException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        throw new UnknownFormatConversionException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid elf magic: ", file));
    }

    /* renamed from: a */
    public static boolean m2088a(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, Tailer.RAF_MODE);
            long readInt = randomAccessFile.readInt();
            randomAccessFile.close();
            return readInt == 2135247942;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m2085b(File file) {
        StringBuilder sb;
        String str;
        if (!m2080g() || !m2088a(file)) {
            return true;
        }
        try {
            new C1443e(file);
            return true;
        } catch (IOException e) {
            String str2 = "checkElfFile IOException: " + e;
            return false;
        } catch (UnknownFormatConversionException e2) {
            e = e2;
            sb = new StringBuilder();
            str = "checkElfFile UnknownFormatConversionException: ";
            sb.append(str);
            sb.append(e);
            sb.toString();
            return true;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "checkElfFile Throwable: ";
            sb.append(str);
            sb.append(e);
            sb.toString();
            return true;
        }
    }

    /* renamed from: f */
    private void m2081f() throws IOException {
        AbstractC1444a abstractC1444a = this.f2433h;
        C1435c c1435c = this.f2432g;
        boolean m2083d = m2083d();
        AbstractC1454k m2087a = m2087a(".dynsym");
        if (m2087a != null) {
            c1435c.m2104a(m2087a.mo2076b());
            int mo2077a = m2087a.mo2077a() / (m2083d ? 24 : 16);
            this.f2430e = new AbstractC1455l[mo2077a];
            char[] cArr = new char[1];
            for (int i = 0; i < mo2077a; i++) {
                if (m2083d) {
                    C1452i c1452i = new C1452i();
                    c1452i.f2486c = c1435c.m2100b();
                    c1435c.m2101a(cArr);
                    c1452i.f2487d = cArr[0];
                    c1435c.m2101a(cArr);
                    c1452i.f2488e = cArr[0];
                    c1452i.f2478a = c1435c.m2099c();
                    c1452i.f2479b = c1435c.m2099c();
                    c1452i.f2489f = c1435c.m2105a();
                    this.f2430e[i] = c1452i;
                } else {
                    C1448e c1448e = new C1448e();
                    c1448e.f2486c = c1435c.m2100b();
                    c1448e.f2461a = c1435c.m2100b();
                    c1448e.f2462b = c1435c.m2100b();
                    c1435c.m2101a(cArr);
                    c1448e.f2487d = cArr[0];
                    c1435c.m2101a(cArr);
                    c1448e.f2488e = cArr[0];
                    c1448e.f2489f = c1435c.m2105a();
                    this.f2430e[i] = c1448e;
                }
            }
            AbstractC1454k abstractC1454k = this.f2434i[m2087a.f2484i];
            c1435c.m2104a(abstractC1454k.mo2076b());
            byte[] bArr = new byte[abstractC1454k.mo2077a()];
            this.f2431f = bArr;
            c1435c.m2102a(bArr);
        }
        this.f2429d = new AbstractC1453j[abstractC1444a.f2442g];
        for (int i2 = 0; i2 < abstractC1444a.f2442g; i2++) {
            c1435c.m2104a(abstractC1444a.mo2078b() + (abstractC1444a.f2441f * i2));
            if (m2083d) {
                C1450g c1450g = new C1450g();
                c1450g.f2480g = c1435c.m2100b();
                c1450g.f2481h = c1435c.m2100b();
                c1450g.f2466a = c1435c.m2099c();
                c1450g.f2467b = c1435c.m2099c();
                c1450g.f2468c = c1435c.m2099c();
                c1450g.f2469d = c1435c.m2099c();
                c1450g.f2470e = c1435c.m2099c();
                c1450g.f2471f = c1435c.m2099c();
                this.f2429d[i2] = c1450g;
            } else {
                C1446c c1446c = new C1446c();
                c1446c.f2480g = c1435c.m2100b();
                c1446c.f2481h = c1435c.m2100b();
                c1446c.f2449a = c1435c.m2100b();
                c1446c.f2450b = c1435c.m2100b();
                c1446c.f2451c = c1435c.m2100b();
                c1446c.f2452d = c1435c.m2100b();
                c1446c.f2453e = c1435c.m2100b();
                c1446c.f2454f = c1435c.m2100b();
                this.f2429d[i2] = c1446c;
            }
        }
    }

    /* renamed from: g */
    public static boolean m2080g() {
        String property = System.getProperty("java.vm.version");
        return property != null && property.startsWith(ExifInterface.GPS_MEASUREMENT_2D);
    }

    /* renamed from: a */
    public final AbstractC1454k m2087a(String str) {
        AbstractC1454k[] abstractC1454kArr;
        for (AbstractC1454k abstractC1454k : this.f2434i) {
            if (str.equals(m2089a(abstractC1454k.f2482g))) {
                return abstractC1454k;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final String m2089a(int i) {
        if (i == 0) {
            return "SHN_UNDEF";
        }
        int i2 = i;
        while (this.f2435j[i2] != 0) {
            i2++;
        }
        return new String(this.f2435j, i, i2 - i);
    }

    /* renamed from: a */
    public final boolean m2090a() {
        return this.f2427b[0] == f2426a[0];
    }

    /* renamed from: b */
    public final char m2086b() {
        return this.f2427b[4];
    }

    /* renamed from: c */
    public final char m2084c() {
        return this.f2427b[5];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2432g.close();
    }

    /* renamed from: d */
    public final boolean m2083d() {
        return m2086b() == 2;
    }

    /* renamed from: e */
    public final boolean m2082e() {
        return m2084c() == 1;
    }
}
