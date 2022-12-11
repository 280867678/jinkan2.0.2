package me.tvspark.view.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class EditHomeMarkActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public EditHomeMarkActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ EditHomeMarkActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditHomeMarkActivity_ViewBinding editHomeMarkActivity_ViewBinding, EditHomeMarkActivity editHomeMarkActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = editHomeMarkActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ EditHomeMarkActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditHomeMarkActivity_ViewBinding editHomeMarkActivity_ViewBinding, EditHomeMarkActivity editHomeMarkActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = editHomeMarkActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ EditHomeMarkActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditHomeMarkActivity_ViewBinding editHomeMarkActivity_ViewBinding, EditHomeMarkActivity editHomeMarkActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = editHomeMarkActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public EditHomeMarkActivity_ViewBinding(EditHomeMarkActivity editHomeMarkActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = editHomeMarkActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_ok, "field 'tvOk' and method 'onViewClicked'");
        editHomeMarkActivity.tvOk = (TextView) Utils.castView(findRequiredView, R.id.tv_ok, "field 'tvOk'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, editHomeMarkActivity));
        editHomeMarkActivity.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        editHomeMarkActivity.etTitle = (EditText) Utils.findRequiredViewAsType(view, R.id.et_title, "field 'etTitle'", EditText.class);
        editHomeMarkActivity.etUrl = (EditText) Utils.findRequiredViewAsType(view, R.id.et_url, "field 'etUrl'", EditText.class);
        FrameLayout frameLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        Utils.findRequiredView(view, R.id.view_line_title, "field 'viewLineTitle'");
        Utils.findRequiredView(view, R.id.view_line_url, "field 'viewLineUrl'");
        editHomeMarkActivity.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        editHomeMarkActivity.tvIcon = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_icon, "field 'tvIcon'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, editHomeMarkActivity));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.rlyt_icon, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView3;
        findRequiredView3.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, editHomeMarkActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditHomeMarkActivity editHomeMarkActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (editHomeMarkActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            editHomeMarkActivity.tvName = null;
            editHomeMarkActivity.etTitle = null;
            editHomeMarkActivity.etUrl = null;
            editHomeMarkActivity.ivIcon = null;
            editHomeMarkActivity.tvIcon = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
