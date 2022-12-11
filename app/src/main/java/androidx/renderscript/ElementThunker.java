package androidx.renderscript;

import android.renderscript.Element;
import androidx.renderscript.Element;

/* loaded from: classes3.dex */
public class ElementThunker extends Element {

    /* renamed from: mN */
    public android.renderscript.Element f94mN;

    /* renamed from: androidx.renderscript.ElementThunker$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C05241 {
        public static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Element$DataKind;
        public static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Element$DataType;

        static {
            int[] iArr = new int[Element.DataType.values().length];
            $SwitchMap$android$support$v8$renderscript$Element$DataType = iArr;
            try {
                Element.DataType dataType = Element.DataType.NONE;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType2 = Element.DataType.FLOAT_32;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType3 = Element.DataType.FLOAT_64;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType4 = Element.DataType.SIGNED_8;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType5 = Element.DataType.SIGNED_16;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType6 = Element.DataType.SIGNED_32;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType7 = Element.DataType.SIGNED_64;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType8 = Element.DataType.UNSIGNED_8;
                iArr8[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType9 = Element.DataType.UNSIGNED_16;
                iArr9[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType10 = Element.DataType.UNSIGNED_32;
                iArr10[9] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType11 = Element.DataType.UNSIGNED_64;
                iArr11[10] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType12 = Element.DataType.BOOLEAN;
                iArr12[11] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType13 = Element.DataType.MATRIX_4X4;
                iArr13[15] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType14 = Element.DataType.MATRIX_3X3;
                iArr14[16] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                int[] iArr15 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType15 = Element.DataType.MATRIX_2X2;
                iArr15[17] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                int[] iArr16 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType16 = Element.DataType.RS_ELEMENT;
                iArr16[18] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                int[] iArr17 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType17 = Element.DataType.RS_TYPE;
                iArr17[19] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                int[] iArr18 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType18 = Element.DataType.RS_ALLOCATION;
                iArr18[20] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                int[] iArr19 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType19 = Element.DataType.RS_SAMPLER;
                iArr19[21] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                int[] iArr20 = $SwitchMap$android$support$v8$renderscript$Element$DataType;
                Element.DataType dataType20 = Element.DataType.RS_SCRIPT;
                iArr20[22] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr21 = new int[Element.DataKind.values().length];
            $SwitchMap$android$support$v8$renderscript$Element$DataKind = iArr21;
            try {
                Element.DataKind dataKind = Element.DataKind.USER;
                iArr21[0] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                int[] iArr22 = $SwitchMap$android$support$v8$renderscript$Element$DataKind;
                Element.DataKind dataKind2 = Element.DataKind.PIXEL_L;
                iArr22[1] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                int[] iArr23 = $SwitchMap$android$support$v8$renderscript$Element$DataKind;
                Element.DataKind dataKind3 = Element.DataKind.PIXEL_A;
                iArr23[2] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                int[] iArr24 = $SwitchMap$android$support$v8$renderscript$Element$DataKind;
                Element.DataKind dataKind4 = Element.DataKind.PIXEL_LA;
                iArr24[3] = 4;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                int[] iArr25 = $SwitchMap$android$support$v8$renderscript$Element$DataKind;
                Element.DataKind dataKind5 = Element.DataKind.PIXEL_RGB;
                iArr25[4] = 5;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                int[] iArr26 = $SwitchMap$android$support$v8$renderscript$Element$DataKind;
                Element.DataKind dataKind6 = Element.DataKind.PIXEL_RGBA;
                iArr26[5] = 6;
            } catch (NoSuchFieldError unused26) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class BuilderThunker {

        /* renamed from: mN */
        public Element.Builder f95mN;

        public BuilderThunker(RenderScript renderScript) {
            try {
                this.f95mN = new Element.Builder(((RenderScriptThunker) renderScript).f125mN);
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }

        public void add(Element element, String str, int i) {
            try {
                this.f95mN.add(((ElementThunker) element).f94mN, str, i);
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }

        public Element create(RenderScript renderScript) {
            try {
                return new ElementThunker(renderScript, this.f95mN.create());
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }
    }

    public ElementThunker(RenderScript renderScript, android.renderscript.Element element) {
        super(0, renderScript);
        this.f94mN = element;
    }

    public static Element.DataKind convertKind(Element.DataKind dataKind) {
        int ordinal = dataKind.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return Element.DataKind.PIXEL_L;
            }
            if (ordinal == 2) {
                return Element.DataKind.PIXEL_A;
            }
            if (ordinal == 3) {
                return Element.DataKind.PIXEL_LA;
            }
            if (ordinal == 4) {
                return Element.DataKind.PIXEL_RGB;
            }
            if (ordinal == 5) {
                return Element.DataKind.PIXEL_RGBA;
            }
            return null;
        }
        return Element.DataKind.USER;
    }

    public static Element.DataType convertType(Element.DataType dataType) {
        switch (dataType.ordinal()) {
            case 0:
                return Element.DataType.NONE;
            case 1:
                return Element.DataType.FLOAT_32;
            case 2:
                return Element.DataType.FLOAT_64;
            case 3:
                return Element.DataType.SIGNED_8;
            case 4:
                return Element.DataType.SIGNED_16;
            case 5:
                return Element.DataType.SIGNED_32;
            case 6:
                return Element.DataType.SIGNED_64;
            case 7:
                return Element.DataType.UNSIGNED_8;
            case 8:
                return Element.DataType.UNSIGNED_16;
            case 9:
                return Element.DataType.UNSIGNED_32;
            case 10:
                return Element.DataType.UNSIGNED_64;
            case 11:
                return Element.DataType.BOOLEAN;
            case 12:
            case 13:
            case 14:
            default:
                return null;
            case 15:
                return Element.DataType.MATRIX_4X4;
            case 16:
                return Element.DataType.MATRIX_3X3;
            case 17:
                return Element.DataType.MATRIX_2X2;
            case 18:
                return Element.DataType.RS_ELEMENT;
            case 19:
                return Element.DataType.RS_TYPE;
            case 20:
                return Element.DataType.RS_ALLOCATION;
            case 21:
                return Element.DataType.RS_SAMPLER;
            case 22:
                return Element.DataType.RS_SCRIPT;
        }
    }

    public static Element create(RenderScript renderScript, Element.DataType dataType) {
        RenderScriptThunker renderScriptThunker = (RenderScriptThunker) renderScript;
        android.renderscript.Element element = null;
        try {
            switch (dataType.ordinal()) {
                case 1:
                    element = android.renderscript.Element.F32(renderScriptThunker.f125mN);
                    break;
                case 2:
                    element = android.renderscript.Element.F64(renderScriptThunker.f125mN);
                    break;
                case 3:
                    element = android.renderscript.Element.I8(renderScriptThunker.f125mN);
                    break;
                case 4:
                    element = android.renderscript.Element.I16(renderScriptThunker.f125mN);
                    break;
                case 5:
                    element = android.renderscript.Element.I32(renderScriptThunker.f125mN);
                    break;
                case 6:
                    element = android.renderscript.Element.I64(renderScriptThunker.f125mN);
                    break;
                case 7:
                    element = android.renderscript.Element.U8(renderScriptThunker.f125mN);
                    break;
                case 8:
                    element = android.renderscript.Element.U16(renderScriptThunker.f125mN);
                    break;
                case 9:
                    element = android.renderscript.Element.U32(renderScriptThunker.f125mN);
                    break;
                case 10:
                    element = android.renderscript.Element.U64(renderScriptThunker.f125mN);
                    break;
                case 11:
                    element = android.renderscript.Element.BOOLEAN(renderScriptThunker.f125mN);
                    break;
                case 15:
                    element = android.renderscript.Element.MATRIX_4X4(renderScriptThunker.f125mN);
                    break;
                case 16:
                    element = android.renderscript.Element.MATRIX_3X3(renderScriptThunker.f125mN);
                    break;
                case 17:
                    element = android.renderscript.Element.MATRIX_2X2(renderScriptThunker.f125mN);
                    break;
                case 18:
                    element = android.renderscript.Element.ELEMENT(renderScriptThunker.f125mN);
                    break;
                case 19:
                    element = android.renderscript.Element.TYPE(renderScriptThunker.f125mN);
                    break;
                case 20:
                    element = android.renderscript.Element.ALLOCATION(renderScriptThunker.f125mN);
                    break;
                case 21:
                    element = android.renderscript.Element.SAMPLER(renderScriptThunker.f125mN);
                    break;
                case 22:
                    element = android.renderscript.Element.SCRIPT(renderScriptThunker.f125mN);
                    break;
            }
            return new ElementThunker(renderScript, element);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Element createPixel(RenderScript renderScript, Element.DataType dataType, Element.DataKind dataKind) {
        try {
            return new ElementThunker(renderScript, android.renderscript.Element.createPixel(((RenderScriptThunker) renderScript).f125mN, convertType(dataType), convertKind(dataKind)));
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    public static Element createVector(RenderScript renderScript, Element.DataType dataType, int i) {
        try {
            return new ElementThunker(renderScript, android.renderscript.Element.createVector(((RenderScriptThunker) renderScript).f125mN, convertType(dataType), i));
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public int getBytesSize() {
        try {
            return this.f94mN.getBytesSize();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public Element.DataKind getDataKind() {
        return this.mKind;
    }

    @Override // androidx.renderscript.Element
    public Element.DataType getDataType() {
        return this.mType;
    }

    @Override // androidx.renderscript.BaseObj
    /* renamed from: getNObj  reason: collision with other method in class */
    public android.renderscript.Element mo4369getNObj() {
        return this.f94mN;
    }

    @Override // androidx.renderscript.Element
    public Element getSubElement(int i) {
        try {
            return new ElementThunker(this.mRS, this.f94mN.getSubElement(i));
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public int getSubElementArraySize(int i) {
        try {
            return this.f94mN.getSubElementArraySize(i);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public int getSubElementCount() {
        try {
            return this.f94mN.getSubElementCount();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public String getSubElementName(int i) {
        try {
            return this.f94mN.getSubElementName(i);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public int getSubElementOffsetBytes(int i) {
        try {
            return this.f94mN.getSubElementOffsetBytes(i);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public int getVectorSize() {
        try {
            return this.f94mN.getVectorSize();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public boolean isCompatible(Element element) {
        try {
            return ((ElementThunker) element).f94mN.isCompatible(this.f94mN);
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }

    @Override // androidx.renderscript.Element
    public boolean isComplex() {
        try {
            return this.f94mN.isComplex();
        } catch (android.renderscript.RSRuntimeException e) {
            throw ExceptionThunker.convertException(e);
        }
    }
}
