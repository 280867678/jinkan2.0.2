package me.tvspark.view.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.tvspark.mn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class ModernFragment_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ModernFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ ModernFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ModernFragment_ViewBinding modernFragment_ViewBinding, ModernFragment modernFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = modernFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            ModernFragment modernFragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (modernFragment != null) {
                if (view.getId() != R.id.rlyt_search) {
                    return;
                }
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(modernFragment.Wwwwwwwwwwwwwwwwwwwwwww, "");
                return;
            }
            throw null;
        }
    }

    @UiThread
    public ModernFragment_ViewBinding(ModernFragment modernFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = modernFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.rlyt_search, "field 'rlytSearch' and method 'onViewClicked'");
        modernFragment.rlytSearch = (RelativeLayout) Utils.castView(findRequiredView, R.id.rlyt_search, "field 'rlytSearch'", RelativeLayout.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, modernFragment));
        modernFragment.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ModernFragment modernFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (modernFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            modernFragment.rlytSearch = null;
            modernFragment.rvContent = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
