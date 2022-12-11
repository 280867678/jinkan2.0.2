package me.tvspark.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Arrays;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.event.RefreshHomeMarkEvent;
import me.tvspark.data.sql.HomeMarkData;
import me.tvspark.eo0;
import me.tvspark.nn0;
import me.tvspark.o11;
import me.tvspark.r40;
import me.tvspark.vn0;
import me.tvspark.widget.dialog.BaseAlertDialog;
import me.tvspark.yn0;
import org.litepal.crud.callback.UpdateOrDeleteCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class EditHomeMarkActivity extends BaseActivity {
    public HomeMarkData Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.et_title)
    public EditText etTitle;
    @BindView(R.id.et_url)
    public EditText etUrl;
    @BindView(R.id.iv_icon)
    public ImageView ivIcon;
    @BindView(R.id.tv_icon)
    public TextView tvIcon;
    @BindView(R.id.tv_name)
    public TextView tvName;
    @BindView(R.id.tv_ok)
    public TextView tvOk;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            EditHomeMarkActivity.this = r1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GlideException glideException) {
            EditHomeMarkActivity.this.ivIcon.setVisibility(8);
            EditHomeMarkActivity.this.tvIcon.setVisibility(0);
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || EditHomeMarkActivity.this.isFinishing()) {
                return;
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "图标获取超时");
            EditHomeMarkActivity.this.Wwwwwwwwwwwwwwwwwww.setIconUrl("");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements BaseAlertDialog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            EditHomeMarkActivity.this = r1;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements UpdateOrDeleteCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            EditHomeMarkActivity.this = r1;
        }

        @Override // org.litepal.crud.callback.UpdateOrDeleteCallback
        public void onFinish(int i) {
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RefreshHomeMarkEvent());
            EditHomeMarkActivity editHomeMarkActivity = EditHomeMarkActivity.this;
            editHomeMarkActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editHomeMarkActivity.etTitle);
            EditHomeMarkActivity editHomeMarkActivity2 = EditHomeMarkActivity.this;
            editHomeMarkActivity2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editHomeMarkActivity2.etUrl);
            EditHomeMarkActivity.this.finish();
        }
    }

    public static /* synthetic */ BaseActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditHomeMarkActivity editHomeMarkActivity) {
        return editHomeMarkActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
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
        return R.layout.activity_edit_home_mark;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, ContextCompat.getColor(baseActivity, R.color.f5061white));
        this.Wwwwwwwwwwwwwwwwwww = (HomeMarkData) getIntent().getParcelableExtra("key_parcel");
        this.tvName.setText("编辑书签");
        this.etTitle.setText(this.Wwwwwwwwwwwwwwwwwww.getTitle());
        this.etUrl.setText(this.Wwwwwwwwwwwwwwwwwww.getUrl());
        this.etTitle.requestFocus();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, false);
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(5);
            ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HomeMarkData homeMarkData, boolean z) {
        TextView textView;
        String str;
        ((GradientDrawable) this.tvIcon.getBackground()).setColor(Color.parseColor(!TextUtils.isEmpty(homeMarkData.getIconColor()) ? homeMarkData.getIconColor() : nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        if (!TextUtils.isEmpty(homeMarkData.getIconTxt())) {
            textView = this.tvIcon;
            str = homeMarkData.getIconTxt();
        } else {
            textView = this.tvIcon;
            str = "网站\n书签";
        }
        textView.setText(Html.fromHtml(str));
        if (TextUtils.isEmpty(homeMarkData.getIconUrl())) {
            this.ivIcon.setVisibility(8);
            this.tvIcon.setVisibility(0);
            return;
        }
        this.ivIcon.setVisibility(0);
        this.tvIcon.setVisibility(8);
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, homeMarkData.getIconUrl(), r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwwwww, 5.0d), this.ivIcon, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z));
    }

    @OnClick({R.id.iv_back, R.id.tv_ok, R.id.rlyt_icon})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_back) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.etTitle);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.etUrl);
            finish();
        } else if (id != R.id.rlyt_icon) {
            if (id != R.id.tv_ok) {
                return;
            }
            String obj = this.etTitle.getText().toString();
            String obj2 = this.etUrl.getText().toString();
            if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "请完整填写");
                return;
            }
            this.Wwwwwwwwwwwwwwwwwww.setUrl(obj2);
            this.Wwwwwwwwwwwwwwwwwww.setTitle(obj);
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww.getUrl(), this.Wwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.etTitle);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.etUrl);
            BaseAlertDialog baseAlertDialog = new BaseAlertDialog(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            baseAlertDialog.tvMsg.setVisibility(8);
            baseAlertDialog.listView.setVisibility(0);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseAlertDialog.Wwwwwwwwwwwwwwwwwwwwwwww);
            linearLayoutManager.setOrientation(1);
            baseAlertDialog.listView.setLayoutManager(linearLayoutManager);
            BaseAlertDialog.DialogListAdapter dialogListAdapter = new BaseAlertDialog.DialogListAdapter(Arrays.asList("设置背景颜色", "设置背景文字", "尝试网站图标"));
            dialogListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            baseAlertDialog.listView.setAdapter(dialogListAdapter);
            baseAlertDialog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}
