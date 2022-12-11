package me.tvspark;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;

/* loaded from: classes4.dex */
public class bo0 implements sk0 {
    public static SharedPreferences.Editor Wwwwwwwwwwwwwwwwwwwwwww;
    public static SharedPreferences Wwwwwwwwwwwwwwwwwwwwwwww;

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        return Wwwwwwwwwwwwwwwwwwwwwwww.getString("save_path_root", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return context.getExternalFilesDir("").getPath() + "/";
        }
        return Environment.getExternalStorageDirectory().getPath() + "/鲸看/";
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return Wwwwwwwwwwwwwwwwwwwwwwww.getString(str, "");
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("conf_url_url", 1);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return Wwwwwwwwwwwwwwwwwwwwwwww.getInt(str, 0);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwww.getInt(str, i);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.deleteFile(qn0.Wwwwwwwwwwwwwwwwww);
        context.deleteFile(qn0.Wwwwwwwwwwwwwwwwwww);
        context.deleteFile(qn0.Wwwwwwwwwwwwwwwww + 1);
        context.deleteFile(qn0.Wwwwwwwwwwwwwwwww + 2);
        context.deleteFile(qn0.Wwwwwwwwwwwwwwwww + 3);
        context.deleteFile(qn0.Wwwwwwwwwwwwwwwww + 4);
        Wwwwwwwwwwwwwwwwwwwwwww.remove("last_select_pos");
        Wwwwwwwwwwwwwwwwwwwwwww.commit();
    }

    public static <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, T t) {
        if (t instanceof String) {
            Wwwwwwwwwwwwwwwwwwwwwww.putString(str, (String) t);
        } else if (t instanceof Boolean) {
            Wwwwwwwwwwwwwwwwwwwwwww.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Integer) {
            Wwwwwwwwwwwwwwwwwwwwwww.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            Wwwwwwwwwwwwwwwwwwwwwww.putLong(str, ((Long) t).longValue());
        } else if (t instanceof Float) {
            Wwwwwwwwwwwwwwwwwwwwwww.putFloat(str, ((Float) t).floatValue());
        }
        Wwwwwwwwwwwwwwwwwwwwwww.commit();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z) {
        return Wwwwwwwwwwwwwwwwwwwwwwww.getBoolean(str, z);
    }
}
