package jface.windowElements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SWTDoneCheckLine extends Composite{
    private final Label swtDoneLabel;
    private final Button swtDoneButton;

    public SWTDoneCheckLine(Composite parent, int style) {
        super(parent, style);
        swtDoneLabel = new Label(this, SWT.None);
        swtDoneButton = new Button(this, SWT.CHECK);
        
        swtDoneLabel.setText("SWT task done ");
    }

}
