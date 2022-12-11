package me.tvspark.widget.easytagdragview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.at0;
import me.tvspark.bt0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.CodeForSiteData;
import me.tvspark.eo0;
import me.tvspark.nu0;
import me.tvspark.outline;
import me.tvspark.pu0;
import me.tvspark.qu0;
import me.tvspark.ru0;
import me.tvspark.tu0;
import me.tvspark.view.activity.SortWebsiteActivity;
import me.tvspark.widget.easytagdragview.widget.DragDropGirdView;
import me.tvspark.widget.easytagdragview.widget.TipItemView;
import me.tvspark.yn0;
import me.tvspark.zs0;
import white.whale.R;

/* loaded from: classes4.dex */
public class EasyTipDragView extends RelativeLayout implements nu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, View.OnClickListener {
    public static int Wwwwwwwwwwwwww = 12;
    public boolean Wwwwwwwwwwwwwww = false;
    public ArrayList<ru0> Wwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww;
    public qu0 Wwwwwwwwwwwwwwwwwwww;
    public pu0 Wwwwwwwwwwwwwwwwwwwww;
    public TextView Wwwwwwwwwwwwwwwwwwwwww;
    public GridView Wwwwwwwwwwwwwwwwwwwwwww;
    public DragDropGirdView Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AdapterView.OnItemClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Context context;
            String str;
            EasyTipDragView easyTipDragView = EasyTipDragView.this;
            if (easyTipDragView.Wwwwwwwwwwwwwww) {
                if (easyTipDragView.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().size() >= EasyTipDragView.Wwwwwwwwwwwwww) {
                    context = EasyTipDragView.this.getContext();
                    str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("最多添加"), EasyTipDragView.Wwwwwwwwwwwwww, "项");
                } else {
                    EasyTipDragView easyTipDragView2 = EasyTipDragView.this;
                    qu0 qu0Var = easyTipDragView2.Wwwwwwwwwwwwwwwwwwww;
                    CodeForSiteData codeForSiteData = easyTipDragView2.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    boolean z = false;
                    if (qu0Var.Wwwwwwwwwwwwwwwwwwwwww != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= qu0Var.Wwwwwwwwwwwwwwwwwwwwww.size()) {
                                break;
                            }
                            try {
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (codeForSiteData.getWebSourceBaseUrl().equals(qu0Var.Wwwwwwwwwwwwwwwwwwwwww.get(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl())) {
                                z = true;
                                break;
                            }
                            i2++;
                        }
                    }
                    EasyTipDragView easyTipDragView3 = EasyTipDragView.this;
                    if (!z) {
                        easyTipDragView3.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().add(EasyTipDragView.this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.get(i));
                        EasyTipDragView.this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                    context = easyTipDragView3.getContext();
                    str = "已包含此酷站";
                }
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str);
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = easyTipDragView.Wwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(easyTipDragView.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), new zs0((SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements qu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public EasyTipDragView(Context context) {
        super(context);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public EasyTipDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public EasyTipDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @TargetApi(21)
    public EasyTipDragView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (isInEditMode()) {
            return;
        }
        setVisibility(8);
        qu0 qu0Var = new qu0(getContext(), this, this);
        this.Wwwwwwwwwwwwwwwwwwww = qu0Var;
        qu0Var.Wwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwww = new pu0();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_easytagdrag, this);
        this.Wwwwwwwwwwwwwwwwwwwwww = (TextView) inflate.findViewById(R.id.drag_finish_tv);
        DragDropGirdView dragDropGirdView = (DragDropGirdView) inflate.findViewById(R.id.tagdrag_view);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = dragDropGirdView;
        tu0 dragDropController = dragDropGirdView.getDragDropController();
        qu0 qu0Var2 = this.Wwwwwwwwwwwwwwwwwwww;
        if (!dragDropController.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(qu0Var2)) {
            dragDropController.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(qu0Var2);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setDragShadowOverlay((ImageView) inflate.findViewById(R.id.tile_drag_shadow_overlay));
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setAdapter((ListAdapter) this.Wwwwwwwwwwwwwwwwwwww);
        GridView gridView = (GridView) inflate.findViewById(R.id.add_gridview);
        this.Wwwwwwwwwwwwwwwwwwwwwww = gridView;
        gridView.setAdapter((ListAdapter) this.Wwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setOnItemClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwww.setOnClickListener(this);
    }

    @Override // me.tvspark.widget.easytagdragview.widget.TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ru0 ru0Var, int i, View view) {
        if (this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().size() == 0) {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), "最少包含一项");
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().remove(i);
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public ArrayList<ru0> getDragData() {
        return this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.nu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public DragDropGirdView getDragDropGirdView() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        if (view.getId() != R.id.drag_finish_tv) {
            return;
        }
        qu0 qu0Var = this.Wwwwwwwwwwwwwwwwwwww;
        qu0Var.Wwww = false;
        qu0Var.Wwwwwwww = false;
        qu0Var.notifyDataSetChanged();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            ArrayList<ru0> arrayList = this.Wwwwwwwwwwwwwwww;
            SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(arrayList.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            baseActivity = SortWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            AlertDialog create = new AlertDialog.Builder(baseActivity).setMessage("重启APP后配置更改生效 ？").setPositiveButton("重启", new bt0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, arrayList2)).setNegativeButton("取消", new at0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)).create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.setVisibility(8);
    }

    public void setAddData(List<ru0> list) {
        this.Wwwwwwwwwwwwwwww = new ArrayList<>(list);
        this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = list;
    }

    public void setDataResultCallback(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setDragData(List<ru0> list) {
        qu0 qu0Var = this.Wwwwwwwwwwwwwwwwwwww;
        if (qu0Var.Wwwwwwwwwwwwwwww || list == null) {
            return;
        }
        qu0Var.Wwwwwwwwwwwwwwwwwwwwww.clear();
        qu0Var.Wwwwwwwwwwwwwwwwwwwwww.addAll(list);
        qu0Var.notifyDataSetChanged();
        qu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new long[0]);
    }

    public void setGoEditMode(boolean z) {
        this.Wwwwwwwwwwwwwww = z;
        qu0 qu0Var = this.Wwwwwwwwwwwwwwwwwwww;
        qu0Var.Wwww = z;
        if (!z) {
            qu0Var.Wwwwwwww = false;
            qu0Var.notifyDataSetChanged();
        } else {
            qu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) null);
        }
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwww.setVisibility(8);
        }
    }

    public void setOnCompleteCallback(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.nu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ArrayList<ru0> arrayList) {
        this.Wwwwwwwwwwwwwwww = arrayList;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || ((SortWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            return;
        }
        throw null;
    }
}
