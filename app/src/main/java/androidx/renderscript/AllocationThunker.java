package androidx.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Allocation;
import androidx.renderscript.Allocation;

/* loaded from: classes3.dex */
public class AllocationThunker extends Allocation {
    public static BitmapFactory.Options mBitmapOptions;

    /* renamed from: mN */
    public android.renderscript.Allocation f73mN;

    /* renamed from: androidx.renderscript.AllocationThunker$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C05221 {

        /* renamed from: $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl */
        public static final /* synthetic */ int[] f74xf845ab5c;

        static {
            int[] iArr = new int[Allocation.MipmapControl.values().length];
            f74xf845ab5c = iArr;
            try {
                Allocation.MipmapControl mipmapControl = Allocation.MipmapControl.MIPMAP_NONE;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f74xf845ab5c;
                Allocation.MipmapControl mipmapControl2 = Allocation.MipmapControl.MIPMAP_FULL;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f74xf845ab5c;
                Allocation.MipmapControl mipmapControl3 = Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        BitmapFactory.Options options = new BitmapFactory.Options();
        mBitmapOptions = options;
        options.inScaled = false;
    }

    public AllocationThunker(RenderScript renderScript, Type type, int i, android.renderscript.Allocation allocation) {
        super(0, renderScript, type, i);
        this.mType = type;
        this.mUsage = i;
        this.f73mN = allocation;
    }

    public static Allocation.MipmapControl convertMipmapControl(Allocation.MipmapControl mipmapControl) {
        int ordinal = mipmapControl.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return Allocation.MipmapControl.MIPMAP_FULL;
            }
            if (ordinal == 2) {
                return Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE;
            }
            return null;
        }
        return Allocation.MipmapControl.MIPMAP_NONE;
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap, Allocation.MipmapControl mipmapControl, int i) {
        try {
            android.renderscript.Allocation createCubemapFromBitmap = android.renderscript.Allocation.createCubemapFromBitmap(((RenderScriptThunker) renderScript).f125mN, bitmap, convertMipmapControl(mipmapControl), i);
            return new AllocationThunker(renderScript, new TypeThunker(renderScript, createCubemapFromBitmap.getType()), i, createCubemapFromBitmap);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, Allocation.MipmapControl mipmapControl, int i) {
        try {
            android.renderscript.Allocation createCubemapFromCubeFaces = android.renderscript.Allocation.createCubemapFromCubeFaces(((RenderScriptThunker) renderScript).f125mN, bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, convertMipmapControl(mipmapControl), i);
            return new AllocationThunker(renderScript, new TypeThunker(renderScript, createCubemapFromCubeFaces.getType()), i, createCubemapFromCubeFaces);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap, Allocation.MipmapControl mipmapControl, int i) {
        try {
            android.renderscript.Allocation createFromBitmap = android.renderscript.Allocation.createFromBitmap(((RenderScriptThunker) renderScript).f125mN, bitmap, convertMipmapControl(mipmapControl), i);
            return new AllocationThunker(renderScript, new TypeThunker(renderScript, createFromBitmap.getType()), i, createFromBitmap);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i, Allocation.MipmapControl mipmapControl, int i2) {
        try {
            android.renderscript.Allocation createFromBitmapResource = android.renderscript.Allocation.createFromBitmapResource(((RenderScriptThunker) renderScript).f125mN, resources, i, convertMipmapControl(mipmapControl), i2);
            return new AllocationThunker(renderScript, new TypeThunker(renderScript, createFromBitmapResource.getType()), i2, createFromBitmapResource);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Allocation createFromString(RenderScript renderScript, String str, int i) {
        try {
            android.renderscript.Allocation createFromString = android.renderscript.Allocation.createFromString(((RenderScriptThunker) renderScript).f125mN, str, i);
            return new AllocationThunker(renderScript, new TypeThunker(renderScript, createFromString.getType()), i, createFromString);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i, int i2) {
        ElementThunker elementThunker = (ElementThunker) element;
        try {
            android.renderscript.Allocation createSized = android.renderscript.Allocation.createSized(((RenderScriptThunker) renderScript).f125mN, (android.renderscript.Element) element.mo4369getNObj(), i, i2);
            return new AllocationThunker(renderScript, new TypeThunker(renderScript, createSized.getType()), i2, createSized);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, Allocation.MipmapControl mipmapControl, int i) {
        try {
            return new AllocationThunker(renderScript, type, i, android.renderscript.Allocation.createTyped(((RenderScriptThunker) renderScript).f125mN, ((TypeThunker) type).f150mN, convertMipmapControl(mipmapControl), i));
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFrom(int i, int i2, Allocation allocation, int i3) {
        try {
            this.f73mN.copy1DRangeFrom(i, i2, ((AllocationThunker) allocation).f73mN, i3);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFrom(int i, int i2, byte[] bArr) {
        try {
            this.f73mN.copy1DRangeFrom(i, i2, bArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFrom(int i, int i2, float[] fArr) {
        try {
            this.f73mN.copy1DRangeFrom(i, i2, fArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFrom(int i, int i2, int[] iArr) {
        try {
            this.f73mN.copy1DRangeFrom(i, i2, iArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFrom(int i, int i2, short[] sArr) {
        try {
            this.f73mN.copy1DRangeFrom(i, i2, sArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFromUnchecked(int i, int i2, byte[] bArr) {
        try {
            this.f73mN.copy1DRangeFromUnchecked(i, i2, bArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFromUnchecked(int i, int i2, float[] fArr) {
        try {
            this.f73mN.copy1DRangeFromUnchecked(i, i2, fArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFromUnchecked(int i, int i2, int[] iArr) {
        try {
            this.f73mN.copy1DRangeFromUnchecked(i, i2, iArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy1DRangeFromUnchecked(int i, int i2, short[] sArr) {
        try {
            this.f73mN.copy1DRangeFromUnchecked(i, i2, sArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy2DRangeFrom(int i, int i2, int i3, int i4, Allocation allocation, int i5, int i6) {
        try {
            this.f73mN.copy2DRangeFrom(i, i2, i3, i4, ((AllocationThunker) allocation).f73mN, i5, i6);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy2DRangeFrom(int i, int i2, int i3, int i4, byte[] bArr) {
        try {
            this.f73mN.copy2DRangeFrom(i, i2, i3, i4, bArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy2DRangeFrom(int i, int i2, int i3, int i4, float[] fArr) {
        try {
            this.f73mN.copy2DRangeFrom(i, i2, i3, i4, fArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy2DRangeFrom(int i, int i2, int i3, int i4, int[] iArr) {
        try {
            this.f73mN.copy2DRangeFrom(i, i2, i3, i4, iArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy2DRangeFrom(int i, int i2, int i3, int i4, short[] sArr) {
        try {
            this.f73mN.copy2DRangeFrom(i, i2, i3, i4, sArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copy2DRangeFrom(int i, int i2, Bitmap bitmap) {
        try {
            this.f73mN.copy2DRangeFrom(i, i2, bitmap);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFrom(Bitmap bitmap) {
        try {
            this.f73mN.copyFrom(bitmap);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFrom(Allocation allocation) {
        try {
            this.f73mN.copyFrom(((AllocationThunker) allocation).f73mN);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFrom(byte[] bArr) {
        try {
            this.f73mN.copyFrom(bArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFrom(float[] fArr) {
        try {
            this.f73mN.copyFrom(fArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFrom(int[] iArr) {
        try {
            this.f73mN.copyFrom(iArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFrom(BaseObj[] baseObjArr) {
        if (baseObjArr == null) {
            return;
        }
        android.renderscript.BaseObj[] baseObjArr2 = new android.renderscript.BaseObj[baseObjArr.length];
        for (int i = 0; i < baseObjArr.length; i++) {
            baseObjArr2[i] = baseObjArr[i].mo4369getNObj();
        }
        try {
            this.f73mN.copyFrom(baseObjArr2);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFrom(short[] sArr) {
        try {
            this.f73mN.copyFrom(sArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFromUnchecked(byte[] bArr) {
        try {
            this.f73mN.copyFromUnchecked(bArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFromUnchecked(float[] fArr) {
        try {
            this.f73mN.copyFromUnchecked(fArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFromUnchecked(int[] iArr) {
        try {
            this.f73mN.copyFromUnchecked(iArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyFromUnchecked(short[] sArr) {
        try {
            this.f73mN.copyFromUnchecked(sArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyTo(Bitmap bitmap) {
        try {
            this.f73mN.copyTo(bitmap);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyTo(byte[] bArr) {
        try {
            this.f73mN.copyTo(bArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyTo(float[] fArr) {
        try {
            this.f73mN.copyTo(fArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyTo(int[] iArr) {
        try {
            this.f73mN.copyTo(iArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void copyTo(short[] sArr) {
        try {
            this.f73mN.copyTo(sArr);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void generateMipmaps() {
        try {
            this.f73mN.generateMipmaps();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public int getBytesSize() {
        try {
            return this.f73mN.getBytesSize();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public Element getElement() {
        return getType().getElement();
    }

    @Override // androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.Allocation mo4369getNObj() {
        return this.f73mN;
    }

    @Override // androidx.renderscript.Allocation
    public Type getType() {
        return TypeThunker.find(this.f73mN.getType());
    }

    @Override // androidx.renderscript.Allocation
    public int getUsage() {
        try {
            return this.f73mN.getUsage();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void ioReceive() {
        try {
            this.f73mN.ioReceive();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void ioSend() {
        try {
            this.f73mN.ioSend();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void setFromFieldPacker(int i, int i2, FieldPacker fieldPacker) {
        try {
            byte[] data = fieldPacker.getData();
            int pos = fieldPacker.getPos();
            android.renderscript.FieldPacker fieldPacker2 = new android.renderscript.FieldPacker(pos);
            for (int i3 = 0; i3 < pos; i3++) {
                fieldPacker2.addI8(data[i3]);
            }
            this.f73mN.setFromFieldPacker(i, i2, fieldPacker2);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void setFromFieldPacker(int i, FieldPacker fieldPacker) {
        try {
            byte[] data = fieldPacker.getData();
            int pos = fieldPacker.getPos();
            android.renderscript.FieldPacker fieldPacker2 = new android.renderscript.FieldPacker(pos);
            for (int i2 = 0; i2 < pos; i2++) {
                fieldPacker2.addI8(data[i2]);
            }
            this.f73mN.setFromFieldPacker(i, fieldPacker2);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Allocation
    public void syncAll(int i) {
        try {
            this.f73mN.syncAll(i);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
