package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    public DimensionDependency baselineDimension = null;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01781 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType */
        public static final /* synthetic */ int[] f43xbf6f0c8e;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f43xbf6f0c8e = iArr;
            try {
                WidgetRun.RunType runType = WidgetRun.RunType.START;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f43xbf6f0c8e;
                WidgetRun.RunType runType2 = WidgetRun.RunType.END;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f43xbf6f0c8e;
                WidgetRun.RunType runType3 = WidgetRun.RunType.CENTER;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.start.type = DependencyNode.Type.TOP;
        this.end.type = DependencyNode.Type.BOTTOM;
        dependencyNode.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02ed, code lost:
        if (r9.widget.hasBaseline() != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02ef, code lost:
        r0 = r9.baseline;
        r1 = r9.start;
        r2 = r9.baselineDimension;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x034e, code lost:
        if (r0.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x03fb, code lost:
        r0.dimension.dependencies.add(r9.dimension);
        r9.dimension.targets.add(r9.widget.horizontalRun.dimension);
        r9.dimension.updateDelegate = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0380, code lost:
        if (r9.widget.hasBaseline() != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03f9, code lost:
        if (r0.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L124;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void apply() {
        ConstraintWidget parent;
        HorizontalWidgetRun horizontalWidgetRun;
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        DimensionDependency dimensionDependency;
        WidgetRun widgetRun;
        DependencyNode dependencyNode3;
        DependencyNode dependencyNode4;
        int i;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getHeight());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
            if (this.widget.hasBaseline()) {
                this.baselineDimension = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.widget.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (parent2.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
                    addTarget(this.start, parent2.verticalRun.start, this.widget.mTop.getMargin());
                    addTarget(this.end, parent2.verticalRun.end, -this.widget.mBottom.getMargin());
                    this.dimension.resolve(height);
                    return;
                } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getHeight());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.widget.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            addTarget(this.start, parent.verticalRun.start, this.widget.mTop.getMargin());
            addTarget(this.end, parent.verticalRun.end, -this.widget.mBottom.getMargin());
            return;
        }
        if (this.dimension.resolved) {
            ConstraintWidget constraintWidget2 = this.widget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                if (constraintAnchorArr[2].mTarget == null || constraintAnchorArr[3].mTarget == null) {
                    ConstraintWidget constraintWidget3 = this.widget;
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget3.mListAnchors;
                    if (constraintAnchorArr2[2].mTarget != null) {
                        DependencyNode target = getTarget(constraintAnchorArr2[2]);
                        if (target == null) {
                            return;
                        }
                        addTarget(this.start, target, this.widget.mListAnchors[2].getMargin());
                        addTarget(this.end, this.start, this.dimension.value);
                        if (!this.widget.hasBaseline()) {
                            return;
                        }
                    } else if (constraintAnchorArr2[3].mTarget != null) {
                        DependencyNode target2 = getTarget(constraintAnchorArr2[3]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.widget.mListAnchors[3].getMargin());
                            addTarget(this.start, this.end, -this.dimension.value);
                        }
                        if (!this.widget.hasBaseline()) {
                            return;
                        }
                    } else if (constraintAnchorArr2[4].mTarget != null) {
                        DependencyNode target3 = getTarget(constraintAnchorArr2[4]);
                        if (target3 == null) {
                            return;
                        }
                        addTarget(this.baseline, target3, 0);
                        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
                        dependencyNode3 = this.end;
                        dependencyNode4 = this.start;
                        i = this.dimension.value;
                        addTarget(dependencyNode3, dependencyNode4, i);
                        return;
                    } else if ((constraintWidget3 instanceof Helper) || constraintWidget3.getParent() == null || this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) {
                        return;
                    } else {
                        addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                        addTarget(this.end, this.start, this.dimension.value);
                        if (!this.widget.hasBaseline()) {
                            return;
                        }
                    }
                } else {
                    if (constraintWidget2.isInVerticalChain()) {
                        this.start.margin = this.widget.mListAnchors[2].getMargin();
                        this.end.margin = -this.widget.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target4 = getTarget(this.widget.mListAnchors[2]);
                        if (target4 != null) {
                            addTarget(this.start, target4, this.widget.mListAnchors[2].getMargin());
                        }
                        DependencyNode target5 = getTarget(this.widget.mListAnchors[3]);
                        if (target5 != null) {
                            addTarget(this.end, target5, -this.widget.mListAnchors[3].getMargin());
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                    }
                    if (!this.widget.hasBaseline()) {
                        return;
                    }
                }
                dependencyNode3 = this.baseline;
                dependencyNode4 = this.start;
                i = this.widget.getBaselineDistance();
                addTarget(dependencyNode3, dependencyNode4, i);
                return;
            }
        }
        if (this.dimension.resolved || this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            this.dimension.addDependency(this);
        } else {
            ConstraintWidget constraintWidget4 = this.widget;
            int i2 = constraintWidget4.mMatchConstraintDefaultHeight;
            if (i2 == 2) {
                ConstraintWidget parent3 = constraintWidget4.getParent();
                if (parent3 != null) {
                    widgetRun = parent3.verticalRun;
                    DimensionDependency dimensionDependency2 = widgetRun.dimension;
                    this.dimension.targets.add(dimensionDependency2);
                    dimensionDependency2.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency3 = this.dimension;
                    dimensionDependency3.delegateToWidgetRun = true;
                    dimensionDependency3.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            } else if (i2 == 3 && !constraintWidget4.isInVerticalChain()) {
                ConstraintWidget constraintWidget5 = this.widget;
                if (constraintWidget5.mMatchConstraintDefaultWidth != 3) {
                    widgetRun = constraintWidget5.horizontalRun;
                    DimensionDependency dimensionDependency22 = widgetRun.dimension;
                    this.dimension.targets.add(dimensionDependency22);
                    dimensionDependency22.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency32 = this.dimension;
                    dimensionDependency32.delegateToWidgetRun = true;
                    dimensionDependency32.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            }
        }
        ConstraintWidget constraintWidget6 = this.widget;
        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget6.mListAnchors;
        if (constraintAnchorArr3[2].mTarget == null || constraintAnchorArr3[3].mTarget == null) {
            ConstraintWidget constraintWidget7 = this.widget;
            ConstraintAnchor[] constraintAnchorArr4 = constraintWidget7.mListAnchors;
            if (constraintAnchorArr4[2].mTarget != null) {
                DependencyNode target6 = getTarget(constraintAnchorArr4[2]);
                if (target6 != null) {
                    addTarget(this.start, target6, this.widget.mListAnchors[2].getMargin());
                    addTarget(this.end, this.start, 1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                    if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.getDimensionRatio() > 0.0f) {
                        horizontalWidgetRun = this.widget.horizontalRun;
                    }
                }
            } else if (constraintAnchorArr4[3].mTarget != null) {
                DependencyNode target7 = getTarget(constraintAnchorArr4[3]);
                if (target7 != null) {
                    addTarget(this.end, target7, -this.widget.mListAnchors[3].getMargin());
                    addTarget(this.start, this.end, -1, this.dimension);
                }
            } else if (constraintAnchorArr4[4].mTarget != null) {
                DependencyNode target8 = getTarget(constraintAnchorArr4[4]);
                if (target8 != null) {
                    addTarget(this.baseline, target8, 0);
                    addTarget(this.start, this.baseline, -1, this.baselineDimension);
                    dependencyNode = this.end;
                    dependencyNode2 = this.start;
                    dimensionDependency = this.dimension;
                }
            } else if (!(constraintWidget7 instanceof Helper) && constraintWidget7.getParent() != null) {
                addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                addTarget(this.end, this.start, 1, this.dimension);
                if (this.widget.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.getDimensionRatio() > 0.0f) {
                    horizontalWidgetRun = this.widget.horizontalRun;
                }
            }
            if (this.dimension.targets.size() == 0) {
                return;
            }
            this.dimension.readyToSolve = true;
            return;
        } else if (constraintWidget6.isInVerticalChain()) {
            this.start.margin = this.widget.mListAnchors[2].getMargin();
            this.end.margin = -this.widget.mListAnchors[3].getMargin();
        } else {
            DependencyNode target9 = getTarget(this.widget.mListAnchors[2]);
            DependencyNode target10 = getTarget(this.widget.mListAnchors[3]);
            target9.addDependency(this);
            target10.addDependency(this);
            this.mRunType = WidgetRun.RunType.CENTER;
        }
        addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
        if (this.dimension.targets.size() == 0) {
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.setY(dependencyNode.value);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultHeight == 0;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("VerticalRun ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.widget.getDebugName());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        float f;
        float f2;
        int i;
        ConstraintWidget constraintWidget;
        int ordinal = this.mRunType.ordinal();
        if (ordinal == 1) {
            updateRunStart(dependency);
        } else if (ordinal == 2) {
            updateRunEnd(dependency);
        } else if (ordinal == 3) {
            ConstraintWidget constraintWidget2 = this.widget;
            updateRunCenter(dependency, constraintWidget2.mTop, constraintWidget2.mBottom, 1);
            return;
        }
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.readyToSolve && !dimensionDependency.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.widget;
            int i2 = constraintWidget3.mMatchConstraintDefaultHeight;
            if (i2 == 2) {
                ConstraintWidget parent = constraintWidget3.getParent();
                if (parent != null) {
                    DimensionDependency dimensionDependency2 = parent.verticalRun.dimension;
                    if (dimensionDependency2.resolved) {
                        f = this.widget.mMatchConstraintPercentHeight;
                        f2 = dimensionDependency2.value;
                        i = (int) ((f2 * f) + 0.5f);
                    }
                }
            } else if (i2 == 3 && constraintWidget3.horizontalRun.dimension.resolved) {
                int dimensionRatioSide = constraintWidget3.getDimensionRatioSide();
                if (dimensionRatioSide != -1) {
                    if (dimensionRatioSide == 0) {
                        ConstraintWidget constraintWidget4 = this.widget;
                        f = constraintWidget4.horizontalRun.dimension.value;
                        f2 = constraintWidget4.getDimensionRatio();
                        i = (int) ((f2 * f) + 0.5f);
                    } else if (dimensionRatioSide != 1) {
                        i = 0;
                    }
                }
                i = (int) ((constraintWidget.horizontalRun.dimension.value / this.widget.getDimensionRatio()) + 0.5f);
            }
            this.dimension.resolve(i);
        }
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve) {
            DependencyNode dependencyNode2 = this.end;
            if (!dependencyNode2.readyToSolve) {
                return;
            }
            if (dependencyNode.resolved && dependencyNode2.resolved && this.dimension.resolved) {
                return;
            }
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget constraintWidget5 = this.widget;
                if (constraintWidget5.mMatchConstraintDefaultWidth == 0 && !constraintWidget5.isInVerticalChain()) {
                    int i3 = this.start.targets.get(0).value;
                    DependencyNode dependencyNode3 = this.start;
                    int i4 = i3 + dependencyNode3.margin;
                    int i5 = this.end.targets.get(0).value + this.end.margin;
                    dependencyNode3.resolve(i4);
                    this.end.resolve(i5);
                    this.dimension.resolve(i5 - i4);
                    return;
                }
            }
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                int i6 = (this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin);
                DimensionDependency dimensionDependency3 = this.dimension;
                int i7 = dimensionDependency3.wrapValue;
                if (i6 < i7) {
                    dimensionDependency3.resolve(i6);
                } else {
                    dimensionDependency3.resolve(i7);
                }
            }
            if (!this.dimension.resolved || this.start.targets.size() <= 0 || this.end.targets.size() <= 0) {
                return;
            }
            DependencyNode dependencyNode4 = this.start.targets.get(0);
            DependencyNode dependencyNode5 = this.end.targets.get(0);
            int i8 = dependencyNode4.value + this.start.margin;
            int i9 = dependencyNode5.value + this.end.margin;
            float verticalBiasPercent = this.widget.getVerticalBiasPercent();
            if (dependencyNode4 == dependencyNode5) {
                i8 = dependencyNode4.value;
                i9 = dependencyNode5.value;
                verticalBiasPercent = 0.5f;
            }
            this.start.resolve((int) ((((i9 - i8) - this.dimension.value) * verticalBiasPercent) + i8 + 0.5f));
            this.end.resolve(this.start.value + this.dimension.value);
        }
    }
}
