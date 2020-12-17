package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.ApplicationWindow;

public class ExitAction extends Action {
    private ApplicationWindow win;

    public ExitAction(ApplicationWindow aWin) {
        super("Exit", AS_PUSH_BUTTON);
        this.win = aWin;
    }

    public void run() {
        this.win.close();
    }
}
