package com.lzf.easyfloat.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.os.Bundle;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.widget.appfloat.AppFloatManager;
import com.lzf.easyfloat.widget.appfloat.FloatManager;
import java.util.Map;
import java.util.Set;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.of0;

@ef0
/* loaded from: classes3.dex */
public final class LifecycleUtils {
    public static final LifecycleUtils INSTANCE = new LifecycleUtils();
    public static int activityCount;
    public static Application application;

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkHide() {
        if (isForeground()) {
            return;
        }
        for (Map.Entry<String, AppFloatManager> entry : FloatManager.INSTANCE.getFloatMap().entrySet()) {
            String key = entry.getKey();
            FloatConfig config = entry.getValue().getConfig();
            INSTANCE.setVisible(config.getShowPattern() != ShowPattern.FOREGROUND && config.getNeedShow$easyfloat_release(), key);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkShow(Activity activity) {
        if (activity == null) {
            return;
        }
        for (Map.Entry<String, AppFloatManager> entry : FloatManager.INSTANCE.getFloatMap().entrySet()) {
            String key = entry.getKey();
            FloatConfig config = entry.getValue().getConfig();
            if (config.getShowPattern() == ShowPattern.BACKGROUND) {
                INSTANCE.setVisible(false, key);
            } else if (config.getNeedShow$easyfloat_release()) {
                LifecycleUtils lifecycleUtils = INSTANCE;
                Set<String> filterSet = config.getFilterSet();
                ComponentName componentName = activity.getComponentName();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) componentName, "activity.componentName");
                lifecycleUtils.setVisible(!filterSet.contains(componentName.getClassName()), key);
            }
        }
    }

    private final of0 setVisible(boolean z, String str) {
        return FloatManager.visible$default(FloatManager.INSTANCE, z, str, false, 4, null);
    }

    public static /* synthetic */ of0 setVisible$default(LifecycleUtils lifecycleUtils, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = lifecycleUtils.isForeground();
        }
        return lifecycleUtils.setVisible(z, str);
    }

    public final boolean isForeground() {
        return activityCount > 0;
    }

    public final void setLifecycleCallbacks(Application application2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(application2, "application");
        application = application2;
        application2.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.lzf.easyfloat.utils.LifecycleUtils$setLifecycleCallbacks$1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                LifecycleUtils.INSTANCE.checkShow(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                int i;
                if (activity != null) {
                    LifecycleUtils lifecycleUtils = LifecycleUtils.INSTANCE;
                    i = LifecycleUtils.activityCount;
                    LifecycleUtils.activityCount = i + 1;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                int i;
                if (activity != null) {
                    LifecycleUtils lifecycleUtils = LifecycleUtils.INSTANCE;
                    i = LifecycleUtils.activityCount;
                    LifecycleUtils.activityCount = i - 1;
                    LifecycleUtils.INSTANCE.checkHide();
                }
            }
        });
    }
}
