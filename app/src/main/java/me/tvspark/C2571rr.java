package me.tvspark;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.TextInputLayout;
import me.tvspark.C2416nq;

/* renamed from: me.tvspark.rr */
/* loaded from: classes4.dex */
public class C2571rr extends AbstractC2760wr {
    public ValueAnimator Wwwwwwwwwwwwwwwwwww;
    public ValueAnimator Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AccessibilityManager Wwwwwwwwwwwwwwwwwwwww;
    public MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwww;
    public StateListDrawable Wwwwwwwwwwwwwwwwwwwwwww;
    public final TextWatcher Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final View.OnFocusChangeListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final TextInputLayout.AccessibilityDelegate Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    public final TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwww = false;
    public long Wwwwwwwwwwwwwwwwwwwwwwww = Long.MAX_VALUE;

    /* renamed from: me.tvspark.rr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr.this, (AutoCompleteTextView) C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText());
        }
    }

    /* renamed from: me.tvspark.rr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {

        /* renamed from: me.tvspark.rr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ AutoCompleteTextView Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AutoCompleteTextView autoCompleteTextView) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.removeTextChangedListener(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i != 3) {
                return;
            }
            autoCompleteTextView.post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            autoCompleteTextView.setOnDismissListener(null);
        }
    }

    /* renamed from: me.tvspark.rr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
        @Override // com.google.android.material.textfield.TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextInputLayout textInputLayout) {
            Drawable drawable;
            C2571rr c2571rr;
            AutoCompleteTextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textInputLayout.getEditText());
            C2571rr c2571rr2 = C2571rr.this;
            int boxBackgroundMode = c2571rr2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBoxBackgroundMode();
            if (boxBackgroundMode != 2) {
                if (boxBackgroundMode == 1) {
                    drawable = c2571rr2.Wwwwwwwwwwwwwwwwwwwwwww;
                }
                c2571rr = C2571rr.this;
                if (c2571rr == null) {
                    boolean z = false;
                    if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getKeyListener() != null)) {
                        int boxBackgroundMode2 = c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBoxBackgroundMode();
                        MaterialShapeDrawable boxBackground = c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBoxBackground();
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$attr.colorControlHighlight);
                        int[][] iArr = {new int[]{16842919}, new int[0]};
                        if (boxBackgroundMode2 == 2) {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$attr.colorSurface);
                            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 0.1f);
                            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ColorStateList(iArr, new int[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, 0}));
                            materialShapeDrawable.setTint(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3});
                            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            materialShapeDrawable2.setTint(-1);
                            ViewCompat.setBackground(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
                        } else if (boxBackgroundMode2 == 1) {
                            int boxBackgroundColor = c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBoxBackgroundColor();
                            ViewCompat.setBackground(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new RippleDrawable(new ColorStateList(iArr, new int[]{Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                        }
                    }
                    C2571rr c2571rr3 = C2571rr.this;
                    if (c2571rr3 != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnTouchListener(new View$OnTouchListenerC2645tr(c2571rr3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnFocusChangeListener(c2571rr3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnDismissListener(new C2682ur(c2571rr3));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setThreshold(0);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeTextChangedListener(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addTextChangedListener(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        textInputLayout.setEndIconCheckable(true);
                        textInputLayout.setErrorIconDrawable((Drawable) null);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getKeyListener() != null) {
                            z = true;
                        }
                        if (!z) {
                            ViewCompat.setImportantForAccessibility(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 2);
                        }
                        textInputLayout.setTextInputAccessibilityDelegate(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        textInputLayout.setEndIconVisible(true);
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            drawable = c2571rr2.Wwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setDropDownBackgroundDrawable(drawable);
            c2571rr = C2571rr.this;
            if (c2571rr == null) {
            }
        }
    }

    /* renamed from: me.tvspark.rr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends TextInputLayout.AccessibilityDelegate {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText());
            if (accessibilityEvent.getEventType() != 1 || !C2571rr.this.Wwwwwwwwwwwwwwwwwwwww.isTouchExplorationEnabled() || C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText())) {
                return;
            }
            C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr.this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.rr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnFocusChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setEndIconActivated(z);
            if (!z) {
                C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr.this, false);
                C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
        }
    }

    /* renamed from: me.tvspark.rr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2378mp {

        /* renamed from: me.tvspark.rr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC3490Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ AutoCompleteTextView Wwwwwwwwwwwwwwwwwwwwwwww;

            public RunnableC3490Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AutoCompleteTextView autoCompleteTextView) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.Wwwwwwwwwwwwwwwwwwwwwwww.isPopupShowing();
                C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr.this, isPopupShowing);
                C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwww = isPopupShowing;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.C2378mp, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText());
            if (C2571rr.this.Wwwwwwwwwwwwwwwwwwwww.isTouchExplorationEnabled() && C2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !C2571rr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasFocus()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dismissDropDown();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.post(new RunnableC3490Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    public C2571rr(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static /* synthetic */ AutoCompleteTextView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long currentTimeMillis = System.currentTimeMillis() - this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    @Override // me.tvspark.AbstractC2760wr
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.AbstractC2760wr
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i != 0;
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr c2571rr, boolean z) {
        if (c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwww != z) {
            c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwww = z;
            c2571rr.Wwwwwwwwwwwwwwwwwww.cancel();
            c2571rr.Wwwwwwwwwwwwwwwwwwww.start();
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2571rr c2571rr, AutoCompleteTextView autoCompleteTextView) {
        if (c2571rr != null) {
            if (autoCompleteTextView == null) {
                return;
            }
            if (c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
            if (c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
                return;
            }
            boolean z = c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z2 = !z;
            if (z != z2) {
                c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwww = z2;
                c2571rr.Wwwwwwwwwwwwwwwwwww.cancel();
                c2571rr.Wwwwwwwwwwwwwwwwwwww.start();
            }
            if (!c2571rr.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                autoCompleteTextView.dismissDropDown();
                return;
            }
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
            return;
        }
        throw null;
    }

    public final MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, int i) {
        C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f2);
        C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.invalidateSelf();
        MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww.set(0, i, 0, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.invalidateSelf();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
    }

    @Override // me.tvspark.AbstractC2760wr
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        float dimensionPixelOffset = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelOffset(com.google.android.material.R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelOffset(com.google.android.material.R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getResources().getDimensionPixelOffset(com.google.android.material.R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.Wwwwwwwwwwwwwwwwwwwwwww = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.Wwwwwwwwwwwwwwwwwwwwwww.addState(new int[0], Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setEndIconDrawable(AppCompatResources.getDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(com.google.android.material.R$string.exposed_dropdown_menu_content_description));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setEndIconOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Illlllllllllllllllllll.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ofFloat.setDuration(67);
        ofFloat.addUpdateListener(new C2608sr(this));
        this.Wwwwwwwwwwwwwwwwwww = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ofFloat2.setDuration(50);
        ofFloat2.addUpdateListener(new C2608sr(this));
        this.Wwwwwwwwwwwwwwwwwwww = ofFloat2;
        ofFloat2.addListener(new C2723vr(this));
        this.Wwwwwwwwwwwwwwwwwwwww = (AccessibilityManager) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSystemService("accessibility");
    }
}
