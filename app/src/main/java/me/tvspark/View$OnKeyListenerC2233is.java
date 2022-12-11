package me.tvspark;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.timepicker.ChipTextInputComboView;

/* renamed from: me.tvspark.is */
/* loaded from: classes4.dex */
public class View$OnKeyListenerC2233is implements TextView.OnEditorActionListener, View.OnKeyListener {
    public boolean Wwwwwwwwwwwwwwwwwwwww = false;
    public final C2122fs Wwwwwwwwwwwwwwwwwwwwww;
    public final ChipTextInputComboView Wwwwwwwwwwwwwwwwwwwwwww;
    public final ChipTextInputComboView Wwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnKeyListenerC2233is(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, C2122fs c2122fs) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = chipTextInputComboView;
        this.Wwwwwwwwwwwwwwwwwwwwwww = chipTextInputComboView2;
        this.Wwwwwwwwwwwwwwwwwwwwww = c2122fs;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = true;
        this.Wwwwwwwwwwwwwwwwwwwwwww.setChecked(i == 12);
        ChipTextInputComboView chipTextInputComboView = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i != 10) {
            z = false;
        }
        chipTextInputComboView.setChecked(z);
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = i;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = i == 5;
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
        }
        return z;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        boolean z = true;
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        EditText editText = (EditText) view;
        if (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww == 12) {
            if (i == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
            }
            z = false;
        } else {
            Editable text = editText.getText();
            if (text != null) {
                if (i >= 7 && i <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
                }
            }
            z = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = false;
        return z;
    }
}
