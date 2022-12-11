package com.tencent.smtt.audio.core.utils;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.tbs.common.resources.TBSResources;

/* JADX WARN: Classes with same name are omitted:
  鲸看_2.0.2_内测版_kill2_sign.apk:lib/armeabi/libfuck.so:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/TbsToastBuilder.class
 */
/* loaded from: 鲸看_2.0.2_内测版_kill2_sign.apk:assets/45912.apk:assets/webkit/audio_base.jar:com/tencent/smtt/audio/core/utils/TbsToastBuilder.class */
public class TbsToastBuilder {
    public static final String x5_menu_toast_text_color = "x5_menu_toast_text_color";
    public static final String x5_menu_toast_text_night_color = "x5_menu_toast_text_night_color";
    public static final String x5_toast_margin_left_right = "x5_toast_margin_left_right";
    public static final String x5_toast_margin_top_bottom = "x5_toast_margin_top_bottom";
    public static final String x5_tbs_menu_toast_background = "x5_tbs_menu_toast_background";
    public static final int MARGIN_LEFT_RIGHT = TBSResources.getDimensionPixelSize("x5_toast_margin_left_right");
    public static final int MARGIN_TOP_BOTTOM = TBSResources.getDimensionPixelSize("x5_toast_margin_top_bottom");
    public static final int DEFAULT_DURATION = 0;

    public static void show(Context context, CharSequence text, boolean isNight) {
        show(context, text, 0, isNight);
    }

    public static void show(Context context, CharSequence text, int duration, boolean isNight) {
        try {
            Toast toast = makeText(context, text, duration, isNight);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Toast makeText(Context context, CharSequence text, int duration, boolean isNight) {
        try {
            Toast toast = new Toast(context);
            LinearLayout root = new LinearLayout(context);
            LinearLayout.LayoutParams rootParams = new LinearLayout.LayoutParams(-2, -2);
            root.setLayoutParams(rootParams);
            TbsDialogBase.setViewBackground(root, TbsDialogBase.getImageDrawable("x5_tbs_menu_toast_background", isNight, 2));
            TextView textView = new TextView(context);
            textView.setTextSize(16.0f);
            if (isNight) {
                textView.setTextColor(TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_menu_toast_text_night_color", "color")));
            } else {
                textView.setTextColor(TBSResources.getResources().getColor(TBSResources.loadIdentifierResource("x5_menu_toast_text_color", "color")));
            }
            textView.setText(text);
            textView.setFocusable(false);
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(-2, -2);
            textParams.setMargins(MARGIN_LEFT_RIGHT, MARGIN_TOP_BOTTOM, MARGIN_LEFT_RIGHT, MARGIN_TOP_BOTTOM);
            textView.setLayoutParams(textParams);
            textView.setGravity(17);
            root.addView(textView);
            toast.setDuration(duration);
            toast.setView(root);
            return toast;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
