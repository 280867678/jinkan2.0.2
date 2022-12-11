package me.tvspark;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import me.tvspark.widget.easytagdragview.widget.DragDropGirdView;
import me.tvspark.widget.easytagdragview.widget.TipItemView;
import white.whale.R;

/* loaded from: classes4.dex */
public abstract class nu0 extends BaseAdapter implements su0 {
    public static ru0 Wwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public int Wwwwwwwwwwwwwww;
    public ArrayList<ru0> Wwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;
    public ru0 Wwwwwwwwwwwwwwwwwwwww = null;
    public int Wwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwww = -1;
    public boolean Wwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwww = false;
    public int Wwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwww = Integer.MAX_VALUE;
    public final HashMap<Long, Integer> Wwwwwwwwwww = new HashMap<>();
    public final HashMap<Long, Integer> Wwwwwwwwww = new HashMap<>();

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ArrayList<ru0> arrayList);

        DragDropGirdView getDragDropGirdView();
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ru0 {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @Override // me.tvspark.ru0
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public nu0(Context context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
        this.Wwwwwwwwwwwwwww = context.getResources().getInteger(R.integer.fade_duration);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwww == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww) || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww.add(i, Wwwwwwwww);
        ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Wwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new long[0]);
        notifyDataSetChanged();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int firstVisiblePosition = this.Wwwwwwwwwwwwwwwwwwwwwwww.getDragDropGirdView().getFirstVisiblePosition();
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwww.getDragDropGirdView().getChildCount(); i++) {
            View childAt = this.Wwwwwwwwwwwwwwwwwwwwwwww.getDragDropGirdView().getChildAt(i);
            int i2 = firstVisiblePosition + i;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                long itemId = getItemId(i2);
                this.Wwwwwwwwwww.put(Long.valueOf(itemId), Integer.valueOf(childAt.getTop()));
                this.Wwwwwwwwww.put(Long.valueOf(itemId), Integer.valueOf(childAt.getLeft()));
            }
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i >= 0 && i < this.Wwwwwwwwwwwwwwwwwwwwww.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ru0> arrayList = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwww.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getCount() > 0;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long... jArr) {
        if (this.Wwwwwwwwwww.isEmpty()) {
            return;
        }
        ViewTreeObserver viewTreeObserver = this.Wwwwwwwwwwwwwwwwwwwwwwww.getDragDropGirdView().getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new ou0(this, viewTreeObserver, jArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // me.tvspark.su0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int i3;
        this.Wwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwww = false;
        if (this.Wwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww) || (i3 = this.Wwwwwwwwwwwwwwwwww) == this.Wwwwwwwwwwwwwwwwwwww) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww)) {
                this.Wwwwwwwwwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = null;
            if (this.Wwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwww.set(i3, this.Wwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        notifyDataSetChanged();
        this.Wwwwwwwwwwwwwwwwwwwww = null;
        if (this.Wwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwww) {
        }
    }

    @Override // me.tvspark.su0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, View view) {
        if (view == null) {
            return;
        }
        int indexOf = this.Wwwwwwwwwwwwwwwwwwwwww.indexOf(((TipItemView) view).getDragEntity());
        if (!this.Wwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwww == indexOf || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexOf) || indexOf <= this.Wwwwwwwwwwwww || indexOf >= this.Wwwwwwwwwwww) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexOf);
    }

    @Override // me.tvspark.su0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, View view) {
        this.Wwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwww = true;
        int indexOf = this.Wwwwwwwwwwwwwwwwwwwwww.indexOf(((TipItemView) view).getDragEntity());
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexOf)) {
            this.Wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww.get(indexOf);
            this.Wwwwwwwwwwwwwwwwwwww = indexOf;
            this.Wwwwwwwwwwwwwwwwww = indexOf;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexOf);
        }
    }
}
