package org.simpleframework.xml.convert;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public interface Converter<T> {
    /* renamed from: read */
    T mo4863read(InputNode inputNode) throws Exception;

    void write(OutputNode outputNode, T t) throws Exception;
}
