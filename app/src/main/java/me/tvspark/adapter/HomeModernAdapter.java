package me.tvspark.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.load.engine.GlideException;
import com.noober.menu.R$drawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.HomeMarkData;
import me.tvspark.eo0;
import me.tvspark.h50;
import me.tvspark.i50;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.outline;
import me.tvspark.pt0;
import me.tvspark.r40;
import me.tvspark.view.fragment.ModernFragment;
import me.tvspark.vn0;
import me.tvspark.widget.ItemTouchCallBack;
import me.tvspark.yn0;
import org.litepal.crud.callback.SaveCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class HomeModernAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchCallBack.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwww;
    public List<HomeMarkData> Wwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        public ImageView ivIcon;
        @BindView(R.id.rlyt_add)
        public RelativeLayout rlytAdd;
        @BindView(R.id.rlyt_icon)
        public RelativeLayout rlytIcon;
        @BindView(R.id.tv_icon)
        public TextView tvIcon;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(HomeModernAdapter homeModernAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
            viewHolder.tvIcon = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_icon, "field 'tvIcon'", TextView.class);
            viewHolder.rlytIcon = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_icon, "field 'rlytIcon'", RelativeLayout.class);
            viewHolder.rlytAdd = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_add, "field 'rlytAdd'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.ivIcon = null;
                viewHolder.tvIcon = null;
                viewHolder.rlytIcon = null;
                viewHolder.rlytAdd = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HomeModernAdapter homeModernAdapter) {
        }

        @Override // org.litepal.crud.callback.SaveCallback
        public void onFinish(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnLongClickListener {
        public final /* synthetic */ HomeMarkData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HomeMarkData homeMarkData) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = homeMarkData;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = HomeModernAdapter.this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                HomeMarkData homeMarkData = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                ModernFragment modernFragment = ModernFragment.this;
                Point point = modernFragment.Wwwwwwwwwwwwwwww;
                if (point != null) {
                    BaseActivity baseActivity = modernFragment.Wwwwwwwwwwwwwwwwwwwwwww;
                    h50 h50Var = new h50(baseActivity, view);
                    String[] strArr = {"打开网页", "编辑书签", "删除书签", "※拖拽可排序"};
                    int i = h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                    for (int i2 = 0; i2 < 4; i2++) {
                        i50 i50Var = new i50();
                        i50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strArr[i2];
                        h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(i50Var);
                    }
                    LinearLayout linearLayout = new LinearLayout(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    h50Var.Wwwwwwwwwwwwwwwwwwwwwwww = linearLayout;
                    linearLayout.setBackgroundDrawable(ContextCompat.getDrawable(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R$drawable.shape_bg_dialog));
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 8.0f);
                    h50Var.Wwwwwwwwwwwwwwwwwwwwwwww.setPadding(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    boolean z = true;
                    h50Var.Wwwwwwwwwwwwwwwwwwwwwwww.setOrientation(1);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 17.0f);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 12.0f);
                    int i3 = 0;
                    while (i3 < h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                        TextView textView = new TextView(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        textView.setClickable(z);
                        textView.setBackgroundDrawable(ContextCompat.getDrawable(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R$drawable.selector_item));
                        textView.setPadding(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        textView.setWidth(i);
                        textView.setGravity(8388627);
                        textView.setTextSize(15.0f);
                        textView.setTextColor(-1);
                        i50 i50Var2 = h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
                        int i4 = i50Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (i4 != -1) {
                            Drawable drawable = ContextCompat.getDrawable(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4);
                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                            textView.setCompoundDrawablePadding(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 12.0f));
                            textView.setCompoundDrawables(drawable, null, null, null);
                        }
                        textView.setText(i50Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (h50Var.Wwwwwwwwwwwwwwwwwwwwwww != null) {
                            textView.setOnClickListener(new h50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3));
                        }
                        h50Var.Wwwwwwwwwwwwwwwwwwwwwwww.addView(textView);
                        i3++;
                        z = true;
                    }
                    h50Var.Wwwwwwwwwwwwwwwwwwwwwwww.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwww = h50Var.Wwwwwwwwwwwwwwwwwwwwwwww.getMeasuredWidth();
                    h50Var.Wwwwwwwwwwwwwwwwwwwwwwwww = h50Var.Wwwwwwwwwwwwwwwwwwwwwwww.getMeasuredHeight();
                    h50Var.setContentView(h50Var.Wwwwwwwwwwwwwwwwwwwwwwww);
                    h50Var.setWidth(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                    h50Var.setHeight(h50Var.Wwwwwwwwwwwwwwwwwwwwwwwww);
                    h50Var.Wwwwwwwwwwwwwwwwwwwwwww = new pt0(modernFragment, baseActivity, homeMarkData);
                    for (int i5 = 0; i5 < h50Var.Wwwwwwwwwwwwwwwwwwwwwwww.getChildCount(); i5++) {
                        h50Var.Wwwwwwwwwwwwwwwwwwwwwwww.getChildAt(i5).setOnClickListener(new h50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5));
                    }
                    try {
                        h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = point.x;
                        h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww = point.y;
                        h50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    modernFragment.Wwwwwwwwwwwwwww = h50Var;
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ HomeMarkData Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HomeMarkData homeMarkData) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = homeMarkData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = HomeModernAdapter.this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) ModernFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ModernFragment.this), this.Wwwwwwwwwwwwwwwwwwwwwwww.getUrl(), true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ RecyclerView.ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(HomeModernAdapter homeModernAdapter, RecyclerView.ViewHolder viewHolder) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GlideException glideException) {
            ((ViewHolder) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).ivIcon.setVisibility(8);
            ((ViewHolder) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).tvIcon.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = HomeModernAdapter.this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ModernFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ModernFragment.this), "浏览网址后点击地址栏收藏按钮");
            }
        }
    }

    public HomeModernAdapter(Context context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.widget.ItemTouchCallBack.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        List<HomeMarkData> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (list.get(list.size() - 1).getUrl().equals("@")) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.Wwwwwwwwwwwwwwwwwwwwwwww.size(); i3++) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i3).setSerialNumber(i3);
                if (i3 != this.Wwwwwwwwwwwwwwwwwwwwwwww.size() - 1) {
                    arrayList.add(this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i3));
                }
            }
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        }
    }

    @Override // me.tvspark.widget.ItemTouchCallBack.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            ModernFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (ModernFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            h50 h50Var = ModernFragment.this.Wwwwwwwwwwwwwww;
            if (h50Var != null && h50Var.isShowing()) {
                ModernFragment.this.Wwwwwwwwwwwwwww.dismiss();
            }
        }
        int i3 = i;
        if (i < i2) {
            while (i3 < i2) {
                int i4 = i3 + 1;
                Collections.swap(this.Wwwwwwwwwwwwwwwwwwwwwwww, i3, i4);
                i3 = i4;
            }
        } else {
            while (i3 > i2) {
                Collections.swap(this.Wwwwwwwwwwwwwwwwwwwwwwww, i3, i3 - 1);
                i3--;
            }
        }
        notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<HomeMarkData> list = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        String str;
        HomeMarkData homeMarkData = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i);
        if (i + 1 == this.Wwwwwwwwwwwwwwwwwwwwwwww.size()) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.rlytAdd.setVisibility(0);
            viewHolder2.rlytIcon.setVisibility(8);
            viewHolder2.rlytAdd.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            return;
        }
        ViewHolder viewHolder3 = (ViewHolder) viewHolder;
        viewHolder3.rlytAdd.setVisibility(8);
        viewHolder3.rlytIcon.setVisibility(0);
        viewHolder3.tvTitle.setText(homeMarkData.getTitle());
        ((GradientDrawable) viewHolder3.tvIcon.getBackground()).setColor(Color.parseColor(!TextUtils.isEmpty(homeMarkData.getIconColor()) ? homeMarkData.getIconColor() : nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        if (!TextUtils.isEmpty(homeMarkData.getIconTxt())) {
            textView = viewHolder3.tvIcon;
            str = homeMarkData.getIconTxt();
        } else {
            textView = viewHolder3.tvIcon;
            str = "网站\n书签";
        }
        textView.setText(Html.fromHtml(str));
        if (!TextUtils.isEmpty(homeMarkData.getIconUrl())) {
            viewHolder3.ivIcon.setVisibility(0);
            viewHolder3.tvIcon.setVisibility(8);
            vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, homeMarkData.getIconUrl(), viewHolder3.ivIcon, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, viewHolder));
        } else {
            viewHolder3.ivIcon.setVisibility(8);
            viewHolder3.tvIcon.setVisibility(0);
        }
        viewHolder3.rlytIcon.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(homeMarkData));
        viewHolder3.rlytIcon.setOnLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(homeMarkData));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_home_modern, viewGroup, false));
    }
}
