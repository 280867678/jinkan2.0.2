package com.lzf.easyfloat.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.lzf.easyfloat.widget.appfloat.AppFloatManager;
import com.lzf.easyfloat.widget.appfloat.FloatManager;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.of0;

@ef0
/* loaded from: classes3.dex */
public final class InputMethodUtils {
    public static final InputMethodUtils INSTANCE = new InputMethodUtils();

    public static final of0 closedInputMethod() {
        return closedInputMethod$default(null, 1, null);
    }

    public static final of0 closedInputMethod(String str) {
        AppFloatManager appFloatManager = FloatManager.INSTANCE.getAppFloatManager(str);
        if (appFloatManager != null) {
            appFloatManager.getParams().flags = 40;
            appFloatManager.getWindowManager().updateViewLayout(appFloatManager.getFrameLayout(), appFloatManager.getParams());
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    public static /* synthetic */ of0 closedInputMethod$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return closedInputMethod(str);
    }

    public static final void openInputMethod(EditText editText) {
        openInputMethod$default(editText, null, 2, null);
    }

    public static final void openInputMethod(final EditText editText, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText, "editText");
        AppFloatManager appFloatManager = FloatManager.INSTANCE.getAppFloatManager(str);
        if (appFloatManager != null) {
            appFloatManager.getParams().flags = 32;
            appFloatManager.getWindowManager().updateViewLayout(appFloatManager.getFrameLayout(), appFloatManager.getParams());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.lzf.easyfloat.utils.InputMethodUtils$openInputMethod$2
            @Override // java.lang.Runnable
            public final void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }
        }, 100L);
    }

    public static /* synthetic */ void openInputMethod$default(EditText editText, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        openInputMethod(editText, str);
    }
}
