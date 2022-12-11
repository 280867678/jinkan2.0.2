package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes4.dex */
public class SerializationUtils {

    /* loaded from: classes4.dex */
    public static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        public static final Map<String, Class<?>> primitiveTypes = new HashMap();
        public final ClassLoader classLoader;

        public ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws IOException {
            super(inputStream);
            this.classLoader = classLoader;
            primitiveTypes.put(ClassTransform.BYTE, Byte.TYPE);
            primitiveTypes.put(ClassTransform.SHORT, Short.TYPE);
            primitiveTypes.put(ClassTransform.INTEGER, Integer.TYPE);
            primitiveTypes.put(ClassTransform.LONG, Long.TYPE);
            primitiveTypes.put(ClassTransform.FLOAT, Float.TYPE);
            primitiveTypes.put(ClassTransform.DOUBLE, Double.TYPE);
            primitiveTypes.put(ClassTransform.BOOLEAN, Boolean.TYPE);
            primitiveTypes.put(ClassTransform.CHARACTER, Character.TYPE);
            primitiveTypes.put(ClassTransform.VOID, Void.TYPE);
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, this.classLoader);
                } catch (ClassNotFoundException e) {
                    Class<?> cls = primitiveTypes.get(name);
                    if (cls == null) {
                        throw e;
                    }
                    return cls;
                }
            } catch (ClassNotFoundException unused) {
                return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
            }
        }
    }

    public static <T extends Serializable> T clone(T t) {
        ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream;
        ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream2 = null;
        if (t == null) {
            return null;
        }
        try {
            try {
                classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t)), t.getClass().getClassLoader());
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (ClassNotFoundException e2) {
            e = e2;
        }
        try {
            T t2 = (T) classLoaderAwareObjectInputStream.readObject();
            try {
                classLoaderAwareObjectInputStream.close();
                return t2;
            } catch (IOException e3) {
                throw new SerializationException("IOException on closing cloned object data InputStream.", e3);
            }
        } catch (IOException e4) {
            e = e4;
            throw new SerializationException("IOException while reading cloned object data", e);
        } catch (ClassNotFoundException e5) {
            e = e5;
            throw new SerializationException("ClassNotFoundException while reading cloned object data", e);
        } catch (Throwable th2) {
            th = th2;
            classLoaderAwareObjectInputStream2 = classLoaderAwareObjectInputStream;
            if (classLoaderAwareObjectInputStream2 != null) {
                try {
                    classLoaderAwareObjectInputStream2.close();
                } catch (IOException e6) {
                    throw new SerializationException("IOException on closing cloned object data InputStream.", e6);
                }
            }
            throw th;
        }
    }

    public static <T> T deserialize(InputStream inputStream) {
        ObjectInputStream objectInputStream;
        if (inputStream != null) {
            ObjectInputStream objectInputStream2 = null;
            try {
                try {
                    objectInputStream = new ObjectInputStream(inputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            } catch (ClassCastException e2) {
                e = e2;
            } catch (ClassNotFoundException e3) {
                e = e3;
            }
            try {
                T t = (T) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (IOException unused) {
                }
                return t;
            } catch (IOException e4) {
                e = e4;
                throw new SerializationException(e);
            } catch (ClassCastException e5) {
                e = e5;
                throw new SerializationException(e);
            } catch (ClassNotFoundException e6) {
                e = e6;
                throw new SerializationException(e);
            } catch (Throwable th2) {
                th = th2;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("The InputStream must not be null");
    }

    public static <T> T deserialize(byte[] bArr) {
        if (bArr != null) {
            return (T) deserialize(new ByteArrayInputStream(bArr));
        }
        throw new IllegalArgumentException("The byte[] must not be null");
    }

    public static <T extends Serializable> T roundtrip(T t) {
        return (T) deserialize(serialize(t));
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        ObjectOutputStream objectOutputStream;
        if (outputStream != null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(outputStream);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(serializable);
                try {
                    objectOutputStream.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            } catch (IOException e2) {
                e = e2;
                objectOutputStream2 = objectOutputStream;
                throw new SerializationException(e);
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("The OutputStream must not be null");
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
