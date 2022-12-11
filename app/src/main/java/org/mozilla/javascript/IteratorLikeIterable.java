package org.mozilla.javascript;

import java.io.Closeable;
import java.util.Iterator;
import org.fourthline.cling.model.meta.QueryStateVariableAction;

/* loaded from: classes5.dex */
public class IteratorLikeIterable implements Iterable<Object>, Closeable {
    public boolean closed;

    /* renamed from: cx */
    public final Context f4670cx;
    public final Scriptable iterator;
    public final Callable next;
    public final Callable returnFunc;
    public final Scriptable scope;

    /* loaded from: classes5.dex */
    public final class Itr implements Iterator<Object> {
        public Object nextVal;

        public Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Object call = IteratorLikeIterable.this.next.call(IteratorLikeIterable.this.f4670cx, IteratorLikeIterable.this.scope, IteratorLikeIterable.this.iterator, ScriptRuntime.emptyArgs);
            Object objectProp = ScriptRuntime.getObjectProp(call, ES6Iterator.DONE_PROPERTY, IteratorLikeIterable.this.f4670cx, IteratorLikeIterable.this.scope);
            if (!Undefined.instance.equals(objectProp)) {
                if (Boolean.TRUE.equals(objectProp)) {
                    return false;
                }
                this.nextVal = ScriptRuntime.getObjectProp(call, "value", IteratorLikeIterable.this.f4670cx, IteratorLikeIterable.this.scope);
                return true;
            }
            throw ScriptRuntime.undefReadError(call, ES6Iterator.DONE_PROPERTY);
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.nextVal;
        }
    }

    public IteratorLikeIterable(Context context, Scriptable scriptable, Object obj) {
        this.f4670cx = context;
        this.scope = scriptable;
        this.next = ScriptRuntime.getPropFunctionAndThis(obj, ES6Iterator.NEXT_METHOD, context, scriptable);
        this.iterator = ScriptRuntime.lastStoredScriptable(context);
        Scriptable ensureScriptable = ScriptableObject.ensureScriptable(obj);
        if (!ensureScriptable.has(QueryStateVariableAction.OUTPUT_ARG_RETURN, ensureScriptable)) {
            this.returnFunc = null;
            return;
        }
        this.returnFunc = ScriptRuntime.getPropFunctionAndThis(obj, QueryStateVariableAction.OUTPUT_ARG_RETURN, context, scriptable);
        ScriptRuntime.lastStoredScriptable(context);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.closed = true;
            Callable callable = this.returnFunc;
            if (callable == null) {
                return;
            }
            callable.call(this.f4670cx, this.scope, this.iterator, ScriptRuntime.emptyArgs);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return new Itr();
    }
}
