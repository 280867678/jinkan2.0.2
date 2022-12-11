package me.tvspark;

import android.text.TextUtils;
import java.util.HashMap;
import org.eclipse.jetty.server.AsyncContinuation;

/* loaded from: classes4.dex */
public class ln0 implements sk0 {
    public static ln0 Wwwwwwwwwwwwwwwwwwwwwww;
    public HashMap<String, Long> Wwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();

    public static ln0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (ln0.class) {
                if (Wwwwwwwwwwwwwwwwwwwwwww == null) {
                    Wwwwwwwwwwwwwwwwwwwwwww = new ln0();
                }
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String.format(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, " onNoAD，eCode = %d, eMsg = %s"), Integer.valueOf(i), str);
        if (i != 6000 || TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.contains("102006") && !str.contains("112001") && !str.contains("109502")) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.put(str2, Long.valueOf(System.currentTimeMillis()));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.containsKey(str)) {
                if (System.currentTimeMillis() - this.Wwwwwwwwwwwwwwwwwwwwwwww.get(str).longValue() < AsyncContinuation.DEFAULT_TIMEOUT) {
                    return true;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(str);
                return false;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
