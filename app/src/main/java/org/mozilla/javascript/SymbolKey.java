package org.mozilla.javascript;

import java.io.Serializable;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class SymbolKey implements Symbol, Serializable {
    public static final long serialVersionUID = -6019782713330994754L;
    public String name;
    public static final SymbolKey ITERATOR = new SymbolKey("Symbol.iterator");
    public static final SymbolKey TO_STRING_TAG = new SymbolKey("Symbol.toStringTag");
    public static final SymbolKey SPECIES = new SymbolKey("Symbol.species");
    public static final SymbolKey HAS_INSTANCE = new SymbolKey("Symbol.hasInstance");
    public static final SymbolKey IS_CONCAT_SPREADABLE = new SymbolKey("Symbol.isConcatSpreadable");
    public static final SymbolKey IS_REGEXP = new SymbolKey("Symbol.isRegExp");
    public static final SymbolKey TO_PRIMITIVE = new SymbolKey("Symbol.toPrimitive");
    public static final SymbolKey MATCH = new SymbolKey("Symbol.match");
    public static final SymbolKey REPLACE = new SymbolKey("Symbol.replace");
    public static final SymbolKey SEARCH = new SymbolKey("Symbol.search");
    public static final SymbolKey SPLIT = new SymbolKey("Symbol.split");
    public static final SymbolKey UNSCOPABLES = new SymbolKey("Symbol.unscopables");

    public SymbolKey(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        return obj instanceof SymbolKey ? obj == this : (obj instanceof NativeSymbol) && ((NativeSymbol) obj).getKey() == this;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public String toString() {
        if (this.name == null) {
            return "Symbol()";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Symbol(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.name);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
