package me.tvspark;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.InputDeviceCompat;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
public final class a30 {
    public static Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static v20 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public v20 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public a30(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
    }

    public a30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String... strArr) {
        ArrayList<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) strArr);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                for (String str : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(str)) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(str);
                    }
                }
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0171 A[EXC_TOP_SPLITTER, LOOP:5: B:259:0x0171->B:264:0x018a, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(w20 w20Var) {
        Activity activity;
        boolean z;
        boolean z2;
        Activity activity2;
        String str;
        String str2;
        XmlResourceParser Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str3;
        String str4;
        boolean z3;
        PackageManager packageManager;
        Bundle bundle;
        Context context;
        int i;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new z20();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        ArrayList arrayList = new ArrayList(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Context context2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Boolean.valueOf((context2.getApplicationInfo().flags & 2) != 0);
        }
        boolean booleanValue = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.booleanValue();
        Context context3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (!(context3 instanceof Activity)) {
            if (!(context3 instanceof ContextWrapper) || (context3 = ((ContextWrapper) context3).getBaseContext()) == null) {
                activity = null;
                break;
            }
            while (!(context3 instanceof Activity)) {
            }
        }
        activity = (Activity) context3;
        if (activity == null) {
            if (booleanValue) {
                throw new IllegalArgumentException("The instance of the context must be an activity object");
            }
        } else if (activity.isFinishing()) {
            if (booleanValue) {
                throw new IllegalStateException("The activity has been finishing, please manually determine the status of the activity");
            }
        } else if (!activity.isDestroyed()) {
            z = true;
            if (z) {
                return;
            }
            if (!arrayList.isEmpty()) {
                if (booleanValue) {
                    ArrayList arrayList2 = new ArrayList();
                    Field[] declaredFields = x20.class.getDeclaredFields();
                    if (declaredFields.length != 0) {
                        for (Field field : declaredFields) {
                            if (String.class.equals(field.getType())) {
                                try {
                                    arrayList2.add((String) field.get(null));
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str5 = (String) it.next();
                            if (!arrayList2.contains(str5)) {
                                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The ", str5, " is not a dangerous permission or special permission, please do not apply dynamically"));
                            }
                        }
                    }
                }
                z2 = true;
            } else if (booleanValue) {
                throw new IllegalArgumentException("The requested permission cannot be empty");
            } else {
                z2 = false;
            }
            if (!z2) {
                return;
            }
            if (booleanValue) {
                activity2 = activity;
                Context context4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (arrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE") || arrayList.contains("android.permission.READ_EXTERNAL_STORAGE") || arrayList.contains(UMUtils.SD_PERMISSION)) {
                    try {
                        packageManager = context4.getPackageManager();
                        str = UMUtils.SD_PERMISSION;
                    } catch (PackageManager.NameNotFoundException e2) {
                        e = e2;
                        str = UMUtils.SD_PERMISSION;
                    }
                    try {
                        str2 = "android.permission.READ_EXTERNAL_STORAGE";
                    } catch (PackageManager.NameNotFoundException e3) {
                        e = e3;
                        str2 = "android.permission.READ_EXTERNAL_STORAGE";
                        e.printStackTrace();
                        z3 = false;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(context4);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        }
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getApplicationInfo().targetSdkVersion < 31) {
                        }
                        if (arrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                        }
                        context = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (!arrayList.contains("android.permission.BLUETOOTH_SCAN")) {
                        }
                        if (context.getApplicationInfo().targetSdkVersion < i) {
                        }
                        if (booleanValue) {
                        }
                        String str6 = str;
                        String str7 = str2;
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                        }
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                        }
                        if (arrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                        }
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            arrayList.add("android.permission.READ_PHONE_STATE");
                        }
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            arrayList.add("android.permission.BODY_SENSORS");
                        }
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (List<String>) arrayList)) {
                        }
                    }
                    try {
                        bundle = packageManager.getApplicationInfo(context4.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException e4) {
                        e = e4;
                        e.printStackTrace();
                        z3 = false;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(context4);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        }
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getApplicationInfo().targetSdkVersion < 31) {
                        }
                        if (arrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                        }
                        context = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (!arrayList.contains("android.permission.BLUETOOTH_SCAN")) {
                        }
                        if (context.getApplicationInfo().targetSdkVersion < i) {
                        }
                        if (booleanValue) {
                        }
                        String str62 = str;
                        String str72 = str2;
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        }
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        }
                        if (arrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                        }
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        }
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        }
                        if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (List<String>) arrayList)) {
                        }
                    }
                    if (bundle != null && bundle.containsKey("ScopedStorage")) {
                        z3 = Boolean.parseBoolean(String.valueOf(bundle.get("ScopedStorage")));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(context4);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            while (true) {
                                try {
                                    try {
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getEventType() == 2 && "application".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getName())) {
                                            int i2 = context4.getApplicationInfo().targetSdkVersion;
                                            boolean attributeBooleanValue = Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getAttributeBooleanValue(TypedArrayUtils.NAMESPACE, "requestLegacyExternalStorage", false);
                                            if (i2 >= 29 && !attributeBooleanValue && (arrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE") || !z3)) {
                                                throw new IllegalStateException("Please register the android:requestLegacyExternalStorage=\"true\" attribute in the AndroidManifest.xml file");
                                            }
                                            if (i2 >= 30 && !arrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE") && !z3) {
                                                throw new IllegalArgumentException("Please adapt the scoped storage, or use the MANAGE_EXTERNAL_STORAGE permission");
                                            }
                                        }
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.next() == 1) {
                                            break;
                                        }
                                    } finally {
                                    }
                                } catch (IOException | XmlPullParserException e5) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    }
                    z3 = false;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(context4);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    }
                } else {
                    str = UMUtils.SD_PERMISSION;
                    str2 = "android.permission.READ_EXTERNAL_STORAGE";
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getApplicationInfo().targetSdkVersion < 31 && arrayList.contains("android.permission.ACCESS_FINE_LOCATION") && !arrayList.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                    throw new IllegalArgumentException("If your app targets Android 12 or higher and requests the ACCESS_FINE_LOCATION runtime permission, you must also request the ACCESS_COARSE_LOCATION permission. You must include both permissions in a single runtime request.");
                }
                if (arrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    if (arrayList.contains("android.permission.ACCESS_COARSE_LOCATION") && !arrayList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                        throw new IllegalArgumentException("The application for background location permissions must include precise location permissions");
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        String str8 = (String) it2.next();
                        if (!"android.permission.ACCESS_FINE_LOCATION".equals(str8) && !"android.permission.ACCESS_COARSE_LOCATION".equals(str8) && !"android.permission.ACCESS_BACKGROUND_LOCATION".equals(str8)) {
                            throw new IllegalArgumentException("Because it includes background location permissions, do not apply for permissions unrelated to location");
                        }
                    }
                }
                context = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i = (!arrayList.contains("android.permission.BLUETOOTH_SCAN") || arrayList.contains("android.permission.BLUETOOTH_CONNECT") || arrayList.contains("android.permission.BLUETOOTH_ADVERTISE")) ? 31 : arrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE") ? 30 : arrayList.contains("android.permission.ACCEPT_HANDOVER") ? 28 : (arrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION") || arrayList.contains("android.permission.ACTIVITY_RECOGNITION") || arrayList.contains("android.permission.ACCESS_MEDIA_LOCATION")) ? 29 : (arrayList.contains("android.permission.REQUEST_INSTALL_PACKAGES") || arrayList.contains("android.permission.ANSWER_PHONE_CALLS") || arrayList.contains("android.permission.READ_PHONE_NUMBERS")) ? 26 : 23;
                if (context.getApplicationInfo().targetSdkVersion < i) {
                    throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The targetSdkVersion SDK must be ", i, " or more"));
                }
            } else {
                activity2 = activity;
                str = UMUtils.SD_PERMISSION;
                str2 = "android.permission.READ_EXTERNAL_STORAGE";
            }
            if (booleanValue) {
                Context context5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                HashMap hashMap = new HashMap();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(context5);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    while (true) {
                        try {
                            try {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getEventType() == 2 && "uses-permission".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getName())) {
                                    hashMap.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getAttributeValue(TypedArrayUtils.NAMESPACE, "name"), Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getAttributeIntValue(TypedArrayUtils.NAMESPACE, "maxSdkVersion", Integer.MAX_VALUE)));
                                }
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.next() == 1) {
                                    break;
                                }
                            } finally {
                            }
                        } catch (IOException | XmlPullParserException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    try {
                        String[] strArr = context5.getPackageManager().getPackageInfo(context5.getPackageName(), 4096).requestedPermissions;
                        if (strArr != null) {
                            for (String str9 : strArr) {
                                hashMap.put(str9, Integer.MAX_VALUE);
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e7) {
                        e7.printStackTrace();
                    }
                }
                if (hashMap.isEmpty()) {
                    throw new IllegalStateException("No permissions are registered in the AndroidManifest.xml file");
                }
                int i3 = Build.VERSION.SDK_INT >= 24 ? context5.getApplicationInfo().minSdkVersion : 23;
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    String str10 = (String) it3.next();
                    if (!"android.permission.NOTIFICATION_SERVICE".equals(str10)) {
                        if (31 >= i3) {
                            if ("android.permission.BLUETOOTH_SCAN".equals(str10)) {
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, "android.permission.BLUETOOTH_ADMIN", 31);
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, "android.permission.ACCESS_COARSE_LOCATION", 31);
                            }
                            if ("android.permission.BLUETOOTH_CONNECT".equals(str10)) {
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, "android.permission.BLUETOOTH", 31);
                            }
                            if ("android.permission.BLUETOOTH_ADVERTISE".equals(str10)) {
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, "android.permission.BLUETOOTH_ADMIN", 31);
                            }
                        }
                        if (30 < i3 || !"android.permission.MANAGE_EXTERNAL_STORAGE".equals(str10)) {
                            str3 = str;
                            str4 = str2;
                        } else {
                            str4 = str2;
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, str4, 30);
                            str3 = str;
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, str3, 30);
                        }
                        if (29 >= i3 && "android.permission.ACTIVITY_RECOGNITION".equals(str10)) {
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, "android.permission.BODY_SENSORS", 29);
                        }
                        if (26 >= i3 && "android.permission.READ_PHONE_NUMBERS".equals(str10)) {
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, "android.permission.READ_PHONE_NUMBERS", 26);
                        }
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hashMap, str10, Integer.MAX_VALUE);
                        str2 = str4;
                        str = str3;
                    }
                }
            }
            String str622 = str;
            String str722 = str2;
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && arrayList.contains("android.permission.BLUETOOTH_SCAN") && !arrayList.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && arrayList.contains("android.permission.BLUETOOTH_SCAN")) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            if (arrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                if (arrayList.contains(str722) || arrayList.contains(str622)) {
                    throw new IllegalArgumentException("If you have applied for MANAGE_EXTERNAL_STORAGE permissions, do not apply for the READ_EXTERNAL_STORAGE and WRITE_EXTERNAL_STORAGE permissions");
                }
                if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    arrayList.add(str722);
                    arrayList.add(str622);
                }
            }
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() && arrayList.contains("android.permission.READ_PHONE_NUMBERS") && !arrayList.contains("android.permission.READ_PHONE_STATE")) {
                arrayList.add("android.permission.READ_PHONE_STATE");
            }
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && arrayList.contains("android.permission.ACTIVITY_RECOGNITION") && !arrayList.contains("android.permission.BODY_SENSORS")) {
                arrayList.add("android.permission.BODY_SENSORS");
            }
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (List<String>) arrayList)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity2, w20Var, arrayList);
                return;
            } else if (w20Var == null) {
                return;
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity2, w20Var, arrayList, true);
                return;
            }
        } else if (booleanValue) {
            throw new IllegalStateException("The activity has been destroyed, please manually determine the status of the activity");
        }
        z = false;
        if (z) {
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, List<String> list) {
        activity.startActivityForResult(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) activity, list), InputDeviceCompat.SOURCE_GAMEPAD);
    }
}
