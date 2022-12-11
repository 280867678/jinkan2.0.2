package me.tvspark;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Comparator;

/* loaded from: classes4.dex */
public abstract class p81 implements Comparator<File> {
    @IntRange(from = -1, m4212to = 1)
    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, @NonNull File file2);

    @Override // java.util.Comparator
    @IntRange(from = -1, m4212to = 1)
    public int compare(@NonNull File file, @NonNull File file2) {
        File file3 = file;
        File file4 = file2;
        if (!file3.isDirectory() || file4.isDirectory()) {
            if (!file3.isDirectory() && file4.isDirectory()) {
                return 1;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file3, file4);
        }
        return -1;
    }
}
