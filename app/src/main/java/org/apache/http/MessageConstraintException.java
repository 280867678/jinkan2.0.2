package org.apache.http;

import java.nio.charset.CharacterCodingException;

/* loaded from: classes4.dex */
public class MessageConstraintException extends CharacterCodingException {
    public static final long serialVersionUID = 6077207720446368695L;
    public final String message;

    public MessageConstraintException(String str) {
        this.message = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
