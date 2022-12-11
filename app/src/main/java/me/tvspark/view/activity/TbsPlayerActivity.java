package me.tvspark.view.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stub.StubApp;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.VideoActivity;
import java.io.File;
import me.tvspark.ApplicationC1880C;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.dt0;
import me.tvspark.eo0;
import me.tvspark.et0;
import me.tvspark.outline;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import me.tvspark.widget.dialog.DialogEpisodeX5;

/* loaded from: classes4.dex */
public class TbsPlayerActivity extends VideoActivity {
    public View.OnLayoutChangeListener Wwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwwwwwww = "";
    public boolean Wwwwwwwwwwwwwwwwwwwww = true;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                TbsPlayerActivity.this.deleteDatabase("webview.db");
                TbsPlayerActivity.this.deleteDatabase("webviewCache.db");
                TbsPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsPlayerActivity.this.getExternalFilesDir("VideoCache"));
                TbsPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new File(Environment.getExternalStorageDirectory().toString() + "/VideoCache/" + TbsPlayerActivity.this.getPackageName()));
                String str = "/data/data/" + TbsPlayerActivity.this.getPackageName() + "/cache/webviewCache";
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                TbsPlayerActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new File(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ApplicationC1880C.Wwwwwwwwwwww.getEpisodeListPlay().isEmpty()) {
                TbsPlayerActivity tbsPlayerActivity = TbsPlayerActivity.this;
                DialogEpisodeX5 dialogEpisodeX5 = new DialogEpisodeX5(tbsPlayerActivity, tbsPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwww, ApplicationC1880C.Wwwwwwwwwwww.getEpisodeListPlay(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                if (dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
                    return;
                }
                dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
                dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
                dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww.show();
                Window window = dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwww);
                attributes.height = dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwww.getWindowManager().getDefaultDisplay().getHeight();
                window.setAttributes(attributes);
                window.setContentView(dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwwww);
                dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
                dialogEpisodeX5.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
                return;
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsPlayerActivity.this, "暂无列表");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsPlayerActivity tbsPlayerActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    static {
        StubApp.interface11(11291);
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsPlayerActivity tbsPlayerActivity, EpisodeParcel episodeParcel, int i) {
        if (tbsPlayerActivity != null) {
            String str = tbsPlayerActivity.Wwwwwwwwwwwwwwwwwwwwww;
            DialogParse dialogParse = new DialogParse(tbsPlayerActivity, str, str, episodeParcel.getLink(), tbsPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwww, episodeParcel.getCount(), 13, false);
            dialogParse.Wwwwwwwwwwwwwwwwwwwww = new et0(tbsPlayerActivity);
            dialogParse.Wwwwwwwwwwwwwwwwwwwwww = new dt0(tbsPlayerActivity, i, episodeParcel);
            dialogParse.Kkkkkkkkkkkkkkkkk = tbsPlayerActivity.Wwwwwwwwwwwwwwwwwwwww;
            dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        throw null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    if (TextUtils.isEmpty(childAt.getClass().getName()) || !childAt.getClass().getName().startsWith(DexLoader.TENCENT_PACKAGE_PREFIX)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) childAt);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) childAt);
                    }
                }
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) childAt);
                } else if (childAt instanceof TextView) {
                    String charSequence = ((TextView) childAt).getText().toString();
                    if (!TextUtils.isEmpty(charSequence) && (charSequence.equals("倍速") || charSequence.equals("0.5X") || charSequence.equals("1.0X") || charSequence.equals("1.25X") || charSequence.equals("1.5X") || charSequence.equals("2.0X"))) {
                        childAt.setVisibility(0);
                    } else if (!TextUtils.isEmpty(charSequence) && charSequence.equals("下载")) {
                        ((LinearLayout) childAt.getParent().getParent()).setVisibility(0);
                        ((LinearLayout) childAt.getParent()).setVisibility(0);
                    } else if (!TextUtils.isEmpty(charSequence) && charSequence.equals("小窗")) {
                        ((LinearLayout) childAt.getParent().getParent()).setVisibility(0);
                        ((LinearLayout) childAt.getParent()).setVisibility(0);
                        ((TextView) childAt).setText("选集");
                        ((LinearLayout) childAt.getParent()).setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    }
                }
            }
            try {
                if (this.Wwwwwwwwwwwwwwwwwwww == null) {
                    return;
                }
                getWindow().getDecorView().removeOnLayoutChangeListener(this.Wwwwwwwwwwwwwwwwwwww);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isFile()) {
                        file.delete();
                    } else if (file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2);
                        }
                    }
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        file.getAbsolutePath();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            getWindow().getDecorView().addOnLayoutChangeListener(this.Wwwwwwwwwwwwwwwwwwww);
        }
        int i = configuration.orientation;
        if (i == 2) {
            this.Wwwwwwwwwwwwwwwwwwwww = true;
        } else if (i != 1) {
        } else {
            this.Wwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    @Override // com.tencent.smtt.sdk.VideoActivity, android.app.Activity
    public native void onCreate(Bundle bundle);
}
