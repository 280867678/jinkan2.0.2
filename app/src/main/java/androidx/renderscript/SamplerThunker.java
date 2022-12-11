package androidx.renderscript;

import android.renderscript.Sampler;
import androidx.renderscript.Sampler;

/* loaded from: classes3.dex */
public class SamplerThunker extends Sampler {

    /* renamed from: mN */
    public android.renderscript.Sampler f126mN;

    /* renamed from: androidx.renderscript.SamplerThunker$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C05271 {
        public static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Sampler$Value;

        static {
            int[] iArr = new int[Sampler.Value.values().length];
            $SwitchMap$android$support$v8$renderscript$Sampler$Value = iArr;
            try {
                Sampler.Value value = Sampler.Value.NEAREST;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$android$support$v8$renderscript$Sampler$Value;
                Sampler.Value value2 = Sampler.Value.LINEAR;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$android$support$v8$renderscript$Sampler$Value;
                Sampler.Value value3 = Sampler.Value.LINEAR_MIP_LINEAR;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$android$support$v8$renderscript$Sampler$Value;
                Sampler.Value value4 = Sampler.Value.LINEAR_MIP_NEAREST;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$android$support$v8$renderscript$Sampler$Value;
                Sampler.Value value5 = Sampler.Value.WRAP;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$android$support$v8$renderscript$Sampler$Value;
                Sampler.Value value6 = Sampler.Value.CLAMP;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$android$support$v8$renderscript$Sampler$Value;
                Sampler.Value value7 = Sampler.Value.MIRRORED_REPEAT;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public float mAniso;
        public Sampler.Value mMag;
        public Sampler.Value mMin;
        public RenderScriptThunker mRS;
        public Sampler.Value mWrapR;
        public Sampler.Value mWrapS;
        public Sampler.Value mWrapT;

        public Builder(RenderScriptThunker renderScriptThunker) {
            this.mRS = renderScriptThunker;
            Sampler.Value value = Sampler.Value.NEAREST;
            this.mMin = value;
            this.mMag = value;
            Sampler.Value value2 = Sampler.Value.WRAP;
            this.mWrapS = value2;
            this.mWrapT = value2;
            this.mWrapR = value2;
        }

        public Sampler create() {
            this.mRS.validate();
            try {
                Sampler.Builder builder = new Sampler.Builder(this.mRS.f125mN);
                builder.setMinification(SamplerThunker.convertValue(this.mMin));
                builder.setMagnification(SamplerThunker.convertValue(this.mMag));
                builder.setWrapS(SamplerThunker.convertValue(this.mWrapS));
                builder.setWrapT(SamplerThunker.convertValue(this.mWrapT));
                builder.setAnisotropy(this.mAniso);
                android.renderscript.Sampler create = builder.create();
                SamplerThunker samplerThunker = new SamplerThunker(0, this.mRS);
                samplerThunker.mMin = this.mMin;
                samplerThunker.mMag = this.mMag;
                samplerThunker.mWrapS = this.mWrapS;
                samplerThunker.mWrapT = this.mWrapT;
                samplerThunker.mWrapR = this.mWrapR;
                samplerThunker.mAniso = this.mAniso;
                samplerThunker.f126mN = create;
                return samplerThunker;
            } catch (android.renderscript.RSRuntimeException e) {
                throw ExceptionThunker.convertException(e);
            }
        }

        public void setAnisotropy(float f) {
            if (f >= 0.0f) {
                this.mAniso = f;
                return;
            }
            throw new IllegalArgumentException("Invalid value");
        }

        public void setMagnification(Sampler.Value value) {
            if (value == Sampler.Value.NEAREST || value == Sampler.Value.LINEAR) {
                this.mMag = value;
                return;
            }
            throw new IllegalArgumentException("Invalid value");
        }

        public void setMinification(Sampler.Value value) {
            if (value == Sampler.Value.NEAREST || value == Sampler.Value.LINEAR || value == Sampler.Value.LINEAR_MIP_LINEAR || value == Sampler.Value.LINEAR_MIP_NEAREST) {
                this.mMin = value;
                return;
            }
            throw new IllegalArgumentException("Invalid value");
        }

        public void setWrapS(Sampler.Value value) {
            if (value == Sampler.Value.WRAP || value == Sampler.Value.CLAMP || value == Sampler.Value.MIRRORED_REPEAT) {
                this.mWrapS = value;
                return;
            }
            throw new IllegalArgumentException("Invalid value");
        }

        public void setWrapT(Sampler.Value value) {
            if (value == Sampler.Value.WRAP || value == Sampler.Value.CLAMP || value == Sampler.Value.MIRRORED_REPEAT) {
                this.mWrapT = value;
                return;
            }
            throw new IllegalArgumentException("Invalid value");
        }
    }

    public SamplerThunker(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static Sampler.Value convertValue(Sampler.Value value) {
        switch (value.ordinal()) {
            case 0:
                return Sampler.Value.NEAREST;
            case 1:
                return Sampler.Value.LINEAR;
            case 2:
                return Sampler.Value.LINEAR_MIP_LINEAR;
            case 3:
                return Sampler.Value.LINEAR_MIP_NEAREST;
            case 4:
                return Sampler.Value.WRAP;
            case 5:
                return Sampler.Value.CLAMP;
            case 6:
                return Sampler.Value.MIRRORED_REPEAT;
            default:
                return null;
        }
    }

    @Override // androidx.renderscript.BaseObj
    /* renamed from: getNObj */
    public android.renderscript.BaseObj mo4369getNObj() {
        return this.f126mN;
    }
}
