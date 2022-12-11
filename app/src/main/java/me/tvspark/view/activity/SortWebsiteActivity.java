package me.tvspark.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.OnClick;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.CodeForSiteData;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.eo0;
import me.tvspark.ln0;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.ru0;
import me.tvspark.widget.easytagdragview.EasyTipDragView;
import me.tvspark.widget.easytagdragview.widget.TipItemView;
import me.tvspark.xt0;
import me.tvspark.yn0;
import org.litepal.LitePal;
import org.litepal.crud.callback.FindMultiCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class SortWebsiteActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public boolean Wwwwwwwwwwwwwwww;
    public UnifiedInterstitialAD Wwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.drag_view)
    public EasyTipDragView dragView;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.tv_cancel)
    public TextView tvCancel;
    @BindView(R.id.tv_reset)
    public TextView tvReset;
    public String Wwwwwwwwwwwwwwwww = SortWebsiteActivity.class.getSimpleName() + "_interstitial";
    public int Wwwwwwwwwwwwwww = 103;
    public int Wwwwwwwwwwwwww = 0;
    public boolean Wwwwwwwwwwwww = false;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("site_websource_deleted_notify", false);
            LitePal.deleteAll(CodeForSiteData.class, new String[0]);
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "重启后生效...");
            mn0.Wwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity sortWebsiteActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < SortWebsiteActivity.this.dragView.getDragData().size(); i2++) {
                arrayList.add(SortWebsiteActivity.this.dragView.getDragData().get(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList);
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "重启后生效...");
            mn0.Wwwwwwwwwwwwwwwwwwwwwwww(SortWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            SortWebsiteActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebSourceTitaData> {
        public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements EasyTipDragView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements EasyTipDragView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements EasyTipDragView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }
        }

        /* renamed from: me.tvspark.view.activity.SortWebsiteActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3502Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TipItemView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public C3502Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List list) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public void onFinish(List<WebSourceTitaData> list) {
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (!TextUtils.isEmpty(list.get(i).getRuleIndex1List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex2List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex3List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex4List())) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new CodeForSiteData(list.get(i).getBaseUrl(), list.get(i).getName()));
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<CodeForSiteData> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            for (int i2 = 0; i2 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
                ru0 ru0Var = new ru0();
                ru0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                SortWebsiteActivity.this.Wwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() + i2;
                ru0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SortWebsiteActivity.this.Wwwwwwwwwwwwww;
                arrayList.add(ru0Var);
            }
            for (int i3 = 0; i3 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i3++) {
                ru0 ru0Var2 = new ru0();
                ru0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (CodeForSiteData) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
                ru0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                arrayList2.add(ru0Var2);
            }
            SortWebsiteActivity.this.dragView.setDragData(arrayList);
            SortWebsiteActivity.this.dragView.setAddData(arrayList2);
            EasyTipDragView easyTipDragView = SortWebsiteActivity.this.dragView;
            C3502Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3502Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C3502Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            easyTipDragView.Wwwwwwwwwwwwwwwwwwww.Wwwwwww = c3502Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            easyTipDragView.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            SortWebsiteActivity.this.dragView.setDataResultCallback(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
            SortWebsiteActivity.this.dragView.setOnCompleteCallback(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            SortWebsiteActivity.this.dragView.setVisibility(0);
        }
    }

    static {
        StubApp.interface11(11281);
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
        return R.layout.activity_sort_website;
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
        if (this.Wwwwwwwwwwwwwwwwww.getAdPatternType() == 2) {
            this.Wwwwwwwwwwwwwwwwww.setMediaListener(this);
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwww;
        unifiedInterstitialAD.sendWinNotification(unifiedInterstitialAD.getECPM());
        this.Wwwwwwwwwwwwwwwwww.getECPM();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        BaseActivity baseActivity;
        String str;
        BaseActivity baseActivity2;
        String str2;
        super.onActivityResult(i, i2, intent);
        if (i == this.Wwwwwwwwwwwwwww && i2 == -1 && intent != null) {
            int i3 = 0;
            boolean booleanExtra = intent.getBooleanExtra("key_boolean", false);
            String stringExtra = intent.getStringExtra("key_string");
            String stringExtra2 = intent.getStringExtra("key_string_one");
            ArrayList arrayList = new ArrayList(this.dragView.getDragData());
            if (!booleanExtra) {
                if (arrayList.size() == 1) {
                    baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    str2 = "请至少保留一个酷站";
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, str2);
                }
                while (true) {
                    if (i3 >= arrayList.size()) {
                        break;
                    } else if (((ru0) arrayList.get(i3)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl().equals(stringExtra)) {
                        arrayList.remove(i3);
                        break;
                    } else {
                        i3++;
                    }
                }
                this.dragView.setDragData(arrayList);
                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "已从自选酷站中删除";
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
                this.Wwwwwwwwwwwww = true;
            } else if (arrayList.size() == EasyTipDragView.Wwwwwwwwwwwwww) {
                baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("最多添加"), EasyTipDragView.Wwwwwwwwwwwwww, "项");
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, str2);
            } else {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break;
                    } else if (stringExtra.equals(((ru0) arrayList.get(i4)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl())) {
                        i3 = 1;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 != 0) {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "已包含此酷站");
                    return;
                }
                ru0 ru0Var = new ru0();
                ru0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CodeForSiteData(stringExtra, stringExtra2);
                int i5 = this.Wwwwwwwwwwwwww + 1;
                this.Wwwwwwwwwwwwww = i5;
                ru0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                arrayList.add(ru0Var);
                this.dragView.setDragData(arrayList);
                baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "已添加到自选酷站中";
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
                this.Wwwwwwwwwwwww = true;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.Wwwwwwwwwwwww) {
            super.onBackPressed();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setMessage("重启APP后配置更改生效 ？").setPositiveButton("重启", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setNegativeButton("取消", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwww;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(adError.getErrorCode(), adError.getErrorMsg(), this.Wwwwwwwwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (isFinishing() || (unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        unifiedInterstitialAD.showAsPopupWindow();
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

    @OnClick({R.id.iv_back, R.id.tv_cancel, R.id.tv_reset})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_back) {
            onBackPressed();
        } else if (id != R.id.tv_cancel) {
            if (id != R.id.tv_reset) {
                return;
            }
            AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setMessage("重启APP后重置生效 ？").setPositiveButton("重启", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setNegativeButton("取消", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)).create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        } else {
            if (this.Wwwwwwwwwwwwwwww) {
                this.tvCancel.setText("编辑");
                this.tvReset.setVisibility(8);
                this.dragView.setGoEditMode(false);
            } else {
                this.tvCancel.setText("取消");
                this.tvReset.setVisibility(0);
                this.dragView.setGoEditMode(true);
            }
            this.Wwwwwwwwwwwwwwww = !this.Wwwwwwwwwwwwwwww;
        }
    }
}
