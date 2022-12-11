package androidx.renderscript;

import android.content.Context;
import android.renderscript.RenderScript;
import androidx.renderscript.RenderScript;

/* loaded from: classes3.dex */
public class RenderScriptThunker extends RenderScript {

    /* renamed from: mN */
    public android.renderscript.RenderScript f125mN;

    public RenderScriptThunker(Context context) {
        super(context);
        RenderScript.isNative = true;
    }

    public static RenderScript create(Context context, int i) {
        try {
            RenderScriptThunker renderScriptThunker = new RenderScriptThunker(context);
            renderScriptThunker.f125mN = (android.renderscript.RenderScript) Class.forName("android.renderscript.RenderScript").getDeclaredMethod("create", Context.class, Integer.TYPE).invoke(null, context, new Integer(i));
            return renderScriptThunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        } catch (Exception unused) {
            throw new RSRuntimeException("Failure to create platform RenderScript context");
        }
    }

    @Override // androidx.renderscript.RenderScript
    public void contextDump() {
        try {
            this.f125mN.contextDump();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.RenderScript
    public void destroy() {
        try {
            this.f125mN.destroy();
            this.f125mN = null;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public boolean equals(Object obj, Object obj2) {
        if (obj2 instanceof BaseObj) {
            return ((android.renderscript.BaseObj) obj).equals(((BaseObj) obj2).mo4369getNObj());
        }
        return false;
    }

    @Override // androidx.renderscript.RenderScript
    public void finish() {
        try {
            this.f125mN.finish();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.RenderScript
    public void setErrorHandler(RenderScript.RSErrorHandler rSErrorHandler) {
        this.mErrorCallback = rSErrorHandler;
        try {
            this.f125mN.setErrorHandler(new RenderScript.RSErrorHandler() { // from class: androidx.renderscript.RenderScriptThunker.2
                @Override // android.renderscript.RenderScript.RSErrorHandler, java.lang.Runnable
                public void run() {
                    RenderScript.RSErrorHandler rSErrorHandler2 = RenderScriptThunker.this.mErrorCallback;
                    rSErrorHandler2.mErrorMessage = ((RenderScript.RSErrorHandler) this).mErrorMessage;
                    rSErrorHandler2.mErrorNum = ((RenderScript.RSErrorHandler) this).mErrorNum;
                    rSErrorHandler2.run();
                }
            });
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.RenderScript
    public void setMessageHandler(RenderScript.RSMessageHandler rSMessageHandler) {
        this.mMessageCallback = rSMessageHandler;
        try {
            this.f125mN.setMessageHandler(new RenderScript.RSMessageHandler() { // from class: androidx.renderscript.RenderScriptThunker.1
                @Override // android.renderscript.RenderScript.RSMessageHandler, java.lang.Runnable
                public void run() {
                    RenderScript.RSMessageHandler rSMessageHandler2 = RenderScriptThunker.this.mMessageCallback;
                    rSMessageHandler2.mData = ((RenderScript.RSMessageHandler) this).mData;
                    rSMessageHandler2.mID = ((RenderScript.RSMessageHandler) this).mID;
                    rSMessageHandler2.mLength = ((RenderScript.RSMessageHandler) this).mLength;
                    rSMessageHandler2.run();
                }
            });
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.RenderScript
    public void setPriority(RenderScript.Priority priority) {
        try {
            if (priority == RenderScript.Priority.LOW) {
                this.f125mN.setPriority(RenderScript.Priority.LOW);
            }
            if (priority != RenderScript.Priority.NORMAL) {
                return;
            }
            this.f125mN.setPriority(RenderScript.Priority.NORMAL);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.RenderScript
    public void validate() {
        if (this.f125mN != null) {
            return;
        }
        throw new RSInvalidStateException("Calling RS with no Context active.");
    }
}
