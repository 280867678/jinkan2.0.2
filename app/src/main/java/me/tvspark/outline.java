package me.tvspark;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.tencent.bugly.proguard.C1223k;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.commonsdk.debug.UMLogUtils;
import java.io.File;
import me.tvspark.C2245j3;
import me.tvspark.data.bean.GenreParcel;

/* renamed from: me.tvspark.Wwww */
/* loaded from: classes4.dex */
public class outline {
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
        return ((i + i2) * i3) + i4;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity) {
        return activity.getWindowManager().getDefaultDisplay().getWidth();
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x41 x41Var, int i, int i2) {
        return x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + i + i2;
    }

    public static View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, z);
    }

    public static VideoOption Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i, boolean z2) {
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.build();
        return builder.setAutoPlayMuted(z).setAutoPlayPolicy(i).setDetailPageMuted(z2).build();
    }

    public static C1223k.C1224a Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1223k c1223k) {
        C1223k.C1224a c1224a = new C1223k.C1224a();
        c1223k.m2935a(c1224a);
        return c1224a;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
        return str + i;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, int i2) {
        return str.substring(i2, str.length() + i);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2, int i2, String str3) {
        return str + i + str2 + i2 + str3;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j) {
        return str + j;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Uri uri) {
        return str + uri;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, File file) {
        return str + file;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, File file, String str2) {
        return str + file + str2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Class cls) {
        return str + cls;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Exception exc) {
        return str + exc;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object obj) {
        return str + obj;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        return str + str2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, StringBuilder sb) {
        sb.append(UMLogUtils.makeUrl(str));
        return sb.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        return sb;
    }

    public static StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, StringBuilder sb, String str2) {
        sb.append(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        sb.append(str2);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Throwable th) {
        String str2 = str + th;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z, String str2) {
        TbsLog.m2155i(str2, str + z);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, StringBuilder sb, String str) {
        sb.append(Log.getStackTraceString(th));
        TbsLog.m2155i(str, sb.toString());
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel, StringBuilder sb, String str) {
        sb.append(genreParcel.getName());
        sb.append(str);
    }
}
