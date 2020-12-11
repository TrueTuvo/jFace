package jface.menu.attachments;

import org.eclipse.jface.action.Action;

import jface.view.DeletePersonDialog;
import jfaceApp.JFaceTest;

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
