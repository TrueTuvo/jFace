package jfaceApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.eclipse.jface.action.MenuManager;
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

import jface.menu.attachments.About;
import jface.menu.attachments.Delete;
import jface.menu.attachments.Exit;
import jface.menu.attachments.New;
import jface.menu.attachments.Save;
import jface.model.ModelProvider;
import jface.model.Person;
import jface.view.DeletePersonDialog;
import jface.view.TableViewerAdapter;
import jface.view.CreateNewPersonDialog;
import jface.view.composite.attachments.MainComposite;

/**
 * 
 * @author SZabara
 * 
 *         Class for start application
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
                if (selectionPerson != null && !mainComposite.getDeleteButton().getSelection()) {
                    mainComposite.getNameTextField().setText(selectionPerson.getName());
                    mainComposite.getGroupTextField().setText(String.valueOf(selectionPerson.getGroup()));
                    mainComposite.getSwtCheckdone().setSelection(selectionPerson.isSwtDone());
                }
            }
        });

        mainComposite.getDeleteButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                try {
                    switch (e.type) {
                    case SWT.Selection:
                        if (tableViewerAdapter.getViewer().getStructuredSelection() != null) {
                            new DeletePersonDialog(tableViewerAdapter).open();
                            mainComposite.getNameTextField().setText("");
                            mainComposite.getGroupTextField().setText("");
                            mainComposite.getSwtCheckdone().setSelection(false);

                            break;
                        }
                    }
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }
        });

        mainComposite.getNewButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                try {
                    switch (e.type) {
                    case SWT.Selection:
                        new CreateNewPersonDialog(tableViewerAdapter).open();
                        break;
                    }
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }
        });

        mainComposite.getSaveButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                try {
                    switch (e.type) {
                    case SWT.Selection:
                        String name = mainComposite.getNameTextField().getText();
                        int group = Integer.parseInt(mainComposite.getGroupTextField().getText());
                        if (MainComposite.isValidData(name, group)) {
                            boolean swtDone = mainComposite.getSwtCheckdone().getSelection();
                            Person person = tableViewerAdapter.getCurrentPerson();
                            for (Person person2 : ModelProvider.INSTANCE.getPersons()) {
                                if (person.equals(person2)) {
                                    person2.setName(name);
                                    person2.setGroup(group);
                                    person2.setSwtDone(swtDone);
                                    tableViewerAdapter.getViewer().refresh();
                                }
                            }
                            break;
                        }
                    }
                } catch (Exception e2) {

                }
            }
        });

        mainComposite.getResetButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                try {
                    switch (e.type) {
                    case SWT.Selection: {
                        Person currentPerson = tableViewerAdapter.getCurrentPerson();
                        mainComposite.getNameTextField().setText(currentPerson.getName());
                        mainComposite.getGroupTextField().setText(String.valueOf(currentPerson.getGroup()));
                        mainComposite.getSwtCheckdone().setSelection(currentPerson.isSwtDone());
                        tableViewerAdapter.getViewer().refresh();
                    }
                        break;
                    }
                } catch (Exception e2) {
                    // TODO: handle exception
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
        editMenu.add(new New(this));
        editMenu.add(new Save(this, mainComposite));
        editMenu.add(new Delete(this));
        helpMenu.add(new About());

        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);
        mainMenu.add(helpMenu);

        return mainMenu;
    }

    @Override
    public boolean close() {
        try {
            FileWriter tfw = new FileWriter(new File("database.txt").getAbsoluteFile());
            BufferedWriter tbw = new BufferedWriter(tfw);
            for (Person person : ModelProvider.INSTANCE.getPersons()) {
                tbw.write(person.getName() + "," + person.getGroup() + "," + person.isSwtDone());
                tbw.newLine();
                tbw.flush();
            }
            
            tbw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return super.close();
    }

    public TableViewerAdapter getMyTableViewer() {
        return tableViewerAdapter;
    }

    public MainComposite getMainComposite() {
        return mainComposite;
    }

    public static void main(String[] args) {
        UserManagerApp win = new UserManagerApp();
        win.setBlockOnOpen(true);
        win.open();
        Display.getCurrent().dispose();
    }
}
