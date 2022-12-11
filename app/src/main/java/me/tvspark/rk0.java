package me.tvspark;

import android.text.TextUtils;
import android.view.View;
import com.arialyy.aria.core.download.DownloadEntity;
import java.io.File;
import me.tvspark.adapter.DowningAdapter;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.view.activity.DowningActivity;

/* loaded from: classes4.dex */
public class rk0 implements View.OnClickListener {
    public final /* synthetic */ DowningAdapter Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ DownloadEntity Wwwwwwwwwwwwwwwwwwwwwwww;

    public rk0(DowningAdapter downingAdapter, DownloadEntity downloadEntity) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = downingAdapter;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = downloadEntity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        String str;
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        DowningAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            DownloadEntity downloadEntity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            DowningActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DowningActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                throw null;
            }
            String str2 = downloadEntity.getFilePath() + ".m3u8";
            if (downloadEntity.getPercent() == 100) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
                boolean isEmpty = TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                DowningActivity downingActivity = DowningActivity.this;
                if (!isEmpty) {
                    baseActivity3 = downingActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, downloadEntity.getFileName(), 0L, true);
                    return;
                }
                baseActivity = downingActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
            } else if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_play_local_type", 4) != 4 || bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core") != 2) {
                baseActivity = DowningActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "一直 100% 且播放失败，可尝试修复后再播";
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
            } else if (new File(str2).exists()) {
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 1);
                baseActivity2 = DowningActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, str2, downloadEntity.getFileName(), 0L, true);
                return;
            } else {
                baseActivity = DowningActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            }
            str = "文件打开失败";
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
        }
    }
}
