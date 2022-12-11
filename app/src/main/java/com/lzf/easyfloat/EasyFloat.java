package com.lzf.easyfloat;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ViewCompat;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.FloatCallbacks;
import com.lzf.easyfloat.interfaces.OnAppFloatAnimator;
import com.lzf.easyfloat.interfaces.OnDisplayHeight;
import com.lzf.easyfloat.interfaces.OnFloatAnimator;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import com.lzf.easyfloat.interfaces.OnInvokeView;
import com.lzf.easyfloat.interfaces.OnPermissionResult;
import com.lzf.easyfloat.permission.PermissionUtils;
import com.lzf.easyfloat.utils.LifecycleUtils;
import com.lzf.easyfloat.utils.Logger;
import com.lzf.easyfloat.widget.activityfloat.ActivityFloatManager;
import com.lzf.easyfloat.widget.activityfloat.FloatingView;
import com.lzf.easyfloat.widget.appfloat.AppFloatManager;
import com.lzf.easyfloat.widget.appfloat.FloatManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.nh0;
import me.tvspark.of0;

@ef0
/* loaded from: classes3.dex */
public final class EasyFloat {
    public static final Companion Companion = new Companion(null);
    public static WeakReference<Activity> activityWr;
    public static boolean isDebug;
    public static boolean isInitialized;

    @ef0
    /* loaded from: classes3.dex */
    public static final class Builder implements OnPermissionResult {
        public final Context activity;
        public final FloatConfig config = new FloatConfig(null, null, null, false, false, false, false, false, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, false, false, ViewCompat.MEASURED_SIZE_MASK, null);

        @ef0
        /* loaded from: classes3.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ShowPattern.values().length];
                $EnumSwitchMapping$0 = iArr;
                ShowPattern showPattern = ShowPattern.CURRENT_ACTIVITY;
                iArr[0] = 1;
                int[] iArr2 = $EnumSwitchMapping$0;
                ShowPattern showPattern2 = ShowPattern.FOREGROUND;
                iArr2[1] = 2;
                int[] iArr3 = $EnumSwitchMapping$0;
                ShowPattern showPattern3 = ShowPattern.BACKGROUND;
                iArr3[2] = 3;
                int[] iArr4 = $EnumSwitchMapping$0;
                ShowPattern showPattern4 = ShowPattern.ALL_TIME;
                iArr4[3] = 4;
            }
        }

        public Builder(Context context) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.activity = context;
        }

        private final void callbackCreateFailed(String str) {
            FloatCallbacks.Builder builder;
            nh0<Boolean, String, View, of0> createdResult$easyfloat_release;
            OnFloatCallbacks callbacks = this.config.getCallbacks();
            if (callbacks != null) {
                callbacks.createdResult(false, str, null);
            }
            FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
            if (floatCallbacks != null && (builder = floatCallbacks.getBuilder()) != null && (createdResult$easyfloat_release = builder.getCreatedResult$easyfloat_release()) != null) {
                createdResult$easyfloat_release.invoke(false, str, null);
            }
            Logger.INSTANCE.m3691w(str);
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) EasyFloatMessageKt.WARN_NO_LAYOUT) || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) EasyFloatMessageKt.WARN_UNINITIALIZED) || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) EasyFloatMessageKt.WARN_CONTEXT_ACTIVITY)) {
                throw new Exception(str);
            }
        }

        private final boolean checkUninitialized() {
            int ordinal = this.config.getShowPattern().ordinal();
            if (ordinal != 0) {
                if (ordinal == 1 || ordinal == 2) {
                    if (EasyFloat.isInitialized) {
                        return false;
                    }
                } else if (ordinal != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    if (!(!this.config.getFilterSet().isEmpty()) || EasyFloat.isInitialized) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        private final void createActivityFloat() {
            Context context = this.activity;
            if (context instanceof Activity) {
                new ActivityFloatManager((Activity) context).createFloat(this.config);
            } else {
                callbackCreateFailed(EasyFloatMessageKt.WARN_CONTEXT_ACTIVITY);
            }
        }

        private final void createAppFloat() {
            FloatManager.INSTANCE.create(this.activity, this.config);
        }

        private final void requestPermission() {
            Context context = this.activity;
            if (context instanceof Activity) {
                PermissionUtils.requestPermission((Activity) context, this);
            } else {
                callbackCreateFailed(EasyFloatMessageKt.WARN_CONTEXT_REQUEST);
            }
        }

        public static /* synthetic */ Builder setGravity$default(Builder builder, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            return builder.setGravity(i, i2, i3);
        }

        public static /* synthetic */ Builder setLayout$default(Builder builder, int i, OnInvokeView onInvokeView, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                onInvokeView = null;
            }
            return builder.setLayout(i, onInvokeView);
        }

        public static /* synthetic */ Builder setMatchParent$default(Builder builder, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            return builder.setMatchParent(z, z2);
        }

        public final Builder hasEditText(boolean z) {
            this.config.setHasEditText(z);
            return this;
        }

        public final Builder invokeView(OnInvokeView onInvokeView) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(onInvokeView, "invokeView");
            this.config.setInvokeView(onInvokeView);
            return this;
        }

        @Override // com.lzf.easyfloat.interfaces.OnPermissionResult
        public void permissionResult(boolean z) {
            if (z) {
                createAppFloat();
            } else {
                callbackCreateFailed(EasyFloatMessageKt.WARN_PERMISSION);
            }
        }

        public final Builder registerCallback(ih0<? super FloatCallbacks.Builder, of0> ih0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "builder");
            FloatConfig floatConfig = this.config;
            FloatCallbacks floatCallbacks = new FloatCallbacks();
            floatCallbacks.registerListener(ih0Var);
            floatConfig.setFloatCallbacks(floatCallbacks);
            return this;
        }

        public final Builder registerCallbacks(OnFloatCallbacks onFloatCallbacks) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(onFloatCallbacks, "callbacks");
            this.config.setCallbacks(onFloatCallbacks);
            return this;
        }

        public final Builder setAnimator(OnFloatAnimator onFloatAnimator) {
            this.config.setFloatAnimator(onFloatAnimator);
            return this;
        }

        public final Builder setAppFloatAnimator(OnAppFloatAnimator onAppFloatAnimator) {
            this.config.setAppFloatAnimator(onAppFloatAnimator);
            return this;
        }

        public final Builder setDisplayHeight(OnDisplayHeight onDisplayHeight) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(onDisplayHeight, "displayHeight");
            this.config.setDisplayHeight(onDisplayHeight);
            return this;
        }

        public final Builder setDragEnable(boolean z) {
            this.config.setDragEnable(z);
            return this;
        }

        public final Builder setFilter(Class<?>... clsArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(clsArr, "clazz");
            for (Class<?> cls : clsArr) {
                Set<String> filterSet = this.config.getFilterSet();
                String name = cls.getName();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, "it.name");
                filterSet.add(name);
                if (this.activity instanceof Activity) {
                    String name2 = cls.getName();
                    ComponentName componentName = ((Activity) this.activity).getComponentName();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) componentName, "activity.componentName");
                    if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name2, (Object) componentName.getClassName())) {
                        this.config.setFilterSelf$easyfloat_release(true);
                    }
                }
            }
            return this;
        }

        public final Builder setGravity(int i) {
            return setGravity$default(this, i, 0, 0, 6, null);
        }

        public final Builder setGravity(int i, int i2) {
            return setGravity$default(this, i, i2, 0, 4, null);
        }

        public final Builder setGravity(int i, int i2, int i3) {
            this.config.setGravity(i);
            this.config.setOffsetPair(new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3)));
            return this;
        }

        public final Builder setLayout(int i) {
            return setLayout$default(this, i, null, 2, null);
        }

        public final Builder setLayout(int i, OnInvokeView onInvokeView) {
            this.config.setLayoutId(Integer.valueOf(i));
            this.config.setInvokeView(onInvokeView);
            return this;
        }

        public final Builder setLocation(int i, int i2) {
            this.config.setLocationPair(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            return this;
        }

        public final Builder setMatchParent(boolean z, boolean z2) {
            this.config.setWidthMatch(z);
            this.config.setHeightMatch(z2);
            return this;
        }

        public final Builder setShowPattern(ShowPattern showPattern) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(showPattern, "showPattern");
            this.config.setShowPattern(showPattern);
            return this;
        }

        public final Builder setSidePattern(SidePattern sidePattern) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
            this.config.setSidePattern(sidePattern);
            return this;
        }

        public final Builder setTag(String str) {
            this.config.setFloatTag(str);
            return this;
        }

        public final void show() {
            String str;
            if (this.config.getLayoutId() == null) {
                str = EasyFloatMessageKt.WARN_NO_LAYOUT;
            } else if (!checkUninitialized()) {
                if (this.config.getShowPattern() == ShowPattern.CURRENT_ACTIVITY) {
                    createActivityFloat();
                    return;
                } else if (PermissionUtils.checkPermission(this.activity)) {
                    createAppFloat();
                    return;
                } else {
                    requestPermission();
                    return;
                }
            } else {
                str = EasyFloatMessageKt.WARN_UNINITIALIZED;
            }
            callbackCreateFailed(str);
        }
    }

    @ef0
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public static /* synthetic */ void appFloatDragEnable$default(Companion companion, boolean z, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.appFloatDragEnable(z, str);
        }

        public static /* synthetic */ boolean appFloatIsShow$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.appFloatIsShow(str);
        }

        public static /* synthetic */ of0 clearFilters$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.clearFilters(str);
        }

        public static /* synthetic */ of0 dismiss$default(Companion companion, Activity activity, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.dismiss(activity, str);
        }

        public static /* synthetic */ of0 dismissAppFloat$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.dismissAppFloat(str);
        }

        public static /* synthetic */ Boolean filterActivities$default(Companion companion, String str, Class[] clsArr, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.filterActivities(str, clsArr);
        }

        public static /* synthetic */ Boolean filterActivity$default(Companion companion, Activity activity, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.filterActivity(activity, str);
        }

        public static /* synthetic */ View getAppFloatView$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.getAppFloatView(str);
        }

        private final FloatConfig getConfig(String str) {
            AppFloatManager appFloatManager = FloatManager.INSTANCE.getAppFloatManager(str);
            if (appFloatManager != null) {
                return appFloatManager.getConfig();
            }
            return null;
        }

        private final Set<String> getFilterSet(String str) {
            FloatConfig config = getConfig(str);
            if (config != null) {
                return config.getFilterSet();
            }
            return null;
        }

        public static /* synthetic */ View getFloatView$default(Companion companion, Activity activity, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.getFloatView(activity, str);
        }

        public static /* synthetic */ FloatingView hide$default(Companion companion, Activity activity, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.hide(activity, str);
        }

        public static /* synthetic */ of0 hideAppFloat$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.hideAppFloat(str);
        }

        public static /* synthetic */ void init$default(Companion companion, Application application, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.init(application, z);
        }

        public static /* synthetic */ Boolean isShow$default(Companion companion, Activity activity, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.isShow(activity, str);
        }

        private final ActivityFloatManager manager(Activity activity) {
            if (activity == null) {
                WeakReference weakReference = EasyFloat.activityWr;
                activity = weakReference != null ? (Activity) weakReference.get() : null;
            }
            if (activity != null) {
                return new ActivityFloatManager(activity);
            }
            return null;
        }

        public static /* synthetic */ Boolean removeFilter$default(Companion companion, Activity activity, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.removeFilter(activity, str);
        }

        public static /* synthetic */ Boolean removeFilters$default(Companion companion, String str, Class[] clsArr, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.removeFilters(str, clsArr);
        }

        public static /* synthetic */ of0 setDragEnable$default(Companion companion, Activity activity, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            return companion.setDragEnable(activity, z, str);
        }

        public static /* synthetic */ FloatingView show$default(Companion companion, Activity activity, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.show(activity, str);
        }

        public static /* synthetic */ of0 showAppFloat$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.showAppFloat(str);
        }

        public final void appFloatDragEnable(boolean z) {
            appFloatDragEnable$default(this, z, null, 2, null);
        }

        public final void appFloatDragEnable(boolean z, String str) {
            FloatConfig config = getConfig(str);
            if (config != null) {
                config.setDragEnable(z);
            }
        }

        public final boolean appFloatIsShow() {
            return appFloatIsShow$default(this, null, 1, null);
        }

        public final boolean appFloatIsShow(String str) {
            if (getConfig(str) != null) {
                FloatConfig config = getConfig(str);
                if (config == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (config.isShow()) {
                    return true;
                }
            }
            return false;
        }

        public final of0 clearFilters() {
            return clearFilters$default(this, null, 1, null);
        }

        public final of0 clearFilters(String str) {
            Set<String> filterSet = getFilterSet(str);
            if (filterSet != null) {
                filterSet.clear();
                return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return null;
        }

        public final of0 dismiss() {
            return dismiss$default(this, null, null, 3, null);
        }

        public final of0 dismiss(Activity activity) {
            return dismiss$default(this, activity, null, 2, null);
        }

        public final of0 dismiss(Activity activity, String str) {
            ActivityFloatManager manager = manager(activity);
            if (manager != null) {
                return manager.dismiss(str);
            }
            return null;
        }

        public final of0 dismissAppFloat() {
            return dismissAppFloat$default(this, null, 1, null);
        }

        public final of0 dismissAppFloat(String str) {
            return FloatManager.INSTANCE.dismiss(str);
        }

        public final Boolean filterActivities(String str, Class<?>... clsArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(clsArr, "clazz");
            Set<String> filterSet = getFilterSet(str);
            if (filterSet != null) {
                ArrayList arrayList = new ArrayList(clsArr.length);
                for (Class<?> cls : clsArr) {
                    arrayList.add(cls.getName());
                }
                return Boolean.valueOf(filterSet.addAll(arrayList));
            }
            return null;
        }

        public final Boolean filterActivities(Class<?>... clsArr) {
            return filterActivities$default(this, null, clsArr, 1, null);
        }

        public final Boolean filterActivity(Activity activity) {
            return filterActivity$default(this, activity, null, 2, null);
        }

        public final Boolean filterActivity(Activity activity, String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Set<String> filterSet = getFilterSet(str);
            if (filterSet != null) {
                ComponentName componentName = activity.getComponentName();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) componentName, "activity.componentName");
                String className = componentName.getClassName();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) className, "activity.componentName.className");
                return Boolean.valueOf(filterSet.add(className));
            }
            return null;
        }

        public final View getAppFloatView() {
            return getAppFloatView$default(this, null, 1, null);
        }

        public final View getAppFloatView(String str) {
            FloatConfig config = getConfig(str);
            if (config != null) {
                return config.getLayoutView();
            }
            return null;
        }

        public final View getFloatView() {
            return getFloatView$default(this, null, null, 3, null);
        }

        public final View getFloatView(Activity activity) {
            return getFloatView$default(this, activity, null, 2, null);
        }

        public final View getFloatView(Activity activity, String str) {
            ActivityFloatManager manager = manager(activity);
            if (manager != null) {
                return manager.getFloatView(str);
            }
            return null;
        }

        public final FloatingView hide() {
            return hide$default(this, null, null, 3, null);
        }

        public final FloatingView hide(Activity activity) {
            return hide$default(this, activity, null, 2, null);
        }

        public final FloatingView hide(Activity activity, String str) {
            ActivityFloatManager manager = manager(activity);
            if (manager != null) {
                return manager.setVisibility(str, 8);
            }
            return null;
        }

        public final of0 hideAppFloat() {
            return hideAppFloat$default(this, null, 1, null);
        }

        public final of0 hideAppFloat(String str) {
            return FloatManager.INSTANCE.visible(false, str, false);
        }

        public final void init(Application application) {
            init$default(this, application, false, 2, null);
        }

        public final void init(Application application, boolean z) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(application, "application");
            setDebug$easyfloat_release(z);
            EasyFloat.isInitialized = true;
            LifecycleUtils.INSTANCE.setLifecycleCallbacks(application);
        }

        public final boolean isDebug$easyfloat_release() {
            return EasyFloat.isDebug;
        }

        public final Boolean isShow() {
            return isShow$default(this, null, null, 3, null);
        }

        public final Boolean isShow(Activity activity) {
            return isShow$default(this, activity, null, 2, null);
        }

        public final Boolean isShow(Activity activity, String str) {
            ActivityFloatManager manager = manager(activity);
            if (manager != null) {
                return Boolean.valueOf(manager.isShow(str));
            }
            return null;
        }

        public final Boolean removeFilter(Activity activity) {
            return removeFilter$default(this, activity, null, 2, null);
        }

        public final Boolean removeFilter(Activity activity, String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Set<String> filterSet = getFilterSet(str);
            if (filterSet != null) {
                ComponentName componentName = activity.getComponentName();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) componentName, "activity.componentName");
                return Boolean.valueOf(filterSet.remove(componentName.getClassName()));
            }
            return null;
        }

        public final Boolean removeFilters(String str, Class<?>... clsArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(clsArr, "clazz");
            Set<String> filterSet = getFilterSet(str);
            if (filterSet != null) {
                ArrayList arrayList = new ArrayList(clsArr.length);
                for (Class<?> cls : clsArr) {
                    arrayList.add(cls.getName());
                }
                return Boolean.valueOf(filterSet.removeAll(arrayList));
            }
            return null;
        }

        public final Boolean removeFilters(Class<?>... clsArr) {
            return removeFilters$default(this, null, clsArr, 1, null);
        }

        public final void setDebug$easyfloat_release(boolean z) {
            EasyFloat.isDebug = z;
        }

        public final of0 setDragEnable(Activity activity, boolean z) {
            return setDragEnable$default(this, activity, z, null, 4, null);
        }

        public final of0 setDragEnable(Activity activity, boolean z, String str) {
            ActivityFloatManager manager = manager(activity);
            if (manager != null) {
                manager.setDragEnable(z, str);
                return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return null;
        }

        public final of0 setDragEnable(boolean z) {
            return setDragEnable$default(this, null, z, null, 5, null);
        }

        public final FloatingView show() {
            return show$default(this, null, null, 3, null);
        }

        public final FloatingView show(Activity activity) {
            return show$default(this, activity, null, 2, null);
        }

        public final FloatingView show(Activity activity, String str) {
            ActivityFloatManager manager = manager(activity);
            if (manager != null) {
                return manager.setVisibility(str, 0);
            }
            return null;
        }

        public final of0 showAppFloat() {
            return showAppFloat$default(this, null, 1, null);
        }

        public final of0 showAppFloat(String str) {
            return FloatManager.INSTANCE.visible(true, str, true);
        }

        public final Builder with(Context context) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (context instanceof Activity) {
                EasyFloat.activityWr = new WeakReference(context);
            }
            return new Builder(context);
        }
    }

    public static final void appFloatDragEnable(boolean z) {
        Companion.appFloatDragEnable$default(Companion, z, null, 2, null);
    }

    public static final void appFloatDragEnable(boolean z, String str) {
        Companion.appFloatDragEnable(z, str);
    }

    public static final boolean appFloatIsShow() {
        return Companion.appFloatIsShow$default(Companion, null, 1, null);
    }

    public static final boolean appFloatIsShow(String str) {
        return Companion.appFloatIsShow(str);
    }

    public static final of0 clearFilters() {
        return Companion.clearFilters$default(Companion, null, 1, null);
    }

    public static final of0 clearFilters(String str) {
        return Companion.clearFilters(str);
    }

    public static final of0 dismiss() {
        return Companion.dismiss$default(Companion, null, null, 3, null);
    }

    public static final of0 dismiss(Activity activity) {
        return Companion.dismiss$default(Companion, activity, null, 2, null);
    }

    public static final of0 dismiss(Activity activity, String str) {
        return Companion.dismiss(activity, str);
    }

    public static final of0 dismissAppFloat() {
        return Companion.dismissAppFloat$default(Companion, null, 1, null);
    }

    public static final of0 dismissAppFloat(String str) {
        return Companion.dismissAppFloat(str);
    }

    public static final Boolean filterActivities(String str, Class<?>... clsArr) {
        return Companion.filterActivities(str, clsArr);
    }

    public static final Boolean filterActivities(Class<?>... clsArr) {
        return Companion.filterActivities$default(Companion, null, clsArr, 1, null);
    }

    public static final Boolean filterActivity(Activity activity) {
        return Companion.filterActivity$default(Companion, activity, null, 2, null);
    }

    public static final Boolean filterActivity(Activity activity, String str) {
        return Companion.filterActivity(activity, str);
    }

    public static final View getAppFloatView() {
        return Companion.getAppFloatView$default(Companion, null, 1, null);
    }

    public static final View getAppFloatView(String str) {
        return Companion.getAppFloatView(str);
    }

    public static final View getFloatView() {
        return Companion.getFloatView$default(Companion, null, null, 3, null);
    }

    public static final View getFloatView(Activity activity) {
        return Companion.getFloatView$default(Companion, activity, null, 2, null);
    }

    public static final View getFloatView(Activity activity, String str) {
        return Companion.getFloatView(activity, str);
    }

    public static final FloatingView hide() {
        return Companion.hide$default(Companion, null, null, 3, null);
    }

    public static final FloatingView hide(Activity activity) {
        return Companion.hide$default(Companion, activity, null, 2, null);
    }

    public static final FloatingView hide(Activity activity, String str) {
        return Companion.hide(activity, str);
    }

    public static final of0 hideAppFloat() {
        return Companion.hideAppFloat$default(Companion, null, 1, null);
    }

    public static final of0 hideAppFloat(String str) {
        return Companion.hideAppFloat(str);
    }

    public static final void init(Application application) {
        Companion.init$default(Companion, application, false, 2, null);
    }

    public static final void init(Application application, boolean z) {
        Companion.init(application, z);
    }

    public static final Boolean isShow() {
        return Companion.isShow$default(Companion, null, null, 3, null);
    }

    public static final Boolean isShow(Activity activity) {
        return Companion.isShow$default(Companion, activity, null, 2, null);
    }

    public static final Boolean isShow(Activity activity, String str) {
        return Companion.isShow(activity, str);
    }

    public static final Boolean removeFilter(Activity activity) {
        return Companion.removeFilter$default(Companion, activity, null, 2, null);
    }

    public static final Boolean removeFilter(Activity activity, String str) {
        return Companion.removeFilter(activity, str);
    }

    public static final Boolean removeFilters(String str, Class<?>... clsArr) {
        return Companion.removeFilters(str, clsArr);
    }

    public static final Boolean removeFilters(Class<?>... clsArr) {
        return Companion.removeFilters$default(Companion, null, clsArr, 1, null);
    }

    public static final of0 setDragEnable(Activity activity, boolean z) {
        return Companion.setDragEnable$default(Companion, activity, z, null, 4, null);
    }

    public static final of0 setDragEnable(Activity activity, boolean z, String str) {
        return Companion.setDragEnable(activity, z, str);
    }

    public static final of0 setDragEnable(boolean z) {
        return Companion.setDragEnable$default(Companion, null, z, null, 5, null);
    }

    public static final FloatingView show() {
        return Companion.show$default(Companion, null, null, 3, null);
    }

    public static final FloatingView show(Activity activity) {
        return Companion.show$default(Companion, activity, null, 2, null);
    }

    public static final FloatingView show(Activity activity, String str) {
        return Companion.show(activity, str);
    }

    public static final of0 showAppFloat() {
        return Companion.showAppFloat$default(Companion, null, 1, null);
    }

    public static final of0 showAppFloat(String str) {
        return Companion.showAppFloat(str);
    }

    public static final Builder with(Context context) {
        return Companion.with(context);
    }
}
