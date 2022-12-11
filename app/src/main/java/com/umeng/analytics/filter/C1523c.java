package com.umeng.analytics.filter;

import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;

/* renamed from: com.umeng.analytics.filter.c */
/* loaded from: classes4.dex */
public class C1523c implements UMImprintChangeCallback, UMImprintPreProcessCallback {
    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
    }

    public boolean onPreProcessImprintKey(String str, String str2) {
        return false;
    }
}
