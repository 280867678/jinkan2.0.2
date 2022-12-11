package me.tvspark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.efs.sdk.base.Constants;
import me.tvspark.Llllllllll;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.xe0;
import white.whale.R;

/* loaded from: classes4.dex */
public class vn0 implements sk0 {

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GlideException glideException);
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2507q0<Bitmap> {
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2507q0
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable GlideException glideException, Object obj, AbstractC1930b1<Bitmap> abstractC1930b1, boolean z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(glideException);
                return false;
            }
            return false;
        }

        @Override // me.tvspark.AbstractC2507q0
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap, Object obj, AbstractC1930b1<Bitmap> abstractC1930b1, DataSource dataSource, boolean z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2507q0<Bitmap> {
        public final /* synthetic */ Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Context context) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        }

        @Override // me.tvspark.AbstractC2507q0
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable GlideException glideException, Object obj, AbstractC1930b1<Bitmap> abstractC1930b1, boolean z) {
            return false;
        }

        @Override // me.tvspark.AbstractC2507q0
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap, Object obj, AbstractC1930b1<Bitmap> abstractC1930b1, DataSource dataSource, boolean z) {
            Bitmap bitmap2 = bitmap;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap2);
                Palette.from(bitmap2).generate(new wn0(this));
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2844z0<Bitmap> {
        public final /* synthetic */ ImageView Wwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Context Wwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, ImageView imageView) {
            this.Wwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwww = imageView;
        }

        @Override // me.tvspark.AbstractC1930b1
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj, @Nullable AbstractC2058e1 abstractC2058e1) {
            Bitmap bitmap = (Bitmap) obj;
            xe0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = xe0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww);
            ze0 ze0Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 10;
            ze0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            xe0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new xe0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bitmap, ze0Var, true, null);
            ImageView imageView = this.Wwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWidth();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHeight();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                bf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(new af0(new bf0(imageView.getContext(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new we0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, imageView))));
                return;
            }
            imageView.setImageDrawable(new BitmapDrawable(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResources(), r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView.getContext(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2507q0<Bitmap> {
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2507q0
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable GlideException glideException, Object obj, AbstractC1930b1<Bitmap> abstractC1930b1, boolean z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(glideException);
                return false;
            }
            return false;
        }

        @Override // me.tvspark.AbstractC2507q0
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap, Object obj, AbstractC1930b1<Bitmap> abstractC1930b1, DataSource dataSource, boolean z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return false;
            }
            return false;
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, ImageView imageView, String str2) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        if ((context instanceof BaseActivity) && ((BaseActivity) context).isFinishing()) {
            return;
        }
        Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkk = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.bg_place_holder_vertical).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.bg_place_holder_vertical).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        if ((context instanceof BaseActivity) && ((BaseActivity) context).isFinishing()) {
            return;
        }
        Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf((int) R.drawable.bg_place_holder_vertical)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, ImageView imageView, String str2) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        if ((context instanceof BaseActivity) && ((BaseActivity) context).isFinishing()) {
            return;
        }
        Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkk = true;
        Kkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, imageView);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, C2391n1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        throw null;
    }

    public static Ooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = Constants.CP_NONE;
        }
        Llllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Llllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("User-Agent", ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww);
        if (!TextUtils.isEmpty(str2) && !str2.equals(Constants.CP_NONE)) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Referer", str2);
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        return new Ooo(str, new Llllllllll(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, ImageView imageView) {
        Kkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (imageView == null) {
            return;
        }
        if ((context instanceof BaseActivity) && ((BaseActivity) context).isFinishing()) {
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (isEmpty) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.valueOf((int) R.drawable.bg_banner_def)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Kkkkkkkkkkkkkkkkk = str;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Kkkkkkkkkkkkkk = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.bg_banner_def).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.bg_banner_def);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, ImageView imageView, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        if ((context instanceof BaseActivity) && ((BaseActivity) context).isFinishing()) {
            return;
        }
        Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkk = str;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkk = true;
        Kkkkkkkkkkkkk mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) R.color.f5061white).mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Zzzzzzzzzz(), new Zzzzzzzz()));
        mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2507q0) new xn0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, int i, ImageView imageView, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        if ((context instanceof BaseActivity) && ((BaseActivity) context).isFinishing()) {
            return;
        }
        Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkk = str;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkk = true;
        Kkkkkkkkkkkkk mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) R.color.f5061white).mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Zzzzzzzzzz(), new Cccccc(i)));
        mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2507q0) new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, ImageView imageView, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        if ((context instanceof BaseActivity) && ((BaseActivity) context).isFinishing()) {
            return;
        }
        Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkk = true;
        Kkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.bg_place_holder_vertical).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.bg_place_holder_vertical);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2507q0) new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, context));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str, String str2, ImageView imageView, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        if ((context instanceof BaseActivity) && ((BaseActivity) context).isFinishing()) {
            return;
        }
        Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkk = true;
        Kkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.bg_place_holder_vertical).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.drawable.bg_place_holder_vertical);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2507q0) new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView);
    }
}
