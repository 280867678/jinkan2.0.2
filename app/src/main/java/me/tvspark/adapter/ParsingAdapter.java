package me.tvspark.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import white.whale.R;

/* loaded from: classes4.dex */
public class ParsingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "嗅探失败，【点我】去源网页观看";
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = "嗅探失败，【点我】尝试重新嗅探";
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwww = "嗅探失败，【点我】搜索其他网站播放";
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwww = "嗅探到疑似视频地址 ";
    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class EditHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_m3u8)
        public TextView tvM3U8;
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public EditHolder(ParsingAdapter parsingAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes4.dex */
    public class EditHolder_ViewBinding implements Unbinder {
        public EditHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public EditHolder_ViewBinding(EditHolder editHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = editHolder;
            editHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            editHolder.tvM3U8 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_m3u8, "field 'tvM3U8'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            EditHolder editHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (editHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                editHolder.tvTitle = null;
                editHolder.tvM3U8 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class ParsingHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public ParsingHolder(ParsingAdapter parsingAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            if (parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.tvTitle.setBackgroundColor(ContextCompat.getColor(parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.transparent));
                this.tvTitle.setTextColor(ContextCompat.getColor(parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, R.color.f5061white));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class ParsingHolder_ViewBinding implements Unbinder {
        public ParsingHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public ParsingHolder_ViewBinding(ParsingHolder parsingHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parsingHolder;
            parsingHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ParsingHolder parsingHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (parsingHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                parsingHolder.tvTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public class RetryEndHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        public RetryEndHolder(ParsingAdapter parsingAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes4.dex */
    public class RetryEndHolder_ViewBinding implements Unbinder {
        public RetryEndHolder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @UiThread
        public RetryEndHolder_ViewBinding(RetryEndHolder retryEndHolder, View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = retryEndHolder;
            retryEndHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RetryEndHolder retryEndHolder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (retryEndHolder != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                retryEndHolder.tvTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ParsingAdapter parsingAdapter = ParsingAdapter.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public final /* synthetic */ RecyclerView.ViewHolder Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RecyclerView.ViewHolder viewHolder) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ParsingAdapter parsingAdapter = ParsingAdapter.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((EditHolder) this.Wwwwwwwwwwwwwwwwwwwwwwww).tvM3U8.getText().toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {

        /* renamed from: me.tvspark.adapter.ParsingAdapter$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC3467Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC3467Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("如下几种链接中类似于红色标注部分为正确播放地址，请参考删除非红色标注部分\n\n1、http://xxx=");
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("http://xxx");
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(-65536), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            spannableStringBuilder.append((CharSequence) "\n2、");
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("http://xxx.m3u8?xxx");
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(-65536), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder.append((CharSequence) "\n3、");
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("http://xxx.mp4?xxx");
            spannableStringBuilder4.setSpan(new ForegroundColorSpan(-65536), 0, spannableStringBuilder4.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            spannableStringBuilder.append((CharSequence) "\n4、");
            SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("http://xxx.m3u8");
            spannableStringBuilder5.setSpan(new ForegroundColorSpan(-65536), 0, spannableStringBuilder5.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder5);
            spannableStringBuilder.append((CharSequence) "\n5、");
            SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("http://xxx.mp4");
            spannableStringBuilder6.setSpan(new ForegroundColorSpan(-65536), 0, spannableStringBuilder6.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
            new AlertDialog.Builder(ParsingAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).setTitle("规则").setMessage(spannableStringBuilder).setPositiveButton("了解", new DialogInterface$OnClickListenerC3467Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)).create().show();
        }
    }

    public ParsingAdapter(Context context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        }
        if (!TextUtils.isEmpty(str)) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                List<String> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (list.get(list.size() - 1).equals("......")) {
                    List<String> list2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    list2.set(list2.size() - 1, str);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("......");
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(str);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("......");
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3 && i2 != 4) {
                ((ParsingHolder) viewHolder).tvTitle.setText(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i));
                return;
            }
            String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            RetryEndHolder retryEndHolder = (RetryEndHolder) viewHolder;
            retryEndHolder.tvTitle.setText(str);
            retryEndHolder.tvTitle.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
            return;
        }
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        if (i == 0) {
            EditHolder editHolder = (EditHolder) viewHolder;
            editHolder.tvTitle.setVisibility(0);
            editHolder.tvM3U8.setVisibility(8);
            editHolder.tvTitle.setText(str2);
            editHolder.tvTitle.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            return;
        }
        EditHolder editHolder2 = (EditHolder) viewHolder;
        editHolder2.tvTitle.setVisibility(8);
        editHolder2.tvM3U8.setVisibility(0);
        editHolder2.tvM3U8.setText(str2);
        editHolder2.tvM3U8.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewHolder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new EditHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_parsing_edit, viewGroup, false));
        }
        if (i != 2 && i != 3 && i != 4) {
            return new ParsingHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_parsing_list, viewGroup, false));
        }
        return new RetryEndHolder(this, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, (int) R.layout.item_parsing_retry_end, viewGroup, false));
    }
}
