package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

/* loaded from: classes5.dex */
public abstract class StructuralEvaluator extends Evaluator {
    public Evaluator evaluator;

    /* loaded from: classes5.dex */
    public static class Has extends StructuralEvaluator {
        public Has(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Iterator<Element> it = element2.getAllElements().iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next != element2 && this.evaluator.matches(element2, next)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", this.evaluator);
        }
    }

    /* loaded from: classes5.dex */
    public static class ImmediateParent extends StructuralEvaluator {
        public ImmediateParent(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element mo5259parent;
            return (element == element2 || (mo5259parent = element2.mo5259parent()) == null || !this.evaluator.matches(element, mo5259parent)) ? false : true;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", this.evaluator);
        }
    }

    /* loaded from: classes5.dex */
    public static class ImmediatePreviousSibling extends StructuralEvaluator {
        public ImmediatePreviousSibling(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element previousElementSibling;
            return (element == element2 || (previousElementSibling = element2.previousElementSibling()) == null || !this.evaluator.matches(element, previousElementSibling)) ? false : true;
        }

        public String toString() {
            return String.format(":prev%s", this.evaluator);
        }
    }

    /* loaded from: classes5.dex */
    public static class Not extends StructuralEvaluator {
        public Not(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return !this.evaluator.matches(element, element2);
        }

        public String toString() {
            return String.format(":not%s", this.evaluator);
        }
    }

    /* loaded from: classes5.dex */
    public static class Parent extends StructuralEvaluator {
        public Parent(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            do {
                element2 = element2.mo5259parent();
                if (this.evaluator.matches(element, element2)) {
                    return true;
                }
            } while (element2 != element);
            return false;
        }

        public String toString() {
            return String.format(":parent%s", this.evaluator);
        }
    }

    /* loaded from: classes5.dex */
    public static class PreviousSibling extends StructuralEvaluator {
        public PreviousSibling(Evaluator evaluator) {
            this.evaluator = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            do {
                element2 = element2.previousElementSibling();
                if (element2 == null) {
                    return false;
                }
            } while (!this.evaluator.matches(element, element2));
            return true;
        }

        public String toString() {
            return String.format(":prev*%s", this.evaluator);
        }
    }

    /* loaded from: classes5.dex */
    public static class Root extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element == element2;
        }
    }
}
