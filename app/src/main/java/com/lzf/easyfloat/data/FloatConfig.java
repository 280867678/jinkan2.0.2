package com.lzf.easyfloat.data;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.lzf.easyfloat.anim.AppFloatDefaultAnimator;
import com.lzf.easyfloat.anim.DefaultAnimator;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.FloatCallbacks;
import com.lzf.easyfloat.interfaces.OnAppFloatAnimator;
import com.lzf.easyfloat.interfaces.OnDisplayHeight;
import com.lzf.easyfloat.interfaces.OnFloatAnimator;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import com.lzf.easyfloat.interfaces.OnInvokeView;
import com.lzf.easyfloat.utils.DefaultDisplayHeight;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;

@ef0
/* loaded from: classes3.dex */
public final class FloatConfig {
    public OnAppFloatAnimator appFloatAnimator;
    public OnFloatCallbacks callbacks;
    public OnDisplayHeight displayHeight;
    public boolean dragEnable;
    public boolean filterSelf;
    public final Set<String> filterSet;
    public OnFloatAnimator floatAnimator;
    public FloatCallbacks floatCallbacks;
    public String floatTag;
    public int gravity;
    public boolean hasEditText;
    public boolean heightMatch;
    public OnInvokeView invokeView;
    public boolean isAnim;
    public boolean isDrag;
    public boolean isShow;
    public Integer layoutId;
    public View layoutView;
    public Pair<Integer, Integer> locationPair;
    public boolean needShow;
    public Pair<Integer, Integer> offsetPair;
    public ShowPattern showPattern;
    public SidePattern sidePattern;
    public boolean widthMatch;

    public FloatConfig() {
        this(null, null, null, false, false, false, false, false, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, false, false, ViewCompat.MEASURED_SIZE_MASK, null);
    }

    public FloatConfig(Integer num, View view, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SidePattern sidePattern, ShowPattern showPattern, boolean z6, boolean z7, int i, Pair<Integer, Integer> pair, Pair<Integer, Integer> pair2, OnInvokeView onInvokeView, OnFloatCallbacks onFloatCallbacks, FloatCallbacks floatCallbacks, OnFloatAnimator onFloatAnimator, OnAppFloatAnimator onAppFloatAnimator, OnDisplayHeight onDisplayHeight, Set<String> set, boolean z8, boolean z9) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(showPattern, "showPattern");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair, "offsetPair");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair2, "locationPair");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(onDisplayHeight, "displayHeight");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(set, "filterSet");
        this.layoutId = num;
        this.layoutView = view;
        this.floatTag = str;
        this.dragEnable = z;
        this.isDrag = z2;
        this.isAnim = z3;
        this.isShow = z4;
        this.hasEditText = z5;
        this.sidePattern = sidePattern;
        this.showPattern = showPattern;
        this.widthMatch = z6;
        this.heightMatch = z7;
        this.gravity = i;
        this.offsetPair = pair;
        this.locationPair = pair2;
        this.invokeView = onInvokeView;
        this.callbacks = onFloatCallbacks;
        this.floatCallbacks = floatCallbacks;
        this.floatAnimator = onFloatAnimator;
        this.appFloatAnimator = onAppFloatAnimator;
        this.displayHeight = onDisplayHeight;
        this.filterSet = set;
        this.filterSelf = z8;
        this.needShow = z9;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ FloatConfig(Integer num, View view, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SidePattern sidePattern, ShowPattern showPattern, boolean z6, boolean z7, int i, Pair pair, Pair pair2, OnInvokeView onInvokeView, OnFloatCallbacks onFloatCallbacks, FloatCallbacks floatCallbacks, OnFloatAnimator onFloatAnimator, OnAppFloatAnimator onAppFloatAnimator, OnDisplayHeight onDisplayHeight, Set set, boolean z8, boolean z9, int i2, gi0 gi0Var) {
        this(r1, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r17, r16, r18, r2, (32768 & i2) != 0 ? null : onInvokeView, (65536 & i2) != 0 ? null : onFloatCallbacks, (i2 & 131072) != 0 ? null : floatCallbacks, (i2 & 262144) != 0 ? new DefaultAnimator() : onFloatAnimator, (i2 & 524288) != 0 ? new AppFloatDefaultAnimator() : onAppFloatAnimator, (i2 & 1048576) != 0 ? new DefaultDisplayHeight() : onDisplayHeight, (i2 & 2097152) != 0 ? new LinkedHashSet() : set, (i2 & 4194304) == 0 ? z8 : r8, (i2 & 8388608) != 0 ? true : z9);
        int i3;
        boolean z10;
        Pair pair3;
        Pair pair4;
        Pair pair5;
        Integer num2 = (i2 & 1) != 0 ? null : num;
        View view2 = (i2 & 2) != 0 ? null : view;
        String str2 = (i2 & 4) != 0 ? null : str;
        boolean z11 = (i2 & 8) != 0 ? true : z;
        boolean z12 = false;
        boolean z13 = (i2 & 16) != 0 ? false : z2;
        boolean z14 = (i2 & 32) != 0 ? false : z3;
        boolean z15 = (i2 & 64) != 0 ? false : z4;
        boolean z16 = (i2 & 128) != 0 ? false : z5;
        SidePattern sidePattern2 = (i2 & 256) != 0 ? SidePattern.DEFAULT : sidePattern;
        ShowPattern showPattern2 = (i2 & 512) != 0 ? ShowPattern.CURRENT_ACTIVITY : showPattern;
        boolean z17 = (i2 & 1024) != 0 ? false : z6;
        boolean z18 = (i2 & 2048) != 0 ? false : z7;
        int i4 = (i2 & 4096) != 0 ? 0 : i;
        if ((i2 & 8192) != 0) {
            i3 = i4;
            z10 = z18;
            pair3 = new Pair(0, 0);
        } else {
            i3 = i4;
            z10 = z18;
            pair3 = pair;
        }
        if ((i2 & 16384) != 0) {
            pair4 = pair3;
            pair5 = new Pair(0, 0);
        } else {
            pair4 = pair3;
            pair5 = pair2;
        }
    }

    public final Integer component1() {
        return this.layoutId;
    }

    public final ShowPattern component10() {
        return this.showPattern;
    }

    public final boolean component11() {
        return this.widthMatch;
    }

    public final boolean component12() {
        return this.heightMatch;
    }

    public final int component13() {
        return this.gravity;
    }

    public final Pair<Integer, Integer> component14() {
        return this.offsetPair;
    }

    public final Pair<Integer, Integer> component15() {
        return this.locationPair;
    }

    public final OnInvokeView component16() {
        return this.invokeView;
    }

    public final OnFloatCallbacks component17() {
        return this.callbacks;
    }

    public final FloatCallbacks component18() {
        return this.floatCallbacks;
    }

    public final OnFloatAnimator component19() {
        return this.floatAnimator;
    }

    public final View component2() {
        return this.layoutView;
    }

    public final OnAppFloatAnimator component20() {
        return this.appFloatAnimator;
    }

    public final OnDisplayHeight component21() {
        return this.displayHeight;
    }

    public final Set<String> component22() {
        return this.filterSet;
    }

    public final boolean component23$easyfloat_release() {
        return this.filterSelf;
    }

    public final boolean component24$easyfloat_release() {
        return this.needShow;
    }

    public final String component3() {
        return this.floatTag;
    }

    public final boolean component4() {
        return this.dragEnable;
    }

    public final boolean component5() {
        return this.isDrag;
    }

    public final boolean component6() {
        return this.isAnim;
    }

    public final boolean component7() {
        return this.isShow;
    }

    public final boolean component8() {
        return this.hasEditText;
    }

    public final SidePattern component9() {
        return this.sidePattern;
    }

    public final FloatConfig copy(Integer num, View view, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SidePattern sidePattern, ShowPattern showPattern, boolean z6, boolean z7, int i, Pair<Integer, Integer> pair, Pair<Integer, Integer> pair2, OnInvokeView onInvokeView, OnFloatCallbacks onFloatCallbacks, FloatCallbacks floatCallbacks, OnFloatAnimator onFloatAnimator, OnAppFloatAnimator onAppFloatAnimator, OnDisplayHeight onDisplayHeight, Set<String> set, boolean z8, boolean z9) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(showPattern, "showPattern");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair, "offsetPair");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair2, "locationPair");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(onDisplayHeight, "displayHeight");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(set, "filterSet");
        return new FloatConfig(num, view, str, z, z2, z3, z4, z5, sidePattern, showPattern, z6, z7, i, pair, pair2, onInvokeView, onFloatCallbacks, floatCallbacks, onFloatAnimator, onAppFloatAnimator, onDisplayHeight, set, z8, z9);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof FloatConfig)) {
                return false;
            }
            FloatConfig floatConfig = (FloatConfig) obj;
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.layoutId, floatConfig.layoutId) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.layoutView, floatConfig.layoutView) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.floatTag, (Object) floatConfig.floatTag) && this.dragEnable == floatConfig.dragEnable && this.isDrag == floatConfig.isDrag && this.isAnim == floatConfig.isAnim && this.isShow == floatConfig.isShow && this.hasEditText == floatConfig.hasEditText && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.sidePattern, floatConfig.sidePattern) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.showPattern, floatConfig.showPattern) && this.widthMatch == floatConfig.widthMatch && this.heightMatch == floatConfig.heightMatch && this.gravity == floatConfig.gravity && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.offsetPair, floatConfig.offsetPair) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.locationPair, floatConfig.locationPair) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.invokeView, floatConfig.invokeView) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.callbacks, floatConfig.callbacks) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.floatCallbacks, floatConfig.floatCallbacks) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.floatAnimator, floatConfig.floatAnimator) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.appFloatAnimator, floatConfig.appFloatAnimator) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.displayHeight, floatConfig.displayHeight) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.filterSet, floatConfig.filterSet) && this.filterSelf == floatConfig.filterSelf && this.needShow == floatConfig.needShow;
        }
        return true;
    }

    public final OnAppFloatAnimator getAppFloatAnimator() {
        return this.appFloatAnimator;
    }

    public final OnFloatCallbacks getCallbacks() {
        return this.callbacks;
    }

    public final OnDisplayHeight getDisplayHeight() {
        return this.displayHeight;
    }

    public final boolean getDragEnable() {
        return this.dragEnable;
    }

    public final boolean getFilterSelf$easyfloat_release() {
        return this.filterSelf;
    }

    public final Set<String> getFilterSet() {
        return this.filterSet;
    }

    public final OnFloatAnimator getFloatAnimator() {
        return this.floatAnimator;
    }

    public final FloatCallbacks getFloatCallbacks() {
        return this.floatCallbacks;
    }

    public final String getFloatTag() {
        return this.floatTag;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final boolean getHasEditText() {
        return this.hasEditText;
    }

    public final boolean getHeightMatch() {
        return this.heightMatch;
    }

    public final OnInvokeView getInvokeView() {
        return this.invokeView;
    }

    public final Integer getLayoutId() {
        return this.layoutId;
    }

    public final View getLayoutView() {
        return this.layoutView;
    }

    public final Pair<Integer, Integer> getLocationPair() {
        return this.locationPair;
    }

    public final boolean getNeedShow$easyfloat_release() {
        return this.needShow;
    }

    public final Pair<Integer, Integer> getOffsetPair() {
        return this.offsetPair;
    }

    public final ShowPattern getShowPattern() {
        return this.showPattern;
    }

    public final SidePattern getSidePattern() {
        return this.sidePattern;
    }

    public final boolean getWidthMatch() {
        return this.widthMatch;
    }

    public int hashCode() {
        Integer num = this.layoutId;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        View view = this.layoutView;
        int hashCode2 = (hashCode + (view != null ? view.hashCode() : 0)) * 31;
        String str = this.floatTag;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.dragEnable;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode3 + i3) * 31;
        boolean z2 = this.isDrag;
        if (z2) {
            z2 = true;
        }
        int i6 = z2 ? 1 : 0;
        int i7 = z2 ? 1 : 0;
        int i8 = (i5 + i6) * 31;
        boolean z3 = this.isAnim;
        if (z3) {
            z3 = true;
        }
        int i9 = z3 ? 1 : 0;
        int i10 = z3 ? 1 : 0;
        int i11 = (i8 + i9) * 31;
        boolean z4 = this.isShow;
        if (z4) {
            z4 = true;
        }
        int i12 = z4 ? 1 : 0;
        int i13 = z4 ? 1 : 0;
        int i14 = (i11 + i12) * 31;
        boolean z5 = this.hasEditText;
        if (z5) {
            z5 = true;
        }
        int i15 = z5 ? 1 : 0;
        int i16 = z5 ? 1 : 0;
        int i17 = (i14 + i15) * 31;
        SidePattern sidePattern = this.sidePattern;
        int hashCode4 = (i17 + (sidePattern != null ? sidePattern.hashCode() : 0)) * 31;
        ShowPattern showPattern = this.showPattern;
        int hashCode5 = (hashCode4 + (showPattern != null ? showPattern.hashCode() : 0)) * 31;
        boolean z6 = this.widthMatch;
        if (z6) {
            z6 = true;
        }
        int i18 = z6 ? 1 : 0;
        int i19 = z6 ? 1 : 0;
        int i20 = (hashCode5 + i18) * 31;
        boolean z7 = this.heightMatch;
        if (z7) {
            z7 = true;
        }
        int i21 = z7 ? 1 : 0;
        int i22 = z7 ? 1 : 0;
        int i23 = (((i20 + i21) * 31) + this.gravity) * 31;
        Pair<Integer, Integer> pair = this.offsetPair;
        int hashCode6 = (i23 + (pair != null ? pair.hashCode() : 0)) * 31;
        Pair<Integer, Integer> pair2 = this.locationPair;
        int hashCode7 = (hashCode6 + (pair2 != null ? pair2.hashCode() : 0)) * 31;
        OnInvokeView onInvokeView = this.invokeView;
        int hashCode8 = (hashCode7 + (onInvokeView != null ? onInvokeView.hashCode() : 0)) * 31;
        OnFloatCallbacks onFloatCallbacks = this.callbacks;
        int hashCode9 = (hashCode8 + (onFloatCallbacks != null ? onFloatCallbacks.hashCode() : 0)) * 31;
        FloatCallbacks floatCallbacks = this.floatCallbacks;
        int hashCode10 = (hashCode9 + (floatCallbacks != null ? floatCallbacks.hashCode() : 0)) * 31;
        OnFloatAnimator onFloatAnimator = this.floatAnimator;
        int hashCode11 = (hashCode10 + (onFloatAnimator != null ? onFloatAnimator.hashCode() : 0)) * 31;
        OnAppFloatAnimator onAppFloatAnimator = this.appFloatAnimator;
        int hashCode12 = (hashCode11 + (onAppFloatAnimator != null ? onAppFloatAnimator.hashCode() : 0)) * 31;
        OnDisplayHeight onDisplayHeight = this.displayHeight;
        int hashCode13 = (hashCode12 + (onDisplayHeight != null ? onDisplayHeight.hashCode() : 0)) * 31;
        Set<String> set = this.filterSet;
        if (set != null) {
            i = set.hashCode();
        }
        int i24 = (hashCode13 + i) * 31;
        boolean z8 = this.filterSelf;
        if (z8) {
            z8 = true;
        }
        int i25 = z8 ? 1 : 0;
        int i26 = z8 ? 1 : 0;
        int i27 = (i24 + i25) * 31;
        boolean z9 = this.needShow;
        if (!z9) {
            i2 = z9 ? 1 : 0;
        }
        return i27 + i2;
    }

    public final boolean isAnim() {
        return this.isAnim;
    }

    public final boolean isDrag() {
        return this.isDrag;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setAnim(boolean z) {
        this.isAnim = z;
    }

    public final void setAppFloatAnimator(OnAppFloatAnimator onAppFloatAnimator) {
        this.appFloatAnimator = onAppFloatAnimator;
    }

    public final void setCallbacks(OnFloatCallbacks onFloatCallbacks) {
        this.callbacks = onFloatCallbacks;
    }

    public final void setDisplayHeight(OnDisplayHeight onDisplayHeight) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(onDisplayHeight, "<set-?>");
        this.displayHeight = onDisplayHeight;
    }

    public final void setDrag(boolean z) {
        this.isDrag = z;
    }

    public final void setDragEnable(boolean z) {
        this.dragEnable = z;
    }

    public final void setFilterSelf$easyfloat_release(boolean z) {
        this.filterSelf = z;
    }

    public final void setFloatAnimator(OnFloatAnimator onFloatAnimator) {
        this.floatAnimator = onFloatAnimator;
    }

    public final void setFloatCallbacks(FloatCallbacks floatCallbacks) {
        this.floatCallbacks = floatCallbacks;
    }

    public final void setFloatTag(String str) {
        this.floatTag = str;
    }

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setHasEditText(boolean z) {
        this.hasEditText = z;
    }

    public final void setHeightMatch(boolean z) {
        this.heightMatch = z;
    }

    public final void setInvokeView(OnInvokeView onInvokeView) {
        this.invokeView = onInvokeView;
    }

    public final void setLayoutId(Integer num) {
        this.layoutId = num;
    }

    public final void setLayoutView(View view) {
        this.layoutView = view;
    }

    public final void setLocationPair(Pair<Integer, Integer> pair) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair, "<set-?>");
        this.locationPair = pair;
    }

    public final void setNeedShow$easyfloat_release(boolean z) {
        this.needShow = z;
    }

    public final void setOffsetPair(Pair<Integer, Integer> pair) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair, "<set-?>");
        this.offsetPair = pair;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final void setShowPattern(ShowPattern showPattern) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(showPattern, "<set-?>");
        this.showPattern = showPattern;
    }

    public final void setSidePattern(SidePattern sidePattern) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "<set-?>");
        this.sidePattern = sidePattern;
    }

    public final void setWidthMatch(boolean z) {
        this.widthMatch = z;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FloatConfig(layoutId=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.layoutId);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", layoutView=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.layoutView);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", floatTag=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.floatTag);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", dragEnable=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.dragEnable);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", isDrag=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.isDrag);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", isAnim=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.isAnim);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", isShow=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.isShow);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", hasEditText=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.hasEditText);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", sidePattern=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.sidePattern);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", showPattern=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.showPattern);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", widthMatch=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.widthMatch);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", heightMatch=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.heightMatch);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", gravity=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.gravity);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", offsetPair=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.offsetPair);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", locationPair=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.locationPair);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", invokeView=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.invokeView);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", callbacks=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.callbacks);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", floatCallbacks=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.floatCallbacks);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", floatAnimator=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.floatAnimator);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", appFloatAnimator=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.appFloatAnimator);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", displayHeight=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.displayHeight);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", filterSet=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.filterSet);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", filterSelf=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.filterSelf);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", needShow=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.needShow);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
