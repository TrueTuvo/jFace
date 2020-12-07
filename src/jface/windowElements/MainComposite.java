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

        InputFields inputValues = new InputFields(this, SWT.FILL);
        inputValues.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        SWTDoneCheckLine swtDoneCheckLine = new SWTDoneCheckLine(this, SWT.FILL);
        swtDoneCheckLine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


        ButtonLine buttonLine = new ButtonLine(this, SWT.FILL);
        buttonLine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        
    }
    
   

}
