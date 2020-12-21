package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;

import com.jface.zabara.app.UserManagerApp;
import com.jface.zabara.view.DeletePersonDialog;

/**
 * 
 * This class creates a button in a Edit menu.
 * 
 * @author SZabara
 *
 */
public class DeleteAction extends Action {
    private UserManagerApp app;

    public DeleteAction(UserManagerApp app) {
        super("Delete", AS_PUSH_BUTTON);
        this.app = app;
    }

    /**
     * 
     * When you press this button - shell with question will be open. If you press "Ok" in question's shell - selected
     * person will be remove.
     */
    public void run() {
        if (app.getTableViewerAdapter().getCurrentPerson() != null) {
            new DeletePersonDialog(app.getTableViewerAdapter()).open();
        }
    }
}
