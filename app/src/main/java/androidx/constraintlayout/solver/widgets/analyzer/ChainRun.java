package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class ChainRun extends WidgetRun {
    public int chainStyle;
    public ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.orientation = i;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        do {
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget2.getPreviousChainMember(this.orientation);
        } while (constraintWidget2 != null);
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i = this.orientation;
            if (i == 0) {
                next.widget.horizontalChainRun = this;
            } else if (i == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
        addTarget(r5.end, r1, -r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
        if (r1 != null) goto L23;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void apply() {
        DependencyNode target;
        int margin;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target2 = getTarget(constraintAnchor, 0);
            int margin2 = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin2 = firstVisibleWidget.mLeft.getMargin();
            }
            if (target2 != null) {
                addTarget(this.start, target2, margin2);
            }
            target = getTarget(constraintAnchor2, 0);
            margin = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin = lastVisibleWidget.mRight.getMargin();
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            target = getTarget(constraintAnchor4, 1);
            margin = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin = lastVisibleWidget2.mBottom.getMargin();
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            j = widgetRun.end.margin + widgetRun.getWrapDimension() + j + widgetRun.start.margin;
        }
        return j;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ChainRun ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "<");
            sb = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + it.next(), "> ");
        }
        return sb;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0198, code lost:
        if (r7 != r9) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01c5, code lost:
        r12.dimension.resolve(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01c2, code lost:
        r16 = r16 + 1;
        r9 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01c0, code lost:
        if (r7 != r9) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x03d6, code lost:
        r3 = r3 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
        if (r2.dimension.resolved != false) goto L68;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        float f2;
        int i9;
        int max;
        if (!this.start.resolved || !this.end.resolved) {
            return;
        }
        ConstraintWidget parent = this.widget.getParent();
        boolean isRtl = (parent == null || !(parent instanceof ConstraintWidgetContainer)) ? false : ((ConstraintWidgetContainer) parent).isRtl();
        int i10 = this.end.value - this.start.value;
        int size = this.widgets.size();
        int i11 = 0;
        while (true) {
            i = -1;
            i2 = 8;
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (this.widgets.get(i11).widget.getVisibility() != 8) {
                break;
            } else {
                i11++;
            }
        }
        int i12 = size - 1;
        int i13 = i12;
        while (true) {
            if (i13 < 0) {
                break;
            }
            if (this.widgets.get(i13).widget.getVisibility() != 8) {
                i = i13;
                break;
            }
            i13--;
        }
        int i14 = 0;
        while (i14 < 2) {
            int i15 = 0;
            i4 = 0;
            i5 = 0;
            int i16 = 0;
            f = 0.0f;
            while (i15 < size) {
                WidgetRun widgetRun = this.widgets.get(i15);
                if (widgetRun.widget.getVisibility() != i2) {
                    i16++;
                    if (i15 > 0 && i15 >= i11) {
                        i4 += widgetRun.start.margin;
                    }
                    int i17 = widgetRun.dimension.value;
                    boolean z = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (!z) {
                        if (widgetRun.matchConstraintsType == 1 && i14 == 0) {
                            i17 = widgetRun.dimension.wrapValue;
                            i5++;
                        }
                        z = true;
                    } else if (this.orientation == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                        return;
                    } else {
                        if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                            return;
                        }
                    }
                    if (!z) {
                        i5++;
                        float f3 = widgetRun.widget.mWeight[this.orientation];
                        if (f3 >= 0.0f) {
                            f += f3;
                        }
                    } else {
                        i4 += i17;
                    }
                    if (i15 < i12 && i15 < i) {
                        i4 += -widgetRun.end.margin;
                    }
                }
                i15++;
                i2 = 8;
            }
            if (i4 < i10 || i5 == 0) {
                i3 = i16;
                break;
            } else {
                i14++;
                i2 = 8;
            }
        }
        i3 = 0;
        i4 = 0;
        i5 = 0;
        f = 0.0f;
        int i18 = this.start.value;
        if (isRtl) {
            i18 = this.end.value;
        }
        if (i4 > i10) {
            int i19 = (int) (((i4 - i10) / 2.0f) + 0.5f);
            i18 = isRtl ? i18 + i19 : i18 - i19;
        }
        if (i5 > 0) {
            float f4 = i10 - i4;
            int i20 = (int) ((f4 / i5) + 0.5f);
            int i21 = 0;
            int i22 = 0;
            while (i21 < size) {
                WidgetRun widgetRun2 = this.widgets.get(i21);
                int i23 = i20;
                if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !widgetRun2.dimension.resolved) {
                    int i24 = f > 0.0f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f4) / f) + 0.5f) : i23;
                    if (this.orientation == 0) {
                        ConstraintWidget constraintWidget = widgetRun2.widget;
                        f2 = f4;
                        int i25 = constraintWidget.mMatchConstraintMaxWidth;
                        i9 = i4;
                        i8 = i18;
                        max = Math.max(constraintWidget.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? Math.min(i24, widgetRun2.dimension.wrapValue) : i24);
                        if (i25 > 0) {
                            max = Math.min(i25, max);
                        }
                    } else {
                        i8 = i18;
                        f2 = f4;
                        i9 = i4;
                        ConstraintWidget constraintWidget2 = widgetRun2.widget;
                        int i26 = constraintWidget2.mMatchConstraintMaxHeight;
                        max = Math.max(constraintWidget2.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? Math.min(i24, widgetRun2.dimension.wrapValue) : i24);
                        if (i26 > 0) {
                            max = Math.min(i26, max);
                        }
                    }
                } else {
                    i8 = i18;
                    f2 = f4;
                    i9 = i4;
                }
                i21++;
                i20 = i23;
                f4 = f2;
                i4 = i9;
                i18 = i8;
            }
            i6 = i18;
            int i27 = i4;
            if (i22 > 0) {
                i5 -= i22;
                int i28 = 0;
                for (int i29 = 0; i29 < size; i29++) {
                    WidgetRun widgetRun3 = this.widgets.get(i29);
                    if (widgetRun3.widget.getVisibility() != 8) {
                        if (i29 > 0 && i29 >= i11) {
                            i28 += widgetRun3.start.margin;
                        }
                        i28 += widgetRun3.dimension.value;
                        if (i29 < i12 && i29 < i) {
                            i28 += -widgetRun3.end.margin;
                        }
                    }
                }
                i4 = i28;
            } else {
                i4 = i27;
            }
            i7 = 2;
            if (this.chainStyle == 2 && i22 == 0) {
                this.chainStyle = 0;
            }
        } else {
            i6 = i18;
            i7 = 2;
        }
        if (i4 > i10) {
            this.chainStyle = i7;
        }
        if (i3 > 0 && i5 == 0 && i11 == i) {
            this.chainStyle = i7;
        }
        int i30 = this.chainStyle;
        if (i30 == 1) {
            int i31 = i3 > 1 ? (i10 - i4) / (i3 - 1) : i3 == 1 ? (i10 - i4) / 2 : 0;
            if (i5 > 0) {
                i31 = 0;
            }
            int i32 = i6;
            for (int i33 = 0; i33 < size; i33++) {
                WidgetRun widgetRun4 = this.widgets.get(isRtl ? size - (i33 + 1) : i33);
                if (widgetRun4.widget.getVisibility() == 8) {
                    widgetRun4.start.resolve(i32);
                    widgetRun4.end.resolve(i32);
                } else {
                    if (i33 > 0) {
                        i32 = isRtl ? i32 - i31 : i32 + i31;
                    }
                    if (i33 > 0 && i33 >= i11) {
                        int i34 = widgetRun4.start.margin;
                        i32 = isRtl ? i32 - i34 : i32 + i34;
                    }
                    (isRtl ? widgetRun4.end : widgetRun4.start).resolve(i32);
                    DimensionDependency dimensionDependency = widgetRun4.dimension;
                    int i35 = dimensionDependency.value;
                    if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                        i35 = dimensionDependency.wrapValue;
                    }
                    i32 = isRtl ? i32 - i35 : i32 + i35;
                    (isRtl ? widgetRun4.start : widgetRun4.end).resolve(i32);
                    widgetRun4.resolved = true;
                    if (i33 < i12 && i33 < i) {
                        int i36 = -widgetRun4.end.margin;
                        i32 = isRtl ? i32 - i36 : i32 + i36;
                    }
                }
            }
        } else if (i30 == 0) {
            int i37 = (i10 - i4) / (i3 + 1);
            if (i5 > 0) {
                i37 = 0;
            }
            int i38 = i6;
            for (int i39 = 0; i39 < size; i39++) {
                WidgetRun widgetRun5 = this.widgets.get(isRtl ? size - (i39 + 1) : i39);
                if (widgetRun5.widget.getVisibility() == 8) {
                    widgetRun5.start.resolve(i38);
                    widgetRun5.end.resolve(i38);
                } else {
                    int i40 = isRtl ? i38 - i37 : i38 + i37;
                    if (i39 > 0 && i39 >= i11) {
                        int i41 = widgetRun5.start.margin;
                        i40 = isRtl ? i40 - i41 : i40 + i41;
                    }
                    (isRtl ? widgetRun5.end : widgetRun5.start).resolve(i40);
                    DimensionDependency dimensionDependency2 = widgetRun5.dimension;
                    int i42 = dimensionDependency2.value;
                    if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                        i42 = Math.min(i42, dimensionDependency2.wrapValue);
                    }
                    i38 = isRtl ? i40 - i42 : i40 + i42;
                    (isRtl ? widgetRun5.start : widgetRun5.end).resolve(i38);
                    if (i39 < i12 && i39 < i) {
                        int i43 = -widgetRun5.end.margin;
                        i38 = isRtl ? i38 - i43 : i38 + i43;
                    }
                }
            }
        } else if (i30 == 2) {
            float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
            if (isRtl) {
                horizontalBiasPercent = 1.0f - horizontalBiasPercent;
            }
            int i44 = (int) (((i10 - i4) * horizontalBiasPercent) + 0.5f);
            if (i44 < 0 || i5 > 0) {
                i44 = 0;
            }
            int i45 = isRtl ? i6 - i44 : i6 + i44;
            for (int i46 = 0; i46 < size; i46++) {
                WidgetRun widgetRun6 = this.widgets.get(isRtl ? size - (i46 + 1) : i46);
                if (widgetRun6.widget.getVisibility() == 8) {
                    widgetRun6.start.resolve(i45);
                    widgetRun6.end.resolve(i45);
                } else {
                    if (i46 > 0 && i46 >= i11) {
                        int i47 = widgetRun6.start.margin;
                        i45 = isRtl ? i45 - i47 : i45 + i47;
                    }
                    (isRtl ? widgetRun6.end : widgetRun6.start).resolve(i45);
                    DimensionDependency dimensionDependency3 = widgetRun6.dimension;
                    int i48 = dimensionDependency3.value;
                    if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                        i48 = dimensionDependency3.wrapValue;
                    }
                    i45 += i48;
                    (isRtl ? widgetRun6.start : widgetRun6.end).resolve(i45);
                    if (i46 < i12 && i46 < i) {
                        int i49 = -widgetRun6.end.margin;
                        i45 = isRtl ? i45 - i49 : i45 + i49;
                    }
                }
            }
        }
    }
}
