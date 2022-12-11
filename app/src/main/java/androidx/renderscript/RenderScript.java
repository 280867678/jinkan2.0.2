package androidx.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes3.dex */
public class RenderScript {
    public static final String CACHE_PATH = "com.android.renderscript.cache";
    public static final boolean DEBUG = false;
    public static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "RenderScript_jni";
    public static boolean isNative = false;
    public static Object lock = new Object();
    public static String mCachePath = null;
    public static Method registerNativeAllocation = null;
    public static Method registerNativeFree = null;
    public static boolean sInitialized = false;
    public static Object sRuntime = null;
    public static int sSdkVersion = -1;
    public static int sThunk = -1;
    public static boolean sUseGCHooks;
    public Context mApplicationContext;
    public int mContext;
    public int mDev;
    public Element mElement_ALLOCATION;
    public Element mElement_A_8;
    public Element mElement_BOOLEAN;
    public Element mElement_CHAR_2;
    public Element mElement_CHAR_3;
    public Element mElement_CHAR_4;
    public Element mElement_DOUBLE_2;
    public Element mElement_DOUBLE_3;
    public Element mElement_DOUBLE_4;
    public Element mElement_ELEMENT;
    public Element mElement_F32;
    public Element mElement_F64;
    public Element mElement_FLOAT_2;
    public Element mElement_FLOAT_3;
    public Element mElement_FLOAT_4;
    public Element mElement_I16;
    public Element mElement_I32;
    public Element mElement_I64;
    public Element mElement_I8;
    public Element mElement_INT_2;
    public Element mElement_INT_3;
    public Element mElement_INT_4;
    public Element mElement_LONG_2;
    public Element mElement_LONG_3;
    public Element mElement_LONG_4;
    public Element mElement_MATRIX_2X2;
    public Element mElement_MATRIX_3X3;
    public Element mElement_MATRIX_4X4;
    public Element mElement_RGBA_4444;
    public Element mElement_RGBA_5551;
    public Element mElement_RGBA_8888;
    public Element mElement_RGB_565;
    public Element mElement_RGB_888;
    public Element mElement_SAMPLER;
    public Element mElement_SCRIPT;
    public Element mElement_SHORT_2;
    public Element mElement_SHORT_3;
    public Element mElement_SHORT_4;
    public Element mElement_TYPE;
    public Element mElement_U16;
    public Element mElement_U32;
    public Element mElement_U64;
    public Element mElement_U8;
    public Element mElement_UCHAR_2;
    public Element mElement_UCHAR_3;
    public Element mElement_UCHAR_4;
    public Element mElement_UINT_2;
    public Element mElement_UINT_3;
    public Element mElement_UINT_4;
    public Element mElement_ULONG_2;
    public Element mElement_ULONG_3;
    public Element mElement_ULONG_4;
    public Element mElement_USHORT_2;
    public Element mElement_USHORT_3;
    public Element mElement_USHORT_4;
    public MessageThread mMessageThread;
    public ReentrantReadWriteLock mRWLock;
    public Sampler mSampler_CLAMP_LINEAR;
    public Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    public Sampler mSampler_CLAMP_NEAREST;
    public Sampler mSampler_MIRRORED_REPEAT_LINEAR;
    public Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
    public Sampler mSampler_MIRRORED_REPEAT_NEAREST;
    public Sampler mSampler_WRAP_LINEAR;
    public Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    public Sampler mSampler_WRAP_NEAREST;
    public RSMessageHandler mMessageCallback = null;
    public RSErrorHandler mErrorCallback = null;

    /* loaded from: classes3.dex */
    public enum ContextType {
        NORMAL(0),
        DEBUG(1),
        PROFILE(2);
        
        public int mID;

        ContextType(int i) {
            this.mID = i;
        }
    }

    /* loaded from: classes3.dex */
    public static class MessageThread extends Thread {
        public static final int RS_ERROR_FATAL_UNKNOWN = 4096;
        public static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        public static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        public static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        public static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        public static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        public RenderScript mRS;
        public boolean mRun = true;
        public int[] mAuxData = new int[2];

        public MessageThread(RenderScript renderScript) {
            super("RSMessageThread");
            this.mRS = renderScript;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int[] iArr = new int[16];
            RenderScript renderScript = this.mRS;
            renderScript.nContextInitToClient(renderScript.mContext);
            while (this.mRun) {
                iArr[0] = 0;
                RenderScript renderScript2 = this.mRS;
                int nContextPeekMessage = renderScript2.nContextPeekMessage(renderScript2.mContext, this.mAuxData);
                int[] iArr2 = this.mAuxData;
                int i = iArr2[1];
                int i2 = iArr2[0];
                if (nContextPeekMessage == 4) {
                    if ((i >> 2) >= iArr.length) {
                        iArr = new int[(i + 3) >> 2];
                    }
                    RenderScript renderScript3 = this.mRS;
                    if (renderScript3.nContextGetUserMessage(renderScript3.mContext, iArr) != 4) {
                        throw new RSDriverException("Error processing message from RenderScript.");
                    }
                    RSMessageHandler rSMessageHandler = this.mRS.mMessageCallback;
                    if (rSMessageHandler == null) {
                        throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                    }
                    rSMessageHandler.mData = iArr;
                    rSMessageHandler.mID = i2;
                    rSMessageHandler.mLength = i;
                    rSMessageHandler.run();
                } else if (nContextPeekMessage == 3) {
                    RenderScript renderScript4 = this.mRS;
                    String nContextGetErrorMessage = renderScript4.nContextGetErrorMessage(renderScript4.mContext);
                    if (i2 >= 4096) {
                        throw new RSRuntimeException("Fatal error " + i2 + ", details: " + nContextGetErrorMessage);
                    }
                    RSErrorHandler rSErrorHandler = this.mRS.mErrorCallback;
                    if (rSErrorHandler != null) {
                        rSErrorHandler.mErrorMessage = nContextGetErrorMessage;
                        rSErrorHandler.mErrorNum = i2;
                        rSErrorHandler.run();
                    }
                } else {
                    try {
                        Thread.sleep(1L, 0);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum Priority {
        LOW(15),
        NORMAL(-4);
        
        public int mID;

        Priority(int i) {
            this.mID = i;
        }
    }

    /* loaded from: classes3.dex */
    public static class RSErrorHandler implements Runnable {
        public String mErrorMessage;
        public int mErrorNum;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes3.dex */
    public static class RSMessageHandler implements Runnable {
        public int[] mData;
        public int mID;
        public int mLength;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public RenderScript(Context context) {
        if (context != null) {
            this.mApplicationContext = context.getApplicationContext();
        }
        this.mRWLock = new ReentrantReadWriteLock();
    }

    public static RenderScript create(Context context) {
        return create(context, ContextType.NORMAL);
    }

    public static RenderScript create(Context context, int i) {
        return create(context, i, ContextType.NORMAL);
    }

    public static RenderScript create(Context context, int i, ContextType contextType) {
        RenderScript renderScript = new RenderScript(context);
        int i2 = sSdkVersion;
        if (i2 == -1) {
            sSdkVersion = i;
        } else if (i2 != i) {
            throw new RSRuntimeException("Can't have two contexts with different SDK versions in support lib");
        }
        if (setupThunk(sSdkVersion, context)) {
            return RenderScriptThunker.create(context, sSdkVersion);
        }
        synchronized (lock) {
            if (!sInitialized) {
                try {
                    Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                    sRuntime = cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]);
                    registerNativeAllocation = cls.getDeclaredMethod("registerNativeAllocation", Integer.TYPE);
                    registerNativeFree = cls.getDeclaredMethod("registerNativeFree", Integer.TYPE);
                    sUseGCHooks = true;
                } catch (Exception unused) {
                    sUseGCHooks = false;
                }
                try {
                    System.loadLibrary("RSSupport");
                    System.loadLibrary("rsjni");
                    sInitialized = true;
                } catch (UnsatisfiedLinkError e) {
                    String str = "Error loading RS jni library: " + e;
                    throw new RSRuntimeException("Error loading RS jni library: " + e);
                }
            }
        }
        int nDeviceCreate = renderScript.nDeviceCreate();
        renderScript.mDev = nDeviceCreate;
        int nContextCreate = renderScript.nContextCreate(nDeviceCreate, 0, i, contextType.mID);
        renderScript.mContext = nContextCreate;
        if (nContextCreate == 0) {
            throw new RSDriverException("Failed to create RS context.");
        }
        MessageThread messageThread = new MessageThread(renderScript);
        renderScript.mMessageThread = messageThread;
        messageThread.start();
        return renderScript;
    }

    public static RenderScript create(Context context, ContextType contextType) {
        return create(context, context.getApplicationInfo().targetSdkVersion, contextType);
    }

    public static void setupDiskCache(File file) {
        File file2 = new File(file, CACHE_PATH);
        mCachePath = file2.getAbsolutePath();
        file2.mkdirs();
    }

    public static boolean setupThunk(int i, Context context) {
        int i2;
        long j;
        if (sThunk == -1) {
            try {
                i2 = ((Integer) Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(null, "debug.rs.forcecompat", new Integer(0))).intValue();
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                sThunk = 1;
            } else {
                sThunk = 0;
            }
            if (sThunk == 1) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    try {
                        j = ((Long) Class.forName("android.renderscript.RenderScript").getDeclaredMethod("getMinorID", new Class[0]).invoke(null, new Object[0])).longValue();
                    } catch (Exception unused2) {
                        j = 0;
                    }
                    Bundle bundle = applicationInfo.metaData;
                    if (bundle != null) {
                        if (bundle.getBoolean("com.android.support.v8.renderscript.EnableAsyncTeardown") && j == 0) {
                            sThunk = 0;
                        }
                        applicationInfo.metaData.getBoolean("com.android.support.v8.renderscript.EnableBlurWorkaround");
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    return true;
                }
            }
        }
        return sThunk == 1;
    }

    public static boolean shouldThunk() {
        int i = sThunk;
        if (i != -1) {
            return i == 1;
        }
        throw new RSRuntimeException("Can't use RS classes before setting up a RenderScript context");
    }

    public void contextDump() {
        validate();
        nContextDump(0);
    }

    public void destroy() {
        validate();
        nContextFinish();
        nContextDeinitToClient(this.mContext);
        MessageThread messageThread = this.mMessageThread;
        messageThread.mRun = false;
        try {
            messageThread.join();
        } catch (InterruptedException unused) {
        }
        nContextDestroy();
        nDeviceDestroy(this.mDev);
        this.mDev = 0;
    }

    public void finish() {
        nContextFinish();
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public RSErrorHandler getErrorHandler() {
        return this.mErrorCallback;
    }

    public RSMessageHandler getMessageHandler() {
        return this.mMessageCallback;
    }

    public boolean isAlive() {
        return this.mContext != 0;
    }

    public synchronized void nAllocationCopyFromBitmap(int i, Bitmap bitmap) {
        validate();
        rsnAllocationCopyFromBitmap(this.mContext, i, bitmap);
    }

    public synchronized void nAllocationCopyToBitmap(int i, Bitmap bitmap) {
        validate();
        rsnAllocationCopyToBitmap(this.mContext, i, bitmap);
    }

    public synchronized int nAllocationCreateBitmapBackedAllocation(int i, int i2, Bitmap bitmap, int i3) {
        validate();
        return rsnAllocationCreateBitmapBackedAllocation(this.mContext, i, i2, bitmap, i3);
    }

    public synchronized int nAllocationCreateBitmapRef(int i, Bitmap bitmap) {
        validate();
        return rsnAllocationCreateBitmapRef(this.mContext, i, bitmap);
    }

    public synchronized int nAllocationCreateFromAssetStream(int i, int i2, int i3) {
        validate();
        return rsnAllocationCreateFromAssetStream(this.mContext, i, i2, i3);
    }

    public synchronized int nAllocationCreateFromBitmap(int i, int i2, Bitmap bitmap, int i3) {
        validate();
        return rsnAllocationCreateFromBitmap(this.mContext, i, i2, bitmap, i3);
    }

    public synchronized int nAllocationCreateTyped(int i, int i2, int i3, int i4) {
        validate();
        return rsnAllocationCreateTyped(this.mContext, i, i2, i3, i4);
    }

    public synchronized int nAllocationCubeCreateFromBitmap(int i, int i2, Bitmap bitmap, int i3) {
        validate();
        return rsnAllocationCubeCreateFromBitmap(this.mContext, i, i2, bitmap, i3);
    }

    public synchronized void nAllocationData1D(int i, int i2, int i3, int i4, byte[] bArr, int i5) {
        validate();
        rsnAllocationData1D(this.mContext, i, i2, i3, i4, bArr, i5);
    }

    public synchronized void nAllocationData1D(int i, int i2, int i3, int i4, float[] fArr, int i5) {
        validate();
        rsnAllocationData1D(this.mContext, i, i2, i3, i4, fArr, i5);
    }

    public synchronized void nAllocationData1D(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        validate();
        rsnAllocationData1D(this.mContext, i, i2, i3, i4, iArr, i5);
    }

    public synchronized void nAllocationData1D(int i, int i2, int i3, int i4, short[] sArr, int i5) {
        validate();
        rsnAllocationData1D(this.mContext, i, i2, i3, i4, sArr, i5);
    }

    public synchronized void nAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        validate();
        rsnAllocationData2D(this.mContext, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12);
    }

    public synchronized void nAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, byte[] bArr, int i8) {
        validate();
        rsnAllocationData2D(this.mContext, i, i2, i3, i4, i5, i6, i7, bArr, i8);
    }

    public synchronized void nAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, float[] fArr, int i8) {
        validate();
        rsnAllocationData2D(this.mContext, i, i2, i3, i4, i5, i6, i7, fArr, i8);
    }

    public synchronized void nAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        validate();
        rsnAllocationData2D(this.mContext, i, i2, i3, i4, i5, i6, i7, iArr, i8);
    }

    public synchronized void nAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, short[] sArr, int i8) {
        validate();
        rsnAllocationData2D(this.mContext, i, i2, i3, i4, i5, i6, i7, sArr, i8);
    }

    public synchronized void nAllocationData2D(int i, int i2, int i3, int i4, int i5, Bitmap bitmap) {
        validate();
        rsnAllocationData2D(this.mContext, i, i2, i3, i4, i5, bitmap);
    }

    public synchronized void nAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        validate();
        rsnAllocationData3D(this.mContext, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13);
    }

    public synchronized void nAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr, int i9) {
        validate();
        rsnAllocationData3D(this.mContext, i, i2, i3, i4, i5, i6, i7, i8, bArr, i9);
    }

    public synchronized void nAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float[] fArr, int i9) {
        validate();
        rsnAllocationData3D(this.mContext, i, i2, i3, i4, i5, i6, i7, i8, fArr, i9);
    }

    public synchronized void nAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr, int i9) {
        validate();
        rsnAllocationData3D(this.mContext, i, i2, i3, i4, i5, i6, i7, i8, iArr, i9);
    }

    public synchronized void nAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, short[] sArr, int i9) {
        validate();
        rsnAllocationData3D(this.mContext, i, i2, i3, i4, i5, i6, i7, i8, sArr, i9);
    }

    public synchronized void nAllocationElementData1D(int i, int i2, int i3, int i4, byte[] bArr, int i5) {
        validate();
        rsnAllocationElementData1D(this.mContext, i, i2, i3, i4, bArr, i5);
    }

    public synchronized void nAllocationGenerateMipmaps(int i) {
        validate();
        rsnAllocationGenerateMipmaps(this.mContext, i);
    }

    public synchronized int nAllocationGetType(int i) {
        validate();
        return rsnAllocationGetType(this.mContext, i);
    }

    public synchronized void nAllocationIoReceive(int i) {
        validate();
        rsnAllocationIoReceive(this.mContext, i);
    }

    public synchronized void nAllocationIoSend(int i) {
        validate();
        rsnAllocationIoSend(this.mContext, i);
    }

    public synchronized void nAllocationRead(int i, byte[] bArr) {
        validate();
        rsnAllocationRead(this.mContext, i, bArr);
    }

    public synchronized void nAllocationRead(int i, float[] fArr) {
        validate();
        rsnAllocationRead(this.mContext, i, fArr);
    }

    public synchronized void nAllocationRead(int i, int[] iArr) {
        validate();
        rsnAllocationRead(this.mContext, i, iArr);
    }

    public synchronized void nAllocationRead(int i, short[] sArr) {
        validate();
        rsnAllocationRead(this.mContext, i, sArr);
    }

    public synchronized void nAllocationResize1D(int i, int i2) {
        validate();
        rsnAllocationResize1D(this.mContext, i, i2);
    }

    public synchronized void nAllocationResize2D(int i, int i2, int i3) {
        validate();
        rsnAllocationResize2D(this.mContext, i, i2, i3);
    }

    public synchronized void nAllocationSyncAll(int i, int i2) {
        validate();
        rsnAllocationSyncAll(this.mContext, i, i2);
    }

    public synchronized int nContextCreate(int i, int i2, int i3, int i4) {
        return rsnContextCreate(i, i2, i3, i4);
    }

    public native void nContextDeinitToClient(int i);

    public synchronized void nContextDestroy() {
        validate();
        ReentrantReadWriteLock.WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        int i = this.mContext;
        this.mContext = 0;
        writeLock.unlock();
        rsnContextDestroy(i);
    }

    public synchronized void nContextDump(int i) {
        validate();
        rsnContextDump(this.mContext, i);
    }

    public synchronized void nContextFinish() {
        validate();
        rsnContextFinish(this.mContext);
    }

    public native String nContextGetErrorMessage(int i);

    public native int nContextGetUserMessage(int i, int[] iArr);

    public native void nContextInitToClient(int i);

    public native int nContextPeekMessage(int i, int[] iArr);

    public synchronized void nContextSendMessage(int i, int[] iArr) {
        validate();
        rsnContextSendMessage(this.mContext, i, iArr);
    }

    public synchronized void nContextSetPriority(int i) {
        validate();
        rsnContextSetPriority(this.mContext, i);
    }

    public native int nDeviceCreate();

    public native void nDeviceDestroy(int i);

    public native void nDeviceSetConfig(int i, int i2, int i3);

    public synchronized int nElementCreate(int i, int i2, boolean z, int i3) {
        validate();
        return rsnElementCreate(this.mContext, i, i2, z, i3);
    }

    public synchronized int nElementCreate2(int[] iArr, String[] strArr, int[] iArr2) {
        validate();
        return rsnElementCreate2(this.mContext, iArr, strArr, iArr2);
    }

    public synchronized void nElementGetNativeData(int i, int[] iArr) {
        validate();
        rsnElementGetNativeData(this.mContext, i, iArr);
    }

    public synchronized void nElementGetSubElements(int i, int[] iArr, String[] strArr, int[] iArr2) {
        validate();
        rsnElementGetSubElements(this.mContext, i, iArr, strArr, iArr2);
    }

    public void nObjDestroy(int i) {
        int i2 = this.mContext;
        if (i2 != 0) {
            rsnObjDestroy(i2, i);
        }
    }

    public synchronized int nSamplerCreate(int i, int i2, int i3, int i4, int i5, float f) {
        validate();
        return rsnSamplerCreate(this.mContext, i, i2, i3, i4, i5, f);
    }

    public synchronized void nScriptBindAllocation(int i, int i2, int i3) {
        validate();
        rsnScriptBindAllocation(this.mContext, i, i2, i3);
    }

    public synchronized int nScriptCCreate(String str, String str2, byte[] bArr, int i) {
        validate();
        return rsnScriptCCreate(this.mContext, str, str2, bArr, i);
    }

    public synchronized int nScriptFieldIDCreate(int i, int i2) {
        validate();
        return rsnScriptFieldIDCreate(this.mContext, i, i2);
    }

    public synchronized void nScriptForEach(int i, int i2, int i3, int i4, byte[] bArr) {
        validate();
        if (bArr == null) {
            rsnScriptForEach(this.mContext, i, i2, i3, i4);
        } else {
            rsnScriptForEach(this.mContext, i, i2, i3, i4, bArr);
        }
    }

    public synchronized void nScriptForEachClipped(int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10) {
        validate();
        if (bArr == null) {
            rsnScriptForEachClipped(this.mContext, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        } else {
            rsnScriptForEachClipped(this.mContext, i, i2, i3, i4, bArr, i5, i6, i7, i8, i9, i10);
        }
    }

    public synchronized int nScriptGroupCreate(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        validate();
        return rsnScriptGroupCreate(this.mContext, iArr, iArr2, iArr3, iArr4, iArr5);
    }

    public synchronized void nScriptGroupExecute(int i) {
        validate();
        rsnScriptGroupExecute(this.mContext, i);
    }

    public synchronized void nScriptGroupSetInput(int i, int i2, int i3) {
        validate();
        rsnScriptGroupSetInput(this.mContext, i, i2, i3);
    }

    public synchronized void nScriptGroupSetOutput(int i, int i2, int i3) {
        validate();
        rsnScriptGroupSetOutput(this.mContext, i, i2, i3);
    }

    public synchronized int nScriptIntrinsicCreate(int i, int i2) {
        validate();
        return rsnScriptIntrinsicCreate(this.mContext, i, i2);
    }

    public synchronized void nScriptInvoke(int i, int i2) {
        validate();
        rsnScriptInvoke(this.mContext, i, i2);
    }

    public synchronized void nScriptInvokeV(int i, int i2, byte[] bArr) {
        validate();
        rsnScriptInvokeV(this.mContext, i, i2, bArr);
    }

    public synchronized int nScriptKernelIDCreate(int i, int i2, int i3) {
        validate();
        return rsnScriptKernelIDCreate(this.mContext, i, i2, i3);
    }

    public synchronized void nScriptSetTimeZone(int i, byte[] bArr) {
        validate();
        rsnScriptSetTimeZone(this.mContext, i, bArr);
    }

    public synchronized void nScriptSetVarD(int i, int i2, double d) {
        validate();
        rsnScriptSetVarD(this.mContext, i, i2, d);
    }

    public synchronized void nScriptSetVarF(int i, int i2, float f) {
        validate();
        rsnScriptSetVarF(this.mContext, i, i2, f);
    }

    public synchronized void nScriptSetVarI(int i, int i2, int i3) {
        validate();
        rsnScriptSetVarI(this.mContext, i, i2, i3);
    }

    public synchronized void nScriptSetVarJ(int i, int i2, long j) {
        validate();
        rsnScriptSetVarJ(this.mContext, i, i2, j);
    }

    public synchronized void nScriptSetVarObj(int i, int i2, int i3) {
        validate();
        rsnScriptSetVarObj(this.mContext, i, i2, i3);
    }

    public synchronized void nScriptSetVarV(int i, int i2, byte[] bArr) {
        validate();
        rsnScriptSetVarV(this.mContext, i, i2, bArr);
    }

    public synchronized void nScriptSetVarVE(int i, int i2, byte[] bArr, int i3, int[] iArr) {
        validate();
        rsnScriptSetVarVE(this.mContext, i, i2, bArr, i3, iArr);
    }

    public synchronized int nTypeCreate(int i, int i2, int i3, int i4, boolean z, boolean z2, int i5) {
        validate();
        return rsnTypeCreate(this.mContext, i, i2, i3, i4, z, z2, i5);
    }

    public synchronized void nTypeGetNativeData(int i, int[] iArr) {
        validate();
        rsnTypeGetNativeData(this.mContext, i, iArr);
    }

    public native void rsnAllocationCopyFromBitmap(int i, int i2, Bitmap bitmap);

    public native void rsnAllocationCopyToBitmap(int i, int i2, Bitmap bitmap);

    public native int rsnAllocationCreateBitmapBackedAllocation(int i, int i2, int i3, Bitmap bitmap, int i4);

    public native int rsnAllocationCreateBitmapRef(int i, int i2, Bitmap bitmap);

    public native int rsnAllocationCreateFromAssetStream(int i, int i2, int i3, int i4);

    public native int rsnAllocationCreateFromBitmap(int i, int i2, int i3, Bitmap bitmap, int i4);

    public native int rsnAllocationCreateTyped(int i, int i2, int i3, int i4, int i5);

    public native int rsnAllocationCubeCreateFromBitmap(int i, int i2, int i3, Bitmap bitmap, int i4);

    public native void rsnAllocationData1D(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6);

    public native void rsnAllocationData1D(int i, int i2, int i3, int i4, int i5, float[] fArr, int i6);

    public native void rsnAllocationData1D(int i, int i2, int i3, int i4, int i5, int[] iArr, int i6);

    public native void rsnAllocationData1D(int i, int i2, int i3, int i4, int i5, short[] sArr, int i6);

    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13);

    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr, int i9);

    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float[] fArr, int i9);

    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr, int i9);

    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, short[] sArr, int i9);

    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap);

    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14);

    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr, int i10);

    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float[] fArr, int i10);

    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr, int i10);

    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, short[] sArr, int i10);

    public native void rsnAllocationElementData1D(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6);

    public native void rsnAllocationGenerateMipmaps(int i, int i2);

    public native int rsnAllocationGetType(int i, int i2);

    public native void rsnAllocationIoReceive(int i, int i2);

    public native void rsnAllocationIoSend(int i, int i2);

    public native void rsnAllocationRead(int i, int i2, byte[] bArr);

    public native void rsnAllocationRead(int i, int i2, float[] fArr);

    public native void rsnAllocationRead(int i, int i2, int[] iArr);

    public native void rsnAllocationRead(int i, int i2, short[] sArr);

    public native void rsnAllocationResize1D(int i, int i2, int i3);

    public native void rsnAllocationResize2D(int i, int i2, int i3, int i4);

    public native void rsnAllocationSyncAll(int i, int i2, int i3);

    public native int rsnContextCreate(int i, int i2, int i3, int i4);

    public native void rsnContextDestroy(int i);

    public native void rsnContextDump(int i, int i2);

    public native void rsnContextFinish(int i);

    public native void rsnContextSendMessage(int i, int i2, int[] iArr);

    public native void rsnContextSetPriority(int i, int i2);

    public native int rsnElementCreate(int i, int i2, int i3, boolean z, int i4);

    public native int rsnElementCreate2(int i, int[] iArr, String[] strArr, int[] iArr2);

    public native void rsnElementGetNativeData(int i, int i2, int[] iArr);

    public native void rsnElementGetSubElements(int i, int i2, int[] iArr, String[] strArr, int[] iArr2);

    public native void rsnObjDestroy(int i, int i2);

    public native int rsnSamplerCreate(int i, int i2, int i3, int i4, int i5, int i6, float f);

    public native void rsnScriptBindAllocation(int i, int i2, int i3, int i4);

    public native int rsnScriptCCreate(int i, String str, String str2, byte[] bArr, int i2);

    public native int rsnScriptFieldIDCreate(int i, int i2, int i3);

    public native void rsnScriptForEach(int i, int i2, int i3, int i4, int i5);

    public native void rsnScriptForEach(int i, int i2, int i3, int i4, int i5, byte[] bArr);

    public native void rsnScriptForEachClipped(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    public native void rsnScriptForEachClipped(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7, int i8, int i9, int i10, int i11);

    public native int rsnScriptGroupCreate(int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5);

    public native void rsnScriptGroupExecute(int i, int i2);

    public native void rsnScriptGroupSetInput(int i, int i2, int i3, int i4);

    public native void rsnScriptGroupSetOutput(int i, int i2, int i3, int i4);

    public native int rsnScriptIntrinsicCreate(int i, int i2, int i3);

    public native void rsnScriptInvoke(int i, int i2, int i3);

    public native void rsnScriptInvokeV(int i, int i2, int i3, byte[] bArr);

    public native int rsnScriptKernelIDCreate(int i, int i2, int i3, int i4);

    public native void rsnScriptSetTimeZone(int i, int i2, byte[] bArr);

    public native void rsnScriptSetVarD(int i, int i2, int i3, double d);

    public native void rsnScriptSetVarF(int i, int i2, int i3, float f);

    public native void rsnScriptSetVarI(int i, int i2, int i3, int i4);

    public native void rsnScriptSetVarJ(int i, int i2, int i3, long j);

    public native void rsnScriptSetVarObj(int i, int i2, int i3, int i4);

    public native void rsnScriptSetVarV(int i, int i2, int i3, byte[] bArr);

    public native void rsnScriptSetVarVE(int i, int i2, int i3, byte[] bArr, int i4, int[] iArr);

    public native int rsnTypeCreate(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6);

    public native void rsnTypeGetNativeData(int i, int i2, int[] iArr);

    public int safeID(BaseObj baseObj) {
        if (baseObj != null) {
            return baseObj.getID(this);
        }
        return 0;
    }

    public void sendMessage(int i, int[] iArr) {
        nContextSendMessage(i, iArr);
    }

    public void setErrorHandler(RSErrorHandler rSErrorHandler) {
        this.mErrorCallback = rSErrorHandler;
        if (isNative) {
            ((RenderScriptThunker) this).setErrorHandler(rSErrorHandler);
        }
    }

    public void setMessageHandler(RSMessageHandler rSMessageHandler) {
        this.mMessageCallback = rSMessageHandler;
        if (isNative) {
            ((RenderScriptThunker) this).setMessageHandler(rSMessageHandler);
        }
    }

    public void setPriority(Priority priority) {
        validate();
        nContextSetPriority(priority.mID);
    }

    public void validate() {
        if (this.mContext != 0) {
            return;
        }
        throw new RSInvalidStateException("Calling RS with no Context active.");
    }
}
