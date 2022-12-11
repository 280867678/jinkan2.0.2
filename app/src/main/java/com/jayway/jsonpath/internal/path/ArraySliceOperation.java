package com.jayway.jsonpath.internal.path;

import me.tvspark.outline;

/* loaded from: classes3.dex */
public class ArraySliceOperation {
    public final Operation Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public enum Operation {
        SLICE_FROM,
        SLICE_TO,
        SLICE_BETWEEN
    }

    public ArraySliceOperation(Integer num, Integer num2, Operation operation) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = num;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = num2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = operation;
    }

    public static Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String[] strArr, int i) {
        if (strArr.length <= i || strArr[i].equals("")) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(strArr[i]));
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
        Integer num = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str = "";
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(num == null ? str : num.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Integer num2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (num2 != null) {
            str = num2.toString();
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str, "]");
    }
}
