package com.p038qq.p039e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.p038qq.p039e.comm.p040pi.ACTD;
import com.stub.StubApp;

/* renamed from: com.qq.e.ads.ADActivity */
/* loaded from: classes3.dex */
public class ADActivity extends Activity {
    public static final String NOTCH_CONTAINER_TAG = "NOTCH_CONTAINER";
    public FrameLayout Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: a */
    public ACTD f656a;

    static {
        StubApp.interface11(5231);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        super.setContentView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setTag(NOTCH_CONTAINER_TAG);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(frameLayout);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new FrameLayout(this);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ACTD actd = this.f656a;
        if (actd != null) {
            actd.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.f656a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.f656a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ACTD actd = this.f656a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.f656a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ACTD actd = this.f656a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        ACTD actd = this.f656a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        LayoutInflater.from(this).inflate(i, (ViewGroup) this.Wwwwwwwwwwwwwwwwwwwwwwww, true);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.addView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.addView(view, layoutParams);
    }
}
