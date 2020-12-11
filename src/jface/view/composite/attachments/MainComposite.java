package jface.view.composite.attachments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * @author SZabara
 * 
 *         {@summary Consist of the three composites : InputFields, ButtonLine and SWTButtonCheckLine, provides access
 *         to the important elements}
 * 
 */
public class MainComposite extends Composite {
    private Text name, group;
    private Button swtCheckdone, newButton, saveButton, deleteButton, resetButton;

    public Text getName() {
        return name;
    }

    public Text getGroup() {
        return group;
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

    public MainComposite(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(1, false));
        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        InputFields inputValues = new InputFields(this, SWT.FILL);
        inputValues.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        SWTDoneCheckLine swtDoneCheckLine = new SWTDoneCheckLine(this, SWT.FILL);
        swtDoneCheckLine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        ButtonLine buttonLine = new ButtonLine(this, SWT.FILL);
        buttonLine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        name = inputValues.getNameTextField();
        group = inputValues.getGroupTextField();
        swtCheckdone = swtDoneCheckLine.getSwtDoneButton();
        newButton = buttonLine.getNewButton();
        saveButton = buttonLine.getSaveButton();
        deleteButton = buttonLine.getDeleteButton();
        resetButton = buttonLine.getResetButton();
    }
}
