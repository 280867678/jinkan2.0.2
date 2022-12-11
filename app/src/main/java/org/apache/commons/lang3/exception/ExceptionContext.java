package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: classes4.dex */
public interface ExceptionContext {
    /* renamed from: addContextValue */
    ExceptionContext mo5171addContextValue(String str, Object obj);

    List<Pair<String, Object>> getContextEntries();

    Set<String> getContextLabels();

    List<Object> getContextValues(String str);

    Object getFirstContextValue(String str);

    String getFormattedExceptionMessage(String str);

    /* renamed from: setContextValue */
    ExceptionContext mo5172setContextValue(String str, Object obj);
}
