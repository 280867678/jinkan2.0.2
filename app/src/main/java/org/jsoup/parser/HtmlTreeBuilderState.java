package org.jsoup.parser;

import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.net.MailTo;
import com.alibaba.fastjson.parser.JSONLexer;
import com.umeng.analytics.pro.C1543ak;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.http.message.TokenParser;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;

/* loaded from: classes5.dex */
public enum HtmlTreeBuilderState {
    Initial { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (!token.isDoctype()) {
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
                return htmlTreeBuilder.process(token);
            } else {
                Token.Doctype asDoctype = token.asDoctype();
                DocumentType documentType = new DocumentType(htmlTreeBuilder.settings.normalizeTag(asDoctype.getName()), asDoctype.getPublicIdentifier(), asDoctype.getSystemIdentifier());
                documentType.setPubSysKey(asDoctype.getPubSysKey());
                htmlTreeBuilder.getDocument().appendChild(documentType);
                if (asDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
            }
            return true;
        }
    },
    BeforeHtml { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
            return htmlTreeBuilder.process(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                htmlTreeBuilder.insert(token.asStartTag());
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
                return true;
            } else {
                if ((!token.isEndTag() || !StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) && token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
        }
    },
    BeforeHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
            } else {
                if (token.isStartTag() && token.asStartTag().normalName().equals("head")) {
                    htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
                    return true;
                } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                } else if (token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    InHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag("head");
            return treeBuilder.process(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int ordinal = token.type.ordinal();
            if (ordinal == 0) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (ordinal == 1) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("html")) {
                    return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
                }
                if (StringUtil.inSorted(normalName, Constants.InHeadEmpty)) {
                    Element insertEmpty = htmlTreeBuilder.insertEmpty(asStartTag);
                    if (normalName.equals("base") && insertEmpty.hasAttr("href")) {
                        htmlTreeBuilder.maybeSetBaseUri(insertEmpty);
                    }
                } else if (normalName.equals("meta")) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (normalName.equals(NotificationCompatJellybean.KEY_TITLE)) {
                    HtmlTreeBuilderState.handleRcData(asStartTag, htmlTreeBuilder);
                } else if (StringUtil.inSorted(normalName, Constants.InHeadRaw)) {
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                } else if (normalName.equals("noscript")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InHeadNoscript;
                    htmlTreeBuilder.transition(htmlTreeBuilderState);
                } else if (!normalName.equals("script")) {
                    if (!normalName.equals("head")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                    htmlTreeBuilder.markInsertionMode();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.Text);
                    htmlTreeBuilder.insert(asStartTag);
                }
            } else if (ordinal == 2) {
                String normalName2 = token.asEndTag().normalName();
                if (!normalName2.equals("head")) {
                    if (StringUtil.inSorted(normalName2, Constants.InHeadEnd)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilderState = HtmlTreeBuilderState.AfterHead;
                htmlTreeBuilder.transition(htmlTreeBuilderState);
            } else if (ordinal != 3) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                htmlTreeBuilder.insert(token.asComment());
            }
            return true;
        }
    },
    InHeadNoscript { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().normalName().equals("noscript")) {
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
                    return true;
                } else if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoScriptHead))) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                } else {
                    if (token.isEndTag() && token.asEndTag().normalName().equals("br")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if ((!token.isStartTag() || !StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoscriptIgnore)) && !token.isEndTag()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }
    },
    AfterHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag(MailTo.BODY);
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else {
                if (token.isStartTag()) {
                    Token.StartTag asStartTag = token.asStartTag();
                    String normalName = asStartTag.normalName();
                    if (normalName.equals("html")) {
                        return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                    }
                    if (normalName.equals(MailTo.BODY)) {
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.framesetOk(false);
                        htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
                    } else if (normalName.equals("frameset")) {
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilderState = HtmlTreeBuilderState.InFrameset;
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartToHead)) {
                        htmlTreeBuilder.error(this);
                        Element headElement = htmlTreeBuilder.getHeadElement();
                        htmlTreeBuilder.push(headElement);
                        htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                        htmlTreeBuilder.removeFromStack(headElement);
                        return true;
                    } else if (normalName.equals("head")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.transition(htmlTreeBuilderState);
                    return true;
                } else if (token.isEndTag() && !StringUtil.inSorted(token.asEndTag().normalName(), Constants.AfterHeadBody)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                anythingElse(token, htmlTreeBuilder);
                return true;
            }
        }
    },
    InBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.7
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x01d5, code lost:
            if (r9.currentElement().normalName().equals(r1) == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x01ab, code lost:
            r9.popStackToClose(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x01a8, code lost:
            r9.error(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x011c, code lost:
            if (r9.currentElement().normalName().equals(r1) == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0140, code lost:
            if (r9.currentElement().normalName().equals(r1) == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x01a6, code lost:
            if (r9.currentElement().normalName().equals(r1) == false) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean inBodyEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            char c;
            Token.EndTag asEndTag = token.asEndTag();
            String normalName = asEndTag.normalName();
            int hashCode = normalName.hashCode();
            switch (hashCode) {
                case 112:
                    if (normalName.equals(C1543ak.f3013ax)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3152:
                    if (normalName.equals("br")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 3200:
                    if (normalName.equals("dd")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 3216:
                    if (normalName.equals("dt")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 3453:
                    if (normalName.equals("li")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3029410:
                    if (normalName.equals(MailTo.BODY)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3148996:
                    if (normalName.equals("form")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3213227:
                    if (normalName.equals("html")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3536714:
                    if (normalName.equals("span")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1869063452:
                    if (normalName.equals("sarcasm")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 3273:
                            if (normalName.equals("h1")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3274:
                            if (normalName.equals("h2")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3275:
                            if (normalName.equals("h3")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3276:
                            if (normalName.equals("h4")) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3277:
                            if (normalName.equals("h5")) {
                                c = '\r';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3278:
                            if (normalName.equals("h6")) {
                                c = 14;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
            }
            switch (c) {
                case 0:
                case 1:
                    return anyOtherEndTag(token, htmlTreeBuilder);
                case 2:
                    if (htmlTreeBuilder.inListItemScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags(normalName);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 3:
                    if (htmlTreeBuilder.inScope(MailTo.BODY)) {
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterBody);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 4:
                    if (htmlTreeBuilder.processEndTag(MailTo.BODY)) {
                        return htmlTreeBuilder.process(asEndTag);
                    }
                    break;
                case 5:
                    FormElement formElement = htmlTreeBuilder.getFormElement();
                    htmlTreeBuilder.setFormElement(null);
                    if (formElement != null && htmlTreeBuilder.inScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.removeFromStack(formElement);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 6:
                    if (htmlTreeBuilder.inButtonScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags(normalName);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processStartTag(normalName);
                        return htmlTreeBuilder.process(asEndTag);
                    }
                case 7:
                case '\b':
                    if (htmlTreeBuilder.inScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags(normalName);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                    if (htmlTreeBuilder.inScope(Constants.Headings)) {
                        htmlTreeBuilder.generateImpliedEndTags(normalName);
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(Constants.Headings);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 15:
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag("br");
                    return false;
                default:
                    if (StringUtil.inSorted(normalName, Constants.InBodyEndAdoptionFormatters)) {
                        return inBodyEndTagAdoption(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(normalName, Constants.InBodyEndClosers)) {
                        if (htmlTreeBuilder.inScope(normalName)) {
                            htmlTreeBuilder.generateImpliedEndTags();
                            break;
                        } else {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                    } else if (!StringUtil.inSorted(normalName, Constants.InBodyStartApplets)) {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    } else {
                        if (!htmlTreeBuilder.inScope("name")) {
                            if (htmlTreeBuilder.inScope(normalName)) {
                                htmlTreeBuilder.generateImpliedEndTags();
                                if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                                    htmlTreeBuilder.error(this);
                                }
                                htmlTreeBuilder.popStackToClose(normalName);
                                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                                break;
                            } else {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                        }
                    }
                    break;
            }
            return true;
        }

        private boolean inBodyEndTagAdoption(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String normalName = token.asEndTag().normalName();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            for (int i = 0; i < 8; i++) {
                Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(normalName);
                if (activeFormattingElement == null) {
                    return anyOtherEndTag(token, htmlTreeBuilder);
                }
                if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                    htmlTreeBuilder.error(this);
                } else if (!htmlTreeBuilder.inScope(activeFormattingElement.normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                        htmlTreeBuilder.error(this);
                    }
                    int size = stack.size();
                    Element element = null;
                    Element element2 = null;
                    int i2 = 0;
                    boolean z = false;
                    while (true) {
                        if (i2 >= size || i2 >= 64) {
                            break;
                        }
                        Element element3 = stack.get(i2);
                        if (element3 == activeFormattingElement) {
                            element2 = stack.get(i2 - 1);
                            z = true;
                        } else if (z && htmlTreeBuilder.isSpecial(element3)) {
                            element = element3;
                            break;
                        }
                        i2++;
                    }
                    if (element == null) {
                        htmlTreeBuilder.popStackToClose(activeFormattingElement.normalName());
                    } else {
                        Element element4 = element;
                        Node node = element4;
                        for (int i3 = 0; i3 < 3; i3++) {
                            if (htmlTreeBuilder.onStack(element4)) {
                                element4 = htmlTreeBuilder.aboveOnStack(element4);
                            }
                            if (!htmlTreeBuilder.isInActiveFormattingElements(element4)) {
                                htmlTreeBuilder.removeFromStack(element4);
                            } else if (element4 == activeFormattingElement) {
                                break;
                            } else {
                                Element element5 = new Element(Tag.valueOf(element4.nodeName(), ParseSettings.preserveCase), htmlTreeBuilder.getBaseUri());
                                htmlTreeBuilder.replaceActiveFormattingElement(element4, element5);
                                htmlTreeBuilder.replaceOnStack(element4, element5);
                                if (node.mo5259parent() != null) {
                                    node.remove();
                                }
                                element5.appendChild(node);
                                element4 = element5;
                                node = element4;
                            }
                        }
                        if (StringUtil.inSorted(element2.normalName(), Constants.InBodyEndTableFosters)) {
                            if (node.mo5259parent() != null) {
                                node.remove();
                            }
                            htmlTreeBuilder.insertInFosterParent(node);
                        } else {
                            if (node.mo5259parent() != null) {
                                node.remove();
                            }
                            element2.appendChild(node);
                        }
                        Element element6 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                        element6.attributes().addAll(activeFormattingElement.attributes());
                        for (Node node2 : (Node[]) element.childNodes().toArray(new Node[0])) {
                            element6.appendChild(node2);
                        }
                        element.appendChild(element6);
                        htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                        htmlTreeBuilder.removeFromStack(activeFormattingElement);
                        htmlTreeBuilder.insertOnStackAfter(element, element6);
                    }
                }
                htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                return true;
            }
            return true;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x05bd, code lost:
            if (r19.inButtonScope(com.umeng.analytics.pro.C1543ak.f3013ax) != false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:232:0x057d, code lost:
            if (r19.inButtonScope(com.umeng.analytics.pro.C1543ak.f3013ax) != false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x024d, code lost:
            r19.processEndTag(com.umeng.analytics.pro.C1543ak.f3013ax);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x024b, code lost:
            if (r19.inButtonScope(com.umeng.analytics.pro.C1543ak.f3013ax) != false) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean inBodyStartTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            char c;
            Token.StartTag startTag;
            HtmlTreeBuilderState htmlTreeBuilderState;
            boolean z;
            Token.StartTag startTag2;
            boolean z2;
            Token.StartTag asStartTag = token.asStartTag();
            String normalName = asStartTag.normalName();
            int hashCode = normalName.hashCode();
            switch (hashCode) {
                case -1644953643:
                    if (normalName.equals("frameset")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1377687758:
                    if (normalName.equals("button")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1191214428:
                    if (normalName.equals("iframe")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -1010136971:
                    if (normalName.equals("option")) {
                        c = PublicSuffixDatabase.EXCEPTION_MARKER;
                        break;
                    }
                    c = 65535;
                    break;
                case -1003243718:
                    if (normalName.equals("textarea")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -906021636:
                    if (normalName.equals("select")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case -80773204:
                    if (normalName.equals("optgroup")) {
                        c = TokenParser.f4579SP;
                        break;
                    }
                    c = 65535;
                    break;
                case 97:
                    if (normalName.equals("a")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3200:
                    if (normalName.equals("dd")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 3216:
                    if (normalName.equals("dt")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case 3338:
                    if (normalName.equals("hr")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 3453:
                    if (normalName.equals("li")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3646:
                    if (normalName.equals("rp")) {
                        c = '\"';
                        break;
                    }
                    c = 65535;
                    break;
                case 3650:
                    if (normalName.equals("rt")) {
                        c = '#';
                        break;
                    }
                    c = 65535;
                    break;
                case 111267:
                    if (normalName.equals("pre")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 114276:
                    if (normalName.equals("svg")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 118811:
                    if (normalName.equals("xmp")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 3029410:
                    if (normalName.equals(MailTo.BODY)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3148996:
                    if (normalName.equals("form")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3213227:
                    if (normalName.equals("html")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3344136:
                    if (normalName.equals("math")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 3386833:
                    if (normalName.equals("nobr")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 3536714:
                    if (normalName.equals("span")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 100313435:
                    if (normalName.equals("image")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 100358090:
                    if (normalName.equals("input")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 110115790:
                    if (normalName.equals("table")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 181975684:
                    if (normalName.equals("listing")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1973234167:
                    if (normalName.equals("plaintext")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 2091304424:
                    if (normalName.equals("isindex")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 2115613112:
                    if (normalName.equals("noembed")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 3273:
                            if (normalName.equals("h1")) {
                                c = 22;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3274:
                            if (normalName.equals("h2")) {
                                c = 23;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3275:
                            if (normalName.equals("h3")) {
                                c = 24;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3276:
                            if (normalName.equals("h4")) {
                                c = 25;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3277:
                            if (normalName.equals("h5")) {
                                c = JSONLexer.EOI;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3278:
                            if (normalName.equals("h6")) {
                                c = 27;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
            }
            switch (c) {
                case 0:
                    startTag = asStartTag;
                    if (htmlTreeBuilder.getActiveFormattingElement("a") != null) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("a");
                        Element fromStack = htmlTreeBuilder.getFromStack("a");
                        if (fromStack != null) {
                            htmlTreeBuilder.removeFromActiveFormattingElements(fromStack);
                            htmlTreeBuilder.removeFromStack(fromStack);
                        }
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTag));
                    return true;
                case 1:
                case 20:
                case 21:
                    startTag = asStartTag;
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(startTag);
                    return true;
                case 2:
                    startTag = asStartTag;
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack = htmlTreeBuilder.getStack();
                    int size = stack.size() - 1;
                    while (true) {
                        if (size > 0) {
                            Element element = stack.get(size);
                            if (element.normalName().equals("li")) {
                                htmlTreeBuilder.processEndTag("li");
                            } else if (!htmlTreeBuilder.isSpecial(element) || StringUtil.inSorted(element.normalName(), Constants.InBodyStartLiBreakers)) {
                                size--;
                            }
                        }
                    }
                    break;
                case 3:
                    htmlTreeBuilder.error(this);
                    Element element2 = htmlTreeBuilder.getStack().get(0);
                    Iterator<Attribute> it = asStartTag.getAttributes().iterator();
                    while (it.hasNext()) {
                        Attribute next = it.next();
                        if (!element2.hasAttr(next.getKey())) {
                            element2.attributes().put(next);
                        }
                    }
                    return true;
                case 4:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack2 = htmlTreeBuilder.getStack();
                    if (stack2.size() == 1) {
                        return false;
                    }
                    if (stack2.size() > 2 && !stack2.get(1).normalName().equals(MailTo.BODY)) {
                        return false;
                    }
                    htmlTreeBuilder.framesetOk(false);
                    Element element3 = stack2.get(1);
                    Iterator<Attribute> it2 = asStartTag.getAttributes().iterator();
                    while (it2.hasNext()) {
                        Attribute next2 = it2.next();
                        if (!element3.hasAttr(next2.getKey())) {
                            element3.attributes().put(next2);
                        }
                    }
                    return true;
                case 5:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack3 = htmlTreeBuilder.getStack();
                    if (stack3.size() == 1) {
                        return false;
                    }
                    if ((stack3.size() > 2 && !stack3.get(1).normalName().equals(MailTo.BODY)) || !htmlTreeBuilder.framesetOk()) {
                        return false;
                    }
                    Element element4 = stack3.get(1);
                    if (element4.mo5259parent() != null) {
                        element4.remove();
                    }
                    for (int i = 1; stack3.size() > i; i = 1) {
                        stack3.remove(stack3.size() - i);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InFrameset;
                    htmlTreeBuilder.transition(htmlTreeBuilderState);
                    return true;
                case 6:
                    if (htmlTreeBuilder.getFormElement() != null) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (htmlTreeBuilder.inButtonScope(C1543ak.f3013ax)) {
                        htmlTreeBuilder.processEndTag(C1543ak.f3013ax);
                    }
                    htmlTreeBuilder.insertForm(asStartTag, true);
                    return true;
                case 7:
                    if (htmlTreeBuilder.inButtonScope(C1543ak.f3013ax)) {
                        htmlTreeBuilder.processEndTag(C1543ak.f3013ax);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                    return true;
                case '\b':
                    if (htmlTreeBuilder.inButtonScope("button")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("button");
                        htmlTreeBuilder.process(asStartTag);
                        return true;
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    z = false;
                    htmlTreeBuilder.framesetOk(z);
                    return true;
                case '\t':
                    startTag = asStartTag;
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (htmlTreeBuilder.inScope("nobr")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("nobr");
                        htmlTreeBuilder.reconstructFormattingElements();
                    }
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTag));
                    return true;
                case '\n':
                    if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder.inButtonScope(C1543ak.f3013ax)) {
                        htmlTreeBuilder.processEndTag(C1543ak.f3013ax);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InTable;
                    htmlTreeBuilder.transition(htmlTreeBuilderState);
                    return true;
                case 11:
                    z = false;
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (htmlTreeBuilder.insertEmpty(asStartTag).attr("type").equalsIgnoreCase("hidden")) {
                        return true;
                    }
                    htmlTreeBuilder.framesetOk(z);
                    return true;
                case '\f':
                    startTag = asStartTag;
                    if (htmlTreeBuilder.inButtonScope(C1543ak.f3013ax)) {
                        htmlTreeBuilder.processEndTag(C1543ak.f3013ax);
                    }
                    htmlTreeBuilder.insertEmpty(startTag);
                    z = false;
                    htmlTreeBuilder.framesetOk(z);
                    return true;
                case '\r':
                    startTag = asStartTag;
                    if (htmlTreeBuilder.getFromStack("svg") == null) {
                        return htmlTreeBuilder.process(startTag.name("img"));
                    }
                    htmlTreeBuilder.insert(startTag);
                    return true;
                case 14:
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.getFormElement() != null) {
                        return false;
                    }
                    htmlTreeBuilder.processStartTag("form");
                    if (asStartTag.attributes.hasKey("action")) {
                        htmlTreeBuilder.getFormElement().mo5251attr("action", asStartTag.attributes.get("action"));
                    }
                    htmlTreeBuilder.processStartTag("hr");
                    htmlTreeBuilder.processStartTag(NotificationCompatJellybean.KEY_LABEL);
                    htmlTreeBuilder.process(new Token.Character().data(asStartTag.attributes.hasKey("prompt") ? asStartTag.attributes.get("prompt") : "This is a searchable index. Enter search keywords: "));
                    Attributes attributes = new Attributes();
                    Iterator<Attribute> it3 = asStartTag.attributes.iterator();
                    while (it3.hasNext()) {
                        Attribute next3 = it3.next();
                        if (!StringUtil.inSorted(next3.getKey(), Constants.InBodyStartInputAttribs)) {
                            attributes.put(next3);
                        }
                    }
                    attributes.put("name", "isindex");
                    htmlTreeBuilder.processStartTag("input", attributes);
                    htmlTreeBuilder.processEndTag(NotificationCompatJellybean.KEY_LABEL);
                    htmlTreeBuilder.processStartTag("hr");
                    htmlTreeBuilder.processEndTag("form");
                    return true;
                case 15:
                    htmlTreeBuilder.insert(asStartTag);
                    if (asStartTag.isSelfClosing()) {
                        return true;
                    }
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
                    htmlTreeBuilder.markInsertionMode();
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilderState = HtmlTreeBuilderState.Text;
                    htmlTreeBuilder.transition(htmlTreeBuilderState);
                    return true;
                case 16:
                    startTag2 = asStartTag;
                    z2 = false;
                    if (htmlTreeBuilder.inButtonScope(C1543ak.f3013ax)) {
                        htmlTreeBuilder.processEndTag(C1543ak.f3013ax);
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.framesetOk(z2);
                    HtmlTreeBuilderState.handleRawtext(startTag2, htmlTreeBuilder);
                    return true;
                case 17:
                    startTag2 = asStartTag;
                    z2 = false;
                    htmlTreeBuilder.framesetOk(z2);
                    HtmlTreeBuilderState.handleRawtext(startTag2, htmlTreeBuilder);
                    return true;
                case 18:
                    startTag2 = asStartTag;
                    HtmlTreeBuilderState.handleRawtext(startTag2, htmlTreeBuilder);
                    return true;
                case 19:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState state = htmlTreeBuilder.state();
                    htmlTreeBuilderState = (state.equals(HtmlTreeBuilderState.InTable) || state.equals(HtmlTreeBuilderState.InCaption) || state.equals(HtmlTreeBuilderState.InTableBody) || state.equals(HtmlTreeBuilderState.InRow) || state.equals(HtmlTreeBuilderState.InCell)) ? HtmlTreeBuilderState.InSelectInTable : HtmlTreeBuilderState.InSelect;
                    htmlTreeBuilder.transition(htmlTreeBuilderState);
                    return true;
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    startTag = asStartTag;
                    if (htmlTreeBuilder.inButtonScope(C1543ak.f3013ax)) {
                        htmlTreeBuilder.processEndTag(C1543ak.f3013ax);
                    }
                    if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.pop();
                    }
                    htmlTreeBuilder.insert(startTag);
                    return true;
                case 28:
                case 29:
                    if (htmlTreeBuilder.inButtonScope(C1543ak.f3013ax)) {
                        htmlTreeBuilder.processEndTag(C1543ak.f3013ax);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.reader.matchConsume("\n");
                    z = false;
                    htmlTreeBuilder.framesetOk(z);
                    return true;
                case 30:
                case 31:
                    startTag = asStartTag;
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack4 = htmlTreeBuilder.getStack();
                    int size2 = stack4.size() - 1;
                    while (true) {
                        if (size2 > 0) {
                            Element element5 = stack4.get(size2);
                            if (StringUtil.inSorted(element5.normalName(), Constants.DdDt)) {
                                htmlTreeBuilder.processEndTag(element5.normalName());
                            } else if (!htmlTreeBuilder.isSpecial(element5) || StringUtil.inSorted(element5.normalName(), Constants.InBodyStartLiBreakers)) {
                                size2--;
                            }
                        }
                    }
                    break;
                case ' ':
                case '!':
                    startTag = asStartTag;
                    if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                        htmlTreeBuilder.processEndTag("option");
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(startTag);
                    return true;
                case '\"':
                case '#':
                    if (!htmlTreeBuilder.inScope("ruby")) {
                        return true;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().normalName().equals("ruby")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.popStackToBefore("ruby");
                    }
                    startTag = asStartTag;
                    htmlTreeBuilder.insert(startTag);
                    return true;
                default:
                    startTag = asStartTag;
                    if (!StringUtil.inSorted(normalName, Constants.InBodyStartEmptyFormatters)) {
                        if (StringUtil.inSorted(normalName, Constants.InBodyStartPClosers)) {
                            break;
                        } else {
                            if (StringUtil.inSorted(normalName, Constants.InBodyStartToHead)) {
                                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                            }
                            if (!StringUtil.inSorted(normalName, Constants.Formatters)) {
                                if (StringUtil.inSorted(normalName, Constants.InBodyStartApplets)) {
                                    htmlTreeBuilder.reconstructFormattingElements();
                                    htmlTreeBuilder.insert(startTag);
                                    htmlTreeBuilder.insertMarkerToFormattingElements();
                                    z = false;
                                    htmlTreeBuilder.framesetOk(z);
                                    return true;
                                } else if (StringUtil.inSorted(normalName, Constants.InBodyStartMedia)) {
                                    htmlTreeBuilder.insertEmpty(startTag);
                                    return true;
                                } else {
                                    if (StringUtil.inSorted(normalName, Constants.InBodyStartDrop)) {
                                        htmlTreeBuilder.error(this);
                                        return false;
                                    }
                                    htmlTreeBuilder.reconstructFormattingElements();
                                    htmlTreeBuilder.insert(startTag);
                                    return true;
                                }
                            }
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTag));
                            return true;
                        }
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insertEmpty(startTag);
                        z = false;
                        htmlTreeBuilder.framesetOk(z);
                        return true;
                    }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String str = token.asEndTag().normalName;
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            int size = stack.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = stack.get(size);
                if (element.normalName().equals(str)) {
                    htmlTreeBuilder.generateImpliedEndTags(str);
                    if (!str.equals(htmlTreeBuilder.currentElement().normalName())) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(str);
                } else if (htmlTreeBuilder.isSpecial(element)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    size--;
                }
            }
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int ordinal = token.type.ordinal();
            if (ordinal == 0) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (ordinal == 1) {
                return inBodyStartTag(token, htmlTreeBuilder);
            } else {
                if (ordinal == 2) {
                    return inBodyEndTag(token, htmlTreeBuilder);
                }
                if (ordinal == 3) {
                    htmlTreeBuilder.insert(token.asComment());
                } else if (ordinal == 4) {
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else if (!htmlTreeBuilder.framesetOk() || !HtmlTreeBuilderState.isWhitespace(asCharacter)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asCharacter);
                        htmlTreeBuilder.framesetOk(false);
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asCharacter);
                    }
                }
                return true;
            }
        }
    },
    Text { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            } else if (!token.isEndTag()) {
                return true;
            } else {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return true;
            }
        }
    },
    InTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
        public boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                htmlTreeBuilder.setFosterInserts(true);
                boolean process = htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                htmlTreeBuilder.setFosterInserts(false);
                return process;
            }
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableText);
                return htmlTreeBuilder.process(token);
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (!token.isStartTag()) {
                if (!token.isEndTag()) {
                    if (!token.isEOF()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                        htmlTreeBuilder.error(this);
                    }
                    return true;
                }
                String normalName = token.asEndTag().normalName();
                if (!normalName.equals("table")) {
                    if (!StringUtil.inSorted(normalName, Constants.InTableEndErr)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!htmlTreeBuilder.inTableScope(normalName)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.popStackToClose("table");
                    htmlTreeBuilder.resetInsertionMode();
                    return true;
                }
            } else {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName2 = asStartTag.normalName();
                if (normalName2.equals("caption")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InCaption;
                } else if (normalName2.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InColumnGroup;
                } else if (normalName2.equals("col")) {
                    htmlTreeBuilder.processStartTag("colgroup");
                    return htmlTreeBuilder.process(token);
                } else if (!StringUtil.inSorted(normalName2, Constants.InTableToBody)) {
                    if (StringUtil.inSorted(normalName2, Constants.InTableAddBody)) {
                        htmlTreeBuilder.processStartTag("tbody");
                        return htmlTreeBuilder.process(token);
                    }
                    if (normalName2.equals("table")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.processEndTag("table")) {
                            return htmlTreeBuilder.process(token);
                        }
                    } else if (StringUtil.inSorted(normalName2, Constants.InTableToHead)) {
                        return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                    } else {
                        if (normalName2.equals("input")) {
                            if (!asStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.insertEmpty(asStartTag);
                        } else if (!normalName2.equals("form")) {
                            return anythingElse(token, htmlTreeBuilder);
                        } else {
                            htmlTreeBuilder.error(this);
                            if (htmlTreeBuilder.getFormElement() != null) {
                                return false;
                            }
                            htmlTreeBuilder.insertForm(asStartTag, false);
                        }
                    }
                    return true;
                } else {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InTableBody;
                }
                htmlTreeBuilder.transition(htmlTreeBuilderState);
                return true;
            }
        }
    },
    InTableText { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.type == Token.TokenType.Character) {
                Token.Character asCharacter = token.asCharacter();
                if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.getPendingTableCharacters().add(asCharacter.getData());
                return true;
            }
            if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                    if (!HtmlTreeBuilderState.isWhitespace(str)) {
                        htmlTreeBuilder.error(this);
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                            htmlTreeBuilder.setFosterInserts(true);
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                            htmlTreeBuilder.setFosterInserts(false);
                        } else {
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                        }
                    } else {
                        htmlTreeBuilder.insert(new Token.Character().data(str));
                    }
                }
                htmlTreeBuilder.newPendingTableCharacters();
            }
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return htmlTreeBuilder.process(token);
        }
    },
    InCaption { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag() && token.asEndTag().normalName().equals("caption")) {
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().normalName().equals("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                return true;
            } else if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) || (token.isEndTag() && token.asEndTag().normalName().equals("table"))) {
                htmlTreeBuilder.error(this);
                if (!htmlTreeBuilder.processEndTag("caption")) {
                    return true;
                }
                return htmlTreeBuilder.process(token);
            } else if (!token.isEndTag() || !StringUtil.inSorted(token.asEndTag().normalName(), Constants.InCaptionIgnore)) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            } else {
                htmlTreeBuilder.error(this);
                return false;
            }
        }
    },
    InColumnGroup { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("colgroup")) {
                return treeBuilder.process(token);
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
            if (r4.equals("html") == false) goto L47;
         */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int ordinal = token.type.ordinal();
            if (ordinal != 0) {
                char c = 0;
                if (ordinal == 1) {
                    Token.StartTag asStartTag = token.asStartTag();
                    String normalName = asStartTag.normalName();
                    int hashCode = normalName.hashCode();
                    if (hashCode != 98688) {
                        if (hashCode == 3213227) {
                        }
                        c = 65535;
                        if (c == 0) {
                            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                        }
                        if (c != 1) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.insertEmpty(asStartTag);
                    } else {
                        if (normalName.equals("col")) {
                            c = 1;
                            if (c == 0) {
                            }
                        }
                        c = 65535;
                        if (c == 0) {
                        }
                    }
                } else if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 5 || !htmlTreeBuilder.currentElement().normalName().equals("html")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        return true;
                    }
                    htmlTreeBuilder.insert(token.asComment());
                } else if (!token.asEndTag().normalName.equals("colgroup")) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                }
            } else {
                htmlTreeBuilder.error(this);
            }
            return true;
        }
    },
    InTableBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.inTableScope("tbody") && !htmlTreeBuilder.inTableScope("thead") && !htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().normalName());
            return htmlTreeBuilder.process(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            int ordinal = token.type.ordinal();
            if (ordinal == 1) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("template")) {
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                } else if (!normalName.equals("tr")) {
                    if (!StringUtil.inSorted(normalName, Constants.InCellNames)) {
                        return StringUtil.inSorted(normalName, Constants.InTableBodyExit) ? exitTableBody(token, htmlTreeBuilder) : anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag("tr");
                    return htmlTreeBuilder.process(asStartTag);
                } else {
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InRow;
                }
            } else if (ordinal != 2) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String normalName2 = token.asEndTag().normalName();
                if (!StringUtil.inSorted(normalName2, Constants.InTableEndIgnore)) {
                    if (normalName2.equals("table")) {
                        return exitTableBody(token, htmlTreeBuilder);
                    }
                    if (!StringUtil.inSorted(normalName2, Constants.InTableBodyEndIgnore)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!htmlTreeBuilder.inTableScope(normalName2)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilderState = HtmlTreeBuilderState.InTable;
                }
            }
            htmlTreeBuilder.transition(htmlTreeBuilderState);
            return true;
        }
    },
    InRow { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("template")) {
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                } else if (!StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    return StringUtil.inSorted(normalName, Constants.InRowMissing) ? handleMissingTr(token, htmlTreeBuilder) : anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InCell);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    return true;
                }
            } else if (!token.isEndTag()) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals("tr")) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableBody);
                    return true;
                } else if (normalName2.equals("table")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.inSorted(normalName2, Constants.InTableToBody)) {
                        if (!StringUtil.inSorted(normalName2, Constants.InRowIgnore)) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.error(this);
                        return false;
                    } else if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        htmlTreeBuilder.processEndTag("tr");
                        return htmlTreeBuilder.process(token);
                    }
                }
            }
        }
    },
    InCell { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            String str = "td";
            if (!htmlTreeBuilder.inTableScope(str)) {
                str = "th";
            }
            htmlTreeBuilder.processEndTag(str);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String normalName = token.asEndTag().normalName();
                if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InCellBody)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!StringUtil.inSorted(normalName, Constants.InCellTable)) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                }
            } else if (!token.isStartTag() || !StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (!htmlTreeBuilder.inTableScope("td") && !htmlTreeBuilder.inTableScope("th")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            closeCell(htmlTreeBuilder);
            return htmlTreeBuilder.process(token);
        }
    },
    InSelect { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
            if (r12.currentElement().normalName().equals("html") == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
            r12.error(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00b9, code lost:
            if (r12.currentElement().normalName().equals("option") != false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
            r12.pop();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00f9, code lost:
            if (r12.currentElement().normalName().equals("optgroup") != false) goto L47;
         */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int ordinal = token.type.ordinal();
            if (ordinal == 0) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (ordinal == 1) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("html")) {
                    return htmlTreeBuilder.process(asStartTag, HtmlTreeBuilderState.InBody);
                }
                if (normalName.equals("option")) {
                    if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                        htmlTreeBuilder.processEndTag("option");
                    }
                } else if (!normalName.equals("optgroup")) {
                    if (normalName.equals("select")) {
                        htmlTreeBuilder.error(this);
                        return htmlTreeBuilder.processEndTag("select");
                    } else if (!StringUtil.inSorted(normalName, Constants.InSelectEnd)) {
                        return normalName.equals("script") ? htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead) : anythingElse(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.error(this);
                        if (!htmlTreeBuilder.inSelectScope("select")) {
                            return false;
                        }
                        htmlTreeBuilder.processEndTag("select");
                        return htmlTreeBuilder.process(asStartTag);
                    }
                } else {
                    if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                        htmlTreeBuilder.processEndTag("option");
                    }
                    if (htmlTreeBuilder.currentElement().normalName().equals("optgroup")) {
                        htmlTreeBuilder.processEndTag("optgroup");
                    }
                }
                htmlTreeBuilder.insert(asStartTag);
            } else if (ordinal == 2) {
                String normalName2 = token.asEndTag().normalName();
                char c = 65535;
                int hashCode = normalName2.hashCode();
                if (hashCode != -1010136971) {
                    if (hashCode != -906021636) {
                        if (hashCode == -80773204 && normalName2.equals("optgroup")) {
                            c = 0;
                        }
                    } else if (normalName2.equals("select")) {
                        c = 2;
                    }
                } else if (normalName2.equals("option")) {
                    c = 1;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        if (!htmlTreeBuilder.inSelectScope(normalName2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.popStackToClose(normalName2);
                        htmlTreeBuilder.resetInsertionMode();
                    }
                } else if (htmlTreeBuilder.currentElement().normalName().equals("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).normalName().equals("optgroup")) {
                    htmlTreeBuilder.processEndTag("option");
                }
            } else if (ordinal == 3) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (ordinal == 4) {
                Token.Character asCharacter = token.asCharacter();
                if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.insert(asCharacter);
            } else if (ordinal != 5) {
                return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }
    },
    InSelectInTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InSelecTableEnd)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            } else if (!token.isEndTag() || !StringUtil.inSorted(token.asEndTag().normalName(), Constants.InSelecTableEnd)) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InSelect);
            } else {
                htmlTreeBuilder.error(this);
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    return false;
                }
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            }
        }
    },
    AfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            } else {
                if (!token.isEndTag() || !token.asEndTag().normalName().equals("html")) {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
                    return htmlTreeBuilder.process(token);
                } else if (htmlTreeBuilder.isFragmentParsing()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterBody);
                    return true;
                }
            }
        }
    },
    InFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                char c = 65535;
                switch (normalName.hashCode()) {
                    case -1644953643:
                        if (normalName.equals("frameset")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3213227:
                        if (normalName.equals("html")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 97692013:
                        if (normalName.equals("frame")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1192721831:
                        if (normalName.equals("noframes")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
                } else if (c == 1) {
                    htmlTreeBuilder.insert(asStartTag);
                } else if (c == 2) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (c != 3) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilderState = HtmlTreeBuilderState.InHead;
                }
                return htmlTreeBuilder.process(asStartTag, htmlTreeBuilderState);
            } else if (!token.isEndTag() || !token.asEndTag().normalName().equals("frameset")) {
                if (!token.isEOF()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!htmlTreeBuilder.currentElement().normalName().equals("html")) {
                    htmlTreeBuilder.error(this);
                }
            } else if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                htmlTreeBuilder.pop();
                if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().normalName().equals("frameset")) {
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterFrameset);
                }
            }
            return true;
        }
    },
    AfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                    htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
                } else if (token.isEndTag() && token.asEndTag().normalName().equals("html")) {
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterFrameset);
                    return true;
                } else if (!token.isStartTag() || !token.asStartTag().normalName().equals("noframes")) {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilderState = HtmlTreeBuilderState.InHead;
                }
                return htmlTreeBuilder.process(token, htmlTreeBuilderState);
            }
        }
    },
    AfterAfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || (token.isStartTag() && token.asStartTag().normalName().equals("html"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            } else {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    Element popStackToClose = htmlTreeBuilder.popStackToClose("html");
                    htmlTreeBuilder.insert(token.asCharacter());
                    htmlTreeBuilder.stack.add(popStackToClose);
                    htmlTreeBuilder.stack.add(popStackToClose.selectFirst(MailTo.BODY));
                    return true;
                } else if (token.isEOF()) {
                    return true;
                } else {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    AfterAfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().normalName().equals("html"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.isEOF()) {
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
        }
    },
    ForeignContent { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    public static final String nullString = String.valueOf((char) 0);

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$24 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C315724 {
        public static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$org$jsoup$parser$Token$TokenType = iArr;
            try {
                Token.TokenType tokenType = Token.TokenType.Comment;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$org$jsoup$parser$Token$TokenType;
                Token.TokenType tokenType2 = Token.TokenType.Doctype;
                iArr2[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$org$jsoup$parser$Token$TokenType;
                Token.TokenType tokenType3 = Token.TokenType.StartTag;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$org$jsoup$parser$Token$TokenType;
                Token.TokenType tokenType4 = Token.TokenType.EndTag;
                iArr4[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$org$jsoup$parser$Token$TokenType;
                Token.TokenType tokenType5 = Token.TokenType.Character;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$org$jsoup$parser$Token$TokenType;
                Token.TokenType tokenType6 = Token.TokenType.EOF;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Constants {
        public static final String[] InHeadEmpty = {"base", "basefont", "bgsound", "command", "link"};
        public static final String[] InHeadRaw = {"noframes", "style"};
        public static final String[] InHeadEnd = {MailTo.BODY, "br", "html"};
        public static final String[] AfterHeadBody = {MailTo.BODY, "html"};
        public static final String[] BeforeHtmlToHead = {MailTo.BODY, "br", "head", "html"};
        public static final String[] InHeadNoScriptHead = {"basefont", "bgsound", "link", "meta", "noframes", "style"};
        public static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", NotificationCompatJellybean.KEY_TITLE};
        public static final String[] InBodyStartPClosers = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", SupportMenuInflater.XML_MENU, "nav", "ol", C1543ak.f3013ax, "section", "summary", "ul"};
        public static final String[] Headings = {"h1", "h2", "h3", "h4", "h5", "h6"};
        public static final String[] InBodyStartLiBreakers = {"address", "div", C1543ak.f3013ax};
        public static final String[] DdDt = {"dd", "dt"};
        public static final String[] Formatters = {"b", "big", "code", "em", "font", C1543ak.f2966aC, C1543ak.f2965aB, "small", "strike", "strong", "tt", C1543ak.f2970aG};
        public static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        public static final String[] InBodyStartEmptyFormatters = {"area", "br", "embed", "img", "keygen", "wbr"};
        public static final String[] InBodyStartMedia = {"param", "source", "track"};
        public static final String[] InBodyStartInputAttribs = {"action", "name", "prompt"};
        public static final String[] InBodyStartDrop = {"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] InBodyEndClosers = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", SupportMenuInflater.XML_MENU, "nav", "ol", "pre", "section", "summary", "ul"};
        public static final String[] InBodyEndAdoptionFormatters = {"a", "b", "big", "code", "em", "font", C1543ak.f2966aC, "nobr", C1543ak.f2965aB, "small", "strike", "strong", "tt", C1543ak.f2970aG};
        public static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] InTableToBody = {"tbody", "tfoot", "thead"};
        public static final String[] InTableAddBody = {"td", "th", "tr"};
        public static final String[] InTableToHead = {"script", "style"};
        public static final String[] InCellNames = {"td", "th"};
        public static final String[] InCellBody = {MailTo.BODY, "caption", "col", "colgroup", "html"};
        public static final String[] InCellTable = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] InCellCol = {"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] InTableEndErr = {MailTo.BODY, "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] InTableFoster = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] InTableBodyExit = {"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
        public static final String[] InTableBodyEndIgnore = {MailTo.BODY, "caption", "col", "colgroup", "html", "td", "th", "tr"};
        public static final String[] InRowMissing = {"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
        public static final String[] InRowIgnore = {MailTo.BODY, "caption", "col", "colgroup", "html", "td", "th"};
        public static final String[] InSelectEnd = {"input", "keygen", "textarea"};
        public static final String[] InSelecTableEnd = {"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] InTableEndIgnore = {"tbody", "tfoot", "thead"};
        public static final String[] InHeadNoscriptIgnore = {"head", "noscript"};
        public static final String[] InCaptionIgnore = {MailTo.BODY, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
    }

    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    public static boolean isWhitespace(String str) {
        return StringUtil.isBlank(str);
    }

    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return StringUtil.isBlank(token.asCharacter().getData());
        }
        return false;
    }

    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);
}
