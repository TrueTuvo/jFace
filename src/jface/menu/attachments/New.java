package jface.menu.attachments;

import org.eclipse.jface.action.Action;

import jface.view.NewPersonDialog;
import jfaceApp.JFaceTest;

public class New  extends Action{
    private JFaceTest app;

    public New(JFaceTest app) {
        super("New", AS_PUSH_BUTTON);
        this.app = app;
    }
    public void run() {
        new NewPersonDialog(app.getMyTableViewer()).open();
    }
}