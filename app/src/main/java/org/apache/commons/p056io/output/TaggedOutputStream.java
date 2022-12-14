package org.apache.commons.p056io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.p056io.TaggedIOException;

/* renamed from: org.apache.commons.io.output.TaggedOutputStream */
/* loaded from: classes4.dex */
public class TaggedOutputStream extends ProxyOutputStream {
    public final Serializable tag = UUID.randomUUID();

    public TaggedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.apache.commons.p056io.output.ProxyOutputStream
    public void handleIOException(IOException iOException) throws IOException {
        throw new TaggedIOException(iOException, this.tag);
    }

    public boolean isCauseOf(Exception exc) {
        return TaggedIOException.isTaggedWith(exc, this.tag);
    }

    public void throwIfCauseOf(Exception exc) throws IOException {
        TaggedIOException.throwCauseIfTaggedWith(exc, this.tag);
    }
}
