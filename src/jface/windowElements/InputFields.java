package jface.windowElements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class InputFields extends Composite{
    private final Label nameLabel, groupLabel;
    private final Text nameTextField,groupTextField;
    

    public InputFields(Composite parent, int style) {
        super(parent, style);
        
       nameLabel = new Label(this,SWT.NONE);
       groupLabel = new Label(this,SWT.NONE);
       
       nameTextField = new Text(this,SWT.NONE);
       groupTextField = new Text(this,SWT.NONE);

       nameLabel.setText("Name ");
       groupLabel.setText("Group ");
       
        
    }


    public Text getGroupTextField() {
        return groupTextField;
    }


    public Text getNameTextField() {
        return nameTextField;
    }

}
