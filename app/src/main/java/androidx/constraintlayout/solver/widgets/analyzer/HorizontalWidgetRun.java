package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class HorizontalWidgetRun extends WidgetRun {
    public static int[] tempDimensions = new int[2];

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01771 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType */
        public static final /* synthetic */ int[] f42xbf6f0c8e;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f42xbf6f0c8e = iArr;
            try {
                WidgetRun.RunType runType = WidgetRun.RunType.START;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f42xbf6f0c8e;
                WidgetRun.RunType runType2 = WidgetRun.RunType.END;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f42xbf6f0c8e;
                WidgetRun.RunType runType3 = WidgetRun.RunType.CENTER;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else if (i5 != 1) {
                return;
            } else {
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6 && i7 <= i7) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i6 > i6 || i9 > i7) {
        } else {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget parent;
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        DependencyNode dependencyNode3;
        ConstraintAnchor constraintAnchor;
        List<Dependency> list;
        Dependency dependency;
        DependencyNode dependencyNode4;
        DependencyNode dependencyNode5;
        DependencyNode dependencyNode6;
        int i;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getWidth());
        }
        if (!this.dimension.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.widget.getHorizontalDimensionBehaviour();
            this.dimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((parent2 = this.widget.getParent()) != null && parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                    int width = (parent2.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    addTarget(this.start, parent2.horizontalRun.start, this.widget.mLeft.getMargin());
                    addTarget(this.end, parent2.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(width);
                    return;
                } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((parent = this.widget.getParent()) != null && parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
            addTarget(this.start, parent.horizontalRun.start, this.widget.mLeft.getMargin());
            addTarget(this.end, parent.horizontalRun.end, -this.widget.mRight.getMargin());
            return;
        }
        int i2 = 1;
        if (this.dimension.resolved) {
            ConstraintWidget constraintWidget2 = this.widget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                if (constraintAnchorArr[0].mTarget != null && constraintAnchorArr[1].mTarget != null) {
                    if (constraintWidget2.isInHorizontalChain()) {
                        this.start.margin = this.widget.mListAnchors[0].getMargin();
                        dependencyNode3 = this.end;
                        constraintAnchor = this.widget.mListAnchors[1];
                        dependencyNode3.margin = -constraintAnchor.getMargin();
                        return;
                    }
                    DependencyNode target = getTarget(this.widget.mListAnchors[0]);
                    if (target != null) {
                        addTarget(this.start, target, this.widget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target2 = getTarget(this.widget.mListAnchors[1]);
                    if (target2 != null) {
                        addTarget(this.end, target2, -this.widget.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
                ConstraintWidget constraintWidget3 = this.widget;
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget3.mListAnchors;
                if (constraintAnchorArr2[0].mTarget != null) {
                    DependencyNode target3 = getTarget(constraintAnchorArr2[0]);
                    if (target3 == null) {
                        return;
                    }
                    addTarget(this.start, target3, this.widget.mListAnchors[0].getMargin());
                } else if (constraintAnchorArr2[1].mTarget != null) {
                    DependencyNode target4 = getTarget(constraintAnchorArr2[1]);
                    if (target4 == null) {
                        return;
                    }
                    addTarget(this.end, target4, -this.widget.mListAnchors[1].getMargin());
                    dependencyNode5 = this.start;
                    dependencyNode6 = this.end;
                    i = -this.dimension.value;
                    addTarget(dependencyNode5, dependencyNode6, i);
                    return;
                } else if ((constraintWidget3 instanceof Helper) || constraintWidget3.getParent() == null || this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) {
                    return;
                } else {
                    addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                }
                dependencyNode5 = this.end;
                dependencyNode6 = this.start;
                i = this.dimension.value;
                addTarget(dependencyNode5, dependencyNode6, i);
                return;
            }
        }
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget4 = this.widget;
            int i3 = constraintWidget4.mMatchConstraintDefaultWidth;
            if (i3 == 2) {
                ConstraintWidget parent3 = constraintWidget4.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency = parent3.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency);
                    dimensionDependency.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency2 = this.dimension;
                    dimensionDependency2.delegateToWidgetRun = true;
                    dimensionDependency2.dependencies.add(this.start);
                    list = this.dimension.dependencies;
                    dependency = this.end;
                    list.add(dependency);
                }
            } else if (i3 == 3) {
                if (constraintWidget4.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget4.verticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    this.dimension.updateDelegate = this;
                    if (constraintWidget4.isInVerticalChain()) {
                        this.dimension.targets.add(this.widget.verticalRun.dimension);
                        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                        VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                        verticalWidgetRun2.dimension.updateDelegate = this;
                        this.dimension.targets.add(verticalWidgetRun2.start);
                        this.dimension.targets.add(this.widget.verticalRun.end);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        list = this.widget.verticalRun.end.dependencies;
                        dependency = this.dimension;
                        list.add(dependency);
                    } else if (this.widget.isInHorizontalChain()) {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                        list = this.dimension.dependencies;
                        dependency = this.widget.verticalRun.dimension;
                        list.add(dependency);
                    } else {
                        dependencyNode4 = this.widget.verticalRun.dimension;
                    }
                } else {
                    DimensionDependency dimensionDependency3 = constraintWidget4.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency3);
                    dimensionDependency3.dependencies.add(this.dimension);
                    this.widget.verticalRun.start.dependencies.add(this.dimension);
                    this.widget.verticalRun.end.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency4 = this.dimension;
                    dimensionDependency4.delegateToWidgetRun = true;
                    dimensionDependency4.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                    this.start.targets.add(this.dimension);
                    dependencyNode4 = this.end;
                }
                list = dependencyNode4.targets;
                dependency = this.dimension;
                list.add(dependency);
            }
            dependencyNode3.margin = -constraintAnchor.getMargin();
            return;
        }
        ConstraintWidget constraintWidget5 = this.widget;
        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget5.mListAnchors;
        if (constraintAnchorArr3[0].mTarget != null && constraintAnchorArr3[1].mTarget != null) {
            if (constraintWidget5.isInHorizontalChain()) {
                this.start.margin = this.widget.mListAnchors[0].getMargin();
                dependencyNode3 = this.end;
                constraintAnchor = this.widget.mListAnchors[1];
                dependencyNode3.margin = -constraintAnchor.getMargin();
                return;
            }
            DependencyNode target5 = getTarget(this.widget.mListAnchors[0]);
            DependencyNode target6 = getTarget(this.widget.mListAnchors[1]);
            target5.addDependency(this);
            target6.addDependency(this);
            this.mRunType = WidgetRun.RunType.CENTER;
            return;
        }
        ConstraintWidget constraintWidget6 = this.widget;
        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget6.mListAnchors;
        if (constraintAnchorArr4[0].mTarget != null) {
            DependencyNode target7 = getTarget(constraintAnchorArr4[0]);
            if (target7 == null) {
                return;
            }
            addTarget(this.start, target7, this.widget.mListAnchors[0].getMargin());
        } else if (constraintAnchorArr4[1].mTarget != null) {
            DependencyNode target8 = getTarget(constraintAnchorArr4[1]);
            if (target8 == null) {
                return;
            }
            addTarget(this.end, target8, -this.widget.mListAnchors[1].getMargin());
            dependencyNode = this.start;
            dependencyNode2 = this.end;
            i2 = -1;
            addTarget(dependencyNode, dependencyNode2, i2, this.dimension);
        } else if ((constraintWidget6 instanceof Helper) || constraintWidget6.getParent() == null) {
            return;
        } else {
            addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
        }
        dependencyNode = this.end;
        dependencyNode2 = this.start;
        addTarget(dependencyNode, dependencyNode2, i2, this.dimension);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.setX(dependencyNode.value);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
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
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HorizontalRun ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.widget.getDebugName());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x029a, code lost:
        if (r14 != 1) goto L130;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        float f;
        float f2;
        int i;
        int limitedDimension;
        int limitedDimension2;
        float f3;
        DimensionDependency dimensionDependency;
        int limitedDimension3;
        int limitedDimension4;
        float f4;
        ConstraintWidget constraintWidget;
        int ordinal = this.mRunType.ordinal();
        if (ordinal == 1) {
            updateRunStart(dependency);
        } else if (ordinal == 2) {
            updateRunEnd(dependency);
        } else if (ordinal == 3) {
            ConstraintWidget constraintWidget2 = this.widget;
            updateRunCenter(dependency, constraintWidget2.mLeft, constraintWidget2.mRight, 0);
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.widget;
            int i2 = constraintWidget3.mMatchConstraintDefaultWidth;
            if (i2 == 2) {
                ConstraintWidget parent = constraintWidget3.getParent();
                if (parent != null) {
                    DimensionDependency dimensionDependency2 = parent.horizontalRun.dimension;
                    if (dimensionDependency2.resolved) {
                        f = this.widget.mMatchConstraintPercentWidth;
                        f2 = dimensionDependency2.value;
                        i = (int) ((f2 * f) + 0.5f);
                    }
                }
            } else if (i2 == 3) {
                int i3 = constraintWidget3.mMatchConstraintDefaultHeight;
                if (i3 == 0 || i3 == 3) {
                    ConstraintWidget constraintWidget4 = this.widget;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget4.verticalRun;
                    DependencyNode dependencyNode = verticalWidgetRun.start;
                    DependencyNode dependencyNode2 = verticalWidgetRun.end;
                    boolean z = constraintWidget4.mLeft.mTarget != null;
                    boolean z2 = this.widget.mTop.mTarget != null;
                    boolean z3 = this.widget.mRight.mTarget != null;
                    boolean z4 = this.widget.mBottom.mTarget != null;
                    int dimensionRatioSide = this.widget.getDimensionRatioSide();
                    if (z && z2 && z3 && z4) {
                        float dimensionRatio = this.widget.getDimensionRatio();
                        if (dependencyNode.resolved && dependencyNode2.resolved) {
                            DependencyNode dependencyNode3 = this.start;
                            if (!dependencyNode3.readyToSolve || !this.end.readyToSolve) {
                                return;
                            }
                            computeInsetRatio(tempDimensions, dependencyNode3.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.value + dependencyNode.margin, dependencyNode2.value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                            this.dimension.resolve(tempDimensions[0]);
                            this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                            return;
                        }
                        DependencyNode dependencyNode4 = this.start;
                        if (dependencyNode4.resolved) {
                            DependencyNode dependencyNode5 = this.end;
                            if (dependencyNode5.resolved) {
                                if (!dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                                    return;
                                }
                                computeInsetRatio(tempDimensions, dependencyNode4.value + dependencyNode4.margin, dependencyNode5.value - dependencyNode5.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                            }
                        }
                        DependencyNode dependencyNode6 = this.start;
                        if (!dependencyNode6.readyToSolve || !this.end.readyToSolve || !dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                            return;
                        }
                        computeInsetRatio(tempDimensions, dependencyNode6.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                        this.dimension.resolve(tempDimensions[0]);
                        dimensionDependency = this.widget.verticalRun.dimension;
                        limitedDimension = tempDimensions[1];
                    } else if (!z || !z3) {
                        if (z2 && z4) {
                            if (!dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                                return;
                            }
                            float dimensionRatio2 = this.widget.getDimensionRatio();
                            int i4 = dependencyNode.targets.get(0).value + dependencyNode.margin;
                            int i5 = dependencyNode2.targets.get(0).value - dependencyNode2.margin;
                            if (dimensionRatioSide != -1) {
                                if (dimensionRatioSide == 0) {
                                    limitedDimension = getLimitedDimension(i5 - i4, 1);
                                    int i6 = (int) ((limitedDimension * dimensionRatio2) + 0.5f);
                                    limitedDimension2 = getLimitedDimension(i6, 0);
                                    if (i6 != limitedDimension2) {
                                        f3 = limitedDimension2 / dimensionRatio2;
                                        limitedDimension = (int) (f3 + 0.5f);
                                    }
                                    this.dimension.resolve(limitedDimension2);
                                    dimensionDependency = this.widget.verticalRun.dimension;
                                }
                            }
                            limitedDimension = getLimitedDimension(i5 - i4, 1);
                            int i7 = (int) ((limitedDimension / dimensionRatio2) + 0.5f);
                            limitedDimension2 = getLimitedDimension(i7, 0);
                            if (i7 != limitedDimension2) {
                                f3 = limitedDimension2 * dimensionRatio2;
                                limitedDimension = (int) (f3 + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension2);
                            dimensionDependency = this.widget.verticalRun.dimension;
                        }
                    } else if (!this.start.readyToSolve || !this.end.readyToSolve) {
                        return;
                    } else {
                        float dimensionRatio3 = this.widget.getDimensionRatio();
                        int i8 = this.start.targets.get(0).value + this.start.margin;
                        int i9 = this.end.targets.get(0).value - this.end.margin;
                        if (dimensionRatioSide == -1 || dimensionRatioSide == 0) {
                            limitedDimension3 = getLimitedDimension(i9 - i8, 0);
                            int i10 = (int) ((limitedDimension3 * dimensionRatio3) + 0.5f);
                            limitedDimension4 = getLimitedDimension(i10, 1);
                            if (i10 != limitedDimension4) {
                                f4 = limitedDimension4 / dimensionRatio3;
                                limitedDimension3 = (int) (f4 + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension3);
                            this.widget.verticalRun.dimension.resolve(limitedDimension4);
                        } else if (dimensionRatioSide == 1) {
                            limitedDimension3 = getLimitedDimension(i9 - i8, 0);
                            int i11 = (int) ((limitedDimension3 / dimensionRatio3) + 0.5f);
                            limitedDimension4 = getLimitedDimension(i11, 1);
                            if (i11 != limitedDimension4) {
                                f4 = limitedDimension4 * dimensionRatio3;
                                limitedDimension3 = (int) (f4 + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension3);
                            this.widget.verticalRun.dimension.resolve(limitedDimension4);
                        }
                    }
                    dimensionDependency.resolve(limitedDimension);
                } else {
                    int dimensionRatioSide2 = constraintWidget3.getDimensionRatioSide();
                    if (dimensionRatioSide2 != -1) {
                        if (dimensionRatioSide2 == 0) {
                            i = (int) ((constraintWidget.verticalRun.dimension.value / this.widget.getDimensionRatio()) + 0.5f);
                        } else if (dimensionRatioSide2 != 1) {
                            i = 0;
                        }
                    }
                    ConstraintWidget constraintWidget5 = this.widget;
                    f = constraintWidget5.verticalRun.dimension.value;
                    f2 = constraintWidget5.getDimensionRatio();
                    i = (int) ((f2 * f) + 0.5f);
                }
            }
            this.dimension.resolve(i);
        }
        DependencyNode dependencyNode7 = this.start;
        if (dependencyNode7.readyToSolve) {
            DependencyNode dependencyNode8 = this.end;
            if (!dependencyNode8.readyToSolve) {
                return;
            }
            if (dependencyNode7.resolved && dependencyNode8.resolved && this.dimension.resolved) {
                return;
            }
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget constraintWidget6 = this.widget;
                if (constraintWidget6.mMatchConstraintDefaultWidth == 0 && !constraintWidget6.isInHorizontalChain()) {
                    int i12 = this.start.targets.get(0).value;
                    DependencyNode dependencyNode9 = this.start;
                    int i13 = i12 + dependencyNode9.margin;
                    int i14 = this.end.targets.get(0).value + this.end.margin;
                    dependencyNode9.resolve(i13);
                    this.end.resolve(i14);
                    this.dimension.resolve(i14 - i13);
                    return;
                }
            }
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                int min = Math.min((this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin), this.dimension.wrapValue);
                ConstraintWidget constraintWidget7 = this.widget;
                int i15 = constraintWidget7.mMatchConstraintMaxWidth;
                int max = Math.max(constraintWidget7.mMatchConstraintMinWidth, min);
                if (i15 > 0) {
                    max = Math.min(i15, max);
                }
                this.dimension.resolve(max);
            }
            if (!this.dimension.resolved) {
                return;
            }
            DependencyNode dependencyNode10 = this.start.targets.get(0);
            DependencyNode dependencyNode11 = this.end.targets.get(0);
            int i16 = dependencyNode10.value + this.start.margin;
            int i17 = dependencyNode11.value + this.end.margin;
            float horizontalBiasPercent = this.widget.getHorizontalBiasPercent();
            if (dependencyNode10 == dependencyNode11) {
                i16 = dependencyNode10.value;
                i17 = dependencyNode11.value;
                horizontalBiasPercent = 0.5f;
            }
            this.start.resolve((int) ((((i17 - i16) - this.dimension.value) * horizontalBiasPercent) + i16 + 0.5f));
            this.end.resolve(this.start.value + this.dimension.value);
        }
    }
}
