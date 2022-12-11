package org.eclipse.jetty.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import me.tvspark.outline;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class Scanner extends AbstractLifeCycle {
    public static final Logger LOG = Log.getLogger(Scanner.class);
    public static int __scannerId = 0;
    public FilenameFilter _filter;
    public int _scanInterval;
    public TimerTask _task;
    public Timer _timer;
    public int _scanCount = 0;
    public final List<Listener> _listeners = new ArrayList();
    public final Map<String, TimeNSize> _prevScan = new HashMap();
    public final Map<String, TimeNSize> _currentScan = new HashMap();
    public final List<File> _scanDirs = new ArrayList();
    public volatile boolean _running = false;
    public boolean _reportExisting = true;
    public boolean _reportDirs = true;
    public int _scanDepth = 0;
    public final Map<String, Notification> _notifications = new HashMap();

    /* renamed from: org.eclipse.jetty.util.Scanner$2 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C30152 {
        public static final /* synthetic */ int[] $SwitchMap$org$eclipse$jetty$util$Scanner$Notification;

        static {
            int[] iArr = new int[Notification.values().length];
            $SwitchMap$org$eclipse$jetty$util$Scanner$Notification = iArr;
            try {
                Notification notification = Notification.REMOVED;
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$org$eclipse$jetty$util$Scanner$Notification;
                Notification notification2 = Notification.CHANGED;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$org$eclipse$jetty$util$Scanner$Notification;
                Notification notification3 = Notification.ADDED;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface BulkListener extends Listener {
        void filesChanged(List<String> list) throws Exception;
    }

    /* loaded from: classes5.dex */
    public interface DiscreteListener extends Listener {
        void fileAdded(String str) throws Exception;

        void fileChanged(String str) throws Exception;

        void fileRemoved(String str) throws Exception;
    }

    /* loaded from: classes5.dex */
    public interface Listener {
    }

    /* loaded from: classes5.dex */
    public enum Notification {
        ADDED,
        CHANGED,
        REMOVED
    }

    /* loaded from: classes5.dex */
    public interface ScanCycleListener extends Listener {
        void scanEnded(int i) throws Exception;

        void scanStarted(int i) throws Exception;
    }

    /* loaded from: classes5.dex */
    public interface ScanListener extends Listener {
        void scan();
    }

    /* loaded from: classes5.dex */
    public static class TimeNSize {
        public final long _lastModified;
        public final long _size;

        public TimeNSize(long j, long j2) {
            this._lastModified = j;
            this._size = j2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof TimeNSize) {
                TimeNSize timeNSize = (TimeNSize) obj;
                return timeNSize._lastModified == this._lastModified && timeNSize._size == this._size;
            }
            return false;
        }

        public int hashCode() {
            return ((int) this._size) ^ ((int) this._lastModified);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[lm=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._lastModified);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",s=");
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this._size, "]");
        }
    }

    private void reportAddition(String str) {
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof DiscreteListener) {
                    ((DiscreteListener) listener).fileAdded(str);
                }
            } catch (Error | Exception e) {
                warn(listener, str, e);
            }
        }
    }

    private void reportBulkChanges(List<String> list) {
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof BulkListener) {
                    ((BulkListener) listener).filesChanged(list);
                }
            } catch (Error | Exception e) {
                warn(listener, list.toString(), e);
            }
        }
    }

    private void reportChange(String str) {
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof DiscreteListener) {
                    ((DiscreteListener) listener).fileChanged(str);
                }
            } catch (Error | Exception e) {
                warn(listener, str, e);
            }
        }
    }

    private void reportRemoval(String str) {
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof DiscreteListener) {
                    ((DiscreteListener) listener).fileRemoved(str);
                }
            } catch (Error | Exception e) {
                warn(listener, str, e);
            }
        }
    }

    private void reportScanEnd(int i) {
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof ScanCycleListener) {
                    ((ScanCycleListener) listener).scanEnded(i);
                }
            } catch (Exception e) {
                Logger logger = LOG;
                logger.warn(listener + " failed on scan end for cycle " + i, e);
            }
        }
    }

    private void reportScanStart(int i) {
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof ScanCycleListener) {
                    ((ScanCycleListener) listener).scanStarted(i);
                }
            } catch (Exception e) {
                Logger logger = LOG;
                logger.warn(listener + " failed on scan start for cycle " + i, e);
            }
        }
    }

    private void scanFile(File file, Map<String, TimeNSize> map, int i) {
        try {
            if (!file.exists()) {
                return;
            }
            if ((file.isFile() || (i > 0 && this._reportDirs && file.isDirectory())) && (this._filter == null || (this._filter != null && this._filter.accept(file.getParentFile(), file.getName())))) {
                map.put(file.getCanonicalPath(), new TimeNSize(file.lastModified(), file.length()));
            }
            if (!file.isDirectory()) {
                return;
            }
            if (i >= this._scanDepth && this._scanDepth != -1 && !this._scanDirs.contains(file)) {
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                LOG.warn("Error listing files in directory {}", file);
                return;
            }
            for (File file2 : listFiles) {
                scanFile(file2, map, i + 1);
            }
        } catch (IOException e) {
            LOG.warn("Error scanning watched files", e);
        }
    }

    private void warn(Object obj, String str, Throwable th) {
        Logger logger = LOG;
        logger.warn(obj + " failed on '" + str, th);
    }

    public synchronized void addListener(Listener listener) {
        if (listener == null) {
            return;
        }
        this._listeners.add(listener);
    }

    public synchronized void addScanDir(File file) {
        this._scanDirs.add(file);
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() {
        if (this._running) {
            return;
        }
        this._running = true;
        if (this._reportExisting) {
            scan();
            scan();
        } else {
            scanFiles();
            this._prevScan.putAll(this._currentScan);
        }
        schedule();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStop() {
        if (this._running) {
            this._running = false;
            if (this._timer != null) {
                this._timer.cancel();
            }
            if (this._task != null) {
                this._task.cancel();
            }
            this._task = null;
            this._timer = null;
        }
    }

    public FilenameFilter getFilenameFilter() {
        return this._filter;
    }

    public boolean getRecursive() {
        return this._scanDepth == -1;
    }

    public boolean getReportDirs() {
        return this._reportDirs;
    }

    public boolean getReportExistingFilesOnStartup() {
        return this._reportExisting;
    }

    public int getScanDepth() {
        return this._scanDepth;
    }

    @Deprecated
    public File getScanDir() {
        List<File> list = this._scanDirs;
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    public List<File> getScanDirs() {
        return Collections.unmodifiableList(this._scanDirs);
    }

    public int getScanInterval() {
        return this._scanInterval;
    }

    public Timer newTimer() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Scanner-");
        int i = __scannerId;
        __scannerId = i + 1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
        return new Timer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), true);
    }

    public TimerTask newTimerTask() {
        return new TimerTask() { // from class: org.eclipse.jetty.util.Scanner.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Scanner.this.scan();
            }
        };
    }

    public synchronized void removeListener(Listener listener) {
        if (listener == null) {
            return;
        }
        this._listeners.remove(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0122 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void reportDifferences(Map<String, TimeNSize> map, Map<String, TimeNSize> map2) {
        int ordinal;
        Notification put;
        int ordinal2;
        Map<String, Notification> map3;
        Notification notification;
        Notification put2;
        HashSet hashSet = new HashSet(map2.keySet());
        for (Map.Entry<String, TimeNSize> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!hashSet.contains(key)) {
                Notification put3 = this._notifications.put(key, Notification.ADDED);
                if (put3 != null && ((ordinal2 = put3.ordinal()) == 1 || ordinal2 == 2)) {
                    map3 = this._notifications;
                    notification = Notification.CHANGED;
                    map3.put(key, notification);
                }
            } else if (!map2.get(key).equals(map.get(key)) && (put2 = this._notifications.put(key, Notification.CHANGED)) != null && put2.ordinal() == 0) {
                map3 = this._notifications;
                notification = Notification.ADDED;
                map3.put(key, notification);
            }
        }
        for (String str : map2.keySet()) {
            if (!map.containsKey(str) && (put = this._notifications.put(str, Notification.REMOVED)) != null && put.ordinal() == 0) {
                this._notifications.remove(str);
            }
        }
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            logger.debug("scanned " + this._scanDirs + ": " + this._notifications, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, Notification>> it = this._notifications.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Notification> next = it.next();
            String key2 = next.getKey();
            if (map2.containsKey(key2)) {
                if (map2.get(key2).equals(map.get(key2))) {
                    it.remove();
                    arrayList.add(key2);
                    ordinal = next.getValue().ordinal();
                    if (ordinal != 0) {
                        reportAddition(key2);
                    } else if (ordinal == 1) {
                        reportChange(key2);
                    } else if (ordinal == 2) {
                        reportRemoval(key2);
                    }
                }
            } else if (!map.containsKey(key2)) {
                it.remove();
                arrayList.add(key2);
                ordinal = next.getValue().ordinal();
                if (ordinal != 0) {
                }
            }
        }
        if (!arrayList.isEmpty()) {
            reportBulkChanges(arrayList);
        }
    }

    public synchronized void scan() {
        Logger logger;
        int i = this._scanCount + 1;
        this._scanCount = i;
        reportScanStart(i);
        scanFiles();
        reportDifferences(this._currentScan, this._prevScan);
        this._prevScan.clear();
        this._prevScan.putAll(this._currentScan);
        reportScanEnd(this._scanCount);
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof ScanListener) {
                    ((ScanListener) listener).scan();
                }
            } catch (Error e) {
                e = e;
                logger = LOG;
                logger.warn(e);
            } catch (Exception e2) {
                e = e2;
                logger = LOG;
                logger.warn(e);
            }
        }
    }

    public synchronized void scanFiles() {
        if (this._scanDirs == null) {
            return;
        }
        this._currentScan.clear();
        for (File file : this._scanDirs) {
            if (file != null && file.exists()) {
                try {
                    scanFile(file.getCanonicalFile(), this._currentScan, 0);
                } catch (IOException e) {
                    LOG.warn("Error scanning files.", e);
                }
            }
        }
    }

    public void schedule() {
        if (this._running) {
            Timer timer = this._timer;
            if (timer != null) {
                timer.cancel();
            }
            TimerTask timerTask = this._task;
            if (timerTask != null) {
                timerTask.cancel();
            }
            if (getScanInterval() <= 0) {
                return;
            }
            this._timer = newTimer();
            TimerTask newTimerTask = newTimerTask();
            this._task = newTimerTask;
            this._timer.schedule(newTimerTask, getScanInterval() * 1010, 1010 * getScanInterval());
        }
    }

    public void setFilenameFilter(FilenameFilter filenameFilter) {
        this._filter = filenameFilter;
    }

    public void setRecursive(boolean z) {
        this._scanDepth = z ? -1 : 0;
    }

    public void setReportDirs(boolean z) {
        this._reportDirs = z;
    }

    public void setReportExistingFilesOnStartup(boolean z) {
        this._reportExisting = z;
    }

    public void setScanDepth(int i) {
        this._scanDepth = i;
    }

    @Deprecated
    public void setScanDir(File file) {
        this._scanDirs.clear();
        this._scanDirs.add(file);
    }

    public void setScanDirs(List<File> list) {
        this._scanDirs.clear();
        this._scanDirs.addAll(list);
    }

    public synchronized void setScanInterval(int i) {
        this._scanInterval = i;
        schedule();
    }
}
