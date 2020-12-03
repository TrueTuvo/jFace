package jface;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import jface.menu.Edit;
import jface.menu.File;
import jface.menu.Help;
import jface.view.ViewTable;
import jface.windowElements.ButtonLine;
import jface.windowElements.InputFields;
import jface.windowElements.MainComposite;
import jface.windowElements.SWTDoneCheckLine;

public class JFaceTest extends ApplicationWindow {

    public JFaceTest() {
        super(null);
        addMenuBar(); 
    }

    public Control createContents(Composite parent) {
        getShell().setText("JFace menu demo");
        getShell().setSize(800, 600);
        
        SashForm form = new SashForm(parent,SWT.HORIZONTAL);
        GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);

        form.setLayoutData(data);
        form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        form.setLayout(new GridLayout());
        
        ViewTable viewTable = new ViewTable();
        viewTable.createPartControl(form);

        Composite child2 = new MainComposite(form,SWT.NONE);
        getShell().pack();
        return parent;
    }

    protected MenuManager createMenuManager() {
        MenuManager mainMenu = new MenuManager();
        MenuManager fileMenu = new MenuManager("File");
        MenuManager editMenu = new MenuManager("Edit");
        MenuManager helpMenu = new MenuManager("Help");


        // File popup menu
        fileMenu.add(new File());
        fileMenu.add(new Edit());
        fileMenu.add(new Help());

        // Help popup menu


        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);
        mainMenu.add(helpMenu);
        
        editMenu.add(new Edit());
        
        
        helpMenu.add(new Edit());

        

        return mainMenu;
    }

    public static void main(String[] args) {
        JFaceTest win = new JFaceTest();
        win.setBlockOnOpen(true);
        win.open();             
        Display.getCurrent().dispose();
    }



    

}
