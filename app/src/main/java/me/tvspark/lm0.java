package me.tvspark;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.ol0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.litepal.crud.callback.CountCallback;
import org.litepal.crud.callback.FindMultiCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public class lm0 extends zk0<in0> implements hn0 {
    public boolean Wwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww = 3;
    public List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public boolean Wwwwwwwwwwwwwwwwwwwww = false;
    public LinkedBlockingQueue<Integer> Wwwwwwwwwwwwwwwwwww = new LinkedBlockingQueue<>();
    public LinkedBlockingQueue<WebSourceIndexData> Wwwwwwwwwwwwwwwwww = new LinkedBlockingQueue<>();
    public LinkedBlockingQueue<Integer> Wwwwwwwwwwwwwwwww = new LinkedBlockingQueue<>();
    public int Wwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
            public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ WebSourceIndexData Wwwwwwwwwwwwwwwwwwwwwwww;

            /* loaded from: classes4.dex */
            public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ol0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
                public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                }
            }

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexData webSourceIndexData, String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = webSourceIndexData;
                this.Wwwwwwwwwwwwwwwwwwwwwww = str;
                this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable th) {
                th.printStackTrace();
                if (!lm0.this.Wwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    boolean z = true;
                    lm0.this.Wwwwwwwwwwwwwwwww.add(1);
                    ((in0) lm0.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getWebSourceSiteName(), lm0.this.Wwwwwwwwwwwwwwwww.size() + 1, lm0.this.Wwwwwwwwwwwwwwww);
                    int size = lm0.this.Wwwwwwwwwwwwwwwww.size();
                    lm0 lm0Var = lm0.this;
                    int i = lm0Var.Wwwwwwwwwwwwwwww;
                    if (size != i) {
                        return;
                    }
                    lm0Var.Wwwwwwwwwwwwww += i;
                    lm0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    lm0 lm0Var2 = lm0.this;
                    in0 in0Var = (in0) lm0Var2.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (lm0Var2.Wwwwwwwwwwwwww < lm0Var2.Wwwwwwwwwwwww) {
                        z = false;
                    }
                    in0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, z);
                }
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (lm0.this.Wwwwwwwwwwwwwww) {
                        return;
                    }
                    new ol0(response.body(), this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).execute(new Void[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                    onFailure(call, e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexData webSourceIndexData, String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            String encode;
            Call<ResponseBody> call;
            if (lm0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            if (!TextUtils.isEmpty(webSourceIndexData.getReqCharset())) {
                try {
                    encode = URLEncoder.encode(str, webSourceIndexData.getReqCharset());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(webSourceIndexData.getSearchPostData())) {
                    call = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexData.getWebSourceBaseUrl(), webSourceIndexData.getHttpUserAgent()).post(webSourceIndexData.getWebSearchUrl(), RequestBody.create(MediaType.parse("text"), webSourceIndexData.getSearchPostData().replace("{search}", encode).toString()));
                } else {
                    call = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexData.getWebSourceBaseUrl(), webSourceIndexData.getHttpUserAgent()).get(webSourceIndexData.getWebSearchUrl().replace("{search}", encode));
                }
                if (call != null) {
                    return;
                }
                call.enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceIndexData, str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                return;
            }
            encode = str;
            if (TextUtils.isEmpty(webSourceIndexData.getSearchPostData())) {
            }
            if (call != null) {
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            Thread.currentThread().getId();
            while (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                lm0 lm0Var = lm0.this;
                if (!lm0Var.Wwwwwwwwwwwwwwwwwwwww) {
                    break;
                }
                try {
                    if (!lm0Var.Wwwwwwwwwwwwwwwwwwww) {
                        lm0Var.Wwwwwwwwwwwwwwwwwww.take();
                        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                            lm0.this.Wwwwwwwwwwwwwwwwwww.add(1);
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lm0.this.Wwwwwwwwwwwwwwwwww.take(), this.Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Thread.currentThread().getId();
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebSourceTitaData> {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public void onFinish(List<WebSourceTitaData> list) {
            lm0 lm0Var = lm0.this;
            lm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lm0Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, list, lm0Var.Wwwwwwwwwwwwww != 0);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebSourceTitaData> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // org.litepal.crud.callback.FindMultiCallback
            public void onFinish(List<WebSourceTitaData> list) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                lm0 lm0Var = lm0.this;
                lm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lm0Var, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, list, lm0Var.Wwwwwwwwwwwwww != 0);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            lm0 lm0Var = lm0.this;
            lm0Var.Wwwwwwwwwwwww = i;
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, lm0Var.Wwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebSourceIndexData> {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public void onFinish(List<WebSourceIndexData> list) {
            lm0 lm0Var = lm0.this;
            lm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lm0Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, list, null, lm0Var.Wwwwwwwwwwwwww != 0);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CountCallback {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.lm0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebSourceIndexData> {
            public C3480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // org.litepal.crud.callback.FindMultiCallback
            public void onFinish(List<WebSourceIndexData> list) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                lm0 lm0Var = lm0.this;
                lm0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lm0Var, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, list, null, lm0Var.Wwwwwwwwwwwwww != 0);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // org.litepal.crud.callback.CountCallback
        public void onFinish(int i) {
            lm0 lm0Var = lm0.this;
            lm0Var.Wwwwwwwwwwwww = i;
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, lm0Var.Wwwwwwwwwwwwww, new C3480Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lm0 lm0Var, String str, List list, List list2, boolean z) {
        int size;
        int i = 0;
        lm0Var.Wwwwwwwwwwwwwwwwwwwww = false;
        lm0Var.Wwwwwwwwwwwwwww = false;
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> list3 = lm0Var.Wwwwwwwwwwwwwwwwwwwwww;
        if (list3 == null) {
            lm0Var.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        } else if (!list3.isEmpty()) {
            for (int i2 = 0; i2 < lm0Var.Wwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
                lm0Var.Wwwwwwwwwwwwwwwwwwwwww.get(i2).Wwwwwwwwwwwwwwwwwwwwwww = true;
            }
            lm0Var.Wwwwwwwwwwwwwwwwwwwwww.clear();
        }
        if (lm0Var.Wwwwwwwwwwww && list != null && !list.isEmpty()) {
            lm0Var.Wwwwwwwwwwwwwwwwwwwww = true;
            while (i < lm0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
                lm0Var.Wwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
                i++;
            }
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww : lm0Var.Wwwwwwwwwwwwwwwwwwwwww) {
                try {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                WebSourceIndexData webSourceIndexData = (WebSourceIndexData) it.next();
                lm0Var.Wwwwwwwwwwwwwwwwwww.add(1);
            }
            lm0Var.Wwwwwwwwwwwwwwwwww.addAll(list);
            lm0Var.Wwwwwwwwwwwwwwwww.clear();
            size = list.size();
        } else if (lm0Var.Wwwwwwwwwwww || list2 == null || list2.isEmpty()) {
            ((in0) lm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, 0, z);
            int i3 = lm0Var.Wwwwwwwwwwwwww;
            if (i3 == 0) {
                ((in0) lm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, true);
            } else if (i3 >= lm0Var.Wwwwwwwwwwwww) {
                ((in0) lm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, true);
                lm0Var.Wwwwwwwwwwwwww = 0;
            } else {
                ((in0) lm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
            }
            lm0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        } else {
            lm0Var.Wwwwwwwwwwwwwwwwwwwww = true;
            while (i < lm0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
                lm0Var.Wwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
                i++;
            }
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : lm0Var.Wwwwwwwwwwwwwwwwwwwwww) {
                try {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.start();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(((WebSourceTitaData) it2.next()).trans2WebSourceIndexData());
                lm0Var.Wwwwwwwwwwwwwwwwwww.add(1);
            }
            lm0Var.Wwwwwwwwwwwwwwwwww.addAll(arrayList);
            lm0Var.Wwwwwwwwwwwwwwwww.clear();
            size = arrayList.size();
        }
        lm0Var.Wwwwwwwwwwwwwwww = size;
        ((in0) lm0Var.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, size, z);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwww.clear();
    }

    @Override // me.tvspark.hn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwww = false;
    }

    @Override // me.tvspark.bl0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ApplicationC1880C.Wwwwwwwwwwww.clear();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwww = 0;
    }

    @Override // me.tvspark.hn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // me.tvspark.hn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z, boolean z2) {
        this.Wwwwwwwwwwww = z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tita_so_default_count", 50);
        if (z2) {
            this.Wwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwww = 0;
        }
        if (z) {
            if (this.Wwwwwwwwwwwww == 0) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, str));
            } else {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
            }
        } else if (this.Wwwwwwwwwwwww == 0) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, str));
        } else {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        }
    }
}
