package jface.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.ApplicationWindow;

import jface.view.MyTableViewer;

public class Delete extends Action{
    private MyTableViewer myTableViewer;
    public Delete(MyTableViewer myTableViewer) {
        super("Delete", AS_PUSH_BUTTON);
        this.myTableViewer = myTableViewer;
    }
    public void run() {
        myTableViewer.delete();
    }
}
