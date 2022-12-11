package com.efs.sdk.base.core.util.p015b;

import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p014a.AbstractC0766c;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.Map;

/* renamed from: com.efs.sdk.base.core.util.b.b */
/* loaded from: classes3.dex */
public final class C0772b implements AbstractC0766c<HttpResponse> {

    /* renamed from: a */
    public String f323a;

    /* renamed from: b */
    public Map<String, String> f324b;

    /* renamed from: c */
    public byte[] f325c;

    /* renamed from: d */
    public File f326d;

    /* renamed from: e */
    public String f327e;

    /* renamed from: f */
    public Map<String, String> f328f;

    /* renamed from: g */
    public boolean f329g = false;

    @Override // com.efs.sdk.base.core.util.p014a.AbstractC0766c
    @Nullable
    /* renamed from: a */
    public final /* synthetic */ HttpResponse mo4020a() {
        char c;
        String str = this.f327e;
        int hashCode = str.hashCode();
        if (hashCode != 102230) {
            if (hashCode == 3446944 && str.equals("post")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("get")) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c == 1) {
                byte[] bArr = this.f325c;
                return (bArr == null || bArr.length <= 0) ? HttpEnv.getInstance().getHttpUtil().post(this.f323a, this.f324b, this.f326d) : this.f329g ? HttpEnv.getInstance().getHttpUtil().postAsFile(this.f323a, this.f324b, this.f325c) : HttpEnv.getInstance().getHttpUtil().post(this.f323a, this.f324b, this.f325c);
            }
            Log.m4066e("efs.util.http", "request not support method '" + this.f327e + "'");
            return null;
        }
        return HttpEnv.getInstance().getHttpUtil().get(this.f323a, this.f324b);
    }
}
