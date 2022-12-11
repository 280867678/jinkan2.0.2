package org.eclipse.jetty.security;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.security.auth.Subject;
import me.tvspark.outline;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Credential;

/* loaded from: classes4.dex */
public abstract class MappedLoginService extends AbstractLifeCycle implements LoginService {
    public static final Logger LOG = Log.getLogger(MappedLoginService.class);
    public String _name;
    public IdentityService _identityService = new DefaultIdentityService();
    public final ConcurrentMap<String, UserIdentity> _users = new ConcurrentHashMap();

    /* loaded from: classes4.dex */
    public static class Anonymous implements UserPrincipal, Serializable {
        public static final long serialVersionUID = 1097640442553284845L;

        @Override // org.eclipse.jetty.security.MappedLoginService.UserPrincipal
        public boolean authenticate(Object obj) {
            return false;
        }

        @Override // java.security.Principal
        public String getName() {
            return "Anonymous";
        }

        @Override // org.eclipse.jetty.security.MappedLoginService.UserPrincipal
        public boolean isAuthenticated() {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class KnownUser implements UserPrincipal, Serializable {
        public static final long serialVersionUID = -6226920753748399662L;
        public final Credential _credential;
        public final String _name;

        public KnownUser(String str, Credential credential) {
            this._name = str;
            this._credential = credential;
        }

        @Override // org.eclipse.jetty.security.MappedLoginService.UserPrincipal
        public boolean authenticate(Object obj) {
            Credential credential = this._credential;
            return credential != null && credential.check(obj);
        }

        @Override // java.security.Principal
        public String getName() {
            return this._name;
        }

        @Override // org.eclipse.jetty.security.MappedLoginService.UserPrincipal
        public boolean isAuthenticated() {
            return true;
        }

        @Override // java.security.Principal
        public String toString() {
            return this._name;
        }
    }

    /* loaded from: classes4.dex */
    public static class RolePrincipal implements Principal, Serializable {
        public static final long serialVersionUID = 2998397924051854402L;
        public final String _roleName;

        public RolePrincipal(String str) {
            this._roleName = str;
        }

        @Override // java.security.Principal
        public String getName() {
            return this._roleName;
        }
    }

    /* loaded from: classes4.dex */
    public interface UserPrincipal extends Principal, Serializable {
        boolean authenticate(Object obj);

        boolean isAuthenticated();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        loadUsers();
        super.doStart();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        super.doStop();
    }

    @Override // org.eclipse.jetty.security.LoginService
    public IdentityService getIdentityService() {
        return this._identityService;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public String getName() {
        return this._name;
    }

    public ConcurrentMap<String, UserIdentity> getUsers() {
        return this._users;
    }

    public abstract UserIdentity loadUser(String str);

    public abstract void loadUsers() throws IOException;

    public UserIdentity login(String str, Object obj) {
        UserIdentity userIdentity = this._users.get(str);
        if (userIdentity == null) {
            userIdentity = loadUser(str);
        }
        if (userIdentity == null || !((UserPrincipal) userIdentity.getUserPrincipal()).authenticate(obj)) {
            return null;
        }
        return userIdentity;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void logout(UserIdentity userIdentity) {
        LOG.debug("logout {}", userIdentity);
    }

    public synchronized UserIdentity putUser(String str, Object obj) {
        UserIdentity newUserIdentity;
        if (obj instanceof UserIdentity) {
            newUserIdentity = (UserIdentity) obj;
        } else {
            Credential credential = obj instanceof Credential ? (Credential) obj : Credential.getCredential(obj.toString());
            KnownUser knownUser = new KnownUser(str, credential);
            Subject subject = new Subject();
            subject.getPrincipals().add(knownUser);
            subject.getPrivateCredentials().add(credential);
            subject.setReadOnly();
            newUserIdentity = this._identityService.newUserIdentity(subject, knownUser, IdentityService.NO_ROLES);
        }
        this._users.put(str, newUserIdentity);
        return newUserIdentity;
    }

    public synchronized UserIdentity putUser(String str, Credential credential, String[] strArr) {
        UserIdentity newUserIdentity;
        KnownUser knownUser = new KnownUser(str, credential);
        Subject subject = new Subject();
        subject.getPrincipals().add(knownUser);
        subject.getPrivateCredentials().add(credential);
        if (strArr != null) {
            for (String str2 : strArr) {
                subject.getPrincipals().add(new RolePrincipal(str2));
            }
        }
        subject.setReadOnly();
        newUserIdentity = this._identityService.newUserIdentity(subject, knownUser, strArr);
        this._users.put(str, newUserIdentity);
        return newUserIdentity;
    }

    public void removeUser(String str) {
        this._users.remove(str);
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void setIdentityService(IdentityService identityService) {
        if (!isRunning()) {
            this._identityService = identityService;
            return;
        }
        throw new IllegalStateException("Running");
    }

    public void setName(String str) {
        if (!isRunning()) {
            this._name = str;
            return;
        }
        throw new IllegalStateException("Running");
    }

    public void setUsers(Map<String, UserIdentity> map) {
        if (!isRunning()) {
            this._users.clear();
            this._users.putAll(map);
            return;
        }
        throw new IllegalStateException("Running");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this._name, "]");
    }

    @Override // org.eclipse.jetty.security.LoginService
    public boolean validate(UserIdentity userIdentity) {
        return this._users.containsKey(userIdentity.getUserPrincipal().getName()) || loadUser(userIdentity.getUserPrincipal().getName()) != null;
    }
}
