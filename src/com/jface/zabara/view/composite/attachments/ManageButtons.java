package com.jface.zabara.view.composite.attachments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Composite, what will be added for operations over person
 * 
 * @author SZabara
 *
 */
public class ManageButtons extends Composite {

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

    public ManageButtons(Composite parent, int style) {
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
