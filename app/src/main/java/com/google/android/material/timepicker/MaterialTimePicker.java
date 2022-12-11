package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.LinkedHashSet;
import java.util.Set;
import me.tvspark.AbstractC2196hs;
import me.tvspark.C2122fs;
import me.tvspark.C2159gs;
import me.tvspark.C2270js;
import me.tvspark.C2605so;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class MaterialTimePicker extends DialogFragment {
    public C2122fs Wwwwwwww;
    public MaterialButton Wwwwwwwwww;
    public String Wwwwwwwwwww;
    @DrawableRes
    public int Wwwwwwwwwwwww;
    @DrawableRes
    public int Wwwwwwwwwwwwww;
    @Nullable
    public AbstractC2196hs Wwwwwwwwwwwwwww;
    @Nullable
    public C2270js Wwwwwwwwwwwwwwww;
    @Nullable
    public C2159gs Wwwwwwwwwwwwwwwww;
    public ViewStub Wwwwwwwwwwwwwwwwww;
    public LinearLayout Wwwwwwwwwwwwwwwwwww;
    public TimePickerView Wwwwwwwwwwwwwwwwwwww;
    public final Set<View.OnClickListener> Wwwwwwwwwwwwwwwwwwwwwwww = new LinkedHashSet();
    public final Set<View.OnClickListener> Wwwwwwwwwwwwwwwwwwwwwww = new LinkedHashSet();
    public final Set<DialogInterface.OnCancelListener> Wwwwwwwwwwwwwwwwwwwwww = new LinkedHashSet();
    public final Set<DialogInterface.OnDismissListener> Wwwwwwwwwwwwwwwwwwwww = new LinkedHashSet();
    public int Wwwwwwwwwwww = 0;
    public int Wwwwwwwww = 0;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.Wwwwwwwww = materialTimePicker.Wwwwwwwww == 0 ? 1 : 0;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialTimePicker2.Wwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : MaterialTimePicker.this.Wwwwwwwwwwwwwwwwwwwwwww) {
                onClickListener.onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : MaterialTimePicker.this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                onClickListener.onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TimePickerView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialButton materialButton) {
        C2159gs c2159gs;
        Pair pair;
        AbstractC2196hs abstractC2196hs = this.Wwwwwwwwwwwwwww;
        if (abstractC2196hs != null) {
            abstractC2196hs.hide();
        }
        if (this.Wwwwwwwww == 0) {
            C2159gs c2159gs2 = this.Wwwwwwwwwwwwwwwww;
            C2159gs c2159gs3 = c2159gs2;
            if (c2159gs2 == null) {
                c2159gs3 = new C2159gs(this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwww = c2159gs3;
            c2159gs = c2159gs3;
        } else {
            if (this.Wwwwwwwwwwwwwwww == null) {
                LinearLayout linearLayout = (LinearLayout) this.Wwwwwwwwwwwwwwwwww.inflate();
                this.Wwwwwwwwwwwwwwwwwww = linearLayout;
                this.Wwwwwwwwwwwwwwww = new C2270js(linearLayout, this.Wwwwwwww);
            }
            C2270js c2270js = this.Wwwwwwwwwwwwwwww;
            c2270js.Wwwwwwwwwwwwwwwwwwww.setChecked(false);
            c2270js.Wwwwwwwwwwwwwwwwwww.setChecked(false);
            c2159gs = this.Wwwwwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwwwwww = c2159gs;
        c2159gs.show();
        this.Wwwwwwwwwwwwwww.invalidate();
        int i = this.Wwwwwwwww;
        if (i == 0) {
            pair = new Pair(Integer.valueOf(this.Wwwwwwwwwwwwww), Integer.valueOf(R$string.material_timepicker_text_input_mode_description));
        } else if (i != 1) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no icon for mode: ", i));
        } else {
            pair = new Pair(Integer.valueOf(this.Wwwwwwwwwwwww), Integer.valueOf(R$string.material_timepicker_clock_mode_description));
        }
        materialButton.setIconResource(((Integer) pair.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pair.second).intValue()));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancelListener : this.Wwwwwwwwwwwwwwwwwwwwww) {
            onCancelListener.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle == null) {
            return;
        }
        C2122fs c2122fs = (C2122fs) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.Wwwwwwww = c2122fs;
        if (c2122fs == null) {
            this.Wwwwwwww = new C2122fs(0, 0, 10, 0);
        }
        this.Wwwwwwwww = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
        this.Wwwwwwwwwwww = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.Wwwwwwwwwww = bundle.getString("TIME_PICKER_TITLE_TEXT");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        TypedValue Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requireContext(), R$attr.materialTimePickerTheme);
        Dialog dialog = new Dialog(requireContext(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null ? 0 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.data);
        Context context = dialog.getContext();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, R$attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R$attr.materialTimePickerStyle, R$style.Widget_MaterialComponents_TimePicker);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialTimePicker, R$attr.materialTimePickerStyle, R$style.Widget_MaterialComponents_TimePicker);
        this.Wwwwwwwwwwwww = obtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_clockIcon, 0);
        this.Wwwwwwwwwwwwww = obtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2605so(context);
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R$id.material_timepicker_view);
        this.Wwwwwwwwwwwwwwwwwwww = timePickerView;
        timePickerView.Wwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwww = (ViewStub) viewGroup2.findViewById(R$id.material_textinput_timepicker);
        this.Wwwwwwwwww = (MaterialButton) viewGroup2.findViewById(R$id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R$id.header_title);
        if (!TextUtils.isEmpty(this.Wwwwwwwwwww)) {
            textView.setText(this.Wwwwwwwwwww);
        }
        int i = this.Wwwwwwwwwwww;
        if (i != 0) {
            textView.setText(i);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww);
        ((Button) viewGroup2.findViewById(R$id.material_timepicker_ok_button)).setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        ((Button) viewGroup2.findViewById(R$id.material_timepicker_cancel_button)).setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwww.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.Wwwwwwwwwwwwwwwwwwwww) {
            onDismissListener.onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.Wwwwwwww);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.Wwwwwwwww);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.Wwwwwwwwwwww);
        bundle.putString("TIME_PICKER_TITLE_TEXT", this.Wwwwwwwwwww);
    }
}
