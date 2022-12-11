package me.tvspark;

import android.text.TextUtils;
import android.view.View;
import com.arialyy.aria.core.download.DownloadEntity;
import me.tvspark.adapter.DowningAdapter;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.view.activity.DowningActivity;

/* loaded from: classes4.dex */
public class qk0 implements View.OnClickListener {
    public final /* synthetic */ DowningAdapter Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ DownloadEntity Wwwwwwwwwwwwwwwwwwwwwwww;

    public qk0(DowningAdapter downingAdapter, DownloadEntity downloadEntity) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = downingAdapter;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = downloadEntity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        DowningAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            DownloadEntity downloadEntity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            DowningActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DowningActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                boolean z = true;
                if (downloadEntity.getPercent() < 4) {
                    baseActivity3 = DowningActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity3, "请先等待缓存 3% 后再播放");
                } else {
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadEntity.getM3U8Entity().getCacheDir(), downloadEntity.getFilePath() + ".m3u8", downloadEntity.getFilePath() + ".key", downloadEntity.getM3U8Entity().getPeerNum());
                    boolean isEmpty = TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    DowningActivity downingActivity = DowningActivity.this;
                    if (isEmpty) {
                        baseActivity2 = downingActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
                        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, "文件打开失败");
                        z = false;
                    } else {
                        baseActivity = downingActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
                        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, downloadEntity.getFileName(), 0L, true);
                    }
                }
                if (!z) {
                    return;
                }
                int state = this.Wwwwwwwwwwwwwwwwwwwwwwww.getState();
                if (state != -1 && state != 0 && state != 2 && state != 5 && state != 6) {
                    return;
                }
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getUrl(), "", this.Wwwwwwwwwwwwwwwwwwwwwwww.getId(), 1);
                return;
            }
            throw null;
        }
    }
}
