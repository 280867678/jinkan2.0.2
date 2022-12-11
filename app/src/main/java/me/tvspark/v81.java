package me.tvspark;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes4.dex */
public class v81 extends p81 {
    @Override // me.tvspark.p81
    @IntRange(from = -1, m4212to = 1)
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, @NonNull File file2) {
        return Long.valueOf(file2.length()).compareTo(Long.valueOf(file.length()));
    }
}
