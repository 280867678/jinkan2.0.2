package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes3.dex */
public class BottomSheetDialog extends AppCompatDialog {
    @NonNull
    public BottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public FrameLayout Wwwwwwwwwwwwwwwwwwwwwww;
    public BottomSheetBehavior<FrameLayout> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends BottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, int i) {
            if (i == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnTouchListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BottomSheetDialog bottomSheetDialog) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AccessibilityDelegateCompat {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (BottomSheetDialog.this.Wwwwwwwwwwwwwwwwwwwwww) {
                accessibilityNodeInfoCompat.addAction(1048576);
                z = true;
            } else {
                z = false;
            }
            accessibilityNodeInfoCompat.setDismissable(z);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.Wwwwwwwwwwwwwwwwwwwwww) {
                    bottomSheetDialog.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
            if (!bottomSheetDialog.Wwwwwwwwwwwwwwwwwwwwww || !bottomSheetDialog.isShowing()) {
                return;
            }
            BottomSheetDialog bottomSheetDialog2 = BottomSheetDialog.this;
            if (!bottomSheetDialog2.Wwwwwwwwwwwwwwwwwwww) {
                TypedArray obtainStyledAttributes = bottomSheetDialog2.getContext().obtainStyledAttributes(new int[]{16843611});
                bottomSheetDialog2.Wwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
                bottomSheetDialog2.Wwwwwwwwwwwwwwwwwwww = true;
            }
            if (!bottomSheetDialog2.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            BottomSheetDialog.this.cancel();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BottomSheetDialog(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            i = context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        supportRequestWindowFeature(1);
    }

    public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.Wwwwwwwwwwwwwwwwwwwwwww.findViewById(R$id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.Wwwwwwwwwwwwwwwwwwwwwww.findViewById(R$id.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        ViewCompat.setAccessibilityDelegate(frameLayout, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        frameLayout.setOnTouchListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public final FrameLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.Wwwwwwwwwwwwwwwwwwwwwww = frameLayout;
            BottomSheetBehavior<FrameLayout> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = BottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((FrameLayout) frameLayout.findViewById(R$id.design_bottom_sheet));
            this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            BottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkkkkkkkk.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Kkkkkkkkkkkkkkkkkkkkkkk.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        super.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (bottomSheetBehavior == null || bottomSheetBehavior.Wwwwwwwww != 5) {
            return;
        }
        bottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.Wwwwwwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwwwwwww = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (bottomSheetBehavior == null) {
                return;
            }
            bottomSheetBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.Wwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i) {
        super.setContentView(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, view, layoutParams));
    }
}
