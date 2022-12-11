package me.tvspark.widget.listener;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.data.bean.UseWebViewReqParcel;
import me.tvspark.vu0;
import me.tvspark.wu0;
import okhttp3.ResponseBody;
import org.apache.http.util.EncodingUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes4.dex */
public abstract class BasicOnScrollListener<I> extends RecyclerView.OnScrollListener {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 5;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callback<ResponseBody> {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            BasicOnScrollListener basicOnScrollListener = BasicOnScrollListener.this;
            basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setRefreshing(false);
            BasicOnScrollListener.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            BasicOnScrollListener basicOnScrollListener = BasicOnScrollListener.this;
            if (j == basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                int i2 = basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i != i2) {
                    return;
                }
                try {
                    basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
                    basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response.body(), this.Wwwwwwwwwwwwwwwwwwwwwww);
                } catch (Throwable th) {
                    onFailure(call, th);
                }
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setRefreshing(false);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 5;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().size();
        if (size > 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().clear();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().notifyItemRangeRemoved(0, size);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = currentTimeMillis;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(currentTimeMillis);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    public abstract SwipeRefreshLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract RecyclerView.LayoutManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract List<I> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract UseWebViewReqParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    public abstract RecyclerView.Adapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 + 1;
        Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
        UseWebViewReqParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.enqueue(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i2));
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setRefreshing(false);
        } else if (j != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || i2 != (i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            Activity context = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext();
            String url = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getUrl();
            String userAgent = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getUserAgent();
            String searchPostData = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSearchPostData();
            WebView webView = new WebView(context);
            WebSettings settings = webView.getSettings();
            if (TextUtils.isEmpty(userAgent)) {
                userAgent = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww;
            }
            settings.setUserAgentString(userAgent);
            webView.addJavascriptInterface(new vu0(this, webView, context, i2), "HTMLOUT");
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setDefaultTextEncodingName("utf-8");
            webView.getSettings().setCacheMode(-1);
            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            webView.getSettings().setDisplayZoomControls(false);
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setAllowContentAccess(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setSavePassword(true);
            webView.getSettings().setSaveFormData(true);
            webView.getSettings().setTextZoom(100);
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setSupportMultipleWindows(true);
            webView.getSettings().setAllowFileAccessFromFileURLs(true);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webView.getSettings().setDatabaseEnabled(true);
            webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setLoadsImagesAutomatically(false);
            webView.getSettings().setBlockNetworkImage(true);
            webView.getSettings().setMixedContentMode(0);
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView.getSettings().setAppCachePath(context.getCacheDir().getAbsolutePath());
            webView.getSettings().setGeolocationDatabasePath(context.getDir("database", 0).getPath());
            webView.getSettings().setGeolocationEnabled(false);
            webView.setWebViewClient(new wu0(this, context, webView, i2));
            if (TextUtils.isEmpty(searchPostData)) {
                webView.loadUrl(url);
            } else {
                webView.postUrl(url, EncodingUtils.getBytes(searchPostData, "base64"));
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, int i) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ResponseBody responseBody, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        boolean z;
        int i3;
        LinearLayoutManager linearLayoutManager;
        super.onScrolled(recyclerView, i, i2);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            RecyclerView.LayoutManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                int childCount = recyclerView.getChildCount();
                int itemCount = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getItemCount();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof StaggeredGridLayoutManager) {
                    i3 = ((StaggeredGridLayoutManager) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).findFirstVisibleItemPositions(null)[0];
                } else {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof GridLayoutManager) {
                        linearLayoutManager = (GridLayoutManager) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof LinearLayoutManager) {
                        linearLayoutManager = (LinearLayoutManager) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        i3 = 0;
                    }
                    i3 = linearLayoutManager.findFirstVisibleItemPosition();
                }
                if (itemCount - childCount <= i3 + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    z = true;
                    if (z && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                        long currentTimeMillis = System.currentTimeMillis();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = currentTimeMillis;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(currentTimeMillis);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        return;
                    }
                }
            }
            z = false;
            if (z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                long currentTimeMillis2 = System.currentTimeMillis();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = currentTimeMillis2;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(currentTimeMillis2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                return;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }
}
