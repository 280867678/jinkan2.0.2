package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DependencyGraph {
    public static final boolean USE_GROUPS = true;
    public ConstraintWidgetContainer container;
    public ConstraintWidgetContainer mContainer;
    public boolean mNeedBuildGraph = true;
    public boolean mNeedRedoMeasures = true;
    public ArrayList<WidgetRun> mRuns = new ArrayList<>();
    public ArrayList<RunGroup> runGroups = new ArrayList<>();
    public BasicMeasure.Measurer mMeasurer = null;
    public BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    public ArrayList<RunGroup> mGroups = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (widgetRun == constraintWidgetContainer.horizontalRun || widgetRun == constraintWidgetContainer.verticalRun) {
                return;
            }
            if (runGroup == null) {
                runGroup = new RunGroup(widgetRun, i2);
                arrayList.add(runGroup);
            }
            widgetRun.runGroup = runGroup;
            runGroup.add(widgetRun);
            for (Dependency dependency : widgetRun.start.dependencies) {
                if (dependency instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency, i, 0, dependencyNode2, arrayList, runGroup);
                }
            }
            for (Dependency dependency2 : widgetRun.end.dependencies) {
                if (dependency2 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency2, i, 1, dependencyNode2, arrayList, runGroup);
                }
            }
            if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                    if (dependency3 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency3, i, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
            for (DependencyNode dependencyNode3 : widgetRun.start.targets) {
                if (dependencyNode3 == dependencyNode2) {
                    runGroup.dual = true;
                }
                applyGroup(dependencyNode3, i, 0, dependencyNode2, arrayList, runGroup);
            }
            for (DependencyNode dependencyNode4 : widgetRun.end.targets) {
                if (dependencyNode4 == dependencyNode2) {
                    runGroup.dual = true;
                }
                applyGroup(dependencyNode4, i, 1, dependencyNode2, arrayList, runGroup);
            }
            if (i != 1 || !(widgetRun instanceof VerticalWidgetRun)) {
                return;
            }
            for (DependencyNode dependencyNode5 : ((VerticalWidgetRun) widgetRun).baseline.targets) {
                applyGroup(dependencyNode5, i, 2, dependencyNode2, arrayList, runGroup);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0076, code lost:
        if (r1.mMatchConstraintDefaultHeight == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        int i;
        int i2;
        ConstraintWidget constraintWidget;
        DependencyGraph dependencyGraph;
        int i3;
        float f;
        float height;
        DimensionDependency dimensionDependency;
        int height2;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
            if (next.getVisibility() != 8) {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.getDimensionRatio() > 0.0f) {
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else {
                        if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED)) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                            if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
                                if (next.mMatchConstraintDefaultWidth == 0) {
                                    next.mMatchConstraintDefaultWidth = 3;
                                }
                            }
                        }
                        next.mMatchConstraintDefaultHeight = 3;
                    }
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviour;
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                    dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviour2;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour4;
                horizontalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultWidth;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour5;
                verticalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultHeight;
                if ((dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int width = next.getWidth();
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        i = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i = width;
                    }
                    int height3 = next.getHeight();
                    if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        i2 = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i2 = height3;
                    }
                } else {
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        int i4 = next.mMatchConstraintDefaultWidth;
                        if (i4 == 3) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour5 == dimensionBehaviour6) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour6, 0);
                            }
                            i2 = next.getHeight();
                            i = (int) ((i2 * next.mDimensionRatio) + 0.5f);
                            dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                            dependencyGraph = this;
                            constraintWidget = next;
                            dimensionBehaviour4 = dimensionBehaviour5;
                            dependencyGraph.measure(constraintWidget, dimensionBehaviour4, i, dimensionBehaviour5, i2);
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                        } else if (i4 == 1) {
                            measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                            dimensionDependency = next.horizontalRun.dimension;
                            height2 = next.getWidth();
                            dimensionDependency.wrapValue = height2;
                        } else if (i4 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr2[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                i = (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f);
                                i2 = next.getHeight();
                                dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                            if (constraintAnchorArr[0].mTarget != null) {
                                if (constraintAnchorArr[1].mTarget == null) {
                                }
                            }
                            dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            i = 0;
                            i2 = 0;
                        }
                    }
                    if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        int i5 = next.mMatchConstraintDefaultHeight;
                        if (i5 == 3) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour4 == dimensionBehaviour7) {
                                measure(next, dimensionBehaviour7, 0, dimensionBehaviour7, 0);
                            }
                            i = next.getWidth();
                            height = next.mDimensionRatio;
                            if (next.getDimensionRatioSide() == -1) {
                                height = 1.0f / height;
                            }
                            f = i;
                            i2 = (int) ((f * height) + 0.5f);
                            dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                            dependencyGraph = this;
                            constraintWidget = next;
                            dimensionBehaviour4 = dimensionBehaviour5;
                            dependencyGraph.measure(constraintWidget, dimensionBehaviour4, i, dimensionBehaviour5, i2);
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                        } else if (i5 == 1) {
                            measure(next, dimensionBehaviour4, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            dimensionDependency = next.verticalRun.dimension;
                            height2 = next.getHeight();
                            dimensionDependency.wrapValue = height2;
                        } else if (i5 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr3[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr3[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                float f2 = next.mMatchConstraintPercentHeight;
                                i = next.getWidth();
                                i2 = (int) ((f2 * constraintWidgetContainer.getHeight()) + 0.5f);
                                dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget != null) {
                                if (constraintAnchorArr2[3].mTarget == null) {
                                }
                            }
                            dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            i = 0;
                            i2 = 0;
                        }
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour8 && dimensionBehaviour5 == dimensionBehaviour8) {
                        int i6 = next.mMatchConstraintDefaultWidth;
                        if (i6 == 1 || (i3 = next.mMatchConstraintDefaultHeight) == 1) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            measure(next, dimensionBehaviour9, 0, dimensionBehaviour9, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                            dimensionDependency = next.verticalRun.dimension;
                            height2 = next.getHeight();
                            dimensionDependency.wrapValue = height2;
                        } else if (i3 == 2 && i6 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr4 = constraintWidgetContainer.mListDimensionBehaviors;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = dimensionBehaviourArr4[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour10 == dimensionBehaviour11 || dimensionBehaviourArr4[0] == dimensionBehaviour11) {
                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr5 = constraintWidgetContainer.mListDimensionBehaviors;
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = dimensionBehaviourArr5[1];
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour12 == dimensionBehaviour13 || dimensionBehaviourArr5[1] == dimensionBehaviour13) {
                                    float f3 = next.mMatchConstraintPercentWidth;
                                    f = next.mMatchConstraintPercentHeight;
                                    i = (int) ((f3 * constraintWidgetContainer.getWidth()) + 0.5f);
                                    height = constraintWidgetContainer.getHeight();
                                    i2 = (int) ((f * height) + 0.5f);
                                    dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                                    dependencyGraph = this;
                                    constraintWidget = next;
                                    dimensionBehaviour4 = dimensionBehaviour5;
                                    dependencyGraph.measure(constraintWidget, dimensionBehaviour4, i, dimensionBehaviour5, i2);
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                }
                            }
                        }
                    }
                }
                dependencyGraph = this;
                constraintWidget = next;
                dependencyGraph.measure(constraintWidget, dimensionBehaviour4, i, dimensionBehaviour5, i2);
                next.horizontalRun.dimension.resolve(next.getWidth());
                next.verticalRun.dimension.resolve(next.getHeight());
            }
            next.measured = true;
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        int size = this.mGroups.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j = Math.max(j, this.mGroups.get(i2).computeWrapSize(constraintWidgetContainer, i));
        }
        return (int) j;
    }

    private void displayGraph() {
        Iterator<WidgetRun> it = this.mRuns.iterator();
        String str = "digraph {\n";
        while (it.hasNext()) {
            str = generateDisplayGraph(it.next(), str);
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "\n}\n");
        PrintStream printStream = System.out;
        printStream.println("content:<<\n" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + "\n>>");
    }

    private void findGroup(WidgetRun widgetRun, int i, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.start.dependencies) {
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun chainRun, String str) {
        int i = chainRun.orientation;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cluster_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(chainRun.widget.getDebugName());
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb);
        sb2.append(i == 0 ? "_h" : "_v");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("subgraph ", sb2.toString(), " {\n");
        Iterator<WidgetRun> it = chainRun.widgets.iterator();
        String str2 = "";
        while (it.hasNext()) {
            WidgetRun next = it.next();
            String debugName = next.widget.getDebugName();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(debugName);
            sb3.append(i == 0 ? "_HORIZONTAL" : "_VERTICAL");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, sb3.toString(), ";\n");
            str2 = generateDisplayGraph(next, str2);
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "}\n"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
        if (r9.widget.getDimensionRatio() > 0.0f) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0114, code lost:
        r9.widget.getDebugName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0112, code lost:
        if (r9.widget.getDimensionRatio() > 0.0f) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String generateDisplayGraph(WidgetRun widgetRun, String str) {
        String sb;
        StringBuilder sb2;
        boolean z;
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        if ((widgetRun instanceof HelperReferences) || !dependencyNode.dependencies.isEmpty() || (!dependencyNode2.dependencies.isEmpty() || !dependencyNode.targets.isEmpty()) || !dependencyNode2.targets.isEmpty()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(nodeDefinition(widgetRun));
            String sb3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            boolean isCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
            String generateDisplayNode = generateDisplayNode(dependencyNode2, isCenteredConnection, generateDisplayNode(dependencyNode, isCenteredConnection, sb3));
            boolean z2 = widgetRun instanceof VerticalWidgetRun;
            if (z2) {
                generateDisplayNode = generateDisplayNode(((VerticalWidgetRun) widgetRun).baseline, isCenteredConnection, generateDisplayNode);
            }
            if ((widgetRun instanceof HorizontalWidgetRun) || (((z = widgetRun instanceof ChainRun)) && ((ChainRun) widgetRun).orientation == 0)) {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
                if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(dependencyNode2.name());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" -> ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(dependencyNode.name());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("\n");
                        sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                        sb2 = new StringBuilder();
                    } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(dependencyNode.name());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" -> ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(dependencyNode2.name());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("\n");
                        sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
                        sb2 = new StringBuilder();
                    }
                    generateDisplayNode = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, generateDisplayNode, sb);
                } else if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                }
            } else if (z2 || (z && ((ChainRun) widgetRun).orientation == 1)) {
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour();
                if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(dependencyNode2.name());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(" -> ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(dependencyNode.name());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append("\n");
                        sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString();
                        sb2 = new StringBuilder();
                    } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(dependencyNode.name());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(" -> ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(dependencyNode2.name());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append("\n");
                        sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString();
                        sb2 = new StringBuilder();
                    }
                    generateDisplayNode = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, generateDisplayNode, sb);
                } else if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                }
            }
            return widgetRun instanceof ChainRun ? generateChainDisplayGraph((ChainRun) widgetRun, generateDisplayNode) : generateDisplayNode;
        }
        return str;
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean z, String str) {
        for (DependencyNode dependencyNode2 : dependencyNode.targets) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(dependencyNode.name());
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), " -> ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(dependencyNode2.name());
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            if (dependencyNode.margin > 0 || z || (dependencyNode.run instanceof HelperReferences)) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "[");
                if (dependencyNode.margin > 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "label=\""), dependencyNode.margin, "\"");
                    if (z) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, ",");
                    }
                }
                if (z) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, " style=dashed ");
                }
                if (dependencyNode.run instanceof HelperReferences) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, " style=bold,color=gray ");
                }
                sb = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "]");
            }
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "\n"));
        }
        return str;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        int i = 0;
        for (DependencyNode dependencyNode3 : dependencyNode.targets) {
            if (dependencyNode3 != dependencyNode2) {
                i++;
            }
        }
        int i2 = 0;
        for (DependencyNode dependencyNode4 : dependencyNode2.targets) {
            if (dependencyNode4 != dependencyNode) {
                i2++;
            }
        }
        return i > 0 && i2 > 0;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nodeDefinition(WidgetRun widgetRun) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str2;
        String str3;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        String str4;
        boolean z = widgetRun instanceof VerticalWidgetRun;
        String debugName = widgetRun.widget.getDebugName();
        ConstraintWidget constraintWidget = widgetRun.widget;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = !z ? constraintWidget.getHorizontalDimensionBehaviour() : constraintWidget.getVerticalDimensionBehaviour();
        RunGroup runGroup = widgetRun.runGroup;
        StringBuilder sb = new StringBuilder();
        sb.append(debugName);
        sb.append(!z ? "_HORIZONTAL" : "_VERTICAL");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString(), " [shape=none, label=<"), "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">"), "  <TR>"), "    <TD ");
        boolean z2 = widgetRun.start.resolved;
        if (!z) {
            if (z2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, " BGCOLOR=\"green\"");
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            str = " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
        } else {
            if (z2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, " BGCOLOR=\"green\"");
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            str = " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), "    <TD BORDER=\"1\" ");
        if (widgetRun.dimension.resolved && !widgetRun.widget.measured) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
            str2 = " BGCOLOR=\"green\" ";
        } else if (!widgetRun.dimension.resolved || !widgetRun.widget.measured) {
            if (!widgetRun.dimension.resolved && widgetRun.widget.measured) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                str2 = " BGCOLOR=\"yellow\" ";
            }
            if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, "style=\"dashed\"");
            }
            if (runGroup == null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(" [");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(runGroup.groupIndex + 1);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append("/");
                str3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, RunGroup.index, "]");
            } else {
                str3 = "";
            }
            String str5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 + ">" + debugName + str3 + " </TD>";
            if (z) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, "    <TD ");
                if (widgetRun.end.resolved) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, " BGCOLOR=\"green\"");
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                str4 = " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
            } else {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, "    <TD ");
                if ((widgetRun instanceof VerticalWidgetRun) && ((VerticalWidgetRun) widgetRun).baseline.resolved) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, " BGCOLOR=\"green\"");
                }
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, " PORT=\"BASELINE\" BORDER=\"1\">b</TD>"), "    <TD ");
                if (widgetRun.end.resolved) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9, " BGCOLOR=\"green\"");
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                str4 = " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(str4);
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), "  </TR></TABLE>"), ">];\n");
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
            str2 = " BGCOLOR=\"lightgray\" ";
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        }
        if (runGroup == null) {
        }
        String str52 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 + ">" + debugName + str3 + " </TD>";
        if (z) {
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(str4);
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), "  </TR></TABLE>"), ">];\n");
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        WidgetRun guidelineReference;
        arrayList.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arrayList.add(this.mContainer.horizontalRun);
        arrayList.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> it = this.mContainer.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                guidelineReference = new GuidelineReference(next);
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof HelperWidget) {
                    guidelineReference = new HelperReferences(next);
                }
            }
            arrayList.add(guidelineReference);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != this.mContainer) {
                next2.apply();
            }
        }
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.mNeedBuildGraph) {
            buildGraph();
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            boolean z = false;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                boolean[] zArr = next.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof Barrier) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            Iterator<RunGroup> it2 = this.mGroups.iterator();
            while (it2.hasNext()) {
                it2.next().defineTerminalWidgets(dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
    }

    public boolean directMeasure(boolean z) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = z & true;
        if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.measured = false;
                next.horizontalRun.reset();
                next.verticalRun.reset();
            }
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            constraintWidgetContainer.horizontalRun.reset();
            this.container.verticalRun.reset();
            this.mNeedRedoMeasures = false;
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph) {
            buildGraph();
        }
        int x = this.container.getX();
        int y = this.container.getY();
        this.container.horizontalRun.start.resolve(x);
        this.container.verticalRun.start.resolve(y);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
            if (z4) {
                Iterator<WidgetRun> it2 = this.mRuns.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it2.next().supportsWrapComputation()) {
                            z4 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z4 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                constraintWidgetContainer2.setWidth(computeWrap(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.horizontalRun.dimension.resolve(constraintWidgetContainer3.getWidth());
            }
            if (z4 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.setHeight(computeWrap(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
                constraintWidgetContainer5.verticalRun.dimension.resolve(constraintWidgetContainer5.getHeight());
            }
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.container.mListDimensionBehaviors;
        if (dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int width = this.container.getWidth() + x;
            this.container.horizontalRun.end.resolve(width);
            this.container.horizontalRun.dimension.resolve(width - x);
            measureWidgets();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.container.mListDimensionBehaviors;
            if (dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = this.container.getHeight() + y;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y);
            }
            measureWidgets();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<WidgetRun> it3 = this.mRuns.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != this.container || next2.resolved) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it4 = this.mRuns.iterator();
        while (it4.hasNext()) {
            WidgetRun next3 = it4.next();
            if (z2 || next3.widget != this.container) {
                if (!next3.start.resolved || ((!next3.end.resolved && !(next3 instanceof GuidelineReference)) || (!next3.dimension.resolved && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)))) {
                    z3 = false;
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z3;
    }

    public boolean directMeasureSetup(boolean z) {
        if (this.mNeedBuildGraph) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.measured = false;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimension.resolved = false;
                horizontalWidgetRun.resolved = false;
                horizontalWidgetRun.reset();
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimension.resolved = false;
                verticalWidgetRun.resolved = false;
                verticalWidgetRun.reset();
            }
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.horizontalRun;
            horizontalWidgetRun2.dimension.resolved = false;
            horizontalWidgetRun2.resolved = false;
            horizontalWidgetRun2.reset();
            VerticalWidgetRun verticalWidgetRun2 = this.container.verticalRun;
            verticalWidgetRun2.dimension.resolved = false;
            verticalWidgetRun2.resolved = false;
            verticalWidgetRun2.reset();
            buildGraph();
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        boolean z2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        DimensionDependency dimensionDependency;
        int height;
        boolean z3 = true;
        boolean z4 = z & true;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = this.container.getDimensionBehaviour(1);
        int x = this.container.getX();
        int y = this.container.getY();
        if (z4 && (dimensionBehaviour2 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = this.mRuns.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.orientation == i && !next.supportsWrapComputation()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer = this.container;
                    constraintWidgetContainer.setWidth(computeWrap(constraintWidgetContainer, 0));
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                    dimensionDependency = constraintWidgetContainer2.horizontalRun.dimension;
                    height = constraintWidgetContainer2.getWidth();
                    dimensionDependency.resolve(height);
                }
            } else if (z4 && dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.setHeight(computeWrap(constraintWidgetContainer3, 1));
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                dimensionDependency = constraintWidgetContainer4.verticalRun.dimension;
                height = constraintWidgetContainer4.getHeight();
                dimensionDependency.resolve(height);
            }
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.container.mListDimensionBehaviors;
        if (i == 0) {
            if (dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int width = this.container.getWidth() + x;
                this.container.horizontalRun.end.resolve(width);
                this.container.horizontalRun.dimension.resolve(width - x);
                z2 = true;
            }
            z2 = false;
        } else {
            if (dimensionBehaviourArr[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height2 = this.container.getHeight() + y;
                this.container.verticalRun.end.resolve(height2);
                this.container.verticalRun.dimension.resolve(height2 - y);
                z2 = true;
            }
            z2 = false;
        }
        measureWidgets();
        Iterator<WidgetRun> it2 = this.mRuns.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.orientation == i && (next2.widget != this.container || next2.resolved)) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it3 = this.mRuns.iterator();
        while (it3.hasNext()) {
            WidgetRun next3 = it3.next();
            if (next3.orientation == i && (z2 || next3.widget != this.container)) {
                if (!next3.start.resolved || !next3.end.resolved || (!(next3 instanceof ChainRun) && !next3.dimension.resolved)) {
                    z3 = false;
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour3);
        return z3;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0008 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureWidgets() {
        DimensionDependency dimensionDependency;
        int width;
        DimensionDependency dimensionDependency2;
        int width2;
        DimensionDependency dimensionDependency3;
        Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i = next.mMatchConstraintDefaultWidth;
                int i2 = next.mMatchConstraintDefaultHeight;
                boolean z2 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i == 1);
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                DimensionDependency dimensionDependency4 = next.horizontalRun.dimension;
                boolean z3 = dimensionDependency4.resolved;
                DimensionDependency dimensionDependency5 = next.verticalRun.dimension;
                boolean z4 = dimensionDependency5.resolved;
                if (z3 && z4) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
                    measure(next, dimensionBehaviour3, dimensionDependency4.value, dimensionBehaviour3, dimensionDependency5.value);
                } else if (!z3 || !z) {
                    if (z4 && z2) {
                        measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, next.verticalRun.dimension.value);
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            dimensionDependency2 = next.horizontalRun.dimension;
                            width2 = next.getWidth();
                            dimensionDependency2.wrapValue = width2;
                        } else {
                            dimensionDependency = next.horizontalRun.dimension;
                            width = next.getWidth();
                            dimensionDependency.resolve(width);
                        }
                    }
                    if (!next.measured && (dimensionDependency3 = next.verticalRun.baselineDimension) != null) {
                        dimensionDependency3.resolve(next.getBaselineDistance());
                    }
                } else {
                    measure(next, ConstraintWidget.DimensionBehaviour.FIXED, next.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.verticalRun.dimension.value);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        dimensionDependency2 = next.verticalRun.dimension;
                        width2 = next.getHeight();
                        dimensionDependency2.wrapValue = width2;
                        if (!next.measured) {
                            dimensionDependency3.resolve(next.getBaselineDistance());
                        }
                    } else {
                        dimensionDependency = next.verticalRun.dimension;
                        width = next.getHeight();
                        dimensionDependency.resolve(width);
                    }
                }
                next.measured = true;
                if (!next.measured) {
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }
}
