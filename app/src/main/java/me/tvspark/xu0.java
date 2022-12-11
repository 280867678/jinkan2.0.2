package me.tvspark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import white.whale.R;

/* loaded from: classes4.dex */
public class xu0 extends BaseAdapter {
    public Context Wwwwwwwwwwwwwwwwwwwwwww;
    public List<String> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xu0 xu0Var) {
        }
    }

    public xu0(Context context, List<String> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwww = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (view == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            view2 = LayoutInflater.from(this.Wwwwwwwwwwwwwwwwwwwwwww).inflate(R.layout.item_selection_view, (ViewGroup) null);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (TextView) view2.findViewById(R.id.tvSelTitleItem);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view2.findViewById(R.id.line);
            view2.setTag(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            view2 = view;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) view.getTag();
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setText(this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i));
        if (i + 1 == this.Wwwwwwwwwwwwwwwwwwwwwwww.size()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(4);
        }
        return view2;
    }
}
