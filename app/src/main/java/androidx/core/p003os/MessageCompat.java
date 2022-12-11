package androidx.core.p003os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;

/* renamed from: androidx.core.os.MessageCompat */
/* loaded from: classes3.dex */
public final class MessageCompat {
    public static boolean sTryIsAsynchronous = true;
    public static boolean sTrySetAsynchronous = true;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
        androidx.core.p003os.MessageCompat.sTryIsAsynchronous = false;
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isAsynchronous(@NonNull Message message) {
        if (Build.VERSION.SDK_INT < 22 && !sTryIsAsynchronous) {
            return false;
        }
        return message.isAsynchronous();
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z) {
        if (Build.VERSION.SDK_INT >= 22) {
            message.setAsynchronous(z);
        } else if (!sTrySetAsynchronous) {
        } else {
            try {
                message.setAsynchronous(z);
            } catch (NoSuchMethodError unused) {
                sTrySetAsynchronous = false;
            }
        }
    }
}
