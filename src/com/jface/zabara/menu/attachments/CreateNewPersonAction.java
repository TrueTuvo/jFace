package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;

import com.jface.zabara.app.UserManagerApp;
import com.jface.zabara.view.CreateNewPersonDialog;

public class CreateNewPersonAction extends Action {
    private UserManagerApp app;

    public CreateNewPersonAction(UserManagerApp app) {
        super("New", AS_PUSH_BUTTON);
        this.app = app;
    }

    public void run() {
        new CreateNewPersonDialog(app.getTableViewerAdapter()).open();
    }
}