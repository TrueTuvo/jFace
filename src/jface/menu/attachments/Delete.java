package jface.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.ApplicationWindow;

import jface.JFaceTest;
import jface.view.DeletePersonDialog;
import jface.view.MyTableViewer;

public class Delete extends Action {
    private JFaceTest app;

    public Delete(JFaceTest app) {
        super("Delete", AS_PUSH_BUTTON);
        this.app = app;
    }

    public void run() {
        if (app.getMyTableViewer().getViewer().getStructuredSelection() != null) {
            new DeletePersonDialog(app.getMyTableViewer()).open();
        }
    }
}
