package org.fourthline.cling.binding.xml;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.binding.staging.MutableAction;
import org.fourthline.cling.binding.staging.MutableActionArgument;
import org.fourthline.cling.binding.staging.MutableAllowedValueRange;
import org.fourthline.cling.binding.staging.MutableService;
import org.fourthline.cling.binding.staging.MutableStateVariable;
import org.fourthline.cling.binding.xml.Descriptor;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.ActionArgument;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.meta.StateVariableEventDetails;
import org.fourthline.cling.model.types.CustomDatatype;
import org.fourthline.cling.model.types.Datatype;
import org.seamless.xml.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class UDA10ServiceDescriptorBinderSAXImpl extends UDA10ServiceDescriptorBinderImpl {
    public static Logger log = Logger.getLogger(ServiceDescriptorBinder.class.getName());

    /* renamed from: org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C30391 {

        /* renamed from: $SwitchMap$org$fourthline$cling$binding$xml$Descriptor$Service$ELEMENT */
        public static final /* synthetic */ int[] f4608x632136c5;

        static {
            int[] iArr = new int[Descriptor.Service.ELEMENT.values().length];
            f4608x632136c5 = iArr;
            try {
                Descriptor.Service.ELEMENT element = Descriptor.Service.ELEMENT.name;
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f4608x632136c5;
                Descriptor.Service.ELEMENT element2 = Descriptor.Service.ELEMENT.direction;
                iArr2[9] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f4608x632136c5;
                Descriptor.Service.ELEMENT element3 = Descriptor.Service.ELEMENT.relatedStateVariable;
                iArr3[10] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f4608x632136c5;
                Descriptor.Service.ELEMENT element4 = Descriptor.Service.ELEMENT.retval;
                iArr4[11] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f4608x632136c5;
                Descriptor.Service.ELEMENT element5 = Descriptor.Service.ELEMENT.dataType;
                iArr5[14] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f4608x632136c5;
                Descriptor.Service.ELEMENT element6 = Descriptor.Service.ELEMENT.defaultValue;
                iArr6[15] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f4608x632136c5;
                Descriptor.Service.ELEMENT element7 = Descriptor.Service.ELEMENT.allowedValue;
                iArr7[17] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = f4608x632136c5;
                Descriptor.Service.ELEMENT element8 = Descriptor.Service.ELEMENT.minimum;
                iArr8[19] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = f4608x632136c5;
                Descriptor.Service.ELEMENT element9 = Descriptor.Service.ELEMENT.maximum;
                iArr9[20] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = f4608x632136c5;
                Descriptor.Service.ELEMENT element10 = Descriptor.Service.ELEMENT.step;
                iArr10[21] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ActionArgumentHandler extends ServiceDescriptorHandler<MutableActionArgument> {

        /* renamed from: EL */
        public static final Descriptor.Service.ELEMENT f4609EL = Descriptor.Service.ELEMENT.argument;

        public ActionArgumentHandler(MutableActionArgument mutableActionArgument, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(mutableActionArgument, serviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void endElement(Descriptor.Service.ELEMENT element) throws SAXException {
            int ordinal = element.ordinal();
            if (ordinal == 6) {
                getInstance().name = getCharacters();
                return;
            }
            switch (ordinal) {
                case 9:
                    String characters = getCharacters();
                    try {
                        getInstance().direction = ActionArgument.Direction.valueOf(characters.toUpperCase(Locale.ROOT));
                        return;
                    } catch (IllegalArgumentException unused) {
                        Logger logger = UDA10ServiceDescriptorBinderSAXImpl.log;
                        logger.warning("UPnP specification violation: Invalid action argument direction, assuming 'IN': " + characters);
                        getInstance().direction = ActionArgument.Direction.IN;
                        return;
                    }
                case 10:
                    getInstance().relatedStateVariable = getCharacters();
                    return;
                case 11:
                    getInstance().retval = true;
                    return;
                default:
                    return;
            }
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return element.equals(f4609EL);
        }
    }

    /* loaded from: classes5.dex */
    public static class ActionArgumentListHandler extends ServiceDescriptorHandler<List<MutableActionArgument>> {

        /* renamed from: EL */
        public static final Descriptor.Service.ELEMENT f4610EL = Descriptor.Service.ELEMENT.argumentList;

        public ActionArgumentListHandler(List<MutableActionArgument> list, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(list, serviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return element.equals(f4610EL);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void startElement(Descriptor.Service.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(ActionArgumentHandler.f4609EL)) {
                MutableActionArgument mutableActionArgument = new MutableActionArgument();
                getInstance().add(mutableActionArgument);
                new ActionArgumentHandler(mutableActionArgument, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ActionHandler extends ServiceDescriptorHandler<MutableAction> {

        /* renamed from: EL */
        public static final Descriptor.Service.ELEMENT f4611EL = Descriptor.Service.ELEMENT.action;

        public ActionHandler(MutableAction mutableAction, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(mutableAction, serviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void endElement(Descriptor.Service.ELEMENT element) throws SAXException {
            if (element.ordinal() != 6) {
                return;
            }
            getInstance().name = getCharacters();
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return element.equals(f4611EL);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void startElement(Descriptor.Service.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(ActionArgumentListHandler.f4610EL)) {
                ArrayList arrayList = new ArrayList();
                getInstance().arguments = arrayList;
                new ActionArgumentListHandler(arrayList, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ActionListHandler extends ServiceDescriptorHandler<List<MutableAction>> {

        /* renamed from: EL */
        public static final Descriptor.Service.ELEMENT f4612EL = Descriptor.Service.ELEMENT.actionList;

        public ActionListHandler(List<MutableAction> list, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(list, serviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return element.equals(f4612EL);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void startElement(Descriptor.Service.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(ActionHandler.f4611EL)) {
                MutableAction mutableAction = new MutableAction();
                getInstance().add(mutableAction);
                new ActionHandler(mutableAction, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class AllowedValueListHandler extends ServiceDescriptorHandler<List<String>> {

        /* renamed from: EL */
        public static final Descriptor.Service.ELEMENT f4613EL = Descriptor.Service.ELEMENT.allowedValueList;

        public AllowedValueListHandler(List<String> list, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(list, serviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void endElement(Descriptor.Service.ELEMENT element) throws SAXException {
            if (element.ordinal() != 17) {
                return;
            }
            getInstance().add(getCharacters());
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return element.equals(f4613EL);
        }
    }

    /* loaded from: classes5.dex */
    public static class AllowedValueRangeHandler extends ServiceDescriptorHandler<MutableAllowedValueRange> {

        /* renamed from: EL */
        public static final Descriptor.Service.ELEMENT f4614EL = Descriptor.Service.ELEMENT.allowedValueRange;

        public AllowedValueRangeHandler(MutableAllowedValueRange mutableAllowedValueRange, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(mutableAllowedValueRange, serviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void endElement(Descriptor.Service.ELEMENT element) throws SAXException {
            try {
                switch (element.ordinal()) {
                    case 19:
                        getInstance().minimum = Long.valueOf(getCharacters());
                        break;
                    case 20:
                        getInstance().maximum = Long.valueOf(getCharacters());
                        break;
                    case 21:
                        getInstance().step = Long.valueOf(getCharacters());
                        break;
                }
            } catch (Exception unused) {
            }
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return element.equals(f4614EL);
        }
    }

    /* loaded from: classes5.dex */
    public static class RootHandler extends ServiceDescriptorHandler<MutableService> {
        public RootHandler(MutableService mutableService, SAXParser sAXParser) {
            super(mutableService, sAXParser);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void startElement(Descriptor.Service.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(ActionListHandler.f4612EL)) {
                ArrayList arrayList = new ArrayList();
                getInstance().actions = arrayList;
                new ActionListHandler(arrayList, this);
            }
            if (element.equals(StateVariableListHandler.f4616EL)) {
                ArrayList arrayList2 = new ArrayList();
                getInstance().stateVariables = arrayList2;
                new StateVariableListHandler(arrayList2, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ServiceDescriptorHandler<I> extends SAXParser.Handler<I> {
        public ServiceDescriptorHandler(I i) {
            super(i);
        }

        public ServiceDescriptorHandler(I i, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(i, serviceDescriptorHandler);
        }

        public ServiceDescriptorHandler(I i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        public ServiceDescriptorHandler(I i, SAXParser sAXParser, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(i, sAXParser, serviceDescriptorHandler);
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            super.endElement(str, str2, str3);
            Descriptor.Service.ELEMENT valueOrNullOf = Descriptor.Service.ELEMENT.valueOrNullOf(str2);
            if (valueOrNullOf == null) {
                return;
            }
            endElement(valueOrNullOf);
        }

        public void endElement(Descriptor.Service.ELEMENT element) throws SAXException {
        }

        @Override // org.seamless.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            Descriptor.Service.ELEMENT valueOrNullOf = Descriptor.Service.ELEMENT.valueOrNullOf(str2);
            return valueOrNullOf != null && isLastElement(valueOrNullOf);
        }

        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return false;
        }

        @Override // org.seamless.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            super.startElement(str, str2, str3, attributes);
            Descriptor.Service.ELEMENT valueOrNullOf = Descriptor.Service.ELEMENT.valueOrNullOf(str2);
            if (valueOrNullOf == null) {
                return;
            }
            startElement(valueOrNullOf, attributes);
        }

        public void startElement(Descriptor.Service.ELEMENT element, Attributes attributes) throws SAXException {
        }
    }

    /* loaded from: classes5.dex */
    public static class StateVariableHandler extends ServiceDescriptorHandler<MutableStateVariable> {

        /* renamed from: EL */
        public static final Descriptor.Service.ELEMENT f4615EL = Descriptor.Service.ELEMENT.stateVariable;

        public StateVariableHandler(MutableStateVariable mutableStateVariable, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(mutableStateVariable, serviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void endElement(Descriptor.Service.ELEMENT element) throws SAXException {
            int ordinal = element.ordinal();
            if (ordinal == 6) {
                getInstance().name = getCharacters();
            } else if (ordinal != 14) {
                if (ordinal != 15) {
                    return;
                }
                getInstance().defaultValue = getCharacters();
            } else {
                String characters = getCharacters();
                Datatype.Builtin byDescriptorName = Datatype.Builtin.getByDescriptorName(characters);
                getInstance().dataType = byDescriptorName != null ? byDescriptorName.getDatatype() : new CustomDatatype(characters);
            }
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return element.equals(f4615EL);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void startElement(Descriptor.Service.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(AllowedValueListHandler.f4613EL)) {
                ArrayList arrayList = new ArrayList();
                getInstance().allowedValues = arrayList;
                new AllowedValueListHandler(arrayList, this);
            }
            if (element.equals(AllowedValueRangeHandler.f4614EL)) {
                MutableAllowedValueRange mutableAllowedValueRange = new MutableAllowedValueRange();
                getInstance().allowedValueRange = mutableAllowedValueRange;
                new AllowedValueRangeHandler(mutableAllowedValueRange, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class StateVariableListHandler extends ServiceDescriptorHandler<List<MutableStateVariable>> {

        /* renamed from: EL */
        public static final Descriptor.Service.ELEMENT f4616EL = Descriptor.Service.ELEMENT.serviceStateTable;

        public StateVariableListHandler(List<MutableStateVariable> list, ServiceDescriptorHandler serviceDescriptorHandler) {
            super(list, serviceDescriptorHandler);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public boolean isLastElement(Descriptor.Service.ELEMENT element) {
            return element.equals(f4616EL);
        }

        @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderSAXImpl.ServiceDescriptorHandler
        public void startElement(Descriptor.Service.ELEMENT element, Attributes attributes) throws SAXException {
            if (element.equals(StateVariableHandler.f4615EL)) {
                MutableStateVariable mutableStateVariable = new MutableStateVariable();
                Descriptor.Service.ATTRIBUTE attribute = Descriptor.Service.ATTRIBUTE.sendEvents;
                String value = attributes.getValue("sendEvents");
                mutableStateVariable.eventDetails = new StateVariableEventDetails(value != null && value.toUpperCase(Locale.ROOT).equals("YES"));
                getInstance().add(mutableStateVariable);
                new StateVariableHandler(mutableStateVariable, this);
            }
        }
    }

    @Override // org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderImpl, org.fourthline.cling.binding.xml.ServiceDescriptorBinder
    public <S extends Service> S describe(S s, String str) throws DescriptorBindingException, ValidationException {
        if (str == null || str.length() == 0) {
            throw new DescriptorBindingException("Null or empty descriptor");
        }
        try {
            log.fine("Reading service from XML descriptor");
            SAXParser sAXParser = new SAXParser();
            MutableService mutableService = new MutableService();
            hydrateBasic(mutableService, s);
            new RootHandler(mutableService, sAXParser);
            sAXParser.parse(new InputSource(new StringReader(str.trim())));
            return (S) mutableService.build(s.getDevice());
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse service descriptor: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.toString());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e2);
        }
    }
}
