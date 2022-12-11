package me.tvspark.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes4.dex */
public class ShangshabanChangeTextSpaceView extends AppCompatTextView {
    public float Wwwwwwwwwwwwwwwwwwwwwwww = 0.0f;
    public CharSequence Wwwwwwwwwwwwwwwwwwwwwww = "";

    public ShangshabanChangeTextSpaceView(Context context) {
        super(context);
    }

    public ShangshabanChangeTextSpaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShangshabanChangeTextSpaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.Wwwwwwwwwwwwwwwwwwwwwww.length()) {
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwww.charAt(i));
            i++;
            if (i < this.Wwwwwwwwwwwwwwwwwwwwwww.length()) {
                sb.append(" ");
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                spannableString.setSpan(new ScaleXSpan((this.Wwwwwwwwwwwwwwwwwwwwwwww + 1.0f) / 10.0f), i2, i2 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public float getSpacing() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public CharSequence getText() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setSpacing(float f) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = f;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = charSequence;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
