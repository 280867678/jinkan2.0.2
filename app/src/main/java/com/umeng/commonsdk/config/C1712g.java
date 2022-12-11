package com.umeng.commonsdk.config;

import com.umeng.commonsdk.debug.UMRTLog;

/* renamed from: com.umeng.commonsdk.config.g */
/* loaded from: classes4.dex */
public class C1712g implements AbstractC1710e {
    @Override // com.umeng.commonsdk.config.AbstractC1710e
    /* renamed from: a */
    public void mo775a(String str, Object obj, String[] strArr) {
        String str2;
        long parseLong;
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            parseLong = Long.parseLong(str);
        } catch (Throwable unused) {
            str2 = "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.";
        }
        if (parseLong == -1) {
            str2 = "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.";
            UMRTLog.m767e("Config", str2);
            return;
        }
        UMRTLog.m766i("Config", "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
        if (obj == null || !(obj instanceof C1701b)) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            try {
                String str3 = strArr[i];
                if (C1705d.m778a(str3)) {
                    ((C1701b) obj).mo776a(str3, Boolean.valueOf(C1700a.m787a(parseLong, i)));
                }
            } catch (Throwable unused2) {
                return;
            }
        }
    }
}
