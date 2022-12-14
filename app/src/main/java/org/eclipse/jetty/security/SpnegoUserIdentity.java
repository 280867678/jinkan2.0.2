package org.eclipse.jetty.security;

import java.security.Principal;
import java.util.List;
import javax.security.auth.Subject;
import org.eclipse.jetty.server.UserIdentity;

/* loaded from: classes4.dex */
public class SpnegoUserIdentity implements UserIdentity {
    public Principal _principal;
    public List<String> _roles;
    public Subject _subject;

    public SpnegoUserIdentity(Subject subject, Principal principal, List<String> list) {
        this._subject = subject;
        this._principal = principal;
        this._roles = list;
    }

    @Override // org.eclipse.jetty.server.UserIdentity
    public Subject getSubject() {
        return this._subject;
    }

    @Override // org.eclipse.jetty.server.UserIdentity
    public Principal getUserPrincipal() {
        return this._principal;
    }

    @Override // org.eclipse.jetty.server.UserIdentity
    public boolean isUserInRole(String str, UserIdentity.Scope scope) {
        return this._roles.contains(str);
    }
}
