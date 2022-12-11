package com.arialyy.aria.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.widget.PopupWindow;
import com.arialyy.aria.core.download.DownloadReceiver;
import com.arialyy.aria.core.upload.UploadReceiver;
import com.arialyy.aria.util.ALog;

@TargetApi(15)
/* loaded from: classes3.dex */
public class Aria {
    public static Context convertContext(Object obj) {
        if (obj instanceof Application) {
            return (Application) obj;
        }
        if (obj instanceof Service) {
            return (Service) obj;
        }
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        if (AriaManager.isFragment(obj.getClass())) {
            return AriaManager.getFragmentActivity(obj);
        }
        if (obj instanceof Dialog) {
            return ((Dialog) obj).getContext();
        }
        if (obj instanceof PopupWindow) {
            return ((PopupWindow) obj).getContentView().getContext();
        }
        ALog.m4191e("Aria", "请使用download(this)或upload(this)");
        return null;
    }

    public static DownloadReceiver download(Object obj) {
        return (AriaManager.getInstance() != null ? AriaManager.getInstance() : get(convertContext(obj))).download(obj);
    }

    public static AriaManager get(Context context) {
        if (context != null) {
            return AriaManager.init(context);
        }
        throw new NullPointerException("context 无效，在非【Activity、Service、Application、DialogFragment、Fragment、PopupWindow、Dialog】，请参考【https://aria.laoyuyu.me/aria_doc/create/any_java.html】，参数请使用 download(this) 或 upload(this);不要使用 download(getContext()) 或 upload(getContext())");
    }

    public static AriaManager init(Context context) {
        return get(context);
    }

    public static UploadReceiver upload(Object obj) {
        return (AriaManager.getInstance() != null ? AriaManager.getInstance() : get(convertContext(obj))).upload(obj);
    }
}
