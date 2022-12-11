package javax.script;

/* loaded from: classes4.dex */
public interface Invocable {
    <T> T getInterface(Class<T> cls);

    <T> T getInterface(Object obj, Class<T> cls);

    Object invokeFunction(String str, Object... objArr) throws ScriptException, NoSuchMethodException;

    Object invokeMethod(Object obj, String str, Object... objArr) throws ScriptException, NoSuchMethodException;
}
