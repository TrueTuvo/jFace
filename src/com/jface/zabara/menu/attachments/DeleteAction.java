package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;

import com.jface.zabara.app.UserManagerApp;
import com.jface.zabara.view.DeletePersonDialog;

public class DeleteAction extends Action {
    private UserManagerApp app;

    public DeleteAction(UserManagerApp app) {
        super("Delete", AS_PUSH_BUTTON);
        this.app = app;
    }

    public void run() {
        if (app.getTableViewerAdapter().getCurrentPerson() != null) {
            new DeletePersonDialog(app.getTableViewerAdapter()).open();
        }
    }
}
