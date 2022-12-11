package org.jsoup.nodes;

import com.just.agentweb.JsCallJava;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* loaded from: classes5.dex */
public class FormElement extends Element {
    public final Elements elements = new Elements();

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    /* renamed from: clone */
    public FormElement mo5269clone() {
        return (FormElement) super.mo5269clone();
    }

    public Elements elements() {
        return this.elements;
    }

    public List<Connection.KeyVal> formData() {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = this.elements.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.tag().isFormSubmittable() && !next.hasAttr("disabled")) {
                String attr = next.attr("name");
                if (attr.length() != 0) {
                    String attr2 = next.attr("type");
                    if (!attr2.equalsIgnoreCase("button")) {
                        if ("select".equals(next.normalName())) {
                            boolean z = false;
                            Iterator<Element> it2 = next.select("option[selected]").iterator();
                            while (it2.hasNext()) {
                                arrayList.add(HttpConnection.KeyVal.create(attr, it2.next().val()));
                                z = true;
                            }
                            if (!z && (next = next.select("option").first()) != null) {
                                str = next.val();
                            }
                        } else {
                            if ("checkbox".equalsIgnoreCase(attr2) || "radio".equalsIgnoreCase(attr2)) {
                                if (next.hasAttr("checked")) {
                                    if (next.val().length() <= 0) {
                                        str = "on";
                                    }
                                }
                            }
                            str = next.val();
                        }
                        arrayList.add(HttpConnection.KeyVal.create(attr, str));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // org.jsoup.nodes.Node
    public void removeChild(Node node) {
        super.removeChild(node);
        this.elements.remove(node);
    }

    public Connection submit() {
        String absUrl = hasAttr("action") ? absUrl("action") : baseUri();
        Validate.notEmpty(absUrl, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        return Jsoup.connect(absUrl).data(formData()).method(attr(JsCallJava.KEY_METHOD).toUpperCase().equals("POST") ? Connection.Method.POST : Connection.Method.GET);
    }
}
