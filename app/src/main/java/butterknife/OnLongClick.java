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
@ListenerClass(method = {@ListenerMethod(defaultReturn = "true", name = "onLongClick", parameters = {ExploreByTouchHelper.DEFAULT_CLASS_NAME}, returnType = ClassTransform.BOOLEAN)}, setter = "setOnLongClickListener", targetType = ExploreByTouchHelper.DEFAULT_CLASS_NAME, type = "android.view.View.OnLongClickListener")
/* loaded from: classes3.dex */
public @interface OnLongClick {
    @IdRes
    int[] value() default {-1};
}
