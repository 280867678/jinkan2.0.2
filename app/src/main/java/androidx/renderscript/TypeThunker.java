package androidx.renderscript;

import android.renderscript.Type;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class TypeThunker extends Type {
    public static HashMap<android.renderscript.Type, Type> mMap = new HashMap<>();

    /* renamed from: mN */
    public android.renderscript.Type f150mN;

    public TypeThunker(RenderScript renderScript, android.renderscript.Type type) {
        super(0, renderScript);
        this.f150mN = type;
        try {
            internalCalc();
            this.mElement = new ElementThunker(renderScript, type.getElement());
            synchronized (mMap) {
                mMap.put(this.f150mN, this);
            }
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Type create(RenderScript renderScript, Element element, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        try {
            Type.Builder builder = new Type.Builder(((RenderScriptThunker) renderScript).f125mN, ((ElementThunker) element).f94mN);
            if (i > 0) {
                builder.setX(i);
            }
            if (i2 > 0) {
                builder.setY(i2);
            }
            if (i3 > 0) {
                builder.setZ(i3);
            }
            if (z) {
                builder.setMipmaps(z);
            }
            if (z2) {
                builder.setFaces(z2);
            }
            if (i4 > 0) {
                builder.setYuvFormat(i4);
            }
            TypeThunker typeThunker = new TypeThunker(renderScript, builder.create());
            typeThunker.internalCalc();
            return typeThunker;
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Type find(android.renderscript.Type type) {
        return mMap.get(type);
    }

    @Override // androidx.renderscript.BaseObj
    /* renamed from: getNObj  reason: collision with other method in class */
    public android.renderscript.Type mo4369getNObj() {
        return this.f150mN;
    }

    public void internalCalc() {
        this.mDimX = this.f150mN.getX();
        this.mDimY = this.f150mN.getY();
        this.mDimZ = this.f150mN.getZ();
        this.mDimFaces = this.f150mN.hasFaces();
        this.mDimMipmaps = this.f150mN.hasMipmaps();
        this.mDimYuv = this.f150mN.getYuv();
        calcElementCount();
    }
}
