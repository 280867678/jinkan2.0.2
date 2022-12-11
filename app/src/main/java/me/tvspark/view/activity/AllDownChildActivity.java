package me.tvspark.view.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.cu0;
import me.tvspark.data.event.FileEvent;
import me.tvspark.data.sql.DownPlayHistoryData;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.utils.cast.p050ui.DialogDlna;
import me.tvspark.xt0;
import me.tvspark.yn0;
import org.litepal.crud.callback.FindCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class AllDownChildActivity extends BaseActivity {
    public String Wwwwwwwwwwwwwwwww;
    public AllDownAdapter Wwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.fab_cast)
    public FloatingActionButton fabCast;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rlyt_top_bar)
    public RelativeLayout rlytTopBar;
    @BindView(R.id.rv_content)
    public RecyclerView rvContent;
    @BindView(R.id.tv_dlna)
    public TextView tvDlna;
    @BindView(R.id.tv_history)
    public TextView tvHistory;
    @BindView(R.id.tv_title)
    public TextView tvTitle;

    /* loaded from: classes4.dex */
    public class AllDownAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public List<DownloadEntity> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_path)
            public TextView tvPath;
            @BindView(R.id.tv_title)
            public TextView tvTitle;

            public ViewHolder(AllDownAdapter allDownAdapter, View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        /* loaded from: classes4.dex */
        public class ViewHolder_ViewBinding implements Unbinder {
            public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
                viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
                viewHolder.tvPath = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_path, "field 'tvPath'", TextView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (viewHolder != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    viewHolder.tvTitle = null;
                    viewHolder.tvPath = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLongClickListener {
            public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ DownloadEntity Wwwwwwwwwwwwwwwwwwwwwwww;

            /* loaded from: classes4.dex */
            public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {

                /* renamed from: me.tvspark.view.activity.AllDownChildActivity$AllDownAdapter$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class DialogInterface$OnClickListenerC3496Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
                    public DialogInterface$OnClickListenerC3496Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".ts";
                        try {
                            File file = new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath());
                            File file2 = new File(str);
                            if (file.isFile() && file.exists()) {
                                file.delete();
                            } else if (file2.isFile() && file2.exists()) {
                                file2.delete();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Aria.download(AllDownAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).load(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getId()).cancel(false);
                        o11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new FileEvent(AllDownChildActivity.this.Wwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getUrl()));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                        AllDownAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww);
                        AllDownAdapter.this.notifyDataSetChanged();
                    }
                }

                /* renamed from: me.tvspark.view.activity.AllDownChildActivity$AllDownAdapter$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class C3497Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
                    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

                    public C3497Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                    }

                    @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog) {
                        dialog.dismiss();
                    }

                    @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog, String str) {
                        dialog.dismiss();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                        new DialogDlna(AllDownAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                }

                public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    String str;
                    if (i != 0) {
                        if (i != 1) {
                            return;
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("是否删除 ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ？");
                        AlertDialog create = builder.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()).setPositiveButton("删除", new DialogInterface$OnClickListenerC3496Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
                        create.setCanceledOnTouchOutside(true);
                        create.show();
                        return;
                    }
                    try {
                    } catch (Exception e) {
                        e.printStackTrace();
                        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "文件打开错误");
                    }
                    if (new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".ts").exists()) {
                        str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".ts";
                    } else if (new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath()).exists()) {
                        str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath();
                    } else {
                        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "文件已不存在");
                        str = "";
                    }
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (ApplicationC1880C.Wwwww) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                        new DialogDlna(AllDownAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName(), str, false).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                    ApplicationC1880C.Wwwww = true;
                    cu0 cu0Var = new cu0(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "说明", AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww.getString(R.string.local_dlna_tips));
                    cu0Var.Wwwwwwww = true;
                    cu0Var.Wwwwwwwwwwwww = "取 消";
                    cu0Var.Wwwwwwwwwwww = "了 解";
                    cu0Var.Wwwwwwwwwwwwwww = new C3497Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                    cu0Var.Wwwwww = -1;
                    cu0Var.Wwwww = 15;
                    cu0Var.Wwwwwww = 17;
                    cu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownloadEntity downloadEntity, int i) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = downloadEntity;
                this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                builder.setItems(new String[]{"投屏播放", "删除文件"}, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                builder.setCancelable(true);
                builder.create().show();
                return false;
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
            public final /* synthetic */ DownloadEntity Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownloadEntity downloadEntity) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = downloadEntity;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AllDownChildActivity allDownChildActivity;
                String fileName;
                try {
                    if (new File(this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".ts").exists()) {
                        BaseActivity baseActivity = AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath() + ".ts", this.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName(), 0L, false);
                        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName());
                        allDownChildActivity = AllDownChildActivity.this;
                        fileName = this.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName();
                    } else if (!new File(this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath()).exists()) {
                        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "文件已不存在");
                        return;
                    } else {
                        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilePath(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName(), 0L, false);
                        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName());
                        allDownChildActivity = AllDownChildActivity.this;
                        fileName = this.Wwwwwwwwwwwwwwwwwwwwwwww.getFileName();
                    }
                    AllDownChildActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allDownChildActivity, fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "文件打开错误");
                }
            }
        }

        public AllDownAdapter(Activity activity, List<DownloadEntity> list) {
            ArrayList arrayList = new ArrayList();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
            arrayList.addAll(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<DownloadEntity> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            DownloadEntity downloadEntity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            if (downloadEntity == null) {
                return;
            }
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.tvTitle.setText(downloadEntity.getFileName());
            viewHolder2.tvPath.setText(downloadEntity.getFilePath());
            viewHolder2.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadEntity));
            viewHolder2.itemView.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downloadEntity, i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_all_down_child, viewGroup, false));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<DownPlayHistoryData> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.FindCallback
        public void onFinish(DownPlayHistoryData downPlayHistoryData) {
            DownPlayHistoryData downPlayHistoryData2 = downPlayHistoryData;
            if (downPlayHistoryData2 == null) {
                AllDownChildActivity.this.tvHistory.setVisibility(8);
            } else {
                AllDownChildActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this, downPlayHistoryData2.getTitle());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    static {
        StubApp.interface11(11101);
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownChildActivity allDownChildActivity, String str) {
        allDownChildActivity.tvHistory.setVisibility(0);
        TextView textView = allDownChildActivity.tvHistory;
        textView.setText("上次：" + str);
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
        return R.layout.activity_all_down_parent;
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @OnClick({R.id.iv_top_back})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.iv_top_back) {
            return;
        }
        finish();
    }
}
