package me.tvspark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import me.tvspark.yt0;
import white.whale.R;

/* loaded from: classes4.dex */
public class yt0 extends PopupWindow {

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str);
    }

    public yt0(Context context, final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        super(-1, -2);
        setContentView(LayoutInflater.from(context).inflate(R.layout.pop_soft_keyboard_top_tool, (ViewGroup) null));
        setTouchable(true);
        setOutsideTouchable(false);
        setFocusable(false);
        setInputMethodMode(1);
        LinearLayout linearLayout = (LinearLayout) getContentView().findViewById(R.id.ll_content);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            ((TextView) linearLayout.getChildAt(i)).setOnClickListener(new View.OnClickListener() { // from class: me.tvspark.wt0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    yt0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yt0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this, view);
                }
            });
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, View view) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((TextView) view).getText().toString());
        }
    }
}
