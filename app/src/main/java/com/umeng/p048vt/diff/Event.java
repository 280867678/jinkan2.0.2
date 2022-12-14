package com.umeng.p048vt.diff;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.p048vt.diff.util.ClassLoadUtil;
import com.umeng.tunnel.UMChannelAgent;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: com.umeng.vt.diff.Event */
/* loaded from: classes4.dex */
public class Event {
    public static final int MAX_PROPERTY_LENGTH = 128;

    public static void commit(Context context, View view, String str, Map<String, Object> map, Boolean bool) {
        Class<?> cls;
        Class<?> cls2;
        if (!bool.booleanValue()) {
            if (view != null) {
                String textPropertyFromView = textPropertyFromView(view);
                if (!TextUtils.isEmpty(textPropertyFromView)) {
                    map.put(C1865V.VISUAL_TRACK_TEXT, textPropertyFromView);
                }
                cls = view.getContext().getClass();
            } else {
                cls = context.getClass();
            }
            map.put(C1865V.VISUAL_TRACK_PG, cls.getName());
            map.put(C1865V.VISUAL_TRACK_STYLE, 1);
            map.put(C1865V.VISUAL_TRACK_UAPP_PG, getPageName());
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "release:事件名: " + str);
            if (map.containsKey(C1865V.VISUAL_TRACK_TEXT)) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; 参数：" + ((String) map.get(C1865V.VISUAL_TRACK_TEXT)));
            }
            if (map.containsKey(C1865V.VISUAL_TRACK_PG)) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; 页面：" + ((String) map.get(C1865V.VISUAL_TRACK_PG)));
            }
            if (map.containsKey(C1865V.VISUAL_TRACK_UAPP_PG)) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; UApp页面路径：" + ((String) map.get(C1865V.VISUAL_TRACK_UAPP_PG)));
            }
            MobclickAgent.onEventObject(context, str, map);
        } else if (!UMChannelAgent.init()) {
        } else {
            if (view != null) {
                String textPropertyFromView2 = textPropertyFromView(view);
                if (!TextUtils.isEmpty(textPropertyFromView2)) {
                    map.put(C1865V.VISUAL_TRACK_TEXT, textPropertyFromView2);
                }
                cls2 = view.getContext().getClass();
            } else {
                cls2 = context.getClass();
            }
            map.put(C1865V.VISUAL_TRACK_PG, cls2.getName());
            map.put(C1865V.VISUAL_TRACK_STYLE, 1);
            map.put(C1865V.VISUAL_TRACK_UAPP_PG, getPageName());
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "config:事件名: " + str);
            if (map.containsKey(C1865V.VISUAL_TRACK_TEXT)) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; 参数：" + ((String) map.get(C1865V.VISUAL_TRACK_TEXT)));
            }
            if (map.containsKey(C1865V.VISUAL_TRACK_PG)) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; 页面：" + ((String) map.get(C1865V.VISUAL_TRACK_PG)));
            }
            if (map.containsKey(C1865V.VISUAL_TRACK_UAPP_PG)) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; UApp页面路径：" + ((String) map.get(C1865V.VISUAL_TRACK_UAPP_PG)));
            }
            UMChannelAgent.onDebugEvent(context, str, map);
        }
    }

    public static String getActivityName(View view) {
        Context context;
        if (view == null || (context = view.getContext()) == null) {
            return null;
        }
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (!(context instanceof Activity)) {
            return null;
        }
        return context.getClass().getCanonicalName();
    }

    public static String getPageName() {
        String currenPageName = PageNameMonitor.getInstance().getCurrenPageName();
        return TextUtils.isEmpty(currenPageName) ? "" : currenPageName;
    }

    public static String getPageName(View view) {
        String pageName = getPageName();
        if (pageName == null || pageName.equals("") || pageName.equals("VT")) {
            String activityName = getActivityName(view);
            return (activityName == null || activityName.equals("")) ? "VT" : activityName;
        }
        return pageName;
    }

    public static void init(Context context, String str, String str2, int i, String str3) {
    }

    public static void openDebug(String str) {
    }

    public static void reflectTrack(Context context, String str, Map<String, Object> map) {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.analytics.MobclickAgent");
            if (findClass == null || (method = findClass.getMethod("onEvent", Context.class, String.class, Map.class)) == null) {
                return;
            }
            method.invoke(null, context, str, map);
        } catch (Exception unused) {
        }
    }

    public static String textPropertyFromView(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text == null) {
                return null;
            }
            return text.toString();
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount && sb.length() < 128; i++) {
                String textPropertyFromView = textPropertyFromView(viewGroup.getChildAt(i));
                if (textPropertyFromView != null && textPropertyFromView.length() > 0) {
                    if (z) {
                        sb.append(", ");
                    }
                    sb.append(textPropertyFromView);
                    z = true;
                }
            }
            if (sb.length() > 128) {
                return sb.substring(0, 128);
            }
            if (!z) {
                return null;
            }
            return sb.toString();
        }
    }
}
