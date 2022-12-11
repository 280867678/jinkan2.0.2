package org.fourthline.cling.support.messagebox.model;

import org.fourthline.cling.support.messagebox.model.Message;
import org.fourthline.cling.support.messagebox.parser.MessageElement;

/* loaded from: classes5.dex */
public class MessageScheduleReminder extends Message {
    public final String body;
    public final DateTime endTime;
    public final String location;
    public final NumberName owner;
    public final DateTime startTime;
    public final String subject;

    public MessageScheduleReminder(DateTime dateTime, NumberName numberName, String str, DateTime dateTime2, String str2, String str3) {
        this(Message.DisplayType.MAXIMUM, dateTime, numberName, str, dateTime2, str2, str3);
    }

    public MessageScheduleReminder(Message.DisplayType displayType, DateTime dateTime, NumberName numberName, String str, DateTime dateTime2, String str2, String str3) {
        super(Message.Category.SCHEDULE_REMINDER, displayType);
        this.startTime = dateTime;
        this.owner = numberName;
        this.subject = str;
        this.endTime = dateTime2;
        this.location = str2;
        this.body = str3;
    }

    @Override // org.fourthline.cling.support.messagebox.model.ElementAppender
    public void appendMessageElements(MessageElement messageElement) {
        getStartTime().appendMessageElements(messageElement.createChild("StartTime"));
        getOwner().appendMessageElements(messageElement.createChild("Owner"));
        messageElement.createChild("Subject").setContent(getSubject());
        getEndTime().appendMessageElements(messageElement.createChild("EndTime"));
        messageElement.createChild("Location").setContent(getLocation());
        messageElement.createChild("Body").setContent(getBody());
    }

    public String getBody() {
        return this.body;
    }

    public DateTime getEndTime() {
        return this.endTime;
    }

    public String getLocation() {
        return this.location;
    }

    public NumberName getOwner() {
        return this.owner;
    }

    public DateTime getStartTime() {
        return this.startTime;
    }

    public String getSubject() {
        return this.subject;
    }
}
