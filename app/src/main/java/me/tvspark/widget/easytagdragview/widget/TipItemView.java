package me.tvspark.widget.easytagdragview.widget;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import me.tvspark.ru0;
import me.tvspark.uu0;
import white.whale.R;

/* loaded from: classes4.dex */
public class TipItemView extends RelativeLayout {
    public int Wwwwwwwwwwwwwwwwwww;
    public ImageView Wwwwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwwwww;
    public ru0 Wwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ru0 ru0Var, int i, View view);
    }

    static {
        ClipData.newPlainText("", "");
    }

    public TipItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ru0 getDragEntity() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new uu0(this));
        this.Wwwwwwwwwwwwwwwwwwwww = (TextView) findViewById(R.id.tagview_title);
        this.Wwwwwwwwwwwwwwwwwwww = (ImageView) findViewById(R.id.tagview_delete);
    }
}
