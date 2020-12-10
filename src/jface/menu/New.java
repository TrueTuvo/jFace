package jface.menu;

import org.eclipse.jface.action.Action;

import jface.JFaceTest;
import jface.view.NewPersonDialog;

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