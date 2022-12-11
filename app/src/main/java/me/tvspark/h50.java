package me.tvspark;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.HomeModernAdapter;
import me.tvspark.data.sql.HomeMarkData;
import org.litepal.crud.callback.UpdateOrDeleteCallback;

/* loaded from: classes4.dex */
public class h50 extends PopupWindow {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public LinearLayout Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Point Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<i50> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnTouchListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                h50.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) motionEvent.getRawX();
                h50.this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (int) motionEvent.getRawY();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h50.this.dismiss();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = h50.this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                pt0 pt0Var = (pt0) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i == 0) {
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) pt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, pt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getUrl(), true);
                } else if (i == 1) {
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, pt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (i == 2) {
                    HomeModernAdapter homeModernAdapter = pt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww;
                    HomeMarkData homeMarkData = pt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    List<HomeMarkData> list = homeModernAdapter.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (list != null && !list.isEmpty()) {
                        int size = homeModernAdapter.Wwwwwwwwwwwwwwwwwwwwwwww.size();
                        while (true) {
                            size--;
                            if (size < 0) {
                                break;
                            } else if (homeModernAdapter.Wwwwwwwwwwwwwwwwwwwwwwww.get(size).getUrl().equals(homeMarkData.getUrl())) {
                                homeModernAdapter.Wwwwwwwwwwwwwwwwwwwwwwww.remove(size);
                            }
                        }
                        homeModernAdapter.notifyDataSetChanged();
                    }
                    yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getUrl(), (UpdateOrDeleteCallback) null);
                }
            }
            if (h50.this.isShowing()) {
                h50.this.dismiss();
            }
        }
    }

    public h50(Context context, View view) {
        super(context);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        view.setOnTouchListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, 10.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, 140.0f);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        int i2;
        View view;
        int i3;
        if (isShowing()) {
            return;
        }
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Point point = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i4 <= point.x / 2) {
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (i + i2 < point.y) {
                view = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i3 = i + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                view = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i3 = (i - i2) - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        } else {
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (i + i2 < point.y) {
                view = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i4 -= this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                i3 = i + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                view = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i4 -= this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                i3 = (i - i2) - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        showAtLocation(view, 8388659, i4, i3);
    }

    @Override // android.widget.PopupWindow
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }
}
