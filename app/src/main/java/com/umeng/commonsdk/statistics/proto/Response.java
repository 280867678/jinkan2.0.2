package com.umeng.commonsdk.statistics.proto;

import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.AbstractC1558at;
import com.umeng.analytics.pro.AbstractC1570ba;
import com.umeng.analytics.pro.AbstractC1596bs;
import com.umeng.analytics.pro.AbstractC1606ca;
import com.umeng.analytics.pro.AbstractC1607cb;
import com.umeng.analytics.pro.AbstractC1608cc;
import com.umeng.analytics.pro.AbstractC1609cd;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.analytics.pro.C1555aq;
import com.umeng.analytics.pro.C1566az;
import com.umeng.analytics.pro.C1580bf;
import com.umeng.analytics.pro.C1581bg;
import com.umeng.analytics.pro.C1585bk;
import com.umeng.analytics.pro.C1588bm;
import com.umeng.analytics.pro.C1591bn;
import com.umeng.analytics.pro.C1597bt;
import com.umeng.analytics.pro.C1599bv;
import com.umeng.analytics.pro.C1601bx;
import com.umeng.analytics.pro.C1602by;
import com.umeng.analytics.pro.C1610ce;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class Response implements AbstractC1558at<Response, EnumC1809e>, Serializable, Cloneable {
    public static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<EnumC1809e, C1580bf> metaDataMap;
    public static final Map<Class<? extends AbstractC1606ca>, AbstractC1607cb> schemes;
    public static final long serialVersionUID = -4549277923241195391L;
    public byte __isset_bitfield;
    public C1831d imprint;
    public String msg;
    public EnumC1809e[] optionals;
    public int resp_code;
    public static final C1601bx STRUCT_DESC = new C1601bx("Response");
    public static final C1591bn RESP_CODE_FIELD_DESC = new C1591bn("resp_code", (byte) 8, 1);
    public static final C1591bn MSG_FIELD_DESC = new C1591bn(NotificationCompat.CATEGORY_MESSAGE, (byte) 11, 2);
    public static final C1591bn IMPRINT_FIELD_DESC = new C1591bn(C1543ak.f2960X, (byte) 12, 3);

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$a */
    /* loaded from: classes4.dex */
    public static class C1805a extends AbstractC1608cc<Response> {
        public C1805a() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo233b(AbstractC1596bs abstractC1596bs, Response response) throws C1566az {
            abstractC1596bs.mo1127j();
            while (true) {
                C1591bn mo1125l = abstractC1596bs.mo1125l();
                byte b = mo1125l.f3221b;
                if (b == 0) {
                    break;
                }
                short s = mo1125l.f3222c;
                if (s == 1) {
                    if (b == 8) {
                        response.resp_code = abstractC1596bs.mo1114w();
                        response.setResp_codeIsSet(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else if (s != 2) {
                    if (s == 3 && b == 12) {
                        C1831d c1831d = new C1831d();
                        response.imprint = c1831d;
                        c1831d.read(abstractC1596bs);
                        response.setImprintIsSet(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                } else {
                    if (b == 11) {
                        response.msg = abstractC1596bs.mo1111z();
                        response.setMsgIsSet(true);
                    }
                    C1599bv.m1108a(abstractC1596bs, b);
                }
                abstractC1596bs.mo1124m();
            }
            abstractC1596bs.mo1126k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required field 'resp_code' was not found in serialized data! Struct: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toString());
            throw new C1597bt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo235a(AbstractC1596bs abstractC1596bs, Response response) throws C1566az {
            response.validate();
            abstractC1596bs.mo1140a(Response.STRUCT_DESC);
            abstractC1596bs.mo1145a(Response.RESP_CODE_FIELD_DESC);
            abstractC1596bs.mo1147a(response.resp_code);
            abstractC1596bs.mo1134c();
            if (response.msg != null && response.isSetMsg()) {
                abstractC1596bs.mo1145a(Response.MSG_FIELD_DESC);
                abstractC1596bs.mo1139a(response.msg);
                abstractC1596bs.mo1134c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                abstractC1596bs.mo1145a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(abstractC1596bs);
                abstractC1596bs.mo1134c();
            }
            abstractC1596bs.mo1133d();
            abstractC1596bs.mo1135b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$b */
    /* loaded from: classes4.dex */
    public static class C1806b implements AbstractC1607cb {
        public C1806b() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1805a mo230b() {
            return new C1805a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$c */
    /* loaded from: classes4.dex */
    public static class C1807c extends AbstractC1609cd<Response> {
        public C1807c() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: a */
        public void mo235a(AbstractC1596bs abstractC1596bs, Response response) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            c1602by.mo1147a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            c1602by.m1104a(bitSet, 2);
            if (response.isSetMsg()) {
                c1602by.mo1139a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(c1602by);
            }
        }

        @Override // com.umeng.analytics.pro.AbstractC1606ca
        /* renamed from: b */
        public void mo233b(AbstractC1596bs abstractC1596bs, Response response) throws C1566az {
            C1602by c1602by = (C1602by) abstractC1596bs;
            response.resp_code = c1602by.mo1114w();
            response.setResp_codeIsSet(true);
            BitSet m1102b = c1602by.m1102b(2);
            if (m1102b.get(0)) {
                response.msg = c1602by.mo1111z();
                response.setMsgIsSet(true);
            }
            if (m1102b.get(1)) {
                C1831d c1831d = new C1831d();
                response.imprint = c1831d;
                c1831d.read(c1602by);
                response.setImprintIsSet(true);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$d */
    /* loaded from: classes4.dex */
    public static class C1808d implements AbstractC1607cb {
        public C1808d() {
        }

        @Override // com.umeng.analytics.pro.AbstractC1607cb
        /* renamed from: a */
        public C1807c mo230b() {
            return new C1807c();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$e */
    /* loaded from: classes4.dex */
    public enum EnumC1809e implements AbstractC1570ba {
        RESP_CODE(1, "resp_code"),
        MSG(2, NotificationCompat.CATEGORY_MESSAGE),
        IMPRINT(3, C1543ak.f2960X);
        

        /* renamed from: d */
        public static final Map<String, EnumC1809e> f4137d = new HashMap();

        /* renamed from: e */
        public final short f4139e;

        /* renamed from: f */
        public final String f4140f;

        static {
            Iterator it = EnumSet.allOf(EnumC1809e.class).iterator();
            while (it.hasNext()) {
                EnumC1809e enumC1809e = (EnumC1809e) it.next();
                f4137d.put(enumC1809e.mo226b(), enumC1809e);
            }
        }

        EnumC1809e(short s, String str) {
            this.f4139e = s;
            this.f4140f = str;
        }

        /* renamed from: a */
        public static EnumC1809e m410a(int i) {
            if (i != 1) {
                if (i == 2) {
                    return MSG;
                }
                if (i == 3) {
                    return IMPRINT;
                }
                return null;
            }
            return RESP_CODE;
        }

        /* renamed from: a */
        public static EnumC1809e m409a(String str) {
            return f4137d.get(str);
        }

        /* renamed from: b */
        public static EnumC1809e m408b(int i) {
            EnumC1809e m410a = m410a(i);
            if (m410a != null) {
                return m410a;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field ", i, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: a */
        public short mo229a() {
            return this.f4139e;
        }

        @Override // com.umeng.analytics.pro.AbstractC1570ba
        /* renamed from: b */
        public String mo226b() {
            return this.f4140f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        hashMap.put(AbstractC1608cc.class, new C1806b());
        schemes.put(AbstractC1609cd.class, new C1808d());
        EnumMap enumMap = new EnumMap(EnumC1809e.class);
        enumMap.put((EnumMap) EnumC1809e.RESP_CODE, (EnumC1809e) new C1580bf("resp_code", (byte) 1, new C1581bg((byte) 8)));
        enumMap.put((EnumMap) EnumC1809e.MSG, (EnumC1809e) new C1580bf(NotificationCompat.CATEGORY_MESSAGE, (byte) 2, new C1581bg((byte) 11)));
        enumMap.put((EnumMap) EnumC1809e.IMPRINT, (EnumC1809e) new C1580bf(C1543ak.f2960X, (byte) 2, new C1585bk((byte) 12, C1831d.class)));
        Map<EnumC1809e, C1580bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        C1580bf.m1185a(Response.class, unmodifiableMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new EnumC1809e[]{EnumC1809e.MSG, EnumC1809e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new EnumC1809e[]{EnumC1809e.MSG, EnumC1809e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new C1831d(response.imprint);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new C1588bm(new C1610ce(objectInputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C1588bm(new C1610ce(objectOutputStream)));
        } catch (C1566az e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public AbstractC1558at<Response, EnumC1809e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public EnumC1809e fieldForId(int i) {
        return EnumC1809e.m410a(i);
    }

    public C1831d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return C1555aq.m1284a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void read(AbstractC1596bs abstractC1596bs) throws C1566az {
        schemes.get(abstractC1596bs.mo1105D()).mo230b().mo233b(abstractC1596bs, this);
    }

    public Response setImprint(C1831d c1831d) {
        this.imprint = c1831d;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (!z) {
            this.imprint = null;
        }
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (!z) {
            this.msg = null;
        }
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = C1555aq.m1283a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            C1831d c1831d = this.imprint;
            if (c1831d == null) {
                sb.append("null");
            } else {
                sb.append(c1831d);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = C1555aq.m1272b(this.__isset_bitfield, 0);
    }

    public void validate() throws C1566az {
        C1831d c1831d = this.imprint;
        if (c1831d != null) {
            c1831d.m276l();
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC1558at
    public void write(AbstractC1596bs abstractC1596bs) throws C1566az {
        schemes.get(abstractC1596bs.mo1105D()).mo230b().mo235a(abstractC1596bs, this);
    }
}
