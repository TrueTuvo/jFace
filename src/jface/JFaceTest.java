package jface;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import jface.menu.About;
import jface.menu.Exit;
import jface.menu.New;
import jface.menu.Save;
import jface.view.ViewTable;
import jface.windowElements.MainComposite;

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


        fileMenu.add(new Exit(this));
        editMenu.add(new New());
        editMenu.add(new Save());
        helpMenu.add(new About());
        
        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);
        mainMenu.add(helpMenu);
        
        
        

        

        return mainMenu;
    }

    public static void main(String[] args) {
        JFaceTest win = new JFaceTest();
        win.setBlockOnOpen(true);
        win.open();             
        Display.getCurrent().dispose();
    }



    

}
