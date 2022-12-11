package org.fourthline.cling.binding.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.binding.LocalServiceBinder;
import org.fourthline.cling.binding.LocalServiceBindingException;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.action.ActionExecutor;
import org.fourthline.cling.model.action.QueryStateVariableExecutor;
import org.fourthline.cling.model.meta.Action;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.meta.QueryStateVariableAction;
import org.fourthline.cling.model.meta.StateVariable;
import org.fourthline.cling.model.state.FieldStateVariableAccessor;
import org.fourthline.cling.model.state.GetterStateVariableAccessor;
import org.fourthline.cling.model.state.StateVariableAccessor;
import org.fourthline.cling.model.types.ServiceId;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.model.types.UDAServiceId;
import org.fourthline.cling.model.types.UDAServiceType;
import org.fourthline.cling.model.types.csv.CSV;
import org.seamless.util.Reflections;

/* loaded from: classes5.dex */
public class AnnotationLocalServiceBinder implements LocalServiceBinder {
    public static Logger log = Logger.getLogger(AnnotationLocalServiceBinder.class.getName());

    public static String toJavaActionName(String str) {
        if (str.length() >= 1) {
            return str.substring(0, 1).toLowerCase(Locale.ROOT) + str.substring(1);
        }
        throw new IllegalArgumentException("Variable name must be at least 1 character long");
    }

    public static String toJavaStateVariableName(String str) {
        if (str.length() >= 1) {
            return str.substring(0, 1).toLowerCase(Locale.ROOT) + str.substring(1);
        }
        throw new IllegalArgumentException("Variable name must be at least 1 character long");
    }

    public static String toUpnpActionName(String str) {
        if (str.length() >= 1) {
            return str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1);
        }
        throw new IllegalArgumentException("Action name must be at least 1 character long");
    }

    public static String toUpnpStateVariableName(String str) {
        if (str.length() >= 1) {
            return str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1);
        }
        throw new IllegalArgumentException("Variable name must be at least 1 character long");
    }

    public boolean isActionExcluded(Action action) {
        return false;
    }

    @Override // org.fourthline.cling.binding.LocalServiceBinder
    public LocalService read(Class<?> cls) throws LocalServiceBindingException {
        Logger logger = log;
        logger.fine("Reading and binding annotations of service implementation class: " + cls);
        if (cls.isAnnotationPresent(UpnpService.class)) {
            UpnpService upnpService = (UpnpService) cls.getAnnotation(UpnpService.class);
            UpnpServiceId serviceId = upnpService.serviceId();
            UpnpServiceType serviceType = upnpService.serviceType();
            return read(cls, serviceId.namespace().equals(UDAServiceId.DEFAULT_NAMESPACE) ? new UDAServiceId(serviceId.value()) : new ServiceId(serviceId.namespace(), serviceId.value()), serviceType.namespace().equals("schemas-upnp-org") ? new UDAServiceType(serviceType.value(), serviceType.version()) : new ServiceType(serviceType.namespace(), serviceType.value(), serviceType.version()), upnpService.supportsQueryStateVariables(), readStringConvertibleTypes(upnpService.stringConvertibleTypes()));
        }
        throw new LocalServiceBindingException("Given class is not an @UpnpService");
    }

    public LocalService read(Class<?> cls, ServiceId serviceId, ServiceType serviceType, boolean z, Set<Class> set) throws LocalServiceBindingException {
        Map<StateVariable, StateVariableAccessor> readStateVariables = readStateVariables(cls, set);
        Map<Action, ActionExecutor> readActions = readActions(cls, readStateVariables, set);
        if (z) {
            readActions.put(new QueryStateVariableAction(), new QueryStateVariableExecutor());
        }
        try {
            return new LocalService(serviceType, serviceId, readActions, readStateVariables, set, z);
        } catch (ValidationException e) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not validate device model: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
            logger.severe(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            for (ValidationError validationError : e.getErrors()) {
                log.severe(validationError.toString());
            }
            throw new LocalServiceBindingException("Validation of model failed, check the log");
        }
    }

    @Override // org.fourthline.cling.binding.LocalServiceBinder
    public LocalService read(Class<?> cls, ServiceId serviceId, ServiceType serviceType, boolean z, Class[] clsArr) throws LocalServiceBindingException {
        return read(cls, serviceId, serviceType, z, new HashSet(Arrays.asList(clsArr)));
    }

    public Map<Action, ActionExecutor> readActions(Class<?> cls, Map<StateVariable, StateVariableAccessor> map, Set<Class> set) throws LocalServiceBindingException {
        HashMap hashMap = new HashMap();
        for (Method method : Reflections.getMethods(cls, UpnpAction.class)) {
            Action appendAction = new AnnotationActionBinder(method, map, set).appendAction(hashMap);
            if (isActionExcluded(appendAction)) {
                hashMap.remove(appendAction);
            }
        }
        return hashMap;
    }

    public Map<StateVariable, StateVariableAccessor> readStateVariables(Class<?> cls, Set<Class> set) throws LocalServiceBindingException {
        UpnpStateVariable[] value;
        HashMap hashMap = new HashMap();
        if (cls.isAnnotationPresent(UpnpStateVariables.class)) {
            UpnpStateVariables upnpStateVariables = (UpnpStateVariables) cls.getAnnotation(UpnpStateVariables.class);
            for (UpnpStateVariable upnpStateVariable : upnpStateVariables.value()) {
                if (upnpStateVariable.name().length() == 0) {
                    throw new LocalServiceBindingException("Class-level @UpnpStateVariable name attribute value required");
                }
                String javaStateVariableName = toJavaStateVariableName(upnpStateVariable.name());
                Method getterMethod = Reflections.getGetterMethod(cls, javaStateVariableName);
                Field field = Reflections.getField(cls, javaStateVariableName);
                StateVariableAccessor stateVariableAccessor = null;
                if (getterMethod != null && field != null) {
                    stateVariableAccessor = upnpStateVariables.preferFields() ? new FieldStateVariableAccessor(field) : new GetterStateVariableAccessor(getterMethod);
                } else if (field != null) {
                    stateVariableAccessor = new FieldStateVariableAccessor(field);
                } else if (getterMethod != null) {
                    stateVariableAccessor = new GetterStateVariableAccessor(getterMethod);
                } else {
                    Logger logger = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No field or getter found for state variable, skipping accessor: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(upnpStateVariable.name());
                    logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                hashMap.put(new AnnotationStateVariableBinder(upnpStateVariable, upnpStateVariable.name(), stateVariableAccessor, set).createStateVariable(), stateVariableAccessor);
            }
        }
        for (Field field2 : Reflections.getFields(cls, UpnpStateVariable.class)) {
            UpnpStateVariable upnpStateVariable2 = (UpnpStateVariable) field2.getAnnotation(UpnpStateVariable.class);
            FieldStateVariableAccessor fieldStateVariableAccessor = new FieldStateVariableAccessor(field2);
            hashMap.put(new AnnotationStateVariableBinder(upnpStateVariable2, upnpStateVariable2.name().length() == 0 ? toUpnpStateVariableName(field2.getName()) : upnpStateVariable2.name(), fieldStateVariableAccessor, set).createStateVariable(), fieldStateVariableAccessor);
        }
        for (Method method : Reflections.getMethods(cls, UpnpStateVariable.class)) {
            String methodPropertyName = Reflections.getMethodPropertyName(method.getName());
            if (methodPropertyName == null) {
                throw new LocalServiceBindingException("Annotated method is not a getter method (: " + method);
            } else if (method.getParameterTypes().length > 0) {
                throw new LocalServiceBindingException("Getter method defined as @UpnpStateVariable can not have parameters: " + method);
            } else {
                UpnpStateVariable upnpStateVariable3 = (UpnpStateVariable) method.getAnnotation(UpnpStateVariable.class);
                GetterStateVariableAccessor getterStateVariableAccessor = new GetterStateVariableAccessor(method);
                hashMap.put(new AnnotationStateVariableBinder(upnpStateVariable3, upnpStateVariable3.name().length() == 0 ? toUpnpStateVariableName(methodPropertyName) : upnpStateVariable3.name(), getterStateVariableAccessor, set).createStateVariable(), getterStateVariableAccessor);
            }
        }
        return hashMap;
    }

    public Set<Class> readStringConvertibleTypes(Class[] clsArr) throws LocalServiceBindingException {
        for (Class cls : clsArr) {
            if (!Modifier.isPublic(cls.getModifiers())) {
                throw new LocalServiceBindingException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Declared string-convertible type must be public: ", cls));
            }
            try {
                cls.getConstructor(String.class);
            } catch (NoSuchMethodException unused) {
                throw new LocalServiceBindingException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Declared string-convertible type needs a public single-argument String constructor: ", cls));
            }
        }
        HashSet hashSet = new HashSet(Arrays.asList(clsArr));
        hashSet.add(URI.class);
        hashSet.add(URL.class);
        hashSet.add(CSV.class);
        return hashSet;
    }
}
