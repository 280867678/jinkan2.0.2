package org.fourthline.cling.support.renderingcontrol;

import androidx.appcompat.app.WindowDecorActionBar;
import java.beans.PropertyChangeSupport;
import me.tvspark.outline;
import org.fourthline.cling.binding.annotations.UpnpAction;
import org.fourthline.cling.binding.annotations.UpnpInputArgument;
import org.fourthline.cling.binding.annotations.UpnpOutputArgument;
import org.fourthline.cling.binding.annotations.UpnpService;
import org.fourthline.cling.binding.annotations.UpnpServiceId;
import org.fourthline.cling.binding.annotations.UpnpServiceType;
import org.fourthline.cling.binding.annotations.UpnpStateVariable;
import org.fourthline.cling.binding.annotations.UpnpStateVariables;
import org.fourthline.cling.model.types.ErrorCode;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.model.types.UnsignedIntegerTwoBytes;
import org.fourthline.cling.support.lastchange.LastChange;
import org.fourthline.cling.support.lastchange.LastChangeDelegator;
import org.fourthline.cling.support.model.Channel;
import org.fourthline.cling.support.model.PresetName;
import org.fourthline.cling.support.model.VolumeDBRange;
import org.fourthline.cling.support.renderingcontrol.lastchange.ChannelLoudness;
import org.fourthline.cling.support.renderingcontrol.lastchange.ChannelMute;
import org.fourthline.cling.support.renderingcontrol.lastchange.ChannelVolume;
import org.fourthline.cling.support.renderingcontrol.lastchange.ChannelVolumeDB;
import org.fourthline.cling.support.renderingcontrol.lastchange.RenderingControlLastChangeParser;
import org.fourthline.cling.support.renderingcontrol.lastchange.RenderingControlVariable;
import org.mozilla.javascript.tools.idswitch.Main;
import org.simpleframework.xml.transform.ClassTransform;

@UpnpService(serviceId = @UpnpServiceId("RenderingControl"), serviceType = @UpnpServiceType(value = "RenderingControl", version = 1), stringConvertibleTypes = {LastChange.class})
@UpnpStateVariables({@UpnpStateVariable(datatype = Main.STRING_TAG_STR, name = "PresetNameList", sendEvents = false), @UpnpStateVariable(datatype = ClassTransform.BOOLEAN, name = "Mute", sendEvents = false), @UpnpStateVariable(allowedValueMaximum = WindowDecorActionBar.FADE_OUT_DURATION_MS, allowedValueMinimum = 0, datatype = "ui2", name = "Volume", sendEvents = false), @UpnpStateVariable(allowedValueMaximum = 32767, allowedValueMinimum = -36864, datatype = "i2", name = "VolumeDB", sendEvents = false), @UpnpStateVariable(datatype = ClassTransform.BOOLEAN, name = "Loudness", sendEvents = false), @UpnpStateVariable(allowedValuesEnum = Channel.class, name = "A_ARG_TYPE_Channel", sendEvents = false), @UpnpStateVariable(allowedValuesEnum = PresetName.class, name = "A_ARG_TYPE_PresetName", sendEvents = false), @UpnpStateVariable(datatype = "ui4", name = "A_ARG_TYPE_InstanceID", sendEvents = false)})
/* loaded from: classes5.dex */
public abstract class AbstractAudioRenderingControl implements LastChangeDelegator {
    @UpnpStateVariable(eventMaximumRateMilliseconds = 200)
    public final LastChange lastChange;
    public final PropertyChangeSupport propertyChangeSupport;

    public AbstractAudioRenderingControl() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.lastChange = new LastChange(new RenderingControlLastChangeParser());
    }

    public AbstractAudioRenderingControl(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
        this.lastChange = new LastChange(new RenderingControlLastChangeParser());
    }

    public AbstractAudioRenderingControl(PropertyChangeSupport propertyChangeSupport, LastChange lastChange) {
        this.propertyChangeSupport = propertyChangeSupport;
        this.lastChange = lastChange;
    }

    public AbstractAudioRenderingControl(LastChange lastChange) {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.lastChange = lastChange;
    }

    public static UnsignedIntegerFourBytes getDefaultInstanceID() {
        return new UnsignedIntegerFourBytes(0L);
    }

    @Override // org.fourthline.cling.support.lastchange.LastChangeDelegator
    public void appendCurrentState(LastChange lastChange, UnsignedIntegerFourBytes unsignedIntegerFourBytes) throws Exception {
        Channel[] currentChannels;
        for (Channel channel : getCurrentChannels()) {
            String name = channel.name();
            PresetName presetName = PresetName.FactoryDefaults;
            lastChange.setEventedValue(unsignedIntegerFourBytes, new RenderingControlVariable.Mute(new ChannelMute(channel, Boolean.valueOf(getMute(unsignedIntegerFourBytes, name)))), new RenderingControlVariable.Loudness(new ChannelLoudness(channel, Boolean.valueOf(getLoudness(unsignedIntegerFourBytes, name)))), new RenderingControlVariable.Volume(new ChannelVolume(channel, Integer.valueOf(getVolume(unsignedIntegerFourBytes, name).getValue().intValue()))), new RenderingControlVariable.VolumeDB(new ChannelVolumeDB(channel, getVolumeDB(unsignedIntegerFourBytes, name))), new RenderingControlVariable.PresetNameList("FactoryDefaults"));
        }
    }

    public Channel getChannel(String str) throws RenderingControlException {
        try {
            return Channel.valueOf(str);
        } catch (IllegalArgumentException unused) {
            throw new RenderingControlException(ErrorCode.ARGUMENT_VALUE_INVALID, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unsupported audio channel: ", str));
        }
    }

    public abstract Channel[] getCurrentChannels();

    @Override // org.fourthline.cling.support.lastchange.LastChangeDelegator
    public LastChange getLastChange() {
        return this.lastChange;
    }

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentLoudness", stateVariable = "Loudness")})
    public boolean getLoudness(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str) throws RenderingControlException {
        return false;
    }

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentMute", stateVariable = "Mute")})
    public abstract boolean getMute(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str) throws RenderingControlException;

    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentVolume", stateVariable = "Volume")})
    public abstract UnsignedIntegerTwoBytes getVolume(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str) throws RenderingControlException;

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentVolume", stateVariable = "VolumeDB")})
    public Integer getVolumeDB(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str) throws RenderingControlException {
        return 0;
    }

    @UpnpAction(out = {@UpnpOutputArgument(getterName = "getMinValue", name = "MinValue", stateVariable = "VolumeDB"), @UpnpOutputArgument(getterName = "getMaxValue", name = "MaxValue", stateVariable = "VolumeDB")})
    public VolumeDBRange getVolumeDBRange(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str) throws RenderingControlException {
        return new VolumeDBRange(0, 0);
    }

    @UpnpAction(out = {@UpnpOutputArgument(name = "CurrentPresetNameList", stateVariable = "PresetNameList")})
    public String listPresets(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes) throws RenderingControlException {
        PresetName presetName = PresetName.FactoryDefaults;
        return "FactoryDefaults";
    }

    @UpnpAction
    public void selectPreset(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "PresetName") String str) throws RenderingControlException {
    }

    @UpnpAction
    public void setLoudness(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str, @UpnpInputArgument(name = "DesiredLoudness", stateVariable = "Loudness") boolean z) throws RenderingControlException {
    }

    @UpnpAction
    public abstract void setMute(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str, @UpnpInputArgument(name = "DesiredMute", stateVariable = "Mute") boolean z) throws RenderingControlException;

    @UpnpAction
    public abstract void setVolume(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str, @UpnpInputArgument(name = "DesiredVolume", stateVariable = "Volume") UnsignedIntegerTwoBytes unsignedIntegerTwoBytes) throws RenderingControlException;

    @UpnpAction
    public void setVolumeDB(@UpnpInputArgument(name = "InstanceID") UnsignedIntegerFourBytes unsignedIntegerFourBytes, @UpnpInputArgument(name = "Channel") String str, @UpnpInputArgument(name = "DesiredVolume", stateVariable = "VolumeDB") Integer num) throws RenderingControlException {
    }
}
