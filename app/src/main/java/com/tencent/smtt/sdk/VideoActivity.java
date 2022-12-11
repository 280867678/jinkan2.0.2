package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.tbs.video.interfaces.AbstractC1489a;

/* loaded from: classes4.dex */
public class VideoActivity extends Activity {
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C1392s.m2404a(this).m2406a(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            C1392s.m2404a(super.getApplicationContext()).m2403a((String) null, bundleExtra, (AbstractC1489a) null);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1392s.m2404a(this).m2405a(this, 4);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C1392s.m2404a(this).m2405a(this, 3);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        C1392s.m2404a(this).m2405a(this, 2);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        C1392s.m2404a(this).m2405a(this, 1);
    }
}
