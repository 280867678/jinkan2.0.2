package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import me.tvspark.AbstractC2760wr;
import me.tvspark.C1920as;
import me.tvspark.C1957bs;
import me.tvspark.C2156gp;
import me.tvspark.C2193hp;
import me.tvspark.C2227im;
import me.tvspark.C2306kr;
import me.tvspark.C2415np;
import me.tvspark.C2416nq;
import me.tvspark.C2491pr;
import me.tvspark.C2534qr;
import me.tvspark.C2571rr;
import me.tvspark.C2797xr;
import me.tvspark.C2871zr;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout {
    public static final int O0000000000 = R$style.Widget_Design_TextInputLayout;
    public boolean IIl;
    public boolean IIll;
    public ValueAnimator IIlll;
    public boolean IIllll;
    public boolean IIlllll;
    public final C2156gp IIllllll;
    public boolean IIlllllll;
    @ColorInt
    public int IIllllllll;
    @ColorInt
    public int IIlllllllll;
    @ColorInt

    /* renamed from: Il */
    public int f579Il;
    @ColorInt
    public int Ill;
    @ColorInt
    public int Illl;
    public ColorStateList Illll;
    @ColorInt
    public int Illlll;
    @ColorInt
    public int Illllll;
    @ColorInt
    public int Illlllll;
    public ColorStateList Illllllll;
    public ColorStateList Illlllllll;
    public ColorStateList Illllllllll;
    @NonNull
    public final CheckableImageButton Illlllllllll;
    public View.OnLongClickListener Illllllllllll;
    public View.OnLongClickListener Illlllllllllll;
    public Drawable Illllllllllllll;
    public int Illlllllllllllll;
    @Nullable
    public Drawable Illllllllllllllll;
    public boolean Illlllllllllllllll;
    public PorterDuff.Mode Illllllllllllllllll;
    public boolean Illlllllllllllllllll;
    public ColorStateList Illllllllllllllllllll;
    public final LinkedHashSet<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> Illlllllllllllllllllll;
    @NonNull
    public final CheckableImageButton Illllllllllllllllllllll;
    public final SparseArray<AbstractC2760wr> Illlllllllllllllllllllll;
    public int Illllllllllllllllllllllll;
    public final LinkedHashSet<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Illlllllllllllllllllllllll;
    public View.OnLongClickListener Illllllllllllllllllllllllll;
    public int Illlllllllllllllllllllllllll;
    @Nullable
    public Drawable Illllllllllllllllllllllllllll;

    /* renamed from: Kk */
    public boolean f580Kk;
    public PorterDuff.Mode Kkk;
    public boolean Kkkk;
    public ColorStateList Kkkkk;
    @NonNull
    public final CheckableImageButton Kkkkkk;
    public Typeface Kkkkkkk;
    public final RectF Kkkkkkkk;
    public final Rect Kkkkkkkkk;
    public final Rect Kkkkkkkkkk;
    @ColorInt
    public int Kkkkkkkkkkk;
    @ColorInt
    public int Kkkkkkkkkkkk;
    public int Kkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkk;
    public final int Kkkkkkkkkkkkkkkkkk;
    @NonNull
    public C2416nq Kkkkkkkkkkkkkkkkkkk;
    @Nullable
    public MaterialShapeDrawable Kkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public MaterialShapeDrawable Kkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkk;
    public CharSequence Kkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkk;
    @NonNull
    public final TextView Kkkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public CharSequence Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    @NonNull
    public final TextView Www;
    @Nullable
    public CharSequence Wwww;
    @Nullable
    public ColorStateList Wwwww;
    @Nullable
    public ColorStateList Wwwwww;
    public int Wwwwwww;
    @Nullable
    public ColorStateList Wwwwwwww;
    public TextView Wwwwwwwww;
    public boolean Wwwwwwwwww;
    public CharSequence Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    @Nullable
    public TextView Wwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public final C2797xr Wwwwwwwwwwwwwwwwww;
    public CharSequence Wwwwwwwwwwwwwwwwwww;
    public EditText Wwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final FrameLayout Wwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final LinearLayout Wwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final LinearLayout Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final FrameLayout Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final TextInputLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textInputLayout;
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
            if (r3 != null) goto L43;
         */
        @Override // androidx.core.view.AccessibilityDelegateCompat
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHint();
            CharSequence error = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getError();
            CharSequence placeholderText = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPlaceholderText();
            int counterMaxLength = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.IIlllllll;
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.setText(charSequence);
                if (z3 && placeholderText != null) {
                    placeholderText = charSequence + ", " + ((Object) placeholderText);
                    accessibilityNodeInfoCompat.setText(placeholderText);
                }
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R$id.textinput_helper_text);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbsSavedState {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        @Nullable
        public CharSequence Wwwwwwwwwwwwwwwwwwww;
        @Nullable
        public CharSequence Wwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public CharSequence Wwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public CharSequence Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<Wwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, classLoader);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readInt() != 1 ? false : true;
            this.Wwwwwwwwwwwwwwwwwwwwww = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.Wwwwwwwwwwwwwwwwwwwww = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.Wwwwwwwwwwwwwwwwwwww = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TextInputLayout.SavedState{");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Integer.toHexString(System.identityHashCode(this)));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" error=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((Object) this.Wwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" hint=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((Object) this.Wwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" helperText=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((Object) this.Wwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" placeholderText=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((Object) this.Wwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("}");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.Wwwwwwwwwwwwwwwwwwwwwwww, parcel, i);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww ? 1 : 0);
            TextUtils.writeToParcel(this.Wwwwwwwwwwwwwwwwwwwwww, parcel, i);
            TextUtils.writeToParcel(this.Wwwwwwwwwwwwwwwwwwwww, parcel, i);
            TextUtils.writeToParcel(this.Wwwwwwwwwwwwwwwwwwww, parcel, i);
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextInputLayout textInputLayout, int i);
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextInputLayout textInputLayout);
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ValueAnimator.AnimatorUpdateListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.Wwwwwwwwwwwwwwwwwwww.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.Illllllllllllllllllllll.performClick();
            TextInputLayout.this.Illllllllllllllllllllll.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextWatcher {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!textInputLayout.IIl, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.Wwwwwwwwwwwwwwwww) {
                textInputLayout2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.Wwwwwwwwww) {
                textInputLayout3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, O0000000000), attributeSet, i);
        int i2;
        int colorForState;
        this.Wwwwwwwwwwwwwwwwww = new C2797xr(this);
        this.Kkkkkkkkkk = new Rect();
        this.Kkkkkkkkk = new Rect();
        this.Kkkkkkkk = new RectF();
        this.Illlllllllllllllllllllllll = new LinkedHashSet<>();
        this.Illllllllllllllllllllllll = 0;
        this.Illlllllllllllllllllllll = new SparseArray<>();
        this.Illlllllllllllllllllll = new LinkedHashSet<>();
        this.IIllllll = new C2156gp(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.Wwwwwwwwwwwwwwwwwwwwwww = linearLayout;
        linearLayout.setOrientation(0);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        this.Wwwwwwwwwwwwwwwwwwwwwwww.addView(this.Wwwwwwwwwwwwwwwwwwwwwww);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.Wwwwwwwwwwwwwwwwwwwwww = linearLayout2;
        linearLayout2.setOrientation(0);
        this.Wwwwwwwwwwwwwwwwwwwwww.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        this.Wwwwwwwwwwwwwwwwwwwwwwww.addView(this.Wwwwwwwwwwwwwwwwwwwwww);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.Wwwwwwwwwwwwwwwwwwwww = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        C2156gp c2156gp = this.IIllllll;
        c2156gp.Kkkkkkkkkkkkkkkkkkkkkk = C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2156gp c2156gp2 = this.IIllllll;
        c2156gp2.Kkkkkkkkkkkkkkkkkkkkkkk = C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8388659);
        int[] iArr = R$styleable.TextInputLayout;
        int i3 = O0000000000;
        int[] iArr2 = {R$styleable.TextInputLayout_counterTextAppearance, R$styleable.TextInputLayout_counterOverflowTextAppearance, R$styleable.TextInputLayout_errorTextAppearance, R$styleable.TextInputLayout_helperTextTextAppearance, R$styleable.TextInputLayout_hintTextAppearance};
        C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, i, i3);
        C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, iArr, i, i3, iArr2);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i, i3);
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(obtainStyledAttributes.getText(R$styleable.TextInputLayout_android_hint));
        this.IIllll = obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.IIlllll = obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_expandedHintEnabled, true);
        this.Kkkkkkkkkkkkkkkkkkk = C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, i, O0000000000).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Kkkkkkkkkkkkkkkkkk = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.Kkkkkkkkkkkkkkkk = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.Kkkkkkkkkkkkkk = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.Kkkkkkkkkkkkk = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.Kkkkkkkkkkkkkkk = this.Kkkkkkkkkkkkkk;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = obtainStyledAttributes.getDimension(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        C2416nq c2416nq = this.Kkkkkkkkkkkkkkkkkkk;
        if (c2416nq != null) {
            C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq);
            if (dimension >= 0.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dimension);
            }
            if (dimension2 >= 0.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dimension2);
            }
            if (dimension3 >= 0.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dimension3);
            }
            if (dimension4 >= 0.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dimension4);
            }
            this.Kkkkkkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, obtainStyledAttributes, R$styleable.TextInputLayout_boxBackgroundColor);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                int defaultColor = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDefaultColor();
                this.Illl = defaultColor;
                this.Kkkkkkkkkkk = defaultColor;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isStateful()) {
                    this.Ill = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getColorForState(new int[]{-16842910}, -1);
                    this.f579Il = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getColorForState(new int[]{16842908, 16842910}, -1);
                    colorForState = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getColorForState(new int[]{16843623, 16842910}, -1);
                } else {
                    this.f579Il = this.Illl;
                    ColorStateList colorStateList = AppCompatResources.getColorStateList(context2, R$color.mtrl_filled_background_color);
                    this.Ill = colorStateList.getColorForState(new int[]{-16842910}, -1);
                    colorForState = colorStateList.getColorForState(new int[]{16843623}, -1);
                }
                this.IIlllllllll = colorForState;
            } else {
                this.Kkkkkkkkkkk = 0;
                this.Illl = 0;
                this.Ill = 0;
                this.f579Il = 0;
                this.IIlllllllll = 0;
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_android_textColorHint)) {
                ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_android_textColorHint);
                this.Illllllll = colorStateList2;
                this.Illlllllll = colorStateList2;
            }
            ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, obtainStyledAttributes, R$styleable.TextInputLayout_boxStrokeColor);
            this.Illlll = obtainStyledAttributes.getColor(R$styleable.TextInputLayout_boxStrokeColor, 0);
            this.Illlllll = ContextCompat.getColor(context2, R$color.mtrl_textinput_default_box_stroke_color);
            this.IIllllllll = ContextCompat.getColor(context2, R$color.mtrl_textinput_disabled_color);
            this.Illllll = ContextCompat.getColor(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                setBoxStrokeColorStateList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_boxStrokeErrorColor)) {
                setBoxStrokeErrorColor(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, obtainStyledAttributes, R$styleable.TextInputLayout_boxStrokeErrorColor));
            }
            if (obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
                setHintTextAppearance(obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_hintTextAppearance, 0));
            }
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_errorTextAppearance, 0);
            CharSequence text = obtainStyledAttributes.getText(R$styleable.TextInputLayout_errorContentDescription);
            boolean z = obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_errorEnabled, false);
            CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_end_icon, (ViewGroup) this.Wwwwwwwwwwwwwwwwwwwwww, false);
            this.Illlllllllll = checkableImageButton;
            checkableImageButton.setId(R$id.text_input_error_icon);
            this.Illlllllllll.setVisibility(8);
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2)) {
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.Illlllllllll.getLayoutParams(), 0);
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_errorIconDrawable)) {
                setErrorIconDrawable(obtainStyledAttributes.getDrawable(R$styleable.TextInputLayout_errorIconDrawable));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_errorIconTint)) {
                setErrorIconTintList(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, obtainStyledAttributes, R$styleable.TextInputLayout_errorIconTint));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_errorIconTintMode)) {
                setErrorIconTintMode(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes.getInt(R$styleable.TextInputLayout_errorIconTintMode, -1), (PorterDuff.Mode) null));
            }
            this.Illlllllllll.setContentDescription(getResources().getText(R$string.error_icon_content_description));
            ViewCompat.setImportantForAccessibility(this.Illlllllllll, 2);
            this.Illlllllllll.setClickable(false);
            this.Illlllllllll.setPressable(false);
            this.Illlllllllll.setFocusable(false);
            int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_helperTextTextAppearance, 0);
            boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_helperTextEnabled, false);
            CharSequence text2 = obtainStyledAttributes.getText(R$styleable.TextInputLayout_helperText);
            int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
            CharSequence text3 = obtainStyledAttributes.getText(R$styleable.TextInputLayout_placeholderText);
            int resourceId4 = obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_prefixTextAppearance, 0);
            CharSequence text4 = obtainStyledAttributes.getText(R$styleable.TextInputLayout_prefixText);
            int resourceId5 = obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_suffixTextAppearance, 0);
            CharSequence text5 = obtainStyledAttributes.getText(R$styleable.TextInputLayout_suffixText);
            boolean z3 = obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_counterEnabled, false);
            setCounterMaxLength(obtainStyledAttributes.getInt(R$styleable.TextInputLayout_counterMaxLength, -1));
            this.Wwwwwwwwwwww = obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_counterTextAppearance, 0);
            this.Wwwwwwwwwwwww = obtainStyledAttributes.getResourceId(R$styleable.TextInputLayout_counterOverflowTextAppearance, 0);
            CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this.Wwwwwwwwwwwwwwwwwwwwwww, false);
            this.Kkkkkk = checkableImageButton2;
            checkableImageButton2.setVisibility(8);
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2)) {
                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.Kkkkkk.getLayoutParams(), 0);
            }
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_startIconDrawable)) {
                setStartIconDrawable(obtainStyledAttributes.getDrawable(R$styleable.TextInputLayout_startIconDrawable));
                if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_startIconContentDescription)) {
                    setStartIconContentDescription(obtainStyledAttributes.getText(R$styleable.TextInputLayout_startIconContentDescription));
                }
                setStartIconCheckable(obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_startIconCheckable, true));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_startIconTint)) {
                setStartIconTintList(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, obtainStyledAttributes, R$styleable.TextInputLayout_startIconTint));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_startIconTintMode)) {
                setStartIconTintMode(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes.getInt(R$styleable.TextInputLayout_startIconTintMode, -1), (PorterDuff.Mode) null));
            }
            setBoxBackgroundMode(obtainStyledAttributes.getInt(R$styleable.TextInputLayout_boxBackgroundMode, 0));
            CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_end_icon, (ViewGroup) this.Wwwwwwwwwwwwwwwwwwwww, false);
            this.Illllllllllllllllllllll = checkableImageButton3;
            this.Wwwwwwwwwwwwwwwwwwwww.addView(checkableImageButton3);
            this.Illllllllllllllllllllll.setVisibility(8);
            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2)) {
                i2 = 0;
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.Illllllllllllllllllllll.getLayoutParams(), 0);
            } else {
                i2 = 0;
            }
            this.Illlllllllllllllllllllll.append(-1, new C2491pr(this));
            this.Illlllllllllllllllllllll.append(i2, new C2871zr(this));
            this.Illlllllllllllllllllllll.append(1, new C1920as(this));
            this.Illlllllllllllllllllllll.append(2, new C2306kr(this));
            this.Illlllllllllllllllllllll.append(3, new C2571rr(this));
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_endIconMode)) {
                setEndIconMode(obtainStyledAttributes.getInt(R$styleable.TextInputLayout_endIconMode, 0));
                if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_endIconDrawable)) {
                    setEndIconDrawable(obtainStyledAttributes.getDrawable(R$styleable.TextInputLayout_endIconDrawable));
                }
                if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_endIconContentDescription)) {
                    setEndIconContentDescription(obtainStyledAttributes.getText(R$styleable.TextInputLayout_endIconContentDescription));
                }
                setEndIconCheckable(obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_endIconCheckable, true));
            } else if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_passwordToggleEnabled)) {
                setEndIconMode(obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
                setEndIconDrawable(obtainStyledAttributes.getDrawable(R$styleable.TextInputLayout_passwordToggleDrawable));
                setEndIconContentDescription(obtainStyledAttributes.getText(R$styleable.TextInputLayout_passwordToggleContentDescription));
                if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_passwordToggleTint)) {
                    setEndIconTintList(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, obtainStyledAttributes, R$styleable.TextInputLayout_passwordToggleTint));
                }
                if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_passwordToggleTintMode)) {
                    setEndIconTintMode(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes.getInt(R$styleable.TextInputLayout_passwordToggleTintMode, -1), (PorterDuff.Mode) null));
                }
            }
            if (!obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_passwordToggleEnabled)) {
                if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_endIconTint)) {
                    setEndIconTintList(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, obtainStyledAttributes, R$styleable.TextInputLayout_endIconTint));
                }
                if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_endIconTintMode)) {
                    setEndIconTintMode(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes.getInt(R$styleable.TextInputLayout_endIconTintMode, -1), (PorterDuff.Mode) null));
                }
            }
            AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
            this.Www = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_prefix_text);
            this.Www.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            ViewCompat.setAccessibilityLiveRegion(this.Www, 1);
            this.Wwwwwwwwwwwwwwwwwwwwwww.addView(this.Kkkkkk);
            this.Wwwwwwwwwwwwwwwwwwwwwww.addView(this.Www);
            AppCompatTextView appCompatTextView2 = new AppCompatTextView(context2);
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = appCompatTextView2;
            appCompatTextView2.setId(R$id.textinput_suffix_text);
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
            ViewCompat.setAccessibilityLiveRegion(this.Kkkkkkkkkkkkkkkkkkkkkkkkk, 1);
            this.Wwwwwwwwwwwwwwwwwwwwww.addView(this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
            this.Wwwwwwwwwwwwwwwwwwwwww.addView(this.Illlllllllll);
            this.Wwwwwwwwwwwwwwwwwwwwww.addView(this.Wwwwwwwwwwwwwwwwwwwww);
            setHelperTextEnabled(z2);
            setHelperText(text2);
            setHelperTextTextAppearance(resourceId2);
            setErrorEnabled(z);
            setErrorTextAppearance(resourceId);
            setErrorContentDescription(text);
            setCounterTextAppearance(this.Wwwwwwwwwwww);
            setCounterOverflowTextAppearance(this.Wwwwwwwwwwwww);
            setPlaceholderText(text3);
            setPlaceholderTextAppearance(resourceId3);
            setPrefixText(text4);
            setPrefixTextAppearance(resourceId4);
            setSuffixText(text5);
            setSuffixTextAppearance(resourceId5);
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_errorTextColor)) {
                setErrorTextColor(obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_errorTextColor));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_helperTextTextColor)) {
                setHelperTextColor(obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_helperTextTextColor));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_hintTextColor)) {
                setHintTextColor(obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_hintTextColor));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_counterTextColor)) {
                setCounterTextColor(obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_counterTextColor));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_counterOverflowTextColor)) {
                setCounterOverflowTextColor(obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_counterOverflowTextColor));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_placeholderTextColor)) {
                setPlaceholderTextColor(obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_placeholderTextColor));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_prefixTextColor)) {
                setPrefixTextColor(obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_prefixTextColor));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TextInputLayout_suffixTextColor)) {
                setSuffixTextColor(obtainStyledAttributes.getColorStateList(R$styleable.TextInputLayout_suffixTextColor));
            }
            setCounterEnabled(z3);
            setEnabled(obtainStyledAttributes.getBoolean(R$styleable.TextInputLayout_android_enabled, true));
            obtainStyledAttributes.recycle();
            ViewCompat.setImportantForAccessibility(this, 2);
            if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            ViewCompat.setImportantForAutofill(this, 1);
            return;
        }
        throw null;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) childAt, z);
            }
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z = false;
        int i = 1;
        boolean z2 = onLongClickListener != null;
        if (hasOnClickListeners || z2) {
            z = true;
        }
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        if (!z) {
            i = 2;
        }
        ViewCompat.setImportantForAccessibility(checkableImageButton, i);
    }

    private AbstractC2760wr getEndIconDelegate() {
        AbstractC2760wr abstractC2760wr = this.Illlllllllllllllllllllll.get(this.Illllllllllllllllllllllll);
        return abstractC2760wr != null ? abstractC2760wr : this.Illlllllllllllllllllllll.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.Illlllllllll.getVisibility() == 0) {
            return this.Illlllllllll;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Illllllllllllllllllllll;
        }
        return null;
    }

    private void setEditText(EditText editText) {
        if (this.Wwwwwwwwwwwwwwwwwwww == null) {
            if (this.Illllllllllllllllllllllll != 3) {
                boolean z = editText instanceof TextInputEditText;
            }
            this.Wwwwwwwwwwwwwwwwwwww = editText;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww.getTypeface());
            C2156gp c2156gp = this.IIllllll;
            float textSize = this.Wwwwwwwwwwwwwwwwwwww.getTextSize();
            if (c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwww != textSize) {
                c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwww = textSize;
                c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            int gravity = this.Wwwwwwwwwwwwwwwwwwww.getGravity();
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((gravity & (-113)) | 48);
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gravity);
            this.Wwwwwwwwwwwwwwwwwwww.addTextChangedListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            if (this.Illlllllll == null) {
                this.Illlllllll = this.Wwwwwwwwwwwwwwwwwwww.getHintTextColors();
            }
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
                if (TextUtils.isEmpty(this.Kkkkkkkkkkkkkkkkkkkkkkk)) {
                    CharSequence hint = this.Wwwwwwwwwwwwwwwwwwww.getHint();
                    this.Wwwwwwwwwwwwwwwwwww = hint;
                    setHint(hint);
                    this.Wwwwwwwwwwwwwwwwwwww.setHint((CharSequence) null);
                }
                this.Kkkkkkkkkkkkkkkkkkkkkk = true;
            }
            if (this.Wwwwwwwwwwwwww != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww.getText().length());
            }
            Wwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwww.bringToFront();
            this.Wwwwwwwwwwwwwwwwwwwwww.bringToFront();
            this.Wwwwwwwwwwwwwwwwwwwww.bringToFront();
            this.Illlllllllll.bringToFront();
            Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Illlllllllllllllllllllllll.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
            Wwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwww();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z) {
        int i = 0;
        this.Illlllllllll.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.Wwwwwwwwwwwwwwwwwwwww;
        if (z) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        Wwwwwwwwwwwwwwwwww();
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.Kkkkkkkkkkkkkkkkkkkkkkk)) {
            this.Kkkkkkkkkkkkkkkkkkkkkkk = charSequence;
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
            if (this.IIlllllll) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.Wwwwwwwwww == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.Wwwwwwwww = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            ViewCompat.setAccessibilityLiveRegion(this.Wwwwwwwww, 1);
            setPlaceholderTextAppearance(this.Wwwwwww);
            setPlaceholderTextColor(this.Wwwwwwww);
            TextView textView = this.Wwwwwwwww;
            if (textView != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.addView(textView);
                this.Wwwwwwwww.setVisibility(0);
            }
        } else {
            TextView textView2 = this.Wwwwwwwww;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            this.Wwwwwwwww = null;
        }
        this.Wwwwwwwwww = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwww() {
        int i;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.Kkkkkkkkkkkkkkkkkkkkk == null || this.Kkkkkkkkkkkkkkkkk == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.Wwwwwwwwwwwwwwwwwwww) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.Wwwwwwwwwwwwwwwwwwww) != null && editText.isHovered());
        if (isEnabled()) {
            if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if (this.Illll == null) {
                    i = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, z3);
            } else if (!this.Wwwwwwwwwwwwwww || (textView = this.Wwwwwwwwwwwwww) == null) {
                i = z2 ? this.Illlll : z3 ? this.Illllll : this.Illlllll;
            } else {
                if (this.Illll == null) {
                    i = textView.getCurrentTextColor();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, z3);
            }
            if (getErrorIconDrawable() != null) {
                C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
                if (c2797xr.Wwwwwwwwwwwwwwwwwwwwwwww && c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    z = true;
                }
            }
            setErrorIconVisible(z);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illlllllllll, this.Illllllllll);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkk, this.Kkkkk);
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            if (getEndIconDelegate().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if (!this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || getEndIconDrawable() == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } else {
                    Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
                    DrawableCompat.setTint(mutate, this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    this.Illllllllllllllllllllll.setImageDrawable(mutate);
                }
            }
            this.Kkkkkkkkkkkkkkk = (z2 || !isEnabled()) ? this.Kkkkkkkkkkkkkk : this.Kkkkkkkkkkkkk;
            if (this.Kkkkkkkkkkkkkkkkk == 1) {
                this.Kkkkkkkkkkk = !isEnabled() ? this.Ill : (!z3 || z2) ? z2 ? this.f579Il : this.Illl : this.IIlllllllll;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        i = this.IIllllllll;
        this.Kkkkkkkkkkkk = i;
        if (getErrorIconDrawable() != null) {
        }
        setErrorIconVisible(z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illlllllllll, this.Illllllllll);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkk, this.Kkkkk);
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        if (getEndIconDelegate().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
        }
        this.Kkkkkkkkkkkkkkk = (z2 || !isEnabled()) ? this.Kkkkkkkkkkkkkk : this.Kkkkkkkkkkkkk;
        if (this.Kkkkkkkkkkkkkkkkk == 1) {
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwww() {
        int visibility = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getVisibility();
        int i = 0;
        boolean z = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk != null && !this.IIlllllll;
        TextView textView = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
        if (visibility != this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getVisibility()) {
            getEndIconDelegate().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }
        Wwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        int i = 0;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (!(this.Illlllllllll.getVisibility() == 0)) {
                i = ViewCompat.getPaddingEnd(this.Wwwwwwwwwwwwwwwwwwww);
            }
        }
        ViewCompat.setPaddingRelative(this.Kkkkkkkkkkkkkkkkkkkkkkkkk, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.Wwwwwwwwwwwwwwwwwwww.getPaddingTop(), i, this.Wwwwwwwwwwwwwwwwwwww.getPaddingBottom());
    }

    public final void Wwwwwwwwwwwwwwwwwww() {
        this.Www.setVisibility((this.Wwww == null || this.IIlllllll) ? 8 : 0);
        Wwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        int i = 0;
        if (!(this.Kkkkkk.getVisibility() == 0)) {
            i = ViewCompat.getPaddingStart(this.Wwwwwwwwwwwwwwwwwwww);
        }
        ViewCompat.setPaddingRelative(this.Www, i, this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingBottom());
    }

    public final void Wwwwwwwwwwwwwwwwwwwww() {
        if (this.Kkkkkkkkkkkkkkkkk != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Wwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == layoutParams.topMargin) {
                return;
            }
            layoutParams.topMargin = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.requestLayout();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwww() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.Wwwwwwwwwwwwwwwwwwww;
        if (editText == null || this.Kkkkkkkkkkkkkkkkk != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            currentTextColor = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (!this.Wwwwwwwwwwwwwww || (textView = this.Wwwwwwwwwwwwww) == null) {
            DrawableCompat.clearColorFilter(background);
            this.Wwwwwwwwwwwwwwwwwwww.refreshDrawableState();
            return;
        } else {
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwww() {
        boolean z;
        if (this.Wwwwwwwwwwwwwwwwwwww == null) {
            return false;
        }
        boolean z2 = true;
        if (!(getStartIconDrawable() == null && this.Wwww == null) && this.Wwwwwwwwwwwwwwwwwwwwwww.getMeasuredWidth() > 0) {
            int measuredWidth = this.Wwwwwwwwwwwwwwwwwwwwwww.getMeasuredWidth() - this.Wwwwwwwwwwwwwwwwwwww.getPaddingLeft();
            if (this.Illllllllllllllllllllllllllll == null || this.Illlllllllllllllllllllllllll != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.Illllllllllllllllllllllllllll = colorDrawable;
                this.Illlllllllllllllllllllllllll = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.Illllllllllllllllllllllllllll;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.Illllllllllllllllllllllllllll != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww);
                TextViewCompat.setCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.Illllllllllllllllllllllllllll = null;
                z = true;
            }
            z = false;
        }
        if ((this.Illlllllllll.getVisibility() == 0 || ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) || this.Kkkkkkkkkkkkkkkkkkkkkkkkkk != null)) && this.Wwwwwwwwwwwwwwwwwwwwww.getMeasuredWidth() > 0) {
            int measuredWidth2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getMeasuredWidth() - this.Wwwwwwwwwwwwwwwwwwww.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()) + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww);
            Drawable drawable3 = this.Illllllllllllllll;
            if (drawable3 == null || this.Illlllllllllllll == measuredWidth2) {
                if (this.Illllllllllllllll == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.Illllllllllllllll = colorDrawable2;
                    this.Illlllllllllllll = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.Illllllllllllllll;
                if (drawable4 != drawable5) {
                    this.Illllllllllllll = compoundDrawablesRelative3[2];
                    TextViewCompat.setCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.Illlllllllllllll = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.Illllllllllllllll, compoundDrawablesRelative3[3]);
            }
        } else if (this.Illllllllllllllll == null) {
            return z;
        } else {
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww);
            if (compoundDrawablesRelative4[2] == this.Illllllllllllllll) {
                TextViewCompat.setCompoundDrawablesRelative(this.Wwwwwwwwwwwwwwwwwwww, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.Illllllllllllll, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.Illllllllllllllll = null;
        }
        return z2;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwww() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.Wwwwwwwwwwwwww;
        if (textView != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textView, this.Wwwwwwwwwwwwwww ? this.Wwwwwwwwwwwww : this.Wwwwwwwwwwww);
            if (!this.Wwwwwwwwwwwwwww && (colorStateList2 = this.Wwwwww) != null) {
                this.Wwwwwwwwwwwwww.setTextColor(colorStateList2);
            }
            if (!this.Wwwwwwwwwwwwwww || (colorStateList = this.Wwwww) == null) {
                return;
            }
            this.Wwwwwwwwwwwwww.setTextColor(colorStateList);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwww != null) {
            EditText editText = this.Wwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText == null ? 0 : editText.getText().length());
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllllllll, this.Illllllllllllllllllll);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        float f;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        float f2;
        float f3;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        float f4;
        C2534qr c2534qr;
        int i;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        RectF rectF = this.Kkkkkkkk;
        C2156gp c2156gp = this.IIllllll;
        int width = this.Wwwwwwwwwwwwwwwwwwww.getWidth();
        int gravity = this.Wwwwwwwwwwwwwwwwwwww.getGravity();
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2156gp.Wwwwwwwwwww);
        c2156gp.Wwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        if (gravity == 17 || (gravity & 7) == 1) {
            f = width / 2.0f;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() / 2.0f;
        } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !c2156gp.Wwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) {
            f = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.right;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            f2 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.left;
            rectF.left = f2;
            Rect rect = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            rectF.top = rect.top;
            if (gravity != 17 || (gravity & 7) == 1) {
                f3 = width / 2.0f;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() / 2.0f;
            } else {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (c2156gp.Wwwwwwwww) {
                        f3 = rectF.left;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } else {
                        i = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.right;
                    }
                } else if (!c2156gp.Wwwwwwwww) {
                    f4 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + f2;
                    rectF.right = f4;
                    float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.top;
                    rectF.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    float f5 = rectF.left;
                    float f6 = this.Kkkkkkkkkkkkkkkkkk;
                    rectF.left = f5 - f6;
                    rectF.top -= f6;
                    rectF.right += f6;
                    rectF.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + f6;
                    rectF.offset(-getPaddingLeft(), -getPaddingTop());
                    c2534qr = (C2534qr) this.Kkkkkkkkkkkkkkkkkkkkk;
                    if (c2534qr != null) {
                        throw null;
                    }
                    c2534qr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF.left, rectF.top, rectF.right, rectF.bottom);
                    return;
                } else {
                    i = rect.right;
                }
                f4 = i;
                rectF.right = f4;
                float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.top;
                rectF.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22;
                float f52 = rectF.left;
                float f62 = this.Kkkkkkkkkkkkkkkkkk;
                rectF.left = f52 - f62;
                rectF.top -= f62;
                rectF.right += f62;
                rectF.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 + f62;
                rectF.offset(-getPaddingLeft(), -getPaddingTop());
                c2534qr = (C2534qr) this.Kkkkkkkkkkkkkkkkkkkkk;
                if (c2534qr != null) {
                }
            }
            f4 = f3 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            rectF.right = f4;
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.top;
            rectF.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222;
            float f522 = rectF.left;
            float f622 = this.Kkkkkkkkkkkkkkkkkk;
            rectF.left = f522 - f622;
            rectF.top -= f622;
            rectF.right += f622;
            rectF.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww222 + f622;
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            c2534qr = (C2534qr) this.Kkkkkkkkkkkkkkkkkkkkk;
            if (c2534qr != null) {
            }
        }
        f2 = f - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        rectF.left = f2;
        Rect rect2 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        rectF.top = rect2.top;
        if (gravity != 17) {
        }
        f3 = width / 2.0f;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() / 2.0f;
        f4 = f3 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        rectF.right = f4;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222 = c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.top;
        rectF.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222;
        float f5222 = rectF.left;
        float f6222 = this.Kkkkkkkkkkkkkkkkkk;
        rectF.left = f5222 - f6222;
        rectF.top -= f6222;
        rectF.right += f6222;
        rectF.bottom = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2222 + f6222;
        rectF.offset(-getPaddingLeft(), -getPaddingTop());
        c2534qr = (C2534qr) this.Kkkkkkkkkkkkkkkkkkkkk;
        if (c2534qr != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        EditText editText;
        EditText editText2;
        int paddingStart;
        int dimensionPixelSize;
        int paddingEnd;
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        int i3 = this.Kkkkkkkkkkkkkkkkk;
        if (i3 == 0) {
            this.Kkkkkkkkkkkkkkkkkkkkk = null;
        } else if (i3 == 1) {
            this.Kkkkkkkkkkkkkkkkkkkkk = new MaterialShapeDrawable(this.Kkkkkkkkkkkkkkkkkkk);
            this.Kkkkkkkkkkkkkkkkkkkk = new MaterialShapeDrawable();
            editText = this.Wwwwwwwwwwwwwwwwwwww;
            if (editText == null && this.Kkkkkkkkkkkkkkkkkkkkk != null && editText.getBackground() == null && this.Kkkkkkkkkkkkkkkkk != 0) {
                ViewCompat.setBackground(this.Wwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkk);
            }
            Wwwwwwwwwwwwwwww();
            if (this.Kkkkkkkkkkkkkkkkk == 1) {
                if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext())) {
                    resources2 = getResources();
                    i2 = R$dimen.material_font_2_0_box_collapsed_padding_top;
                } else if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext())) {
                    resources2 = getResources();
                    i2 = R$dimen.material_font_1_3_box_collapsed_padding_top;
                }
                this.Kkkkkkkkkkkkkkkk = resources2.getDimensionPixelSize(i2);
            }
            if (this.Wwwwwwwwwwwwwwwwwwww != null && this.Kkkkkkkkkkkkkkkkk == 1) {
                if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext())) {
                    editText2 = this.Wwwwwwwwwwwwwwwwwwww;
                    paddingStart = ViewCompat.getPaddingStart(editText2);
                    dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top);
                    paddingEnd = ViewCompat.getPaddingEnd(this.Wwwwwwwwwwwwwwwwwwww);
                    resources = getResources();
                    i = R$dimen.material_filled_edittext_font_2_0_padding_bottom;
                } else if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext())) {
                    editText2 = this.Wwwwwwwwwwwwwwwwwwww;
                    paddingStart = ViewCompat.getPaddingStart(editText2);
                    dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top);
                    paddingEnd = ViewCompat.getPaddingEnd(this.Wwwwwwwwwwwwwwwwwwww);
                    resources = getResources();
                    i = R$dimen.material_filled_edittext_font_1_3_padding_bottom;
                }
                ViewCompat.setPaddingRelative(editText2, paddingStart, dimensionPixelSize, paddingEnd, resources.getDimensionPixelSize(i));
            }
            if (this.Kkkkkkkkkkkkkkkkk != 0) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwww();
            return;
        } else if (i3 != 2) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.Kkkkkkkkkkkkkkkkk, " is illegal; only @BoxBackgroundMode constants are supported."));
        } else {
            this.Kkkkkkkkkkkkkkkkkkkkk = (!this.Kkkkkkkkkkkkkkkkkkkkkkkk || (this.Kkkkkkkkkkkkkkkkkkkkk instanceof C2534qr)) ? new MaterialShapeDrawable(this.Kkkkkkkkkkkkkkkkkkk) : new C2534qr(this.Kkkkkkkkkkkkkkkkkkk);
        }
        this.Kkkkkkkkkkkkkkkkkkkk = null;
        editText = this.Wwwwwwwwwwwwwwwwwwww;
        if (editText == null && this.Kkkkkkkkkkkkkkkkkkkkk != null && editText.getBackground() == null && this.Kkkkkkkkkkkkkkkkk != 0) {
        }
        Wwwwwwwwwwwwwwww();
        if (this.Kkkkkkkkkkkkkkkkk == 1) {
        }
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            if (!Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext())) {
            }
            ViewCompat.setPaddingRelative(editText2, paddingStart, dimensionPixelSize, paddingEnd, resources.getDimensionPixelSize(i));
        }
        if (this.Kkkkkkkkkkkkkkkkk != 0) {
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwww.getVisibility() == 0 && this.Illllllllllllllllllllll.getVisibility() == 0;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Illllllllllllllllllllllll != 0;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Kkkkkkkkkkkkkkkkkkkkkkkk && !TextUtils.isEmpty(this.Kkkkkkkkkkkkkkkkkkkkkkk) && (this.Kkkkkkkkkkkkkkkkkkkkk instanceof C2534qr);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (!this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
            return 0;
        }
        int i = this.Kkkkkkkkkkkkkkkkk;
        if (i == 0 || i == 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (i != 2) {
            return 0;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() / 2.0f;
        }
        return (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        int compoundPaddingRight = i - this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingRight();
        return (this.Wwww == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.Www.getMeasuredWidth() - this.Www.getPaddingRight());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllllllll, this.Illlllllllllllllllll, this.Illllllllllllllllllll, this.Illlllllllllllllll, this.Illllllllllllllllll);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i == 0 && !this.IIlllllll) {
            TextView textView = this.Wwwwwwwww;
            if (textView == null || !this.Wwwwwwwwww) {
                return;
            }
            textView.setText(this.Wwwwwwwwwww);
            this.Wwwwwwwww.setVisibility(0);
            this.Wwwwwwwww.bringToFront();
            return;
        }
        TextView textView2 = this.Wwwwwwwww;
        if (textView2 == null || !this.Wwwwwwwwww) {
            return;
        }
        textView2.setText((CharSequence) null);
        this.Wwwwwwwww.setVisibility(4);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
        int defaultColor = this.Illll.getDefaultColor();
        int colorForState = this.Illll.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.Illll.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.Kkkkkkkkkkkk = colorForState2;
        } else if (z2) {
            this.Kkkkkkkkkkkk = colorForState;
        } else {
            this.Kkkkkkkkkkkk = defaultColor;
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        int compoundPaddingLeft = this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingLeft() + i;
        return (this.Wwww == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.Www.getMeasuredWidth()) + this.Www.getPaddingLeft();
    }

    @VisibleForTesting
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == f) {
            return;
        }
        if (this.IIlll == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.IIlll = valueAnimator;
            valueAnimator.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.IIlll.setDuration(167L);
            this.IIlll.addUpdateListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        this.IIlll.setFloatValues(this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f);
        this.IIlll.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextView textView, @StyleRes int i) {
        boolean z = true;
        try {
            TextViewCompat.setTextAppearance(textView, i);
            if (Build.VERSION.SDK_INT >= 23) {
            }
            z = false;
        } catch (Exception unused) {
        }
        if (z) {
            TextViewCompat.setTextAppearance(textView, R$style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(ContextCompat.getColor(getContext(), R$color.design_error));
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z2) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Illlllllllllllllllllllllll.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.addView(view, layoutParams2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setLayoutParams(layoutParams);
        Wwwwwwwwwwwwwwwwwwwww();
        setEditText((EditText) view);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i) {
        EditText editText = this.Wwwwwwwwwwwwwwwwwwww;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwww != null) {
            boolean z = this.Kkkkkkkkkkkkkkkkkkkkkk;
            this.Kkkkkkkkkkkkkkkkkkkkkk = false;
            CharSequence hint = editText.getHint();
            this.Wwwwwwwwwwwwwwwwwwww.setHint(this.Wwwwwwwwwwwwwwwwwww);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.Wwwwwwwwwwwwwwwwwwww.setHint(hint);
                this.Kkkkkkkkkkkkkkkkkkkkkk = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.Wwwwwwwwwwwwwwwwwwwwwwww.getChildCount());
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwww.getChildCount(); i2++) {
            View childAt = this.Wwwwwwwwwwwwwwwwwwwwwwww.getChildAt(i2);
            ViewStructure newChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(newChild, i);
            if (childAt == this.Wwwwwwwwwwwwwwwwwwww) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.IIl = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.IIl = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
        }
        MaterialShapeDrawable materialShapeDrawable = this.Kkkkkkkkkkkkkkkkkkkk;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.Kkkkkkkkkkkkkkk;
            this.Kkkkkkkkkkkkkkkkkkkk.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.IIll) {
            return;
        }
        boolean z = true;
        this.IIll = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        C2156gp c2156gp = this.IIllllll;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2156gp != null ? c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(drawableState) | false : false;
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                z = false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, false);
        }
        Wwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            invalidate();
        }
        this.IIll = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.Wwwwwwwwwwwwwwwwwwww;
        if (editText != null) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + getPaddingTop() + editText.getBaseline();
        }
        return super.getBaseline();
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i = this.Kkkkkkkkkkkkkkkkk;
        if (i == 1 || i == 2) {
            return this.Kkkkkkkkkkkkkkkkkkkkk;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.Kkkkkkkkkkk;
    }

    public int getBoxBackgroundMode() {
        return this.Kkkkkkkkkkkkkkkkk;
    }

    public float getBoxCornerRadiusBottomEnd() {
        MaterialShapeDrawable materialShapeDrawable = this.Kkkkkkkkkkkkkkkkkkkkk;
        return materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public float getBoxCornerRadiusBottomStart() {
        MaterialShapeDrawable materialShapeDrawable = this.Kkkkkkkkkkkkkkkkkkkkk;
        return materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public float getBoxCornerRadiusTopEnd() {
        MaterialShapeDrawable materialShapeDrawable = this.Kkkkkkkkkkkkkkkkkkkkk;
        return materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public int getBoxStrokeColor() {
        return this.Illlll;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.Illll;
    }

    public int getBoxStrokeWidth() {
        return this.Kkkkkkkkkkkkkk;
    }

    public int getBoxStrokeWidthFocused() {
        return this.Kkkkkkkkkkkkk;
    }

    public int getCounterMaxLength() {
        return this.Wwwwwwwwwwwwwwww;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.Wwwwwwwwwwwwwwwww || !this.Wwwwwwwwwwwwwww || (textView = this.Wwwwwwwwwwwwww) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.Wwwwww;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.Wwwwww;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.Illlllllll;
    }

    @Nullable
    public EditText getEditText() {
        return this.Wwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.Illllllllllllllllllllll.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.Illllllllllllllllllllll.getDrawable();
    }

    public int getEndIconMode() {
        return this.Illllllllllllllllllllllll;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.Illllllllllllllllllllll;
    }

    @Nullable
    public CharSequence getError() {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        if (c2797xr.Wwwwwwwwwwwwwwwwwwwwwwww) {
            return c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.Illlllllllll.getDrawable();
    }

    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Nullable
    public CharSequence getHelperText() {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        if (c2797xr.Wwwwwwwwwwwwwwwwww) {
            return c2797xr.Wwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        TextView textView = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
            return this.Kkkkkkkkkkkkkkkkkkkkkkk;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.Illllllll;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.Illllllllllllllllllllll.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.Illllllllllllllllllllll.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.Wwwwwwwwww) {
            return this.Wwwwwwwwwww;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.Wwwwwww;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.Wwwwwwww;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.Wwww;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.Www.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.Www;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.Kkkkkk.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.Kkkkkk.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.Kkkkkkk;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0172  */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.Wwwwwwwwwwwwwwwwwwww;
        if (editText != null) {
            Rect rect = this.Kkkkkkkkkk;
            C2193hp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, editText, rect);
            MaterialShapeDrawable materialShapeDrawable = this.Kkkkkkkkkkkkkkkkkkkk;
            if (materialShapeDrawable != null) {
                int i7 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, i7 - this.Kkkkkkkkkkkkk, rect.right, i7);
            }
            if (!this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
                return;
            }
            C2156gp c2156gp = this.IIllllll;
            float textSize = this.Wwwwwwwwwwwwwwwwwwww.getTextSize();
            if (c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwww != textSize) {
                c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwww = textSize;
                c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            int gravity = this.Wwwwwwwwwwwwwwwwwwww.getGravity();
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((gravity & (-113)) | 48);
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gravity);
            C2156gp c2156gp2 = this.IIllllll;
            if (this.Wwwwwwwwwwwwwwwwwwww == null) {
                throw new IllegalStateException();
            }
            Rect rect2 = this.Kkkkkkkkk;
            boolean z2 = false;
            boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
            rect2.bottom = rect.bottom;
            int i8 = this.Kkkkkkkkkkkkkkkkk;
            if (i8 == 1) {
                rect2.left = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rect.left, z3);
                i5 = rect.top + this.Kkkkkkkkkkkkkkkk;
            } else if (i8 == 2) {
                rect2.left = this.Wwwwwwwwwwwwwwwwwwww.getPaddingLeft() + rect.left;
                rect2.top = rect.top - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                i6 = rect.right - this.Wwwwwwwwwwwwwwwwwwww.getPaddingRight();
                rect2.right = i6;
                if (c2156gp2 == null) {
                    int i9 = rect2.left;
                    int i10 = rect2.top;
                    int i11 = rect2.bottom;
                    if (!C2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i9, i10, i6, i11)) {
                        c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(i9, i10, i6, i11);
                        c2156gp2.Kkkkkkkkkkkkkkkkkkkkkkkkkk = true;
                        c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    C2156gp c2156gp3 = this.IIllllll;
                    if (this.Wwwwwwwwwwwwwwwwwwww != null) {
                        Rect rect3 = this.Kkkkkkkkk;
                        TextPaint textPaint = c2156gp3.Kkkkkkkkkkkkkkkkkkkkkkkk;
                        textPaint.setTextSize(c2156gp3.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                        textPaint.setTypeface(c2156gp3.Wwwwwwwwwwwwwww);
                        textPaint.setLetterSpacing(c2156gp3.Kkkkkkkkkkkk);
                        float f = -c2156gp3.Kkkkkkkkkkkkkkkkkkkkkkkk.ascent();
                        rect3.left = this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingLeft() + rect.left;
                        rect3.top = this.Kkkkkkkkkkkkkkkkk == 1 && this.Wwwwwwwwwwwwwwwwwwww.getMinLines() <= 1 ? (int) (rect.centerY() - (f / 2.0f)) : rect.top + this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingTop();
                        rect3.right = rect.right - this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingRight();
                        if (this.Kkkkkkkkkkkkkkkkk == 1 && this.Wwwwwwwwwwwwwwwwwwww.getMinLines() <= 1) {
                            z2 = true;
                        }
                        int compoundPaddingBottom = z2 ? (int) (rect3.top + f) : rect.bottom - this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingBottom();
                        rect3.bottom = compoundPaddingBottom;
                        int i12 = rect3.left;
                        int i13 = rect3.top;
                        int i14 = rect3.right;
                        if (!C2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2156gp3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i12, i13, i14, compoundPaddingBottom)) {
                            c2156gp3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(i12, i13, i14, compoundPaddingBottom);
                            c2156gp3.Kkkkkkkkkkkkkkkkkkkkkkkkkk = true;
                            c2156gp3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                        this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || this.IIlllllll) {
                            return;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                    throw new IllegalStateException();
                }
                throw null;
            } else {
                rect2.left = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rect.left, z3);
                i5 = getPaddingTop();
            }
            rect2.top = i5;
            i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rect.right, z3);
            rect2.right = i6;
            if (c2156gp2 == null) {
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        EditText editText;
        int max;
        super.onMeasure(i, i2);
        boolean z = false;
        if (this.Wwwwwwwwwwwwwwwwwwww != null && this.Wwwwwwwwwwwwwwwwwwww.getMeasuredHeight() < (max = Math.max(this.Wwwwwwwwwwwwwwwwwwwwww.getMeasuredHeight(), this.Wwwwwwwwwwwwwwwwwwwwwww.getMeasuredHeight()))) {
            this.Wwwwwwwwwwwwwwwwwwww.setMinimumHeight(max);
            z = true;
        }
        boolean Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwww();
        if (z || Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww.post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        if (this.Wwwwwwwww != null && (editText = this.Wwwwwwwwwwwwwwwwwwww) != null) {
            this.Wwwwwwwww.setGravity(editText.getGravity());
            this.Wwwwwwwww.setPadding(this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingLeft(), this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingTop(), this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingRight(), this.Wwwwwwwwwwwwwwwwwwww.getCompoundPaddingBottom());
        }
        Wwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwww();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwww) parcelable;
        super.onRestoreInstanceState(wwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuperState());
        setError(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Illllllllllllllllllllll.post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        setHint(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww);
        setHelperText(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww);
        setPlaceholderText(wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(super.onSaveInstanceState());
        if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = getError();
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Illllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = getHint();
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = getHelperText();
        wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = getPlaceholderText();
        return wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setBoxBackgroundColor(@ColorInt int i) {
        if (this.Kkkkkkkkkkk != i) {
            this.Kkkkkkkkkkk = i;
            this.Illl = i;
            this.f579Il = i;
            this.IIlllllllll = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.Illl = defaultColor;
        this.Kkkkkkkkkkk = defaultColor;
        this.Ill = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f579Il = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.IIlllllllll = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.Kkkkkkkkkkkkkkkkk) {
            return;
        }
        this.Kkkkkkkkkkkkkkkkk = i;
        if (this.Wwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setBoxStrokeColor(@ColorInt int i) {
        if (this.Illlll != i) {
            this.Illlll = i;
            Wwwwwwwwwwwwwwww();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor;
        if (!colorStateList.isStateful()) {
            if (this.Illlll != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            Wwwwwwwwwwwwwwww();
        }
        this.Illlllll = colorStateList.getDefaultColor();
        this.IIllllllll = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.Illllll = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.Illlll = defaultColor;
        Wwwwwwwwwwwwwwww();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.Illll != colorStateList) {
            this.Illll = colorStateList;
            Wwwwwwwwwwwwwwww();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.Kkkkkkkkkkkkkk = i;
        Wwwwwwwwwwwwwwww();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.Kkkkkkkkkkkkk = i;
        Wwwwwwwwwwwwwwww();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.Wwwwwwwwwwwwwwwww != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.Wwwwwwwwwwwwww = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.Kkkkkkk;
                if (typeface != null) {
                    this.Wwwwwwwwwwwwww.setTypeface(typeface);
                }
                this.Wwwwwwwwwwwwww.setMaxLines(1);
                this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwww, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.Wwwwwwwwwwwwww.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                Wwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwww, 2);
                this.Wwwwwwwwwwwwww = null;
            }
            this.Wwwwwwwwwwwwwwwww = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.Wwwwwwwwwwwwwwww != i) {
            if (i <= 0) {
                i = -1;
            }
            this.Wwwwwwwwwwwwwwww = i;
            if (!this.Wwwwwwwwwwwwwwwww) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.Wwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.Wwwww != colorStateList) {
            this.Wwwww = colorStateList;
            Wwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.Wwwwwwwwwwww != i) {
            this.Wwwwwwwwwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwww != colorStateList) {
            this.Wwwwww = colorStateList;
            Wwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.Illlllllll = colorStateList;
        this.Illllllll = colorStateList;
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.Illllllllllllllllllllll.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.Illllllllllllllllllllll.setCheckable(z);
    }

    public void setEndIconContentDescription(@StringRes int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.Illllllllllllllllllllll.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@DrawableRes int i) {
        setEndIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.Illllllllllllllllllllll.setImageDrawable(drawable);
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setEndIconMode(int i) {
        int i2 = this.Illllllllllllllllllllllll;
        this.Illllllllllllllllllllllll = i;
        Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Illlllllllllllllllllll.iterator();
        while (it.hasNext()) {
            it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i2);
        }
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkk)) {
            getEndIconDelegate().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The current box background mode ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Kkkkkkkkkkkkkkkkk);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" is not supported by the end icon mode ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(i);
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.Illllllllllllllllllllll;
        View.OnLongClickListener onLongClickListener = this.Illlllllllllll;
        checkableImageButton.setOnClickListener(onClickListener);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.Illlllllllllll = onLongClickListener;
        CheckableImageButton checkableImageButton = this.Illllllllllllllllllllll;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.Illllllllllllllllllll != colorStateList) {
            this.Illllllllllllllllllll = colorStateList;
            this.Illlllllllllllllllll = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.Illllllllllllllllll != mode) {
            this.Illllllllllllllllll = mode;
            this.Illlllllllllllllll = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() != z) {
            this.Illllllllllllllllllllll.setVisibility(z ? 0 : 8);
            Wwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwww.setText(charSequence);
            if (c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            }
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwww, c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwwwwwwwww, charSequence));
            return;
        }
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        c2797xr.Wwwwwwwwwwwwwwwwwwwwww = charSequence;
        TextView textView = c2797xr.Wwwwwwwwwwwwwwwwwwwwwww;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        if (c2797xr.Wwwwwwwwwwwwwwwwwwwwwwww == z) {
            return;
        }
        c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwww = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwww.setTextAlignment(5);
            Typeface typeface = c2797xr.Wwwwwwwwwwwwww;
            if (typeface != null) {
                c2797xr.Wwwwwwwwwwwwwwwwwwwwwww.setTypeface(typeface);
            }
            int i = c2797xr.Wwwwwwwwwwwwwwwwwwwww;
            c2797xr.Wwwwwwwwwwwwwwwwwwwww = i;
            TextView textView = c2797xr.Wwwwwwwwwwwwwwwwwwwwwww;
            if (textView != null) {
                c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textView, i);
            }
            ColorStateList colorStateList = c2797xr.Wwwwwwwwwwwwwwwwwwww;
            c2797xr.Wwwwwwwwwwwwwwwwwwww = colorStateList;
            TextView textView2 = c2797xr.Wwwwwwwwwwwwwwwwwwwwwww;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            CharSequence charSequence = c2797xr.Wwwwwwwwwwwwwwwwwwwwww;
            c2797xr.Wwwwwwwwwwwwwwwwwwwwww = charSequence;
            TextView textView3 = c2797xr.Wwwwwwwwwwwwwwwwwwwwwww;
            if (textView3 != null) {
                textView3.setContentDescription(charSequence);
            }
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwww.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(c2797xr.Wwwwwwwwwwwwwwwwwwwwwww, 1);
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwwwwwwwww, 0);
        } else {
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwwwwwwwww, 0);
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwww = null;
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww();
        }
        c2797xr.Wwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public void setErrorIconDrawable(@DrawableRes int i) {
        setErrorIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illlllllllll, this.Illllllllll);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.Illlllllllll;
        View.OnLongClickListener onLongClickListener = this.Illllllllllll;
        checkableImageButton.setOnClickListener(onClickListener);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.Illllllllllll = onLongClickListener;
        CheckableImageButton checkableImageButton = this.Illlllllllll;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.Illllllllll = colorStateList;
        Drawable drawable = this.Illlllllllll.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.Illlllllllll.getDrawable() != drawable) {
            this.Illlllllllll.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.Illlllllllll.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.Illlllllllll.getDrawable() != drawable) {
            this.Illlllllllll.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i) {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        c2797xr.Wwwwwwwwwwwwwwwwwwwww = i;
        TextView textView = c2797xr.Wwwwwwwwwwwwwwwwwwwwwww;
        if (textView != null) {
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textView, i);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        c2797xr.Wwwwwwwwwwwwwwwwwwww = colorStateList;
        TextView textView = c2797xr.Wwwwwwwwwwwwwwwwwwwwwww;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.IIlllll != z) {
            this.IIlllll = z;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (!this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            setHelperTextEnabled(false);
            return;
        }
        if (!this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww) {
            setHelperTextEnabled(true);
        }
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        c2797xr.Wwwwwwwwwwwwwwwwwww = charSequence;
        c2797xr.Wwwwwwwwwwwwwwwww.setText(charSequence);
        if (c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwww != 2) {
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwww = 2;
        }
        c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwww, c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwww, charSequence));
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        c2797xr.Wwwwwwwwwwwwwww = colorStateList;
        TextView textView = c2797xr.Wwwwwwwwwwwwwwwww;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        if (c2797xr.Wwwwwwwwwwwwwwwwww == z) {
            return;
        }
        c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c2797xr.Wwwwwwwwwwwwwwwww = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            c2797xr.Wwwwwwwwwwwwwwwww.setTextAlignment(5);
            Typeface typeface = c2797xr.Wwwwwwwwwwwwww;
            if (typeface != null) {
                c2797xr.Wwwwwwwwwwwwwwwww.setTypeface(typeface);
            }
            c2797xr.Wwwwwwwwwwwwwwwww.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(c2797xr.Wwwwwwwwwwwwwwwww, 1);
            int i = c2797xr.Wwwwwwwwwwwwwwww;
            c2797xr.Wwwwwwwwwwwwwwww = i;
            TextView textView = c2797xr.Wwwwwwwwwwwwwwwww;
            if (textView != null) {
                TextViewCompat.setTextAppearance(textView, i);
            }
            ColorStateList colorStateList = c2797xr.Wwwwwwwwwwwwwww;
            c2797xr.Wwwwwwwwwwwwwww = colorStateList;
            TextView textView2 = c2797xr.Wwwwwwwwwwwwwwwww;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwww, 1);
        } else {
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            }
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwww, c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwww, (CharSequence) null));
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2797xr.Wwwwwwwwwwwwwwwww, 1);
            c2797xr.Wwwwwwwwwwwwwwwww = null;
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            c2797xr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww();
        }
        c2797xr.Wwwwwwwwwwwwwwwwww = z;
    }

    public void setHelperTextTextAppearance(@StyleRes int i) {
        C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
        c2797xr.Wwwwwwwwwwwwwwww = i;
        TextView textView = c2797xr.Wwwwwwwwwwwwwwwww;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i);
        }
    }

    public void setHint(@StringRes int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.IIllll = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = z;
            if (!z) {
                this.Kkkkkkkkkkkkkkkkkkkkkk = false;
                if (!TextUtils.isEmpty(this.Kkkkkkkkkkkkkkkkkkkkkkk) && TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwww.getHint())) {
                    this.Wwwwwwwwwwwwwwwwwwww.setHint(this.Kkkkkkkkkkkkkkkkkkkkkkk);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.Wwwwwwwwwwwwwwwwwwww.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.Kkkkkkkkkkkkkkkkkkkkkkk)) {
                        setHint(hint);
                    }
                    this.Wwwwwwwwwwwwwwwwwwww.setHint((CharSequence) null);
                }
                this.Kkkkkkkkkkkkkkkkkkkkkk = true;
            }
            if (this.Wwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setHintTextAppearance(@StyleRes int i) {
        this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.Illllllll = this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
            Wwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.Illllllll != colorStateList) {
            if (this.Illlllllll == null) {
                C2156gp c2156gp = this.IIllllll;
                if (c2156gp.Wwwwwwwwwwwwwwwwwwwwwww != colorStateList) {
                    c2156gp.Wwwwwwwwwwwwwwwwwwwwwww = colorStateList;
                    c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            this.Illllllll = colorStateList;
            if (this.Wwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.Illllllllllllllllllllll.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.Illllllllllllllllllllll.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.Illllllllllllllllllllllll != 1) {
            setEndIconMode(1);
        } else if (z) {
        } else {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.Illllllllllllllllllll = colorStateList;
        this.Illlllllllllllllllll = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.Illllllllllllllllll = mode;
        this.Illlllllllllllllll = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        int i = 0;
        if (!this.Wwwwwwwwww || !TextUtils.isEmpty(charSequence)) {
            if (!this.Wwwwwwwwww) {
                setPlaceholderTextEnabled(true);
            }
            this.Wwwwwwwwwww = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        EditText editText = this.Wwwwwwwwwwwwwwwwwwww;
        if (editText != null) {
            i = editText.getText().length();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public void setPlaceholderTextAppearance(@StyleRes int i) {
        this.Wwwwwww = i;
        TextView textView = this.Wwwwwwwww;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwww != colorStateList) {
            this.Wwwwwwww = colorStateList;
            TextView textView = this.Wwwwwwwww;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.Wwww = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.Www.setText(charSequence);
        Wwwwwwwwwwwwwwwwwww();
    }

    public void setPrefixTextAppearance(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.Www, i);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.Www.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.Kkkkkk.setCheckable(z);
    }

    public void setStartIconContentDescription(@StringRes int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.Kkkkkk.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@DrawableRes int i) {
        setStartIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.Kkkkkk.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkk, this.Kkkkk);
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.Kkkkkk;
        View.OnLongClickListener onLongClickListener = this.Illllllllllllllllllllllllll;
        checkableImageButton.setOnClickListener(onClickListener);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.Illllllllllllllllllllllllll = onLongClickListener;
        CheckableImageButton checkableImageButton = this.Kkkkkk;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.Kkkkk != colorStateList) {
            this.Kkkkk = colorStateList;
            this.Kkkk = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkk, true, colorStateList, this.f580Kk, this.Kkk);
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.Kkk != mode) {
            this.Kkk = mode;
            this.f580Kk = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkk, this.Kkkk, this.Kkkkk, true, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        int i = 0;
        if ((this.Kkkkkk.getVisibility() == 0) != z) {
            CheckableImageButton checkableImageButton = this.Kkkkkk;
            if (!z) {
                i = 8;
            }
            checkableImageButton.setVisibility(i);
            Wwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setText(charSequence);
        Wwwwwwwwwwwwwwwww();
    }

    public void setSuffixTextAppearance(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.Kkkkkkkkkkkkkkkkkkkkkkkkk, i);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.Wwwwwwwwwwwwwwwwwwww;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.Kkkkkkk) {
            this.Kkkkkkk = typeface;
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(typeface);
            C2797xr c2797xr = this.Wwwwwwwwwwwwwwwwww;
            if (typeface != c2797xr.Wwwwwwwwwwwwww) {
                c2797xr.Wwwwwwwwwwwwww = typeface;
                TextView textView = c2797xr.Wwwwwwwwwwwwwwwwwwwwwww;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = c2797xr.Wwwwwwwwwwwwwwwww;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.Wwwwwwwwwwwwww;
            if (textView3 == null) {
                return;
            }
            textView3.setTypeface(typeface);
        }
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.Illlllllllll.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z;
        MaterialShapeDrawable materialShapeDrawable = this.Kkkkkkkkkkkkkkkkkkkkk;
        if (materialShapeDrawable == null) {
            return;
        }
        materialShapeDrawable.setShapeAppearanceModel(this.Kkkkkkkkkkkkkkkkkkk);
        boolean z2 = false;
        if (this.Kkkkkkkkkkkkkkkkk == 2) {
            if (this.Kkkkkkkkkkkkkkk > -1 && this.Kkkkkkkkkkkk != 0) {
                z = true;
                if (z) {
                    this.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkk, this.Kkkkkkkkkkkk);
                }
                int i = this.Kkkkkkkkkkk;
                if (this.Kkkkkkkkkkkkkkkkk == 1) {
                    i = ColorUtils.compositeColors(this.Kkkkkkkkkkk, Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), R$attr.colorSurface, 0));
                }
                this.Kkkkkkkkkkk = i;
                this.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(i));
                if (this.Illllllllllllllllllllllll == 3) {
                    this.Wwwwwwwwwwwwwwwwwwww.getBackground().invalidateSelf();
                }
                if (this.Kkkkkkkkkkkkkkkkkkkk != null) {
                    if (this.Kkkkkkkkkkkkkkk > -1 && this.Kkkkkkkkkkkk != 0) {
                        z2 = true;
                    }
                    if (z2) {
                        this.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(this.Kkkkkkkkkkkk));
                    }
                    invalidate();
                }
                invalidate();
            }
        }
        z = false;
        if (z) {
        }
        int i2 = this.Kkkkkkkkkkk;
        if (this.Kkkkkkkkkkkkkkkkk == 1) {
        }
        this.Kkkkkkkkkkk = i2;
        this.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(i2));
        if (this.Illllllllllllllllllllllll == 3) {
        }
        if (this.Kkkkkkkkkkkkkkkkkkkk != null) {
        }
        invalidate();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = this.Wwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwww;
        if (i2 == -1) {
            this.Wwwwwwwwwwwwww.setText(String.valueOf(i));
            this.Wwwwwwwwwwwwww.setContentDescription(null);
            this.Wwwwwwwwwwwwwww = false;
        } else {
            this.Wwwwwwwwwwwwwww = i > i2;
            Context context = getContext();
            this.Wwwwwwwwwwwwww.setContentDescription(context.getString(this.Wwwwwwwwwwwwwww ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.Wwwwwwwwwwwwwwww)));
            if (z != this.Wwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwwwwwwwwww.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.Wwwwwwwwwwwwwwww))));
        }
        if (this.Wwwwwwwwwwwwwwwwwwww == null || z == this.Wwwwwwwwwwwwwww) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
        Wwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
        ColorStateList colorStateList;
        C2156gp c2156gp;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.Wwwwwwwwwwwwwwwwwwww;
        int i = 0;
        boolean z3 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.Wwwwwwwwwwwwwwwwwwww;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ColorStateList colorStateList2 = this.Illlllllll;
        if (colorStateList2 != null) {
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList2);
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illlllllll);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.Illlllllll;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.IIllllllll) : this.IIllllllll;
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(colorForState));
            this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(colorForState));
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            C2156gp c2156gp2 = this.IIllllll;
            TextView textView2 = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            c2156gp2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textView2 != null ? textView2.getTextColors() : null);
        } else {
            if (this.Wwwwwwwwwwwwwww && (textView = this.Wwwwwwwwwwwwww) != null) {
                c2156gp = this.IIllllll;
                colorStateList = textView.getTextColors();
            } else if (z4 && (colorStateList = this.Illllllll) != null) {
                c2156gp = this.IIllllll;
            }
            c2156gp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
        }
        if (z3 || !this.IIlllll || (isEnabled() && z4)) {
            if (!z2 && !this.IIlllllll) {
                return;
            }
            ValueAnimator valueAnimator = this.IIlll;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.IIlll.cancel();
            }
            if (!z || !this.IIllll) {
                this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0f);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0f);
            }
            this.IIlllllll = false;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            EditText editText3 = this.Wwwwwwwwwwwwwwwwwwww;
            if (editText3 != null) {
                i = editText3.getText().length();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            Wwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwww();
        } else if (!z2 && this.IIlllllll) {
        } else {
            ValueAnimator valueAnimator2 = this.IIlll;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.IIlll.cancel();
            }
            if (!z || !this.IIllll) {
                this.IIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f);
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && (!((C2534qr) this.Kkkkkkkkkkkkkkkkkkkkk).Kkkkkkkkkkkkkkkkkkkkkkk.isEmpty()) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                ((C2534qr) this.Kkkkkkkkkkkkkkkkkkkkk).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.IIlllllll = true;
            TextView textView3 = this.Wwwwwwwww;
            if (textView3 != null && this.Wwwwwwwwww) {
                textView3.setText((CharSequence) null);
                this.Wwwwwwwww.setVisibility(4);
            }
            Wwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwww();
        }
    }
}
