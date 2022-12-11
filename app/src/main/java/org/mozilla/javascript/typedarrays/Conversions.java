package org.mozilla.javascript.typedarrays;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import org.mozilla.javascript.ScriptRuntime;

/* loaded from: classes5.dex */
public class Conversions {
    public static int toInt16(Object obj) {
        return (short) ScriptRuntime.toInt32(obj);
    }

    public static int toInt32(Object obj) {
        return ScriptRuntime.toInt32(obj);
    }

    public static int toInt8(Object obj) {
        return (byte) ScriptRuntime.toInt32(obj);
    }

    public static int toUint16(Object obj) {
        return ScriptRuntime.toInt32(obj) & 65535;
    }

    public static long toUint32(Object obj) {
        return ScriptRuntime.toUint32(obj);
    }

    public static int toUint8(Object obj) {
        return ScriptRuntime.toInt32(obj) & 255;
    }

    public static int toUint8Clamp(Object obj) {
        double number = ScriptRuntime.toNumber(obj);
        if (number <= RoundRectDrawableWithShadow.COS_45) {
            return 0;
        }
        if (number >= 255.0d) {
            return 255;
        }
        double floor = Math.floor(number);
        double d = 0.5d + floor;
        if (d < number) {
            return (int) (floor + 1.0d);
        }
        if (number < d) {
            return (int) floor;
        }
        int i = (int) floor;
        return i % 2 != 0 ? i + 1 : i;
    }
}
