package jface.view;


import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import jface.model.*;
import vogella.jface.tableviewer.edit.GroupEditingSupport;
import vogella.jface.tableviewer.edit.NameEditingSupport;
import vogella.jface.tableviewer.edit.SwtDoneEditingSupport;

public class MyTableViewer{

    public static final String ID = "www";

    private TableViewer viewer;
    // We use icons

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

        // First column is for the first name
        TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
        col.setLabelProvider(new CellLabelProvider() {
            @Override
            public void update(ViewerCell cell) {
                cell.setText(((Person) cell.getElement()).getName());
            }
        });
        col.setEditingSupport(new NameEditingSupport(viewer));

        // Second column is for the last name
        col = createTableViewerColumn(titles[1], bounds[1], 1);
        col.setLabelProvider(new CellLabelProvider() {
            @Override
            public void update(ViewerCell cell) {
                cell.setText(String.valueOf(((Person) cell.getElement()).getGroup()));
            }
        });
        col.setEditingSupport(new GroupEditingSupport(viewer));


        col = createTableViewerColumn(titles[2], bounds[2], 2);
        col.setLabelProvider(new CheckBoxLabelProvider(viewer) {
            
            @Override
            protected boolean isChecked(Object element) {
                return ((Person) element).isSwtDone();
            }
        });
        col.setEditingSupport(new SwtDoneEditingSupport(viewer));

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
    public void delete() {
        Person person = (Person)viewer.getStructuredSelection().getFirstElement();
        viewer.remove(person);
    }

}