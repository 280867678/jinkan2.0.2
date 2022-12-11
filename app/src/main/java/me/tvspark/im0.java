package me.tvspark;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.LiveParcel;
import me.tvspark.data.sql.WebSourceLiveData;
import me.tvspark.tl0;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class im0 extends zk0<cn0> implements bn0 {
    public WebSourceLiveData Wwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwww = "";
    public List<LiveParcel> Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwwww
        public void onDismiss() {
            ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwwww
        public void onDismiss() {
            ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.im0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements tl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public C3475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            Object obj;
            th.printStackTrace();
            if (im0.this.Wwwwwwwwwwwwwwwwwwwww.isAllGeted()) {
                obj = im0.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            } else if (TextUtils.isEmpty(im0.this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                obj = im0.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwww();
                return;
            }
            ((cn0) obj).Wwwwwwwwwwwwwwwwwwww();
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            BaseActivity mo4928getContext = ((cn0) im0.this.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext();
            boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            im0 im0Var = im0.this;
            new tl0(mo4928getContext, z, im0Var.Wwwwwwwwwwwwwwwwwwwww, im0Var.Wwwwwwwwwwwwwwwwwwwwwww, response, new C3475Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).execute(new Void[0]);
        }
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.bn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = liveParcel.getChanelName();
        if (!liveParcel.getEpisodeList().isEmpty()) {
            ((cn0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, liveParcel.getEpisodeList());
            return;
        }
        ((cn0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, liveParcel.getChanelUrl());
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwww)) {
            ((cn0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            ((cn0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwww();
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwww.getHttpUserAgent()).get(str).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z));
    }

    @Override // me.tvspark.bn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceLiveData webSourceLiveData) {
        this.Wwwwwwwwwwwwwwwwwwwww = webSourceLiveData;
        List<LiveParcel> list = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (list == null || list.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, webSourceLiveData.getWebSourceBaseUrl());
        }
    }

    @Override // me.tvspark.bn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, LiveParcel liveParcel) {
        ApplicationC1880C.Wwwwwwwwwww.setData(new ArrayList(), 0);
        DialogParse dialogParse = new DialogParse(((cn0) this.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), this.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), liveParcel.getChanelUrl(), liveParcel.getChanelUrl(), liveParcel.getChanelName(), "直播", z ? 14 : 9, true);
        dialogParse.Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.bn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveParcel liveParcel) {
        DialogParse dialogParse = new DialogParse(((cn0) this.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), this.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), liveParcel.getChanelUrl(), liveParcel.getChanelUrl(), liveParcel.getChanelName(), "直播", bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_live_type", 4), true);
        dialogParse.Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
