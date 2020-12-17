package com.jface.zabara.view;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.jface.zabara.app.Utils;
import com.jface.zabara.model.Person;
import com.jface.zabara.view.composite.attachments.InputFields;
import com.jface.zabara.view.composite.attachments.SWTDoneCheckLine;

/**
 * 
 * @author SZabara {@summary Every time, when user try to add new person, must fill empty fields confirm action in
 *         dialog window}
 */
public class CreateNewPersonDialog extends Dialog {
    private TableViewerAdapter myTableViewer;
    private InputFields inputFields;
    private SWTDoneCheckLine swtDoneCheckLine;

    public CreateNewPersonDialog(TableViewerAdapter tableViewer) {
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
           try {
               String name = inputFields.getNameTextField().getText();
               int group = Integer.parseInt(inputFields.getGroupTextField().getText());
               boolean swtDone = swtDoneCheckLine.getSwtDoneButton().getSelection();
               if (Utils.isValidData(name, group)) {               
                   Person person = new Person(name, group, swtDone);
                   myTableViewer.add(person);
                   super.okPressed();
                   
               }
               else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Incoorect input", "Your input was empty. Please, put the correct data");
        }
               
    }

    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }
}