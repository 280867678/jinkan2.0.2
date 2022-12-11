package com.umeng.analytics.pro;

import com.umeng.analytics.pro.C1588bm;

/* renamed from: com.umeng.analytics.pro.bv */
/* loaded from: classes4.dex */
public class C1599bv {

    /* renamed from: a */
    public static int f3244a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static AbstractC1598bu m1106a(byte[] bArr, AbstractC1598bu abstractC1598bu) {
        return bArr[0] > 16 ? new C1588bm.C1589a() : (bArr.length <= 1 || (bArr[1] & 128) == 0) ? abstractC1598bu : new C1588bm.C1589a();
    }

    /* renamed from: a */
    public static void m1109a(int i) {
        f3244a = i;
    }

    /* renamed from: a */
    public static void m1108a(AbstractC1596bs abstractC1596bs, byte b) throws C1566az {
        m1107a(abstractC1596bs, b, f3244a);
    }

    /* renamed from: a */
    public static void m1107a(AbstractC1596bs abstractC1596bs, byte b, int i) throws C1566az {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    abstractC1596bs.mo1117t();
                    return;
                case 3:
                    abstractC1596bs.mo1116u();
                    return;
                case 4:
                    abstractC1596bs.mo1112y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    abstractC1596bs.mo1115v();
                    return;
                case 8:
                    abstractC1596bs.mo1114w();
                    return;
                case 10:
                    abstractC1596bs.mo1113x();
                    return;
                case 11:
                    abstractC1596bs.mo1153A();
                    return;
                case 12:
                    abstractC1596bs.mo1127j();
                    while (true) {
                        byte b2 = abstractC1596bs.mo1125l().f3221b;
                        if (b2 == 0) {
                            abstractC1596bs.mo1126k();
                            return;
                        } else {
                            m1107a(abstractC1596bs, b2, i - 1);
                            abstractC1596bs.mo1124m();
                        }
                    }
                case 13:
                    C1593bp mo1123n = abstractC1596bs.mo1123n();
                    while (i2 < mo1123n.f3227c) {
                        int i3 = i - 1;
                        m1107a(abstractC1596bs, mo1123n.f3225a, i3);
                        m1107a(abstractC1596bs, mo1123n.f3226b, i3);
                        i2++;
                    }
                    abstractC1596bs.mo1122o();
                    return;
                case 14:
                    C1600bw mo1119r = abstractC1596bs.mo1119r();
                    while (i2 < mo1119r.f3246b) {
                        m1107a(abstractC1596bs, mo1119r.f3245a, i - 1);
                        i2++;
                    }
                    abstractC1596bs.mo1118s();
                    return;
                case 15:
                    C1592bo mo1121p = abstractC1596bs.mo1121p();
                    while (i2 < mo1121p.f3224b) {
                        m1107a(abstractC1596bs, mo1121p.f3223a, i - 1);
                        i2++;
                    }
                    abstractC1596bs.mo1120q();
                    return;
            }
        } else {
            throw new C1566az("Maximum skip depth exceeded");
        }
    }
}
