package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;
import me.tvspark.C2122fs;
import me.tvspark.C2378mp;

/* loaded from: classes3.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {
    public TextWatcher Wwwwwwwwwwwwwwwwwwwww;
    public final EditText Wwwwwwwwwwwwwwwwwwwwww;
    public final TextInputLayout Wwwwwwwwwwwwwwwwwwwwwww;
    public final Chip Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2378mp {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.C2378mp, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.Wwwwwwwwwwwwwwwwwwwwwwww.setText(C2122fs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipTextInputComboView.getResources(), "00", "%02d"));
                return;
            }
            ChipTextInputComboView chipTextInputComboView2 = ChipTextInputComboView.this;
            chipTextInputComboView2.Wwwwwwwwwwwwwwwwwwwwwwww.setText(C2122fs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chipTextInputComboView2.getResources(), editable, "%02d"));
        }
    }

    public ChipTextInputComboView(@NonNull Context context) {
        this(context, null);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater from = LayoutInflater.from(context);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (Chip) from.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        this.Wwwwwwwwwwwwwwwwwwwwwww = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.Wwwwwwwwwwwwwwwwwwwwww = editText;
        editText.setVisibility(4);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww.addTextChangedListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        addView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        addView(this.Wwwwwwwwwwwwwwwwwwwwwww);
        TextView textView = (TextView) findViewById(R$id.material_label);
        this.Wwwwwwwwwwwwwwwwwwwwww.setSaveEnabled(false);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.Wwwwwwwwwwwwwwwwwwwwww.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputFilter inputFilter) {
        InputFilter[] filters = this.Wwwwwwwwwwwwwwwwwwwwww.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.Wwwwwwwwwwwwwwwwwwwwww.setFilters(inputFilterArr);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setText(C2122fs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getResources(), charSequence, "%02d"));
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwww.getText())) {
            this.Wwwwwwwwwwwwwwwwwwwwww.removeTextChangedListener(this.Wwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww.setText((CharSequence) null);
            this.Wwwwwwwwwwwwwwwwwwwwww.addTextChangedListener(this.Wwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setChecked(z);
        int i = 0;
        this.Wwwwwwwwwwwwwwwwwwwwww.setVisibility(z ? 0 : 4);
        Chip chip = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (z) {
            i = 8;
        }
        chip.setVisibility(i);
        if (isChecked()) {
            this.Wwwwwwwwwwwwwwwwwwwwww.requestFocus();
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwww.getText())) {
                return;
            }
            EditText editText = this.Wwwwwwwwwwwwwwwwwwwwww;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setTag(i, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.toggle();
    }
}
