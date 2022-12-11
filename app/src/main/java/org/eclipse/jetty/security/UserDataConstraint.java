package org.eclipse.jetty.security;

import me.tvspark.outline;

/* loaded from: classes4.dex */
public enum UserDataConstraint {
    None,
    Integral,
    Confidential;

    public static UserDataConstraint get(int i) {
        if (i < -1 || i > 2) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected -1, 0, 1, or 2, not: ", i));
        }
        return i == -1 ? None : values()[i];
    }

    public UserDataConstraint combine(UserDataConstraint userDataConstraint) {
        return compareTo(userDataConstraint) < 0 ? this : userDataConstraint;
    }
}
