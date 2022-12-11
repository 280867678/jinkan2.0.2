package org.eclipse.jetty.security;

import java.io.IOException;
import me.tvspark.outline;
import org.eclipse.jetty.security.PropertyUserStore;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.Scanner;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.security.Credential;

/* loaded from: classes4.dex */
public class HashLoginService extends MappedLoginService implements PropertyUserStore.UserListener {
    public static final Logger LOG = Log.getLogger(HashLoginService.class);
    public String _config;
    public Resource _configResource;
    public PropertyUserStore _propertyUserStore;
    public int _refreshInterval = 0;
    public Scanner _scanner;

    public HashLoginService() {
    }

    public HashLoginService(String str) {
        setName(str);
    }

    public HashLoginService(String str, String str2) {
        setName(str);
        setConfig(str2);
    }

    @Override // org.eclipse.jetty.security.MappedLoginService, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        super.doStart();
        if (this._propertyUserStore == null) {
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("doStart: Starting new PropertyUserStore. PropertiesFile: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._config);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" refreshInterval: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._refreshInterval);
                logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            }
            PropertyUserStore propertyUserStore = new PropertyUserStore();
            this._propertyUserStore = propertyUserStore;
            propertyUserStore.setRefreshInterval(this._refreshInterval);
            this._propertyUserStore.setConfig(this._config);
            this._propertyUserStore.registerUserListener(this);
            this._propertyUserStore.start();
        }
    }

    @Override // org.eclipse.jetty.security.MappedLoginService, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        super.doStop();
        Scanner scanner = this._scanner;
        if (scanner != null) {
            scanner.stop();
        }
        this._scanner = null;
    }

    public String getConfig() {
        return this._config;
    }

    public void getConfig(String str) {
        this._config = str;
    }

    public Resource getConfigResource() {
        return this._configResource;
    }

    public int getRefreshInterval() {
        return this._refreshInterval;
    }

    @Override // org.eclipse.jetty.security.MappedLoginService
    public UserIdentity loadUser(String str) {
        return null;
    }

    @Override // org.eclipse.jetty.security.MappedLoginService
    public void loadUsers() throws IOException {
    }

    @Override // org.eclipse.jetty.security.PropertyUserStore.UserListener
    public void remove(String str) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("remove: ", str), new Object[0]);
        }
        removeUser(str);
    }

    public void setConfig(String str) {
        this._config = str;
    }

    public void setRefreshInterval(int i) {
        this._refreshInterval = i;
    }

    @Override // org.eclipse.jetty.security.PropertyUserStore.UserListener
    public void update(String str, Credential credential, String[] strArr) {
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update: ", str, " Roles: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(strArr.length);
            logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
        putUser(str, credential, strArr);
    }
}
