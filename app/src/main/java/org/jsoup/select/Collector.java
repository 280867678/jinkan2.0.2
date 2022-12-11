package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeFilter;

/* loaded from: classes5.dex */
public class Collector {

    /* loaded from: classes5.dex */
    public static class Accumulator implements NodeVisitor {
        public final Elements elements;
        public final Evaluator eval;
        public final Element root;

        public Accumulator(Element element, Elements elements, Evaluator evaluator) {
            this.root = element;
            this.elements = elements;
            this.eval = evaluator;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (!this.eval.matches(this.root, element)) {
                    return;
                }
                this.elements.add(element);
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
        }
    }

    /* loaded from: classes5.dex */
    public static class FirstFinder implements NodeFilter {
        public final Evaluator eval;
        public Element match = null;
        public final Element root;

        public FirstFinder(Element element, Evaluator evaluator) {
            this.root = element;
            this.eval = evaluator;
        }

        @Override // org.jsoup.select.NodeFilter
        public NodeFilter.FilterResult head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.eval.matches(this.root, element)) {
                    this.match = element;
                    return NodeFilter.FilterResult.STOP;
                }
            }
            return NodeFilter.FilterResult.CONTINUE;
        }

        @Override // org.jsoup.select.NodeFilter
        public NodeFilter.FilterResult tail(Node node, int i) {
            return NodeFilter.FilterResult.CONTINUE;
        }
    }

    public static Elements collect(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        NodeTraversor.traverse(new Accumulator(element, elements, evaluator), element);
        return elements;
    }

    public static Element findFirst(Evaluator evaluator, Element element) {
        FirstFinder firstFinder = new FirstFinder(element, evaluator);
        NodeTraversor.filter(firstFinder, element);
        return firstFinder.match;
    }
}
