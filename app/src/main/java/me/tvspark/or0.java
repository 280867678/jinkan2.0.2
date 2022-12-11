package me.tvspark;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class or0 {
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Field Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        try {
            Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, boolean z) {
        Method method = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z));
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return;
            }
        }
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 23) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Field declaredField = attributes.getClass().getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                declaredField.setAccessible(true);
                int i = declaredField.getInt(attributes);
                Field declaredField2 = attributes.getClass().getDeclaredField("meizuFlags");
                declaredField2.setAccessible(true);
                int i2 = declaredField2.getInt(attributes);
                int i3 = z ? i | i2 : (~i) & i2;
                if (i2 == i3) {
                    return;
                }
                declaredField2.setInt(attributes, i3);
                return;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                return;
            } catch (NoSuchFieldException e5) {
                e5.printStackTrace();
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        View decorView = window.getDecorView();
        if (decorView == null) {
            return;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i4 = z ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww | systemUiVisibility : (~Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) & systemUiVisibility;
        if (i4 != systemUiVisibility) {
            decorView.setSystemUiVisibility(i4);
        }
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        Field field = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (field == null) {
            return;
        }
        try {
            if (field.getInt(attributes2) == 0) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(attributes2, 0);
            window.setAttributes(attributes2);
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        }
    }
}
