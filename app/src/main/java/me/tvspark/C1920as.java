package me.tvspark;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: me.tvspark.as */
/* loaded from: classes4.dex */
public class C1920as extends AbstractC2760wr {
    public final TextWatcher Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.as$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = C1920as.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            editText.setTransformationMethod(C1920as.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1920as.this) ? null : PasswordTransformationMethod.getInstance());
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            C1920as.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* renamed from: me.tvspark.as$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {

        /* renamed from: me.tvspark.as$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.removeTextChangedListener(C1920as.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText));
        }
    }

    /* renamed from: me.tvspark.as$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            C1920as c1920as = C1920as.this;
            c1920as.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setChecked(!C1920as.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1920as));
            editText.removeTextChangedListener(C1920as.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            editText.addTextChangedListener(C1920as.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.as$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2378mp {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.C2378mp, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C1920as c1920as = C1920as.this;
            c1920as.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setChecked(!C1920as.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1920as));
        }
    }

    public C1920as(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1920as c1920as) {
        EditText editText = c1920as.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // me.tvspark.AbstractC2760wr
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setEndIconDrawable(AppCompatResources.getDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, com.google.android.material.R$drawable.design_password_eye));
        TextInputLayout textInputLayout = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(com.google.android.material.R$string.password_toggle_content_description));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setEndIconOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Illlllllllllllllllllll.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        EditText editText = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
