package jfaceApp;

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
import jface.view.MyTableViewer;
import jface.view.NewPersonDialog;
import jface.view.composite.attachments.InputFields;
import jface.view.composite.attachments.MainComposite;

/**
 * 
 * @author SZabara
 * 
 *         class for start application
 */
public class JFaceTest extends ApplicationWindow {

    private InputFields inputFields;

    public InputFields getInputFields() {
        return inputFields;
    }

    /**
     * user class for control table viewer
     */
    private MyTableViewer myTableViewer;

    /**
     * Composite in within will be show current selection of the table viewer, as well as buttons for control selected
     * Person
     */
    private MainComposite mainComposite;

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

        myTableViewer = new MyTableViewer();

        myTableViewer.createPartControl(form);
        mainComposite = new MainComposite(form, SWT.NONE);
        inputFields = mainComposite.getInputValues();
        myTableViewer.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = event.getStructuredSelection();
                Person selectionPerson = (Person) selection.getFirstElement();
                if (selectionPerson != null && !mainComposite.getDeleteButton().getSelection()) {
                    mainComposite.getName().setText(selectionPerson.getName());
                    mainComposite.getGroup().setText(String.valueOf(selectionPerson.getGroup()));
                    mainComposite.getSwtCheckdone().setSelection(selectionPerson.isSwtDone());
                }
            }
        });

        mainComposite.getDeleteButton().addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                try {
                    switch (e.type) {
                    case SWT.Selection:
                        if (myTableViewer.getViewer().getStructuredSelection() != null) {
                            new DeletePersonDialog(myTableViewer).open();
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
                        new NewPersonDialog(myTableViewer).open();
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
                        String name = mainComposite.getName().getText();
                        int group = Integer.parseInt(mainComposite.getGroup().getText());
                        if (inputFields.isValidData(name, group)) {
                            boolean swtDone = mainComposite.getSwtCheckdone().getSelection();
                            Person person = myTableViewer.getCurrentPerson();
                            for (Person person2 : ModelProvider.INSTANCE.getPersons()) {
                                if (person.equals(person2)) {
                                    person2.setName(name);
                                    person2.setGroup(group);
                                    person2.setSwtDone(swtDone);
                                    myTableViewer.getViewer().refresh();
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
                        Person currentPerson = myTableViewer.getCurrentPerson();
                        mainComposite.getName().setText(currentPerson.getName());
                        mainComposite.getGroup().setText(String.valueOf(currentPerson.getGroup()));
                        mainComposite.getSwtCheckdone().setSelection(currentPerson.isSwtDone());
                        myTableViewer.getViewer().refresh();
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
        editMenu.add(new Save(this));
        editMenu.add(new Delete(this));
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

    public MyTableViewer getMyTableViewer() {
        return myTableViewer;
    }

    public MainComposite getMainComposite() {
        return mainComposite;
    }
}
