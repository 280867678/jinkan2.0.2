package me.tvspark;

import android.content.DialogInterface;
import java.util.List;
import me.tvspark.adapter.HistoryListWebAdapter;
import me.tvspark.data.sql.WebHistoryData;
import me.tvspark.view.fragment.History2Fragment;

/* loaded from: classes4.dex */
public class lt0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ History2Fragment Wwwwwwwwwwwwwwwwwwwwwwww;

    public lt0(History2Fragment history2Fragment) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = history2Fragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.clear();
        History2Fragment history2Fragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        HistoryListWebAdapter historyListWebAdapter = history2Fragment.Wwwwwwwwwwwwwwww;
        List<WebHistoryData> list = history2Fragment.Wwwwwwwwwwwwwwwww;
        if (historyListWebAdapter != null) {
            if (list != null) {
                historyListWebAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                historyListWebAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
                historyListWebAdapter.notifyDataSetChanged();
            }
            History2Fragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, true);
            return;
        }
        throw null;
    }
}
