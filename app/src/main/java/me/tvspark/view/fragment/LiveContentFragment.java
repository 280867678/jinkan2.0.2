package me.tvspark.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import java.util.List;
import me.tvspark.adapter.LiveListAdapter;
import me.tvspark.bn0;
import me.tvspark.cn0;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.bean.LiveParcel;
import me.tvspark.data.sql.WebSourceLiveData;
import me.tvspark.im0;
import me.tvspark.jl0;
import me.tvspark.mn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class LiveContentFragment extends BaseFragment<bn0> implements cn0 {
    public LiveParcel Wwwwwwwwwwwwww;
    public WebSourceLiveData Wwwwwwwwwwwwwww;
    public LiveListAdapter Wwwwwwwwwwwwwwww;
    public LiveListAdapter Wwwwwwwwwwwwwwwww;
    @BindView(R.id.llyt_all)
    public LinearLayout llytAll;
    @BindView(R.id.llyt_error)
    public LinearLayout llytError;
    @BindView(R.id.llyt_right_retry)
    public LinearLayout llytRightRetry;
    @BindView(R.id.pb_all)
    public ProgressBar pbAll;
    @BindView(R.id.pb_right)
    public ProgressBar pbRight;
    @BindView(R.id.rv_channel)
    public RecyclerView rvChannel;
    @BindView(R.id.rv_episode)
    public RecyclerView rvEpisode;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements LiveListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.LiveListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
            ((bn0) LiveContentFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(liveParcel);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements LiveListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public final /* synthetic */ LiveParcel Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = liveParcel;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) LiveContentFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getChanelUrl(), true);
                } else if (i == 1) {
                    ((bn0) LiveContentFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                } else if (i != 2) {
                } else {
                    ((bn0) LiveContentFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LiveContentFragment.this.Wwwwwwwwwwwwwwwwwwwwwww);
            builder.setTitle(liveParcel.getChanelName());
            builder.setItems(new String[]{"※ 嗅探网页浏览", "※ 云播投屏播放", "※ DLNA投屏播放"}, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(liveParcel));
            builder.setCancelable(true);
            builder.create().show();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements LiveListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.LiveListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
            LiveContentFragment liveContentFragment = LiveContentFragment.this;
            liveContentFragment.Wwwwwwwwwwwwww = liveParcel;
            ((bn0) liveContentFragment.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(liveParcel);
        }
    }

    public void Wwwwwwwwwwwwww() {
        WebSourceLiveData webSourceLiveData;
        if (!getUserVisibleHint() || !this.Wwwwwwwwwwwwwwwwwwwwww || (webSourceLiveData = this.Wwwwwwwwwwwwwww) == null) {
            return;
        }
        ((bn0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceLiveData);
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bn0 Wwwwwwwwwwwwwwwww() {
        return new im0();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_live_content;
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwww() {
        this.llytAll.setVisibility(0);
        this.pbAll.setVisibility(8);
        this.pbRight.setVisibility(8);
        this.rvEpisode.setVisibility(8);
        this.llytError.setVisibility(8);
        this.llytRightRetry.setVisibility(0);
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwwww() {
        this.llytAll.setVisibility(8);
        this.pbAll.setVisibility(8);
        this.llytError.setVisibility(0);
        this.llytRightRetry.setVisibility(8);
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwwwwwww() {
        this.llytAll.setVisibility(0);
        this.pbAll.setVisibility(8);
        this.pbRight.setVisibility(0);
        this.rvEpisode.setVisibility(8);
        this.llytError.setVisibility(8);
        this.llytRightRetry.setVisibility(8);
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        new BaseFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().start();
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.llytAll.setVisibility(8);
        this.pbAll.setVisibility(0);
        this.llytError.setVisibility(8);
        this.llytRightRetry.setVisibility(8);
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<LiveParcel> list) {
        LiveListAdapter liveListAdapter = this.Wwwwwwwwwwwwwwwww;
        if (list != null) {
            liveListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            liveListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        liveListAdapter.notifyDataSetChanged();
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        LiveListAdapter liveListAdapter = this.Wwwwwwwwwwwwwwwww;
        liveListAdapter.Wwwwwwwwwwwwwwwwwwww = str;
        liveListAdapter.notifyDataSetChanged();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwwwww = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().get(getArguments().getInt("key_integer"));
        LiveListAdapter liveListAdapter = new LiveListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, true);
        liveListAdapter.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwww = liveListAdapter;
        LiveListAdapter liveListAdapter2 = new LiveListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, false);
        liveListAdapter2.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        liveListAdapter2.Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwww = liveListAdapter2;
        this.rvChannel.setAdapter(this.Wwwwwwwwwwwwwwwww);
        this.rvChannel.setLayoutManager(new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww));
        this.rvEpisode.setAdapter(this.Wwwwwwwwwwwwwwww);
        this.rvEpisode.setLayoutManager(new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww));
        Wwwwwwwwwwwwww();
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, List<LiveParcel> list) {
        this.llytAll.setVisibility(0);
        this.pbAll.setVisibility(8);
        this.pbRight.setVisibility(0);
        this.rvEpisode.setVisibility(8);
        this.llytError.setVisibility(8);
        this.llytRightRetry.setVisibility(8);
        if (list != null && !list.isEmpty()) {
            this.Wwwwwwwwwwwwww = list.get(0);
        }
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, list);
    }

    @Override // me.tvspark.cn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, List<LiveParcel> list, List<LiveParcel> list2) {
        this.llytAll.setVisibility(0);
        this.pbAll.setVisibility(8);
        this.pbRight.setVisibility(8);
        this.rvEpisode.setVisibility(0);
        this.llytError.setVisibility(8);
        this.llytRightRetry.setVisibility(8);
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, list2);
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, list);
    }

    @OnClick({R.id.tv_right_retry, R.id.tv_retry})
    public void onViewClicked(View view) {
        LiveParcel liveParcel;
        int id = view.getId();
        if (id == R.id.tv_retry) {
            Wwwwwwwwwwwwww();
        } else if (id != R.id.tv_right_retry || (liveParcel = this.Wwwwwwwwwwwwww) == null) {
        } else {
            ((bn0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(liveParcel);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Wwwwwwwwwwwwww();
    }
}
