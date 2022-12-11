package org.greenrobot.eventbus.util;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import me.tvspark.o11;

/* loaded from: classes5.dex */
public class ErrorDialogManager$SupportManagerFragment extends Fragment {
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public o11 Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = false;
            return;
        }
        throw null;
    }
}
