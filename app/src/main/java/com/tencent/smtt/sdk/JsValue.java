package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class JsValue {

    /* renamed from: a */
    public final JsContext f1721a;

    /* renamed from: b */
    public final IX5JsValue f1722b;

    /* renamed from: com.tencent.smtt.sdk.JsValue$a */
    /* loaded from: classes4.dex */
    public static class C1279a implements IX5JsValue.JsValueFactory {
        public C1279a() {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public String getJsValueClassName() {
            return JsValue.class.getName();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public IX5JsValue unwrap(Object obj) {
            if (obj == null || !(obj instanceof JsValue)) {
                return null;
            }
            return ((JsValue) obj).f1722b;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public Object wrap(IX5JsValue iX5JsValue) {
            JsContext current;
            if (iX5JsValue == null || (current = JsContext.current()) == null) {
                return null;
            }
            return new JsValue(current, iX5JsValue);
        }
    }

    public JsValue(JsContext jsContext, IX5JsValue iX5JsValue) {
        this.f1721a = jsContext;
        this.f1722b = iX5JsValue;
    }

    /* renamed from: a */
    public static IX5JsValue.JsValueFactory m2847a() {
        return new C1279a();
    }

    /* renamed from: a */
    private JsValue m2846a(IX5JsValue iX5JsValue) {
        if (iX5JsValue == null) {
            return null;
        }
        return new JsValue(this.f1721a, iX5JsValue);
    }

    public JsValue call(Object... objArr) {
        return m2846a(this.f1722b.call(objArr));
    }

    public JsValue construct(Object... objArr) {
        return m2846a(this.f1722b.construct(objArr));
    }

    public JsContext context() {
        return this.f1721a;
    }

    public boolean isArray() {
        return this.f1722b.isArray();
    }

    public boolean isArrayBufferOrArrayBufferView() {
        return this.f1722b.isArrayBufferOrArrayBufferView();
    }

    public boolean isBoolean() {
        return this.f1722b.isBoolean();
    }

    public boolean isFunction() {
        return this.f1722b.isFunction();
    }

    public boolean isInteger() {
        return this.f1722b.isInteger();
    }

    public boolean isJavascriptInterface() {
        return this.f1722b.isJavascriptInterface();
    }

    public boolean isNull() {
        return this.f1722b.isNull();
    }

    public boolean isNumber() {
        return this.f1722b.isNumber();
    }

    public boolean isObject() {
        return this.f1722b.isObject();
    }

    public boolean isPromise() {
        return this.f1722b.isPromise();
    }

    public boolean isString() {
        return this.f1722b.isString();
    }

    public boolean isUndefined() {
        return this.f1722b.isUndefined();
    }

    public void reject(Object obj) {
        this.f1722b.resolveOrReject(obj, false);
    }

    public void resolve(Object obj) {
        this.f1722b.resolveOrReject(obj, true);
    }

    public boolean toBoolean() {
        return this.f1722b.toBoolean();
    }

    public ByteBuffer toByteBuffer() {
        return this.f1722b.toByteBuffer();
    }

    public int toInteger() {
        return this.f1722b.toInteger();
    }

    public Object toJavascriptInterface() {
        return this.f1722b.toJavascriptInterface();
    }

    public Number toNumber() {
        return this.f1722b.toNumber();
    }

    public <T> T toObject(Class<T> cls) {
        return (T) this.f1722b.toObject(cls);
    }

    public String toString() {
        return this.f1722b.toString();
    }
}
