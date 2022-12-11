package me.tvspark;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.YearGridAdapter;
import java.util.Calendar;

/* renamed from: me.tvspark.ao */
/* loaded from: classes4.dex */
public class C1916ao extends RecyclerView.ItemDecoration {
    public final /* synthetic */ MaterialCalendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public C1916ao(MaterialCalendar materialCalendar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (!(recyclerView.getAdapter() instanceof YearGridAdapter) || !(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return;
        }
        YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        for (Pair<Long, Long> pair : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Long l = pair.first;
            if (l != null && pair.second != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTimeInMillis(l.longValue());
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTimeInMillis(pair.second.longValue());
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = yearGridAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(1));
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = yearGridAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(1));
                View findViewByPosition = gridLayoutManager.findViewByPosition(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                View findViewByPosition2 = gridLayoutManager.findViewByPosition(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                int spanCount = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / gridLayoutManager.getSpanCount();
                int spanCount2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 / gridLayoutManager.getSpanCount();
                for (int i = spanCount; i <= spanCount2; i++) {
                    View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i);
                    if (findViewByPosition3 != null) {
                        int top = findViewByPosition3.getTop() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.top;
                        int bottom = findViewByPosition3.getBottom() - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.bottom;
                        canvas.drawRect(i == spanCount ? (findViewByPosition.getWidth() / 2) + findViewByPosition.getLeft() : 0, top, i == spanCount2 ? (findViewByPosition2.getWidth() / 2) + findViewByPosition2.getLeft() : recyclerView.getWidth(), bottom, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
            }
        }
    }
}
