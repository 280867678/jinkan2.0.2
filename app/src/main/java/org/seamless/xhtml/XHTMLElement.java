package org.seamless.xhtml;

import java.util.ArrayList;
import javax.xml.xpath.XPath;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.seamless.xhtml.XHTML;
import org.seamless.xml.DOMElement;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class XHTMLElement extends DOMElement<XHTMLElement, XHTMLElement> {
    public static final String XPATH_PREFIX = "h";

    public XHTMLElement(XPath xPath, Element element) {
        super(xPath, element);
    }

    public XHTMLElement createChild(XHTML.ELEMENT element) {
        return (XHTMLElement) super.createChild(element.name(), XHTML.NAMESPACE_URI);
    }

    @Override // org.seamless.xml.DOMElement
    public DOMElement<XHTMLElement, XHTMLElement>.ArrayBuilder<XHTMLElement> createChildBuilder(DOMElement dOMElement) {
        return new DOMElement<XHTMLElement, XHTMLElement>.ArrayBuilder<XHTMLElement>(dOMElement) { // from class: org.seamless.xhtml.XHTMLElement.2
            @Override // org.seamless.xml.DOMElement.Builder
            /* renamed from: build */
            public XHTMLElement mo5294build(Element element) {
                return new XHTMLElement(XHTMLElement.this.getXpath(), element);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.seamless.xml.DOMElement.ArrayBuilder
            /* renamed from: newChildrenArray */
            public XHTMLElement[] mo5295newChildrenArray(int i) {
                return new XHTMLElement[i];
            }
        };
    }

    @Override // org.seamless.xml.DOMElement
    public DOMElement<XHTMLElement, XHTMLElement>.Builder<XHTMLElement> createParentBuilder(DOMElement dOMElement) {
        return new DOMElement<XHTMLElement, XHTMLElement>.Builder<XHTMLElement>(dOMElement) { // from class: org.seamless.xhtml.XHTMLElement.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.seamless.xml.DOMElement.Builder
            /* renamed from: build */
            public XHTMLElement mo5294build(Element element) {
                return new XHTMLElement(XHTMLElement.this.getXpath(), element);
            }
        };
    }

    public Anchor[] findAllAnchors() {
        return findAllAnchors(null, null);
    }

    public Anchor[] findAllAnchors(String str) {
        return findAllAnchors(str, null);
    }

    public Anchor[] findAllAnchors(String str, String str2) {
        XHTMLElement[] findChildrenWithClass = findChildrenWithClass(XHTML.ELEMENT.a, str2);
        ArrayList arrayList = new ArrayList(findChildrenWithClass.length);
        for (XHTMLElement xHTMLElement : findChildrenWithClass) {
            String attribute = xHTMLElement.getAttribute(XHTML.ATTR.href);
            if (str == null || (attribute != null && attribute.startsWith(str))) {
                arrayList.add(new Anchor(getXpath(), xHTMLElement.getW3CElement()));
            }
        }
        return (Anchor[]) arrayList.toArray(new Anchor[arrayList.size()]);
    }

    public XHTMLElement[] findChildren(XHTML.ELEMENT element) {
        return (XHTMLElement[]) super.findChildren(element.name());
    }

    public XHTMLElement[] findChildrenWithClass(XHTML.ELEMENT element, String str) {
        XHTMLElement[] findChildren;
        ArrayList arrayList = new ArrayList();
        for (XHTMLElement xHTMLElement : findChildren(element)) {
            if (str != null) {
                for (String str2 : xHTMLElement.getClasses()) {
                    if (!str2.matches(str)) {
                    }
                }
            }
            arrayList.add(xHTMLElement);
        }
        return (XHTMLElement[]) arrayList.toArray(this.CHILD_BUILDER.mo5295newChildrenArray(arrayList.size()));
    }

    public String getAttribute(XHTML.ATTR attr) {
        return getAttribute(attr.name());
    }

    public XHTMLElement[] getChildren(XHTML.ELEMENT element) {
        return (XHTMLElement[]) super.getChildren(element.name());
    }

    public String[] getClasses() {
        String attribute = getAttribute("class");
        return attribute == null ? new String[0] : attribute.split(StringUtils.SPACE);
    }

    public XHTML.ELEMENT getConstant() {
        return XHTML.ELEMENT.valueOf(getElementName());
    }

    public XHTMLElement getFirstChild(XHTML.ELEMENT element) {
        return (XHTMLElement) super.getFirstChild(element.name());
    }

    public String getId() {
        return getAttribute(XHTML.ATTR.id);
    }

    public Option getOption(String str) {
        Option[] options;
        for (Option option : getOptions()) {
            if (option.getKey().equals(str)) {
                return option;
            }
        }
        return null;
    }

    public Option[] getOptions() {
        return Option.fromString(getAttribute(XHTML.ATTR.style));
    }

    public String getTitle() {
        return getAttribute(XHTML.ATTR.title);
    }

    @Override // org.seamless.xml.DOMElement
    public String prefix(String str) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("h:", str);
    }

    @Override // org.seamless.xml.DOMElement
    /* renamed from: setAttribute */
    public XHTMLElement mo5292setAttribute(String str, String str2) {
        super.mo5292setAttribute(str, str2);
        return this;
    }

    public XHTMLElement setAttribute(XHTML.ATTR attr, String str) {
        super.mo5292setAttribute(attr.name(), str);
        return this;
    }

    public XHTMLElement setClasses(String str) {
        mo5292setAttribute("class", str);
        return this;
    }

    public XHTMLElement setClasses(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i != strArr.length - 1) {
                sb.append(StringUtils.SPACE);
            }
        }
        mo5292setAttribute("class", sb.toString());
        return this;
    }

    @Override // org.seamless.xml.DOMElement
    /* renamed from: setContent */
    public DOMElement<XHTMLElement, XHTMLElement> setContent2(String str) {
        super.setContent(str);
        return this;
    }

    public XHTMLElement setId(String str) {
        setAttribute(XHTML.ATTR.id, str);
        return this;
    }

    public XHTMLElement setTitle(String str) {
        setAttribute(XHTML.ATTR.title, str);
        return this;
    }
}
