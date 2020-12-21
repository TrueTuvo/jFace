package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.jface.zabara.app.UserManagerApp;
import com.jface.zabara.app.Utils;
import com.jface.zabara.model.ModelProvider;
import com.jface.zabara.model.Person;

/**
 * 
 * This class creates a button in a Edit menu.
 * 
 * @author SZabara
 *
 */
public class SavePersonAction extends Action {

    private final UserManagerApp app;

    public SavePersonAction(UserManagerApp app) {
        super("Save", AS_PUSH_BUTTON);
        this.app = app;
    }

    /**
     * 
     * When you press this button - data, from the input fields will be write to the selected person in the table.
     * 
     */
    public void run() {

        String name = null;

        int group = 0;

        boolean swtDone = false;

        try {
            name = app.getMainComposite().getNameTextField().getText();
            group = Integer.parseInt(app.getMainComposite().getGroupTextField().getText());
            swtDone = app.getMainComposite().getSwtCheckdone().getSelection();
        } catch (NumberFormatException ignore) {
            MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Incoorect input",
                    "Your input was incorrect. Please, put the correct data");
        }
        if (Utils.isValidData(name, group)) {
            Person selectionPerson = app.getTableViewerAdapter().getCurrentPerson();
            if (app.getTableViewerAdapter().getCurrentPerson() == null) {
                MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Information",
                        "Please, choose a row for saving data");
            } else {
                for (Person availablePerson : ModelProvider.INSTANCE.getPersons()) {
                    if (selectionPerson.equals(availablePerson)) {
                        Utils.updatePersonData(availablePerson, name, group, swtDone);
                        app.getTableViewerAdapter().getViewer().refresh();
                    }
                }
            }
        }
    }
}