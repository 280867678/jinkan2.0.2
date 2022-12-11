package me.tvspark;

import android.content.DialogInterface;
import java.util.List;
import me.tvspark.adapter.CollectListAdapter;
import me.tvspark.data.sql.VideoCollectData;
import me.tvspark.view.fragment.CollectedFragment;

/* loaded from: classes4.dex */
public class jt0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ CollectedFragment Wwwwwwwwwwwwwwwwwwwwwwww;

    public jt0(CollectedFragment collectedFragment) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = collectedFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.clear();
        CollectedFragment collectedFragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        CollectListAdapter collectListAdapter = collectedFragment.Wwwwwwwwwwwwwwww;
        List<VideoCollectData> list = collectedFragment.Wwwwwwwwwwwwwwwww;
        if (collectListAdapter != null) {
            if (list != null) {
                collectListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                collectListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
                collectListAdapter.notifyDataSetChanged();
            }
            CollectedFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, true);
            return;
        }
        throw null;
    }
}
