package jface.view;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import jface.model.CheckBoxLabelProvider;
import jface.model.ModelProvider;
import jface.model.Person;

/**
 * 
 * @author SZabara
 *
 *         This class need for customize and control of table viewer
 */
public class MyTableViewer {

    public static final String ID = "www";

    private TableViewer viewer;

    public void createPartControl(Composite parent) {
        GridLayout layout = new GridLayout(2, false);
        parent.setLayout(layout);
        createViewer(parent);
    }

    private void createViewer(Composite parent) {
        viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        createColumns(parent, viewer);
        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        viewer.setContentProvider(new ArrayContentProvider());
        // Get the content for the viewer, setInput will call getElements in the
        // contentProvider
        viewer.setInput(ModelProvider.INSTANCE.getPersons());
        // make the selection available to other views
        // Set the sorter for the table

        // Layout the viewer

        GridData gridData = new GridData();
        gridData.verticalAlignment = GridData.FILL;
        gridData.horizontalSpan = 2;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.horizontalAlignment = GridData.FILL;
        viewer.getControl().setLayoutData(gridData);
    }

    public TableViewer getViewer() {
        return viewer;
    }

    // This will create the columns for the table
    private void createColumns(final Composite parent, final TableViewer viewer) {
        String[] titles = { "Name", "Group", "swtDone" };
        int[] bounds = { 100, 100, 100 };

        // First column is for the name
        TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                Person p = (Person) element;
                return p.getName();
            }
        });
        // Second column is for the group
        col = createTableViewerColumn(titles[1], bounds[1], 1);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                Person p = (Person) element;
                return String.valueOf(p.getGroup());
            }
        });
        // Third column is for the swtDone
        col = createTableViewerColumn(titles[2], bounds[2], 2);
        col.setLabelProvider(new CheckBoxLabelProvider(viewer) {
            @Override
            protected boolean isChecked(Object element) {
                return ((Person) element).isSwtDone();
            }
        });
    }

    private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
        final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
        final TableColumn column = viewerColumn.getColumn();
        column.setText(title);
        column.setWidth(bound);
        column.setResizable(true);
        column.setMoveable(true);
        return viewerColumn;

    }

    /**
     * Passing the focus request to the viewer's control.
     */
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    public void delete(Person person) {
        if (ModelProvider.INSTANCE.getPersons().contains(person)) {
            ModelProvider.INSTANCE.getPersons().remove(person);
            getViewer().refresh();
        }
    }

    public void add(Person person) {

        ModelProvider.INSTANCE.getPersons().add(person);
        getViewer().refresh();

    }

    public Person getCurrentPerson() {
        return (Person) getViewer().getStructuredSelection().getFirstElement();
    }

}