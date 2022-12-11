package butterknife.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

/* loaded from: classes3.dex */
public abstract class DebouncingOnClickListener implements View.OnClickListener {
    public static final Runnable ENABLE_AGAIN = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final Handler MAIN = new Handler(Looper.getMainLooper());
    public static boolean enabled = true;

    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (enabled) {
            enabled = false;
            MAIN.post(ENABLE_AGAIN);
            doClick(view);
        }
    }
}
