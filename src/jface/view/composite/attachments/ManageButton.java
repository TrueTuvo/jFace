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
public class ManageButton extends Composite {

    private final Button newPersonButton, savePersonButton, deletePersonButton, resetPersonButton;

    public Button getNewPersonButton() {
        return newPersonButton;
    }

    public Button getSavePersonButton() {
        return savePersonButton;
    }

    public Button getDeletePersonButton() {
        return deletePersonButton;
    }

    public Button getResetPersonButton() {
        return resetPersonButton;
    }

    public ManageButton(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout());
        newPersonButton = new Button(this, SWT.PUSH);
        newPersonButton.setText("New");

        savePersonButton = new Button(this, SWT.PUSH);
        savePersonButton.setText("Save");

        deletePersonButton = new Button(this, SWT.PUSH);
        deletePersonButton.setText("Delete");

        resetPersonButton = new Button(this, SWT.PUSH);
        resetPersonButton.setText("Reset");

    }
}
