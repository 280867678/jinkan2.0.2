package org.eclipse.jetty.p059io;

/* renamed from: org.eclipse.jetty.io.ConnectedEndPoint */
/* loaded from: classes4.dex */
public interface ConnectedEndPoint extends EndPoint {
    Connection getConnection();

    void setConnection(Connection connection);
}
