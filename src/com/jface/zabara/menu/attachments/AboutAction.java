package com.jface.zabara.menu.attachments;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class AboutAction extends Action {
    public AboutAction() {
        super("About", AS_PUSH_BUTTON);
    }

    public void run() {
        Display display = Display.getCurrent();
        Shell shell = new Shell(display);
        shell.setText("About");
        Rectangle screenSize = display.getPrimaryMonitor().getBounds();
        shell.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, true));
        shell.setLayout(new FillLayout(SWT.VERTICAL));
        Label label = new Label(shell, SWT.CENTER);
        label.setText("SWT/Jface application for emulation work with users list");
        label = new Label(shell, SWT.CENTER);
        label.setText("Author SZabara");
        label = new Label(shell, SWT.CENTER);
        label.setText("with the support of Pavel Podgorniy");
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
