package me.tvspark;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import java.util.Iterator;
import java.util.List;
import me.tvspark.view.fragment.SearchHistoryFragment;

/* loaded from: classes4.dex */
public class tt0 implements SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ SearchHistoryFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public tt0(SearchHistoryFragment searchHistoryFragment, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = searchHistoryFragment;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // me.tvspark.view.fragment.SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list) {
        if (list.isEmpty()) {
            list.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, it.next())) {
                    it.remove();
                }
            }
            list.add(0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        int size = list.size();
        if (size > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww) {
            while (true) {
                size--;
                if (size < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww) {
                    break;
                }
                list.remove(size);
            }
        }
        SearchHistoryFragment searchHistoryFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (searchHistoryFragment.Wwwwwwwwwwwwwwww != null) {
            searchHistoryFragment.Wwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.addAll(list);
            SearchHistoryFragment searchHistoryFragment2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            r50<String> r50Var = searchHistoryFragment2.Wwwwwwwwwwwwwwww;
            r50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = searchHistoryFragment2.Wwwwwwwwwwwwwww;
            r50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        yn0.Wwwwwwwwwwwwwwwwwwwwwwww(JSON.toJSONString(list));
    }
}
