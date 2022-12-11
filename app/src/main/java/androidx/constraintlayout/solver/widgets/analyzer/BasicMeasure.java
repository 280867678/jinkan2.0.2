package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    public static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    public static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    public ConstraintWidgetContainer constraintWidgetContainer;
    public final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    public Measure mMeasure = new Measure();

    /* loaded from: classes3.dex */
    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    /* loaded from: classes3.dex */
    public enum MeasureType {
    }

    /* loaded from: classes3.dex */
    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = z;
        boolean z2 = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > 0.0f;
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.useCurrentDimensions = false;
        return measure2.measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        int size = constraintWidgetContainer.mChildren.size();
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i);
            if (!(constraintWidget instanceof Guideline) && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                boolean z = true;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    z = false;
                }
                if (!z) {
                    measure(measurer, constraintWidget, false);
                    Metrics metrics = constraintWidgetContainer.mMetrics;
                    if (metrics != null) {
                        metrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String str, int i, int i2) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i);
        constraintWidgetContainer.setHeight(i2);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z;
        int i10;
        boolean z2;
        boolean z3;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z4;
        int i18;
        Metrics metrics;
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        int size = constraintWidgetContainer.mChildren.size();
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean enabled = Optimizer.enabled(i, 128);
        boolean z5 = enabled || Optimizer.enabled(i, 64);
        if (z5) {
            for (int i19 = 0; i19 < size; i19++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i19);
                boolean z6 = (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((constraintWidget.isInHorizontalChain() && z6) || ((constraintWidget.isInVerticalChain() && z6) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                    z5 = false;
                    break;
                }
            }
        }
        if (z5 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        if (z5 && ((i4 == 1073741824 && i6 == 1073741824) || enabled)) {
            int min = Math.min(constraintWidgetContainer.getMaxWidth(), i5);
            int min2 = Math.min(constraintWidgetContainer.getMaxHeight(), i7);
            if (i4 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                constraintWidgetContainer.setWidth(min);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i6 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                constraintWidgetContainer.setHeight(min2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                z = constraintWidgetContainer.directMeasure(enabled);
                i10 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer.directMeasureSetup(enabled);
                if (i4 == 1073741824) {
                    z4 = directMeasureSetup & constraintWidgetContainer.directMeasureWithOrientation(enabled, 0);
                    i18 = 1;
                } else {
                    z4 = directMeasureSetup;
                    i18 = 0;
                }
                if (i6 == 1073741824) {
                    boolean directMeasureWithOrientation = constraintWidgetContainer.directMeasureWithOrientation(enabled, 1) & z4;
                    i10 = i18 + 1;
                    z = directMeasureWithOrientation;
                } else {
                    i10 = i18;
                    z = z4;
                }
            }
            if (z) {
                constraintWidgetContainer.updateFromRuns(i4 == 1073741824, i6 == 1073741824);
            }
        } else {
            z = false;
            i10 = 0;
        }
        if (!z || i10 != 2) {
            if (size > 0) {
                measureChildren(constraintWidgetContainer);
            }
            int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
            int size2 = this.mVariableDimensionsWidgets.size();
            if (size > 0) {
                solveLinearSystem(constraintWidgetContainer, "First pass", width, height);
            }
            if (size2 > 0) {
                boolean z7 = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z8 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                int max = Math.max(constraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
                int max2 = Math.max(constraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
                int i20 = 0;
                boolean z9 = false;
                while (i20 < size2) {
                    ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i20);
                    if (!(constraintWidget2 instanceof VirtualLayout)) {
                        i15 = optimizationLevel;
                        i16 = width;
                        i17 = height;
                    } else {
                        int width2 = constraintWidget2.getWidth();
                        int height2 = constraintWidget2.getHeight();
                        i15 = optimizationLevel;
                        boolean measure = z9 | measure(measurer, constraintWidget2, true);
                        Metrics metrics2 = constraintWidgetContainer.mMetrics;
                        i16 = width;
                        i17 = height;
                        if (metrics2 != null) {
                            metrics2.measuredMatchWidgets++;
                        }
                        int width3 = constraintWidget2.getWidth();
                        int height3 = constraintWidget2.getHeight();
                        if (width3 != width2) {
                            constraintWidget2.setWidth(width3);
                            if (z7 && constraintWidget2.getRight() > max) {
                                max = Math.max(max, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + constraintWidget2.getRight());
                            }
                            measure = true;
                        }
                        if (height3 != height2) {
                            constraintWidget2.setHeight(height3);
                            if (z8 && constraintWidget2.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + constraintWidget2.getBottom());
                            }
                            measure = true;
                        }
                        z9 = measure | ((VirtualLayout) constraintWidget2).needSolverPass();
                    }
                    i20++;
                    optimizationLevel = i15;
                    width = i16;
                    height = i17;
                }
                int i21 = optimizationLevel;
                int i22 = width;
                int i23 = height;
                int i24 = 0;
                int i25 = 2;
                while (i24 < i25) {
                    int i26 = 0;
                    while (i26 < size2) {
                        ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i26);
                        if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.getVisibility() != 8 && ((!constraintWidget3.horizontalRun.dimension.resolved || !constraintWidget3.verticalRun.dimension.resolved) && !(constraintWidget3 instanceof VirtualLayout))) {
                            int width4 = constraintWidget3.getWidth();
                            int height4 = constraintWidget3.getHeight();
                            int baselineDistance = constraintWidget3.getBaselineDistance();
                            z9 |= measure(measurer, constraintWidget3, true);
                            Metrics metrics3 = constraintWidgetContainer.mMetrics;
                            i13 = i24;
                            i14 = size2;
                            if (metrics3 != null) {
                                metrics3.measuredMatchWidgets++;
                            }
                            int width5 = constraintWidget3.getWidth();
                            int height5 = constraintWidget3.getHeight();
                            if (width5 != width4) {
                                constraintWidget3.setWidth(width5);
                                if (z7 && constraintWidget3.getRight() > max) {
                                    max = Math.max(max, constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + constraintWidget3.getRight());
                                }
                                z9 = true;
                            }
                            if (height5 != height4) {
                                constraintWidget3.setHeight(height5);
                                if (z8 && constraintWidget3.getBottom() > max2) {
                                    max2 = Math.max(max2, constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + constraintWidget3.getBottom());
                                }
                                z9 = true;
                            }
                            if (constraintWidget3.hasBaseline() && baselineDistance != constraintWidget3.getBaselineDistance()) {
                                z9 = true;
                            }
                        } else {
                            i13 = i24;
                            i14 = size2;
                        }
                        i26++;
                        size2 = i14;
                        i24 = i13;
                    }
                    int i27 = i24;
                    int i28 = size2;
                    if (z9) {
                        i11 = i22;
                        i12 = i23;
                        solveLinearSystem(constraintWidgetContainer, "intermediate pass", i11, i12);
                        z9 = false;
                    } else {
                        i11 = i22;
                        i12 = i23;
                    }
                    i24 = i27 + 1;
                    i22 = i11;
                    i23 = i12;
                    i25 = 2;
                    size2 = i28;
                }
                int i29 = i22;
                int i30 = i23;
                if (z9) {
                    solveLinearSystem(constraintWidgetContainer, "2nd pass", i29, i30);
                    if (constraintWidgetContainer.getWidth() < max) {
                        constraintWidgetContainer.setWidth(max);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (constraintWidgetContainer.getHeight() < max2) {
                        constraintWidgetContainer.setHeight(max2);
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (z3) {
                        solveLinearSystem(constraintWidgetContainer, "3rd pass", i29, i30);
                    }
                }
                optimizationLevel = i21;
            }
            constraintWidgetContainer.setOptimizationLevel(optimizationLevel);
            return 0L;
        }
        return 0L;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer.invalidateGraph();
    }
}
