package org.fourthline.cling.binding.xml;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import me.tvspark.outline;
import org.fourthline.cling.binding.staging.MutableAction;
import org.fourthline.cling.binding.staging.MutableActionArgument;
import org.fourthline.cling.binding.staging.MutableAllowedValueRange;
import org.fourthline.cling.binding.staging.MutableService;
import org.fourthline.cling.binding.staging.MutableStateVariable;
import org.fourthline.cling.binding.xml.Descriptor;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.XMLUtil;
import org.fourthline.cling.model.meta.Action;
import org.fourthline.cling.model.meta.ActionArgument;
import org.fourthline.cling.model.meta.QueryStateVariableAction;
import org.fourthline.cling.model.meta.RemoteService;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.meta.StateVariable;
import org.fourthline.cling.model.meta.StateVariableEventDetails;
import org.fourthline.cling.model.types.CustomDatatype;
import org.fourthline.cling.model.types.Datatype;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class UDA10ServiceDescriptorBinderImpl implements ServiceDescriptorBinder, ErrorHandler {
    public static Logger log = Logger.getLogger(ServiceDescriptorBinder.class.getName());

    private void generateAction(Action action, Document document, Element element) {
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Service.ELEMENT.action);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Service.ELEMENT.name, action.getName());
        if (action.hasArguments()) {
            Element appendNewElement2 = XMLUtil.appendNewElement(document, appendNewElement, Descriptor.Service.ELEMENT.argumentList);
            for (ActionArgument actionArgument : action.getArguments()) {
                generateActionArgument(actionArgument, document, appendNewElement2);
            }
        }
    }

    private void generateActionArgument(ActionArgument actionArgument, Document document, Element element) {
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Service.ELEMENT.argument);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Service.ELEMENT.name, actionArgument.getName());
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Service.ELEMENT.direction, actionArgument.getDirection().toString().toLowerCase(Locale.ROOT));
        if (actionArgument.isReturnValue()) {
            Logger logger = log;
            logger.warning("UPnP specification violation: Not producing <retval> element to be compatible with WMP12: " + actionArgument);
        }
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Service.ELEMENT.relatedStateVariable, actionArgument.getRelatedStateVariableName());
    }

    private void generateActionList(Service service, Document document, Element element) {
        Action[] actions;
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Service.ELEMENT.actionList);
        for (Action action : service.getActions()) {
            if (!action.getName().equals(QueryStateVariableAction.ACTION_NAME)) {
                generateAction(action, document, appendNewElement);
            }
        }
    }

    private void generateScpd(Service service, Document document) {
        Descriptor.Service.ELEMENT element = Descriptor.Service.ELEMENT.scpd;
        Element createElementNS = document.createElementNS(Descriptor.Service.NAMESPACE_URI, "scpd");
        document.appendChild(createElementNS);
        generateSpecVersion(service, document, createElementNS);
        if (service.hasActions()) {
            generateActionList(service, document, createElementNS);
        }
        generateServiceStateTable(service, document, createElementNS);
    }

    private void generateServiceStateTable(Service service, Document document, Element element) {
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Service.ELEMENT.serviceStateTable);
        for (StateVariable stateVariable : service.getStateVariables()) {
            generateStateVariable(stateVariable, document, appendNewElement);
        }
    }

    private void generateSpecVersion(Service service, Document document, Element element) {
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Service.ELEMENT.specVersion);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Service.ELEMENT.major, Integer.valueOf(service.getDevice().getVersion().getMajor()));
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Service.ELEMENT.minor, Integer.valueOf(service.getDevice().getVersion().getMinor()));
    }

    private void generateStateVariable(StateVariable stateVariable, Document document, Element element) {
        Descriptor.Service.ELEMENT element2;
        String descriptorName;
        String str;
        Element appendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Service.ELEMENT.stateVariable);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Service.ELEMENT.name, stateVariable.getName());
        if (stateVariable.getTypeDetails().getDatatype() instanceof CustomDatatype) {
            element2 = Descriptor.Service.ELEMENT.dataType;
            descriptorName = ((CustomDatatype) stateVariable.getTypeDetails().getDatatype()).getName();
        } else {
            element2 = Descriptor.Service.ELEMENT.dataType;
            descriptorName = stateVariable.getTypeDetails().getDatatype().getBuiltin().getDescriptorName();
        }
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, element2, descriptorName);
        XMLUtil.appendNewElementIfNotNull(document, appendNewElement, Descriptor.Service.ELEMENT.defaultValue, stateVariable.getTypeDetails().getDefaultValue());
        if (stateVariable.getEventDetails().isSendEvents()) {
            Descriptor.Service.ATTRIBUTE attribute = Descriptor.Service.ATTRIBUTE.sendEvents;
            str = "yes";
        } else {
            Descriptor.Service.ATTRIBUTE attribute2 = Descriptor.Service.ATTRIBUTE.sendEvents;
            str = "no";
        }
        appendNewElement.setAttribute("sendEvents", str);
        if (stateVariable.getTypeDetails().getAllowedValues() != null) {
            Element appendNewElement2 = XMLUtil.appendNewElement(document, appendNewElement, Descriptor.Service.ELEMENT.allowedValueList);
            for (String str2 : stateVariable.getTypeDetails().getAllowedValues()) {
                XMLUtil.appendNewElementIfNotNull(document, appendNewElement2, Descriptor.Service.ELEMENT.allowedValue, str2);
            }
        }
        if (stateVariable.getTypeDetails().getAllowedValueRange() != null) {
            Element appendNewElement3 = XMLUtil.appendNewElement(document, appendNewElement, Descriptor.Service.ELEMENT.allowedValueRange);
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement3, Descriptor.Service.ELEMENT.minimum, Long.valueOf(stateVariable.getTypeDetails().getAllowedValueRange().getMinimum()));
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement3, Descriptor.Service.ELEMENT.maximum, Long.valueOf(stateVariable.getTypeDetails().getAllowedValueRange().getMaximum()));
            if (stateVariable.getTypeDetails().getAllowedValueRange().getStep() < 1) {
                return;
            }
            XMLUtil.appendNewElementIfNotNull(document, appendNewElement3, Descriptor.Service.ELEMENT.step, Long.valueOf(stateVariable.getTypeDetails().getAllowedValueRange().getStep()));
        }
    }

    @Override // org.fourthline.cling.binding.xml.ServiceDescriptorBinder
    public Document buildDOM(Service service) throws DescriptorBindingException {
        try {
            Logger logger = log;
            logger.fine("Generating XML descriptor from service model: " + service);
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            Document newDocument = newInstance.newDocumentBuilder().newDocument();
            generateScpd(service, newDocument);
            return newDocument;
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not generate service descriptor: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    public <S extends Service> S buildInstance(S s, MutableService mutableService) throws ValidationException {
        return (S) mutableService.build(s.getDevice());
    }

    @Override // org.fourthline.cling.binding.xml.ServiceDescriptorBinder
    public <S extends Service> S describe(S s, String str) throws DescriptorBindingException, ValidationException {
        if (str == null || str.length() == 0) {
            throw new DescriptorBindingException("Null or empty descriptor");
        }
        try {
            Logger logger = log;
            logger.fine("Populating service from XML descriptor: " + s);
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
            newDocumentBuilder.setErrorHandler(this);
            return (S) describe((UDA10ServiceDescriptorBinderImpl) s, newDocumentBuilder.parse(new InputSource(new StringReader(str.trim()))));
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse service descriptor: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.toString());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e2);
        }
    }

    @Override // org.fourthline.cling.binding.xml.ServiceDescriptorBinder
    public <S extends Service> S describe(S s, Document document) throws DescriptorBindingException, ValidationException {
        try {
            Logger logger = log;
            logger.fine("Populating service from DOM: " + s);
            MutableService mutableService = new MutableService();
            hydrateBasic(mutableService, s);
            hydrateRoot(mutableService, document.getDocumentElement());
            return (S) buildInstance(s, mutableService);
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not parse service DOM: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.toString());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e2);
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    @Override // org.fourthline.cling.binding.xml.ServiceDescriptorBinder
    public String generate(Service service) throws DescriptorBindingException {
        try {
            Logger logger = log;
            logger.fine("Generating XML descriptor from service model: " + service);
            return XMLUtil.documentToString(buildDOM(service));
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not build DOM: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    public void hydrateAction(MutableAction mutableAction, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                if (Descriptor.Service.ELEMENT.name.equals(item)) {
                    mutableAction.name = XMLUtil.getTextContent(item);
                } else if (Descriptor.Service.ELEMENT.argumentList.equals(item)) {
                    NodeList childNodes2 = item.getChildNodes();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        Node item2 = childNodes2.item(i2);
                        if (item2.getNodeType() == 1) {
                            MutableActionArgument mutableActionArgument = new MutableActionArgument();
                            hydrateActionArgument(mutableActionArgument, item2);
                            mutableAction.arguments.add(mutableActionArgument);
                        }
                    }
                }
            }
        }
    }

    public void hydrateActionArgument(MutableActionArgument mutableActionArgument, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                if (Descriptor.Service.ELEMENT.name.equals(item)) {
                    mutableActionArgument.name = XMLUtil.getTextContent(item);
                } else if (Descriptor.Service.ELEMENT.direction.equals(item)) {
                    String textContent = XMLUtil.getTextContent(item);
                    try {
                        mutableActionArgument.direction = ActionArgument.Direction.valueOf(textContent.toUpperCase(Locale.ROOT));
                    } catch (IllegalArgumentException unused) {
                        Logger logger = log;
                        logger.warning("UPnP specification violation: Invalid action argument direction, assuming 'IN': " + textContent);
                        mutableActionArgument.direction = ActionArgument.Direction.IN;
                    }
                } else if (Descriptor.Service.ELEMENT.relatedStateVariable.equals(item)) {
                    mutableActionArgument.relatedStateVariable = XMLUtil.getTextContent(item);
                } else if (Descriptor.Service.ELEMENT.retval.equals(item)) {
                    mutableActionArgument.retval = true;
                }
            }
        }
    }

    public void hydrateActionList(MutableService mutableService, Node node) throws DescriptorBindingException {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && Descriptor.Service.ELEMENT.action.equals(item)) {
                MutableAction mutableAction = new MutableAction();
                hydrateAction(mutableAction, item);
                mutableService.actions.add(mutableAction);
            }
        }
    }

    public void hydrateBasic(MutableService mutableService, Service service) {
        mutableService.serviceId = service.getServiceId();
        mutableService.serviceType = service.getServiceType();
        if (service instanceof RemoteService) {
            RemoteService remoteService = (RemoteService) service;
            mutableService.controlURI = remoteService.getControlURI();
            mutableService.eventSubscriptionURI = remoteService.getEventSubscriptionURI();
            mutableService.descriptorURI = remoteService.getDescriptorURI();
        }
    }

    public void hydrateRoot(MutableService mutableService, Element element) throws DescriptorBindingException {
        if (!Descriptor.Service.ELEMENT.scpd.equals((Node) element)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Root element name is not <scpd>: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(element.getNodeName());
            throw new DescriptorBindingException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && !Descriptor.Service.ELEMENT.specVersion.equals(item)) {
                if (Descriptor.Service.ELEMENT.actionList.equals(item)) {
                    hydrateActionList(mutableService, item);
                } else if (Descriptor.Service.ELEMENT.serviceStateTable.equals(item)) {
                    hydrateServiceStateTableList(mutableService, item);
                } else {
                    Logger logger = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring unknown element: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(item.getNodeName());
                    logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                }
            }
        }
    }

    public void hydrateServiceStateTableList(MutableService mutableService, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && Descriptor.Service.ELEMENT.stateVariable.equals(item)) {
                MutableStateVariable mutableStateVariable = new MutableStateVariable();
                hydrateStateVariable(mutableStateVariable, (Element) item);
                mutableService.stateVariables.add(mutableStateVariable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void hydrateStateVariable(MutableStateVariable mutableStateVariable, Element element) {
        boolean z;
        NodeList childNodes;
        int i;
        if (element.getAttribute("sendEvents") != null) {
            Descriptor.Service.ATTRIBUTE attribute = Descriptor.Service.ATTRIBUTE.sendEvents;
            if (element.getAttribute("sendEvents").toUpperCase(Locale.ROOT).equals("YES")) {
                z = true;
                mutableStateVariable.eventDetails = new StateVariableEventDetails(z);
                childNodes = element.getChildNodes();
                for (i = 0; i < childNodes.getLength(); i++) {
                    Node item = childNodes.item(i);
                    if (item.getNodeType() == 1) {
                        if (Descriptor.Service.ELEMENT.name.equals(item)) {
                            mutableStateVariable.name = XMLUtil.getTextContent(item);
                        } else if (Descriptor.Service.ELEMENT.dataType.equals(item)) {
                            String textContent = XMLUtil.getTextContent(item);
                            Datatype.Builtin byDescriptorName = Datatype.Builtin.getByDescriptorName(textContent);
                            mutableStateVariable.dataType = byDescriptorName != null ? byDescriptorName.getDatatype() : new CustomDatatype(textContent);
                        } else if (Descriptor.Service.ELEMENT.defaultValue.equals(item)) {
                            mutableStateVariable.defaultValue = XMLUtil.getTextContent(item);
                        } else if (Descriptor.Service.ELEMENT.allowedValueList.equals(item)) {
                            ArrayList arrayList = new ArrayList();
                            NodeList childNodes2 = item.getChildNodes();
                            for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                                Node item2 = childNodes2.item(i2);
                                if (item2.getNodeType() == 1 && Descriptor.Service.ELEMENT.allowedValue.equals(item2)) {
                                    arrayList.add(XMLUtil.getTextContent(item2));
                                }
                            }
                            mutableStateVariable.allowedValues = arrayList;
                        } else if (Descriptor.Service.ELEMENT.allowedValueRange.equals(item)) {
                            MutableAllowedValueRange mutableAllowedValueRange = new MutableAllowedValueRange();
                            NodeList childNodes3 = item.getChildNodes();
                            for (int i3 = 0; i3 < childNodes3.getLength(); i3++) {
                                Node item3 = childNodes3.item(i3);
                                if (item3.getNodeType() == 1) {
                                    if (Descriptor.Service.ELEMENT.minimum.equals(item3)) {
                                        try {
                                            mutableAllowedValueRange.minimum = Long.valueOf(XMLUtil.getTextContent(item3));
                                        } catch (Exception unused) {
                                        }
                                    } else if (Descriptor.Service.ELEMENT.maximum.equals(item3)) {
                                        mutableAllowedValueRange.maximum = Long.valueOf(XMLUtil.getTextContent(item3));
                                    } else if (Descriptor.Service.ELEMENT.step.equals(item3)) {
                                        mutableAllowedValueRange.step = Long.valueOf(XMLUtil.getTextContent(item3));
                                    }
                                }
                            }
                            mutableStateVariable.allowedValueRange = mutableAllowedValueRange;
                        }
                    }
                }
            }
        }
        z = false;
        mutableStateVariable.eventDetails = new StateVariableEventDetails(z);
        childNodes = element.getChildNodes();
        while (i < childNodes.getLength()) {
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
        log.warning(sAXParseException.toString());
    }
}
