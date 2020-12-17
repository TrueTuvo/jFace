package com.jface.zabara.view.composite.attachments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * Consist of the three composites : InputFields, ButtonLine and SWTButtonCheckLine, provides access
 *         to the important elements
 * @author SZabara
 * 
 * 
 */
public class MainComposite extends Composite {
    private final Text nameTextField, groupTextField;
    private final Button swtCheckdone, newButton, saveButton, deleteButton, resetButton;

    public MainComposite(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(1, false));
        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        InputFields inputValues = new InputFields(this, SWT.FILL);
        inputValues.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        SWTDoneCheckLine swtDoneCheckLine = new SWTDoneCheckLine(this, SWT.FILL);
        swtDoneCheckLine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        ManageButtons buttonLine = new ManageButtons(this, SWT.FILL);
        buttonLine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        nameTextField = inputValues.getNameTextField();
        groupTextField = inputValues.getGroupTextField();
        swtCheckdone = swtDoneCheckLine.getSwtDoneButton();
        newButton = buttonLine.getNewPersonButton();
        saveButton = buttonLine.getSavePersonButton();
        deleteButton = buttonLine.getDeletePersonButton();
        resetButton = buttonLine.getResetPersonButton();
    }
    
    public Text getNameTextField() {
        return nameTextField;
    }

    public Text getGroupTextField() {
        return groupTextField;
    }

    public Button getSwtCheckdone() {
        return swtCheckdone;
    }

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
}
