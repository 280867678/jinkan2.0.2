package org.jsoup.parser;

import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.net.MailTo;
import com.umeng.analytics.pro.C1543ak;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.tvspark.outline;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;
import org.jsoup.select.Elements;

/* loaded from: classes5.dex */
public class HtmlTreeBuilder extends TreeBuilder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MaxScopeSearchDepth = 100;
    public boolean baseUriSetFromDoc;
    public Element contextElement;
    public Token.EndTag emptyEnd;
    public FormElement formElement;
    public ArrayList<Element> formattingElements;
    public boolean fosterInserts;
    public boolean fragmentParsing;
    public boolean framesetOk;
    public Element headElement;
    public HtmlTreeBuilderState originalState;
    public List<String> pendingTableCharacters;
    public String[] specificScopeTarget = {null};
    public HtmlTreeBuilderState state;
    public static final String[] TagsSearchInScope = {"applet", "caption", "html", "marquee", "object", "table", "td", "th"};
    public static final String[] TagSearchList = {"ol", "ul"};
    public static final String[] TagSearchButton = {"button"};
    public static final String[] TagSearchTableScope = {"html", "table"};
    public static final String[] TagSearchSelectScope = {"optgroup", "option"};
    public static final String[] TagSearchEndTags = {"dd", "dt", "li", "optgroup", "option", C1543ak.f3013ax, "rp", "rt"};
    public static final String[] TagSearchSpecial = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", MailTo.BODY, "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", SupportMenuInflater.XML_MENU, "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", C1543ak.f3013ax, "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", NotificationCompatJellybean.KEY_TITLE, "tr", "ul", "wbr", "xmp"};

    private void clearStackToContext(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (StringUtil.m36in(element.normalName(), strArr) || element.normalName().equals("html")) {
                return;
            }
            this.stack.remove(size);
        }
    }

    private boolean inSpecificScope(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.specificScopeTarget;
        strArr3[0] = str;
        return inSpecificScope(strArr3, strArr, strArr2);
    }

    private boolean inSpecificScope(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.stack.size() - 1;
        int i = size > 100 ? size - 100 : 0;
        while (size >= i) {
            String normalName = this.stack.get(size).normalName();
            if (StringUtil.inSorted(normalName, strArr)) {
                return true;
            }
            if (StringUtil.inSorted(normalName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.inSorted(normalName, strArr3)) {
                return false;
            }
            size--;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void insertNode(Node node) {
        Element currentElement;
        FormElement formElement;
        if (this.stack.isEmpty()) {
            currentElement = this.doc;
        } else if (isFosterInserts()) {
            insertInFosterParent(node);
            if (node instanceof Element) {
                return;
            }
            Element element = (Element) node;
            if (!element.tag().isFormListed() || (formElement = this.formElement) == null) {
                return;
            }
            formElement.addElement(element);
            return;
        } else {
            currentElement = currentElement();
        }
        currentElement.appendChild(node);
        if (node instanceof Element) {
        }
    }

    private boolean isElementInQueue(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameFormattingElement(Element element, Element element2) {
        return element.normalName().equals(element2.normalName()) && element.attributes().equals(element2.attributes());
    }

    private void replaceInQueue(ArrayList<Element> arrayList, Element element, Element element2) {
        int lastIndexOf = arrayList.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        arrayList.set(lastIndexOf, element2);
    }

    public Element aboveOnStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                return this.stack.get(size - 1);
            }
        }
        return null;
    }

    public void clearFormattingElementsToLastMarker() {
        while (!this.formattingElements.isEmpty() && removeLastFormattingElement() != null) {
        }
    }

    public void clearStackToTableBodyContext() {
        clearStackToContext("tbody", "tfoot", "thead", "template");
    }

    public void clearStackToTableContext() {
        clearStackToContext("table");
    }

    public void clearStackToTableRowContext() {
        clearStackToContext("tr", "template");
    }

    @Override // org.jsoup.parser.TreeBuilder
    public ParseSettings defaultSettings() {
        return ParseSettings.htmlDefault;
    }

    public void error(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.parser.getErrors().canAddError()) {
            this.parser.getErrors().add(new ParseError(this.reader.pos(), "Unexpected token [%s] when in state [%s]", this.currentToken.tokenType(), htmlTreeBuilderState));
        }
    }

    public void framesetOk(boolean z) {
        this.framesetOk = z;
    }

    public boolean framesetOk() {
        return this.framesetOk;
    }

    public void generateImpliedEndTags() {
        generateImpliedEndTags(null);
    }

    public void generateImpliedEndTags(String str) {
        while (str != null && !currentElement().normalName().equals(str) && StringUtil.inSorted(currentElement().normalName(), TagSearchEndTags)) {
            pop();
        }
    }

    public Element getActiveFormattingElement(String str) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            Element element = this.formattingElements.get(size);
            if (element == null) {
                return null;
            }
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public String getBaseUri() {
        return this.baseUri;
    }

    public Document getDocument() {
        return this.doc;
    }

    public FormElement getFormElement() {
        return this.formElement;
    }

    public Element getFromStack(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public Element getHeadElement() {
        return this.headElement;
    }

    public List<String> getPendingTableCharacters() {
        return this.pendingTableCharacters;
    }

    public ArrayList<Element> getStack() {
        return this.stack;
    }

    public boolean inButtonScope(String str) {
        return inScope(str, TagSearchButton);
    }

    public boolean inListItemScope(String str) {
        return inScope(str, TagSearchList);
    }

    public boolean inScope(String str) {
        return inScope(str, null);
    }

    public boolean inScope(String str, String[] strArr) {
        return inSpecificScope(str, TagsSearchInScope, strArr);
    }

    public boolean inScope(String[] strArr) {
        return inSpecificScope(strArr, TagsSearchInScope, (String[]) null);
    }

    public boolean inSelectScope(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String normalName = this.stack.get(size).normalName();
            if (normalName.equals(str)) {
                return true;
            }
            if (!StringUtil.inSorted(normalName, TagSearchSelectScope)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    public boolean inTableScope(String str) {
        return inSpecificScope(str, TagSearchTableScope, (String[]) null);
    }

    @Override // org.jsoup.parser.TreeBuilder
    public void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.state = HtmlTreeBuilderState.Initial;
        this.originalState = null;
        this.baseUriSetFromDoc = false;
        this.headElement = null;
        this.formElement = null;
        this.contextElement = null;
        this.formattingElements = new ArrayList<>();
        this.pendingTableCharacters = new ArrayList();
        this.emptyEnd = new Token.EndTag();
        this.framesetOk = true;
        this.fosterInserts = false;
        this.fragmentParsing = false;
    }

    public Element insert(Token.StartTag startTag) {
        Attributes attributes = startTag.attributes;
        if (attributes != null && !attributes.isEmpty() && startTag.attributes.deduplicate(this.settings) > 0) {
            error("Duplicate attribute");
        }
        if (!startTag.isSelfClosing()) {
            Element element = new Element(Tag.valueOf(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
            insert(element);
            return element;
        }
        Element insertEmpty = insertEmpty(startTag);
        this.stack.add(insertEmpty);
        this.tokeniser.transition(TokeniserState.Data);
        this.tokeniser.emit(this.emptyEnd.mo5272reset().name(insertEmpty.tagName()));
        return insertEmpty;
    }

    public void insert(Element element) {
        insertNode(element);
        this.stack.add(element);
    }

    public void insert(Token.Character character) {
        Element currentElement = currentElement();
        if (currentElement == null) {
            currentElement = this.doc;
        }
        String normalName = currentElement.normalName();
        String data = character.getData();
        currentElement.appendChild(character.isCData() ? new CDataNode(data) : (normalName.equals("script") || normalName.equals("style")) ? new DataNode(data) : new TextNode(data));
    }

    public void insert(Token.Comment comment) {
        insertNode(new Comment(comment.getData()));
    }

    public Element insertEmpty(Token.StartTag startTag) {
        Tag valueOf = Tag.valueOf(startTag.name(), this.settings);
        Element element = new Element(valueOf, null, this.settings.normalizeAttributes(startTag.attributes));
        insertNode(element);
        if (startTag.isSelfClosing()) {
            if (!valueOf.isKnownTag()) {
                valueOf.setSelfClosing();
            } else if (!valueOf.isEmpty()) {
                this.tokeniser.error("Tag cannot be self closing; not a void tag");
            }
        }
        return element;
    }

    public FormElement insertForm(Token.StartTag startTag, boolean z) {
        FormElement formElement = new FormElement(Tag.valueOf(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        setFormElement(formElement);
        insertNode(formElement);
        if (z) {
            this.stack.add(formElement);
        }
        return formElement;
    }

    public void insertInFosterParent(Node node) {
        Element element;
        Element fromStack = getFromStack("table");
        boolean z = false;
        if (fromStack == null) {
            element = this.stack.get(0);
        } else if (fromStack.mo5259parent() != null) {
            element = fromStack.mo5259parent();
            z = true;
        } else {
            element = aboveOnStack(fromStack);
        }
        if (!z) {
            element.appendChild(node);
            return;
        }
        Validate.notNull(fromStack);
        fromStack.mo5253before(node);
    }

    public void insertMarkerToFormattingElements() {
        this.formattingElements.add(null);
    }

    public void insertOnStackAfter(Element element, Element element2) {
        int lastIndexOf = this.stack.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        this.stack.add(lastIndexOf + 1, element2);
    }

    public Element insertStartTag(String str) {
        Element element = new Element(Tag.valueOf(str, this.settings), null);
        insert(element);
        return element;
    }

    public boolean isFosterInserts() {
        return this.fosterInserts;
    }

    public boolean isFragmentParsing() {
        return this.fragmentParsing;
    }

    public boolean isInActiveFormattingElements(Element element) {
        return isElementInQueue(this.formattingElements, element);
    }

    public boolean isSpecial(Element element) {
        return StringUtil.inSorted(element.normalName(), TagSearchSpecial);
    }

    public Element lastFormattingElement() {
        if (this.formattingElements.size() > 0) {
            ArrayList<Element> arrayList = this.formattingElements;
            return arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    public void markInsertionMode() {
        this.originalState = this.state;
    }

    public void maybeSetBaseUri(Element element) {
        if (this.baseUriSetFromDoc) {
            return;
        }
        String absUrl = element.absUrl("href");
        if (absUrl.length() == 0) {
            return;
        }
        this.baseUri = absUrl;
        this.baseUriSetFromDoc = true;
        this.doc.setBaseUri(absUrl);
    }

    public void newPendingTableCharacters() {
        this.pendingTableCharacters = new ArrayList();
    }

    public boolean onStack(Element element) {
        return isElementInQueue(this.stack, element);
    }

    public HtmlTreeBuilderState originalState() {
        return this.originalState;
    }

    @Override // org.jsoup.parser.TreeBuilder
    public List<Node> parseFragment(String str, Element element, String str2, Parser parser) {
        Element element2;
        Tokeniser tokeniser;
        TokeniserState tokeniserState;
        this.state = HtmlTreeBuilderState.Initial;
        initialiseParse(new StringReader(str), str2, parser);
        this.contextElement = element;
        this.fragmentParsing = true;
        if (element != null) {
            if (element.ownerDocument() != null) {
                this.doc.quirksMode(element.ownerDocument().quirksMode());
            }
            String normalName = element.normalName();
            if (StringUtil.m36in(normalName, NotificationCompatJellybean.KEY_TITLE, "textarea")) {
                tokeniser = this.tokeniser;
                tokeniserState = TokeniserState.Rcdata;
            } else if (StringUtil.m36in(normalName, "iframe", "noembed", "noframes", "style", "xmp")) {
                tokeniser = this.tokeniser;
                tokeniserState = TokeniserState.Rawtext;
            } else if (normalName.equals("script")) {
                tokeniser = this.tokeniser;
                tokeniserState = TokeniserState.ScriptData;
            } else {
                if (!normalName.equals("noscript")) {
                    normalName.equals("plaintext");
                }
                tokeniser = this.tokeniser;
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.transition(tokeniserState);
            element2 = new Element(Tag.valueOf("html", this.settings), str2);
            this.doc.appendChild(element2);
            this.stack.add(element2);
            resetInsertionMode();
            Elements parents = element.parents();
            parents.add(0, element);
            Iterator<Element> it = parents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Element next = it.next();
                if (next instanceof FormElement) {
                    this.formElement = (FormElement) next;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        runParser();
        return element != null ? element2.childNodes() : this.doc.childNodes();
    }

    public Element pop() {
        return this.stack.remove(this.stack.size() - 1);
    }

    public void popStackToBefore(String str) {
        for (int size = this.stack.size() - 1; size >= 0 && !this.stack.get(size).normalName().equals(str); size--) {
            this.stack.remove(size);
        }
    }

    public Element popStackToClose(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            this.stack.remove(size);
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public void popStackToClose(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            this.stack.remove(size);
            if (StringUtil.inSorted(this.stack.get(size).normalName(), strArr)) {
                return;
            }
        }
    }

    @Override // org.jsoup.parser.TreeBuilder
    public boolean process(Token token) {
        this.currentToken = token;
        return this.state.process(token, this);
    }

    public boolean process(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.currentToken = token;
        return htmlTreeBuilderState.process(token, this);
    }

    @Override // org.jsoup.parser.TreeBuilder
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    public void push(Element element) {
        this.stack.add(element);
    }

    public void pushActiveFormattingElements(Element element) {
        int size = this.formattingElements.size() - 1;
        int i = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.formattingElements.get(size);
                if (element2 == null) {
                    break;
                }
                if (isSameFormattingElement(element, element2)) {
                    i++;
                }
                if (i == 3) {
                    this.formattingElements.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.formattingElements.add(element);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reconstructFormattingElements() {
        Element lastFormattingElement = lastFormattingElement();
        if (lastFormattingElement == null || onStack(lastFormattingElement)) {
            return;
        }
        boolean z = true;
        int size = this.formattingElements.size() - 1;
        int i = size;
        while (i != 0) {
            i--;
            lastFormattingElement = this.formattingElements.get(i);
            if (lastFormattingElement == null || onStack(lastFormattingElement)) {
                z = false;
                break;
            }
            while (i != 0) {
            }
        }
        while (true) {
            if (!z) {
                i++;
                lastFormattingElement = this.formattingElements.get(i);
            }
            Validate.notNull(lastFormattingElement);
            Element insertStartTag = insertStartTag(lastFormattingElement.normalName());
            insertStartTag.attributes().addAll(lastFormattingElement.attributes());
            this.formattingElements.set(i, insertStartTag);
            if (i == size) {
                return;
            }
            z = false;
        }
    }

    public void removeFromActiveFormattingElements(Element element) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            if (this.formattingElements.get(size) == element) {
                this.formattingElements.remove(size);
                return;
            }
        }
    }

    public boolean removeFromStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                this.stack.remove(size);
                return true;
            }
        }
        return false;
    }

    public Element removeLastFormattingElement() {
        int size = this.formattingElements.size();
        if (size > 0) {
            return this.formattingElements.remove(size - 1);
        }
        return null;
    }

    public void replaceActiveFormattingElement(Element element, Element element2) {
        replaceInQueue(this.formattingElements, element, element2);
    }

    public void replaceOnStack(Element element, Element element2) {
        replaceInQueue(this.stack, element, element2);
    }

    public void resetInsertionMode() {
        HtmlTreeBuilderState htmlTreeBuilderState;
        boolean z = false;
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (size == 0) {
                element = this.contextElement;
                z = true;
            }
            String normalName = element.normalName();
            if ("select".equals(normalName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InSelect;
            } else if ("td".equals(normalName) || ("th".equals(normalName) && !z)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InCell;
            } else if ("tr".equals(normalName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InRow;
            } else if ("tbody".equals(normalName) || "thead".equals(normalName) || "tfoot".equals(normalName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InTableBody;
            } else if ("caption".equals(normalName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InCaption;
            } else if ("colgroup".equals(normalName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InColumnGroup;
            } else if ("table".equals(normalName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InTable;
            } else {
                if (!"head".equals(normalName) && !MailTo.BODY.equals(normalName)) {
                    if ("frameset".equals(normalName)) {
                        htmlTreeBuilderState = HtmlTreeBuilderState.InFrameset;
                    } else if ("html".equals(normalName)) {
                        htmlTreeBuilderState = HtmlTreeBuilderState.BeforeHead;
                    } else if (!z) {
                    }
                }
                htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
            }
            transition(htmlTreeBuilderState);
            return;
        }
    }

    public void setFormElement(FormElement formElement) {
        this.formElement = formElement;
    }

    public void setFosterInserts(boolean z) {
        this.fosterInserts = z;
    }

    public void setHeadElement(Element element) {
        this.headElement = element;
    }

    public HtmlTreeBuilderState state() {
        return this.state;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TreeBuilder{currentToken=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.currentToken);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", state=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", currentElement=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(currentElement());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public void transition(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.state = htmlTreeBuilderState;
    }
}
