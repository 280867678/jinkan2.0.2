package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;

/* loaded from: classes5.dex */
public class FilterMapping implements Dumpable {
    public static final int ALL = 31;
    public static final int ASYNC = 16;
    public static final int DEFAULT = 0;
    public static final int ERROR = 8;
    public static final int FORWARD = 2;
    public static final int INCLUDE = 4;
    public static final int REQUEST = 1;
    public int _dispatches = 0;
    public String _filterName;
    public transient FilterHolder _holder;
    public String[] _pathSpecs;
    public String[] _servletNames;

    /* renamed from: org.eclipse.jetty.servlet.FilterMapping$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C30061 {
        public static final /* synthetic */ int[] $SwitchMap$javax$servlet$DispatcherType;

        static {
            int[] iArr = new int[DispatcherType.values().length];
            $SwitchMap$javax$servlet$DispatcherType = iArr;
            try {
                DispatcherType dispatcherType = DispatcherType.REQUEST;
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$javax$servlet$DispatcherType;
                DispatcherType dispatcherType2 = DispatcherType.ASYNC;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$javax$servlet$DispatcherType;
                DispatcherType dispatcherType3 = DispatcherType.FORWARD;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$javax$servlet$DispatcherType;
                DispatcherType dispatcherType4 = DispatcherType.INCLUDE;
                iArr4[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$javax$servlet$DispatcherType;
                DispatcherType dispatcherType5 = DispatcherType.ERROR;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int dispatch(DispatcherType dispatcherType) {
        int ordinal = dispatcherType.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return 4;
            }
            if (ordinal == 2) {
                return 1;
            }
            if (ordinal == 3) {
                return 16;
            }
            if (ordinal != 4) {
                throw new IllegalArgumentException(dispatcherType.toString());
            }
            return 8;
        }
        return 2;
    }

    public static DispatcherType dispatch(String str) {
        if ("request".equalsIgnoreCase(str)) {
            return DispatcherType.REQUEST;
        }
        if ("forward".equalsIgnoreCase(str)) {
            return DispatcherType.FORWARD;
        }
        if ("include".equalsIgnoreCase(str)) {
            return DispatcherType.INCLUDE;
        }
        if ("error".equalsIgnoreCase(str)) {
            return DispatcherType.ERROR;
        }
        if (!"async".equalsIgnoreCase(str)) {
            throw new IllegalArgumentException(str);
        }
        return DispatcherType.ASYNC;
    }

    public boolean appliesTo(int i) {
        int i2 = this._dispatches;
        return i2 == 0 ? i == 1 || (i == 16 && this._holder.isAsyncSupported()) : (i & i2) != 0;
    }

    public boolean appliesTo(String str, int i) {
        if (appliesTo(i)) {
            int i2 = 0;
            while (true) {
                String[] strArr = this._pathSpecs;
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2] != null && PathMap.match(strArr[i2], str, true)) {
                    return true;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return AggregateLifeCycle.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        appendable.append(String.valueOf(this)).append("\n");
    }

    public EnumSet<DispatcherType> getDispatcherTypes() {
        EnumSet<DispatcherType> noneOf = EnumSet.noneOf(DispatcherType.class);
        if ((this._dispatches & 8) == 8) {
            noneOf.add(DispatcherType.ERROR);
        }
        if ((this._dispatches & 2) == 2) {
            noneOf.add(DispatcherType.FORWARD);
        }
        if ((this._dispatches & 4) == 4) {
            noneOf.add(DispatcherType.INCLUDE);
        }
        if ((this._dispatches & 1) == 1) {
            noneOf.add(DispatcherType.REQUEST);
        }
        if ((this._dispatches & 16) == 16) {
            noneOf.add(DispatcherType.ASYNC);
        }
        return noneOf;
    }

    public FilterHolder getFilterHolder() {
        return this._holder;
    }

    public String getFilterName() {
        return this._filterName;
    }

    public String[] getPathSpecs() {
        return this._pathSpecs;
    }

    public String[] getServletNames() {
        return this._servletNames;
    }

    public void setDispatcherTypes(EnumSet<DispatcherType> enumSet) {
        this._dispatches = 0;
        if (enumSet != null) {
            if (enumSet.contains(DispatcherType.ERROR)) {
                this._dispatches |= 8;
            }
            if (enumSet.contains(DispatcherType.FORWARD)) {
                this._dispatches |= 2;
            }
            if (enumSet.contains(DispatcherType.INCLUDE)) {
                this._dispatches |= 4;
            }
            if (enumSet.contains(DispatcherType.REQUEST)) {
                this._dispatches |= 1;
            }
            if (!enumSet.contains(DispatcherType.ASYNC)) {
                return;
            }
            this._dispatches |= 16;
        }
    }

    public void setDispatches(int i) {
        this._dispatches = i;
    }

    public void setFilterHolder(FilterHolder filterHolder) {
        this._holder = filterHolder;
        setFilterName(filterHolder.getName());
    }

    public void setFilterName(String str) {
        this._filterName = str;
    }

    public void setPathSpec(String str) {
        this._pathSpecs = new String[]{str};
    }

    public void setPathSpecs(String[] strArr) {
        this._pathSpecs = strArr;
    }

    public void setServletName(String str) {
        this._servletNames = new String[]{str};
    }

    public void setServletNames(String[] strArr) {
        this._servletNames = strArr;
    }

    public String toString() {
        return TypeUtil.asList(this._pathSpecs) + "/" + TypeUtil.asList(this._servletNames) + "==" + this._dispatches + "=>" + this._filterName;
    }
}
