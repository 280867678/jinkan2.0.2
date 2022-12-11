package me.tvspark.data.event;

/* loaded from: classes4.dex */
public class NotifyBlockEvent extends BaseEvent {
    public String blockName;

    public NotifyBlockEvent(String str) {
        this.blockName = "";
        this.blockName = str;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String str) {
        this.blockName = str;
    }
}
