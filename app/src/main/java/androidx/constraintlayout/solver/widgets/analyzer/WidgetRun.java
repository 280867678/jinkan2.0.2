package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* loaded from: classes3.dex */
public abstract class WidgetRun implements Dependency {
    public ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public int matchConstraintsType;
    public RunGroup runGroup;
    public ConstraintWidget widget;
    public DimensionDependency dimension = new DimensionDependency(this);
    public int orientation = 0;
    public boolean resolved = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    public RunType mRunType = RunType.NONE;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01791 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type */
        public static final /* synthetic */ int[] f44x4c44d048;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f44x4c44d048 = iArr;
            try {
                ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f44x4c44d048;
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f44x4c44d048;
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f44x4c44d048;
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BASELINE;
                iArr4[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f44x4c44d048;
                ConstraintAnchor.Type type5 = ConstraintAnchor.Type.BOTTOM;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    private void resolveDimension(int i, int i2) {
        DimensionDependency dimensionDependency;
        int limitedDimension;
        int i3 = this.matchConstraintsType;
        if (i3 != 0) {
            if (i3 == 1) {
                int limitedDimension2 = getLimitedDimension(this.dimension.wrapValue, i);
                dimensionDependency = this.dimension;
                limitedDimension = Math.min(limitedDimension2, i2);
                dimensionDependency.resolve(limitedDimension);
            } else if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                ConstraintWidget constraintWidget = this.widget;
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget.horizontalRun;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = horizontalWidgetRun.dimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour == dimensionBehaviour2 && horizontalWidgetRun.matchConstraintsType == 3) {
                    VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                    if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                        return;
                    }
                }
                ConstraintWidget constraintWidget2 = this.widget;
                WidgetRun widgetRun = i == 0 ? constraintWidget2.verticalRun : constraintWidget2.horizontalRun;
                if (!widgetRun.dimension.resolved) {
                    return;
                }
                float dimensionRatio = this.widget.getDimensionRatio();
                this.dimension.resolve(i == 1 ? (int) ((widgetRun.dimension.value / dimensionRatio) + 0.5f) : (int) ((dimensionRatio * widgetRun.dimension.value) + 0.5f));
                return;
            } else {
                ConstraintWidget parent = this.widget.getParent();
                if (parent == null) {
                    return;
                }
                WidgetRun widgetRun2 = i == 0 ? parent.horizontalRun : parent.verticalRun;
                if (!widgetRun2.dimension.resolved) {
                    return;
                }
                ConstraintWidget constraintWidget3 = this.widget;
                i2 = (int) ((widgetRun2.dimension.value * (i == 0 ? constraintWidget3.mMatchConstraintPercentWidth : constraintWidget3.mMatchConstraintPercentHeight)) + 0.5f);
            }
        }
        dimensionDependency = this.dimension;
        limitedDimension = getLimitedDimension(i2, i);
        dimensionDependency.resolve(limitedDimension);
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i, int i2) {
        int max;
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i3 = constraintWidget.mMatchConstraintMaxWidth;
            max = Math.max(constraintWidget.mMatchConstraintMinWidth, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i4 = constraintWidget2.mMatchConstraintMaxHeight;
            max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i);
            if (i4 > 0) {
                max = Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int ordinal = constraintAnchor2.mType.ordinal();
        if (ordinal == 1) {
            widgetRun = constraintWidget.horizontalRun;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                widgetRun2 = constraintWidget.horizontalRun;
            } else if (ordinal != 4) {
                if (ordinal == 5) {
                    return constraintWidget.verticalRun.baseline;
                }
                return null;
            } else {
                widgetRun2 = constraintWidget.verticalRun;
            }
            return widgetRun2.end;
        } else {
            widgetRun = constraintWidget.verticalRun;
        }
        return widgetRun.start;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int ordinal = constraintAnchor.mTarget.mType.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return widgetRun.start;
        }
        if (ordinal != 3 && ordinal != 4) {
            return null;
        }
        return widgetRun.end;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            return dimensionDependency.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int size = this.start.targets.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.start.targets.get(i2).run != this) {
                i++;
            }
        }
        int size2 = this.end.targets.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (this.end.targets.get(i3).run != this) {
                i++;
            }
        }
        return i >= 2;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (!target.resolved || !target2.resolved) {
            return;
        }
        int margin = constraintAnchor.getMargin() + target.value;
        int margin2 = target2.value - constraintAnchor2.getMargin();
        int i2 = margin2 - margin;
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            resolveDimension(i, i2);
        }
        DimensionDependency dimensionDependency = this.dimension;
        if (!dimensionDependency.resolved) {
            return;
        }
        if (dimensionDependency.value == i2) {
            this.start.resolve(margin);
            this.end.resolve(margin2);
            return;
        }
        ConstraintWidget constraintWidget = this.widget;
        float horizontalBiasPercent = i == 0 ? constraintWidget.getHorizontalBiasPercent() : constraintWidget.getVerticalBiasPercent();
        if (target == target2) {
            margin = target.value;
            margin2 = target2.value;
            horizontalBiasPercent = 0.5f;
        }
        this.start.resolve((int) ((((margin2 - margin) - this.dimension.value) * horizontalBiasPercent) + margin + 0.5f));
        this.end.resolve(this.start.value + this.dimension.value);
    }

    public void updateRunEnd(Dependency dependency) {
    }

    public void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i) {
        int i2;
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            long j = dimensionDependency.value;
            if (isCenterConnection()) {
                i2 = this.start.margin - this.end.margin;
            } else if (i != 0) {
                return j - this.end.margin;
            } else {
                i2 = this.start.margin;
            }
            return j + i2;
        }
        return 0L;
    }
}
