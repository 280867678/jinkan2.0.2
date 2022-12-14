package org.eclipse.jetty.util.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class ShutdownThread extends Thread {
    public static final Logger LOG = Log.getLogger(ShutdownThread.class);
    public static final ShutdownThread _thread = new ShutdownThread();
    public boolean _hooked;
    public final List<LifeCycle> _lifeCycles = new CopyOnWriteArrayList();

    public static synchronized void deregister(LifeCycle lifeCycle) {
        synchronized (ShutdownThread.class) {
            _thread._lifeCycles.remove(lifeCycle);
            if (_thread._lifeCycles.size() == 0) {
                _thread.unhook();
            }
        }
    }

    public static ShutdownThread getInstance() {
        return _thread;
    }

    private synchronized void hook() {
        try {
            if (!this._hooked) {
                Runtime.getRuntime().addShutdownHook(this);
            }
            this._hooked = true;
        } catch (Exception e) {
            LOG.ignore(e);
            LOG.info("shutdown already commenced", new Object[0]);
        }
    }

    public static synchronized void register(int i, LifeCycle... lifeCycleArr) {
        synchronized (ShutdownThread.class) {
            _thread._lifeCycles.addAll(i, Arrays.asList(lifeCycleArr));
            if (_thread._lifeCycles.size() > 0) {
                _thread.hook();
            }
        }
    }

    public static synchronized void register(LifeCycle... lifeCycleArr) {
        synchronized (ShutdownThread.class) {
            _thread._lifeCycles.addAll(Arrays.asList(lifeCycleArr));
            if (_thread._lifeCycles.size() > 0) {
                _thread.hook();
            }
        }
    }

    private synchronized void unhook() {
        try {
            this._hooked = false;
            Runtime.getRuntime().removeShutdownHook(this);
        } catch (Exception e) {
            LOG.ignore(e);
            LOG.debug("shutdown already commenced", new Object[0]);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        for (LifeCycle lifeCycle : _thread._lifeCycles) {
            try {
                if (lifeCycle.isStarted()) {
                    lifeCycle.stop();
                    LOG.debug("Stopped {}", lifeCycle);
                }
                if (lifeCycle instanceof Destroyable) {
                    ((Destroyable) lifeCycle).destroy();
                    LOG.debug("Destroyed {}", lifeCycle);
                }
            } catch (Exception e) {
                LOG.debug(e);
            }
        }
    }
}
