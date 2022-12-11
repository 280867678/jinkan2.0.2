package org.jsoup.nodes;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.QueryParser;
import org.jsoup.select.Selector;

/* loaded from: classes5.dex */
public class Element extends Node {
    public Attributes attributes;
    public List<Node> childNodes;
    public WeakReference<List<Element>> shadowChildrenRef;
    public Tag tag;
    public static final List<Node> EMPTY_NODES = Collections.emptyList();
    public static final Pattern classSplit = Pattern.compile("\\s+");
    public static final String baseUriKey = Attributes.internalKey("baseUri");

    /* loaded from: classes5.dex */
    public static final class NodeList extends ChangeNotifyingArrayList<Node> {
        public final Element owner;

        public NodeList(Element element, int i) {
            super(i);
            this.owner = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.nodelistChanged();
        }
    }

    public Element(String str) {
        this(Tag.valueOf(str), "", null);
    }

    public Element(Tag tag, String str) {
        this(tag, str, null);
    }

    public Element(Tag tag, String str, Attributes attributes) {
        Validate.notNull(tag);
        this.childNodes = EMPTY_NODES;
        this.attributes = attributes;
        this.tag = tag;
        if (str != null) {
            setBaseUri(str);
        }
    }

    public static void accumulateParents(Element element, Elements elements) {
        Element mo5259parent = element.mo5259parent();
        if (mo5259parent == null || mo5259parent.tagName().equals("#root")) {
            return;
        }
        elements.add(mo5259parent);
        accumulateParents(mo5259parent, elements);
    }

    public static void appendNormalisedText(StringBuilder sb, TextNode textNode) {
        String wholeText = textNode.getWholeText();
        if (preserveWhitespace(textNode.parentNode) || (textNode instanceof CDataNode)) {
            sb.append(wholeText);
        } else {
            StringUtil.appendNormalisedWhitespace(sb, wholeText, TextNode.lastCharIsWhitespace(sb));
        }
    }

    public static void appendWhitespaceIfBr(Element element, StringBuilder sb) {
        if (!element.tag.getName().equals("br") || TextNode.lastCharIsWhitespace(sb)) {
            return;
        }
        sb.append(StringUtils.SPACE);
    }

    private List<Element> childElementsList() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.shadowChildrenRef;
        if (weakReference == null || (list = weakReference.get()) == null) {
            int size = this.childNodes.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Node node = this.childNodes.get(i);
                if (node instanceof Element) {
                    arrayList.add((Element) node);
                }
            }
            this.shadowChildrenRef = new WeakReference<>(arrayList);
            return arrayList;
        }
        return list;
    }

    public static <E extends Element> int indexInList(Element element, List<E> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == element) {
                return i;
            }
        }
        return 0;
    }

    private boolean isFormatAsBlock(Document.OutputSettings outputSettings) {
        return this.tag.formatAsBlock() || (mo5259parent() != null && mo5259parent().tag().formatAsBlock()) || outputSettings.outline();
    }

    private boolean isInlineable(Document.OutputSettings outputSettings) {
        return tag().isInline() && !tag().isEmpty() && mo5259parent().isBlock() && previousSibling() != null && !outputSettings.outline();
    }

    private Elements nextElementSiblings(boolean z) {
        Elements elements = new Elements();
        if (this.parentNode == null) {
            return elements;
        }
        elements.add(this);
        return z ? elements.nextAll() : elements.prevAll();
    }

    private void ownText(StringBuilder sb) {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                appendNormalisedText(sb, (TextNode) node);
            } else if (node instanceof Element) {
                appendWhitespaceIfBr((Element) node, sb);
            }
        }
    }

    public static boolean preserveWhitespace(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            int i = 0;
            while (!element.tag.preserveWhitespace()) {
                element = element.mo5259parent();
                i++;
                if (i < 6) {
                    if (element == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static String searchUpForAttribute(Element element, String str) {
        while (element != null) {
            if (element.hasAttributes() && element.attributes.hasKey(str)) {
                return element.attributes.get(str);
            }
            element = element.mo5259parent();
        }
        return "";
    }

    public Element addClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        classNames.add(str);
        classNames(classNames);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: after */
    public Element mo5249after(String str) {
        return (Element) super.mo5249after(str);
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: after */
    public Element mo5250after(Node node) {
        return (Element) super.mo5250after(node);
    }

    public Element append(String str) {
        Validate.notNull(str);
        addChildren((Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element appendChild(Node node) {
        Validate.notNull(node);
        reparentChild(node);
        ensureChildNodes();
        this.childNodes.add(node);
        node.setSiblingIndex(this.childNodes.size() - 1);
        return this;
    }

    public Element appendElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        appendChild(element);
        return element;
    }

    public Element appendText(String str) {
        Validate.notNull(str);
        appendChild(new TextNode(str));
        return this;
    }

    public Element appendTo(Element element) {
        Validate.notNull(element);
        element.appendChild(this);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: attr */
    public Element mo5251attr(String str, String str2) {
        super.mo5251attr(str, str2);
        return this;
    }

    public Element attr(String str, boolean z) {
        attributes().put(str, z);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Attributes attributes() {
        if (!hasAttributes()) {
            this.attributes = new Attributes();
        }
        return this.attributes;
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        return searchUpForAttribute(this, baseUriKey);
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: before */
    public Element mo5252before(String str) {
        return (Element) super.mo5252before(str);
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: before */
    public Element mo5253before(Node node) {
        return (Element) super.mo5253before(node);
    }

    public Element child(int i) {
        return childElementsList().get(i);
    }

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return this.childNodes.size();
    }

    public Elements children() {
        return new Elements(childElementsList());
    }

    public int childrenSize() {
        return childElementsList().size();
    }

    public String className() {
        return attr("class").trim();
    }

    public Set<String> classNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(classSplit.split(className())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public Element classNames(Set<String> set) {
        Validate.notNull(set);
        if (set.isEmpty()) {
            attributes().remove("class");
        } else {
            attributes().put("class", StringUtil.join(set, StringUtils.SPACE));
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: clearAttributes */
    public Element mo5254clearAttributes() {
        if (this.attributes != null) {
            super.mo5254clearAttributes();
            this.attributes = null;
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: clone  reason: collision with other method in class */
    public Element mo5269clone() {
        return (Element) super.mo5269clone();
    }

    public Element closest(String str) {
        return closest(QueryParser.parse(str));
    }

    public Element closest(Evaluator evaluator) {
        Validate.notNull(evaluator);
        Element mo5261root = mo5261root();
        Element element = this;
        while (!evaluator.matches(mo5261root, element)) {
            element = element.mo5259parent();
            if (element == null) {
                return null;
            }
        }
        return element;
    }

    public String cssSelector() {
        StringBuilder sb;
        String sb2;
        if (m35id().length() > 0) {
            sb = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("#");
            sb2 = m35id();
        } else {
            StringBuilder sb3 = new StringBuilder(tagName().replace(':', '|'));
            String join = StringUtil.join(classNames(), ".");
            if (join.length() > 0) {
                sb3.append('.');
                sb3.append(join);
            }
            if (mo5259parent() == null || (mo5259parent() instanceof Document)) {
                return sb3.toString();
            }
            sb3.insert(0, " > ");
            if (mo5259parent().select(sb3.toString()).size() > 1) {
                sb3.append(String.format(":nth-child(%d)", Integer.valueOf(elementSiblingIndex() + 1)));
            }
            sb = new StringBuilder();
            sb.append(mo5259parent().cssSelector());
            sb2 = sb3.toString();
        }
        sb.append(sb2);
        return sb.toString();
    }

    public String data() {
        String wholeData;
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                wholeData = ((DataNode) node).getWholeData();
            } else if (node instanceof Comment) {
                wholeData = ((Comment) node).getData();
            } else if (node instanceof Element) {
                wholeData = ((Element) node).data();
            } else if (node instanceof CDataNode) {
                wholeData = ((CDataNode) node).getWholeText();
            }
            borrowBuilder.append(wholeData);
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public List<DataNode> dataNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                arrayList.add((DataNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Map<String, String> dataset() {
        return attributes().dataset();
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: doClone */
    public Element mo5267doClone(Node node) {
        Element element = (Element) super.mo5267doClone(node);
        Attributes attributes = this.attributes;
        element.attributes = attributes != null ? attributes.clone() : null;
        NodeList nodeList = new NodeList(element, this.childNodes.size());
        element.childNodes = nodeList;
        nodeList.addAll(this.childNodes);
        element.setBaseUri(baseUri());
        return element;
    }

    @Override // org.jsoup.nodes.Node
    public void doSetBaseUri(String str) {
        attributes().put(baseUriKey, str);
    }

    public int elementSiblingIndex() {
        if (mo5259parent() == null) {
            return 0;
        }
        return indexInList(this, mo5259parent().childElementsList());
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: empty */
    public Element mo5257empty() {
        this.childNodes.clear();
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        if (this.childNodes == EMPTY_NODES) {
            this.childNodes = new NodeList(this, 4);
        }
        return this.childNodes;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: filter */
    public Element mo5258filter(NodeFilter nodeFilter) {
        return (Element) super.mo5258filter(nodeFilter);
    }

    public Element firstElementSibling() {
        List<Element> childElementsList = mo5259parent().childElementsList();
        if (childElementsList.size() > 1) {
            return childElementsList.get(0);
        }
        return null;
    }

    public Elements getAllElements() {
        return Collector.collect(new Evaluator.AllElements(), this);
    }

    public Element getElementById(String str) {
        Validate.notEmpty(str);
        Elements collect = Collector.collect(new Evaluator.C3236Id(str), this);
        if (collect.size() > 0) {
            return collect.get(0);
        }
        return null;
    }

    public Elements getElementsByAttribute(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Attribute(str.trim()), this);
    }

    public Elements getElementsByAttributeStarting(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.AttributeStarting(str.trim()), this);
    }

    public Elements getElementsByAttributeValue(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValue(str, str2), this);
    }

    public Elements getElementsByAttributeValueContaining(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueContaining(str, str2), this);
    }

    public Elements getElementsByAttributeValueEnding(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueEnding(str, str2), this);
    }

    public Elements getElementsByAttributeValueMatching(String str, String str2) {
        try {
            return getElementsByAttributeValueMatching(str, Pattern.compile(str2));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Pattern syntax error: ", str2), e);
        }
    }

    public Elements getElementsByAttributeValueMatching(String str, Pattern pattern) {
        return Collector.collect(new Evaluator.AttributeWithValueMatching(str, pattern), this);
    }

    public Elements getElementsByAttributeValueNot(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueNot(str, str2), this);
    }

    public Elements getElementsByAttributeValueStarting(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueStarting(str, str2), this);
    }

    public Elements getElementsByClass(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Class(str), this);
    }

    public Elements getElementsByIndexEquals(int i) {
        return Collector.collect(new Evaluator.IndexEquals(i), this);
    }

    public Elements getElementsByIndexGreaterThan(int i) {
        return Collector.collect(new Evaluator.IndexGreaterThan(i), this);
    }

    public Elements getElementsByIndexLessThan(int i) {
        return Collector.collect(new Evaluator.IndexLessThan(i), this);
    }

    public Elements getElementsByTag(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Tag(Normalizer.normalize(str)), this);
    }

    public Elements getElementsContainingOwnText(String str) {
        return Collector.collect(new Evaluator.ContainsOwnText(str), this);
    }

    public Elements getElementsContainingText(String str) {
        return Collector.collect(new Evaluator.ContainsText(str), this);
    }

    public Elements getElementsMatchingOwnText(String str) {
        try {
            return getElementsMatchingOwnText(Pattern.compile(str));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Pattern syntax error: ", str), e);
        }
    }

    public Elements getElementsMatchingOwnText(Pattern pattern) {
        return Collector.collect(new Evaluator.MatchesOwn(pattern), this);
    }

    public Elements getElementsMatchingText(String str) {
        try {
            return getElementsMatchingText(Pattern.compile(str));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Pattern syntax error: ", str), e);
        }
    }

    public Elements getElementsMatchingText(Pattern pattern) {
        return Collector.collect(new Evaluator.Matches(pattern), this);
    }

    @Override // org.jsoup.nodes.Node
    public boolean hasAttributes() {
        return this.attributes != null;
    }

    public boolean hasClass(String str) {
        if (!hasAttributes()) {
            return false;
        }
        String ignoreCase = this.attributes.getIgnoreCase("class");
        int length = ignoreCase.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(ignoreCase);
            }
            boolean z = false;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(ignoreCase.charAt(i2))) {
                    if (!z) {
                        continue;
                    } else if (i2 - i == length2 && ignoreCase.regionMatches(true, i, str, 0, length2)) {
                        return true;
                    } else {
                        z = false;
                    }
                } else if (!z) {
                    i = i2;
                    z = true;
                }
            }
            if (z && length - i == length2) {
                return ignoreCase.regionMatches(true, i, str, 0, length2);
            }
        }
        return false;
    }

    public boolean hasText() {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                if (!((TextNode) node).isBlank()) {
                    return true;
                }
            } else if ((node instanceof Element) && ((Element) node).hasText()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.jsoup.nodes.Node
    public <T extends Appendable> T html(T t) {
        int size = this.childNodes.size();
        for (int i = 0; i < size; i++) {
            this.childNodes.get(i).outerHtml(t);
        }
        return t;
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        html((Element) borrowBuilder);
        String releaseBuilder = StringUtil.releaseBuilder(borrowBuilder);
        return NodeUtils.outputSettings(this).prettyPrint() ? releaseBuilder.trim() : releaseBuilder;
    }

    public Element html(String str) {
        mo5257empty();
        append(str);
        return this;
    }

    /* renamed from: id */
    public String m35id() {
        return hasAttributes() ? this.attributes.getIgnoreCase("id") : "";
    }

    public Element insertChildren(int i, Collection<? extends Node> collection) {
        Validate.notNull(collection, "Children collection to be inserted must not be null.");
        int childNodeSize = childNodeSize();
        if (i < 0) {
            i += childNodeSize + 1;
        }
        Validate.isTrue(i >= 0 && i <= childNodeSize, "Insert position out of bounds.");
        addChildren(i, (Node[]) new ArrayList(collection).toArray(new Node[0]));
        return this;
    }

    public Element insertChildren(int i, Node... nodeArr) {
        Validate.notNull(nodeArr, "Children collection to be inserted must not be null.");
        int childNodeSize = childNodeSize();
        if (i < 0) {
            i += childNodeSize + 1;
        }
        Validate.isTrue(i >= 0 && i <= childNodeSize, "Insert position out of bounds.");
        addChildren(i, nodeArr);
        return this;
    }

    /* renamed from: is */
    public boolean m34is(String str) {
        return m33is(QueryParser.parse(str));
    }

    /* renamed from: is */
    public boolean m33is(Evaluator evaluator) {
        return evaluator.matches(mo5261root(), this);
    }

    public boolean isBlock() {
        return this.tag.isBlock();
    }

    public Element lastElementSibling() {
        List<Element> childElementsList = mo5259parent().childElementsList();
        if (childElementsList.size() > 1) {
            return childElementsList.get(childElementsList.size() - 1);
        }
        return null;
    }

    public Element nextElementSibling() {
        if (this.parentNode == null) {
            return null;
        }
        List<Element> childElementsList = mo5259parent().childElementsList();
        int indexInList = indexInList(this, childElementsList) + 1;
        if (childElementsList.size() <= indexInList) {
            return null;
        }
        return childElementsList.get(indexInList);
    }

    public Elements nextElementSiblings() {
        return nextElementSiblings(true);
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return this.tag.getName();
    }

    @Override // org.jsoup.nodes.Node
    public void nodelistChanged() {
        super.nodelistChanged();
        this.shadowChildrenRef = null;
    }

    public String normalName() {
        return this.tag.normalName();
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint() && isFormatAsBlock(outputSettings) && !isInlineable(outputSettings) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0)) {
            indent(appendable, i, outputSettings);
        }
        appendable.append('<').append(tagName());
        Attributes attributes = this.attributes;
        if (attributes != null) {
            attributes.html(appendable, outputSettings);
        }
        if (!this.childNodes.isEmpty() || !this.tag.isSelfClosing() || (outputSettings.syntax() == Document.OutputSettings.Syntax.html && this.tag.isEmpty())) {
            appendable.append('>');
        } else {
            appendable.append(" />");
        }
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (!this.childNodes.isEmpty() || !this.tag.isSelfClosing()) {
            if (outputSettings.prettyPrint() && !this.childNodes.isEmpty() && (this.tag.formatAsBlock() || (outputSettings.outline() && (this.childNodes.size() > 1 || (this.childNodes.size() == 1 && !(this.childNodes.get(0) instanceof TextNode)))))) {
                indent(appendable, i, outputSettings);
            }
            appendable.append("</").append(tagName()).append('>');
        }
    }

    public String ownText() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        ownText(borrowBuilder);
        return StringUtil.releaseBuilder(borrowBuilder).trim();
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: parent */
    public final Element mo5259parent() {
        return (Element) this.parentNode;
    }

    public Elements parents() {
        Elements elements = new Elements();
        accumulateParents(this, elements);
        return elements;
    }

    public Element prepend(String str) {
        Validate.notNull(str);
        addChildren(0, (Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element prependChild(Node node) {
        Validate.notNull(node);
        addChildren(0, node);
        return this;
    }

    public Element prependElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        prependChild(element);
        return element;
    }

    public Element prependText(String str) {
        Validate.notNull(str);
        prependChild(new TextNode(str));
        return this;
    }

    public Element previousElementSibling() {
        List<Element> childElementsList;
        int indexInList;
        if (this.parentNode != null && (indexInList = indexInList(this, (childElementsList = mo5259parent().childElementsList()))) > 0) {
            return childElementsList.get(indexInList - 1);
        }
        return null;
    }

    public Elements previousElementSiblings() {
        return nextElementSiblings(false);
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: removeAttr */
    public Element mo5260removeAttr(String str) {
        return (Element) super.mo5260removeAttr(str);
    }

    public Element removeClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        classNames.remove(str);
        classNames(classNames);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: root */
    public Element mo5261root() {
        return (Element) super.mo5261root();
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Elements select(Evaluator evaluator) {
        return Selector.select(evaluator, this);
    }

    public Element selectFirst(String str) {
        return Selector.selectFirst(str, this);
    }

    public Element selectFirst(Evaluator evaluator) {
        return Collector.findFirst(evaluator, this);
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: shallowClone */
    public Element mo5262shallowClone() {
        Tag tag = this.tag;
        String baseUri = baseUri();
        Attributes attributes = this.attributes;
        return new Element(tag, baseUri, attributes == null ? null : attributes.clone());
    }

    public Elements siblingElements() {
        if (this.parentNode == null) {
            return new Elements(0);
        }
        List<Element> childElementsList = mo5259parent().childElementsList();
        Elements elements = new Elements(childElementsList.size() - 1);
        for (Element element : childElementsList) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public Tag tag() {
        return this.tag;
    }

    public String tagName() {
        return this.tag.getName();
    }

    public Element tagName(String str) {
        Validate.notEmpty(str, "Tag name must not be empty.");
        this.tag = Tag.valueOf(str, NodeUtils.parser(this).settings());
        return this;
    }

    public String text() {
        final StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element.1
            @Override // org.jsoup.select.NodeVisitor
            public void head(Node node, int i) {
                if (node instanceof TextNode) {
                    Element.appendNormalisedText(borrowBuilder, (TextNode) node);
                } else if (!(node instanceof Element)) {
                } else {
                    Element element = (Element) node;
                    if (borrowBuilder.length() <= 0) {
                        return;
                    }
                    if ((!element.isBlock() && !element.tag.getName().equals("br")) || TextNode.lastCharIsWhitespace(borrowBuilder)) {
                        return;
                    }
                    borrowBuilder.append(TokenParser.f4579SP);
                }
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(Node node, int i) {
                if (!(node instanceof Element) || !((Element) node).isBlock() || !(node.nextSibling() instanceof TextNode) || TextNode.lastCharIsWhitespace(borrowBuilder)) {
                    return;
                }
                borrowBuilder.append(TokenParser.f4579SP);
            }
        }, this);
        return StringUtil.releaseBuilder(borrowBuilder).trim();
    }

    public Element text(String str) {
        Validate.notNull(str);
        mo5257empty();
        appendChild(new TextNode(str));
        return this;
    }

    public List<TextNode> textNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                arrayList.add((TextNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Element toggleClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        if (classNames.contains(str)) {
            classNames.remove(str);
        } else {
            classNames.add(str);
        }
        classNames(classNames);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: traverse */
    public Element mo5263traverse(NodeVisitor nodeVisitor) {
        return (Element) super.mo5263traverse(nodeVisitor);
    }

    public String val() {
        return normalName().equals("textarea") ? text() : attr("value");
    }

    public Element val(String str) {
        if (normalName().equals("textarea")) {
            text(str);
        } else {
            mo5251attr("value", str);
        }
        return this;
    }

    public String wholeText() {
        final StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element.2
            @Override // org.jsoup.select.NodeVisitor
            public void head(Node node, int i) {
                if (node instanceof TextNode) {
                    borrowBuilder.append(((TextNode) node).getWholeText());
                }
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(Node node, int i) {
            }
        }, this);
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: wrap */
    public Element mo5264wrap(String str) {
        return (Element) super.mo5264wrap(str);
    }
}
