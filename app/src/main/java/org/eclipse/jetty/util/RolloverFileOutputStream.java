package org.eclipse.jetty.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes5.dex */
public class RolloverFileOutputStream extends FilterOutputStream {
    public static final String ROLLOVER_FILE_BACKUP_FORMAT = "HHmmssSSS";
    public static final String ROLLOVER_FILE_DATE_FORMAT = "yyyy_MM_dd";
    public static final int ROLLOVER_FILE_RETAIN_DAYS = 31;
    public static final String YYYY_MM_DD = "yyyy_mm_dd";
    public static Timer __rollover;
    public boolean _append;
    public File _file;
    public SimpleDateFormat _fileBackupFormat;
    public SimpleDateFormat _fileDateFormat;
    public String _filename;
    public int _retainDays;
    public RollTask _rollTask;

    /* loaded from: classes5.dex */
    public class RollTask extends TimerTask {
        public RollTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                RolloverFileOutputStream.this.setFile();
                RolloverFileOutputStream.this.removeOldFiles();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public RolloverFileOutputStream(String str) throws IOException {
        this(str, true, 31);
    }

    public RolloverFileOutputStream(String str, boolean z) throws IOException {
        this(str, z, 31);
    }

    public RolloverFileOutputStream(String str, boolean z, int i) throws IOException {
        this(str, z, i, TimeZone.getDefault());
    }

    public RolloverFileOutputStream(String str, boolean z, int i, TimeZone timeZone) throws IOException {
        this(str, z, i, timeZone, null, null);
    }

    public RolloverFileOutputStream(String str, boolean z, int i, TimeZone timeZone, String str2, String str3) throws IOException {
        super(null);
        this._fileDateFormat = new SimpleDateFormat(str2 == null ? ROLLOVER_FILE_DATE_FORMAT : str2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3 == null ? ROLLOVER_FILE_BACKUP_FORMAT : str3);
        this._fileBackupFormat = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeZone);
        this._fileDateFormat.setTimeZone(timeZone);
        if (str != null) {
            str = str.trim();
            if (str.length() == 0) {
                str = null;
            }
        }
        if (str != null) {
            this._filename = str;
            this._append = z;
            this._retainDays = i;
            setFile();
            synchronized (RolloverFileOutputStream.class) {
                if (__rollover == null) {
                    __rollover = new Timer(RolloverFileOutputStream.class.getName(), true);
                }
                this._rollTask = new RollTask();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeZone(timeZone);
                GregorianCalendar gregorianCalendar = new GregorianCalendar(calendar.get(1), calendar.get(2), calendar.get(5), 23, 0);
                gregorianCalendar.setTimeZone(timeZone);
                gregorianCalendar.add(10, 1);
                __rollover.scheduleAtFixedRate(this._rollTask, gregorianCalendar.getTime(), 86400000L);
            }
            return;
        }
        throw new IllegalArgumentException("Invalid filename");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOldFiles() {
        String[] list;
        if (this._retainDays > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(this._filename);
            File file2 = new File(file.getParent());
            String name = file.getName();
            int indexOf = name.toLowerCase(Locale.ENGLISH).indexOf(YYYY_MM_DD);
            if (indexOf < 0) {
                return;
            }
            String substring = name.substring(0, indexOf);
            String substring2 = name.substring(indexOf + 10);
            for (String str : file2.list()) {
                if (str.startsWith(substring) && str.indexOf(substring2, substring.length()) >= 0) {
                    File file3 = new File(file2, str);
                    if ((currentTimeMillis - file3.lastModified()) / 86400000 > this._retainDays) {
                        file3.delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setFile() throws IOException {
        this._filename = new File(this._filename).getCanonicalPath();
        File file = new File(this._filename);
        File file2 = new File(file.getParent());
        if (!file2.isDirectory() || !file2.canWrite()) {
            throw new IOException("Cannot write log directory " + file2);
        }
        Date date = new Date();
        String name = file.getName();
        int indexOf = name.toLowerCase(Locale.ENGLISH).indexOf(YYYY_MM_DD);
        if (indexOf >= 0) {
            file = new File(file2, name.substring(0, indexOf) + this._fileDateFormat.format(date) + name.substring(indexOf + 10));
        }
        if (file.exists() && !file.canWrite()) {
            throw new IOException("Cannot write log file " + file);
        }
        if (((FilterOutputStream) this).out == null || !file.equals(this._file)) {
            this._file = file;
            if (!this._append && file.exists()) {
                file.renameTo(new File(file.toString() + "." + this._fileBackupFormat.format(date)));
            }
            OutputStream outputStream = ((FilterOutputStream) this).out;
            ((FilterOutputStream) this).out = new FileOutputStream(file.toString(), this._append);
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (RolloverFileOutputStream.class) {
            try {
                super.close();
                ((FilterOutputStream) this).out = null;
                this._file = null;
                this._rollTask.cancel();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getDatedFilename() {
        File file = this._file;
        if (file == null) {
            return null;
        }
        return file.toString();
    }

    public String getFilename() {
        return this._filename;
    }

    public int getRetainDays() {
        return this._retainDays;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        ((FilterOutputStream) this).out.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
    }
}
