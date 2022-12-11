package androidx.core.p003os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* renamed from: androidx.core.os.ProcessCompat */
/* loaded from: classes3.dex */
public final class ProcessCompat {

    @RequiresApi(16)
    /* renamed from: androidx.core.os.ProcessCompat$Api16Impl */
    /* loaded from: classes3.dex */
    public static class Api16Impl {
        public static Method sMethodUserIdIsAppMethod;
        public static boolean sResolved;
        public static final Object sResolvedLock = new Object();

        @SuppressLint({"PrivateApi"})
        public static boolean isApplicationUid(int i) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                if (sMethodUserIdIsAppMethod != null) {
                    Boolean bool = (Boolean) sMethodUserIdIsAppMethod.invoke(null, Integer.valueOf(i));
                    if (bool == null) {
                        throw new NullPointerException();
                    }
                    return bool.booleanValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(17)
    /* renamed from: androidx.core.os.ProcessCompat$Api17Impl */
    /* loaded from: classes3.dex */
    public static class Api17Impl {
        public static Method sMethodUserHandleIsAppMethod;
        public static boolean sResolved;
        public static final Object sResolvedLock = new Object();

        @SuppressLint({"DiscouragedPrivateApi"})
        public static boolean isApplicationUid(int i) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                if (sMethodUserHandleIsAppMethod != null && ((Boolean) sMethodUserHandleIsAppMethod.invoke(null, Integer.valueOf(i))) == null) {
                    throw new NullPointerException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(24)
    /* renamed from: androidx.core.os.ProcessCompat$Api24Impl */
    /* loaded from: classes3.dex */
    public static class Api24Impl {
        public static boolean isApplicationUid(int i) {
            return Process.isApplicationUid(i);
        }
    }

    public static boolean isApplicationUid(int i) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.isApplicationUid(i) : Api17Impl.isApplicationUid(i);
    }
}
