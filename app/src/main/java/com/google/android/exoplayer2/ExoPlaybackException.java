package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import me.tvspark.AbstractC2858ze;
import me.tvspark.C1933b4;
import me.tvspark.C2245j3;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class ExoPlaybackException extends Exception {
    public static final int TIMEOUT_OPERATION_RELEASE = 1;
    public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
    public static final int TIMEOUT_OPERATION_UNDEFINED = 0;
    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_TIMEOUT = 5;
    public static final int TYPE_UNEXPECTED = 2;
    @Nullable
    public final Throwable cause;
    @Nullable
    public final AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mediaPeriodId;
    @Nullable
    public final C2245j3 rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    @Nullable
    public final String rendererName;
    public final int timeoutOperation;
    public final long timestampMs;
    public final int type;

    public ExoPlaybackException(int i, String str) {
        this(i, null, str, null, -1, null, 4, 0);
    }

    public ExoPlaybackException(int i, Throwable th) {
        this(i, th, null, null, -1, null, 4, 0);
    }

    public ExoPlaybackException(int i, @Nullable Throwable th, @Nullable String str, @Nullable String str2, int i2, @Nullable C2245j3 c2245j3, int i3, int i4) {
        this(deriveMessage(i, str, str2, i2, c2245j3, i3), th, i, str2, i2, c2245j3, i3, null, i4, SystemClock.elapsedRealtime());
    }

    public ExoPlaybackException(@Nullable String str, @Nullable Throwable th, int i, @Nullable String str2, int i2, @Nullable C2245j3 c2245j3, int i3, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i4, long j) {
        super(str, th);
        this.type = i;
        this.cause = th;
        this.rendererName = str2;
        this.rendererIndex = i2;
        this.rendererFormat = c2245j3;
        this.rendererFormatSupport = i3;
        this.mediaPeriodId = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.timeoutOperation = i4;
        this.timestampMs = j;
    }

    public static ExoPlaybackException createForOutOfMemory(OutOfMemoryError outOfMemoryError) {
        return new ExoPlaybackException(4, outOfMemoryError);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, str);
    }

    public static ExoPlaybackException createForRenderer(Exception exc, String str, int i, @Nullable C2245j3 c2245j3, int i2) {
        return new ExoPlaybackException(1, exc, null, str, i, c2245j3, c2245j3 == null ? 4 : i2, 0);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, iOException);
    }

    public static ExoPlaybackException createForTimeout(TimeoutException timeoutException, int i) {
        return new ExoPlaybackException(5, timeoutException, null, null, -1, null, 4, i);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException);
    }

    @Nullable
    public static String deriveMessage(int i, @Nullable String str, @Nullable String str2, int i2, @Nullable C2245j3 c2245j3, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? i != 4 ? i != 5 ? "Unexpected runtime error" : "Timeout error" : "Out of memory error" : "Remote error";
        } else {
            String valueOf = String.valueOf(c2245j3);
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            StringBuilder sb = new StringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() + valueOf.length() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, 53));
            sb.append(str2);
            sb.append(" error, index=");
            sb.append(i2);
            sb.append(", format=");
            str3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, valueOf, ", format_supported=", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (!TextUtils.isEmpty(str)) {
            String valueOf2 = String.valueOf(str3);
            StringBuilder sb2 = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, valueOf2.length() + 2));
            sb2.append(valueOf2);
            sb2.append(": ");
            sb2.append(str);
            return sb2.toString();
        }
        return str3;
    }

    @CheckResult
    public ExoPlaybackException copyWithMediaPeriodId(@Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return new ExoPlaybackException(getMessage(), this.cause, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.timeoutOperation, this.timestampMs);
    }

    public OutOfMemoryError getOutOfMemoryError() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.type == 4);
        Throwable th = this.cause;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        return (OutOfMemoryError) th;
    }

    public Exception getRendererException() {
        boolean z = true;
        if (this.type != 1) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        Throwable th = this.cause;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        return (Exception) th;
    }

    public IOException getSourceException() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.type == 0);
        Throwable th = this.cause;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        return (IOException) th;
    }

    public TimeoutException getTimeoutException() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.type == 5);
        Throwable th = this.cause;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        return (TimeoutException) th;
    }

    public RuntimeException getUnexpectedException() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.type == 2);
        Throwable th = this.cause;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        return (RuntimeException) th;
    }
}
