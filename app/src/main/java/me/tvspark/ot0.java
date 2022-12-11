package me.tvspark;

import java.util.List;
import me.tvspark.adapter.HomeModernAdapter;
import me.tvspark.data.sql.HomeMarkData;
import me.tvspark.view.fragment.ModernFragment;
import org.litepal.crud.callback.FindMultiCallback;

/* loaded from: classes4.dex */
public class ot0 implements FindMultiCallback<HomeMarkData> {
    public final /* synthetic */ ModernFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ot0(ModernFragment modernFragment) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = modernFragment;
    }

    @Override // org.litepal.crud.callback.FindMultiCallback
    public void onFinish(List<HomeMarkData> list) {
        HomeModernAdapter homeModernAdapter = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww;
        homeModernAdapter.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        if (list != null) {
            homeModernAdapter.Wwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        HomeMarkData homeMarkData = new HomeMarkData();
        homeMarkData.setUrl("@");
        homeModernAdapter.Wwwwwwwwwwwwwwwwwwwwwwww.add(homeMarkData);
        homeModernAdapter.notifyDataSetChanged();
    }
}
