package jface.menu.attachments;

import org.eclipse.jface.action.Action;

import jface.view.CreateNewPersonDialog;
import jfaceApp.UserManagerApp;

public class New extends Action {
    private UserManagerApp app;

    public New(UserManagerApp app) {
        super("New", AS_PUSH_BUTTON);
        this.app = app;
    }

    public void run() {
        new CreateNewPersonDialog(app.getMyTableViewer()).open();
    }
}