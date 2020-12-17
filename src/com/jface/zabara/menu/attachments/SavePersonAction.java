package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.jface.zabara.app.UserManagerApp;
import com.jface.zabara.app.Utils;
import com.jface.zabara.model.ModelProvider;
import com.jface.zabara.model.Person;

public class SavePersonAction extends Action {
    private final UserManagerApp app;

    public SavePersonAction(UserManagerApp app) {
        super("Save", AS_PUSH_BUTTON);
        this.app = app;
    }

    public void run() {

        try {
            String name = app.getMainComposite().getNameTextField().getText();
            int group = Integer.parseInt(app.getMainComposite().getGroupTextField().getText());
            boolean swtDone = app.getMainComposite().getSwtCheckdone().getSelection();

            if (Utils.isValidData(name, group)) {
                Person selectionPerson = app.getTableViewerAdapter().getCurrentPerson();
                for (Person availablePerson : ModelProvider.INSTANCE.getPersons()) {
                    if (selectionPerson.equals(availablePerson)) {
                        Utils.updatePersonData(availablePerson, name, group, swtDone);
                        app.getTableViewerAdapter().getViewer().refresh();
                    }
                }
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException exception) {
            MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Incoorect input",
                    "Your input was incorrect. Please, put the correct data");
        }
    }
}