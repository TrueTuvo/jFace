package jface.menu.attachments;

import org.eclipse.jface.action.Action;

import jface.model.ModelProvider;
import jface.model.Person;
import jface.view.composite.attachments.MainComposite;
import jfaceApp.UserManagerApp;

public class Save extends Action {
    private final UserManagerApp app;
    private final MainComposite mainComposite;

    public Save(UserManagerApp app, MainComposite mainComposite) {
        super("Save", AS_PUSH_BUTTON);
        this.app = app;
        this.mainComposite = mainComposite;
    }

    public void run() {
        try {
            String name = app.getMainComposite().getNameTextField().getText();
            int group = Integer.parseInt(app.getMainComposite().getGroupTextField().getText());
            boolean swtDone = app.getMainComposite().getSwtCheckdone().getSelection();
            if (mainComposite.isValidData(name, group)) {
                Person person = app.getMyTableViewer().getCurrentPerson();
                for (Person person2 : ModelProvider.INSTANCE.getPersons()) {
                    if (person.equals(person2)) {
                        person2.setName(name);
                        person2.setGroup(group);
                        person2.setSwtDone(swtDone);
                        app.getMyTableViewer().getViewer().refresh();

                    }
                }
            }

        } catch (Exception e) {
        }
    }
}