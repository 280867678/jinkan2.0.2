package org.eclipse.jetty.security.authentication;

import java.security.Principal;
import javax.security.auth.Subject;
import org.eclipse.jetty.security.IdentityService;

/* loaded from: classes4.dex */
public class LoginCallbackImpl implements LoginCallback {
    public Object credential;
    public String[] roles = IdentityService.NO_ROLES;
    public final Subject subject;
    public boolean success;
    public final String userName;
    public Principal userPrincipal;

    public LoginCallbackImpl(Subject subject, String str, Object obj) {
        this.subject = subject;
        this.userName = str;
        this.credential = obj;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public void clearPassword() {
        if (this.credential != null) {
            this.credential = null;
        }
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public Object getCredential() {
        return this.credential;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public String[] getRoles() {
        return this.roles;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public Subject getSubject() {
        return this.subject;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public String getUserName() {
        return this.userName;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public Principal getUserPrincipal() {
        return this.userPrincipal;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public boolean isSuccess() {
        return this.success;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public void setRoles(String[] strArr) {
        this.roles = strArr;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public void setSuccess(boolean z) {
        this.success = z;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginCallback
    public void setUserPrincipal(Principal principal) {
        this.userPrincipal = principal;
    }
}
