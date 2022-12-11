package me.tvspark;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.fastjson.JSON;
import me.tvspark.data.bean.VersionParcel;
import me.tvspark.utils.SKUtils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import white.whale.R;

/* loaded from: classes4.dex */
public class am0 extends zk0<um0> implements tm0 {

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ VersionParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VersionParcel versionParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = versionParcel;
        }

        @Override // java.lang.Runnable
        public void run() {
            am0 am0Var = am0.this;
            VersionParcel versionParcel = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            ((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("n_flag", 0);
            if (versionParcel.getnType().equals("wforce") || versionParcel.getnFlag() > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("n_flag", Integer.valueOf(versionParcel.getnFlag()));
                AlertDialog create = new AlertDialog.Builder(((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext()).setTitle("通知").setMessage(versionParcel.getnContent()).setCancelable(!versionParcel.getnType().equals("wforce")).setPositiveButton(versionParcel.getnType().startsWith("wforce") ? "" : (!versionParcel.getnType().startsWith("wdetail") && !versionParcel.getnType().startsWith("http")) ? "确定" : "详情", (DialogInterface.OnClickListener) null).create();
                create.show();
                create.getButton(-1).setOnClickListener(new dm0(am0Var, versionParcel, create));
            }
            am0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(am0.this, this.Wwwwwwwwwwwwwwwwwwwwwwww, true);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            th.printStackTrace();
            ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                VersionParcel versionParcel = (VersionParcel) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response.body().string())), VersionParcel.class);
                if (versionParcel != null) {
                    ApplicationC1880C.Wwwwwwwwwwwwwww = versionParcel;
                    am0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(versionParcel, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
                ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.am0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC3468Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ VersionParcel Wwwwwwwwwwwwwwwwwwwwwwww;

            public RunnableC3468Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VersionParcel versionParcel) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = versionParcel;
            }

            @Override // java.lang.Runnable
            public void run() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                boolean z = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                am0 am0Var = am0.this;
                if (z) {
                    am0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(am0Var, this.Wwwwwwwwwwwwwwwwwwwwwwww, false);
                } else {
                    am0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(am0Var, this.Wwwwwwwwwwwwwwwwwwwwwwww.getShareUrl());
                }
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            th.printStackTrace();
            ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                VersionParcel versionParcel = (VersionParcel) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response.body().string())), VersionParcel.class);
                if (versionParcel != null) {
                    ApplicationC1880C.Wwwwwwwwwwwwwww = versionParcel;
                    ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                    new Handler(Looper.getMainLooper()).post(new RunnableC3468Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(versionParcel));
                } else {
                    ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                    ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
                ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                ((um0) am0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            }
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(am0 am0Var, VersionParcel versionParcel, boolean z) {
        ((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        if (versionParcel.getLatestVersionCode() > 0) {
            ((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext();
            if (302 < versionParcel.getLatestVersionCode()) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("新版本：");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(versionParcel.getLatestVersionName());
                String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                if (versionParcel.getChangelog() != null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "\n\n更新日志：\n\n");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(versionParcel.getChangelog());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("\n");
                    sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                }
                AlertDialog create = new AlertDialog.Builder(((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext()).setTitle("发现更新").setMessage(sb).setNegativeButton("忽略", (DialogInterface.OnClickListener) null).setPositiveButton("去下载", (DialogInterface.OnClickListener) null).create();
                if (versionParcel.isForceUpdate()) {
                    create.setCancelable(false);
                }
                create.show();
                create.getButton(-1).setOnClickListener(new bm0(am0Var, versionParcel, create));
                create.getButton(-2).setOnClickListener(new cm0(am0Var, versionParcel, create));
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_index", false);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_category", false);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_index_rec", false);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_season", false);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_live", false);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_down", false);
                return;
            }
        }
        if (!z) {
            Toast.makeText(((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), "已是最新版本", 0).show();
        }
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.tm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        if (z) {
            pn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwww).get(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwww).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z));
    }

    @Override // me.tvspark.tm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        VersionParcel versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww;
        if (versionParcel == null || z) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwww).get(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwww).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z));
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(versionParcel, z);
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(am0 am0Var, String str) {
        ((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), ((um0) am0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext().getResources().getString(R.string.share_msg) + str);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VersionParcel versionParcel, boolean z) {
        ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwww = versionParcel.isGoWebPlay();
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type", Integer.valueOf(versionParcel.getAd_type()));
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("data_type", Integer.valueOf(versionParcel.getData_type()));
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("data_pic", versionParcel.getData_pic());
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("data_url", versionParcel.getData_url());
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_index_url", versionParcel.getHostIndex());
        if (versionParcel.getbWords() != null) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwww(JSON.toJSONString(versionParcel.getbWords()));
        }
        ((um0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        if (!z) {
            new Handler(Looper.getMainLooper()).post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(versionParcel));
        }
    }
}
