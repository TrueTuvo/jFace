package jface.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;



public class About extends Action{  
    public About() {
        super("About", AS_PUSH_BUTTON);
    }
    public void run() {
        Display display = Display.getCurrent();
        Shell shell = new Shell(display);
        Rectangle screenSize = display.getPrimaryMonitor().getBounds();
        shell.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        shell.setLayout(new GridLayout(1, false));
        System.out.println();
        Label label = new Label(shell, SWT.NONE);
        label.setText("additional information");
        shell.pack();
        shell.setLocation((screenSize.width - shell.getBounds().width) / 2,
                (screenSize.height - shell.getBounds().height) / 2);
        shell.open();
        shell.forceActive();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        
        
    }
}
