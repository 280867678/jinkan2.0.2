package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import me.tvspark.AbstractC2192ho;
import me.tvspark.AbstractC2340lo;
import me.tvspark.AbstractC2377mo;
import me.tvspark.AbstractC2793xn;
import me.tvspark.C2229io;
import me.tvspark.C2266jo;
import me.tvspark.C2488po;
import me.tvspark.C2678un;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.View$OnClickListenerC2155go;
import me.tvspark.View$OnTouchListenerC2568ro;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    public Button Wwwwwwww;
    @Nullable
    public MaterialShapeDrawable Wwwwwwwww;
    public CheckableImageButton Wwwwwwwwww;
    public TextView Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public boolean Wwwwwwwwwwwww;
    public CharSequence Wwwwwwwwwwwwww;
    @StringRes
    public int Wwwwwwwwwwwwwww;
    public MaterialCalendar<S> Wwwwwwwwwwwwwwww;
    @Nullable
    public C2678un Wwwwwwwwwwwwwwwww;
    public AbstractC2377mo<S> Wwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2793xn<S> Wwwwwwwwwwwwwwwwwww;
    @StyleRes
    public int Wwwwwwwwwwwwwwwwwwww;
    public static final Object Wwwwwww = "CONFIRM_BUTTON_TAG";
    public static final Object Wwwwww = "CANCEL_BUTTON_TAG";
    public static final Object Wwwww = "TOGGLE_BUTTON_TAG";
    public final LinkedHashSet<AbstractC2192ho<? super S>> Wwwwwwwwwwwwwwwwwwwwwwww = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> Wwwwwwwwwwwwwwwwwwwwwww = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> Wwwwwwwwwwwwwwwwwwwwww = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> Wwwwwwwwwwwwwwwwwwwww = new LinkedHashSet<>();

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2340lo<S> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2340lo
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(S s) {
            MaterialDatePicker.this.Wwwwwwwwwwwwwwwww();
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.Wwwwwwww.setEnabled(materialDatePicker.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<View.OnClickListener> it = MaterialDatePicker.this.Wwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<AbstractC2192ho<? super S>> it = MaterialDatePicker.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((S) MaterialDatePicker.this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww());
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, 16843277);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i = new C2229io(C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).Wwwwwwwwwwwwwwwwwwwww;
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, -1, resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding), (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i) + (dimensionPixelOffset * 2));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final void Wwwwwwwwwwwwwwwww() {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4928getContext());
        this.Wwwwwwwwwww.setContentDescription(String.format(getString(R$string.mtrl_picker_announce_current_selection), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        this.Wwwwwwwwwww.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.android.material.datepicker.MaterialTextInputPicker, androidx.fragment.app.Fragment] */
    public final void Wwwwwwwwwwwwwwwwww() {
        Context requireContext = requireContext();
        int i = this.Wwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            i = this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requireContext);
        }
        AbstractC2793xn<S> abstractC2793xn = this.Wwwwwwwwwwwwwwwwwww;
        C2678un c2678un = this.Wwwwwwwwwwwwwwwww;
        MaterialCalendar<S> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("GRID_SELECTOR_KEY", abstractC2793xn);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c2678un);
        bundle.putParcelable("CURRENT_MONTH_KEY", c2678un.Wwwwwwwwwwwwwwwwwwwww);
        materialCalendar.setArguments(bundle);
        this.Wwwwwwwwwwwwwwww = materialCalendar;
        if (this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) {
            AbstractC2793xn<S> abstractC2793xn2 = this.Wwwwwwwwwwwwwwwwwww;
            C2678un c2678un2 = this.Wwwwwwwwwwwwwwwww;
            ?? materialTextInputPicker = new MaterialTextInputPicker();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i);
            bundle2.putParcelable("DATE_SELECTOR_KEY", abstractC2793xn2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", c2678un2);
            materialTextInputPicker.setArguments(bundle2);
            materialCalendar = materialTextInputPicker;
        }
        this.Wwwwwwwwwwwwwwwwww = materialCalendar;
        Wwwwwwwwwwwwwwwww();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.mtrl_calendar_frame, this.Wwwwwwwwwwwwwwwwww);
        beginTransaction.commitNow();
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.Wwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.Wwwwwwwwwwwwwwwwwwww = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.Wwwwwwwwwwwwwwwwwww = (AbstractC2793xn) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.Wwwwwwwwwwwwwwwww = (C2678un) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.Wwwwwwwwwwwwwww = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.Wwwwwwwwwwwwww = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.Wwwwwwwwwwww = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Context requireContext2 = requireContext();
        int i = this.Wwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            i = this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requireContext2);
        }
        Dialog dialog = new Dialog(requireContext, i);
        Context context = dialog.getContext();
        this.Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, R$attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.Wwwwwwwww = materialShapeDrawable;
        materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(this.Wwwwwwwwwwwww ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.Wwwwwwwwwwwww) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context), -2));
        } else {
            View findViewById = inflate.findViewById(R$id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R$id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context), -1));
            Resources resources = requireContext().getResources();
            findViewById2.setMinimumHeight(resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height) + (resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding) * (C2266jo.Wwwwwwwwwwwwwwwwwww - 1)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * C2266jo.Wwwwwwwwwwwwwwwwwww) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.Wwwwwwwwwww = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.Wwwwwwwwww = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.Wwwwwwwwwwwwww;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.Wwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwww.setTag(Wwwww);
        CheckableImageButton checkableImageButton = this.Wwwwwwwwww;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R$drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.Wwwwwwwwww.setChecked(this.Wwwwwwwwwwww != 0);
        ViewCompat.setAccessibilityDelegate(this.Wwwwwwwwww, null);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww);
        this.Wwwwwwwwww.setOnClickListener(new View$OnClickListenerC2155go(this));
        this.Wwwwwwww = (Button) inflate.findViewById(R$id.confirm_button);
        if (this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwww.setEnabled(true);
        } else {
            this.Wwwwwwww.setEnabled(false);
        }
        this.Wwwwwwww.setTag(Wwwwwww);
        this.Wwwwwwww.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag(Wwwwww);
        button.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.Wwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.Wwwwwwwwwwwwwwwwwwww);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.Wwwwwwwwwwwwwwwwwww);
        C2678un.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2678un.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww);
        C2229io c2229io = this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
        if (c2229io != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Long.valueOf(c2229io.Wwwwwwwwwwwwwwwwwww);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2229io Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2229io Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2678un.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (C2678un.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new C2678un(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, l == null ? null : C2229io.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l.longValue()), null));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.Wwwwwwwwwwwwwww);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.Wwwwwwwwwwwwww);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.Wwwwwwwwwwwww) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.Wwwwwwwww);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.Wwwwwwwww, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new View$OnTouchListenerC2568ro(requireDialog(), rect));
        }
        Wwwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        super.onStop();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CheckableImageButton checkableImageButton) {
        this.Wwwwwwwwww.setContentDescription(checkableImageButton.getContext().getString(this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww ? R$string.mtrl_picker_toggle_to_calendar_input_mode : R$string.mtrl_picker_toggle_to_text_input_mode));
    }
}
