package org.fourthline.cling.model;

import java.util.Date;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class ExpirationDetails {
    public static final int UNLIMITED_AGE = 0;
    public static String simpleName = "ExpirationDetails";
    public long lastRefreshTimestampSeconds;
    public int maxAgeSeconds;

    public ExpirationDetails() {
        this.maxAgeSeconds = 0;
        this.lastRefreshTimestampSeconds = getCurrentTimestampSeconds();
    }

    public ExpirationDetails(int i) {
        this.maxAgeSeconds = 0;
        this.lastRefreshTimestampSeconds = getCurrentTimestampSeconds();
        this.maxAgeSeconds = i;
    }

    public long getCurrentTimestampSeconds() {
        return new Date().getTime() / 1000;
    }

    public long getLastRefreshTimestampSeconds() {
        return this.lastRefreshTimestampSeconds;
    }

    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public long getSecondsUntilExpiration() {
        int i = this.maxAgeSeconds;
        if (i == 0) {
            return 2147483647L;
        }
        return (this.lastRefreshTimestampSeconds + i) - getCurrentTimestampSeconds();
    }

    public boolean hasExpired() {
        return hasExpired(false);
    }

    public boolean hasExpired(boolean z) {
        int i = this.maxAgeSeconds;
        if (i != 0) {
            if (this.lastRefreshTimestampSeconds + (i / (z ? 2 : 1)) < getCurrentTimestampSeconds()) {
                return true;
            }
        }
        return false;
    }

    public void setLastRefreshTimestampSeconds(long j) {
        this.lastRefreshTimestampSeconds = j;
    }

    public void stampLastRefresh() {
        setLastRefreshTimestampSeconds(getCurrentTimestampSeconds());
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, simpleName, ")", " MAX AGE: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.maxAgeSeconds);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
