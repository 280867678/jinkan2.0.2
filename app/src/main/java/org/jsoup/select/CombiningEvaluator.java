package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Element;

/* loaded from: classes5.dex */
public abstract class CombiningEvaluator extends Evaluator {
    public final ArrayList<Evaluator> evaluators;
    public int num;

    /* loaded from: classes5.dex */
    public static final class And extends CombiningEvaluator {
        public And(Collection<Evaluator> collection) {
            super(collection);
        }

        public And(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (int i = 0; i < this.num; i++) {
                if (!this.evaluators.get(i).matches(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return StringUtil.join(this.evaluators, StringUtils.SPACE);
        }
    }

    /* renamed from: org.jsoup.select.CombiningEvaluator$Or */
    /* loaded from: classes5.dex */
    public static final class C3235Or extends CombiningEvaluator {
        public C3235Or() {
        }

        public C3235Or(Collection<Evaluator> collection) {
            if (this.num > 1) {
                this.evaluators.add(new And(collection));
            } else {
                this.evaluators.addAll(collection);
            }
            updateNumEvaluators();
        }

        public C3235Or(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        public void add(Evaluator evaluator) {
            this.evaluators.add(evaluator);
            updateNumEvaluators();
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (int i = 0; i < this.num; i++) {
                if (this.evaluators.get(i).matches(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return StringUtil.join(this.evaluators, ", ");
        }
    }

    public CombiningEvaluator() {
        this.num = 0;
        this.evaluators = new ArrayList<>();
    }

    public CombiningEvaluator(Collection<Evaluator> collection) {
        this();
        this.evaluators.addAll(collection);
        updateNumEvaluators();
    }

    public void replaceRightMostEvaluator(Evaluator evaluator) {
        this.evaluators.set(this.num - 1, evaluator);
    }

    public Evaluator rightMostEvaluator() {
        int i = this.num;
        if (i > 0) {
            return this.evaluators.get(i - 1);
        }
        return null;
    }

    public void updateNumEvaluators() {
        this.num = this.evaluators.size();
    }
}
