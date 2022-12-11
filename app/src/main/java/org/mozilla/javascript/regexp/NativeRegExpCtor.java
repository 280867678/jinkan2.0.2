package org.mozilla.javascript.regexp;

import org.mozilla.javascript.BaseFunction;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeRegExpCtor extends BaseFunction {
    public static final int DOLLAR_ID_BASE = 12;
    public static final int Id_AMPERSAND = 6;
    public static final int Id_BACK_QUOTE = 10;
    public static final int Id_DOLLAR_1 = 13;
    public static final int Id_DOLLAR_2 = 14;
    public static final int Id_DOLLAR_3 = 15;
    public static final int Id_DOLLAR_4 = 16;
    public static final int Id_DOLLAR_5 = 17;
    public static final int Id_DOLLAR_6 = 18;
    public static final int Id_DOLLAR_7 = 19;
    public static final int Id_DOLLAR_8 = 20;
    public static final int Id_DOLLAR_9 = 21;
    public static final int Id_PLUS = 8;
    public static final int Id_QUOTE = 12;
    public static final int Id_STAR = 2;
    public static final int Id_UNDERSCORE = 4;
    public static final int Id_input = 3;
    public static final int Id_lastMatch = 5;
    public static final int Id_lastParen = 7;
    public static final int Id_leftContext = 9;
    public static final int Id_multiline = 1;
    public static final int Id_rightContext = 11;
    public static final int MAX_INSTANCE_ID = 21;
    public static final long serialVersionUID = -5733330028285400526L;
    public int multilineAttr = 4;
    public int starAttr = 4;
    public int inputAttr = 4;
    public int underscoreAttr = 4;

    public static RegExpImpl getImpl() {
        return (RegExpImpl) ScriptRuntime.getRegExpProxy(Context.getCurrentContext());
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return (objArr.length <= 0 || !(objArr[0] instanceof NativeRegExp) || !(objArr.length == 1 || objArr[1] == Undefined.instance)) ? construct(context, scriptable, objArr) : objArr[0];
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.compile(context, scriptable, objArr);
        ScriptRuntime.setBuiltinProtoAndParent(nativeRegExp, scriptable, TopLevel.Builtins.RegExp);
        return nativeRegExp;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00ed, code lost:
        if (r11.charAt(0) == '$') goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00fc A[ADDED_TO_REGION] */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int findInstanceIdInfo(String str) {
        String str2;
        int length = str.length();
        int i = 12;
        int i2 = 5;
        if (length != 2) {
            if (length != 5) {
                if (length == 9) {
                    char charAt = str.charAt(4);
                    if (charAt == 'M') {
                        str2 = "lastMatch";
                        i = 5;
                    } else if (charAt == 'P') {
                        str2 = "lastParen";
                        i = 7;
                    } else if (charAt == 'i') {
                        str2 = "multiline";
                        i = 1;
                    }
                } else if (length == 11) {
                    str2 = "leftContext";
                    i = 9;
                } else if (length == 12) {
                    str2 = "rightContext";
                    i = 11;
                }
                if (i != 0) {
                    return super.findInstanceIdInfo(str);
                }
                if (i == 1) {
                    i2 = this.multilineAttr;
                } else if (i == 2) {
                    i2 = this.starAttr;
                } else if (i == 3) {
                    i2 = this.inputAttr;
                } else if (i == 4) {
                    i2 = this.underscoreAttr;
                }
                return IdScriptableObject.instanceIdInfo(i2, super.getMaxInstanceId() + i);
            }
            str2 = "input";
            i = 3;
            if (str2 != null && str2 != str && !str2.equals(str)) {
                i = 0;
            }
            if (i != 0) {
            }
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 != '&') {
                if (charAt2 != '\'') {
                    if (charAt2 != '*') {
                        if (charAt2 != '+') {
                            if (charAt2 != '_') {
                                if (charAt2 != '`') {
                                    switch (charAt2) {
                                        case '1':
                                            if (str.charAt(0) == '$') {
                                                i = 13;
                                                break;
                                            }
                                            break;
                                        case '2':
                                            if (str.charAt(0) == '$') {
                                                i = 14;
                                                break;
                                            }
                                            break;
                                        case '3':
                                            if (str.charAt(0) == '$') {
                                                i = 15;
                                                break;
                                            }
                                            break;
                                        case '4':
                                            if (str.charAt(0) == '$') {
                                                i = 16;
                                                break;
                                            }
                                            break;
                                        case '5':
                                            if (str.charAt(0) == '$') {
                                                i = 17;
                                                break;
                                            }
                                            break;
                                        case '6':
                                            if (str.charAt(0) == '$') {
                                                i = 18;
                                                break;
                                            }
                                            break;
                                        case '7':
                                            if (str.charAt(0) == '$') {
                                                i = 19;
                                                break;
                                            }
                                            break;
                                        case '8':
                                            if (str.charAt(0) == '$') {
                                                i = 20;
                                                break;
                                            }
                                            break;
                                        case '9':
                                            if (str.charAt(0) == '$') {
                                                i = 21;
                                                break;
                                            }
                                            break;
                                    }
                                    if (i != 0) {
                                    }
                                } else if (str.charAt(0) == '$') {
                                    i = 10;
                                    if (i != 0) {
                                    }
                                }
                            } else if (str.charAt(0) == '$') {
                                i = 4;
                                if (i != 0) {
                                }
                            }
                        } else if (str.charAt(0) == '$') {
                            i = 8;
                            if (i != 0) {
                            }
                        }
                    } else if (str.charAt(0) == '$') {
                        i = 2;
                        if (i != 0) {
                        }
                    }
                }
            } else if (str.charAt(0) == '$') {
                i = 6;
                if (i != 0) {
                }
            }
            if (str2 != null) {
                i = 0;
            }
            if (i != 0) {
            }
        }
        str2 = null;
        i = 0;
        if (str2 != null) {
        }
        if (i != 0) {
        }
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        return 2;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return "RegExp";
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (1 > maxInstanceId || maxInstanceId > 21) {
            return super.getInstanceIdName(i);
        }
        switch (maxInstanceId) {
            case 1:
                return "multiline";
            case 2:
                return "$*";
            case 3:
                return "input";
            case 4:
                return "$_";
            case 5:
                return "lastMatch";
            case 6:
                return "$&";
            case 7:
                return "lastParen";
            case 8:
                return "$+";
            case 9:
                return "leftContext";
            case 10:
                return "$`";
            case 11:
                return "rightContext";
            case 12:
                return "$'";
            default:
                return new String(new char[]{'$', (char) (((maxInstanceId - 12) - 1) + 49)});
        }
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        Object obj;
        int maxInstanceId = i - super.getMaxInstanceId();
        if (1 > maxInstanceId || maxInstanceId > 21) {
            return super.getInstanceIdValue(i);
        }
        RegExpImpl impl = getImpl();
        switch (maxInstanceId) {
            case 1:
            case 2:
                return ScriptRuntime.wrapBoolean(impl.multiline);
            case 3:
            case 4:
                obj = impl.input;
                break;
            case 5:
            case 6:
                obj = impl.lastMatch;
                break;
            case 7:
            case 8:
                obj = impl.lastParen;
                break;
            case 9:
            case 10:
                obj = impl.leftContext;
                break;
            case 11:
            case 12:
                obj = impl.rightContext;
                break;
            default:
                obj = impl.getParenSubString((maxInstanceId - 12) - 1);
                break;
        }
        return obj == null ? "" : obj.toString();
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getLength() {
        return 2;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return super.getMaxInstanceId() + 21;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdAttributes(int i, int i2) {
        int maxInstanceId = i - super.getMaxInstanceId();
        switch (maxInstanceId) {
            case 1:
                this.multilineAttr = i2;
                return;
            case 2:
                this.starAttr = i2;
                return;
            case 3:
                this.inputAttr = i2;
                return;
            case 4:
                this.underscoreAttr = i2;
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return;
            default:
                int i3 = (maxInstanceId - 12) - 1;
                if (i3 >= 0 && i3 <= 8) {
                    return;
                }
                super.setInstanceIdAttributes(i, i2);
                return;
        }
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        int maxInstanceId = i - super.getMaxInstanceId();
        switch (maxInstanceId) {
            case 1:
            case 2:
                getImpl().multiline = ScriptRuntime.toBoolean(obj);
                return;
            case 3:
            case 4:
                getImpl().input = ScriptRuntime.toString(obj);
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return;
            default:
                int i2 = (maxInstanceId - 12) - 1;
                if (i2 >= 0 && i2 <= 8) {
                    return;
                }
                super.setInstanceIdValue(i, obj);
                return;
        }
    }
}
