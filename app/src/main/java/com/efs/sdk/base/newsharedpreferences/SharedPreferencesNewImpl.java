package com.efs.sdk.base.newsharedpreferences;

import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p056io.input.Tailer;

/* loaded from: classes3.dex */
public final class SharedPreferencesNewImpl implements SharedPreferences {
    public static final String BACKUP_FILE_SUFFIX = ".bak";
    public static final int CONTENT_LENGTH_LOST = 1;
    public static final int CONTENT_OVER_SIZE = 7;
    public static final int DATA_TYPE_ERROR = 8;
    public static final int DATA_TYPE_INVALID = 9;
    public static final long DELAY_TIME_TO_SAVE = 1000;
    public static final byte FINISH_MARK = 18;
    public static final int FINISH_MARK_LENGTH = 1;
    public static final int ID_LENGTH = 4;
    public static final int INIT_EXCEPTION = 10;
    public static final int LOAD_BAK_FILE = 12;
    public static final int MAPPED_BUFFER_ERROR = 4;
    public static final int MAX_HANDLERTHREAD = 3;
    public static final long MAX_LOCK_FILE_TIME = 10000;
    public static final int MAX_NUM = Integer.MAX_VALUE;
    public static final int MAX_TRY_TIME = 6;
    public static final int MIN_INCREASE_LENGTH = 1024;
    public static final int MODIFY_ID_LOST = 2;
    public static final int OTHER_EXCEPTION = 11;
    public static final String TAG = "SharedPreferencesNew";
    public static final long TRY_RELOAD_INTERVAL = 60;
    public static final int TRY_SAVE_TIME_DELAY = 2000;
    public static final int TYPE_CAST_EXCEPTION = 13;
    public static final int VALUE_LOST = 3;
    public static final Object mFileMonitorSyncObj = new Object();
    public static HandlerThread[] mHandlerThreadPool = new HandlerThread[3];
    public static final int mSaveMessageID = 21310;
    public static ExecutorService sCachedThreadPool;
    public String mBackupFilePath;
    public int mCurTryTime;
    public Vector<SharedPreferences.Editor> mEditorList;
    public OnSharedPreferenceErrorListener mErrorListener;
    public File mFile;
    public FileChannel mFileChannel;
    public FileMonitor mFileMonitor;
    public Handler mHandler;
    public boolean mIsSaving;
    public final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
    public boolean mLoaded;
    public final LinkedHashMap<String, Object> mMap;
    public MappedByteBuffer mMappedByteBuffer;
    public int mModifyErrorCnt;
    public int mModifyID;
    public RunnableEx mSaveRunnable;
    public final Object mSyncObj;
    public final Object mSyncSaveObj;
    public final Runnable mTryReloadRunnable;
    public long mTryReloadStartTime;

    /* loaded from: classes3.dex */
    public static class ByteFloatUtils {
        public static float bytesToFloat(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getFloat();
        }

        public static byte[] floatToBytes(float f) {
            return ByteBuffer.allocate(4).putFloat(f).array();
        }
    }

    /* loaded from: classes3.dex */
    public static class ByteIntUtils {
        public static int bytesToInt(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getInt();
        }

        public static byte[] intToBytes(int i) {
            return ByteBuffer.allocate(4).putInt(i).array();
        }
    }

    /* loaded from: classes3.dex */
    public static class ByteLongUtils {
        public static long bytesToLong(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getLong();
        }

        public static byte[] longToBytes(long j) {
            return ByteBuffer.allocate(8).putLong(j).array();
        }
    }

    /* loaded from: classes3.dex */
    public final class EditorImpl implements SharedPreferences.Editor {
        public boolean mClear;
        public HashMap<String, Object> mModified = new HashMap<>();

        public EditorImpl() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            SharedPreferencesNewImpl.this.save(this, false, false, true);
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            SharedPreferencesNewImpl.this.save(this, false, true, false);
            return true;
        }

        public final boolean doClear() {
            boolean z;
            synchronized (this) {
                z = this.mClear;
                this.mClear = false;
            }
            return z;
        }

        public final HashMap<String, Object> getAll() {
            HashMap<String, Object> hashMap;
            synchronized (this) {
                hashMap = this.mModified;
            }
            return hashMap;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.mModified.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this) {
                this.mModified.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this) {
                this.mModified.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this) {
                this.mModified.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this) {
                this.mModified.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new RuntimeException("putStringSet is not supported!");
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            synchronized (this) {
                this.mModified.put(str, null);
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public final class FileMonitor extends FileObserver {
        public FileMonitor(String str, int i) {
            super(str, i);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i, String str) {
            if (SharedPreferencesNewImpl.this.mListeners.size() > 0) {
                SharedPreferencesNewImpl.this.tryReload();
            } else {
                stopWatching();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnSharedPreferenceErrorListener {
        void onError(String str, int i, long j);
    }

    /* loaded from: classes3.dex */
    public static abstract class RunnableEx implements Runnable {
        public Object mArg;

        public Object getArg() {
            return this.mArg;
        }

        public void setArg(Object obj) {
            this.mArg = obj;
        }
    }

    /* loaded from: classes3.dex */
    public class SUPPORTED_TYPE {
        public static final byte TYPE_BOOLEAN = 4;
        public static final byte TYPE_FLOAT = 2;
        public static final byte TYPE_INT = 1;
        public static final byte TYPE_LONG = 3;
        public static final byte TYPE_STRING = 5;

        public SUPPORTED_TYPE() {
        }
    }

    static {
        for (int i = 0; i < 3; i++) {
            mHandlerThreadPool[i] = new HandlerThread("newsp".concat(String.valueOf(i)));
            mHandlerThreadPool[i].start();
        }
        sCachedThreadPool = Executors.newCachedThreadPool();
    }

    public SharedPreferencesNewImpl(File file) {
        this(file, 0, null, false);
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, i, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener, boolean z) {
        this.mMap = new LinkedHashMap<>();
        this.mListeners = new ArrayList<>();
        this.mLoaded = true;
        this.mSyncObj = new Object();
        this.mSyncSaveObj = new Object();
        this.mEditorList = new Vector<>();
        this.mIsSaving = false;
        this.mTryReloadRunnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int modifyID = SharedPreferencesNewImpl.this.getModifyID();
                if (modifyID <= 0 || modifyID == SharedPreferencesNewImpl.this.mModifyID) {
                    return;
                }
                SharedPreferencesNewImpl.this.saveInner(false);
            }
        };
        this.mSaveRunnable = new RunnableEx() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferencesNewImpl.this.saveInner(((Boolean) getArg()).booleanValue());
            }
        };
        this.mErrorListener = onSharedPreferenceErrorListener;
        this.mHandler = new Handler(getHandlerThread().getLooper());
        this.mFile = file;
        this.mBackupFilePath = file.getAbsolutePath() + BACKUP_FILE_SUFFIX;
        if (initBuffer()) {
            startLoadFromDisk(z);
        }
        this.mHandler.post(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file2 = new File(SharedPreferencesNewImpl.this.mBackupFilePath);
                    if (file2.exists()) {
                        return;
                    }
                    file2.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SharedPreferencesNewImpl(File file, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, 0, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, boolean z) {
        this(file, 0, null, z);
    }

    private MappedByteBuffer allocBuffer(int i) {
        MappedByteBuffer mappedByteBuffer = this.mMappedByteBuffer;
        int position = mappedByteBuffer != null ? mappedByteBuffer.position() : 0;
        try {
            this.mMappedByteBuffer = this.mFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MappedByteBuffer mappedByteBuffer2 = this.mMappedByteBuffer;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.position(position);
        }
        return this.mMappedByteBuffer;
    }

    private void awaitLoadedLocked() {
        if (!this.mLoaded) {
            synchronized (this) {
                while (!this.mLoaded) {
                    wait();
                }
            }
        }
        tryReload();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void backup() {
        Throwable th;
        Closeable closeable;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(this.mBackupFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                closeable = fileOutputStream.getChannel();
                this.mFileChannel.transferTo(0L, this.mMappedByteBuffer.capacity(), closeable);
            } catch (Throwable th2) {
                closeable = fileOutputStream;
                fileOutputStream = fileOutputStream;
                th = th2;
                try {
                    th.printStackTrace();
                } finally {
                    safeClose(fileOutputStream);
                    safeClose(closeable);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    private byte getBCCCode(byte[] bArr) {
        byte b = 0;
        for (byte b2 : bArr) {
            b = (byte) (b ^ b2);
        }
        return b;
    }

    private byte[] getBytes(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return ((String) obj).getBytes();
                }
                if (obj instanceof Boolean) {
                    int i = 1;
                    byte[] bArr = new byte[1];
                    if (!((Boolean) obj).booleanValue()) {
                        i = 0;
                    }
                    bArr[0] = (byte) i;
                    return bArr;
                } else if (obj instanceof Float) {
                    return ByteFloatUtils.floatToBytes(((Float) obj).floatValue());
                } else {
                    if (obj instanceof Integer) {
                        return ByteIntUtils.intToBytes(((Integer) obj).intValue());
                    }
                    if (!(obj instanceof Long)) {
                        return null;
                    }
                    return ByteLongUtils.longToBytes(((Long) obj).longValue());
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private int getContentLength() {
        if (this.mMappedByteBuffer == null || this.mFileChannel == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int bytesToInt = ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(4);
            byte b = this.mMappedByteBuffer.get();
            if ((b == 18 || b == getMaskByte(bArr)) && bytesToInt >= 0) {
                if (bytesToInt > Integer.MAX_VALUE) {
                    bytesToInt = Integer.MAX_VALUE;
                }
                return bytesToInt;
            }
            if (this.mErrorListener != null) {
                this.mErrorListener.onError(this.mFile != null ? this.mFile.getAbsolutePath() : null, 1, this.mFile != null ? this.mFile.length() : 0L);
            }
            return -1;
        }
    }

    private Pair<Integer, byte[][]> getDataBytes() {
        byte[][] bArr;
        ArrayList arrayList;
        synchronized (this.mMap) {
            bArr = new byte[this.mMap.size() * 5];
            arrayList = new ArrayList(this.mMap.entrySet());
            this.mEditorList.clear();
        }
        int i = 0;
        int i2 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Map.Entry entry = (Map.Entry) arrayList.get(size);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null && str.trim().length() > 0 && value != null) {
                byte[] bytes = str.getBytes();
                byte[] intToBytes = ByteIntUtils.intToBytes(bytes.length);
                bArr[i2] = intToBytes;
                bArr[i2 + 1] = bytes;
                int length = intToBytes.length + bytes.length + i;
                byte[] bytes2 = getBytes(value);
                byte[] intToBytes2 = ByteIntUtils.intToBytes(bytes2.length);
                bArr[i2 + 2] = intToBytes2;
                bArr[i2 + 3] = bytes2;
                byte[] bArr2 = new byte[1];
                bArr2[0] = (byte) getObjectType(value);
                bArr[i2 + 4] = bArr2;
                i = intToBytes2.length + bytes2.length + length + 1;
                i2 += 5;
            }
        }
        return new Pair<>(Integer.valueOf(i), bArr);
    }

    private HandlerThread getHandlerThread() {
        int nextInt = new Random().nextInt();
        if (nextInt < 0) {
            nextInt = -nextInt;
        }
        return mHandlerThreadPool[nextInt % 3];
    }

    private byte getMaskByte(byte[] bArr) {
        return getBCCCode(bArr);
    }

    private Object getObjectByType(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            if (i == 5) {
                return new String(bArr);
            }
            boolean z = true;
            if (i == 4) {
                if (bArr[0] != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else if (i == 2) {
                return Float.valueOf(ByteFloatUtils.bytesToFloat(bArr));
            } else {
                if (i == 1) {
                    return Integer.valueOf(ByteIntUtils.bytesToInt(bArr));
                }
                if (i != 3) {
                    return null;
                }
                return Long.valueOf(ByteLongUtils.bytesToLong(bArr));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int getObjectType(Object obj) {
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        return obj instanceof Long ? 3 : 0;
    }

    private Pair<byte[], Integer> getOneString(byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i, bArr2, 0, 4);
        int i3 = i + 4;
        if (bArr[i3] == 18 || bArr[i3] == getMaskByte(bArr2)) {
            int i4 = i3 + 1;
            int bytesToInt = ByteIntUtils.bytesToInt(bArr2);
            if (bytesToInt < 0 || (i2 = i4 + bytesToInt) >= bArr.length || bytesToInt > Integer.MAX_VALUE) {
                throw new Exception("length string is invalid");
            }
            byte[] bArr3 = null;
            if (bytesToInt != 0) {
                bArr3 = new byte[bytesToInt];
                System.arraycopy(bArr, i4, bArr3, 0, bytesToInt);
                if (bArr[i2] != 18 && bArr[i2] != getMaskByte(bArr3)) {
                    throw new Exception("Stored bytes' finish mark missing");
                }
                i4 = i2;
            }
            return new Pair<>(bArr3, Integer.valueOf(i4 + 1));
        }
        throw new Exception("length string's finish mark missing");
    }

    private int increaseModifyID() {
        int i = (this.mModifyID + 1) % Integer.MAX_VALUE;
        this.mModifyID = i;
        return i;
    }

    private boolean initBuffer() {
        boolean z = true;
        if (this.mMappedByteBuffer == null) {
            try {
                if (!this.mFile.exists()) {
                    this.mFile.getParentFile().mkdirs();
                    this.mFile.createNewFile();
                    z = new File(this.mBackupFilePath).exists();
                } else if (this.mFile.length() == 0) {
                    if (this.mErrorListener != null) {
                        this.mErrorListener.onError(this.mFile.getAbsolutePath(), 4, this.mFile.length());
                    }
                    z = false;
                }
                this.mFileChannel = new RandomAccessFile(this.mFile, "rw").getChannel();
                allocBuffer(10);
                if (!z) {
                    initFileHeader();
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener == null) {
                    return false;
                }
                onSharedPreferenceErrorListener.onError(this.mFile.getAbsolutePath() + StringUtils.SPACE + e.getCause(), 10, -1L);
                return false;
            }
        }
        return true;
    }

    private void initFileHeader() {
        if (this.mMappedByteBuffer != null) {
            byte[] bArr = new byte[10];
            byte[] intToBytes = ByteIntUtils.intToBytes(0);
            System.arraycopy(intToBytes, 0, bArr, 0, 4);
            bArr[4] = getMaskByte(intToBytes);
            byte[] intToBytes2 = ByteIntUtils.intToBytes(0);
            System.arraycopy(intToBytes2, 0, bArr, 5, 4);
            bArr[9] = getMaskByte(intToBytes2);
            this.mMappedByteBuffer.position(0);
            this.mMappedByteBuffer.put(bArr);
        }
    }

    private void load(boolean z) {
        byte[] bArr = null;
        FileLock lockFile = z ? null : lockFile(true);
        if (lockFile == null && !z) {
            if (z) {
                return;
            }
            loadFromBakFile();
            return;
        }
        boolean z2 = false;
        try {
            reallocBuffer();
            if (this.mMappedByteBuffer != null && this.mMappedByteBuffer.capacity() != 0) {
                long contentLength = getContentLength();
                if (contentLength <= 10) {
                    try {
                        z2 = parseBytesIntoMap(null, true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!z2 || this.mModifyID < 0) {
                        loadFromBakFile();
                    }
                    if (lockFile == null) {
                        return;
                    }
                    try {
                        lockFile.release();
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                int modifyID = getModifyID();
                this.mModifyID = modifyID;
                if (modifyID > 0) {
                    synchronized (this.mSyncObj) {
                        this.mMappedByteBuffer.position(10);
                        bArr = new byte[((int) contentLength) - 10];
                        safeBufferGet(this.mMappedByteBuffer, bArr);
                    }
                }
                try {
                    z2 = parseBytesIntoMap(bArr, true);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (!z2 || (bArr == null && this.mModifyID < 0)) {
                    loadFromBakFile();
                }
                if (lockFile == null) {
                    return;
                }
                try {
                    lockFile.release();
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            try {
                z2 = parseBytesIntoMap(null, true);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            if (!z2 || this.mModifyID < 0) {
                loadFromBakFile();
            }
            if (lockFile == null) {
                return;
            }
            try {
                lockFile.release();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                z2 = parseBytesIntoMap(bArr, true);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            if (!z2 || (bArr == null && this.mModifyID < 0)) {
                loadFromBakFile();
            }
            if (lockFile != null) {
                try {
                    lockFile.release();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    private boolean loadFromBakFile() {
        byte[] bArr;
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        String str;
        long j;
        RandomAccessFile randomAccessFile;
        int bytesToInt;
        Closeable closeable = null;
        byte[] bArr2 = null;
        int i = 0;
        boolean z = true;
        try {
            randomAccessFile = new RandomAccessFile(this.mBackupFilePath, Tailer.RAF_MODE);
        } catch (Throwable th) {
            th = th;
            bArr = null;
        }
        try {
            byte[] bArr3 = new byte[4];
            randomAccessFile.read(bArr3, 0, 4);
            bytesToInt = ByteIntUtils.bytesToInt(bArr3);
        } catch (Throwable th2) {
            th = th2;
            bArr = bArr2;
            closeable = randomAccessFile;
            try {
                th.printStackTrace();
                safeClose(closeable);
                try {
                    z = parseBytesIntoMap(bArr, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    str = this.mBackupFilePath + "#" + th.getCause() + "#" + z;
                    if (bArr != null) {
                        i = bArr.length;
                    }
                    j = i;
                    onSharedPreferenceErrorListener.onError(str, 12, j);
                }
                return z;
            } catch (Throwable th3) {
                safeClose(closeable);
                try {
                    z = parseBytesIntoMap(bArr, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
                if (onSharedPreferenceErrorListener2 != null) {
                    String str2 = this.mBackupFilePath + "#" + th.getCause() + "#" + z;
                    if (bArr != null) {
                        i = bArr.length;
                    }
                    onSharedPreferenceErrorListener2.onError(str2, 12, i);
                }
                throw th3;
            }
        }
        if (bytesToInt <= 10) {
            safeClose(randomAccessFile);
            try {
                parseBytesIntoMap(null, false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return false;
        }
        if (bytesToInt > Integer.MAX_VALUE) {
            bytesToInt = Integer.MAX_VALUE;
        }
        if (bytesToInt > randomAccessFile.length()) {
            bytesToInt = (int) randomAccessFile.length();
        }
        int i2 = bytesToInt - 10;
        bArr2 = new byte[i2];
        randomAccessFile.seek(10L);
        randomAccessFile.read(bArr2);
        safeClose(randomAccessFile);
        try {
            z = parseBytesIntoMap(bArr2, false);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        onSharedPreferenceErrorListener = this.mErrorListener;
        if (onSharedPreferenceErrorListener != null) {
            str = this.mBackupFilePath + "#" + ((Object) "") + "#" + z;
            j = i2;
            onSharedPreferenceErrorListener.onError(str, 12, j);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromDiskLocked() {
        if (this.mLoaded) {
            return;
        }
        load(false);
        this.mLoaded = true;
        notifyAll();
    }

    private FileLock lockFile(boolean z) {
        FileChannel fileChannel = this.mFileChannel;
        FileLock fileLock = null;
        if (fileChannel == null) {
            return null;
        }
        if (!z) {
            try {
                return fileChannel.tryLock();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        while (fileLock == null) {
            try {
                fileLock = this.mFileChannel.tryLock();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (fileLock == null) {
                try {
                    Thread.sleep(100L);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (SystemClock.uptimeMillis() - uptimeMillis > 10000) {
                return fileLock;
            }
        }
        return fileLock;
    }

    private boolean merge(SharedPreferences.Editor editor, Map map, boolean z) {
        if (editor == null) {
            return false;
        }
        EditorImpl editorImpl = (EditorImpl) editor;
        boolean doClear = editorImpl.doClear();
        if (doClear) {
            map.clear();
            this.mEditorList.clear();
        }
        HashMap<String, Object> all = editorImpl.getAll();
        if (all.size() == 0) {
            return doClear;
        }
        synchronized (editor) {
            for (Map.Entry<String, Object> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.remove(key);
                } else {
                    if (map.containsKey(key)) {
                        map.remove(key);
                    }
                    map.put(key, value);
                }
                if (!z) {
                    notifyDataChanged(key);
                }
            }
        }
        return true;
    }

    private void mergeWhenReload() {
        synchronized (this.mMap) {
            if (this.mEditorList.size() > 0) {
                Iterator<SharedPreferences.Editor> it = this.mEditorList.iterator();
                while (it.hasNext()) {
                    merge(it.next(), this.mMap, true);
                }
            }
        }
    }

    private void notifyDataChanged(String str) {
        if (this.mListeners.size() > 0) {
            for (int i = 0; i < this.mListeners.size(); i++) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.mListeners.get(i);
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    private byte[] obtainTotalBytes() {
        Pair<Integer, byte[][]> dataBytes = getDataBytes();
        int length = (((byte[][]) dataBytes.second).length * 1) + ((Integer) dataBytes.first).intValue() + 10;
        if (length > Integer.MAX_VALUE) {
            length = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[length];
        byte[] intToBytes = ByteIntUtils.intToBytes(length);
        System.arraycopy(intToBytes, 0, bArr, 0, intToBytes.length);
        int length2 = intToBytes.length + 0;
        bArr[length2] = getMaskByte(intToBytes);
        int i = length2 + 1;
        byte[] intToBytes2 = ByteIntUtils.intToBytes(increaseModifyID());
        System.arraycopy(intToBytes2, 0, bArr, i, intToBytes2.length);
        int length3 = i + intToBytes2.length;
        bArr[length3] = getMaskByte(intToBytes2);
        int i2 = length3 + 1;
        byte[][] bArr2 = (byte[][]) dataBytes.second;
        int length4 = bArr2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length4) {
                break;
            }
            byte[] bArr3 = bArr2[i3];
            if (bArr3 != null) {
                if (bArr3.length + i2 + 1 <= Integer.MAX_VALUE) {
                    System.arraycopy(bArr3, 0, bArr, i2, bArr3.length);
                    int length5 = i2 + bArr3.length;
                    bArr[length5] = getMaskByte(bArr3);
                    i2 = length5 + 1;
                } else {
                    File file = this.mFile;
                    if (file != null) {
                        file.getAbsolutePath();
                    }
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(file2 != null ? file2.getAbsolutePath() : null, 7, -1L);
                    }
                }
            }
            i3++;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
        if (r12.mErrorListener == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
        r3 = r12.mErrorListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        if (r12.mFile == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
        r5 = r12.mFile.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
        r3.onError(r5, 8, r13.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean parseBytesIntoMap(byte[] bArr, boolean z) {
        LinkedHashMap linkedHashMap;
        synchronized (this.mMap) {
            String str = null;
            if (z) {
                try {
                    linkedHashMap = new LinkedHashMap(this.mMap);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        if (this.mFile != null) {
                            str = this.mFile.getAbsolutePath();
                        }
                        sb.append(str);
                        sb.append("#");
                        sb.append(e.getCause());
                        onSharedPreferenceErrorListener.onError(sb.toString(), 3, bArr.length);
                    }
                } finally {
                }
            } else {
                linkedHashMap = null;
            }
            if (z && this.mModifyID > 0) {
                this.mMap.clear();
            }
            if (bArr != null && bArr.length != 0) {
                boolean z2 = false;
                int i = 0;
                boolean z3 = true;
                while (true) {
                    if (i >= bArr.length) {
                        z2 = z3;
                        break;
                    }
                    Pair<byte[], Integer> oneString = getOneString(bArr, i);
                    Pair<byte[], Integer> oneString2 = getOneString(bArr, ((Integer) oneString.second).intValue());
                    int intValue = ((Integer) oneString2.second).intValue();
                    byte b = bArr[intValue];
                    int i2 = intValue + 1;
                    byte b2 = bArr[i2];
                    int i3 = i2 + 1;
                    if (b2 != 18 && b2 != getMaskByte(new byte[]{b})) {
                        break;
                    } else if (!checkTypeValid(b)) {
                        if (this.mErrorListener != null) {
                            this.mErrorListener.onError(this.mFile != null ? this.mFile.getAbsolutePath() : null, 9, bArr.length);
                        }
                        i = i3;
                        z3 = false;
                    } else {
                        Object objectByType = getObjectByType((byte[]) oneString2.first, b);
                        if (oneString.first != null && ((byte[]) oneString.first).length > 0 && objectByType != null) {
                            String str2 = new String((byte[]) oneString.first);
                            if (z || !this.mMap.containsKey(str2)) {
                                this.mMap.put(str2, objectByType);
                            }
                        }
                        i = i3;
                    }
                }
                if (!z2 && z) {
                    this.mMap.putAll(linkedHashMap);
                }
                return z2;
            }
            return true;
        }
    }

    private void reallocBuffer() {
        if (this.mMappedByteBuffer == null) {
            return;
        }
        synchronized (this.mSyncObj) {
            try {
                int contentLength = getContentLength();
                if (contentLength > this.mMappedByteBuffer.capacity()) {
                    allocBuffer(contentLength + 1024);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean safeBufferGet(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        Arrays.fill(bArr, (byte) 0);
        int position = mappedByteBuffer.position();
        if (position + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private void safeBufferPut(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return;
        }
        if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
            mappedByteBuffer = allocBuffer(mappedByteBuffer.position() + bArr.length + 1024);
        }
        mappedByteBuffer.put(bArr);
    }

    private void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(SharedPreferences.Editor editor, boolean z, boolean z2, boolean z3) {
        if (editor == null) {
            return;
        }
        synchronized (this.mMap) {
            boolean z4 = false;
            this.mCurTryTime = 0;
            if (merge(editor, this.mMap, false)) {
                z4 = true;
            } else if (this.mEditorList.size() == 0) {
                return;
            }
            if (z4) {
                this.mEditorList.add(editor);
            }
            if (z2) {
                saveInner(z);
                return;
            }
            long j = z3 ? 1000L : 0L;
            this.mSaveRunnable.setArg(Boolean.valueOf(z));
            Message obtain = Message.obtain(this.mHandler, this.mSaveRunnable);
            obtain.what = mSaveMessageID;
            this.mHandler.sendMessageDelayed(obtain, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInner(final boolean z) {
        synchronized (this.mSyncSaveObj) {
            FileLock lockFile = lockFile(false);
            if (lockFile != null) {
                this.mIsSaving = true;
                if (tryReloadWhenSave()) {
                    mergeWhenReload();
                    notifyDataChanged(null);
                }
                synchronized (this.mMap) {
                    if (this.mEditorList.size() <= 0) {
                        try {
                            lockFile.release();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        this.mIsSaving = false;
                        return;
                    }
                    saveToMappedBuffer(obtainTotalBytes(), z);
                    backup();
                    try {
                        lockFile.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.mIsSaving = false;
                }
            }
            int i = this.mCurTryTime;
            this.mCurTryTime = i + 1;
            if (i < 6) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferencesNewImpl.this.saveInner(z);
                    }
                }, 2000L);
            }
        }
    }

    private void saveToMappedBuffer(byte[] bArr, boolean z) {
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            safeBufferPut(this.mMappedByteBuffer, bArr);
            if (z) {
                this.mMappedByteBuffer.force();
            }
        }
    }

    private void startLoadFromDisk(boolean z) {
        synchronized (this) {
            this.mLoaded = false;
        }
        Runnable runnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SharedPreferencesNewImpl.this) {
                    SharedPreferencesNewImpl.this.loadFromDiskLocked();
                }
            }
        };
        if (z) {
            runnable.run();
        } else {
            sCachedThreadPool.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReload() {
        if (SystemClock.uptimeMillis() - this.mTryReloadStartTime > 60) {
            this.mTryReloadStartTime = SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mTryReloadRunnable);
            this.mHandler.post(this.mTryReloadRunnable);
        }
    }

    private boolean tryReloadWhenSave() {
        int modifyID = getModifyID();
        if (modifyID <= 0 || modifyID == this.mModifyID) {
            return false;
        }
        load(true);
        return true;
    }

    public final boolean checkTypeValid(byte b) {
        return b == 4 || b == 2 || b == 1 || b == 3 || b == 5;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        boolean containsKey;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            containsKey = this.mMap.containsKey(str);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        awaitLoadedLocked();
        return new EditorImpl();
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HashMap hashMap;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            hashMap = new HashMap(this.mMap);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Boolean bool = (Boolean) this.mMap.get(str);
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Float f2 = (Float) this.mMap.get(str);
                    if (f2 != null) {
                        f = f2.floatValue();
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Integer num = (Integer) this.mMap.get(str);
                    if (num != null) {
                        i = num.intValue();
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Long l = (Long) this.mMap.get(str);
                    if (l != null) {
                        j = l.longValue();
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public final int getModifyID() {
        if (this.mMappedByteBuffer == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(5);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int bytesToInt = ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(9);
            byte b = this.mMappedByteBuffer.get();
            if ((b == 18 || b == getMaskByte(bArr)) && bytesToInt >= 0) {
                return bytesToInt;
            }
            int i = this.mModifyErrorCnt + 1;
            this.mModifyErrorCnt = i;
            if (i < 3 && this.mErrorListener != null) {
                this.mErrorListener.onError(this.mFile != null ? this.mFile.getAbsolutePath() : null, 2, this.mFile != null ? this.mFile.length() : 0L);
            }
            return -1;
        }
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    String str3 = (String) this.mMap.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                } catch (ClassCastException e) {
                    if (this.mErrorListener != null) {
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mFile != null ? this.mFile.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        onSharedPreferenceErrorListener.onError(sb.toString(), 13, this.mFile != null ? this.mFile.length() : 0L);
                    }
                    return str2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("putStringSet is not supported!");
    }

    public final void onDestroy() {
        if (this.mIsSaving || this.mHandler.hasMessages(mSaveMessageID)) {
            saveInner(false);
        }
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(onSharedPreferenceChangeListener);
                if (this.mFileMonitor == null) {
                    try {
                        File file = new File(this.mBackupFilePath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.mFileMonitor = new FileMonitor(this.mBackupFilePath, 2);
                }
            }
            synchronized (mFileMonitorSyncObj) {
                this.mFileMonitor.startWatching();
            }
        }
    }

    public final void setSharedPreferenceErrorListener(OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.mErrorListener = onSharedPreferenceErrorListener;
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
                if (this.mFileMonitor != null && this.mListeners.size() <= 0) {
                    this.mFileMonitor.stopWatching();
                }
            }
        }
    }
}
