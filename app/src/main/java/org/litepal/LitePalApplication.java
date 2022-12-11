package org.litepal;

import android.app.Application;
import android.content.Context;
import org.litepal.exceptions.GlobalException;

/* loaded from: classes5.dex */
public class LitePalApplication extends Application {
    public static Context sContext;

    public LitePalApplication() {
        sContext = this;
    }

    public static Context getContext() {
        Context context = sContext;
        if (context != null) {
            return context;
        }
        throw new GlobalException(GlobalException.APPLICATION_CONTEXT_IS_NULL);
    }
}
