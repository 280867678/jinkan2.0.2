package org.fourthline.cling.transport.impl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.model.Constants;
import org.fourthline.cling.model.UnsupportedDataException;
import org.fourthline.cling.model.XMLUtil;
import org.fourthline.cling.model.action.ActionArgumentValue;
import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.control.ActionMessage;
import org.fourthline.cling.model.message.control.ActionRequestMessage;
import org.fourthline.cling.model.message.control.ActionResponseMessage;
import org.fourthline.cling.model.meta.ActionArgument;
import org.fourthline.cling.model.types.ErrorCode;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.transport.spi.SOAPActionProcessor;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class SOAPActionProcessorImpl implements SOAPActionProcessor, ErrorHandler {
    public static Logger log = Logger.getLogger(SOAPActionProcessor.class.getName());

    public DocumentBuilderFactory createDocumentBuilderFactory() throws FactoryConfigurationError {
        return DocumentBuilderFactory.newInstance();
    }

    public ActionArgumentValue createValue(ActionArgument actionArgument, String str) throws ActionException {
        try {
            return new ActionArgumentValue(actionArgument, str);
        } catch (InvalidValueException e) {
            ErrorCode errorCode = ErrorCode.ARGUMENT_VALUE_INVALID;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Wrong type or invalid value for '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionArgument.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("': ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
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

    public Node findActionArgumentNode(List<Node> list, ActionArgument actionArgument) {
        for (Node node : list) {
            if (actionArgument.isNameOrAlias(getUnprefixedNodeName(node))) {
                return node;
            }
        }
        return null;
    }

    public List<Node> getMatchingNodes(NodeList nodeList, ActionArgument[] actionArgumentArr) throws ActionException {
        ArrayList arrayList = new ArrayList();
        for (ActionArgument actionArgument : actionArgumentArr) {
            arrayList.add(actionArgument.getName());
            arrayList.addAll(Arrays.asList(actionArgument.getAliases()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            if (item.getNodeType() == 1 && arrayList.contains(getUnprefixedNodeName(item))) {
                arrayList2.add(item);
            }
        }
        if (arrayList2.size() >= actionArgumentArr.length) {
            return arrayList2;
        }
        ErrorCode errorCode = ErrorCode.ARGUMENT_VALUE_INVALID;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid number of input or output arguments in XML message, expected ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionArgumentArr.length);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" but found ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(arrayList2.size());
        throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public String getMessageBody(ActionMessage actionMessage) throws UnsupportedDataException {
        if (actionMessage.isBodyNonEmptyString()) {
            return actionMessage.getBodyString().trim();
        }
        throw new UnsupportedDataException("Can't transform null or non-string/zero-length body of: " + actionMessage);
    }

    public String getUnprefixedNodeName(Node node) {
        return node.getPrefix() != null ? node.getNodeName().substring(node.getPrefix().length() + 1) : node.getNodeName();
    }

    public void readActionInputArguments(Element element, ActionInvocation actionInvocation) throws ActionException {
        actionInvocation.setInput(readArgumentValues(element.getChildNodes(), actionInvocation.getAction().getInputArguments()));
    }

    public void readActionOutputArguments(Element element, ActionInvocation actionInvocation) throws ActionException {
        actionInvocation.setOutput(readArgumentValues(element.getChildNodes(), actionInvocation.getAction().getOutputArguments()));
    }

    public Element readActionRequestElement(Element element, ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) {
        NodeList childNodes = element.getChildNodes();
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Looking for action request element matching namespace:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionRequestMessage.getActionNamespace());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                String unprefixedNodeName = getUnprefixedNodeName(item);
                if (unprefixedNodeName.equals(actionInvocation.getAction().getName())) {
                    if (item.getNamespaceURI() == null || !item.getNamespaceURI().equals(actionRequestMessage.getActionNamespace())) {
                        throw new UnsupportedDataException("Illegal or missing namespace on action request element: " + item);
                    }
                    Logger logger2 = log;
                    logger2.fine("Reading action request element: " + unprefixedNodeName);
                    return (Element) item;
                }
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not read action request element matching namespace: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(actionRequestMessage.getActionNamespace());
        throw new UnsupportedDataException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }

    public Element readActionResponseElement(Element element, ActionInvocation actionInvocation) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                String unprefixedNodeName = getUnprefixedNodeName(item);
                if (unprefixedNodeName.equals(actionInvocation.getAction().getName() + "Response")) {
                    Logger logger = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Reading action response element: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getUnprefixedNodeName(item));
                    logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    return (Element) item;
                }
            }
        }
        log.fine("Could not read action response element");
        return null;
    }

    public ActionArgumentValue[] readArgumentValues(NodeList nodeList, ActionArgument[] actionArgumentArr) throws ActionException {
        List<Node> matchingNodes = getMatchingNodes(nodeList, actionArgumentArr);
        ActionArgumentValue[] actionArgumentValueArr = new ActionArgumentValue[actionArgumentArr.length];
        for (int i = 0; i < actionArgumentArr.length; i++) {
            ActionArgument actionArgument = actionArgumentArr[i];
            Node findActionArgumentNode = findActionArgumentNode(matchingNodes, actionArgument);
            if (findActionArgumentNode == null) {
                ErrorCode errorCode = ErrorCode.ARGUMENT_VALUE_INVALID;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not find argument '");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionArgument.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' node");
                throw new ActionException(errorCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Reading action argument: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(actionArgument.getName());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            actionArgumentValueArr[i] = createValue(actionArgument, XMLUtil.getTextContent(findActionArgumentNode));
        }
        return actionArgumentValueArr;
    }

    @Override // org.fourthline.cling.transport.spi.SOAPActionProcessor
    public void readBody(ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) throws UnsupportedDataException {
        Logger logger = log;
        logger.fine("Reading body of " + actionRequestMessage + " for: " + actionInvocation);
        if (log.isLoggable(Level.FINER)) {
            log.finer("===================================== SOAP BODY BEGIN ============================================");
            log.finer(actionRequestMessage.getBodyString());
            log.finer("-===================================== SOAP BODY END ============================================");
        }
        String messageBody = getMessageBody(actionRequestMessage);
        try {
            DocumentBuilderFactory createDocumentBuilderFactory = createDocumentBuilderFactory();
            createDocumentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder newDocumentBuilder = createDocumentBuilderFactory.newDocumentBuilder();
            newDocumentBuilder.setErrorHandler(this);
            Document parse = newDocumentBuilder.parse(new InputSource(new StringReader(messageBody)));
            readBodyRequest(parse, readBodyElement(parse), actionRequestMessage, actionInvocation);
        } catch (Exception e) {
            throw new UnsupportedDataException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't transform message payload: ", e), e, messageBody);
        }
    }

    @Override // org.fourthline.cling.transport.spi.SOAPActionProcessor
    public void readBody(ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) throws UnsupportedDataException {
        Logger logger = log;
        logger.fine("Reading body of " + actionResponseMessage + " for: " + actionInvocation);
        if (log.isLoggable(Level.FINER)) {
            log.finer("===================================== SOAP BODY BEGIN ============================================");
            log.finer(actionResponseMessage.getBodyString());
            log.finer("-===================================== SOAP BODY END ============================================");
        }
        String messageBody = getMessageBody(actionResponseMessage);
        try {
            DocumentBuilderFactory createDocumentBuilderFactory = createDocumentBuilderFactory();
            createDocumentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder newDocumentBuilder = createDocumentBuilderFactory.newDocumentBuilder();
            newDocumentBuilder.setErrorHandler(this);
            Document parse = newDocumentBuilder.parse(new InputSource(new StringReader(messageBody)));
            Element readBodyElement = readBodyElement(parse);
            ActionException readBodyFailure = readBodyFailure(parse, readBodyElement);
            if (readBodyFailure == null) {
                readBodyResponse(parse, readBodyElement, actionResponseMessage, actionInvocation);
            } else {
                actionInvocation.setFailure(readBodyFailure);
            }
        } catch (Exception e) {
            throw new UnsupportedDataException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't transform message payload: ", e), e, messageBody);
        }
    }

    public Element readBodyElement(Document document) {
        Element documentElement = document.getDocumentElement();
        if (documentElement == null || !getUnprefixedNodeName(documentElement).equals("Envelope")) {
            throw new RuntimeException("Response root element was not 'Envelope'");
        }
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1 && getUnprefixedNodeName(item).equals("Body")) {
                return (Element) item;
            }
        }
        throw new RuntimeException("Response envelope did not contain 'Body' child element");
    }

    public ActionException readBodyFailure(Document document, Element element) throws Exception {
        return readFaultElement(element);
    }

    public void readBodyRequest(Document document, Element element, ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) throws Exception {
        readActionInputArguments(readActionRequestElement(element, actionRequestMessage, actionInvocation), actionInvocation);
    }

    public void readBodyResponse(Document document, Element element, ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) throws Exception {
        readActionOutputArguments(readActionResponseElement(element, actionInvocation), actionInvocation);
    }

    public ActionException readFaultElement(Element element) {
        NodeList childNodes = element.getChildNodes();
        String str = null;
        String str2 = null;
        boolean z = false;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            short s = 1;
            if (item.getNodeType() == 1 && getUnprefixedNodeName(item).equals("Fault")) {
                NodeList childNodes2 = item.getChildNodes();
                int i2 = 0;
                while (i2 < childNodes2.getLength()) {
                    Node item2 = childNodes2.item(i2);
                    if (item2.getNodeType() == s && getUnprefixedNodeName(item2).equals("detail")) {
                        NodeList childNodes3 = item2.getChildNodes();
                        int i3 = 0;
                        while (i3 < childNodes3.getLength()) {
                            Node item3 = childNodes3.item(i3);
                            if (item3.getNodeType() == s && getUnprefixedNodeName(item3).equals("UPnPError")) {
                                NodeList childNodes4 = item3.getChildNodes();
                                int i4 = 0;
                                while (i4 < childNodes4.getLength()) {
                                    Node item4 = childNodes4.item(i4);
                                    if (item4.getNodeType() == s) {
                                        if (getUnprefixedNodeName(item4).equals("errorCode")) {
                                            str = XMLUtil.getTextContent(item4);
                                        }
                                        if (getUnprefixedNodeName(item4).equals("errorDescription")) {
                                            str2 = XMLUtil.getTextContent(item4);
                                        }
                                    }
                                    i4++;
                                    s = 1;
                                }
                            }
                            i3++;
                            s = 1;
                        }
                    }
                    i2++;
                    s = 1;
                }
                z = true;
            }
        }
        if (str == null) {
            if (z) {
                throw new RuntimeException("Received fault element but no error code");
            }
            return null;
        }
        try {
            int intValue = Integer.valueOf(str).intValue();
            ErrorCode byCode = ErrorCode.getByCode(intValue);
            if (byCode != null) {
                log.fine("Reading fault element: " + byCode.getCode() + " - " + str2);
                return new ActionException(byCode, str2, false);
            }
            log.fine("Reading fault element: " + intValue + " - " + str2);
            return new ActionException(intValue, str2);
        } catch (NumberFormatException unused) {
            throw new RuntimeException("Error code was not a number");
        }
    }

    public String toString(Document document) throws Exception {
        String documentToString = XMLUtil.documentToString(document);
        while (true) {
            if (documentToString.endsWith("\n") || documentToString.endsWith(StringUtils.f4552CR)) {
                documentToString = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(documentToString, -1, 0);
            } else {
                return documentToString;
            }
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
        log.warning(sAXParseException.toString());
    }

    public void writeActionInputArguments(Document document, Element element, ActionInvocation actionInvocation) {
        ActionArgument[] inputArguments;
        for (ActionArgument actionArgument : actionInvocation.getAction().getInputArguments()) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Writing action input argument: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionArgument.getName());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            XMLUtil.appendNewElement(document, element, actionArgument.getName(), actionInvocation.getInput(actionArgument) != null ? actionInvocation.getInput(actionArgument).toString() : "");
        }
    }

    public void writeActionOutputArguments(Document document, Element element, ActionInvocation actionInvocation) {
        ActionArgument[] outputArguments;
        for (ActionArgument actionArgument : actionInvocation.getAction().getOutputArguments()) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Writing action output argument: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionArgument.getName());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            XMLUtil.appendNewElement(document, element, actionArgument.getName(), actionInvocation.getOutput(actionArgument) != null ? actionInvocation.getOutput(actionArgument).toString() : "");
        }
    }

    public Element writeActionRequestElement(Document document, Element element, ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Writing action request element: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionInvocation.getAction().getName());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        String actionNamespace = actionRequestMessage.getActionNamespace();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("u:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(actionInvocation.getAction().getName());
        Element createElementNS = document.createElementNS(actionNamespace, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        element.appendChild(createElementNS);
        return createElementNS;
    }

    public Element writeActionResponseElement(Document document, Element element, ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Writing action response element: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(actionInvocation.getAction().getName());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        String actionNamespace = actionResponseMessage.getActionNamespace();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("u:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(actionInvocation.getAction().getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("Response");
        Element createElementNS = document.createElementNS(actionNamespace, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        element.appendChild(createElementNS);
        return createElementNS;
    }

    @Override // org.fourthline.cling.transport.spi.SOAPActionProcessor
    public void writeBody(ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) throws UnsupportedDataException {
        Logger logger = log;
        logger.fine("Writing body of " + actionRequestMessage + " for: " + actionInvocation);
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            Document newDocument = newInstance.newDocumentBuilder().newDocument();
            writeBodyRequest(newDocument, writeBodyElement(newDocument), actionRequestMessage, actionInvocation);
            if (!log.isLoggable(Level.FINER)) {
                return;
            }
            log.finer("===================================== SOAP BODY BEGIN ============================================");
            log.finer(actionRequestMessage.getBodyString());
            log.finer("-===================================== SOAP BODY END ============================================");
        } catch (Exception e) {
            throw new UnsupportedDataException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't transform message payload: ", e), e);
        }
    }

    @Override // org.fourthline.cling.transport.spi.SOAPActionProcessor
    public void writeBody(ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) throws UnsupportedDataException {
        Logger logger = log;
        logger.fine("Writing body of " + actionResponseMessage + " for: " + actionInvocation);
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            Document newDocument = newInstance.newDocumentBuilder().newDocument();
            Element writeBodyElement = writeBodyElement(newDocument);
            if (actionInvocation.getFailure() != null) {
                writeBodyFailure(newDocument, writeBodyElement, actionResponseMessage, actionInvocation);
            } else {
                writeBodyResponse(newDocument, writeBodyElement, actionResponseMessage, actionInvocation);
            }
            if (!log.isLoggable(Level.FINER)) {
                return;
            }
            log.finer("===================================== SOAP BODY BEGIN ============================================");
            log.finer(actionResponseMessage.getBodyString());
            log.finer("-===================================== SOAP BODY END ============================================");
        } catch (Exception e) {
            throw new UnsupportedDataException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't transform message payload: ", e), e);
        }
    }

    public Element writeBodyElement(Document document) {
        Element createElementNS = document.createElementNS(Constants.SOAP_NS_ENVELOPE, "s:Envelope");
        Attr createAttributeNS = document.createAttributeNS(Constants.SOAP_NS_ENVELOPE, "s:encodingStyle");
        createAttributeNS.setValue(Constants.SOAP_URI_ENCODING_STYLE);
        createElementNS.setAttributeNode(createAttributeNS);
        document.appendChild(createElementNS);
        Element createElementNS2 = document.createElementNS(Constants.SOAP_NS_ENVELOPE, "s:Body");
        createElementNS.appendChild(createElementNS2);
        return createElementNS2;
    }

    public void writeBodyFailure(Document document, Element element, ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) throws Exception {
        writeFaultElement(document, element, actionInvocation);
        actionResponseMessage.setBody(toString(document));
    }

    public void writeBodyRequest(Document document, Element element, ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) throws Exception {
        writeActionInputArguments(document, writeActionRequestElement(document, element, actionRequestMessage, actionInvocation), actionInvocation);
        actionRequestMessage.setBody(toString(document));
    }

    public void writeBodyResponse(Document document, Element element, ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) throws Exception {
        writeActionOutputArguments(document, writeActionResponseElement(document, element, actionResponseMessage, actionInvocation), actionInvocation);
        actionResponseMessage.setBody(toString(document));
    }

    public void writeFaultElement(Document document, Element element, ActionInvocation actionInvocation) {
        Element createElementNS = document.createElementNS(Constants.SOAP_NS_ENVELOPE, "s:Fault");
        element.appendChild(createElementNS);
        XMLUtil.appendNewElement(document, createElementNS, "faultcode", "s:Client");
        XMLUtil.appendNewElement(document, createElementNS, "faultstring", "UPnPError");
        Element createElement = document.createElement("detail");
        createElementNS.appendChild(createElement);
        Element createElementNS2 = document.createElementNS(Constants.NS_UPNP_CONTROL_10, "UPnPError");
        createElement.appendChild(createElementNS2);
        int errorCode = actionInvocation.getFailure().getErrorCode();
        String message = actionInvocation.getFailure().getMessage();
        Logger logger = log;
        logger.fine("Writing fault element: " + errorCode + " - " + message);
        XMLUtil.appendNewElement(document, createElementNS2, "errorCode", Integer.toString(errorCode));
        XMLUtil.appendNewElement(document, createElementNS2, "errorDescription", message);
    }
}
