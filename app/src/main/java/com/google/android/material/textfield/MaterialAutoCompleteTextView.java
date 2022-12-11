package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.Locale;
import me.tvspark.C1957bs;
import me.tvspark.C2415np;
import me.tvspark.C2834yr;

/* loaded from: classes3.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    @NonNull
    public final Rect Wwwwwwwwwwwwwwwwwwwwww = new Rect();
    @Nullable
    public final AccessibilityManager Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final ListPopupWindow Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, r3, 0), attributeSet, r3);
        int i = R$attr.autoCompleteTextViewStyle;
        Context context2 = getContext();
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasValue(R$styleable.MaterialAutoCompleteTextView_android_inputType) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getInt(R$styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = listPopupWindow;
        listPopupWindow.setModal(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setAnchorView(this);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setInputMethodMode(2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setAdapter(getAdapter());
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setOnItemClickListener(new C2834yr(this));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.recycle();
    }

    @Nullable
    public final TextInputLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkk) ? super.getHint() : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkk || super.getHint() != null || !Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            return;
        }
        setHint("");
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i3 = 0;
            if (adapter != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                int min = Math.min(adapter.getCount(), Math.max(0, this.Wwwwwwwwwwwwwwwwwwwwwwww.getSelectedItemPosition()) + 15);
                View view = null;
                int i4 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i3) {
                        view = null;
                        i3 = itemViewType;
                    }
                    view = adapter.getView(max, view, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i4 = Math.max(i4, view.getMeasuredWidth());
                }
                Drawable background = this.Wwwwwwwwwwwwwwwwwwwwwwww.getBackground();
                if (background != null) {
                    background.getPadding(this.Wwwwwwwwwwwwwwwwwwwwww);
                    Rect rect = this.Wwwwwwwwwwwwwwwwwwwwww;
                    i4 += rect.left + rect.right;
                }
                i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEndIconView().getMeasuredWidth() + i4;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i3), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t) {
        super.setAdapter(t);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.show();
        }
    }
}
