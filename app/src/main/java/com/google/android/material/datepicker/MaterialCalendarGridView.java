package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import java.util.Calendar;
import me.tvspark.AbstractC2793xn;
import me.tvspark.C2266jo;
import me.tvspark.C2488po;
import me.tvspark.C2756wn;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class MaterialCalendarGridView extends GridView {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final Calendar Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AccessibilityDelegateCompat {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = C2488po.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (MaterialDatePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = MaterialDatePicker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), R$attr.nestedScrollable);
        ViewCompat.setAccessibilityDelegate(this, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* renamed from: getAdapter  reason: collision with other method in class */
    public ListAdapter getAdapter2() {
        return (C2266jo) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas canvas) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int width;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int width2;
        int width3;
        int i;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        C2266jo adapter2 = getAdapter2();
        AbstractC2793xn<?> abstractC2793xn = adapter2.Wwwwwwwwwwwwwwwwwwwwwww;
        C2756wn c2756wn = adapter2.Wwwwwwwwwwwwwwwwwwwww;
        Long mo4936getItem = adapter2.mo4936getItem(adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Long mo4936getItem2 = adapter2.mo4936getItem(adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        for (Pair<Long, Long> pair : abstractC2793xn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Long l = pair.first;
            if (l != null) {
                if (pair.second != null) {
                    long longValue = l.longValue();
                    long longValue2 = pair.second.longValue();
                    Long valueOf = Long.valueOf(longValue);
                    Long valueOf2 = Long.valueOf(longValue2);
                    boolean z = true;
                    if (!(mo4936getItem == null || mo4936getItem2 == null || valueOf == null || valueOf2 == null || valueOf.longValue() > mo4936getItem2.longValue() || valueOf2.longValue() < mo4936getItem.longValue())) {
                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this);
                        if (longValue < mo4936getItem.longValue()) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 % adapter2.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww == 0) {
                                width = 0;
                            } else {
                                View childAt = materialCalendarGridView.getChildAt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - 1);
                                width = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? childAt.getRight() : childAt.getLeft();
                            }
                        } else {
                            materialCalendarGridView.Wwwwwwwwwwwwwwwwwwwwwwww.setTimeInMillis(longValue);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialCalendarGridView.Wwwwwwwwwwwwwwwwwwwwwwww.get(5));
                            View childAt2 = materialCalendarGridView.getChildAt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            width = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        if (longValue2 > mo4936getItem2.longValue()) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Math.min(adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), getChildCount() - 1);
                            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + 1) % adapter2.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww != 0) {
                                z = false;
                            }
                            if (z) {
                                width2 = getWidth();
                            } else {
                                View childAt3 = materialCalendarGridView.getChildAt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                width2 = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? childAt3.getRight() : childAt3.getLeft();
                            }
                        } else {
                            materialCalendarGridView.Wwwwwwwwwwwwwwwwwwwwwwww.setTimeInMillis(longValue2);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = adapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(materialCalendarGridView.Wwwwwwwwwwwwwwwwwwwwwwww.get(5));
                            View childAt4 = materialCalendarGridView.getChildAt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                            width2 = (childAt4.getWidth() / 2) + childAt4.getLeft();
                        }
                        int itemId = (int) adapter2.getItemId(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        int itemId2 = (int) adapter2.getItemId(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt5 = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt5.getTop() + c2756wn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.top;
                            int bottom = childAt5.getBottom() - c2756wn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.bottom;
                            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                i = numColumns > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? 0 : width;
                                width3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 > numColumns2 ? getWidth() : width2;
                            } else {
                                int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 > numColumns2 ? 0 : width2;
                                width3 = numColumns > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? getWidth() : width;
                                i = i2;
                            }
                            canvas.drawRect(i, top, width3, bottom, c2756wn.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter2 = adapter2;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
            adapter2 = adapter2;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (!z) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = getAdapter2().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (i != 130) {
            super.onFocusChanged(true, i, rect);
            return;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = getAdapter2().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        setSelection(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter2().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof C2266jo) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), C2266jo.class.getCanonicalName()));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter2().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            i = getAdapter2().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        super.setSelection(i);
    }
}
