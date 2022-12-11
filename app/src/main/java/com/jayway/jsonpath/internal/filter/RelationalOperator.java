package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.InvalidPathException;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public enum RelationalOperator {
    GTE(">="),
    LTE("<="),
    EQ("=="),
    TSEQ("==="),
    NE("!="),
    TSNE("!=="),
    LT("<"),
    GT(">"),
    REGEX("=~"),
    NIN("NIN"),
    IN("IN"),
    CONTAINS("CONTAINS"),
    ALL("ALL"),
    SIZE("SIZE"),
    EXISTS("EXISTS"),
    TYPE("TYPE"),
    MATCHES("MATCHES"),
    EMPTY("EMPTY"),
    SUBSETOF("SUBSETOF");
    
    public final String operatorString;

    RelationalOperator(String str) {
        this.operatorString = str;
    }

    public static RelationalOperator fromString(String str) {
        RelationalOperator[] values;
        for (RelationalOperator relationalOperator : values()) {
            if (relationalOperator.operatorString.equals(str.toUpperCase())) {
                return relationalOperator;
            }
        }
        throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Filter operator ", str, " is not supported!"));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.operatorString;
    }
}
