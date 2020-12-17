package jface.view.composite.attachments;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * 
 * @author SZabara
 * 
 *         {@summary part of MainComposite. Responsible for show  SWTDone flag. }
 *
 */
public class SWTDoneCheckLine extends Composite {

    private final Button swtDoneButton;

    public SWTDoneCheckLine(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout(SWT.HORIZONTAL));
        Label swtDoneLabel = new Label(this, SWT.FILL);
        swtDoneButton = new Button(this, SWT.CHECK | SWT.RIGHT);
        swtDoneLabel.setText("SWT task Done");
        swtDoneButton.setOrientation(SWT.RIGHT_TO_LEFT);
    }
    
    public Button getSwtDoneButton() {
        return swtDoneButton;
    }
}