package jface.view;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import jface.model.Person;
import jface.view.composite.attachments.InputFields;
import jface.view.composite.attachments.SWTDoneCheckLine;

/**
 * 
 * @author SZabara {@summary Every time, when user try to add new person, must fill empty fields confirm action in
 *         dialog window}
 */
public class NewPersonDialog extends Dialog {
    private MyTableViewer myTableViewer;
    private InputFields inputFields;
    private SWTDoneCheckLine swtDoneCheckLine;

    public NewPersonDialog(MyTableViewer tableViewer) {
        super(Display.getCurrent().getActiveShell());
        this.myTableViewer = tableViewer;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        inputFields = new InputFields(container, SWT.NONE);
        swtDoneCheckLine = new SWTDoneCheckLine(container, SWT.NONE);

        return container;
    }

    // overriding this methods allows you to set the
    // title of the custom dialog
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Selection dialog");
    }

    @Override
    protected void okPressed() {
        Person person = new Person(inputFields.getNameTextField().getText(),
                Integer.parseInt(inputFields.getGroupTextField().getText()),
                swtDoneCheckLine.getSwtDoneButton().getSelection());
        myTableViewer.add(person);
        super.okPressed();
    }

    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }

}