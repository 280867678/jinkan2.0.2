package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class MultiDexExtractor implements Closeable {
    public static final int BUFFER_SIZE = 16384;
    public static final String DEX_PREFIX = "classes";
    public static final String DEX_SUFFIX = ".dex";
    public static final String EXTRACTED_NAME_EXT = ".classes";
    public static final String EXTRACTED_SUFFIX = ".zip";
    public static final String KEY_CRC = "crc";
    public static final String KEY_DEX_CRC = "dex.crc.";
    public static final String KEY_DEX_NUMBER = "dex.number";
    public static final String KEY_DEX_TIME = "dex.time.";
    public static final String KEY_TIME_STAMP = "timestamp";
    public static final String LOCK_FILENAME = "MultiDex.lock";
    public static final int MAX_EXTRACT_ATTEMPTS = 3;
    public static final long NO_VALUE = -1;
    public static final String PREFS_FILE = "multidex.version";
    public static final String TAG = "MultiDex";
    public final FileLock cacheLock;
    public final File dexDir;
    public final FileChannel lockChannel;
    public final RandomAccessFile lockRaf;
    public final File sourceApk;
    public final long sourceCrc;

    /* loaded from: classes3.dex */
    public static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    public MultiDexExtractor(File file, File file2) throws IOException {
        file.getPath();
        file2.getPath();
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.lockRaf = randomAccessFile;
        try {
            this.lockChannel = randomAccessFile.getChannel();
            try {
                file3.getPath();
                this.cacheLock = this.lockChannel.lock();
                file3.getPath();
            } catch (IOException e) {
                e = e;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            closeQuietly(this.lockRaf);
            throw e4;
        }
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() { // from class: androidx.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            this.dexDir.getPath();
            return;
        }
        for (File file : listFiles) {
            file.getPath();
            file.length();
            file.delete();
            file.getPath();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tmp-", str), EXTRACTED_SUFFIX, file.getParentFile());
        createTempFile.getPath();
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (!createTempFile.setReadOnly()) {
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            }
            file.getPath();
            if (createTempFile.renameTo(file)) {
                return;
            }
            throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } finally {
            closeQuietly(inputStream);
            createTempFile.delete();
        }
    }

    public static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    public static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    public static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    public static boolean isModified(Context context, File file, long j, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + "timestamp", -1L) == getTimeStamp(file)) {
            if (multiDexPreferences.getLong(str + KEY_CRC, -1L) == j) {
                return false;
            }
        }
        return true;
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i = multiDexPreferences.getInt(str + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i + (-1));
        int i2 = 2;
        while (i2 <= i) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, i2, EXTRACTED_SUFFIX));
            if (!extractedDex.isFile()) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing extracted secondary dex file '");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(extractedDex.getPath());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            extractedDex.crc = getZipCrc(extractedDex);
            long j = multiDexPreferences.getLong(str + KEY_DEX_CRC + i2, -1L);
            long j2 = multiDexPreferences.getLong(str + KEY_DEX_TIME + i2, -1L);
            long lastModified = extractedDex.lastModified();
            if (j2 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = multiDexPreferences;
                if (j == extractedDex.crc) {
                    arrayList.add(extractedDex);
                    i2++;
                    multiDexPreferences = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cd, code lost:
        throw new java.io.IOException("Could not create zip file " + r6.getAbsolutePath() + " for secondary dex (" + r3 + ")");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<ExtractedDex> performExtractions() throws IOException {
        String str = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        clearDexDir();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        int i = 2;
        String str2 = "classes2.dex";
        while (true) {
            try {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry == null) {
                    return arrayList;
                }
                ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str + i + EXTRACTED_SUFFIX);
                arrayList.add(extractedDex);
                String str3 = "Extraction is needed for file " + extractedDex;
                int i2 = 0;
                boolean z = false;
                while (i2 < 3 && !z) {
                    i2++;
                    extract(zipFile, entry, extractedDex, str);
                    try {
                        extractedDex.crc = getZipCrc(extractedDex);
                        z = true;
                    } catch (IOException unused) {
                        extractedDex.getAbsolutePath();
                        z = false;
                    }
                    extractedDex.getAbsolutePath();
                    extractedDex.length();
                    if (!z) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            extractedDex.getPath();
                        }
                    }
                }
                if (!z) {
                    break;
                }
                i++;
                str2 = DEX_PREFIX + i + DEX_SUFFIX;
            } finally {
                try {
                    zipFile.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    public static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), str, KEY_CRC), j2);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i = 2;
        for (ExtractedDex extractedDex : list) {
            edit.putLong(str + KEY_DEX_CRC + i, extractedDex.crc);
            edit.putLong(str + KEY_DEX_TIME + i, extractedDex.lastModified());
            i++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    public List<? extends File> load(Context context, String str, boolean z) throws IOException {
        List<ExtractedDex> performExtractions;
        this.sourceApk.getPath();
        if (this.cacheLock.isValid()) {
            if (!z && !isModified(context, this.sourceApk, this.sourceCrc, str)) {
                try {
                    performExtractions = loadExistingExtractions(context, str);
                } catch (IOException unused) {
                }
                performExtractions.size();
                return performExtractions;
            }
            performExtractions = performExtractions();
            putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
            performExtractions.size();
            return performExtractions;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
