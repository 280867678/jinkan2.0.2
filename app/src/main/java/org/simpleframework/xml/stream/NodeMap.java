package org.simpleframework.xml.stream;

import java.util.Iterator;
import org.simpleframework.xml.stream.Node;

/* loaded from: classes5.dex */
public interface NodeMap<T extends Node> extends Iterable<String> {
    /* renamed from: get */
    T mo5312get(String str);

    String getName();

    /* renamed from: getNode */
    T mo5313getNode();

    @Override // java.lang.Iterable
    Iterator<String> iterator();

    /* renamed from: put */
    T mo5314put(String str, String str2);

    /* renamed from: remove */
    T mo5315remove(String str);
}
