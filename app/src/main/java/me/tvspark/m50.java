package me.tvspark;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* loaded from: classes4.dex */
public final class m50 {
    static {
        try {
            Modifier.valueOf("DEFAULT");
        } catch (IllegalArgumentException unused) {
        }
    }

    public static <T> Set<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection<T> collection) {
        return Collections.unmodifiableSet(new LinkedHashSet(collection));
    }
}
