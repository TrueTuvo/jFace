package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;

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

        String name = app.getMainComposite().getNameTextField().getText();
        int group = Integer.parseInt(app.getMainComposite().getGroupTextField().getText());
        boolean swtDone = app.getMainComposite().getSwtCheckdone().getSelection();
        if (Utils.isValidData(name, group)) {
            Person person = app.getTableViewerAdapter().getCurrentPerson();
            for (Person person2 : ModelProvider.INSTANCE.getPersons()) {
                if (person.equals(person2)) {
                    person2.setName(name);
                    person2.setGroup(group);
                    person2.setSwtDone(swtDone);
                    app.getTableViewerAdapter().getViewer().refresh();

                }
            }
        }
    }
}