package jface.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.ApplicationWindow;

public class Exit extends Action{
    private ApplicationWindow win;
    public Exit(ApplicationWindow aWin) {
        super("Exit", AS_PUSH_BUTTON);
        this.win = aWin;
    }
    public void run() {
        this.win.close();
    }
}
