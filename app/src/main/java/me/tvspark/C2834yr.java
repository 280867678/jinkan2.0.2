package me.tvspark;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

/* renamed from: me.tvspark.yr */
/* loaded from: classes4.dex */
public class C2834yr implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialAutoCompleteTextView Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2834yr(MaterialAutoCompleteTextView materialAutoCompleteTextView) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = materialAutoCompleteTextView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        r0.setText(this.Wwwwwwwwwwwwwwwwwwwwwwww.convertSelectionToString(i < 0 ? materialAutoCompleteTextView.Wwwwwwwwwwwwwwwwwwwwwwww.getSelectedItem() : materialAutoCompleteTextView.getAdapter().getItem(i)), false);
        AdapterView.OnItemClickListener onItemClickListener = this.Wwwwwwwwwwwwwwwwwwwwwwww.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                view = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getSelectedView();
                i = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getSelectedItemPosition();
                j = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getListView(), view, i, j);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.dismiss();
    }
}
