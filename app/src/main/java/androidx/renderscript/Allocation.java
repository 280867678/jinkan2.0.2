package androidx.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.renderscript.Element;
import androidx.renderscript.Type;
import com.tencent.smtt.sdk.TbsListener;
import me.tvspark.outline;
import org.mozilla.javascript.Token;

/* loaded from: classes3.dex */
public class Allocation extends BaseObj {
    public static final int USAGE_GRAPHICS_TEXTURE = 2;
    public static final int USAGE_IO_INPUT = 32;
    public static final int USAGE_IO_OUTPUT = 64;
    public static final int USAGE_SCRIPT = 1;
    public static final int USAGE_SHARED = 128;
    public static BitmapFactory.Options mBitmapOptions;
    public Allocation mAdaptedAllocation;
    public Bitmap mBitmap;
    public boolean mConstrainedFace;
    public boolean mConstrainedLOD;
    public boolean mConstrainedY;
    public boolean mConstrainedZ;
    public int mCurrentCount;
    public int mCurrentDimX;
    public int mCurrentDimY;
    public int mCurrentDimZ;
    public boolean mReadAllowed = true;
    public Type.CubemapFace mSelectedFace = Type.CubemapFace.POSITIVE_X;
    public int mSelectedLOD;
    public int mSelectedY;
    public int mSelectedZ;
    public int mSize;
    public Type mType;
    public int mUsage;
    public boolean mWriteAllowed;

    /* renamed from: androidx.renderscript.Allocation$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C05211 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum MipmapControl {
        MIPMAP_NONE(0),
        MIPMAP_FULL(1),
        MIPMAP_ON_SYNC_TO_TEXTURE(2);
        
        public int mID;

        MipmapControl(int i) {
            this.mID = i;
        }
    }

    static {
        BitmapFactory.Options options = new BitmapFactory.Options();
        mBitmapOptions = options;
        options.inScaled = false;
    }

    public Allocation(int i, RenderScript renderScript, Type type, int i2) {
        super(i, renderScript);
        this.mWriteAllowed = true;
        if ((i2 & (-228)) == 0) {
            if ((i2 & 32) != 0) {
                this.mWriteAllowed = false;
                if ((i2 & (-36)) != 0) {
                    throw new RSIllegalArgumentException("Invalid usage combination.");
                }
            }
            this.mType = type;
            this.mUsage = i2;
            this.mSize = this.mType.getElement().getBytesSize() * type.getCount();
            if (type != null) {
                updateCacheInfo(type);
            }
            if (!RenderScript.sUseGCHooks) {
                return;
            }
            try {
                RenderScript.registerNativeAllocation.invoke(RenderScript.sRuntime, Integer.valueOf(this.mSize));
                return;
            } catch (Exception e) {
                String str = "Couldn't invoke registerNativeAllocation:" + e;
                throw new RSRuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Couldn't invoke registerNativeAllocation:", e));
            }
        }
        throw new RSIllegalArgumentException("Unknown usage specified.");
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        return createCubemapFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i) {
        renderScript.validate();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if (width % 6 == 0) {
            if (width / 6 != height) {
                throw new RSIllegalArgumentException("Only square cube map faces supported");
            }
            boolean z = false;
            if (!(((height + (-1)) & height) == 0)) {
                throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
            }
            Element elementFromBitmap = elementFromBitmap(renderScript, bitmap);
            Type.Builder builder = new Type.Builder(renderScript, elementFromBitmap);
            builder.setX(height);
            builder.setY(height);
            builder.setFaces(true);
            if (mipmapControl == MipmapControl.MIPMAP_FULL) {
                z = true;
            }
            builder.setMipmaps(z);
            Type create = builder.create();
            int nAllocationCubeCreateFromBitmap = renderScript.nAllocationCubeCreateFromBitmap(create.getID(renderScript), mipmapControl.mID, bitmap, i);
            if (nAllocationCubeCreateFromBitmap != 0) {
                return new Allocation(nAllocationCubeCreateFromBitmap, renderScript, create, i);
            }
            throw new RSRuntimeException("Load failed for bitmap " + bitmap + " element " + elementFromBitmap);
        }
        throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        return createCubemapFromCubeFaces(renderScript, bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, MipmapControl mipmapControl, int i) {
        return null;
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        return createFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, Token.LABEL);
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i) {
        if (RenderScript.isNative) {
            return AllocationThunker.createFromBitmap((RenderScriptThunker) renderScript, bitmap, mipmapControl, i);
        }
        renderScript.validate();
        if (bitmap.getConfig() == null) {
            if ((i & 128) != 0) {
                throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return createFromBitmap(renderScript, createBitmap, mipmapControl, i);
        }
        Type typeFromBitmap = typeFromBitmap(renderScript, bitmap, mipmapControl);
        if (mipmapControl != MipmapControl.MIPMAP_NONE || !typeFromBitmap.getElement().isCompatible(Element.RGBA_8888(renderScript)) || i != 131) {
            int nAllocationCreateFromBitmap = renderScript.nAllocationCreateFromBitmap(typeFromBitmap.getID(renderScript), mipmapControl.mID, bitmap, i);
            if (nAllocationCreateFromBitmap == 0) {
                throw new RSRuntimeException("Load failed.");
            }
            return new Allocation(nAllocationCreateFromBitmap, renderScript, typeFromBitmap, i);
        }
        int nAllocationCreateBitmapBackedAllocation = renderScript.nAllocationCreateBitmapBackedAllocation(typeFromBitmap.getID(renderScript), mipmapControl.mID, bitmap, i);
        if (nAllocationCreateBitmapBackedAllocation == 0) {
            throw new RSRuntimeException("Load failed.");
        }
        Allocation allocation = new Allocation(nAllocationCreateBitmapBackedAllocation, renderScript, typeFromBitmap, i);
        allocation.setBitmap(bitmap);
        return allocation;
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i) {
        return createFromBitmapResource(renderScript, resources, i, MipmapControl.MIPMAP_NONE, 3);
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i, MipmapControl mipmapControl, int i2) {
        renderScript.validate();
        if ((i2 & TbsListener.ErrorCode.EXCEED_INCR_UPDATE) == 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
            Allocation createFromBitmap = createFromBitmap(renderScript, decodeResource, mipmapControl, i2);
            decodeResource.recycle();
            return createFromBitmap;
        }
        throw new RSIllegalArgumentException("Unsupported usage specified.");
    }

    public static Allocation createFromString(RenderScript renderScript, String str, int i) {
        renderScript.validate();
        try {
            byte[] bytes = str.getBytes("UTF-8");
            Allocation createSized = createSized(renderScript, Element.m4196U8(renderScript), bytes.length, i);
            createSized.copyFrom(bytes);
            return createSized;
        } catch (Exception unused) {
            throw new RSRuntimeException("Could not convert string to utf-8.");
        }
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i) {
        return createSized(renderScript, element, i, 1);
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i, int i2) {
        if (RenderScript.isNative) {
            RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
            return AllocationThunker.createSized(renderScript, element, i, i2);
        }
        renderScript.validate();
        Type.Builder builder = new Type.Builder(renderScript, element);
        builder.setX(i);
        Type create = builder.create();
        int nAllocationCreateTyped = renderScript.nAllocationCreateTyped(create.getID(renderScript), MipmapControl.MIPMAP_NONE.mID, i2, 0);
        if (nAllocationCreateTyped == 0) {
            throw new RSRuntimeException("Allocation creation failed.");
        }
        return new Allocation(nAllocationCreateTyped, renderScript, create, i2);
    }

    public static Allocation createTyped(RenderScript renderScript, Type type) {
        return createTyped(renderScript, type, MipmapControl.MIPMAP_NONE, 1);
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, int i) {
        return createTyped(renderScript, type, MipmapControl.MIPMAP_NONE, i);
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, MipmapControl mipmapControl, int i) {
        if (RenderScript.isNative) {
            return AllocationThunker.createTyped((RenderScriptThunker) renderScript, type, mipmapControl, i);
        }
        renderScript.validate();
        if (type.getID(renderScript) == 0) {
            throw new RSInvalidStateException("Bad Type");
        }
        int nAllocationCreateTyped = renderScript.nAllocationCreateTyped(type.getID(renderScript), mipmapControl.mID, i, 0);
        if (nAllocationCreateTyped == 0) {
            throw new RSRuntimeException("Allocation creation failed.");
        }
        return new Allocation(nAllocationCreateTyped, renderScript, type, i);
    }

    private void data1DChecks(int i, int i2, int i3, int i4) {
        this.mRS.validate();
        if (i >= 0) {
            if (i2 < 1) {
                throw new RSIllegalArgumentException("Count must be >= 1.");
            }
            if (i + i2 <= this.mCurrentCount) {
                if (i3 < i4) {
                    throw new RSIllegalArgumentException("Array too small for allocation type.");
                }
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Overflow, Available count ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mCurrentCount);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", got ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" at offset ");
            throw new RSIllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, "."));
        }
        throw new RSIllegalArgumentException("Offset must be >= 0.");
    }

    public static Element elementFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == Bitmap.Config.ALPHA_8) {
            return Element.A_8(renderScript);
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return Element.RGBA_4444(renderScript);
        }
        if (config == Bitmap.Config.ARGB_8888) {
            return Element.RGBA_8888(renderScript);
        }
        if (config == Bitmap.Config.RGB_565) {
            return Element.RGB_565(renderScript);
        }
        throw new RSInvalidStateException("Bad bitmap type: " + config);
    }

    private int getIDSafe() {
        Allocation allocation = this.mAdaptedAllocation;
        return allocation != null ? allocation.getID(this.mRS) : getID(this.mRS);
    }

    private void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public static Type typeFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl) {
        Type.Builder builder = new Type.Builder(renderScript, elementFromBitmap(renderScript, bitmap));
        builder.setX(bitmap.getWidth());
        builder.setY(bitmap.getHeight());
        builder.setMipmaps(mipmapControl == MipmapControl.MIPMAP_FULL);
        return builder.create();
    }

    private void updateCacheInfo(Type type) {
        this.mCurrentDimX = type.getX();
        this.mCurrentDimY = type.getY();
        this.mCurrentDimZ = type.getZ();
        int i = this.mCurrentDimX;
        this.mCurrentCount = i;
        int i2 = this.mCurrentDimY;
        if (i2 > 1) {
            this.mCurrentCount = i * i2;
        }
        int i3 = this.mCurrentDimZ;
        if (i3 > 1) {
            this.mCurrentCount *= i3;
        }
    }

    private void validate2DRange(int i, int i2, int i3, int i4) {
        if (this.mAdaptedAllocation != null) {
            return;
        }
        if (i < 0 || i2 < 0) {
            throw new RSIllegalArgumentException("Offset cannot be negative.");
        }
        if (i4 < 0 || i3 < 0) {
            throw new RSIllegalArgumentException("Height or width cannot be negative.");
        }
        if (i + i3 <= this.mCurrentDimX && i2 + i4 <= this.mCurrentDimY) {
            return;
        }
        throw new RSIllegalArgumentException("Updated region larger than allocation.");
    }

    private void validate3DRange(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mAdaptedAllocation != null) {
            return;
        }
        if (i < 0 || i2 < 0 || i3 < 0) {
            throw new RSIllegalArgumentException("Offset cannot be negative.");
        }
        if (i5 < 0 || i4 < 0 || i6 < 0) {
            throw new RSIllegalArgumentException("Height or width cannot be negative.");
        }
        if (i + i4 <= this.mCurrentDimX && i2 + i5 <= this.mCurrentDimY && i3 + i6 <= this.mCurrentDimZ) {
            return;
        }
        throw new RSIllegalArgumentException("Updated region larger than allocation.");
    }

    private void validateBitmapFormat(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config != null) {
            int i = C05211.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
            if (i == 1) {
                if (this.mType.getElement().mKind == Element.DataKind.PIXEL_A) {
                    return;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allocation kind is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mType.getElement().mKind);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", type ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mType.getElement().mType);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" of ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mType.getElement().getBytesSize());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" bytes, passed bitmap was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(config);
                throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else if (i == 2) {
                if (this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA && this.mType.getElement().getBytesSize() == 4) {
                    return;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allocation kind is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mType.getElement().mKind);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", type ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mType.getElement().mType);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" of ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.mType.getElement().getBytesSize());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" bytes, passed bitmap was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(config);
                throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } else if (i == 3) {
                if (this.mType.getElement().mKind == Element.DataKind.PIXEL_RGB && this.mType.getElement().getBytesSize() == 2) {
                    return;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allocation kind is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.mType.getElement().mKind);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(", type ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.mType.getElement().mType);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" of ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.mType.getElement().getBytesSize());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" bytes, passed bitmap was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(config);
                throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            } else if (i != 4) {
                return;
            } else {
                if (this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA && this.mType.getElement().getBytesSize() == 2) {
                    return;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Allocation kind is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.mType.getElement().mKind);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(", type ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.mType.getElement().mType);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(" of ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.mType.getElement().getBytesSize());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(" bytes, passed bitmap was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(config);
                throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            }
        }
        throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
    }

    private void validateBitmapSize(Bitmap bitmap) {
        if (this.mCurrentDimX == bitmap.getWidth() && this.mCurrentDimY == bitmap.getHeight()) {
            return;
        }
        throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
    }

    private void validateIsFloat32() {
        if (this.mType.mElement.mType == Element.DataType.FLOAT_32) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("32 bit float source does not match allocation type ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mType.mElement.mType);
        throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    private void validateIsInt16() {
        Element.DataType dataType = this.mType.mElement.mType;
        if (dataType == Element.DataType.SIGNED_16 || dataType == Element.DataType.UNSIGNED_16) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("16 bit integer source does not match allocation type ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mType.mElement.mType);
        throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    private void validateIsInt32() {
        Element.DataType dataType = this.mType.mElement.mType;
        if (dataType == Element.DataType.SIGNED_32 || dataType == Element.DataType.UNSIGNED_32) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("32 bit integer source does not match allocation type ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mType.mElement.mType);
        throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    private void validateIsInt8() {
        Element.DataType dataType = this.mType.mElement.mType;
        if (dataType == Element.DataType.SIGNED_8 || dataType == Element.DataType.UNSIGNED_8) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("8 bit integer source does not match allocation type ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mType.mElement.mType);
        throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    private void validateIsObject() {
        Element.DataType dataType = this.mType.mElement.mType;
        if (dataType == Element.DataType.RS_ELEMENT || dataType == Element.DataType.RS_TYPE || dataType == Element.DataType.RS_ALLOCATION || dataType == Element.DataType.RS_SAMPLER || dataType == Element.DataType.RS_SCRIPT) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Object source does not match allocation type ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mType.mElement.mType);
        throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void copy1DRangeFrom(int i, int i2, Allocation allocation, int i3) {
        this.mRS.nAllocationData2D(getIDSafe(), i, 0, this.mSelectedLOD, this.mSelectedFace.mID, i2, 1, allocation.getID(this.mRS), i3, 0, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy1DRangeFrom(int i, int i2, byte[] bArr) {
        validateIsInt8();
        copy1DRangeFromUnchecked(i, i2, bArr);
    }

    public void copy1DRangeFrom(int i, int i2, float[] fArr) {
        validateIsFloat32();
        copy1DRangeFromUnchecked(i, i2, fArr);
    }

    public void copy1DRangeFrom(int i, int i2, int[] iArr) {
        validateIsInt32();
        copy1DRangeFromUnchecked(i, i2, iArr);
    }

    public void copy1DRangeFrom(int i, int i2, short[] sArr) {
        validateIsInt16();
        copy1DRangeFromUnchecked(i, i2, sArr);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, byte[] bArr) {
        int bytesSize = this.mType.mElement.getBytesSize() * i2;
        data1DChecks(i, i2, bArr.length, bytesSize);
        this.mRS.nAllocationData1D(getIDSafe(), i, this.mSelectedLOD, i2, bArr, bytesSize);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, float[] fArr) {
        int bytesSize = this.mType.mElement.getBytesSize() * i2;
        data1DChecks(i, i2, fArr.length * 4, bytesSize);
        this.mRS.nAllocationData1D(getIDSafe(), i, this.mSelectedLOD, i2, fArr, bytesSize);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, int[] iArr) {
        int bytesSize = this.mType.mElement.getBytesSize() * i2;
        data1DChecks(i, i2, iArr.length * 4, bytesSize);
        this.mRS.nAllocationData1D(getIDSafe(), i, this.mSelectedLOD, i2, iArr, bytesSize);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, short[] sArr) {
        int bytesSize = this.mType.mElement.getBytesSize() * i2;
        data1DChecks(i, i2, sArr.length * 2, bytesSize);
        this.mRS.nAllocationData1D(getIDSafe(), i, this.mSelectedLOD, i2, sArr, bytesSize);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, Allocation allocation, int i5, int i6) {
        this.mRS.validate();
        validate2DRange(i, i2, i3, i4);
        this.mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, allocation.getID(this.mRS), i5, i6, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, byte[] bArr) {
        validateIsInt8();
        copy2DRangeFromUnchecked(i, i2, i3, i4, bArr);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, float[] fArr) {
        validateIsFloat32();
        copy2DRangeFromUnchecked(i, i2, i3, i4, fArr);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, int[] iArr) {
        validateIsInt32();
        copy2DRangeFromUnchecked(i, i2, i3, i4, iArr);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, short[] sArr) {
        validateIsInt16();
        copy2DRangeFromUnchecked(i, i2, i3, i4, sArr);
    }

    public void copy2DRangeFrom(int i, int i2, Bitmap bitmap) {
        this.mRS.validate();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            copy2DRangeFrom(i, i2, createBitmap);
            return;
        }
        validateBitmapFormat(bitmap);
        validate2DRange(i, i2, bitmap.getWidth(), bitmap.getHeight());
        this.mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, bitmap);
    }

    public void copy2DRangeFromUnchecked(int i, int i2, int i3, int i4, byte[] bArr) {
        this.mRS.validate();
        validate2DRange(i, i2, i3, i4);
        this.mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, bArr, bArr.length);
    }

    public void copy2DRangeFromUnchecked(int i, int i2, int i3, int i4, float[] fArr) {
        this.mRS.validate();
        validate2DRange(i, i2, i3, i4);
        this.mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, fArr, fArr.length * 4);
    }

    public void copy2DRangeFromUnchecked(int i, int i2, int i3, int i4, int[] iArr) {
        this.mRS.validate();
        validate2DRange(i, i2, i3, i4);
        this.mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, iArr, iArr.length * 4);
    }

    public void copy2DRangeFromUnchecked(int i, int i2, int i3, int i4, short[] sArr) {
        this.mRS.validate();
        validate2DRange(i, i2, i3, i4);
        this.mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, sArr, sArr.length * 2);
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, Allocation allocation, int i7, int i8, int i9) {
        this.mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        this.mRS.nAllocationData3D(getIDSafe(), i, i2, i3, this.mSelectedLOD, i4, i5, i6, allocation.getID(this.mRS), i7, i8, i9, allocation.mSelectedLOD);
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        validateIsInt8();
        copy3DRangeFromUnchecked(i, i2, i3, i4, i5, i6, bArr);
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, float[] fArr) {
        validateIsFloat32();
        copy3DRangeFromUnchecked(i, i2, i3, i4, i5, i6, fArr);
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        validateIsInt32();
        copy3DRangeFromUnchecked(i, i2, i3, i4, i5, i6, iArr);
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, short[] sArr) {
        validateIsInt16();
        copy3DRangeFromUnchecked(i, i2, i3, i4, i5, i6, sArr);
    }

    public void copy3DRangeFromUnchecked(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        this.mRS.nAllocationData3D(getIDSafe(), i, i2, i3, this.mSelectedLOD, i4, i5, i6, bArr, bArr.length);
    }

    public void copy3DRangeFromUnchecked(int i, int i2, int i3, int i4, int i5, int i6, float[] fArr) {
        this.mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        this.mRS.nAllocationData3D(getIDSafe(), i, i2, i3, this.mSelectedLOD, i4, i5, i6, fArr, fArr.length * 4);
    }

    public void copy3DRangeFromUnchecked(int i, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        this.mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        this.mRS.nAllocationData3D(getIDSafe(), i, i2, i3, this.mSelectedLOD, i4, i5, i6, iArr, iArr.length * 4);
    }

    public void copy3DRangeFromUnchecked(int i, int i2, int i3, int i4, int i5, int i6, short[] sArr) {
        this.mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        this.mRS.nAllocationData3D(getIDSafe(), i, i2, i3, this.mSelectedLOD, i4, i5, i6, sArr, sArr.length * 2);
    }

    public void copyFrom(Bitmap bitmap) {
        this.mRS.validate();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            copyFrom(createBitmap);
            return;
        }
        validateBitmapSize(bitmap);
        validateBitmapFormat(bitmap);
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationCopyFromBitmap(getID(renderScript), bitmap);
    }

    public void copyFrom(Allocation allocation) {
        this.mRS.validate();
        if (this.mType.equals(allocation.getType())) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, allocation, 0, 0);
            return;
        }
        throw new RSIllegalArgumentException("Types of allocations must match.");
    }

    public void copyFrom(byte[] bArr) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, bArr);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, i2, bArr);
        } else {
            copy1DRangeFrom(0, this.mCurrentCount, bArr);
        }
    }

    public void copyFrom(float[] fArr) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, fArr);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, i2, fArr);
        } else {
            copy1DRangeFrom(0, this.mCurrentCount, fArr);
        }
    }

    public void copyFrom(int[] iArr) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, iArr);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, i2, iArr);
        } else {
            copy1DRangeFrom(0, this.mCurrentCount, iArr);
        }
    }

    public void copyFrom(BaseObj[] baseObjArr) {
        this.mRS.validate();
        validateIsObject();
        if (baseObjArr.length != this.mCurrentCount) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Array size mismatch, allocation sizeX = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mCurrentCount);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", array length = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(baseObjArr.length);
            throw new RSIllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        int[] iArr = new int[baseObjArr.length];
        for (int i = 0; i < baseObjArr.length; i++) {
            iArr[i] = baseObjArr[i].getID(this.mRS);
        }
        copy1DRangeFromUnchecked(0, this.mCurrentCount, iArr);
    }

    public void copyFrom(short[] sArr) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, sArr);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, i2, sArr);
        } else {
            copy1DRangeFrom(0, this.mCurrentCount, sArr);
        }
    }

    public void copyFromUnchecked(byte[] bArr) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, bArr);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i2, bArr);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, bArr);
        }
    }

    public void copyFromUnchecked(float[] fArr) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, fArr);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i2, fArr);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, fArr);
        }
    }

    public void copyFromUnchecked(int[] iArr) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, iArr);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i2, iArr);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, iArr);
        }
    }

    public void copyFromUnchecked(short[] sArr) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, sArr);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i2, sArr);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, sArr);
        }
    }

    public void copyTo(Bitmap bitmap) {
        this.mRS.validate();
        validateBitmapFormat(bitmap);
        validateBitmapSize(bitmap);
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationCopyToBitmap(getID(renderScript), bitmap);
    }

    public void copyTo(byte[] bArr) {
        validateIsInt8();
        this.mRS.validate();
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationRead(getID(renderScript), bArr);
    }

    public void copyTo(float[] fArr) {
        validateIsFloat32();
        this.mRS.validate();
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationRead(getID(renderScript), fArr);
    }

    public void copyTo(int[] iArr) {
        validateIsInt32();
        this.mRS.validate();
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationRead(getID(renderScript), iArr);
    }

    public void copyTo(short[] sArr) {
        validateIsInt16();
        this.mRS.validate();
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationRead(getID(renderScript), sArr);
    }

    @Override // androidx.renderscript.BaseObj
    public void finalize() throws Throwable {
        if (RenderScript.sUseGCHooks) {
            RenderScript.registerNativeFree.invoke(RenderScript.sRuntime, Integer.valueOf(this.mSize));
        }
        super.finalize();
    }

    public void generateMipmaps() {
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationGenerateMipmaps(getID(renderScript));
    }

    public int getBytesSize() {
        Type type = this.mType;
        int i = type.mDimYuv;
        int count = type.getCount();
        return i != 0 ? (int) Math.ceil(this.mType.getElement().getBytesSize() * count * 1.5d) : this.mType.getElement().getBytesSize() * count;
    }

    public Element getElement() {
        return this.mType.getElement();
    }

    public Type getType() {
        return this.mType;
    }

    public int getUsage() {
        return this.mUsage;
    }

    public void ioReceive() {
        if ((this.mUsage & 32) != 0) {
            this.mRS.validate();
            RenderScript renderScript = this.mRS;
            renderScript.nAllocationIoReceive(getID(renderScript));
            return;
        }
        throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
    }

    public void ioSend() {
        if ((this.mUsage & 64) != 0) {
            this.mRS.validate();
            RenderScript renderScript = this.mRS;
            renderScript.nAllocationIoSend(getID(renderScript));
            return;
        }
        throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
    }

    public void ioSendOutput() {
        ioSend();
    }

    public void setFromFieldPacker(int i, int i2, FieldPacker fieldPacker) {
        this.mRS.validate();
        if (i2 < this.mType.mElement.mElements.length) {
            if (i < 0) {
                throw new RSIllegalArgumentException("Offset must be >= 0.");
            }
            byte[] data = fieldPacker.getData();
            int pos = fieldPacker.getPos();
            int bytesSize = this.mType.mElement.mElements[i2].getBytesSize() * this.mType.mElement.mArraySizes[i2];
            if (pos != bytesSize) {
                throw new RSIllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field packer sizelength ", pos, " does not match component size ", bytesSize, "."));
            }
            this.mRS.nAllocationElementData1D(getIDSafe(), i, this.mSelectedLOD, i2, data, pos);
            return;
        }
        throw new RSIllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Component_number ", i2, " out of range."));
    }

    public void setFromFieldPacker(int i, FieldPacker fieldPacker) {
        this.mRS.validate();
        int bytesSize = this.mType.mElement.getBytesSize();
        byte[] data = fieldPacker.getData();
        int pos = fieldPacker.getPos();
        int i2 = pos / bytesSize;
        if (bytesSize * i2 == pos) {
            copy1DRangeFromUnchecked(i, i2, data);
            return;
        }
        throw new RSIllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Field packer length ", pos, " not divisible by element size ", bytesSize, "."));
    }

    public void syncAll(int i) {
        if (i == 1 || i == 2) {
            this.mRS.validate();
            this.mRS.nAllocationSyncAll(getIDSafe(), i);
            return;
        }
        throw new RSIllegalArgumentException("Source must be exactly one usage type.");
    }
}
