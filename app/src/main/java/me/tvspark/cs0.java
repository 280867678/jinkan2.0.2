package me.tvspark;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.arialyy.aria.core.Aria;
import java.util.List;
import me.tvspark.adapter.EpisodeAdapter;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.data.sql.VideoPlayPosData;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.view.activity.DetailActivity;
import org.litepal.crud.callback.FindCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class cs0 implements MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ DetailActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<VideoPlayPosData> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
            if (r3.Wwwwwww < r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration()) goto L13;
         */
        @Override // org.litepal.crud.callback.FindCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onFinish(VideoPlayPosData videoPlayPosData) {
            BaseActivity baseActivity;
            StringBuilder sb;
            DetailActivity detailActivity;
            VideoPlayPosData videoPlayPosData2 = videoPlayPosData;
            if (videoPlayPosData2 != null && videoPlayPosData2.getQuitTime() != 0) {
                int i = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww;
                if (i > 0 && i > videoPlayPosData2.getQuitTime()) {
                    if (cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration() != 0) {
                    }
                    DetailActivity detailActivity2 = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    MyJzvdStd myJzvdStd = detailActivity2.myJzvdStd;
                    long j = detailActivity2.Wwwwwww;
                    myJzvdStd.Wwwwwwwwwwwwww = j;
                    myJzvdStd.Wwwwwwwwwwwwwwwwww.seekTo(j);
                    baseActivity = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                    sb = new StringBuilder();
                }
                if (cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration() != 0 && videoPlayPosData2.getQuitTime() >= cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration()) {
                    return;
                }
                cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.Wwwwwwwwwwwwww = videoPlayPosData2.getQuitTime();
                cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.Wwwwwwwwwwwwwwwwww.seekTo(videoPlayPosData2.getQuitTime());
                return;
            }
            DetailActivity detailActivity3 = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            new VideoPlayPosData(detailActivity3.Kkkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity3.Kkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity3.Wwwwwwwwwwwww, detailActivity3.Kkkkkkkkkkkkkkkkkkkkkkkk, 0L).saveAsync().listen(null);
            DetailActivity detailActivity4 = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (detailActivity4.Wwwwwww <= 0) {
                return;
            }
            if (detailActivity4.myJzvdStd.getDuration() != 0) {
                if (detailActivity.Wwwwwww >= cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.myJzvdStd.getDuration()) {
                    return;
                }
            }
            DetailActivity detailActivity5 = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            MyJzvdStd myJzvdStd2 = detailActivity5.myJzvdStd;
            long j2 = detailActivity5.Wwwwwww;
            myJzvdStd2.Wwwwwwwwwwwwww = j2;
            myJzvdStd2.Wwwwwwwwwwwwwwwwww.seekTo(j2);
            baseActivity = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            sb = new StringBuilder();
            sb.append("已跳过片头 ");
            sb.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww / 1000));
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, sb.toString());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText, EditText editText2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
            this.Wwwwwwwwwwwwwwwwwwwwwww = editText2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            BaseActivity baseActivity;
            BaseActivity baseActivity2;
            String obj = this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString();
            String obj2 = this.Wwwwwwwwwwwwwwwwwwwwwww.getText().toString();
            if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                baseActivity = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, "请完整填写正确内容");
                return;
            }
            baseActivity2 = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, "加入缓存任务列表");
            String replace = obj.replace("/", "");
            String str = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) + "download/" + replace + "/" + obj2.replace("/", "") + "-" + replace;
            DetailActivity detailActivity = cs0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Wwwwwwwwwwwwwwwwwwwwwwww, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkk, str, -1L, 0);
        }
    }

    public cs0(DetailActivity detailActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = detailActivity;
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        BaseActivity baseActivity;
        baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (Aria.download(baseActivity).taskExists(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkk)) {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, "已存在，请查看我的缓存");
            return;
        }
        View inflate = LayoutInflater.from(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).inflate(R.layout.view_web_sniffer_down, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.et_dir);
        EditText editText2 = (EditText) inflate.findViewById(R.id.et_file);
        editText.setText(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww);
        editText2.setText(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkk);
        new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("填写缓存信息").setView(inflate).setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("下载", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText, editText2)).create().show();
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!detailActivity.Www) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk, new es0(detailActivity, false, null));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Www = false;
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        BaseActivity baseActivity;
        String str;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
            baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            str = "已切换IJK内核";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 1) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "已切换Android内核";
            }
            DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            detailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkk, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkk, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkk);
        } else {
            baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            str = "已切换EXO内核";
        }
        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
        DetailActivity detailActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        detailActivity2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity2.Kkkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity2.Kkkkkkkkkkkkkkkkkkkkkkk, detailActivity2.Kkkkkkkkkkkkkkkkkkkkkkkk, detailActivity2.Kkkkkkkkkkkkkkkkkkkkkkkkk);
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0.Kkkkkkkkkkkkkkkkkkkkkkkkkk, new es0(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, null));
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        detailActivity.Wwww = true;
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk, new es0(detailActivity, false, null));
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, EpisodeParcel episodeParcel, List<EpisodeParcel> list, int i, int i2) {
        EpisodeAdapter episodeAdapter = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww;
        episodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeParcel.getCount();
        episodeAdapter.notifyDataSetChanged();
        EpisodeAdapter episodeAdapter2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
        episodeAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeParcel.getCount();
        episodeAdapter2.notifyDataSetChanged();
        DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, z, list, i2, episodeParcel);
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        BaseActivity baseActivity;
        baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) baseActivity)) {
            DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, detailActivity.Wwwwwwwwwwwwwwwwwwwwwwww, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkk, detailActivity.Wwwwwwwwwwwww, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkk, detailActivity.Wwwwwwwwwwww, detailActivity.Wwwwwwwwwwwwwwwwwww, detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk, false);
        } else {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, (int) R.string.x5_failure);
            DetailActivity detailActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity2.Wwwwwwwwwwwwwwwwwwwwwwww, detailActivity2.Kkkkkkkkkkkkkkkkkkkkkkkkk);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.finish();
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
        DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = detailActivity.Wwwwww;
        if (i2 > 0) {
            long j3 = j2 - j;
            if (j3 < i2 - 500 || j3 > i2 + 500) {
                return;
            }
            detailActivity.myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww();
            BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已跳过片尾 ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwww / 1000));
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }

    @Override // me.tvspark.utils.player.MyJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkkk, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }
}
