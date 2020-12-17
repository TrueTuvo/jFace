package com.jface.zabara.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.jface.zabara.menu.attachments.AboutAction;
import com.jface.zabara.menu.attachments.CreateNewPersonAction;
import com.jface.zabara.menu.attachments.DeleteAction;
import com.jface.zabara.menu.attachments.ExitAction;
import com.jface.zabara.menu.attachments.SavePersonAction;
import com.jface.zabara.model.ModelProvider;
import com.jface.zabara.model.Person;
import com.jface.zabara.view.CreateNewPersonDialog;
import com.jface.zabara.view.DeletePersonDialog;
import com.jface.zabara.view.TableViewerAdapter;
import com.jface.zabara.view.composite.attachments.MainComposite;

/**
 * Class for start application
 * 
 * @author SZabara
 */
public class UserManagerApp extends ApplicationWindow {

    /**
     * User's class for control table viewer
     */
    private TableViewerAdapter tableViewerAdapter;

    /**
     * Composite in within will be show current selection of the table viewer, as well as buttons for control selected
     * Person
     */
    private MainComposite mainComposite;

    public UserManagerApp() {
        super(null);
        addMenuBar();
    }
    /**
     * Creates a window, that separates to 2 part, first part includes only TabLeViewer, second part include 3 composites. After layOut, occur adding Listeners.
     */
    public Control createContents(Composite parent) {
        getShell().setText("JFace menu demo");
        getShell().setSize(800, 600);

        SashForm form = new SashForm(parent, SWT.HORIZONTAL);
        GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);

        form.setLayoutData(data);
        form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        form.setLayout(new GridLayout());

        tableViewerAdapter = new TableViewerAdapter();

        tableViewerAdapter.createPartControl(form);
        mainComposite = new MainComposite(form, SWT.NONE);
        tableViewerAdapter.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = event.getStructuredSelection();
                Person selectionPerson = (Person) selection.getFirstElement();
                Utils.putPersonData(mainComposite, selectionPerson);
            }
        });

        mainComposite.getDeleteButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                switch (e.type) {
                case SWT.Selection:
                    if (getTableViewerAdapter().getCurrentPerson() != null) {
                        new DeletePersonDialog(tableViewerAdapter).open();
                        Utils.putEmptyPersonData(mainComposite);
                        break;
                    }
                }
            }
        });

        mainComposite.getNewButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                switch (e.type) {
                case SWT.Selection:
                    new CreateNewPersonDialog(tableViewerAdapter).open();
                    break;
                }
            }
        });

        mainComposite.getSaveButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {

                switch (e.type) {
                case SWT.Selection:

                    String name = mainComposite.getNameTextField().getText();
                    int group = Integer.parseInt(mainComposite.getGroupTextField().getText());
                    boolean swtDone = mainComposite.getSwtCheckdone().getSelection();

                    if (Utils.isValidData(name, group)) {
                        Person selectionPerson = tableViewerAdapter.getCurrentPerson();
                        for (Person availablePerson : ModelProvider.INSTANCE.getPersons()) {
                            if (selectionPerson.equals(availablePerson)) {
                                Utils.updatePersonData(availablePerson, name, group, swtDone);
                                tableViewerAdapter.getViewer().refresh();
                            }
                        }
                        break;
                    } else {
                        MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Incoorect input",
                                "Your input was incorrect. Please, put the correct data");
                    }
                }
            }
        });

        mainComposite.getResetButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                switch (e.type) {
                case SWT.Selection: {
                    if (getTableViewerAdapter().getCurrentPerson() != null) {
                        Utils.removeChangesPersonData(mainComposite, tableViewerAdapter.getCurrentPerson());
                        tableViewerAdapter.getViewer().refresh();
                    }
                }
                    break;
                }
            }
        });

        getShell().pack();
        return parent;
    }
    /**
     *  Creates a menu with attachments
     */
    protected MenuManager createMenuManager() {
        MenuManager mainMenu = new MenuManager();
        MenuManager fileMenu = new MenuManager("File");
        MenuManager editMenu = new MenuManager("Edit");
        MenuManager helpMenu = new MenuManager("Help");

        fileMenu.add(new ExitAction(this));
        editMenu.add(new CreateNewPersonAction(this));
        editMenu.add(new SavePersonAction(this));
        editMenu.add(new DeleteAction(this));
        helpMenu.add(new AboutAction());

        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);
        mainMenu.add(helpMenu);

        return mainMenu;
    }
    /**
     *  When window will be closed - all data will be rewrite on the disk
     */
    @Override
    public boolean close() {
        try {
            FileWriter tfw = new FileWriter(new File(Utils.FILE_PATH).getAbsoluteFile());
            BufferedWriter tbw = new BufferedWriter(tfw);
            
            for (Person person : ModelProvider.INSTANCE.getPersons()) {
                tbw.write(person.getName() + "," + person.getGroup() + "," + person.isSwtDone());
                tbw.newLine();
                tbw.flush();
            }

            tbw.close();
        } catch (IOException ex) {
            System.err.println("Some problem with writing file. Changes was not saved.");
        }
        return super.close();
    }
    /**
     * 
     * @return  tableviewer
     */
    public TableViewerAdapter getTableViewerAdapter() {
        return tableViewerAdapter;
    }
    /**
     * 
     * @return mainComposite
     */
    public MainComposite getMainComposite() {
        return mainComposite;
    }
    /**
     * starts this app
     *
     */
    public static void main(String[] args) {
        UserManagerApp win = new UserManagerApp();
        win.setBlockOnOpen(true);
        win.open();
        Display.getCurrent().dispose();
    }
}
