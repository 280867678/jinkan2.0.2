package me.tvspark;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;

/* renamed from: me.tvspark.js */
/* loaded from: classes4.dex */
public class C2270js implements TimePickerView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2196hs {
    public MaterialButtonToggleGroup Wwwwwwwwwwwwwww;
    public final EditText Wwwwwwwwwwwwwwww;
    public final EditText Wwwwwwwwwwwwwwwww;
    public final View$OnKeyListenerC2233is Wwwwwwwwwwwwwwwwww;
    public final ChipTextInputComboView Wwwwwwwwwwwwwwwwwww;
    public final ChipTextInputComboView Wwwwwwwwwwwwwwwwwwww;
    public final C2122fs Wwwwwwwwwwwwwwwwwwwwwww;
    public final LinearLayout Wwwwwwwwwwwwwwwwwwwwwwww;
    public final TextWatcher Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final TextWatcher Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.js$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2270js.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) view.getTag(com.google.android.material.R$id.selection_type)).intValue());
        }
    }

    /* renamed from: me.tvspark.js$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2378mp {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.C2378mp, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    C2270js.this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    return;
                }
                C2270js.this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* renamed from: me.tvspark.js$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2378mp {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.C2378mp, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    C2122fs c2122fs = C2270js.this.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (c2122fs == null) {
                        throw null;
                    }
                    c2122fs.Wwwwwwwwwwwwwwwwwwww = 0;
                    return;
                }
                int parseInt = Integer.parseInt(editable.toString());
                C2122fs c2122fs2 = C2270js.this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (c2122fs2 == null) {
                    throw null;
                }
                c2122fs2.Wwwwwwwwwwwwwwwwwwww = parseInt % 60;
            } catch (NumberFormatException unused) {
            }
        }
    }

    public C2270js(LinearLayout linearLayout, C2122fs c2122fs) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = linearLayout;
        this.Wwwwwwwwwwwwwwwwwwwwwww = c2122fs;
        Resources resources = linearLayout.getResources();
        this.Wwwwwwwwwwwwwwwwwwww = (ChipTextInputComboView) linearLayout.findViewById(com.google.android.material.R$id.material_minute_text_input);
        this.Wwwwwwwwwwwwwwwwwww = (ChipTextInputComboView) linearLayout.findViewById(com.google.android.material.R$id.material_hour_text_input);
        ((TextView) this.Wwwwwwwwwwwwwwwwwwww.findViewById(com.google.android.material.R$id.material_label)).setText(resources.getString(com.google.android.material.R$string.material_timepicker_minute));
        ((TextView) this.Wwwwwwwwwwwwwwwwwww.findViewById(com.google.android.material.R$id.material_label)).setText(resources.getString(com.google.android.material.R$string.material_timepicker_hour));
        ChipTextInputComboView chipTextInputComboView = this.Wwwwwwwwwwwwwwwwwwww;
        chipTextInputComboView.Wwwwwwwwwwwwwwwwwwwwwwww.setTag(com.google.android.material.R$id.selection_type, 12);
        ChipTextInputComboView chipTextInputComboView2 = this.Wwwwwwwwwwwwwwwwwww;
        chipTextInputComboView2.Wwwwwwwwwwwwwwwwwwwwwwww.setTag(com.google.android.material.R$id.selection_type, 10);
        if (c2122fs.Wwwwwwwwwwwwwwwwwwwwww == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.Wwwwwwwwwwwwwwwwwwwwwwww.findViewById(com.google.android.material.R$id.material_clock_period_toggle);
            this.Wwwwwwwwwwwwwww = materialButtonToggleGroup;
            materialButtonToggleGroup.Wwwwwwwwwwwwwwwwwwwww.add(new C2307ks(this));
            this.Wwwwwwwwwwwwwww.setVisibility(0);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2122fs.Wwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2122fs.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.getEditText();
        this.Wwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.getEditText();
        this.Wwwwwwwwwwwwwwwwww = new View$OnKeyListenerC2233is(this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, c2122fs);
        ChipTextInputComboView chipTextInputComboView3 = this.Wwwwwwwwwwwwwwwwwww;
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView3.Wwwwwwwwwwwwwwwwwwwwwwww, new C1994cs(linearLayout.getContext(), com.google.android.material.R$string.material_hour_selection));
        ChipTextInputComboView chipTextInputComboView4 = this.Wwwwwwwwwwwwwwwwwwww;
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView4.Wwwwwwwwwwwwwwwwwwwwwwww, new C1994cs(linearLayout.getContext(), com.google.android.material.R$string.material_minute_selection));
        this.Wwwwwwwwwwwwwwwww.addTextChangedListener(this.Wwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwww.addTextChangedListener(this.Wwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        View$OnKeyListenerC2233is view$OnKeyListenerC2233is = this.Wwwwwwwwwwwwwwwwww;
        TextInputLayout textInputLayout = view$OnKeyListenerC2233is.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        TextInputLayout textInputLayout2 = view$OnKeyListenerC2233is.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(view$OnKeyListenerC2233is);
        editText.setOnKeyListener(view$OnKeyListenerC2233is);
        editText2.setOnKeyListener(view$OnKeyListenerC2233is);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.Wwwwwwwwwwwwwww;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww == 0 ? com.google.android.material.R$id.material_clock_period_am_button : com.google.android.material.R$id.material_clock_period_pm_button);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = i;
        boolean z = true;
        this.Wwwwwwwwwwwwwwwwwwww.setChecked(i == 12);
        ChipTextInputComboView chipTextInputComboView = this.Wwwwwwwwwwwwwwwwwww;
        if (i != 10) {
            z = false;
        }
        chipTextInputComboView.setChecked(z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2122fs c2122fs) {
        this.Wwwwwwwwwwwwwwwww.removeTextChangedListener(this.Wwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwww.removeTextChangedListener(this.Wwwwwwwwwwwwwwwwwwwwww);
        Locale locale = this.Wwwwwwwwwwwwwwwwwwwwwwww.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(c2122fs.Wwwwwwwwwwwwwwwwwwww));
        String format2 = String.format(locale, "%02d", Integer.valueOf(c2122fs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(format);
        this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(format2);
        this.Wwwwwwwwwwwwwwwww.addTextChangedListener(this.Wwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwww.addTextChangedListener(this.Wwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2196hs
    public void hide() {
        InputMethodManager inputMethodManager;
        View focusedChild = this.Wwwwwwwwwwwwwwwwwwwwwwww.getFocusedChild();
        if (focusedChild != null && (inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.Wwwwwwwwwwwwwwwwwwwwwwww.getContext(), InputMethodManager.class)) != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setVisibility(8);
    }

    @Override // me.tvspark.AbstractC2196hs
    public void invalidate() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2196hs
    public void show() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
    }
}
