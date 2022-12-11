package me.tvspark;

import com.jayway.jsonpath.EvaluationListener;
import com.jayway.jsonpath.Option;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class b30 {
    public final Collection<EvaluationListener> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Set<Option> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final b50 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public /* synthetic */ b30(b50 b50Var, e50 e50Var, EnumSet enumSet, Collection collection, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b50Var, "jsonProvider can not be null", new Object[0]);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e50Var, "mappingProvider can not be null", new Object[0]);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(enumSet, "setOptions can not be null", new Object[0]);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collection, "evaluationListeners can not be null", new Object[0]);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b50Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableSet(enumSet);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableCollection(collection);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Option option) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(option);
    }
}
