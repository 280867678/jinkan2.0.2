package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.HashSet;
import java.util.Set;
import me.tvspark.AbstractC2843z;
import me.tvspark.C2389n;
import me.tvspark.C2806y;
import me.tvspark.Kkkkkkkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkk;

/* loaded from: classes3.dex */
public class SupportRequestManagerFragment extends Fragment {
    @Nullable
    public Fragment Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public Kkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public SupportRequestManagerFragment Wwwwwwwwwwwwwwwwwwwww;
    public final C2389n Wwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2843z Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final Set<SupportRequestManagerFragment> Wwwwwwwwwwwwwwwwwwwwww = new HashSet();

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2843z {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        C2389n c2389n = new C2389n();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2389n;
    }

    public final void Wwwwwwwwwwwwwwwww() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.Wwwwwwwwwwwwwwwwwwwww;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.Wwwwwwwwwwwwwwwwwwwwww.remove(this);
            this.Wwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    @Nullable
    public final Fragment Wwwwwwwwwwwwwwwwww() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.Wwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        Wwwwwwwwwwwwwwwww();
        C2806y c2806y = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwww;
        if (c2806y != null) {
            SupportRequestManagerFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2806y.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fragmentManager, (Fragment) null, C2806y.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
            this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.add(this);
            return;
        }
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4928getContext(), fragmentManager);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.Wwwwwwwwwwwwwwwwwww = null;
        Wwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + Wwwwwwwwwwwwwwwwww() + "}";
    }
}
