package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.InvalidPathException;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public enum LogicalOperator {
    AND("&&"),
    NOT("!"),
    OR("||");
    
    public final String operatorString;

    LogicalOperator(String str) {
        this.operatorString = str;
    }

    public static LogicalOperator fromString(String str) {
        if (AND.operatorString.equals(str)) {
            return AND;
        }
        if (NOT.operatorString.equals(str)) {
            return NOT;
        }
        if (!OR.operatorString.equals(str)) {
            throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to parse operator ", str));
        }
        return OR;
    }

    public String getOperatorString() {
        return this.operatorString;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.operatorString;
    }
}
