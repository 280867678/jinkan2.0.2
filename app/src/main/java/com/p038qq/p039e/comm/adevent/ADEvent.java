package com.p038qq.p039e.comm.adevent;

import com.p038qq.p039e.comm.util.GDTLogger;
import me.tvspark.outline;

/* renamed from: com.qq.e.comm.adevent.ADEvent */
/* loaded from: classes3.dex */
public class ADEvent {
    public final Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ADEvent(int i, Object... objArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = objArr;
        if (i < 100) {
            GDTLogger.m3646e("EventId 错误" + i);
        }
    }

    public <T> T getParam(int i, Class<T> cls) {
        Object[] objArr;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (cls == null || (objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null || objArr.length <= i) {
            return null;
        }
        T t = (T) objArr[i];
        if (t == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ADEvent 参数为空,type:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else if (cls.isInstance(objArr[i])) {
            return t;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ADEvent");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" 参数类型错误,期望类型");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("实际类型 ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(t.getClass().getName());
        }
        GDTLogger.m3646e(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        return null;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
