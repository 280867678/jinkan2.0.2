package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class ListViewCompat {
    public static boolean canScrollList(@NonNull ListView listView, int i) {
        return listView.canScrollList(i);
    }

    public static void scrollListBy(@NonNull ListView listView, int i) {
        listView.scrollListBy(i);
    }
}
