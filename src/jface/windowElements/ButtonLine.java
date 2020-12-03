package jface.windowElements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ButtonLine extends Composite{
    
    private final Button newButton, saveButton,deleteButton, cancelButton;
    
    public ButtonLine(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(4,true));
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
