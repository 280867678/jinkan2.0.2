package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import java.util.Iterator;
import me.tvspark.AbstractC2340lo;
import me.tvspark.AbstractC2377mo;
import me.tvspark.AbstractC2793xn;
import me.tvspark.C2678un;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class MaterialTextInputPicker<S> extends AbstractC2377mo<S> {
    @Nullable
    public C2678un Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2793xn<S> Wwwwwwwwwwwwwwwwwwwwww;
    @StyleRes
    public int Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2340lo<S> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC2340lo
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(S s) {
            Iterator<AbstractC2340lo<S>> it = MaterialTextInputPicker.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = bundle.getInt("THEME_RES_ID_KEY");
        this.Wwwwwwwwwwwwwwwwwwwwww = (AbstractC2793xn) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.Wwwwwwwwwwwwwwwwwwwww = (C2678un) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutInflater.cloneInContext(new ContextThemeWrapper(mo4928getContext(), this.Wwwwwwwwwwwwwwwwwwwwwww)), viewGroup, bundle, this.Wwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.Wwwwwwwwwwwwwwwwwwwwwww);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.Wwwwwwwwwwwwwwwwwwwwww);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Wwwwwwwwwwwwwwwwwwwww);
    }
}
