package butterknife;

import androidx.annotation.IdRes;
import androidx.customview.widget.ExploreByTouchHelper;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.simpleframework.xml.transform.ClassTransform;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(name = "onFocusChange", parameters = {ExploreByTouchHelper.DEFAULT_CLASS_NAME, ClassTransform.BOOLEAN})}, setter = "setOnFocusChangeListener", targetType = ExploreByTouchHelper.DEFAULT_CLASS_NAME, type = "android.view.View.OnFocusChangeListener")
/* loaded from: classes3.dex */
public @interface OnFocusChange {
    @IdRes
    int[] value() default {-1};
}
