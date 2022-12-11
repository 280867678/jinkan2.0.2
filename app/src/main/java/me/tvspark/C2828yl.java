package me.tvspark;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;

@RequiresApi(17)
/* renamed from: me.tvspark.yl */
/* loaded from: classes4.dex */
public final class C2828yl extends Surface {
    public static boolean Wwwwwwwwwwwwwwwwwwwww;
    public static int Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.yl$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends HandlerThread implements Handler.Callback {
        @Nullable
        public C2828yl Wwwwwwwwwwwwwwwwwwww;
        @Nullable
        public RuntimeException Wwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public Error Wwwwwwwwwwwwwwwwwwwwww;
        public Handler Wwwwwwwwwwwwwwwwwwwwwww;
        public EGLSurfaceTexture Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super("ExoPlayer:DummySurface");
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            EGLSurface eglCreatePbufferSurface;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            EGLSurfaceTexture eGLSurfaceTexture = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (eGLSurfaceTexture != null) {
                boolean z = false;
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                if (eglGetDisplay == null) {
                    throw new EGLSurfaceTexture.GlException("eglGetDisplay failed");
                }
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww = eglGetDisplay;
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    int[] iArr2 = new int[1];
                    boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, EGLSurfaceTexture.Wwwwwwwwwwwwwwwww, 0, eGLConfigArr, 0, 1, iArr2, 0);
                    if (eglChooseConfig && iArr2[0] > 0 && eGLConfigArr[0] != null) {
                        EGLConfig eGLConfig = eGLConfigArr[0];
                        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
                        if (eglCreateContext != null) {
                            eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwww = eglCreateContext;
                            EGLDisplay eGLDisplay = eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww;
                            if (i == 1) {
                                eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
                            } else {
                                eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                                if (eglCreatePbufferSurface == null) {
                                    throw new EGLSurfaceTexture.GlException("eglCreatePbufferSurface failed");
                                }
                            }
                            if (EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext)) {
                                eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwww = eglCreatePbufferSurface;
                                GLES20.glGenTextures(1, eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwwwww, 0);
                                while (true) {
                                    int glGetError = GLES20.glGetError();
                                    if (glGetError == 0) {
                                        break;
                                    }
                                    String valueOf = String.valueOf(GLU.gluErrorString(glGetError));
                                    if (valueOf.length() != 0) {
                                        "glError ".concat(valueOf);
                                    } else {
                                        new String("glError ");
                                    }
                                }
                                SurfaceTexture surfaceTexture = new SurfaceTexture(eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwwwww[0]);
                                eGLSurfaceTexture.Wwwwwwwwwwwwwwwwww = surfaceTexture;
                                surfaceTexture.setOnFrameAvailableListener(eGLSurfaceTexture);
                                SurfaceTexture surfaceTexture2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(surfaceTexture2);
                                if (i != 0) {
                                    z = true;
                                }
                                this.Wwwwwwwwwwwwwwwwwwww = new C2828yl(this, surfaceTexture2, z, null);
                                return;
                            }
                            throw new EGLSurfaceTexture.GlException("eglMakeCurrent failed");
                        }
                        throw new EGLSurfaceTexture.GlException("eglCreateContext failed");
                    }
                    throw new EGLSurfaceTexture.GlException(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]));
                }
                throw new EGLSurfaceTexture.GlException("eglInitialize failed");
            }
            throw null;
        }

        public C2828yl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            boolean z;
            start();
            Handler handler = new Handler(getLooper(), this);
            this.Wwwwwwwwwwwwwwwwwwwwwww = handler;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new EGLSurfaceTexture(handler);
            synchronized (this) {
                z = false;
                this.Wwwwwwwwwwwwwwwwwwwwwww.obtainMessage(1, i, 0).sendToTarget();
                while (this.Wwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwwwwww == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.Wwwwwwwwwwwwwwwwwwwww;
            if (runtimeException == null) {
                Error error = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (error != null) {
                    throw error;
                }
                C2828yl c2828yl = this.Wwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2828yl);
                return c2828yl;
            }
            throw runtimeException;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [android.opengl.EGLContext, android.graphics.SurfaceTexture, android.opengl.EGLSurface, android.opengl.EGLDisplay] */
        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            EGLSurfaceTexture eGLSurfaceTexture = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwwwwww.removeCallbacks(eGLSurfaceTexture);
            try {
                if (eGLSurfaceTexture.Wwwwwwwwwwwwwwwwww != null) {
                    eGLSurfaceTexture.Wwwwwwwwwwwwwwwwww.release();
                    GLES20.glDeleteTextures(1, eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwwwww, 0);
                }
            } finally {
                EGLDisplay eGLDisplay = eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww;
                if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                    EGLDisplay eGLDisplay2 = eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww;
                    EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                }
                EGLSurface eGLSurface2 = eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwww;
                if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                    EGL14.eglDestroySurface(eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww, eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwww);
                }
                EGLContext eGLContext = eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwww;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww, eGLContext);
                }
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 19) {
                    EGL14.eglReleaseThread();
                }
                EGLDisplay eGLDisplay3 = eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww;
                if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                    EGL14.eglTerminate(eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww);
                }
                eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwwww = null;
                eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwwww = null;
                eGLSurfaceTexture.Wwwwwwwwwwwwwwwwwww = null;
                eGLSurfaceTexture.Wwwwwwwwwwwwwwwwww = null;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to initialize dummy surface", e);
                    this.Wwwwwwwwwwwwwwwwwwwwww = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to initialize dummy surface", e2);
                    this.Wwwwwwwwwwwwwwwwwwwww = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    public /* synthetic */ C2828yl(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, SurfaceTexture surfaceTexture, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        super(surfaceTexture);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        boolean z;
        synchronized (C2828yl.class) {
            z = true;
            if (!Wwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
                Wwwwwwwwwwwwwwwwwwwww = true;
            }
            if (Wwwwwwwwwwwwwwwwwwwwww == 0) {
                z = false;
            }
        }
        return z;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        String eglQueryString;
        String eglQueryString2;
        int i = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = false;
        if (i >= 24 && (i >= 26 || (!"samsung".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"XT1650".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) && ((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString2.contains("EGL_EXT_protected_content"))) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_KHR_surfaceless_context")) {
                z = true;
            }
            return z ? 1 : 2;
        }
        return 0;
    }

    public static C2828yl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, boolean z) {
        int i = 0;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!z || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (z) {
            i = Wwwwwwwwwwwwwwwwwwwwww;
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.sendEmptyMessage(2);
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            }
        }
    }
}
