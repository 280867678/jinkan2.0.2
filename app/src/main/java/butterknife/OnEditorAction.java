package butterknife;

import androidx.annotation.IdRes;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.simpleframework.xml.transform.ClassTransform;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = "true", name = "onEditorAction", parameters = {"android.widget.TextView", ClassTransform.INTEGER, "android.view.KeyEvent"}, returnType = ClassTransform.BOOLEAN)}, setter = "setOnEditorActionListener", targetType = "android.widget.TextView", type = "android.widget.TextView.OnEditorActionListener")
/* loaded from: classes3.dex */
public @interface OnEditorAction {
    @IdRes
    int[] value() default {-1};
}
