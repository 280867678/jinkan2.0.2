package org.eclipse.jetty.util.component;

import java.io.FileWriter;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class FileNoticeLifeCycleListener implements LifeCycle.Listener {
    public Logger LOG = Log.getLogger(FileNoticeLifeCycleListener.class);
    public final String _filename;

    public FileNoticeLifeCycleListener(String str) {
        this._filename = str;
    }

    private void writeState(String str, LifeCycle lifeCycle) {
        try {
            FileWriter fileWriter = new FileWriter(this._filename, true);
            fileWriter.append((CharSequence) str).append((CharSequence) StringUtils.SPACE).append((CharSequence) lifeCycle.toString()).append((CharSequence) "\n");
            fileWriter.close();
        } catch (Exception e) {
            this.LOG.warn(e);
        }
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleFailure(LifeCycle lifeCycle, Throwable th) {
        writeState(AbstractLifeCycle.FAILED, lifeCycle);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStarted(LifeCycle lifeCycle) {
        writeState(AbstractLifeCycle.STARTED, lifeCycle);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStarting(LifeCycle lifeCycle) {
        writeState(AbstractLifeCycle.STARTING, lifeCycle);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStopped(LifeCycle lifeCycle) {
        writeState(AbstractLifeCycle.STOPPED, lifeCycle);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStopping(LifeCycle lifeCycle) {
        writeState(AbstractLifeCycle.STOPPING, lifeCycle);
    }
}
