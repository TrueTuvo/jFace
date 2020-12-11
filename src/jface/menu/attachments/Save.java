package jface.menu.attachments;

import org.eclipse.jface.action.Action;

import jface.model.ModelProvider;
import jface.model.Person;
import jfaceApp.JFaceTest;

public class Save extends Action {
    private JFaceTest app;

    public Save(JFaceTest app) {
        super("Save", AS_PUSH_BUTTON);
        this.app = app;
    }
    public void run() {
        String name = app.getMainComposite().getName().getText();
        int group = Integer.parseInt(app.getMainComposite().getGroup().getText());
        boolean swtDone = app.getMainComposite().getSwtCheckdone().getSelection();

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
}