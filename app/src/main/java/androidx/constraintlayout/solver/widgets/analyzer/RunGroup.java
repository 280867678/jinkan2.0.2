package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    public int direction;
    public WidgetRun firstRun;
    public int groupIndex;
    public WidgetRun lastRun;
    public int position = 0;
    public boolean dual = false;
    public ArrayList<WidgetRun> runs = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i) {
        this.firstRun = null;
        this.lastRun = null;
        this.groupIndex = 0;
        int i2 = index;
        this.groupIndex = i2;
        index = i2 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.widget.isTerminalWidget[i]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.dependencies) {
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it = ((ChainRun) widgetRun).widgets.iterator();
                    while (it.hasNext()) {
                        defineTerminalWidget(it.next(), i);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i] = false;
                }
                defineTerminalWidget(dependencyNode2.run, i);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).widgets.iterator();
                    while (it2.hasNext()) {
                        defineTerminalWidget(it2.next(), i);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i] = false;
                }
                defineTerminalWidget(dependencyNode.run, i);
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.dependencies.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.dependencies.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j2 = Math.min(j2, traverseEnd(dependencyNode2, dependencyNode2.margin + j));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j2;
        }
        long wrapDimension = j - widgetRun.getWrapDimension();
        return Math.min(Math.min(j2, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
    }

    private long traverseStart(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.dependencies.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.dependencies.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j2 = Math.max(j2, traverseStart(dependencyNode2, dependencyNode2.margin + j));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j2;
        }
        long wrapDimension = j + widgetRun.getWrapDimension();
        return Math.max(Math.max(j2, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        WidgetRun widgetRun;
        DependencyNode dependencyNode;
        long j;
        long j2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun2 = this.firstRun;
        long j3 = 0;
        if (widgetRun2 instanceof ChainRun) {
            if (((ChainRun) widgetRun2).orientation != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(widgetRun2 instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun2 instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode3 = (i == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).start;
        DependencyNode dependencyNode4 = (i == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).end;
        boolean contains = this.firstRun.start.targets.contains(dependencyNode3);
        boolean contains2 = this.firstRun.end.targets.contains(dependencyNode4);
        long wrapDimension = this.firstRun.getWrapDimension();
        if (!contains || !contains2) {
            if (contains) {
                j2 = traverseStart(this.firstRun.start, dependencyNode2.margin);
                j = this.firstRun.start.margin + wrapDimension;
            } else if (!contains2) {
                return (this.firstRun.getWrapDimension() + widgetRun.start.margin) - this.firstRun.end.margin;
            } else {
                j = (-this.firstRun.end.margin) + wrapDimension;
                j2 = -traverseEnd(this.firstRun.end, dependencyNode.margin);
            }
            return Math.max(j2, j);
        }
        long traverseStart = traverseStart(this.firstRun.start, 0L);
        long traverseEnd = traverseEnd(this.firstRun.end, 0L);
        long j4 = traverseStart - wrapDimension;
        int i2 = this.firstRun.end.margin;
        if (j4 >= (-i2)) {
            j4 += i2;
        }
        int i3 = this.firstRun.start.margin;
        long j5 = ((-traverseEnd) - wrapDimension) - i3;
        if (j5 >= i3) {
            j5 -= i3;
        }
        float biasPercent = this.firstRun.widget.getBiasPercent(i);
        if (biasPercent > 0.0f) {
            j3 = (((float) j4) / (1.0f - biasPercent)) + (((float) j5) / biasPercent);
        }
        float f = (float) j3;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (f * biasPercent) + 0.5f + wrapDimension + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0f, biasPercent, f, 0.5f);
        WidgetRun widgetRun3 = this.firstRun;
        return (widgetRun3.start.margin + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - widgetRun3.end.margin;
    }

    public void defineTerminalWidgets(boolean z, boolean z2) {
        if (z) {
            WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z2) {
            WidgetRun widgetRun2 = this.firstRun;
            if (!(widgetRun2 instanceof VerticalWidgetRun)) {
                return;
            }
            defineTerminalWidget(widgetRun2, 1);
        }
    }
}
