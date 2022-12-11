package androidx.renderscript;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes3.dex */
public class BaseObj {
    public boolean mDestroyed = false;
    public int mID;
    public RenderScript mRS;

    public BaseObj(int i, RenderScript renderScript) {
        renderScript.validate();
        this.mRS = renderScript;
        this.mID = i;
    }

    private void helpDestroy() {
        boolean z;
        synchronized (this) {
            z = true;
            if (!this.mDestroyed) {
                this.mDestroyed = true;
            } else {
                z = false;
            }
        }
        if (z) {
            ReentrantReadWriteLock.ReadLock readLock = this.mRS.mRWLock.readLock();
            readLock.lock();
            if (this.mRS.isAlive()) {
                this.mRS.nObjDestroy(this.mID);
            }
            readLock.unlock();
            this.mRS = null;
            this.mID = 0;
        }
    }

    public void checkValid() {
        if (this.mID == 0 && mo4369getNObj() == null) {
            throw new RSIllegalArgumentException("Invalid object.");
        }
    }

    public void destroy() {
        if (!this.mDestroyed) {
            helpDestroy();
            return;
        }
        throw new RSInvalidStateException("Object already destroyed.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return RenderScript.isNative ? ((RenderScriptThunker) this.mRS).equals(this, obj) : this.mID == ((BaseObj) obj).mID;
    }

    public void finalize() throws Throwable {
        helpDestroy();
        super.finalize();
    }

    public int getID(RenderScript renderScript) {
        this.mRS.validate();
        if (!this.mDestroyed) {
            if (this.mID == 0) {
                throw new RSRuntimeException("Internal error: Object id 0.");
            }
            if (renderScript != null && renderScript != this.mRS) {
                throw new RSInvalidStateException("using object with mismatched context.");
            }
            return this.mID;
        }
        throw new RSInvalidStateException("using a destroyed object.");
    }

    /* renamed from: getNObj */
    public android.renderscript.BaseObj mo4369getNObj() {
        return null;
    }

    public int hashCode() {
        return this.mID;
    }

    public void setID(int i) {
        if (this.mID == 0) {
            this.mID = i;
            return;
        }
        throw new RSRuntimeException("Internal Error, reset of object ID.");
    }
}
