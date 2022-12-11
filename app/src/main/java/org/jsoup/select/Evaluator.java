package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.apache.commons.lang3.text.FormattableUtils;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.PseudoTextElement;
import org.jsoup.nodes.XmlDeclaration;

/* loaded from: classes5.dex */
public abstract class Evaluator {

    /* loaded from: classes5.dex */
    public static final class AllElements extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* loaded from: classes5.dex */
    public static final class Attribute extends Evaluator {
        public String key;

        public Attribute(String str) {
            this.key = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key);
        }

        public String toString() {
            return String.format("[%s]", this.key);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class AttributeKeyPair extends Evaluator {
        public String key;
        public String value;

        public AttributeKeyPair(String str, String str2) {
            this(str, str2, true);
        }

        public AttributeKeyPair(String str, String str2, boolean z) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            this.key = Normalizer.normalize(str);
            boolean z2 = (str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""));
            str2 = z2 ? str2.substring(1, str2.length() - 1) : str2;
            this.value = z ? Normalizer.normalize(str2) : Normalizer.normalize(str2, z2);
        }
    }

    /* loaded from: classes5.dex */
    public static final class AttributeStarting extends Evaluator {
        public String keyPrefix;

        public AttributeStarting(String str) {
            Validate.notEmpty(str);
            this.keyPrefix = Normalizer.lowerCase(str);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (org.jsoup.nodes.Attribute attribute : element2.attributes().asList()) {
                if (Normalizer.lowerCase(attribute.getKey()).startsWith(this.keyPrefix)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.keyPrefix);
        }
    }

    /* loaded from: classes5.dex */
    public static final class AttributeWithValue extends AttributeKeyPair {
        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.value.equalsIgnoreCase(element2.attr(this.key).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes5.dex */
    public static final class AttributeWithValueContaining extends AttributeKeyPair {
        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).contains(this.value);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes5.dex */
    public static final class AttributeWithValueEnding extends AttributeKeyPair {
        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2, false);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).endsWith(this.value);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes5.dex */
    public static final class AttributeWithValueMatching extends Evaluator {
        public String key;
        public Pattern pattern;

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.key = Normalizer.normalize(str);
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.pattern.matcher(element2.attr(this.key)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.key, this.pattern.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static final class AttributeWithValueNot extends AttributeKeyPair {
        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return !this.value.equalsIgnoreCase(element2.attr(this.key));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes5.dex */
    public static final class AttributeWithValueStarting extends AttributeKeyPair {
        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2, false);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).startsWith(this.value);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Class extends Evaluator {
        public String className;

        public Class(String str) {
            this.className = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasClass(this.className);
        }

        public String toString() {
            return String.format(".%s", this.className);
        }
    }

    /* loaded from: classes5.dex */
    public static final class ContainsData extends Evaluator {
        public String searchText;

        public ContainsData(String str) {
            this.searchText = Normalizer.lowerCase(str);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.data()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.searchText);
        }
    }

    /* loaded from: classes5.dex */
    public static final class ContainsOwnText extends Evaluator {
        public String searchText;

        public ContainsOwnText(String str) {
            this.searchText = Normalizer.lowerCase(str);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.ownText()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.searchText);
        }
    }

    /* loaded from: classes5.dex */
    public static final class ContainsText extends Evaluator {
        public String searchText;

        public ContainsText(String str) {
            this.searchText = Normalizer.lowerCase(str);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.text()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":contains(%s)", this.searchText);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class CssNthEvaluator extends Evaluator {

        /* renamed from: a */
        public final int f4656a;

        /* renamed from: b */
        public final int f4657b;

        public CssNthEvaluator(int i) {
            this(0, i);
        }

        public CssNthEvaluator(int i, int i2) {
            this.f4656a = i;
            this.f4657b = i2;
        }

        public abstract int calculatePosition(Element element, Element element2);

        public abstract String getPseudoClass();

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element mo5259parent = element2.mo5259parent();
            if (mo5259parent == null || (mo5259parent instanceof Document)) {
                return false;
            }
            int calculatePosition = calculatePosition(element, element2);
            int i = this.f4656a;
            if (i == 0) {
                return calculatePosition == this.f4657b;
            }
            int i2 = this.f4657b;
            return (calculatePosition - i2) * i >= 0 && (calculatePosition - i2) % i == 0;
        }

        public String toString() {
            return this.f4656a == 0 ? String.format(":%s(%d)", getPseudoClass(), Integer.valueOf(this.f4657b)) : this.f4657b == 0 ? String.format(":%s(%dn)", getPseudoClass(), Integer.valueOf(this.f4656a)) : String.format(":%s(%dn%+d)", getPseudoClass(), Integer.valueOf(this.f4656a), Integer.valueOf(this.f4657b));
        }
    }

    /* renamed from: org.jsoup.select.Evaluator$Id */
    /* loaded from: classes5.dex */
    public static final class C3236Id extends Evaluator {

        /* renamed from: id */
        public String f4658id;

        public C3236Id(String str) {
            this.f4658id = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.f4658id.equals(element2.m35id());
        }

        public String toString() {
            return String.format("#%s", this.f4658id);
        }
    }

    /* loaded from: classes5.dex */
    public static final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex() == this.index;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class IndexEvaluator extends Evaluator {
        public int index;

        public IndexEvaluator(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes5.dex */
    public static final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex() > this.index;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes5.dex */
    public static final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element != element2 && element2.elementSiblingIndex() < this.index;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsEmpty extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (Node node : element2.childNodes()) {
                if (!(node instanceof Comment) && !(node instanceof XmlDeclaration) && !(node instanceof DocumentType)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsFirstChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element mo5259parent = element2.mo5259parent();
            return mo5259parent != null && !(mo5259parent instanceof Document) && element2.elementSiblingIndex() == 0;
        }

        public String toString() {
            return ":first-child";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsFirstOfType extends IsNthOfType {
        public IsFirstOfType() {
            super(0, 1);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":first-of-type";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsLastChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element mo5259parent = element2.mo5259parent();
            return mo5259parent != null && !(mo5259parent instanceof Document) && element2.elementSiblingIndex() == mo5259parent.children().size() - 1;
        }

        public String toString() {
            return ":last-child";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsLastOfType extends IsNthLastOfType {
        public IsLastOfType() {
            super(0, 1);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":last-of-type";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsNthChild extends CssNthEvaluator {
        public IsNthChild(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public int calculatePosition(Element element, Element element2) {
            return element2.elementSiblingIndex() + 1;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String getPseudoClass() {
            return "nth-child";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsNthLastChild extends CssNthEvaluator {
        public IsNthLastChild(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public int calculatePosition(Element element, Element element2) {
            return element2.mo5259parent().children().size() - element2.elementSiblingIndex();
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String getPseudoClass() {
            return "nth-last-child";
        }
    }

    /* loaded from: classes5.dex */
    public static class IsNthLastOfType extends CssNthEvaluator {
        public IsNthLastOfType(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public int calculatePosition(Element element, Element element2) {
            Elements children = element2.mo5259parent().children();
            int i = 0;
            for (int elementSiblingIndex = element2.elementSiblingIndex(); elementSiblingIndex < children.size(); elementSiblingIndex++) {
                if (children.get(elementSiblingIndex).tag().equals(element2.tag())) {
                    i++;
                }
            }
            return i;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String getPseudoClass() {
            return "nth-last-of-type";
        }
    }

    /* loaded from: classes5.dex */
    public static class IsNthOfType extends CssNthEvaluator {
        public IsNthOfType(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public int calculatePosition(Element element, Element element2) {
            Iterator<Element> it = element2.mo5259parent().children().iterator();
            int i = 0;
            while (it.hasNext()) {
                Element next = it.next();
                if (next.tag().equals(element2.tag())) {
                    i++;
                    continue;
                }
                if (next == element2) {
                    break;
                }
            }
            return i;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String getPseudoClass() {
            return "nth-of-type";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsOnlyChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element mo5259parent = element2.mo5259parent();
            return mo5259parent != null && !(mo5259parent instanceof Document) && element2.siblingElements().isEmpty();
        }

        public String toString() {
            return ":only-child";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsOnlyOfType extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element mo5259parent = element2.mo5259parent();
            if (mo5259parent == null || (mo5259parent instanceof Document)) {
                return false;
            }
            Iterator<Element> it = mo5259parent.children().iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().tag().equals(element2.tag())) {
                    i++;
                }
            }
            return i == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    /* loaded from: classes5.dex */
    public static final class IsRoot extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.child(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    /* loaded from: classes5.dex */
    public static final class MatchText extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element2 instanceof PseudoTextElement) {
                return true;
            }
            for (Node node : element2.textNodes()) {
                PseudoTextElement pseudoTextElement = new PseudoTextElement(org.jsoup.parser.Tag.valueOf(element2.tagName()), element2.baseUri(), element2.attributes());
                node.replaceWith(pseudoTextElement);
                pseudoTextElement.appendChild(node);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    /* loaded from: classes5.dex */
    public static final class Matches extends Evaluator {
        public Pattern pattern;

        public Matches(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.text()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.pattern);
        }
    }

    /* loaded from: classes5.dex */
    public static final class MatchesOwn extends Evaluator {
        public Pattern pattern;

        public MatchesOwn(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.ownText()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.pattern);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Tag extends Evaluator {
        public String tagName;

        public Tag(String str) {
            this.tagName = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.normalName().equals(this.tagName);
        }

        public String toString() {
            return String.format(FormattableUtils.SIMPLEST_FORMAT, this.tagName);
        }
    }

    /* loaded from: classes5.dex */
    public static final class TagEndsWith extends Evaluator {
        public String tagName;

        public TagEndsWith(String str) {
            this.tagName = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.normalName().endsWith(this.tagName);
        }

        public String toString() {
            return String.format(FormattableUtils.SIMPLEST_FORMAT, this.tagName);
        }
    }

    public abstract boolean matches(Element element, Element element2);
}
