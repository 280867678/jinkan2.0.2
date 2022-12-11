package org.eclipse.jetty.server.session;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import me.tvspark.ae0;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class HashedSession extends AbstractSession {
    public static final Logger LOG = Log.getLogger(HashedSession.class);
    public final HashSessionManager _hashSessionManager;
    public transient boolean _idled = false;
    public transient boolean _saveFailed = false;

    public HashedSession(HashSessionManager hashSessionManager, long j, long j2, String str) {
        super(hashSessionManager, j, j2, str);
        this._hashSessionManager = hashSessionManager;
    }

    public HashedSession(HashSessionManager hashSessionManager, ae0 ae0Var) {
        super(hashSessionManager, ae0Var);
        this._hashSessionManager = hashSessionManager;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSession
    public void checkValid() {
        if (this._hashSessionManager._idleSavePeriodMs != 0) {
            deIdle();
        }
        super.checkValid();
    }

    public synchronized void deIdle() {
        FileInputStream fileInputStream;
        Exception e;
        if (isIdled()) {
            access(System.currentTimeMillis());
            if (LOG.isDebugEnabled()) {
                LOG.debug("De-idling " + super.getId(), new Object[0]);
            }
            try {
                File file = new File(this._hashSessionManager._storeDir, super.getId());
                if (!file.exists() || !file.canRead()) {
                    throw new FileNotFoundException(file.getName());
                }
                fileInputStream = new FileInputStream(file);
                try {
                    this._idled = false;
                    this._hashSessionManager.restoreSession(fileInputStream, this);
                    C3009IO.close((InputStream) fileInputStream);
                    didActivate();
                    if (this._hashSessionManager._savePeriodMs == 0) {
                        file.delete();
                    }
                } catch (Exception e2) {
                    e = e2;
                    LOG.warn("Problem de-idling session " + super.getId(), e);
                    if (fileInputStream != null) {
                        C3009IO.close((InputStream) fileInputStream);
                    }
                    invalidate();
                }
            } catch (Exception e3) {
                fileInputStream = null;
                e = e3;
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSession
    public void doInvalidate() throws IllegalStateException {
        super.doInvalidate();
        if (this._hashSessionManager._storeDir == null || getId() == null) {
            return;
        }
        new File(this._hashSessionManager._storeDir, getId()).delete();
    }

    public synchronized void idle() throws Exception {
        save(false);
        this._idled = true;
    }

    public synchronized boolean isIdled() {
        return this._idled;
    }

    public synchronized boolean isSaveFailed() {
        return this._saveFailed;
    }

    public synchronized void save(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(getClusterId());
        dataOutputStream.writeUTF(getNodeId());
        dataOutputStream.writeLong(getCreationTime());
        dataOutputStream.writeLong(getAccessed());
        dataOutputStream.writeInt(getRequests());
        dataOutputStream.writeInt(getAttributes());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        Enumeration<String> attributeNames = getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String nextElement = attributeNames.nextElement();
            objectOutputStream.writeUTF(nextElement);
            objectOutputStream.writeObject(doGet(nextElement));
        }
        objectOutputStream.close();
    }

    public synchronized void save(boolean z) throws Exception {
        File file;
        FileOutputStream fileOutputStream;
        if (!isIdled() && !this._saveFailed) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Saving {} {}", super.getId(), Boolean.valueOf(z));
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                file = new File(this._hashSessionManager._storeDir, super.getId());
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    willPassivate();
                    save(fileOutputStream);
                    C3009IO.close((OutputStream) fileOutputStream);
                    if (z) {
                        didActivate();
                    } else {
                        clearAttributes();
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    saveFailed();
                    if (fileOutputStream2 != null) {
                        C3009IO.close((OutputStream) fileOutputStream2);
                    }
                    if (file != null) {
                        file.delete();
                    }
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                file = null;
            }
        }
    }

    public synchronized void saveFailed() {
        this._saveFailed = true;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSession
    public void setMaxInactiveInterval(int i) {
        super.setMaxInactiveInterval(i);
        if (getMaxInactiveInterval() > 0) {
            HashSessionManager hashSessionManager = this._hashSessionManager;
            if ((getMaxInactiveInterval() * 1000) / 10 >= hashSessionManager._scavengePeriodMs) {
                return;
            }
            hashSessionManager.setScavengePeriod((i + 9) / 10);
        }
    }
}
