package com.umeng.analytics.pro;

import java.util.BitSet;

/* renamed from: com.umeng.analytics.pro.by */
/* loaded from: classes4.dex */
public final class C1602by extends C1588bm {

    /* renamed from: com.umeng.analytics.pro.by$a */
    /* loaded from: classes4.dex */
    public static class C1603a implements AbstractC1598bu {
        @Override // com.umeng.analytics.pro.AbstractC1598bu
        /* renamed from: a */
        public AbstractC1596bs mo1100a(AbstractC1612cg abstractC1612cg) {
            return new C1602by(abstractC1612cg);
        }
    }

    public C1602by(AbstractC1612cg abstractC1612cg) {
        super(abstractC1612cg);
    }

    /* renamed from: a */
    public static BitSet m1103a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    /* renamed from: b */
    public static byte[] m1101b(BitSet bitSet, int i) {
        int ceil = (int) Math.ceil(i / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int i3 = (ceil - (i2 / 8)) - 1;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        return bArr;
    }

    @Override // com.umeng.analytics.pro.AbstractC1596bs
    /* renamed from: D */
    public Class<? extends AbstractC1606ca> mo1105D() {
        return AbstractC1609cd.class;
    }

    /* renamed from: a */
    public void m1104a(BitSet bitSet, int i) throws C1566az {
        for (byte b : m1101b(bitSet, i)) {
            mo1149a(b);
        }
    }

    /* renamed from: b */
    public BitSet m1102b(int i) throws C1566az {
        int ceil = (int) Math.ceil(i / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = mo1116u();
        }
        return m1103a(bArr);
    }
}
