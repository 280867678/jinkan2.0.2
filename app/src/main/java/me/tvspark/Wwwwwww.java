package me.tvspark;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes4.dex */
public class Wwwwwww {
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public static Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((ContextWrapper) context).getBaseContext());
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static Window Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        return (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context)).getWindow();
    }

    public static AppCompatActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (!(context instanceof ContextThemeWrapper)) {
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((ContextThemeWrapper) context).getBaseContext());
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        long j2 = j / 1000;
        int i = (int) (j2 % 60);
        int i2 = (int) ((j2 / 60) % 60);
        int i3 = (int) (j2 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return (i3 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)) : formatter.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i))).toString();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, int i) {
        (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) != null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context)).setRequestedOrientation(i);
    }
}
