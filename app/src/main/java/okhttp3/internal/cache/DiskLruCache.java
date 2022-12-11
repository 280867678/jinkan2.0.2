package okhttp3.internal.cache;

import androidx.core.app.Person;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.gx0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.mx0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.pf0;
import me.tvspark.r40;
import me.tvspark.tw0;
import me.tvspark.vw0;
import me.tvspark.ww0;
import okhttp3.internal.Util;
import okhttp3.internal.p053io.FileSystem;
import okhttp3.internal.platform.Platform;
import org.apache.http.message.TokenParser;

@ef0
/* loaded from: classes4.dex */
public final class DiskLruCache implements Closeable, Flushable {
    public final int appVersion;
    public boolean closed;
    public final File directory;
    public final Executor executor;
    public final FileSystem fileSystem;
    public boolean hasJournalErrors;
    public boolean initialized;
    public final File journalFile;
    public final File journalFileBackup;
    public final File journalFileTmp;
    public vw0 journalWriter;
    public long maxSize;
    public boolean mostRecentRebuildFailed;
    public boolean mostRecentTrimFailed;
    public long nextSequenceNumber;
    public int redundantOpCount;
    public long size;
    public final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = JOURNAL_FILE;
    public static final String JOURNAL_FILE = JOURNAL_FILE;
    public static final String JOURNAL_FILE_TEMP = JOURNAL_FILE_TEMP;
    public static final String JOURNAL_FILE_TEMP = JOURNAL_FILE_TEMP;
    public static final String JOURNAL_FILE_BACKUP = JOURNAL_FILE_BACKUP;
    public static final String JOURNAL_FILE_BACKUP = JOURNAL_FILE_BACKUP;
    public static final String MAGIC = MAGIC;
    public static final String MAGIC = MAGIC;
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String CLEAN = CLEAN;
    public static final String CLEAN = CLEAN;
    public static final String DIRTY = DIRTY;
    public static final String DIRTY = DIRTY;
    public static final String REMOVE = REMOVE;
    public static final String REMOVE = REMOVE;
    public static final String READ = READ;
    public static final String READ = READ;
    public final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    public final Runnable cleanupRunnable = new Runnable() { // from class: okhttp3.internal.cache.DiskLruCache$cleanupRunnable$1
        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            boolean journalRebuildRequired;
            synchronized (DiskLruCache.this) {
                z = DiskLruCache.this.initialized;
                if (!z || DiskLruCache.this.getClosed$okhttp()) {
                    return;
                }
                try {
                    DiskLruCache.this.trimToSize();
                } catch (IOException unused) {
                    DiskLruCache.this.mostRecentTrimFailed = true;
                }
                try {
                    journalRebuildRequired = DiskLruCache.this.journalRebuildRequired();
                    if (journalRebuildRequired) {
                        DiskLruCache.this.rebuildJournal$okhttp();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                } catch (IOException unused2) {
                    DiskLruCache.this.mostRecentRebuildFailed = true;
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    tw0 tw0Var = new tw0();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tw0Var, "$receiver");
                    diskLruCache.journalWriter = new gx0(tw0Var);
                }
            }
        }
    };

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileSystem, "fileSystem");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "directory");
            boolean z = false;
            if (j > 0) {
                if (i2 > 0) {
                    z = true;
                }
                if (!z) {
                    throw new IllegalArgumentException("valueCount <= 0".toString());
                }
                return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
            }
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class Editor {
        public boolean done;
        public final Entry entry;
        public final /* synthetic */ DiskLruCache this$0;
        public final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry, org.simpleframework.xml.core.Entry.DEFAULT_NAME);
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            synchronized (this.this$0) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.entry.getCurrentEditor$okhttp(), this)) {
                    this.this$0.completeEdit$okhttp(this, false);
                }
                this.done = true;
            }
        }

        public final void commit() throws IOException {
            synchronized (this.this$0) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.entry.getCurrentEditor$okhttp(), this)) {
                    this.this$0.completeEdit$okhttp(this, true);
                }
                this.done = true;
            }
        }

        public final void detach$okhttp() {
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.entry.getCurrentEditor$okhttp(), this)) {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i = 0; i < valueCount$okhttp; i++) {
                    try {
                        this.this$0.getFileSystem$okhttp().delete(this.entry.getDirtyFiles$okhttp().get(i));
                    } catch (IOException unused) {
                    }
                }
                this.entry.setCurrentEditor$okhttp(null);
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final kx0 newSink(int i) {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.entry.getCurrentEditor$okhttp(), this)) {
                        return new tw0();
                    }
                    if (!this.entry.getReadable$okhttp()) {
                        boolean[] zArr = this.written;
                        if (zArr == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        zArr[i] = true;
                    }
                    try {
                        return new FaultHidingSink(this.this$0.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i)), new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, i));
                    } catch (FileNotFoundException unused) {
                        return new tw0();
                    }
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final mx0 newSource(int i) {
            synchronized (this.this$0) {
                if (!this.done) {
                    mx0 mx0Var = null;
                    if (!this.entry.getReadable$okhttp() || (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.entry.getCurrentEditor$okhttp(), this))) {
                        return null;
                    }
                    try {
                        mx0Var = this.this$0.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i));
                    } catch (FileNotFoundException unused) {
                    }
                    return mx0Var;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class Entry {
        public Editor currentEditor;
        public final String key;
        public final long[] lengths;
        public boolean readable;
        public long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;
        public final List<File> cleanFiles = new ArrayList();
        public final List<File> dirtyFiles = new ArrayList();

        public Entry(DiskLruCache diskLruCache, String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Person.KEY_KEY);
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            StringBuilder sb = new StringBuilder(this.key);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i = 0; i < valueCount$okhttp; i++) {
                sb.append(i);
                this.cleanFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final IOException invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> list) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "strings");
            if (list.size() == this.this$0.getValueCount$okhttp()) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.lengths[i] = Long.parseLong(list.get(i));
                    }
                    return;
                } catch (NumberFormatException unused) {
                    throw invalidLengths(list);
                }
            }
            throw invalidLengths(list);
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final Snapshot snapshot$okhttp() {
            boolean holdsLock = Thread.holdsLock(this.this$0);
            if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
                ArrayList<mx0> arrayList = new ArrayList();
                long[] jArr = (long[]) this.lengths.clone();
                try {
                    int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                    for (int i = 0; i < valueCount$okhttp; i++) {
                        arrayList.add(this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i)));
                    }
                    return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (mx0 mx0Var : arrayList) {
                        Util.closeQuietly(mx0Var);
                    }
                    try {
                        this.this$0.removeEntry$okhttp(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            throw new AssertionError("Assertion failed");
        }

        public final void writeLengths$okhttp(vw0 vw0Var) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "writer");
            for (long j : this.lengths) {
                vw0Var.mo4963writeByte(32).mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            }
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class Snapshot implements Closeable {
        public final String key;
        public final long[] lengths;
        public final long sequenceNumber;
        public final List<mx0> sources;
        public final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache diskLruCache, String str, long j, List<? extends mx0> list, long[] jArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Person.KEY_KEY);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "sources");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr, "lengths");
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.sources = list;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (mx0 mx0Var : this.sources) {
                Util.closeQuietly(mx0Var);
            }
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        public final mx0 getSource(int i) {
            return this.sources.get(i);
        }

        public final String key() {
            return this.key;
        }
    }

    public DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileSystem, "fileSystem");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "directory");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(executor, "executor");
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.valueCount = i2;
        this.executor = executor;
        this.maxSize = j;
        this.journalFile = new File(this.directory, JOURNAL_FILE);
        this.journalFileTmp = new File(this.directory, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(this.directory, JOURNAL_FILE_BACKUP);
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    private final vw0 newJournalWriter() throws FileNotFoundException {
        FaultHidingSink faultHidingSink = new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(faultHidingSink, "$receiver");
        return new gx0(faultHidingSink);
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "i.next()");
            Entry entry = next;
            int i = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    this.size += entry.getLengths$okhttp()[i];
                    i++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i3 = this.valueCount;
                while (i < i3) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() throws IOException {
        ww0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.fileSystem.source(this.journalFile));
        try {
            String Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww();
            String Wwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww();
            String Wwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww();
            String Wwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww();
            String Wwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww();
            boolean z = true;
            if (!(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) MAGIC, (Object) Wwwwwwwwwwwwwwwwwwwwwwwww)) && !(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) VERSION_1, (Object) Wwwwwwwwwwwwwwwwwwwwwwwww2)) && !(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) String.valueOf(this.appVersion), (Object) Wwwwwwwwwwwwwwwwwwwwwwwww3)) && !(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) String.valueOf(this.valueCount), (Object) Wwwwwwwwwwwwwwwwwwwwwwwww4))) {
                int i = 0;
                if (Wwwwwwwwwwwwwwwwwwwwwwwww5.length() <= 0) {
                    z = false;
                }
                if (!z) {
                    while (true) {
                        try {
                            readJournalLine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww());
                            i++;
                        } catch (EOFException unused) {
                            this.redundantOpCount = i - this.lruEntries.size();
                            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                rebuildJournal$okhttp();
                            } else {
                                this.journalWriter = newJournalWriter();
                            }
                            th = null;
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + Wwwwwwwwwwwwwwwwwwwwwwwww + ", " + Wwwwwwwwwwwwwwwwwwwwwwwww2 + ", " + Wwwwwwwwwwwwwwwwwwwwwwwww4 + ", " + Wwwwwwwwwwwwwwwwwwwwwwwww5 + ']');
        } finally {
        }
    }

    private final void readJournalLine(String str) throws IOException {
        String substring;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, (char) TokenParser.f4579SP, 0, false, 6);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, (char) TokenParser.f4579SP, i, false, 4);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                substring = str.substring(i);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == REMOVE.length() && nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, REMOVE, false, 2)) {
                    this.lruEntries.remove(substring);
                    return;
                }
            } else if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } else {
                substring = str.substring(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            Entry entry = this.lruEntries.get(substring);
            if (entry == null) {
                entry = new Entry(this, substring);
                this.lruEntries.put(substring, entry);
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != CLEAN.length() || !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, CLEAN, false, 2)) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == DIRTY.length() && nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, DIRTY, false, 2)) {
                    entry.setCurrentEditor$okhttp(new Editor(this, entry));
                    return;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != READ.length() || !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, READ, false, 2)) {
                    throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected journal line: ", str));
                } else {
                    return;
                }
            }
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring2 = str.substring(i2);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring2, "(this as java.lang.String).substring(startIndex)");
            List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) substring2, new char[]{TokenParser.f4579SP}, false, 0, 6);
            entry.setReadable$okhttp(true);
            entry.setCurrentEditor$okhttp(null);
            entry.setLengths$okhttp(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            return;
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected journal line: ", str));
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Entry[] entryArr;
        if (this.initialized && !this.closed) {
            Collection<Entry> values = this.lruEntries.values();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) values, "lruEntries.values");
            Object[] array = values.toArray(new Entry[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            for (Entry entry : (Entry[]) array) {
                if (entry.getCurrentEditor$okhttp() != null) {
                    Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
                    if (currentEditor$okhttp == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    currentEditor$okhttp.abort();
                }
            }
            trimToSize();
            vw0 vw0Var = this.journalWriter;
            if (vw0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            vw0Var.close();
            this.journalWriter = null;
            this.closed = true;
            return;
        }
        this.closed = true;
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            if (z && !entry$okhttp.getReadable$okhttp()) {
                int i = this.valueCount;
                for (int i2 = 0; i2 < i; i2++) {
                    boolean[] written$okhttp = editor.getWritten$okhttp();
                    if (written$okhttp == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    } else if (!written$okhttp[i2]) {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i2))) {
                        editor.abort();
                        return;
                    }
                }
            }
            int i3 = this.valueCount;
            for (int i4 = 0; i4 < i3; i4++) {
                File file = entry$okhttp.getDirtyFiles$okhttp().get(i4);
                if (!z) {
                    this.fileSystem.delete(file);
                } else if (this.fileSystem.exists(file)) {
                    File file2 = entry$okhttp.getCleanFiles$okhttp().get(i4);
                    this.fileSystem.rename(file, file2);
                    long j = entry$okhttp.getLengths$okhttp()[i4];
                    long size = this.fileSystem.size(file2);
                    entry$okhttp.getLengths$okhttp()[i4] = size;
                    this.size = (this.size - j) + size;
                }
            }
            this.redundantOpCount++;
            entry$okhttp.setCurrentEditor$okhttp(null);
            vw0 vw0Var = this.journalWriter;
            if (vw0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            if (!entry$okhttp.getReadable$okhttp() && !z) {
                this.lruEntries.remove(entry$okhttp.getKey$okhttp());
                vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(REMOVE).mo4963writeByte(32);
                vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry$okhttp.getKey$okhttp());
                vw0Var.mo4963writeByte(10);
                vw0Var.flush();
                if (this.size <= this.maxSize || journalRebuildRequired()) {
                    this.executor.execute(this.cleanupRunnable);
                }
                return;
            }
            entry$okhttp.setReadable$okhttp(true);
            vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CLEAN).mo4963writeByte(32);
            vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry$okhttp.getKey$okhttp());
            entry$okhttp.writeLengths$okhttp(vw0Var);
            vw0Var.mo4963writeByte(10);
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry$okhttp.setSequenceNumber$okhttp(j2);
            }
            vw0Var.flush();
            if (this.size <= this.maxSize) {
            }
            this.executor.execute(this.cleanupRunnable);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String str) throws IOException {
        return edit$default(this, str, 0L, 2, null);
    }

    public final synchronized Editor edit(String str, long j) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Person.KEY_KEY);
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j == ANY_SEQUENCE_NUMBER || (entry != null && entry.getSequenceNumber$okhttp() == j)) {
            if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
                return null;
            }
            if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                vw0 vw0Var = this.journalWriter;
                if (vw0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DIRTY).mo4963writeByte(32).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).mo4963writeByte(10);
                vw0Var.flush();
                if (this.hasJournalErrors) {
                    return null;
                }
                if (entry == null) {
                    entry = new Entry(this, str);
                    this.lruEntries.put(str, entry);
                }
                Editor editor = new Editor(this, entry);
                entry.setCurrentEditor$okhttp(editor);
                return editor;
            }
            this.executor.execute(this.cleanupRunnable);
            return null;
        }
        return null;
    }

    public final synchronized void evictAll() throws IOException {
        Entry[] entryArr;
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) values, "lruEntries.values");
        Object[] array = values.toArray(new Entry[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        for (Entry entry : (Entry[]) array) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) entry, org.simpleframework.xml.core.Entry.DEFAULT_NAME);
            removeEntry$okhttp(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (!this.initialized) {
            return;
        }
        checkNotClosed();
        trimToSize();
        vw0 vw0Var = this.journalWriter;
        if (vw0Var != null) {
            vw0Var.flush();
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    public final synchronized Snapshot get(String str) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Person.KEY_KEY);
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) entry, "lruEntries[key] ?: return null");
            if (!entry.getReadable$okhttp()) {
                return null;
            }
            Snapshot snapshot$okhttp = entry.snapshot$okhttp();
            if (snapshot$okhttp == null) {
                return null;
            }
            this.redundantOpCount++;
            vw0 vw0Var = this.journalWriter;
            if (vw0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(READ).mo4963writeByte(32).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).mo4963writeByte(10);
            if (journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return snapshot$okhttp;
        }
        return null;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        boolean holdsLock = Thread.holdsLock(this);
        if (pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && !holdsLock) {
            throw new AssertionError("Assertion failed");
        }
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (IOException e) {
                Platform platform = Platform.Companion.get();
                platform.log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);
                delete();
                this.closed = false;
            }
        }
        rebuildJournal$okhttp();
        this.initialized = true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        vw0 vw0Var = this.journalWriter;
        if (vw0Var != null) {
            vw0Var.close();
        }
        vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.fileSystem.sink(this.journalFileTmp));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MAGIC).mo4963writeByte(10);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VERSION_1).mo4963writeByte(10);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.appVersion).mo4963writeByte(10);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.valueCount).mo4963writeByte(10);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4963writeByte(10);
        for (Entry entry : this.lruEntries.values()) {
            if (entry.getCurrentEditor$okhttp() != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DIRTY).mo4963writeByte(32);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getKey$okhttp());
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CLEAN).mo4963writeByte(32);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getKey$okhttp());
                entry.writeLengths$okhttp(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4963writeByte(10);
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Throwable) null);
        if (this.fileSystem.exists(this.journalFile)) {
            this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
    }

    public final synchronized boolean remove(String str) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Person.KEY_KEY);
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) entry, "lruEntries[key] ?: return false");
            boolean removeEntry$okhttp = removeEntry$okhttp(entry);
            if (removeEntry$okhttp && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
            return removeEntry$okhttp;
        }
        return false;
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry, org.simpleframework.xml.core.Entry.DEFAULT_NAME);
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i2));
            this.size -= entry.getLengths$okhttp()[i2];
            entry.getLengths$okhttp()[i2] = 0;
        }
        this.redundantOpCount++;
        vw0 vw0Var = this.journalWriter;
        if (vw0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        vw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(REMOVE).mo4963writeByte(32).mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getKey$okhttp()).mo4963writeByte(10);
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            Entry next = this.lruEntries.values().iterator().next();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "lruEntries.values.iterator().next()");
            removeEntry$okhttp(next);
        }
        this.mostRecentTrimFailed = false;
    }
}
