package me.tvspark.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.load.engine.GlideException;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.view.fragment.SearchWebSourceSignalFragment;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebSourceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements sk0 {
    public WebSourceIndexData Wwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public List<VideoParcel> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_gallery)
        public RoundImageView ivGallery;
        @BindView(R.id.tv_actor)
        public TextView tvActor;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolder(SearchWebSourceAdapter searchWebSourceAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.ivGallery.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolderAD extends RecyclerView.ViewHolder {
        @BindView(R.id.card_ad)
        public CardView cardAD;
        @BindView(R.id.imageview)
        public ImageView imageView;

        public ViewHolderAD(SearchWebSourceAdapter searchWebSourceAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolderAD_ViewBinding implements Unbinder {
        public ViewHolderAD Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolderAD_ViewBinding(ViewHolderAD viewHolderAD, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolderAD;
            viewHolderAD.cardAD = (CardView) Utils.findRequiredViewAsType(view, R.id.card_ad, "field 'cardAD'", CardView.class);
            viewHolderAD.imageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.imageview, "field 'imageView'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolderAD viewHolderAD = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolderAD != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolderAD.cardAD = null;
                viewHolderAD.imageView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolderTXT extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_go_web)
        public TextView tvGoWeb;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ViewHolderTXT(SearchWebSourceAdapter searchWebSourceAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolderTXT_ViewBinding implements Unbinder {
        public ViewHolderTXT Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolderTXT_ViewBinding(ViewHolderTXT viewHolderTXT, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolderTXT;
            viewHolderTXT.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolderTXT.tvGoWeb = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_go_web, "field 'tvGoWeb'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolderTXT viewHolderTXT = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolderTXT != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolderTXT.tvTitle = null;
                viewHolderTXT.tvGoWeb = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            viewHolder.ivGallery = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_gallery, "field 'ivGallery'", RoundImageView.class);
            viewHolder.tvActor = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_actor, "field 'tvActor'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                viewHolder.tvTitle = null;
                viewHolder.ivGallery = null;
                viewHolder.tvActor = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ RecyclerView.ViewHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RecyclerView.ViewHolder viewHolder) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SearchWebSourceAdapter.this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                SearchWebSourceSignalFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceSignalFragment.this, ((ViewHolder) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).ivGallery.getWidth(), ((ViewHolder) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).ivGallery.getHeight());
            }
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GlideException glideException) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ VideoParcel Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoParcel videoParcel) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = videoParcel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchWebSourceAdapter searchWebSourceAdapter = SearchWebSourceAdapter.this;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwwww, searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getLink(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle(), this.Wwwwwwwwwwwwwwwwwwwwwwww.getCoverUrl(), SearchWebSourceAdapter.this.Wwwwwwwwwwwwwwwwwwww.isCustomWebSource());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchWebSourceAdapter searchWebSourceAdapter = SearchWebSourceAdapter.this;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwwww, searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwww.getWebSearchUrl().replace("{search}", SearchWebSourceAdapter.this.Wwwwwwwwwwwwwwwwwwwww).replace("{page}", "1"), true);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchWebSourceAdapter searchWebSourceAdapter = SearchWebSourceAdapter.this;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwwww, searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwww.getWebSearchUrl().replace("{search}", SearchWebSourceAdapter.this.Wwwwwwwwwwwwwwwwwwwww).replace("{page}", "1"), true);
        }
    }

    public SearchWebSourceAdapter(List<VideoParcel> list, Context context, WebSourceIndexData webSourceIndexData, String str) {
        this.Wwwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwww = webSourceIndexData;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwww = str;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VideoParcel> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 2;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwww.get(i - 1).isADPos() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 2) {
            ViewHolderTXT viewHolderTXT = (ViewHolderTXT) viewHolder;
            TextView textView = viewHolderTXT.tvTitle;
            textView.setText(this.Wwwwwwwwwwwwwwwwwwwwwwww.getResources().getString(R.string.search_from) + this.Wwwwwwwwwwwwwwwwwwww.getWebSourceBaseUrl());
            viewHolderTXT.tvTitle.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            viewHolderTXT.tvGoWeb.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } else if (getItemViewType(i) != 1) {
            VideoParcel videoParcel = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i - 1);
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.tvTitle.setText(videoParcel.getTitle());
            viewHolder2.tvActor.setText(videoParcel.getActor());
            viewHolder.itemView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoParcel));
            vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, videoParcel.getCoverUrl(), "", ((ViewHolder) viewHolder).ivGallery, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder));
        } else {
            try {
                vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, ((ViewHolderAD) viewHolder).imageView);
                NativeExpressADView nativeExpressADView = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i - 1).getNativeExpressADView();
                if (nativeExpressADView == null) {
                    return;
                }
                if (((ViewHolderAD) viewHolder).cardAD.getChildCount() > 0 && ((ViewHolderAD) viewHolder).cardAD.getChildAt(0) == nativeExpressADView) {
                    return;
                }
                if (((ViewHolderAD) viewHolder).cardAD.getChildCount() > 0) {
                    ((ViewHolderAD) viewHolder).cardAD.removeAllViews();
                }
                if (nativeExpressADView.getParent() != null) {
                    ((ViewGroup) nativeExpressADView.getParent()).removeView(nativeExpressADView);
                }
                ((ViewHolderAD) viewHolder).cardAD.addView(nativeExpressADView);
                nativeExpressADView.render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 2 ? new ViewHolderTXT(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_txt, viewGroup, false)) : i == 1 ? new ViewHolderAD(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_ad_content_video_list_websource, viewGroup, false)) : new ViewHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_video_list_websource, viewGroup, false));
    }
}
