package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

/* loaded from: classes3.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Dialog dialog = getDialog();
        if (dialog instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
            if (bottomSheetDialog.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
                bottomSheetDialog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            boolean z2 = bottomSheetDialog.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww;
            return false;
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new BottomSheetDialog(mo4928getContext(), getTheme());
    }
}
