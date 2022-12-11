package com.tencent.bugly.proguard;

import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.p041ui.C1112i;
import com.tencent.bugly.beta.p041ui.C1114k;
import com.tencent.bugly.beta.tinker.TinkerManager;

/* renamed from: com.tencent.bugly.proguard.s */
/* loaded from: classes3.dex */
public class C1240s implements TinkerManager.TinkerListener {

    /* renamed from: a */
    public final /* synthetic */ C1093e f1622a;

    public C1240s(C1093e c1093e) {
        this.f1622a = c1093e;
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onApplyFailure(String str) {
        this.f1622a.f753P = false;
        C1089a.m3609b("PatchResult", false);
        C1089a.m3609b("IS_PATCHING", false);
        C1199X.m3078c("Tinker patch failure, result: " + str, new Object[0]);
        BetaPatchListener betaPatchListener = this.f1622a.f762Y;
        if (betaPatchListener != null) {
            betaPatchListener.onApplyFailure(str);
        }
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onApplySuccess(String str) {
        C1093e c1093e = this.f1622a;
        c1093e.f771ea = false;
        c1093e.f753P = true;
        C1089a.m3609b("IS_PATCHING", false);
        C1089a.m3609b("PatchResult", true);
        C1199X.m3078c("Tinker patch success, result: " + str, new Object[0]);
        if (this.f1622a.f763Z) {
            C1114k.m3586a(new C1112i(), true);
        }
        BetaPatchListener betaPatchListener = this.f1622a.f762Y;
        if (betaPatchListener != null) {
            betaPatchListener.onApplySuccess(str);
        }
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onDownloadFailure(String str) {
        BetaPatchListener betaPatchListener = this.f1622a.f762Y;
        if (betaPatchListener != null) {
            betaPatchListener.onDownloadFailure(str);
        }
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onDownloadSuccess(String str) {
        BetaPatchListener betaPatchListener = this.f1622a.f762Y;
        if (betaPatchListener != null) {
            betaPatchListener.onDownloadSuccess(str);
        }
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onPatchRollback() {
        C1199X.m3078c("patch rollback callback.", new Object[0]);
        BetaPatchListener betaPatchListener = this.f1622a.f762Y;
        if (betaPatchListener != null) {
            betaPatchListener.onPatchRollback();
        }
        if (TinkerManager.getInstance().getPatchDirectory(this.f1622a.f789v) == null || TinkerManager.getInstance().getPatchDirectory(this.f1622a.f789v).exists()) {
            return;
        }
        C1089a.m3609b("IS_PATCH_ROLL_BACK", false);
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onPatchStart() {
        this.f1622a.f771ea = true;
        C1089a.m3609b("IS_PATCHING", true);
    }
}
