package me.tvspark;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.arialyy.aria.core.Aria;
import java.util.HashMap;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.data.bean.VideoDetailParcel;
import me.tvspark.data.sql.VideoCollectData;
import me.tvspark.data.sql.WebSourceSeasonData;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import me.tvspark.vl0;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class fm0 extends zk0<wm0> implements vm0 {
    public WebSourceSeasonData Wwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwww = "";
    public HashMap<String, String> Wwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public String Wwwwwwwwwwwwwwwwwwww = "";

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwwww
        public void onDismiss() {
            ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ WebSourceSeasonData Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements vl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public final /* synthetic */ Call Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Call call) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = call;
            }

            @Override // me.tvspark.vl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, VideoDetailParcel videoDetailParcel, String str) {
                if (z) {
                    ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoDetailParcel);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.onFailure(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Throwable());
                }
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceSeasonData webSourceSeasonData, Activity activity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceSeasonData;
            this.Wwwwwwwwwwwwwwwwwwwwwww = activity;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            th.printStackTrace();
            ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                String string = response.body().string();
                fm0.this.Wwwwwwwwwwwwwwwwwwww = un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), string);
                if (!TextUtils.isEmpty(fm0.this.Wwwwwwwwwwwwwwwwwwww)) {
                    fm0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    new vl0(string, this.Wwwwwwwwwwwwwwwwwwwwwwww, fm0.this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call)).execute(new Void[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
                onFailure(call, e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements j60<String> {
        public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ WebSourceSeasonData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceSeasonData webSourceSeasonData, Activity activity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceSeasonData;
            this.Wwwwwwwwwwwwwwwwwwwwwww = activity;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.j60
        public void onNext(String str) {
            String str2 = str;
            try {
                fm0.this.Wwwwwwwwwwwwwwwwwwww = un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), str2);
                if (!TextUtils.isEmpty(fm0.this.Wwwwwwwwwwwwwwwwwwww)) {
                    fm0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    new vl0(str2, this.Wwwwwwwwwwwwwwwwwwwwwwww, fm0.this.Wwwwwwwwwwwwwwwwwwwwwww, new em0(this)).execute(new Void[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
                ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fm0 fm0Var, String str, String str2, String str3, String str4, boolean z) {
        if (Aria.download(((wm0) fm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext()).taskExists(str)) {
            if (!z) {
                return;
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((wm0) fm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), "已存在，请查看我的缓存");
            return;
        }
        if (z) {
            BaseActivity mo4928getContext = ((wm0) fm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext();
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4928getContext, str3 + " 加入缓存列表");
        }
        String replace = str2.replace("/", "");
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((wm0) fm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), str, bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((wm0) fm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext()) + "download/" + replace + "/" + str3.replace("/", "") + "-" + replace, -1L, 0);
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(replace, str4);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, String str3, String str4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false, 2, str, str2, i, str3, str4);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, String str3, String str4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false, 3, str, str2, i, str3, str4);
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        HashMap<String, String> hashMap = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (hashMap != null) {
            hashMap.clear();
        }
        ApplicationC1880C.Wwwwwwwwwwww.clear();
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, String str3, String str4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false, 5, str, str2, i, str3, str4);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, String str3, String str4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false, 6, str, str2, i, str3, str4);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, List<EpisodeParcel> list, String str, String str2, String str3, int i, String str4, String str5) {
        ((wm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ApplicationC1880C.Wwwwwwwwwwww.setData(list, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z2, 7, str, str2, i, str4, str5);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, WebSourceSeasonData webSourceSeasonData, String str, String str2) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        ((wm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwww = str2;
        if (webSourceSeasonData == null) {
            ((wm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = webSourceSeasonData;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, webSourceSeasonData);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, String str3, String str4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false, -1, str, str2, i, str3, str4);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, int i, String str4, String str5) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false, 0, str, str2, i, str4, str5);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, String str4) {
        new VideoCollectData(this.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwww.getImgReferer(), this.Wwwwwwwwwwwwwwwwwwwww.getWebSourceSiteName(), str, str2, str3, str4, System.currentTimeMillis(), this.Wwwwwwwwwwwwwwwwwwwww.isCustomWebSource()).saveAsync().listen(null);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i, String str, String str2, String str3, int i2, String str4, String str5) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, z, i, str, str2, i2, str4, str5);
    }

    @Override // me.tvspark.vm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, List<EpisodeParcel> list, String str, String str2, String str3, int i, String str4, String str5) {
        ApplicationC1880C.Wwwwwwwwwww.setData(list, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, z, z2 ? 14 : 9, str, str2, i, str4, str5);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2, String str3, String str4, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, DialogParse dialogParse) {
            if (dialogParse != null) {
                dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z) {
            if (z || !str.startsWith("http")) {
                return;
            }
            fm0.this.Wwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
            if (i == 7) {
                ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
            } else if (i != 11) {
            } else {
                fm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fm0.this, str, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogParse.Wwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, String str2, String str3, String str4) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str4;
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, DialogParse dialogParse) {
            if (dialogParse != null) {
                dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        }

        @Override // me.tvspark.utils.sniffer.dialog.DialogParse.Wwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, boolean z) {
            if (z || !str.startsWith("http")) {
                return;
            }
            fm0.this.Wwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
            if (i == 7) {
                ((wm0) fm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str);
            } else if (i != 11) {
            } else {
                fm0 fm0Var = fm0.this;
                fm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fm0Var, fm0Var.Wwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.zk0, me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull cl0 cl0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cl0Var;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final Activity activity, WebSourceSeasonData webSourceSeasonData) {
        final String str = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwww)) {
            str = this.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = "";
        }
        if (!webSourceSeasonData.isUseWebViewReq()) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceSeasonData.getWebSourceBaseUrl(), webSourceSeasonData.getHttpUserAgent()).get(str).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceSeasonData, activity));
            return;
        }
        final String httpUserAgent = webSourceSeasonData.getHttpUserAgent();
        d60.create(new f60() { // from class: me.tvspark.i40
            @Override // me.tvspark.f60
            public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e60 e60Var) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, httpUserAgent, str, e60Var);
            }
        }).subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceSeasonData, activity));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, int i, String str, String str2, int i2, String str3, String str4) {
        try {
            String str5 = TextUtils.isEmpty(str3) ? "" : str3;
            if (this.Wwwwwwwwwwwwwwwwwwwwww.containsKey(str4)) {
                DialogParse dialogParse = new DialogParse(((wm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext());
                dialogParse.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                dialogParse.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4, i2, str5, str, str2);
                dialogParse.Kkkkkkkkkkkkkkkkk = z2;
                dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwwww.get(str4), str, str4, this.Wwwwwwwwwwwwwwwwwwwwwww, str5, i);
            } else {
                DialogParse dialogParse2 = new DialogParse(((wm0) this.Wwwwwwwwwwwwwwwwwwwwwwww).mo4928getContext(), this.Wwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwwwww, str4, str, str5, i, false);
                dialogParse2.Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                dialogParse2.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4, i2, str5, str, str2, z);
                dialogParse2.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                dialogParse2.Kkkkkkkkkkkkkkkkk = z2;
                dialogParse2.Kkkkkkkkkkkkkkkk = z;
                dialogParse2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
