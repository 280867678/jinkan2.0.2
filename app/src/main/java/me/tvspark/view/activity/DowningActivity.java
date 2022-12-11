package me.tvspark.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.arialyy.aria.core.download.DownloadEntity;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.tvspark.adapter.DowningAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.event.PlayedFileMergingEvent;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.o11;
import me.tvspark.os0;
import me.tvspark.ps0;
import me.tvspark.r40;
import me.tvspark.x11;
import me.tvspark.xt0;
import org.greenrobot.eventbus.ThreadMode;
import white.whale.R;

/* loaded from: classes4.dex */
public class DowningActivity extends BaseActivity {
    public PopupWindow Wwwwwwwwwwwwww;
    public PlayedFileMergingEvent Wwwwwwwwwwwwwwww;
    public DowningAdapter Wwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.llyt_empty)
    public LinearLayout llytEmpty;
    @BindView(R.id.rlyt_top_bar)
    public RelativeLayout rlytTopBar;
    @BindView(R.id.rv_content)
    public RecyclerView rvContent;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    public List<DownloadEntity> Wwwwwwwwwwwwwwwww = new ArrayList();
    public HashMap<String, String> Wwwwwwwwwwwwwww = new HashMap<>();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ PlayedFileMergingEvent Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PlayedFileMergingEvent playedFileMergingEvent) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = playedFileMergingEvent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            DowningActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww("合并文件中...");
            if (DowningActivity.this.Wwwwwwwwwwwwwww.containsKey(this.Wwwwwwwwwwwwwwwwwwwwwwww.getMergedFilePath())) {
                DowningActivity downingActivity = DowningActivity.this;
                DowningActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downingActivity, this.Wwwwwwwwwwwwwwwwwwwwwwww.getMergedFilePath() + ".ts", this.Wwwwwwwwwwwwwwwwwwwwwwww.getVideoTitle(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getCurrentPlayPos());
            } else {
                DowningActivity.this.Wwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            }
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DowningActivity downingActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DowningAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownloadEntity downloadEntity) {
            PlayedFileMergingEvent playedFileMergingEvent = DowningActivity.this.Wwwwwwwwwwwwwwww;
            if (playedFileMergingEvent != null && playedFileMergingEvent.getMergedFilePath().equals(downloadEntity.getFilePath())) {
                DowningActivity downingActivity = DowningActivity.this;
                DowningActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downingActivity, DowningActivity.this.Wwwwwwwwwwwwwwww.getMergedFilePath() + ".ts", DowningActivity.this.Wwwwwwwwwwwwwwww.getVideoTitle(), DowningActivity.this.Wwwwwwwwwwwwwwww.getCurrentPlayPos());
                return;
            }
            DowningActivity.this.Wwwwwwwwwwwwwww.put(downloadEntity.getFilePath(), downloadEntity.getFileName());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DowningAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    static {
        StubApp.interface11(11169);
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DowningActivity downingActivity, String str, String str2, long j) {
        downingActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        try {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downingActivity.Wwwwwwwwwwwwwwwwwwwwwwww, str, str2, j, false);
        } catch (Exception e) {
            e.printStackTrace();
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downingActivity.Wwwwwwwwwwwwwwwwwwwwwwww, "打开文件失败");
        }
        downingActivity.Wwwwwwwwwwwwwww.clear();
        downingActivity.Wwwwwwwwwwwwwwww = null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public bl0 Wwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_downing;
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.Wwwwwwwwwwwwwwww = null;
        DowningAdapter downingAdapter = this.Wwwwwwwwwwwwwwwwww;
        if (downingAdapter != null) {
            if (downingAdapter == null) {
                throw null;
            }
            if (!o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downingAdapter.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                return;
            }
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downingAdapter.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onPlayedFileMergingEvent(PlayedFileMergingEvent playedFileMergingEvent) {
        AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("当前播放视频").setMessage("已缓存完成，是否立即打开继续播放？").setPositiveButton("播放", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(playedFileMergingEvent)).setNegativeButton("取消", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    @OnClick({R.id.iv_top_back, R.id.img_add_more})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.img_add_more) {
            if (id != R.id.iv_top_back) {
                return;
            }
            finish();
            return;
        }
        View inflate = LayoutInflater.from(this.Wwwwwwwwwwwwwwwwwwwwwwww).inflate(R.layout.view_main_popup, (ViewGroup) null, false);
        inflate.findViewById(R.id.llyt_all_start).setOnClickListener(new os0(this));
        inflate.findViewById(R.id.llyt_all_pause).setOnClickListener(new ps0(this));
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        this.Wwwwwwwwwwwwww = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.Wwwwwwwwwwwwww.update();
        this.Wwwwwwwwwwwwww.setAnimationStyle(R.style.AnimationPopup);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view.getContext());
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(view.getContext());
        inflate.measure(0, 0);
        int measuredHeight = inflate.getMeasuredHeight();
        int measuredWidth = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - inflate.getMeasuredWidth();
        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww - iArr2[1]) - height < measuredHeight) {
            iArr[0] = measuredWidth;
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[0] = measuredWidth;
            iArr[1] = iArr2[1] + height;
        }
        iArr[0] = iArr[0] - r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwwwww, -10.0d);
        iArr[1] = iArr[1] - r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwwwww, 20.0d);
        this.Wwwwwwwwwwwwww.showAtLocation(view, 8388659, iArr[0], iArr[1]);
    }
}
