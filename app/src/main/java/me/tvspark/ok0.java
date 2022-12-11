package me.tvspark;

/* loaded from: classes4.dex */
public final class ok0 extends wf0 {
    public final /* synthetic */ CharSequence Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public ok0(CharSequence charSequence) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = charSequence;
    }

    @Override // me.tvspark.wf0
    public char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        CharSequence charSequence = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
        return charSequence.charAt(i);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww.length();
    }
}
