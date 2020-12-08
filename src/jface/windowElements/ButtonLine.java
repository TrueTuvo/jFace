package jface.windowElements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ButtonLine extends Composite{
    
    private final Button newButton, saveButton,deleteButton, cancelButton;
    
    public Button getNewButton() {
        return newButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getCancelButton() {
        return cancelButton;
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
        
        cancelButton = new Button(this, SWT.PUSH);
        cancelButton.setText("Cansel");
        
    }
    

}
