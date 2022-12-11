package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

/* loaded from: classes5.dex */
public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    public Elements(int i) {
        super(i);
    }

    public Elements(Collection<Element> collection) {
        super(collection);
    }

    public Elements(List<Element> list) {
        super(list);
    }

    public Elements(Element... elementArr) {
        super(Arrays.asList(elementArr));
    }

    private <T extends Node> List<T> nodesOfType(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.getClass().isInstance(cls)) {
                arrayList.add(cls.cast(next));
            } else if (Node.class.isAssignableFrom(cls)) {
                for (int i = 0; i < next.childNodeSize(); i++) {
                    Node childNode = next.childNode(i);
                    if (cls.isInstance(childNode)) {
                        arrayList.add(cls.cast(childNode));
                    }
                }
            }
        }
        return arrayList;
    }

    private Elements siblings(String str, boolean z, boolean z2) {
        Elements elements = new Elements();
        Evaluator parse = str != null ? QueryParser.parse(str) : null;
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            do {
                next = z ? next.nextElementSibling() : next.previousElementSibling();
                if (next != null) {
                    if (parse == null || next.m33is(parse)) {
                        elements.add(next);
                        continue;
                    }
                }
            } while (z2);
        }
        return elements;
    }

    public Elements addClass(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().addClass(str);
        }
        return this;
    }

    public Elements after(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().mo5249after(str);
        }
        return this;
    }

    public Elements append(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().append(str);
        }
        return this;
    }

    public String attr(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.hasAttr(str)) {
                return next.attr(str);
            }
        }
        return "";
    }

    public Elements attr(String str, String str2) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().mo5251attr(str, str2);
        }
        return this;
    }

    public Elements before(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().mo5252before(str);
        }
        return this;
    }

    @Override // java.util.ArrayList
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            elements.add(it.next().mo5269clone());
        }
        return elements;
    }

    public List<Comment> comments() {
        return nodesOfType(Comment.class);
    }

    public List<DataNode> dataNodes() {
        return nodesOfType(DataNode.class);
    }

    public List<String> eachAttr(String str) {
        ArrayList arrayList = new ArrayList(size());
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.hasAttr(str)) {
                arrayList.add(next.attr(str));
            }
        }
        return arrayList;
    }

    public List<String> eachText() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.hasText()) {
                arrayList.add(next.text());
            }
        }
        return arrayList;
    }

    public Elements empty() {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().mo5257empty();
        }
        return this;
    }

    /* renamed from: eq */
    public Elements m32eq(int i) {
        return size() > i ? new Elements(get(i)) : new Elements();
    }

    public Elements filter(NodeFilter nodeFilter) {
        NodeTraversor.filter(nodeFilter, this);
        return this;
    }

    public Element first() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public List<FormElement> forms() {
        return nodesOfType(FormElement.class);
    }

    public boolean hasAttr(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            if (it.next().hasAttr(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasClass(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            if (it.next().hasClass(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasText() {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            if (it.next().hasText()) {
                return true;
            }
        }
        return false;
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (borrowBuilder.length() != 0) {
                borrowBuilder.append("\n");
            }
            borrowBuilder.append(next.html());
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public Elements html(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().html(str);
        }
        return this;
    }

    /* renamed from: is */
    public boolean m31is(String str) {
        Evaluator parse = QueryParser.parse(str);
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            if (it.next().m33is(parse)) {
                return true;
            }
        }
        return false;
    }

    public Element last() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public Elements next() {
        return siblings(null, true, false);
    }

    public Elements next(String str) {
        return siblings(str, true, false);
    }

    public Elements nextAll() {
        return siblings(null, true, true);
    }

    public Elements nextAll(String str) {
        return siblings(str, true, true);
    }

    public Elements not(String str) {
        return Selector.filterOut(this, Selector.select(str, this));
    }

    public String outerHtml() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (borrowBuilder.length() != 0) {
                borrowBuilder.append("\n");
            }
            borrowBuilder.append(next.outerHtml());
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public Elements parents() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(it.next().parents());
        }
        return new Elements(linkedHashSet);
    }

    public Elements prepend(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().prepend(str);
        }
        return this;
    }

    public Elements prev() {
        return siblings(null, false, false);
    }

    public Elements prev(String str) {
        return siblings(str, false, false);
    }

    public Elements prevAll() {
        return siblings(null, false, true);
    }

    public Elements prevAll(String str) {
        return siblings(str, false, true);
    }

    public Elements remove() {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        return this;
    }

    public Elements removeAttr(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().mo5260removeAttr(str);
        }
        return this;
    }

    public Elements removeClass(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().removeClass(str);
        }
        return this;
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Elements tagName(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().tagName(str);
        }
        return this;
    }

    public String text() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (borrowBuilder.length() != 0) {
                borrowBuilder.append(StringUtils.SPACE);
            }
            borrowBuilder.append(next.text());
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public List<TextNode> textNodes() {
        return nodesOfType(TextNode.class);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return outerHtml();
    }

    public Elements toggleClass(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().toggleClass(str);
        }
        return this;
    }

    public Elements traverse(NodeVisitor nodeVisitor) {
        NodeTraversor.traverse(nodeVisitor, this);
        return this;
    }

    public Elements unwrap() {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().unwrap();
        }
        return this;
    }

    public String val() {
        return size() > 0 ? first().val() : "";
    }

    public Elements val(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().val(str);
        }
        return this;
    }

    public Elements wrap(String str) {
        Validate.notEmpty(str);
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().mo5264wrap(str);
        }
        return this;
    }
}
