package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.Locale;
import me.tvspark.C1957bs;
import me.tvspark.C2415np;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class TextInputEditText extends AppCompatEditText {
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final Rect Wwwwwwwwwwwwwwwwwwwwwwww;

    public TextInputEditText(@NonNull Context context) {
        this(context, null);
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, 0), attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new Rect();
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, R$styleable.TextInputEditText, i, R$style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBoolean(R$styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.recycle();
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !this.Wwwwwwwwwwwwwwwwwwwwwww || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        rect.bottom = this.Wwwwwwwwwwwwwwwwwwwwwwww.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect rect, @Nullable Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.Wwwwwwwwwwwwwwwwwwwwwww && rect != null) {
            textInputLayout.getGlobalVisibleRect(this.Wwwwwwwwwwwwwwwwwwwwwwww, point);
            rect.bottom = this.Wwwwwwwwwwwwwwwwwwwwwwww.bottom;
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.Kkkkkkkkkkkkkkkkkkkkkk) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !textInputLayout.Kkkkkkkkkkkkkkkkkkkkkk || super.getHint() != null || !Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            return;
        }
        setHint("");
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
            return;
        }
        Editable mo4278getText = mo4278getText();
        CharSequence hint = textInputLayout.getHint();
        boolean z = !TextUtils.isEmpty(mo4278getText);
        boolean z2 = !TextUtils.isEmpty(hint);
        setLabelFor(R$id.textinput_helper_text);
        String str = "";
        String charSequence = z2 ? hint.toString() : str;
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) mo4278getText);
            if (!TextUtils.isEmpty(charSequence)) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(", ", charSequence);
            }
            sb.append(str);
            str = sb.toString();
        } else if (!TextUtils.isEmpty(charSequence)) {
            str = charSequence;
        }
        accessibilityNodeInfo.setText(str);
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect rect) {
        boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R$dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.Wwwwwwwwwwwwwwwwwwwwwwww, true);
        }
        return requestRectangleOnScreen;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = z;
    }
}
