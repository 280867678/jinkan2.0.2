package com.just.agentweb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class AgentActionFragment extends Fragment {
    public static final String FRAGMENT_TAG = "AgentWebActionFragment";
    public static final String KEY_FROM_INTENTION = "KEY_FROM_INTENTION";
    public static final String KEY_URI = "KEY_URI";
    public static final int REQUEST_CODE = 596;
    public static final String TAG = AgentActionFragment.class.getSimpleName();
    public boolean isViewCreated = false;
    public Action mAction;

    /* loaded from: classes3.dex */
    public interface ChooserListener {
        void onChoiceResult(int i, int i2, Intent intent);
    }

    /* loaded from: classes3.dex */
    public interface PermissionListener {
        void onRequestPermissionsResult(@NonNull String[] strArr, @NonNull int[] iArr, Bundle bundle);
    }

    /* loaded from: classes3.dex */
    public interface RationaleListener {
        void onRationaleResult(boolean z, Bundle bundle);
    }

    static {
        StubApp.interface11(5010);
    }

    private void captureCamera() {
        try {
            if (this.mAction.getChooserListener() == null) {
                resetAction();
                return;
            }
            File createImageFile = AgentWebUtils.createImageFile(getActivity());
            if (createImageFile == null) {
                this.mAction.getChooserListener().onChoiceResult(REQUEST_CODE, 0, null);
            }
            Intent intentCaptureCompat = AgentWebUtils.getIntentCaptureCompat(getActivity(), createImageFile);
            this.mAction.setUri((Uri) intentCaptureCompat.getParcelableExtra("output"));
            startActivityForResult(intentCaptureCompat, REQUEST_CODE);
        } catch (Throwable th) {
            LogUtils.m3703e(TAG, "找不到系统相机");
            if (this.mAction.getChooserListener() != null) {
                this.mAction.getChooserListener().onChoiceResult(REQUEST_CODE, 0, null);
            }
            resetAction();
            if (!LogUtils.isDebug()) {
                return;
            }
            th.printStackTrace();
        }
    }

    private void choose() {
        try {
            if (this.mAction.getChooserListener() == null) {
                return;
            }
            Intent intent = this.mAction.getIntent();
            if (intent == null) {
                resetAction();
            } else {
                startActivityForResult(intent, REQUEST_CODE);
            }
        } catch (Throwable th) {
            LogUtils.m3701i(TAG, "找不到文件选择器");
            chooserActionCallback(-1, null);
            if (!LogUtils.isDebug()) {
                return;
            }
            th.printStackTrace();
        }
    }

    private void chooserActionCallback(int i, Intent intent) {
        if (this.mAction.getChooserListener() != null) {
            this.mAction.getChooserListener().onChoiceResult(REQUEST_CODE, i, intent);
        }
        resetAction();
    }

    private void recordVideo() {
        try {
            if (this.mAction.getChooserListener() == null) {
                resetAction();
                return;
            }
            File createVideoFile = AgentWebUtils.createVideoFile(getActivity());
            if (createVideoFile == null) {
                this.mAction.getChooserListener().onChoiceResult(REQUEST_CODE, 0, null);
                resetAction();
                return;
            }
            Intent intentVideoCompat = AgentWebUtils.getIntentVideoCompat(getActivity(), createVideoFile);
            this.mAction.setUri((Uri) intentVideoCompat.getParcelableExtra("output"));
            startActivityForResult(intentVideoCompat, REQUEST_CODE);
        } catch (Throwable th) {
            LogUtils.m3703e(TAG, "找不到系统相机");
            if (this.mAction.getChooserListener() != null) {
                this.mAction.getChooserListener().onChoiceResult(REQUEST_CODE, 0, null);
            }
            resetAction();
            if (!LogUtils.isDebug()) {
                return;
            }
            th.printStackTrace();
        }
    }

    @RequiresApi(api = 23)
    private void requestPermission(Action action) {
        ArrayList<String> permissions = action.getPermissions();
        if (AgentWebUtils.isEmptyCollection(permissions)) {
            resetAction();
            return;
        }
        boolean z = false;
        if (this.mAction.getRationaleListener() == null) {
            if (this.mAction.getPermissionListener() == null) {
                return;
            }
            requestPermissions((String[]) permissions.toArray(new String[0]), 1);
            return;
        }
        Iterator<String> it = permissions.iterator();
        while (it.hasNext() && !(z = shouldShowRequestPermissionRationale(it.next()))) {
        }
        this.mAction.getRationaleListener().onRationaleResult(z, new Bundle());
        resetAction();
    }

    private void resetAction() {
    }

    private void runAction() {
        Action action = this.mAction;
        if (action == null) {
            resetAction();
        } else if (action.getAction() == 1) {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermission(this.mAction);
            } else {
                resetAction();
            }
        } else if (this.mAction.getAction() == 3) {
            captureCamera();
        } else if (this.mAction.getAction() == 4) {
            recordVideo();
        } else {
            choose();
        }
    }

    public static void start(Activity activity, Action action) {
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        AgentActionFragment agentActionFragment = (AgentActionFragment) supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (agentActionFragment == null) {
            agentActionFragment = new AgentActionFragment();
            supportFragmentManager.beginTransaction().add(agentActionFragment, FRAGMENT_TAG).commitAllowingStateLoss();
        }
        agentActionFragment.mAction = action;
        if (agentActionFragment.isViewCreated) {
            agentActionFragment.runAction();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 596) {
            if (this.mAction.getUri() != null) {
                chooserActionCallback(i2, new Intent().putExtra(KEY_URI, this.mAction.getUri()));
            } else {
                chooserActionCallback(i2, intent);
            }
        }
        resetAction();
    }

    @Override // androidx.fragment.app.Fragment
    public native void onCreate(@Nullable Bundle bundle);

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public native void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
