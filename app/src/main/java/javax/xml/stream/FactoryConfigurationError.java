package javax.xml.stream;

/* loaded from: classes4.dex */
public class FactoryConfigurationError extends Error {
    public Exception nested;

    public FactoryConfigurationError() {
    }

    public FactoryConfigurationError(Exception exc) {
        this.nested = exc;
    }

    public FactoryConfigurationError(Exception exc, String str) {
        super(str);
        this.nested = exc;
    }

    public FactoryConfigurationError(String str) {
        super(str);
    }

    public FactoryConfigurationError(String str, Exception exc) {
        super(str);
        this.nested = exc;
    }

    public Exception getException() {
        return this.nested;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Exception exc;
        String message = super.getMessage();
        if (message == null && (exc = this.nested) != null) {
            String message2 = exc.getMessage();
            return message2 == null ? this.nested.getClass().toString() : message2;
        }
        return message;
    }
}
