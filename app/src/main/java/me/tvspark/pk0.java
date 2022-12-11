package me.tvspark;

import android.view.View;
import com.arialyy.aria.core.download.DownloadEntity;
import me.tvspark.adapter.DowningAdapter;

/* loaded from: classes4.dex */
public class pk0 implements View.OnClickListener {
    public final /* synthetic */ DowningAdapter Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ DownloadEntity Wwwwwwwwwwwwwwwwwwwwwwww;

    public pk0(DowningAdapter downingAdapter, DownloadEntity downloadEntity) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = downingAdapter;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = downloadEntity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.notifyDataSetChanged();
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getUrl(), "", this.Wwwwwwwwwwwwwwwwwwwwwwww.getId(), 3);
        zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".m3u8", this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".key");
    }
}
