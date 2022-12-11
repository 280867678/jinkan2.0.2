package com.efs.sdk.base.core.p013f;

import com.efs.sdk.base.core.config.C0725a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p005a.C0694a;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.record.AbsRecordLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.efs.sdk.base.core.f.b */
/* loaded from: classes3.dex */
public final class C0755b extends AbsRecordLog {

    /* renamed from: a */
    public String f293a;

    /* renamed from: b */
    public String f294b;

    /* renamed from: c */
    public String f295c;

    /* renamed from: d */
    public String f296d;

    public C0755b(String str, String str2, String str3) {
        super("wa");
        this.f293a = str;
        this.f294b = str2;
        this.f296d = str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.CHINA);
        C0694a.m4184a();
        this.f295c = simpleDateFormat.format(new Date(C0694a.m4180b()));
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final byte[] generate() {
        String generateString = generateString();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.m4062i("efs.base", generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String generateString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("lt=event`", "ev_ct=");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.f293a, "`", "ev_ac=");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.f294b, "`", "tm=");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.f295c, "`", "dn=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f296d);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("`");
        for (Map.Entry<String, Object> entry : this.dataMap.entrySet()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(entry.getKey());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(entry.getValue());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("`");
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.subSequence(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() - 1).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkId() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkKey() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void insertGlobal(C0725a c0725a) {
        this.dataMap.putAll(c0725a.m4135a());
        this.dataMap.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }
}
