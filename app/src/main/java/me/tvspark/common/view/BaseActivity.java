package me.tvspark.common.view;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import me.tvspark.bl0;
import me.tvspark.cl0;
import me.tvspark.data.event.BaseEvent;
import me.tvspark.iu0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.sk0;
import me.tvspark.x11;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public abstract class BaseActivity<T extends bl0> extends AppCompatActivity implements sk0, cl0 {
    public T Wwwwwwwwwwwwwwwwwwwww;
    public FragmentManager Wwwwwwwwwwwwwwwwwwwwwww;
    public BaseActivity Wwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwww = "";
    public iu0 Wwwwwwwwwwwwwwwwwwww = null;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                BaseActivity.this.deleteDatabase("webview.db");
                BaseActivity.this.deleteDatabase("webviewCache.db");
                BaseActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BaseActivity.this.getExternalFilesDir("VideoCache"));
                BaseActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new File(Environment.getExternalStorageDirectory().toString() + "/VideoCache/" + BaseActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww.getPackageName()));
                if (TextUtils.isEmpty(BaseActivity.this.Wwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                BaseActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new File(BaseActivity.this.Wwwwwwwwwwwwwwwwwwwwww));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public abstract boolean Wwwwwwwwwwwwwww();

    public abstract T Wwwwwwwwwwwwwwww();

    public abstract int Wwwwwwwwwwwwwwwww();

    public void Wwwwwwwwwwwwwwwwww() {
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().start();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        iu0 iu0Var = this.Wwwwwwwwwwwwwwwwwwww;
        if (iu0Var == null || iu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || isFinishing()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Dialog dialog;
        if (z) {
            if (this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            return;
        }
        iu0 iu0Var = this.Wwwwwwwwwwwwwwwwwwww;
        if (iu0Var == null || !iu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || (dialog = this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        dialog.dismiss();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(3);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
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

    @Override // me.tvspark.cl0
    /* renamed from: getContext */
    public BaseActivity mo4928getContext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        if (Wwwwwwwwwwwwwwwww() != 0) {
            setContentView(Wwwwwwwwwwwwwwwww());
        }
        T Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        ButterKnife.bind(this);
        this.Wwwwwwwwwwwwwwwwwwwwwww = getSupportFragmentManager();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("/data/data/");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwww.getPackageName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("/cache/webviewCache");
        this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        this.Wwwwwwwwwwwwwwwwwwww = new iu0(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Dialog dialog;
        super.onDestroy();
        T t = this.Wwwwwwwwwwwwwwwwwwwww;
        if (t != null) {
            t.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        iu0 iu0Var = this.Wwwwwwwwwwwwwwwwwwww;
        if (iu0Var == null || !iu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || (dialog = this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        dialog.dismiss();
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent baseEvent) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!Wwwwwwwwwwwwwww()) {
            MobclickAgent.onPageEnd(getClass().getSimpleName());
        }
        MobclickAgent.onPause(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!Wwwwwwwwwwwwwww()) {
            MobclickAgent.onPageStart(getClass().getSimpleName());
        }
        MobclickAgent.onResume(this);
    }
}
