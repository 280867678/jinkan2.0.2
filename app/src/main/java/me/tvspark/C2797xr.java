package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.xr */
/* loaded from: classes4.dex */
public final class C2797xr {
    public Typeface Wwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    @Nullable
    public TextView Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public CharSequence Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public CharSequence Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public TextView Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public FrameLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public LinearLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final TextInputLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.xr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public final /* synthetic */ TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, TextView textView, int i2, TextView textView2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textView;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView;
            C2797xr c2797xr = C2797xr.this;
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            TextView textView2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 && (textView = C2797xr.this.Wwwwwwwwwwwwwwwwwwwwwww) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public C2797xr(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textInputLayout;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = context.getResources().getDimensionPixelSize(com.google.android.material.R$dimen.design_textinput_caption_translate_y);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = null;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = (!this.Wwwwwwwwwwwwwwwwww || TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwww)) ? 0 : 2;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, (CharSequence) null));
    }

    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        TextView textView = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwww == 1 && this.Wwwwwwwwwwwwwwwwwwwwwww != null && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Animator animator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        if (!(i == 0 || i == 1) || (frameLayout = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        LinearLayout linearLayout = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 != 0) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, @DimenRes int i, int i2) {
        return z ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelSize(i) : i2;
    }

    @Nullable
    public final TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 1) {
            if (i == 2) {
                return this.Wwwwwwwwwwwwwwwww;
            }
            return null;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText() == null) ? false : true) {
            EditText editText = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText();
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ViewCompat.setPaddingRelative(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingStart(editText)), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$dimen.material_helper_text_font_1_3_padding_top, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelSize(com.google.android.material.R$dimen.material_helper_text_default_padding_top)), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TextView textView, int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            LinearLayout linearLayout = new LinearLayout(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = linearLayout;
            linearLayout.setOrientation(0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addView(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -1, -2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new FrameLayout(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addView(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText() != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        if (i == 0 || i == 1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addView(textView);
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEnabled() && (this.Wwwwwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwwwwwwww || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull List<Animator> list, boolean z, @Nullable TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i != i3 && i != i2) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, i3 == i ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        list.add(ofFloat);
        if (i3 != i) {
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, 0.0f);
        ofFloat2.setDuration(217L);
        ofFloat2.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        list.add(ofFloat2);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, boolean z) {
        TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        TextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = animatorSet;
            ArrayList arrayList = new ArrayList();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, 2, i, i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, 1, i, i2);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(animatorSet, (List<Animator>) arrayList);
            animatorSet.addListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i), i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)));
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.setVisibility(0);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.setAlpha(1.0f);
            }
            if (i != 0 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setVisibility(4);
                if (i == 1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setText((CharSequence) null);
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww();
    }
}
