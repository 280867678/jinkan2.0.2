package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class AtomicFile {
    public static final String LOG_TAG = "AtomicFile";
    public final File mBaseName;
    public final File mLegacyBackupName;
    public final File mNewName;

    public AtomicFile(@NonNull File file) {
        this.mBaseName = file;
        this.mNewName = new File(file.getPath() + ".new");
        this.mLegacyBackupName = new File(file.getPath() + SharedPreferencesNewImpl.BACKUP_FILE_SUFFIX);
    }

    public static void rename(@NonNull File file, @NonNull File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            String str = "Failed to delete file which is a directory " + file2;
        }
        if (!file.renameTo(file2)) {
            String str2 = "Failed to rename " + file + " to " + file2;
        }
    }

    public static boolean sync(@NonNull FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        if (this.mNewName.delete()) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to delete new file ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mNewName);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public void finishWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        rename(this.mNewName, this.mBaseName);
    }

    @NonNull
    public File getBaseFile() {
        return this.mBaseName;
    }

    @NonNull
    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mLegacyBackupName.exists()) {
            rename(this.mLegacyBackupName, this.mBaseName);
        }
        if (this.mNewName.exists() && this.mBaseName.exists() && !this.mNewName.delete()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to delete outdated new file ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mNewName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return new FileInputStream(this.mBaseName);
    }

    @NonNull
    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    return bArr;
                }
                i += read;
                int available = openRead.available();
                if (available > bArr.length - i) {
                    byte[] bArr2 = new byte[available + i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    @NonNull
    public FileOutputStream startWrite() throws IOException {
        if (this.mLegacyBackupName.exists()) {
            rename(this.mLegacyBackupName, this.mBaseName);
        }
        try {
            return new FileOutputStream(this.mNewName);
        } catch (FileNotFoundException unused) {
            if (!this.mNewName.getParentFile().mkdirs()) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to create directory for ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mNewName);
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            try {
                return new FileOutputStream(this.mNewName);
            } catch (FileNotFoundException e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to create new file ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mNewName);
                throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), e);
            }
        }
    }
}
