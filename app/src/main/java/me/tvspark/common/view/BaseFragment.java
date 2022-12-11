package me.tvspark.common.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import me.tvspark.bl0;
import me.tvspark.cl0;
import me.tvspark.data.event.BaseEvent;
import me.tvspark.nn0;
import me.tvspark.o11;
import me.tvspark.sk0;
import me.tvspark.x11;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;

/* loaded from: classes4.dex */
public abstract class BaseFragment<T extends bl0> extends Fragment implements sk0, cl0 {
    public boolean Wwwwwwwwwwwwwwwwwww;
    public T Wwwwwwwwwwwwwwwwwwww;
    public BaseActivity Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww = false;
    public String Wwwwwwwwwwwwwwwwwwwww = "";
    public boolean Wwwwwwwwwwwwwwwwww = false;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                LitePal.deleteDatabase("webview.db");
                LitePal.deleteDatabase("webviewCache.db");
                BaseFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseFragment.this.Wwwwwwwwwwwwwwwwwwwwwww.getExternalFilesDir("VideoCache"));
                BaseFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new File(Environment.getExternalStorageDirectory().toString() + "/VideoCache/" + BaseFragment.this.Wwwwwwwwwwwwwwwwwwwwwww.getPackageName()));
                if (TextUtils.isEmpty(BaseFragment.this.Wwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                BaseFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new File(BaseFragment.this.Wwwwwwwwwwwwwwwwwwwww));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Wwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwww = true;
            AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwww).setMessage("非常感谢支持，截止本次退出App前将不再显示广告 ^_^").setPositiveButton("确定", (DialogInterface.OnClickListener) null).create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    public boolean Wwwwwwwwwwwwwwww() {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwwww, "请关闭网络代理后重试", 1).show();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public abstract T Wwwwwwwwwwwwwwwww();

    public int Wwwwwwwwwwwwwwwwww() {
        return 0;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
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

    @Override // androidx.fragment.app.Fragment, me.tvspark.cl0
    /* renamed from: getContext */
    public Context mo4928getContext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.fragment.app.Fragment, me.tvspark.cl0
    /* renamed from: getContext  reason: collision with other method in class */
    public BaseActivity mo4928getContext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.Wwwwwwwwwwwwwwwwwwwwwww = (BaseActivity) activity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        T Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(Wwwwwwwwwwwwwwwwww(), viewGroup, false);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bundle);
        this.Wwwwwwwwwwwwwwwwwwwww = "/data/data/" + this.Wwwwwwwwwwwwwwwwwwwwwww.getPackageName() + "/cache/webviewCache";
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        T t = this.Wwwwwwwwwwwwwwwwwwww;
        if (t != null) {
            t.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent baseEvent) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getClass().getSimpleName());
    }
}
