package jface.view;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import jface.model.Person;

/**
 * 
 * @author SZabara Every time, when user try to delete person, must confirm action in dialog window
 */
public class DeletePersonDialog extends Dialog {

    private final TableViewerAdapter myTableViewer;

    public DeletePersonDialog(TableViewerAdapter tableViewer) {
        super(Display.getCurrent().getActiveShell());
        this.myTableViewer = tableViewer;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        Label label = new Label(container, SWT.FILL);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        label.setText(
                String.format("Do you really want to delete %s  person?", myTableViewer.getCurrentPerson().getName()));

        return container;
    }

    // overriding this methods allows you to set the
    // title of the custom dialog
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Delete Person");

    }

    @Override
    protected void okPressed() {
        Person person = (Person) myTableViewer.getViewer().getStructuredSelection().getFirstElement();
        myTableViewer.delete(person);
        super.okPressed();
    }

    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }
}
