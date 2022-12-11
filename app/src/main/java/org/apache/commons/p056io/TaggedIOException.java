package org.apache.commons.p056io;

import java.io.IOException;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.TaggedIOException */
/* loaded from: classes4.dex */
public class TaggedIOException extends IOExceptionWithCause {
    public static final long serialVersionUID = -6994123481142850163L;
    public final Serializable tag;

    public TaggedIOException(IOException iOException, Serializable serializable) {
        super(iOException.getMessage(), iOException);
        this.tag = serializable;
    }

    public static boolean isTaggedWith(Throwable th, Object obj) {
        return obj != null && (th instanceof TaggedIOException) && obj.equals(((TaggedIOException) th).tag);
    }

    public static void throwCauseIfTaggedWith(Throwable th, Object obj) throws IOException {
        if (!isTaggedWith(th, obj)) {
            return;
        }
        throw ((TaggedIOException) th).mo5114getCause();
    }

    @Override // java.lang.Throwable
    /* renamed from: getCause */
    public IOException mo5114getCause() {
        return (IOException) super.getCause();
    }

    public Serializable getTag() {
        return this.tag;
    }
}
