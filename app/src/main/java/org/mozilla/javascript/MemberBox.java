package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.http.message.TokenParser;

/* loaded from: classes5.dex */
public final class MemberBox implements Serializable {
    public static final Class<?>[] primitives = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Double.TYPE, Float.TYPE, Integer.TYPE, Long.TYPE, Short.TYPE, Void.TYPE};
    public static final long serialVersionUID = 6358550398665688245L;
    public transient Class<?>[] argTypes;
    public transient Object delegateTo;
    public transient Member memberObject;
    public transient boolean vararg;

    public MemberBox(Constructor<?> constructor) {
        init(constructor);
    }

    public MemberBox(Method method) {
        init(method);
    }

    private void init(Constructor<?> constructor) {
        this.memberObject = constructor;
        this.argTypes = constructor.getParameterTypes();
        this.vararg = constructor.isVarArgs();
    }

    private void init(Method method) {
        this.memberObject = method;
        this.argTypes = method.getParameterTypes();
        this.vararg = method.isVarArgs();
    }

    public static Member readMember(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        if (!objectInputStream.readBoolean()) {
            return null;
        }
        boolean readBoolean = objectInputStream.readBoolean();
        String str = (String) objectInputStream.readObject();
        Class cls = (Class) objectInputStream.readObject();
        Class<?>[] readParameters = readParameters(objectInputStream);
        try {
            return readBoolean ? cls.getMethod(str, readParameters) : cls.getConstructor(readParameters);
        } catch (NoSuchMethodException e) {
            throw new IOException("Cannot find member: " + e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Member readMember = readMember(objectInputStream);
        if (readMember instanceof Method) {
            init((Method) readMember);
        } else {
            init((Constructor) readMember);
        }
    }

    public static Class<?>[] readParameters(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int readShort = objectInputStream.readShort();
        Class<?>[] clsArr = new Class[readShort];
        for (int i = 0; i < readShort; i++) {
            if (!objectInputStream.readBoolean()) {
                clsArr[i] = (Class) objectInputStream.readObject();
            } else {
                clsArr[i] = primitives[objectInputStream.readByte()];
            }
        }
        return clsArr;
    }

    public static Method searchAccessibleMethod(Method method, Class<?>[] clsArr) {
        int modifiers = method.getModifiers();
        if (!Modifier.isPublic(modifiers) || Modifier.isStatic(modifiers)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return null;
        }
        String name = method.getName();
        Class<?>[] interfaces = declaringClass.getInterfaces();
        int length = interfaces.length;
        for (int i = 0; i != length; i++) {
            Class<?> cls = interfaces[i];
            if (Modifier.isPublic(cls.getModifiers())) {
                try {
                    return cls.getMethod(name, clsArr);
                } catch (NoSuchMethodException | SecurityException unused) {
                    continue;
                }
            }
        }
        while (true) {
            declaringClass = declaringClass.getSuperclass();
            if (declaringClass == null) {
                return null;
            }
            if (Modifier.isPublic(declaringClass.getModifiers())) {
                try {
                    Method method2 = declaringClass.getMethod(name, clsArr);
                    int modifiers2 = method2.getModifiers();
                    if (Modifier.isPublic(modifiers2) && !Modifier.isStatic(modifiers2)) {
                        return method2;
                    }
                } catch (NoSuchMethodException | SecurityException unused2) {
                }
            }
        }
    }

    public static void writeMember(ObjectOutputStream objectOutputStream, Member member) throws IOException {
        if (member == null) {
            objectOutputStream.writeBoolean(false);
            return;
        }
        objectOutputStream.writeBoolean(true);
        boolean z = member instanceof Method;
        if (!z && !(member instanceof Constructor)) {
            throw new IllegalArgumentException("not Method or Constructor");
        }
        objectOutputStream.writeBoolean(z);
        objectOutputStream.writeObject(member.getName());
        objectOutputStream.writeObject(member.getDeclaringClass());
        if (z) {
            writeParameters(objectOutputStream, ((Method) member).getParameterTypes());
        } else {
            writeParameters(objectOutputStream, ((Constructor) member).getParameterTypes());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        writeMember(objectOutputStream, this.memberObject);
    }

    public static void writeParameters(ObjectOutputStream objectOutputStream, Class<?>[] clsArr) throws IOException {
        objectOutputStream.writeShort(clsArr.length);
        for (Class<?> cls : clsArr) {
            boolean isPrimitive = cls.isPrimitive();
            objectOutputStream.writeBoolean(isPrimitive);
            if (!isPrimitive) {
                objectOutputStream.writeObject(cls);
            } else {
                int i = 0;
                while (true) {
                    Class<?>[] clsArr2 = primitives;
                    if (i >= clsArr2.length) {
                        throw new IllegalArgumentException("Primitive " + cls + " not found");
                    } else if (cls.equals(clsArr2[i])) {
                        objectOutputStream.writeByte(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public Constructor<?> ctor() {
        return (Constructor) this.memberObject;
    }

    public Class<?> getDeclaringClass() {
        return this.memberObject.getDeclaringClass();
    }

    public String getName() {
        return this.memberObject.getName();
    }

    public Object invoke(Object obj, Object[] objArr) {
        Method method = method();
        try {
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                Method searchAccessibleMethod = searchAccessibleMethod(method, this.argTypes);
                if (searchAccessibleMethod != null) {
                    this.memberObject = searchAccessibleMethod;
                    method = searchAccessibleMethod;
                } else if (!VMBridge.instance.tryToMakeAccessible(method)) {
                    throw Context.throwAsScriptRuntimeEx(e);
                }
                return method.invoke(obj, objArr);
            }
        } catch (InvocationTargetException e2) {
            e = e2;
            do {
                e = ((InvocationTargetException) e).getTargetException();
            } while (e instanceof InvocationTargetException);
            if (!(e instanceof ContinuationPending)) {
                throw Context.throwAsScriptRuntimeEx(e);
            }
            throw ((ContinuationPending) e);
        } catch (Exception e3) {
            throw Context.throwAsScriptRuntimeEx(e3);
        }
    }

    public boolean isCtor() {
        return this.memberObject instanceof Constructor;
    }

    public boolean isMethod() {
        return this.memberObject instanceof Method;
    }

    public boolean isPublic() {
        return Modifier.isPublic(this.memberObject.getModifiers());
    }

    public boolean isStatic() {
        return Modifier.isStatic(this.memberObject.getModifiers());
    }

    public Member member() {
        return this.memberObject;
    }

    public Method method() {
        return (Method) this.memberObject;
    }

    public Object newInstance(Object[] objArr) {
        Constructor<?> ctor = ctor();
        try {
            try {
                return ctor.newInstance(objArr);
            } catch (IllegalAccessException e) {
                if (!VMBridge.instance.tryToMakeAccessible(ctor)) {
                    throw Context.throwAsScriptRuntimeEx(e);
                }
                return ctor.newInstance(objArr);
            }
        } catch (Exception e2) {
            throw Context.throwAsScriptRuntimeEx(e2);
        }
    }

    public String toJavaDeclaration() {
        String name;
        StringBuilder sb = new StringBuilder();
        if (isMethod()) {
            Method method = method();
            sb.append(method.getReturnType());
            sb.append(TokenParser.f4579SP);
            name = method.getName();
        } else {
            name = ctor().getDeclaringClass().getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                name = name.substring(lastIndexOf + 1);
            }
        }
        sb.append(name);
        sb.append(JavaMembers.liveConnectSignature(this.argTypes));
        return sb.toString();
    }

    public String toString() {
        return this.memberObject.toString();
    }
}
