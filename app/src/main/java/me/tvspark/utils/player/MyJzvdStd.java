package me.tvspark.utils.player;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.Wwwww;
import me.tvspark.Wwwwww;
import me.tvspark.Wwwwwww;
import me.tvspark.Wwwwwwwwww;
import me.tvspark.adapter.EpisodeFullPlayAdapter;
import me.tvspark.adapter.ParsingAdapter;
import me.tvspark.bo0;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.eo0;
import me.tvspark.gr0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.rn0;
import me.tvspark.utils.player.MyJzvdStd;
import me.tvspark.vn0;
import me.tvspark.widget.ScaleImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class MyJzvdStd extends Wwwww {
    public TextView IIl;
    public TextView IIll;
    public TextView IIlll;
    public Context IIllll;

    /* renamed from: O0 */
    public TextView f4522O0;
    public TextView O00;
    public TextView O000;
    public TextView O0000;
    public TextView O00000;
    public TextView O000000;
    public TextView O0000000;
    public TextView O00000000;
    public TextView O000000000;
    public TextView O0000000000;
    public ImageView OO0;
    public ImageView OO00;
    public ImageView OO000;
    public ImageView OO0000;
    public TextView OO000000;
    public TextView OO0000000;
    public TextView OO00000000;
    public TextView OO000000000;
    public boolean Ooooooo;
    public boolean Oooooooo;
    public MotionEvent Ooooooooo;
    public MotionEvent Oooooooooo;
    public Wwwwwwwwwwwwwwwwwwwwwwwww QQO;
    public Wwwwwwwwwwwwwwwwwwwwwwwwww QQOO;
    public LinearLayout QQOOO;
    public LinearLayout QQOOOO;
    public LinearLayout QQOOOOO;
    public ImageView QQOOOOOO;
    public ImageView QQOOOOOOO;
    public ImageView QQOOOOOOOO;
    public ImageView QQOOOOOOOOO;
    public Wwwwwwwwwwwwwwwwwwwwwwww Ssss;
    public ScaleImageView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Sssss;
    public ParsingAdapter Ssssss;
    public RecyclerView Sssssss;
    public ScaleImageView Ssssssss;
    public EpisodeFullPlayAdapter Sssssssss;
    public RecyclerView Ssssssssss;
    public boolean Sssssssssss;
    public int OO00000 = 1;
    public List<EpisodeParcel> Sss = new ArrayList();

    /* renamed from: Ss */
    public int f4523Ss = 0;
    public boolean Ooooooooooo = false;
    public rn0 Oooooo = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(1000, 100);
    public rn0 Ooooo = new Wwwwwwwwwwwwwwwwwwwwwwwwwww(7000, 1000);

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, EpisodeParcel episodeParcel, List<EpisodeParcel> list, int i, int i2);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww extends rn0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
            super(j, j2);
        }

        @Override // me.tvspark.rn0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.rn0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            if (Wwwwww.Kkkkkkkkkkkk != null) {
                try {
                    if (MyJzvdStd.this.Sssssssss == null) {
                        return;
                    }
                    long j2 = j / 1000;
                    TextView textView = MyJzvdStd.this.OO000000000;
                    textView.setText(j2 + "s 后播放：" + MyJzvdStd.this.Sssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    if (j2 != 1) {
                        return;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    MyJzvdStd.this.Sssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            MyJzvdStd.this.Ooooo = null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends rn0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
            super(j, j2);
        }

        @Override // me.tvspark.rn0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.rn0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            int i;
            if (j < 200) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                MyJzvdStd myJzvdStd = MyJzvdStd.this;
                if (myJzvdStd.Ooooooo || (i = myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwwww) == 5 || i == 6) {
                    return;
                }
                myJzvdStd.Oooooooo = true;
                myJzvdStd.QQOOO.setVisibility(0);
                try {
                    MyJzvdStd.this.Wwwwwwwwwwwwwwwwww.setSpeed(2.0f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MyJzvdStd.this.QQOOO.performHapticFeedback(0, 2);
                Wwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwww = MyJzvdStd.this.QQO;
                if (wwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    return;
                }
                ((gr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements EpisodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EpisodeParcel episodeParcel, List<EpisodeParcel> list, int i) {
            MyJzvdStd myJzvdStd = MyJzvdStd.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = myJzvdStd.QQOO;
            if (wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                boolean z = true;
                if (myJzvdStd.Wwwwwwwwwwwwwwwwwwwwwww != 1) {
                    z = false;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, episodeParcel, list, i, MyJzvdStd.this.f4523Ss);
                MyJzvdStd.this.QQOOOO.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyJzvdStd.this.Ssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyJzvdStd.this.Ssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyJzvdStd.this.Ssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyJzvdStd.this.Ssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyJzvdStd.this.Ssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public MyJzvdStd(Context context) {
        super(context);
        this.IIllll = context;
    }

    public MyJzvdStd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IIllll = context;
    }

    public /* synthetic */ void Kkkkkkkkkkkkkkkk() {
        this.Wwwwww.setVisibility(4);
        this.Wwwwwww.setVisibility(4);
        this.Wwwwwwwwwwwww.setVisibility(4);
        this.QQOOOOOOOOO.setVisibility(8);
        this.QQOOOOOOO.setVisibility(8);
        PopupWindow popupWindow = this.Illllllllllllllllll;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
            this.f4510Kk.setVisibility(8);
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwww == 2) {
        } else {
            this.f4510Kk.setVisibility(0);
        }
    }

    public void Kkkkkkkkkkkkkkkkk() {
        this.Ooooooo = true;
        rn0 rn0Var = this.Oooooo;
        if (rn0Var != null) {
            rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.QQOOO.setVisibility(8);
        if (this.Oooooooo) {
            try {
                this.Wwwwwwwwwwwwwwwwww.setSpeed(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.Oooooooo = false;
        Wwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwww = this.QQO;
        if (wwwwwwwwwwwwwwwwwwwwwwwww != null) {
            ((gr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
    }

    @Override // me.tvspark.Wwwww
    public void Kkkkkkkkkkkkkkkkkkkkk() {
        super.Kkkkkkkkkkkkkkkkkkkkk();
        TextView textView = this.IIll;
        textView.setText(Wwwww.IIllllll + "%");
    }

    @Override // me.tvspark.Wwwww
    public void Kkkkkkkkkkkkkkkkkkkkkkkkk() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 7 || i == 6) {
            return;
        }
        post(new Runnable() { // from class: me.tvspark.dr0
            @Override // java.lang.Runnable
            public final void run() {
                MyJzvdStd.this.Kkkkkkkkkkkkkkkk();
            }
        });
    }

    @Override // me.tvspark.Wwwww
    public void Kkkkkkkkkkkkkkkkkkkkkkkkkk() {
        super.Kkkkkkkkkkkkkkkkkkkkkkkkkk();
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
            this.f4510Kk.setVisibility(8);
        }
    }

    @Override // me.tvspark.Wwwww
    public void Www() {
        super.Www();
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
            this.f4510Kk.setVisibility(8);
        }
    }

    @Override // me.tvspark.Wwwww
    public void Wwww() {
        super.Wwww();
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
            this.f4510Kk.setVisibility(8);
        }
    }

    @Override // me.tvspark.Wwwww
    public void Wwwww() {
        super.Wwwww();
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
            this.f4510Kk.setVisibility(8);
        }
    }

    @Override // me.tvspark.Wwwww
    public void Wwwwww() {
        super.Wwwwww();
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
            this.f4510Kk.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // me.tvspark.Wwwww
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww;
        super.Wwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
            this.O0000000000.setText("切换EXO内核重试");
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 1) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
                this.O0000000000.setText("切换IJK内核重试");
                this.O000000000.setText("切换EXO内核重试");
            }
            wwwwwwwwwwwwwwwwwwwwwwwwww = this.QQOO;
            if (wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
                this.f4510Kk.setVisibility(8);
            }
            if (this.f4509Il) {
                return;
            }
            this.Wwwwwww.setVisibility(0);
            return;
        } else {
            this.O0000000000.setText("切换IJK内核重试");
        }
        this.O000000000.setText("切换Android内核重试");
        wwwwwwwwwwwwwwwwwwwwwwwwww = this.QQOO;
        if (wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
        }
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
        }
        if (this.f4509Il) {
        }
    }

    @Override // me.tvspark.Wwwww
    public void Wwwwwwww() {
        super.Wwwwwwww();
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
            this.f4510Kk.setVisibility(8);
        }
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwww();
        this.OO0000.setVisibility(8);
        this.OO00.setVisibility(8);
        this.Illlllllllllllllllllllllllll.setVisibility(0);
        this.O00.setVisibility(0);
        this.IIlll.setVisibility(0);
        if (!this.Ill && !this.Sss.isEmpty()) {
            this.OO000000.setVisibility(0);
            this.OO0000000.setVisibility(0);
        }
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QQOOO.getLayoutParams();
            layoutParams.setMargins(0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(50), 0, 0);
            this.QQOOO.setLayoutParams(layoutParams);
        } catch (Exception unused) {
        }
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwww();
        try {
            if (this.Oooooooo) {
                this.Wwwwwwwwwwwwwwwwww.setSpeed(2.0f);
            } else {
                this.Wwwwwwwwwwwwwwwwww.setSpeed(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.QQOOOOOOOOO.setVisibility(8);
        this.QQOOOOOOO.setVisibility(8);
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = this.QQOO;
        if (wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwww() {
        super.Wwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = this.QQOO;
        if (wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (!this.Ill && this.Sssssssss != null) {
            TextView textView = this.OO00000000;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("播放：");
            EpisodeFullPlayAdapter episodeFullPlayAdapter = this.Sssssssss;
            List<EpisodeParcel> list = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((list == null || list.isEmpty() || episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1 >= episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) ? "N/A" : episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1).getCount());
            textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            TextView textView2 = this.f4522O0;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("当前：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.Sssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount());
            textView2.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            TextView textView3 = this.OO000000000;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("6s 后播放：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.Sssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            textView3.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("play_next_auto", true)) {
                rn0 rn0Var = this.Ooooo;
                if (rn0Var == null) {
                    return;
                }
                rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Ooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
        }
        this.Illllllllllllllllllll.setVisibility(8);
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        rn0 rn0Var = this.Ooooo;
        if (rn0Var != null) {
            rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Ssss;
        if (wwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        float f;
        TextView textView;
        this.O00000000.setTextColor(ContextCompat.getColor(this.IIllll, R.color.f5061white));
        this.O0000000.setTextColor(ContextCompat.getColor(this.IIllll, R.color.f5061white));
        this.O000000.setTextColor(ContextCompat.getColor(this.IIllll, R.color.f5061white));
        this.O00000.setTextColor(ContextCompat.getColor(this.IIllll, R.color.f5061white));
        this.O0000.setTextColor(ContextCompat.getColor(this.IIllll, R.color.f5061white));
        this.O000.setTextColor(ContextCompat.getColor(this.IIllll, R.color.f5061white));
        if (i == 0) {
            f = 0.5f;
            textView = this.O00000000;
        } else if (i == 1) {
            f = 0.75f;
            textView = this.O0000000;
        } else if (i == 2) {
            f = 1.0f;
            textView = this.O000000;
        } else if (i == 3) {
            f = 1.25f;
            textView = this.O00000;
        } else if (i == 4) {
            f = 1.5f;
            textView = this.O0000;
        } else if (i != 5) {
            return 0.0f;
        } else {
            f = 2.0f;
            textView = this.O000;
        }
        textView.setTextColor(ContextCompat.getColor(this.IIllll, R.color.colorPrimary));
        return f;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        List<EpisodeParcel> list;
        EpisodeFullPlayAdapter episodeFullPlayAdapter = this.Sssssssss;
        if (episodeFullPlayAdapter != null) {
            if (episodeFullPlayAdapter == null) {
                throw null;
            }
            if (TextUtils.isEmpty(str) || (list = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null || list.isEmpty()) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                    break;
                } else if (str.equals(episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).getCount())) {
                    episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                    episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                    break;
                } else {
                    i++;
                }
            }
            episodeFullPlayAdapter.notifyDataSetChanged();
        }
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
    }

    @Override // me.tvspark.Wwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", false)) {
            this.f4510Kk.setVisibility(8);
        }
    }

    public MyJzvdStd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Ssss = wwwwwwwwwwwwwwwwwwwwwwww;
            this.QQOOOOOO.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.OO0.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.OO000.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.OO0000.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.OO00.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        return this;
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, int i) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, i);
        this.Illllllll.setProgressDrawable(ContextCompat.getDrawable(this.IIllll, R.drawable.myjz_dialog_progress));
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, String str, long j, String str2, long j2) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, str, j, str2, j2);
        this.Illlllllllllll.setProgressDrawable(ContextCompat.getDrawable(this.IIllll, R.drawable.myjz_dialog_progress));
        this.Illllllllllll.setTextColor(ContextCompat.getColor(this.IIllll, R.color.colorPrimary));
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.Illll.setProgressDrawable(ContextCompat.getDrawable(this.IIllll, R.drawable.myjz_dialog_progress));
    }

    @Override // me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j, j2);
        Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = this.QQOO;
        if (wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j, j2);
        }
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        this.Sssssss = (RecyclerView) findViewById(R.id.rv_progress);
        ParsingAdapter parsingAdapter = new ParsingAdapter(context, null);
        this.Ssssss = parsingAdapter;
        parsingAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Sssssss.setItemAnimator(null);
        this.Sssssss.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.Sssssss.setAdapter(this.Ssssss);
        this.Sssssss.setVisibility(8);
        this.QQOOO = (LinearLayout) findViewById(R.id.llyt_long_press_speed);
        this.OO0 = (ImageView) findViewById(R.id.iv_float_full);
        this.OO000 = (ImageView) findViewById(R.id.iv_float_play);
        this.OO0000 = (ImageView) findViewById(R.id.iv_more);
        this.OO00 = (ImageView) findViewById(R.id.iv_dlna_play);
        this.QQOOOOOO = (ImageView) findViewById(R.id.iv_float_close);
        this.Ssssssss = (ScaleImageView) findViewById(R.id.ivScale);
        TextView textView = (TextView) findViewById(R.id.tv_speed);
        this.IIlll = textView;
        textView.setOnClickListener(this);
        this.IIlll.setVisibility(8);
        this.Illlllllllllllllllllllllllll.setVisibility(4);
        this.IIll = (TextView) findViewById(R.id.battery_txt);
        TextView textView2 = (TextView) findViewById(R.id.tv_error_change_player);
        this.IIl = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) findViewById(R.id.tv_error_change_core);
        this.O0000000000 = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) findViewById(R.id.tv_error_change_core2);
        this.O000000000 = textView4;
        textView4.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llyt_speed);
        this.QQOOOOO = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(R.id.tv_050);
        this.O00000000 = textView5;
        textView5.setOnClickListener(this);
        TextView textView6 = (TextView) findViewById(R.id.tv_075);
        this.O0000000 = textView6;
        textView6.setOnClickListener(this);
        TextView textView7 = (TextView) findViewById(R.id.tv_100);
        this.O000000 = textView7;
        textView7.setOnClickListener(this);
        TextView textView8 = (TextView) findViewById(R.id.tv_125);
        this.O00000 = textView8;
        textView8.setOnClickListener(this);
        TextView textView9 = (TextView) findViewById(R.id.tv_150);
        this.O0000 = textView9;
        textView9.setOnClickListener(this);
        TextView textView10 = (TextView) findViewById(R.id.tv_200);
        this.O000 = textView10;
        textView10.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.iv_lock);
        this.QQOOOOOOOOO = imageView;
        imageView.setOnClickListener(this);
        this.QQOOOOOOOOO.setVisibility(8);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_down);
        this.QQOOOOOOO = imageView2;
        imageView2.setOnClickListener(this);
        this.QQOOOOOOO.setVisibility(8);
        TextView textView11 = (TextView) findViewById(R.id.tv_size);
        this.O00 = textView11;
        textView11.setOnClickListener(this);
        this.O00.setVisibility(8);
        this.QQOOOOOOOO = (ImageView) findViewById(R.id.fullscreen);
        TextView textView12 = (TextView) findViewById(R.id.tv_next);
        this.OO0000000 = textView12;
        textView12.setVisibility(8);
        this.OO0000000.setOnClickListener(this);
        this.f4522O0 = (TextView) findViewById(R.id.next_text_current);
        TextView textView13 = (TextView) findViewById(R.id.next_text_auto);
        this.OO000000000 = textView13;
        textView13.setOnClickListener(this);
        TextView textView14 = (TextView) findViewById(R.id.before_text_auto);
        this.OO00000000 = textView14;
        textView14.setOnClickListener(this);
        TextView textView15 = (TextView) findViewById(R.id.tv_episode);
        this.OO000000 = textView15;
        textView15.setVisibility(8);
        this.OO000000.setOnClickListener(this);
        this.Ssssssssss = (RecyclerView) findViewById(R.id.play_episode);
        this.QQOOOO = (LinearLayout) findViewById(R.id.llyt_episode);
        if (!this.Ill) {
            EpisodeFullPlayAdapter episodeFullPlayAdapter = new EpisodeFullPlayAdapter(context, this.Sss);
            episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Sssssssss = episodeFullPlayAdapter;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.Ssssssssss.setLayoutManager(linearLayoutManager);
            this.Ssssssssss.setAdapter(this.Sssssssss);
        }
        if (this.f4509Il) {
            this.QQOOOOOO.setVisibility(0);
            this.OO0.setVisibility(0);
            this.Ssssssss.setVisibility(0);
            ScaleImageView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Sssss;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Ssssssss.setOnScaledListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.QQOOOOOOOO.setVisibility(8);
            this.OO000.setVisibility(8);
            this.OO0000.setVisibility(8);
            this.OO00.setVisibility(8);
            this.O00.setVisibility(0);
            this.IIlll.setVisibility(0);
        } else {
            this.QQOOOOOO.setVisibility(8);
            this.OO0.setVisibility(8);
            this.Ssssssss.setVisibility(8);
            this.QQOOOOOOOO.setVisibility(0);
            this.OO000.setVisibility(0);
            this.OO0000.setVisibility(0);
            this.OO00.setVisibility(0);
        }
        Wwwwww.setVideoImageDisplayType(0);
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwww wwwwwwwwww, int i, Class cls) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwww, i, cls);
        this.OO00000 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", 2);
        TextView textView = this.IIlll;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("x");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("倍速");
        textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public int getLayoutId() {
        return R.layout.layout_my_jzvd_std;
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww, android.view.View.OnClickListener
    public void onClick(View view) {
        Toast makeText;
        TextView textView;
        String str;
        List<EpisodeParcel> list;
        LinearLayout linearLayout;
        super.onClick(view);
        try {
            switch (view.getId()) {
                case R.id.before_text_auto /* 2131361889 */:
                    rn0 rn0Var = this.Ooooo;
                    if (rn0Var != null) {
                        rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    EpisodeFullPlayAdapter episodeFullPlayAdapter = this.Sssssssss;
                    if (episodeFullPlayAdapter == null || (list = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null || list.isEmpty()) {
                        return;
                    }
                    if (episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1 >= episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "已经是最后一集了");
                        return;
                    } else if (episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        return;
                    } else {
                        int i = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                        episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                        EpisodeParcel episodeParcel = episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                        episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = episodeParcel;
                        ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(episodeParcel, episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, episodeFullPlayAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        episodeFullPlayAdapter.notifyDataSetChanged();
                        return;
                    }
                case R.id.iv_down /* 2131362165 */:
                    Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = this.QQOO;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        return;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                case R.id.iv_lock /* 2131362176 */:
                    if (!this.Sssssssssss) {
                        Kkkkkkkkkkkkkkkkkkkkkk();
                        this.Sssssssssss = true;
                        this.QQOOOOOOOOO.setImageResource(R.drawable.ic_lock_closed);
                        this.QQOOOOOOO.setVisibility(8);
                        return;
                    }
                    this.Sssssssssss = false;
                    this.QQOOOOOOOOO.setImageResource(R.drawable.ic_lock_open);
                    if (!this.Ill) {
                        this.QQOOOOOOO.setVisibility(0);
                    }
                    Kkkkkkkkkkkkkkkkkkkkkk();
                    Kkkkkkkkkkkkkkkkkkk();
                    return;
                case R.id.next_text_auto /* 2131362370 */:
                case R.id.tv_next /* 2131362707 */:
                    rn0 rn0Var2 = this.Ooooo;
                    if (rn0Var2 != null) {
                        rn0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    EpisodeFullPlayAdapter episodeFullPlayAdapter2 = this.Sssssssss;
                    if (episodeFullPlayAdapter2 == null) {
                        return;
                    }
                    episodeFullPlayAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                case R.id.tv_050 /* 2131362633 */:
                    this.OO00000 = 0;
                    this.Wwwwwwwwwwwwwwwwww.setSpeed(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0));
                    TextView textView2 = this.IIlll;
                    textView2.setText("x" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000) + "倍速");
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", Integer.valueOf(this.OO00000));
                    return;
                case R.id.tv_075 /* 2131362634 */:
                    this.OO00000 = 1;
                    this.Wwwwwwwwwwwwwwwwww.setSpeed(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1));
                    TextView textView3 = this.IIlll;
                    textView3.setText("x" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000) + "倍速");
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", Integer.valueOf(this.OO00000));
                    return;
                case R.id.tv_100 /* 2131362636 */:
                    this.OO00000 = 2;
                    this.Wwwwwwwwwwwwwwwwww.setSpeed(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2));
                    TextView textView4 = this.IIlll;
                    textView4.setText("x" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000) + "倍速");
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", Integer.valueOf(this.OO00000));
                    return;
                case R.id.tv_125 /* 2131362637 */:
                    this.OO00000 = 3;
                    this.Wwwwwwwwwwwwwwwwww.setSpeed(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
                    TextView textView5 = this.IIlll;
                    textView5.setText("x" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000) + "倍速");
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", Integer.valueOf(this.OO00000));
                    return;
                case R.id.tv_150 /* 2131362638 */:
                    this.OO00000 = 4;
                    this.Wwwwwwwwwwwwwwwwww.setSpeed(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4));
                    TextView textView6 = this.IIlll;
                    textView6.setText("x" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000) + "倍速");
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", Integer.valueOf(this.OO00000));
                    return;
                case R.id.tv_200 /* 2131362640 */:
                    this.OO00000 = 5;
                    this.Wwwwwwwwwwwwwwwwww.setSpeed(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5));
                    TextView textView7 = this.IIlll;
                    textView7.setText("x" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.OO00000) + "倍速");
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", Integer.valueOf(this.OO00000));
                    return;
                case R.id.tv_episode /* 2131362678 */:
                    Kkkkkkkkkkkkkkkkkkkkkkkkk();
                    linearLayout = this.QQOOOO;
                    linearLayout.setVisibility(0);
                    return;
                case R.id.tv_error_change_core /* 2131362680 */:
                    if (this.QQOO == null) {
                        return;
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 2) {
                            return;
                        }
                        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
                        this.QQOO.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 1);
                    this.QQOO.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                case R.id.tv_error_change_core2 /* 2131362681 */:
                    if (this.QQOO == null) {
                        return;
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 1) {
                        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 2);
                        this.QQOO.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != 2) {
                        return;
                    }
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 1);
                    this.QQOO.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                case R.id.tv_error_change_player /* 2131362682 */:
                    Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww2 = this.QQOO;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                        return;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                case R.id.tv_size /* 2131362735 */:
                    try {
                        int i2 = Wwwwww.Kkkkkk;
                        if (i2 == 0) {
                            Wwwwww.setVideoImageDisplayType(1);
                            textView = this.O00;
                            str = "全屏";
                        } else if (i2 == 1) {
                            Wwwwww.setVideoImageDisplayType(2);
                            textView = this.O00;
                            str = "裁剪";
                        } else if (i2 == 2) {
                            Wwwwww.setVideoImageDisplayType(3);
                            textView = this.O00;
                            str = "原始";
                        } else if (i2 != 3) {
                            return;
                        } else {
                            Wwwwww.setVideoImageDisplayType(0);
                            textView = this.O00;
                            str = "填充";
                        }
                        textView.setText(str);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        makeText = Toast.makeText(this.IIllll, "切换失败", 0);
                        makeText.show();
                        return;
                    }
                case R.id.tv_speed /* 2131362741 */:
                    Kkkkkkkkkkkkkkkkkkkkkkkkk();
                    linearLayout = this.QQOOOOO;
                    linearLayout.setVisibility(0);
                    return;
                default:
                    return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            makeText = Toast.makeText(this.IIllll, (int) R.string.msg_change_key_core, 1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x02a5, code lost:
        if (r0 != 1) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0289  */
    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww, android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        ImageView imageView;
        int streamMaxVolume;
        int i;
        if (!this.Sssssssssss) {
            int id = view.getId();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (id == R.id.surface_container) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    hashCode();
                    MotionEvent motionEvent2 = this.Ooooooooo;
                    if (motionEvent2 != null && this.Oooooooooo != null) {
                        if (motionEvent.getEventTime() - motionEvent2.getEventTime() <= 200) {
                            int x2 = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                            int y2 = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                            if ((y2 * y2) + (x2 * x2) < 10000) {
                                z = true;
                                if (z) {
                                    this.Ooooooooooo = true;
                                    this.Wwwwwwwwwwwww.performClick();
                                    this.Oooooooooo = MotionEvent.obtain(motionEvent);
                                    this.Kkkkkkkkkkkkkkkkkkkkkkk = true;
                                    this.Kkkkkkkkkkkkkkkkkkkkkk = x;
                                    this.Kkkkkkkkkkkkkkkkkkkkk = y;
                                    this.Kkkkkkkkkkkkkkkkkkkk = false;
                                    this.Kkkkkkkkkkkkkkkkkkk = false;
                                    this.Kkkkkkkkkkkkkkkkkk = false;
                                    this.Oooooooo = false;
                                    if (!this.Ooooooooooo) {
                                        this.Ooooooo = false;
                                        rn0 rn0Var = this.Oooooo;
                                        if (rn0Var != null) {
                                            rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                            this.Oooooooo = false;
                                            this.Oooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        }
                                    }
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    this.Ooooooooooo = false;
                    this.Oooooooooo = MotionEvent.obtain(motionEvent);
                    this.Kkkkkkkkkkkkkkkkkkkkkkk = true;
                    this.Kkkkkkkkkkkkkkkkkkkkkk = x;
                    this.Kkkkkkkkkkkkkkkkkkkkk = y;
                    this.Kkkkkkkkkkkkkkkkkkkk = false;
                    this.Kkkkkkkkkkkkkkkkkkk = false;
                    this.Kkkkkkkkkkkkkkkkkk = false;
                    this.Oooooooo = false;
                    if (!this.Ooooooooooo) {
                    }
                } else if (action == 1) {
                    hashCode();
                    Kkkkkkkkkkkkkkkkk();
                    this.Ooooooooo = MotionEvent.obtain(motionEvent);
                    this.Kkkkkkkkkkkkkkkkkkkkkkk = false;
                    this.QQOOOOO.setVisibility(8);
                    this.QQOOOO.setVisibility(8);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (this.Kkkkkkkkkkkkkkkkkkk) {
                        this.Wwwwwwwwwwwwwwwwww.seekTo(this.Kkkkkkkkkkkkkk);
                        long duration = getDuration();
                        long j = this.Kkkkkkkkkkkkkk * 100;
                        if (duration == 0) {
                            duration = 1;
                        }
                        int i2 = (int) (j / duration);
                        this.Wwwwwwwwwwww.setProgress(i2);
                        this.f4510Kk.setProgress(i2);
                    }
                    Wwwwwwwwwwwwwww();
                    if (!this.Kkkkkkkkkkkkkkkkkkk && !this.Kkkkkkkkkkkkkkkkkkkk && !this.Ooooooooooo) {
                        Kkkkkkkkkkkkkkkkkkkkkk();
                        if (this.Wwwwwwwwwwwwwwwwwwwwwww == 1) {
                            if (this.Wwwwwwwwwwwww.getVisibility() == 0) {
                                this.QQOOOOOOOOO.setVisibility(0);
                                if (!this.Ill) {
                                    imageView = this.QQOOOOOOO;
                                }
                            } else {
                                this.QQOOOOOOOOO.setVisibility(8);
                                this.QQOOOOOOO.setVisibility(8);
                            }
                        }
                    }
                    Kkkkkkkkkkkkkkkkkkk();
                } else if (action == 2) {
                    hashCode();
                    float f = x - this.Kkkkkkkkkkkkkkkkkkkkkk;
                    float f2 = y - this.Kkkkkkkkkkkkkkkkkkkkk;
                    float abs = Math.abs(f);
                    float abs2 = Math.abs(f2);
                    if (!this.Oooooooo && (abs > 80.0f || abs2 > 80.0f)) {
                        Kkkkkkkkkkkkkkkkk();
                    }
                    if (!this.Oooooooo && this.Wwwwwwwwwwwwwwwwwwwwwww == 1 && !this.Kkkkkkkkkkkkkkkkkkk && !this.Kkkkkkkkkkkkkkkkkkkk && !this.Kkkkkkkkkkkkkkkkkk && (abs > 80.0f || abs2 > 80.0f)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (i >= 0) {
                            if (this.Wwwwwwwwwwwwwwwwwwwwwwww != 7) {
                                this.Kkkkkkkkkkkkkkkkkkk = true;
                                this.Kkkkkkkkkkkkkkkkk = getCurrentPositionWhenPlaying();
                            }
                        } else if (this.Kkkkkkkkkkkkkkkkkkkkkk < this.Www * 0.5f) {
                            this.Kkkkkkkkkkkkkkkkkk = true;
                            float f3 = Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getAttributes().screenBrightness;
                            if (f3 < 0.0f) {
                                try {
                                    this.Kkkkkkkkkkkkkkk = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                                } catch (Settings.SettingNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                this.Kkkkkkkkkkkkkkk = f3 * 255.0f;
                            }
                        } else {
                            this.Kkkkkkkkkkkkkkkkkkkk = true;
                            this.Kkkkkkkkkkkkkkkk = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getStreamVolume(3);
                        }
                    }
                    if (this.Kkkkkkkkkkkkkkkkkkk) {
                        long duration2 = getDuration();
                        long j2 = (int) (((((float) duration2) * f) / (this.Www * 20)) + ((float) this.Kkkkkkkkkkkkkkkkk));
                        this.Kkkkkkkkkkkkkk = j2;
                        if (j2 > duration2) {
                            this.Kkkkkkkkkkkkkk = duration2;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk), this.Kkkkkkkkkkkkkk, Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(duration2), duration2);
                    }
                    if (this.Kkkkkkkkkkkkkkkkkkkk) {
                        f2 = -f2;
                        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setStreamVolume(3, this.Kkkkkkkkkkkkkkkk + ((int) (((this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getStreamMaxVolume(3) * f2) * 3.0f) / this.Kkkkkkkkkkkkkkkkkkkkkkkkkk)), 0);
                        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-f2, (int) ((((f2 * 3.0f) * 100.0f) / this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) + ((this.Kkkkkkkkkkkkkkkk * 100) / streamMaxVolume)));
                        this.Illllllll.setProgressDrawable(ContextCompat.getDrawable(this.IIllll, R.drawable.myjz_dialog_progress));
                    }
                    if (this.Kkkkkkkkkkkkkkkkkk) {
                        float f4 = -f2;
                        WindowManager.LayoutParams attributes = Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).getAttributes();
                        float f5 = this.Kkkkkkkkkkkkkkk;
                        float f6 = (int) (((f4 * 255.0f) * 3.0f) / this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
                        if ((f5 + f6) / 255.0f >= 1.0f) {
                            attributes.screenBrightness = 1.0f;
                        } else if ((f5 + f6) / 255.0f <= 0.0f) {
                            attributes.screenBrightness = 0.01f;
                        } else {
                            attributes.screenBrightness = (f5 + f6) / 255.0f;
                        }
                        Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext()).setAttributes(attributes);
                        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((((f4 * 3.0f) * 100.0f) / this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) + ((this.Kkkkkkkkkkkkkkk * 100.0f) / 255.0f)));
                        this.Illll.setProgressDrawable(ContextCompat.getDrawable(this.IIllll, R.drawable.myjz_dialog_progress));
                    }
                }
            } else if (id == R.id.bottom_seek_progress) {
                int action2 = motionEvent.getAction();
                if (action2 == 0) {
                    Wwwwwwwww();
                }
            }
            return false;
        }
        imageView = this.QQOOOOOOOOO;
        imageView.setVisibility(0);
        Kkkkkkkkkkkkkkkkkkk();
        return false;
    }

    public void setCallBack(Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.QQOO = wwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void setScreenNormal(boolean z) {
        super.setScreenNormal(z);
        if (!z || !this.IIlllllllll) {
            this.OO000000.setVisibility(8);
            this.OO0000000.setVisibility(8);
            if (this.f4509Il) {
                this.Illlllllllllllllllllllllllll.setVisibility(4);
                this.O00.setVisibility(0);
                this.IIlll.setVisibility(0);
            } else {
                this.Illlllllllllllllllllllllllll.setVisibility(0);
                this.OO0000.setVisibility(0);
                this.OO00.setVisibility(0);
                this.O00.setVisibility(8);
                this.IIlll.setVisibility(8);
            }
            this.QQOOOO.setVisibility(8);
            this.QQOOOOOOOOO.setVisibility(8);
            this.QQOOOOOOO.setVisibility(8);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QQOOO.getLayoutParams();
            layoutParams.setMargins(0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(40), 0, 0);
            this.QQOOO.setLayoutParams(layoutParams);
        } catch (Exception unused) {
        }
    }

    public void setSnifferUrl(String str) {
        if (this.Ssssss != null) {
            if (this.Sssssss.getVisibility() == 8) {
                this.Sssssss.setVisibility(0);
            }
            this.Ssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, str);
            this.Sssssss.scrollToPosition(this.Ssssss.getItemCount() - 1);
        }
    }

    public void setThumbImg(String str) {
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.IIllll, str, this.Illllllllllllllllllllllllll, "");
    }

    @Override // me.tvspark.Wwwww, me.tvspark.Wwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        hashCode();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = 1;
        Wwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww = this.QQOO;
        if (wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }
    }
}
