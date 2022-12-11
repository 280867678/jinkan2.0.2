package me.tvspark;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import me.tvspark.nu0;
import me.tvspark.widget.easytagdragview.EasyTipDragView;
import me.tvspark.widget.easytagdragview.widget.TipItemView;
import white.whale.R;

/* loaded from: classes4.dex */
public class qu0 extends nu0 implements View.OnLongClickListener, TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final ClipData Www = ClipData.newPlainText("", "");
    public boolean Wwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwww;
    public TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwww;
    public TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwww;
    public boolean Wwwwwwww = false;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends View.DragShadowBuilder {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qu0 qu0Var) {
        }

        @Override // android.view.View.DragShadowBuilder
        public void onProvideShadowMetrics(Point point, Point point2) {
            point.set(1, 1);
            point2.set(0, 0);
        }
    }

    public qu0(Context context, nu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        super(context, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        notifyDataSetChanged();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
    }

    public ArrayList<ru0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ArrayList<ru0> arrayList = this.Wwwwwwwwwwwwwwwwwwwwww;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        if (!this.Wwwwwwww) {
            this.Wwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                EasyTipDragView.this.Wwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
            }
            notifyDataSetChanged();
        }
        if (view != null) {
            view.startDrag(Www, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this), "FAVORITE_TILE", 0);
        }
    }

    @Override // me.tvspark.widget.easytagdragview.widget.TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ru0 ru0Var, int i, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwww.remove(i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || !(view instanceof TipItemView)) {
            view = View.inflate(this.Wwwwwwwwwwwwwwwwwwwwwww, R.layout.view_easytagdrag_tag_item, null);
        }
        TipItemView tipItemView = (TipItemView) view;
        int i2 = 0;
        if (this.Wwwwwwww) {
            tipItemView.Wwwwwwwwwwwwwwwwwwww.setVisibility(0);
        } else {
            tipItemView.Wwwwwwwwwwwwwwwwwwww.setVisibility(8);
        }
        tipItemView.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwww;
        tipItemView.Wwwwwwwwwwwwwwwwwww = i;
        tipItemView.setOnLongClickListener(this);
        TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwww;
        tipItemView.Wwwwwwwwwwwwwwwwwww = i;
        tipItemView.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ru0 ru0Var = this.Wwwwwwwwwwwwwwwwwwwwww.get(i);
        tipItemView.Wwwwwwwwwwwwwwwwwwwwww = ru0Var;
        if (ru0Var == null || ru0Var == nu0.Wwwwwwwww) {
            i2 = 4;
        } else {
            tipItemView.Wwwwwwwwwwwwwwwwwwwww.setText(ru0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName());
        }
        tipItemView.setVisibility(i2);
        return tipItemView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.Wwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
            return true;
        }
        return true;
    }
}
