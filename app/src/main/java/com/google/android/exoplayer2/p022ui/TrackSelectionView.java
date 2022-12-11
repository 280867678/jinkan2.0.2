package com.google.android.exoplayer2.p022ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.AbstractC2409nj;
import me.tvspark.C2298kj;
import me.tvspark.C2368mf;
import me.tvspark.C2825yi;
import me.tvspark.Illllllllllllllllllllllllllll;

/* renamed from: com.google.android.exoplayer2.ui.TrackSelectionView */
/* loaded from: classes3.dex */
public class TrackSelectionView extends LinearLayout {
    public boolean Wwwwwwwwwwwww;
    public C2368mf Wwwwwwwwwwwwww;
    public CheckedTextView[][] Wwwwwwwwwwwwwww;
    public AbstractC2409nj Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public final SparseArray<C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public final CheckedTextView Wwwwwwwwwwwwwwwwwwwww;
    public final CheckedTextView Wwwwwwwwwwwwwwwwwwwwww;
    public final LayoutInflater Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.google.android.exoplayer2.ui.TrackSelectionView$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: com.google.android.exoplayer2.ui.TrackSelectionView$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView trackSelectionView = TrackSelectionView.this;
            if (view == trackSelectionView.Wwwwwwwwwwwwwwwwwwwwww) {
                trackSelectionView.Wwwwwwwwwwwww = true;
                trackSelectionView.Wwwwwwwwwwwwwwwwwww.clear();
            } else if (view == trackSelectionView.Wwwwwwwwwwwwwwwwwwwww) {
                trackSelectionView.Wwwwwwwwwwwww = false;
                trackSelectionView.Wwwwwwwwwwwwwwwwwww.clear();
            } else {
                trackSelectionView.Wwwwwwwwwwwww = false;
                Object tag = view.getTag();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tag);
                trackSelectionView.Wwwwwwwwwwwwwwwwwww.get(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) tag).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                throw null;
            }
            trackSelectionView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        this.Wwwwwwwwwwwwwwwwwww = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        this.Wwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        this.Wwwwwwwwwwwwwwwwwwwwwww = LayoutInflater.from(context);
        this.Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        this.Wwwwwwwwwwwwwwww = new C2298kj(getResources());
        this.Wwwwwwwwwwwwww = C2368mf.Wwwwwwwwwwwwwwwwwwwww;
        CheckedTextView checkedTextView = (CheckedTextView) this.Wwwwwwwwwwwwwwwwwwwwwww.inflate(17367055, (ViewGroup) this, false);
        this.Wwwwwwwwwwwwwwwwwwwwww = checkedTextView;
        checkedTextView.setBackgroundResource(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwww.setText(R$string.exo_track_selection_none);
        this.Wwwwwwwwwwwwwwwwwwwwww.setEnabled(false);
        this.Wwwwwwwwwwwwwwwwwwwwww.setFocusable(true);
        this.Wwwwwwwwwwwwwwwwwwwwww.setOnClickListener(this.Wwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwww.setVisibility(8);
        addView(this.Wwwwwwwwwwwwwwwwwwwwww);
        addView(this.Wwwwwwwwwwwwwwwwwwwwwww.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) this.Wwwwwwwwwwwwwwwwwwwwwww.inflate(17367055, (ViewGroup) this, false);
        this.Wwwwwwwwwwwwwwwwwwwww = checkedTextView2;
        checkedTextView2.setBackgroundResource(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww.setText(R$string.exo_track_selection_auto);
        this.Wwwwwwwwwwwwwwwwwwwww.setEnabled(false);
        this.Wwwwwwwwwwwwwwwwwwwww.setFocusable(true);
        this.Wwwwwwwwwwwwwwwwwwwww.setOnClickListener(this.Wwwwwwwwwwwwwwwwwwww);
        addView(this.Wwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount < 3) {
                this.Wwwwwwwwwwwwwwwwwwwwww.setEnabled(false);
                this.Wwwwwwwwwwwwwwwwwwwww.setEnabled(false);
                return;
            }
            removeViewAt(childCount);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z;
        this.Wwwwwwwwwwwwwwwwwwwwww.setChecked(this.Wwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww.setChecked(!this.Wwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwww.size() == 0);
        for (int i = 0; i < this.Wwwwwwwwwwwwwww.length; i++) {
            C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww.get(i);
            int i2 = 0;
            while (true) {
                CheckedTextView[][] checkedTextViewArr = this.Wwwwwwwwwwwwwww;
                if (i2 < checkedTextViewArr[i].length) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Object tag = checkedTextViewArr[i][i2].getTag();
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tag);
                        CheckedTextView checkedTextView = this.Wwwwwwwwwwwwwww[i][i2];
                        int i3 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) tag).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int[] iArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                        int length = iArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                z = false;
                                break;
                            } else if (iArr[i4] == i3) {
                                z = true;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        checkedTextView.setChecked(z);
                    } else {
                        checkedTextViewArr[i][i2].setChecked(false);
                    }
                    i2++;
                }
            }
        }
    }

    public boolean getIsDisabled() {
        return this.Wwwwwwwwwwwww;
    }

    public List<C2825yi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> getOverrides() {
        ArrayList arrayList = new ArrayList(this.Wwwwwwwwwwwwwwwwwww.size());
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwww.size(); i++) {
            arrayList.add(this.Wwwwwwwwwwwwwwwwwww.valueAt(i));
        }
        return arrayList;
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwwww = z;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.Wwwwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwwwww = z;
            if (!z && this.Wwwwwwwwwwwwwwwwwww.size() > 1) {
                for (int size = this.Wwwwwwwwwwwwwwwwwww.size() - 1; size > 0; size--) {
                    this.Wwwwwwwwwwwwwwwwwww.remove(size);
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwww.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(AbstractC2409nj abstractC2409nj) {
        if (abstractC2409nj != null) {
            this.Wwwwwwwwwwwwwwww = abstractC2409nj;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        throw null;
    }
}
