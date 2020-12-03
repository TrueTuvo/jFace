package jface.windowElements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class MainComposite extends Composite{
    
    


    public MainComposite(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout(SWT.HORIZONTAL));
        new InputFields(this, SWT.NONE);
        new SWTDoneCheckLine(this, SWT.NONE);
        new ButtonLine(this, SWT.NONE);
        
    }
    
   

}
