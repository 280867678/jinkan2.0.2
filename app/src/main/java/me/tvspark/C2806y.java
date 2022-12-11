package me.tvspark;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* renamed from: me.tvspark.y */
/* loaded from: classes4.dex */
public class C2806y implements Handler.Callback {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public final Handler Wwwwwwwwwwwwwwwwwwwww;
    public volatile Kkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwww;
    @VisibleForTesting
    public final Map<FragmentManager, FragmentC2769x> Wwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    @VisibleForTesting
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> Wwwwwwwwwwwwwwwwwwwwww = new HashMap();

    /* renamed from: me.tvspark.y$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* renamed from: me.tvspark.y$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public C2806y(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        new ArrayMap();
        new ArrayMap();
        new Bundle();
        this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? Wwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = new Handler(Looper.getMainLooper(), this);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isFinishing();
    }

    @Nullable
    public static Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((ContextWrapper) context).getBaseContext());
    }

    @NonNull
    public final Kkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (this) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
                    Kkkkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
                    C2426o c2426o = new C2426o();
                    C2617t c2617t = new C2617t();
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = new Kkkkkkkkkkkk(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, c2426o, c2617t, origApplicationContext);
                    } else {
                        throw null;
                    }
                }
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @NonNull
    public Kkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        if (context != null) {
            if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    FragmentActivity fragmentActivity = (FragmentActivity) context;
                    if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StubApp.getOrigApplicationContext(fragmentActivity.getApplicationContext()));
                    }
                    if (!fragmentActivity.isDestroyed()) {
                        SupportRequestManagerFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fragmentActivity.getSupportFragmentManager(), (Fragment) null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fragmentActivity));
                        Kkkkkkkkkkkk kkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww;
                        if (kkkkkkkkkkkk != null) {
                            return kkkkkkkkkkkk;
                        }
                        Kkkkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fragmentActivity);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
                        C2389n c2389n = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww;
                        AbstractC2843z abstractC2843z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
                        if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                            Kkkkkkkkkkkk kkkkkkkkkkkk2 = new Kkkkkkkkkkkk(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, c2389n, abstractC2843z, fragmentActivity);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww = kkkkkkkkkkkk2;
                            return kkkkkkkkkkkk2;
                        }
                        throw null;
                    }
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                } else if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
                    }
                    if (!activity.isDestroyed()) {
                        FragmentC2769x Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity.getFragmentManager(), (android.app.Fragment) null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity));
                        Kkkkkkkkkkkk kkkkkkkkkkkk3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww;
                        if (kkkkkkkkkkkk3 != null) {
                            return kkkkkkkkkkkk3;
                        }
                        Kkkkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwww;
                        C2389n c2389n2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww;
                        AbstractC2843z abstractC2843z2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwww;
                        if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) != null) {
                            Kkkkkkkkkkkk kkkkkkkkkkkk4 = new Kkkkkkkkkkkk(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, c2389n2, abstractC2843z2, activity);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww = kkkkkkkkkkkk4;
                            return kkkkkkkkkkkk4;
                        }
                        throw null;
                    }
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                } else if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (StubApp.getOrigApplicationContext(contextWrapper.getBaseContext().getApplicationContext()) != null) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contextWrapper.getBaseContext());
                    }
                }
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Map map;
        Object obj2;
        int i = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            map = this.Wwwwwwwwwwwwwwwwwwwwwww;
        } else if (i != 2) {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                String str = "Failed to remove expected request manager fragment, manager: " + obj2;
            }
            return z;
        } else {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            map = this.Wwwwwwwwwwwwwwwwwwwwww;
        }
        Object obj4 = obj;
        obj3 = map.remove(obj);
        obj2 = obj4;
        if (z) {
            String str2 = "Failed to remove expected request manager fragment, manager: " + obj2;
        }
        return z;
    }

    @NonNull
    public final FragmentC2769x Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        FragmentC2769x fragmentC2769x = (FragmentC2769x) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (fragmentC2769x == null && (fragmentC2769x = this.Wwwwwwwwwwwwwwwwwwwwwww.get(fragmentManager)) == null) {
            fragmentC2769x = new FragmentC2769x();
            fragmentC2769x.Wwwwwwwwwwwwwwwwwww = fragment;
            if (fragment != null && fragment.getActivity() != null) {
                fragmentC2769x.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fragment.getActivity());
            }
            if (z) {
                fragmentC2769x.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.put(fragmentManager, fragmentC2769x);
            fragmentManager.beginTransaction().add(fragmentC2769x, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.Wwwwwwwwwwwwwwwwwwwww.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return fragmentC2769x;
    }

    @NonNull
    public final SupportRequestManagerFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.Wwwwwwwwwwwwwwwwwwwwww.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.Wwwwwwwwwwwwwwwwwww = fragment;
            if (fragment != null && fragment.mo4928getContext() != null) {
                Fragment fragment2 = fragment;
                while (fragment2.getParentFragment() != null) {
                    fragment2 = fragment2.getParentFragment();
                }
                androidx.fragment.app.FragmentManager fragmentManager2 = fragment2.getFragmentManager();
                if (fragmentManager2 != null) {
                    supportRequestManagerFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fragment.mo4928getContext(), fragmentManager2);
                }
            }
            if (z) {
                supportRequestManagerFragment.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.Wwwwwwwwwwwwwwwwwwwww.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }
}
