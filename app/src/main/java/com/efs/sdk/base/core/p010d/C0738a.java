package com.efs.sdk.base.core.p010d;

import com.efs.sdk.base.Constants;

/* renamed from: com.efs.sdk.base.core.d.a */
/* loaded from: classes3.dex */
public final class C0738a {

    /* renamed from: a */
    public String f271a;

    /* renamed from: b */
    public byte f272b;

    /* renamed from: c */
    public int f273c = 0;

    /* renamed from: d */
    public String f274d = Constants.CP_NONE;

    /* renamed from: e */
    public int f275e = 1;

    /* renamed from: f */
    public long f276f = 0;

    /* renamed from: g */
    public int f277g = 1;

    public C0738a(String str, byte b) {
        this.f272b = (byte) 2;
        this.f271a = str;
        if (b <= 0 || 3 < b) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b)));
        }
        this.f272b = b;
    }
}
