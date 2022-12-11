package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.outline;
import me.tvspark.q50;
import me.tvspark.r50;
import me.tvspark.rt0;
import me.tvspark.s50;
import me.tvspark.view.activity.SearchActivity;
import me.tvspark.view.fragment.SearchHistoryFragment;
import white.whale.R;

/* loaded from: classes4.dex */
public class TagFlowLayout extends q50 implements r50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwww;
    public Handler Wwwww;
    public long Wwwwww;
    public float Wwwwwww;
    public float Wwwwwwww;
    public float Wwwwwwwww;
    public float Wwwwwwwwww;
    public float Wwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww;
    public Set<Integer> Wwwwwwwwwwwwwww;
    public MotionEvent Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public r50 Wwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Set<Integer> set);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            MotionEvent motionEvent = TagFlowLayout.this.Wwwwwwwwwwwwwwww;
            if (motionEvent != null) {
                TagFlowLayout tagFlowLayout = TagFlowLayout.this;
                tagFlowLayout.Wwwwwwwwwwwwwwww = null;
                s50 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tagFlowLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) motionEvent.getX(), (int) TagFlowLayout.this.Wwwwwwwwwwwwwwww.getY());
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = TagFlowLayout.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = TagFlowLayout.this.Wwwwwwwwwwww) == null) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTagView();
                SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                String str = SearchHistoryFragment.this.Wwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(SearchHistoryFragment.this.Wwwwwwwwwwwwwwwwwwwwwww).setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("删除", new rt0(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str));
                positiveButton.setMessage("是否删除 " + str + " ？").show();
            }
        }
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwww = new HashSet();
        this.Wwwww = new Handler();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TagFlowLayout);
        this.Wwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.TagFlowLayout_auto_select_effect, true);
        this.Wwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(R$styleable.TagFlowLayout_max_select, -1);
        obtainStyledAttributes.recycle();
        if (this.Wwwwwwwwwwwwwwwwww) {
            setClickable(true);
        }
        setLongClickable(true);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        BaseActivity baseActivity;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        removeAllViews();
        r50 r50Var = this.Wwwwwwwwwwwwwwwwwww;
        HashSet<Integer> hashSet = r50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        while (true) {
            List<T> list = r50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i < (list == 0 ? 0 : list.size())) {
                SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3503Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3503Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3503Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) r50Var;
                baseActivity = SearchHistoryFragment.this.Wwwwwwwwwwwwwwwwwwwwwww;
                View inflate = LayoutInflater.from(baseActivity).inflate(R.layout.item_flowlayout_hot, (ViewGroup) SearchHistoryFragment.this.tags, false);
                ((TextView) inflate.findViewById(R.id.tv_name)).setText((String) r50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i));
                s50 s50Var = new s50(getContext());
                inflate.setDuplicateParentStateEnabled(true);
                if (inflate.getLayoutParams() != null) {
                    marginLayoutParams = inflate.getLayoutParams();
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams2.setMargins(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), 5.0f), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), 5.0f), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), 5.0f), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), 5.0f));
                    marginLayoutParams = marginLayoutParams2;
                }
                s50Var.setLayoutParams(marginLayoutParams);
                s50Var.addView(inflate);
                addView(s50Var);
                if (hashSet.contains(Integer.valueOf(i))) {
                    s50Var.setChecked(true);
                }
                r50 r50Var2 = this.Wwwwwwwwwwwwwwwwwww;
                r50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                if (r50Var2 == null) {
                    throw null;
                }
                i++;
            } else {
                this.Wwwwwwwwwwwwwww.addAll(hashSet);
                return;
            }
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    public final s50 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            s50 s50Var = (s50) getChildAt(i3);
            if (s50Var.getVisibility() != 8) {
                Rect rect = new Rect();
                s50Var.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return s50Var;
                }
            }
        }
        return null;
    }

    @Override // me.tvspark.r50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwww.clear();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public r50 getAdapter() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.Wwwwwwwwwwwwwww);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = 8;
            if (i5 >= childCount) {
                break;
            }
            s50 s50Var = (s50) getChildAt(i5);
            if (s50Var.getVisibility() != 8 && s50Var.getTagView().getVisibility() == 8) {
                s50Var.setVisibility(8);
            }
            i5++;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount2 = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i4 < childCount2) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != i3) {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i10 = i7 + measuredWidth;
                if (i10 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i6 = Math.max(i6, i7);
                    i9 += i8;
                    i10 = measuredWidth;
                } else {
                    measuredHeight = Math.max(i8, measuredHeight);
                }
                if (i4 == childCount2 - 1) {
                    i6 = Math.max(i10, i6);
                    i9 += measuredHeight;
                }
                i8 = measuredHeight;
                i7 = i10;
            } else if (i4 == childCount2 - 1) {
                i6 = Math.max(i7, i6);
                i9 += i8;
            }
            i4++;
            i3 = 8;
        }
        if (mode != 1073741824) {
            size = getPaddingLeft() + i6 + getPaddingRight();
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingBottom() + getPaddingTop() + i9;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        String string = bundle.getString("key_choose_pos");
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("\\|")) {
                int parseInt = Integer.parseInt(str);
                this.Wwwwwwwwwwwwwww.add(Integer.valueOf(parseInt));
                s50 s50Var = (s50) getChildAt(parseInt);
                if (s50Var != null) {
                    s50Var.setChecked(true);
                }
            }
        }
        super.onRestoreInstanceState(bundle.getParcelable("key_default"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        String str = "";
        if (this.Wwwwwwwwwwwwwww.size() > 0) {
            for (Integer num : this.Wwwwwwwwwwwwwww) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, num.intValue(), "|");
            }
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -1, 0);
        }
        bundle.putString("key_choose_pos", str);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.Wwwwwwwwwww = motionEvent.getRawX();
        this.Wwwwwwwwww = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Wwwwwwwww = motionEvent.getRawX();
            this.Wwwwwww = motionEvent.getRawY();
            this.Wwwwww = Calendar.getInstance().getTimeInMillis();
            this.Wwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwww = MotionEvent.obtain(motionEvent);
            this.Wwwww.postDelayed(this.Wwww, 500L);
        } else if (action == 1) {
            this.Wwwwwwww = motionEvent.getRawX();
            if (!(Math.abs(this.Wwwwwwwww - this.Wwwwwwwwwww) > 10.0f || Math.abs(this.Wwwwwww - this.Wwwwwwwwww) > 10.0f)) {
                if (Calendar.getInstance().getTimeInMillis() - this.Wwwwww <= 500) {
                    this.Wwwwwwwwwwwwwwww = null;
                    this.Wwwww.removeCallbacks(this.Wwww);
                    s50 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) MotionEvent.obtain(motionEvent).getX(), (int) MotionEvent.obtain(motionEvent).getY());
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        if (this.Wwwwwwwwwwwwwwwwww) {
                            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww) {
                                if (this.Wwwwwwwwwwwwwwwww == 1 && this.Wwwwwwwwwwwwwww.size() == 1) {
                                    Integer next = this.Wwwwwwwwwwwwwww.iterator().next();
                                    ((s50) getChildAt(next.intValue())).setChecked(false);
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setChecked(true);
                                    this.Wwwwwwwwwwwwwww.remove(next);
                                } else if (this.Wwwwwwwwwwwwwwwww <= 0 || this.Wwwwwwwwwwwwwww.size() < this.Wwwwwwwwwwwwwwwww) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setChecked(true);
                                }
                                this.Wwwwwwwwwwwwwww.add(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3));
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setChecked(false);
                                this.Wwwwwwwwwwwwwww.remove(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3));
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwww;
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new HashSet(this.Wwwwwwwwwwwwwww));
                            }
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwww;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getTagView();
                            SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            String str = SearchHistoryFragment.this.Wwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                            if (SearchHistoryFragment.this.getActivity() instanceof SearchActivity) {
                                ((SearchActivity) SearchHistoryFragment.this.getActivity()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                            }
                            return true;
                        }
                    }
                }
            } else {
                this.Wwwwwwwwwwwwwwww = null;
                this.Wwwww.removeCallbacks(this.Wwww);
                int i = ((this.Wwwwwwww - this.Wwwwwwwww) > 200.0f ? 1 : ((this.Wwwwwwww - this.Wwwwwwwww) == 200.0f ? 0 : -1));
            }
        }
        return true;
    }

    public void setAdapter(r50 r50Var) {
        this.Wwwwwwwwwwwwwwwwwww = r50Var;
        r50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
        this.Wwwwwwwwwwwwwww.clear();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setMaxSelectCount(int i) {
        if (this.Wwwwwwwwwwwwwww.size() > i) {
            this.Wwwwwwwwwwwwwww.clear();
        }
        this.Wwwwwwwwwwwwwwwww = i;
    }

    public void setOnSelectListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            setClickable(true);
        }
    }

    public void setOnTagClickListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            setClickable(true);
        }
    }

    public void setOnTagLongClickListener(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            setLongClickable(true);
        }
    }
}
