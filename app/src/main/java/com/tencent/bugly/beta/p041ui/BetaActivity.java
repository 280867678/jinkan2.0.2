package com.tencent.bugly.beta.p041ui;

import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.stub.StubApp;

/* renamed from: com.tencent.bugly.beta.ui.BetaActivity */
/* loaded from: classes3.dex */
public class BetaActivity extends FragmentActivity {
    public Runnable onDestroyRunnable = null;

    static {
        StubApp.interface11(5458);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.onDestroyRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(16908290);
        if (findFragmentById instanceof AbstractC1106e) {
            z = ((AbstractC1106e) findFragmentById).mo3583a(i, keyEvent);
            if (!z) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        z = false;
        if (!z) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}
