package jface;

import java.util.Iterator;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import jface.menu.About;
import jface.menu.Delete;
import jface.menu.Exit;
import jface.menu.New;
import jface.menu.Save;
import jface.model.Person;
import jface.view.MyTableViewer;
import jface.windowElements.MainComposite;

public class JFaceTest extends ApplicationWindow {

    private MyTableViewer viewer;

    public JFaceTest() {
        super(null);
        addMenuBar();
    }

    public Control createContents(Composite parent) {
        getShell().setText("JFace menu demo");
        getShell().setSize(800, 600);

        SashForm form = new SashForm(parent, SWT.HORIZONTAL);
        GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);

        form.setLayoutData(data);
        form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        form.setLayout(new GridLayout());

        viewer = new MyTableViewer();

        viewer.createPartControl(form);
        MainComposite child2 = new MainComposite(form, SWT.NONE);
        viewer.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = event.getStructuredSelection();
                Person selectionPerson = (Person) selection.getFirstElement();
                if (selectionPerson != null && !child2.getDeleteButton().getSelection()) {
                child2.getName().setText(selectionPerson.getName());
                child2.getGroup().setText(String.valueOf(selectionPerson.getGroup()));

                child2.getSwtCheckdone().setSelection(selectionPerson.isSwtDone());
                }
            }
        });
        child2.getDeleteButton().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ISelection selection = viewer.getViewer().getSelection();
                if (selection instanceof IStructuredSelection) {
                    Iterator iterator = ((IStructuredSelection) selection).iterator();
                    while (iterator.hasNext()) {
                        Object obj = iterator.next();
                        viewer.getViewer().remove(obj);
                        viewer.getViewer().refresh();
                        child2.getName().setText("");
                        child2.getGroup().setText("");
                        child2.getSwtCheckdone().setSelection(false);
                        viewer.getViewer().refresh();
                    }
                }
            }
        });

    

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
        editMenu.add(new Delete(this.viewer));
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
