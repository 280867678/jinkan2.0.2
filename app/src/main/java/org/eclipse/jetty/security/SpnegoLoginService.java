package org.eclipse.jetty.security;

import java.util.Properties;
import javax.security.auth.Subject;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.Oid;

/* loaded from: classes4.dex */
public class SpnegoLoginService extends AbstractLifeCycle implements LoginService {
    public static final Logger LOG = Log.getLogger(SpnegoLoginService.class);
    public String _config;
    public IdentityService _identityService;
    public String _name;
    public String _targetName;

    public SpnegoLoginService() {
    }

    public SpnegoLoginService(String str) {
        setName(str);
    }

    public SpnegoLoginService(String str, String str2) {
        setName(str);
        setConfig(str2);
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        Properties properties = new Properties();
        properties.load(Resource.newResource(this._config).getInputStream());
        String property = properties.getProperty("targetName");
        this._targetName = property;
        LOG.debug("Target Name {}", property);
        super.doStart();
    }

    public String getConfig() {
        return this._config;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public IdentityService getIdentityService() {
        return this._identityService;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public String getName() {
        return this._name;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public UserIdentity login(String str, Object obj) {
        byte[] decode = B64Code.decode((String) obj);
        GSSManager gSSManager = GSSManager.getInstance();
        try {
            GSSContext createContext = gSSManager.createContext(gSSManager.createCredential(gSSManager.createName(this._targetName, (Oid) null), Integer.MAX_VALUE, new Oid("1.3.6.1.5.5.2"), 2));
            if (createContext == null) {
                LOG.debug("SpnegoUserRealm: failed to establish GSSContext", new Object[0]);
            } else {
                while (!createContext.isEstablished()) {
                    decode = createContext.acceptSecContext(decode, 0, decode.length);
                }
                if (createContext.isEstablished()) {
                    String gSSName = createContext.getSrcName().toString();
                    String substring = gSSName.substring(gSSName.indexOf(64) + 1);
                    LOG.debug("SpnegoUserRealm: established a security context", new Object[0]);
                    Logger logger = LOG;
                    logger.debug("Client Principal is: " + createContext.getSrcName(), new Object[0]);
                    Logger logger2 = LOG;
                    logger2.debug("Server Principal is: " + createContext.getTargName(), new Object[0]);
                    Logger logger3 = LOG;
                    logger3.debug("Client Default Role: " + substring, new Object[0]);
                    SpnegoUserPrincipal spnegoUserPrincipal = new SpnegoUserPrincipal(gSSName, decode);
                    Subject subject = new Subject();
                    subject.getPrincipals().add(spnegoUserPrincipal);
                    return this._identityService.newUserIdentity(subject, spnegoUserPrincipal, new String[]{substring});
                }
            }
        } catch (GSSException e) {
            LOG.warn(e);
        }
        return null;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void logout(UserIdentity userIdentity) {
    }

    public void setConfig(String str) {
        if (!isRunning()) {
            this._config = str;
            return;
        }
        throw new IllegalStateException("Running");
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void setIdentityService(IdentityService identityService) {
        this._identityService = identityService;
    }

    public void setName(String str) {
        if (!isRunning()) {
            this._name = str;
            return;
        }
        throw new IllegalStateException("Running");
    }

    @Override // org.eclipse.jetty.security.LoginService
    public boolean validate(UserIdentity userIdentity) {
        return false;
    }
}
