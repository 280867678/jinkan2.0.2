package org.seamless.swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class AbstractController<V extends Container> implements Controller<V> {
    public static Logger log = Logger.getLogger(AbstractController.class.getName());
    public Map<String, DefaultAction> actions;
    public Map<Class, List<EventListener>> eventListeners;
    public Controller parentController;
    public List<Controller> subControllers;
    public V view;

    public AbstractController() {
        this.subControllers = new ArrayList();
        this.actions = new HashMap();
        this.eventListeners = new HashMap();
    }

    public AbstractController(V v) {
        this.subControllers = new ArrayList();
        this.actions = new HashMap();
        this.eventListeners = new HashMap();
        this.view = v;
    }

    public AbstractController(V v, Controller controller) {
        this.subControllers = new ArrayList();
        this.actions = new HashMap();
        this.eventListeners = new HashMap();
        this.view = v;
        if (controller != null) {
            this.parentController = controller;
            controller.getSubControllers().add(this);
        }
    }

    public AbstractController(Controller controller) {
        this(null, controller);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        try {
            String actionCommand = ((AbstractButton) actionEvent.getSource()).getActionCommand();
            DefaultAction defaultAction = this.actions.get(actionCommand);
            if (defaultAction == null) {
                if (getParentController() != null) {
                    log.fine("Passing action on to parent controller");
                    this.parentController.actionPerformed(actionEvent);
                    return;
                }
                throw new RuntimeException("Nobody is responsible for action command: " + actionCommand);
            }
            Logger logger = log;
            logger.fine("Handling command: " + actionCommand + " with action: " + defaultAction.getClass());
            try {
                preActionExecute();
                log.fine("Dispatching to action for execution");
                defaultAction.executeInController(this, actionEvent);
                postActionExecute();
                finalActionExecute();
            } catch (RuntimeException e) {
                failedActionExecute();
                throw e;
            } catch (Exception e2) {
                failedActionExecute();
                throw new RuntimeException(e2);
            }
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("Action source is not an Abstractbutton: " + actionEvent);
        }
    }

    public void deregisterAction(String str) {
        this.actions.remove(str);
    }

    @Override // org.seamless.swing.Controller
    public void dispose() {
        log.fine("Disposing controller");
        Iterator<Controller> it = this.subControllers.iterator();
        while (it.hasNext()) {
            it.next().dispose();
            it.remove();
        }
    }

    @Override // org.seamless.swing.Controller
    public void failedActionExecute() {
    }

    @Override // org.seamless.swing.Controller
    public void finalActionExecute() {
    }

    @Override // org.seamless.swing.Controller
    public void fireEvent(Event event) {
        fireEvent(event, false);
    }

    @Override // org.seamless.swing.Controller
    public void fireEvent(Event event, boolean z) {
        if (!event.alreadyFired(this)) {
            log.finest("Event has not been fired already");
            if (this.eventListeners.get(event.getClass()) != null) {
                Logger logger = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Have listeners for this type of event: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.eventListeners.get(event.getClass()));
                logger.finest(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                for (EventListener eventListener : this.eventListeners.get(event.getClass())) {
                    Logger logger2 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Processing event: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(event.getClass().getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" with listener: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(eventListener.getClass().getName());
                    logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    eventListener.handleEvent(event);
                }
            }
            event.addFiredInController(this);
            Logger logger3 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Passing event: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(event.getClass().getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" DOWN in the controller hierarchy");
            logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            for (Controller controller : this.subControllers) {
                controller.fireEvent(event, z);
            }
        } else {
            log.finest("Event already fired here, ignoring...");
        }
        if (getParentController() == null || event.alreadyFired(getParentController()) || !z) {
            log.finest("Event does not propagate up the tree from here");
            return;
        }
        Logger logger4 = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Passing event: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(event.getClass().getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(" UP in the controller hierarchy");
        logger4.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        getParentController().fireEvent(event, z);
    }

    @Override // org.seamless.swing.Controller
    public void fireEventGlobal(Event event) {
        fireEvent(event, true);
    }

    @Override // org.seamless.swing.Controller
    public Controller getParentController() {
        return this.parentController;
    }

    @Override // org.seamless.swing.Controller
    public List<Controller> getSubControllers() {
        return this.subControllers;
    }

    @Override // org.seamless.swing.Controller
    public V getView() {
        return this.view;
    }

    @Override // org.seamless.swing.Controller
    public void postActionExecute() {
    }

    @Override // org.seamless.swing.Controller
    public void preActionExecute() {
    }

    @Override // org.seamless.swing.Controller
    public void registerAction(AbstractButton abstractButton, String str, DefaultAction defaultAction) {
        abstractButton.setActionCommand(str);
        registerAction(abstractButton, defaultAction);
    }

    @Override // org.seamless.swing.Controller
    public void registerAction(AbstractButton abstractButton, DefaultAction defaultAction) {
        abstractButton.removeActionListener(this);
        abstractButton.addActionListener(this);
        this.actions.put(abstractButton.getActionCommand(), defaultAction);
    }

    @Override // org.seamless.swing.Controller
    public void registerEventListener(Class cls, EventListener eventListener) {
        Logger logger = log;
        logger.fine("Registering listener: " + eventListener + " for event type: " + cls.getName());
        List<EventListener> list = this.eventListeners.get(cls);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(eventListener);
        this.eventListeners.put(cls, list);
    }

    public void windowActivated(WindowEvent windowEvent) {
    }

    public void windowClosed(WindowEvent windowEvent) {
    }

    public void windowClosing(WindowEvent windowEvent) {
        dispose();
        getView().dispose();
    }

    public void windowDeactivated(WindowEvent windowEvent) {
    }

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowIconified(WindowEvent windowEvent) {
    }

    public void windowOpened(WindowEvent windowEvent) {
    }
}
