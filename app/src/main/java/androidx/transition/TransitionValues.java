package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            return this.view == transitionValues.view && this.values.equals(transitionValues.values);
        }
        return false;
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TransitionValues@");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(hashCode()));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":\n");
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), "    view = ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.view);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), "    values:");
        for (String str : this.values.keySet()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }
}
