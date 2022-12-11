package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class KeyCache {
    public HashMap<Object, HashMap<String, float[]>> map = new HashMap<>();

    public float getFloatValue(Object obj, String str, int i) {
        if (!this.map.containsKey(obj)) {
            return Float.NaN;
        }
        HashMap<String, float[]> hashMap = this.map.get(obj);
        if (!hashMap.containsKey(str)) {
            return Float.NaN;
        }
        float[] fArr = hashMap.get(str);
        if (fArr.length <= i) {
            return Float.NaN;
        }
        return fArr[i];
    }

    public void setFloatValue(Object obj, String str, int i, float f) {
        HashMap<String, float[]> hashMap;
        if (!this.map.containsKey(obj)) {
            hashMap = new HashMap<>();
            float[] fArr = new float[i + 1];
            fArr[i] = f;
            hashMap.put(str, fArr);
        } else {
            hashMap = this.map.get(obj);
            if (hashMap.containsKey(str)) {
                float[] fArr2 = hashMap.get(str);
                if (fArr2.length <= i) {
                    fArr2 = Arrays.copyOf(fArr2, i + 1);
                }
                fArr2[i] = f;
                hashMap.put(str, fArr2);
                return;
            }
            float[] fArr3 = new float[i + 1];
            fArr3[i] = f;
            hashMap.put(str, fArr3);
        }
        this.map.put(obj, hashMap);
    }
}
