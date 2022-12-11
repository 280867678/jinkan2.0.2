package androidx.appcompat.app;

import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class LayoutIncludeDetector {
    @NonNull
    public final Deque<WeakReference<XmlPullParser>> mXmlParserStack = new ArrayDeque();

    public static boolean isParserOutdated(@Nullable XmlPullParser xmlPullParser) {
        if (xmlPullParser != null) {
            try {
                if (xmlPullParser.getEventType() == 3) {
                    return true;
                }
                return xmlPullParser.getEventType() == 1;
            } catch (XmlPullParserException unused) {
                return true;
            }
        }
        return true;
    }

    @Nullable
    public static XmlPullParser popOutdatedAttrHolders(@NonNull Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            XmlPullParser xmlPullParser = deque.peek().get();
            if (!isParserOutdated(xmlPullParser)) {
                return xmlPullParser;
            }
            deque.pop();
        }
        return null;
    }

    public static boolean shouldInheritContext(@NonNull XmlPullParser xmlPullParser, @Nullable XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 == null || xmlPullParser == xmlPullParser2) {
            return false;
        }
        try {
            if (xmlPullParser2.getEventType() != 2) {
                return false;
            }
            return "include".equals(xmlPullParser2.getName());
        } catch (XmlPullParserException unused) {
            return false;
        }
    }

    public boolean detect(@NonNull AttributeSet attributeSet) {
        if (attributeSet instanceof XmlPullParser) {
            XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
            if (xmlPullParser.getDepth() != 1) {
                return false;
            }
            XmlPullParser popOutdatedAttrHolders = popOutdatedAttrHolders(this.mXmlParserStack);
            this.mXmlParserStack.push(new WeakReference<>(xmlPullParser));
            return shouldInheritContext(xmlPullParser, popOutdatedAttrHolders);
        }
        return false;
    }
}
