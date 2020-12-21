package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.ApplicationWindow;

/**
 * 
 * This class creates a button in a File menu.
 * 
 * @author SZabara
 *
 */
public class ExitAction extends Action {
    private ApplicationWindow win;

    public ExitAction(ApplicationWindow aWin) {
        super("Exit", AS_PUSH_BUTTON);
        this.win = aWin;
    }

    /**
     * 
     * When you press this button - shell will be close.
     */
    public void run() {
        this.win.close();
    }
}
