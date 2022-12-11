package me.tvspark;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.util.List;
import me.tvspark.data.bean.VersionParcel;
import me.tvspark.data.event.ReqWebSourceEvent;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.data.sql.WebSourceLiveData;
import me.tvspark.data.sql.WebSourceSeasonData;
import me.tvspark.jo0;
import me.tvspark.utils.SKUtils;
import okhttp3.ResponseBody;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.crud.callback.SaveCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class jl0 extends yk0 implements sk0 {
    public static List<WebSourceLiveData> Wwwwwwwwwwwwwww;
    public static WebSourceIndexRecData Wwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // org.litepal.crud.callback.SaveCallback
            public void onFinish(boolean z) {
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwwwww, z));
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            jl0.Wwwwwwwwwwwwwwwwwwwwwwww = false;
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwwwww, false));
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                WebSourceIndexRecData webSourceIndexRecData = (WebSourceIndexRecData) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response.body().string())), WebSourceIndexRecData.class);
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexRecData, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
                jl0.Wwwwwwwwwwwwwwww = webSourceIndexRecData;
                jl0.Wwwwwwwwwwwwwwwwwwww = true;
            } catch (Exception e) {
                e.printStackTrace();
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwwwww, false));
            }
            jl0.Wwwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Context Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends TypeReference<List<WebSourceLiveData>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {

            /* renamed from: me.tvspark.jl0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C3477Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebSourceLiveData> {
                public C3477Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                }

                @Override // org.litepal.crud.callback.FindMultiCallback
                public void onFinish(List<WebSourceLiveData> list) {
                    o11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    ReqWebSourceEvent reqWebSourceEvent;
                    jl0.Wwwwwwwwwwwwwww = list;
                    if (list == null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        reqWebSourceEvent = new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwww, false);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        reqWebSourceEvent = new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwww, true);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(reqWebSourceEvent);
                }
            }

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // org.litepal.crud.callback.SaveCallback
            public void onFinish(boolean z) {
                VersionParcel versionParcel;
                jl0.Wwwwwwwwwwwwwwwww = true;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww || ((versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww) != null && versionParcel.getNeedUpdateWebsourceApkVersion() == 302)) {
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_live", true);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, "直播");
                    return;
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww) {
                    jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, "直播");
                }
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwww(new C3477Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Context context, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwww = z2;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            jl0.Wwwwwwwwwwwwwwwwwwwww = false;
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwww, false));
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((List) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response.body().string())), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this), new Feature[0]), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            } catch (Exception e) {
                e.printStackTrace();
                if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
                    o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwww, false));
                }
            }
            jl0.Wwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Context Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.jl0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends TypeReference<List<WebSourceSeasonData>> {
            public C3478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements jo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.jo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void onFinish(boolean z) {
                VersionParcel versionParcel;
                jl0.Wwwwwwwwwwwwwwwwww = true;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww || ((versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww) != null && versionParcel.getNeedUpdateWebsourceApkVersion() == 302)) {
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_season", true);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, "详情");
                    return;
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww) {
                    jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, "详情");
                }
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwww, true));
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Context context, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwww = z2;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            jl0.Wwwwwwwwwwwwwwwwwwwwww = false;
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwww, false));
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                String Wwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response.body().string()));
                jo0 jo0Var = new jo0();
                jo0Var.Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jo0Var.Wwwwwwwwwwwwwwwwwwwwww = (List) JSON.parseObject(Wwwwwwwwwwwwwwwwwwwwwwww, new C3478Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this), new Feature[0]);
                jo0Var.execute(new Void[0]);
            } catch (Exception e) {
                e.printStackTrace();
                if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
                    o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwww, false));
                }
            }
            jl0.Wwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Context Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends TypeReference<List<WebSourceIndexData>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
        }

        /* renamed from: me.tvspark.jl0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements jo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public C3479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.jo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void onFinish(boolean z) {
                VersionParcel versionParcel;
                jl0.Wwwwwwwwwwwwwwwwwww = true;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww || ((versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww) != null && versionParcel.getNeedUpdateWebsourceApkVersion() == 302)) {
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_index", true);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, "站源");
                    return;
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww) {
                    jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, "站源");
                }
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwwww, true));
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Context context, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwww = z2;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            jl0.Wwwwwwwwwwwwwwwwwwwwwww = false;
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwwww, false));
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                String Wwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response.body().string()));
                jo0 jo0Var = new jo0();
                jo0Var.Wwwwwwwwwwwwwwwwwwwwwwww = new C3479Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jo0Var.Wwwwwwwwwwwwwwwwwwwwwww = (List) JSON.parseObject(Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this), new Feature[0]);
                jo0Var.execute(new Void[0]);
            } catch (Exception e) {
                e.printStackTrace();
                if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
                    o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ReqWebSourceEvent(ApplicationC1880C.Wwwwwwwwwwwwwwwwww, false));
                }
            }
            jl0.Wwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, boolean z, boolean z2) {
        if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(context) && !Wwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwww = true;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwwwww).get(ApplicationC1880C.Wwwwwwwwwwwwwwwww).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, context, z));
        }
    }

    public static List<WebSourceLiveData> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwww();
        }
        return Wwwwwwwwwwwwwww;
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle("更新");
        title.setMessage("【" + str + "】配置已下载并更新完成").setPositiveButton("OK", (DialogInterface.OnClickListener) null).create().show();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, boolean z, boolean z2) {
        if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(context) && !Wwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwww = true;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwwww).get(ApplicationC1880C.Wwwwwwwwwwwwwwww).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, context, z));
        }
    }

    public static WebSourceIndexRecData Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return Wwwwwwwwwwwwwwww;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(context) && !Wwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwww = true;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwwwwwww).get(ApplicationC1880C.Wwwwwwwwwwwwwwwwwww).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle("配置");
        title.setMessage("新升级APP后【" + str + "】已完成配置，请继续点击其他模块页面，一并更新配置，重启APP后生效").setPositiveButton("OK", (DialogInterface.OnClickListener) null).create().show();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, WebSourceSeasonData webSourceSeasonData) {
        VersionParcel versionParcel;
        VersionParcel versionParcel2 = ApplicationC1880C.Wwwwwwwwwwwwwww;
        if (versionParcel2 != null && versionParcel2.getNeedUpdateWebsourceApkVersion() == 302 && !bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_season", false)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, false, true);
        } else if (Wwwwwwwwwwwwwwwwww || webSourceSeasonData == null || (versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww) == null || versionParcel.getRuleSeasonVersion() <= webSourceSeasonData.getVersion()) {
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, true, false);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, boolean z, boolean z2) {
        if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwww(context) && !Wwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwww = true;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwww(ApplicationC1880C.Wwwwwwwwwwwwwwwwww).get(ApplicationC1880C.Wwwwwwwwwwwwwwwwww).enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, context, z));
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, WebSourceIndexData webSourceIndexData) {
        VersionParcel versionParcel;
        VersionParcel versionParcel2 = ApplicationC1880C.Wwwwwwwwwwwwwww;
        if (versionParcel2 != null && versionParcel2.getNeedUpdateWebsourceApkVersion() == 302 && !bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_index", false)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, false, true);
            return true;
        } else if (Wwwwwwwwwwwwwwwwwww || webSourceIndexData == null || (versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww) == null || versionParcel.getRuleIndexVersion() <= webSourceIndexData.getVersion()) {
            return false;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, true, false);
            return true;
        }
    }
}
