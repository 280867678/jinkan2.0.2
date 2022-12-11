package me.tvspark.view.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.snackbar.Snackbar;
import com.p038qq.p039e.ads.nativ.NativeExpressAD;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import com.stub.StubApp;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.C2195hr;
import me.tvspark.Wwwwww;
import me.tvspark.adapter.ChanelAdapter;
import me.tvspark.adapter.EpisodeAdapter;
import me.tvspark.adapter.EpisodeFullPlayAdapter;
import me.tvspark.bo0;
import me.tvspark.co0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.data.bean.VideoDetailParcel;
import me.tvspark.data.event.ReqWebSourceEvent;
import me.tvspark.data.sql.VideoHistoryData;
import me.tvspark.data.sql.WebSourceSeasonData;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.eo0;
import me.tvspark.es0;
import me.tvspark.fm0;
import me.tvspark.fs0;
import me.tvspark.gs0;
import me.tvspark.jl0;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.vm0;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import me.tvspark.widget.decoration.GridSpanDecoration;
import me.tvspark.widget.decoration.SpacesItemDecoration;
import me.tvspark.widget.dialog.DialogDetailDesc;
import me.tvspark.wm0;
import me.tvspark.x11;
import me.tvspark.xt0;
import me.tvspark.yn0;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.crud.callback.CountCallback;
import org.litepal.crud.callback.FindCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class DetailActivity extends BaseActivity<vm0> implements wm0 {
    public boolean Kkkkkkkkkkkkkkkkkk;
    public WebSourceSeasonData Kkkkkkkkkkkkkkkkkkkkk;
    public boolean Www;
    public boolean Wwww;
    public NativeExpressADView Wwwwwwww;
    public NativeExpressAD Wwwwwwwww;
    public xt0 Wwwwwwwwww;
    public String Wwwwwwwwwww;
    public String Wwwwwwwwwwww;
    public String Wwwwwwwwwwwww;
    public VideoDetailParcel Wwwwwwwwwwwwww;
    public EpisodeAdapter Wwwwwwwwwwwwwww;
    public EpisodeAdapter Wwwwwwwwwwwwwwww;
    public ChanelAdapter Wwwwwwwwwwwwwwwww;
    public ChanelAdapter Wwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.flyt_native)
    public FrameLayout flytNative;
    @BindView(R.id.iv_operate4)
    public ImageView ivOperate4;
    @BindView(R.id.iv_poster)
    public RoundImageView ivPoster;
    @BindView(R.id.iv_sort_type)
    public ImageView ivSortType;
    @BindView(R.id.llyt_all_channel)
    public LinearLayout llytAllChannel;
    @BindView(R.id.video)
    public MyJzvdStd myJzvdStd;
    @BindView(R.id.rv_all_chanel)
    public RecyclerView rvAllChanel;
    @BindView(R.id.rv_all_episode)
    public RecyclerView rvAllEpisode;
    @BindView(R.id.rv_channel)
    public RecyclerView rvChannel;
    @BindView(R.id.rv_episode)
    public RecyclerView rvEpisode;
    @BindView(R.id.scroll_content)
    public NestedScrollView scrollContent;
    @BindView(R.id.tv_desc)
    public TextView tvDesc;
    @BindView(R.id.tv_operate4)
    public TextView tvOperate4;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.tv_web_name)
    public TextView tvWebName;
    @BindView(R.id.tv_web_url)
    public TextView tvWebUrl;
    @BindView(R.id.vod_content)
    public RelativeLayout vodContent;
    public String Wwwwwwwwwwwwwwwwwww = "";
    public int Wwwwwww = 0;
    public int Wwwwww = 0;
    public boolean Wwwww = false;
    public String Kkkkkkkkkkkkkkkkkkkkkkkkkk = "";
    public String Kkkkkkkkkkkkkkkkkkkkkkkkk = "";
    public String Kkkkkkkkkkkkkkkkkkkkkkkk = "";
    public int Kkkkkkkkkkkkkkkkkkkkkkk = 0;
    public boolean Kkkkkkkkkkkkkkkkkkkkkk = true;
    public String Kkkkkkkkkkkkkkkkkkkk = "";
    public boolean Kkkkkkkkkkkkkkkkkkk = false;
    public EpisodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public EpisodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<WebSourceSeasonData> {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // org.litepal.crud.callback.FindCallback
        public void onFinish(WebSourceSeasonData webSourceSeasonData) {
            WebSourceSeasonData webSourceSeasonData2 = webSourceSeasonData;
            if (webSourceSeasonData2 != null) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, webSourceSeasonData2);
                }
                DetailActivity detailActivity = DetailActivity.this;
                detailActivity.Kkkkkkkkkkkkkkkkkkkkk = webSourceSeasonData2;
                ((vm0) detailActivity.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Wwwwwwwwwwwwwwwwwwwwwwww, webSourceSeasonData2, detailActivity.Wwwwwwwwwwwww, detailActivity.Wwwwwwwwwwwwwwwwwww);
                return;
            }
            DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, false, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<WebSourceTitaData> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.FindCallback
        public void onFinish(WebSourceTitaData webSourceTitaData) {
            WebSourceTitaData webSourceTitaData2 = webSourceTitaData;
            if (webSourceTitaData2 == null) {
                DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            DetailActivity.this.Kkkkkkkkkkkkkkkkkkkkk = webSourceTitaData2.trans2WebSourceSeasonData();
            DetailActivity detailActivity = DetailActivity.this;
            ((vm0) detailActivity.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Wwwwwwwwwwwwwwwwwwwwwwww, detailActivity.Kkkkkkkkkkkkkkkkkkkkk, detailActivity.Wwwwwwwwwwwww, detailActivity.Wwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, String str2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            if (i != 0) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DetailActivity.this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, System.currentTimeMillis());
                return;
            }
            DetailActivity detailActivity = DetailActivity.this;
            String str = detailActivity.Wwwwwwwwwwww;
            String imgReferer = detailActivity.Kkkkkkkkkkkkkkkkkkkkk.getImgReferer();
            String webSourceSiteName = DetailActivity.this.Kkkkkkkkkkkkkkkkkkkkk.getWebSourceSiteName();
            DetailActivity detailActivity2 = DetailActivity.this;
            new VideoHistoryData(str, imgReferer, webSourceSiteName, detailActivity2.Wwwwwwwwwwwww, detailActivity2.Wwwwwwwwwww, detailActivity2.Wwwwwwwwwwwwww.getDesc(), DetailActivity.this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, System.currentTimeMillis(), DetailActivity.this.Kkkkkkkkkkkkkkkkkkkkk.isCustomWebSource()).saveAsync().listen(null);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<VideoHistoryData> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.FindCallback
        public void onFinish(VideoHistoryData videoHistoryData) {
            String str;
            boolean z;
            int i;
            int i2;
            VideoHistoryData videoHistoryData2 = videoHistoryData;
            if (videoHistoryData2 != null) {
                int channel = videoHistoryData2.getChannel();
                str = videoHistoryData2.getLastEpisode();
                if (!TextUtils.isEmpty(str) && channel < DetailActivity.this.Wwwwwwwwwwwwww.getChanelList().size()) {
                    i = 0;
                    while (i < DetailActivity.this.Wwwwwwwwwwwwww.getChanelList().get(channel).getEpisodeList().size()) {
                        if (DetailActivity.this.Wwwwwwwwwwwwww.getChanelList().get(channel).getEpisodeList().get(i).getCount().equals(str)) {
                            i2 = channel;
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                i2 = channel;
                z = false;
                i = 0;
            } else {
                str = "";
                z = false;
                i = 0;
                i2 = 0;
            }
            DetailActivity detailActivity = DetailActivity.this;
            detailActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Wwwwwwwwwwwwww.getChanelList(), i2);
            DetailActivity detailActivity2 = DetailActivity.this;
            detailActivity2.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity2.Wwwwwwwwwwwwww.getChanelList().get(i2).getEpisodeList(), i2, str);
            int i3 = i - 2;
            if (i3 > 0 || i - 1 > 0) {
                DetailActivity.this.rvEpisode.scrollToPosition(i3);
            }
            DetailActivity detailActivity3 = DetailActivity.this;
            detailActivity3.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity3.Wwwwwwwwwwwwww.getChanelList(), i2);
            DetailActivity detailActivity4 = DetailActivity.this;
            detailActivity4.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity4.Wwwwwwwwwwwwww.getChanelList().get(i2).getEpisodeList(), i2, str);
            if (DetailActivity.this.Wwwwwwwwwwwwww.getChanelList().get(i2).getEpisodeList() != null && !DetailActivity.this.Wwwwwwwwwwwwww.getChanelList().get(i2).getEpisodeList().isEmpty()) {
                try {
                    if (DetailActivity.this.Wwwwwwwwwwwwww.getChanelList().get(i2).getEpisodeList().get(i2).getCount().length() > 7) {
                        DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                    } else {
                        DetailActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (videoHistoryData2 != null && !z) {
                Snackbar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Snackbar.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DetailActivity.this.scrollContent, "播放记录定位错误，请手动选择集", 0);
                C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
            } else if (!bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("auto_play_activity", true)) {
            } else {
                DetailActivity detailActivity5 = DetailActivity.this;
                DetailActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity5, false, false, detailActivity5.Wwwwwwwwwwwwww.getChanelList().get(i2).getEpisodeList(), i2, DetailActivity.this.Wwwwwwwwwwwwww.getChanelList().get(i2).getEpisodeList().get(i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            ImageView imageView;
            int i2;
            if (i != 0) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DetailActivity.this.Wwwwwwwwwwwwwwwwwww);
                DetailActivity.this.tvOperate4.setText("收藏");
                imageView = DetailActivity.this.ivOperate4;
                i2 = R.drawable.ic_detail_collect_no;
            } else {
                DetailActivity detailActivity = DetailActivity.this;
                ((vm0) DetailActivity.this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Wwwwwwwwwwwww, detailActivity.Wwwwwwwwwww, detailActivity.Wwwwwwwwwwwwww.getDesc(), DetailActivity.this.Wwwwwwwwwwwwwwwwwww);
                DetailActivity.this.tvOperate4.setText("已收藏");
                imageView = DetailActivity.this.ivOperate4;
                i2 = R.drawable.ic_detail_collect_yes;
            }
            imageView.setImageResource(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements EpisodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements EpisodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    static {
        StubApp.interface11(11146);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public vm0 Wwwwwwwwwwwwwwww() {
        return new fm0();
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_detail;
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "请求失败");
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        LinearLayoutManager linearLayoutManager;
        ImageView imageView = this.ivSortType;
        if (z) {
            imageView.setImageResource(R.drawable.ic_category_vertical_green);
            linearLayoutManager = new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwwww, 4);
            try {
                this.rvAllEpisode.removeItemDecorationAt(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.rvAllEpisode.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15)));
        } else {
            imageView.setImageResource(R.drawable.ic_category_grid_green);
            linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            linearLayoutManager.setOrientation(1);
            try {
                this.rvAllEpisode.removeItemDecorationAt(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.rvAllEpisode.addItemDecoration(new SpacesItemDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15), 1));
        }
        this.rvAllEpisode.setLayoutManager(linearLayoutManager);
        this.Kkkkkkkkkkkkkkkkkkkkkk = z;
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwww = false;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Kkkkkkkkkkkkkkkkkkk) {
            WebSourceSeasonData cNTVWebSource = new WebSourceSeasonData().getCNTVWebSource();
            this.Kkkkkkkkkkkkkkkkkkkkk = cNTVWebSource;
            ((vm0) this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, cNTVWebSource, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww);
        } else if (this.Kkkkkkkkkkkkkkkkkk) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } else {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(z));
        }
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, (int) R.string.parse_error);
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            try {
                if (!this.myJzvdStd.Wwwwwwwwwwwwwwwwww.isPlaying()) {
                    return;
                }
                this.Wwwww = true;
                Wwwwww.Wwwwwwwwwwww();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        } catch (Exception unused) {
            Wwwwww.Wwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwww) {
            Wwwwww.Wwwwwwwwwww();
            this.Wwwww = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131  */
    @Override // me.tvspark.wm0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoDetailParcel videoDetailParcel) {
        TextView textView;
        String str;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        if (videoDetailParcel == null) {
            return;
        }
        this.Wwwwwwwwwwwwww = videoDetailParcel;
        if (this.Kkkkkkkkkkkkkkkkkkk) {
            this.tvWebUrl.setVisibility(8);
            this.Wwwwwwwwwwwwww.setDesc(this.Kkkkkkkkkkkkkkkkkkkk);
        } else {
            this.tvWebUrl.setText(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww));
        }
        this.tvWebName.setText(this.Kkkkkkkkkkkkkkkkkkkkk.getWebSourceSiteName());
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwww.getTitle())) {
            String title = this.Wwwwwwwwwwwwww.getTitle();
            this.Wwwwwwwwwwwww = title;
            this.tvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwww.getDesc()) && this.Wwwwwwwwwwwwww.getDesc().length() >= 5) {
            textView = this.tvDesc;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("简介：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwww.getDesc());
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        } else if (!this.Wwwwwwwwwwwwww.getTvsList().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.Wwwwwwwwwwwwww.getTvsList().size(); i++) {
                if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwww.getTvsList().get(i))) {
                    sb.append(this.Wwwwwwwwwwwwww.getTvsList().get(i));
                }
            }
            TextView textView2 = this.tvDesc;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("简介：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(sb.toString());
            textView2.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            if (!this.Wwwwwwwwwwwwww.getChanelList().isEmpty()) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwww.getCoverUrl()) && this.Wwwwwwwwwwwwww.getCoverUrl().startsWith("http") && !this.Wwwwwwwwwwwwww.getCoverUrl().equals(this.Wwwwwwwwwww)) {
                String coverUrl = this.Wwwwwwwwwwwwww.getCoverUrl();
                this.Wwwwwwwwwww = coverUrl;
                vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, coverUrl, this.ivPoster, "");
            } else if (!TextUtils.isEmpty(this.Wwwwwwwwwww)) {
                this.Wwwwwwwwwwwwww.setCoverUrl(this.Wwwwwwwwwww);
            }
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwww.getTitle())) {
                this.Wwwwwwwwwwwwww.setTitle(this.Wwwwwwwwwwwww);
            }
            if (this.Wwwwwwww == null || this.flytNative.getVisibility() != 8) {
            }
            this.flytNative.setVisibility(0);
            if (this.flytNative.getChildCount() > 0) {
                this.flytNative.removeAllViews();
            }
            this.flytNative.addView(this.Wwwwwwww);
            this.Wwwwwwww.render();
            return;
        } else {
            textView = this.tvDesc;
            str = "简介：暂无";
        }
        textView.setText(str);
        if (!this.Wwwwwwwwwwwwww.getChanelList().isEmpty()) {
        }
        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwww.getCoverUrl())) {
        }
        if (!TextUtils.isEmpty(this.Wwwwwwwwwww)) {
        }
        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwww.getTitle())) {
        }
        if (this.Wwwwwwww == null) {
        }
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str) {
        if (!z) {
            this.myJzvdStd.setSnifferUrl(str);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.llytAllChannel.getVisibility() == 0) {
            this.llytAllChannel.setVisibility(8);
            this.llytAllChannel.startAnimation(AnimationUtils.loadAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.push_bottom_out));
        } else if (Wwwwww.Wwwwwwwwwwwww()) {
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getWindow().addFlags(128);
        this.myJzvdStd.setKeepScreenOn(true);
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NativeExpressADView nativeExpressADView = this.Wwwwwwww;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
        Wwwwww.Wwwwwwwwww();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        getWindow().clearFlags(128);
        this.myJzvdStd.setKeepScreenOn(false);
        try {
            Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, (String) null);
            Wwwwww.Wwwwwwwwwwww();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getWindow().addFlags(128);
        this.myJzvdStd.setKeepScreenOn(true);
        try {
            Wwwwww.Wwwwwwwwwww();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.llyt_sort_type, R.id.iv_poster, R.id.llyt_operate5, R.id.tv_douban, R.id.llyt_sort_all, R.id.iv_all_channel_close, R.id.tv_desc, R.id.tv_desc_more, R.id.llyt_operate1, R.id.llyt_operate2, R.id.llyt_operate3, R.id.llyt_operate4, R.id.llyt_sort, R.id.llyt_open_all, R.id.tv_web_name, R.id.tv_web_url})
    public void onViewClicked(View view) {
        ChanelAdapter chanelAdapter;
        BaseActivity baseActivity;
        String str;
        switch (view.getId()) {
            case R.id.iv_all_channel_close /* 2131362147 */:
                if (this.llytAllChannel.getVisibility() != 0) {
                    return;
                }
                this.llytAllChannel.setVisibility(8);
                this.llytAllChannel.startAnimation(AnimationUtils.loadAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.push_bottom_out));
                return;
            case R.id.iv_poster /* 2131362186 */:
            case R.id.tv_desc /* 2131362670 */:
            case R.id.tv_desc_more /* 2131362671 */:
                VideoDetailParcel videoDetailParcel = this.Wwwwwwwwwwwwww;
                if (videoDetailParcel == null) {
                    return;
                }
                DialogDetailDesc dialogDetailDesc = new DialogDetailDesc(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkk, this.Wwwwwwwwwwwwwwwwwww, videoDetailParcel);
                if (dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
                    return;
                }
                dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
                dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
                dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwwww.show();
                Window window = dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
                window.setWindowAnimations(R.style.BotomInOutDialogStyle);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.width = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwww);
                attributes.height = (int) (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwww) - dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwww.getResources().getDimension(R.dimen.top_player_height));
                window.setAttributes(attributes);
                window.setContentView(dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwwwww);
                dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
                dialogDetailDesc.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
                return;
            case R.id.llyt_open_all /* 2131362272 */:
                if (this.llytAllChannel.getVisibility() != 8) {
                    return;
                }
                this.llytAllChannel.setVisibility(0);
                this.llytAllChannel.startAnimation(AnimationUtils.loadAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.push_bottom_in));
                return;
            case R.id.llyt_operate1 /* 2131362274 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwww);
                return;
            case R.id.llyt_operate2 /* 2131362275 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_operate3 /* 2131362276 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_operate4 /* 2131362277 */:
                if (this.Wwwwwwwwwwwwww == null) {
                    Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwwwww, "获取失败", 0).show();
                    return;
                } else {
                    yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    return;
                }
            case R.id.llyt_operate5 /* 2131362278 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_sort /* 2131362293 */:
                this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                chanelAdapter = this.Wwwwwwwwwwwwwwwwww;
                chanelAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case R.id.llyt_sort_all /* 2131362294 */:
                this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                chanelAdapter = this.Wwwwwwwwwwwwwwwww;
                chanelAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case R.id.llyt_sort_type /* 2131362295 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Kkkkkkkkkkkkkkkkkkkkkk);
                return;
            case R.id.tv_douban /* 2131362675 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwww);
                return;
            case R.id.tv_web_name /* 2131362762 */:
                if (this.Kkkkkkkkkkkkkkkkkkk) {
                    return;
                }
                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = this.Wwwwwwwwwwww;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) baseActivity, str, true);
                return;
            case R.id.tv_web_url /* 2131362763 */:
                if (this.Kkkkkkkkkkkkkkkkkkk) {
                    return;
                }
                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = this.Wwwwwwwwwwwwwwwwwww;
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) baseActivity, str, true);
                return;
            default:
                return;
        }
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onWebSourceDownload(ReqWebSourceEvent reqWebSourceEvent) {
        if (reqWebSourceEvent.getUrlWebSource().equals(ApplicationC1880C.Wwwwwwwwwwwwwwwww)) {
            if (reqWebSourceEvent.isSuccess()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DetailActivity detailActivity, boolean z, boolean z2, List list, int i, EpisodeParcel episodeParcel) {
        detailActivity.Www = true;
        if (!detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk.equals(episodeParcel.getLink()) || detailActivity.Wwww) {
            MyJzvdStd myJzvdStd = detailActivity.myJzvdStd;
            myJzvdStd.Sss.clear();
            myJzvdStd.f4523Ss = i;
            if (list != null) {
                myJzvdStd.Sss.addAll(list);
            }
            EpisodeFullPlayAdapter episodeFullPlayAdapter = myJzvdStd.Sssssssss;
            List<EpisodeParcel> list2 = myJzvdStd.Sss;
            if (episodeFullPlayAdapter != null) {
                if (list2 != null && !list2.isEmpty()) {
                    episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                    episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list2);
                    if (episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                        episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    episodeFullPlayAdapter.notifyDataSetChanged();
                }
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(detailActivity.Kkkkkkkkkkkkkkkkkkkkkkkkkk, new es0(detailActivity, false, new fs0(detailActivity, z, z2, list, i, episodeParcel)));
                return;
            }
            throw null;
        }
    }

    @Override // me.tvspark.wm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2, String str3) {
        getWindow().addFlags(128);
        this.myJzvdStd.setKeepScreenOn(true);
        EpisodeAdapter episodeAdapter = this.Wwwwwwwwwwwwwwww;
        if (episodeAdapter != null) {
            episodeAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            episodeAdapter.notifyDataSetChanged();
        }
        EpisodeAdapter episodeAdapter2 = this.Wwwwwwwwwwwwwww;
        if (episodeAdapter2 != null) {
            episodeAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            episodeAdapter2.notifyDataSetChanged();
        }
        this.myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        if (!bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no_history", false)) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, str2, str));
        }
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new gs0(this, str3, str2, i, str));
    }
}
