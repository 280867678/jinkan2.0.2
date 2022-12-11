package androidx.renderscript;

/* loaded from: classes3.dex */
public class Type extends BaseObj {
    public boolean mDimFaces;
    public boolean mDimMipmaps;
    public int mDimX;
    public int mDimY;
    public int mDimYuv;
    public int mDimZ;
    public Element mElement;
    public int mElementCount;

    /* loaded from: classes3.dex */
    public static class Builder {
        public boolean mDimFaces;
        public boolean mDimMipmaps;
        public int mDimX = 1;
        public int mDimY;
        public int mDimZ;
        public Element mElement;
        public RenderScript mRS;
        public int mYuv;

        public Builder(RenderScript renderScript, Element element) {
            element.checkValid();
            this.mRS = renderScript;
            this.mElement = element;
        }

        public Type create() {
            if (this.mDimZ > 0) {
                if (this.mDimX < 1 || this.mDimY < 1) {
                    throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                }
                if (this.mDimFaces) {
                    throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                }
            }
            if (this.mDimY <= 0 || this.mDimX >= 1) {
                if (this.mDimFaces && this.mDimY < 1) {
                    throw new RSInvalidStateException("Cube maps require 2D Types.");
                }
                if (this.mYuv != 0 && (this.mDimZ != 0 || this.mDimFaces || this.mDimMipmaps)) {
                    throw new RSInvalidStateException("YUV only supports basic 2D.");
                }
                RenderScript renderScript = this.mRS;
                Type create = RenderScript.isNative ? TypeThunker.create((RenderScriptThunker) renderScript, this.mElement, this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv) : new Type(renderScript.nTypeCreate(this.mElement.getID(renderScript), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS);
                create.mElement = this.mElement;
                create.mDimX = this.mDimX;
                create.mDimY = this.mDimY;
                create.mDimZ = this.mDimZ;
                create.mDimMipmaps = this.mDimMipmaps;
                create.mDimFaces = this.mDimFaces;
                create.mDimYuv = this.mYuv;
                create.calcElementCount();
                return create;
            }
            throw new RSInvalidStateException("X dimension required when Y is present.");
        }

        public Builder setFaces(boolean z) {
            this.mDimFaces = z;
            return this;
        }

        public Builder setMipmaps(boolean z) {
            this.mDimMipmaps = z;
            return this;
        }

        public Builder setX(int i) {
            if (i >= 1) {
                this.mDimX = i;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
        }

        public Builder setY(int i) {
            if (i >= 1) {
                this.mDimY = i;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
        }

        public Builder setYuvFormat(int i) {
            if (i == 17 || i == 842094169) {
                this.mYuv = i;
                return this;
            }
            throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");
        }

        public Builder setZ(int i) {
            if (i >= 1) {
                this.mDimZ = i;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
        }
    }

    /* loaded from: classes3.dex */
    public enum CubemapFace {
        POSITIVE_X(0),
        NEGATIVE_X(1),
        POSITIVE_Y(2),
        NEGATIVE_Y(3),
        POSITIVE_Z(4),
        NEGATIVE_Z(5);
        
        public int mID;

        CubemapFace(int i) {
            this.mID = i;
        }
    }

    public Type(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public void calcElementCount() {
        boolean hasMipmaps = hasMipmaps();
        int x = getX();
        int y = getY();
        int z = getZ();
        int i = hasFaces() ? 6 : 1;
        if (x == 0) {
            x = 1;
        }
        if (y == 0) {
            y = 1;
        }
        if (z == 0) {
            z = 1;
        }
        int i2 = x * y * z * i;
        while (hasMipmaps && (x > 1 || y > 1 || z > 1)) {
            if (x > 1) {
                x >>= 1;
            }
            if (y > 1) {
                y >>= 1;
            }
            if (z > 1) {
                z >>= 1;
            }
            i2 += x * y * z * i;
        }
        this.mElementCount = i2;
    }

    public int getCount() {
        return this.mElementCount;
    }

    public Element getElement() {
        return this.mElement;
    }

    public int getX() {
        return this.mDimX;
    }

    public int getY() {
        return this.mDimY;
    }

    public int getYuv() {
        return this.mDimYuv;
    }

    public int getZ() {
        return this.mDimZ;
    }

    public boolean hasFaces() {
        return this.mDimFaces;
    }

    public boolean hasMipmaps() {
        return this.mDimMipmaps;
    }
}
