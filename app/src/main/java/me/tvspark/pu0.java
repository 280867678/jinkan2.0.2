package me.tvspark;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import white.whale.R;

/* loaded from: classes4.dex */
public class pu0 extends BaseAdapter {
    public List<ru0> Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // android.widget.Adapter
    public int getCount() {
        List<ru0> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.view_easytagdrag_add_item, null);
        ((TextView) inflate.findViewById(R.id.tagview_title)).setText(this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName());
        return inflate;
    }
}
