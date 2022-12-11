package me.tvspark;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;

/* renamed from: me.tvspark.yk */
/* loaded from: classes4.dex */
public final class C2827yk {
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, @Nullable Throwable th) {
        boolean z;
        String replace;
        if (th == null) {
            replace = null;
        } else {
            Throwable th2 = th;
            while (true) {
                if (th2 == null) {
                    z = false;
                    break;
                } else if (th2 instanceof UnknownHostException) {
                    z = true;
                    break;
                } else {
                    th2 = th2.getCause();
                }
            }
            replace = z ? "UnknownHostException (no network)" : Log.getStackTraceString(th).trim().replace("\t", "    ");
        }
        if (!TextUtils.isEmpty(replace)) {
            String valueOf = String.valueOf(str);
            String replace2 = replace.replace("\n", "\n  ");
            StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replace2, valueOf.length() + 4));
            sb.append(valueOf);
            sb.append("\n  ");
            sb.append(replace2);
            sb.append('\n');
            return sb.toString();
        }
        return str;
    }
}
