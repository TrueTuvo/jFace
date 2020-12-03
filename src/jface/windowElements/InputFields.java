package jface.windowElements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class InputFields extends Composite{
    private final Label nameLabel, groupLabel;
    private final Text nameTextField,groupTextField;
    

    public InputFields(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(2, true));
        
       nameLabel = new Label(this,SWT.FILL);  
       nameTextField = new Text(this,SWT.FILL);
       groupLabel = new Label(this,SWT.FILL);   
       groupTextField = new Text(this,SWT.FILL);
       nameLabel.setText("Name ");
       groupLabel.setText("Group ");
       
       setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    }


    public Text getGroupTextField() {
        return groupTextField;
    }


    public Text getNameTextField() {
        return nameTextField;
    }

}
