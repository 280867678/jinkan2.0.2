package org.fourthline.cling.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.meta.StateVariable;
import org.fourthline.cling.model.state.StateVariableAccessor;
import org.fourthline.cling.model.state.StateVariableValue;
import org.seamless.util.Exceptions;
import org.seamless.util.Reflections;

/* loaded from: classes5.dex */
public class DefaultServiceManager<T> implements ServiceManager<T> {
    public static Logger log = Logger.getLogger(DefaultServiceManager.class.getName());
    public final ReentrantLock lock;
    public PropertyChangeSupport propertyChangeSupport;
    public final LocalService<T> service;
    public final Class<T> serviceClass;
    public T serviceImpl;

    /* loaded from: classes5.dex */
    public class DefaultPropertyChangeListener implements PropertyChangeListener {
        public DefaultPropertyChangeListener() {
        }

        @Override // java.beans.PropertyChangeListener
        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            Logger logger = DefaultServiceManager.log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Property change event on local service: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(propertyChangeEvent.getPropertyName());
            logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            if (propertyChangeEvent.getPropertyName().equals(ServiceManager.EVENTED_STATE_VARIABLES)) {
                return;
            }
            String[] fromCommaSeparatedList = ModelUtil.fromCommaSeparatedList(propertyChangeEvent.getPropertyName());
            Logger logger2 = DefaultServiceManager.log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Changed variable names: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Arrays.toString(fromCommaSeparatedList));
            logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            try {
                Collection<StateVariableValue> currentState = DefaultServiceManager.this.getCurrentState(fromCommaSeparatedList);
                if (currentState.isEmpty()) {
                    return;
                }
                DefaultServiceManager.this.getPropertyChangeSupport().firePropertyChange(ServiceManager.EVENTED_STATE_VARIABLES, (Object) null, currentState);
            } catch (Exception e) {
                Logger logger3 = DefaultServiceManager.log;
                Level level = Level.SEVERE;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error reading state of service after state variable update event: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Exceptions.unwrap(e));
                logger3.log(level, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), (Throwable) e);
            }
        }
    }

    public DefaultServiceManager(LocalService<T> localService) {
        this(localService, null);
    }

    public DefaultServiceManager(LocalService<T> localService, Class<T> cls) {
        this.lock = new ReentrantLock(true);
        this.service = localService;
        this.serviceClass = cls;
    }

    public PropertyChangeListener createPropertyChangeListener(T t) throws Exception {
        return new DefaultPropertyChangeListener();
    }

    public PropertyChangeSupport createPropertyChangeSupport(T t) throws Exception {
        Method getterMethod = Reflections.getGetterMethod(t.getClass(), "propertyChangeSupport");
        if (getterMethod == null || !PropertyChangeSupport.class.isAssignableFrom(getterMethod.getReturnType())) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Creating new PropertyChangeSupport for service implementation: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(t.getClass().getName());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return new PropertyChangeSupport(t);
        }
        Logger logger2 = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Service implementation instance offers PropertyChangeSupport, using that: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(t.getClass().getName());
        logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        return (PropertyChangeSupport) getterMethod.invoke(t, new Object[0]);
    }

    public T createServiceInstance() throws Exception {
        Class<T> cls = this.serviceClass;
        if (cls != null) {
            try {
                return cls.getConstructor(LocalService.class).newInstance(getService());
            } catch (NoSuchMethodException unused) {
                Logger logger = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Creating new service implementation instance with no-arg constructor: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.serviceClass.getName());
                logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return this.serviceClass.newInstance();
            }
        }
        throw new IllegalStateException("Subclass has to provide service class or override createServiceInstance()");
    }

    @Override // org.fourthline.cling.model.ServiceManager
    public void execute(Command<T> command) throws Exception {
        lock();
        try {
            command.execute(this);
        } finally {
            unlock();
        }
    }

    @Override // org.fourthline.cling.model.ServiceManager
    public Collection<StateVariableValue> getCurrentState() throws Exception {
        StateVariable<LocalService>[] stateVariables;
        lock();
        try {
            Collection<StateVariableValue> readInitialEventedStateVariableValues = readInitialEventedStateVariableValues();
            if (readInitialEventedStateVariableValues != null) {
                log.fine("Obtained initial state variable values for event, skipping individual state variable accessors");
                return readInitialEventedStateVariableValues;
            }
            ArrayList arrayList = new ArrayList();
            for (StateVariable<LocalService> stateVariable : getService().getStateVariables()) {
                if (stateVariable.getEventDetails().isSendEvents()) {
                    StateVariableAccessor accessor = getService().getAccessor(stateVariable);
                    if (accessor == null) {
                        throw new IllegalStateException("No accessor for evented state variable");
                    }
                    arrayList.add(accessor.read(stateVariable, getImplementation()));
                }
            }
            return arrayList;
        } finally {
            unlock();
        }
    }

    public Collection<StateVariableValue> getCurrentState(String[] strArr) throws Exception {
        lock();
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                String trim = str.trim();
                StateVariable<LocalService> stateVariable = getService().getStateVariable(trim);
                if (stateVariable != null && stateVariable.getEventDetails().isSendEvents()) {
                    StateVariableAccessor accessor = getService().getAccessor(stateVariable);
                    if (accessor == null) {
                        log.warning("Ignoring evented state variable without accessor: " + trim);
                    } else {
                        arrayList.add(accessor.read(stateVariable, getImplementation()));
                    }
                }
                log.fine("Ignoring unknown or non-evented state variable: " + trim);
            }
            return arrayList;
        } finally {
            unlock();
        }
    }

    @Override // org.fourthline.cling.model.ServiceManager
    public T getImplementation() {
        lock();
        try {
            if (this.serviceImpl == null) {
                init();
            }
            return this.serviceImpl;
        } finally {
            unlock();
        }
    }

    public int getLockTimeoutMillis() {
        return 500;
    }

    @Override // org.fourthline.cling.model.ServiceManager
    public PropertyChangeSupport getPropertyChangeSupport() {
        lock();
        try {
            if (this.propertyChangeSupport == null) {
                init();
            }
            return this.propertyChangeSupport;
        } finally {
            unlock();
        }
    }

    @Override // org.fourthline.cling.model.ServiceManager
    public LocalService<T> getService() {
        return this.service;
    }

    public void init() {
        log.fine("No service implementation instance available, initializing...");
        try {
            T createServiceInstance = createServiceInstance();
            this.serviceImpl = createServiceInstance;
            PropertyChangeSupport createPropertyChangeSupport = createPropertyChangeSupport(createServiceInstance);
            this.propertyChangeSupport = createPropertyChangeSupport;
            createPropertyChangeSupport.addPropertyChangeListener(createPropertyChangeListener(this.serviceImpl));
        } catch (Exception e) {
            throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not initialize implementation: ", e), e);
        }
    }

    public void lock() {
        try {
            if (this.lock.tryLock(getLockTimeoutMillis(), TimeUnit.MILLISECONDS)) {
                if (!log.isLoggable(Level.FINEST)) {
                    return;
                }
                log.finest("Acquired lock");
                return;
            }
            throw new RuntimeException("Failed to acquire lock in milliseconds: " + getLockTimeoutMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to acquire lock:" + e);
        }
    }

    public Collection<StateVariableValue> readInitialEventedStateVariableValues() throws Exception {
        return null;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") Implementation: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.serviceImpl);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public void unlock() {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("Releasing lock");
        }
        this.lock.unlock();
    }
}
