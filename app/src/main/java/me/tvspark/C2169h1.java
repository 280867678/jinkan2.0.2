package me.tvspark;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: me.tvspark.h1 */
/* loaded from: classes4.dex */
public final class C2169h1 {
    public static final ConcurrentMap<String, Illlllllllllllllllllllllllll> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ConcurrentHashMap();

    @NonNull
    public static Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        PackageInfo packageInfo;
        String packageName = context.getPackageName();
        Illlllllllllllllllllllllllll illlllllllllllllllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(packageName);
        if (illlllllllllllllllllllllllll == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                context.getPackageName();
                packageInfo = null;
            }
            C2243j1 c2243j1 = new C2243j1(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
            Illlllllllllllllllllllllllll putIfAbsent = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putIfAbsent(packageName, c2243j1);
            return putIfAbsent == null ? c2243j1 : putIfAbsent;
        }
        return illlllllllllllllllllllllllll;
    }
}
