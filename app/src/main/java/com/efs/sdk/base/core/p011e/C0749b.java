package com.efs.sdk.base.core.p011e;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p016c.C0776a;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* renamed from: com.efs.sdk.base.core.e.b */
/* loaded from: classes3.dex */
public final class C0749b implements ILogEncryptAction {
    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] decrypt(String str, byte[] bArr) {
        try {
            return C0776a.m4011a(bArr, str);
        } catch (Exception e) {
            Log.m4065e("efs.base", "aes decrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] encrypt(String str, byte[] bArr) {
        try {
            return C0776a.m4010b(bArr, str);
        } catch (Exception e) {
            Log.m4065e("efs.base", "aes encrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final int getDeVal() {
        return 2;
    }
}
