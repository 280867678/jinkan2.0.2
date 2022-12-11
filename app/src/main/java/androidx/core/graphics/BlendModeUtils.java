package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
public class BlendModeUtils {

    /* renamed from: androidx.core.graphics.BlendModeUtils$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C02101 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$core$graphics$BlendModeCompat;

        static {
            int[] iArr = new int[BlendModeCompat.values().length];
            $SwitchMap$androidx$core$graphics$BlendModeCompat = iArr;
            try {
                BlendModeCompat blendModeCompat = BlendModeCompat.CLEAR;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat2 = BlendModeCompat.SRC;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat3 = BlendModeCompat.DST;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat4 = BlendModeCompat.SRC_OVER;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat5 = BlendModeCompat.DST_OVER;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat6 = BlendModeCompat.SRC_IN;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat7 = BlendModeCompat.DST_IN;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat8 = BlendModeCompat.SRC_OUT;
                iArr8[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat9 = BlendModeCompat.DST_OUT;
                iArr9[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat10 = BlendModeCompat.SRC_ATOP;
                iArr10[9] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat11 = BlendModeCompat.DST_ATOP;
                iArr11[10] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat12 = BlendModeCompat.XOR;
                iArr12[11] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat13 = BlendModeCompat.PLUS;
                iArr13[12] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat14 = BlendModeCompat.MODULATE;
                iArr14[13] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                int[] iArr15 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat15 = BlendModeCompat.SCREEN;
                iArr15[14] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                int[] iArr16 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat16 = BlendModeCompat.OVERLAY;
                iArr16[15] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                int[] iArr17 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat17 = BlendModeCompat.DARKEN;
                iArr17[16] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                int[] iArr18 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat18 = BlendModeCompat.LIGHTEN;
                iArr18[17] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                int[] iArr19 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat19 = BlendModeCompat.COLOR_DODGE;
                iArr19[18] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                int[] iArr20 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat20 = BlendModeCompat.COLOR_BURN;
                iArr20[19] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                int[] iArr21 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat21 = BlendModeCompat.HARD_LIGHT;
                iArr21[20] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                int[] iArr22 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat22 = BlendModeCompat.SOFT_LIGHT;
                iArr22[21] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                int[] iArr23 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat23 = BlendModeCompat.DIFFERENCE;
                iArr23[22] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                int[] iArr24 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat24 = BlendModeCompat.EXCLUSION;
                iArr24[23] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                int[] iArr25 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat25 = BlendModeCompat.MULTIPLY;
                iArr25[24] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                int[] iArr26 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat26 = BlendModeCompat.HUE;
                iArr26[25] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                int[] iArr27 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat27 = BlendModeCompat.SATURATION;
                iArr27[26] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                int[] iArr28 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat28 = BlendModeCompat.COLOR;
                iArr28[27] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                int[] iArr29 = $SwitchMap$androidx$core$graphics$BlendModeCompat;
                BlendModeCompat blendModeCompat29 = BlendModeCompat.LUMINOSITY;
                iArr29[28] = 29;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    @Nullable
    @RequiresApi(29)
    public static BlendMode obtainBlendModeFromCompat(@NonNull BlendModeCompat blendModeCompat) {
        switch (blendModeCompat.ordinal()) {
            case 0:
                return BlendMode.CLEAR;
            case 1:
                return BlendMode.SRC;
            case 2:
                return BlendMode.DST;
            case 3:
                return BlendMode.SRC_OVER;
            case 4:
                return BlendMode.DST_OVER;
            case 5:
                return BlendMode.SRC_IN;
            case 6:
                return BlendMode.DST_IN;
            case 7:
                return BlendMode.SRC_OUT;
            case 8:
                return BlendMode.DST_OUT;
            case 9:
                return BlendMode.SRC_ATOP;
            case 10:
                return BlendMode.DST_ATOP;
            case 11:
                return BlendMode.XOR;
            case 12:
                return BlendMode.PLUS;
            case 13:
                return BlendMode.MODULATE;
            case 14:
                return BlendMode.SCREEN;
            case 15:
                return BlendMode.OVERLAY;
            case 16:
                return BlendMode.DARKEN;
            case 17:
                return BlendMode.LIGHTEN;
            case 18:
                return BlendMode.COLOR_DODGE;
            case 19:
                return BlendMode.COLOR_BURN;
            case 20:
                return BlendMode.HARD_LIGHT;
            case 21:
                return BlendMode.SOFT_LIGHT;
            case 22:
                return BlendMode.DIFFERENCE;
            case 23:
                return BlendMode.EXCLUSION;
            case 24:
                return BlendMode.MULTIPLY;
            case 25:
                return BlendMode.HUE;
            case 26:
                return BlendMode.SATURATION;
            case 27:
                return BlendMode.COLOR;
            case 28:
                return BlendMode.LUMINOSITY;
            default:
                return null;
        }
    }

    @Nullable
    public static PorterDuff.Mode obtainPorterDuffFromCompat(@Nullable BlendModeCompat blendModeCompat) {
        if (blendModeCompat != null) {
            switch (blendModeCompat.ordinal()) {
                case 0:
                    return PorterDuff.Mode.CLEAR;
                case 1:
                    return PorterDuff.Mode.SRC;
                case 2:
                    return PorterDuff.Mode.DST;
                case 3:
                    return PorterDuff.Mode.SRC_OVER;
                case 4:
                    return PorterDuff.Mode.DST_OVER;
                case 5:
                    return PorterDuff.Mode.SRC_IN;
                case 6:
                    return PorterDuff.Mode.DST_IN;
                case 7:
                    return PorterDuff.Mode.SRC_OUT;
                case 8:
                    return PorterDuff.Mode.DST_OUT;
                case 9:
                    return PorterDuff.Mode.SRC_ATOP;
                case 10:
                    return PorterDuff.Mode.DST_ATOP;
                case 11:
                    return PorterDuff.Mode.XOR;
                case 12:
                    return PorterDuff.Mode.ADD;
                case 13:
                    return PorterDuff.Mode.MULTIPLY;
                case 14:
                    return PorterDuff.Mode.SCREEN;
                case 15:
                    return PorterDuff.Mode.OVERLAY;
                case 16:
                    return PorterDuff.Mode.DARKEN;
                case 17:
                    return PorterDuff.Mode.LIGHTEN;
                default:
                    return null;
            }
        }
        return null;
    }
}
