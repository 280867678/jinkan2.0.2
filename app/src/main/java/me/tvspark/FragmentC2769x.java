package me.tvspark;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* renamed from: me.tvspark.x */
/* loaded from: classes4.dex */
public class FragmentC2769x extends Fragment {
    @Nullable
    public Fragment Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public FragmentC2769x Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Kkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwww;
    public final C2389n Wwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2843z Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final Set<FragmentC2769x> Wwwwwwwwwwwwwwwwwwwwww = new HashSet();

    /* renamed from: me.tvspark.x$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2843z {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + FragmentC2769x.this + "}";
        }
    }

    public FragmentC2769x() {
        C2389n c2389n = new C2389n();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2389n;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Activity activity) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2806y c2806y = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity).Wwwwwwwwwwwwwwwwwww;
        if (c2806y != null) {
            FragmentC2769x Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2806y.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity.getFragmentManager(), (Fragment) null, C2806y.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity));
            this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.add(this);
            return;
        }
        throw null;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.Wwwwwwwwwwwwwwwwwww;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        FragmentC2769x fragmentC2769x = this.Wwwwwwwwwwwwwwwwwwww;
        if (fragmentC2769x != null) {
            fragmentC2769x.Wwwwwwwwwwwwwwwwwwwwww.remove(this);
            this.Wwwwwwwwwwwwwwwwwwww = null;
        }
    }
}
