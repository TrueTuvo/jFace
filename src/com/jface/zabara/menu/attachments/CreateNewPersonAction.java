package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;

import com.jface.zabara.app.UserManagerApp;
import com.jface.zabara.view.CreateNewPersonDialog;

/**
 * 
 * This class creates a button in a Edit menu.
 * 
 * @author SZabara
 *
 */
public class CreateNewPersonAction extends Action {

    private UserManagerApp app;

    public CreateNewPersonAction(UserManagerApp app) {
        super("New", AS_PUSH_BUTTON);
        this.app = app;
    }

    /**
     * 
     * When you press this button - shell with input fields will be open.
     */
    public void run() {
        new CreateNewPersonDialog(app.getTableViewerAdapter()).open();
    }
}