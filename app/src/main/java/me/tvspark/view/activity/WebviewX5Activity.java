package me.tvspark.view.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.tencent.smtt.sdk.WebView;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.r40;
import me.tvspark.view.fragment.WebviewX5Fragment;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebviewX5Activity extends BaseActivity {
    public WebviewX5Fragment Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_content)
    public FrameLayout flytContent;

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public bl0 Wwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_webview_x5;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, baseActivity.getResources().getColor(R.color.f5061white));
        String stringExtra = getIntent().getStringExtra("key_string");
        boolean booleanExtra = getIntent().getBooleanExtra("key_boolean", true);
        WebviewX5Fragment webviewX5Fragment = new WebviewX5Fragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_string", stringExtra);
        bundle2.putBoolean("key_boolean", booleanExtra);
        webviewX5Fragment.setArguments(bundle2);
        this.Wwwwwwwwwwwwwwwwwww = webviewX5Fragment;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.flyt_content, this.Wwwwwwwwwwwwwwwwwww);
        beginTransaction.commit();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebviewX5Fragment webviewX5Fragment = this.Wwwwwwwwwwwwwwwwwww;
        if (webviewX5Fragment != null) {
            WebView webView = webviewX5Fragment.webView;
            boolean z = false;
            if (webView != null && webView.canGoBack()) {
                webviewX5Fragment.Wwwwwwwwwwwwwww = 0;
                webviewX5Fragment.webView.goBack();
                z = true;
            }
            if (z) {
                return;
            }
        }
        super.onBackPressed();
    }
}
