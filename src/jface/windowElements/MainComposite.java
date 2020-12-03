package jface.windowElements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class MainComposite extends Composite{
    
    


    public MainComposite(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(1, false));
        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        InputFields inputValues = new InputFields(this, SWT.NONE);


        SWTDoneCheckLine buttons = new SWTDoneCheckLine(this, SWT.HORIZONTAL);


        ButtonLine results = new ButtonLine(this, SWT.HORIZONTAL);

        
    }
    
   

}
