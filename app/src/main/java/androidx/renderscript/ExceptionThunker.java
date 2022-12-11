package androidx.renderscript;

/* loaded from: classes3.dex */
public class ExceptionThunker {
    public static RuntimeException convertException(RuntimeException runtimeException) {
        return runtimeException instanceof android.renderscript.RSIllegalArgumentException ? new RSIllegalArgumentException(runtimeException.getMessage()) : runtimeException instanceof android.renderscript.RSInvalidStateException ? new RSInvalidStateException(runtimeException.getMessage()) : runtimeException instanceof android.renderscript.RSDriverException ? new RSDriverException(runtimeException.getMessage()) : runtimeException instanceof android.renderscript.RSRuntimeException ? new RSRuntimeException(runtimeException.getMessage()) : runtimeException;
    }
}
