package org.eclipse.jetty.client.security;

/* loaded from: classes4.dex */
public interface Realm {
    String getCredentials();

    String getId();

    String getPrincipal();
}
