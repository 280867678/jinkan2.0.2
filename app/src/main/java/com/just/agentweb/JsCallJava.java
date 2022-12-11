package com.just.agentweb;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Method;
import java.util.HashMap;
import me.tvspark.outline;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.tools.idswitch.Main;
import org.simpleframework.xml.core.AnnotationHandler;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes3.dex */
public class JsCallJava {
    public static final String[] IGNORE_UNSAFE_METHODS = {"getClass", "hashCode", "notify", "notifyAll", AnnotationHandler.EQUAL, AnnotationHandler.STRING, "wait"};
    public static final String KEY_ARGS = "args";
    public static final String KEY_METHOD = "method";
    public static final String KEY_OBJ = "obj";
    public static final String KEY_TYPES = "types";
    public static final String MSG_PROMPT_HEADER = "AgentWeb:";
    public static final String RETURN_RESULT_FORMAT = "{\"CODE\": %d, \"result\": %s}";
    public static final String TAG = "JsCallJava";
    public Object mInterfaceObj;
    public String mInterfacedName;
    public HashMap<String, Method> mMethodsMap;
    public String mPreloadInterfaceJs;

    public JsCallJava(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.mInterfaceObj = obj;
            this.mInterfacedName = str;
            this.mMethodsMap = new HashMap<>();
            Method[] methods = this.mInterfaceObj.getClass().getMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.mInterfacedName);
            sb.append(" init begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : methods) {
                String str2 = "method:" + method;
                String genJavaMethodSign = genJavaMethodSign(method);
                if (genJavaMethodSign != null) {
                    this.mMethodsMap.put(genJavaMethodSign, method);
                    sb.append(String.format("a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.mInterfacedName);
            sb.append(" call result, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var k = new Date().getTime();var l = f.shift();var m=prompt('");
            sb.append(MSG_PROMPT_HEADER);
            sb.append("'+JSON.stringify(");
            sb.append(promptMsgFormat("'" + this.mInterfacedName + "'", "l", "e", "f"));
            sb.append("));console.log(\"invoke \"+l+\", time: \"+(new Date().getTime()-k));var g=JSON.parse(m);if(g.CODE!=200){throw\"");
            sb.append(this.mInterfacedName);
            sb.append(" call result, CODE:\"+g.CODE+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.mInterfacedName);
            sb.append("=a;console.log(\"");
            sb.append(this.mInterfacedName);
            sb.append(" init end\")})(window)");
            this.mPreloadInterfaceJs = sb.toString();
            sb.setLength(0);
        } catch (Exception e) {
            if (!LogUtils.isDebug()) {
                return;
            }
            e.getMessage();
        }
    }

    private String genJavaMethodSign(Method method) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str;
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (String str2 : IGNORE_UNSAFE_METHODS) {
            if (str2.equals(name)) {
                LogUtils.isDebug();
                return null;
            }
        }
        int length = parameterTypes.length;
        for (int i = 0; i < length; i++) {
            Class<?> cls = parameterTypes[i];
            if (cls == String.class) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name);
                str = "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name);
                str = "_N";
            } else if (cls == Boolean.TYPE) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name);
                str = "_B";
            } else if (cls == JSONObject.class) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name);
                str = "_O";
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name);
                str = cls == JsCallback.class ? "_F" : "_P";
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            name = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return name;
    }

    public static String getInterfacedName(JSONObject jSONObject) {
        return jSONObject.optString("obj");
    }

    public static JSONObject getMsgJSONObject(String str) {
        try {
            return new JSONObject(str.substring(9));
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    private String getReturn(JSONObject jSONObject, int i, Object obj, long j) {
        String format = String.format(RETURN_RESULT_FORMAT, Integer.valueOf(i), obj == null ? "null" : obj instanceof String ? "\"".concat(String.valueOf(((String) obj).replace("\"", "\\\""))).concat("\"") : String.valueOf(obj));
        if (LogUtils.isDebug()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("call time: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(SystemClock.uptimeMillis() - j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(jSONObject);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", result:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(format);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return format;
    }

    public static boolean isSafeWebViewCallMsg(String str) {
        return str.startsWith(MSG_PROMPT_HEADER);
    }

    public static String promptMsgFormat(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("obj");
        sb.append(":");
        sb.append(str);
        sb.append(",");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, KEY_METHOD, ":", str2, ",");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, KEY_TYPES, ":", str3, ",");
        sb.append(KEY_ARGS);
        sb.append(":");
        sb.append(str4);
        sb.append("}");
        return sb.toString();
    }

    public String call(WebView webView, JSONObject jSONObject) {
        int i;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String message;
        String sb;
        long uptimeMillis = LogUtils.isDebug() ? SystemClock.uptimeMillis() : 0L;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(KEY_METHOD);
                JSONArray jSONArray = jSONObject.getJSONArray(KEY_TYPES);
                JSONArray jSONArray2 = jSONObject.getJSONArray(KEY_ARGS);
                int length = jSONArray.length();
                Object[] objArr = new Object[length];
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = jSONArray.optString(i3);
                    Object obj = null;
                    if (Main.STRING_TAG_STR.equals(optString)) {
                        string = string + "_S";
                        if (!jSONArray2.isNull(i3)) {
                            obj = jSONArray2.getString(i3);
                        }
                        objArr[i3] = obj;
                    } else if ("number".equals(optString)) {
                        string = string + "_N";
                        i2 = (i2 * 10) + i3 + 1;
                    } else if (ClassTransform.BOOLEAN.equals(optString)) {
                        string = string + "_B";
                        objArr[i3] = Boolean.valueOf(jSONArray2.getBoolean(i3));
                    } else if ("object".equals(optString)) {
                        string = string + "_O";
                        if (!jSONArray2.isNull(i3)) {
                            obj = jSONArray2.getJSONObject(i3);
                        }
                        objArr[i3] = obj;
                    } else if ("function".equals(optString)) {
                        string = string + "_F";
                        objArr[i3] = new JsCallback(webView, this.mInterfacedName, jSONArray2.getInt(i3));
                    } else {
                        string = string + "_P";
                    }
                }
                Method method = this.mMethodsMap.get(string);
                if (method == null) {
                    return getReturn(jSONObject, 500, "not found method(" + string + ") with valid parameters", uptimeMillis);
                }
                if (i2 > 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    while (i2 > 0) {
                        int i4 = (i2 - ((i2 / 10) * 10)) - 1;
                        Class<?> cls = parameterTypes[i4];
                        if (cls == Integer.TYPE) {
                            objArr[i4] = Integer.valueOf(jSONArray2.getInt(i4));
                        } else if (cls == Long.TYPE) {
                            objArr[i4] = Long.valueOf(Long.parseLong(jSONArray2.getString(i4)));
                        } else {
                            objArr[i4] = Double.valueOf(jSONArray2.getDouble(i4));
                        }
                        i2 /= 10;
                    }
                }
                return getReturn(jSONObject, 200, method.invoke(this.mInterfaceObj, objArr), uptimeMillis);
            } catch (Exception e) {
                LogUtils.safeCheckCrash(TAG, NotificationCompat.CATEGORY_CALL, e);
                i = 500;
                if (e.getCause() != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("method execute result:");
                    message = e.getCause().getMessage();
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("method execute result:");
                    message = e.getMessage();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(message);
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
        } else {
            sb = "call data empty";
            i = 500;
        }
        return getReturn(jSONObject, i, sb, uptimeMillis);
    }

    public String getPreloadInterfaceJs() {
        return this.mPreloadInterfaceJs;
    }
}
