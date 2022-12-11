package me.tvspark;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import me.tvspark.nn0;

/* loaded from: classes4.dex */
public final class on0 implements Runnable {
    public final /* synthetic */ nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwww;

    public on0(Activity activity, nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        ClipboardManager clipboardManager = (ClipboardManager) this.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard");
        if (clipboardManager == null || !clipboardManager.hasPrimaryClip() || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() < 1 || (itemAt = primaryClip.getItemAt(0)) == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            return;
        }
        CharSequence text = itemAt.getText();
        if (TextUtils.isEmpty(text)) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(text.toString());
        }
    }
}
