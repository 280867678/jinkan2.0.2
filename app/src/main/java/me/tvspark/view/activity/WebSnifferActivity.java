package me.tvspark.view.activity;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompatJellybean;
import butterknife.BindView;
import butterknife.OnClick;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.event.RefreshHomeMarkEvent;
import me.tvspark.data.sql.WebHistoryData;
import me.tvspark.eo0;
import me.tvspark.gt0;
import me.tvspark.hr0;
import me.tvspark.ht0;
import me.tvspark.it0;
import me.tvspark.kr0;
import me.tvspark.lr0;
import me.tvspark.mn0;
import me.tvspark.mr0;
import me.tvspark.nn0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.un0;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import me.tvspark.widget.dialog.DialogWebviewSet;
import me.tvspark.x11;
import me.tvspark.yn0;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;
import org.litepal.crud.callback.SaveCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebSnifferActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public UnifiedInterstitialAD Wwwwwwwww;
    public boolean Wwwwwwwwww;
    public boolean Wwwwwwwwwww;
    public mr0 Wwwwwwwwwwwwwww;
    public SortedMap<String, lr0> Wwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwww;
    public AgentWeb Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_content)
    public FrameLayout flytContent;
    @BindView(R.id.iv_mask)
    public ImageView ivMask;
    @BindView(R.id.iv_web_back)
    public ImageView ivWebBack;
    @BindView(R.id.iv_web_collect)
    public ImageView ivWebCollect;
    @BindView(R.id.iv_web_forward)
    public ImageView ivWebForward;
    @BindView(R.id.iv_web_result)
    public ImageView ivWebResult;
    @BindView(R.id.rlyt_adb)
    public RelativeLayout rlytADB;
    @BindView(R.id.rlyt_sniff_finish)
    public RelativeLayout rlytSniffFinish;
    @BindView(R.id.rlyt_web_back)
    public RelativeLayout rlytWebBack;
    @BindView(R.id.rlyt_web_collect)
    public RelativeLayout rlytWebCollect;
    @BindView(R.id.rlyt_web_down)
    public RelativeLayout rlytWebDown;
    @BindView(R.id.rlyt_web_forward)
    public RelativeLayout rlytWebForward;
    @BindView(R.id.tv_adb)
    public TextView tvADB;
    @BindView(R.id.tv_play_type)
    public TextView tvPlayType;
    @BindView(R.id.tv_sniff_url)
    public TextView tvSniffUrl;
    @BindView(R.id.tv_web_url)
    public TextView tvWebUrl;
    public String Wwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwww = "N/A";
    public int Wwwwwwwwwwww = 0;
    public boolean Wwwwwwww = false;
    public WebChromeClient Wwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public WebViewClient Wwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String obj = this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "不允许为空");
                return;
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            WebSnifferActivity webSnifferActivity = WebSnifferActivity.this;
            webSnifferActivity.Wwwwwwwwwwwwwwwwww = obj;
            webSnifferActivity.tvWebUrl.setText(obj);
            WebSnifferActivity.this.Wwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            DialogParse dialogParse;
            String str;
            String str2;
            String str3;
            String str4;
            int i2;
            if (i == 0) {
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_CAST");
                DialogParse dialogParse2 = new DialogParse(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                WebSnifferActivity webSnifferActivity = WebSnifferActivity.this;
                String str5 = webSnifferActivity.Wwwwwwwwwwwwwwwwww;
                String str6 = webSnifferActivity.Wwwwwwwwwwwwww;
                dialogParse = dialogParse2;
                str = webSnifferActivity.Wwwwwwwwwwwww;
                str2 = str5;
                str3 = str6;
                str4 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                i2 = 14;
            } else if (i != 1) {
                return;
            } else {
                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_DLNA");
                DialogParse dialogParse3 = new DialogParse(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                WebSnifferActivity webSnifferActivity2 = WebSnifferActivity.this;
                String str7 = webSnifferActivity2.Wwwwwwwwwwwwwwwwww;
                String str8 = webSnifferActivity2.Wwwwwwwwwwwwww;
                dialogParse = dialogParse3;
                str = webSnifferActivity2.Wwwwwwwwwwwww;
                str2 = str7;
                str3 = str8;
                str4 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                i2 = 9;
            }
            dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str3, str, str2, str2, str4, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwww implements Animation.AnimationListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WebSnifferActivity.this.ivMask.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            int i2;
            BaseActivity baseActivity;
            Toast makeText;
            int i3;
            switch (i) {
                case 0:
                    i2 = -1;
                    i3 = Integer.valueOf(i2);
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 1:
                    i2 = 14;
                    i3 = Integer.valueOf(i2);
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 2:
                    i2 = 9;
                    i3 = Integer.valueOf(i2);
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 3:
                    if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, TbsConfig.APP_QB)) {
                        i2 = 5;
                        i3 = Integer.valueOf(i2);
                        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                        WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                        return;
                    }
                    baseActivity = WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    makeText = Toast.makeText(baseActivity, "请先安装手机QQ浏览器", 1);
                    makeText.show();
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 4:
                    if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, TbsConfig.APP_QB)) {
                        i2 = 12;
                        i3 = Integer.valueOf(i2);
                        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                        WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                        return;
                    }
                    baseActivity = WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    makeText = Toast.makeText(baseActivity, "请先安装手机QQ浏览器", 1);
                    makeText.show();
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 5:
                    if (!nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "com.UCMobile")) {
                        makeText = Toast.makeText(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请先安装手机UC浏览器", 1);
                        makeText.show();
                        WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                        return;
                    }
                    i2 = 6;
                    i3 = Integer.valueOf(i2);
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 6:
                    i2 = 3;
                    i3 = Integer.valueOf(i2);
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 7:
                    i2 = 0;
                    i3 = Integer.valueOf(i2);
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 8:
                    i3 = 4;
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 9:
                    i2 = 2;
                    i3 = Integer.valueOf(i2);
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                case 10:
                    i2 = 10;
                    i3 = Integer.valueOf(i2);
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", i3);
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
                default:
                    WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends WebChromeClient {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this, webView.getTitle(), webView.getUrl());
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            WebSnifferActivity.this.Wwwwwwwwwwwww = str;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Animation.AnimationListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WebSnifferActivity.this.ivMask.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.SaveCallback
        public void onFinish(boolean z) {
            if (z) {
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RefreshHomeMarkEvent());
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, z ? "收藏成功" : "已存在");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements UpdateOrDeleteCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity webSnifferActivity) {
        }

        @Override // org.litepal.crud.callback.UpdateOrDeleteCallback
        public void onFinish(int i) {
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RefreshHomeMarkEvent());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnShowListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity webSnifferActivity) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ((ClipboardManager) WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(WebSnifferActivity.this.tvWebUrl.getText().toString());
            BaseActivity baseActivity = WebSnifferActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已复制：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(WebSnifferActivity.this.tvWebUrl.getText().toString());
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity webSnifferActivity, String str, String str2) {
        if (webSnifferActivity != null) {
            if (!TextUtils.isEmpty(str)) {
                webSnifferActivity.Wwwwwwwwwwwww = str;
            }
            webSnifferActivity.Wwwwwwwwwwwwwwwww = str2;
            webSnifferActivity.Wwwwwwwwwwwwwwwwww = str2;
            webSnifferActivity.tvWebUrl.setText(str2);
            webSnifferActivity.Wwwwwwwwwww();
            if (webSnifferActivity.Wwwwwwwwwwww != 0) {
                webSnifferActivity.rlytADB.setVisibility(0);
                TextView textView = webSnifferActivity.tvADB;
                textView.setText(webSnifferActivity.Wwwwwwwwwwww + "");
            } else {
                webSnifferActivity.rlytADB.setVisibility(8);
                webSnifferActivity.Wwwwwwwwwwww = 0;
            }
            if (!webSnifferActivity.Wwwwwwwwwww) {
                return;
            }
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSnifferActivity.Wwwwwwwwwwwwwwwwww, new ht0(webSnifferActivity));
            if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no_history", false)) {
                return;
            }
            LitePal.where("siteUrl = ?", webSnifferActivity.Wwwwwwwwwwwwwwwwww).countAsync(WebHistoryData.class).listen(new it0(webSnifferActivity));
            return;
        }
        throw null;
    }

    public final void Wwwwwwwwwww() {
        ImageView imageView;
        int i;
        ImageView imageView2;
        int i2;
        AgentWeb agentWeb = this.Wwwwwwwwwwwwwwwwwww;
        if (agentWeb == null) {
            return;
        }
        if (agentWeb.getWebCreator().getWebView().canGoBack()) {
            this.rlytWebBack.setClickable(true);
            imageView = this.ivWebBack;
            i = R.drawable.ic_web_back_color;
        } else {
            this.rlytWebBack.setClickable(false);
            imageView = this.ivWebBack;
            i = R.drawable.ic_web_back_gray;
        }
        imageView.setImageResource(i);
        if (this.Wwwwwwwwwwwwwwwwwww.getWebCreator().getWebView().canGoForward()) {
            this.rlytWebForward.setClickable(true);
            imageView2 = this.ivWebForward;
            i2 = R.drawable.ic_web_forward_color;
        } else {
            this.rlytWebForward.setClickable(false);
            imageView2 = this.ivWebForward;
            i2 = R.drawable.ic_web_forward_gray;
        }
        imageView2.setImageResource(i2);
    }

    public final void Wwwwwwwwwwww() {
        Wwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww.getWebCreator().getWebView().stopLoading();
        this.Wwwwwwwwwwwwwwwwwww.getWebCreator().getWebView().loadUrl(this.Wwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwww() {
        this.Wwwwwwwwwwww = 0;
        this.rlytADB.setVisibility(8);
        if (this.rlytSniffFinish.getVisibility() == 0) {
            this.ivMask.setVisibility(8);
            this.rlytSniffFinish.setVisibility(8);
            this.rlytSniffFinish.startAnimation(AnimationUtils.loadAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.push_bottom_out));
        }
        this.ivWebResult.setImageResource(R.drawable.ic_web_result_0);
        this.rlytWebDown.setVisibility(8);
        this.Wwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwww.clear();
        ApplicationC1880C.Wwwwwwwwww.clear();
    }

    public final void Wwwwwwwwwwwwww() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        builder.setTitle("选择播放模式");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4);
        String str = "※ 复制播放链接";
        String str2 = "※ 云播投屏播放";
        String str3 = "※ DLNA投屏播放";
        String str4 = "※ QQ浏览器播放";
        String str5 = "※ QQ浏览器 (带下载)";
        String str6 = "※ UC浏览器播放";
        String str7 = "※ 电脑浏览器播放";
        String str8 = "※ 极速播放器 (X5)";
        String str9 = "※ 常规播放器 (KSY)";
        String str10 = "※ 手机第三方播放器";
        String str11 = "※ 悬浮窗播放 (KSY)";
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
            str = "※ 复制播放链接      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
            str8 = "※ 极速播放器 (X5)      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
            str10 = "※ 手机第三方播放器      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 3) {
            str7 = "※ 电脑浏览器播放      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 5) {
            str4 = "※ QQ浏览器播放      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 6) {
            str6 = "※ UC浏览器播放      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 9) {
            str3 = "※ DLNA投屏播放      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 10) {
            str11 = "※ 悬浮窗播放 (KSY)      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 12) {
            str5 = "※ QQ浏览器 (带下载)      √";
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 14) {
            str9 = "※ 常规播放器 (KSY)      √";
        } else {
            str2 = "※ 云播投屏播放      √";
        }
        builder.setItems(new String[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11}, new Wwwwwwwwwwwwwwwwwwwwwwwwww());
        builder.setCancelable(true);
        builder.create().show();
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
        return R.layout.activity_web_sniffer;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        TextView textView;
        String str;
        if (i == -1) {
            textView = this.tvPlayType;
            str = "复制播放链接";
        } else if (i == 0) {
            textView = this.tvPlayType;
            str = "X5 播放";
        } else if (i == 2) {
            textView = this.tvPlayType;
            str = "三方播放";
        } else if (i == 3) {
            textView = this.tvPlayType;
            str = "电脑浏览器播放";
        } else if (i == 5) {
            textView = this.tvPlayType;
            str = "QQ浏览器播放";
        } else if (i == 6) {
            textView = this.tvPlayType;
            str = "UC浏览器播放";
        } else if (i == 9) {
            textView = this.tvPlayType;
            str = "DLNA投屏播放";
        } else if (i == 10) {
            textView = this.tvPlayType;
            str = "悬浮窗播放";
        } else if (i == 12) {
            textView = this.tvPlayType;
            str = "QQ浏览器(带下载)";
        } else if (i != 14) {
            textView = this.tvPlayType;
            str = "KSY 播放";
        } else {
            textView = this.tvPlayType;
            str = "云播投屏播放";
        }
        textView.setText(str);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, baseActivity.getResources().getColor(R.color.f5061white));
        String stringExtra = getIntent().getStringExtra("key_string");
        this.Wwwwwwwwwww = getIntent().getBooleanExtra("key_boolean", false);
        this.Wwwwwwwwwwwwwwwwww = stringExtra;
        this.rlytWebDown.setVisibility(8);
        SortedMap<String, lr0> synchronizedSortedMap = Collections.synchronizedSortedMap(new TreeMap());
        this.Wwwwwwwwwwwwwwww = synchronizedSortedMap;
        mr0 mr0Var = new mr0(synchronizedSortedMap);
        this.Wwwwwwwwwwwwwww = mr0Var;
        mr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.tvWebUrl.setText(stringExtra);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4));
        if (this.Wwwwwwwwwww) {
            this.rlytWebCollect.setVisibility(0);
        } else {
            this.rlytWebCollect.setVisibility(8);
        }
        AgentWeb m3704go = AgentWeb.with(this).setAgentWebParent(this.flytContent, new LinearLayout.LayoutParams(-1, -1)).useDefaultIndicator().setWebViewClient(this.Wwwwww).setWebChromeClient(this.Wwwwwww).setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK).setSecurityType(AgentWeb.SecurityType.STRICT_CHECK).interceptUnkownUrl().createAgentWeb().ready().m3704go(stringExtra);
        this.Wwwwwwwwwwwwwwwwwww = m3704go;
        WebSettings webSettings = m3704go.getAgentWebSettings().getWebSettings();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDisplayZoomControls(false);
        String str = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("vip_browser_ua");
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
            str = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 1) {
            str = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36";
        }
        webSettings.setUserAgentString(str);
        webSettings.setMixedContentMode(0);
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClicked() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClosed() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADExposure() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADLeftApplication() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADOpened() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADReceive() {
        if (this.Wwwwwwwww.getAdPatternType() == 2) {
            this.Wwwwwwwww.setMediaListener(this);
        }
        this.Wwwwwwwww.getECPMLevel();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            this.Wwwwwwwwwwwwwwwwwww.getWebLifeCycle().onDestroy();
        } catch (Exception unused) {
        }
        AgentWebConfig.clearDiskCache(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        mr0 mr0Var = this.Wwwwwwwwwwwwwww;
        if (mr0Var != null) {
            mr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwww = null;
            ApplicationC1880C.Wwwwwwwwww.clear();
        }
        super.onDestroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwww;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.rlytSniffFinish.getVisibility() == 0) {
            this.ivMask.setVisibility(8);
            this.rlytSniffFinish.setVisibility(8);
            this.rlytSniffFinish.startAnimation(AnimationUtils.loadAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.push_bottom_out));
            return true;
        } else if (!this.Wwwwwwwwwwwwwwwwwww.handleKeyEvent(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        } else {
            Wwwwwwwwwwwww();
            return true;
        }
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        String.format(Locale.getDefault(), "onNoAD, error code: %d, error msg: %s", Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg());
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        try {
            this.Wwwwwwwwwwwwwwwwwww.getWebLifeCycle().onPause();
        } catch (Exception unused) {
        }
        super.onPause();
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (isFinishing() || (unifiedInterstitialAD = this.Wwwwwwwww) == null) {
            return;
        }
        unifiedInterstitialAD.showAsPopupWindow();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        try {
            this.Wwwwwwwwwwwwwwwwwww.getWebLifeCycle().onResume();
        } catch (Exception unused) {
        }
        super.onResume();
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onSnifferVideo(lr0 lr0Var) {
        if (lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwww = lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (this.rlytSniffFinish.getVisibility() == 8) {
                this.rlytSniffFinish.setVisibility(0);
                Animation loadAnimation = AnimationUtils.loadAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.push_bottom_in);
                loadAnimation.setAnimationListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                this.rlytSniffFinish.startAnimation(loadAnimation);
            }
            this.ivWebResult.setImageResource(R.drawable.ic_web_result_1);
            this.tvSniffUrl.setText(this.Wwwwwwwwwwwwww);
            this.rlytWebDown.setVisibility(0);
        } else if (TextUtils.isEmpty(lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
        } else {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = kr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lr0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                return;
            }
            ApplicationC1880C.Wwwwwwwwww.add(new hr0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwwwwwwwwwwwwwwwww, NotificationCompatJellybean.KEY_TITLE));
        }
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onVideoCached() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(AdError adError) {
        adError.getErrorCode();
        adError.getErrorMsg();
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoInit() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoLoading() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageClose() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageOpen() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPause() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoReady(long j) {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
    }

    @OnClick({R.id.rlyt_web_result, R.id.iv_play, R.id.iv_dlna, R.id.rlyt_play_type, R.id.iv_dialog_close, R.id.rlyt_web_collect, R.id.rlyt_web_down, R.id.rlyt_adb, R.id.tv_web_url, R.id.rlyt_web_back, R.id.rlyt_web_forward, R.id.rlyt_web_refresh, R.id.rlyt_web_setting})
    public void onViewClicked(View view) {
        AlertDialog create;
        BaseActivity baseActivity;
        String str;
        DialogParse dialogParse;
        String str2;
        String str3;
        String str4;
        int i;
        int id = view.getId();
        String str5 = "N/A";
        switch (id) {
            case R.id.iv_dialog_close /* 2131362162 */:
                this.ivMask.setVisibility(8);
                this.rlytSniffFinish.setVisibility(8);
                this.rlytSniffFinish.startAnimation(AnimationUtils.loadAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.push_bottom_out));
                return;
            case R.id.iv_dlna /* 2131362163 */:
                if (TextUtils.isEmpty(this.Wwwwwwwwwwwwww)) {
                    return;
                }
                Matcher matcher = Pattern.compile(".*(第\\d+集)").matcher(this.Wwwwwwwwwwwww);
                if (matcher.find()) {
                    try {
                        str5 = matcher.group(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                builder.setItems(new String[]{"云播投屏播放", "DLNA投屏播放"}, new Wwwwwwwwwwwwwwwwwwwwwwww(str5));
                builder.setCancelable(true);
                create = builder.create();
                break;
            default:
                switch (id) {
                    case R.id.iv_play /* 2131362184 */:
                        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwww)) {
                            baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                            str = "嗅探中请等待！此按钮变成红色方可播放，长时间未成功，请手动点击网页中的视频播放";
                            break;
                        } else {
                            Matcher matcher2 = Pattern.compile(".*(第\\d+集)").matcher(this.Wwwwwwwwwwwww);
                            if (matcher2.find()) {
                                try {
                                    str5 = matcher2.group(1);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_player_type", 4);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PARSE");
                                ((ClipboardManager) this.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(this.Wwwwwwwwwwwwww);
                                Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwwwww, "已复制", 0).show();
                                return;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
                                BaseActivity baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                String str6 = this.Wwwwwwwwwwwwww;
                                String str7 = this.Wwwwwwwwwwwww;
                                String str8 = this.Wwwwwwwwwwwwwwwwww;
                                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, baseActivity2, str6, str7, str5, str8, str8, str8, false);
                                return;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
                                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_THIED_PLAYER");
                                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
                                return;
                            } else {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 3) {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 4) {
                                        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PLAY_KSY");
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 5) {
                                        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_QQ_BROWSER");
                                        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
                                        return;
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 6) {
                                        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_UC_BROWSER");
                                        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
                                        return;
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 9) {
                                        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_DLNA");
                                        DialogParse dialogParse2 = new DialogParse(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                        String str9 = this.Wwwwwwwwwwwwwwwwww;
                                        dialogParse = dialogParse2;
                                        str2 = str9;
                                        str3 = this.Wwwwwwwwwwwwww;
                                        str4 = this.Wwwwwwwwwwwww;
                                        i = 9;
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 10) {
                                        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PLAY_FLOAT");
                                        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, (Activity) this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, this.Wwwwwwwwwwwww, str5, false, (mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
                                        return;
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 12) {
                                        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_QQ_BROWSER_BROWSER");
                                        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
                                        return;
                                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 14) {
                                        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_CAST");
                                        DialogParse dialogParse3 = new DialogParse(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                        String str10 = this.Wwwwwwwwwwwwwwwwww;
                                        dialogParse = dialogParse3;
                                        str2 = str10;
                                        str3 = this.Wwwwwwwwwwwwww;
                                        str4 = this.Wwwwwwwwwwwww;
                                        i = 14;
                                    }
                                    BaseActivity baseActivity3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                    String str11 = this.Wwwwwwwwwwwwww;
                                    String str12 = this.Wwwwwwwwwwwwwwwwww;
                                    mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) baseActivity3, str11, str12, str12, this.Wwwwwwwwwwwww, str5, str12, false);
                                    return;
                                }
                                nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PC_PLAYER");
                                DialogParse dialogParse4 = new DialogParse(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                String str13 = this.Wwwwwwwwwwwwwwwwww;
                                dialogParse = dialogParse4;
                                str2 = str13;
                                str3 = this.Wwwwwwwwwwwwww;
                                str4 = this.Wwwwwwwwwwwww;
                                i = 3;
                                dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str3, str4, str2, str2, str5, i);
                                return;
                            }
                        }
                    case R.id.rlyt_adb /* 2131362431 */:
                        if (this.Wwwwwwwwwwww == 0) {
                            return;
                        }
                        BaseActivity baseActivity4 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("已屏蔽");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.Wwwwwwwwwwww);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("条广告");
                        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                        return;
                    case R.id.rlyt_play_type /* 2131362445 */:
                        Wwwwwwwwwwwwww();
                        return;
                    case R.id.rlyt_web_back /* 2131362460 */:
                        Wwwwwwwwwwwww();
                        if (!this.Wwwwwwwwwwwwwwwwwww.getWebCreator().getWebView().canGoBack()) {
                            return;
                        }
                        this.Wwwwwwwwwwwwwwwwwww.getWebCreator().getWebView().goBack();
                        return;
                    case R.id.tv_web_url /* 2131362763 */:
                        EditText editText = new EditText(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                        editText.setHint("网址地址");
                        if (!TextUtils.isEmpty(this.tvWebUrl.getText().toString())) {
                            editText.setText(this.tvWebUrl.getText().toString());
                        }
                        create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("编辑网址").setView(editText).setNeutralButton("复制", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("前往", new Wwwwwwwwwwwwwwwwwwwwwww(editText)).create();
                        create.setView(editText, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 0);
                        create.setOnShowListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
                        break;
                    default:
                        switch (id) {
                            case R.id.rlyt_web_collect /* 2131362462 */:
                                if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwww)) {
                                    if (this.Wwwwwwwwww) {
                                        this.Wwwwwwwwww = false;
                                        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
                                        this.ivWebCollect.setImageResource(R.drawable.ic_web_collect_no);
                                        return;
                                    }
                                    this.Wwwwwwwwww = true;
                                    this.ivWebCollect.setImageResource(R.drawable.ic_web_collect_yes);
                                    yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                    return;
                                }
                                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                str = "请先等待页面加载完成";
                                break;
                            case R.id.rlyt_web_down /* 2131362463 */:
                                if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwww)) {
                                    String str14 = this.Wwwwwwwwwwwwww;
                                    Matcher matcher3 = Pattern.compile(".*(第\\d+集)").matcher(this.Wwwwwwwwwwwww);
                                    if (matcher3.find()) {
                                        try {
                                            str5 = matcher3.group(1);
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    View inflate = LayoutInflater.from(this.Wwwwwwwwwwwwwwwwwwwwwwww).inflate(R.layout.view_web_sniffer_down, (ViewGroup) null);
                                    EditText editText2 = (EditText) inflate.findViewById(R.id.et_dir);
                                    EditText editText3 = (EditText) inflate.findViewById(R.id.et_file);
                                    editText2.setText(this.Wwwwwwwwwwwww);
                                    editText3.setText(str5);
                                    new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("填写缓存信息").setView(inflate).setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("下载", new gt0(this, editText2, editText3, str14)).create().show();
                                    return;
                                }
                                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                str = "嗅探中..请等待播放按钮变成红色！";
                                break;
                            case R.id.rlyt_web_forward /* 2131362464 */:
                                Wwwwwwwwwwwww();
                                if (!this.Wwwwwwwwwwwwwwwwwww.getWebCreator().getWebView().canGoForward()) {
                                    return;
                                }
                                this.Wwwwwwwwwwwwwwwwwww.getWebCreator().getWebView().goForward();
                                return;
                            case R.id.rlyt_web_refresh /* 2131362465 */:
                                Wwwwwwwwwwww();
                                return;
                            case R.id.rlyt_web_result /* 2131362466 */:
                                if (TextUtils.isEmpty(this.Wwwwwwwwwwwwww)) {
                                    baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                    str = "暂未嗅探到播放链接";
                                    break;
                                } else if (this.rlytSniffFinish.getVisibility() != 8) {
                                    return;
                                } else {
                                    this.rlytSniffFinish.setVisibility(0);
                                    Animation loadAnimation = AnimationUtils.loadAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, R.anim.push_bottom_in);
                                    loadAnimation.setAnimationListener(new Wwwwwwwwwwwwwwwwwwwwwwwww());
                                    this.rlytSniffFinish.startAnimation(loadAnimation);
                                    return;
                                }
                            case R.id.rlyt_web_setting /* 2131362467 */:
                                DialogWebviewSet dialogWebviewSet = new DialogWebviewSet(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                                dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                if (dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
                                    return;
                                }
                                dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
                                dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
                                dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwww.show();
                                Window window = dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
                                window.setWindowAnimations(R.style.BotomInOutDialogStyle);
                                WindowManager.LayoutParams attributes = window.getAttributes();
                                attributes.gravity = 80;
                                attributes.width = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwww);
                                window.setAttributes(attributes);
                                window.setContentView(dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwwww);
                                dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
                                dialogWebviewSet.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
                                return;
                            default:
                                return;
                        }
                }
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
                return;
        }
        create.show();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends WebViewClient {
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        public final InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ByteArrayInputStream(new byte[0]);

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            ApplicationC1880C.Wwwwwwwwww.add(new hr0(str, WebSnifferActivity.this.Wwwwwwwwwwwwwwwwww, NotificationCompatJellybean.KEY_TITLE));
            super.onLoadResource(webView, str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this, webView.getTitle(), str);
            WebSnifferActivity webSnifferActivity = WebSnifferActivity.this;
            if (webSnifferActivity.Wwwwwwww || ApplicationC1880C.Wwwwwwwww) {
                return;
            }
            UnifiedInterstitialAD unifiedInterstitialAD = webSnifferActivity.Wwwwwwwww;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.close();
                webSnifferActivity.Wwwwwwwww.destroy();
                webSnifferActivity.Wwwwwwwww = null;
            }
            UnifiedInterstitialAD unifiedInterstitialAD2 = new UnifiedInterstitialAD(webSnifferActivity, "3083371676977396", webSnifferActivity);
            webSnifferActivity.Wwwwwwwww = unifiedInterstitialAD2;
            webSnifferActivity.Wwwwwwwww = unifiedInterstitialAD2;
            WebSnifferActivity webSnifferActivity2 = WebSnifferActivity.this;
            if (webSnifferActivity2 != null) {
                webSnifferActivity2.Wwwwwwwww.setVideoOption(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, 1, true));
                WebSnifferActivity.this.Wwwwwwwww.loadAD();
                WebSnifferActivity.this.Wwwwwwww = true;
                return;
            }
            throw null;
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String title = webView.getTitle();
            if (!TextUtils.isEmpty(title)) {
                WebSnifferActivity.this.Wwwwwwwwwwwww = title;
            }
            WebSnifferActivity webSnifferActivity = WebSnifferActivity.this;
            webSnifferActivity.Wwwwwwwwwwwwwwwww = "";
            webSnifferActivity.Wwwwwwwwwwwwwwwwww = str;
            webSnifferActivity.tvWebUrl.setText(str);
            WebSnifferActivity.this.Wwwwwwwwwww();
            WebSnifferActivity webSnifferActivity2 = WebSnifferActivity.this;
            if (webSnifferActivity2.Wwwwwwwwwww) {
                webSnifferActivity2.Wwwwwwwwww = false;
                webSnifferActivity2.ivWebCollect.setImageResource(R.drawable.ic_web_collect_no);
            }
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return !renderProcessGoneDetail.didCrash();
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (ApplicationC1880C.Wwwwwwwwwwwwww != null) {
                if (webResourceRequest.isForMainFrame()) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = webResourceRequest.getUrl().toString();
                }
                if (ApplicationC1880C.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webResourceRequest.getUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("※ blocked:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(webResourceRequest.getUrl());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    WebSnifferActivity.this.Wwwwwwwwwwww++;
                    return new WebResourceResponse("text/plain", "UTF-8", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  unblocked:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(webResourceRequest.getUrl());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this, webResourceRequest.getUrl().toString()) || un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webResourceRequest.getUrl().toString())) {
                return true;
            }
            WebSnifferActivity.this.Wwwwwwwwwwwww();
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return true;
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (WebSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity.this, str) || un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
                return true;
            }
            WebSnifferActivity.this.Wwwwwwwwwwwww();
            webView.loadUrl(str);
            return true;
        }
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSnifferActivity webSnifferActivity, String str) {
        if (webSnifferActivity != null) {
            if (!str.contains("thunder://") && !str.contains("magnet:?") && !str.contains("pan.baidu.com") && !str.contains("ed2k://")) {
                return false;
            }
            ((ClipboardManager) webSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(str);
            BaseActivity baseActivity = webSnifferActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
            Toast.makeText(baseActivity, "已复制：" + str, 0).show();
            return true;
        }
        throw null;
    }
}
