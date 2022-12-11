package me.tvspark.widget.selectionLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.r40;
import me.tvspark.xu0;
import me.tvspark.yu0;
import white.whale.R;

/* loaded from: classes4.dex */
public class SelectionLayout extends LinearLayout {
    public int Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, TextView textView);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinearLayout implements View.OnClickListener, AdapterView.OnItemClickListener {
        public Animation Wwwwwwwwwwwwww;
        public Animation Wwwwwwwwwwwwwww;
        public Context Wwwwwwwwwwwwwwww;
        public xu0 Wwwwwwwwwwwwwwwww;
        public ListPopupWindow Wwwwwwwwwwwwwwwwww;
        public ImageView Wwwwwwwwwwwwwwwwwwwwww;
        public RelativeLayout Wwwwwwwwwwwwwwwwwwwwwww;
        public LinearLayout Wwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwww = false;
        public List<String> Wwwwwwwwwwwwwwwwwww = new ArrayList();
        public LinearInterpolator Wwwwwwwwwwwww = new LinearInterpolator();
        public LinearInterpolator Wwwwwwwwwwww = new LinearInterpolator();
        public TextView Wwwwwwwwwwwwwwwwwwwww = (TextView) findViewById(R.id.tvSelTitle);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, int i) {
            super(context, null, 0);
            this.Wwwwwwwwwwwwwww = AnimationUtils.loadAnimation(SelectionLayout.this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.roate_0_180);
            this.Wwwwwwwwwwwwww = AnimationUtils.loadAnimation(SelectionLayout.this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.roate_180_360);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, this);
            this.Wwwwwwwwwwwwwwww = context;
            ImageView imageView = (ImageView) findViewById(R.id.ivSelArrow);
            this.Wwwwwwwwwwwwwwwwwwwwww = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout);
            this.Wwwwwwwwwwwwwwwwwwwwwww = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.Wwwwwwwwwwwwwww.setInterpolator(this.Wwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwww.setFillAfter(true);
            this.Wwwwwwwwwwwwww.setInterpolator(this.Wwwwwwwwwwww);
            this.Wwwwwwwwwwwwww.setFillAfter(true);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwww.startAnimation(this.Wwwwwwwwwwwwww);
                ListPopupWindow listPopupWindow = this.Wwwwwwwwwwwwwwwwww;
                if (listPopupWindow != null && listPopupWindow.isShowing()) {
                    this.Wwwwwwwwwwwwwwwwww.dismiss();
                }
                this.Wwwwwwwwwwwwwwwwwwww = false;
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.startAnimation(this.Wwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwww = new ListPopupWindow(SelectionLayout.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                xu0 xu0Var = new xu0(SelectionLayout.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwww = xu0Var;
                this.Wwwwwwwwwwwwwwwwww.setAdapter(xu0Var);
                this.Wwwwwwwwwwwwwwwwww.setWidth(SelectionLayout.this.Wwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwww.setHeight(SelectionLayout.this.Wwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwww.setAnchorView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                int i = SelectionLayout.this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (i != 0) {
                    this.Wwwwwwwwwwwwwwwwww.setHorizontalOffset(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
                }
                this.Wwwwwwwwwwwwwwwwww.setBackgroundDrawable(ContextCompat.getDrawable(SelectionLayout.this.Wwwwwwwwwwwwwwwwwwwwwwww, R.drawable.popup_menu_window_bkg));
                this.Wwwwwwwwwwwwwwwwww.setOnItemClickListener(this);
                this.Wwwwwwwwwwwwwwwwww.setOnDismissListener(new yu0(this));
                this.Wwwwwwwwwwwwwwwwww.setModal(true);
                if (this.Wwwwwwwwwwwwwwwwww.getListView() != null) {
                    this.Wwwwwwwwwwwwwwwwww.getListView().setScrollBarStyle(0);
                }
            }
            this.Wwwwwwwwwwwwwwwwww.show();
            this.Wwwwwwwwwwwwwwwwwwww = true;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TextView textView;
            String str;
            this.Wwwwwwwwwwwwwwwww.notifyDataSetChanged();
            if (SelectionLayout.this.Wwwwwwwwwwwwwwwwwwwww) {
                textView = this.Wwwwwwwwwwwwwwwwwwwww;
                str = this.Wwwwwwwwwwwwwwwwwww.get(i) + "更新";
            } else {
                textView = this.Wwwwwwwwwwwwwwwwwwwww;
                str = this.Wwwwwwwwwwwwwwwwwww.get(i);
            }
            textView.setText(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SelectionLayout.this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) getTag()).intValue(), i, this.Wwwwwwwwwwwwwwwwwww.get(i), this.Wwwwwwwwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwww.dismiss();
        }
    }

    public SelectionLayout(Context context) {
        this(context, null);
    }

    public SelectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwww = -2;
        this.Wwwwwwwwwwwwwwwwwww = -2;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z, int i2, int i3, int i4, int i5, int i6, List<String>... listArr) {
        this.Wwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwww = i5;
        this.Wwwwwwwwwwwwwwwwwww = i6;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i4;
        if (listArr == null || listArr.length <= 0) {
            return;
        }
        for (int i7 = 0; i7 < listArr.length; i7++) {
            List<String> list = listArr[i7];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLayoutParams(layoutParams);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setGravity(17);
            if (list != null && !list.isEmpty()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww.addAll(list);
                TextView textView = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                if (z) {
                    textView.setText(list.get(i3) + "更新");
                } else {
                    textView.setText(list.get(i3));
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.setPadding(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, 5.0f), 0, 0, 0);
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTag(Integer.valueOf(i7));
            float f = i2;
            TextView textView2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            if (textView2 != null) {
                textView2.setTextSize(1, f);
            }
            addView(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public void setOnSelectListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
