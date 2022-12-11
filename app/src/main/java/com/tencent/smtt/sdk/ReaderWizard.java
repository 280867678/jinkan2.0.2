package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsReaderView;

/* loaded from: classes4.dex */
public class ReaderWizard {

    /* renamed from: a */
    public DexLoader f1781a;

    /* renamed from: b */
    public TbsReaderView.ReaderCallback f1782b;

    public ReaderWizard(TbsReaderView.ReaderCallback readerCallback) {
        this.f1781a = null;
        this.f1782b = null;
        this.f1781a = m2821a();
        this.f1782b = readerCallback;
    }

    /* renamed from: a */
    public static DexLoader m2821a() {
        C1414v m2593c = C1363g.m2597a(true).m2593c();
        if (m2593c != null) {
            return m2593c.m2302b();
        }
        return null;
    }

    public static Drawable getResDrawable(int i) {
        DexLoader m2821a = m2821a();
        if (m2821a != null) {
            Object invokeStaticMethod = m2821a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof Drawable) {
                return (Drawable) invokeStaticMethod;
            }
        }
        return null;
    }

    public static String getResString(int i) {
        DexLoader m2821a = m2821a();
        if (m2821a != null) {
            Object invokeStaticMethod = m2821a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof String) {
                return (String) invokeStaticMethod;
            }
        }
        return "";
    }

    public static boolean isSupportCurrentPlatform(Context context) {
        DexLoader m2821a = m2821a();
        if (m2821a != null) {
            Object invokeStaticMethod = m2821a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
            if (!(invokeStaticMethod instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }

    public static boolean isSupportExt(String str) {
        DexLoader m2821a = m2821a();
        if (m2821a != null) {
            Object invokeStaticMethod = m2821a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
            if (!(invokeStaticMethod instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }

    public boolean checkPlugin(Object obj, Context context, String str, boolean z) {
        DexLoader dexLoader = this.f1781a;
        if (dexLoader == null) {
            return false;
        }
        Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z));
        if (invokeMethod instanceof Boolean) {
            return ((Boolean) invokeMethod).booleanValue();
        }
        return false;
    }

    public void destroy(Object obj) {
        this.f1782b = null;
        DexLoader dexLoader = this.f1781a;
        if (dexLoader == null || obj == null) {
            return;
        }
        dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
    }

    public void doCommand(Object obj, Integer num, Object obj2, Object obj3) {
        DexLoader dexLoader = this.f1781a;
        if (dexLoader == null) {
            return;
        }
        dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, new Integer(num.intValue()), obj2, obj3);
    }

    public Object getTbsReader() {
        return this.f1781a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    }

    public boolean initTbsReader(Object obj, Context context) {
        DexLoader dexLoader = this.f1781a;
        if (dexLoader == null || obj == null) {
            return false;
        }
        Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "init", new Class[]{Context.class, DexLoader.class, Object.class}, context, dexLoader, this);
        if (invokeMethod instanceof Boolean) {
            return ((Boolean) invokeMethod).booleanValue();
        }
        return false;
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        TbsReaderView.ReaderCallback readerCallback = this.f1782b;
        if (readerCallback != null) {
            readerCallback.onCallBackAction(num, obj, obj2);
        }
    }

    public void onSizeChanged(Object obj, int i, int i2) {
        DexLoader dexLoader = this.f1781a;
        if (dexLoader == null) {
            return;
        }
        dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, new Integer(i), new Integer(i2));
    }

    public boolean openFile(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        DexLoader dexLoader = this.f1781a;
        if (dexLoader == null) {
            return false;
        }
        Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
        if (invokeMethod instanceof Boolean) {
            return ((Boolean) invokeMethod).booleanValue();
        }
        return false;
    }

    public void userStatistics(Object obj, String str) {
        DexLoader dexLoader = this.f1781a;
        if (dexLoader == null) {
            return;
        }
        dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
    }
}
