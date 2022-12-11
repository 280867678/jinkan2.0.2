package me.tvspark;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.content.FileProvider;
import com.arialyy.aria.core.download.DownloadEntity;
import com.lzf.easyfloat.interfaces.OnPermissionResult;
import com.lzf.easyfloat.permission.PermissionUtils;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsVideo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.HomeMarkData;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.utils.cast.p050ui.CastPlayActivity;
import me.tvspark.utils.service.ADownService;
import me.tvspark.utils.service.FloatPlayService;
import me.tvspark.view.activity.AboutActivity;
import me.tvspark.view.activity.AllDownChildActivity;
import me.tvspark.view.activity.AllDownParentActivity;
import me.tvspark.view.activity.CollectActivity;
import me.tvspark.view.activity.ConfActivity;
import me.tvspark.view.activity.DelWebsiteActivity;
import me.tvspark.view.activity.DetailActivity;
import me.tvspark.view.activity.DowningActivity;
import me.tvspark.view.activity.EditHomeMarkActivity;
import me.tvspark.view.activity.EditWebActivity;
import me.tvspark.view.activity.GActivity;
import me.tvspark.view.activity.HistoryActivity;
import me.tvspark.view.activity.HomeActivity;
import me.tvspark.view.activity.KSYPlayerActivity;
import me.tvspark.view.activity.LocalPlayerActivity;
import me.tvspark.view.activity.RankListActivity;
import me.tvspark.view.activity.RecIndexMoreActivity;
import me.tvspark.view.activity.SearchActivity;
import me.tvspark.view.activity.SettingActivity;
import me.tvspark.view.activity.SortWebsiteActivity;
import me.tvspark.view.activity.WebSnifferActivity;
import me.tvspark.view.activity.WebsiteActivity;
import me.tvspark.view.activity.WebviewAgentActivity;
import me.tvspark.view.activity.WebviewX5Activity;
import white.whale.R;

/* loaded from: classes4.dex */
public class mn0 implements sk0 {

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements OnPermissionResult {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, FloatPlayService.class);
                intent.putExtra("key_string", Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                intent.putExtra("key_string_one", Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                intent.putExtra("key_string_two", Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                intent.putExtra("key_string_three", Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                intent.putExtra("key_boolean", Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startService(intent);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww, Activity activity, String str, String str2, String str3, String str4, boolean z, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = activity;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = str4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // com.lzf.easyfloat.interfaces.OnPermissionResult
        public void permissionResult(boolean z) {
            if (z) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                new Handler().postDelayed(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, String str, String str2, String str3, String str4, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
            this.Wwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwwww = str4;
            this.Wwwwwwwwwwwwwwwwwww = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(this.Wwwwwwwwwwwwwwwwwwwwwwww, FloatPlayService.class);
            intent.putExtra("key_string", this.Wwwwwwwwwwwwwwwwwwwwwww);
            intent.putExtra("key_string_one", this.Wwwwwwwwwwwwwwwwwwwwww);
            intent.putExtra("key_string_two", this.Wwwwwwwwwwwwwwwwwwwww);
            intent.putExtra("key_string_three", this.Wwwwwwwwwwwwwwwwwwww);
            intent.putExtra("key_boolean", this.Wwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.startService(intent);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ BaseActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseActivity baseActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = baseActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ BaseActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseActivity baseActivity, String str, String str2, long j, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = baseActivity;
            this.Wwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((BaseActivity) this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Activity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = activity;
            this.Wwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwwww = str4;
            this.Wwwwwwwwwwwwwwwwwww = str5;
            this.Wwwwwwwwwwwwwwwwww = str6;
            this.Wwwwwwwwwwwwwwwww = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, SortWebsiteActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        Intent intent = new Intent(context, GActivity.class);
        intent.setFlags(268468224);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, HomeActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, HistoryActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "错误异常", 0).show();
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, DowningActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Toast makeText;
        Uri fromFile;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, "com.UCMobile")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (str.startsWith("http")) {
                    fromFile = Uri.parse(str);
                } else if (Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                    fromFile = FileProvider.getUriForFile(context, "white.whale.fileProvider", new File(str));
                } else {
                    fromFile = Uri.fromFile(new File(str));
                }
                intent.setDataAndType(fromFile, "video/*");
                intent.setClassName("com.UCMobile", "com.UCMobile.video");
                context.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                makeText = Toast.makeText(context, "调用失败", 0);
            }
        } else {
            makeText = Toast.makeText(context, (int) R.string.uc_uninstall, 1);
        }
        makeText.show();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, DelWebsiteActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("分享 ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(context.getString(R.string.app_name));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" APP");
        context.startActivity(Intent.createChooser(intent, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString()));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, ConfActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_integer", 0);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, CollectActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_integer", 2);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("GO_PLAY_IN_CAST_ACTIVITY");
        Intent intent = new Intent();
        intent.setClass(context, CastPlayActivity.class);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Toast makeText;
        Uri fromFile;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, TbsConfig.APP_QB)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (str.startsWith("http")) {
                    fromFile = Uri.parse(str);
                } else if (Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                    fromFile = FileProvider.getUriForFile(context, "white.whale.fileProvider", new File(str));
                } else {
                    fromFile = Uri.fromFile(new File(str));
                }
                intent.setDataAndType(fromFile, "video/*");
                intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity");
                context.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                makeText = Toast.makeText(context, "调用失败", 0);
            }
        } else {
            makeText = Toast.makeText(context, (int) R.string.qq_uninstall, 1);
        }
        makeText.show();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, AllDownParentActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Toast makeText;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, TbsConfig.APP_QB)) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                context.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                makeText = Toast.makeText(context, "调用失败", 0);
            }
        } else {
            makeText = Toast.makeText(context, (int) R.string.qq_uninstall, 1);
        }
        makeText.show();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, boolean z) {
        Intent intent = new Intent(context, WebviewX5Activity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_boolean", z);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Uri fromFile;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (str.startsWith("http")) {
                fromFile = Uri.parse(str);
            } else if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
                fromFile = FileProvider.getUriForFile(context, "white.whale.fileProvider", new File(str));
            } else {
                fromFile = Uri.fromFile(new File(str));
            }
            intent.setDataAndType(fromFile, "video/*");
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            Toast.makeText(context, "调用第三方播放器失败，播放链接已复制到剪切板", 0).show();
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Intent Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str, str2, str3, str4, str5, str6);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setFlags(268435456);
        context.startActivity(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, List<VideoParcel> list) {
        Intent intent = new Intent(context, RankListActivity.class);
        intent.putExtra("key_string", str);
        intent.putParcelableArrayListExtra("key_parcel_list", (ArrayList) list);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, boolean z) {
        Intent intent = new Intent(context, WebviewAgentActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_boolean", z);
        intent.putExtra("key_boolean_two", false);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseActivity baseActivity, String str, String str2, long j, boolean z) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_play_local_type", 4);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
            if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) baseActivity)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str, str2, "", "", "");
            } else {
                new AlertDialog.Builder(baseActivity).setTitle("提示").setMessage(baseActivity.getString(R.string.x5_failure2)).setPositiveButton("立即安装X5内核", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity)).setNegativeButton("KSY播放器播放", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str, str2, j, z)).create().show();
            }
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 10) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, baseActivity, str, str, str2, "", z, (Wwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 5) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 6) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str, str2, j, z);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
        }
    }

    public static Intent Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (ApplicationC1880C.Wwwwwwwwwwwww) {
            context.stopService(new Intent(context, FloatPlayService.class));
        }
        Intent intent = new Intent(context, KSYPlayerActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_string_one", str4);
        intent.putExtra("key_string_two", str5);
        intent.putExtra("key_string_three", str2);
        intent.putExtra("key_string_4", str3);
        intent.putExtra("key_string_5", str6);
        intent.putExtra("key_boolean_one", false);
        return intent;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Activity activity, String str, String str2, String str3, String str4, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (!PermissionUtils.checkPermission(activity)) {
            PermissionUtils.requestPermission(activity, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwww, activity, str, str2, str3, str4, z, i));
            return;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        new Handler().postDelayed(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, str, str2, str3, str4, z), i);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, WebSourceTitaData webSourceTitaData, boolean z, int i) {
        Intent intent = new Intent(activity, WebsiteActivity.class);
        intent.putExtra("key_parcel", (Parcelable) webSourceTitaData);
        intent.putExtra("key_boolean", z);
        intent.putExtra("key_boolean_one", false);
        activity.startActivityForResult(intent, i);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        context.startActivity(new Intent(context, GActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        Intent intent = new Intent(context, WebviewAgentActivity.class);
        intent.putExtra("key_string", "https://m.douban.com/search/?query=" + str + "&type=movie");
        intent.putExtra("key_boolean", true);
        intent.putExtra("key_boolean_one", false);
        intent.putExtra("key_boolean_two", true);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, long j, int i) {
        Intent intent = new Intent(context, ADownService.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_string_one", str2);
        intent.putExtra("key_integer", i);
        intent.putExtra("key_long", j);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, RecIndexMoreActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_string_one", str2);
        intent.putExtra("key_string_two", str3);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_string_one", str2);
        intent.putExtra("key_string_two", str3);
        intent.putExtra("key_string_three", str4);
        intent.putExtra("key_string_4", "CNTV");
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        bundle.putInt("screenMode", 102);
        bundle.putString(NotificationCompatJellybean.KEY_TITLE, str2);
        bundle.putBoolean("standardFullScreen", true);
        bundle.putBoolean("supportLiteWnd", false);
        bundle.putInt("DefaultVideoScreen", 1);
        bundle.putString("epTitle", str3);
        bundle.putString("epUrl", str4);
        bundle.putString("detailUrl", str5);
        TbsVideo.openVideo(context, str, bundle);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Intent Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str, str2, str3, str4, str5, str6);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.putExtra("key_boolean_one", z);
        context.startActivity(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, String str3, String str4, boolean z) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("key_string", str2);
        intent.putExtra("key_string_one", str3);
        intent.putExtra("key_string_two", str4);
        intent.putExtra("key_string_4", str);
        intent.putExtra("key_boolean", z);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, List<DownloadEntity> list) {
        fo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("key_string", new WeakReference<>(str));
        fo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put("key_parcel_list", new WeakReference<>(list));
        context.startActivity(new Intent(context, AllDownChildActivity.class));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, WebSourceIndexData webSourceIndexData) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_integer", 1);
        intent.putExtra("key_parcel", (Parcelable) webSourceIndexData);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, boolean z) {
        Intent intent = new Intent(context, WebSnifferActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_boolean", z);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, HomeMarkData homeMarkData) {
        Intent intent = new Intent(context, EditHomeMarkActivity.class);
        intent.putExtra("key_parcel", homeMarkData);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, WebSourceTitaData webSourceTitaData) {
        Intent intent = new Intent(context, WebsiteActivity.class);
        intent.putExtra("key_parcel", (Parcelable) webSourceTitaData);
        intent.putExtra("key_boolean_one", true);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, WebSourceTitaData webSourceTitaData, int i) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, EditWebActivity.class);
        intent.putExtra("key_parcel", (Parcelable) webSourceTitaData);
        intent.putExtra("key_integer", i);
        context.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseActivity baseActivity, String str, String str2, long j, boolean z) {
        if (ApplicationC1880C.Wwwwwwwwwwwww) {
            baseActivity.stopService(new Intent(baseActivity, FloatPlayService.class));
        }
        Intent intent = new Intent(baseActivity, LocalPlayerActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_string_one", str2);
        intent.putExtra("key_long", j);
        intent.putExtra("key_boolean", z);
        baseActivity.startActivity(intent);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Activity activity, String str, String str2, String str3, String str4, String str5, String str6, boolean z2) {
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, str, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, " - ", str3), str2, str6, str5);
        } else if (!z) {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, (int) R.string.x5_failure);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, str, str6, str5, str2, str3, str4, z2);
        } else if (activity instanceof BaseActivity) {
            new AlertDialog.Builder(activity).setTitle("提示").setMessage(activity.getString(R.string.x5_failure2)).setPositiveButton("立即安装X5内核", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity)).setNegativeButton("KSY播放器播放", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, str, str6, str5, str2, str3, str4, z2)).create().show();
        } else {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, (int) R.string.x5_failure);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Activity activity, boolean z) {
        String str = z ? "https://support.qq.com/product/421907/new-post" : "https://support.qq.com/product/421907";
        Intent intent = new Intent(activity, WebviewAgentActivity.class);
        intent.putExtra("key_string", str);
        intent.putExtra("key_boolean", true);
        intent.putExtra("key_boolean_two", true);
        activity.startActivity(intent);
    }
}
