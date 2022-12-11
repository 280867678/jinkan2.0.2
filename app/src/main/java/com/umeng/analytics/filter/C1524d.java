package com.umeng.analytics.filter;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.umeng.analytics.filter.d */
/* loaded from: classes4.dex */
public class C1524d {

    /* renamed from: b */
    public static final String f2896b = "Ă";

    /* renamed from: c */
    public MessageDigest f2898c;

    /* renamed from: e */
    public boolean f2900e;

    /* renamed from: a */
    public final String f2897a = LitePalSupport.MD5;

    /* renamed from: d */
    public Set<Object> f2899d = new HashSet();

    public C1524d(boolean z, String str) {
        int i = 0;
        this.f2900e = false;
        this.f2900e = z;
        try {
            this.f2898c = MessageDigest.getInstance(LitePalSupport.MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (str != null) {
            if (!z) {
                String[] split = str.split(f2896b);
                int length = split.length;
                while (i < length) {
                    this.f2899d.add(split[i]);
                    i++;
                }
                return;
            }
            try {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                while (i < decode.length / 4) {
                    int i2 = i * 4;
                    this.f2899d.add(Integer.valueOf(((decode[i2 + 0] & 255) << 24) + ((decode[i2 + 1] & 255) << 16) + ((decode[i2 + 2] & 255) << 8) + (decode[i2 + 3] & 255)));
                    i++;
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private Integer m1409c(String str) {
        try {
            this.f2898c.update(str.getBytes());
            byte[] digest = this.f2898c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m1412a() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f2899d) {
            sb.append(obj);
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public boolean m1411a(String str) {
        Set<Object> set;
        Integer num;
        if (this.f2900e) {
            set = this.f2899d;
            num = m1409c(str);
        } else {
            set = this.f2899d;
            num = str;
        }
        return set.contains(num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public void m1410b(String str) {
        Set<Object> set;
        Integer num;
        if (this.f2900e) {
            set = this.f2899d;
            num = m1409c(str);
        } else {
            set = this.f2899d;
            num = str;
        }
        set.add(num);
    }

    public String toString() {
        if (!this.f2900e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f2899d) {
                if (sb.length() > 0) {
                    sb.append(f2896b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f2899d.size() * 4];
        Iterator<Object> it = this.f2899d.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            int i2 = i + 1;
            bArr[i] = (byte) (((-16777216) & intValue) >> 24);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((16711680 & intValue) >> 16);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((65280 & intValue) >> 8);
            i = i4 + 1;
            bArr[i4] = (byte) (intValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }
}
