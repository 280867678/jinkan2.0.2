package com.efs.sdk.p020pa.p021a;

import com.efs.sdk.p020pa.C0842b;
import com.efs.sdk.p020pa.PAMsgListener;
import java.io.BufferedOutputStream;

/* renamed from: com.efs.sdk.pa.a.f */
/* loaded from: classes3.dex */
public final class C0839f implements AbstractC0837d {

    /* renamed from: a */
    public PAMsgListener f541a;

    /* renamed from: b */
    public boolean f542b;

    /* renamed from: c */
    public String f543c;

    /* renamed from: d */
    public BufferedOutputStream f544d;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0089 A[Catch: Exception -> 0x00ac, TryCatch #0 {Exception -> 0x00ac, blocks: (B:7:0x000f, B:11:0x001c, B:13:0x0022, B:14:0x002c, B:17:0x0036, B:19:0x003c, B:22:0x0048, B:25:0x0052, B:26:0x007f, B:28:0x0089, B:30:0x008f, B:32:0x0095, B:34:0x009d, B:35:0x00a5, B:40:0x0057, B:42:0x005d, B:44:0x0063, B:47:0x006f, B:50:0x0079), top: B:6:0x000f }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0842b m3936b(String str, long j, long j2) {
        String str2;
        int indexOf;
        int indexOf2;
        int i;
        String substring;
        int lastIndexOf;
        int i2;
        int i3;
        if (str == null) {
            return null;
        }
        C0842b c0842b = new C0842b();
        try {
            int indexOf3 = str.indexOf(":");
            String str3 = "";
            if (indexOf3 != -1) {
                int i4 = indexOf3 + 2;
                if (i4 < str.length()) {
                    str2 = str.substring(i4, str.length());
                    c0842b.f548a = str2;
                    if (!str.contains("(") && str.contains(")")) {
                        int indexOf4 = str.indexOf("(");
                        int indexOf5 = str.indexOf(")");
                        if (indexOf4 != -1 && indexOf5 != -1 && (i3 = indexOf4 + 1) < str.length() && indexOf5 > i3) {
                            substring = str.substring(i3, indexOf5);
                            c0842b.f549b = substring;
                            if (!str.contains("null")) {
                            }
                            c0842b.f550c = str3;
                            c0842b.f551d = j;
                            c0842b.f552e = j2;
                            return c0842b;
                        }
                        substring = str3;
                        c0842b.f549b = substring;
                        if (!str.contains("null")) {
                        }
                        c0842b.f550c = str3;
                        c0842b.f551d = j;
                        c0842b.f552e = j2;
                        return c0842b;
                    }
                    if (str.contains("{") && str.contains("}")) {
                        indexOf = str.indexOf("{");
                        indexOf2 = str.indexOf("}");
                        if (indexOf != -1 && indexOf2 != -1 && (i = indexOf + 1) < str.length() && indexOf2 > i) {
                            substring = str.substring(i, indexOf2);
                            c0842b.f549b = substring;
                            if (!str.contains("null") && str.contains("}") && (lastIndexOf = str.lastIndexOf("}")) != -1 && (i2 = lastIndexOf + 1) < str.length()) {
                                str3 = str.substring(i2, str.length());
                            }
                            c0842b.f550c = str3;
                            c0842b.f551d = j;
                            c0842b.f552e = j2;
                            return c0842b;
                        }
                    }
                    substring = str3;
                    c0842b.f549b = substring;
                    if (!str.contains("null")) {
                        str3 = str.substring(i2, str.length());
                    }
                    c0842b.f550c = str3;
                    c0842b.f551d = j;
                    c0842b.f552e = j2;
                    return c0842b;
                }
            }
            str2 = str3;
            c0842b.f548a = str2;
            if (!str.contains("(")) {
            }
            if (str.contains("{")) {
                indexOf = str.indexOf("{");
                indexOf2 = str.indexOf("}");
                if (indexOf != -1) {
                    substring = str.substring(i, indexOf2);
                    c0842b.f549b = substring;
                    if (!str.contains("null")) {
                    }
                    c0842b.f550c = str3;
                    c0842b.f551d = j;
                    c0842b.f552e = j2;
                    return c0842b;
                }
            }
            substring = str3;
            c0842b.f549b = substring;
            if (!str.contains("null")) {
            }
            c0842b.f550c = str3;
            c0842b.f551d = j;
            c0842b.f552e = j2;
            return c0842b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.efs.sdk.p020pa.p021a.AbstractC0837d
    /* renamed from: a */
    public final void mo3937a(String str, long j, long j2) {
        C0842b m3936b = m3936b(str, j, j2);
        if (m3936b != null) {
            if (this.f542b) {
                m3936b.toString();
            }
            if (this.f543c != null) {
                try {
                    BufferedOutputStream bufferedOutputStream = this.f544d;
                    bufferedOutputStream.write((m3936b.toString() + "\n").getBytes());
                } catch (Exception unused) {
                }
            }
            this.f541a.msg(m3936b);
        }
    }
}
