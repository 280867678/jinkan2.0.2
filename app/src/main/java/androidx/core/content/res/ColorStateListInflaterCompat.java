package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.C0196R;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes3.dex */
public final class ColorStateListInflaterCompat {
    @NonNull
    public static ColorStateList createFromXml(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static ColorStateList createFromXmlInner(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources resources, @XmlRes int i, @Nullable Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStateList inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i;
        int attributeCount;
        int i2;
        int i3 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i4 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i3 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, C0196R.styleable.ColorStateListItem);
                int color = obtainAttributes.getColor(C0196R.styleable.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (obtainAttributes.hasValue(C0196R.styleable.ColorStateListItem_android_alpha)) {
                    i = C0196R.styleable.ColorStateListItem_android_alpha;
                } else {
                    if (obtainAttributes.hasValue(C0196R.styleable.ColorStateListItem_alpha)) {
                        i = C0196R.styleable.ColorStateListItem_alpha;
                    }
                    obtainAttributes.recycle();
                    attributeCount = attributeSet.getAttributeCount();
                    int[] iArr3 = new int[attributeCount];
                    int i5 = 0;
                    for (i2 = 0; i2 < attributeCount; i2++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                        if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != C0196R.attr.alpha) {
                            int i6 = i5 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr3[i5] = attributeNameResource;
                            i5 = i6;
                        }
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr3, i5);
                    iArr2 = GrowingArrayUtils.append(iArr2, i4, modulateColorAlpha(color, f));
                    iArr = (int[][]) GrowingArrayUtils.append(iArr, i4, trimStateSet);
                    i4++;
                }
                f = obtainAttributes.getFloat(i, 1.0f);
                obtainAttributes.recycle();
                attributeCount = attributeSet.getAttributeCount();
                int[] iArr32 = new int[attributeCount];
                int i52 = 0;
                while (i2 < attributeCount) {
                }
                int[] trimStateSet2 = StateSet.trimStateSet(iArr32, i52);
                iArr2 = GrowingArrayUtils.append(iArr2, i4, modulateColorAlpha(color, f));
                iArr = (int[][]) GrowingArrayUtils.append(iArr, i4, trimStateSet2);
                i4++;
            }
            i3 = 1;
        }
        int[] iArr4 = new int[i4];
        int[][] iArr5 = new int[i4];
        System.arraycopy(iArr2, 0, iArr4, 0, i4);
        System.arraycopy(iArr, 0, iArr5, 0, i4);
        return new ColorStateList(iArr5, iArr4);
    }

    @ColorInt
    public static int modulateColorAlpha(@ColorInt int i, @FloatRange(from = 0.0d, m4213to = 1.0d) float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (Math.round(Color.alpha(i) * f) << 24);
    }

    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
