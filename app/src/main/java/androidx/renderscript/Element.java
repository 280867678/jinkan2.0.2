package androidx.renderscript;

import androidx.renderscript.ElementThunker;

/* loaded from: classes3.dex */
public class Element extends BaseObj {
    public int[] mArraySizes;
    public String[] mElementNames;
    public Element[] mElements;
    public DataKind mKind;
    public boolean mNormalized;
    public int[] mOffsetInBytes;
    public int mSize;
    public DataType mType;
    public int mVectorSize;
    public int[] mVisibleElementMap;

    /* renamed from: androidx.renderscript.Element$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C05231 {
        public static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Element$DataKind;
        public static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Element$DataType;

        static {
            int[] iArr = new int[DataKind.values().length];
            $SwitchMap$android$support$v8$renderscript$Element$DataKind = iArr;
            try {
                DataKind dataKind = DataKind.PIXEL_LA;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$android$support$v8$renderscript$Element$DataKind;
                DataKind dataKind2 = DataKind.PIXEL_RGB;
                iArr2[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$android$support$v8$renderscript$Element$DataKind;
                DataKind dataKind3 = DataKind.PIXEL_RGBA;
                iArr3[5] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr4 = new int[DataType.values().length];
            $SwitchMap$android$support$v8$renderscript$Element$DataType = iArr4;
            try {
                DataType dataType = DataType.FLOAT_32;
                iArr4[1] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType2 = DataType.FLOAT_64;
                iArr5[2] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType3 = DataType.SIGNED_8;
                iArr6[3] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType4 = DataType.SIGNED_16;
                iArr7[4] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType5 = DataType.SIGNED_32;
                iArr8[5] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType6 = DataType.SIGNED_64;
                iArr9[6] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType7 = DataType.UNSIGNED_8;
                iArr10[7] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType8 = DataType.UNSIGNED_16;
                iArr11[8] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType9 = DataType.UNSIGNED_32;
                iArr12[9] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType10 = DataType.UNSIGNED_64;
                iArr13[10] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                DataType dataType11 = DataType.BOOLEAN;
                iArr14[11] = 11;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public int[] mArraySizes;
        public int mCount;
        public String[] mElementNames;
        public Element[] mElements;
        public RenderScript mRS;
        public int mSkipPadding;

        /* renamed from: mT */
        public ElementThunker.BuilderThunker f93mT;

        public Builder(RenderScript renderScript) {
            if (RenderScript.isNative) {
                RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
                this.f93mT = new ElementThunker.BuilderThunker(renderScript);
            }
            this.mRS = renderScript;
            this.mCount = 0;
            this.mElements = new Element[8];
            this.mElementNames = new String[8];
            this.mArraySizes = new int[8];
        }

        public Builder add(Element element, String str) {
            return add(element, str, 1);
        }

        public Builder add(Element element, String str, int i) {
            ElementThunker.BuilderThunker builderThunker = this.f93mT;
            if (builderThunker != null) {
                builderThunker.add(element, str, i);
                return this;
            } else if (i < 1) {
                throw new RSIllegalArgumentException("Array size cannot be less than 1.");
            } else {
                if (this.mSkipPadding != 0 && str.startsWith("#padding_")) {
                    this.mSkipPadding = 0;
                    return this;
                }
                if (element.mVectorSize == 3) {
                    this.mSkipPadding = 1;
                } else {
                    this.mSkipPadding = 0;
                }
                int i2 = this.mCount;
                Element[] elementArr = this.mElements;
                if (i2 == elementArr.length) {
                    Element[] elementArr2 = new Element[i2 + 8];
                    String[] strArr = new String[i2 + 8];
                    int[] iArr = new int[i2 + 8];
                    System.arraycopy(elementArr, 0, elementArr2, 0, i2);
                    System.arraycopy(this.mElementNames, 0, strArr, 0, this.mCount);
                    System.arraycopy(this.mArraySizes, 0, iArr, 0, this.mCount);
                    this.mElements = elementArr2;
                    this.mElementNames = strArr;
                    this.mArraySizes = iArr;
                }
                Element[] elementArr3 = this.mElements;
                int i3 = this.mCount;
                elementArr3[i3] = element;
                this.mElementNames[i3] = str;
                this.mArraySizes[i3] = i;
                this.mCount = i3 + 1;
                return this;
            }
        }

        public Element create() {
            ElementThunker.BuilderThunker builderThunker = this.f93mT;
            if (builderThunker != null) {
                return builderThunker.create(this.mRS);
            }
            this.mRS.validate();
            int i = this.mCount;
            Element[] elementArr = new Element[i];
            String[] strArr = new String[i];
            int[] iArr = new int[i];
            System.arraycopy(this.mElements, 0, elementArr, 0, i);
            System.arraycopy(this.mElementNames, 0, strArr, 0, this.mCount);
            System.arraycopy(this.mArraySizes, 0, iArr, 0, this.mCount);
            int[] iArr2 = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr2[i2] = elementArr[i2].getID(this.mRS);
            }
            return new Element(this.mRS.nElementCreate2(iArr2, strArr, iArr), this.mRS, elementArr, strArr, iArr);
        }
    }

    /* loaded from: classes3.dex */
    public enum DataKind {
        USER(0),
        PIXEL_L(7),
        PIXEL_A(8),
        PIXEL_LA(9),
        PIXEL_RGB(10),
        PIXEL_RGBA(11),
        PIXEL_DEPTH(12),
        PIXEL_YUV(13);
        
        public int mID;

        DataKind(int i) {
            this.mID = i;
        }
    }

    /* loaded from: classes3.dex */
    public enum DataType {
        NONE(0, 0),
        FLOAT_32(2, 4),
        FLOAT_64(3, 8),
        SIGNED_8(4, 1),
        SIGNED_16(5, 2),
        SIGNED_32(6, 4),
        SIGNED_64(7, 8),
        UNSIGNED_8(8, 1),
        UNSIGNED_16(9, 2),
        UNSIGNED_32(10, 4),
        UNSIGNED_64(11, 8),
        BOOLEAN(12, 1),
        UNSIGNED_5_6_5(13, 2),
        UNSIGNED_5_5_5_1(14, 2),
        UNSIGNED_4_4_4_4(15, 2),
        MATRIX_4X4(16, 64),
        MATRIX_3X3(17, 36),
        MATRIX_2X2(18, 16),
        RS_ELEMENT(1000, 4),
        RS_TYPE(1001, 4),
        RS_ALLOCATION(1002, 4),
        RS_SAMPLER(1003, 4),
        RS_SCRIPT(1004, 4);
        
        public int mID;
        public int mSize;

        DataType(int i, int i2) {
            this.mID = i;
            this.mSize = i2;
        }
    }

    public Element(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public Element(int i, RenderScript renderScript, DataType dataType, DataKind dataKind, boolean z, int i2) {
        super(i, renderScript);
        this.mSize = (dataType == DataType.UNSIGNED_5_6_5 || dataType == DataType.UNSIGNED_4_4_4_4 || dataType == DataType.UNSIGNED_5_5_5_1) ? dataType.mSize : i2 == 3 ? dataType.mSize * 4 : dataType.mSize * i2;
        this.mType = dataType;
        this.mKind = dataKind;
        this.mNormalized = z;
        this.mVectorSize = i2;
    }

    public Element(int i, RenderScript renderScript, Element[] elementArr, String[] strArr, int[] iArr) {
        super(i, renderScript);
        int i2 = 0;
        this.mSize = 0;
        this.mVectorSize = 1;
        this.mElements = elementArr;
        this.mElementNames = strArr;
        this.mArraySizes = iArr;
        this.mType = DataType.NONE;
        this.mKind = DataKind.USER;
        this.mOffsetInBytes = new int[elementArr.length];
        while (true) {
            Element[] elementArr2 = this.mElements;
            if (i2 >= elementArr2.length) {
                updateVisibleSubElements();
                return;
            }
            int[] iArr2 = this.mOffsetInBytes;
            int i3 = this.mSize;
            iArr2[i2] = i3;
            this.mSize = (elementArr2[i2].mSize * this.mArraySizes[i2]) + i3;
            i2++;
        }
    }

    public static Element ALLOCATION(RenderScript renderScript) {
        if (renderScript.mElement_ALLOCATION == null) {
            renderScript.mElement_ALLOCATION = createUser(renderScript, DataType.RS_ALLOCATION);
        }
        return renderScript.mElement_ALLOCATION;
    }

    public static Element A_8(RenderScript renderScript) {
        if (renderScript.mElement_A_8 == null) {
            renderScript.mElement_A_8 = createPixel(renderScript, DataType.UNSIGNED_8, DataKind.PIXEL_A);
        }
        return renderScript.mElement_A_8;
    }

    public static Element BOOLEAN(RenderScript renderScript) {
        if (renderScript.mElement_BOOLEAN == null) {
            renderScript.mElement_BOOLEAN = createUser(renderScript, DataType.BOOLEAN);
        }
        return renderScript.mElement_BOOLEAN;
    }

    public static Element ELEMENT(RenderScript renderScript) {
        if (renderScript.mElement_ELEMENT == null) {
            renderScript.mElement_ELEMENT = createUser(renderScript, DataType.RS_ELEMENT);
        }
        return renderScript.mElement_ELEMENT;
    }

    public static Element F32(RenderScript renderScript) {
        if (renderScript.mElement_F32 == null) {
            renderScript.mElement_F32 = createUser(renderScript, DataType.FLOAT_32);
        }
        return renderScript.mElement_F32;
    }

    public static Element F32_2(RenderScript renderScript) {
        if (renderScript.mElement_FLOAT_2 == null) {
            renderScript.mElement_FLOAT_2 = createVector(renderScript, DataType.FLOAT_32, 2);
        }
        return renderScript.mElement_FLOAT_2;
    }

    public static Element F32_3(RenderScript renderScript) {
        if (renderScript.mElement_FLOAT_3 == null) {
            renderScript.mElement_FLOAT_3 = createVector(renderScript, DataType.FLOAT_32, 3);
        }
        return renderScript.mElement_FLOAT_3;
    }

    public static Element F32_4(RenderScript renderScript) {
        if (renderScript.mElement_FLOAT_4 == null) {
            renderScript.mElement_FLOAT_4 = createVector(renderScript, DataType.FLOAT_32, 4);
        }
        return renderScript.mElement_FLOAT_4;
    }

    public static Element F64(RenderScript renderScript) {
        if (renderScript.mElement_F64 == null) {
            renderScript.mElement_F64 = createUser(renderScript, DataType.FLOAT_64);
        }
        return renderScript.mElement_F64;
    }

    public static Element F64_2(RenderScript renderScript) {
        if (renderScript.mElement_DOUBLE_2 == null) {
            renderScript.mElement_DOUBLE_2 = createVector(renderScript, DataType.FLOAT_64, 2);
        }
        return renderScript.mElement_DOUBLE_2;
    }

    public static Element F64_3(RenderScript renderScript) {
        if (renderScript.mElement_DOUBLE_3 == null) {
            renderScript.mElement_DOUBLE_3 = createVector(renderScript, DataType.FLOAT_64, 3);
        }
        return renderScript.mElement_DOUBLE_3;
    }

    public static Element F64_4(RenderScript renderScript) {
        if (renderScript.mElement_DOUBLE_4 == null) {
            renderScript.mElement_DOUBLE_4 = createVector(renderScript, DataType.FLOAT_64, 4);
        }
        return renderScript.mElement_DOUBLE_4;
    }

    public static Element I16(RenderScript renderScript) {
        if (renderScript.mElement_I16 == null) {
            renderScript.mElement_I16 = createUser(renderScript, DataType.SIGNED_16);
        }
        return renderScript.mElement_I16;
    }

    public static Element I16_2(RenderScript renderScript) {
        if (renderScript.mElement_SHORT_2 == null) {
            renderScript.mElement_SHORT_2 = createVector(renderScript, DataType.SIGNED_16, 2);
        }
        return renderScript.mElement_SHORT_2;
    }

    public static Element I16_3(RenderScript renderScript) {
        if (renderScript.mElement_SHORT_3 == null) {
            renderScript.mElement_SHORT_3 = createVector(renderScript, DataType.SIGNED_16, 3);
        }
        return renderScript.mElement_SHORT_3;
    }

    public static Element I16_4(RenderScript renderScript) {
        if (renderScript.mElement_SHORT_4 == null) {
            renderScript.mElement_SHORT_4 = createVector(renderScript, DataType.SIGNED_16, 4);
        }
        return renderScript.mElement_SHORT_4;
    }

    public static Element I32(RenderScript renderScript) {
        if (renderScript.mElement_I32 == null) {
            renderScript.mElement_I32 = createUser(renderScript, DataType.SIGNED_32);
        }
        return renderScript.mElement_I32;
    }

    public static Element I32_2(RenderScript renderScript) {
        if (renderScript.mElement_INT_2 == null) {
            renderScript.mElement_INT_2 = createVector(renderScript, DataType.SIGNED_32, 2);
        }
        return renderScript.mElement_INT_2;
    }

    public static Element I32_3(RenderScript renderScript) {
        if (renderScript.mElement_INT_3 == null) {
            renderScript.mElement_INT_3 = createVector(renderScript, DataType.SIGNED_32, 3);
        }
        return renderScript.mElement_INT_3;
    }

    public static Element I32_4(RenderScript renderScript) {
        if (renderScript.mElement_INT_4 == null) {
            renderScript.mElement_INT_4 = createVector(renderScript, DataType.SIGNED_32, 4);
        }
        return renderScript.mElement_INT_4;
    }

    public static Element I64(RenderScript renderScript) {
        if (renderScript.mElement_I64 == null) {
            renderScript.mElement_I64 = createUser(renderScript, DataType.SIGNED_64);
        }
        return renderScript.mElement_I64;
    }

    public static Element I64_2(RenderScript renderScript) {
        if (renderScript.mElement_LONG_2 == null) {
            renderScript.mElement_LONG_2 = createVector(renderScript, DataType.SIGNED_64, 2);
        }
        return renderScript.mElement_LONG_2;
    }

    public static Element I64_3(RenderScript renderScript) {
        if (renderScript.mElement_LONG_3 == null) {
            renderScript.mElement_LONG_3 = createVector(renderScript, DataType.SIGNED_64, 3);
        }
        return renderScript.mElement_LONG_3;
    }

    public static Element I64_4(RenderScript renderScript) {
        if (renderScript.mElement_LONG_4 == null) {
            renderScript.mElement_LONG_4 = createVector(renderScript, DataType.SIGNED_64, 4);
        }
        return renderScript.mElement_LONG_4;
    }

    /* renamed from: I8 */
    public static Element m4197I8(RenderScript renderScript) {
        if (renderScript.mElement_I8 == null) {
            renderScript.mElement_I8 = createUser(renderScript, DataType.SIGNED_8);
        }
        return renderScript.mElement_I8;
    }

    public static Element I8_2(RenderScript renderScript) {
        if (renderScript.mElement_CHAR_2 == null) {
            renderScript.mElement_CHAR_2 = createVector(renderScript, DataType.SIGNED_8, 2);
        }
        return renderScript.mElement_CHAR_2;
    }

    public static Element I8_3(RenderScript renderScript) {
        if (renderScript.mElement_CHAR_3 == null) {
            renderScript.mElement_CHAR_3 = createVector(renderScript, DataType.SIGNED_8, 3);
        }
        return renderScript.mElement_CHAR_3;
    }

    public static Element I8_4(RenderScript renderScript) {
        if (renderScript.mElement_CHAR_4 == null) {
            renderScript.mElement_CHAR_4 = createVector(renderScript, DataType.SIGNED_8, 4);
        }
        return renderScript.mElement_CHAR_4;
    }

    public static Element MATRIX_2X2(RenderScript renderScript) {
        if (renderScript.mElement_MATRIX_2X2 == null) {
            renderScript.mElement_MATRIX_2X2 = createUser(renderScript, DataType.MATRIX_2X2);
        }
        return renderScript.mElement_MATRIX_2X2;
    }

    public static Element MATRIX_3X3(RenderScript renderScript) {
        if (renderScript.mElement_MATRIX_3X3 == null) {
            renderScript.mElement_MATRIX_3X3 = createUser(renderScript, DataType.MATRIX_3X3);
        }
        return renderScript.mElement_MATRIX_3X3;
    }

    public static Element MATRIX_4X4(RenderScript renderScript) {
        if (renderScript.mElement_MATRIX_4X4 == null) {
            renderScript.mElement_MATRIX_4X4 = createUser(renderScript, DataType.MATRIX_4X4);
        }
        return renderScript.mElement_MATRIX_4X4;
    }

    public static Element RGBA_4444(RenderScript renderScript) {
        if (renderScript.mElement_RGBA_4444 == null) {
            renderScript.mElement_RGBA_4444 = createPixel(renderScript, DataType.UNSIGNED_4_4_4_4, DataKind.PIXEL_RGBA);
        }
        return renderScript.mElement_RGBA_4444;
    }

    public static Element RGBA_5551(RenderScript renderScript) {
        if (renderScript.mElement_RGBA_5551 == null) {
            renderScript.mElement_RGBA_5551 = createPixel(renderScript, DataType.UNSIGNED_5_5_5_1, DataKind.PIXEL_RGBA);
        }
        return renderScript.mElement_RGBA_5551;
    }

    public static Element RGBA_8888(RenderScript renderScript) {
        if (renderScript.mElement_RGBA_8888 == null) {
            renderScript.mElement_RGBA_8888 = createPixel(renderScript, DataType.UNSIGNED_8, DataKind.PIXEL_RGBA);
        }
        return renderScript.mElement_RGBA_8888;
    }

    public static Element RGB_565(RenderScript renderScript) {
        if (renderScript.mElement_RGB_565 == null) {
            renderScript.mElement_RGB_565 = createPixel(renderScript, DataType.UNSIGNED_5_6_5, DataKind.PIXEL_RGB);
        }
        return renderScript.mElement_RGB_565;
    }

    public static Element RGB_888(RenderScript renderScript) {
        if (renderScript.mElement_RGB_888 == null) {
            renderScript.mElement_RGB_888 = createPixel(renderScript, DataType.UNSIGNED_8, DataKind.PIXEL_RGB);
        }
        return renderScript.mElement_RGB_888;
    }

    public static Element SAMPLER(RenderScript renderScript) {
        if (renderScript.mElement_SAMPLER == null) {
            renderScript.mElement_SAMPLER = createUser(renderScript, DataType.RS_SAMPLER);
        }
        return renderScript.mElement_SAMPLER;
    }

    public static Element SCRIPT(RenderScript renderScript) {
        if (renderScript.mElement_SCRIPT == null) {
            renderScript.mElement_SCRIPT = createUser(renderScript, DataType.RS_SCRIPT);
        }
        return renderScript.mElement_SCRIPT;
    }

    public static Element TYPE(RenderScript renderScript) {
        if (renderScript.mElement_TYPE == null) {
            renderScript.mElement_TYPE = createUser(renderScript, DataType.RS_TYPE);
        }
        return renderScript.mElement_TYPE;
    }

    public static Element U16(RenderScript renderScript) {
        if (renderScript.mElement_U16 == null) {
            renderScript.mElement_U16 = createUser(renderScript, DataType.UNSIGNED_16);
        }
        return renderScript.mElement_U16;
    }

    public static Element U16_2(RenderScript renderScript) {
        if (renderScript.mElement_USHORT_2 == null) {
            renderScript.mElement_USHORT_2 = createVector(renderScript, DataType.UNSIGNED_16, 2);
        }
        return renderScript.mElement_USHORT_2;
    }

    public static Element U16_3(RenderScript renderScript) {
        if (renderScript.mElement_USHORT_3 == null) {
            renderScript.mElement_USHORT_3 = createVector(renderScript, DataType.UNSIGNED_16, 3);
        }
        return renderScript.mElement_USHORT_3;
    }

    public static Element U16_4(RenderScript renderScript) {
        if (renderScript.mElement_USHORT_4 == null) {
            renderScript.mElement_USHORT_4 = createVector(renderScript, DataType.UNSIGNED_16, 4);
        }
        return renderScript.mElement_USHORT_4;
    }

    public static Element U32(RenderScript renderScript) {
        if (renderScript.mElement_U32 == null) {
            renderScript.mElement_U32 = createUser(renderScript, DataType.UNSIGNED_32);
        }
        return renderScript.mElement_U32;
    }

    public static Element U32_2(RenderScript renderScript) {
        if (renderScript.mElement_UINT_2 == null) {
            renderScript.mElement_UINT_2 = createVector(renderScript, DataType.UNSIGNED_32, 2);
        }
        return renderScript.mElement_UINT_2;
    }

    public static Element U32_3(RenderScript renderScript) {
        if (renderScript.mElement_UINT_3 == null) {
            renderScript.mElement_UINT_3 = createVector(renderScript, DataType.UNSIGNED_32, 3);
        }
        return renderScript.mElement_UINT_3;
    }

    public static Element U32_4(RenderScript renderScript) {
        if (renderScript.mElement_UINT_4 == null) {
            renderScript.mElement_UINT_4 = createVector(renderScript, DataType.UNSIGNED_32, 4);
        }
        return renderScript.mElement_UINT_4;
    }

    public static Element U64(RenderScript renderScript) {
        if (renderScript.mElement_U64 == null) {
            renderScript.mElement_U64 = createUser(renderScript, DataType.UNSIGNED_64);
        }
        return renderScript.mElement_U64;
    }

    public static Element U64_2(RenderScript renderScript) {
        if (renderScript.mElement_ULONG_2 == null) {
            renderScript.mElement_ULONG_2 = createVector(renderScript, DataType.UNSIGNED_64, 2);
        }
        return renderScript.mElement_ULONG_2;
    }

    public static Element U64_3(RenderScript renderScript) {
        if (renderScript.mElement_ULONG_3 == null) {
            renderScript.mElement_ULONG_3 = createVector(renderScript, DataType.UNSIGNED_64, 3);
        }
        return renderScript.mElement_ULONG_3;
    }

    public static Element U64_4(RenderScript renderScript) {
        if (renderScript.mElement_ULONG_4 == null) {
            renderScript.mElement_ULONG_4 = createVector(renderScript, DataType.UNSIGNED_64, 4);
        }
        return renderScript.mElement_ULONG_4;
    }

    /* renamed from: U8 */
    public static Element m4196U8(RenderScript renderScript) {
        if (renderScript.mElement_U8 == null) {
            renderScript.mElement_U8 = createUser(renderScript, DataType.UNSIGNED_8);
        }
        return renderScript.mElement_U8;
    }

    public static Element U8_2(RenderScript renderScript) {
        if (renderScript.mElement_UCHAR_2 == null) {
            renderScript.mElement_UCHAR_2 = createVector(renderScript, DataType.UNSIGNED_8, 2);
        }
        return renderScript.mElement_UCHAR_2;
    }

    public static Element U8_3(RenderScript renderScript) {
        if (renderScript.mElement_UCHAR_3 == null) {
            renderScript.mElement_UCHAR_3 = createVector(renderScript, DataType.UNSIGNED_8, 3);
        }
        return renderScript.mElement_UCHAR_3;
    }

    public static Element U8_4(RenderScript renderScript) {
        if (renderScript.mElement_UCHAR_4 == null) {
            renderScript.mElement_UCHAR_4 = createVector(renderScript, DataType.UNSIGNED_8, 4);
        }
        return renderScript.mElement_UCHAR_4;
    }

    public static Element createPixel(RenderScript renderScript, DataType dataType, DataKind dataKind) {
        if (RenderScript.isNative) {
            return ElementThunker.createPixel((RenderScriptThunker) renderScript, dataType, dataKind);
        }
        if (dataKind != DataKind.PIXEL_L && dataKind != DataKind.PIXEL_A && dataKind != DataKind.PIXEL_LA && dataKind != DataKind.PIXEL_RGB && dataKind != DataKind.PIXEL_RGBA && dataKind != DataKind.PIXEL_DEPTH && dataKind != DataKind.PIXEL_YUV) {
            throw new RSIllegalArgumentException("Unsupported DataKind");
        }
        if (dataType != DataType.UNSIGNED_8 && dataType != DataType.UNSIGNED_16 && dataType != DataType.UNSIGNED_5_6_5 && dataType != DataType.UNSIGNED_4_4_4_4 && dataType != DataType.UNSIGNED_5_5_5_1) {
            throw new RSIllegalArgumentException("Unsupported DataType");
        }
        if (dataType == DataType.UNSIGNED_5_6_5 && dataKind != DataKind.PIXEL_RGB) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dataType == DataType.UNSIGNED_5_5_5_1 && dataKind != DataKind.PIXEL_RGBA) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dataType == DataType.UNSIGNED_4_4_4_4 && dataKind != DataKind.PIXEL_RGBA) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dataType == DataType.UNSIGNED_16 && dataKind != DataKind.PIXEL_DEPTH) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        int ordinal = dataKind.ordinal();
        int i = ordinal != 3 ? ordinal != 4 ? ordinal != 5 ? 1 : 4 : 3 : 2;
        return new Element(renderScript.nElementCreate(dataType.mID, dataKind.mID, true, i), renderScript, dataType, dataKind, true, i);
    }

    public static Element createUser(RenderScript renderScript, DataType dataType) {
        if (RenderScript.isNative) {
            return ElementThunker.create((RenderScriptThunker) renderScript, dataType);
        }
        DataKind dataKind = DataKind.USER;
        return new Element(renderScript.nElementCreate(dataType.mID, dataKind.mID, false, 1), renderScript, dataType, dataKind, false, 1);
    }

    public static Element createVector(RenderScript renderScript, DataType dataType, int i) {
        if (RenderScript.isNative) {
            return ElementThunker.createVector((RenderScriptThunker) renderScript, dataType, i);
        }
        if (i < 2 || i > 4) {
            throw new RSIllegalArgumentException("Vector size out of range 2-4.");
        }
        switch (dataType.ordinal()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                DataKind dataKind = DataKind.USER;
                return new Element(renderScript.nElementCreate(dataType.mID, dataKind.mID, false, i), renderScript, dataType, dataKind, false, i);
            default:
                throw new RSIllegalArgumentException("Cannot create vector of non-primitive type.");
        }
    }

    private void updateVisibleSubElements() {
        if (this.mElements == null) {
            return;
        }
        int length = this.mElementNames.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mElementNames[i2].charAt(0) != '#') {
                i++;
            }
        }
        this.mVisibleElementMap = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.mElementNames[i4].charAt(0) != '#') {
                this.mVisibleElementMap[i3] = i4;
                i3++;
            }
        }
    }

    public int getBytesSize() {
        return this.mSize;
    }

    public DataKind getDataKind() {
        return this.mKind;
    }

    public DataType getDataType() {
        return this.mType;
    }

    public Element getSubElement(int i) {
        int[] iArr = this.mVisibleElementMap;
        if (iArr != null) {
            if (i >= 0 && i < iArr.length) {
                return this.mElements[iArr[i]];
            }
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        throw new RSIllegalArgumentException("Element contains no sub-elements");
    }

    public int getSubElementArraySize(int i) {
        int[] iArr = this.mVisibleElementMap;
        if (iArr != null) {
            if (i >= 0 && i < iArr.length) {
                return this.mArraySizes[iArr[i]];
            }
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        throw new RSIllegalArgumentException("Element contains no sub-elements");
    }

    public int getSubElementCount() {
        int[] iArr = this.mVisibleElementMap;
        if (iArr == null) {
            return 0;
        }
        return iArr.length;
    }

    public String getSubElementName(int i) {
        int[] iArr = this.mVisibleElementMap;
        if (iArr != null) {
            if (i >= 0 && i < iArr.length) {
                return this.mElementNames[iArr[i]];
            }
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        throw new RSIllegalArgumentException("Element contains no sub-elements");
    }

    public int getSubElementOffsetBytes(int i) {
        int[] iArr = this.mVisibleElementMap;
        if (iArr != null) {
            if (i >= 0 && i < iArr.length) {
                return this.mOffsetInBytes[iArr[i]];
            }
            throw new RSIllegalArgumentException("Illegal sub-element index");
        }
        throw new RSIllegalArgumentException("Element contains no sub-elements");
    }

    public int getVectorSize() {
        return this.mVectorSize;
    }

    public boolean isCompatible(Element element) {
        DataType dataType;
        if (equals(element)) {
            return true;
        }
        return this.mSize == element.mSize && (dataType = this.mType) != DataType.NONE && dataType == element.mType && this.mVectorSize == element.mVectorSize;
    }

    public boolean isComplex() {
        if (this.mElements == null) {
            return false;
        }
        int i = 0;
        while (true) {
            Element[] elementArr = this.mElements;
            if (i >= elementArr.length) {
                return false;
            }
            if (elementArr[i].mElements != null) {
                return true;
            }
            i++;
        }
    }
}
