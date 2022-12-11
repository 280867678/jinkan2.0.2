package me.tvspark;

import java.util.List;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.widget.dialog.DialogLines;
import org.litepal.crud.callback.FindMultiCallback;

/* loaded from: classes4.dex */
public class hu0 implements FindMultiCallback<WebSourceIndexData> {
    public final /* synthetic */ DialogLines Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public hu0(DialogLines dialogLines) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogLines;
    }

    @Override // org.litepal.crud.callback.FindMultiCallback
    public void onFinish(List<WebSourceIndexData> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                GenreParcel genreParcel = new GenreParcel(list.get(i).getWebSourceSiteName(), list.get(i).getWebSourceBaseUrl(), list.get(i).getAppVer());
                if (list.get(i).getWebSourceBaseUrl().equals(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwww)) {
                    genreParcel.setAppLine(true);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = i;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.add(genreParcel);
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.rvFile.setVisibility(8);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.llytChangeConfUrl.setVisibility(0);
            return;
        }
        DialogLines dialogLines = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        dialogLines.Wwwwwwwwwwwwwwwwww = new DialogLines.LineListAdapter();
        DialogLines dialogLines2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        dialogLines2.rvFile.setAdapter(dialogLines2.Wwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.rvFile.hasFixedSize();
        DialogLines dialogLines3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        dialogLines3.rvFile.scrollToPosition(dialogLines3.Wwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.rvFile.setVisibility(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.llytChangeConfUrl.setVisibility(8);
    }
}
