package me.tvspark;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Locale;

/* loaded from: classes4.dex */
public class t81 extends p81 {
    @Override // me.tvspark.p81
    @IntRange(from = -1, m4212to = 1)
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, @NonNull File file2) {
        return file2.getName().toLowerCase(Locale.getDefault()).compareTo(file.getName().toLowerCase(Locale.getDefault()));
    }
}
