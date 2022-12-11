package org.seamless.statemachine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class StateMachineInvocationHandler implements InvocationHandler {
    public static final String METHOD_ON_ENTRY = "onEntry";
    public static final String METHOD_ON_EXIT = "onExit";
    public static Logger log = Logger.getLogger(StateMachineInvocationHandler.class.getName());
    public Object currentState;
    public final Class initialStateClass;
    public final Map<Class, Object> stateObjects = new ConcurrentHashMap();

    public StateMachineInvocationHandler(List<Class<?>> list, Class<?> cls, Class[] clsArr, Object[] objArr) {
        Object newInstance;
        Logger logger = log;
        logger.fine("Creating state machine with initial state: " + cls);
        this.initialStateClass = cls;
        for (Class<?> cls2 : list) {
            if (clsArr != null) {
                try {
                    newInstance = cls2.getConstructor(clsArr).newInstance(objArr);
                    continue;
                } catch (NoSuchMethodException e) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("State ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls2.getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" has the wrong constructor: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e);
                    throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
                } catch (Exception e2) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("State ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls2.getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" can't be instantiated: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e2);
                    throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), e2);
                }
            } else {
                newInstance = cls2.newInstance();
                continue;
            }
            Logger logger2 = log;
            logger2.fine("Adding state instance: " + newInstance.getClass().getName());
            this.stateObjects.put(cls2, newInstance);
        }
        if (this.stateObjects.containsKey(cls)) {
            this.currentState = this.stateObjects.get(cls);
            synchronized (this) {
                invokeEntryMethod(this.currentState);
            }
            return;
        }
        throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Initial state not in list of states: ", (Class) cls));
    }

    private Method getMethodOfCurrentState(Method method) {
        try {
            return this.currentState.getClass().getMethod(method.getName(), method.getParameterTypes());
        } catch (NoSuchMethodException unused) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("State '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.currentState.getClass().getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' doesn't support signal '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(method.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
            throw new TransitionException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    private void invokeEntryMethod(Object obj) {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Trying to invoke entry method of state: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass().getName());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        try {
            obj.getClass().getMethod(METHOD_ON_ENTRY, new Class[0]).invoke(obj, new Object[0]);
        } catch (NoSuchMethodException unused) {
            Logger logger2 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No entry method found on state: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(obj.getClass().getName());
            logger2.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("State '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(obj.getClass().getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("' entry method threw exception: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(e);
            throw new TransitionException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), e);
        }
    }

    private void invokeExitMethod(Object obj) {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Trying to invoking exit method of state: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass().getName());
        logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        try {
            obj.getClass().getMethod(METHOD_ON_EXIT, new Class[0]).invoke(obj, new Object[0]);
        } catch (NoSuchMethodException unused) {
            Logger logger2 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No exit method found on state: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(obj.getClass().getName());
            logger2.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("State '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(obj.getClass().getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("' exit method threw exception: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(e);
            throw new TransitionException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), e);
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        synchronized (this) {
            if (StateMachine.METHOD_CURRENT_STATE.equals(method.getName()) && method.getParameterTypes().length == 0) {
                return this.currentState;
            } else if (StateMachine.METHOD_FORCE_STATE.equals(method.getName()) && method.getParameterTypes().length == 1 && objArr.length == 1 && objArr[0] != null && (objArr[0] instanceof Class)) {
                Object obj2 = this.stateObjects.get((Class) objArr[0]);
                if (obj2 == null) {
                    throw new TransitionException("Can't force to invalid state: " + objArr[0]);
                }
                Logger logger = log;
                logger.finer("Forcing state machine into state: " + obj2.getClass().getName());
                invokeExitMethod(this.currentState);
                this.currentState = obj2;
                invokeEntryMethod(obj2);
                return null;
            } else {
                Method methodOfCurrentState = getMethodOfCurrentState(method);
                Logger logger2 = log;
                logger2.fine("Invoking signal method of current state: " + methodOfCurrentState.toString());
                Object invoke = methodOfCurrentState.invoke(this.currentState, objArr);
                if (invoke != null && (invoke instanceof Class)) {
                    Class cls = (Class) invoke;
                    if (this.stateObjects.containsKey(cls)) {
                        Logger logger3 = log;
                        logger3.fine("Executing transition to next state: " + cls.getName());
                        invokeExitMethod(this.currentState);
                        Object obj3 = this.stateObjects.get(cls);
                        this.currentState = obj3;
                        invokeEntryMethod(obj3);
                    }
                }
                return invoke;
            }
        }
    }
}
