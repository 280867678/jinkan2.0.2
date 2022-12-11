package com.p024jg.ids;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.just.agentweb.RomUtils;
import com.p024jg.ids.meizu.C0985c;
import com.p024jg.ids.p025a.C0933a;
import com.p024jg.ids.p026b.C0938a;
import com.p024jg.ids.p027c.C0943a;
import com.p024jg.ids.p028d.C0945a;
import com.p024jg.ids.p029e.C0950a;
import com.p024jg.ids.p030f.C0955a;
import com.p024jg.ids.p031g.C0963d;
import com.p024jg.ids.p032h.C0965a;
import com.p024jg.ids.p033i.C0973d;
import com.p024jg.ids.p034j.C0978d;
import com.p024jg.ids.p035k.C0980a;
import com.p024jg.ids.p036l.C0982a;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.IdsHelper */
/* loaded from: classes6.dex */
public class IdsHelper {
    public static Context CONTEXT = null;
    private static final IdsHelper ourInstance = new IdsHelper();
    private AbstractC0969i provider = null;

    public static IdsHelper getInstance() {
        return ourInstance;
    }

    private IdsHelper() {
    }

    public void init(Context context) {
        boolean z = true;
        if (context != null && this.provider == null) {
            C0979k.m3734a().m3733a(context);
            CONTEXT = context;
            if (!(Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI"))) {
                if (!(!TextUtils.isEmpty(C0974j.m3741a("ro.miui.ui.version.name", "")))) {
                    if (!(Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK"))) {
                        if (Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(C0974j.m3741a("ro.vivo.os.version", ""))) {
                            this.provider = new C0980a(context, "100215079");
                        } else {
                            if (!(Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HONOR"))) {
                                if (!(!TextUtils.isEmpty(C0974j.m3741a(RomUtils.VERSION_PROPERTY_HUAWEI, "")))) {
                                    if (!(Build.MANUFACTURER.equalsIgnoreCase("OPPO") || Build.BRAND.equalsIgnoreCase("OPPO") || Build.BRAND.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(C0974j.m3741a("ro.build.version.opporom", "")))) {
                                        if (!(Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS"))) {
                                            if (!(Build.MANUFACTURER.equalsIgnoreCase("LENOVO") || Build.BRAND.equalsIgnoreCase("LENOVO") || Build.BRAND.equalsIgnoreCase("ZUK"))) {
                                                if (!(Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA"))) {
                                                    if (Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS")) {
                                                        this.provider = new C0933a(context);
                                                    } else {
                                                        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
                                                            this.provider = new C0978d(context);
                                                        } else {
                                                            if ((Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME")) || Build.MANUFACTURER.equalsIgnoreCase("alps")) {
                                                                this.provider = new C0985c(context);
                                                            } else {
                                                                if (Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA")) {
                                                                    this.provider = new C0965a(context);
                                                                } else if (C0974j.m3742a(context)) {
                                                                    this.provider = new C0938a(context);
                                                                } else if (C0974j.m3741a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE")) {
                                                                    this.provider = new C0943a(context);
                                                                } else {
                                                                    if (TextUtils.isEmpty(C0974j.m3741a("ro.build.freeme.label", ""))) {
                                                                        z = false;
                                                                    }
                                                                    if (z) {
                                                                        this.provider = new C0945a(context);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            this.provider = new C0963d(context);
                                        }
                                    }
                                    this.provider = new C0973d(context);
                                }
                            }
                            this.provider = new C0955a(context);
                        }
                        if (this.provider != null || !this.provider.mo3706d()) {
                            this.provider = new C0950a(context);
                        }
                        return;
                    }
                }
            }
            this.provider = new C0982a();
            if (this.provider != null) {
            }
            this.provider = new C0950a(context);
        }
    }

    public String getOAID() {
        if (this.provider == null) {
            return "";
        }
        return this.provider.mo3721b(CONTEXT);
    }

    public String getVAID() {
        return this.provider != null ? this.provider.mo3723a(CONTEXT) : "";
    }

    public String getAAID() {
        return this.provider != null ? this.provider.mo3720c(CONTEXT) : "";
    }
}
