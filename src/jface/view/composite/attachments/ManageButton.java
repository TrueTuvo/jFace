package jface.view.composite.attachments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * @author SZabara {@summary composite, what will be added for operations over person}
 *
 */
public class ButtonLine extends Composite {

    private final Button newButton, saveButton, deleteButton, resetButton;

    public Button getNewButton() {
        return newButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public ButtonLine(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout());
        newButton = new Button(this, SWT.PUSH);
        newButton.setText("New");

        saveButton = new Button(this, SWT.PUSH);
        saveButton.setText("Save");

        deleteButton = new Button(this, SWT.PUSH);
        deleteButton.setText("Delete");

        resetButton = new Button(this, SWT.PUSH);
        resetButton.setText("Reset");

    }

}
