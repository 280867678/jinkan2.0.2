package me.tvspark;

import android.content.DialogInterface;
import java.util.List;
import me.tvspark.adapter.HistoryListAdapter;
import me.tvspark.data.sql.VideoHistoryData;
import me.tvspark.view.fragment.History1Fragment;

/* loaded from: classes4.dex */
public class kt0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ History1Fragment Wwwwwwwwwwwwwwwwwwwwwwww;

    public kt0(History1Fragment history1Fragment) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = history1Fragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.clear();
        History1Fragment history1Fragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        HistoryListAdapter historyListAdapter = history1Fragment.Wwwwwwwwwwwwwwww;
        List<VideoHistoryData> list = history1Fragment.Wwwwwwwwwwwwwwwww;
        if (historyListAdapter != null) {
            if (list != null) {
                historyListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                historyListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
                historyListAdapter.notifyDataSetChanged();
            }
            History1Fragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, true);
            return;
        }
        throw null;
    }
}
