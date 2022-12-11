package com.efs.sdk.base.protocol.file.section;

import me.tvspark.outline;

/* loaded from: classes3.dex */
public class JSONSection extends AbsSection {
    public String body;

    public JSONSection(String str) {
        super("json");
        this.name = str;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public String changeToStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDeclarationLine());
        sb.append("\n");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.body, "\n");
    }

    public void setBody(String str) {
        this.body = str;
    }
}
