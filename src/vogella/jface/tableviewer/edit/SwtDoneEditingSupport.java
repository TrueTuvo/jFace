package vogella.jface.tableviewer.edit;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;

import jface.model.Person;


public class SwtDoneEditingSupport extends EditingSupport {

    private final TableViewer viewer;

    public SwtDoneEditingSupport(TableViewer viewer) {
        super(viewer);
        this.viewer = viewer;
    }

    @Override
    protected CellEditor getCellEditor(Object element) {
        return new CheckboxCellEditor(null, SWT.CHECK | SWT.READ_ONLY);

    }

    @Override
    protected boolean canEdit(Object element) {
        return true;
    }

    @Override
    protected Object getValue(Object element) {
        Person person = (Person) element;
        return person.isSwtDone();

    }

    @Override
    protected void setValue(Object element, Object value) {
        Person pers = (Person) element;
        pers.setSwtDone((Boolean) value);
        viewer.update(element, null);
    }
}