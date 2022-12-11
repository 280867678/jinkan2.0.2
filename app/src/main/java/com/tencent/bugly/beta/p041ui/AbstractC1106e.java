package com.tencent.bugly.beta.p041ui;

import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* renamed from: com.tencent.bugly.beta.ui.e */
/* loaded from: classes3.dex */
public abstract class AbstractC1106e extends Fragment {

    /* renamed from: a */
    public boolean f818a = false;

    /* renamed from: a */
    public synchronized void mo3595a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* renamed from: a */
    public abstract boolean mo3583a(int i, KeyEvent keyEvent);

    /* renamed from: b */
    public synchronized boolean m3594b() {
        return this.f818a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        synchronized (this) {
            this.f818a = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        synchronized (this) {
            this.f818a = true;
        }
    }
}
