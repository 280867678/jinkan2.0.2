package com.lzf.easyfloat.permission;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import com.lzf.easyfloat.interfaces.OnPermissionResult;
import com.lzf.easyfloat.utils.Logger;
import java.util.HashMap;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public final class PermissionFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    public static OnPermissionResult onPermissionResult;
    public HashMap _$_findViewCache;

    @ef0
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final void requestPermission(Activity activity, OnPermissionResult onPermissionResult) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(onPermissionResult, "onPermissionResult");
            PermissionFragment.onPermissionResult = onPermissionResult;
            activity.getFragmentManager().beginTransaction().add(new PermissionFragment(), activity.getLocalClassName()).commitAllowingStateLoss();
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        PermissionUtils.INSTANCE.requestPermission$easyfloat_release(this);
        Logger.INSTANCE.m3695i("PermissionFragment：requestPermission");
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 199) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.lzf.easyfloat.permission.PermissionFragment$onActivityResult$1
                @Override // java.lang.Runnable
                public final void run() {
                    OnPermissionResult onPermissionResult2;
                    Activity activity = PermissionFragment.this.getActivity();
                    if (activity != null) {
                        boolean checkPermission = PermissionUtils.checkPermission(activity);
                        Logger logger = Logger.INSTANCE;
                        logger.m3695i("PermissionFragment onActivityResult: " + checkPermission);
                        onPermissionResult2 = PermissionFragment.onPermissionResult;
                        if (onPermissionResult2 != null) {
                            onPermissionResult2.permissionResult(checkPermission);
                        }
                        PermissionFragment.this.getFragmentManager().beginTransaction().remove(PermissionFragment.this).commitAllowingStateLoss();
                    }
                }
            }, 500L);
        }
    }

    @Override // android.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
