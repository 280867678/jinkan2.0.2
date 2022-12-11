package me.tvspark;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: me.tvspark.kr */
/* loaded from: classes4.dex */
public class C2306kr extends AbstractC2760wr {
    public ValueAnimator Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final TextWatcher Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final View.OnFocusChangeListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.kr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* renamed from: me.tvspark.kr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {

        /* renamed from: me.tvspark.kr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.removeTextChangedListener(C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 2) {
                return;
            }
            editText.post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText));
            if (editText.getOnFocusChangeListener() != C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            editText.setOnFocusChangeListener(null);
        }
    }

    /* renamed from: me.tvspark.kr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
            if ((r0.getText().length() > 0) != false) goto L7;
         */
        @Override // com.google.android.material.textfield.TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            boolean z = true;
            if (editText.hasFocus()) {
            }
            z = false;
            textInputLayout.setEndIconVisible(z);
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            editText.removeTextChangedListener(C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            editText.addTextChangedListener(C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.kr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnFocusChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            C2306kr c2306kr = C2306kr.this;
            if (!z3 || !z) {
                z2 = false;
            }
            c2306kr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2);
        }
    }

    /* renamed from: me.tvspark.kr$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextWatcher {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuffixText() != null) {
                return;
            }
            C2306kr.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editable.length() > 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public C2306kr(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        boolean z2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() == z;
        if (z && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.isRunning()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww.cancel();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.start();
            if (!z2) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.end();
        } else if (z) {
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.cancel();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww.start();
            if (!z2) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww.end();
        }
    }

    @Override // me.tvspark.AbstractC2760wr
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setEndIconDrawable(AppCompatResources.getDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(com.google.android.material.R$string.clear_text_end_icon_content_description));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setEndIconOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Illlllllllllllllllllll.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new C2454or(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new C2417nr(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.addListener(new C2343lr(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new C2417nr(this));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = ofFloat3;
        ofFloat3.addListener(new C2380mr(this));
    }

    @Override // me.tvspark.AbstractC2760wr
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuffixText() == null) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
    }
}
